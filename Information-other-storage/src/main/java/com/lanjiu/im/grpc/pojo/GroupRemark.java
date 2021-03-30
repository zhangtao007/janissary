package com.lanjiu.im.grpc.pojo;

public class GroupRemark {
    private Integer groupId;
    private Integer groupMemberId;
    private Integer groupMemberIdRemarked;
    private String remark;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getGroupMemberId() {
        return groupMemberId;
    }

    public void setGroupMemberId(Integer groupMemberId) {
        this.groupMemberId = groupMemberId;
    }

    public Integer getGroupMemberIdRemarked() {
        return groupMemberIdRemarked;
    }

    public void setGroupMemberIdRemarked(Integer groupMemberIdRemarked) {
        this.groupMemberIdRemarked = groupMemberIdRemarked;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
