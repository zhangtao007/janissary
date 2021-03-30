package com.lanjiu.im.netty.common;


import com.lanjiu.im.util.IMSContacts;
import com.lanjiu.im.util.JCRC32;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class HeartBeatRespHandler extends ChannelInboundHandlerAdapter {
    //private final Logger log = Logger.getLogger(HeartBeatRespHandler.class);
    //线程安全心跳失败计数器
    private AtomicInteger unRecPingTimes = new AtomicInteger(1);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Server msg:" + LocalDateTime.now());
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage CheckUnifiedEntranceMessage = (BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage) msg;
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = CheckUnifiedEntranceMessage.getUnifiedEntranceMessage();
        unRecPingTimes = new AtomicInteger(1);
        //接收客户端心跳信息
        if (message.getHead() != null && message.getHead().getMsgType() == IMSContacts.MsgType.HEART_PACKAGE) {
            //清零心跳失败计数器
            //log.info("server receive client" + ctx.channel().remoteAddress() + " ping msg :---->" + message);
            System.out.println("server receive client" + ctx.channel().remoteAddress() + " ping msg :---->" + message);
            //接收客户端心跳后,进行心跳响应
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage replyMsg = buildHeartBeat();
            ctx.writeAndFlush(replyMsg);
        } else {
            ctx.fireChannelRead(msg);
        }
    }
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println(info() + "server :read");
//    }
//    protected String info() {
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return System.currentTimeMillis() + " " + this.getClass().getSimpleName() + ": ";
//    }


    /**
     * 事件触发器，该处用来处理客户端空闲超时,发送心跳维持连接。
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.READER_IDLE) {
                /*读超时*/
                //log.info("===服务器端===(READER_IDLE 读超时)");
                System.out.println("===服务器端===(READER_IDLE 读超时)");
                unRecPingTimes.getAndIncrement();
                //客户端未进行ping心跳发送的次数等于3,断开此连接
                if (unRecPingTimes.intValue() == 3) {

                    //ctx.disconnect();
                    System.out.println("此客户端连接超时，服务器主动关闭此连接....");
                    System.out.println("此客户端连接超时，服务器主动关闭此连接....");
                    //log.info("此客户端连接超时，服务器主动关闭此连接....");
                }
            } else if (event.state() == IdleState.WRITER_IDLE) {
                /*服务端写超时*/
                //log.info("===服务器端===(WRITER_IDLE 写超时)");
                System.out.println("===服务器端===(WRITER_IDLE 写超时)");

            } else if (event.state() == IdleState.ALL_IDLE) {
                /*总超时*/
                //log.info("===服务器端===(ALL_IDLE 总超时)");
                System.out.println("===服务器端===(ALL_IDLE 总超时)");
            }
        }
    }


    /**
     * 创建心跳响应消息
     *
     * @return
     */
    private BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage buildHeartBeat() {
        BusinessProtocolMessageStandard.Head header = BusinessProtocolMessageStandard.Head.newBuilder().setMsgType(IMSContacts.MsgType.HEART_PACKAGE).build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder().setHead(header).build();
        //加校验码信息
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(message);
        return checkUnified;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
