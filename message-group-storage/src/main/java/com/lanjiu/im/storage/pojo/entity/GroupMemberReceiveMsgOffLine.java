package com.lanjiu.im.storage.pojo.entity;

import com.lanjiu.im.storage.pojo.GroupMsgOffLine;

import java.sql.Timestamp;

public class GroupMemberReceiveMsgOffLine extends GroupMsgOffLine {

    // 接收人
    private String toId;

    // 是否@
    private int isAt;

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public int getIsAt() {
        return isAt;
    }

    public void setIsAt(int isAt) {
        this.isAt = isAt;
    }

    @Override
    public String toString() {
        return "GroupMemberReceiveMsgOffLine{" +
                "toId='" + toId + '\'' +
                ", isAt=" + isAt +
                '}';
    }
}
