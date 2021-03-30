package com.lanjiu.im.netty.server;

import com.lanjiu.im.util.PropertyConf;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginRegistCommunicationServer {

    private  static Logger logger = LoggerFactory.getLogger(LoginRegistCommunicationServer.class);

    public static void main(String[] args) throws Exception {
        //针对Socket编程中，服务器与多客户端连接,交互的事例，偏重于客户端与服务端的交互
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors()*2);

        PropertyConf propertyConf = new PropertyConf("/login_regist_communication.properties");
        int port = Integer.valueOf(propertyConf.getValue("server_port"));
        logger.info("Login_Server started  on port:{} ",port);
        System.out.println("Login_Server started  on port:  "+port);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // handler针对的是bossGroup
            serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).childHandler(new LoginRegistCommServerInitializer()); // childHandler针对的时workerGroup
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();//sync表示在监听该端口.
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
