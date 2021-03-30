package com.lanjiu.im.grpc.client.infomation;


import com.lanjiu.im.grpc.InformationStorageProto;
import com.lanjiu.im.grpc.InformationStorageServiceGrpc;

public class LinkTransferCommunication {

    private static InformationStorageServiceGrpc.InformationStorageServiceBlockingStub blockingStub = null;

    public static InformationStorageServiceGrpc.InformationStorageServiceBlockingStub linkTransferCommunication(){
        InformationStorageServiceGrpc.InformationStorageServiceBlockingStub stub = InformationStorageClient.linkTransferCommunication(blockingStub);
        return stub;
    }




    public InformationStorageProto.RpcRegisteredUserFriend queryUserFriendRelation(InformationStorageProto.TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        InformationStorageProto.RpcRegisteredUserFriend response = null;
        response = blockingStub.queryUserFriendRelation(request);
        try {
            InformationStorageClient.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }



    public InformationStorageProto.AllGroupsMemberResponse deleteGuestRelatedAllInfo(InformationStorageProto.TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        InformationStorageProto.AllGroupsMemberResponse response = null;
        response = blockingStub.deleteGuestRelatedAllInfo(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }
}
