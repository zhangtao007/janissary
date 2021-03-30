package com.lanjiu.im.grpc.server.controller.delete;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.pojo.GuestGroupMember;
import com.lanjiu.im.grpc.pojo.RegisteredGroupMember;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.log4j.Logger;


public class DeleteRegisteredGroupMemberEntityAPI {

    private static final Logger logger = Logger.getLogger(DeleteRegisteredGroupMemberEntityAPI.class.getName());

    public RegisteredGroupMemberResponse deleteRegisteredGroupMember(TransmissionRequest request){
        RegisteredGroupMemberResponse guestGroupMemberResponse = null;
        RpcGuestGroup rpcGuestGroup = request.getGuestGroup();
        String kind = request.getRequestKind();
        RpcRegisteredGroup rpcRegisteredGroup = request.getRegisteredGroup();
        RpcRegisteredGroupMember rpcRegisteredGroupMember = request.getRegisteredGroupMember();
        DeleteRegisteredGroupMemberServiceAPI guestGroupMemberService = new DeleteRegisteredGroupMemberServiceAPI();
        RegisteredGroupMember guestGroupMember = guestGroupMemberService.deleteRegisteredGroupMember(rpcRegisteredGroupMember, kind);
        if(null == guestGroupMember){
            return null;
        }
        guestGroupMemberResponse = RegisteredGroupMemberResponse.newBuilder()
                .addResponseData(RpcRegisteredGroupMember.newBuilder()
                        .setGroupMemberId(guestGroupMember.getGroupMemberId())
                        .setRegisteredUserId(guestGroupMember.getRegisteredUserId())
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
