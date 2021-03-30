package com.lanjiu.im.communication.client.information;

import com.lanjiu.im.communication.client.group.GroupMessageClient;
import com.lanjiu.im.communication.client.util.IMClientUtils;
import com.lanjiu.im.communication.client.friend.FriendMessageClient;
import com.lanjiu.im.communication.server.MsgToDistributionOnline;
import com.lanjiu.im.communication.util.IMServerUtil;
import com.lanjiu.im.communication.util.CheckSumResult;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.*;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.lanjiu.im.communication.client.information.InformationClient.infoChannel;

public class InformationClientHandler extends SimpleChannelInboundHandler<BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage> {

    private final Logger log = Logger.getLogger(InformationClientHandler.class);

    //线程安全心跳失败计数器
    private AtomicInteger atomicInteger = new AtomicInteger(1);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) throws Exception {
        //数据包完整性校验
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String msgType = head.getMsgType();
        if (IMSContacts.MsgType.HEART_PACKAGE.equals(msgType)){
            //清零心跳失败计数器
            atomicInteger = new AtomicInteger(1);
            return;
        }

        CheckSumResult checkSumResult = JCRC32.checkSumValidateProtocol(msg,unifiedEntranceMessage);

        if(!checkSumResult.b_result){
            log.info("IM InformationClient端数据包校验失败... ...");
            ctx.channel().writeAndFlush(IMServerUtil.requestWithResponseValidateFail(msg));
            return;
        }
        if(ResponseStatus.RESPONSE_CHECK_FAILURE.equals(unifiedEntranceMessage.getHead().getStatusReport())){
            log.info("上个数据包完整性校验失败，重发，状态信息为: " + msg.getUnifiedEntranceMessage().getHead().getStatusReport());
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = JCRC32.packageCheckSum(unifiedEntranceMessage);
            ctx.writeAndFlush(checkUnified);
            return;
        }
        printLog(msg);
        if (IMSContacts.MsgType.FRIEND_APPLY_AGREE_REGISTERED.equals(msgType) || IMSContacts.MsgType.FRIEND_APPLY_AGREE_TOURISTS.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                log.info("用户【"+ head.getFromId() +"】同意好友申请响应成功：");
                shortChannel.writeAndFlush(InformationUtils.responseAddFriendMsg(msg));
            }
            if (ResponseStatus.STATUS_REPORT_EXCEPTION.equals(head.getStatusReport())){
                log.info("用户【"+ head.getFromId() +"】同意好友申请响应失败：");
                return;
            }
            String toId = head.getToId();
            Channel toIdChannel = IMServerUtil.getSocketChannel(toId);
            if (toIdChannel != null && toIdChannel.isActive()){
                IMServerUtil.writeAndFlushFriend(toIdChannel, head.getToId(), msg);
            }else {
                FriendMessageClient.sendFriendServer(msg);
            }
            return;
        }
        if (IMSContacts.MsgType.FRIEND_LIST_TOURISTS.equals(msgType) || IMSContacts.MsgType.FRIEND_LIST_REGISTERED.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }
        if (IMSContacts.MsgType.GROUP_LIST_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_LIST_REGISTERED.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        // 创建群
        if (IMSContacts.MsgType.GROUP_CREATE_REGISTERED.equals(msgType) || IMSContacts.MsgType.GROUP_CREATE_TOURISTS.equals(msgType)){
            if (head.getFromId().equals(head.getToId())){
                Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
                if (shortChannel != null){
                    shortChannel.writeAndFlush(msg);
                }
            }else {
                Channel socketChannel = IMServerUtil.getSocketChannel(head.getToId());
                if (socketChannel != null){
                    IMServerUtil.writeAndFlushMsgGroup(socketChannel, head.getToId(), msg);
                }else {
                    GroupMessageClient.sendGroupMessageServer(msg);
                }
            }
            return;
        }

        if (IMSContacts.MsgType.GROUP_MSG_NOTIFY.equals(msgType)){
            Channel socketChannel = IMServerUtil.getSocketChannel(head.getToId());
            if (socketChannel != null){
                IMServerUtil.writeAndFlushFriend(socketChannel, head.getToId(), msg);
            }else {
                try {
                    FriendMessageClient.sendFriendServer(msg);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return;
        }
        if (IMSContacts.MsgType.FRIEND_ALIAS_TOURISTS.equals(msgType) || IMSContacts.MsgType.FRIEND_ALIAS_REGISTERED.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        if (IMSContacts.MsgType.FRIEND_DELETE_REGISTERED.equals(msgType) || IMSContacts.MsgType.FRIEND_DELETE_TOURISTS.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        if (IMSContacts.MsgType.FRIEND_OFFLINE_MSG_REGISTERED.equals(msgType) || IMSContacts.MsgType.FRIEND_OFFLINE_MSG_TOURISTS.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        if (IMSContacts.MsgType.GROUP_MEMBER_INVITE_REGISTERED.equals(msgType) || IMSContacts.MsgType.GROUP_MEMBER_INVITE_TOURISTS.equals(msgType)){
            if(!head.getFromId().equals(head.getToId())){
                Channel socketChannel = IMServerUtil.getSocketChannel(head.getToId());
                if (socketChannel != null){
                    IMServerUtil.writeAndFlushFriend(socketChannel, head.getToId(), msg);
                }else {
                    GroupMessageClient.sendGroupMessageServer(msg);
                }
            }
            return;
        }

        if (IMSContacts.MsgType.GROUP_MEMBER_APPLY_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_MEMBER_APPLY_REGISTERED.equals(msgType)){
            Channel socketChannel = IMServerUtil.getSocketChannel(head.getToId());
            if (socketChannel != null){
                IMServerUtil.writeAndFlushFriend(socketChannel, head.getToId(), msg);
            }
            return;
        }

        // 查询群
        if (IMSContacts.MsgType.GROUP_FIND_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_FIND_REGISTERED.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        // 获取群成员列表
        if (IMSContacts.MsgType.GET_GROUP_MEMBERS.equals(msgType) || IMSContacts.MsgType.GET_GROUP_LIST.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        // 设置群名称
        if (IMSContacts.MsgType.GROUP_NAME_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_NAME_REGISTERED.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        // 修改群公告
        if (IMSContacts.MsgType.GROUP_ANNOUNCEMENT_UPDATE_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_ANNOUNCEMENT_UPDATE_REGISTERED.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        // 群资料
        if (IMSContacts.MsgType.GROUP_INFO_TOURISTS.equals(msgType) || (IMSContacts.MsgType.GROUP_INFO_REGISTERED.equals(msgType))){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        // 群聊天-踢出成员
        if (IMSContacts.MsgType.GROUP_MEMBER_DELETE.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(IMServerUtil.responseSuccessfulMsg(msg));
            }else {
                GroupMessageClient.sendGroupMessageServer(msg);
            }
            Channel socketChannel = IMServerUtil.getSocketChannel(head.getToId());
            if (socketChannel != null){
                socketChannel.writeAndFlush(msg);
            }else {
                GroupMessageClient.sendGroupMessageServer(msg);
            }
            return;
        }

        // 群成员、群主退群
        if (IMSContacts.MsgType.GROUP_MEMBER_EXIT.equals(msgType)){
            Channel socketChannel = IMServerUtil.getSocketChannel(head.getToId());
            if (socketChannel != null && !head.getFromId().equals(head.getToId())){
                log.info("用户【"+head.getFromId()+"】退群，通知在线群成员【"+ head.getToId() +"】，走5秒");
                IMServerUtil.writeAndFlushMsgGroup(socketChannel, head.getToId(), msg);
            }else {
                log.info("用户【"+head.getFromId()+"】退群，通知离线群成员【"+ head.getToId() +"】");
                GroupMessageClient.sendGroupMessageServer(msg);
            }
            if (head.getToId().equals(head.getFromId()) && IMSContacts.GROU_OWNER_RETREAT.equals(head.getStatusReport())){
                GroupMessageClient.sendGroupMessageServer(IMServerUtil.groupOwnerExit(msg));
            }
            return;
        }

        // 修改群备注
        if (IMSContacts.MsgType.UPDATE_GROUP_REMARK.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        // 好友资料
        if (IMSContacts.MsgType.FRIEND_INFO_TOURISTS.equals(msgType) || IMSContacts.MsgType.FRIEND_INFO_REGISTERED.equals(msgType)){
            Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
            if (shortChannel != null){
                shortChannel.writeAndFlush(msg);
            }
            return;
        }

        // 删除群成员
        if (IMSContacts.MsgType.GROUP_MEMBER_DELETE_TOURISTS.equals(msgType) || IMSContacts.MsgType.GROUP_MEMBER_DELETE_REGISTERED.equals(msgType)){
            if(head.getFromId().equals(head.getToId())){
                Channel shortChannel = IMServerUtil.getShortChannel(head.getFromId());
                if (shortChannel != null){
                    shortChannel.writeAndFlush(msg);
                }
                return;
            }
            Channel socketChannel = IMServerUtil.getSocketChannel(head.getToId());
            if (socketChannel != null){
                IMServerUtil.writeAndFlushFriend(socketChannel, head.getToId(), msg);
            }else {
                GroupMessageClient.sendGroupMessageServer(msg);
            }
        }
    }

    private void printLog(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String msgType = head.getMsgType();
        switch (msgType){
        case IMSContacts.MsgType.GET_GROUP_MEMBERS:
            List<BusinessProtocolEntities.AllGroupMemberVO> allGroupMemberVoList = unifiedEntranceMessage.getGroupInfoProtocol().getAllGroupMemberVoList();
            if (allGroupMemberVoList == null || allGroupMemberVoList.isEmpty()){
                log.info("资料服务响应【"+ head.getFromId() +"】发送的【"+ msgType +"】数据（获取群成员列表）：" + msg);
                return;
            }
            Integer groupId = allGroupMemberVoList.stream().findFirst().map(BusinessProtocolEntities.AllGroupMemberVO::getRegisteredGroupId).get();
            List<Integer> collect = allGroupMemberVoList.stream().map(BusinessProtocolEntities.AllGroupMemberVO::getRegisteredUserId).collect(Collectors.toList());
//            log.info("用户【"+ head.getFromId() +"】获取【"+ groupId +"】群成员列表（人数："+ allGroupMemberVoList.size() +"）：" + collect);
            log.info("用户【"+ head.getFromId() +"】获取【"+ groupId +"】群成员列表（人数："+ allGroupMemberVoList.size() +"）：" + msg);
            break;
        default:
            log.info("资料服务响应【"+ head.getFromId() +"】发送的【"+ msgType +"】数据：" + msg);
            break;
        }
    }

    /**
     * 事件触发器，该处用来处理客户端空闲超时,发送心跳维持连接。
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        IMClientUtils.userEventTriggered(ctx, evt, atomicInteger, "Information");
    }

    /**
     * 处理断开重连
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("与资料服务器连接断开，尝试重新连接...");
        ctx.close();
        infoChannel.close();
        InformationClient.getInstance();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
