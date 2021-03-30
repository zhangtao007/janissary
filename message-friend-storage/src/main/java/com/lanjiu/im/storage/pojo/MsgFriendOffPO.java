package com.lanjiu.im.storage.pojo;


public class MsgFriendOffPO {
    private  String msgId;
    private  Integer msgType;
    private  Integer fromId;
    private  Integer toId;
    private  String  content;
    private  String entityUrl;
    private long createTime;
    private boolean messageOfflineStatus;
    private boolean burnAfterReadingStatus;
    private Integer burnAfterReadingLength;
    private String fromNickname;
    private String fromAvatar;
    private long videoTime;

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

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
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

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public boolean isMessageOfflineStatus() {
        return messageOfflineStatus;
    }

    public void setMessageOfflineStatus(boolean messageOfflineStatus) {
        this.messageOfflineStatus = messageOfflineStatus;
    }

    public boolean isBurnAfterReadingStatus() {
        return burnAfterReadingStatus;
    }

    public void setBurnAfterReadingStatus(boolean burnAfterReadingStatus) {
        this.burnAfterReadingStatus = burnAfterReadingStatus;
    }

    public Integer getBurnAfterReadingLength() {
        return burnAfterReadingLength;
    }

    public void setBurnAfterReadingLength(Integer burnAfterReadingLength) {
        this.burnAfterReadingLength = burnAfterReadingLength;
    }

    public String getFromNickname() {
        return fromNickname;
    }

    public void setFromNickname(String fromNickname) {
        this.fromNickname = fromNickname;
    }

    public String getFromAvatar() {
        return fromAvatar;
    }

    public void setFromAvatar(String fromAvatar) {
        this.fromAvatar = fromAvatar;
    }

    public long getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(long videoTime) {
        this.videoTime = videoTime;
    }
}
