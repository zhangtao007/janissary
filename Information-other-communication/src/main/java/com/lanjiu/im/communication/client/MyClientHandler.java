package com.lanjiu.im.communication.client;

import com.lanjiu.im.communication.util.CheckSumResult;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;

public class MyClientHandler extends SimpleChannelInboundHandler<BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage> {

    private int count;
    private final Logger log = Logger.getLogger(MyClientHandler.class);
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) throws Exception {
        //数据包完整性校验
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        JCRC32 jcrc32 = new JCRC32();
        CheckSumResult checkSumResult = jcrc32.checkSumValidateProtocol(msg,unifiedEntranceMessage);
        if(checkSumResult.b_result){
            log.info("Client端数据包校验成功!");
            BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType dataType = unifiedEntranceMessage.getDataType();
            if(dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.RegisteredUserProtocol)
            {
                System.out.println("客户端接收到的RegisteredUserProtocol消息时间：" + unifiedEntranceMessage.getRegisteredUserProtocol().getRegisteredUser().getNickname());
                System.out.println("客户端接收到的RegisteredUserProtocol消息时间：" + unifiedEntranceMessage.getHead().getTimestamp());
            } else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.LoginProtocol)
            {
                System.out.println("客户端接收到的TouristsProtocol消息内容：" );
            }
            System.out.println("客户端收到的消息数量：" + (++this.count));
        }else {
            log.info("Client端数据包校验失败... ...");
            //BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = jcrc32.packageCheckSum(checkSumResult.getMsg());
            //ctx.writeAndFlush(checkSumResult.getMsg());
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        //建立功能模块相关的连接
        //第二个参数为功能类型
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = null;
                    unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.RegisteredUserProtocol)
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(IMSContacts.MsgType.REGISTER)
                            .setTimestamp(LocalDateTime.now().getSecond())
                            .build())
                    .build();

        //加校验码信息
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(unifiedEntranceMessage);
        ctx.writeAndFlush(checkUnified);
    }

    /*
    * 参数为需要交互的功能模块类型，具体类型可以参考常量类
    * ConstantContent中的定义
    * */
//    public BusinessProtocolMessageStandard.UnifiedEntranceMessage interactiveProtocolSelection(ChannelHandlerContext ctx,BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType dataType)
//    {
//        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = null;
//        if(dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.RegisteredUserProtocol)
//        {
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.RegisteredUserProtocol)
//                    .setRegisteredUserProtocol(BusinessProtocolMessageStandard.RegisteredUserProtocol.newBuilder()
//                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setMsgId(ConstantContent.LOGIN_REGISTERED_REGISTERED_REQUEST_MSG_ID)
//                            .setTimestamp(LocalDateTime.now().getSecond())
//                            .build())
//                    .build();
//        } else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.LoginProtocol) {
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.RegisteredUserProtocol)
//                    .setRegisteredUserProtocol(BusinessProtocolMessageStandard.RegisteredUserProtocol.newBuilder()
//                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setMsgId(ConstantContent.LOGIN_LOGIN_REGISTERED_REQUEST_MSG_ID)
//                            .setTimestamp(LocalDateTime.now().getSecond())
//                            .build())
//                    .build();
//        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FindUserRequestProtocol){
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FindUserRequestProtocol)
//                    .setFindUserRequestProtocol(BusinessProtocolMessageStandard.FindUserRequestProtocol.newBuilder()
//                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setStatusReport(ConstantContent.RESPONSE_CHECK_FAILURE)
//                            .build())
//                    .build();
//        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FindGroupRequestProtocol){
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FindGroupRequestProtocol)
//                    .setFindGroupRequestProtocol(BusinessProtocolMessageStandard.FindGroupRequestProtocol.newBuilder()
//                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setStatusReport(ConstantContent.RESPONSE_CHECK_FAILURE)
//                            .build())
//                    .build();
//        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendsListMaintenanceProtocol){
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendsListMaintenanceProtocol)
//                    .setFriendsListMaintenanceProtocol(BusinessProtocolMessageStandard.FriendsListMaintenanceProtocol.newBuilder()
//                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setStatusReport(ConstantContent.RESPONSE_CHECK_FAILURE)
//                            .build())
//                    .build();
//        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupMemberManagementProtocol){
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupMemberManagementProtocol)
//                    .setGroupMemberManagementProtocol(BusinessProtocolMessageStandard.GroupMemberManagementProtocol.newBuilder()
//                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setStatusReport(ConstantContent.RESPONSE_CHECK_FAILURE)
//                            .build())
//                    .build();
//        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.PersonalSettingsProtocol){
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.PersonalSettingsProtocol)
//                    .setPersonalSettingsProtocol(BusinessProtocolMessageStandard.PersonalSettingsProtocol.newBuilder()
//                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setStatusReport(ConstantContent.RESPONSE_CHECK_FAILURE)
//                            .build())
//                    .build();
//        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendsOfflineMessageProtocol){
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendsOfflineMessageProtocol)
//                    .setFriendsOfflineMessageProtocol(BusinessProtocolMessageStandard.FriendsOfflineMessageProtocol.newBuilder()
//                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setStatusReport(ConstantContent.RESPONSE_CHECK_FAILURE)
//                            .build())
//                    .build();
//        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendsBurnAfterReadingProtocol){
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendsBurnAfterReadingProtocol)
//                    .setFriendsBurnAfterReadingProtocol(BusinessProtocolMessageStandard.FriendsBurnAfterReadingProtocol.newBuilder()
//                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setStatusReport(ConstantContent.RESPONSE_CHECK_FAILURE)
//                            .build())
//                    .build();
//        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendsOnlineStatusProtocol){
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendsOnlineStatusProtocol)
//                    .setFriendsOnlineStatusProtocol(BusinessProtocolMessageStandard.FriendsOnlineStatusProtocol.newBuilder()
//                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setStatusReport(ConstantContent.RESPONSE_CHECK_FAILURE)
//                            .build())
//                    .build();
//        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupAnnouncementManagementProtocol){
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupAnnouncementManagementProtocol)
//                    .setGroupAnnouncementManagementProtocol(BusinessProtocolMessageStandard.GroupAnnouncementManagementProtocol.newBuilder()
//                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setStatusReport(ConstantContent.RESPONSE_CHECK_FAILURE)
//                            .build())
//                    .build();
//        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupBurnAfterReadingProtocol){
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupBurnAfterReadingProtocol)
//                    .setGroupBurnAfterReadingProtocol(BusinessProtocolMessageStandard.GroupBurnAfterReadingProtocol.newBuilder()
//                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setStatusReport(ConstantContent.RESPONSE_CHECK_FAILURE)
//                            .build())
//                    .build();
//        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OneVOneChatSendingMessageProtocol){
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OneVOneChatSendingMessageProtocol)
//                    .setOneVOneChatSendingMessageProtocol(BusinessProtocolMessageStandard.OneVOneChatSendingMessageProtocol.newBuilder()
//                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setStatusReport(ConstantContent.RESPONSE_CHECK_FAILURE)
//                            .build())
//                    .build();
//        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OneVOneChatReceptionProtocol){
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OneVOneChatReceptionProtocol)
//                    .setOneVOneChatReceptionProtocol(BusinessProtocolMessageStandard.OneVOneChatReceptionProtocol.newBuilder()
//                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setStatusReport(ConstantContent.RESPONSE_CHECK_FAILURE)
//                            .build())
//                    .build();
//        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupMessagingProtocol){
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupMessagingProtocol)
//                    .setGroupMessagingProtocol(BusinessProtocolMessageStandard.GroupMessagingProtocol.newBuilder()
//                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setStatusReport(ConstantContent.RESPONSE_CHECK_FAILURE)
//                            .build())
//                    .build();
//        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupMessageReceptionProtocol){
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupMessageReceptionProtocol)
//                    .setGroupMessageReceptionProtocol(BusinessProtocolMessageStandard.GroupMessageReceptionProtocol.newBuilder()
//                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setStatusReport(ConstantContent.RESPONSE_CHECK_FAILURE)
//                            .build())
//                    .build();
//        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OriginalPictureVideoFriendsTransmissionProtocol){
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OriginalPictureVideoFriendsTransmissionProtocol)
//                    .setOriginalPictureVideoFriendsTransmissionProtocol(BusinessProtocolMessageStandard.OriginalPictureVideoFriendsTransmissionProtocol.newBuilder()
//                            .setTourists(BusinessProtocolMessageStandard.Tourists.newBuilder()
//                                    .setTemporaryId("client login module test")
//                                    .setIpAddress(ctx.channel().localAddress().toString())
//                                    .setMacAddress(ctx.channel().localAddress().toString())
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setMsgId(ConstantContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_FRIENDS_MSG_ID)
//                            .setTimestamp(LocalDateTime.now().getSecond())
//                            .build())
//                    .build();
//        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OriginalPictureVideoGroupTransmissionProtocol){
//            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OriginalPictureVideoGroupTransmissionProtocol)
//                    .setOriginalPictureVideoGroupTransmissionProtocol(BusinessProtocolMessageStandard.OriginalPictureVideoGroupTransmissionProtocol.newBuilder()
//                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
//                                    .build())
//                            .build())
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                            .setStatusReport(ConstantContent.RESPONSE_CHECK_FAILURE)
//                            .build())
//                    .build();
//        }
//        return unifiedEntranceMessage;
//    }
}
