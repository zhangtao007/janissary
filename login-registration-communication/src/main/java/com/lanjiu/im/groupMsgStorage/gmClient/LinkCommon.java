package com.lanjiu.im.groupMsgStorage.gmClient;

import com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest;
import com.lanjiu.pro.groupStorage.MessageGroupStorageServiceGrpc;
import com.lanjiu.pro.groupStorage.ResponseResult;

public class LinkCommon {

    private static MessageGroupStorageServiceGrpc.MessageGroupStorageServiceBlockingStub  blockingStub = null;

    public static MessageGroupStorageServiceGrpc.MessageGroupStorageServiceBlockingStub  linkTransferCommunication(){
        MessageGroupStorageServiceGrpc.MessageGroupStorageServiceBlockingStub  stub = GroupMessageClient.transformStorageCommunition(blockingStub);
        return stub;
    }


    public ResponseResult deleteGroupMembersOffLineMsg(DeleteGroupMembersMsgRequest request) {
        blockingStub = linkTransferCommunication();
        ResponseResult response = null;
        response = blockingStub.deleteGroupMembersOffLineMsg(request);
        try {
            GroupMessageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }
}
