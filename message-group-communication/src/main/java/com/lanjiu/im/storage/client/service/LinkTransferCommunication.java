package com.lanjiu.im.storage.client.service;


import com.lanjiu.pro.groupStorage.*;

import java.util.logging.Logger;

public class LinkTransferCommunication {

    private static final Logger log = Logger.getLogger(LinkTransferCommunication.class.getName());

    private static MessageGroupStorageServiceGrpc.MessageGroupStorageServiceBlockingStub getInstance(){
        return MessageGroupStorageClient.linkTransferCommunication();
    }

    public ResponseResult saveGroupMassage(GroupMsgOffLineRequest request) {
        ResponseResult responseResult = getInstance().saveGroupMassage(request);
        try {
            MessageGroupStorageClient.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return responseResult;
    }

    public ResponseResult saveGroupMembersOffLineMsg(GroupMsgOffLineRequest request) {
        ResponseResult responseResult = getInstance().saveGroupMembersOffLineMsg(request);
        try {
            MessageGroupStorageClient.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return responseResult;
    }

    public ResponseResult selectOffLineGroupMsg(SelectOffLineGroupMsgRequest request) {
        ResponseResult responseResult = getInstance().selectOffLineGroupMsg(request);
        try {
            MessageGroupStorageClient.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return responseResult;
    }

    public void deleteSendOffLineMsg(DeleteGroupMembersMsgRequest request) {
        ResponseResult responseResult = getInstance().deleteSendOffLineMsg(request);
        try {

            MessageGroupStorageClient.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("拉取离线消息后删除离线消息响应结果：" + responseResult);
    }

    public ResponseResult deleteGroupMsg(GroupMsgOffLineRequest request) {
        ResponseResult responseResult = getInstance().deleteGroupMsg(request);
        try {
            MessageGroupStorageClient.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("主动删除离线消息响应结果：" + responseResult);
        return responseResult;
    }

    public ResponseCount selectOffLineGroupMsgCount(SelectOffLineGroupMsgRequest request) {
        ResponseCount responseCount = getInstance().selectOffLineGroupMsgCount(request);
        try {
            MessageGroupStorageClient.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("查询离线消息总数结果：" + responseCount);
        return responseCount;
    }

    public void groupOwnerExit(DeleteGroupMembersMsgRequest request) {
        ResponseResult responseResult = getInstance().groupOwnerExit(request);
        try {
            MessageGroupStorageClient.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("群成员、群主退群响应结果：" + responseResult);
    }

    public com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse groupAudioAndVideoCall(com.lanjiu.pro.groupStorage.GroupAudioVideoCallRequest request) {
        GroupAudioVideoCallResponse response = getInstance().groupAudioAndVideoCall(request);
        try {
            MessageGroupStorageClient.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }
}
