package com.lanjiu.im.communication.client.login;

import com.lanjiu.im.communication.server.IMServerUtil;
import com.lanjiu.im.communication.util.CheckSumResult;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;

import static com.lanjiu.im.communication.server.ChannelList.channelLoginRegistrationGroup;

public class LoginRegistrationClientHandler extends SimpleChannelInboundHandler<BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage> {

    private final Logger log = Logger.getLogger(LoginRegistrationClientHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) throws Exception {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        //数据包完整性校验
        IMServerUtil imServerUtil = new IMServerUtil();
        JCRC32 jcrc32 = new JCRC32();
        CheckSumResult checkSumResult = jcrc32.checkSumValidateProtocol(msg,unifiedEntranceMessage);
        if(checkSumResult.b_result){
            log.info("IM LoginRegistrationClient端数据包校验成功!!!!!!!!!");
            if(ResponseStatus.RESPONSE_CHECK_FAILURE.equals(unifiedEntranceMessage.getHead().getStatusReport())){
                log.info("上个数据包完整性校验失败，重发，状态信息为: " + msg.getUnifiedEntranceMessage().getHead().getStatusReport());
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(unifiedEntranceMessage);
                ctx.writeAndFlush(checkUnified);
            }else {
                log.info("getFromId : " + msg.getUnifiedEntranceMessage().getHead().getFromId());
                imServerUtil.sendResponseFromClientToPhone(msg);
            }
        } else {
            log.info("IM LoginRegistrationClient端数据包校验失败... ...");
            imServerUtil.requestWithResponseValidateFail(ctx, msg);
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel(); //获取新增连接对象
        channelLoginRegistrationGroup.add(channel);//将新增连接加到组中.
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
