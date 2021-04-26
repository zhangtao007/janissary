package com.lanjiu.im.communication.client.friend;


import com.lanjiu.im.communication.client.group.GroupMessageClient;
import com.lanjiu.im.communication.client.util.IMClientUtils;
import com.lanjiu.im.communication.util.ConfigFileOperation;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.IMServerUtil;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.log4j.Logger;

import java.time.Clock;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class FriendMessageClient {

    private static final Logger log = Logger.getLogger(FriendMessageClient.class);

    volatile static Channel friendChannel = null;

    public static void getInstance() throws Exception {
        if (friendChannel != null && friendChannel.isActive()) return;
        synchronized (GroupMessageClient.class) {
            if(friendChannel == null || !friendChannel.isActive()){
                initLinkFriendServer();
            }
        }
    }

    public static void sendFriendServer(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) throws Exception {
        if(friendChannel == null || !friendChannel.isActive()){
            String msgType = checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead().getMsgType();
            log.info("消息服务异常，发送数据类型：" + msgType + "channel:" + friendChannel);
            throw new Exception("消息服务异常");
        }
        ChannelFuture chfure = friendChannel.writeAndFlush(checkUnifiedEntranceMessage);
        long nowTime = Clock.systemUTC().millis();
        if (checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead().getMsgType().equals(IMSContacts.MsgType.GET_OFF_MESSAGE_REGIST)){
            chfure.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    long ioTime = Clock.systemUTC().millis() - nowTime;
                    log.warn("[send to FRIEND-SERVER  io time is: 【"+ioTime +"】,fromId:"+checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead().getFromId());
                }
            });
        }
    }

    private static void initLinkFriendServer() throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            ConfigFileOperation configFileOperation = new ConfigFileOperation();
            Properties properties = configFileOperation.getFriendMessageServerConfig();
            int port = Integer.valueOf(properties.getProperty("server_port"));
            String address = properties.getProperty("server_address");
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, Boolean.TRUE)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new FriendMessageChannelInitializer());
            doConnect(bootstrap, port, address);
        } catch (Exception e) {
            eventLoopGroup.shutdownGracefully();
            initLinkFriendServer();
            throw new Exception(e.getMessage());
        }
    }

    private static void doConnect(Bootstrap bootstrap, int port, String address) {
        if (friendChannel != null && friendChannel.isActive()) {
            return;
        }
        bootstrap.connect(address, port).addListener((ChannelFutureListener) future -> {
            if (future.isSuccess()){
                log.info("消息服务连接成功");
                friendChannel = future.channel();
            }else {
                log.info("消息服务连接失败");
                future.channel().eventLoop().schedule(() -> doConnect(bootstrap, port, address), 0, TimeUnit.SECONDS);
            }
        });
    }
}
