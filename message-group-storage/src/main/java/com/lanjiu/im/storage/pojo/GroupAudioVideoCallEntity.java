package com.lanjiu.im.storage.pojo;

/**
 * @author zha_gtao
 * @data 2020/8/31 14:52
 */
public class GroupAudioVideoCallEntity {

    private Integer id;
    private String  msgId;
    //房间id
    private String roomId;
    //纯音频
    private Boolean onlyAudio;
    //发起者Id
    private String fromUserId;
    //发起者名称
    private String fromUserName;
    //发起者头像
    private String fromUserAvatar;
    //群id
    private String groupId;
    //群视频通话参与者Id串（逗号分隔）
    private String joinMemberIds;
    //音视频消息类型；（创建；接入；加入；离开；）
    private String type;
    //时间
    private long time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Boolean getOnlyAudio() {
        return onlyAudio;
    }

    public void setOnlyAudio(Boolean onlyAudio) {
        this.onlyAudio = onlyAudio;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getFromUserAvatar() {
        return fromUserAvatar;
    }

    public void setFromUserAvatar(String fromUserAvatar) {
        this.fromUserAvatar = fromUserAvatar;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getJoinMemberIds() {
        return joinMemberIds;
    }

    public void setJoinMemberIds(String joinMemberIds) {
        this.joinMemberIds = joinMemberIds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "GroupAudioVideoCallEntity{" +
                "id=" + id +
                ", msgId='" + msgId + '\'' +
                ", roomId='" + roomId + '\'' +
                ", onlyAudio=" + onlyAudio +
                ", fromUserId='" + fromUserId + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", fromUserAvatar='" + fromUserAvatar + '\'' +
                ", groupId='" + groupId + '\'' +
                ", joinMemberIds='" + joinMemberIds + '\'' +
                ", type='" + type + '\'' +
                ", time=" + time +
                '}';
    }
}
