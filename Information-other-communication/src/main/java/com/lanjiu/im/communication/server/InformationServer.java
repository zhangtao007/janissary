package com.lanjiu.im.communication.server;

import com.lanjiu.im.communication.util.ConfigFileOperation;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class InformationServer {

    private  static  final Logger logger = LoggerFactory.getLogger(InformationServer.class);

    public static void main(String[] args) {
        runServer();
    }

    public static void runServer(){
        //针对Socket编程中，服务器与多客户端连接,交互的事例，偏重于客户端与服务端的交互
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);//不填参数，会给一个默认的参数，一个端口，给一个连接池
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        Properties properties = configFileOperation.getInformationCommunicationConfig();
        int port = Integer.valueOf(properties.getProperty("server_port"));
        logger.info("InformationServer started  on port:{} " ,port);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // handler针对的是bossGroup
            serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).childHandler(new InformationServerInitializer()); // childHandler针对的时workerGroup
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();//sync表示在监听该端口.
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
