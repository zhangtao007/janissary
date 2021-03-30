package com.lanjiu.im.storage.pojo;

import java.util.Date;

public class RegisterUserPO {
    private int userId;
    private String userAcount;
    private String password;
    private String phone;
    private Date date;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserAcount() {
        return userAcount;
    }

    public void setUserAcount(String userAcount) {
        this.userAcount = userAcount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RegisterUserPO{" +
                "userId=" + userId +
                ", userAcount='" + userAcount + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", date=" + date +
                '}';
    }
}
