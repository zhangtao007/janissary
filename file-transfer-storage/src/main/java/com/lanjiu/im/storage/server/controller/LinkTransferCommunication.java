package com.lanjiu.im.storage.server.controller;

import com.lanjiu.im.grpc.client.TransferCommunicationClient;
import com.lanjiu.im.storage.util.ConstantsContent;
import com.lanjiu.pro.file.*;

public class LinkTransferCommunication {

    public FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub linkTransferCommunication(){
        FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub stub = TransferCommunicationClient.linkTransferCommunication();
        return stub;
    }

    public boolean deleteFileIsSuccessFulWithFriends(String serverUrl){
        FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub grpcStub = linkTransferCommunication();
        FriendsTransmissionRequest friendsTransmissionRequest = null;
        FriendsTransmissionResponse response = null;
        friendsTransmissionRequest = FriendsTransmissionRequest.newBuilder()
                .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
                        .setFileContent(
                                FileContent.newBuilder().setBigFileHead(
                                        BigFileHead.newBuilder()
                                                .setServerUrl(serverUrl)
                                                .build())
                                        .build())
                        .build())
                .build();
        //调用文件交互服务器，删除对应文件
        response = grpcStub.friendsTransmissionFileDeleteForStorageServer(friendsTransmissionRequest);
        if(ConstantsContent.FILE_DELETE_SUCCESS.equals(response.getFriendsPictureVideoMessage().getHead().getStatusReport())){
            //文件服务器上的文件删除成功时，删除数据库中记录
            try {
                TransferCommunicationClient.shutdownNow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
        try {
            TransferCommunicationClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteFileIsSuccessFulWithGroup(String serverUrl){
        FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub grpcStub = linkTransferCommunication();
        GroupTransmissionRequest groupTransmissionRequest = null;
        GroupTransmissionResponse response = null;
        groupTransmissionRequest = GroupTransmissionRequest.newBuilder()
                .setGroupPictureVideoMessage(OriginalPictureVideoGroupTransmission.newBuilder()
                        .setFileContent(
                                FileContent.newBuilder().setBigFileHead(
                                        BigFileHead.newBuilder()
                                                .setServerUrl(serverUrl)
                                                .build())
                                        .build())
                        .build())
                .build();
        //调用文件交互服务器，删除对应文件
        response = grpcStub.groupTransmissionFileDeleteForStorageServer(groupTransmissionRequest);
        if(ConstantsContent.FILE_DELETE_SUCCESS.equals(response.getGroupPictureVideoMessage().getHead().getStatusReport())){
            //文件服务器上的文件删除成功时，删除数据库中记录
            try {
                TransferCommunicationClient.shutdownNow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
        try {
            TransferCommunicationClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
