package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.server.ResponseUtil;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class TouristsGroupMemberUpdateRemarkService {

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage updateGuestGroupMemberRemark(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        //还需以被添加人的角色检索记录
        JCRC32 jcrc32 = new JCRC32();
        StorageAPI storageAPI = new StorageAPI();
        TransmissionRequest transmissionRequest ;
        List<RpcGroupRemark> list ;
        ResponseUtil responseUtil = new ResponseUtil();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response ;
        //装载grpc协议请求信息
        //当前设置备注的群成员
        BusinessProtocolEntities.TouristsGroupMember  touristsGroupMember = unifiedEntranceMessage.getGroupMemberSettingsProtocol().getTouristsGroupMember();

        //当前被设置备注的群成员
        BusinessProtocolEntities.RegisteredGroupMember  registeredGroupMember = unifiedEntranceMessage.getGroupMemberSettingsProtocol().getRegisteredGroupMember();

        if(IMSContacts.UserType.TOURISTS_USER.equals(touristsGroupMember.getUserType())){

            transmissionRequest = TransmissionRequest.newBuilder()
                    .setGroupRemark(RpcGroupRemark.newBuilder()
                            .setGroupId(Integer.parseInt(touristsGroupMember.getGroup().getGroupId()))
                            .setGroupMemberId(Integer.parseInt(touristsGroupMember.getGroupMemberId()))
                            .setGroupMemberIdRemarked(Integer.parseInt(registeredGroupMember.getGroupMemberId()))
                            .setRemark(registeredGroupMember.getGroupMemberAlias())
                            .build())
                    .setGuestGroup(RpcGuestGroup.newBuilder()
                            .setGroupId(Integer.parseInt(touristsGroupMember.getGroup().getGroupId()))
                            .build())
                    .build();
            GroupRemarkResponse groupRemarkResponse = storageAPI.updateGroupRemarkAPI(transmissionRequest);
            list = groupRemarkResponse.getResponseDataList();

            BusinessProtocolMessages.GroupMemberSettingsProtocol groupMemberSettingsProtocol = BusinessProtocolMessages.GroupMemberSettingsProtocol.newBuilder()
                    .setRegisteredGroupMember(unifiedEntranceMessage.getGroupMemberSettingsProtocol().getRegisteredGroupMember())
                    .setTouristsGroupMember(touristsGroupMember)
                    .setUserType(unifiedEntranceMessage.getGroupMemberSettingsProtocol().getUserType())
                    .setTouristsUser(unifiedEntranceMessage.getGroupMemberSettingsProtocol().getTouristsUser())
                    .setRegisteredUser(unifiedEntranceMessage.getGroupMemberSettingsProtocol().getRegisteredUser())
                    .setOperation(unifiedEntranceMessage.getGroupMemberSettingsProtocol().getOperation())
                    .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                    .build();
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                    .newBuilder()
                    .setRegisteredUserProtocol(unifiedEntranceMessage.getRegisteredUserProtocol())
                    .setLoginProtocol(unifiedEntranceMessage.getLoginProtocol())
                    .setLogoutProtocol(unifiedEntranceMessage.getLogoutProtocol())
                    .setFindUserProtocol(unifiedEntranceMessage.getFindUserProtocol())
                    .setFriendListProtocol(unifiedEntranceMessage.getFriendListProtocol())
                    .setFriendInfoProtocol(unifiedEntranceMessage.getFriendInfoProtocol())
                    .setFriendOnlineStatusChangeProtocol(unifiedEntranceMessage.getFriendOnlineStatusChangeProtocol())
                    .setFriendAddProtocol(unifiedEntranceMessage.getFriendAddProtocol())
                    .setFriendDeleteProtocol(unifiedEntranceMessage.getFriendDeleteProtocol())
                    .setFindGroupProtocol(unifiedEntranceMessage.getFindGroupProtocol())
                    .setGroupListProtocol(unifiedEntranceMessage.getGroupListProtocol())
                    .setGroupCreateProtocol(unifiedEntranceMessage.getGroupCreateProtocol())
                    .setGroupInfoProtocol(unifiedEntranceMessage.getGroupInfoProtocol())
                    .setGroupMemberOnlineStatusChangeProtocol(unifiedEntranceMessage.getGroupMemberOnlineStatusChangeProtocol())
                    .setGroupMemberAddProtocol(unifiedEntranceMessage.getGroupMemberAddProtocol())
                    .setGroupMemberDeleteProtocol(unifiedEntranceMessage.getGroupMemberDeleteProtocol())
                    .setGroupAnnouncementProtocol(unifiedEntranceMessage.getGroupAnnouncementProtocol())
                    .setPersonalInfoProtocol(unifiedEntranceMessage.getPersonalInfoProtocol())
                    .setPersonalSettingsProtocol(unifiedEntranceMessage.getPersonalSettingsProtocol())
                    .setFriendSettingsProtocol(unifiedEntranceMessage.getFriendSettingsProtocol())
                    .setGroupSettingsProtocol(unifiedEntranceMessage.getGroupSettingsProtocol())
                    .setGroupMemberSettingsProtocol(groupMemberSettingsProtocol)
                    .setNotificationsProtocol(unifiedEntranceMessage.getNotificationsProtocol())
                    .setSysNotifyProtocol(unifiedEntranceMessage.getSysNotifyProtocol())
                    .setUserNotifyProtocol(unifiedEntranceMessage.getUserNotifyProtocol())
                    .setFriendChatProtocol(unifiedEntranceMessage.getFriendChatProtocol())
                    .setGroupChatProtocol(unifiedEntranceMessage.getGroupChatProtocol())
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
        return response;
    }
}
