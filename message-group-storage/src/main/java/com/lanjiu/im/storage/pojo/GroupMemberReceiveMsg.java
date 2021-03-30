package com.lanjiu.im.storage.pojo;

public class GroupMemberReceiveMsg {

    private Integer id;

    private String groupId;

    private String toId;

    private Integer offLineMsgId;

    private Integer isAt;

    private Long createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public Integer getOffLineMsgId() {
        return offLineMsgId;
    }

    public void setOffLineMsgId(Integer offLineMsgId) {
        this.offLineMsgId = offLineMsgId;
    }

    public Integer getIsAt() {
        return isAt;
    }

    public void setIsAt(Integer isAt) {
        this.isAt = isAt;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
