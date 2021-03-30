package com.lanjiu.im.grpc.server.controller.delete;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.pojo.RegisteredGroup;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.log4j.Logger;


public class DeleteRegisteredGroupEntityAPI {

    private static final Logger logger = Logger.getLogger(DeleteRegisteredGroupEntityAPI.class.getName());

    public RegisteredGroupResponse deleteRegisteredGroup(TransmissionRequest request){
        RpcRegisteredGroup rpcRegisteredGroup = request.getRegisteredGroup();
        String kind = request.getRequestKind();
        DeleteRegisteredGroupServiceAPI guestGroupService = new DeleteRegisteredGroupServiceAPI();
        RegisteredGroup guestGroup = guestGroupService.deleteRegisteredGroup(rpcRegisteredGroup, kind);
        if(null == guestGroup){
            return null;
        }
        RegisteredGroupResponse guestGroupResponse = RegisteredGroupResponse.newBuilder()
                .addResponseRegisteredGroup(RpcRegisteredGroup.newBuilder()
                        .setCreationTime(guestGroup.getCreationTime().getTime())
                        .setGroupName(guestGroup.getGroupName())
                        .setAmount(guestGroup.getAmount())
                        .setModificationTime(guestGroup.getModificationTime().getTime())
                        .setGroupId(guestGroup.getGroupId())
                        .setGroupAnnouncementId(guestGroup.getGroupAnnouncementId())
                        .setRegisteredUserId(guestGroup.getRegisteredUserId())
                        .build())
                        .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        return guestGroupResponse;
    }
}
