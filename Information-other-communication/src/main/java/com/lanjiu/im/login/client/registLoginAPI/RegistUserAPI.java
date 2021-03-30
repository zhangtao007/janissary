package com.lanjiu.im.login.client.registLoginAPI;

import com.lanjiu.im.login.client.FriendMessageCommon;
import com.lanjiu.pro.login.RequestUser;
import com.lanjiu.pro.login.ResponseUser;

public class RegistUserAPI {
    //注册
    public ResponseUser storageRegisterUser(RequestUser request) {
        FriendMessageCommon friendMessageCommon = new FriendMessageCommon();
        ResponseUser responseUser = friendMessageCommon.storageRegisterUser(request);
        return responseUser;
    }
    //个人设置
    public ResponseUser storageUserInfomation(RequestUser request) {
        FriendMessageCommon friendMessageCommon = new FriendMessageCommon();
        ResponseUser responseUser = friendMessageCommon.storageUserInfomation(request);
        return responseUser;
    }
    //登录
    public ResponseUser loginRegistUser(RequestUser request) {
        FriendMessageCommon friendMessageCommon = new FriendMessageCommon();
        ResponseUser responseUser = friendMessageCommon.loginRegistUser(request);
        return responseUser;
    }
    //退出
    public ResponseUser logoutRegistUser(RequestUser request) {
        FriendMessageCommon friendMessageCommon = new FriendMessageCommon();
        ResponseUser responseUser = friendMessageCommon.logoutRegistUser(request);
        return responseUser;
    }
    //获取个人设置信息
    public ResponseUser selectUserInfomation(RequestUser request) {
        FriendMessageCommon friendMessageCommon = new FriendMessageCommon();
        ResponseUser responseUser = friendMessageCommon.selectUserInfomation(request);
        return responseUser;
    }

}
