package com.lanjiu.im.communication.client.information;

import com.lanjiu.im.communication.client.group.GroupMessageClient;
import com.lanjiu.im.communication.util.ConfigFileOperation;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.log4j.Logger;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class InformationClient {

    private static final Logger log = Logger.getLogger(InformationClient.class);

    volatile static Channel infoChannel = null;

    public static void getInstance() throws Exception {
        if (infoChannel != null && infoChannel.isActive()) return;
        synchronized (InformationClient.class) {
            if(infoChannel == null || !infoChannel.isActive()){
                initLinkInfoServer();
            }
        }
    }
    public static void sendInformationServer(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) throws Exception {
        if(infoChannel == null || !infoChannel.isActive()){
            String msgType = checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead().getMsgType();
            log.info("资料服务异常，发送数据类型：" + msgType);
            throw new Exception("资料服务异常");
        }
        infoChannel.writeAndFlush(checkUnifiedEntranceMessage);
    }

    private static void initLinkInfoServer() throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            ConfigFileOperation configFileOperation = new ConfigFileOperation();
            Properties properties = configFileOperation.getInformationServerConfig();
            int port = Integer.valueOf(properties.getProperty("server_port"));
            String address = properties.getProperty("server_address");
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, Boolean.TRUE)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new InformationChannelInitializer());
            doConnect(bootstrap, port, address);
        } catch (Exception e) {
            log.info("资料服务连接异常");
            e.printStackTrace();
            eventLoopGroup.shutdownGracefully();
            initLinkInfoServer();
            throw new Exception(e.getMessage());
        }
    }

    private static void doConnect(Bootstrap bootstrap, int port, String address) {
        if (infoChannel != null && infoChannel.isActive()) {
            return;
        }
        bootstrap.connect(address, port).addListener((ChannelFutureListener) future -> {
            if (future.isSuccess()){
                log.info("资料服务连接成功");
                infoChannel = future.channel();
            }else {
                log.info("资料服务连接失败");
                future.channel().eventLoop().schedule(() -> doConnect(bootstrap, port, address), 0, TimeUnit.SECONDS);
            }
        });
    }

}
