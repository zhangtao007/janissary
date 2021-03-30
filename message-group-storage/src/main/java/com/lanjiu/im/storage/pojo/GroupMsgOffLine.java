package com.lanjiu.im.storage.pojo;

import java.sql.Timestamp;

public class GroupMsgOffLine {

    private Integer id;

    // 消息ID
    private String msgId;

    // 消息类型
    private Integer msgType;

    // 发送人
    private String fromId;

    // 群ID
    private String groupId;

    // 群ID
    private String groupName;

    // 消息内容
    private String content;

    // 消息url
    private String entityUrl;

    // 是否阅后即焚
    private boolean snapChatStatus;

    // 阅后即焚时长
    private Integer snapChatTimeLength;

    // 视频时长
    private long duration;

    // 群主ID
    private String groupOwner;

    // 群主昵称
    private String groupOwnerNick;

    // 群主图像
    private String groupOwnerUrl;

    // 发送人群成员ID
    private String fromMemberId;

    // 发送人群昵称
    private String fromMemberName;

    // 发送人群图像
    private String fromMemberAvatar;

    // 创建时间
    private Timestamp createTime;

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

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEntityUrl() {
        return entityUrl;
    }

    public void setEntityUrl(String entityUrl) {
        this.entityUrl = entityUrl;
    }

    public boolean isSnapChatStatus() {
        return snapChatStatus;
    }

    public void setSnapChatStatus(boolean snapChatStatus) {
        this.snapChatStatus = snapChatStatus;
    }

    public Integer getSnapChatTimeLength() {
        return snapChatTimeLength;
    }

    public void setSnapChatTimeLength(Integer snapChatTimeLength) {
        this.snapChatTimeLength = snapChatTimeLength;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getGroupOwner() {
        return groupOwner;
    }

    public void setGroupOwner(String groupOwner) {
        this.groupOwner = groupOwner;
    }

    public String getGroupOwnerNick() {
        return groupOwnerNick;
    }

    public void setGroupOwnerNick(String groupOwnerNick) {
        this.groupOwnerNick = groupOwnerNick;
    }

    public String getGroupOwnerUrl() {
        return groupOwnerUrl;
    }

    public void setGroupOwnerUrl(String groupOwnerUrl) {
        this.groupOwnerUrl = groupOwnerUrl;
    }

    public String getFromMemberId() {
        return fromMemberId;
    }

    public void setFromMemberId(String fromMemberId) {
        this.fromMemberId = fromMemberId;
    }

    public String getFromMemberName() {
        return fromMemberName;
    }

    public void setFromMemberName(String fromMemberName) {
        this.fromMemberName = fromMemberName;
    }

    public String getFromMemberAvatar() {
        return fromMemberAvatar;
    }

    public void setFromMemberAvatar(String fromMemberAvatar) {
        this.fromMemberAvatar = fromMemberAvatar;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "GroupMsgOffLine{" +
                "id=" + id +
                ", msgId='" + msgId + '\'' +
                ", msgType=" + msgType +
                ", fromId='" + fromId + '\'' +
                ", groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", content='" + content + '\'' +
                ", entityUrl='" + entityUrl + '\'' +
                ", snapChatStatus=" + snapChatStatus +
                ", snapChatTimeLength=" + snapChatTimeLength +
                ", duration=" + duration +
                ", groupOwner='" + groupOwner + '\'' +
                ", groupOwnerNick='" + groupOwnerNick + '\'' +
                ", groupOwnerUrl='" + groupOwnerUrl + '\'' +
                ", fromMemberId='" + fromMemberId + '\'' +
                ", fromMemberName='" + fromMemberName + '\'' +
                ", fromMemberAvatar='" + fromMemberAvatar + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
