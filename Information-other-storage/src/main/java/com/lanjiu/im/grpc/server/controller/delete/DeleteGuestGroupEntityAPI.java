package com.lanjiu.im.grpc.server.controller.delete;

import com.lanjiu.im.grpc.GuestGroupResponse;
import com.lanjiu.im.grpc.RpcGuestGroup;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.pojo.GuestGroup;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.log4j.Logger;


public class DeleteGuestGroupEntityAPI {

    private static final Logger logger = Logger.getLogger(DeleteGuestGroupEntityAPI.class.getName());

    public GuestGroupResponse deleteGuestGroup(TransmissionRequest request){
        RpcGuestGroup rpcGuestGroup = request.getGuestGroup();
        String kind = request.getRequestKind();
        DeleteGuestGroupServiceAPI guestGroupService = new DeleteGuestGroupServiceAPI();
        GuestGroup guestGroup = guestGroupService.deleteGuestGroup(rpcGuestGroup, kind);
        if(null == guestGroup){
            return null;
        }
        GuestGroupResponse guestGroupResponse = GuestGroupResponse.newBuilder()
                .addResponseGuestGroup(RpcGuestGroup.newBuilder()
                        .setCreationTime(guestGroup.getCreationTime().getTime())
                        .setGroupName(guestGroup.getGroupName())
                        .setAmount(guestGroup.getAmount())
                        .setModificationTime(guestGroup.getModificationTime().getTime())
                        .setGroupId(guestGroup.getGroupId())
                        .setGroupAnnouncementId(guestGroup.getGroupAnnouncementId())
                        .setGuestUserId(guestGroup.getGuestUserId())
                        .build())
                        .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        return guestGroupResponse;
    }
}
