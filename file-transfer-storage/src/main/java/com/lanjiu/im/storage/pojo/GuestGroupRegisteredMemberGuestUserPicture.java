package com.lanjiu.im.storage.pojo;

import java.sql.Date;

public class GuestGroupRegisteredMemberGuestUserPicture {

    private String downloadUrl;
    private Integer guestGroupId;
    private Integer registeredMemberId;
    private Integer guestUserId;
    private Date creationTime;

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Integer getGuestGroupId() {
        return guestGroupId;
    }

    public void setGuestGroupId(Integer guestGroupId) {
        this.guestGroupId = guestGroupId;
    }

    public Integer getRegisteredMemberId() {
        return registeredMemberId;
    }

    public void setRegisteredMemberId(Integer registeredMemberId) {
        this.registeredMemberId = registeredMemberId;
    }

    public Integer getGuestUserId() {
        return guestUserId;
    }

    public void setGuestUserId(Integer guestUserId) {
        this.guestUserId = guestUserId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
