package com.lanjiu.im.grpc.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class RegisteredGroupMember {

    private Integer groupMemberId;
    private Integer registeredUserId;
    private String userIdAndName;
    private String groupRemarks;
    private String groupOwner;
    private String burnAfterReadingSettings;
    private String burnAfterReadingTimeUnit;
    private BigDecimal burnAfterReadingTimeLength;
    private Timestamp groupEntryTime;
    private String offlineMessageSetting;

    public Integer getGroupMemberId() {
        return groupMemberId;
    }

    public void setGroupMemberId(Integer groupMemberId) {
        this.groupMemberId = groupMemberId;
    }

    public Integer getRegisteredUserId() {
        return registeredUserId;
    }

    public void setRegisteredUserId(Integer registeredUserId) {
        this.registeredUserId = registeredUserId;
    }

    public String getGroupRemarks() {
        return groupRemarks;
    }

    public void setGroupRemarks(String groupRemarks) {
        this.groupRemarks = groupRemarks;
    }

    public String getGroupOwner() {
        return groupOwner;
    }

    public void setGroupOwner(String groupOwner) {
        this.groupOwner = groupOwner;
    }

    public String getBurnAfterReadingSettings() {
        return burnAfterReadingSettings;
    }

    public void setBurnAfterReadingSettings(String burnAfterReadingSettings) {
        this.burnAfterReadingSettings = burnAfterReadingSettings;
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

    public Timestamp getGroupEntryTime() {
        return groupEntryTime;
    }

    public void setGroupEntryTime(Timestamp groupEntryTime) {
        this.groupEntryTime = groupEntryTime;
    }

    public String getOfflineMessageSetting() {
        return offlineMessageSetting;
    }

    public void setOfflineMessageSetting(String offlineMessageSetting) {
        this.offlineMessageSetting = offlineMessageSetting;
    }

    public String getUserIdAndName() {
        return userIdAndName;
    }

    public void setUserIdAndName(String userIdAndName) {
        this.userIdAndName = userIdAndName;
    }
}
