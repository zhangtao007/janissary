package com.lanjiu.im.grpc.pojo;

public class RegisteredGroupGuestUserMemberRelation {
    private Integer registeredGroupId;
    private Integer guestUserMemberId;

    public Integer getRegisteredGroupId() {
        return registeredGroupId;
    }

    public void setRegisteredGroupId(Integer registeredGroupId) {
        this.registeredGroupId = registeredGroupId;
    }

    public Integer getGuestUserMemberId() {
        return guestUserMemberId;
    }

    public void setGuestUserMemberId(Integer guestUserMemberId) {
        this.guestUserMemberId = guestUserMemberId;
    }
}
