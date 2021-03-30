package com.lanjiu.im.infomatiom.infoclient;

import com.lanjiu.im.grpc.*;

public class LinkTransferCommunication {

    private static InformationStorageServiceGrpc.InformationStorageServiceBlockingStub blockingStub = null;

    public static InformationStorageServiceGrpc.InformationStorageServiceBlockingStub linkTransferCommunication(){
        InformationStorageServiceGrpc.InformationStorageServiceBlockingStub stub = InformationStorageClient.linkTransferCommunication(blockingStub);
        return stub;
    }

    public AllGroupsMemberResponse deleteGuestRelatedAllInfo(TransmissionRequest request) {
        blockingStub = linkTransferCommunication();
        AllGroupsMemberResponse response = null;
        response = blockingStub.deleteGuestRelatedAllInfo(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public com.lanjiu.im.grpc.AllGroupsMemberResponse searchAllGroupByUserId(com.lanjiu.im.grpc.TransmissionRequest request) {
        blockingStub = linkTransferCommunication();
        AllGroupsMemberResponse response = null;
        response = blockingStub.searchAllGroupByUserId(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public com.lanjiu.im.grpc.AllGroupsMemberResponse queryGroupMembersInfoList(com.lanjiu.im.grpc.SelectGroupMemberRequest request) {
        blockingStub = linkTransferCommunication();
        AllGroupsMemberResponse response = null;
        response = blockingStub.queryGroupMembersInfoList(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public RegisteredUserFriendResponse selectRegisteredUserFriend(com.lanjiu.im.grpc.TransmissionRequest request) {
        blockingStub = linkTransferCommunication();
        RegisteredUserFriendResponse response = null;
        response = blockingStub.selectRegisteredUserFriend(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }


}
