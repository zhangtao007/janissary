package com.lanjiu.im.grpc.server.controller.create;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.pojo.RegisteredGroupMember;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.log4j.Logger;


public class CreateRegisteredGroupMemberEntityAPI {

    private static final Logger logger = Logger.getLogger(CreateRegisteredGroupMemberEntityAPI.class.getName());

    public RegisteredGroupMemberResponse createRegisteredGroupMember(TransmissionRequest request){
        RegisteredGroupMemberResponse registeredGroupMemberResponse = null;
        RpcGuestGroup rpcGuestGroup = request.getGuestGroup();
        int groupId = rpcGuestGroup.getGroupId();
        System.out.println("groupId: "+groupId);
        RpcRegisteredGroup rpcRegisteredGroup = request.getRegisteredGroup();
        int registeredGroupId = rpcRegisteredGroup.getGroupId();
        System.out.println("registeredGroupId: "+registeredGroupId);
        RpcRegisteredGroupMember rpcRegisteredGroupMember = request.getRegisteredGroupMember();
        if((groupId != 0)&&(registeredGroupId ==0)){
            logger.info("新增群成员的群id "+groupId);
            RegisteredGroupMemberGuestGroupServiceAPI registeredGroupMemberService = new RegisteredGroupMemberGuestGroupServiceAPI();
            RegisteredGroupMember registeredGroupMember = registeredGroupMemberService.createRegisteredGroupMember(rpcGuestGroup, rpcRegisteredGroupMember);
            if(null == registeredGroupMember){
                return null;
            }
            registeredGroupMemberResponse = RegisteredGroupMemberResponse.newBuilder()
                    .addResponseData(RpcRegisteredGroupMember.newBuilder()
                            .setGroupMemberId(registeredGroupMember.getGroupMemberId())
                            .setRegisteredUserId(registeredGroupMember.getRegisteredUserId())
                            .setGroupRemarks(registeredGroupMember.getGroupRemarks())
                            .setGroupOwner(registeredGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(registeredGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(registeredGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(registeredGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(registeredGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(registeredGroupMember.getOfflineMessageSetting())
                            .build())
                    .addRegisteredGroupData(rpcRegisteredGroup)
                    .addGuestGroupData(rpcGuestGroup)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
        }else if ((groupId == 0)&&(registeredGroupId !=0)){ //注册群
            logger.info("本次新增群成员的群id"+registeredGroupId);
            RegisteredGroupMemberRegisteredGroupServiceAPI groupMemberService = new RegisteredGroupMemberRegisteredGroupServiceAPI();
            RegisteredGroupMember groupMember = groupMemberService.createRegisteredGroupMember(rpcRegisteredGroup, rpcRegisteredGroupMember);
            logger.info("本次新增的群成员id"+groupMember.getGroupMemberId());
            if(null == groupMember){
                return null;
            }
            registeredGroupMemberResponse = RegisteredGroupMemberResponse.newBuilder()
                    .addResponseData(RpcRegisteredGroupMember.newBuilder()
                            .setGroupMemberId(groupMember.getGroupMemberId())
                            .setRegisteredUserId(groupMember.getRegisteredUserId())
                            .setGroupRemarks(groupMember.getGroupRemarks())
                            .setGroupOwner(groupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(groupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(groupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(groupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(groupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(groupMember.getOfflineMessageSetting())
                            .build())
                    .addRegisteredGroupData(rpcRegisteredGroup)
                    .addGuestGroupData(rpcGuestGroup)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
        }
        return registeredGroupMemberResponse;
    }
}
