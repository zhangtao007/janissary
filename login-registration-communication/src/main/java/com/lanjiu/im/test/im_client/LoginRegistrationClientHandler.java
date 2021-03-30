package com.lanjiu.im.test.im_client;


import com.lanjiu.im.util.IMSContacts;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

import static com.lanjiu.im.test.im_client.LoginClient.channelLoginRegistrationGroup;

public class LoginRegistrationClientHandler extends SimpleChannelInboundHandler<BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage> {

    private final Logger log = LoggerFactory.getLogger(LoginRegistrationClientHandler.class);
    //线程安全心跳失败计数器
    private AtomicInteger unRecPongTimes = new AtomicInteger(1);
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) throws Exception {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String msgType = head.getMsgType();
        if (IMSContacts.MsgType.HEART_PACKAGE.equals(msgType)){
            log.info("管道ID : " + ctx.channel().id().toString() + "，请求服务地址：" + ctx.channel().remoteAddress() + "，登录服务心跳正常");
            //清零心跳失败计数器
            unRecPongTimes = new AtomicInteger(1);
            return;
        }
//        System.out.println("测试响应："+msg);
        log.info("登录服务响应数据：" + msg);
        log.info("登录服务响应数据类型：" + msgType);
        log.info("登录服务响应数据管道ID : " + ctx.channel().id().toString());
        log.info("登录服务响应数据请求用户ID : " + head.getFromId());
        return;

    }

    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel(); //获取新增连接对象
        channelLoginRegistrationGroup.add(channel);//将新增连接加到组中.
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.info("注销的登录服务channel：" + ctx.channel().id());
        channelLoginRegistrationGroup.remove(ctx.channel());
    }
}
