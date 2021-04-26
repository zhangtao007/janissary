package com.lanjiu.im.netty.server;

import com.lanjiu.im.netty.common.LoginRegistComm;
import com.lanjiu.im.util.IMSContacts;
import com.lanjiu.im.util.JCRC32;
import com.lanjiu.im.util.ResponseStatus;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MsgDeal {

    private static final Logger logger = LoggerFactory.getLogger(MsgDeal.class);

    public void msgToDeal(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = checkUnifiedEntranceMessage.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String msgType = head.getMsgType();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response = null;
        LoginRegistComm loginRegistComm = new LoginRegistComm();
        //请求处理

        if(IMSContacts.MsgType.REGISTER.equals(msgType)){
            response = loginRegistComm.regist(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        } else if(IMSContacts.MsgType.LOGIN_REGISTERED.equals(msgType)) {
            response = loginRegistComm.loginRegistered(unifiedEntranceMessage, head);

            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.LOGIN_TOURISTS.equals(msgType)) {
            response = loginRegistComm.loginTourists(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.LOGOUT_REGISTERED.equals(msgType)) {
            response = loginRegistComm.logoutRegistered(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.LOGOUT_TOURISTS.equals(msgType)){
            response = loginRegistComm.logoutTourists(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if((IMSContacts.MsgType.PERSONAL_EXIT_CLEAN_REGISTERED.equals(msgType))
                || (IMSContacts.MsgType.PERSONAL_TIMER_CLEAN_REGISTERED.equals(msgType))
                || (IMSContacts.MsgType.USER_INFOMATION.equals(msgType))
                  ){
            response = loginRegistComm.registPersonSetting(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.PERSONAL_AVATAR_REGISTERED.equals(msgType)
                ||  (IMSContacts.MsgType.PERSONAL_NICKNAME_REGISTERED.equals(msgType))
                || (IMSContacts.MsgType.RESET_SECRET.equals(msgType))
                || (IMSContacts.MsgType.RESET_SECRET_VERIFY.equals(msgType))
                ){
            response = loginRegistComm.registPersonInfo(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if((IMSContacts.MsgType.VERIFICATION_CODE.equals(msgType))
        ){
            response = loginRegistComm.verificationCode(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if((IMSContacts.MsgType.SETUP_PHONE.equals(msgType))
                || (IMSContacts.MsgType.SETUP_PHONE_EDIT.equals(msgType))
        ){
            response = loginRegistComm.setPhone(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if((IMSContacts.MsgType.PERSONAL_AVATAR_TOURISTS.equals(msgType))
                || (IMSContacts.MsgType.PERSONAL_NICKNAME_TOURISTS.equals(msgType))
                 ){
            response = loginRegistComm.guestPersonInfo(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if( (IMSContacts.MsgType.FRIEND_FIND_REGISTERED.equals(msgType))){
            response = loginRegistComm.findUserRegist(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.FRIEND_FIND_TOURISTS.equals(msgType)){
            response = loginRegistComm.findUserGuest(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.OnlineState.ONLINE.equals(msgType)){
            response = loginRegistComm.changeStatusOnline(unifiedEntranceMessage, head);
             ctx.writeAndFlush(response);
        }else if(IMSContacts.OnlineState.OFFLINE.equals(msgType)) {
            response = loginRegistComm.changeStatusOffline(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.CHECK_FOR_UPDATES.equals(msgType)) {
            response = loginRegistComm.checkVersion(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else if(IMSContacts.MsgType.USER_DEVICE_UPDATE.equals(msgType)) {
            response = loginRegistComm.updateUserDevice(unifiedEntranceMessage, head);
            ctx.writeAndFlush(response);
        }else{
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ResponseStatus.STATUS_REPORT_UNKNOW_MSGTYPE)
                            .setToken(head.getToken())
                            .setMsgType(head.getMsgType())
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .build())
                    .build();
            JCRC32 jcrc32 = new JCRC32();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkMessage = jcrc32.packageCheckSum(message);
            ctx.writeAndFlush(checkMessage);
        }

        printLog(checkUnifiedEntranceMessage);


    }

    public void requestWithResponseValidateFail(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage){
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.Head head= checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage illegal = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setRegisteredUserProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getRegisteredUserProtocol())
                .setLoginProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getLoginProtocol())
                .setLogoutProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getLogoutProtocol())
                .setFindUserProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFindUserProtocol())
                .setFriendListProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendListProtocol())
                .setFriendInfoProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendInfoProtocol())
                .setFriendOnlineStatusChangeProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendOnlineStatusChangeProtocol())
                .setFriendAddProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendAddProtocol())
                .setFriendDeleteProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendDeleteProtocol())
                .setFindGroupProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFindGroupProtocol())
                .setGroupListProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupListProtocol())
                .setGroupCreateProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupCreateProtocol())
                .setGroupInfoProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupInfoProtocol())
                .setGroupMemberOnlineStatusChangeProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberOnlineStatusChangeProtocol())
                .setGroupMemberAddProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberAddProtocol())
                .setGroupMemberDeleteProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberDeleteProtocol())
                .setGroupAnnouncementProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupAnnouncementProtocol())
                .setPersonalInfoProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getPersonalInfoProtocol())
                .setPersonalSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getPersonalSettingsProtocol())
                .setFriendSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendSettingsProtocol())
                .setGroupSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupSettingsProtocol())
                .setGroupMemberSettingsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupMemberSettingsProtocol())
                .setNotificationsProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getNotificationsProtocol())
                .setSysNotifyProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getSysNotifyProtocol())
                .setUserNotifyProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getUserNotifyProtocol())
                .setFriendChatProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getFriendChatProtocol())
                .setGroupChatProtocol(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getGroupChatProtocol())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(head.getMsgType())
                        .setToId(head.getFromId())
                        .setFromId(head.getToId())
                        .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setMsgContentType(head.getMsgContentType())
                        .setStatusReport(ResponseStatus.RESPONSE_CHECK_FAILURE)).build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response = jcrc32.packageCheckSum(illegal);
        ctx.writeAndFlush(response);
        return ;
    }



    private void printLog(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String msgType = head.getMsgType();
        switch (msgType){
            case IMSContacts.MsgType.LOGIN_REGISTERED:
                logger.info("用户【"+ head.getFromId() +"】获取info：" + msg.getUnifiedEntranceMessage().toString());
                break;
            case IMSContacts.MsgType.USER_DEVICE_UPDATE:
                logger.info("用户【"+ head.getFromId() +"】获取设备token：" + msg.getUnifiedEntranceMessage().toString());
                break;
            case IMSContacts.MsgType.CHECK_FOR_UPDATES:
                logger.info("用户【"+ head.getFromId() +"】获取版本信息：" + msg.getUnifiedEntranceMessage().toString());
            default:
                break;
        }
    }
}
