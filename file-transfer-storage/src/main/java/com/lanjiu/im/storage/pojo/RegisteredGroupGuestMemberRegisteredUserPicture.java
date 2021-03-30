package com.lanjiu.im.storage.pojo;

import java.sql.Date;

public class RegisteredGroupGuestMemberRegisteredUserPicture {

    private String downloadUrl;
    private Integer registeredGroupId;
    private Integer guestMemberId;
    private Integer registeredUserId;
    private Date creationTime;

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Integer getRegisteredGroupId() {
        return registeredGroupId;
    }

    public void setRegisteredGroupId(Integer registeredGroupId) {
        this.registeredGroupId = registeredGroupId;
    }

    public Integer getGuestMemberId() {
        return guestMemberId;
    }

    public void setGuestMemberId(Integer guestMemberId) {
        this.guestMemberId = guestMemberId;
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
