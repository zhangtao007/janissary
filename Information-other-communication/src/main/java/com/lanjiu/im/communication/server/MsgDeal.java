package com.lanjiu.im.communication.server;

import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class MsgDeal {

    private final Logger logger = Logger.getLogger(MsgDeal.class);

    public void msgToDeal(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage){
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = checkUnifiedEntranceMessage.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String msgType = head.getMsgType();
        logger.info("当前MsgType-----> " + msgType + "head:"+head.toString());
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response = null;
        CommunicationAPI communicationAPI = new CommunicationAPI();
        try {
            if(IMSContacts.MsgType.FRIEND_LIST_TOURISTS.equals(msgType)){
                //获取游客用户好友列表
                response = communicationAPI.selectGuestUserFriendAPI(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
                logger.info("---获取游客用户好友列表完成---");
            } else if(IMSContacts.MsgType.FRIEND_LIST_REGISTERED.equals(msgType)){
                //获取注册用户好友列表
                long startTime=System.currentTimeMillis();
                response = communicationAPI.selectRegisteredUserFriendAPI(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
                long endTime=System.currentTimeMillis();
                logger.info("获取好友列表接口耗时："+(endTime - startTime));
                logger.info("---获取注册用户好友列表完成---");
            } else if(IMSContacts.MsgType.FRIEND_APPLY_AGREE_TOURISTS.equals(msgType)){
                //同意时，添加好友记录--->当前同意的用户类型为游客
                response =communicationAPI.insertGuestUserFriendAPI(ctx, unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
                logger.info("---游客同意添加好友完成---");
            } else if(IMSContacts.MsgType.FRIEND_APPLY_AGREE_REGISTERED.equals(msgType)){
                //同意时，添加好友记录--->当前同意的用户类型为注册用户
                long startTime=System.currentTimeMillis();
                response = communicationAPI.insertRegisteredUserFriendAPI(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
                long endTime=System.currentTimeMillis();
                logger.info("添加好友接口耗时："+(endTime - startTime));
                logger.info("---注册同意添加好友完成---");
            } else if(IMSContacts.MsgType.FRIEND_DELETE_TOURISTS.equals(msgType)){
                //删除的是游客好友，不用特别关注用户
                communicationAPI.deleteGuestUserFriendAPI(ctx, unifiedEntranceMessage, head);
            } else if(IMSContacts.MsgType.FRIEND_DELETE_REGISTERED.equals(msgType)){
                //删除的是注册好友，不用特别关注用户
                communicationAPI.deleteRegisteredUserFriendAPI(ctx, unifiedEntranceMessage, head);
            } else if(IMSContacts.MsgType.GROUP_FIND_TOURISTS.equals(msgType)){
                //查找某个具体游客群
                communicationAPI.selectGuestGroupAPI(ctx, unifiedEntranceMessage, head);
                logger.info("---根据群ID查找群完成---");
            } else if(IMSContacts.MsgType.GROUP_FIND_REGISTERED.equals(msgType)){
                //查找某个具体注册群
                communicationAPI.selectRegisteredGroupAPI(ctx, unifiedEntranceMessage, head);
                logger.info("---根据群ID查找注册群完成---");
            } else if(IMSContacts.MsgType.GROUP_LIST_TOURISTS.equals(msgType)){
                //查询某个游客用户所有群组
                response = communicationAPI.selectTouristsGroupList(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.GROUP_LIST_REGISTERED.equals(msgType)){
                //查询某个注册用户所有群组
                response = communicationAPI.selectRegisteredGroupList(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.GROUP_CREATE_TOURISTS.equals(msgType)){
                //游客用户创建游客群
                communicationAPI.createGuestGroup(unifiedEntranceMessage, ctx);
            } else if(IMSContacts.MsgType.GROUP_CREATE_REGISTERED.equals(msgType)){
                //注册用户创建注册群
                long startTime=System.currentTimeMillis();
                communicationAPI.createRegisteredGroup(unifiedEntranceMessage, ctx);
                long endTime=System.currentTimeMillis();
                logger.info("创建群接口耗时："+(endTime - startTime));
                logger.info("---注册群创建完成---");
            } else if(IMSContacts.MsgType.GROUP_INFO_TOURISTS.equals(msgType)){
                //查询游客群信息
                response = communicationAPI.selectGuestGroupInformation(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.GROUP_INFO_REGISTERED.equals(msgType)) {
                //查询注册群信息
                response = communicationAPI.selectRegisteredGroupInformation(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
                logger.info("---查询注册群信息完成---");
            }else if(IMSContacts.MsgType.GROUP_MEMBER_INVITE_REGISTERED.equals(msgType)){
                //邀请用户入群(不管是游客还是注册都走这个一个服务,默认用户同意入群，不存在拒绝的情况)
                long startTime=System.currentTimeMillis();
                communicationAPI.inviteUserJoinGroup(unifiedEntranceMessage, ctx);
                long endTime=System.currentTimeMillis();
                logger.info("邀请用户入群接口耗时："+(endTime - startTime));
                logger.info("---邀请用户入群完成---");
            } else if(IMSContacts.MsgType.GROUP_MEMBER_INVITE_AGREE_TOURISTS.equals(msgType)){
                //游客群成员同意邀请时的记录添加
                response = communicationAPI.addTouristsGroupMemberInviteAgree(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.GROUP_MEMBER_INVITE_AGREE_REGISTERED.equals(msgType)){
                //注册群成员同意邀请时的记录添加
                logger.info("注册群成员同意邀请时的记录添加, "+msgType+",  "+head.toString());
                response = communicationAPI.addRegisteredGroupMemberInviteAgree(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.GROUP_MEMBER_APPLY_AGREE_TOURISTS.equals(msgType)){
                //游客群申请，群主同意时的记录添加
                response = communicationAPI.addTouristsGroupMemberApplyAgree(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.GROUP_MEMBER_APPLY_AGREE_REGISTERED.equals(msgType)){
                //注册群申请，群主同意时的记录添加
                response = communicationAPI.addRegisteredGroupMemberApplyAgree(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.GROUP_MEMBER_DELETE_TOURISTS.equals(msgType)){
                //游客群成员删除
                response = communicationAPI.deleteTouristsGroupMember(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.GROUP_MEMBER_DELETE_REGISTERED.equals(msgType)){
                //注册群成员删除
                response = communicationAPI.deleteRegisteredGroupMember(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.GROUP_ANNOUNCEMENT_UPDATE_TOURISTS.equals(msgType)){
                //更新游客群公告
                response = communicationAPI.updateTouristsGroupAnnouncement(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.GROUP_ANNOUNCEMENT_UPDATE_REGISTERED.equals(msgType)){
                //更新注册群公告
                response = communicationAPI.updateRegisteredGroupAnnouncement(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
                logger.info("---更新注册群公告完成---");
            } else if(IMSContacts.MsgType.GROUP_ANNOUNCEMENT_SELECT_TOURISTS.equals(msgType)){
                //查询游客群公告
                response = communicationAPI.selectTouristsGroupAnnouncement(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.GROUP_ANNOUNCEMENT_SELECT_REGISTERED.equals(msgType)){
                //查询注册群公告
                response = communicationAPI.selectRegisteredGroupAnnouncement(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.FRIEND_ALIAS_TOURISTS.equals(msgType)){
                //游客好友更新
                response = communicationAPI.updateTouristsFriend(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.FRIEND_ALIAS_REGISTERED.equals(msgType)){
                //注册好友备注更新
                response = communicationAPI.updateRegisteredFriend(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
                logger.info("---注册好友备注更新完成---");
            } else if(IMSContacts.MsgType.FRIEND_SNAPCHAT_TOURISTS.equals(msgType)){
                //游客好友更新
                response = communicationAPI.updateTouristsFriend(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.FRIEND_SNAPCHAT_REGISTERED.equals(msgType)){
                //注册好友设置阅后即焚更新
                response = communicationAPI.updateRegisteredFriend(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.FRIEND_SNAPCHAT_LENGTH_TOURISTS.equals(msgType)){
                //游客好友更新
                response = communicationAPI.updateTouristsFriend(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.FRIEND_SNAPCHAT_LENGTH_REGISTERED.equals(msgType)){
                //注册好友设置阅后即焚时长更新
                response = communicationAPI.updateRegisteredFriend(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.FRIEND_OFFLINE_MSG_TOURISTS.equals(msgType)){
                //游客好友更新
                response = communicationAPI.updateTouristsFriend(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.FRIEND_OFFLINE_MSG_REGISTERED.equals(msgType)){
                //注册好友好友设置是否离线消息接收更新
                response = communicationAPI.updateRegisteredFriend(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.GROUP_NAME_TOURISTS.equals(msgType)){
                //游客群更新
                response = communicationAPI.updateGuestGroup(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.GROUP_NAME_REGISTERED.equals(msgType)){
                //注册群更新
                response = communicationAPI.updateRegisteredGroup(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
                logger.info("---修改注册群名称完成---");
            } else if(IMSContacts.MsgType.GROUP_MEMBER_ALIAS_TOURISTS.equals(msgType)){
                //游客群成员备注更新
                response = communicationAPI.updateGuestGroupMemberRemark(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.GROUP_MEMBER_ALIAS_REGISTERED.equals(msgType)){
                //注册群成员备注更新
    //            response = communicationAPI.updateRegisteredGroupMemberRemark(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.FRIEND_INFO_TOURISTS.equals(msgType)){
                //游客群成员备注更新
                response = communicationAPI.selectTouristsFriendInformation(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
            } else if(IMSContacts.MsgType.FRIEND_INFO_REGISTERED.equals(msgType)){
                //获取注册好友资料
                long startTime=System.currentTimeMillis();
                response = communicationAPI.selectRegisteredFriendInformation(unifiedEntranceMessage, head);
                ctx.writeAndFlush(response);
                long endTime=System.currentTimeMillis();
                logger.info("获取注册好友资料接口耗时："+(endTime - startTime));
                logger.info("---获取注册好友资料完成---");
            } else if(IMSContacts.MsgType.TOURIST_EXIT.equals(msgType)){
                //游客退出登录
                communicationAPI.touristExitService(unifiedEntranceMessage,ctx);
                logger.info("---游客退出登录完成---");
            } else if(IMSContacts.MsgType.GROUP_MEMBER_LIST.equals(msgType)){
                //获取群成员列表(包括成员字段信息)
                long startTime=System.currentTimeMillis();
                response = communicationAPI.selectGroupMembersInfoList(unifiedEntranceMessage);
                ctx.writeAndFlush(response);
                long endTime=System.currentTimeMillis();
                logger.info("查询群成员列表接口耗时："+(endTime - startTime));
                logger.info("---获取群成员列表完成---");
            } else if(IMSContacts.MsgType.SEARCH_ALLGROUP_BY_USERID.equals(msgType)){
                //根据用户ID搜索用户的所有群
                long startTime=System.currentTimeMillis();
                response = communicationAPI.searchAllGroupByUserId(unifiedEntranceMessage, ctx);
                ctx.writeAndFlush(response);
                long endTime=System.currentTimeMillis();
                logger.info("根据用户ID获取群列表接口耗时："+(endTime - startTime));
                logger.info("---根据用户ID获取群列表完成---");
            } else if(IMSContacts.MsgType.GROUP_MEMBER_DELETE.equals(msgType)){
                //群主移除群成员用户(可以一个可以多个)
                long startTime=System.currentTimeMillis();
                communicationAPI.groupOwnerDeleteMember(unifiedEntranceMessage, ctx);
                long endTime=System.currentTimeMillis();
                logger.info("群主移除群成员用户接口耗时："+(endTime - startTime));
                logger.info("---群主移除群成员用户完成---");
            } else if (IMSContacts.MsgType.GROUP_MEMBER_EXIT_GROUP.equals(msgType)){
                //群成员退出群聊
                long startTime=System.currentTimeMillis();
                communicationAPI.groupMemberExitGroup(unifiedEntranceMessage, ctx);
                long endTime=System.currentTimeMillis();
                logger.info("群成员退出群聊接口耗时："+(endTime - startTime));
                logger.info("---群成员退出群聊完成---");
            } else if (IMSContacts.MsgType.GROUP_MEMBER_COMMENT.equals(msgType)){
                //修改群成员备注
                response = communicationAPI.updateRegisteredGroupMemberRemark(unifiedEntranceMessage, ctx);
                ctx.writeAndFlush(response);
                logger.info("---修改群成员备注完成---");
            }
        }catch (Exception e){
            e.printStackTrace();
            ctx.writeAndFlush(this.exceptionHandleResponse(unifiedEntranceMessage));
        }
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
                        .setToId(head.getToId())
                        .setFromId(head.getFromId())
                        .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setMsgContentType(head.getMsgContentType())
                        .setStatusReport(ResponseStatus.RESPONSE_CHECK_FAILURE)).build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response = jcrc32.packageCheckSum(illegal);
        ctx.writeAndFlush(response);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage exceptionHandleResponse(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage){
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                .newBuilder()
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(IMSContacts.MsgType.FRIEND_APPLY_AGREE_REGISTERED)
                        .setStatusReport("EXCEPTION")
                        .setToId("-")
                        .setFromId(head.getFromId())
                        .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setMsgContentType(head.getMsgContentType())
                        .build()).build();
        return jcrc32.packageCheckSum(message);
    }
}
