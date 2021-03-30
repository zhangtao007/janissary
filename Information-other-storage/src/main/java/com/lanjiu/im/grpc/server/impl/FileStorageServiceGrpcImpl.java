package com.lanjiu.im.grpc.server.impl;

import com.lanjiu.im.grpc.*;
import io.grpc.stub.StreamObserver;

public class FileStorageServiceGrpcImpl extends FileStorageServiceGrpc.FileStorageServiceImplBase {

    /**
     * 存储记录
     */
    @Override
    public void storageFileInformationWithFriend(FriendsTransmissionRequest request, StreamObserver<FriendsTransmissionResponse> responseObserver) {

        System.out.println("存储上传文件记录到数据库中----好友");
        OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission = request.getFriendsPictureVideoMessage();
        String userType = originalPictureVideoFriendsTransmission.getUserType();
        String settingsType = originalPictureVideoFriendsTransmission.getSettingsType();
//        StorageController storageController = new StorageController();
//        int result = storageController.storageControllerFriend(userType, settingsType, originalPictureVideoFriendsTransmission);
//        System.out.println("result:" +result);
//        if (result > 0){
//            FriendsTransmissionResponse friendsTransmissionResponse = FriendsTransmissionResponse.newBuilder()
//                    .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
//                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_PROTECT_SUCCESS).build()))
//                    .build();
//            responseObserver.onNext(friendsTransmissionResponse);
//            responseObserver.onCompleted();
//        }else {
//            FriendsTransmissionResponse friendsTransmissionResponse = FriendsTransmissionResponse.newBuilder()
//                    .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
//                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_PROTECT__FAILURE).build()))
//                    .build();
//            responseObserver.onNext(friendsTransmissionResponse);
//            responseObserver.onCompleted();
//        }

    }

    /**
     * 存储记录
     */
    @Override
    public void storageFileInformationWithGroup(GroupTransmissionRequest request, StreamObserver<GroupTransmissionResponse> responseObserver) {
        System.out.println("存储上传文件记录到数据库中----群");
        OriginalPictureVideoGroupTransmission originalPictureVideoGroupTransmission = request.getGroupPictureVideoMessage();
        String userType = originalPictureVideoGroupTransmission.getUserType();
        String settingsType = originalPictureVideoGroupTransmission.getSettingsType();
//        StorageController storageController = new StorageController();
//        int result = storageController.storageControllerGroup(userType, settingsType, originalPictureVideoGroupTransmission);
//        System.out.println("result:" +result);
//        if(result > 0){
//            GroupTransmissionResponse groupTransmissionResponse = GroupTransmissionResponse.newBuilder()
//                    .setGroupPictureVideoMessage(OriginalPictureVideoGroupTransmission.newBuilder()
//                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_PROTECT_SUCCESS).build()))
//                    .build();
//            responseObserver.onNext(groupTransmissionResponse);
//            responseObserver.onCompleted();
//        }else {
//            GroupTransmissionResponse groupTransmissionResponse = GroupTransmissionResponse.newBuilder()
//                    .setGroupPictureVideoMessage(OriginalPictureVideoGroupTransmission.newBuilder()
//                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_PROTECT__FAILURE).build()))
//                    .build();
//            responseObserver.onNext(groupTransmissionResponse);
//            responseObserver.onCompleted();
//        }

    }

    /**
     * 删除好友上传的记录------>以文件路径删除
     */
    @Override
    public void deleteFileInformationWithFriend(FriendsTransmissionRequest request, StreamObserver<FriendsTransmissionResponse> responseObserver) {
        System.out.println("文件下载成功后，删除数据库中的存储记录----好友");
        OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission = request.getFriendsPictureVideoMessage();
        String userType = originalPictureVideoFriendsTransmission.getUserType();
        String settingsType = originalPictureVideoFriendsTransmission.getSettingsType();
//        StorageController storageController = new StorageController();
//        boolean bResult = storageController.deleteControllerFriend(userType, settingsType, originalPictureVideoFriendsTransmission);
//        if(bResult){
//            FriendsTransmissionResponse friendsTransmissionResponse = FriendsTransmissionResponse.newBuilder()
//                    .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
//                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_DELETE_SUCCESS).build()))
//                    .build();
//            responseObserver.onNext(friendsTransmissionResponse);
//            responseObserver.onCompleted();
//        }else {
//            FriendsTransmissionResponse friendsTransmissionResponse = FriendsTransmissionResponse.newBuilder()
//                    .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
//                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_DELETE__FAILURE).build()))
//                    .build();
//            responseObserver.onNext(friendsTransmissionResponse);
//            responseObserver.onCompleted();
//        }
    }

    /**
     * 删除群存储记录------>以文件路径删除   //其他服务器调用-----------非文件服务器
     */
    @Override
    public void deleteFileInformationWithGroup(GroupTransmissionRequest request, StreamObserver<GroupTransmissionResponse> responseObserver) {

        OriginalPictureVideoGroupTransmission originalPictureVideoGroupTransmission = request.getGroupPictureVideoMessage();
        String userType = originalPictureVideoGroupTransmission.getUserType();
        String settingsType = originalPictureVideoGroupTransmission.getSettingsType();
//        StorageController storageController = new StorageController();
//        boolean bResult = storageController.deleteControllerGroup(userType, settingsType, originalPictureVideoGroupTransmission);
//        if(bResult){
//            GroupTransmissionResponse groupTransmissionResponse = GroupTransmissionResponse.newBuilder()
//                    .setGroupPictureVideoMessage(OriginalPictureVideoGroupTransmission.newBuilder()
//                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_DELETE_SUCCESS).build()))
//                    .build();
//            responseObserver.onNext(groupTransmissionResponse);
//            responseObserver.onCompleted();
//        }
//        else {
//            GroupTransmissionResponse groupTransmissionResponse = GroupTransmissionResponse.newBuilder()
//                    .setGroupPictureVideoMessage(OriginalPictureVideoGroupTransmission.newBuilder()
//                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_DELETE__FAILURE).build()))
//                    .build();
//            responseObserver.onNext(groupTransmissionResponse);
//            responseObserver.onCompleted();
//        }

    }

    /**
     * 删除好友上传的记录------>以好友id删除 //其他服务器调用-----------非文件服务器
     */
    @Override
    public void deleteFileInformationWithFriendByFriendId(FriendsTransmissionRequest request, StreamObserver<FriendsTransmissionResponse> responseObserver) {

        OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission = request.getFriendsPictureVideoMessage();
        String userType = originalPictureVideoFriendsTransmission.getUserType();
        String settingsType = originalPictureVideoFriendsTransmission.getSettingsType();
//        StorageController storageController = new StorageController();
//        boolean bResult = storageController.deleteControllerFriendByFriendId(userType, settingsType, originalPictureVideoFriendsTransmission);
//        if(bResult){
//            FriendsTransmissionResponse friendsTransmissionResponse = FriendsTransmissionResponse.newBuilder()
//                    .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
//                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_DELETE_SUCCESS).build()))
//                    .build();
//            responseObserver.onNext(friendsTransmissionResponse);
//            responseObserver.onCompleted();
//        }else {
//            FriendsTransmissionResponse friendsTransmissionResponse = FriendsTransmissionResponse.newBuilder()
//                    .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
//                            .setHead(Head.newBuilder().setStatusReport(ConstantsContent.FILE_DELETE__FAILURE).build()))
//                    .build();
//            responseObserver.onNext(friendsTransmissionResponse);
//            responseObserver.onCompleted();
//        }
    }
}
