package com.lanjiu.im.communication.client.information;

import com.lanjiu.im.grpc.client.util.ConfigFileOperation;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.lanjiu.im.communication.server.ChannelList.channelInformationGroup;

public class InformationClient {

    public static void linkInformationCommunicationServer(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) throws Exception{
        int nChannel = channelInformationGroup.size();
        if(nChannel >= 1){
            channelInformationGroup.writeAndFlush(checkUnifiedEntranceMessage);
        }else {
            linkServer(checkUnifiedEntranceMessage);
        }
    }

    public static void linkServer(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        Properties properties = configFileOperation.getInformationStorageConfig();
        int port = Integer.valueOf(properties.getProperty("server_port"));
        String address = properties.getProperty("server_address");
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast("ProtobufVarint32FrameDecoder", new ProtobufVarint32FrameDecoder());
                    pipeline.addLast("ProtobufDecoder", new ProtobufDecoder(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.getDefaultInstance()));  //要转换的对象实例
                    pipeline.addLast("ProtobufVarint32LengthFieldPrepender", new ProtobufVarint32LengthFieldPrepender());
                    pipeline.addLast("ProtobufEncoder", new ProtobufEncoder());
                    //netty提供的空闲状态处理器,客户端30秒钟触发一次发送心跳包，超过60秒服务端未响应Pong包时，断开该连接
                    pipeline.addLast("IdleStateHandler", new IdleStateHandler(0,30,0,TimeUnit.SECONDS));
                    pipeline.addLast("HeartBeatReqHandler", new HeartBeatReqHandler());
                    pipeline.addLast("InformationClientHandler", new InformationClientHandler());
                }
            });//客户端不能使用childHandler,只能使用Handler
            ChannelFuture channelFuture = bootstrap.connect(address,port).sync();
            channelInformationGroup.writeAndFlush(checkUnifiedEntranceMessage);
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
