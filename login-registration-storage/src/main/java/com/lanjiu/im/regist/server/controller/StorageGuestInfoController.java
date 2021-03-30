package com.lanjiu.im.regist.server.controller;

import com.lanjiu.im.storage.pojo.GuestUserInfoPO;
import com.lanjiu.im.storage.service.GuestInfoService;
import com.lanjiu.pro.login.UserInfomation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StorageGuestInfoController {

    public static void main(String[] args) {
        GuestUserInfoPO  info = new GuestUserInfoPO ();
        GuestInfoService service = new GuestInfoService();
        info.setUserId(70011230);
        info.setNickname("1688");
        info.setAvatar(null);
        info.setModificationTime( new Date());
//        info.setExitClean(true);
        info.setTimerClean(30);

//        List<GuestUserInfoPO> i= service.getUsrInfomation(1);
//        int i = service.insertUserInfo(info);
        int i = service.updateUserInfo(info);
        System.out.println(i);

    }

    public int insertUserInfo(UserInfomation userInfomation){
        GuestInfoService service = new GuestInfoService();
        GuestUserInfoPO  userInfoPO  = new GuestUserInfoPO ();
        userInfoPO.setUserId(Integer.valueOf(userInfomation.getUserId()));
        userInfoPO.setAvatar(userInfomation.getAvatar());
        userInfoPO.setNickname(userInfomation.getNickname());
//        userInfoPO.setOnlineStatus(userInfomation.getOnlineStatus());
        Date currentTime = new Date();
        userInfoPO.setModificationTime(currentTime);
//        userInfoPO.setExitClean(userInfomation.getExitClean());
        userInfoPO.setTimerClean(userInfomation.getTimerClean());
        int i =service.insertUserInfo(userInfoPO);
        service.close();
        return i;
    }

    public int deleteUserInfo(int userType,int userId){
        GuestInfoService service = new GuestInfoService();
        int i = service.deleteUserInfo(userId);
        service.close();
        return  i;
    }


    public int updateUserInfo(UserInfomation userInfomation){
        GuestInfoService service = new GuestInfoService();
        GuestUserInfoPO userInfoPO  = new GuestUserInfoPO();
        userInfoPO.setUserId(Integer.valueOf(userInfomation.getUserId()));
        userInfoPO.setAvatar(userInfomation.getAvatar());
        userInfoPO.setNickname(userInfomation.getNickname());
//        userInfoPO.setOnlineStatus(userInfomation.getOnlineStatus());
        Date currentTime = new Date();
        userInfoPO.setModificationTime(currentTime);
//        userInfoPO.setExitClean(userInfomation.getExitClean());
        userInfoPO.setTimerClean(userInfomation.getTimerClean());
        int i = 0;
        try {
            i = service.updateUserInfo(userInfoPO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        service.close();
        return i;
    }

    public List<GuestUserInfoPO> getUserInfo(int userId){
        GuestInfoService service = new GuestInfoService();
        List<GuestUserInfoPO>  list = service.getUsrInfomation(userId);
        service.close();
        return list;
    }
}
