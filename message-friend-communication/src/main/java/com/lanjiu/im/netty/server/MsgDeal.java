package com.lanjiu.im.netty.server;

import com.lanjiu.im.grpc.utils.IMSContacts;
import com.lanjiu.im.grpc.utils.JCRC32;
import com.lanjiu.im.grpc.utils.ResponseStatus;
import com.lanjiu.im.netty.server.common.MessageFriendCommon;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MsgDeal {

    private final Logger log = Logger.getLogger(MessageFriendCommServerHandler.class);

    public void msgToDeal
            (ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = checkUnifiedEntranceMessage.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String msgType = head.getMsgType();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response = null;
        MessageFriendCommon messageFriendCommon = new MessageFriendCommon();
        //请求处理
        if(IMSContacts.MsgType.FRIEND_APPLY_REGISTERED.equals(msgType)) {
            response = messageFriendCommon.friendApplyRegist(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.FRIEND_APPLY_TOURISTS.equals(msgType)){
            response = messageFriendCommon.friendApplyTourist(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.FRIEND_DELETE_REGISTERED.equals(msgType)){
            response = messageFriendCommon.friendDeleteRegist(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.FRIEND_DELETE_TOURISTS.equals(msgType)){
            response = messageFriendCommon.friendDeleteTourist(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.FRIEND_APPLY_AGREE_REGISTERED.equals(msgType)){
            response = messageFriendCommon.agreeFriendApplyRegist(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.FRIEND_APPLY_AGREE_TOURISTS.equals(msgType)){
            response = messageFriendCommon.agreeFriendApplyTourist(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.FRIEND_APPLY_REFUSE_REGISTERED.equals(msgType)){
            response = messageFriendCommon.refuseFriendApplyRegist(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.FRIEND_APPLY_REFUSE_TOURISTS.equals(msgType)){
            response = messageFriendCommon.refuseFriendApplyTourist(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.FRIEND_CHAT_REGISTERED.equals(msgType)){
            response = messageFriendCommon.friendChatRegist(ctx,unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.FRIEND_CHAT_TOURISTS.equals(msgType)){
            response = messageFriendCommon.friendChatTourist(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.DEL_FRIEND_OFF_MESSAGE_REGIST.equals(msgType)){
            //存储删除离线消息指令
            response = messageFriendCommon.delFriendOffMessageRegist(unifiedEntranceMessage, head);
           log.info("status_detail："+response.getUnifiedEntranceMessage().getDelFriendOffMessageProtocol().getStatusDetail());
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.DEL_FRIEND_OFF_MESSAGE_TOURIST.equals(msgType)){
            //存储游客删除离线消息指令
            response = messageFriendCommon.delFriendOffMessageTourist(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.GET_OFF_MESSAGE_REGIST.equals(msgType)){
            //捞取注册用户离线消息
            response = messageFriendCommon.getRegistFriendOffMessage(unifiedEntranceMessage, head);
            log.info("status_detail："+response.getUnifiedEntranceMessage().getOffFriendMessageListProtocol().getStatusDetail());
            ChannelFuture future = ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.GET_OFF_MESSAGE_TOURIST.equals(msgType)){
            //捞取游客用户离线消息
            response = messageFriendCommon.getGuestFriendOffMessage(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.REMOVE_MSG_BY_IM.equals(msgType)){
            //IM 删除离线消息
            response = messageFriendCommon.removeMsgFromIM(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if (IMSContacts.MsgType.AUDIO_AND_VIDEO_CALL.equals(msgType)){
            response = messageFriendCommon.audioAndVideoCallStorage(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else{
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(head.getMsgType())
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .build())
                    .build();
            JCRC32 jcrc32 = new JCRC32();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkMessage = jcrc32.packageCheckSum(message);
            ctx.writeAndFlush(checkMessage);
        }

    }

    public void requestWithResponseValidateFail(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
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

        ctx.channel().writeAndFlush(response);
        return ;
    }
}
