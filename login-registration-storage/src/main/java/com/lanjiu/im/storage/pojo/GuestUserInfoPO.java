package com.lanjiu.im.storage.pojo;

import java.util.Date;

public class GuestUserInfoPO {
    private int userId ;
    private String nickname ;
    private String avatar ;
    private boolean offlineMessageSetting ;
    private boolean onlineStatus ;
    private Date modificationTime ;
    private boolean burnAfterReadingSetting ;
    private int burnAfterReadingTimeUnit ;
    private int burnAfterReadingTimeLength ;
    private boolean  exitClean;
    private int timerClean;
    private boolean groupBurnAfterReadingSetting;
    private int groupBurnAfterReadingTimeLength;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isOfflineMessageSetting() {
        return offlineMessageSetting;
    }

    public void setOfflineMessageSetting(boolean offlineMessageSetting) {
        this.offlineMessageSetting = offlineMessageSetting;
    }

    public boolean isOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public boolean isBurnAfterReadingSetting() {
        return burnAfterReadingSetting;
    }

    public void setBurnAfterReadingSetting(boolean burnAfterReadingSetting) {
        this.burnAfterReadingSetting = burnAfterReadingSetting;
    }

    public int getBurnAfterReadingTimeUnit() {
        return burnAfterReadingTimeUnit;
    }

    public void setBurnAfterReadingTimeUnit(int burnAfterReadingTimeUnit) {
        this.burnAfterReadingTimeUnit = burnAfterReadingTimeUnit;
    }

    public int getBurnAfterReadingTimeLength() {
        return burnAfterReadingTimeLength;
    }

    public void setBurnAfterReadingTimeLength(int burnAfterReadingTimeLength) {
        this.burnAfterReadingTimeLength = burnAfterReadingTimeLength;
    }

    public boolean isExitClean() {
        return exitClean;
    }

    public void setExitClean(boolean exitClean) {
        this.exitClean = exitClean;
    }

    public int getTimerClean() {
        return timerClean;
    }

    public void setTimerClean(int timerClean) {
        this.timerClean = timerClean;
    }

    public boolean isGroupBurnAfterReadingSetting() {
        return groupBurnAfterReadingSetting;
    }

    public void setGroupBurnAfterReadingSetting(boolean groupBurnAfterReadingSetting) {
        this.groupBurnAfterReadingSetting = groupBurnAfterReadingSetting;
    }

    public int getGroupBurnAfterReadingTimeLength() {
        return groupBurnAfterReadingTimeLength;
    }

    public void setGroupBurnAfterReadingTimeLength(int groupBurnAfterReadingTimeLength) {
        this.groupBurnAfterReadingTimeLength = groupBurnAfterReadingTimeLength;
    }
}
