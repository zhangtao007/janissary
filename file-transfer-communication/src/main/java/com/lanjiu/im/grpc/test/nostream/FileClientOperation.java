package com.lanjiu.im.grpc.test.nostream;

import com.google.protobuf.ByteString;

import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.FileJCRC32;
import com.lanjiu.im.grpc.util.FileProperties;
import com.lanjiu.pro.file.*;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Properties;

public class FileClientOperation {

    public void transmissionFileContentSend(FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub blockingStub) throws IOException {

        FileJCRC32 jcrc32 = new FileJCRC32();
        String configFile = "config.properties";
        InputStream isConfig = new FileInputStream(configFile);
        Properties properties = new Properties();
        properties.load(isConfig);
        isConfig.close();
        String fileName = properties.getProperty("file_name");
        String suffix = properties.getProperty("file_suffix");
        System.out.println(fileName);
        RandomAccessFile read = new RandomAccessFile("F:\\SVN\\im\\Java\\janissary\\file-transfer-communication\\"+fileName+suffix, "r");
        FileChannel readChannel = read.getChannel();
        long length = read.length();
        int count = (int) (length % ConstantsContent.FRAGMENT_LENGTH == 0 ? length / ConstantsContent.FRAGMENT_LENGTH : length / ConstantsContent.FRAGMENT_LENGTH + 1);
        //构建传输结构体
        FriendsTransmissionRequest request = jcrc32.packageCheckSumRequest(
                OriginalPictureVideoFriendsTransmission.newBuilder().setFileContent(
                        FileContent.newBuilder().setBigFileHead(
                                BigFileHead.newBuilder()
                                        .setCount(count)
                                        .setLength(length)
                                        .setClientUrl(fileName+suffix)
                                        .build())
                                .setPackageKind(ConstantsContent.FILE_HEAD)
                                .build())
                        .build());
        System.out.println("start");
        FriendsTransmissionResponse friendsTransmissionResponse = blockingStub.originalFriendsTransmissionUpload(request);
        System.out.println("阻塞");
        System.out.println(friendsTransmissionResponse);
        FriendsTransmissionResponse myResponse;
        int i = 0;
        int position = 0;
        int size = (int) (length - position < ConstantsContent.FRAGMENT_LENGTH ? length - position : ConstantsContent.FRAGMENT_LENGTH);
        while (count > i) {
            MappedByteBuffer mappedByteBuffer = readChannel.map(FileChannel.MapMode.READ_ONLY, position, size);
            //构建传输结构体
            request = jcrc32.packageCheckSumRequest(
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
                            .build());
            myResponse = blockingStub.originalFriendsTransmissionUpload(request);
            FileContent fileContent = myResponse.getFriendsPictureVideoMessage().getFileContent();
            System.out.println("碎片发送成功！" + (i + 1));
            String packageKind = fileContent.getPackageKind();
            if (ConstantsContent.FILE_FRAGMENT.equals(packageKind)) {
                i++;
            }else if (ConstantsContent.FILE_FOOT.equals(packageKind)) {
                System.out.println(fileContent.getBigFileFoot().getIsSuccess() ? "文件发送成功" : "文件发送失败");
                break;
            }
            position = i * ConstantsContent.FRAGMENT_LENGTH;
            size = (int) (length - position < ConstantsContent.FRAGMENT_LENGTH ? length - position : ConstantsContent.FRAGMENT_LENGTH);
        }
        System.out.println("ddddddddddddddddddddddddddddd");
        readChannel.close();
        read.close();
    }


    public void transmissionFileContentGroupSend(FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub blockingStub) throws IOException {

        FileJCRC32 jcrc32 = new FileJCRC32();
        String configFile = "config.properties";
        InputStream isConfig = new FileInputStream(configFile);
        Properties properties = new Properties();
        properties.load(isConfig);
        isConfig.close();
        String fileName = properties.getProperty("file_name");
        String suffix = properties.getProperty("file_suffix");
        System.out.println(fileName);
        RandomAccessFile read = new RandomAccessFile(fileName, "r");
        FileChannel readChannel = read.getChannel();
        long length = read.length();
        int count = (int) (length % ConstantsContent.FRAGMENT_LENGTH == 0 ? length / ConstantsContent.FRAGMENT_LENGTH : length / ConstantsContent.FRAGMENT_LENGTH + 1);
        //构建传输结构体
        GroupTransmissionRequest request = jcrc32.packageCheckSumGroupRequest(
                OriginalPictureVideoGroupTransmission.newBuilder().setFileContent(
                        FileContent.newBuilder().setBigFileHead(
                                BigFileHead.newBuilder()
                                        .setCount(count)
                                        .setLength(length)
                                        .build())
                                .setPackageKind(ConstantsContent.FILE_HEAD)
                                .build())
                        .build());
        System.out.println("start");
        GroupTransmissionResponse friendsTransmissionResponse = blockingStub.originalGroupTransmissionUpload(request);
        System.out.println("阻塞");
        System.out.println(friendsTransmissionResponse);
        GroupTransmissionResponse myResponse;
        int i = 0;
        int position = 0;
        int size = (int) (length - position < ConstantsContent.FRAGMENT_LENGTH ? length - position : ConstantsContent.FRAGMENT_LENGTH);
        while (count > i) {
            MappedByteBuffer mappedByteBuffer = readChannel.map(FileChannel.MapMode.READ_ONLY, position, size);
            //构建传输结构体
            request = jcrc32.packageCheckSumGroupRequest(
                    OriginalPictureVideoGroupTransmission.newBuilder().setFileContent(
                            FileContent.newBuilder()
                                    .setBigFileFragment(
                                            BigFileFragment.newBuilder()
                                                    .setData(ByteString.copyFrom(mappedByteBuffer))
                                                    .setLength(size)
                                                    .setPosition(position)
                                                    .build())
                                    .setPackageKind(ConstantsContent.FILE_FRAGMENT)
                                    .build())
                            .build());
            myResponse = blockingStub.originalGroupTransmissionUpload(request);
            FileContent fileContent = myResponse.getGroupPictureVideoMessage().getFileContent();
            System.out.println("碎片发送成功！" + (i + 1));
            String packageKind = fileContent.getPackageKind();
            if (ConstantsContent.FILE_FRAGMENT.equals(packageKind)) {
                i++;
            }else if (ConstantsContent.FILE_FOOT.equals(packageKind)) {
                System.out.println(fileContent.getBigFileFoot().getIsSuccess() ? "文件发送成功" : "文件发送失败");
                break;
            }
            position = i * ConstantsContent.FRAGMENT_LENGTH;
            size = (int) (length - position < ConstantsContent.FRAGMENT_LENGTH ? length - position : ConstantsContent.FRAGMENT_LENGTH);
        }
        System.out.println("ddddddddddddddddddddddddddddd");
        readChannel.close();
        read.close();
    }

    //客户端-----好友下载文件
    public FriendsTransmissionRequest transmissionFileContentFriendsReception(FileProperties fileProperties, FileContent fileContent, FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub blockingStub) throws IOException {
        DownloadFileCommon downloadFileCommon = new DownloadFileCommon();
        String dataType = fileContent.getPackageKind();
        FileJCRC32 jcrc32 = new FileJCRC32();
        FriendsTransmissionResponse friendsTransmissionResponse = null;
        FriendsTransmissionRequest request = null;
        if (ConstantsContent.FILE_HEAD.equals(dataType)) {
            BigFileHead bigFileHead = fileContent.getBigFileHead();
            System.out.println("发送大文件请求，文件类型[" + "]文件大小[" + bigFileHead.getLength() + "b]碎片数量[" + bigFileHead.getCount() + "]");
            fileProperties.setFragmentCount(bigFileHead.getCount());
            fileProperties.setFileLength(bigFileHead.getLength());
            fileProperties.setClientFileName(bigFileHead.getClientUrl());
            fileProperties.setReadCount(0);

            fileProperties.setPosition(0);
            fileProperties.setWriteLength(0);
            downloadFileCommon.protectPosition(fileProperties);

            //继续下发请求
            request = jcrc32.packageCheckSumRequest(
                    OriginalPictureVideoFriendsTransmission.newBuilder().setFileContent(
                            FileContent.newBuilder()
                                    .setPackageKind(ConstantsContent.FILE_FRAGMENT)
                                    .build())
                            .build());
            friendsTransmissionResponse = blockingStub.originalFriendsTransmissionDownload(request);
            fileContent = friendsTransmissionResponse.getFriendsPictureVideoMessage().getFileContent();
            transmissionFileContentFriendsReception(fileProperties,fileContent,blockingStub);
        } else if (ConstantsContent.FILE_FRAGMENT.equals(dataType)) {
            BigFileFragment fragment = fileContent.getBigFileFragment();
            long position = fragment.getPosition();
            long size = fragment.getLength();
            String clintfileName = fileProperties.getClientFileName();
            int fragmentCount = fileProperties.getFragmentCount();
            long fileLength = fileProperties.getFileLength();
            String serverfileName = fileProperties.getServerFileName();
            int readCount = fileProperties.getReadCount();

            RandomAccessFile write = new RandomAccessFile(serverfileName, "rw");
            FileChannel writeChannel = write.getChannel();
            MappedByteBuffer mappedByteBuffer = writeChannel.map(FileChannel.MapMode.READ_WRITE, position, size);
            mappedByteBuffer.put(fragment.getData().asReadOnlyByteBuffer());
            long writeLength = write.length();
            writeChannel.close();
            write.close();

            position = position + size;
            fileProperties.setPosition(position);
            readCount++;
            fileProperties.setReadCount(readCount);
            if(0 != size)
            {
                fileProperties.setWriteLength(writeLength);
                fileProperties.setFileLength(fileLength);
                fileProperties.setFragmentCount(fragmentCount);
                downloadFileCommon.protectPosition(fileProperties);
            }
            request = jcrc32.packageCheckSumRequest(
                    OriginalPictureVideoFriendsTransmission.newBuilder().setFileContent(
                            FileContent.newBuilder().setBigFileFragment(
                                    BigFileFragment.newBuilder()
                                            .setPosition(position)
                                            .build())
                                    .setPackageKind(ConstantsContent.FILE_FRAGMENT)
                                    .build())
                            .build());
            friendsTransmissionResponse = blockingStub.originalFriendsTransmissionDownload(request);
            fileContent = friendsTransmissionResponse.getFriendsPictureVideoMessage().getFileContent();
            if(readCount == fragmentCount && writeLength == fileLength) {
                request = jcrc32.packageCheckSumRequest(
                        OriginalPictureVideoFriendsTransmission.newBuilder().setFileContent(
                                FileContent.newBuilder().setBigFileFoot(
                                        BigFileFoot.newBuilder()
                                                .setIsSuccess(true)
                                                .build())
                                        .setPackageKind(ConstantsContent.FILE_FOOT)
                                        .build())
                                .build());
                friendsTransmissionResponse = blockingStub.originalFriendsTransmissionDownload(request);
                fileContent = friendsTransmissionResponse.getFriendsPictureVideoMessage().getFileContent();
                transmissionFileContentFriendsReception(fileProperties,fileContent,blockingStub);
            }else{
                if(0 != size)
                {
                    transmissionFileContentFriendsReception(fileProperties,fileContent,blockingStub);
                }
            }

        }else if (ConstantsContent.FILE_FOOT.equals(dataType)){
            System.out.println(fileContent.getBigFileFoot().getIsSuccess() ? "文件下载成功" : "文件下载失败");
            fileProperties.setPosition(0);
            fileProperties.setWriteLength(0);
            fileProperties.setReadCount(0);
            fileProperties.setFileLength(0);
            fileProperties.setFragmentCount(0);
            downloadFileCommon.protectPosition(fileProperties);
            try {
                GrpcClient.shutdownNow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return request;
    }

    //客户端-----群成员下载文件
    public GroupTransmissionRequest transmissionFileContentGroupReception(FileProperties fileProperties, FileContent fileContent, FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub blockingStub) throws IOException {
        DownloadFileCommon downloadFileCommon = new DownloadFileCommon();
        String dataType = fileContent.getPackageKind();
        FileJCRC32 jcrc32 = new FileJCRC32();
        GroupTransmissionResponse groupTransmissionResponse = null;
        GroupTransmissionRequest request = null;
        if (ConstantsContent.FILE_HEAD.equals(dataType)) {
            BigFileHead bigFileHead = fileContent.getBigFileHead();
            System.out.println("发送大文件请求，文件类型[" + "]文件大小[" + bigFileHead.getLength() + "b]碎片数量[" + bigFileHead.getCount() + "]");
            fileProperties.setFragmentCount(bigFileHead.getCount());
            fileProperties.setFileLength(bigFileHead.getLength());
            fileProperties.setClientFileName(bigFileHead.getClientUrl());
            fileProperties.setReadCount(0);

            fileProperties.setPosition(0);
            fileProperties.setWriteLength(0);
            downloadFileCommon.protectPosition(fileProperties);

            //继续下发请求
            request = jcrc32.packageCheckSumGroupRequest(
                    OriginalPictureVideoGroupTransmission.newBuilder().setFileContent(
                            FileContent.newBuilder()
                                    .setPackageKind(ConstantsContent.FILE_FRAGMENT)
                                    .build())
                            .build());
            groupTransmissionResponse = blockingStub.originalGroupTransmissionDownload(request);
            fileContent = groupTransmissionResponse.getGroupPictureVideoMessage().getFileContent();
            transmissionFileContentGroupReception(fileProperties,fileContent,blockingStub);
        } else if (ConstantsContent.FILE_FRAGMENT.equals(dataType)) {
            BigFileFragment fragment = fileContent.getBigFileFragment();
            long position = fragment.getPosition();
            long size = fragment.getLength();
            String clientfileName = fileProperties.getClientFileName();
            int fragmentCount = fileProperties.getFragmentCount();
            long fileLength = fileProperties.getFileLength();
            String serverfileName = fileProperties.getServerFileName();
            int readCount = fileProperties.getReadCount();

            RandomAccessFile write = new RandomAccessFile(serverfileName, "rw");
            FileChannel writeChannel = write.getChannel();
            MappedByteBuffer mappedByteBuffer = writeChannel.map(FileChannel.MapMode.READ_WRITE, position, size);
            mappedByteBuffer.put(fragment.getData().asReadOnlyByteBuffer());
            long writeLength = write.length();
            writeChannel.close();
            write.close();

            position = position + size;
            fileProperties.setPosition(position);
            readCount++;
            fileProperties.setReadCount(readCount);
            if(0 != size)
            {
                fileProperties.setWriteLength(writeLength);
                fileProperties.setFileLength(fileLength);
                fileProperties.setFragmentCount(fragmentCount);
                downloadFileCommon.protectPosition(fileProperties);
            }
            request = jcrc32.packageCheckSumGroupRequest(
                    OriginalPictureVideoGroupTransmission.newBuilder().setFileContent(
                            FileContent.newBuilder().setBigFileFragment(
                                    BigFileFragment.newBuilder()
                                            .setPosition(position)
                                            .build())
                                    .setPackageKind(ConstantsContent.FILE_FRAGMENT)
                                    .build())
                            .build());
            groupTransmissionResponse = blockingStub.originalGroupTransmissionDownload(request);
            fileContent = groupTransmissionResponse.getGroupPictureVideoMessage().getFileContent();
            if(readCount == fragmentCount && writeLength == fileLength) {
                request = jcrc32.packageCheckSumGroupRequest(
                        OriginalPictureVideoGroupTransmission.newBuilder().setFileContent(
                                FileContent.newBuilder().setBigFileFoot(
                                        BigFileFoot.newBuilder()
                                                .setIsSuccess(true)
                                                .build())
                                        .setPackageKind(ConstantsContent.FILE_FOOT)
                                        .build())
                                .build());
                groupTransmissionResponse = blockingStub.originalGroupTransmissionDownload(request);
                fileContent = groupTransmissionResponse.getGroupPictureVideoMessage().getFileContent();
                transmissionFileContentGroupReception(fileProperties,fileContent,blockingStub);
            }else{
                if(0 != size)
                {
                    transmissionFileContentGroupReception(fileProperties,fileContent,blockingStub);
                }
            }

        }else if (ConstantsContent.FILE_FOOT.equals(dataType)){
            System.out.println(fileContent.getBigFileFoot().getIsSuccess() ? "文件下载成功" : "文件下载失败");
            fileProperties.setPosition(0);
            fileProperties.setWriteLength(0);
            fileProperties.setReadCount(0);
            fileProperties.setFileLength(0);
            fileProperties.setFragmentCount(0);
            downloadFileCommon.protectPosition(fileProperties);
            try {
                GrpcClient.shutdownNow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return request;
    }
}
