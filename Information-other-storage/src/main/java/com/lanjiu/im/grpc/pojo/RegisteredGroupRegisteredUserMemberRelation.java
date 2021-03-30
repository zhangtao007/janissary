package com.lanjiu.im.grpc.pojo;

public class RegisteredGroupRegisteredUserMemberRelation {
    private Integer registeredGroupId;
    private Integer registeredUserMemberId;

    public Integer getRegisteredGroupId() {
        return registeredGroupId;
    }

    public void setRegisteredGroupId(Integer registeredGroupId) {
        this.registeredGroupId = registeredGroupId;
    }

    public Integer getRegisteredUserMemberId() {
        return registeredUserMemberId;
    }

    public void setRegisteredUserMemberId(Integer registeredUserMemberId) {
        this.registeredUserMemberId = registeredUserMemberId;
    }
}
