package com.lanjiu.im.communication.server;

import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

public class HeartBeatRespHandler extends ChannelInboundHandlerAdapter {
    
    private final Logger log = Logger.getLogger(HeartBeatRespHandler.class);
    //线程安全心跳失败计数器
    private AtomicInteger unRecPingTimes = new AtomicInteger(1);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        beatHeartPackageSend(ctx, msg);
    }

    /**
     * 事件触发器，该处用来处理客户端空闲超时,发送心跳维持连接。
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.READER_IDLE) {
                log.info("===服务器端===(READER_IDLE 读超时)");
                unRecPingTimes.getAndIncrement();
                //客户端未进行ping心跳发送的次数等于3,断开此连接
                if (unRecPingTimes.intValue() == 3) {
                }
            } else if (event.state() == IdleState.WRITER_IDLE) {
                log.info("===服务器端===(WRITER_IDLE 写超时)");

            } else if (event.state() == IdleState.ALL_IDLE) {
                log.info("===服务器端===(ALL_IDLE 总超时)");
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

//    /**
//     * 创建心跳响应消息
//     *
//     * @return
//     */
//    private BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage buildHeartBeat() {
//        BusinessProtocolMessageStandard.Head header = BusinessProtocolMessageStandard.Head.newBuilder().setMsgType(IMSContacts.MsgType.HEART_PACKAGE).build();
//        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder().setHead(header).build();
//        //加校验码信息
//        JCRC32 jcrc32 = new JCRC32();
//        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(message);
//        return checkUnified;
//    }

    /**
     * 创建心跳包响应消息
     * */
    private BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage buildHeartBeat(){
        BusinessProtocolMessageStandard.Head header = BusinessProtocolMessageStandard.Head.newBuilder().setMsgType(IMSContacts.MsgType.HEART_PACKAGE).build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder().setHead(header).build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.newBuilder()
                .setUnifiedEntranceMessage(message).build();
        return checkUnifiedEntranceMessage;
    }

    public void beatHeartPackageSend(ChannelHandlerContext ctx, Object msg){
        //log.info("Server msg:" + LocalDateTime.now());
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage CheckUnifiedEntranceMessage = (BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage) msg;
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = CheckUnifiedEntranceMessage.getUnifiedEntranceMessage();
        //接收客户端心跳信息
        if (message.getHead() != null && message.getHead().getMsgType().equals(IMSContacts.MsgType.HEART_PACKAGE)) {
            //清零心跳失败计数器
            unRecPingTimes = new AtomicInteger(1);
            //log.info("server receive client" + ctx.channel().remoteAddress() + " ping msg :---->" + message);
            //接收客户端心跳后,进行心跳响应
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage replyMsg = buildHeartBeat();
            ctx.writeAndFlush(replyMsg);
        } else {
            ctx.fireChannelRead(msg);
        }
    }
}
