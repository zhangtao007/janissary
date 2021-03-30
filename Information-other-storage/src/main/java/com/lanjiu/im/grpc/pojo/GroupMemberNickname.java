package com.lanjiu.im.grpc.pojo;

import java.sql.Timestamp;

public class GroupMemberNickname {

    // 数据ID
    private Integer id;

    // 群ID
    private Integer groupId;

    // 用户ID
    private Integer userId;

    // 群成员ID
    private Integer groupMemberId;

    // 昵称备注
    private String nickRemark;

    // 创建时间
    private Timestamp createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupMemberId() {
        return groupMemberId;
    }

    public void setGroupMemberId(Integer groupMemberId) {
        this.groupMemberId = groupMemberId;
    }

    public String getNickRemark() {
        return nickRemark;
    }

    public void setNickRemark(String nickRemark) {
        this.nickRemark = nickRemark;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "GroupMemberNickname{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", userId=" + userId +
                ", groupMemberId=" + groupMemberId +
                ", nickRemark='" + nickRemark + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
