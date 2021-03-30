package com.lanjiu.im.communication.client.login;

import com.lanjiu.im.communication.util.PropertyConf;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

import static com.lanjiu.im.communication.server.ChannelList.channelLoginRegistrationGroup;

public class LoginRegistrationClient {

    public static void linkLoginRegistrationServer(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) throws Exception{
        int nChannel = channelLoginRegistrationGroup.size();
        if(nChannel >= 1){
            channelLoginRegistrationGroup.writeAndFlush(checkUnifiedEntranceMessage);
        }else {
            linkServer(checkUnifiedEntranceMessage);
        }
    }

    public static void linkServer(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) throws Exception{
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        PropertyConf propertyConf = new PropertyConf("/login_registration_server.properties");
        int port = Integer.valueOf(propertyConf.getValue("server_port"));
        String address = propertyConf.getValue("server_address");
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast(new ProtobufVarint32FrameDecoder());
                    pipeline.addLast(new ProtobufDecoder(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.getDefaultInstance()));  //要转换的对象实例
                    pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
                    pipeline.addLast(new ProtobufEncoder());
                    //netty提供的空闲状态处理器,客户端30秒钟触发一次发送心跳包，超过60秒服务端未响应Pong包时，断开该连接
                    pipeline.addLast(new IdleStateHandler(0,30,0,TimeUnit.SECONDS));
                    pipeline.addLast(new LoginHeartBeatReqHandler());
                    pipeline.addLast(new LoginRegistrationClientHandler());
                }
            });//客户端不能使用childHandler,只能使用Handler
            ChannelFuture channelFuture = bootstrap.connect(address,port).sync();
            channelLoginRegistrationGroup.writeAndFlush(checkUnifiedEntranceMessage);
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
