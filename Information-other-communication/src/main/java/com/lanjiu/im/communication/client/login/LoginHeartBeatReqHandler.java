package com.lanjiu.im.communication.client.login;

import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class LoginHeartBeatReqHandler extends ChannelInboundHandlerAdapter {
    //private  final Logger log=Logger.getLogger(HeartBeatReqHandler.class);
    //ChannelHandlerAdapter

    private final Logger log = Logger.getLogger(LoginHeartBeatReqHandler.class);
    //线程安全心跳失败计数器
    private AtomicInteger unRecPongTimes = new AtomicInteger(1);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        recieveBeatHeatPackage(ctx, msg);
    }

    /**
     * 事件触发器，该处用来处理客户端空闲超时,发送心跳维持连接。
     */
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.READER_IDLE) {
                log.info("===客户端===(READER_IDLE 读超时)");
            } else if (event.state() == IdleState.WRITER_IDLE) {
                log.info("===客户端===(WRITER_IDLE 写超时)");
                unRecPongTimes.getAndIncrement();
                //服务端未进行pong心跳响应的次数小于3,则进行发送心跳，否则则断开连接。
                if(unRecPongTimes.intValue() < 3){
                    //发送心跳，维持连接
                    BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage replyMsg = buildHeartBeat();
                    ctx.channel().writeAndFlush(replyMsg) ;
                    log.info("客户端：发送心跳");
                }else{
                    ctx.channel().close();
                    log.info("断开当前失效连接，下次请求时，新建连接");
                }
                log.info("unRecPongTimes.intValue:  " + unRecPongTimes.intValue());
            } else if (event.state() == IdleState.ALL_IDLE) {
                log.info("===客户端===(ALL_IDLE 总超时)");
            }
        }
    }

    /**
     * 创建心跳包请求消息
    * */
    private BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage buildHeartBeat(){
        BusinessProtocolMessageStandard.Head header = BusinessProtocolMessageStandard.Head.newBuilder().setMsgType(IMSContacts.MsgType.HEART_PACKAGE).build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder().setHead(header).build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.newBuilder()
                .setUnifiedEntranceMessage(message).build();
        return checkUnifiedEntranceMessage;
    }

    /**
     * 异常处理
     */
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    public void recieveBeatHeatPackage(ChannelHandlerContext ctx, Object msg){
        log.info("Client msg:" + LocalDateTime.now());
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage CheckUnifiedEntranceMessage = (BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage) msg;
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = CheckUnifiedEntranceMessage.getUnifiedEntranceMessage();
        //服务器端心跳回复
        if(message != null  && message.getHead().getMsgType().equals(IMSContacts.MsgType.HEART_PACKAGE)){
            //清零心跳失败计数器
            unRecPongTimes = new AtomicInteger(1);
            log.info("client receive server pong msg :---->"+message);
            //ctx.fireUserEventTriggered(IdleState.READER_IDLE);
        }else{
            ctx.fireChannelRead(msg);
        }
    }

}

