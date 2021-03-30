package com.lanjiu.im.storage.pojo;

import java.sql.Date;

public class GuestGroupRegisteredMemberRegisteredUserPicture {

    private String downloadUrl;
    private Integer guestGroupId;
    private Integer registeredMemberId;
    private Integer registeredUserId;
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

    public Integer getRegisteredUserId() {
        return registeredUserId;
    }

    public void setRegisteredUserId(Integer registeredUserId) {
        this.registeredUserId = registeredUserId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
