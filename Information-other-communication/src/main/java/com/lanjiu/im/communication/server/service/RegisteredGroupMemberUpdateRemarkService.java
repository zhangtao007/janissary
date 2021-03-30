package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.server.ResponseUtil;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import io.netty.channel.ChannelHandlerContext;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class RegisteredGroupMemberUpdateRemarkService {

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage updateRegisteredGroupMemberRemark(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, ChannelHandlerContext ctx) {
        //还需以被添加人的角色检索记录
        JCRC32 jcrc32 = new JCRC32();
        StorageAPI storageAPI = new StorageAPI();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        BusinessProtocolEntities.RegisteredGroupMember groupMember = unifiedEntranceMessage.getGroupMemberSettingsProtocol().getRegisteredGroupMember();
        BusinessProtocolEntities.RegisteredUser registeredUser = unifiedEntranceMessage.getGroupMemberSettingsProtocol().getRegisteredUser();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response ;
        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
                        .setRegisteredGroupMember(RpcRegisteredGroupMember.newBuilder()
                                .setRegisteredUserId(Integer.parseInt(groupMember.getGroupMemberUserId()))//被修改人ID
                                .setGroupMemberId(Integer.parseInt(groupMember.getGroupMemberId()))//修改人成员ID
                                .setGroupId(Integer.parseInt(groupMember.getGroup().getGroupId()))//群ID
                                .setGroupRemarks(groupMember.getGroupMemberAlias())//成员备注
                                .build())
                        .setRegisteredUserFriend(RpcRegisteredUserFriend.newBuilder()
                                .setRegisteredUserId(Integer.parseInt(registeredUser.getUserId()))//修改人ID
                                .build())
                        .build();
        RegisteredGroupMemberResponse registeredGroupMemberResponse = storageAPI.updateRegisteredGroupMemberRemark(transmissionRequest);
        List<RpcRegisteredGroupMember> responseDataList = registeredGroupMemberResponse.getResponseDataList();

        if(null != responseDataList && responseDataList.size()>0){
            BusinessProtocolMessages.GroupMemberSettingsProtocol groupMemberSettingsProtocol = BusinessProtocolMessages.GroupMemberSettingsProtocol.newBuilder()
                    .setRegisteredGroupMember(BusinessProtocolEntities.RegisteredGroupMember.newBuilder()
                            .setGroupMemberUserId(String.valueOf(responseDataList.get(0).getRegisteredUserId()))
                            .setGroupMemberAlias(responseDataList.get(0).getGroupRemarks())
                            .setGroup(BusinessProtocolEntities.RegisteredGroup.newBuilder().
                                    setGroupId(String.valueOf(responseDataList.get(0).getGroupId())))
                            .build())
                    .setUserType(unifiedEntranceMessage.getGroupMemberSettingsProtocol().getUserType())
                    .setRegisteredUser(unifiedEntranceMessage.getGroupMemberSettingsProtocol().getRegisteredUser())
                    .setOperation(unifiedEntranceMessage.getGroupMemberSettingsProtocol().getOperation())
                    .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                    .build();
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                    .newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupMemberSettingsProtocol)
                    .setGroupMemberSettingsProtocol(groupMemberSettingsProtocol)
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
                    ).build();
            response = jcrc32.packageCheckSum(message);
            return response;
        }else {
            ResponseUtil responseUtil = new ResponseUtil();
            response = responseUtil.requestWithResponseFail(unifiedEntranceMessage);
        }
        return response;
    }
}
