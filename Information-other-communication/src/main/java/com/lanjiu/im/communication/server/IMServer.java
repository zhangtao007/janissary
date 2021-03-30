package com.lanjiu.im.communication.server;

import com.lanjiu.im.communication.util.ConfigFileOperation;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.Properties;

public class IMServer {

    public static void main(String[] args) throws Exception {
        runIMServer();
    }

    public static void runIMServer() throws Exception{
        //针对Socket编程中，服务器与多客户端连接,交互的事例，偏重于客户端与服务端的交互
//        EventLoopGroup bossGroup = new NioEventLoopGroup(1);//不填参数，会给一个默认的参数
//        EventLoopGroup workerGroup = new NioEventLoopGroup();
//
//        ConfigFileOperation configFileOperation = new ConfigFileOperation();
//        Properties properties = configFileOperation.getImServerConfig();
//        int port = Integer.valueOf(properties.getProperty("server_port"));
//
//        try {
//            ServerBootstrap serverBootstrap = new ServerBootstrap();
//            // handler针对的是bossGroup
//            serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).childHandler(new IMServerInitializer()); // childHandler针对的时workerGroup
//            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();//sync表示在监听该端口.
//            channelFuture.channel().closeFuture().sync();
//        }finally {
//            bossGroup.shutdownGracefully();
//            workerGroup.shutdownGracefully();
//        }
    }
}
