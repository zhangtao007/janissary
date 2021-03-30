package com.lanjiu.im.communication.util;

import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.Channel;
import io.netty.util.concurrent.ScheduledFuture;

import java.util.Map;
import java.util.concurrent.*;


public class ChannelList {

    public static Map<String, Channel> socketChannelGroup = new ConcurrentHashMap<>();

    public static Map<String, Channel> shortChannelGroup = new ConcurrentHashMap<>();

    public static Map<String, String> userMacMap = new ConcurrentHashMap<>();

    public static Map<String, Channel> macChannelMap = new ConcurrentHashMap<>();

    public static Map<String, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage> msgMap = new ConcurrentHashMap<>();

    //public static Map<String, ScheduledFuture<?>> scheduledFutureMap = new ConcurrentHashMap<>();
}
