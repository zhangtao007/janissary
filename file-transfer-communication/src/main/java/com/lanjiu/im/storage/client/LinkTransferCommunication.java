package com.lanjiu.im.storage.client;

import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.DeleteFileUtil;
import com.lanjiu.pro.file.OriginalPictureVideoFriendsTransmission;
import com.lanjiu.pro.fileStorage.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.File;

public class LinkTransferCommunication {

    private static final Logger logger = LoggerFactory.getLogger(LinkTransferCommunication.class);

    private static FileStorageServiceGrpc.FileStorageServiceBlockingStub blockingStub = null;

    public static FileStorageServiceGrpc.FileStorageServiceBlockingStub linkTransferCommunication(){
        FileStorageServiceGrpc.FileStorageServiceBlockingStub stub = TransferStorageClient.linkTransferCommunication(blockingStub);
        return stub;
    }

    public boolean storageFileIsSuccessFulWithFriends(com.lanjiu.pro.file.FriendsTransmissionRequest request){
        blockingStub = linkTransferCommunication();
        com.lanjiu.pro.fileStorage.FriendsTransmissionResponse response = null;
        OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission = request.getFriendsPictureVideoMessage();
        String userType = originalPictureVideoFriendsTransmission.getUserType();
        String settingsType = originalPictureVideoFriendsTransmission.getSettingsType();
        String serverUrl = originalPictureVideoFriendsTransmission.getFileContent().getBigFileHead().getServerUrl();
        String frindsId = originalPictureVideoFriendsTransmission.getFriends().getFriendsId();
        String userId = originalPictureVideoFriendsTransmission.getTourists().getTemporaryId();
        String registeredUserId = originalPictureVideoFriendsTransmission.getRegisteredUser().getUserId();
        //调用文件存储服务器，保存对应文件记录
        com.lanjiu.pro.fileStorage.FriendsTransmissionRequest requestStorage =
                com.lanjiu.pro.fileStorage.FriendsTransmissionRequest.newBuilder()
                .setFriendsPictureVideoMessage(com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission.newBuilder()
                        .setFileContent(FileContent.newBuilder()
                                .setBigFileHead(BigFileHead.newBuilder()
                                        .setServerUrl(serverUrl)
                                        .build())
                                .build())
                        .setFriends(Friends.newBuilder()
                                .setFriendsId(frindsId)
                                .build())
                        .setTourists(Tourists.newBuilder()
                                .setTemporaryId(userId)
                                .build())
                        .setRegisteredUser(RegisteredUser.newBuilder()
                                .setUserId(registeredUserId)
                                .build())
                        .setUserType(userType)
                        .setSettingsType(settingsType)
                        .build())
                        .build();
        try {
            response = blockingStub.storageFileInformationWithFriend(requestStorage);
        } catch (Exception e) {
            logger.info("$$$存储上传文件记录到数据库中异常----好友$$$, error:"+serverUrl+" ,info:"+e.getMessage());
            try {
                TransferStorageClient.shutdownNow();
            } catch (InterruptedException f) {
                f.printStackTrace();
            }
            return false;
        }
        if(ConstantsContent.FILE_PROTECT_SUCCESS.equals(response.getFriendsPictureVideoMessage().getHead().getStatusReport())){
            //存储上传文件记录到数据库中----好友
            logger.info("存储上传文件记录到数据库中----好友:"+serverUrl);
            try {
                TransferStorageClient.shutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
        try {
            TransferStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteFileIsSuccessFulWithFriends(com.lanjiu.pro.file.FriendsTransmissionRequest request){
        blockingStub = linkTransferCommunication();
        com.lanjiu.pro.fileStorage.FriendsTransmissionResponse response = null;
        com.lanjiu.pro.file.OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission = request.getFriendsPictureVideoMessage();
        String userType = originalPictureVideoFriendsTransmission.getUserType();
        String settingsType = originalPictureVideoFriendsTransmission.getSettingsType();
        String serverUrl = originalPictureVideoFriendsTransmission.getFileContent().getBigFileHead().getServerUrl();
        String frindsId = originalPictureVideoFriendsTransmission.getFriends().getFriendsId();
        String userId = originalPictureVideoFriendsTransmission.getTourists().getTemporaryId();
        String registeredUserId = originalPictureVideoFriendsTransmission.getRegisteredUser().getUserId();
        //调用文件存储服务器，保存对应文件记录
        com.lanjiu.pro.fileStorage.FriendsTransmissionRequest requestStorage =
                com.lanjiu.pro.fileStorage.FriendsTransmissionRequest.newBuilder()
                        .setFriendsPictureVideoMessage(com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission.newBuilder()
                                .setFileContent(FileContent.newBuilder()
                                        .setBigFileHead(BigFileHead.newBuilder()
                                                .setServerUrl(serverUrl)
                                                .build())
                                        .build())
                                .setFriends(Friends.newBuilder()
                                        .setFriendsId(frindsId)
                                        .build())
                                .setTourists(Tourists.newBuilder()
                                        .setTemporaryId(userId)
                                        .build())
                                .setRegisteredUser(RegisteredUser.newBuilder()
                                        .setUserId(registeredUserId)
                                        .build())
                                .setUserType(userType)
                                .setSettingsType(settingsType)
                                .build())
                        .build();
        try {
            response = blockingStub.deleteFileInformationWithFriend(requestStorage);
        } catch (Exception e) {
            logger.info("$$$文件下载成功后，删除数据库中的存储记录异常$$$,error:"+serverUrl +" , info:"+e.getMessage());
            try {
                TransferStorageClient.shutdownNow();
            } catch (InterruptedException f) {
                f.printStackTrace();
            }
            return false;
        }
        if(ConstantsContent.FILE_PROTECT_SUCCESS.equals(response.getFriendsPictureVideoMessage().getHead().getStatusReport())){
            //文件下载成功后，删除数据库中的存储记录
            logger.info("文件下载成功后，删除数据库中的存储记录:"+serverUrl);
            try {
                TransferStorageClient.shutdownNow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            DeleteFileUtil deleteFileUtil = new DeleteFileUtil();
            File file = new File(serverUrl);
            boolean bResult = deleteFileUtil.forceDelete(file);
            if(bResult)
            {
                logger.info("文件下载成功后，删除文件服务器上的文件:"+serverUrl);
            }
            return true;
        }
        try {
            TransferStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean storageFileIsSuccessFulWithGroup(com.lanjiu.pro.file.GroupTransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GroupTransmissionResponse response = null;
        //调用文件交互服务器，删除对应文件
        com.lanjiu.pro.file.OriginalPictureVideoGroupTransmission originalPictureVideoGroupTransmission = request.getGroupPictureVideoMessage();
        String userType = originalPictureVideoGroupTransmission.getUserType();
        String settingsType = originalPictureVideoGroupTransmission.getSettingsType();
        String serverUrl = originalPictureVideoGroupTransmission.getFileContent().getBigFileHead().getServerUrl();
        String groupId = originalPictureVideoGroupTransmission.getGroup().getGroupId();
        String groupMemberId = originalPictureVideoGroupTransmission.getGroupMember().getGroupMemberId();
        String userId = originalPictureVideoGroupTransmission.getTourists().getTemporaryId();
        String registeredUserId = originalPictureVideoGroupTransmission.getRegisteredUser().getUserId();
        //调用文件存储服务器，保存对应文件记录
        GroupTransmissionRequest requestStorage =
                GroupTransmissionRequest.newBuilder()
                        .setGroupPictureVideoMessage(OriginalPictureVideoGroupTransmission.newBuilder()
                                .setFileContent(FileContent.newBuilder()
                                        .setBigFileHead(BigFileHead.newBuilder()
                                                .setServerUrl(serverUrl)
                                                .build())
                                        .build())
                                .setGroup(Group.newBuilder()
                                        .setGroupId(groupId)
                                        .build())
                                .setGroupMember(GroupMember.newBuilder()
                                        .setGroupMemberId(groupMemberId)
                                        .build())
                                .setTourists(Tourists.newBuilder()
                                        .setTemporaryId(userId)
                                        .build())
                                .setRegisteredUser(RegisteredUser.newBuilder()
                                        .setUserId(registeredUserId)
                                        .build())
                                .setUserType(userType)
                                .setSettingsType(settingsType)
                                .build())
                        .build();
        try {
            response = blockingStub.storageFileInformationWithGroup(requestStorage);
        } catch (Exception e) {
            logger.info("$$$存储上传文件记录到数据库中----群$$$,error:"+", serverUrl: "+ serverUrl +" ,usreId:"+registeredUserId+" ,info:"+e.getMessage());
            try {
                TransferStorageClient.shutdownNow();
            } catch (InterruptedException f) {
                f.printStackTrace();
            }
            return false;
        }
        if(ConstantsContent.FILE_PROTECT_SUCCESS.equals(response.getGroupPictureVideoMessage().getHead().getStatusReport())){
            //存储上传文件记录到数据库中----群
           logger.info("存储上传文件记录到数据库中----群"+", serverUrl: "+ serverUrl +" ,usreId:"+registeredUserId);
            try {
                TransferStorageClient.shutdownNow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
        try {
            TransferStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
