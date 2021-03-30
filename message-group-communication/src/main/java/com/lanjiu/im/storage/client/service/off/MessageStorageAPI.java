package com.lanjiu.im.storage.client.service.off;

import com.lanjiu.im.storage.client.service.LinkTransferCommunication;
import com.lanjiu.pro.groupStorage.*;
import org.apache.log4j.Logger;

public class MessageStorageAPI {

    private static final Logger log = Logger.getLogger(MessageStorageAPI.class.getName());

    public ResponseResult selectOffLineGroupMsg(SelectOffLineGroupMsgRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.selectOffLineGroupMsg(request);
    }

    public ResponseResult saveGroupMassage(GroupMsgOffLineRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.saveGroupMassage(request);
    }

    public ResponseResult saveGroupMembersOffLineMsg(GroupMsgOffLineRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.saveGroupMembersOffLineMsg(request);
    }

    public void deleteSendOffLineMsg(DeleteGroupMembersMsgRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        linkTransferCommunication.deleteSendOffLineMsg(request);
    }

    public ResponseResult deleteGroupMsg(GroupMsgOffLineRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.deleteGroupMsg(request);
    }

    public ResponseCount selectOffLineGroupMsgCount(SelectOffLineGroupMsgRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.selectOffLineGroupMsgCount(request);
    }

    public void groupOwnerExit(DeleteGroupMembersMsgRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        linkTransferCommunication.groupOwnerExit(request);
    }

    public GroupAudioVideoCallResponse  groupAudioAndVideoCall(GroupAudioVideoCallRequest  request){
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.groupAudioAndVideoCall(request);
    }
}
