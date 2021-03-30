package com.lanjiu.im.communication.server;

import com.lanjiu.im.communication.util.CheckSumResult;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;

import static com.lanjiu.im.communication.server.ChannelList.channelIMGroup;
import static com.lanjiu.im.communication.server.ChannelList.mapIMChannelGroup;


public class IMServerHandler extends SimpleChannelInboundHandler<BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage> {

    private final Logger log = Logger.getLogger(IMServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) throws Exception {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        IMServerUtil imServerUtil = new IMServerUtil();
        String msgType = head.getMsgType();
        if(IMSContacts.MsgType.HEART_PACKAGE_PHONE_END.equals(msgType)){
            //心跳连接断开
            log.info("主动断开心跳连接");
            return;
        }else if (IMSContacts.MsgType.HEART_PACKAGE_PHONE.equals(msgType)){
            //发送心跳，维持连接
            log.info("心跳连接");
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage replyMsg = imServerUtil.buildHeartBeat();
            ctx.writeAndFlush(replyMsg);
            return;
        }

        channelMapAdded(ctx, head);
        //数据包完整性校验
        JCRC32 jcrc32 = new JCRC32();
        CheckSumResult checkSumResult = jcrc32.checkSumValidateProtocol(msg,unifiedEntranceMessage);
        if(checkSumResult.b_result){
            log.info("IM Server端数据包校验成功!!!!!!!!!");
            if(ResponseStatus.RESPONSE_CHECK_FAILURE.equals(unifiedEntranceMessage.getHead().getStatusReport())){
                log.info("上个数据包完整性校验失败，重发，状态信息为: " + msg.getUnifiedEntranceMessage().getHead().getStatusReport());
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(unifiedEntranceMessage);
                ctx.writeAndFlush(checkUnified);
            }else {
                log.info("getFromId : " + msg.getUnifiedEntranceMessage().getHead().getFromId());
                //在线，离线
                String toId = head.getToId();
                System.out.println("toId: "+ toId);
                if(IMSContacts.MsgType.SET_MSG_TYPE_TO_ID.equals(toId) || "".equals(toId)){
                    MsgToDistributionOnline msgToClient = new MsgToDistributionOnline();
                    msgToClient.msgToDistributionOnline(ctx, msg);
                }else {
                    boolean bOnline = imServerUtil.isOnline(toId);
                    if(bOnline){
                        MsgToDistributionOnline msgToClient = new MsgToDistributionOnline();
                        msgToClient.msgToDistributionOnline(ctx, msg);
                    }else {
                        MsgToDistributionOffline msgDistribution = new MsgToDistributionOffline();
                        msgDistribution.msgToDistributionOffline(ctx, msg);
                    }
                }
            }
        } else {
            log.info("IM Server端数据包校验失败... ...");
            imServerUtil.requestWithResponseValidateFail(ctx, msg);
        }
    }

    public void channelMapAdded(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.Head head){
        Channel channel = ctx.channel(); //获取新增连接对象
        String fromId = head.getFromId(); //用客户端id绑定客户端连接对象
        System.out.println("fromId: "+ fromId);
        mapIMChannelGroup.put(fromId, channel);
        log.info("mapIMChannelGroup size: " + mapIMChannelGroup.size());
    }

    public void removeMapRecord(ChannelHandlerContext ctx){
        Channel channel = ctx.channel();
        mapIMChannelGroup.values().remove(channel);
        CommonMessagePackage commonMessagePackage = new CommonMessagePackage();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = commonMessagePackage.offLineStatusUpdateToRegistered();
        channelIMGroup.writeAndFlush(checkUnified);//广播到用户注册类型的好友用户
        checkUnified = commonMessagePackage.offLineStatusUpdateToGroupMemberRegistered();
        channelIMGroup.writeAndFlush(checkUnified);//广播到用户注册类型的群成员
        checkUnified = commonMessagePackage.offLineStatusUpdateToTourists();
        channelIMGroup.writeAndFlush(checkUnified);//广播到游客类型的好友用户
        checkUnified = commonMessagePackage.offLineStatusUpdateToGroupMemberTourists();
        channelIMGroup.writeAndFlush(checkUnified);//广播到游客类型的群成员
        log.info("mapIMChannelGroup size: " + mapIMChannelGroup.size());
        log.info("channelIMGroup size: " + channelIMGroup.size());//channelGroup会自动移除断掉的连接，不需要手工处理
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel(); //获取新增连接对象
        channelIMGroup.add(channel);//将新增连接加到组中.
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        removeMapRecord(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        log.info(channel.remoteAddress() + "上线");
        log.info("channelIMGroup size: " + channelIMGroup.size());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        log.info(channel.remoteAddress() + "下线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
