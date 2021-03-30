package com.lanjiu.im.grpc.pojo;

import java.sql.Timestamp;

public class RegisteredGroup {

    private Integer registeredUserId;
    private Integer groupId;
    private String groupName;
    private Integer groupAnnouncementId;
    private Timestamp creationTime;
    private Timestamp modificationTime;
    private Integer amount;
    private String groupPhotoUrl;
    private String groupPhotoUserIdList;


    public Integer getRegisteredUserId() {
        return registeredUserId;
    }

    public void setRegisteredUserId(Integer registeredUserId) {
        this.registeredUserId = registeredUserId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupAnnouncementId() {
        return groupAnnouncementId;
    }

    public void setGroupAnnouncementId(Integer groupAnnouncementId) {
        this.groupAnnouncementId = groupAnnouncementId;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Timestamp modificationTime) {
        this.modificationTime = modificationTime;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getGroupPhotoUrl() {
        return groupPhotoUrl;
    }

    public void setGroupPhotoUrl(String groupPhotoUrl) {
        this.groupPhotoUrl = groupPhotoUrl;
    }

    public String getGroupPhotoUserIdList() {
        return groupPhotoUserIdList;
    }

    public void setGroupPhotoUserIdList(String groupPhotoUserIdList) {
        this.groupPhotoUserIdList = groupPhotoUserIdList;
    }
}
