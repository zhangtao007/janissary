package com.lanjiu.im.grpc.pojo;

public class GuestGroupRegisteredUserMemberRelation {
    private Integer guestGroupId;
    private Integer registeredUserMemberId;

    public Integer getGuestGroupId() {
        return guestGroupId;
    }

    public void setGuestGroupId(Integer guestGroupId) {
        this.guestGroupId = guestGroupId;
    }

    public Integer getRegisteredUserMemberId() {
        return registeredUserMemberId;
    }

    public void setRegisteredUserMemberId(Integer registeredUserMemberId) {
        this.registeredUserMemberId = registeredUserMemberId;
    }
}
