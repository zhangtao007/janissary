package com.lanjiu.im.communication.client.login;

import com.lanjiu.im.communication.client.information.InformationClient;
import com.lanjiu.im.communication.util.ConfigFileOperation;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.log4j.Logger;

import java.time.Clock;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginRegistrationClient {

    private static final Logger log = Logger.getLogger(LoginRegistrationClient.class.getName());

    volatile static Channel loginChannel = null;

    public static void getInstance() throws Exception {
        if (loginChannel != null && loginChannel.isActive()) return;
        synchronized (InformationClient.class) {
            if(loginChannel == null || !loginChannel.isActive()){
                linkLoginServer();
            }
        }
    }

    public static void sendLoginServer(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) throws Exception {
        if(loginChannel == null){
            String msgType = checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead().getMsgType();
            log.info("登录服务服务异常，发送数据类型：" + msgType + "channel：" + loginChannel);
            throw new Exception("登录服务异常");
        }

        if(!loginChannel.isActive()){
            BusinessProtocolMessageStandard.Head head = checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead();
            String msgType = head.getMsgType();
            log.info("向登录服务服务转发用户【"+head.getFromId()+"】-【"+msgType+"】请求异常" + msgType);
            throw new Exception("登录服务异常");
        }
        ChannelFuture loginFuture = loginChannel.writeAndFlush(checkUnifiedEntranceMessage);
        long nowTime = Clock.systemUTC().millis();
        if (checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead().getMsgType().equals(IMSContacts.MsgType.LOGIN_REGISTERED)){
            loginFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    long ioTime = Clock.systemUTC().millis() - nowTime;
                    log.warn("[send to LOGIN-SERVER  io time is: 【"+ioTime +"】,fromId:"+checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead().getFromId());
                }
            });
        }

    }

    private static void linkLoginServer() throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            ConfigFileOperation configFileOperation = new ConfigFileOperation();
            Properties properties = configFileOperation.getLoginRegistrationServerConfig();
            int port = Integer.valueOf(properties.getProperty("server_port"));
            String address = properties.getProperty("server_address");
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, Boolean.TRUE)
                    .handler(new LoginRegistrationClientInitializer());//客户端不能使用childHandler,只能使用Handler
            doConnect(bootstrap, port, address);
        } catch (Exception e) {
            e.printStackTrace();
            eventLoopGroup.shutdownGracefully();
            linkLoginServer();
            throw new Exception(e.getMessage());
        }
    }

    private static void doConnect(Bootstrap bootstrap, int port, String address) {
        if (loginChannel != null && loginChannel.isActive()) {
            return;
        }
        bootstrap.connect(address, port).addListener((ChannelFutureListener) future -> {
            if (future.isSuccess()){
                log.info("登录服务连接成功");
                loginChannel = future.channel();
            }else {
                log.info("登录服务连接失败");
                future.channel().eventLoop().schedule(() -> doConnect(bootstrap, port, address), 0, TimeUnit.SECONDS);
            }
        });
    }

}
