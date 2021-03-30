package com.lanjiu.im.communication.util;

import com.huawei.push.exception.HuaweiMesssagingException;
import com.huawei.push.message.AndroidConfig;
import com.huawei.push.message.Message;
import com.huawei.push.messaging.HuaweiApp;
import com.huawei.push.messaging.HuaweiMessaging;
import com.huawei.push.model.Urgency;
import com.huawei.push.reponse.SendResponse;
import com.huawei.push.util.InitAppUtils;
import com.lanjiu.im.communication.client.friend.FriendMessageClient;
import com.lanjiu.im.communication.client.group.GroupMessageClient;
import com.lanjiu.im.communication.client.information.InformationClient;
import com.lanjiu.im.communication.client.login.LoginRegistrationClient;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.StringUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.lanjiu.im.communication.util.ChannelList.*;


public class IMServerUtil {

    private final static Logger log = Logger.getLogger(IMServerUtil.class);

    public static Channel getShortChannel(String userId){
        if (StringUtil.isNullOrEmpty(userId)) return null;
        Channel channel = shortChannelGroup.get(userId);
        if (channel != null && channel.isActive()){
            log.info("用户:["+ userId + "]取出的短管道ID：" + channel.id().toString() + "，channel：" + channel);
            return channel;
        }else {
            return null;
        }
    }

    public static Channel getSocketChannel(String userId){
        if (StringUtil.isNullOrEmpty(userId)) return null;
        if (userId.length() == 8) {
            userId = userId + "1";
        }
        Channel channel = socketChannelGroup.get(userId);
        if (channel != null && channel.isActive()){
            log.info("用户:["+ userId + "]取出的长管道ID：" + channel.id().toString() + "，channel：" + channel);
            return channel;
        }else {
            return null;
        }
    }


    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage requestWithResponseValidateFail(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage){
        BusinessProtocolMessageStandard.Head head = checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder(head).setStatusReport(ResponseStatus.RESPONSE_CHECK_FAILURE))
                .setDataType(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getDataType()).build();
        return JCRC32.packageCheckSum(message);
    }

    /**
     * 创建心跳包请求消息
     * */
    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage buildHeartBeat(BusinessProtocolMessageStandard.Head head){
        BusinessProtocolMessageStandard.Head header = BusinessProtocolMessageStandard.Head.newBuilder()
                .setMsgType(IMSContacts.MsgType.HEART_PACKAGE_PHONE)
                .setMsgContentType(head.getMsgContentType())
                .setToId(head.getToId())
                .setFromId(head.getFromId())
                .setToken(head.getToken())
                .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder().setHead(header).build();
        return BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.newBuilder().setUnifiedEntranceMessage(message).build();
    }

    /**
     * 返回心跳包请求fromID异常
     * */
    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage returnHeartBeat(BusinessProtocolMessageStandard.Head head){
        BusinessProtocolMessageStandard.Head header = BusinessProtocolMessageStandard.Head.newBuilder()
                .setMsgType(IMSContacts.MsgType.HEART_PACKAGE_RETURN)
                .setMsgContentType(head.getMsgContentType())
                .setToId(head.getToId())
                .setFromId(head.getFromId())
                .setToken(head.getToken())
                .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder().setHead(header).build();
        return BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.newBuilder().setUnifiedEntranceMessage(message).build();
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage responseOffLineGroupMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        return JCRC32.packageCheckSum(msg.getUnifiedEntranceMessage());
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage responseSuccessfulMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        return responseResultMsg(checkUnifiedEntranceMessage, ResponseStatus.STATUS_REPORT_SUCCESS);
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage responseFailMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        return responseResultMsg(checkUnifiedEntranceMessage, ResponseStatus.STATUS_REPORT_FAILURE);
    }

    private static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage responseExceptionResult(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        return responseResultMsg(checkUnifiedEntranceMessage, ResponseStatus.STATUS_REPORT_EXCEPTION);
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage responseRefuseResult(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        return responseResultMsg(checkUnifiedEntranceMessage, ResponseStatus.STATUS_REPORT_REFUSE);
    }

    private static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage responseResultMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg, String statusReport){
        BusinessProtocolMessageStandard.Head head = msg.getUnifiedEntranceMessage().getHead();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType dataType = msg.getUnifiedEntranceMessage().getDataType();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder(head).setStatusReport(statusReport))
                .setDataType(dataType).build();
        return JCRC32.packageCheckSum(message);
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage getUserOnLineMsg(String userId, String onLineType, boolean onlineStatus) {
        BusinessProtocolMessageStandard.Head head = BusinessProtocolMessageStandard.Head.newBuilder()
                .setFromId(userId)
                .setMsgType(onLineType)
                .setTimestamp(System.currentTimeMillis()).build();
        BusinessProtocolEntities.Settings settings = BusinessProtocolEntities.Settings.newBuilder().setOnlineStatus(onlineStatus).build();
        BusinessProtocolMessages.PersonalSettingsProtocol personalSettingsProtocol = BusinessProtocolMessages.PersonalSettingsProtocol.newBuilder()
                .setSettings(settings)
                .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setPersonalSettingsProtocol(personalSettingsProtocol)
                .setHead(head).build();
        return JCRC32.packageCheckSum(message);
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage deleteOffLineGroupMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        BusinessProtocolMessageStandard.Head newHead = BusinessProtocolMessageStandard.Head.newBuilder()
                .setFromId(head.getFromId())
                .setTimestamp(System.currentTimeMillis())
                .setMsgType(IMSContacts.MsgType.DELETE_GROUP_CHART_OFF_LINE_MSG).build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage1 = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder(unifiedEntranceMessage).setHead(newHead).build();
        return JCRC32.packageCheckSum(unifiedEntranceMessage1);
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage groupOwnerExit(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        BusinessProtocolMessageStandard.Head newHead = BusinessProtocolMessageStandard.Head.newBuilder(head).setMsgType(IMSContacts.MsgType.GROUP_OWNER_EXIT).build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage1 = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder(unifiedEntranceMessage).setHead(newHead).build();
        return JCRC32.packageCheckSum(unifiedEntranceMessage1);
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage repeatLoginHandel(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage) {
        BusinessProtocolMessageStandard.Head head = BusinessProtocolMessageStandard.Head.newBuilder(unifiedEntranceMessage.getHead())
                .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                .setMsgType(IMSContacts.MsgType.REPEAT_LOGIN_MSG)
                .setFromId(unifiedEntranceMessage.getHead().getFromId())
                .build();
        BusinessProtocolMessages.LogoutProtocol logoutProtocol = BusinessProtocolMessages.LogoutProtocol.newBuilder()
                .setUserType(IMSContacts.UserType.REGISTERED_USER)
                .setStatusDetail("被迫下线")
                .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage build = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setHead(head)
                .setLogoutProtocol(logoutProtocol)
                .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.LogoutProtocol)
                .build();
        return JCRC32.packageCheckSum(build);
    }

    public static void writeAndFlushFriend(Channel channel, String userId, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        channel.writeAndFlush(checkUnifiedEntranceMessage);
        BusinessProtocolMessageStandard.Head head = checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead();
        String key = msgKey(head);
        log.info("好友聊天消息唯一标识：" + key);
        msgMap.put(key, checkUnifiedEntranceMessage);
        log.info("================好友聊天发送长连接心跳监测================");
        channel.eventLoop().schedule(() -> {
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage entranceMessage1 = msgMap.get(key);
            log.info(userId + "进入5秒");
            if (entranceMessage1 != null) {
                log.info(userId + "未收到" + key + "确认回执");
                try {
                    FriendMessageClient.sendFriendServer(entranceMessage1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    LoginRegistrationClient.sendLoginServer(IMServerUtil.getUserOnLineMsg(userId.substring(0, 8), IMSContacts.OnlineState.OFFLINE, false));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                channel.close();
                log.info("长连接关闭，toId：[" + userId + "] 长连接活跃状态：" + channel.isActive());
                log.info("消息存储长度：" + msgMap.size());
                log.info("sendFriend用户[" + userId + "]离线");
                msgMap.remove(key);
            }
        }, 5, TimeUnit.SECONDS);
    }

    public static void writeAndFlushClean(Channel channel, String userId, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        channel.writeAndFlush(checkUnifiedEntranceMessage);
        BusinessProtocolMessageStandard.Head head = checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead();
        String key = msgKey(head);
        log.info("删除用户【"+ userId +"】在线接收消息唯一标识：" + key);
        msgMap.put(key, checkUnifiedEntranceMessage);
        log.info("================好友聊天发送长连接心跳监测================");
        channel.eventLoop().schedule(() -> {
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage entranceMessage1 = msgMap.get(key);
            if (entranceMessage1 != null) {
                log.info(userId + "进入5秒，【"+ key +"】未收到回执响应");
                try {
                    LoginRegistrationClient.sendLoginServer(IMServerUtil.getUserOnLineMsg(userId.substring(0, 8), IMSContacts.OnlineState.OFFLINE, false));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                channel.close();
                log.info("长连接关闭，toId：[" + userId + "] 长连接活跃状态：" + channel.isActive());
                log.info("消息存储长度：" + msgMap.size());
                log.info("sendFriend用户[" + userId + "]离线");
                msgMap.remove(key);
            }else {
                log.info(userId + "进入5秒，【"+ key +"】已收到回执响应");
            }
        }, 5, TimeUnit.SECONDS);
    }

    public static void writeAndFlushMsgGroup(Channel channel, String userId, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        channel.writeAndFlush(checkUnifiedEntranceMessage);
        BusinessProtocolMessageStandard.Head head = checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead();
        String key = msgKey(head);
        log.info("群消息唯一标识：" + key);
        msgMap.put(key, checkUnifiedEntranceMessage);
        log.info("================MsgGroup发送长连接心跳监测================");
        channel.eventLoop().schedule(() -> {
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage entranceMessage1 = msgMap.get(key);
            log.info(userId + "进入5秒");
            if (entranceMessage1 != null) {
                log.info(userId + "未收到" + key + "确认回执");
                try {
                    groupOffLineMsgSave(head.getMsgType(), entranceMessage1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    LoginRegistrationClient.sendLoginServer(IMServerUtil.getUserOnLineMsg(userId.substring(0, 8), IMSContacts.OnlineState.OFFLINE, false));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                channel.close();
                log.info("长连接关闭，toId：[" + userId + "] 长连接活跃状态：" + channel.isActive());
                log.info("消息存储长度：" + msgMap.size());
                log.info("sendMsgGroup用户[" + userId + "]离线");
                msgMap.remove(key);
            }
        }, 5, TimeUnit.SECONDS);
    }

    private static void groupOffLineMsgSave(String msgType, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage entranceMessage1) throws Exception{
        switch (msgType){
            case IMSContacts.MsgType.GROUP_CHAT_TOURISTS:
                GroupMessageClient.sendGroupMessageServer(groupMsgStorage(entranceMessage1));
                break;
            case IMSContacts.MsgType.GROUP_CHAT_REGISTERED:
                GroupMessageClient.sendGroupMessageServer(groupMsgStorage(entranceMessage1));
                break;
            case IMSContacts.MsgType.DEL_GROUP_MSG:
                GroupMessageClient.sendGroupMessageServer(delGroupMsgStorage(entranceMessage1.getUnifiedEntranceMessage()));
                break;
            case IMSContacts.MsgType.AUDIO_AND_VIDEO_CALL:
                GroupMessageClient.sendGroupMessageServer(savaMsgOffUser(entranceMessage1));
                break;
            default:
                GroupMessageClient.sendGroupMessageServer(entranceMessage1);
        }
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage groupMsgStorage(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead())
                        .setMsgType(IMSContacts.MsgType.GROUP_CHAT_MESSAGE_STORAGE).build())
                .setDataType(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getDataType())
                .setGroupChatProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupChatProtocol())
                .build();
        return JCRC32.packageCheckSum(message);
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage savaMsgOffUser(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead())
                        .setMsgType(IMSContacts.MsgType.GROUP_AUDIO_VIDEO_SAVE_TO_USER).build())
                .setDataType(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getDataType())
                .setAudioAndVideoCallProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getAudioAndVideoCallProtocol())
                .build();
        return JCRC32.packageCheckSum(message);
    }


    public static String msgKey(BusinessProtocolMessageStandard.Head head) {
        return head.getUniqueIdentify() + head.getToId() + head.getToken();
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage delGroupMsgStorage(BusinessProtocolMessageStandard.UnifiedEntranceMessage message) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message1 = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder(message.getHead()).setMsgType(IMSContacts.MsgType.DEL_GROUP_MSG_STORAGE).build())
                .setDataType(message.getDataType())
                .setDelGroupOffMessageProtocol(message.getDelGroupOffMessageProtocol())
                .build();
        log.info("群服务撤回/删除【"+message.getHead().getFromId()+"】对【"+message.getHead().getToId()+"】发送的数据：" + message1);
        return JCRC32.packageCheckSum(message1);
    }

    public static void sendFriendMessageServer(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        try {
            FriendMessageClient.sendFriendServer(checkUnifiedEntranceMessage);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("消息服务异常：{}", e);
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage message = IMServerUtil.responseExceptionResult(checkUnifiedEntranceMessage);
            ctx.channel().writeAndFlush(message);
        }
    }

    public static void sendMessageGroupServer(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        try {
            GroupMessageClient.sendGroupMessageServer(checkUnifiedEntranceMessage);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("群服务异常：{}", e);
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage message = IMServerUtil.responseExceptionResult(checkUnifiedEntranceMessage);
            ctx.channel().writeAndFlush(message);
        }
    }

    //好友，群，群成员设置类型，申请同意的时候，的请求派发向资料通信服务器,通知列表（包含好友和群的通知类消息）
    public static void sendInformationServer(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        try {
            InformationClient.sendInformationServer(checkUnifiedEntranceMessage);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("资料服务异常：{}", e);
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage message = IMServerUtil.responseExceptionResult(checkUnifiedEntranceMessage);
            ctx.channel().writeAndFlush(message);
        }
    }

    // 发送数据至好友登录服务
    public static void sendLoginRegistrationServer(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        try {

            LoginRegistrationClient.sendLoginServer(msg);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("登录服务异常：{}", e);
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage message = IMServerUtil.responseExceptionResult(msg);
            ctx.channel().writeAndFlush(message);
        }
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage deleteGroupAudioCallIndex(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        return JCRC32.packageCheckSum(msg.getUnifiedEntranceMessage());

    }

    /**
     * 华为推送(透传消息)
     * @throws HuaweiMesssagingException
     */
    public static void sendTransparent(String token,String content) throws HuaweiMesssagingException {
        HuaweiApp app = InitAppUtils.initializeApp();
        HuaweiMessaging huaweiMessaging = HuaweiMessaging.getInstance(app);

        AndroidConfig androidConfig = AndroidConfig.builder().setCollapseKey(-1)
                .setUrgency(Urgency.HIGH.getValue())
                .setTtl("10000s")
                .setBiTag("the_sample_bi_tag_for_receipt_service")
                .build();

//        String token = "0869158029739873300010793000CN01";

        Message message = Message.builder()
                .setData(content)
                .setAndroidConfig(androidConfig)
                .addToken(token)
                .build();

        SendResponse response = huaweiMessaging.sendMessage(message);

    }
}
