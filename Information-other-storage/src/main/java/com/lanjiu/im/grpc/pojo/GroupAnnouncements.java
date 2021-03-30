package com.lanjiu.im.grpc.pojo;

public class GroupAnnouncements {
    private Integer groupAnnouncementId;
    private String announcementTitle;
    private String announcementContent;

    public Integer getGroupAnnouncementId() {
        return groupAnnouncementId;
    }

    public void setGroupAnnouncementId(Integer groupAnnouncementId) {
        this.groupAnnouncementId = groupAnnouncementId;
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
}
