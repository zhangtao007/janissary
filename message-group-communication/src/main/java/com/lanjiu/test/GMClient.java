package com.lanjiu.test;


import com.lanjiu.im.communication.util.GroupContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.GlobalEventExecutor;


public class GMClient {

    public static ChannelGroup channelLoginRegistrationGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public static void runServer(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage check){
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new MyClientInitializer());//客户端不能使用childHandler,只能使用Handler
            ChannelFuture channelFuture =null;
            channelFuture= bootstrap.connect("localhost",11313).sync();
            for (int i=0;i<1;i++){

               channelFuture.channel().writeAndFlush(check);
                System.out.println("222");
           }
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

    public static void linkServer(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage check){
        if (channelLoginRegistrationGroup.size()>0){
            channelLoginRegistrationGroup.writeAndFlush(check);
        }
        runServer(check);

    }
   /* public static void main(String[] args) throws Exception {
        //群消息对接华为推送测试
         BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage check = JCRC32.packageCheckSum(BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
         .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupChatProtocol)
         .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                 .setFromId("10010676")
                 .setToId("10010177")
                 .setTimestamp(1545098699)
                 .setMsgType(GroupContacts.MsgType.GROUP_CHAT_REGISTERED).build())
         .setGroupChatProtocol(BusinessProtocolMessages.GroupChatProtocol.newBuilder()
                 .setUserType("100")
                 .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                         .setUserId("10010676")
                         .setPhone("18754295781").build())
                 .setRegisteredGroupMember(BusinessProtocolEntities.RegisteredGroupMember.newBuilder()
                         .setGroup(BusinessProtocolEntities.RegisteredGroup.newBuilder().setGroupId("10010177").build()).build())
                 .build())
         .build());
        for (int i = 0; i <1 ; i++) {
            linkServer(check);
        }


    }*/
 }

