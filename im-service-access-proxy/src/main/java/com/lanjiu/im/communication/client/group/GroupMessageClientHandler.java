package com.lanjiu.im.communication.client.group;

import com.huawei.push.exception.HuaweiMesssagingException;
import com.huawei.push.message.AndroidConfig;
import com.huawei.push.message.Message;
import com.huawei.push.messaging.HuaweiApp;
import com.huawei.push.messaging.HuaweiMessaging;
import com.huawei.push.model.Urgency;
import com.huawei.push.reponse.SendResponse;
import com.huawei.push.util.InitAppUtils;
import com.lanjiu.im.communication.client.util.IMClientUtils;
import com.lanjiu.im.communication.util.IMServerUtil;
import com.lanjiu.im.communication.util.CheckSumResult;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import io.netty.channel.*;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static com.lanjiu.im.communication.client.group.GroupMessageClient.groupChannel;

public class GroupMessageClientHandler extends SimpleChannelInboundHandler<BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage> {

    private static final Logger log = Logger.getLogger(GroupMessageClientHandler.class);

    //线程安全心跳失败计数器
    private AtomicInteger atomicInteger = new AtomicInteger(1);

//    private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    @Override
    public void channelRead0(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) throws Exception {
        //数据包完整性校验
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String msgType = head.getMsgType();
        if (IMSContacts.MsgType.HEART_PACKAGE.equals(msgType)){
            log.info("管道ID : " + ctx.channel().id().toString() + "，请求服务地址：" + ctx.channel().remoteAddress() + "，群聊天服务心跳正常");
            //清零心跳失败计数器
            atomicInteger = new AtomicInteger(1);
            return;
        }
        CheckSumResult checkSumResult = JCRC32.checkSumValidateProtocol(msg,unifiedEntranceMessage);
        if(!checkSumResult.b_result){
            log.info("IM GroupMessageClient端数据包校验失败... ..." + msg);
            ctx.channel().writeAndFlush(IMServerUtil.requestWithResponseValidateFail(msg));
            return;
        }
        if(ResponseStatus.RESPONSE_CHECK_FAILURE.equals(unifiedEntranceMessage.getHead().getStatusReport())){
            log.info("IM GroupMessageClient端上个数据包完整性校验失败，重发，状态信息为: " + msg.getUnifiedEntranceMessage().getHead().getStatusReport());
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = JCRC32.packageCheckSum(unifiedEntranceMessage);
            ctx.writeAndFlush(checkUnified);
            return;
        }

        switch (msgType){
        case IMSContacts.MsgType.GROUP_CHAT_TOURISTS:
            int groupChatType = unifiedEntranceMessage.getGroupChatProtocol().getChatMessage().getChatType();
            if (groupChatType == 0) {
                log.info("群服务响应【"+ head.getFromId() +"】发送的【"+ msgType +"】数据（chatType="+ groupChatType +"）：" + msg);
            }else {
                log.info("群服务响应【"+ head.getFromId() +"】发送的【"+ msgType +"】数据（chatType="+ groupChatType +"）：" + head);
            }
            break;
        case IMSContacts.MsgType.GROUP_CHAT_REGISTERED:
            int chatType = unifiedEntranceMessage.getGroupChatProtocol().getChatMessage().getChatType();
            if (chatType == 0) {
                log.info("群服务响应【"+ head.getFromId() +"】发送的【"+ msgType +"】数据（chatType="+ chatType +"）：" + msg);
            }else {
                log.info("群服务响应【"+ head.getFromId() +"】发送的【"+ msgType +"】数据（chatType="+ chatType +"）：" + head);
            }
            break;
//        case IMSContacts.MsgType.GROUP_CHART_OFF_LINE_MSG:
//            int count = unifiedEntranceMessage.getOfflineGroupMessageProtocol().getGroupOfflineMessageCount();
//            log.info("群服务响应【"+ head.getFromId() +"】发送的【"+ msgType +"】数据（获取群离线数据）：" + count);
//            break;
        case IMSContacts.MsgType.RES_ONLINE_USER_DEL_GROUP_MSG:
            String groupId = unifiedEntranceMessage.getDelGroupOffMessageProtocol().getGroupId();
            log.info("群服务响应【"+ head.getFromId() +"】对群【"+ groupId +"】用户【"+ head.getToId() +"】发送的撤回消息指令：" + msg);
            break;
        case IMSContacts.MsgType.AUDIO_AND_VIDEO_CALL:
            int type = unifiedEntranceMessage.getGroupChatProtocol().getChatMessage().getChatType();
            if (type == 0) {
                log.info("群服务响应【"+ head.getFromId() +"】发送的【"+ msgType +"】数据（chatType="+ type +"）：" + msg);
            }else {
                log.info("群服务响应【"+ head.getFromId() +"】发送的【"+ msgType +"】数据（chatType="+ type +"）：" + head);
            }
            break;
        default:
            log.info("群服务响应【"+ head.getFromId() +"】发送的【"+ msgType +"】数据：" + msg);
            break;
        }

        // 响应群聊天消息发送人
        if(IMSContacts.MsgType.GROUP_CHART_SEND_NOTIFY.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(IMServerUtil.responseSuccessfulMsg(msg));
            }
            return;
        }


        // 【abandon】拉取群离线消息
        if (IMSContacts.MsgType.GROUP_CHART_OFF_LINE_MSG.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(IMServerUtil.responseOffLineGroupMsg(msg));
            }
            return;
        }

        // 拒绝入群申请
        if (IMSContacts.MsgType.GROUP_MEMBER_APPLY_REFUSE_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_MEMBER_APPLY_REFUSE_REGISTERED.equals(msgType)){
            ctx.channel().writeAndFlush(msg);
            return;
        }

        // 群聊天消息撤回/删除--响应发送方
        if (IMSContacts.MsgType.DEL_GROUP_MSG.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        // 响应在线群用户聊天消息撤回/删除--响应接收方
        if (IMSContacts.MsgType.RES_ONLINE_USER_DEL_GROUP_MSG.equals(msgType)){
            Channel socketChannel = IMServerUtil.getSocketChannel(head.getToId());
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setDelGroupOffMessageProtocol(BusinessProtocolMessages.DelGroupOffMessageProtocol.newBuilder(unifiedEntranceMessage.getDelGroupOffMessageProtocol()).build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder(head).setMsgType(IMSContacts.MsgType.DEL_GROUP_MSG).build())
                    .build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage entranceMessage = JCRC32.packageCheckSum(message);
            if (socketChannel != null){
                log.info("群用户【"+head.getToId()+"】在线，发送撤回消息数据：" + entranceMessage);
                IMServerUtil.writeAndFlushMsgGroup(socketChannel, head.getToId(), entranceMessage);
            }else {
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage saveMessage = IMServerUtil.delGroupMsgStorage(message);
                log.info("群用户【"+head.getToId()+"】离线，保存撤回消息数据：" + saveMessage);
                GroupMessageClient.sendGroupMessageServer(saveMessage);
            }
            return;
        }

        // 多人聊天(群聊)
        if (IMSContacts.MsgType.GROUP_CHAT_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_CHAT_REGISTERED.equals(msgType)){
            Channel socketChannel = IMServerUtil.getSocketChannel(head.getToId());
            String groupId = msg.getUnifiedEntranceMessage().getGroupChatProtocol().getRegisteredGroupMember().getGroup().getGroupId();
            log.info("群"+groupId+"用户[" + head.getToId() + "]接收聊天消息");
            if (socketChannel == null){
                if (head.getStatusReport().equalsIgnoreCase("huawei-push")){
                    String data = msg.getUnifiedEntranceMessage().getGroupChatProtocol().getStatusDetail();
                    String pushToken = msg.getUnifiedEntranceMessage().getGroupChatProtocol().getAt();
                    log.info("对群"+groupId+"用户[" + head.getToId() + "]发送华为推送透传消息");

                    IMClientUtils.cachedThreadPool.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                IMServerUtil.sendTransparent(pushToken,data);
                            } catch (HuaweiMesssagingException e) {
                                log.error("对群成员：["+head.getToId()+"] 发送华为推送消息异常，"+e.getErrorCode()+e.getMessage() +",token："+pushToken);
                            }
                        }
                    });
                    return;
                }
                log.info("离线用户【"+ head.getToId() +"】接收的群消息数据");
                GroupMessageClient.sendGroupMessageServer(IMServerUtil.groupMsgStorage(msg));
            }else {
                log.info("在线用户【"+ head.getToId() +"】接收的群消息数据");
                IMServerUtil.writeAndFlushMsgGroup(socketChannel, head.getToId(), msg);
            }
        }

        //音视频通话响应
        if (IMSContacts.MsgType.AUDIO_AND_VIDEO_CALL.equals(msgType) ){
            Channel socketChannel = IMServerUtil.getSocketChannel(head.getToId());
            String groupId = msg.getUnifiedEntranceMessage().getAudioAndVideoCallProtocol().getToGroup().getGroupId();
            log.info("群"+groupId+"用户[" + head.getToId() + "]接收音视频通话消息");
            if (socketChannel == null){
                if (head.getStatusReport().equals(IMSContacts.OnlineState.ONLINE)){
                    log.error("上线推送失败，重连时再次推送");
                    return;
                }
                log.info("离线用户【"+ head.getToId() +"】接收的群音视频通话消息数据");
                GroupMessageClient.sendGroupMessageServer(IMServerUtil.savaMsgOffUser(msg));
            }else {
                log.info("在线用户【"+ head.getToId() +"】接收的群音视频通话消息数据");
                IMServerUtil.writeAndFlushMsgGroup(socketChannel, head.getToId(), msg);
            }
        }

    }




    /**
     * 事件触发器，该处用来处理客户端空闲超时,发送心跳维持连接。
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        IMClientUtils.userEventTriggered(ctx, evt, atomicInteger, "group");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("channel异常" , cause);
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 处理断开重连
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("与群服务器连接断开，尝试重新连接...");
        ctx.close();
        groupChannel.close();
        GroupMessageClient.linkGroupMessageServer();
    }
}
