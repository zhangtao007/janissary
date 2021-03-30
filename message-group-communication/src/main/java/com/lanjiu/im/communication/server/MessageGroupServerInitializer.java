package com.lanjiu.im.communication.server;

import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

public class MessageGroupServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        System.out.println(this.hashCode());
        ChannelPipeline pipeline = ch.pipeline();
        //netty提供的空闲状态处理器,服务器不主动触发空闲事件，只接受客户端发送的ping包，并返回响应的pong包，如果服务端监听到客户端连接断开，则在连接集合中移除已断开的客户端。
        pipeline.addLast(new ProtobufVarint32FrameDecoder());
        pipeline.addLast(new ProtobufDecoder(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.getDefaultInstance()));  //要转换的对象实例
        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
        pipeline.addLast(new ProtobufEncoder());
        pipeline.addLast(new MessageGroupServerHandler());
    }
}
