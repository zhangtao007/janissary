package com.lanjiu.im.communication.server;

import com.google.common.base.Joiner;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.huawei.push.exception.HuaweiMesssagingException;
import com.huawei.push.message.AndroidConfig;
import com.huawei.push.message.Message;
import com.huawei.push.messaging.HuaweiApp;
import com.huawei.push.messaging.HuaweiMessaging;
import com.huawei.push.model.Urgency;
import com.huawei.push.reponse.SendResponse;
import com.huawei.push.util.InitAppUtils;
import com.lanjiu.im.grpc.AllGroupMemberVO;
import com.lanjiu.im.grpc.AllGroupsMemberResponse;
import com.lanjiu.im.grpc.client.login_client.LoginStorageGrpcApi;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.im.communication.service.MessageGroupCommunicationAPI;
import com.lanjiu.im.communication.util.*;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import com.lanjiu.pro.groupStorage.GroupAudioVideoMessage;
import com.lanjiu.pro.groupStorage.GroupMsg;
import com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest;
import com.lanjiu.pro.groupStorage.ResponseResult;
import com.lanjiu.pro.login.RegisterStorageProto;
import io.netty.channel.*;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static com.google.common.collect.ComparisonChain.start;

public class MessageGroupServerHandler extends SimpleChannelInboundHandler<BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage> {

    private final Logger log = Logger.getLogger(MessageGroupServerHandler.class);

    private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    private ThreadLocal<Channel> threadLocal = new ThreadLocal();

    private MessageGroupCommunicationAPI messageGroupCommunicationAPI;

    public MessageGroupServerHandler() {
        this.messageGroupCommunicationAPI = new MessageGroupCommunicationAPI();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        try {
            BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
            BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
            String msgType = head.getMsgType();
            threadLocal.set(ctx.channel());
            if (GroupContacts.MsgType.HEART_PACKAGE.equals(msgType)){
                log.info("管道ID: " + ctx.channel().id().toString() + "，请求服务地址：" + ctx.channel().remoteAddress() + "，群聊天服务心跳正常");
                //发送心跳，维持连接
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage replyMsg = ResponseUtil.buildHeartBeat();
                ctx.channel().writeAndFlush(replyMsg);
                return;
            }
            //数据包完整性校验
            CheckSumResult checkSumResult = JCRC32.checkSumValidateProtocol(msg,unifiedEntranceMessage);
            if(!checkSumResult.b_result){
                log.info("上个数据包完整性校验失败，重发" + msg);
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = JCRC32.packageCheckSum(unifiedEntranceMessage);
                ctx.channel().writeAndFlush(checkUnified);
                return;
            }
            if(ResponseStatus.RESPONSE_CHECK_FAILURE.equals(unifiedEntranceMessage.getHead().getStatusReport())){
                log.info("数据包完整性校验失败: " + msg);
                ctx.channel().writeAndFlush(ResponseUtil.responseFailMsg(msg));
                return;
            }
            printLog(msg);


            // 群聊天
            if(GroupContacts.MsgType.GROUP_CHAT_TOURISTS.equals(msgType) || GroupContacts.MsgType.GROUP_CHAT_REGISTERED.equals(msgType)){

                Integer msgId = this.messageGroupCommunicationAPI.saveGroupMsg(msg);
                log.info("存储消息ID：" + msgId);
                if (msgId == null){
                    log.info("用户【"+ head.getFromId() +"】发送的群聊天数据保存失败");
                    ctx.channel().writeAndFlush(ResponseUtil.responseFailMsg(msg));
                }else {
                    this.groupChatMsgHandler(ctx, msgId, msg);
                }
                return;
            }

            // 拉取群离线消息
            if (GroupContacts.MsgType.GROUP_CHART_OFF_LINE_MSG.equals(msgType)){
                log.info("===================拉取群离线消息开始时间：===================" + CommonUtils.getTime());
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = messageGroupCommunicationAPI.selectOffLineGroupMsg(msg);
                ctx.channel().writeAndFlush(checkUnifiedEntranceMessage);
                log.info("===================拉取群离线消息开始结束：===================" + CommonUtils.getTime());
                return;
            }

            // 群聊天-删除离线消息
            if (GroupContacts.MsgType.DELETE_GROUP_CHART_OFF_LINE_MSG.equals(msgType)){
                log.info("群聊天-删除离线消息");
                messageGroupCommunicationAPI.deleteSendOffLineMsg(msg);
            }

            // 群聊天消息存储
            if(GroupContacts.MsgType.GROUP_CHAT_MESSAGE_STORAGE.equals(msgType)){
                log.info("群聊天-存储离线消息");

                LoginStorageGrpcApi loginApi = new LoginStorageGrpcApi();
                cachedThreadPool.execute(new Runnable() {
                    @Override
                    public void run()  {
                        //1.调用登录服务查看该用户是否华为设备，若是并且未退出登录则获取token;
                        String fromId = msg.getUnifiedEntranceMessage().getHead().getFromId();
                        String toId = msg.getUnifiedEntranceMessage().getHead().getToId();
                        String groupId = msg.getUnifiedEntranceMessage().getGroupChatProtocol().getRegisteredGroupMember().getGroup().getGroupId();
                        RegisterStorageProto.RequestUserDevice requestUserDevice = RegisterStorageProto.RequestUserDevice.newBuilder().addRequestDeviceUpdate(RegisterStorageProto.RequestDeviceUpdate.newBuilder().setUserId(toId).setStatusDetail("select").build()).build();
                        RegisterStorageProto.RequestUserDevice response = loginApi.updateUserDevice(requestUserDevice);
                        //2.调用华为推送服务下发消息
                        if(response != null && response.getRequestDeviceUpdate(0).getStatusDetail().equalsIgnoreCase(ResponseStatus.STATUS_REPORT_SUCCESS)){
                            //todo 调用华为推送
                            String pushToken = response.getRequestDeviceUpdate(0).getPushToken();
                            String content = CommonUtils.msgContentHandel(msg.getUnifiedEntranceMessage().getGroupChatProtocol().getChatMessage());
                           Map<String,String> data = new HashMap();
                           data.put("fromId",fromId);
                           data.put("toId",toId);
                           data.put("groupId",groupId);
                           data.put("content",content);
                           data.put("pushToken",pushToken);
                           BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage entranceMessage = ResponseUtil.transtionHuaweiPush(msg,data);
                            ctx.channel().writeAndFlush(entranceMessage);
                           return;
                        }

                    }
                });

                messageGroupCommunicationAPI.saveGroupMembersOffLinMsg(msg);
                return;
            }

            // 创建群
            if (GroupContacts.MsgType.GROUP_CREATE_REGISTERED.equals(msgType) || GroupContacts.MsgType.GROUP_CREATE_TOURISTS.equals(msgType)){
                messageGroupCommunicationAPI.saveCreateGroupOffLinMsg(msg);
                return;
            }

            // 邀请入群
            if (GroupContacts.MsgType.GROUP_MEMBER_INVITE_REGISTERED.equals(msgType) || GroupContacts.MsgType.GROUP_MEMBER_INVITE_TOURISTS.equals(msgType)){
                messageGroupCommunicationAPI.saveInviteAddGroupOffLinMsg(msg);
                return;
            }

            // 申请入群
            if (GroupContacts.MsgType.GROUP_MEMBER_APPLY_TOURISTS.equals(msgType) || GroupContacts.MsgType.GROUP_MEMBER_APPLY_REGISTERED.equals(msgType)){
                messageGroupCommunicationAPI.saveGroupOffLinMsg(msg, GroupContacts.OffLineMsgType.REQ_JOIN_IN, "申请入群");
                return;
            }

            // 同意申请
            if (GroupContacts.MsgType.GROUP_MEMBER_APPLY_AGREE_REGISTERED.equals(msgType) || GroupContacts.MsgType.GROUP_MEMBER_APPLY_AGREE_TOURISTS.equals(msgType)){
                messageGroupCommunicationAPI.saveGroupOffLinMsg(msg, GroupContacts.OffLineMsgType.REQ_CONSENT, "同意申请");
                return;
            }

            // 拒绝入群申请
            if (GroupContacts.MsgType.GROUP_MEMBER_APPLY_REFUSE_TOURISTS.equals(msgType) || GroupContacts.MsgType.GROUP_MEMBER_APPLY_REFUSE_REGISTERED.equals(msgType)){
                messageGroupCommunicationAPI.saveGroupOffLinMsg(msg, GroupContacts.OffLineMsgType.REQ_REFUSE, "拒绝入群申请");
                return;
            }
            // 群聊天-踢出成员
            if (GroupContacts.MsgType.GROUP_MEMBER_DELETE.equals(msgType)){
                messageGroupCommunicationAPI.saveGroupOffLinMsg(msg, GroupContacts.OffLineMsgType.KICK_OUT, "踢出群成员");
                return;
            }
            // 群聊天-群成员主动退群
            if (GroupContacts.MsgType.GROUP_MEMBER_EXIT.equals(msgType)){
                if (GroupContacts.GROU_OWNER_RETREAT.equals(head.getStatusReport())){
                    messageGroupCommunicationAPI.saveGroupOffLinMsg(msg, GroupContacts.OffLineMsgType.GROUP_DISSOLVE, "群主退群-群解散");
                }else {
                    messageGroupCommunicationAPI.saveGroupOffLinMsg(msg, GroupContacts.OffLineMsgType.EXIT_GROUP, "群成员主动退群");
                }
                return;
            }
            // 群主退群（解散群）
            if (GroupContacts.MsgType.GROUP_OWNER_EXIT.equals(msgType)){
                messageGroupCommunicationAPI.groupOwnerExit(msg);
                return;
            }
            // 群聊天消息撤回/删除
            if (GroupContacts.MsgType.DEL_GROUP_MSG.equals(msgType)){
                BusinessProtocolMessages.DelGroupOffMessageProtocol delGroupOffMessageProtocol = unifiedEntranceMessage.getDelGroupOffMessageProtocol();
                String msgIds = delGroupOffMessageProtocol.getMsgIds();
                String groupId = delGroupOffMessageProtocol.getGroupId();
                if (StringUtil.isNullOrEmpty(msgIds) || StringUtil.isNullOrEmpty(groupId)){
                    ctx.channel().writeAndFlush(ResponseUtil.responseDelGroupMsgResult(msg, ResponseStatus.STATUS_REPORT_FAILURE, "群组ID或撤回消息ID不能为空"));
                    return ;
                }
                AllGroupsMemberResponse allGroupsMemberResponse = messageGroupCommunicationAPI.queryGroupMembers(groupId);
                if (allGroupsMemberResponse == null) {
                    ctx.channel().writeAndFlush(ResponseUtil.responseDelGroupMsgResult(msg, ResponseStatus.STATUS_REPORT_FAILURE, "资料服务无响应"));
                    return ;
                }
                List<AllGroupMemberVO> responseGroupMemberVoList = allGroupsMemberResponse.getResponseGroupMemberVoList();
                if (responseGroupMemberVoList == null || responseGroupMemberVoList.isEmpty()){
                    ctx.channel().writeAndFlush(ResponseUtil.responseSuccessfulMsg(msg));
                    return ;
                }
                GroupMsgOffLineRequest delGroupMsgRequest = GroupMsgOffLineRequest.newBuilder().setMsgId(msgIds).setGroupId(groupId).build();
                ResponseResult responseResult = messageGroupCommunicationAPI.deleteGroupMsg(delGroupMsgRequest);
                if (responseResult  == null){
                    ctx.channel().writeAndFlush(ResponseUtil.responseDelGroupMsgResult(msg, ResponseStatus.STATUS_REPORT_FAILURE, "群消息服务异常"));
                    return ;
                }
                if (!responseResult.getSuccess()){
                    ctx.channel().writeAndFlush(ResponseUtil.responseDelGroupMsgResult(msg, ResponseStatus.STATUS_REPORT_FAILURE, responseResult.getMsg()));
                    return ;
                }
                ctx.channel().writeAndFlush(ResponseUtil.responseDelGroupMsgResult(msg, ResponseStatus.STATUS_REPORT_SUCCESS, "操作成功"));
                List<String> list = Arrays.asList(delGroupOffMessageProtocol.getMsgIds().split(","));
                List<Integer> ids = new ArrayList<>();
                list.forEach(msgId -> {
                    GroupMsgOffLineRequest rpcMsgGroupOff = GroupMsgOffLineRequest.newBuilder()
                            .setMsgType(GroupContacts.OffLineMsgType.DEL_GROUP_MSG)
                            .setFromId(head.getFromId())
                            .setGroupId(delGroupOffMessageProtocol.getGroupId())
                            .setToId(head.getToId())
                            .setFromMemberId(delGroupOffMessageProtocol.getMemberIds())
                            .setGroupName(delGroupOffMessageProtocol.getChatTypes())
                            .setMsgId(msgId)
                            .build();
                    ResponseResult saveGroupMassage = messageGroupCommunicationAPI.saveGroupMassage(rpcMsgGroupOff);
                    Any data = saveGroupMassage.getData();
                    if (data == null || data.getSerializedSize() == 0) {
                        log.info("用户【" + head.getFromId() + "】撤回群聊消息保存失败:" + CommonUtils.toJson(saveGroupMassage));
                        return;
                    }
                    try {
                        GroupMsg unpack = data.unpack(GroupMsg.class);
                        log.info("用户【" + head.getFromId() + "】撤回群聊消息保存结果:" + CommonUtils.toJson(unpack));
                        int msgId1 = unpack.getMsgId();
                        ids.add(msgId1);
                    } catch (InvalidProtocolBufferException e) {
                        e.printStackTrace();
                    }
                });
                log.info("撤回群聊消息离线数据ID:" + ids);
                String join = Joiner.on(",").join(ids);
                responseGroupMemberVoList.forEach(member ->{
                    int userId = member.getGuestUserId();
                    if (userId == 0){
                        userId = member.getRegisteredUserId();
                    }
                    if (head.getFromId().equals(userId + "")){ return;}

                    BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage entranceMessage = ResponseUtil.resultOnLineDelGroupMsg(msg, userId + "", join, GroupContacts.MsgType.RES_ONLINE_USER_DEL_GROUP_MSG);

                    log.info("对群【"+member.getRegisteredGroupId()+"】成员【"+userId+"】发送撤回消息：" + entranceMessage);
                    ctx.writeAndFlush(entranceMessage);
                });
                return;
            }

            // 离线群用户聊天消息撤回/删除消息存储
            if (GroupContacts.MsgType.DEL_GROUP_MSG_STORAGE.equals(msgType)){
                messageGroupCommunicationAPI.saveDelGroupOffLinMsg(msg);
                return;
            }

            // 离线群用户聊天消息撤回/删除消息存储
            if (GroupContacts.MsgType.DEL_GROUP_OFF_LINE_MSG_STORAGE.equals(msgType)){
                messageGroupCommunicationAPI.deleteGroupMsg(msg);
                return;
            }

            //删除在线用户ack后音视频通话消息记录
            if (ResponseStatus.GROUP_CALL_ACK.equals(head.getToken())){
                log.info("音视频通话消息ack："+head.toString());
                messageGroupCommunicationAPI.removeAudioVideoCallIndex(msg);
                return;
            }


            //音视频通话消息保存
            if (GroupContacts.MsgType.AUDIO_AND_VIDEO_CALL.equals(msgType)){
                //当type为close时房间关闭
                if (msg.getUnifiedEntranceMessage().getAudioAndVideoCallProtocol().getType().equals(ResponseStatus.CLOSE)){
                    String groupId = msg.getUnifiedEntranceMessage().getAudioAndVideoCallProtocol().getToGroup().getGroupId();
                    log.info("群【"+groupId+"】通话房间关闭请求");
                    messageGroupCommunicationAPI.closeRoomByGroupId(groupId);
                    return;
                }
                if (msg.getUnifiedEntranceMessage().getAudioAndVideoCallProtocol().getType().equals(ResponseStatus.CONNECTING)){
                    //对接听类型消息直接转发给所有在线群成员,不需要消息id,(-1标识)
                    this.groupChatMsgHandler(ctx, -1, msg);

                }

                Integer msgKey = this.messageGroupCommunicationAPI.storageGroupAudioVideoCallMessage(msg);
                log.info("存储音视频通话消息后返回主键ID：" + msgKey);

                if (msgKey == null){
                    log.info("用户【"+ head.getFromId() +"】发送的群音视频通话数据保存失败");
                    ctx.channel().writeAndFlush(ResponseUtil.responseFailMsg(msg));
                }else if (msg.getUnifiedEntranceMessage().getAudioAndVideoCallProtocol().getType().equals(ResponseStatus.INVITE)){
                    //邀请新人加入视频通话，直接转发给对方
                    this.groupAudioVideoCallMsgHandler(ctx, msgKey, msg);
                }else {
                    this.groupChatMsgHandler(ctx, msgKey, msg);
                }
                return;
            }

            //将群音视频通话消息保存到离线用户名下，
            if (GroupContacts.MsgType.GROUP_AUDIO_VIDEO_SAVE.equals(msgType)){
                log.info("保存群音视频通话消息到离线成员名下，"+msg.getUnifiedEntranceMessage().getAudioAndVideoCallProtocol().toString());
                if (msg.getUnifiedEntranceMessage().getAudioAndVideoCallProtocol().getType().equals(ResponseStatus.CONNECTING) ||
                        msg.getUnifiedEntranceMessage().getAudioAndVideoCallProtocol().getType().equals(ResponseStatus.JOIN)   ||
                        msg.getUnifiedEntranceMessage().getAudioAndVideoCallProtocol().getType().equals(ResponseStatus.LEAVE)  ||
                        msg.getUnifiedEntranceMessage().getAudioAndVideoCallProtocol().getType().equals(ResponseStatus.UNANSWERED)   ){
                    return;
                }
                messageGroupCommunicationAPI.saveAuvioVideoCallMsgToOffUser(msg);
                return;
            }


            //用户上线时推送音视频通话消息
            if(GroupContacts.OnlineState.ONLINE.equals(msgType)){
                List<GroupAudioVideoMessage> avcMsgList = this.messageGroupCommunicationAPI.pushGroupAudioVideoCallMsg(msg);
                List<BusinessProtocolEntities.CallUser> callUsers = new ArrayList<>();
                LoginStorageGrpcApi loginStorageGrpcApi = new LoginStorageGrpcApi();
                if (avcMsgList== null){
                    return;
                }
                if (avcMsgList.size()>0){
                    for (GroupAudioVideoMessage gaa : avcMsgList){
                        //补充协议里视频参与者个人信息
                        List<String> joinUsers = Arrays.asList(gaa.getCallMemberIds().split(","));
                        if (joinUsers.size()>0){
                            for (String id : joinUsers){
                                RegisterStorageProto.RequestUser requestUser = RegisterStorageProto.RequestUser.newBuilder().setArgs(ResponseStatus.SEARCH_USER).setRegisterUser(RegisterStorageProto.RegisterUser.newBuilder().setUserId(id).build()).build();
                                RegisterStorageProto.RegisterUser registerUser = loginStorageGrpcApi.selectUserInformation(requestUser).getRegisterUser(0);
                                BusinessProtocolEntities.CallUser calluser = BusinessProtocolEntities.CallUser.newBuilder()
                                        .setUserId(id)
                                        .setUserName(registerUser.getUserInfomation().getNickname())
                                        .setUserAvatar(registerUser.getUserInfomation().getAvatar()).build();
                                callUsers.add(calluser);
                            }
                        }
                        BusinessProtocolMessageStandard.UnifiedEntranceMessage gmessage =BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                                .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.AudioAndVideoCallProtocol)
                                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                        .setMsgContentType(Integer.parseInt(gaa.getOther()))  //msgId
                                        .setToken(ResponseStatus.GROUP_CALL_ACK)
                                        .setTimestamp(Long.parseLong(gaa.getDetail())*1000) //消息时间戳
                                        .setFromId(gaa.getFromUserId()) //消息的发送者
                                        .setToId(head.getFromId())    //上线的接收者
                                        .setMsgType(GroupContacts.MsgType.AUDIO_AND_VIDEO_CALL)
                                        .setStatusReport(ResponseStatus.STATUS_REPORT_RECEIPT_OFFLINE)
                                        .setUniqueIdentify(ResponseStatus.AVC_PUSH)
                                        .build())
                                .setAudioAndVideoCallProtocol(BusinessProtocolMessages.AudioAndVideoCallProtocol.newBuilder()
                                        .setServer("")
                                        .setRoom(BusinessProtocolEntities.Room.newBuilder()
                                                .setRoomId(gaa.getRoomId())
                                                .setRoomPwd("")
                                                .setOnlyAudio(gaa.getOnlyAudio()).build())
                                        .setFromUser(BusinessProtocolEntities.CallUser.newBuilder()
                                                .setUserId(gaa.getFromUserId())
                                                .setUserName(gaa.getFromUserName())
                                                .setUserAvatar(gaa.getUserAvatar()).build())
                                        .setToGroup(BusinessProtocolEntities.CallGroup.newBuilder()
                                                .setGroupId(gaa.getGroupId())
                                                .addAllCallMembers(callUsers)  //t参与者个人信息补充
                                                .setCallMemberIds(gaa.getCallMemberIds())
                                                .build())
                                        .setType(gaa.getType())
                                        .setToType(1)
                                        .setStatusDetail(gaa.getDetail())
                                        .build()).build();
                        log.info("》》》》推送音视频通话消息："+gmessage);
                        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage entMessage =JCRC32.packageCheckSum(gmessage);//todo 协议加密
                        ctx.writeAndFlush(entMessage);
                    }
                }

               return;
            }





        }catch (Exception e){
            log.info("群服务异常：" + e);
            e.printStackTrace();
            ctx.writeAndFlush(ResponseUtil.responseExceptionResult(msg));
        }
    }

    private void groupAudioVideoCallMsgHandler(ChannelHandlerContext ctx, Integer msgKey, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        String callMemberIds = unifiedEntranceMessage.getAudioAndVideoCallProtocol().getToGroup().getCallMemberIds();
        String groupId = unifiedEntranceMessage.getAudioAndVideoCallProtocol().getToGroup().getGroupId();
        try {
            log.info("群【"+groupId+"】音视频通话-参与成员：【" + callMemberIds + "】");
             List<String> joinUsers = Arrays.asList(callMemberIds.split(","));

            joinUsers.forEach(memberId ->{
                if (StringUtils.isEmpty(memberId)){
                    return;
                }
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage entranceMessage = ResponseUtil.responseGroupChartResult(msg, memberId, msgKey);
                log.info("对群【"+groupId+"】成员【"+memberId+"】发送群音视频通话消息：" + entranceMessage);
                ctx.writeAndFlush(entranceMessage);
            });
        }catch (Exception e){
            e.printStackTrace();
            log.info("群音视频通话消息处理异常：" + e);
        }

    }

    private void printLog(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = checkUnifiedEntranceMessage.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String msgType = head.getMsgType();
        switch (msgType){
        case GroupContacts.MsgType.DELETE_GROUP_CHART_OFF_LINE_MSG:
            List<BusinessProtocolEntities.GroupOfflineMessage> groupOfflineMessageList = unifiedEntranceMessage.getOfflineGroupMessageProtocol().getGroupOfflineMessageList();
            if (groupOfflineMessageList == null || groupOfflineMessageList.isEmpty()) {
                log.info("群服务接收用户【"+ head.getFromId() +"】发送的【"+ msgType +"】数据：" + checkUnifiedEntranceMessage);
            }else {
                List<BusinessProtocolEntities.ChatMessage> collect = groupOfflineMessageList.stream().map(BusinessProtocolEntities.GroupOfflineMessage::getChatMessage).collect(Collectors.toList());
                Map<String, Integer> map = new HashMap<>();
                collect.forEach(v -> map.put(StringUtil.isNullOrEmpty(v.getMsgId()) ? CommonUtils.uuid() : v.getMsgId(), v.getChatType()));
                log.info("群服务接收用户【"+ head.getFromId() +"】发送的【"+ msgType +"】数据：" + map);
            }
            break;
        case GroupContacts.MsgType.GROUP_CHAT_MESSAGE_STORAGE:
            int chatType = unifiedEntranceMessage.getGroupChatProtocol().getChatMessage().getChatType();
            if (CommonKeys.TEST.contains(chatType)) {
                log.info("群服务接收用户【"+ head.getFromId() +"】发送的【"+ msgType +"】数据：" + head);
            }else {
                log.info("群服务接收用户【"+ head.getFromId() +"】发送的【"+ msgType +"】数据：" + checkUnifiedEntranceMessage);
            }
            break;
        case GroupContacts.MsgType.GROUP_CHAT_REGISTERED:
            int type = unifiedEntranceMessage.getGroupChatProtocol().getChatMessage().getChatType();
            if (CommonKeys.TEST.contains(type)) {
                log.info("群服务接收用户【"+ head.getFromId() +"】发送的【"+ msgType +"】数据：" + head);
            }else {
                log.info("群服务接收用户【"+ head.getFromId() +"】发送的【"+ msgType +"】数据：" + checkUnifiedEntranceMessage);
            }
            break;
        default:
            log.info("群服务接收用户【"+ head.getFromId() +"】发送的【"+ msgType +"】数据：" + checkUnifiedEntranceMessage);
            break;
        }
    }

    private void groupChatMsgHandler(ChannelHandlerContext ctx, Integer msgId, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        try {
            log.info("群聊天-获取群：【" + head.getToId() + "】成员开始");
            // 群聊天-获取群成员
            List<AllGroupMemberVO> groupMemberVOS = messageGroupCommunicationAPI.queryGroupMembers(msg);
            if (groupMemberVOS == null || groupMemberVOS.isEmpty()) {
                log.info("群：【" + head.getToId() + "】无成员用户");
                return;
            }
            log.info("群：【" + head.getToId() + "】成员用户：" + groupMemberVOS.stream().map(AllGroupMemberVO :: getRegisteredUserId).collect(Collectors.toList()));
            groupMemberVOS.forEach(member ->{
                int userId = member.getGuestUserId();
                if (userId == 0){
                    userId = member.getRegisteredUserId();
                }
                if (head.getFromId().equals(userId + "")){ return;}
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage entranceMessage = ResponseUtil.responseGroupChartResult(msg, userId + "", msgId);
                log.info("对群【"+member.getRegisteredGroupId()+"】成员【"+userId+"】发送聊天消息：" + entranceMessage);
                ctx.writeAndFlush(entranceMessage);
            });
        }catch (Exception e){
            e.printStackTrace();
            log.info("群聊天消息处理异常：" + e);
        }
    }

    /**
     * 华为推送(透传消息)
     * @throws HuaweiMesssagingException
     */
    public void sendTransparent(String token,String content) throws HuaweiMesssagingException {
        HuaweiApp app = InitAppUtils.initializeApp();
        HuaweiMessaging huaweiMessaging = HuaweiMessaging.getInstance(app);

        AndroidConfig androidConfig = AndroidConfig.builder().setCollapseKey(-1)
                .setUrgency(Urgency.HIGH.getValue())
                .setTtl("10000s")
                .setBiTag("the_sample_bi_tag_for_receipt_service")
                .build();

//        String token = "0869158029739873300010793000CN01";

        Message message = Message.builder()
                .setData(content)
                .setAndroidConfig(androidConfig)
                .addToken(token)
                .build();

            SendResponse response = huaweiMessaging.sendMessage(message);

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
