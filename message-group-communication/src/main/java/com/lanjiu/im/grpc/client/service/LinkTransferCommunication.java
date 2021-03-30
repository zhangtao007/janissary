package com.lanjiu.im.grpc.client.service;

import com.lanjiu.im.grpc.*;

public class LinkTransferCommunication {

    private static InformationStorageServiceGrpc.InformationStorageServiceBlockingStub blockingStub = null;

    public static InformationStorageServiceGrpc.InformationStorageServiceBlockingStub linkTransferCommunication(){
        InformationStorageServiceGrpc.InformationStorageServiceBlockingStub stub = InformationStorageClient.linkTransferCommunication(blockingStub);
        return stub;
    }

    public AllGroupsMemberResponse selectGroupMembers(SelectGroupMemberRequest request){
        blockingStub = linkTransferCommunication();
        AllGroupsMemberResponse response =  blockingStub.queryGroupMembersInfoList(request);
        try {
            InformationStorageClient.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

}
