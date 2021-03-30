package com.lanjiu.im.communication.server;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.HashMap;
import java.util.Map;

public class ChannelList {

    //IM登录注册客户端和登录注册通信服务端的channel集合----共用一个连接，为1
    public static ChannelGroup channelLoginRegistrationGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    //IM资料客户端和资料通信服务端的channel集合----共用一个连接，为1
    public static ChannelGroup channelInformationGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    //IM群消息客户端和群消息通信服务端的channel集合----共用一个连接，为1
    public static ChannelGroup channelGroupMessageGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    //IM好友消息客户端和好友消息通信服务端的channel集合----共用一个连接，为1
    public static ChannelGroup channelFriendMessageGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    //手机客户端和IM服务器的channel集合---由连接的客户端个数决定
    //保存连接到服务器的所有的连接对象,GlobalEventExecutor单线程的单例的EventExecutor
    //channelGroup会自动移除断掉的连接，不需要手工处理
    //广播组
    public static ChannelGroup channelIMGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    //key--value组
    public static Map<String, Channel> mapIMChannelGroup = new HashMap<>();

}
