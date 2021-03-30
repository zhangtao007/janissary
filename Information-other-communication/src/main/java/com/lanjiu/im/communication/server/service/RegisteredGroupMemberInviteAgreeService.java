package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.server.ResponseUtil;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.im.grpc.client.util.ConstantsDefault;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class RegisteredGroupMemberInviteAgreeService {

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage addRegisteredGroupMemberInviteAgree(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        //还需以被添加人的角色检索记录
        JCRC32 jcrc32 = new JCRC32();
        StorageAPI storageAPI = new StorageAPI();
        TransmissionRequest transmissionRequest ;
        List<RpcRegisteredGroupMember> list ;
        ResponseUtil responseUtil = new ResponseUtil();
        GroupInformUtils groupUtils = new GroupInformUtils();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response = null;
        //装载grpc协议请求信息
        BusinessProtocolEntities.RegisteredUser  registeredUser = unifiedEntranceMessage.getGroupMemberAddProtocol().getRegisteredUser();
        BusinessProtocolEntities.RegisteredGroupMember  registeredGroupMember = unifiedEntranceMessage.getGroupMemberAddProtocol().getRegisteredGroupMember();

        int operation = unifiedEntranceMessage.getGroupMemberAddProtocol().getOperation();

        String isOwner = ConstantsDefault.GROUP_MEMBER_MASTER_NO;

        List<BusinessProtocolEntities.RegisteredGroupMember> registeredGroupMemberList ;

        if(IMSContacts.Operation.AGREE == operation){
            if(IMSContacts.UserType.REGISTERED_USER.equals(registeredGroupMember.getUserType())){
                if(0 == registeredGroupMember.getGroupMemberType()){
                    isOwner = ConstantsDefault.GROUP_MEMBER_MASTER_NO;
                }else if(1 == registeredGroupMember.getGroupMemberType()){
                    isOwner = ConstantsDefault.GROUP_MEMBER_MASTER_YES;
                }
                transmissionRequest = TransmissionRequest.newBuilder()
                        .setRegisteredGroupMember(RpcRegisteredGroupMember.newBuilder()
                                .setGroupId(Integer.parseInt(registeredGroupMember.getGroup().getGroupId()))
                                .setRegisteredUserId(Integer.parseInt(registeredUser.getUserId()))
                                .setGroupOwner(isOwner)
                                .build())
                        .setRegisteredGroup(RpcRegisteredGroup.newBuilder()
                                .setGroupId(Integer.parseInt(registeredGroupMember.getGroup().getGroupId()))
                                .build())
                        .build();
                RegisteredGroupMemberResponse guestGroupMemberResponse = storageAPI.insertRegisteredGroupMemberAPI(transmissionRequest);
                list = guestGroupMemberResponse.getResponseDataList();
                registeredGroupMemberList = groupUtils.turnRpcRegisteredGroupMemberToRegisteredGroupMember(list, unifiedEntranceMessage);

                //commonUtils.isHave(list)
                CommonUtils<BusinessProtocolEntities.RegisteredGroupMember> commonUtils = new CommonUtils<>();
                if(commonUtils.isHave(registeredGroupMemberList)){
                    registeredGroupMember = registeredGroupMemberList.get(0);
                }
                BusinessProtocolMessages.GroupMemberAddProtocol groupMemberAddProtocol = BusinessProtocolMessages.GroupMemberAddProtocol.newBuilder()
                        .setRegisteredGroupMember(registeredGroupMember)
                        .setTouristsGroupMember(unifiedEntranceMessage.getGroupMemberAddProtocol().getTouristsGroupMember())
                        .setUserType(unifiedEntranceMessage.getGroupMemberAddProtocol().getUserType())
                        .setTouristsUser(unifiedEntranceMessage.getGroupMemberAddProtocol().getTouristsUser())
                        .setRegisteredUser(unifiedEntranceMessage.getGroupMemberAddProtocol().getRegisteredUser())
                        .setAddType(unifiedEntranceMessage.getGroupMemberAddProtocol().getAddType())
                        .setOperation(unifiedEntranceMessage.getGroupMemberAddProtocol().getOperation())
                        .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .build();
                BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                        .newBuilder()
                        .setGroupMemberAddProtocol(groupMemberAddProtocol)
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
                response = responseUtil.requestWithResponseFail(unifiedEntranceMessage);
            }
        }else if(IMSContacts.Operation.REFUSE == operation){
            response = responseUtil.requestWithResponseSuccess(unifiedEntranceMessage);
        }
        return response;
    }
}
