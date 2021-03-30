package com.lanjiu.im.storage.pojo;

import java.util.Date;

public class UserInfomationPO {

   private int userId ;
   private String nickname ;
   private String avatar ;
   private String onlineStatus ;
   private Date modificationTime ;
   private String  exitClean; //开启退出清理
   private Integer timerClean;   //设置定期清理

    public UserInfomationPO() {
    }

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


    public String getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getExitClean() {
        return exitClean;
    }

    public void setExitClean(String exitClean) {
        this.exitClean = exitClean;
    }

    public Integer getTimerClean() {
        return timerClean;
    }

    public void setTimerClean(Integer timerClean) {
        this.timerClean = timerClean;
    }
}
