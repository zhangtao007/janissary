package com.lanjiu.im.grpc.server.controller.update;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.pojo.GuestGroupMember;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.log4j.Logger;


public class UpdateGuestGroupMemberEntityAPI {

    private static final Logger logger = Logger.getLogger(UpdateGuestGroupMemberEntityAPI.class.getName());

    public GuestGroupMemberResponse updateGuestGroupMember(TransmissionRequest request){
        GuestGroupMemberResponse guestGroupMemberResponse = null;
        RpcGuestGroup rpcGuestGroup = request.getGuestGroup();
        RpcRegisteredGroup rpcRegisteredGroup = request.getRegisteredGroup();
        RpcGuestGroupMember rpcGuestGroupMember = request.getGuestGroupMember();
        UpdateGuestGroupMemberServiceAPI guestGroupMemberService = new UpdateGuestGroupMemberServiceAPI();
        GuestGroupMember guestGroupMember = guestGroupMemberService.updateGuestGroupMember(rpcGuestGroupMember);
        if(null == guestGroupMember){
            return null;
        }
        guestGroupMemberResponse = GuestGroupMemberResponse.newBuilder()
                .addResponseData(RpcGuestGroupMember.newBuilder()
                        .setGroupMemberId(guestGroupMember.getGroupMemberId())
                        .setGuestUserId(guestGroupMember.getGuestUserId())
                        .setGroupRemarks(guestGroupMember.getGroupRemarks())
                        .setGroupOwner(guestGroupMember.getGroupOwner())
                        .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                        .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                        .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                        .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                        .build())
                .addRegisteredGroupData(rpcRegisteredGroup)
                .addGuestGroupData(rpcGuestGroup)
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();

        return guestGroupMemberResponse;
    }
}
