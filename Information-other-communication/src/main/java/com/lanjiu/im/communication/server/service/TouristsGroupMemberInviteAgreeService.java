package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.server.ResponseUtil;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.grpc.GuestGroupMemberResponse;
import com.lanjiu.im.grpc.RpcGuestGroup;
import com.lanjiu.im.grpc.RpcGuestGroupMember;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.im.grpc.client.util.ConstantsDefault;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class TouristsGroupMemberInviteAgreeService {

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage addTouristsGroupMemberInviteAgree(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        //还需以被添加人的角色检索记录
        JCRC32 jcrc32 = new JCRC32();
        StorageAPI storageAPI = new StorageAPI();
        TransmissionRequest transmissionRequest ;
        List<RpcGuestGroupMember> list ;
        ResponseUtil responseUtil = new ResponseUtil();
        GroupInformUtils groupUtils = new GroupInformUtils();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response = null;
        //装载grpc协议请求信息
        BusinessProtocolEntities.TouristsUser  touristsUser = unifiedEntranceMessage.getGroupMemberAddProtocol().getTouristsUser();
        BusinessProtocolEntities.TouristsGroupMember  touristsGroupMember = unifiedEntranceMessage.getGroupMemberAddProtocol().getTouristsGroupMember();

        int operation = unifiedEntranceMessage.getGroupMemberAddProtocol().getOperation();

        String isOwner = ConstantsDefault.GROUP_MEMBER_MASTER_NO;

        List<BusinessProtocolEntities.TouristsGroupMember> touristsGroupMemberList ;

        if(IMSContacts.Operation.AGREE == operation){
            if(IMSContacts.UserType.TOURISTS_USER.equals(touristsGroupMember.getUserType())){
                if(0 == touristsGroupMember.getGroupMemberType()){
                    isOwner = ConstantsDefault.GROUP_MEMBER_MASTER_NO;
                }else if(1 == touristsGroupMember.getGroupMemberType()){
                    isOwner = ConstantsDefault.GROUP_MEMBER_MASTER_YES;
                }
                transmissionRequest = TransmissionRequest.newBuilder()
                        .setGuestGroupMember(RpcGuestGroupMember.newBuilder()
                                .setGroupId(Integer.parseInt(touristsGroupMember.getGroup().getGroupId()))
                                .setGuestUserId(Integer.parseInt(touristsUser.getTemporaryId()))
                                .setGroupOwner(isOwner)
                                .build())
                        .setGuestGroup(RpcGuestGroup.newBuilder()
                                .setGroupId(Integer.parseInt(touristsGroupMember.getGroup().getGroupId()))
                                .build())
                        .build();
                GuestGroupMemberResponse guestGroupMemberResponse = storageAPI.insertGuestGroupMemberAPI(transmissionRequest);
                list = guestGroupMemberResponse.getResponseDataList();
                touristsGroupMemberList = groupUtils.turnRpcGuestGroupMemberToTouristsGroupMember(list, unifiedEntranceMessage);

                //commonUtils.isHave(list)
                CommonUtils<BusinessProtocolEntities.TouristsGroupMember> commonUtils = new CommonUtils<>();
                if(commonUtils.isHave(touristsGroupMemberList)){
                    touristsGroupMember = touristsGroupMemberList.get(0);
                }
                BusinessProtocolMessages.GroupMemberAddProtocol groupMemberAddProtocol = BusinessProtocolMessages.GroupMemberAddProtocol.newBuilder()
                        .setRegisteredGroupMember(unifiedEntranceMessage.getGroupMemberAddProtocol().getRegisteredGroupMember())
                        .setTouristsGroupMember(touristsGroupMember)
                        .setUserType(unifiedEntranceMessage.getGroupMemberAddProtocol().getUserType())
                        .setTouristsUser(unifiedEntranceMessage.getGroupMemberAddProtocol().getTouristsUser())
                        .setRegisteredUser(unifiedEntranceMessage.getGroupMemberAddProtocol().getRegisteredUser())
                        .setAddType(unifiedEntranceMessage.getGroupMemberAddProtocol().getAddType())
                        .setOperation(unifiedEntranceMessage.getGroupMemberAddProtocol().getOperation())
                        .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .build();
                BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                        .newBuilder().setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupMemberAddProtocol)
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
