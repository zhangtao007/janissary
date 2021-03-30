package com.lanjiu.im.storage.server.impl;

import com.lanjiu.im.storage.server.avatarUtil.ImageTools;
import com.lanjiu.im.storage.server.controller.StorageController;
import com.lanjiu.im.storage.util.ConfigFileOperation;
import com.lanjiu.im.storage.util.ConstantsContent;
import com.lanjiu.pro.fileStorage.*;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class FileStorageServiceGrpcImpl extends FileStorageServiceGrpc.FileStorageServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(FileStorageServiceGrpcImpl.class);

    /**
     * 存储记录
     */
    @Override
    public void storageFileInformationWithFriend(FriendsTransmissionRequest request, StreamObserver<FriendsTransmissionResponse> responseObserver) {

//        System.out.println("存储上传文件记录到数据库中----好友");
        OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission = request.getFriendsPictureVideoMessage();
        String userType = originalPictureVideoFriendsTransmission.getUserType();
        String settingsType = originalPictureVideoFriendsTransmission.getSettingsType();
        StorageController storageController = new StorageController();
        int result = storageController.storageControllerFriend(userType, settingsType, originalPictureVideoFriendsTransmission);
        logger.info("存储好友上传文件记录到数据库，result:"+result);
        if (result > 0){
            FriendsTransmissionResponse friendsTransmissionResponse = FriendsTransmissionResponse.newBuilder()
                    .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_PROTECT_SUCCESS).build()))
                    .build();
            responseObserver.onNext(friendsTransmissionResponse);
            responseObserver.onCompleted();
        }else {
            FriendsTransmissionResponse friendsTransmissionResponse = FriendsTransmissionResponse.newBuilder()
                    .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_PROTECT__FAILURE).build()))
                    .build();
            responseObserver.onNext(friendsTransmissionResponse);
            responseObserver.onCompleted();
        }

    }

    /**
     * 存储记录
     */
    @Override
    public void storageFileInformationWithGroup(GroupTransmissionRequest request, StreamObserver<GroupTransmissionResponse> responseObserver) {
        OriginalPictureVideoGroupTransmission originalPictureVideoGroupTransmission = request.getGroupPictureVideoMessage();
        String userType = originalPictureVideoGroupTransmission.getUserType();
        String settingsType = originalPictureVideoGroupTransmission.getSettingsType();
        StorageController storageController = new StorageController();
        int result = storageController.storageControllerGroup(userType, settingsType, originalPictureVideoGroupTransmission);
        logger.info("存储群成员上传文件记录到数据库 result:" +result);
        if(result > 0){
            GroupTransmissionResponse groupTransmissionResponse = GroupTransmissionResponse.newBuilder()
                    .setGroupPictureVideoMessage(OriginalPictureVideoGroupTransmission.newBuilder()
                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_PROTECT_SUCCESS).build()))
                    .build();
            responseObserver.onNext(groupTransmissionResponse);
            responseObserver.onCompleted();
        }else {
            GroupTransmissionResponse groupTransmissionResponse = GroupTransmissionResponse.newBuilder()
                    .setGroupPictureVideoMessage(OriginalPictureVideoGroupTransmission.newBuilder()
                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_PROTECT__FAILURE).build()))
                    .build();
            responseObserver.onNext(groupTransmissionResponse);
            responseObserver.onCompleted();
        }

    }

    /**
     * 删除好友上传的记录------>以文件路径删除
     */
    @Override
    public void deleteFileInformationWithFriend(FriendsTransmissionRequest request, StreamObserver<FriendsTransmissionResponse> responseObserver) {

        OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission = request.getFriendsPictureVideoMessage();
        String userType = originalPictureVideoFriendsTransmission.getUserType();
        String settingsType = originalPictureVideoFriendsTransmission.getSettingsType();
        StorageController storageController = new StorageController();
        boolean bResult = storageController.deleteControllerFriend(userType, settingsType, originalPictureVideoFriendsTransmission);
        logger.info("文件下载成功后，删除数据库中的存储记录(好友) ，"+bResult+"  ,url:"+originalPictureVideoFriendsTransmission.getFileContent().getBigFileHead().getServerUrl());
        if(bResult){
            FriendsTransmissionResponse friendsTransmissionResponse = FriendsTransmissionResponse.newBuilder()
                    .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_DELETE_SUCCESS).build()))
                    .build();
            responseObserver.onNext(friendsTransmissionResponse);
            responseObserver.onCompleted();
        }else {
            FriendsTransmissionResponse friendsTransmissionResponse = FriendsTransmissionResponse.newBuilder()
                    .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_DELETE__FAILURE).build()))
                    .build();
            responseObserver.onNext(friendsTransmissionResponse);
            responseObserver.onCompleted();
        }
    }

    /**
     * 删除群存储记录------>以文件路径删除   //其他服务器调用-----------非文件服务器
     */
    @Override
    public void deleteFileInformationWithGroup(GroupTransmissionRequest request, StreamObserver<GroupTransmissionResponse> responseObserver) {

        OriginalPictureVideoGroupTransmission originalPictureVideoGroupTransmission = request.getGroupPictureVideoMessage();
        String userType = originalPictureVideoGroupTransmission.getUserType();
        String settingsType = originalPictureVideoGroupTransmission.getSettingsType();
        StorageController storageController = new StorageController();
        boolean bResult = storageController.deleteControllerGroup(userType, settingsType, originalPictureVideoGroupTransmission);
        if(bResult){
            GroupTransmissionResponse groupTransmissionResponse = GroupTransmissionResponse.newBuilder()
                    .setGroupPictureVideoMessage(OriginalPictureVideoGroupTransmission.newBuilder()
                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_DELETE_SUCCESS).build()))
                    .build();
            responseObserver.onNext(groupTransmissionResponse);
            responseObserver.onCompleted();
        }
        else {
            GroupTransmissionResponse groupTransmissionResponse = GroupTransmissionResponse.newBuilder()
                    .setGroupPictureVideoMessage(OriginalPictureVideoGroupTransmission.newBuilder()
                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_DELETE__FAILURE).build()))
                    .build();
            responseObserver.onNext(groupTransmissionResponse);
            responseObserver.onCompleted();
        }

    }

    /**
     * 删除好友上传的记录------>以好友id删除 //其他服务器调用-----------非文件服务器
     */
    @Override
    public void deleteFileInformationWithFriendByFriendId(FriendsTransmissionRequest request, StreamObserver<FriendsTransmissionResponse> responseObserver) {

        OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission = request.getFriendsPictureVideoMessage();
        String userType = originalPictureVideoFriendsTransmission.getUserType();
        String settingsType = originalPictureVideoFriendsTransmission.getSettingsType();
        StorageController storageController = new StorageController();
        boolean bResult = storageController.deleteControllerFriendByFriendId(userType, settingsType, originalPictureVideoFriendsTransmission);
        if(bResult){
            FriendsTransmissionResponse friendsTransmissionResponse = FriendsTransmissionResponse.newBuilder()
                    .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_DELETE_SUCCESS).build()))
                    .build();
            responseObserver.onNext(friendsTransmissionResponse);
            responseObserver.onCompleted();
        }else {
            FriendsTransmissionResponse friendsTransmissionResponse = FriendsTransmissionResponse.newBuilder()
                    .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_DELETE__FAILURE).build()))
                    .build();
            responseObserver.onNext(friendsTransmissionResponse);
            responseObserver.onCompleted();
        }
    }


    /**
     * 用户退出清理2019.12.31  Happy New Year
     * @param
     * @param responseObserver
     */
    public void cleanFileWithUserId(com.lanjiu.pro.fileStorage.FriendsTransmissionRequest request,
                                    io.grpc.stub.StreamObserver<com.lanjiu.pro.fileStorage.FriendsTransmissionResponse> responseObserver) {
        OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission = request.getFriendsPictureVideoMessage();
        StorageController storageController = new StorageController();
        Integer userId = Integer.parseInt(originalPictureVideoFriendsTransmission.getHead().getFromId());
//        if(userId <70000000){
            storageController.cleanFileByRegistUserId(userId);
//        }else{
//            storageController.cleanFileWithUserId(userId);
//        }


        FriendsTransmissionResponse friendsTransmissionResponse = FriendsTransmissionResponse.newBuilder()
                .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
                        .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_DELETE_SUCCESS).build()))
                .build();
        responseObserver.onNext(friendsTransmissionResponse);
        responseObserver.onCompleted();


    }

    /**
     * 群头像合成
     */
    public void mergeGroupAvatar(com.lanjiu.pro.fileStorage.GroupAvatarRequest request,
                                 io.grpc.stub.StreamObserver<com.lanjiu.pro.fileStorage.GroupAvatarResponse> responseObserver) {
        String groupId = request.getGroupId();
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        int num = Integer.parseInt(request.getNum());
        List<String> avatars = request.getAvatarUrlList();
        if (avatars.size()<1 || avatars ==null){
            logger.error("######群头像合成时入参地址都为空######");
        }
        List<String> urlList = judgeUrl(avatars, num, groupId);
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        String destPath =configFileOperation.getGroupAvatarFileDir();
        String groupAvatarUrl = uuid+".jpg";
        try {
//            ImageUtil.getGroupAvatar(urlList,destPath + groupAvatarUrl);
            ImageTools.getCombinationOfhead(urlList,destPath,uuid);
        } catch (Exception e) {
            logger.error("群头像合成错误。"+e.getMessage());
            e.printStackTrace();
            GroupAvatarResponse response =GroupAvatarResponse.newBuilder().setGroupId(groupId).setResult(ConstantsContent.CRC_FAILURE)
                    .setDetail("合成群头像异常").build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        GroupAvatarResponse response =GroupAvatarResponse.newBuilder().setGroupId(groupId).setResult(ConstantsContent.CRC_SUCCESS)
                    .setGroupAvatar(destPath+groupAvatarUrl).build();
        logger.info("group_avatar:"+destPath+groupAvatarUrl);
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    public List<String> judgeUrl(List<String> avatars,int num,String groupId){
        //判断所有头像文件是否存在
        List<String> list = new ArrayList<>();

        for (int i = 0; i <avatars.size() ; i++) {
            String url = avatars.get(i);
            File file = new File(url);
            if(!file.exists()){
                logger.info("######群组："+groupId +",中该用户头像文件不存在："+url);
                continue;
            }
            logger.info("成员头像url："+url+" ,groupId:"+groupId);
            list.add(url);

        }
        logger.info(groupId+",群成员数量："+list.size());
        if(list.size()>9){
            return list.subList(0,9);
        }
        return list;
    }

}
