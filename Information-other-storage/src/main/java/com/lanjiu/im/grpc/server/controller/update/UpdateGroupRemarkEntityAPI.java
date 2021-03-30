package com.lanjiu.im.grpc.server.controller.update;

import com.lanjiu.im.grpc.GroupRemarkResponse;
import com.lanjiu.im.grpc.RpcGroupRemark;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.pojo.GroupRemark;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.log4j.Logger;


public class UpdateGroupRemarkEntityAPI {

    private static final Logger logger = Logger.getLogger(UpdateGroupRemarkEntityAPI.class.getName());

    public GroupRemarkResponse updateGroupRemark(TransmissionRequest request){
        RpcGroupRemark rpcGroupRemark = request.getGroupRemark();
        UpdateGroupRemarkServiceAPI guestGroupUpdateServiceAPI = new UpdateGroupRemarkServiceAPI();
        GroupRemark groupRemark = guestGroupUpdateServiceAPI.updateGroupRemark(rpcGroupRemark);
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
