package com.lanjiu.im.grpc.server.controller.update;

import com.lanjiu.im.grpc.GuestGroupResponse;
import com.lanjiu.im.grpc.RpcGuestGroup;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.pojo.GuestGroup;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.log4j.Logger;


public class UpdateGuestGroupEntityAPI {

    private static final Logger logger = Logger.getLogger(UpdateGuestGroupEntityAPI.class.getName());

    public GuestGroupResponse updateGuestGroup(TransmissionRequest request){
        RpcGuestGroup rpcGuestGroup = request.getGuestGroup();
        UpdateGuestGroupServiceAPI guestGroupService = new UpdateGuestGroupServiceAPI();
        GuestGroup guestGroup = guestGroupService.updateGuestGroup(rpcGuestGroup);
        if(null == guestGroup){
            return null;
        }
        GuestGroupResponse guestGroupResponse = GuestGroupResponse.newBuilder()
                .addResponseGuestGroup(RpcGuestGroup.newBuilder()
                        .setGroupName(guestGroup.getGroupName())
                        .setModificationTime(guestGroup.getModificationTime().getTime())
                        .setGroupId(guestGroup.getGroupId())
                        .setGuestUserId(guestGroup.getGuestUserId())
                        .build())
                        .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                        .build();
        return guestGroupResponse;
    }
}
