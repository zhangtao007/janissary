package com.lanjiu.im.communication.client.util;

import com.google.gson.Gson;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class IMClientUtils {

    private static final Logger log = Logger.getLogger(IMClientUtils.class);

    public static ExecutorService cachedThreadPool = new ThreadPoolExecutor(20,200,60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(1024));

    /**
     * 创建心跳包请求消息
     * */
    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage buildHeartBeat(){
        BusinessProtocolMessageStandard.Head header = BusinessProtocolMessageStandard.Head.newBuilder().setMsgType(IMSContacts.MsgType.HEART_PACKAGE).build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder().setHead(header).build();
        return BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.newBuilder().setUnifiedEntranceMessage(message).build();
    }

    public static void userEventTriggered(ChannelHandlerContext ctx, Object evt, AtomicInteger atomicInteger, String flage) {
        if (flage.equals("login")){
            log.info("空闲次数：" + atomicInteger);
        }
        if (evt instanceof IdleStateEvent){
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
            case READER_IDLE:

                break;
            case WRITER_IDLE:

                break;
            case ALL_IDLE:
                sendHeartBeat(ctx, atomicInteger);
                break;
            }
        }
    }

    private static void sendHeartBeat(ChannelHandlerContext ctx, AtomicInteger atomicInteger) {
        if (atomicInteger.intValue() > 2 ) {
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage replyMsg = buildHeartBeat();
            ctx.channel().writeAndFlush(replyMsg);
        }
    }

    public static List<Integer> TEST = new ArrayList<Integer>(4){
        {
            this.add(1);
            this.add(2);
            this.add(3);
            this.add(4);
        }
    };

    private static Gson gson = new Gson();

    public static String toJson(List<Map<String, String>> list){
        return gson.toJson(list);
    }
}
