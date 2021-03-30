package com.lanjiu.im.grpc.server.controller;


public class LinkTransferCommunication {

//    public FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub linkTransferCommunication(){
//        FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub stub = TransferCommunicationClient.linkTransferCommunication();
//        return stub;
//    }
//
//    public boolean deleteFileIsSuccessFulWithFriends(String serverUrl){
//        FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub grpcStub = linkTransferCommunication();
//        com.lanjiu.im.grpc.FriendsTransmissionRequest friendsTransmissionRequest = null;
//        com.lanjiu.im.grpc.FriendsTransmissionResponse response = null;
//        friendsTransmissionRequest = com.lanjiu.im.grpc.FriendsTransmissionRequest.newBuilder()
//                .setFriendsPictureVideoMessage(com.lanjiu.im.grpc.OriginalPictureVideoFriendsTransmission.newBuilder()
//                        .setFileContent(
//                                com.lanjiu.im.grpc.FileContent.newBuilder().setBigFileHead(
//                                        com.lanjiu.im.grpc.BigFileHead.newBuilder()
//                                                .setServerUrl(serverUrl)
//                                                .build())
//                                        .build())
//                        .build())
//                .build();
//        //调用文件交互服务器，删除对应文件
//        response = grpcStub.friendsTransmissionFileDeleteForStorageServer(friendsTransmissionRequest);
//        if(ConstantsContent.FILE_DELETE_SUCCESS.equals(response.getFriendsPictureVideoMessage().getHead().getStatusReport())){
//            //文件服务器上的文件删除成功时，删除数据库中记录
//            try {
//                TransferCommunicationClient.shutdownNow();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return true;
//        }
//        try {
//            TransferCommunicationClient.shutdownNow();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public boolean deleteFileIsSuccessFulWithGroup(String serverUrl){
//        FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub grpcStub = linkTransferCommunication();
//        com.lanjiu.im.grpc.GroupTransmissionRequest groupTransmissionRequest = null;
//        com.lanjiu.im.grpc.GroupTransmissionResponse response = null;
//        groupTransmissionRequest = com.lanjiu.im.grpc.GroupTransmissionRequest.newBuilder()
//                .setGroupPictureVideoMessage(com.lanjiu.im.grpc.OriginalPictureVideoGroupTransmission.newBuilder()
//                        .setFileContent(
//                                com.lanjiu.im.grpc.FileContent.newBuilder().setBigFileHead(
//                                        com.lanjiu.im.grpc.BigFileHead.newBuilder()
//                                                .setServerUrl(serverUrl)
//                                                .build())
//                                        .build())
//                        .build())
//                .build();
//        //调用文件交互服务器，删除对应文件
//        response = grpcStub.groupTransmissionFileDeleteForStorageServer(groupTransmissionRequest);
//        if(ConstantsContent.FILE_DELETE_SUCCESS.equals(response.getGroupPictureVideoMessage().getHead().getStatusReport())){
//            //文件服务器上的文件删除成功时，删除数据库中记录
//            try {
//                TransferCommunicationClient.shutdownNow();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return true;
//        }
//        try {
//            TransferCommunicationClient.shutdownNow();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
}
