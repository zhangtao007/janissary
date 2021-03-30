package com.lanjiu.im.grpc.server;

import com.google.protobuf.ByteString;
import com.lanjiu.im.grpc.client.loginClient.GuestUserAPI;
import com.lanjiu.im.grpc.client.loginClient.RegistUserAPI;
import com.lanjiu.im.grpc.server.impl.FileTransmissionServiceGrpcImpl;
import com.lanjiu.im.grpc.util.*;
import com.lanjiu.im.storage.client.StorageAPI;
import com.lanjiu.pro.file.*;
import com.lanjiu.pro.login.*;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileServiceOperation {

    private static final Logger logger = LoggerFactory.getLogger(FileServiceOperation.class);

    //群文件存储服务器定时删除文件
    public void groupTransmissionFileDelete(OriginalPictureVideoGroupTransmission originalPictureVideoGroupTransmission, StreamObserver<GroupTransmissionResponse> responseObserver){
        GroupMember groupMember = originalPictureVideoGroupTransmission.getGroupMember();
        Group group = originalPictureVideoGroupTransmission.getGroup();
        FileContent fileContent = originalPictureVideoGroupTransmission.getFileContent();
        GroupTransmissionResponse response = null;
        String fileName = fileContent.getBigFileHead().getServerUrl();
        DeleteFileUtil deleteFileUtil = new DeleteFileUtil();
        boolean bResult = deleteFileUtil.deleteFile(fileName);
        if(bResult){
            response = GroupTransmissionResponse.newBuilder()
                    .setGroupPictureVideoMessage(OriginalPictureVideoGroupTransmission.newBuilder()
                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_DELETE_SUCCESS).build())
                            .setGroupMember(groupMember)
                            .setGroup(group)
                            .build()).build();
        }else{
            response = GroupTransmissionResponse.newBuilder()
                    .setGroupPictureVideoMessage(OriginalPictureVideoGroupTransmission.newBuilder()
                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_DELETE__FAILURE).build())
                            .setGroupMember(groupMember)
                            .setGroup(group)
                            .build()).build();
        }
        responseObserver.onNext(response);
    }

    //好友文件存储服务器定时删除文件
    public void friendsTransmissionFileDelete(OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission, StreamObserver<FriendsTransmissionResponse> responseObserver){
        Friends friends = originalPictureVideoFriendsTransmission.getFriends();
        FileContent fileContent = originalPictureVideoFriendsTransmission.getFileContent();
        FriendsTransmissionResponse response = null;
        String[] fileNames = fileContent.getBigFileHead().getServerUrl().split(",");
        DeleteFileUtil deleteFileUtil = new DeleteFileUtil();
        boolean bResult =false;
        int sum =0;
        for (int i=0;i<fileNames.length;i++){
             bResult = deleteFileUtil.deleteFile(fileNames[i]);
             if(bResult)
                 sum++;

        }

        if(sum == fileNames.length){
            response = FriendsTransmissionResponse.newBuilder()
                    .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_DELETE_SUCCESS).build())
                            .setFriends(friends)
                            .build()).build();
        }else{
            response = FriendsTransmissionResponse.newBuilder()
                    .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_DELETE__FAILURE).build())
                            .setFriends(friends)
                            .build()).build();
        }
        responseObserver.onNext(response);
    }

    //服务发送文件-----好友读取文件下载传输
    public void transmissionFileContentSend(OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission, StreamObserver<FriendsTransmissionResponse> responseObserver) throws IOException {
        Friends friends = originalPictureVideoFriendsTransmission.getFriends();
        FileContent fileContent = originalPictureVideoFriendsTransmission.getFileContent();
        FileJCRC32 jcrc32 = new FileJCRC32();
        String fileName = fileContent.getBigFileHead().getServerUrl();
        String packageKind = fileContent.getPackageKind();
        FriendsTransmissionResponse response = null;
        long endd=0;
        if(ConstantsContent.FILE_DOWNLOAD.equals(packageKind)) {
            long startd = System.currentTimeMillis();
            RandomAccessFile read = new RandomAccessFile(fileName, "r");
            FileChannel readChannel = read.getChannel();
            long length = read.length();
            int count = (int) (length % ConstantsContent.FRAGMENT_LENGTH == 0 ? length / ConstantsContent.FRAGMENT_LENGTH : length / ConstantsContent.FRAGMENT_LENGTH + 1);
            //构建传输结构体
            response = jcrc32.packageCheckSumResponse(
                    OriginalPictureVideoFriendsTransmission.newBuilder()
                            .setFileContent(
                                    FileContent.newBuilder().setBigFileHead(
                                            BigFileHead.newBuilder()
                                                    .setCount(count)
                                                    .setLength(length)
                                                    .setServerUrl(fileName)
                                                    .build())
                                            .setPackageKind(ConstantsContent.FILE_HEAD)
                                            .build())
                            .setFriends(friends)
                            .build());
            readChannel.close();
            read.close();
             endd = System.currentTimeMillis();
//           logger.error("length:"+length);
//           logger.error("count :"+count);
//           logger.error("download  耗时:"+((endd-startd)/1000));
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else if(ConstantsContent.FILE_FRAGMENT.equals(packageKind) || ConstantsContent.FILE_HEAD.equals(packageKind)) {
            long startf = System.currentTimeMillis();
            RandomAccessFile read = new RandomAccessFile(fileName, "r");
            FileChannel readChannel = read.getChannel();
            long length = read.length();
            BigFileFragment fragment = fileContent.getBigFileFragment();
            long position = fragment.getPosition();
            int size = (int) (length - position <= ConstantsContent.FRAGMENT_LENGTH ? length - position : ConstantsContent.FRAGMENT_LENGTH);
            MappedByteBuffer mappedByteBuffer = readChannel.map(FileChannel.MapMode.READ_ONLY, position, size);
            //构建传输结构体
            response = jcrc32.packageCheckSumResponse(
                    OriginalPictureVideoFriendsTransmission.newBuilder().setFileContent(
                            FileContent.newBuilder()
                                    .setBigFileFragment(
                                            BigFileFragment.newBuilder()
                                                    .setData(ByteString.copyFrom(mappedByteBuffer))
                                                    .setLength(size)
                                                    .setPosition(position)
                                                    .build())
                                    .setPackageKind(ConstantsContent.FILE_FRAGMENT)
                                    .build())
                            .setFriends(friends)
                            .build());
            responseObserver.onNext(response);
            readChannel.close();
            long endf= System.currentTimeMillis();
//            logger.error("_size:"+size);
//           logger.error("download fragment 耗时:"+((endf-startf)/1000));
            read.close();
            responseObserver.onCompleted();
        }else if (ConstantsContent.FILE_FOOT.equals(packageKind)){

            long startfoot= System.currentTimeMillis();
//            logger.error("download fragment 总耗时:"+((startfoot-endd)/1000));
            response = jcrc32.packageCheckSumResponse(
                    OriginalPictureVideoFriendsTransmission.newBuilder().setFileContent(
                            FileContent.newBuilder()
                                    .setBigFileFoot(
                                            BigFileFoot.newBuilder()
                                                    .setIsSuccess(true)
                                                    .build())
                                    .setPackageKind(ConstantsContent.FILE_FOOT)
                                    .setBigFileHead(originalPictureVideoFriendsTransmission.getFileContent().getBigFileHead())
                                    .build())
                            .setFriends(friends)
                            .setRegisteredUser(originalPictureVideoFriendsTransmission.getRegisteredUser())
                            .setTourists(originalPictureVideoFriendsTransmission.getTourists())
                            .setUserType(originalPictureVideoFriendsTransmission.getUserType())
                            .setSettingsType(originalPictureVideoFriendsTransmission.getSettingsType())
                            .build());
            responseObserver.onNext(response);
            logger.info(fileContent.getBigFileFoot().getIsSuccess() ? "文件下载成功" : "文件下载失败");
            logger.info("下发文件至好友："+originalPictureVideoFriendsTransmission.getHead().getFromId());
            logger.info("args:"+originalPictureVideoFriendsTransmission.getUserType());
            if(originalPictureVideoFriendsTransmission.getUserType().equalsIgnoreCase(ConstantsContent.ORIGINAL_AVATAR_TRANSMISSION_FRIENDS_REGISTERED_USER)
              || (originalPictureVideoFriendsTransmission.getUserType().equalsIgnoreCase(ConstantsContent.ORIGINAL_AVATAR_TRANSMISSION_FRIENDS_GUEST_USER))) {
                responseObserver.onCompleted();
                 return;
            }
            long endfoot= System.currentTimeMillis();
//            logger.error("download foot 耗时:"+((startfoot-endfoot)/1000));

            responseObserver.onCompleted();
//            StorageAPI storageAPI = new StorageAPI();
//            try {
//                storageAPI.deleteFileInformationWithFriend(response);
//            } catch (Exception e) {
//                logger.error("$$$好友下载文件成功后，删除存储服务数据库记录异常：fromId:"+originalPictureVideoFriendsTransmission.getHead().getFromId()+",info:"+e.getMessage());
//                return;
//            }
        }
    }

    //服务发送文件-----群成员读取文件下载传输
    public void transmissionFileContentGroupSend(OriginalPictureVideoGroupTransmission originalPictureVideoGroupTransmission, StreamObserver<GroupTransmissionResponse> responseObserver) throws IOException {
        GroupMember groupMember = originalPictureVideoGroupTransmission.getGroupMember();
        Group group = originalPictureVideoGroupTransmission.getGroup();
        FileContent fileContent = originalPictureVideoGroupTransmission.getFileContent();
        FileJCRC32 jcrc32 = new FileJCRC32();
        String fileName = fileContent.getBigFileHead().getServerUrl();
        String packageKind = fileContent.getPackageKind();
        GroupTransmissionResponse response = null;
        logger.info("members download:[groupId:]"+group.getGroupId()+",[userId:]"+originalPictureVideoGroupTransmission.getHead().getFromId()+",[fileNmae:]"+fileName );
        if(ConstantsContent.FILE_DOWNLOAD.equals(packageKind)) {
            RandomAccessFile read = new RandomAccessFile(fileName, "r");
            FileChannel readChannel = read.getChannel();
            long length = read.length();
            int count = (int) (length % ConstantsContent.FRAGMENT_LENGTH == 0 ? length / ConstantsContent.FRAGMENT_LENGTH : length / ConstantsContent.FRAGMENT_LENGTH + 1);
            //构建传输结构体
            response = jcrc32.packageCheckSumGroupResponse(
                    OriginalPictureVideoGroupTransmission.newBuilder()
                            .setFileContent(
                                    FileContent.newBuilder().setBigFileHead(
                                            BigFileHead.newBuilder()
                                                    .setCount(count)
                                                    .setLength(length)
                                                    .setServerUrl(fileName)
                                                    .build())
                                            .setPackageKind(ConstantsContent.FILE_HEAD)
                                            .build())
                            .setGroupMember(groupMember)
                            .setGroup(group)
                            .build());
            readChannel.close();
            read.close();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else if(ConstantsContent.FILE_FRAGMENT.equals(packageKind) || ConstantsContent.FILE_HEAD.equals(packageKind)) {
            RandomAccessFile read = new RandomAccessFile(fileName, "r");
            FileChannel readChannel = read.getChannel();
            long length = read.length();
            BigFileFragment fragment = fileContent.getBigFileFragment();
            long position = fragment.getPosition();
            int size = (int) (length - position <= ConstantsContent.FRAGMENT_LENGTH ? length - position : ConstantsContent.FRAGMENT_LENGTH);
            MappedByteBuffer mappedByteBuffer = readChannel.map(FileChannel.MapMode.READ_ONLY, position, size);
            //构建传输结构体
            response = jcrc32.packageCheckSumGroupResponse(
                    OriginalPictureVideoGroupTransmission.newBuilder()
                            .setFileContent(
                                    FileContent.newBuilder()
                                            .setBigFileFragment(
                                                    BigFileFragment.newBuilder()
                                                            .setData(ByteString.copyFrom(mappedByteBuffer))
                                                            .setLength(size)
                                                            .setPosition(position)
                                                            .build())
                                            .setPackageKind(ConstantsContent.FILE_FRAGMENT)
                                            .build())
                            .setGroupMember(groupMember)
                            .setGroup(group)
                            .build());
            readChannel.close();
            read.close();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }else if (ConstantsContent.FILE_FOOT.equals(packageKind)){
            response = jcrc32.packageCheckSumGroupResponse(
                    OriginalPictureVideoGroupTransmission.newBuilder()
                            .setFileContent(
                                    FileContent.newBuilder()
                                            .setBigFileFoot(
                                                    BigFileFoot.newBuilder()
                                                            .setIsSuccess(true)
                                                            .build())
                                            .setPackageKind(ConstantsContent.FILE_FOOT)
                                            .build())
                            .setGroupMember(groupMember)
                            .setGroup(group)
                            .build());
            responseObserver.onNext(response);
            if (!fileContent.getBigFileFoot().getIsSuccess()){
                logger.error("###下发文件至群成员失败 ,fromId:"+originalPictureVideoGroupTransmission.getHead().getFromId()+",[fileName:]"+fileName);
            }
            logger.info("完成下发文件至群成员 ,fromId:"+originalPictureVideoGroupTransmission.getHead().getFromId()+",[fileName:]"+fileName);
            //7日后删除数据库记录，另一套处理机制
            responseObserver.onCompleted();
        }
    }

    //服务保存文件-----群成员上传保存
    public void transmissionFileContentGroupReception(OriginalPictureVideoGroupTransmission originalPictureVideoGroupTransmission, Group group, GroupMember groupMember,  FileContent request, StreamObserver<GroupTransmissionResponse> responseObserver) throws IOException {
        String dataType = request.getPackageKind();
        FileJCRC32 jcrc32 = new FileJCRC32();
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        String fileDir = configFileOperation.getFileProtectUrlWithGroup();
        String fileId = originalPictureVideoGroupTransmission.getHead().getMsgId();
        GroupTransmissionResponse response = null;
        if (ConstantsContent.FILE_HEAD.equals(dataType)) {
            BigFileHead bigFileHead = request.getBigFileHead();
            String clientPath = bigFileHead.getClientUrl();
            String serverPath = bigFileHead.getServerUrl();
            if("".equals(serverPath) || null == serverPath)
            {
//                String time = String.valueOf(java.sql.Timestamp.valueOf(LocalDateTime.now()).getTime());
                int nSuffix = clientPath.lastIndexOf(".");
                String suffix = clientPath.substring(nSuffix,clientPath.length());
                serverPath = fileDir + group.getGroupId() + groupMember.getGroupMemberId() + fileId + suffix;
            }
            logger.info("发送大文件请求" + "]文件大小[" + bigFileHead.getLength() + "b]碎片数量[" + bigFileHead.getCount() + "]");
            FileProperties fileProperties = new FileProperties();
            fileProperties.setFragmentCount(bigFileHead.getCount());
            fileProperties.setFileLength(bigFileHead.getLength());
            fileProperties.setClientFileName(clientPath);
            fileProperties.setServerFileName(serverPath);
            fileProperties.setReadCount(0);
            FileTransmissionServiceGrpcImpl.filePropertyMap.put(fileId,fileProperties);
            response = jcrc32.packageCheckSumGroupResponse(
                    OriginalPictureVideoGroupTransmission.newBuilder()
                            .setFileContent(
                            FileContent.newBuilder().setBigFileHead(
                                    BigFileHead.newBuilder()
                                            .setClientUrl(clientPath)
                                            .setServerUrl(serverPath)
                                            .build())
                                    .setPackageKind(ConstantsContent.FILE_HEAD)
                                    .build())
                            .setGroup(group)
                            .setGroupMember(groupMember)
                            .build());
            responseObserver.onNext(response);
        } else if (ConstantsContent.FILE_FRAGMENT.equals(dataType)) {
            FileProperties properties = FileTransmissionServiceGrpcImpl.filePropertyMap.get(fileId);
            BigFileFragment fragment = request.getBigFileFragment();
            long position = fragment.getPosition();
            long size = fragment.getLength();
            long datesize = fragment.getData().size();
            if(datesize != size){
                logger.error("&&&&&&》》群上传时分片验证大小错误: size:"+size+", dateSize:"+datesize);
                response = jcrc32.packageCheckSumGroupResponse(
                        OriginalPictureVideoGroupTransmission.newBuilder()
                                .setFileContent(
                                        FileContent.newBuilder().setBigFileFragment(
                                                BigFileFragment.newBuilder()
                                                        .setPosition(position-size)
                                                        .build())
                                                .setPackageKind(ConstantsContent.FILE_FRAGMENT)
                                                .build())
                                .setGroup(group)
                                .setGroupMember(groupMember)
                                .build());
                responseObserver.onNext(response);
                return;
            }
            String fileName = properties.getServerFileName();
            int readCount = properties.getReadCount();

            RandomAccessFile write = new RandomAccessFile(fileName, "rw");
            FileChannel writeChannel = write.getChannel();

            write.seek(position);
            writeChannel.write(fragment.getData().asReadOnlyByteBuffer());
            position += size;
            response = jcrc32.packageCheckSumGroupResponse(
                    OriginalPictureVideoGroupTransmission.newBuilder()
                            .setFileContent(
                            FileContent.newBuilder().setBigFileFragment(
                                    BigFileFragment.newBuilder()
                                            .setPosition(position)
                                            .build())
                                    .setPackageKind(ConstantsContent.FILE_FRAGMENT)
                                    .build())
                            .setGroup(group)
                            .setGroupMember(groupMember)
                            .build());
            responseObserver.onNext(response);

            readCount++;
            properties.setReadCount(readCount);
            long writeLength = write.length();
            properties.setWriteLength(writeLength);
            writeChannel.close();
            write.close();
            return;
        }else if(ConstantsContent.FILE_FOOT.equals(dataType)){
            FileProperties properties = FileTransmissionServiceGrpcImpl.filePropertyMap.get(fileId);
            long fileLength = properties.getFileLength();
            long writeLength = properties.getWriteLength();
            if (fileLength == writeLength) {
                String fileName = properties.getServerFileName();
                String clientPath = properties.getClientFileName();
                response = jcrc32.packageCheckSumGroupResponse(
                        OriginalPictureVideoGroupTransmission.newBuilder()
                                .setFileContent(
                                        FileContent.newBuilder()
                                                .setBigFileFoot(BigFileFoot.newBuilder()
                                                        .setIsSuccess(true)
                                                        .build())
                                                .setBigFileHead(BigFileHead.newBuilder()
                                                        .setClientUrl(clientPath)
                                                        .setServerUrl(fileName)
                                                        .build())
                                                .setPackageKind(ConstantsContent.FILE_FOOT)
                                                .build())
                                .setGroup(group)
                                .setGroupMember(groupMember)
                                .setTourists(originalPictureVideoGroupTransmission.getTourists())
                                .setRegisteredUser(originalPictureVideoGroupTransmission.getRegisteredUser())
                                .setSettingsType(originalPictureVideoGroupTransmission.getSettingsType())
                                .setUserType(originalPictureVideoGroupTransmission.getUserType())
                                .build());
                logger.info("群成员上传保存文件成功"+"fromId:"+originalPictureVideoGroupTransmission.getHead().getFromId()+", fileId :"+fileId+" , foot_properties :"+properties.toString());
                //增加数据库记录
                responseObserver.onNext(response);
                StorageAPI storageAPI = new StorageAPI();
                storageAPI.storageFileInformationWithGroup(response);
            }else {
                String fileName = properties.getServerFileName();
                String clientPath = properties.getClientFileName();
                response = jcrc32.packageCheckSumGroupResponse(
                        OriginalPictureVideoGroupTransmission.newBuilder()
                                .setFileContent(
                                        FileContent.newBuilder()
                                                .setBigFileFoot(BigFileFoot.newBuilder()
                                                        .setIsSuccess(false)
                                                        .build())
                                                .setBigFileHead(BigFileHead.newBuilder()
                                                        .setClientUrl(clientPath)
                                                        .setServerUrl(fileName)
                                                        .build())
                                                .setPackageKind(ConstantsContent.FILE_FOOT)
                                                .build())
                                .setGroup(group)
                                .setGroupMember(groupMember)
                                .build());
                logger.info("$$$$$$群成员上传保存文件失败"+"fromId:"+originalPictureVideoGroupTransmission.getHead().getFromId()+", fileId :"+fileId+" , foot_properties :"+properties.toString());
                //增加数据库记录
                responseObserver.onNext(response);
            }
            FileTransmissionServiceGrpcImpl.filePropertyMap.remove(fileId);
        }
    }

    //服务保存文件-好友上传保存
    public void transmissionFileContentReception(OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission, Friends friends, FileContent request, StreamObserver<FriendsTransmissionResponse> responseObserver) throws IOException {
        String dataType = request.getPackageKind();
        FileJCRC32 jcrc32 = new FileJCRC32();
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        String fileDir = configFileOperation.getFileProtectUrl();
        String avatarDir = configFileOperation.getAvatarFileUrl();
        String fileId = originalPictureVideoFriendsTransmission.getHead().getMsgId();
        FriendsTransmissionResponse response = null;

        if (ConstantsContent.FILE_HEAD.equals(dataType)) {
            BigFileHead bigFileHead = request.getBigFileHead();
            String clientPath = bigFileHead.getClientUrl();
            String serverPath = bigFileHead.getServerUrl();
            if("".equals(serverPath) || null == serverPath)
            {
//                String time = String.valueOf(java.sql.Timestamp.valueOf(LocalDateTime.now()).getTime());
                int nSuffix = clientPath.lastIndexOf(".");
                String suffix = clientPath.substring(nSuffix,clientPath.length());
                //判断用户头像保存路径
                if(originalPictureVideoFriendsTransmission.getUserType().equalsIgnoreCase(ConstantsContent.ORIGINAL_AVATAR_TRANSMISSION_FRIENDS_REGISTERED_USER)
                  || (originalPictureVideoFriendsTransmission.getUserType().equalsIgnoreCase(ConstantsContent.ORIGINAL_AVATAR_TRANSMISSION_FRIENDS_GUEST_USER))){
                    serverPath = avatarDir + friends.getFriendsId() + fileId + suffix;

                }else {
                    serverPath = fileDir + friends.getFriendsId() + fileId + suffix;
                }
            }
            logger.info("发送大文件请求" + "]文件大小[" + bigFileHead.getLength() + "b]碎片数量[" + bigFileHead.getCount() + "]");
            FileProperties fileProperties = new FileProperties();
            fileProperties.setFragmentCount(bigFileHead.getCount());
            fileProperties.setFileLength(bigFileHead.getLength());
            fileProperties.setClientFileName(clientPath);
            fileProperties.setServerFileName(serverPath);
            fileProperties.setReadCount(0);
            FileTransmissionServiceGrpcImpl.filePropertyMap.put(fileId,fileProperties);
            response = jcrc32.packageCheckSumResponse(
                    OriginalPictureVideoFriendsTransmission.newBuilder()
                            .setFileContent(
                            FileContent.newBuilder()
                                    .setBigFileHead(
                                    BigFileHead.newBuilder()
                                            .setClientUrl(clientPath)
                                            .setServerUrl(serverPath)
                                            .build())
                                    .setPackageKind(ConstantsContent.FILE_HEAD)
                                    .build())
                            .setFriends(friends)
                            .build());
            responseObserver.onNext(response);
        } else if (ConstantsContent.FILE_FRAGMENT.equals(dataType)) {
            BigFileFragment fragment = request.getBigFileFragment();
            FileProperties fileProperts = FileTransmissionServiceGrpcImpl.filePropertyMap.get(fileId);
            long position = fragment.getPosition();
            long size = fragment.getLength();
            long datesize = fragment.getData().size();
            if(datesize != size){
                logger.error("########分片验证大小错误: size:"+size+", dateSize:"+datesize);
                response = jcrc32.packageCheckSumResponse(
                        OriginalPictureVideoFriendsTransmission.newBuilder()
                                .setFileContent(
                                        FileContent.newBuilder().setBigFileFragment(
                                                BigFileFragment.newBuilder()
                                                        .setPosition(position-size)
                                                        .build())
                                                .setPackageKind(ConstantsContent.FILE_FRAGMENT)
                                                .build())
                                .setFriends(friends)
                                .build());
                responseObserver.onNext(response);
                return;
            }
            String fileName = fileProperts.getServerFileName();
            int readCount = fileProperts.getReadCount();

            RandomAccessFile write = new RandomAccessFile(fileName, "rw");
            FileChannel writeChannel = write.getChannel();

            write.seek(position);
            writeChannel.write(fragment.getData().asReadOnlyByteBuffer());

            position += size;
            response = jcrc32.packageCheckSumResponse(
                    OriginalPictureVideoFriendsTransmission.newBuilder()
                            .setFileContent(
                            FileContent.newBuilder().setBigFileFragment(
                                    BigFileFragment.newBuilder()
                                            .setPosition(position)
                                            .build())
                                    .setPackageKind(ConstantsContent.FILE_FRAGMENT)
                                    .build())
                            .setFriends(friends)
                            .build());
            responseObserver.onNext(response);

            readCount++;
            fileProperts.setReadCount(readCount);
            long writeLength = write.length();
            fileProperts.setWriteLength(writeLength);
            writeChannel.close();
            write.close();
            return;
        }else if (ConstantsContent.FILE_FOOT.equals(dataType)){
            FileProperties fileProperts = FileTransmissionServiceGrpcImpl.filePropertyMap.get(fileId);
            long fileLength = fileProperts.getFileLength();
            long writeLength = fileProperts.getWriteLength();
            if (fileLength == writeLength){
                String fileName = fileProperts.getServerFileName();
                String clientPath = fileProperts.getClientFileName();
                response = jcrc32.packageCheckSumResponse(
                        OriginalPictureVideoFriendsTransmission.newBuilder().setFileContent(
                                FileContent.newBuilder()
                                        .setBigFileFoot(BigFileFoot.newBuilder()
                                                .setIsSuccess(true)
                                                .build())
                                        .setBigFileHead(BigFileHead.newBuilder()
                                                .setClientUrl(clientPath)
                                                .setServerUrl(fileName)
                                                .build())
                                        .setPackageKind(ConstantsContent.FILE_FOOT)
                                        .build())
                                .setRegisteredUser(originalPictureVideoFriendsTransmission.getRegisteredUser())
                                .setTourists(originalPictureVideoFriendsTransmission.getTourists())
                                .setUserType(originalPictureVideoFriendsTransmission.getUserType())
                                .setSettingsType(originalPictureVideoFriendsTransmission.getSettingsType())
                                .setFriends(friends)
                                .build());
                logger.info("上传保存文件成功"+ "fromId:"+originalPictureVideoFriendsTransmission.getHead().getFromId()+", fileId :"+fileId+" , foot_properties :"+fileProperts.toString());
                responseObserver.onNext(response);
                //增加数据库记录
                StorageAPI storageAPI = new StorageAPI();
                try {
                    storageAPI.storageFileInformationWithFriend(response);
                } catch (Exception e) {
                    logger.error("$$$$$$保存文件地址到存储服务数据库失败"+"fromId:"+originalPictureVideoFriendsTransmission.getHead().getFromId()+", fileId :"+fileId+" , foot_properties :"+fileProperts.toString());
                    FileTransmissionServiceGrpcImpl.filePropertyMap.remove(fileId);
                    responseObserver.onNext(response);
                }
                //如果用户上传头像，则调用登录服务器更新个人头像信息；
                if(originalPictureVideoFriendsTransmission.getUserType().equalsIgnoreCase(ConstantsContent.ORIGINAL_AVATAR_TRANSMISSION_FRIENDS_REGISTERED_USER)){
                    RegistUserAPI  registUserAPI = new RegistUserAPI();
                    ResponseUser resp =null;

                    //获取原头像地址
                    RequestUser req = RequestUser.newBuilder().setArgs(ConstType.SEARCH_USER).setUserType(ConstType.REGISTERUSER).setRegisterUser(RegisterUser.newBuilder()
                            .setUserId(originalPictureVideoFriendsTransmission.getRegisteredUser().getUserId())
                            .setUserInfomation(UserInfomation.newBuilder()
                                    .setUserId(originalPictureVideoFriendsTransmission.getRegisteredUser().getUserId())
                                    .build()).build()).build();
                    try {
                        resp = registUserAPI.selectUserInfomation(req);
                    } catch (Exception e) {
                        logger.error("selectUserInfomation",e);
                    }
                    String avatarUrl = resp.getRegisterUserList().get(0).getUserInfomation().getAvatar();
                    //删除旧头像文件
                    if (!avatarUrl.isEmpty() || avatarUrl != null){
                        DeleteFileUtil deleteFileUtil = new DeleteFileUtil();
                        File file = new File(avatarUrl);
                        boolean bResult = deleteFileUtil.forceDelete(file);
                        if(bResult)
                        {
                            logger.info("用户头像更新后，删除旧文件:"+avatarUrl);
                        }
                    }

                     //更新头像地址
                     RequestUser requestUser = RequestUser.newBuilder().setUserType(ConstType.REGISTERUSER).setRegisterUser(RegisterUser.newBuilder()
                             .setUserId(originalPictureVideoFriendsTransmission.getRegisteredUser().getUserId())
                             .setUserInfomation(UserInfomation.newBuilder()
                                     .setUserId(originalPictureVideoFriendsTransmission.getRegisteredUser().getUserId())
                                     .setAvatar(fileName).build()).build()).build();
                     try {
                          registUserAPI.updateUserInfomation(requestUser);
                     } catch (Exception e) {
                         logger.info("$$$更新用户头像地址到登录服务数据库异常："+"fromId:"+originalPictureVideoFriendsTransmission.getHead().getFromId());
                         FileTransmissionServiceGrpcImpl.filePropertyMap.remove(fileId);
                         responseObserver.onNext(response);
                     }



                }else if(originalPictureVideoFriendsTransmission.getUserType().equalsIgnoreCase(ConstantsContent.ORIGINAL_AVATAR_TRANSMISSION_FRIENDS_GUEST_USER)){
                    GuestUserAPI guestUserAPI = new GuestUserAPI();
                    RequestUser requestUser = RequestUser.newBuilder().setUserType(ConstType.GUESTUSER).setGuestUser(GuestUser.newBuilder()
                            .setUserId(originalPictureVideoFriendsTransmission.getTourists().getTemporaryId())
                            .setUserInfomation(UserInfomation.newBuilder()
                                    .setUserId(originalPictureVideoFriendsTransmission.getTourists().getTemporaryId())
                                    .setAvatar(fileName).build()).build()).build();
                    guestUserAPI.updateGuestUserInfo(requestUser);
                }
            }else{
                String fileName = fileProperts.getServerFileName();
                String clientPath = fileProperts.getClientFileName();
                response = jcrc32.packageCheckSumResponse(
                        OriginalPictureVideoFriendsTransmission.newBuilder().setFileContent(
                                FileContent.newBuilder()
                                        .setBigFileFoot(BigFileFoot.newBuilder()
                                                .setIsSuccess(false)
                                                .build())
                                        .setBigFileHead(BigFileHead.newBuilder()
                                                .setClientUrl(clientPath)
                                                .setServerUrl(fileName)
                                                .build())
                                        .setPackageKind(ConstantsContent.FILE_FOOT)
                                        .build())
                                .setFriends(friends)
                                .build());
                responseObserver.onNext(response);
                logger.info("$$$$$$上传保存文件失败"+"fromId:"+originalPictureVideoFriendsTransmission.getHead().getFromId()+", fileId :"+fileId+" , foot_properties :"+fileProperts.toString());
            }
            FileTransmissionServiceGrpcImpl.filePropertyMap.remove(fileId);
        }
    }
}
