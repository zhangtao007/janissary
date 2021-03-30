package com.lanjiu.im.grpc.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class AllGroupMemberVO {

    private Integer groupMemberId;//群成员ID(可以是注册，可以是游客)
    private Integer registeredGroupId;//注册群ID
    private Integer guestGroupId;//游客群ID
    private Integer registeredUserId;//注册用户ID
    private Integer guestUserId;//游客用户ID
    private String groupRemarks;//群备注
    private String groupOwner;//是否群主
    private String burnAfterReadingSettings;
    private String burnAfterReadingTimeUnit;
    private BigDecimal burnAfterReadingTimeLength;
    private Timestamp groupEntryTime;//进群时间
    private String offlineMessageSetting;
    private String registerUserNickName;//注册用户昵称
    private String guestUserNickName;//游客用户昵称
    private String groupName;//群名称
    private Integer amount;//群人数
    private String announcementTitle;//群公告标题》》》 //暂存群成员昵称
    private String announcementContent;//群公告内容
    private String userPhoto;//用户头像

    public Integer getGroupMemberId() {
        return groupMemberId;
    }

    public void setGroupMemberId(Integer groupMemberId) {
        this.groupMemberId = groupMemberId;
    }

    public Integer getRegisteredGroupId() {
        return registeredGroupId;
    }

    public void setRegisteredGroupId(Integer registeredGroupId) {
        this.registeredGroupId = registeredGroupId;
    }

    public Integer getGuestGroupId() {
        return guestGroupId;
    }

    public void setGuestGroupId(Integer guestGroupId) {
        this.guestGroupId = guestGroupId;
    }

    public Integer getRegisteredUserId() {
        return registeredUserId;
    }

    public void setRegisteredUserId(Integer registeredUserId) {
        this.registeredUserId = registeredUserId;
    }

    public Integer getGuestUserId() {
        return guestUserId;
    }

    public void setGuestUserId(Integer guestUserId) {
        this.guestUserId = guestUserId;
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

    public String getRegisterUserNickName() {
        return registerUserNickName;
    }

    public void setRegisterUserNickName(String registerUserNickName) {
        this.registerUserNickName = registerUserNickName;
    }

    public String getGuestUserNickName() {
        return guestUserNickName;
    }

    public void setGuestUserNickName(String guestUserNickName) {
        this.guestUserNickName = guestUserNickName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public String getAnnouncementContent() {
        return announcementContent;
    }

    public void setAnnouncementContent(String announcementContent) {
        this.announcementContent = announcementContent;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }
}
