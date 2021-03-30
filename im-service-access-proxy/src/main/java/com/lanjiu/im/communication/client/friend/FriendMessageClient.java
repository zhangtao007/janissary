package com.lanjiu.im.communication.client.friend;


import com.lanjiu.im.communication.client.group.GroupMessageClient;
import com.lanjiu.im.communication.util.ConfigFileOperation;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.log4j.Logger;

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
        friendChannel.writeAndFlush(checkUnifiedEntranceMessage);
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
