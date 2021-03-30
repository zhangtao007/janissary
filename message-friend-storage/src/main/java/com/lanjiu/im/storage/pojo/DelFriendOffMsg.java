package com.lanjiu.im.storage.pojo;

public class DelFriendOffMsg {

    private Integer delFromId;
    private Integer delToId;
    private Integer fromId;
    private String msgId;
    private long timer;
    private Integer msgType;

    public Integer getDelFromId() {
        return delFromId;
    }

    public void setDelFromId(Integer delFromId) {
        this.delFromId = delFromId;
    }

    public Integer getDelToId() {
        return delToId;
    }

    public void setDelToId(Integer delToId) {
        this.delToId = delToId;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }
}
