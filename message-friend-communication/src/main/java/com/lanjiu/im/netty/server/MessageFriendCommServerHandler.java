package com.lanjiu.im.netty.server;

import com.lanjiu.im.grpc.client.message_friend.mfAPI.OffFriendMessageAPI;
import com.lanjiu.im.grpc.utils.*;
import com.lanjiu.im.netty.server.common.MessageFriendCommon;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.friend_msg.FriendMessage;
import com.lanjiu.pro.friend_msg.RequestFriendMessage;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MessageFriendCommServerHandler extends SimpleChannelInboundHandler<BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage> {

    private final Logger log = LoggerFactory.getLogger(MessageFriendCommServerHandler.class);


    //保存连接到服务器的所有的连接对象,GlobalEventExecutor是一个具备任务队列的单线程的事件执行器。
    //channelGroup会自动移除断掉的连接，不需要手工处理
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    protected void channelRead0(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) throws Exception {

        //把十条数据的字节流作为了一条数据来处理
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        String msgType = unifiedEntranceMessage.getHead().getMsgType();
        ChannelId channel_id = ctx.channel().id();
        String fromId = unifiedEntranceMessage.getHead().getFromId();
        String toId = unifiedEntranceMessage.getHead().getToId();
        //数据包完整性校验
        JCRC32 jcrc32 = new JCRC32();
        MsgDeal msgDeal = new MsgDeal();

        //心跳响应
        if(msg.getUnifiedEntranceMessage().getHead().getMsgType().equalsIgnoreCase(IMSContacts.MsgType.HEART_PACKAGE)){
            ctx.writeAndFlush(msg);
            return;
        }

        if (unifiedEntranceMessage.getHead().getMsgType().equals(IMSContacts.MsgType.GET_OFF_MESSAGE_REGIST) && unifiedEntranceMessage.getHead().getStatusReport().equals(ResponseStatus.RECEIPT_OFFLINE)){
            OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
            BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
            FriendMessage friendMessage = FriendMessage.newBuilder().
                    setToId(Integer.parseInt(head.getFromId())).build();
            RequestFriendMessage requestFriendMessage = RequestFriendMessage.newBuilder().setRet(ConstantKind.MESSAGE_REQUEST_DELETE_TO_ID)
                    .addFriendMessage(friendMessage).build();
            log.info("捞取离线消息后删除操作:"+head.getFromId());
            try {
                offFriendMessageAPI.removeFriendMessage(requestFriendMessage);
            } catch (Exception e) {
                log.error("用户离线消息捞取后删除操作异常"+head.getFromId());
                BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                        .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OffFriendMessageListProtocol)
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                .setStatusReport(ResponseStatus.STATUS_REPORT_EXCEPTION)
                                .setFromId(head.getFromId())
                                .setMsgType(head.getMsgType())
                                .setUniqueIdentify(head.getUniqueIdentify())
                                .build())
                        .build();
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkMessage =  BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.newBuilder().setUnifiedEntranceMessage(message).build();
                ctx.writeAndFlush(checkMessage);
                return;
            }
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OffFriendMessageListProtocol)
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                            .setFromId(head.getFromId())
                            .setMsgType(head.getMsgType())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .build())
                    .build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkMessage = BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.newBuilder().setUnifiedEntranceMessage(message).build();
            ctx.writeAndFlush(checkMessage);
            return;
        }
      // 定期清理推送用户后离线存储及成功响应后删除处理
        if (unifiedEntranceMessage.getHead().getMsgType().equals(IMSContacts.MsgType.DEL_ON_LINE_RECEIVE)){
            log.info("IMServer将定期ql转存离线/客户端回应 ："+unifiedEntranceMessage.getHead().toString());
            MessageFriendCommon messageFriendCommon = new MessageFriendCommon();
            messageFriendCommon.timeClearOnline(unifiedEntranceMessage, unifiedEntranceMessage.getHead());
            return;
        }
        //用户上线后主动推送定期清理通知、音视频消息通知
        if (unifiedEntranceMessage.getHead().getMsgType().equals(IMSContacts.OnlineState.ONLINE)){
            log.info("用户上线："+unifiedEntranceMessage.getHead().toString());
            MessageFriendCommon messageFriendCommon = new MessageFriendCommon();
             messageFriendCommon.Online(ctx,unifiedEntranceMessage, unifiedEntranceMessage.getHead());
             messageFriendCommon.pushAudioAndVideoCallMessage(ctx,unifiedEntranceMessage, unifiedEntranceMessage.getHead());
             return;
        }

        //用户收到音视频推送后响应ack，服务端执行删除
        if (unifiedEntranceMessage.getHead().getMsgType().equals(IMSContacts.MsgType.AUDIO_AND_VIDEO_CALL) &&
            unifiedEntranceMessage.getHead().getStatusReport().equals(ResponseStatus.RECEIPT_OFFLINE)){
            MessageFriendCommon common = new MessageFriendCommon();
            common.removeAVCMessage(unifiedEntranceMessage,unifiedEntranceMessage.getHead());
            return;
        }

          CheckSumResult checkSumResult = jcrc32.checkSumValidateProtocol(msg,unifiedEntranceMessage);
        if(checkSumResult.b_result){
            BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType dataType = unifiedEntranceMessage.getDataType();
            if(ResponseStatus.RESPONSE_CHECK_FAILURE.equals(unifiedEntranceMessage.getHead().getStatusReport())){
                log.info("上个数据包完整性校验失败，重发，状态信息为: " + msg.getUnifiedEntranceMessage().getHead().getStatusReport());
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(unifiedEntranceMessage);
                ctx.writeAndFlush(checkUnified);
            }else {
                log.info("message_friend_server& >>> channel_id:{} and msgType:{} and fromId:{} and toId:{}",channel_id,msgType,fromId,toId);

                msgDeal.msgToDeal(ctx, msg);
            }


        } else {
            log.info("校验失败 >>> channel_id:{} and msgType:{} and fromId:{} and toId:{}",channel_id,msgType,fromId,toId);
//            msgDeal.requestWithResponseValidateFail(ctx, msg);
        }
    }

    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

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
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        log.info("channel close :" + ctx.channel().id() ,cause);
        ctx.close();
    }



}
