package com.lanjiu.im.netty.server;

import com.lanjiu.im.util.CheckSumResult;
import com.lanjiu.im.util.IMSContacts;
import com.lanjiu.im.util.JCRC32;
import com.lanjiu.im.util.ResponseStatus;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginRegistCommServerHandler extends SimpleChannelInboundHandler<BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage> {
    private int count;

    private final Logger log = LoggerFactory.getLogger(LoginRegistCommServerHandler.class);

    //保存连接到服务器的所有的连接对象,GlobalEventExecutor单线程的单例的EventExecutor
    //channelGroup会自动移除断掉的连接，不需要手工处理
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    public static Map<String,Object> ctxMap = new ConcurrentHashMap<String,Object>();
    public static final String CHANNEL ="CHANNEL";

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) throws Exception {
        //把十条数据的字节流作为了一条数据来处理
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        String msgType = unifiedEntranceMessage.getHead().getMsgType();
        ChannelId channel_id = ctx.channel().id();
        String fromId = unifiedEntranceMessage.getHead().getFromId();

        //数据包完整性校验
        JCRC32 jcrc32 = new JCRC32();
        MsgDeal msgDeal = new MsgDeal();
        CheckSumResult checkSumResult = jcrc32.checkSumValidateProtocol(msg,unifiedEntranceMessage);

        //心跳响应
        if(msg.getUnifiedEntranceMessage().getHead().getMsgType().equalsIgnoreCase(IMSContacts.MsgType.HEART_PACKAGE)){
            ctx.writeAndFlush(msg);
            return;
        }

        if(checkSumResult.b_result){

            BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType dataType = unifiedEntranceMessage.getDataType();
            if(ResponseStatus.RESPONSE_CHECK_FAILURE.equals(unifiedEntranceMessage.getHead().getStatusReport())){
                log.error("上个数据包完整性校验失败，重发，状态信息为: " + msg.getUnifiedEntranceMessage().getHead().getStatusReport());
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(unifiedEntranceMessage);
                ctx.writeAndFlush(checkUnified);
            }else {

                //过滤游客
//                if(msgType.length()>7){
//                    String userType = msgType.substring(5,8);
//                    if(userType.equals("101")){
//                        log.error("游客用户账号过滤，userID:"+unifiedEntranceMessage.getHead().getFromId()+" , msgType:"+msgType);
//                        return;
//                    }
//                }

                ctxMap.put(CHANNEL,ctx.channel());
                log.info("login_server& >>> channel_id:{} and msgType:{} and fromId:{} ",channel_id,msgType,fromId);
                msgDeal.msgToDeal(ctx, msg);
            }

        } else {
            log.error("Server端数据包校验失败... >>> channel_id:{} and msgType:{} and fromId:{} ",channel_id,msgType,fromId);
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
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        log.info("channel close :" + ctx.channel().id() + ", error :" ,cause);
        ctx.close();
    }



}
