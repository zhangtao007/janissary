package com.lanjiu.im.communication.client.friend;

import com.google.gson.JsonObject;
import com.huawei.push.exception.HuaweiMesssagingException;
import com.lanjiu.im.communication.client.util.IMClientUtils;
import com.lanjiu.im.communication.util.IMServerUtil;
import com.lanjiu.im.communication.util.CheckSumResult;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static com.lanjiu.im.communication.client.friend.FriendMessageClient.friendChannel;
import static com.lanjiu.im.communication.util.ChannelList.*;
import static com.lanjiu.im.communication.util.ResponseStatus.RESPONSE_CHECK_FAILURE;

public class FriendMessageClientHandler extends SimpleChannelInboundHandler<BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage> {

    private final Logger log = Logger.getLogger(FriendMessageClientHandler.class);

    //线程安全心跳失败计数器
    private AtomicInteger atomicInteger = new AtomicInteger(1);

//    private ExecutorService threadPool = Executors.newCachedThreadPool();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) throws Exception {
        //数据包完整性校验
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String msgType = head.getMsgType();
        if (IMSContacts.MsgType.HEART_PACKAGE.equals(msgType)){
            log.info("管道ID : " + ctx.channel().id().toString() + "，消息服务心跳正常");
            //清零心跳失败计数器
            atomicInteger = new AtomicInteger(1);
            return;
        }
        // 定期清理-删除用户在线接收消息//todo   what?
        if (IMSContacts.MsgType.DEL_ON_LINE_RECEIVE.equals(msgType)){
            log.info("删除用户【"+ head.getToId() +"】在线接收fromID:【"+ head.getFromId() +"】消息-用户上线主动推:" + msg);
            Channel socketChannel = IMServerUtil.getSocketChannel(head.getToId());
            if (socketChannel != null){
                IMServerUtil.writeAndFlushClean(socketChannel, head.getToId(), msg);
            }
            return;
        }
        CheckSumResult checkSumResult = JCRC32.checkSumValidateProtocol(msg, unifiedEntranceMessage);
        if(!checkSumResult.b_result){
            log.info("IM FriendMessageClient端数据包校验失败... ..." + msg);
            return ;
        }
        if(RESPONSE_CHECK_FAILURE.equals(unifiedEntranceMessage.getHead().getStatusReport())){
            log.info("上个数据包完整性校验失败: " + msg);
            return ;
        }

        printLog(msg);

        if(IMSContacts.MsgType.FRIEND_CHAT_TOURISTS.equals(msgType) ||(IMSContacts.MsgType.FRIEND_CHAT_REGISTERED.equals(msgType))){
            Channel channel = IMServerUtil.getShortChannel(head.getFromId());
            if (channel != null){
                channel.writeAndFlush(msg);
                log.info("1v1聊天-响应发送方用户【" + head.getFromId() + "】离线消息处理结果：" + msg);
            }
            if (head.getStatusReport().equalsIgnoreCase("huawei-push")){
                String data = msg.getUnifiedEntranceMessage().getFriendChatProtocol().getStatusDetail();
                String pushToken = msg.getUnifiedEntranceMessage().getFriendChatProtocol().getRegisteredUser().getSecret();
                log.info("对用户[" + head.getToId() + "]发送华为推送透传消息,token:"+pushToken);
                IMClientUtils.cachedThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            IMServerUtil.sendTransparent(pushToken,data);
                        } catch (HuaweiMesssagingException e) {
                            log.error("对好友进行华为推送时接口异常：errorCode>"+e.getErrorCode()+e.getMessage());
                        }
                    }
                });

            }
            return;
        }

        if(IMSContacts.MsgType.GET_OFF_MESSAGE_REGIST.equals(msgType) ||(IMSContacts.MsgType.GET_OFF_MESSAGE_TOURIST.equals(msgType))){
            Channel channel = IMServerUtil.getShortChannel(head.getFromId());
            if (channel != null){
                log.info("消息服务响应用户【"+ head.getFromId() +"】获取好友离线消息, 短连接状态：" + channel.isActive());
                channel.writeAndFlush(msg);
            }else {
                log.info("消息服务响应用户【"+ head.getFromId() +"】获取好友离线消息, 短连接状态不存在");
            }
            return;
        }

        if (IMSContacts.MsgType.DEL_FRIEND_OFF_MESSAGE_REGIST.equals(msgType) ||IMSContacts.MsgType.DEL_FRIEND_OFF_MESSAGE_TOURIST.equals(msgType)){
            Channel channel = IMServerUtil.getShortChannel(head.getToId());
            if (channel != null){
                channel.writeAndFlush(msg);
            }
            return;
        }

        if (IMSContacts.MsgType.AUDIO_AND_VIDEO_CALL.equals(msgType)){
            Channel channel = IMServerUtil.getSocketChannel(head.getToId());
            if (channel != null){
                channel.writeAndFlush(msg);
            }
            return;
        }

    }

    private void printLog(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String msgType = head.getMsgType();
        switch (msgType){
        case IMSContacts.MsgType.FRIEND_CHAT_REGISTERED:
            int chatType = unifiedEntranceMessage.getFriendChatProtocol().getChatMessage().getChatType();
            if (chatType == 0) {
                log.info("消息服务响应【"+ head.getFromId() +"】发送的【"+ msgType +"】数据（chatType="+ chatType +"）：" + msg);
            }else {
                log.info("消息服务响应【"+ head.getFromId() +"】发送的【"+ msgType +"】数据（chatType="+ chatType +"）：" + head);
            }
            break;
        case IMSContacts.MsgType.GET_OFF_MESSAGE_REGIST:
            log.info("消息服务响应用户【"+ head.getFromId() +"】获取好友离线消息总数：" + msg);
            int count = unifiedEntranceMessage.getOffFriendMessageListProtocol().getRegistFriendOffMessageCount();
            log.info("消息服务响应用户【"+ head.getFromId() +"】获取好友离线消息总数：" + count);
            if (count == 0) {
                return;
            }
            List<BusinessProtocolEntities.RegistFriendOffMessage> messageList = unifiedEntranceMessage.getOffFriendMessageListProtocol().getRegistFriendOffMessageList();
            List<Map<String, String>> maps = new ArrayList<>(messageList.size());
            for (BusinessProtocolEntities.RegistFriendOffMessage v : messageList) {
                int chatType1 = v.getChatType();
                Map<String, String> map = new HashMap<>();
                map.put("msg_id", v.getMsgId());
                map.put("chat_type", chatType1 + "");
                map.put("send_user_id", v.getRegisteredFriend().getFriendUserId());
                if (!IMClientUtils.TEST.contains(chatType1)){
                    map.put("content", v.getText().getContent());
                }
                maps.add(map);
            }
            log.info("消息服务响应【"+ head.getFromId() +"】发送的【"+ msgType +"】数据：" + msg);
            log.info("消息服务响应【"+ head.getFromId() +"】发送的【"+ msgType +"】数据(获取好友离线消息)：" + IMClientUtils.toJson(maps));
            break;
        default:
            log.info("消息服务响应【"+ head.getFromId() +"】发送的【"+ msgType +"】数据：" + msg);
            break;
        }
    }

    /**
     * 事件触发器，该处用来处理客户端空闲超时,发送心跳维持连接。
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        IMClientUtils.userEventTriggered(ctx, evt, atomicInteger, "friend");
    }

    /**
     * 处理断开重连
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("与消息服务器连接断开，尝试重新连接...");
        ctx.close();
        friendChannel.close();
        FriendMessageClient.getInstance();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        log.info("channel异常" , cause);
        ctx.close();
    }
}
