package com.lanjiu.im.communication.server;

import com.lanjiu.im.communication.util.CheckSumResult;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.apache.log4j.Logger;


public class InformationServerHandler extends SimpleChannelInboundHandler<BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage> {

    private final Logger log = Logger.getLogger(InformationServerHandler.class);

    //保存连接到服务器的所有的连接对象,GlobalEventExecutor单线程的单例的EventExecutor
    //channelGroup会自动移除断掉的连接，不需要手工处理
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg){
        log.info("请求服务地址："+ctx.channel().remoteAddress());
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        //数据包完整性校验
        JCRC32 jcrc32 = new JCRC32();
        MsgDeal msgDeal = new MsgDeal();
        CheckSumResult checkSumResult = jcrc32.checkSumValidateProtocol(msg,unifiedEntranceMessage);
        if(checkSumResult.b_result){
            log.info("Server端数据包校验成功!!!!!!!!!");
            if(ResponseStatus.RESPONSE_CHECK_FAILURE.equals(unifiedEntranceMessage.getHead().getStatusReport())){
                log.info("上个数据包完整性校验失败，重发，状态信息为: " + msg.getUnifiedEntranceMessage().getHead().getStatusReport());
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(unifiedEntranceMessage);
                ctx.writeAndFlush(checkUnified);
            }else {
                log.info("getFromId : " + msg.getUnifiedEntranceMessage().getHead().getFromId());
                msgDeal.msgToDeal(ctx, msg);
            }
        } else {
            log.info("Server端数据包校验失败... ...");
            msgDeal.requestWithResponseValidateFail(ctx, msg);
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel(); //获取新增连接对象
        channelGroup.add(channel);//将新增连接加到组中.
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception { ;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
