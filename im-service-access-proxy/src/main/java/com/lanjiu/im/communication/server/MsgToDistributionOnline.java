package com.lanjiu.im.communication.server;

import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.IMServerUtil;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

import java.time.Clock;

import static com.lanjiu.im.communication.util.ChannelList.*;

public class MsgToDistributionOnline {

    private static final Logger log = Logger.getLogger(MsgToDistributionOnline.class);

    //请求派发
    public static void msgToDistributionOnline(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage){
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = checkUnifiedEntranceMessage.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String msgType = head.getMsgType();
        printLog(checkUnifiedEntranceMessage);


        //用户设备信息更新
        if (IMSContacts.MsgType.USER_DEVICE_UPDATE.equalsIgnoreCase(msgType)){
            IMServerUtil.sendLoginRegistrationServer(ctx,checkUnifiedEntranceMessage);
            return;
        }
        //音视频交互
        if(IMSContacts.MsgType.AUDIO_AND_VIDEO_CALL.equals(msgType)){
            //接听者类型（0：个人，1：群组）
            Channel fromChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (fromChannel != null){
                fromChannel.writeAndFlush(IMServerUtil.responseSuccessfulMsg(checkUnifiedEntranceMessage));
            }

            int toType = unifiedEntranceMessage.getAudioAndVideoCallProtocol().getToType();
            if (toType == 0){
                Channel socketChannel = IMServerUtil.getSocketChannel(head.getToId());
                if (socketChannel != null){
                    socketChannel.writeAndFlush(checkUnifiedEntranceMessage);
                }else {
                    IMServerUtil.sendFriendMessageServer(ctx, checkUnifiedEntranceMessage);
                }

            }else if(toType ==1){
                //todo
                IMServerUtil.sendMessageGroupServer(ctx, checkUnifiedEntranceMessage);

            }else {
                ctx.channel().writeAndFlush(IMServerUtil.responseFailMsg(checkUnifiedEntranceMessage));
            }

            return;
        }



        // 退出登录
        if (IMSContacts.MsgType.LOGOUT_TOURISTS.equals(msgType) || IMSContacts.MsgType.LOGOUT_REGISTERED.equals(msgType)){
            IMServerUtil.sendLoginRegistrationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }
        // 捞取好友离线消息）
        if (IMSContacts.MsgType.GET_OFF_MESSAGE_REGIST.equals(msgType) || IMSContacts.MsgType.GET_OFF_MESSAGE_TOURIST.equals(msgType)){
//            IMServerUtil.channelTimes.put(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead().getFromId(), Clock.systemUTC().millis());
            IMServerUtil.sendFriendMessageServer(ctx, checkUnifiedEntranceMessage);
            return;
        }
        // 删除好友离线消息的指令
        if (IMSContacts.MsgType.DEL_FRIEND_OFF_MESSAGE_REGIST.equals(msgType) ||IMSContacts.MsgType.DEL_FRIEND_OFF_MESSAGE_TOURIST.equals(msgType)){
            IMServerUtil.sendFriendMessageServer(ctx, checkUnifiedEntranceMessage);
            ctx.channel().writeAndFlush(IMServerUtil.responseSuccessfulMsg(checkUnifiedEntranceMessage));
            Channel socketChannel = IMServerUtil.getSocketChannel(head.getToId());
            if (socketChannel != null){
                socketChannel.writeAndFlush(checkUnifiedEntranceMessage);
            }
            return;
        }

        // 获取好友列表
        if (IMSContacts.MsgType.FRIEND_LIST_TOURISTS.equals(msgType) ||IMSContacts.MsgType.FRIEND_LIST_REGISTERED.equals(msgType)){
            IMServerUtil.sendInformationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        // 通知列表
        if (IMSContacts.MsgType.NOTIFICATIONS_REGISTERED.equals(msgType) || IMSContacts.MsgType.NOTIFICATIONS_TOURISTS.equals(msgType)){
            // 暂未开发
            return;
        }


        // 多人聊天(群聊)
        if((IMSContacts.MsgType.GROUP_CHAT_TOURISTS.equals(msgType)) ||(IMSContacts.MsgType.GROUP_CHAT_REGISTERED.equals(msgType))){
//            IMServerUtil.channelTimes.put(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead().getFromId(), Clock.systemUTC().millis());
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                log.info("群聊天响应发送人【"+head.getFromId()+"】消息发送结果：" + IMServerUtil.responseSuccessfulMsg(checkUnifiedEntranceMessage));
                shortChannel.writeAndFlush(IMServerUtil.responseSuccessfulMsg(checkUnifiedEntranceMessage));
            }

            IMServerUtil.sendMessageGroupServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        // 拉取群离线消息
        if (IMSContacts.MsgType.GROUP_CHART_OFF_LINE_MSG.equals(msgType)){
            IMServerUtil.sendMessageGroupServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        // 查询群
        if (IMSContacts.MsgType.GROUP_FIND_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_FIND_REGISTERED.equals(msgType)){
            IMServerUtil.sendInformationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        // 创建群
        if (IMSContacts.MsgType.GROUP_CREATE_REGISTERED.equals(msgType) || IMSContacts.MsgType.GROUP_CREATE_TOURISTS.equals(msgType)){
            IMServerUtil.sendInformationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        // 申请入群
        if (IMSContacts.MsgType.GROUP_MEMBER_APPLY_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_MEMBER_APPLY_REGISTERED.equals(msgType)){
            Channel socketChannel = IMServerUtil.getSocketChannel(head.getToId());
            if (socketChannel != null){
                socketChannel.writeAndFlush(checkUnifiedEntranceMessage);
            }else {
                IMServerUtil.sendMessageGroupServer(ctx, checkUnifiedEntranceMessage);
            }

            return;
        }

        // 同意入群申请（走邀请业务，后台不会收到此类消息）
        if (IMSContacts.MsgType.GROUP_MEMBER_APPLY_AGREE_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_MEMBER_APPLY_AGREE_REGISTERED.equals(msgType)){
            Channel socketChannel = IMServerUtil.getSocketChannel(head.getToId());
            if (socketChannel != null){
                socketChannel.writeAndFlush(checkUnifiedEntranceMessage);
            }else {
                IMServerUtil.sendMessageGroupServer(ctx, checkUnifiedEntranceMessage);
            }
            Channel fromChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (fromChannel != null){
                fromChannel.writeAndFlush(IMServerUtil.responseSuccessfulMsg(checkUnifiedEntranceMessage));
            }
            IMServerUtil.sendInformationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

//        // 申请入群、同意申请
//        if (IMSContacts.MsgType.GROUP_MEMBER_APPLY_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_MEMBER_APPLY_REGISTERED.equals(msgType)
//                || IMSContacts.MsgType.GROUP_MEMBER_APPLY_AGREE_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_MEMBER_APPLY_AGREE_REGISTERED.equals(msgType)){
//            Channel socketChannel = IMServerUtil.getSocketChannel(head.getToId());
//            if (socketChannel != null && socketChannel.isActive()){
//                IMServerUtil.writeAndFlushMsgGroup(socketChannel, head.getToId(), checkUnifiedEntranceMessage);
//            }else {
//                IMServerUtil.sendMessageGroupServer(ctx, checkUnifiedEntranceMessage);
//            }
//            Channel fromChannel = IMServerUtil.getShortChannel(head.getFromId());
//            if (fromChannel != null){
//                fromChannel.writeAndFlush(IMServerUtil.responseSuccessfulMsg(checkUnifiedEntranceMessage));
//            }
//            return;
//        }

        // 同意好友申请
        if (IMSContacts.MsgType.FRIEND_APPLY_AGREE_TOURISTS.equals(msgType) || IMSContacts.MsgType.FRIEND_APPLY_AGREE_REGISTERED.equals(msgType)){
//            IMServerUtil.channelTimes.put(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead().getFromId(), Clock.systemUTC().millis());
            IMServerUtil.sendInformationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }
        //邀请入群（同意入群）
        if (IMSContacts.MsgType.GROUP_MEMBER_INVITE_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_MEMBER_INVITE_REGISTERED.equals(msgType)){
            ctx.channel().writeAndFlush(IMServerUtil.responseSuccessfulMsg(checkUnifiedEntranceMessage));
            IMServerUtil.sendInformationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        // 查询个人信息
        if (IMSContacts.MsgType.SELECT_USER_INFO.equals(msgType)){
            IMServerUtil.sendLoginRegistrationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        // 群资料
        if (IMSContacts.MsgType.GROUP_INFO_TOURISTS.equals(msgType) || (IMSContacts.MsgType.GROUP_INFO_REGISTERED.equals(msgType))){
            IMServerUtil.sendInformationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        // 获取群成员列表/群列表
        if (IMSContacts.MsgType.GET_GROUP_MEMBERS.equals(msgType) || IMSContacts.MsgType.GET_GROUP_LIST.equals(msgType)){
            IMServerUtil.sendInformationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        // 设置群名称
        if (IMSContacts.MsgType.GROUP_NAME_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_NAME_REGISTERED.equals(msgType)){
            IMServerUtil.sendInformationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        // 拒绝入群申请
        if (IMSContacts.MsgType.GROUP_MEMBER_APPLY_REFUSE_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_MEMBER_APPLY_REFUSE_REGISTERED.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null && shortChannel.isActive()){
                shortChannel.writeAndFlush(IMServerUtil.responseSuccessfulMsg(checkUnifiedEntranceMessage));
            }
            // toId用户是否登录过
            Channel toIdChannel = IMServerUtil.getSocketChannel(head.getToId());
            if (toIdChannel != null){
                IMServerUtil.writeAndFlushMsgGroup(toIdChannel, head.getToId(), checkUnifiedEntranceMessage);
            }else {
                IMServerUtil.sendMessageGroupServer(ctx, checkUnifiedEntranceMessage);
            }
            return;
        }

        // 删除群成员==》group_chart44,
        if (IMSContacts.MsgType.GROUP_MEMBER_DELETE_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_MEMBER_DELETE_REGISTERED.equals(msgType)){
            IMServerUtil.sendInformationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        if (IMSContacts.MsgType.GROUP_MEMBER_DELETE.equals(msgType)){
            IMServerUtil.sendInformationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        // 群成员、群主退群,46
        if (IMSContacts.MsgType.GROUP_MEMBER_EXIT.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(IMServerUtil.responseSuccessfulMsg(checkUnifiedEntranceMessage));
            }
            IMServerUtil.sendInformationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        // 检查更新
        if (IMSContacts.MsgType.CHECK_FOR_UPDATES.equals(msgType)){
            IMServerUtil.sendLoginRegistrationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        // 修改群备注
        if (IMSContacts.MsgType.UPDATE_GROUP_REMARK.equals(msgType)){
            IMServerUtil.sendInformationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        // 群聊天消息撤回/删除
        if (IMSContacts.MsgType.DEL_GROUP_MSG.equals(msgType)){
            IMServerUtil.sendMessageGroupServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        // 登录
        if (IMSContacts.MsgType.LOGIN_TOURISTS.equals(msgType) || IMSContacts.MsgType.LOGIN_REGISTERED.equals(msgType)){
            macChannelMap.put(head.getFromId(), ctx.channel());
            IMServerUtil.sendLoginRegistrationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        // 申请加好友
        if(IMSContacts.MsgType.FRIEND_APPLY_TOURISTS.equals(msgType) ||(IMSContacts.MsgType.FRIEND_APPLY_REGISTERED.equals(msgType))){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(IMServerUtil.responseSuccessfulMsg(checkUnifiedEntranceMessage));
            }
            Channel toIdChannel = IMServerUtil.getSocketChannel(head.getToId());
            // toId用户是否登录过
            if (toIdChannel == null){
                // 没有登录/离线
                IMServerUtil.sendFriendMessageServer(ctx, checkUnifiedEntranceMessage);
            }else {
                IMServerUtil.writeAndFlushFriend(toIdChannel, head.getToId(), checkUnifiedEntranceMessage);
            }
            return;
        }

        // 好友资料
        if (IMSContacts.MsgType.FRIEND_INFO_TOURISTS.equals(msgType) || IMSContacts.MsgType.FRIEND_INFO_REGISTERED.equals(msgType)){
            IMServerUtil.sendInformationServer(ctx, checkUnifiedEntranceMessage);
            return;
        }

        if((IMSContacts.MsgType.FRIEND_FIND_TOURISTS.equals(msgType)
                ||(IMSContacts.MsgType.FRIEND_FIND_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.REGISTER.equals(msgType)))
                ||(IMSContacts.MsgType.PERSONAL_NICKNAME_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_NICKNAME_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_AVATAR_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_AVATAR_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_OFFLINE_MSG_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_OFFLINE_MSG_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_FRIEND_SNAPCHAT_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_FRIEND_SNAPCHAT_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_FRIEND_SNAPCHAT_LENGTH_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_FRIEND_SNAPCHAT_LENGTH_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_GROUP_SNAPCHAT_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_GROUP_SNAPCHAT_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_GROUP_SNAPCHAT_LENGTH_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_GROUP_SNAPCHAT_LENGTH_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_EXIT_CLEAN_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_EXIT_CLEAN_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_TIMER_CLEAN_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_TIMER_CLEAN_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.VERIFICATION_CODE.equals(msgType))
                ||(IMSContacts.MsgType.RESET_SECRET_VERIFY.equals(msgType))
                ||(IMSContacts.MsgType.RESET_SECRET.equals(msgType))
                ||(IMSContacts.MsgType.SETUP_PHONE.equals(msgType))
                ||(IMSContacts.MsgType.SETUP_PHONE_EDIT.equals(msgType))
                ){
            IMServerUtil.sendLoginRegistrationServer(ctx, checkUnifiedEntranceMessage);
        }else if (IMSContacts.MsgType.GROUP_LIST_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_LIST_REGISTERED.equals(msgType)) {
            IMServerUtil.sendInformationServer(ctx, checkUnifiedEntranceMessage);
        } else if((IMSContacts.MsgType.FRIEND_DELETE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_DELETE_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_INVITE_AGREE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_INVITE_AGREE_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_ANNOUNCEMENT_UPDATE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_ANNOUNCEMENT_UPDATE_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_ANNOUNCEMENT_SELECT_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_ANNOUNCEMENT_SELECT_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_ALIAS_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_ALIAS_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_SNAPCHAT_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_SNAPCHAT_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_SNAPCHAT_LENGTH_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_SNAPCHAT_LENGTH_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_OFFLINE_MSG_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_OFFLINE_MSG_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_SNAPCHAT_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_SNAPCHAT_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_SNAPCHAT_LENGTH_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_SNAPCHAT_LENGTH_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_NICK_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_NICK_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_ALIAS_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_ALIAS_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_ALIAS_REGISTERED.equals(msgType))){
            String toId = head.getToId();
            // toId用户是否登录过
            Channel toIdChannel = IMServerUtil.getSocketChannel(toId);
            if (toIdChannel == null){
                // 没有登录/离线
                IMServerUtil.sendFriendMessageServer(ctx, checkUnifiedEntranceMessage);
            }else {
                // 在线
                toIdChannel.writeAndFlush(checkUnifiedEntranceMessage);
            }
            IMServerUtil.sendInformationServer(ctx, checkUnifiedEntranceMessage);
        }else if((IMSContacts.MsgType.FRIEND_APPLY_REFUSE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_APPLY_REFUSE_REGISTERED.equals(msgType))){
            String toId = head.getToId();
            // toId用户是否登录过
            Channel toIdChannel = IMServerUtil.getSocketChannel(toId);
            if (toIdChannel == null){
                // 没有登录/离线
                IMServerUtil.sendFriendMessageServer(ctx, checkUnifiedEntranceMessage);
            }else {
                IMServerUtil.writeAndFlushFriend(toIdChannel, toId, checkUnifiedEntranceMessage);
            }
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(IMServerUtil.responseSuccessfulMsg(checkUnifiedEntranceMessage));
            }
        }else if((IMSContacts.MsgType.GROUP_MEMBER_INVITE_REFUSE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_INVITE_REFUSE_REGISTERED.equals(msgType))){
            //群消息，申请添加，拒绝添加之类的作为信息处理，如果群成员在线，直接发给对方，如果群成员不在线派发向群消息通信服务器
            //群聊天直接转发给对方
            IMServerUtil.sendInformationServer(ctx, checkUnifiedEntranceMessage);
        }else if(IMSContacts.MsgType.FRIEND_CHAT_TOURISTS.equals(msgType) ||(IMSContacts.MsgType.FRIEND_CHAT_REGISTERED.equals(msgType))){
            String toId = head.getToId();
//            IMServerUtil.channelTimes.put(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead().getFromId(), Clock.systemUTC().millis());
            // toId用户是否登录过
            Channel toIdChannel = IMServerUtil.getSocketChannel(toId);
            if (toIdChannel == null){
                IMServerUtil.sendFriendMessageServer(ctx, checkUnifiedEntranceMessage);
            }else {
                Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
                if (shortChannel != null){
                    BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage successfulMsg = IMServerUtil.responseSuccessfulMsg(checkUnifiedEntranceMessage);
                    shortChannel.writeAndFlush(successfulMsg);
                    log.info("1v1聊天-响应发送方用户【" + head.getFromId() + "】消息发送成功：" + successfulMsg);
                }
                IMServerUtil.writeAndFlushFriend(toIdChannel, toId, checkUnifiedEntranceMessage);
                log.info("1v1聊天-消息发送至接收方【" + toId + "】：");
            }
        }
    }

    private static void printLog(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = checkUnifiedEntranceMessage.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String msgType = head.getMsgType();
        switch (msgType){
        case IMSContacts.MsgType.FRIEND_CHAT_REGISTERED:
            int chatType = checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendChatProtocol().getChatMessage().getChatType();
            if (chatType == 0) {
                log.info("接收用户【"+ head.getFromId() +"】发送的【"+ msgType +"】数据（chatType="+ chatType +"）：" + checkUnifiedEntranceMessage);
            }else {
                log.info("接收用户【"+ head.getFromId() +"】发送的【"+ msgType +"】数据（chatType="+ chatType +"）：" + head);
            }
            break;
        case IMSContacts.MsgType.GROUP_CHAT_REGISTERED:
            int groupChatType = checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupChatProtocol().getChatMessage().getChatType();
            if (IMSContacts.GROUP_CHAT_LOG_FILTER.contains(groupChatType + "")) {
                log.info("接收用户【"+ head.getFromId() +"】发送的【"+ msgType +"】数据（chatType="+ groupChatType +"）：" + head);
            }else {
                log.info("接收用户【"+ head.getFromId() +"】发送的【"+ msgType +"】数据（chatType="+ groupChatType +"）：" + checkUnifiedEntranceMessage);
            }
            break;
        default:
            log.info("接收用户【"+ head.getFromId() +"】发送的【"+ msgType +"】数据：" + checkUnifiedEntranceMessage);
            break;
        }
    }

}
