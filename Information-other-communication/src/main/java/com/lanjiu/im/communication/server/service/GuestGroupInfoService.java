package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.server.ResponseUtil;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.im.grpc.client.util.ConstantsSelectKind;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class GuestGroupInfoService {

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectGuestGroupInformation(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        //还需以被添加人的角色检索记录
        JCRC32 jcrc32 = new JCRC32();
        StorageAPI storageAPI = new StorageAPI();
        TransmissionRequest transmissionRequest ;
        List<RpcGuestGroup> rpcGuestGroupList ;
        List<RpcGuestGroupMember> rpcGuestGroupMemberList ;
        List<RpcRegisteredGroup> rpcRegisteredGroupList ;
        List<RpcRegisteredGroupMember> rpcRegisteredGroupMemberList ;

        List<BusinessProtocolEntities.TouristsGroup> touristsGroupList ;
        List<BusinessProtocolEntities.RegisteredGroup> registeredGroupList ;
        List<BusinessProtocolEntities.TouristsGroupMember> touristsGroupMemberList ;
        List<BusinessProtocolEntities.RegisteredGroupMember> registeredGroupMemberList ;

        GroupInformUtils groupUtils = new GroupInformUtils();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response ;
        //装载grpc协议请求信息
        BusinessProtocolEntities.TouristsUser  touristsUser = unifiedEntranceMessage.getGroupInfoProtocol().getTouristsUser();
        BusinessProtocolEntities.TouristsGroup  touristsGroup = unifiedEntranceMessage.getGroupInfoProtocol().getTouristsGroup();

        BusinessProtocolEntities.RegisteredGroup registeredGroup = unifiedEntranceMessage.getGroupInfoProtocol().getRegisteredGroup();

        if(IMSContacts.UserType.TOURISTS_USER.equals(touristsGroup.getGroupType())){
            transmissionRequest = TransmissionRequest.newBuilder()
                    .setRequestKind(ConstantsSelectKind.GUEST_GROUP_AND_GROUP_MEMBER_SELECT_BY_GROUP_ID)
                    .setGuestGroup(RpcGuestGroup.newBuilder()
                            .setGroupId(Integer.parseInt(touristsGroup.getGroupId()))
                            .setGuestUserId(Integer.parseInt(touristsUser.getTemporaryId()))
                            .setGroupName(touristsGroup.getGroupName())
                            .setAmount(touristsGroup.getMemberCount())
                            .build())
                    .build();
            GuestGroupResponse guestGroupResponse = storageAPI.selectGuestGroupAPI(transmissionRequest);
            rpcGuestGroupList = guestGroupResponse.getResponseGuestGroupList();
            touristsGroupList = groupUtils.turnRpcGuestGroupToTouristsGroup(rpcGuestGroupList);
            //commonUtils.isHave(list)
            CommonUtils<BusinessProtocolEntities.TouristsGroup> commonUtils = new CommonUtils<>();
            if(commonUtils.isHave(touristsGroupList)){
                touristsGroup = touristsGroupList.get(0);
            }

            rpcRegisteredGroupList = guestGroupResponse.getResponseRegisteredGroupList();
            registeredGroupList = groupUtils.turnRpcRegisteredGroupToRegisteredGroup(rpcRegisteredGroupList);
            CommonUtils<BusinessProtocolEntities.RegisteredGroup> commonUtils2 = new CommonUtils<>();
            if(commonUtils2.isHave(registeredGroupList)){
                registeredGroup = registeredGroupList.get(0);
            }

            rpcGuestGroupMemberList = guestGroupResponse.getResponseGuestGroupMemberList();
            touristsGroupMemberList = groupUtils.turnRpcGuestGroupMemberToTouristsGroupMember(rpcGuestGroupMemberList, unifiedEntranceMessage);

            rpcRegisteredGroupMemberList = guestGroupResponse.getResponseRegisteredGroupMemberList();
            registeredGroupMemberList = groupUtils.turnRpcRegisteredGroupMemberToRegisteredGroupMember(rpcRegisteredGroupMemberList, unifiedEntranceMessage);
            BusinessProtocolMessages.GroupInfoProtocol groupInfoProtocol = BusinessProtocolMessages.GroupInfoProtocol.newBuilder()
                    .addAllRegisteredGroupMember(registeredGroupMemberList)
                    .addAllTouristsGroupMember(touristsGroupMemberList)
                    .setUserType(unifiedEntranceMessage.getGroupInfoProtocol().getUserType())
                    .setTouristsUser(unifiedEntranceMessage.getGroupInfoProtocol().getTouristsUser())
                    .setRegisteredUser(unifiedEntranceMessage.getGroupInfoProtocol().getRegisteredUser())
                    .setRegisteredGroup(registeredGroup)
                    .setTouristsGroup(touristsGroup)
                    .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                    .build();
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                    .newBuilder()
                    .setGroupInfoProtocol(groupInfoProtocol)
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(head.getMsgType())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                            .setToId(head.getToId())
                            .setFromId(head.getFromId())
                            .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setMsgContentType(head.getMsgContentType())
                            .build()
                    )
                    .build();
            response = jcrc32.packageCheckSum(message);
            return response;
        }else {
            ResponseUtil responseUtil = new ResponseUtil();
            response = responseUtil.requestWithResponseFail(unifiedEntranceMessage);
        }
        return response;
    }
}
