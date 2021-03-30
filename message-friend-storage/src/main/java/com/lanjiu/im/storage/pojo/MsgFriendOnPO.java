package com.lanjiu.im.storage.pojo;

import java.util.Date;

public class MsgFriendOnPO {

    private  String msgId;
    private  Integer msgType;
    private  Integer fromId;
    private  Integer toId;
    private  String  content;
    private  String entityUrl;
    private Date createTime;
    private boolean messageOfflineStatus;
    private boolean burnAfterReadingStatus;
    private Integer burnAfterReadingLength;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
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
}
