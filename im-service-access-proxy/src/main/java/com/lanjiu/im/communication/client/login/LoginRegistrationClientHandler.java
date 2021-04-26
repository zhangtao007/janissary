package com.lanjiu.im.communication.client.login;

import com.lanjiu.im.communication.client.util.IMClientUtils;
import com.lanjiu.im.communication.util.*;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import static com.lanjiu.im.communication.client.login.LoginRegistrationClient.loginChannel;
import static com.lanjiu.im.communication.util.ChannelList.*;
import static com.lanjiu.im.communication.util.ResponseStatus.RESPONSE_CHECK_FAILURE;

public class LoginRegistrationClientHandler extends SimpleChannelInboundHandler<BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage> {

    private static final Logger log = Logger.getLogger(LoginRegistrationClientHandler.class);

    //线程安全心跳失败计数器
    private AtomicInteger atomicInteger = new AtomicInteger(1);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) throws Exception {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String msgType = head.getMsgType();
        if (IMSContacts.MsgType.HEART_PACKAGE.equals(msgType)){
            log.info("登录服务心跳正常");
            //清零心跳失败计数器
            atomicInteger = new AtomicInteger(1);
            return;
        }
        // 定期清理-删除用户在线接收消息
        if (IMSContacts.MsgType.DEL_ON_LINE_RECEIVE.equals(msgType)){
            log.info("删除用户【"+ head.getToId() +"】在线接收fromID:【"+ head.getFromId() +"】消息-定期清理主动推:" + msg);
            Channel socketChannel = IMServerUtil.getSocketChannel(head.getToId());
            if (socketChannel != null){
                IMServerUtil.writeAndFlushFriend(socketChannel, head.getToId(), msg);
            }else {
                log.info("定期清理-用户【"+ head.getToId() +"】离线");
                IMServerUtil.sendFriendMessageServer(ctx, msg);
            }
            return;
        }
        log.info("登录服务响应【"+ head.getFromId() +"】发送的【"+ msgType +"】数据：" + msg);
        //数据包完整性校验
        CheckSumResult checkSumResult = JCRC32.checkSumValidateProtocol(msg,unifiedEntranceMessage);
        if (!checkSumResult.b_result){
            log.info("IM LoginRegistrationClient端数据包校验失败... ..." + msg);
            return;
        }

        if(RESPONSE_CHECK_FAILURE.equals(unifiedEntranceMessage.getHead().getStatusReport())){
            log.info("上个数据包完整性校验失败，重发，状态信息为: " + msg);
            return;
        }

        // 注册
        if (IMSContacts.MsgType.REGISTER.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        // 登录
        if (IMSContacts.MsgType.LOGIN_TOURISTS.equals(msgType) || IMSContacts.MsgType.LOGIN_REGISTERED.equals(msgType)){
            if (ResponseStatus.STATUS_REPORT_FAILURE.equals(head.getStatusReport())){
                Channel shortChannel = macChannelMap.get(head.getFromId());
                log.info("响应登录用户channel：" + shortChannel);
                if (shortChannel != null){
                    shortChannel.writeAndFlush(msg);
                }
                return;
            }
            BusinessProtocolMessages.LoginProtocol loginProtocol = unifiedEntranceMessage.getLoginProtocol();
            // 登录的mac地址
            String macAdr = head.getFromId();
            String userId = loginProtocol.getRegisteredUser().getUserId();
            String ordMacAdr = userMacMap.get(userId);
            if (StringUtils.isEmpty(ordMacAdr)){
                userMacMap.put(userId, macAdr);
                Channel shortChannel = macChannelMap.get(head.getFromId());
                if (shortChannel != null){
                    shortChannel.writeAndFlush(msg);
                }
                log.info("用户【"+ userId +"】登录，不存在旧mac地址");
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage userOnLineMsg = IMServerUtil.getUserOnLineMsg(userId, IMSContacts.OnlineState.ONLINE, true);
                ctx.channel().writeAndFlush(userOnLineMsg);
                return;
            }
            if (ordMacAdr.equals(macAdr)){
                Channel shortChannel = macChannelMap.get(head.getFromId());
                if (shortChannel != null){
                    shortChannel.writeAndFlush(msg);
                }
                log.info("用户【"+ userId +"】登录，新旧mac地址一样");
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage userOnLineMsg = IMServerUtil.getUserOnLineMsg(userId, IMSContacts.OnlineState.ONLINE, true);
                ctx.channel().writeAndFlush(userOnLineMsg);
                return;
            }
            userMacMap.put(userId, macAdr);
            Channel oldSocketChannel = IMServerUtil.getSocketChannel(userId);
            if (oldSocketChannel != null){
                log.info("用户【"+ userId +"】登录，旧mac地址：" + ordMacAdr + "新mac地址：" + macAdr);
                Channel shortChannel = macChannelMap.get(head.getFromId());
                if (shortChannel != null){
                    shortChannel.writeAndFlush(msg);
                }
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage entranceMessage = IMServerUtil.repeatLoginHandel(unifiedEntranceMessage);
                oldSocketChannel.writeAndFlush(entranceMessage);
                log.info("单点登录旧MAC：【"+ ordMacAdr +"】被迫下线：" + entranceMessage);
                return;
            }
            Channel newShortChannel = macChannelMap.get(head.getFromId());
            if (newShortChannel != null){
                newShortChannel.writeAndFlush(msg);
            }
            return;
        }

        // 退出登录
        if (IMSContacts.MsgType.LOGOUT_TOURISTS.equals(msgType) || IMSContacts.MsgType.LOGOUT_REGISTERED.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            if (ResponseStatus.STATUS_REPORT_SUCCESS.equals(head.getStatusReport())){
                userMacMap.remove(head.getFromId());
            }
            return;
        }
        // 查找好友
        if (IMSContacts.MsgType.FRIEND_FIND_REGISTERED.equals(msgType) || IMSContacts.MsgType.FRIEND_FIND_TOURISTS.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }
        // 设置昵称
        if (IMSContacts.MsgType.PERSONAL_NICKNAME_TOURISTS.equals(msgType) || IMSContacts.MsgType.PERSONAL_NICKNAME_REGISTERED.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        if (IMSContacts.MsgType.VERIFICATION_CODE.equals(msgType) || IMSContacts.MsgType.SETUP_PHONE.equals(msgType)
                || IMSContacts.MsgType.SETUP_PHONE_EDIT.equals(msgType) || IMSContacts.MsgType.RESET_SECRET.equals(msgType)
                || IMSContacts.MsgType.RESET_SECRET_VERIFY.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        // 设置-是否每次退出清理
        if (IMSContacts.MsgType.PERSONAL_EXIT_CLEAN_REGISTERED.equals(msgType) || IMSContacts.MsgType.PERSONAL_EXIT_CLEAN_TOURISTS.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        // 检查更新
        if (IMSContacts.MsgType.CHECK_FOR_UPDATES.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        // 查询个人信息
        if (IMSContacts.MsgType.SELECT_USER_INFO.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        // 设置-定期清理周期
        if (IMSContacts.MsgType.PERSONAL_TIMER_CLEAN_REGISTERED.equals(msgType) || IMSContacts.MsgType.PERSONAL_TIMER_CLEAN_TOURISTS.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
        }

        //反馈用户设备信息更新请求
        if (IMSContacts.MsgType.USER_DEVICE_UPDATE.equalsIgnoreCase(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }


    }

    /**
     * 事件触发器，该处用来处理客户端空闲超时,发送心跳维持连接。
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        IMClientUtils.userEventTriggered(ctx, evt, atomicInteger, "login");
    }

    /**
     * 处理断开重连
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("登录服务channel不活跃");
        ctx.close();
        loginChannel.close();
        LoginRegistrationClient.getInstance();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        log.info("channel异常" , cause);
        ctx.close();
    }
}
