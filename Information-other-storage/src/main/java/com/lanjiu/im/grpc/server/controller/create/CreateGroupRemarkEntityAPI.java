package com.lanjiu.im.grpc.server.controller.create;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.pojo.GroupRemark;
import com.lanjiu.im.grpc.pojo.RegisteredUserFriend;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.log4j.Logger;


public class CreateGroupRemarkEntityAPI {

    private static final Logger logger = Logger.getLogger(CreateGroupRemarkEntityAPI.class.getName());

    public GroupRemarkResponse createGroupRemark(TransmissionRequest request){
        RpcGroupRemark rpcGroupRemark = request.getGroupRemark();
        GroupRemarkServiceAPI guestUserFriendService = new GroupRemarkServiceAPI();
        GroupRemark groupRemark = guestUserFriendService.createGroupRemark(rpcGroupRemark);
        if(null == groupRemark){
            return null;
        }
        GroupRemarkResponse registeredUserFriendResponse = GroupRemarkResponse.newBuilder()
                .addResponseData(RpcGroupRemark.newBuilder()
                        .setGroupId(groupRemark.getGroupId())
                        .setGroupMemberId(groupRemark.getGroupMemberId())
                        .setGroupMemberIdRemarked(groupRemark.getGroupMemberIdRemarked())
                        .setRemark(groupRemark.getRemark())
                        .build())
                        .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        return registeredUserFriendResponse;
    }
}
