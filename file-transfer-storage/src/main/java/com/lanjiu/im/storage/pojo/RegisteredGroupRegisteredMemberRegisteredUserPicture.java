package com.lanjiu.im.storage.pojo;

import java.sql.Date;

public class RegisteredGroupRegisteredMemberRegisteredUserPicture {

    private String downloadUrl;
    private Integer registeredGroupId;
    private Integer registeredMemberId;
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
