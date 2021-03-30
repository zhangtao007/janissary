package com.lanjiu.im.netty.server;

import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

public class LoginRegistCommServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        //上面两个都是自定义协议的编解码处理器  解码器将通道中的二进制字节转换为自定义协议对象，然后传递给自定义处理器进行数据处理。
        //自定义处理器处理完成后，编码器将自定义协议对象编码int 和byte[]传递给网络。
        //Encoder会在MyClientHandler后调用，与这里的顺序无关。
        pipeline.addLast(new ProtobufVarint32FrameDecoder());
        pipeline.addLast(new ProtobufDecoder(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.getDefaultInstance()));  //要转换的对象实例
        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
        pipeline.addLast(new ProtobufEncoder());
//        pipeline.addLast(new IdleStateHandler(10,10,10, TimeUnit.SECONDS)); //netty提供的空闲状态处理器
//        pipeline.addLast(new HeartBeatRespHandler());
        pipeline.addLast(new LoginRegistCommServerHandler());
    }
}
