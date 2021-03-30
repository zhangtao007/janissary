package com.lanjiu.im.communication.server;

import com.lanjiu.im.communication.client.friend.FriendMessageClient;
import com.lanjiu.im.communication.client.group.GroupMessageClient;
import com.lanjiu.im.communication.client.information.InformationClient;
import com.lanjiu.im.communication.client.login.LoginRegistrationClient;
import com.lanjiu.im.communication.util.ConfigFileOperation;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.Properties;

public class IMServer {

    public static void main(String[] args) {
        try {
            runIMServer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void runIMServer() throws Exception{
        //针对Socket编程中，服务器与多客户端连接,交互的事例，偏重于客户端与服务端的交互;不填参数，会给一个默认的参数
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        Properties properties = configFileOperation.getImServerConfig();
        int port = Integer.valueOf(properties.getProperty("server_port"));

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // handler针对的是bossGroup
            serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
            // childHandler针对的时workerGroup
            .childHandler(new IMServerInitializer())
            //socketchannel的设置,维持链接的活跃，清除死链接
            .childOption(ChannelOption.SO_KEEPALIVE, true)
            //socketchannel的设置,关闭延迟发送
            .childOption(ChannelOption.TCP_NODELAY, true);
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            channelFuture.addListener((ChannelFutureListener) future -> {
                if (future.isSuccess()){
                    LoginRegistrationClient.getInstance();
                    FriendMessageClient.getInstance();
                    InformationClient.getInstance();
                    GroupMessageClient.getInstance();
                }
            });
            channelFuture.channel().closeFuture().syncUninterruptibly();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


}
