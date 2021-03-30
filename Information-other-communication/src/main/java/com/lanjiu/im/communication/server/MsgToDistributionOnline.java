package com.lanjiu.im.communication.server;

import com.lanjiu.im.communication.client.friend.FriendMessageClient;
import com.lanjiu.im.communication.client.group.GroupMessageClient;
import com.lanjiu.im.communication.client.information.InformationClient;
import com.lanjiu.im.communication.client.login.LoginRegistrationClient;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MsgToDistributionOnline {

    private final Logger log = Logger.getLogger(MsgToDistributionOnline.class);

    public void msgToDistributionOnline(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage){
        BusinessProtocolMessageStandard.Head head = checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead();
        String msgType = head.getMsgType();
        IMServerUtil imServerUtil = new IMServerUtil();
        //请求派发
        if(IMSContacts.MsgType.HEART_PACKAGE_PHONE_END.equals(msgType)){
            //心跳连接断开
            log.info("主动断开心跳连接");
        }else if(IMSContacts.MsgType.HEART_PACKAGE_PHONE.equals(msgType)){
            //发送心跳，维持连接
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage replyMsg = imServerUtil.buildHeartBeat();
            ctx.writeAndFlush(replyMsg);
        }else if((IMSContacts.MsgType.FRIEND_FIND_TOURISTS.equals(msgType)
                ||(IMSContacts.MsgType.FRIEND_FIND_REGISTERED.equals(msgType))
                ||IMSContacts.MsgType.REGISTER.equals(msgType))
                ||(IMSContacts.MsgType.LOGIN_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.LOGIN_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.LOGOUT_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.LOGOUT_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_NICKNAME_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_NICKNAME_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_AVATAR_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_AVATAR_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_OFFLINE_MSG_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_OFFLINE_MSG_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_FRIEND_SNAPCHAT_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_FRIEND_SNAPCHAT_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_FRIEND_SNAPCHAT_LENGTH_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_FRIEND_SNAPCHAT_LENGTH_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_GROUP_SNAPCHAT_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_GROUP_SNAPCHAT_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_GROUP_SNAPCHAT_LENGTH_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_GROUP_SNAPCHAT_LENGTH_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_EXIT_CLEAN_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_EXIT_CLEAN_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_TIMER_CLEAN_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.PERSONAL_TIMER_CLEAN_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_INFO_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_INFO_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.VERIFICATION_CODE.equals(msgType))
                ||(IMSContacts.MsgType.RESET_SECRET_VERIFY.equals(msgType))
                ||(IMSContacts.MsgType.RESET_SECRET.equals(msgType))
                ||(IMSContacts.MsgType.SETUP_PHONE.equals(msgType))
                ||(IMSContacts.MsgType.SETUP_PHONE_EDIT.equals(msgType))
                ){
            //注册，登录，个人信息设置的派发向登录注册通信服务器
//            log.info("返回");
//            imServerUtil.requestWithResponseSuccess(ctx, checkUnifiedEntranceMessage);
//            return;
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        LoginRegistrationClient.linkLoginRegistrationServer(checkUnifiedEntranceMessage);
                    } catch (Exception e) {
                        e.printStackTrace();
                        imServerUtil.requestWithResponseFail(ctx, checkUnifiedEntranceMessage);
                        log.info(ResponseStatus.STATUS_REPORT_FAILURE_CHECK_SERVER_STATUS);
                    }
                }
            });

        }else if((IMSContacts.MsgType.FRIEND_LIST_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_LIST_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_APPLY_AGREE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_APPLY_AGREE_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_DELETE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_DELETE_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_FIND_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_FIND_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_LIST_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_LIST_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_CREATE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_CREATE_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_INFO_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_INFO_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_INVITE_AGREE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_INVITE_AGREE_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_APPLY_AGREE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_APPLY_AGREE_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_DELETE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_DELETE_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_ANNOUNCEMENT_UPDATE_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_ANNOUNCEMENT_UPDATE_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_ANNOUNCEMENT_SELECT_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_ANNOUNCEMENT_SELECT_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_ALIAS_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_ALIAS_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_SNAPCHAT_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_SNAPCHAT_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_SNAPCHAT_LENGTH_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_SNAPCHAT_LENGTH_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_OFFLINE_MSG_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.FRIEND_OFFLINE_MSG_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_NAME_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_NAME_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_SNAPCHAT_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_SNAPCHAT_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_SNAPCHAT_LENGTH_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_SNAPCHAT_LENGTH_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_NICK_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_NICK_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_ALIAS_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_ALIAS_REGISTERED.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_MEMBER_ALIAS_REGISTERED.equals(msgType))
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
            //好友消息，申请添加，拒绝添加之类的作为信息处理，如果好友在线，直接发给好友，如果好友不在线派发向好友消息通信服务器
            boolean illegal = imServerUtil.judgeToIdIsLegal(ctx, head, checkUnifiedEntranceMessage);
            if(!illegal){
                return;
            }
            boolean bSuccess = imServerUtil.chatWithFriend(checkUnifiedEntranceMessage, head);
            if(!bSuccess){
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
            //群消息，申请添加，拒绝添加之类的作为信息处理，如果群成员在线，直接发给对方，如果群成员不在线派发向群消息通信服务器
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
            //好友聊天,在线时直接转发给对方，如果发送失败转给好友消息通信服务器
            boolean illegal = imServerUtil.judgeToIdIsLegal(ctx, head, checkUnifiedEntranceMessage);
            if(!illegal){
                return;
            }
            boolean bSuccess = imServerUtil.chatWithFriend(checkUnifiedEntranceMessage, head);
            if(!bSuccess){
                ExecutorService executorService = Executors.newFixedThreadPool(2);
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

        }else if((IMSContacts.MsgType.GROUP_CHAT_TOURISTS.equals(msgType))
                ||(IMSContacts.MsgType.GROUP_CHAT_REGISTERED.equals(msgType))
                ){
            //群聊天,在线时直接转发给群消息通信服务器处理
            boolean illegal = imServerUtil.judgeToIdIsLegal(ctx, head, checkUnifiedEntranceMessage);
            if(!illegal){
                imServerUtil.judgeToIdIsLegal(ctx, head, checkUnifiedEntranceMessage);
                return;
            }
            ExecutorService executorService = Executors.newFixedThreadPool(2);
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
