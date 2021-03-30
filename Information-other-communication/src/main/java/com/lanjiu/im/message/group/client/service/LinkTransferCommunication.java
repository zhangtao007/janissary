package com.lanjiu.im.message.group.client.service;

import com.lanjiu.im.storage.*;

public class LinkTransferCommunication {

    private static MessageGroupStorageServiceGrpc.MessageGroupStorageServiceBlockingStub blockingStub = null;

    public static MessageGroupStorageServiceGrpc.MessageGroupStorageServiceBlockingStub linkTransferCommunication(){
        MessageGroupStorageServiceGrpc.MessageGroupStorageServiceBlockingStub stub = MessageGroupStorageClient.linkTransferCommunication(blockingStub);
        return stub;
    }

    //online
    public OnGroupMessageTransmissionResponse selectMessageGroupInformationWithGroupOn(OnGroupMessageTransmissionRequest request){
        blockingStub = linkTransferCommunication();
        OnGroupMessageTransmissionResponse response = null;
        response = blockingStub.selectMessageGroupInformationWithGroupOn(request);
        try {
            MessageGroupStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    //online
    public OnGroupMessageTransmissionResponse storageMessageGroupInformationWithGroupOn(OnGroupMessageTransmissionRequest request){
        blockingStub = linkTransferCommunication();
        OnGroupMessageTransmissionResponse response = null;
        response = blockingStub.storageMessageGroupInformationWithGroupOn(request);
        try {
            MessageGroupStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    //online
    public OnGroupMessageTransmissionResponse deleteMessageGroupInformationWithGroupOn(OnGroupMessageTransmissionRequest request){
        blockingStub = linkTransferCommunication();
        OnGroupMessageTransmissionResponse response = null;
        response = blockingStub.deleteMessageGroupInformationWithGroupOn(request);
        try {
            MessageGroupStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    //online
    public OnGroupMessageTransmissionResponse updateMessageGroupInformationWithGroupOn(OnGroupMessageTransmissionRequest request){
        blockingStub = linkTransferCommunication();
        OnGroupMessageTransmissionResponse response = null;
        response = blockingStub.updateMessageGroupInformationWithGroupOn(request);
        try {
            MessageGroupStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }


    //----------------------off------------------------------------

    //offline
    public OffGroupMessageTransmissionResponse selectMessageGroupInformationWithGroupOff(OffGroupMessageTransmissionRequest request){
        blockingStub = linkTransferCommunication();
        OffGroupMessageTransmissionResponse response = null;
        response = blockingStub.selectMessageGroupInformationWithGroupOff(request);
        try {
            MessageGroupStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    //offline
    public OffGroupMessageTransmissionResponse storageMessageGroupInformationWithGroupOff(OffGroupMessageTransmissionRequest request){
        blockingStub = linkTransferCommunication();
        OffGroupMessageTransmissionResponse response = null;
        response = blockingStub.storageMessageGroupInformationWithGroupOff(request);
        try {
            MessageGroupStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    //offline
    public OffGroupMessageTransmissionResponse deleteMessageGroupInformationWithGroupOff(OffGroupMessageTransmissionRequest request){
        blockingStub = linkTransferCommunication();
        OffGroupMessageTransmissionResponse response = null;
        response = blockingStub.deleteMessageGroupInformationWithGroupOff(request);
        try {
            MessageGroupStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    //offline
    public OffGroupMessageTransmissionResponse updateMessageGroupInformationWithGroupOff(OffGroupMessageTransmissionRequest request){
        blockingStub = linkTransferCommunication();
        OffGroupMessageTransmissionResponse response = null;
        response = blockingStub.updateMessageGroupInformationWithGroupOff(request);
        try {
            MessageGroupStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }




}
