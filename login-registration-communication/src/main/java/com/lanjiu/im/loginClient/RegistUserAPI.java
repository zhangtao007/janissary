package com.lanjiu.im.loginClient;

import com.lanjiu.im.util.ConstType;
import com.lanjiu.pro.login.*;

public class RegistUserAPI {
    //注册
    public ResponseUser storageRegisterUser(RequestUser request) {
        LoginRegistCommon loginRegistCommon = new LoginRegistCommon();
        ResponseUser responseUser = loginRegistCommon.storageRegisterUser(request);
        return responseUser;
    }
    //个人设置保存
    public ResponseUser storageUserInfomation(RequestUser request) {
        LoginRegistCommon loginRegistCommon = new LoginRegistCommon();
        ResponseUser responseUser = loginRegistCommon.storageUserInfomation(request);
        return responseUser;
    }
    //登录
    public ResponseUser loginRegistUser(RequestUser request) {
        LoginRegistCommon loginRegistCommon = new LoginRegistCommon();
        ResponseUser responseUser = loginRegistCommon.loginRegistUser(request);
        return responseUser;
    }
    //退出
    public ResponseUser logoutRegistUser(RequestUser request) {
        LoginRegistCommon loginRegistCommon = new LoginRegistCommon();
        ResponseUser responseUser = loginRegistCommon.logoutRegistUser(request);
        return responseUser;
    }
    //获取个人设置信息
    public ResponseUser selectUserInfomation(RequestUser request) {
        LoginRegistCommon loginRegistCommon = new LoginRegistCommon();
        ResponseUser responseUser = loginRegistCommon.selectUserInfomation(request);
        return responseUser;
    }

    //更改个人设置
    public ResponseUser updateUserInfomation(RequestUser request) {
        LoginRegistCommon loginRegistCommon = new LoginRegistCommon();
        ResponseUser responseUser = loginRegistCommon.updateUserInfomation(request);
        return responseUser;
    }

    public CheckForUpdatesProtocol checkAPPVersion(CheckForUpdatesProtocol request) {
        LoginRegistCommon loginRegistCommon = new LoginRegistCommon();
        CheckForUpdatesProtocol response = loginRegistCommon.checkAPPVersion(request);
        return response;
    }

    public RequestUserDevice updateUserDevice(RequestUserDevice request) {
        LoginRegistCommon loginRegistCommon = new LoginRegistCommon();
        RequestUserDevice response = loginRegistCommon.updateUserDevice(request);
        return response;
    }


    public static void main(String[] args) {
        RegistUserAPI registUserAPI = new RegistUserAPI();
        //測試存儲用戶個人信息
     /*   RequestUser requestUser = RequestUser.newBuilder().setUserType(ConstType.REGISTERUSER)
                                            .setUserInfomation(UserInfomation.newBuilder()
                                                    .setUserId("10010044")
                                                    .setAvatar("aaa")
                                                    .setNickname("bilibili")
                                                    .setOffMsgSetting(true).build()
                                          ).setArgs("1").build();
        ResponseUser responseUser = registUserAPI.storageUerInfomation(requestUser);

        System.out.println(responseUser.getRet());
        System.out.println(responseUser.getUserInfomationList().get(0));*/

        //測試獲取用戶信息
        RequestUser requestUser = RequestUser.newBuilder().setUserType(ConstType.REGISTERUSER)
                .setArgs(ConstType.SEARCH_USER)
                .setRegisterUser(RegisterUser.newBuilder()
                        .setUserId("10010260").build())
                .build();
        ResponseUser responseUser = registUserAPI.selectUserInfomation(requestUser);

        System.out.println(responseUser.getRet());
        System.out.println(responseUser.getRegisterUserList().get(0).getUserInfomation());
        System.out.println(responseUser.getRegisterUserList().get(0).getUserInfomation().getAvatar());
        System.out.println(responseUser.getRegisterUserList().get(0).getUserInfomation().getNickname());


     //测试搜索好友


    }

    public static void run(){
        RegistUserAPI registUserAPI = new RegistUserAPI();
        //測試獲取用戶信息
        RequestUser requestUser = RequestUser.newBuilder().setUserType(ConstType.REGISTERUSER)
                .setArgs(ConstType.SEARCH_USER)
                .setRegisterUser(RegisterUser.newBuilder()
                        .setUserId("10010260").build())
                .build();
        ResponseUser responseUser = registUserAPI.selectUserInfomation(requestUser);

        System.out.println(responseUser.getRet());
        System.out.println(responseUser.getRegisterUserList().get(0).getUserInfomation());
    }


}
