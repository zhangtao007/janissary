package com.lanjiu.im.communication.client.group;

import com.lanjiu.im.communication.util.ConfigFileOperation;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.log4j.Logger;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class GroupMessageClient {

    private static final Logger log = Logger.getLogger(GroupMessageClient.class);

    volatile static Channel groupChannel = null;

    public static void getInstance() throws Exception {
        if (groupChannel != null && groupChannel.isActive()) return;
        synchronized (GroupMessageClient.class) {
            if(groupChannel == null || !groupChannel.isActive()){
                linkGroupMessageServer();
            }
        }
    }

    public static void sendGroupMessageServer(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) throws Exception {
        if(groupChannel == null || !groupChannel.isActive()){
            String msgType = checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead().getMsgType();
            log.info("群组服务异常，发送数据类型：" + msgType);
            throw new Exception("群组服务异常");
        }
        groupChannel.writeAndFlush(checkUnifiedEntranceMessage);
    }

    static void linkGroupMessageServer() throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        Properties properties = configFileOperation.getGroupMessageServerConfig();
        int port = Integer.valueOf(properties.getProperty("server_port"));
        String address = properties.getProperty("server_address");
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, Boolean.TRUE)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new GroupMessageChannelInitializer());
            doConnect(bootstrap, port, address);
        } catch (Exception e) {
            log.info("群聊天服务连接异常");
            e.printStackTrace();
            eventLoopGroup.shutdownGracefully();
            linkGroupMessageServer();
            throw new Exception(e.getMessage());
        }
    }

    private static void doConnect(Bootstrap bootstrap, int port, String address) {
        if (groupChannel != null && groupChannel.isActive()) {
            return;
        }
        bootstrap.connect(address, port).addListener((ChannelFutureListener) future -> {
            if (future.isSuccess()){
                log.info("群聊天服务连接成功");
                groupChannel = future.channel();
            }else {
                log.info("群聊天服务连接失败");
                future.channel().eventLoop().schedule(() -> doConnect(bootstrap, port, address), 10, TimeUnit.SECONDS);
            }
        });
    }
}
