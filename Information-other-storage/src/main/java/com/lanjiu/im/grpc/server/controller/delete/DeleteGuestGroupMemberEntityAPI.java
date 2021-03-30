package com.lanjiu.im.grpc.server.controller.delete;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.pojo.GuestGroupMember;
import com.lanjiu.im.grpc.server.controller.create.GuestGroupMemberGuestGroupServiceAPI;
import com.lanjiu.im.grpc.server.controller.create.GuestGroupMemberRegisteredGroupServiceAPI;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.log4j.Logger;


public class DeleteGuestGroupMemberEntityAPI {

    private static final Logger logger = Logger.getLogger(DeleteGuestGroupMemberEntityAPI.class.getName());

    public GuestGroupMemberResponse deleteGuestGroupMember(TransmissionRequest request){
        GuestGroupMemberResponse guestGroupMemberResponse = null;
        RpcGuestGroup rpcGuestGroup = request.getGuestGroup();
        String kind = request.getRequestKind();
        RpcRegisteredGroup rpcRegisteredGroup = request.getRegisteredGroup();
        RpcGuestGroupMember rpcGuestGroupMember = request.getGuestGroupMember();
        DeleteGuestGroupMemberServiceAPI guestGroupMemberService = new DeleteGuestGroupMemberServiceAPI();
        GuestGroupMember guestGroupMember = guestGroupMemberService.deleteGuestGroupMember(rpcGuestGroupMember, kind);
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
