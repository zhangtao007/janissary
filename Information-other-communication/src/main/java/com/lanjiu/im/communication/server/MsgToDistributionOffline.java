package com.lanjiu.im.communication.server;

import com.lanjiu.im.communication.client.friend.FriendMessageClient;
import com.lanjiu.im.communication.client.group.GroupMessageClient;
import com.lanjiu.im.communication.client.information.InformationClient;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MsgToDistributionOffline {

    private final Logger log = Logger.getLogger(MsgToDistributionOffline.class);

    public void msgToDistributionOffline(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage){
        BusinessProtocolMessageStandard.Head head = checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead();
        String msgType = head.getMsgType();
        IMServerUtil imServerUtil = new IMServerUtil();
        //离线类的消息类型请求，非设置类型
       if((IMSContacts.MsgType.FRIEND_APPLY_AGREE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_APPLY_AGREE_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_INVITE_AGREE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_INVITE_AGREE_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_APPLY_AGREE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_APPLY_AGREE_REGISTERED.equals(msgType))
                ){
            //好友，群，群成员设置类型，申请同意的时候，的请求派发向资料通信服务器,通知列表（包含好友和群的通知类消息）
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        InformationClient.linkInformationCommunicationServer(checkUnifiedEntranceMessage);
                    } catch (Exception e) {
                        e.printStackTrace();
                        imServerUtil.requestWithResponseFail(ctx, checkUnifiedEntranceMessage);
                        log.info(ResponseStatus.STATUS_REPORT_FAILURE_CHECK_SERVER_STATUS);
                    }
                }
            });

        }else if(IMSContacts.MsgType.FRIEND_APPLY_TOURISTS.equals(msgType)
                ||(IMSContacts.MsgType.FRIEND_APPLY_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_APPLY_REFUSE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_APPLY_REFUSE_REGISTERED.equals(msgType))
                ){
            //好友消息，申请添加，拒绝添加之类的作为信息处理，如果好友在线，直接发给好友，如果好友不在线派发向好友消息通信服务器,通知列表（包含好友和群的通知类消息）
            boolean illegal = imServerUtil.judgeToIdIsLegal(ctx, head, checkUnifiedEntranceMessage);
            if(illegal){
                ExecutorService executorService = Executors.newSingleThreadExecutor();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            FriendMessageClient.linkFriendMessageServer(checkUnifiedEntranceMessage);
                        } catch (Exception e) {
                            e.printStackTrace();
                            imServerUtil.requestWithResponseFail(ctx, checkUnifiedEntranceMessage);
                            log.info(ResponseStatus.STATUS_REPORT_FAILURE_CHECK_SERVER_STATUS);
                        }
                    }
                });
            }

        }else if(IMSContacts.MsgType.GROUP_MEMBER_INVITE_TOURISTS.equals(msgType)
                ||(IMSContacts.MsgType.GROUP_MEMBER_INVITE_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_INVITE_REFUSE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_INVITE_REFUSE_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_APPLY_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_APPLY_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_APPLY_REFUSE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_APPLY_REFUSE_REGISTERED.equals(msgType))
                ){
            //群消息，申请添加，拒绝添加之类的作为信息处理，群成员不在线派发向群消息通信服务器,通知列表（包含好友和群的通知类消息）
            //群聊天直接转发给对方
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        GroupMessageClient.linkGroupMessageServer(checkUnifiedEntranceMessage);
                    } catch (Exception e) {
                        e.printStackTrace();
                        imServerUtil.requestWithResponseFail(ctx, checkUnifiedEntranceMessage);
                        log.info(ResponseStatus.STATUS_REPORT_FAILURE_CHECK_SERVER_STATUS);
                    }
                }
            });

        }else if(IMSContacts.MsgType.FRIEND_CHAT_TOURISTS.equals(msgType)
                ||(IMSContacts.MsgType.FRIEND_CHAT_REGISTERED.equals(msgType))
                ){
            //好友聊天,在离线线时直接转给好友消息通信服务器
           ExecutorService executorService = Executors.newSingleThreadExecutor();
           executorService.execute(new Runnable() {
               @Override
               public void run() {
                   try {
                       FriendMessageClient.linkFriendMessageServer(checkUnifiedEntranceMessage);
                   } catch (Exception e) {
                       e.printStackTrace();
                       imServerUtil.requestWithResponseFail(ctx, checkUnifiedEntranceMessage);
                       log.info(ResponseStatus.STATUS_REPORT_FAILURE_CHECK_SERVER_STATUS);
                   }
               }
           });

        }else if((IMSContacts.MsgType.GROUP_CHAT_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_CHAT_REGISTERED.equals(msgType))
                ){
            //群聊天,在离时直接转发给群消息通信服务器处理
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        GroupMessageClient.linkGroupMessageServer(checkUnifiedEntranceMessage);
                    } catch (Exception e) {
                        e.printStackTrace();
                        imServerUtil.requestWithResponseFail(ctx, checkUnifiedEntranceMessage);
                        log.info(ResponseStatus.STATUS_REPORT_FAILURE_CHECK_SERVER_STATUS);
                    }
                }
            });
        }
    }
}
