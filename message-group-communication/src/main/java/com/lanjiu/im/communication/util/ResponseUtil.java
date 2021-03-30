package com.lanjiu.im.communication.util;

import com.lanjiu.im.grpc.client.login_client.LoginStorageGrpcApi;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import com.lanjiu.pro.login.RegisterStorageProto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResponseUtil {

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage requestValidateFail(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage){
        BusinessProtocolMessageStandard.Head head = checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder(head).setStatusReport(ResponseStatus.RESPONSE_CHECK_FAILURE))
                .setDataType(checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getDataType()).build();
        return JCRC32.packageCheckSum(message);
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage responseSuccessfulMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        return responseResultMsg(checkUnifiedEntranceMessage, ResponseStatus.STATUS_REPORT_SUCCESS);
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage responseFailMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        return responseResultMsg(checkUnifiedEntranceMessage, ResponseStatus.STATUS_REPORT_FAILURE);
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage responseExceptionResult(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        return responseResultMsg(checkUnifiedEntranceMessage, ResponseStatus.STATUS_REPORT_EXCEPTION);
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage responseRefuseResult(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage) {
        return responseResultMsg(checkUnifiedEntranceMessage, ResponseStatus.STATUS_REPORT_REFUSE);
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage ResponseResult(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg, String msgType, String report) {
        BusinessProtocolMessageStandard.Head head = msg.getUnifiedEntranceMessage().getHead();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder(head).setStatusReport(report).setMsgType(msgType).build())
                .setDataType(msg.getUnifiedEntranceMessage().getDataType()).build();
        return JCRC32.packageCheckSum(message);
    }

    /**
     * 创建心跳包响应消息
     * */
    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage buildHeartBeat(){
        BusinessProtocolMessageStandard.Head header = BusinessProtocolMessageStandard.Head.newBuilder().setMsgType(GroupContacts.MsgType.HEART_PACKAGE).build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder().setHead(header).build();
        return BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.newBuilder().setUnifiedEntranceMessage(message).build();
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage responseResultMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg, String statusReport){
        BusinessProtocolMessageStandard.Head head = msg.getUnifiedEntranceMessage().getHead();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder(head).setStatusReport(statusReport).build())
                .setDataType(msg.getUnifiedEntranceMessage().getDataType())
                .build();
        return JCRC32.packageCheckSum(message);
    }
    //判断协议类型（群聊天消息、群音视频通话消息）
    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage responseGroupChartResult(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg, String userId, Integer msgId){
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage message =null;
        if (unifiedEntranceMessage.getDataType().equals( BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupChatProtocol)){
            BusinessProtocolMessages.GroupChatProtocol groupChatProtocol1 = unifiedEntranceMessage.getGroupChatProtocol();
             message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setGroupChatProtocol(groupChatProtocol1)
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder(head).setToId(userId).setToken(msgId + "").build())
                    .build();

        }
        if(unifiedEntranceMessage.getDataType().equals( BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.AudioAndVideoCallProtocol)){
            BusinessProtocolMessages.AudioAndVideoCallProtocol audioVideoRotocol1 = unifiedEntranceMessage.getAudioAndVideoCallProtocol();
            //转发前对参与者信息进行补充完善（头像，昵称）
            List<String> joinUsers = Arrays.asList(msg.getUnifiedEntranceMessage().getAudioAndVideoCallProtocol().getToGroup().getCallMemberIds().split(","));
            List<BusinessProtocolEntities.CallUser> callList =new ArrayList<>();
            LoginStorageGrpcApi loginApi = new LoginStorageGrpcApi();
            if (joinUsers.size()>0){
                for (String uid: joinUsers){
                    if (uid.equals(userId)){
                        continue;
                    }
                    RegisterStorageProto.RequestUser requestUser = RegisterStorageProto.RequestUser.newBuilder().setArgs(ResponseStatus.SEARCH_USER).setRegisterUser(RegisterStorageProto.RegisterUser.newBuilder().setUserId(uid).build()).build();
                    RegisterStorageProto.RegisterUser registerUser = loginApi.selectUserInformation(requestUser).getRegisterUser(0);
                    BusinessProtocolEntities.CallUser calluser = BusinessProtocolEntities.CallUser.newBuilder()
                            .setUserId(uid)
                            .setUserName(registerUser.getUserInfomation().getNickname())
                            .setUserAvatar(registerUser.getUserInfomation().getAvatar()).build();
                    callList.add(calluser);
                }
            }
            message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setAudioAndVideoCallProtocol(BusinessProtocolMessages.AudioAndVideoCallProtocol.newBuilder()
                            .setRoom(BusinessProtocolEntities.Room.newBuilder()
                                    .setRoomId(audioVideoRotocol1.getRoom().getRoomId())
                                    .setOnlyAudio(audioVideoRotocol1.getRoom().getOnlyAudio()).build())
                            .setType(audioVideoRotocol1.getType())
                            .setToType(audioVideoRotocol1.getToType())
                            .setFromUser(BusinessProtocolEntities.CallUser.newBuilder()
                                    .setUserId(audioVideoRotocol1.getFromUser().getUserId())
                                    .setUserName(audioVideoRotocol1.getFromUser().getUserName())
                                    .setUserAvatar(audioVideoRotocol1.getFromUser().getUserAvatar()).build())
                            .setToGroup(BusinessProtocolEntities.CallGroup.newBuilder()
                                    .setGroupId(audioVideoRotocol1.getToGroup().getGroupId())
                                    .setCallMemberIds(audioVideoRotocol1.getToGroup().getCallMemberIds())
                                    .addAllCallMembers(callList).build()).build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder().setMsgType(head.getMsgType())
                            .setTimestamp(head.getTimestamp())
                            .setFromId(head.getFromId())
                            .setToId(userId).setToken(msgId + "").build())
                    .build();

        }
        return JCRC32.packageCheckSum(message);
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage responseDelGroupMsgResult(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg, String statusReport, String resultMsg){
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        BusinessProtocolMessages.DelGroupOffMessageProtocol delGroupOffMessageProtocol = unifiedEntranceMessage.getDelGroupOffMessageProtocol();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setDataType(unifiedEntranceMessage.getDataType())
                .setDelGroupOffMessageProtocol(BusinessProtocolMessages.DelGroupOffMessageProtocol.newBuilder(delGroupOffMessageProtocol).setStatusDetail(resultMsg).build())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder(head).setStatusReport(statusReport).build())
                .build();
        return JCRC32.packageCheckSum(message);
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage resultOnLineDelGroupMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg, String toId, String ids, String msgType){
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        BusinessProtocolMessages.DelGroupOffMessageProtocol delGroupOffMessageProtocol = unifiedEntranceMessage.getDelGroupOffMessageProtocol();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setDataType(unifiedEntranceMessage.getDataType())
                .setDelGroupOffMessageProtocol(BusinessProtocolMessages.DelGroupOffMessageProtocol.newBuilder(delGroupOffMessageProtocol).build())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder(head).setMsgType(msgType).setToId(toId).setToken(ids).build())
                .build();
        return JCRC32.packageCheckSum(message);
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage resultOfflineGroupMessage(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg, String report, String resultMsg){
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        BusinessProtocolMessages.OfflineGroupMessageProtocol protocol = unifiedEntranceMessage.getOfflineGroupMessageProtocol();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage1 = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder(unifiedEntranceMessage)
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder(head).setStatusReport(report).build())
                .setDataType(unifiedEntranceMessage.getDataType())
                .setOfflineGroupMessageProtocol(BusinessProtocolMessages.OfflineGroupMessageProtocol.newBuilder(protocol).setStatusDetail(resultMsg).build())
                .build();
        return JCRC32.packageCheckSum(unifiedEntranceMessage1);
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage resultSuccessfulOfflineGroupMessage(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg,
                                                                                                                  String report, String resultMsg, boolean isEnd,
                                                                                                                  List<BusinessProtocolEntities.GroupOfflineMessage> list){
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        BusinessProtocolMessages.OfflineGroupMessageProtocol protocol = unifiedEntranceMessage.getOfflineGroupMessageProtocol();
        BusinessProtocolMessages.OfflineGroupMessageProtocol build = BusinessProtocolMessages.OfflineGroupMessageProtocol.newBuilder(protocol)
                .addAllGroupOfflineMessage(list)
                .setRequest(isEnd)
                .setStatusDetail(resultMsg)
                .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder(head).setStatusReport(report).build())
                .setDataType(unifiedEntranceMessage.getDataType())
                .setOfflineGroupMessageProtocol(build)
                .build();
        return JCRC32.packageCheckSum(message);
    }

    public static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage transtionHuaweiPush(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg,Map<String,String> map){
        BusinessProtocolMessageStandard.Head head = msg.getUnifiedEntranceMessage().getHead();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder(head)
                        .setFromId(head.getFromId()).setToId(head.getToId())
                        .setMsgType(GroupContacts.MsgType.GROUP_CHAT_REGISTERED)
                        .setStatusReport("huawei-push").build())
                .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupChatProtocol)
                .setGroupChatProtocol(BusinessProtocolMessages.GroupChatProtocol.newBuilder()
                        .setAt(map.get("pushToken"))
                        .setStatusDetail(map.toString())
                        .setRegisteredGroupMember(BusinessProtocolEntities.RegisteredGroupMember.newBuilder()
                                .setGroup(BusinessProtocolEntities.RegisteredGroup.newBuilder()
                                        .setGroupId(msg.getUnifiedEntranceMessage().getGroupChatProtocol().getRegisteredGroupMember().getGroup().getGroupId())
                                        .build())
                                .build())
                        .build())
                .build();
        return JCRC32.packageCheckSum(message);
    }
}
