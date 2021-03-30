package com.lanjiu.im.communication.server;

import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.concurrent.TimeUnit;

public class IMServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //netty提供的空闲状态处理器,客户端30秒钟触发一次发送心跳包，超过60秒服务端未响应Pong包时，断开该连接
        pipeline.addLast(new IdleStateHandler(0, 0, 65, TimeUnit.SECONDS));
        //上面两个都是自定义协议的编解码处理器  解码器将通道中的二进制字节转换为自定义协议对象，然后传递给自定义处理器进行数据处理。
        //自定义处理器处理完成后，编码器将自定义协议对象编码int 和byte[]传递给网络。
        //Encoder会在MyClientHandler后调用，与这里的顺序无关。
        pipeline.addLast(new ProtobufVarint32FrameDecoder());
        pipeline.addLast(new ProtobufDecoder(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.getDefaultInstance()));  //要转换的对象实例
        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
        pipeline.addLast(new ProtobufEncoder());
        pipeline.addLast(new IdleHandler());
        pipeline.addLast(new IMServerHandler());
    }
}
