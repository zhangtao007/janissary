package com.lanjiu.im.regist.server.controller;

import com.lanjiu.im.storage.pojo.UserInfomationPO;
import com.lanjiu.im.storage.service.UserInfomationService;
import com.lanjiu.pro.login.UserInfomation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class StorageRegistInfoController {

    public int insertUserInfo(UserInfomation userInfomation){
        UserInfomationService service = new UserInfomationService();
        UserInfomationPO userInfoPO  = new UserInfomationPO();
        userInfoPO.setUserId(Integer.valueOf(userInfomation.getUserId()));
        userInfoPO.setAvatar(userInfomation.getAvatar());
        userInfoPO.setNickname(userInfomation.getNickname());
//        userInfoPO.setOnlineStatus(ConstType.ON);
        Date currentTime = new Date();
        userInfoPO.setModificationTime(currentTime);
//        userInfoPO.setExitClean(ConstType.OFF);
//        userInfoPO.setTimerClean(ConstType.CLEAN_TIME_DEFAULT);
        int i =service.insertUserInfo(userInfoPO);
        service.close();
        return i;
    }

    public int updateUserInfo(UserInfomation userInfomation){
        UserInfomationService service = new UserInfomationService();
        UserInfomationPO userInfoPO  = new UserInfomationPO();
        userInfoPO.setUserId(Integer.valueOf(userInfomation.getUserId()));
        userInfoPO.setAvatar(userInfomation.getAvatar());
        userInfoPO.setNickname(userInfomation.getNickname());
        userInfoPO.setOnlineStatus(userInfomation.getOnlineStatus());
        Date currentTime = new Date();
        userInfoPO.setModificationTime(currentTime);
        userInfoPO.setExitClean(userInfomation.getExitClean());
        userInfoPO.setTimerClean(userInfomation.getTimerClean());
        int i =service.updateUserInfo(userInfoPO);
        service.close();
        return i;

    }

    public List<UserInfomationPO> getUserInfo(int userId){
        UserInfomationService service = new UserInfomationService();
        List<UserInfomationPO> list = service.getUsrInfomation(userId);
        service.close();
        return list;
    }
}
