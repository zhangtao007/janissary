package com.lanjiu.im.test.im_client;

import com.lanjiu.im.util.IMSContacts;
import com.lanjiu.im.util.JCRC32;
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

import java.util.HashMap;
import java.util.Map;


public class LoginClient {

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
    public static void main(String[] args) throws Exception {
        JCRC32 jcrc32 = new JCRC32();

        //群消息对接华为推送测试
         BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage check = jcrc32.packageCheckSum(BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
         .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupChatProtocol)
         .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                 .setFromId("10010676")
                 .setToId("10010177")
                 .setTimestamp(1545098699)
                 .setMsgType(IMSContacts.MsgType.GROUP_CHAT_REGISTERED).build())
         .setGroupChatProtocol(BusinessProtocolMessages.GroupChatProtocol.newBuilder()
                 .setUserType("100")
                 .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                         .setUserId("10010676")
                         .setPhone("18754295781").build())
                 .setChatMessage(BusinessProtocolEntities.ChatMessage.newBuilder().setText(BusinessProtocolEntities.Text.newBuilder().setContent("hahaha").build()).build())
                 .setRegisteredGroupMember(BusinessProtocolEntities.RegisteredGroupMember.newBuilder()
                         .setGroup(BusinessProtocolEntities.RegisteredGroup.newBuilder().setGroupId("10010177").build()).build())
                 .build())
         .build());
        for (int i = 0; i <1 ; i++) {
            linkServer(check);
        }

//        //好友消息对接华为推送测试
 /*       BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage check = jcrc32.packageCheckSum(BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendChatProtocol)
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setFromId("10010198")
                        .setToId("77777777")
                        .setTimestamp(1545098699)
                        .setMsgType(IMSContacts.MsgType.FRIEND_CHAT_REGISTERED).build())
                .setFriendChatProtocol(BusinessProtocolMessages.FriendChatProtocol.newBuilder()
                        .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                .setUserId("10010198")
                                .setPhone("18754295781").build())
                        .setChatMessage(BusinessProtocolEntities.ChatMessage.newBuilder().setText(BusinessProtocolEntities.Text.newBuilder().setContent("hahaha").build()).build())
                        .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                                .setFriendId("77777777")
                                .setFriendUserId("77777777")
                                .setUserType("100")
                                .setSettings(BusinessProtocolEntities.Settings.newBuilder().setTimerClean(0).build()).build())
                        .build())
                .build());
        for (int i = 0; i <1 ; i++) {
            linkServer(check);
        }

*/
//        //用户设备绑定接口测试
//        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage check = jcrc32.packageCheckSum(BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.BindingPushServicesProtocol)
//                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                        .setFromId("77777777")
//                        .setToId("10010198")
//                        .setTimestamp(1545098699)
//                        .setMsgType(IMSContacts.MsgType.USER_DEVICE_UPDATE).build())
//                .setBindingPushServicesProtocol(BusinessProtocolMessages.BindingPushServicesProtocol.newBuilder()
//                        .setUserId("77777777")
//                        .setPushToken("token======ajfiugkg")
//                        .setManufacturer("huawei").build())
//                .build());
//        for (int i = 0; i <1 ; i++) {
//            linkServer(check);
//        }







//
//        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage check = jcrc32.packageCheckSum(BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                .setFindUserProtocol(BusinessProtocolMessages.FindUserProtocol.newBuilder()
//                        .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
//                                .setUserId("10010031")
//                                .setNickname("aaaas")
//                                .setPhone("13390907788")
//                                .setSecret("123456")
//                                .build())
//                        .setSearch(BusinessProtocolEntities.Search.newBuilder()
//                                .setKeyword("10010031").build())
//                        .build())
//                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                        .setFromId("10010031")
//                        .setToId("1")
//                        .setTimestamp(1545098699)
//                        .setMsgType(IMSContacts.MsgType.FRIEND_FIND_REGISTERED).build())
//                .build());
//
//        linkServer(check);

        //设置
//        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage check = jcrc32.packageCheckSum(BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//               .setPersonalSettingsProtocol(BusinessProtocolMessages.PersonalSettingsProtocol.newBuilder()
//                       .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
//                               .setUserId("10010031")
//                               .build())
//                       .setSettings(BusinessProtocolEntities.Settings.newBuilder()
//                               .setTimerClean(1).build())
//                       .build())
//                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                        .setFromId("10010031")
//                        .setToId("1")
//                        .setTimestamp(1545098699)
//                        .setMsgType(IMSContacts.MsgType.PERSONAL_TIMER_CLEAN_REGISTERED).build())
//                .build());
//
//        linkServer(check);

//        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage check = jcrc32.packageCheckSum(BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                .setGroupChatProtocol(BusinessProtocolMessages.GroupChatProtocol.newBuilder()
//                        .setUserType("100")
//                        .setChatMessage(BusinessProtocolEntities.ChatMessage.newBuilder()
//                                .setMsgId("1994#1001048710010201#1591751016307")
//                                .setText(BusinessProtocolEntities.Text.newBuilder()
//                                        .setContent("你好")
//                                        .setLength(String.valueOf("你好".length()))
//                                        .build()).build())
//                        .setRegisteredGroupMember(BusinessProtocolEntities.RegisteredGroupMember.newBuilder()
//                                .setGroupMemberId("10010487")
//                                .setGroupMemberUserId("10010487")
//                                .setGroupMemberAvatar("")
//                                .setGroup(BusinessProtocolEntities.RegisteredGroup.newBuilder()
//                                        .setGroupId("10010201")
//                                        .setGroupName("群名称")
//                                        .setGroupType("100").build()).build()).build())
//                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                        .setFromId("10010487")
//                        .setToId("10010201")
//                        .setTimestamp(1545098699)
//                        .setMsgType("10102100").build())
//                .build());
//
//        linkServer(check);


    }
 }

