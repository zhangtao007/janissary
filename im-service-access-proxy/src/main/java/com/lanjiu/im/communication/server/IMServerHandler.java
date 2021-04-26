package com.lanjiu.im.communication.server;

import com.lanjiu.im.communication.client.friend.FriendMessageClient;
import com.lanjiu.im.communication.client.group.GroupMessageClient;
import com.lanjiu.im.communication.client.login.LoginRegistrationClient;
import com.lanjiu.im.communication.util.*;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import io.netty.util.internal.StringUtil;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.lanjiu.im.communication.util.ChannelList.*;

public class IMServerHandler extends SimpleChannelInboundHandler<BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage> {

    private final Logger log = Logger.getLogger(IMServerHandler.class);

    private static final Pattern pattern = Pattern.compile("^\\d{9}$");

    private int initHartNum = 0;

    private String userId;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg){
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String msgType = head.getMsgType();
        if (IMSContacts.MsgType.SERVER_HEART_PACKAGE.equalsIgnoreCase(msgType)){
            String key = IMServerUtil.msgKey(head);
            log.info("用户【"+ head.getFromId() +"】确认接收【"+ msgType +"】长连接在线回执，key【"+key+"】：" + msg);
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage entranceMessage = msgMap.get(key);
            if (entranceMessage == null){
                return;
            }
            Channel shortChannel = IMServerUtil.getShortChannel(head.getToId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(IMServerUtil.responseSuccessfulMsg(entranceMessage));
            }
            msgMap.remove(key);
            return;
        }
        if (ResponseStatus.STATUS_REPORT_RECEIPT.equalsIgnoreCase(head.getStatusReport())){
            String key = IMServerUtil.msgKey(head);
            if ( IMSContacts.MsgType.DEL_ON_LINE_RECEIVE.equals(head.getMsgType())){
                log.info("用户【"+ head.getFromId() +"】确认接收【"+ msgType +"】清理在线消息的回执，key【"+key+"】：" + msg);
                try {
                    FriendMessageClient.sendFriendServer(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                msgMap.remove(key);

            }else { //todo
                log.info("用户【"+ head.getFromId() +"】确认接收【"+ msgType +"】在线消息的回执，key【"+key+"】：" + msg);
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage entranceMessage = msgMap.get(key);
                BusinessProtocolMessageStandard.UnifiedEntranceMessage build = null;
                if (entranceMessage == null){
                        BusinessProtocolMessageStandard.Head buildHead = BusinessProtocolMessageStandard.Head.newBuilder(head)
                                .setMsgType(IMSContacts.MsgType.DEL_GROUP_OFF_LINE_MSG_STORAGE).build();
                        build= BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                                .setHead(buildHead)
                                .setDelGroupOffMessageProtocol(BusinessProtocolMessages.DelGroupOffMessageProtocol.newBuilder())
                                .build();

                    try {
                        GroupMessageClient.sendGroupMessageServer(JCRC32.packageCheckSum(build));
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("系统异常：" + e);
                    }
                    return;
                }
                msgMap.remove(key);
            }
            return;
        }
        if (ResponseStatus.STATUS_REPORT_RECEIPT_OFFLINE.equalsIgnoreCase(head.getStatusReport())){
            log.info("用户【"+ head.getFromId() +"】确认接收到【"+ msgType +"】离线消息的回执(删除离线消息)：" + msg);
            try {
                if (IMSContacts.MsgType.GROUP_CHART_OFF_LINE_MSG.equals(head.getMsgType())){
                    GroupMessageClient.sendGroupMessageServer(IMServerUtil.deleteOffLineGroupMsg(msg));
                }else if(ResponseStatus.GROUP_CALL_ACK.equals(head.getToken())){//群音视频通话消息ack
                    log.info("用户【"+ head.getToId() +"】确认接收到群音视频通话消息【"+ msgType +"】离线消息的回执(删除离线消息)：" + msg);
                    GroupMessageClient.sendGroupMessageServer(IMServerUtil.deleteGroupAudioCallIndex(msg));
                }else {
                    FriendMessageClient.sendFriendServer(msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error("删除离线消息-系统异常：" + e);
            }
            return;
        }




        //数据包完整性校验
        CheckSumResult checkSumResult = JCRC32.checkSumValidateProtocol(msg,unifiedEntranceMessage);
        if(!checkSumResult.b_result && !IMSContacts.MsgType.HEART_PACKAGE_PHONE.equals(msgType) && !IMSContacts.MsgType.HEART_PACKAGE_PHONE_END.equals(msgType)){
            log.info("IM Server端数据包校验失败(心跳包数据无需效验)... ...");
            ctx.channel().writeAndFlush(IMServerUtil.requestWithResponseValidateFail(msg));
            return;
        }
        if(ResponseStatus.RESPONSE_CHECK_FAILURE.equals(head.getStatusReport())){
            log.info("上个数据包完整性校验失败，重发" + msg);
            ctx.channel().writeAndFlush(IMServerUtil.responseFailMsg(msg));
            return;
        }
        if (IMSContacts.MsgType.HEART_PACKAGE_PHONE.equals(msgType)){
            Matcher isNum = pattern.matcher(head.getFromId());
            if (!isNum.matches()){
                ctx.channel().writeAndFlush(IMServerUtil.returnHeartBeat(head));
                return;
            }

            if (initHartNum == 0){
                log.info("用户【"+head.getFromId()+"】第一次长连接"+ ctx.channel().id().toString());
                userId = head.getFromId();
                socketChannelGroup.put(userId, ctx.channel());
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage userOnLineMsg = IMServerUtil.getUserOnLineMsg(head.getFromId().substring(0, head.getFromId().length() - 1), IMSContacts.OnlineState.ONLINE, true);
                log.info("用户【"+ userId +"】上线通知：" + userOnLineMsg);
                IMServerUtil.sendLoginRegistrationServer(ctx, userOnLineMsg);
                log.info("用户【"+ userId +"】上线通知登录服务完成");
                IMServerUtil.sendFriendMessageServer(ctx, userOnLineMsg);
                log.info("用户【"+ userId +"】上线通知消息服务完成");
                //todo  通知群服务进行上线推送音视频通话消息
                IMServerUtil.sendMessageGroupServer(ctx,userOnLineMsg);
                log.info("用户【"+ userId +"】上线通知群消息服务完成");
                userMacMap.put(userId, head.getToken());
                macChannelMap.put(head.getToken(), ctx.channel());
            }
            ctx.channel().writeAndFlush(IMServerUtil.buildHeartBeat(head));
            initHartNum ++;
            return;
        }
        shortChannelGroup.put(head.getFromId(), ctx.channel());
        MsgToDistributionOnline.msgToDistributionOnline(ctx, msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
     /*   IMServerUtil.scheduledService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Iterator<EventExecutor> iteratorGroups = ctx.executor().parent().iterator();
                while (iteratorGroups.hasNext()){
                    SingleThreadEventExecutor next = (SingleThreadEventExecutor)iteratorGroups.next();
                    int size = next.pendingTasks();
                    if(next == ctx.executor()){
                        log.warn(ctx.channel().id() +"--> "+next+" pending size in queue is : --> "+size);
                    }else{
                        log.warn(next+" pending size in queue is : --> "+size);
                    }

                }
            }
        },0,1000, TimeUnit.MILLISECONDS);*/
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        socketChannelGroup.values().remove(channel);
        shortChannelGroup.values().remove(channel);
        if (!StringUtil.isNullOrEmpty(userId)){
            userMacMap.remove(userId);
            String mac = userMacMap.get(userId);
            if (!StringUtil.isNullOrEmpty(mac)){
                macChannelMap.remove(mac);
            }
        }
        initHartNum = 0;
        ctx.close();
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        if (!StringUtil.isNullOrEmpty(userId) && userId.length() == 9){
            log.info("客户端用户[" + userId + "]下线，长连接中断，删除channel：");
            IMServerUtil.sendLoginRegistrationServer(ctx, IMServerUtil.getUserOnLineMsg(userId.substring(0, 8), IMSContacts.OnlineState.OFFLINE,false));
        }
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        log.info(cause);
        ctx.close();
    }
}
