package com.lanjiu.im.communication.server;

import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.lanjiu.im.communication.server.ChannelList.mapIMChannelGroup;

public class IMServerUtil {

    private final Logger log = Logger.getLogger(IMServerUtil.class);

    public boolean isOnline(String toId){
        Channel channel = mapIMChannelGroup.get(toId);
        if((channel != null) && channel.isActive()){
            return true;
        }else {
            return false;
        }
    }

    private <K, V> Set<K> getKeysByStream(Map<K, V> map, V value) {
        return map.entrySet()
                .stream()
                .filter(kvEntry -> Objects.equals(kvEntry.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public boolean judgeToIdIsLegal(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.Head head, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage){
        String toId = head.getToId();
        if("".equals(toId)){
            JCRC32 jcrc32 = new JCRC32();
            BusinessProtocolMessageStandard.UnifiedEntranceMessage illegal = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setRegisteredUserProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getRegisteredUserProtocol())
                    .setLoginProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getLoginProtocol())
                    .setLogoutProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getLogoutProtocol())
                    .setFindUserProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFindUserProtocol())
                    .setFriendListProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendListProtocol())
                    .setFriendInfoProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendInfoProtocol())
                    .setFriendOnlineStatusChangeProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendOnlineStatusChangeProtocol())
                    .setFriendAddProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendAddProtocol())
                    .setFriendDeleteProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendDeleteProtocol())
                    .setFindGroupProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFindGroupProtocol())
                    .setGroupListProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupListProtocol())
                    .setGroupCreateProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupCreateProtocol())
                    .setGroupInfoProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupInfoProtocol())
                    .setGroupMemberOnlineStatusChangeProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberOnlineStatusChangeProtocol())
                    .setGroupMemberAddProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberAddProtocol())
                    .setGroupMemberDeleteProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberDeleteProtocol())
                    .setGroupAnnouncementProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupAnnouncementProtocol())
                    .setPersonalInfoProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getPersonalInfoProtocol())
                    .setPersonalSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getPersonalSettingsProtocol())
                    .setFriendSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendSettingsProtocol())
                    .setGroupSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupSettingsProtocol())
                    .setGroupMemberSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberSettingsProtocol())
                    .setNotificationsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getNotificationsProtocol())
                    .setSysNotifyProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getSysNotifyProtocol())
                    .setUserNotifyProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getUserNotifyProtocol())
                    .setFriendChatProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendChatProtocol())
                    .setGroupChatProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupChatProtocol())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(head.getMsgType())
                            .setToId(head.getFromId())
                            .setFromId(head.getToId())
                            .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setMsgContentType(head.getMsgContentType())
                            .setStatusReport(ResponseStatus.TO_ID_ERROR)).build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(illegal);
            ctx.writeAndFlush(checkUnified);
            return false;
        }
        return true;
    }

    public void requestWithResponseSuccess(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage){
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.Head head= checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage illegal = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setRegisteredUserProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getRegisteredUserProtocol())
                .setLoginProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getLoginProtocol())
                .setLogoutProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getLogoutProtocol())
                .setFindUserProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFindUserProtocol())
                .setFriendListProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendListProtocol())
                .setFriendInfoProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendInfoProtocol())
                .setFriendOnlineStatusChangeProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendOnlineStatusChangeProtocol())
                .setFriendAddProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendAddProtocol())
                .setFriendDeleteProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendDeleteProtocol())
                .setFindGroupProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFindGroupProtocol())
                .setGroupListProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupListProtocol())
                .setGroupCreateProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupCreateProtocol())
                .setGroupInfoProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupInfoProtocol())
                .setGroupMemberOnlineStatusChangeProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberOnlineStatusChangeProtocol())
                .setGroupMemberAddProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberAddProtocol())
                .setGroupMemberDeleteProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberDeleteProtocol())
                .setGroupAnnouncementProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupAnnouncementProtocol())
                .setPersonalInfoProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getPersonalInfoProtocol())
                .setPersonalSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getPersonalSettingsProtocol())
                .setFriendSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendSettingsProtocol())
                .setGroupSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupSettingsProtocol())
                .setGroupMemberSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberSettingsProtocol())
                .setNotificationsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getNotificationsProtocol())
                .setSysNotifyProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getSysNotifyProtocol())
                .setUserNotifyProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getUserNotifyProtocol())
                .setFriendChatProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendChatProtocol())
                .setGroupChatProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupChatProtocol())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(head.getMsgType())
                        .setToId(head.getFromId())
                        .setFromId(head.getToId())
                        .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setMsgContentType(head.getMsgContentType())
                        .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)).build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response = jcrc32.packageCheckSum(illegal);
        ctx.writeAndFlush(response);
        return ;
    }

    public void requestWithResponseValidateFail(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage){
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.Head head= checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage illegal = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setRegisteredUserProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getRegisteredUserProtocol())
                .setLoginProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getLoginProtocol())
                .setLogoutProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getLogoutProtocol())
                .setFindUserProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFindUserProtocol())
                .setFriendListProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendListProtocol())
                .setFriendInfoProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendInfoProtocol())
                .setFriendOnlineStatusChangeProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendOnlineStatusChangeProtocol())
                .setFriendAddProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendAddProtocol())
                .setFriendDeleteProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendDeleteProtocol())
                .setFindGroupProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFindGroupProtocol())
                .setGroupListProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupListProtocol())
                .setGroupCreateProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupCreateProtocol())
                .setGroupInfoProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupInfoProtocol())
                .setGroupMemberOnlineStatusChangeProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberOnlineStatusChangeProtocol())
                .setGroupMemberAddProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberAddProtocol())
                .setGroupMemberDeleteProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberDeleteProtocol())
                .setGroupAnnouncementProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupAnnouncementProtocol())
                .setPersonalInfoProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getPersonalInfoProtocol())
                .setPersonalSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getPersonalSettingsProtocol())
                .setFriendSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendSettingsProtocol())
                .setGroupSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupSettingsProtocol())
                .setGroupMemberSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberSettingsProtocol())
                .setNotificationsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getNotificationsProtocol())
                .setSysNotifyProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getSysNotifyProtocol())
                .setUserNotifyProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getUserNotifyProtocol())
                .setFriendChatProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendChatProtocol())
                .setGroupChatProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupChatProtocol())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(head.getMsgType())
                        .setToId(head.getFromId())
                        .setFromId(head.getToId())
                        .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setMsgContentType(head.getMsgContentType())
                        .setStatusReport(ResponseStatus.RESPONSE_CHECK_FAILURE)).build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response = jcrc32.packageCheckSum(illegal);
        ctx.writeAndFlush(response);
        return ;
    }

    public void requestWithResponseFail(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage){
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.Head head= checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage illegal = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setRegisteredUserProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getRegisteredUserProtocol())
                .setLoginProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getLoginProtocol())
                .setLogoutProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getLogoutProtocol())
                .setFindUserProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFindUserProtocol())
                .setFriendListProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendListProtocol())
                .setFriendInfoProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendInfoProtocol())
                .setFriendOnlineStatusChangeProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendOnlineStatusChangeProtocol())
                .setFriendAddProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendAddProtocol())
                .setFriendDeleteProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendDeleteProtocol())
                .setFindGroupProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFindGroupProtocol())
                .setGroupListProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupListProtocol())
                .setGroupCreateProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupCreateProtocol())
                .setGroupInfoProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupInfoProtocol())
                .setGroupMemberOnlineStatusChangeProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberOnlineStatusChangeProtocol())
                .setGroupMemberAddProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberAddProtocol())
                .setGroupMemberDeleteProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberDeleteProtocol())
                .setGroupAnnouncementProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupAnnouncementProtocol())
                .setPersonalInfoProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getPersonalInfoProtocol())
                .setPersonalSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getPersonalSettingsProtocol())
                .setFriendSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendSettingsProtocol())
                .setGroupSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupSettingsProtocol())
                .setGroupMemberSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberSettingsProtocol())
                .setNotificationsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getNotificationsProtocol())
                .setSysNotifyProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getSysNotifyProtocol())
                .setUserNotifyProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getUserNotifyProtocol())
                .setFriendChatProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendChatProtocol())
                .setGroupChatProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupChatProtocol())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(head.getMsgType())
                        .setToId(head.getFromId())
                        .setFromId(head.getToId())
                        .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setMsgContentType(head.getMsgContentType())
                        .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)).build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response = jcrc32.packageCheckSum(illegal);
        ctx.writeAndFlush(response);
        return ;
    }

    public void sendResponseFromClientToPhone(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified){
        String fromId = checkUnified.getUnifiedEntranceMessage().getHead().getFromId();
        String toId = checkUnified.getUnifiedEntranceMessage().getHead().getToId();
        if (IMSContacts.MsgType.SET_MSG_TYPE_TO_ID.equals(toId)){
            //返回到请求的来源
            Channel channel = mapIMChannelGroup.get(fromId); //返回一个响应到请求端
            channel.writeAndFlush(checkUnified);
            log.info("对应手机地址:" + channel.remoteAddress());
        }else {
            //返回到请求的目标端，并返回一个响应到请求端
            Channel channel = mapIMChannelGroup.get(toId); //返回到请求的目标端
            channel.writeAndFlush(checkUnified);
            boolean bSuccess = channel.isActive();
            if(bSuccess){
                channel = mapIMChannelGroup.get(fromId); //返回一个响应到请求端
                channel.writeAndFlush(checkUnified);
            }else {
                JCRC32 jcrc32 = new JCRC32();
                BusinessProtocolMessageStandard.Head head= checkUnified.getUnifiedEntranceMessage().getHead();
                BusinessProtocolMessageStandard.UnifiedEntranceMessage illegal = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                        .setRegisteredUserProtocol(checkUnified.getUnifiedEntranceMessage().getRegisteredUserProtocol())
                        .setLoginProtocol(checkUnified.getUnifiedEntranceMessage().getLoginProtocol())
                        .setLogoutProtocol(checkUnified.getUnifiedEntranceMessage().getLogoutProtocol())
                        .setFindUserProtocol(checkUnified.getUnifiedEntranceMessage().getFindUserProtocol())
                        .setFriendListProtocol(checkUnified.getUnifiedEntranceMessage().getFriendListProtocol())
                        .setFriendInfoProtocol(checkUnified.getUnifiedEntranceMessage().getFriendInfoProtocol())
                        .setFriendOnlineStatusChangeProtocol(checkUnified.getUnifiedEntranceMessage().getFriendOnlineStatusChangeProtocol())
                        .setFriendAddProtocol(checkUnified.getUnifiedEntranceMessage().getFriendAddProtocol())
                        .setFriendDeleteProtocol(checkUnified.getUnifiedEntranceMessage().getFriendDeleteProtocol())
                        .setFindGroupProtocol(checkUnified.getUnifiedEntranceMessage().getFindGroupProtocol())
                        .setGroupListProtocol(checkUnified.getUnifiedEntranceMessage().getGroupListProtocol())
                        .setGroupCreateProtocol(checkUnified.getUnifiedEntranceMessage().getGroupCreateProtocol())
                        .setGroupInfoProtocol(checkUnified.getUnifiedEntranceMessage().getGroupInfoProtocol())
                        .setGroupMemberOnlineStatusChangeProtocol(checkUnified.getUnifiedEntranceMessage().getGroupMemberOnlineStatusChangeProtocol())
                        .setGroupMemberAddProtocol(checkUnified.getUnifiedEntranceMessage().getGroupMemberAddProtocol())
                        .setGroupMemberDeleteProtocol(checkUnified.getUnifiedEntranceMessage().getGroupMemberDeleteProtocol())
                        .setGroupAnnouncementProtocol(checkUnified.getUnifiedEntranceMessage().getGroupAnnouncementProtocol())
                        .setPersonalInfoProtocol(checkUnified.getUnifiedEntranceMessage().getPersonalInfoProtocol())
                        .setPersonalSettingsProtocol(checkUnified.getUnifiedEntranceMessage().getPersonalSettingsProtocol())
                        .setFriendSettingsProtocol(checkUnified.getUnifiedEntranceMessage().getFriendSettingsProtocol())
                        .setGroupSettingsProtocol(checkUnified.getUnifiedEntranceMessage().getGroupSettingsProtocol())
                        .setGroupMemberSettingsProtocol(checkUnified.getUnifiedEntranceMessage().getGroupMemberSettingsProtocol())
                        .setNotificationsProtocol(checkUnified.getUnifiedEntranceMessage().getNotificationsProtocol())
                        .setSysNotifyProtocol(checkUnified.getUnifiedEntranceMessage().getSysNotifyProtocol())
                        .setUserNotifyProtocol(checkUnified.getUnifiedEntranceMessage().getUserNotifyProtocol())
                        .setFriendChatProtocol(checkUnified.getUnifiedEntranceMessage().getFriendChatProtocol())
                        .setGroupChatProtocol(checkUnified.getUnifiedEntranceMessage().getGroupChatProtocol())
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                .setMsgType(head.getMsgType())
                                .setToId(head.getFromId())
                                .setFromId(head.getToId())
                                .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                                .setToken(head.getToken())
                                .setUniqueIdentify(head.getUniqueIdentify())
                                .setMsgContentType(head.getMsgContentType())
                                .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)).build();
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response = jcrc32.packageCheckSum(illegal);
                channel.writeAndFlush(response);
            }

            log.info("对应手机地址:" + channel.remoteAddress());
        }
    }

    public boolean chatWithFriend(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        String toId = head.getToId();
        Channel channel = mapIMChannelGroup.get(toId);
        ChannelFuture channelFuture = channel.writeAndFlush(checkUnifiedEntranceMessage);
        return channelFuture.isDone();
    }

    public void chatWithGroup(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        String toId = head.getToId();
        Channel channel = mapIMChannelGroup.get(toId);
        channel.writeAndFlush(checkUnifiedEntranceMessage);
    }

    /**
     * 创建心跳包请求消息
     * */
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage buildHeartBeat(){
        BusinessProtocolMessageStandard.Head header = BusinessProtocolMessageStandard.Head.newBuilder().setMsgType(IMSContacts.MsgType.HEART_PACKAGE_PHONE).build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder().setHead(header).build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.newBuilder()
                .setUnifiedEntranceMessage(message).build();
        return checkUnifiedEntranceMessage;
    }

}
