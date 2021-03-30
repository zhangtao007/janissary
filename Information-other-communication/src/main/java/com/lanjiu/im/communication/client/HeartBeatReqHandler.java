package com.lanjiu.im.communication.client;

import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class HeartBeatReqHandler extends ChannelInboundHandlerAdapter {
    //private  final Logger log=Logger.getLogger(HeartBeatReqHandler.class);
    //ChannelHandlerAdapter

    //线程安全心跳失败计数器
    private AtomicInteger unRecPongTimes = new AtomicInteger(1);


    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("Client msg:" + LocalDateTime.now());
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage CheckUnifiedEntranceMessage = (BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage) msg;
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = CheckUnifiedEntranceMessage.getUnifiedEntranceMessage();
        //服务器端心跳回复
        if(message != null  && message.getHead().getMsgType() == IMSContacts.MsgType.HEART_PACKAGE){
            //如果服务器进行pong心跳回复，则清零失败心跳计数器
            unRecPongTimes = new AtomicInteger(1);
            //log.debug("client receive server pong msg :---->"+message);
            System.out.println("client receive server pong msg :---->"+message);
        }else{
            ctx.fireChannelRead(msg);
        }
    }
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println(info() + "client :read");
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
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.READER_IDLE) {
                /*读超时*/
                //log.info("===客户端===(READER_IDLE 读超时)");
                System.out.println("===客户端===(READER_IDLE 读超时)");
            } else if (event.state() == IdleState.WRITER_IDLE) {
                /*客户端写超时*/
                //log.info("===客户端===(WRITER_IDLE 写超时)");
                System.out.println("===客户端===(WRITER_IDLE 写超时)");
                unRecPongTimes.getAndIncrement();
                //服务端未进行pong心跳响应的次数小于3,则进行发送心跳，否则则断开连接。
                if(unRecPongTimes.intValue() < 3){
                    //发送心跳，维持连接
                    //加校验码信息
                    BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage replyMsg = buildHeartBeat();
                    ctx.channel().writeAndFlush(replyMsg) ;
                    //log.info("客户端：发送心跳");
                    System.out.println("客户端：发送心跳");
                }else{
                    //ctx.channel().close();
                }
            } else if (event.state() == IdleState.ALL_IDLE) {
                /*总超时*/
                //log.info("===客户端===(ALL_IDLE 总超时)");
                System.out.println("===客户端===(ALL_IDLE 总超时)");
            }
        }
    }

    private BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage buildHeartBeat(){
        BusinessProtocolMessageStandard.Head header = BusinessProtocolMessageStandard.Head.newBuilder().setMsgType(IMSContacts.MsgType.HEART_PACKAGE).build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder().setHead(header).build();
        //加校验码信息
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(message);
        return checkUnified;
    }

    /**
     * 异常处理
     */
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)throws Exception{
        //ctx.fireExceptionCaught(cause);
        cause.printStackTrace();
        ctx.close();
    }

}

