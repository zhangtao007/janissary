package com.lanjiu.im.grpc.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class GuestUserFriend {

    private Integer guestUserId;
    private Integer friendId;
    private Integer friendUserId;
    private String friendComment;
    private Timestamp creationTime;
    private Timestamp modificationTime;
    private String offlineMessageSetting;
    private String burnAfterReadingSetting;
    private String burnAfterReadingTimeUnit;
    private BigDecimal burnAfterReadingTimeLength;
    private String friendNickName;

    public Integer getFriendUserId() {
        return friendUserId;
    }

    public void setFriendUserId(Integer friendUserId) {
        this.friendUserId = friendUserId;
    }

    public String getFriendNickName() {
        return friendNickName;
    }

    public void setFriendNickName(String friendNickName) {
        this.friendNickName = friendNickName;
    }

    public Integer getGuestUserId() {
        return guestUserId;
    }

    public void setGuestUserId(Integer guestUserId) {
        this.guestUserId = guestUserId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public String getFriendComment() {
        return friendComment;
    }

    public void setFriendComment(String friendComment) {
        this.friendComment = friendComment;
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

    public String getOfflineMessageSetting() {
        return offlineMessageSetting;
    }

    public void setOfflineMessageSetting(String offlineMessageSetting) {
        this.offlineMessageSetting = offlineMessageSetting;
    }

    public String getBurnAfterReadingSetting() {
        return burnAfterReadingSetting;
    }

    public void setBurnAfterReadingSetting(String burnAfterReadingSetting) {
        this.burnAfterReadingSetting = burnAfterReadingSetting;
    }

    public String getBurnAfterReadingTimeUnit() {
        return burnAfterReadingTimeUnit;
    }

    public void setBurnAfterReadingTimeUnit(String burnAfterReadingTimeUnit) {
        this.burnAfterReadingTimeUnit = burnAfterReadingTimeUnit;
    }

    public BigDecimal getBurnAfterReadingTimeLength() {
        return burnAfterReadingTimeLength;
    }

    public void setBurnAfterReadingTimeLength(BigDecimal burnAfterReadingTimeLength) {
        this.burnAfterReadingTimeLength = burnAfterReadingTimeLength;
    }
}
