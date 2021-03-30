package com.lanjiu.im.communication.service;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.lanjiu.im.communication.server.MessageGroupServerHandler;
import com.lanjiu.im.communication.util.*;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.client.login_client.LoginStorageGrpcApi;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.im.storage.client.service.off.MessageStorageAPI;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import com.lanjiu.pro.groupStorage.*;
import com.lanjiu.pro.login.RegisterStorageProto;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static com.lanjiu.im.communication.util.CommonUtils.msgContentHandel;

public class MessageGroupCommunicationAPI {

    private final Logger log = Logger.getLogger(MessageGroupServerHandler.class);

    private StorageAPI storageAPI = new StorageAPI();

    private MessageStorageAPI messageStorageAPI = new MessageStorageAPI();

    /**
     * 群聊天-获取群成员
     * @param msg 消息
     */
    public List<AllGroupMemberVO> queryGroupMembers(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg){
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        String groupId = unifiedEntranceMessage.getHead().getToId();
        SelectGroupMemberRequest request = SelectGroupMemberRequest.newBuilder().setGroupId(groupId).build();
        log.info("获取群成员入参：" + request);
        AllGroupsMemberResponse allGroupsMemberResponse = storageAPI.selectGroupMembers(request);
        log.info("获取群成员响应：" + allGroupsMemberResponse);
        return allGroupsMemberResponse.getResponseGroupMemberVoList();
    }

    public AllGroupsMemberResponse queryGroupMembers(String groupId){
        SelectGroupMemberRequest request = SelectGroupMemberRequest.newBuilder().setGroupId(groupId).build();
        return storageAPI.selectGroupMembers(request);
    }

    /**
     * 群聊天-拉取群离线消息
     * @param msg 消息
     */
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectOffLineGroupMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) throws Exception {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessages.OfflineGroupMessageProtocol protocol = unifiedEntranceMessage.getOfflineGroupMessageProtocol();
        String userId = protocol.getUserId();
        int page = protocol.getPage();
        if (page == 0) {
            return ResponseUtil.resultOfflineGroupMessage(msg, ResponseStatus.STATUS_REPORT_FAILURE, "数据错误");
        }
        SelectOffLineGroupMsgRequest request = SelectOffLineGroupMsgRequest.newBuilder().setUserId(userId).setPage(page).setPageSize(CommonKeys.PAGE_SIZE).build();
        log.info("===================查询群离线总数开始");
        ResponseCount responseCount = messageStorageAPI.selectOffLineGroupMsgCount(request);
        log.info("===================查询群离线总数结束");
        int count = responseCount.getCount();
        log.info("用户【"+userId+"】拉取群离线消息总数：" + count);
        if (count == 0) {
            log.info("用户【"+userId+"】拉取群离线消息无数据！");
            return ResponseUtil.resultOfflineGroupMessage(msg, ResponseStatus.STATUS_REPORT_SUCCESS, "查询无数据");
        }
        log.info("===================查询群离线数据开始");
        ResponseResult responseResult = messageStorageAPI.selectOffLineGroupMsg(request);
        log.info("===================查询群离线数据结束");
        if (responseResult == null){
            log.info("用户【"+userId+"】拉取群离线消息，群存储服务异常！");
            return ResponseUtil.resultOfflineGroupMessage(msg, ResponseStatus.STATUS_REPORT_EXCEPTION, "服务异常");
        }
        if (!responseResult.getSuccess()){
            return ResponseUtil.resultOfflineGroupMessage(msg, ResponseStatus.STATUS_REPORT_FAILURE, responseResult.getMsg());
        }
        Any data = responseResult.getData();
        if (data.getSerializedSize() == 0){
            return ResponseUtil.resultOfflineGroupMessage(msg, ResponseStatus.STATUS_REPORT_SUCCESS, "查询无数据");
        }
        GroupMsgList unpack = data.unpack(GroupMsgList.class);
        List<BusinessProtocolEntities.GroupOfflineMessage> groupMsgList = unpack.getGroupMsgList();
        return ResponseUtil.resultSuccessfulOfflineGroupMessage(msg, ResponseStatus.STATUS_REPORT_SUCCESS, "执行成功", page * CommonKeys.PAGE_SIZE < count, groupMsgList);
    }

    public void deleteSendOffLineMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage message) {
        DeleteGroupMembersMsgRequest request = DeleteGroupMembersMsgRequest.newBuilder()
                .setUserId(message.getUnifiedEntranceMessage().getHead().getFromId())
                .build();
        messageStorageAPI.deleteSendOffLineMsg(request);
    }

    public Integer saveGroupMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        GroupMsgOffLineRequest groupMsgOffLine = CommonUtils.getGroupMsgOffLineRequest(msg);
        log.info("保存消息数据：" + groupMsgOffLine);
        ResponseResult responseResult = messageStorageAPI.saveGroupMassage(groupMsgOffLine);
        if (responseResult == null || !responseResult.getSuccess() || responseResult.getData() == null){
            return null;
        }
        try {
            GroupMsg groupMsg = responseResult.getData().unpack(GroupMsg.class);
            return groupMsg.getMsgId();
        } catch (InvalidProtocolBufferException e) {
            log.info("保存消息数据异常：" + e);
            e.printStackTrace();
        }
        return null;
    }

    public void saveDelGroupOffLinMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        BusinessProtocolMessages.DelGroupOffMessageProtocol delGroupOffMessageProtocol = unifiedEntranceMessage.getDelGroupOffMessageProtocol();
        List<String> list = Arrays.asList(head.getToken().split(","));
        list.forEach(id -> {
            if (StringUtil.isNullOrEmpty(id)) return;
            GroupMsgOffLineRequest rpcMsgGroupOff = GroupMsgOffLineRequest.newBuilder()
                    .setMsgType(GroupContacts.OffLineMsgType.DEL_GROUP_MSG)
                    .setFromId(head.getFromId())
                    .setGroupId(delGroupOffMessageProtocol.getGroupId())
                    .setToId(head.getToId())
                    .setId(Integer.valueOf(id))
                    .setFromMemberId(delGroupOffMessageProtocol.getMemberIds())
                    .setGroupName(delGroupOffMessageProtocol.getChatTypes())
                    .build();
            ResponseResult responseResult = messageStorageAPI.saveGroupMembersOffLineMsg(rpcMsgGroupOff);
            log.info("用户【"+head.getFromId()+"】撤回群聊消息离线保存结果:" + CommonUtils.toJson(responseResult));
        });
    }

    public void saveGroupMembersOffLinMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        GroupMsgOffLineRequest groupMsgOffLine = CommonUtils.getGroupMsgOffLineRequest(msg);
        ResponseResult responseResult = messageStorageAPI.saveGroupMembersOffLineMsg(groupMsgOffLine);
        BusinessProtocolMessageStandard.Head head = msg.getUnifiedEntranceMessage().getHead();
        log.info("存储用户【"+ head.getToId() +"】未接收消息结果:" + CommonUtils.toJson(responseResult));
    }

    // 创建群-离线用户接收的群信息
    public void saveCreateGroupOffLinMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) throws InvalidProtocolBufferException {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        BusinessProtocolMessages.GroupCreateProtocol groupCreateProtocol = unifiedEntranceMessage.getGroupCreateProtocol();
        List<BusinessProtocolEntities.AllGroupMemberVO> vos = groupCreateProtocol.getAllGroupMemberVoList();
        BusinessProtocolEntities.RegisteredGroup registeredGroup = groupCreateProtocol.getRegisteredGroup();
        GroupMsgOffLineRequest rpcMsgGroupOff = GroupMsgOffLineRequest.newBuilder()
                .setMsgType(GroupContacts.OffLineMsgType.CREATE)
                .setContent(groupCreateProtocol.getStatusDetail())
                .setFromId(head.getFromId())
                .setToId(head.getToId())
                .setGroupId(registeredGroup.getGroupId())
                .setGroupName(registeredGroup.getGroupName())
                .setGroupOwnerUrl(registeredGroup.getGroupAvatar())
                .build();
        ResponseResult responseResult = messageStorageAPI.saveGroupMassage(rpcMsgGroupOff);
        log.info("用户【"+head.getFromId()+"】创建群离线消息保存结果:" + CommonUtils.toJson(responseResult));
        Any data = responseResult.getData();
        if (data == null || data.getSerializedSize() == 0){
            return;
        }
        GroupMsg unpack = data.unpack(GroupMsg.class);
        GroupMsgOffLineRequest rpcMsgGroupOffLine = GroupMsgOffLineRequest.newBuilder(rpcMsgGroupOff)
                .setId(unpack.getMsgId())
                .build();
        ResponseResult responseResult2 = messageStorageAPI.saveGroupMembersOffLineMsg(rpcMsgGroupOffLine);
    }

    // 邀请入群离线消息
    public void saveInviteAddGroupOffLinMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) throws InvalidProtocolBufferException {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        BusinessProtocolMessages.GroupMemberAddProtocol groupMemberAddProtocol = unifiedEntranceMessage.getGroupMemberAddProtocol();
        List<BusinessProtocolEntities.AllGroupMemberVO> vos = groupMemberAddProtocol.getAllGroupMemberVoList();
        int groupId = groupMemberAddProtocol.getAllGroupMemberVo(0).getRegisteredGroupId();
        GroupMsgOffLineRequest rpcMsgGroupOff = GroupMsgOffLineRequest.newBuilder()
                .setMsgType(GroupContacts.OffLineMsgType.INVITE_IN)
                .setContent(vos.toString())
                .setFromId(head.getFromId())
                .setGroupId(groupId + "")
                .setToId(head.getToId())
                .build();
        ResponseResult responseResult = messageStorageAPI.saveGroupMassage(rpcMsgGroupOff);
        log.info("邀请用户【"+head.getToId()+"】入群离线消息保存结果:" + responseResult);
        Any data = responseResult.getData();
        if (data == null || data.getSerializedSize() == 0){
            return;
        }
        GroupMsg unpack = data.unpack(GroupMsg.class);
        GroupMsgOffLineRequest rpcMsgGroupOffLine = GroupMsgOffLineRequest.newBuilder(rpcMsgGroupOff)
                .setId(unpack.getMsgId())
                .build();
        ResponseResult responseResult2 = messageStorageAPI.saveGroupMembersOffLineMsg(rpcMsgGroupOffLine);
    }

    public void saveGroupOffLinMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg, int msgType, String message) throws InvalidProtocolBufferException {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        BusinessProtocolMessages.GroupChatProtocol groupChatProtocol = unifiedEntranceMessage.getGroupChatProtocol();
        BusinessProtocolEntities.RegisteredGroupMember registeredGroupMember = groupChatProtocol.getRegisteredGroupMember();
        BusinessProtocolEntities.RegisteredGroup group = registeredGroupMember.getGroup();
        GroupMsgOffLineRequest rpcMsgGroupOff = GroupMsgOffLineRequest.newBuilder()
                .setMsgType(msgType)
                .setContent(msgContentHandel(groupChatProtocol.getChatMessage()))
                .setFromId(head.getFromId())
                .setToId(head.getToId())
                .setGroupId(group.getGroupId())
                .setGroupName(group.getGroupName())
                .setGroupOwner(registeredGroupMember.getGroupMemberNick())
                .setGroupOwnerNick(registeredGroupMember.getGroupMemberAlias())
                .setGroupOwnerUrl(registeredGroupMember.getUserType())
                .setFromMemberId(registeredGroupMember.getGroupMemberUserId())
                .setFromMemberName(registeredGroupMember.getGroupMemberName())
                .setFromMemberAvatar(registeredGroupMember.getGroupMemberAvatar())
                .setMsgId(groupChatProtocol.getChatMessage().getMsgId())
                .build();
        ResponseResult responseResult = messageStorageAPI.saveGroupMassage(rpcMsgGroupOff);
        log.info("用户【"+head.getToId()+"】保存【"+ msgType +"】("+ message +")离线主体消息:" + responseResult);
        Any data = responseResult.getData();
        if (data == null || data.getSerializedSize() == 0){
            return;
        }
        GroupMsg unpack = data.unpack(GroupMsg.class);
        GroupMsgOffLineRequest rpcMsgGroupOffLine = GroupMsgOffLineRequest.newBuilder(rpcMsgGroupOff)
                .setId(unpack.getMsgId())
                .build();
        ResponseResult responseResult2 = messageStorageAPI.saveGroupMembersOffLineMsg(rpcMsgGroupOffLine);
    }

    public void deleteGroupMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String msgId = head.getUniqueIdentify();
        GroupMsgOffLineRequest delGroupMsgRequest = GroupMsgOffLineRequest.newBuilder().setMsgId(msgId).build();
        ResponseResult responseResult = messageStorageAPI.deleteGroupMsg(delGroupMsgRequest);
        log.info("删除指定离线消息ID："+ msgId +"结果：" + responseResult);
    }

    public ResponseResult deleteGroupMsg(GroupMsgOffLineRequest delGroupMsgRequest) {
        return messageStorageAPI.deleteGroupMsg(delGroupMsgRequest);
    }

    public ResponseResult saveGroupMassage(GroupMsgOffLineRequest rpcMsgGroupOff) {
        return messageStorageAPI.saveGroupMassage(rpcMsgGroupOff);
    }

    public void groupOwnerExit(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String groupId = unifiedEntranceMessage.getGroupChatProtocol().getRegisteredGroupMember().getGroup().getGroupId();
        if (StringUtil.isNullOrEmpty(groupId)) {
            log.info("群主退群数据错误，群ID为空");
            return;
        }
        DeleteGroupMembersMsgRequest request = DeleteGroupMembersMsgRequest.newBuilder().addGroupId(groupId + "").setUserId(head.getFromId()).build();
        messageStorageAPI.groupOwnerExit(request);
        log.info("用户【"+head.getToId()+"】退群【"+ groupId +"】(群主解散群)删除离线消息");
    }

    //保存消息内容
    public  Integer storageGroupAudioVideoCallMessage(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg){
        GroupAudioVideoCallRequest storageReq = CommonUtils.createGroupAudioVideoCallReq(msg);
        log.info("保存消息数据：" + storageReq);
        GroupAudioVideoCallResponse response = messageStorageAPI.groupAudioAndVideoCall(storageReq);
        if (response == null || StringUtils.isEmpty(response.getResult())){
            return null;
        }

        try {
            Integer res = Integer.parseInt(response.getResult());
            return res;
        } catch (NumberFormatException e) {
            log.info("格式转换异常：" + e);
        }

        return null;
    }

    //群音视频消息推送至上线用户
    public List<GroupAudioVideoMessage> pushGroupAudioVideoCallMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        GroupAudioVideoCallRequest  pushReq = CommonUtils.pushGroupAudioVideoCallReq(msg);
        GroupAudioVideoCallResponse response = messageStorageAPI.groupAudioAndVideoCall(pushReq);
        if (response == null || StringUtils.isEmpty(response.getResult())){
            return null;
        }

        return    response.getGroupAudioVideoMessageList();

    }

    //保存音视频通话消息到对应离线群成员下
    public void saveAuvioVideoCallMsgToOffUser(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        GroupAudioVideoCallRequest  storageReq = CommonUtils.saveCallMsgToOffUserReq(msg);
        GroupAudioVideoCallResponse response = messageStorageAPI.groupAudioAndVideoCall(storageReq);
    }

    public void removeAudioVideoCallIndex(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        BusinessProtocolMessageStandard.Head head = msg.getUnifiedEntranceMessage().getHead();
        String msgId = String.valueOf(head.getMsgContentType());
        if (StringUtils.isEmpty(msgId)){
            log.error(">>>>>>>>>>>>>>>ack消息id不能为空，"+head.toString());
            return;
        }
        GroupAudioVideoCallRequest request = GroupAudioVideoCallRequest.newBuilder()
                .setArgs(ResponseStatus.AVC_DEL)
                .setGroupAudioVideoMessage(GroupAudioVideoMessage.newBuilder()
                        .setFromUserId(head.getToId()) //客户端接受推送后head头原样ack返回，故userId从toId获取。
                        .setDetail(msgId).build()).build();
        GroupAudioVideoCallResponse response = messageStorageAPI.groupAudioAndVideoCall(request);
        return;
    }

    public void closeRoomByGroupId(String groupId) {
        GroupAudioVideoCallRequest request =GroupAudioVideoCallRequest.newBuilder().setArgs(ResponseStatus.CLOSE).setGroupAudioVideoMessage(GroupAudioVideoMessage.newBuilder().setGroupId(groupId).build()).build();
        messageStorageAPI.groupAudioAndVideoCall(request);
    }



}
