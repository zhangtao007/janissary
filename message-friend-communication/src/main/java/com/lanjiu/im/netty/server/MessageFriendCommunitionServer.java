package com.lanjiu.im.netty.server;

import com.lanjiu.im.grpc.utils.ConfigFileOperation;
import com.lanjiu.im.grpc.utils.PropertyConf;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


public class MessageFriendCommunitionServer {

    private static final Logger logger = LoggerFactory.getLogger(MessageFriendCommunitionServer.class);

    public static void main(String[] args) throws Exception {
        //针对Socket编程中，服务器与多客户端连接,交互的事例，偏重于客户端与服务端的交互
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        PropertyConf propertyConf = new PropertyConf("/message_friend_comm.properties");
        String ports = propertyConf.getValue("server_port").trim();
        int port = Integer.parseInt(propertyConf.getValue("server_port").trim());

        logger.info("message_friend_server start on port:{}" , port);
        System.out.println("message_friend_server start on port:"+port);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // handler针对的是bossGroup
            serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
                    .childOption(ChannelOption.TCP_NODELAY,true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new MessageFreindCommServerInitilizer()); // childHandler针对的时workerGroup
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();//sync表示在监听该端口.
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
