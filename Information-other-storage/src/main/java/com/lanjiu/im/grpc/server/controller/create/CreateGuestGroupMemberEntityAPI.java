package com.lanjiu.im.grpc.server.controller.create;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.pojo.GuestGroupMember;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.log4j.Logger;


public class CreateGuestGroupMemberEntityAPI {

    private static final Logger logger = Logger.getLogger(CreateGuestGroupMemberEntityAPI.class.getName());

    public GuestGroupMemberResponse createGuestGroupMember(TransmissionRequest request){
        GuestGroupMemberResponse guestGroupMemberResponse = null;
        RpcGuestGroup rpcGuestGroup = request.getGuestGroup();
        int groupId = rpcGuestGroup.getGroupId();
        RpcRegisteredGroup rpcRegisteredGroup = request.getRegisteredGroup();
        int registeredGroupId = rpcRegisteredGroup.getGroupId();
        RpcGuestGroupMember rpcGuestGroupMember = request.getGuestGroupMember();
        if((groupId != 0)&&(registeredGroupId ==0)){
            GuestGroupMemberGuestGroupServiceAPI guestGroupMemberService = new GuestGroupMemberGuestGroupServiceAPI();
            GuestGroupMember guestGroupMember = guestGroupMemberService.createGuestGroupMember(rpcGuestGroup, rpcGuestGroupMember);
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
        }else if ((groupId == 0)&&(registeredGroupId !=0)){
            GuestGroupMemberRegisteredGroupServiceAPI guestGroupMemberService = new GuestGroupMemberRegisteredGroupServiceAPI();
            GuestGroupMember guestGroupMember = guestGroupMemberService.createGuestGroupMember(rpcRegisteredGroup, rpcGuestGroupMember);
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
        }

        return guestGroupMemberResponse;
    }
}
