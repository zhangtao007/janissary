package com.lanjiu.im.storage.pojo;

public class TimeClearMsgPO {
    private Integer clsFromId;
    private Integer clsToId;
    private Integer msgType;
    private String msgUid;
    private long newtime;

    public Integer getClsFromId() {
        return clsFromId;
    }

    public void setClsFromId(Integer clsFromId) {
        this.clsFromId = clsFromId;
    }

    public Integer getClsToId() {
        return clsToId;
    }

    public void setClsToId(Integer clsToId) {
        this.clsToId = clsToId;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public String getMsgUid() {
        return msgUid;
    }

    public void setMsgUid(String msgUid) {
        this.msgUid = msgUid;
    }

    public long getNewtime() {
        return newtime;
    }

    public void setNewtime(long newtime) {
        this.newtime = newtime;
    }
}
