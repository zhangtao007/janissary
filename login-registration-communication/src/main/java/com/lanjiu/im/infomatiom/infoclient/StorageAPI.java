package com.lanjiu.im.infomatiom.infoclient;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.infomatiom.*;
import org.apache.log4j.Logger;

public class StorageAPI {

    private static final Logger logger = Logger.getLogger(StorageAPI.class.getName());


    /**
     * 删除游客所有资料
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    public AllGroupsMemberResponse deleteGuestAllInfoAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        AllGroupsMemberResponse response = linkTransferCommunication.deleteGuestRelatedAllInfo(request);
        return response;
    }

    /**
     * 获取用户好友的群id
     */
    public AllGroupsMemberResponse searchAllGroupByUserId(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        AllGroupsMemberResponse response = linkTransferCommunication.searchAllGroupByUserId(request);
        return response;
    }

    /**
     * 查询用户参与群的所有相关人
     */
    public AllGroupsMemberResponse queryGroupMembersInfoList(SelectGroupMemberRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        AllGroupsMemberResponse response = linkTransferCommunication.queryGroupMembersInfoList(request);
        return response;
    }

    /**
     * 好友列表
     */
    public RegisteredUserFriendResponse  selectRegisteredUserFriend(TransmissionRequest request){
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        RegisteredUserFriendResponse response = linkTransferCommunication.selectRegisteredUserFriend(request);
        return response;
    }
}