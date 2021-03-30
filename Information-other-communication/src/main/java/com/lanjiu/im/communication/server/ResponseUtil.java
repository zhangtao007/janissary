package com.lanjiu.im.communication.server;

import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class ResponseUtil {

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage requestWithResponseFail(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage){
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.Head head= unifiedEntranceMessage.getHead();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage illegal = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
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
                .setGroupMemberSettingsProtocol(unifiedEntranceMessage.getGroupMemberSettingsProtocol())
                .setNotificationsProtocol(unifiedEntranceMessage.getNotificationsProtocol())
                .setSysNotifyProtocol(unifiedEntranceMessage.getSysNotifyProtocol())
                .setUserNotifyProtocol(unifiedEntranceMessage.getUserNotifyProtocol())
                .setFriendChatProtocol(unifiedEntranceMessage.getFriendChatProtocol())
                .setGroupChatProtocol(unifiedEntranceMessage.getGroupChatProtocol())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(head.getMsgType())
                        .setToId(head.getToId())
                        .setFromId(head.getFromId())
                        .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setMsgContentType(head.getMsgContentType())
                        .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)).build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response = jcrc32.packageCheckSum(illegal);
        return response;
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage requestWithResponseSuccess(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage){
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.Head head= unifiedEntranceMessage.getHead();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage illegal = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
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
                .setGroupMemberSettingsProtocol(unifiedEntranceMessage.getGroupMemberSettingsProtocol())
                .setNotificationsProtocol(unifiedEntranceMessage.getNotificationsProtocol())
                .setSysNotifyProtocol(unifiedEntranceMessage.getSysNotifyProtocol())
                .setUserNotifyProtocol(unifiedEntranceMessage.getUserNotifyProtocol())
                .setFriendChatProtocol(unifiedEntranceMessage.getFriendChatProtocol())
                .setGroupChatProtocol(unifiedEntranceMessage.getGroupChatProtocol())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(head.getMsgType())
                        .setToId(head.getToId())
                        .setFromId(head.getFromId())
                        .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setMsgContentType(head.getMsgContentType())
                        .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)).build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response = jcrc32.packageCheckSum(illegal);
        return response;
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage ResponseResult(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage,
    List<BusinessProtocolEntities.AllGroupMemberVO> groupMemberVOS,String groupPhoto) {
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        BusinessProtocolMessages.GroupInfoProtocol groupInfoProtocol = BusinessProtocolMessages.GroupInfoProtocol.newBuilder()
                .addAllResponseGroupMemberVo(groupMemberVOS)
                .setRegisteredGroup(BusinessProtocolEntities.RegisteredGroup.newBuilder().setGroupAvatar(groupPhoto).build())
                .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                .newBuilder()
                .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupInfoProtocol)
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
                        .build()).build();
        return new JCRC32().packageCheckSum(message);
    }
}
