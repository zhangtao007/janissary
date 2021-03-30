package com.lanjiu.im.storage.pojo;

/**
 * @author zha_gtao
 * @data 2021/3/23 14:01
 */
public class UserDevice {
    Integer user_id;
    String push_token;
    String manufacturer;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getPush_token() {
        return push_token;
    }

    public void setPush_token(String push_token) {
        this.push_token = push_token;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "UserDevice{" +
                "user_id=" + user_id +
                ", push_token='" + push_token + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
