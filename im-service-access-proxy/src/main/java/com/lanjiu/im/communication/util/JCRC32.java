package com.lanjiu.im.communication.util;


import com.lanjiu.pro.business.BusinessProtocolMessageStandard;

import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;

public class JCRC32 {
    /**
     * 编码
     *
     * @param data
     * @return
     */
    public static long encode(byte[] data) {
        CRC32 crc32 = new CRC32();
        crc32.update(data);
        return crc32.getValue();
    }

    //数据包类型判断
    public static String packageProtocolJudge(BusinessProtocolMessageStandard.UnifiedEntranceMessage msg) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType dataType = msg.getDataType();
        String protocolHexString;
        CustomProtocolToString customProtocolToString = new CustomProtocolToString();
        switch (dataType) {
            case RegisteredUserProtocol:
                protocolHexString = customProtocolToString.toStringRegisteredUserProtocol(msg.getRegisteredUserProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case LoginProtocol:
                protocolHexString = customProtocolToString.toStringLoginProtocol(msg.getLoginProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case LogoutProtocol:
                protocolHexString = customProtocolToString.toStringLogoutProtocol(msg.getLogoutProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case FindUserProtocol:
                protocolHexString = customProtocolToString.toStringFindUserProtocol(msg.getFindUserProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case FriendListProtocol:
                protocolHexString = customProtocolToString.toStringFriendListProtocol(msg.getFriendListProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case FriendInfoProtocol:
                protocolHexString = customProtocolToString.toStringFriendInfoProtocol(msg.getFriendInfoProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case FriendOnlineStatusChangeProtocol:
                protocolHexString = customProtocolToString.toStringFriendOnlineStatusChangeProtocol(msg.getFriendOnlineStatusChangeProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case FriendAddProtocol:
                protocolHexString = customProtocolToString.toStringFriendAddProtocol(msg.getFriendAddProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case FriendDeleteProtocol:
                protocolHexString = customProtocolToString.toStringFriendDeleteProtocol(msg.getFriendDeleteProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case FindGroupProtocol:
                protocolHexString = customProtocolToString.toStringFindGroupProtocol(msg.getFindGroupProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case GroupListProtocol:
                protocolHexString = customProtocolToString.toStringGroupListProtocol(msg.getGroupListProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case GroupCreateProtocol:
                protocolHexString = customProtocolToString.toStringGroupCreateProtocol(msg.getGroupCreateProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case GroupInfoProtocol:
                protocolHexString = customProtocolToString.toStringGroupInfoProtocol(msg.getGroupInfoProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case GroupMemberOnlineStatusChangeProtocol:
                protocolHexString = customProtocolToString.toStringGroupMemberOnlineStatusChangeProtocol(msg.getGroupMemberOnlineStatusChangeProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case GroupMemberAddProtocol:
                protocolHexString = customProtocolToString.toStringGroupMemberAddProtocol(msg.getGroupMemberAddProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case GroupMemberDeleteProtocol:
                protocolHexString = customProtocolToString.toStringGroupMemberDeleteProtocol(msg.getGroupMemberDeleteProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case GroupAnnouncementProtocol:
                protocolHexString = customProtocolToString.toStringGroupAnnouncementProtocol(msg.getGroupAnnouncementProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case PersonalInfoProtocol:
                protocolHexString = customProtocolToString.toStringPersonalInfoProtocol(msg.getPersonalInfoProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case PersonalSettingsProtocol:
                protocolHexString = customProtocolToString.toStringPersonalSettingsProtocol(msg.getPersonalSettingsProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case FriendSettingsProtocol:
                protocolHexString = customProtocolToString.toStringFriendSettingsProtocol(msg.getFriendSettingsProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case GroupSettingsProtocol:
                protocolHexString = customProtocolToString.toStringGroupSettingsProtocol(msg.getGroupSettingsProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case GroupMemberSettingsProtocol:
                protocolHexString = customProtocolToString.toStringGroupMemberSettingsProtocol(msg.getGroupMemberSettingsProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case NotificationsProtocol:
                protocolHexString = customProtocolToString.toStringNotificationsProtocol(msg.getNotificationsProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case SysNotifyProtocol:
                protocolHexString = customProtocolToString.toStringSysNotifyProtocol(msg.getSysNotifyProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case UserNotifyProtocol:
                protocolHexString = customProtocolToString.toStringUserNotifyProtocol(msg.getUserNotifyProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case FriendChatProtocol:
                protocolHexString = customProtocolToString.toStringFriendChatProtocol(msg.getFriendChatProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case GroupChatProtocol:
                protocolHexString = customProtocolToString.toStringGroupChatProtocol(msg.getGroupChatProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case DelFriendOffMessageProtocol:
                protocolHexString = customProtocolToString.toStringDelFriendOffMessageProtocol(msg.getDelFriendOffMessageProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case OffFriendMessageListProtocol:
                protocolHexString = customProtocolToString.toStringOffFriendMessageListProtocol(msg.getOffFriendMessageListProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case CheckForUpdatesProtocol:
                protocolHexString = customProtocolToString.toStringCheckForUpdatesProtocol(msg.getCheckForUpdatesProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case AudioAndVideoCallProtocol:
                protocolHexString = customProtocolToString.toStringAudioAndVideoCallProtocol(msg.getAudioAndVideoCallProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
            case BindingPushServicesProtocol:
                protocolHexString = customProtocolToString.toStringBindingPushServicesProtocol(msg.getBindingPushServicesProtocol()) + customProtocolToString.toStringHead(msg.getHead());
                break;
             default:
                protocolHexString = customProtocolToString.toStringHead(msg.getHead());
                break;
        }
        return protocolHexString;
    }

    //给数据包加校验信息
    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage packageCheckSum(BusinessProtocolMessageStandard.UnifiedEntranceMessage msg) {
        String protocolHexString = packageProtocolJudge(msg);
        String checksum_Translate = String.valueOf(JCRC32.encode(protocolHexString.getBytes(StandardCharsets.UTF_8)));
        return BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.newBuilder().setUnifiedEntranceMessage(msg).setChecksum(checksum_Translate).build();
    }

    //checksum的自定义校验函数
    public static CheckSumResult checkSumValidateProtocol(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage, BusinessProtocolMessageStandard.UnifiedEntranceMessage msg) {
        String checksum = checkUnifiedEntranceMessage.getChecksum();
        String protocolHexString = packageProtocolJudge(msg);
        String checksum_Translate = String.valueOf(JCRC32.encode(protocolHexString.getBytes(StandardCharsets.UTF_8)));
        if (checksum_Translate.equals(checksum)) {
            return new CheckSumResult(true, checkUnifiedEntranceMessage);
        }
        // -1002 自己定义常量，标识验证失败，目前好像没有用
        BusinessProtocolMessageStandard.Head head = BusinessProtocolMessageStandard.Head.newBuilder(msg.getHead()).setMsgContentType(-1002).build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.newBuilder()
                .setUnifiedEntranceMessage(BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder(msg).setHead(head).build())
                .build();
        return new CheckSumResult(false, checkUnified);
    }
}
