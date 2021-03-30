package com.lanjiu.im.grpc.client.file_storage;

import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.DeleteFileUtil;
import com.lanjiu.im.storage.client.TransferStorageClient;
import com.lanjiu.pro.fileStorage.*;

import java.io.File;

public class LinkTransferCommunication {

    private static FileStorageServiceGrpc.FileStorageServiceBlockingStub blockingStub = null;

    public static FileStorageServiceGrpc.FileStorageServiceBlockingStub linkTransferCommunication(){
        FileStorageServiceGrpc.FileStorageServiceBlockingStub stub = TransferStorageClient.linkTransferCommunication(blockingStub);
        return stub;
    }

    public boolean storageFileIsSuccessFulWithFriends(FriendsTransmissionRequest request){
        blockingStub = linkTransferCommunication();
        FriendsTransmissionResponse response = null;
        OriginalPictureVideoFriendsTransmission friendsPictureVideoMessage = request.getFriendsPictureVideoMessage();
        String userType = friendsPictureVideoMessage.getUserType();
        String settingsType = friendsPictureVideoMessage.getSettingsType();
        String serverUrl = friendsPictureVideoMessage.getFileContent().getBigFileHead().getServerUrl();
        String frindsId = friendsPictureVideoMessage.getFriends().getFriendsId();
        String userId = friendsPictureVideoMessage.getTourists().getTemporaryId();
        String registeredUserId = friendsPictureVideoMessage.getRegisteredUser().getUserId();
        //调用文件存储服务器，保存对应文件记录
        FriendsTransmissionRequest requestStorage =
                FriendsTransmissionRequest.newBuilder()
                .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
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
        response = blockingStub.storageFileInformationWithFriend(requestStorage);
        if(ConstantsContent.FILE_PROTECT_SUCCESS.equals(response.getFriendsPictureVideoMessage().getHead().getStatusReport())){
            //存储上传文件记录到数据库中----好友
            System.out.println("存储上传文件记录到数据库中----好友");
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

    public boolean deleteFileIsSuccessFulWithFriends(FriendsTransmissionRequest request){
        blockingStub = linkTransferCommunication();
        FriendsTransmissionResponse response = null;
        OriginalPictureVideoFriendsTransmission friendsPictureVideoMessage = request.getFriendsPictureVideoMessage();
        String userType = friendsPictureVideoMessage.getUserType();
        String settingsType = friendsPictureVideoMessage.getSettingsType();
        String serverUrl = friendsPictureVideoMessage.getFileContent().getBigFileHead().getServerUrl();
        String frindsId = friendsPictureVideoMessage.getFriends().getFriendsId();
        String userId = friendsPictureVideoMessage.getTourists().getTemporaryId();
        String registeredUserId = friendsPictureVideoMessage.getRegisteredUser().getUserId();
        //调用文件存储服务器，保存对应文件记录
        FriendsTransmissionRequest requestStorage =
                FriendsTransmissionRequest.newBuilder()
                        .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
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
        response = blockingStub.deleteFileInformationWithFriend(requestStorage);
        if(ConstantsContent.FILE_PROTECT_SUCCESS.equals(response.getFriendsPictureVideoMessage().getHead().getStatusReport())){
            //文件下载成功后，删除数据库中的存储记录
            System.out.println("文件下载成功后，删除数据库中的存储记录");
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
                System.out.println("文件下载成功后，删除文件服务器上的文件.");
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

    public boolean storageFileIsSuccessFulWithGroup(GroupTransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GroupTransmissionResponse response = null;
        //调用文件交互服务器，删除对应文件
        OriginalPictureVideoGroupTransmission groupPictureVideoMessage = request.getGroupPictureVideoMessage();
        String userType = groupPictureVideoMessage.getUserType();
        String settingsType = groupPictureVideoMessage.getSettingsType();
        String serverUrl = groupPictureVideoMessage.getFileContent().getBigFileHead().getServerUrl();
        String groupId = groupPictureVideoMessage.getGroup().getGroupId();
        String groupMemberId = groupPictureVideoMessage.getGroupMember().getGroupMemberId();
        String userId = groupPictureVideoMessage.getTourists().getTemporaryId();
        String registeredUserId = groupPictureVideoMessage.getRegisteredUser().getUserId();
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
        response = blockingStub.storageFileInformationWithGroup(requestStorage);
        if(ConstantsContent.FILE_PROTECT_SUCCESS.equals(response.getGroupPictureVideoMessage().getHead().getStatusReport())){
            //存储上传文件记录到数据库中----群
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
