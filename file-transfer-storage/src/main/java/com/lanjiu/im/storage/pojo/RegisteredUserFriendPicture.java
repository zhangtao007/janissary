package com.lanjiu.im.storage.pojo;

import java.sql.Date;

public class RegisteredUserFriendPicture {

    private String downloadUrl;
    private Integer registeredUserId;
    private Date creationTime;
    private Integer friendId;

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }


    public Integer getRegisteredUserId() {
        return registeredUserId;
    }

    public void setRegisteredUserId(Integer registeredUserId) {
        this.registeredUserId = registeredUserId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
