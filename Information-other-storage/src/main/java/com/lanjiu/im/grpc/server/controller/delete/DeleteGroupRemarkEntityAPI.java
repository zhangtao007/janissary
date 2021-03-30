package com.lanjiu.im.grpc.server.controller.delete;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.pojo.GroupRemark;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.log4j.Logger;


public class DeleteGroupRemarkEntityAPI {

    private static final Logger logger = Logger.getLogger(DeleteGroupRemarkEntityAPI.class.getName());

    public GroupRemarkResponse deleteGroupRemark(TransmissionRequest request){
        RpcGroupRemark rpcGroupRemark = request.getGroupRemark();
        String kind = request.getRequestKind();
        DeleteGroupRemarkServiceAPI guestUserFriendService = new DeleteGroupRemarkServiceAPI();
        GroupRemark groupRemark = guestUserFriendService.deleteGroupRemark(rpcGroupRemark, kind);
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

    public AllGroupsMemberResponse deleteMembersByGroupOwner(TransmissionRequest request){
        DeleteGroupRemarkServiceAPI guestUserFriendService = new DeleteGroupRemarkServiceAPI();
        return guestUserFriendService.deleteMembersByGroupOwner(request);
    }

    public AllGroupsMemberResponse groupMemberExitGroupChat(TransmissionRequest request){
        DeleteGroupRemarkServiceAPI guestUserFriendService = new DeleteGroupRemarkServiceAPI();
        return guestUserFriendService.groupMemberExitGroupChat(request);
    }
}
