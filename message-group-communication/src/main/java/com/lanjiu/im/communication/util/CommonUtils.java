package com.lanjiu.im.communication.util;

import com.google.gson.Gson;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import com.lanjiu.pro.groupStorage.GroupAudioVideoCallRequest;
import com.lanjiu.pro.groupStorage.GroupAudioVideoMessage;
import com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest;
import com.mysql.cj.util.StringUtils;
import org.apache.log4j.Logger;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CommonUtils {

    private static Logger log = Logger.getLogger(CommonUtils.class);

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static Charset ISO_CHARSET = Charset.forName("ISO-8859-1");

    public static GroupMsgOffLineRequest getGroupMsgOffLineRequest(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg){
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        BusinessProtocolMessages.GroupChatProtocol groupChatProtocol = unifiedEntranceMessage.getGroupChatProtocol();
        BusinessProtocolEntities.ChatMessage chatMessage = groupChatProtocol.getChatMessage();
        BusinessProtocolEntities.RegisteredGroupMember registeredGroupMember = groupChatProtocol.getRegisteredGroupMember();
        BusinessProtocolEntities.RegisteredGroup group = groupChatProtocol.getRegisteredGroupMember().getGroup();
        String at = groupChatProtocol.getAt();
        int isAt = 0;
        if (!StringUtils.isNullOrEmpty(at) && at.contains(head.getToId())){
            isAt = 1;
        }
        String entityUrl = msgContentUrlHandel(chatMessage);
        String content = msgContentHandel(chatMessage);
        long duration = 0;
        if (GroupContacts.OffLineMsgType.VIDEO == chatMessage.getChatType()) duration = chatMessage.getVideo().getPos();
        return GroupMsgOffLineRequest.newBuilder()
                .setMsgId(chatMessage.getMsgId())
                .setMsgType(chatMessage.getChatType())
                .setContent(content)
                .setEntityUrl(entityUrl)
                .setFromId(head.getFromId())
                .setGroupId(group.getGroupId())
                .setToId(head.getToId())
                .setSnapchatStatus(group.getSettings() != null && group.getSettings().getSnapchatStatus())
                .setSnapchatTimeLength(group.getSettings() == null ? 0 : group.getSettings().getSnapchatTimeLength())
                .setId(StringUtils.isNullOrEmpty(head.getToken()) || "null".equals(head.getToken()) ? 0 : Integer.valueOf(head.getToken()))
                .setIsAt(isAt)
                .setDuration(duration)
                .setGroupOwner(registeredGroupMember.getGroupMemberNick())
                .setGroupOwnerNick(registeredGroupMember.getGroupMemberAlias())
                .setGroupOwnerUrl(registeredGroupMember.getUserType())
                .setGroupName(group.getGroupName())
                .setFromMemberId(registeredGroupMember.getGroupMemberUserId())
                .setFromMemberName(registeredGroupMember.getGroupMemberName())
                .setFromMemberAvatar(registeredGroupMember.getGroupMemberAvatar())
                .build();
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String msgContentUrlHandel(BusinessProtocolEntities.ChatMessage chatMessages){
        String entityUrl = "";
        switch (chatMessages.getChatType()){
            case GroupContacts.OffLineMsgType.PICTURE:
                entityUrl = chatMessages.getPicture().getUrl();
                break;
            case GroupContacts.OffLineMsgType.VIDEO:
                entityUrl = chatMessages.getVideo().getUrl();
                break;
            case GroupContacts.OffLineMsgType.FILE:
                entityUrl = chatMessages.getFile().getUrl();
                break;
        }
        return entityUrl;
    }

    public static String msgContentHandel(BusinessProtocolEntities.ChatMessage chatMessages){
        String content;
        switch (chatMessages.getChatType()){
            case GroupContacts.OffLineMsgType.PICTURE:
                content = chatMessages.getPicture().getThumbnail().toString(ISO_CHARSET);
                break;
            case GroupContacts.OffLineMsgType.VIDEO:
                content = chatMessages.getVideo().getThumbnail().toString(ISO_CHARSET);
                break;
            case GroupContacts.OffLineMsgType.VOICE:
                content = chatMessages.getVoice().getContent().toString(ISO_CHARSET);
                break;
            case GroupContacts.OffLineMsgType.FILE:
                content = chatMessages.getFile().getUrl();
                break;
            default:
                content = chatMessages.getText().getContent();
                break;
        }
        return content;
    }

    private static Gson gson = new Gson();

    public static String toJson(Object object){
        return gson.toJson(object);
    }

    public static String getTime() {
        return df.format(new Date());
    }

    public static GroupAudioVideoCallRequest createGroupAudioVideoCallReq(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        BusinessProtocolMessages.AudioAndVideoCallProtocol avcprto = msg.getUnifiedEntranceMessage().getAudioAndVideoCallProtocol();
        GroupAudioVideoCallRequest request = GroupAudioVideoCallRequest.newBuilder()
                .setArgs(ResponseStatus.AVC_SAVE)
                .setGroupAudioVideoMessage(GroupAudioVideoMessage.newBuilder()
                        .setRoomId(avcprto.getRoom().getRoomId())
                        .setOnlyAudio(avcprto.getRoom().getOnlyAudio())
                        .setFromUserId(avcprto.getFromUser().getUserId())
                        .setFromUserName(avcprto.getFromUser().getUserName())
                        .setUserAvatar(avcprto.getFromUser().getUserAvatar())
                        .setGroupId(avcprto.getToGroup().getGroupId())
                        .setCallMemberIds(avcprto.getToGroup().getCallMemberIds())
                        .setType(avcprto.getType())
                        .setDetail(msg.getUnifiedEntranceMessage().getHead().getTimestamp()+"")
                        .build())
                .build();
        return request;
    }

    public static GroupAudioVideoCallRequest pushGroupAudioVideoCallReq(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        BusinessProtocolMessageStandard.Head head = msg.getUnifiedEntranceMessage().getHead();
        GroupAudioVideoCallRequest request =  GroupAudioVideoCallRequest.newBuilder()
                .setArgs(ResponseStatus.AVC_PUSH)
                .setGroupAudioVideoMessage(GroupAudioVideoMessage.newBuilder()
                        .setFromUserId(head.getFromId())
                        .setDetail(String.valueOf(head.getTimestamp()).substring(0,10))
                        .build()).build();
        return request;

    }

    public static GroupAudioVideoCallRequest saveCallMsgToOffUserReq(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        BusinessProtocolMessageStandard.Head head = msg.getUnifiedEntranceMessage().getHead();
        String groupMem = head.getToId();
        BusinessProtocolMessages.AudioAndVideoCallProtocol audioCallProto = msg.getUnifiedEntranceMessage().getAudioAndVideoCallProtocol();
        List<String> joinUserIds = Arrays.asList(audioCallProto.getToGroup().getCallMemberIds().split(","));
        boolean isJoinCall  = false;
        if (joinUserIds.contains(groupMem)){
            isJoinCall =true;
        }
        GroupAudioVideoCallRequest request = GroupAudioVideoCallRequest.newBuilder()
                .setArgs(ResponseStatus.AVC_SAVE_TO_OFF_USER)
                .setGroupAudioVideoMessage(GroupAudioVideoMessage.newBuilder()
                        .setGroupId(audioCallProto.getToGroup().getGroupId())
                        .setCallMemberIds(groupMem)            //离线群成员ID
                        .setOnlyAudio(isJoinCall)              //是否参与通话
                        .setDetail(head.getToken())     //消息内容iD
                        .setOther(String.valueOf(head.getTimestamp()).substring(1,10))  //时间戳
                        .build()).build();
        //对应group_audio_video_call_index表相应字段

        return request;
    }
}
