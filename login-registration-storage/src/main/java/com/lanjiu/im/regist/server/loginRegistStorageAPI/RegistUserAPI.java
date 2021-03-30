package com.lanjiu.im.regist.server.loginRegistStorageAPI;

import com.lanjiu.im.regist.server.controller.StorageRegistInfoController;
import com.lanjiu.im.regist.server.controller.StorageRegisterUserController;
import com.lanjiu.im.regist.utils.ConstType;
import com.lanjiu.im.regist.utils.IMSContacts;
import com.lanjiu.im.storage.pojo.RegisterUserPO;
import com.lanjiu.im.storage.pojo.UserDevice;
import com.lanjiu.im.storage.pojo.UserInfomationPO;
import com.lanjiu.im.storage.pojo.VersionPO;
import com.lanjiu.im.storage.service.RegisterUserService;
import com.lanjiu.im.storage.service.UserInfomationService;
import com.lanjiu.pro.login.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class RegistUserAPI {

    private static Logger logger = LoggerFactory.getLogger(RegistUserAPI.class);

    //注册
    public ResponseUser storageRegisterUser(RequestUser requestUser) {

        RegisterUser registerUser = requestUser.getRegisterUser();
        StorageRegisterUserController controller = new StorageRegisterUserController();
        StorageRegistInfoController infocController = new StorageRegistInfoController();
        UserInfomation info = null;
        ResponseUser responseUser = null;

        //todo 检查手机号码是否已经注册过
      /*  RegisterUserPO userByPhone = controller.getUserByPhone(registerUser.getPhone());
        if(userByPhone !=null && StringUtils.isNotEmpty(userByPhone.getPhone())){
            responseUser = ResponseUser.newBuilder().addRegisterUser(RegisterUser.newBuilder()
                    .setUserId(registerUser.getUserId())
                    .setPhone(registerUser.getPhone())
                    .setPassword(registerUser.getPassword()))
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)
                    .setResult(ConstType.REGIST_PHONE_ISUSED)
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .build();
            return responseUser;
        }*/

        int num = controller.storageRegistUser(registerUser);

        if (num > 0) {
            info = UserInfomation.newBuilder().setUserId(String.valueOf(num))
                    .setNickname(registerUser.getUserInfomation().getNickname()).build();
            infocController.insertUserInfo(info);

            responseUser = ResponseUser.newBuilder().addRegisterUser(RegisterUser.newBuilder()
                    .setUserId(String.valueOf(num))
                    .setPhone(registerUser.getPhone())
                    .setPassword(registerUser.getPassword())
                    .setUserInfomation(info))
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS)
                    .setResult(ConstType.REGIST_SUCCESS)
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .build();
            return responseUser;
        } else {
            responseUser = ResponseUser.newBuilder().addRegisterUser(RegisterUser.newBuilder()
                    .setUserId(String.valueOf(num))
                    .setPhone(registerUser.getPhone())
                    .setPassword(registerUser.getPassword())
                    .setUserInfomation(info))
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)
                    .setResult(ConstType.REGIST_FAILURE)
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .build();
            return responseUser;
        }


    }

    //保存個人设置信息
    public ResponseUser storageUserInfomation(RequestUser requestUser) {
        UserInfomation userInfomationinfo = requestUser.getRegisterUser().getUserInfomation();

        StorageRegistInfoController controller = new StorageRegistInfoController();
        int num = 0;
        ResponseUser responseUser = null;

        num = controller.insertUserInfo(userInfomationinfo);
        if (num > 0) {
            responseUser = ResponseUser.newBuilder()
                    .setResult(ConstType.PERSON_SETTING_SUCCESS)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS)
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .addRegisterUser(RegisterUser.newBuilder()
                            .setUserInfomation(UserInfomation.newBuilder()
                                    .setUserId(userInfomationinfo.getUserId())).build())
                    .build();

        } else {
            responseUser = ResponseUser.newBuilder()
                    .setResult(ConstType.PERSON_SETTING_FAILURE)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .addRegisterUser(RegisterUser.newBuilder()
                            .setUserInfomation(UserInfomation.newBuilder()
                                    .setUserId(userInfomationinfo.getUserId())).build())
                    .build();
        }
        return responseUser;
    }

    //获取信息
    public ResponseUser selectUserInfomation(RequestUser requestUser) {
        StorageRegisterUserController usercontroller = new StorageRegisterUserController();
        StorageRegistInfoController infoController = new StorageRegistInfoController();
        List<RegisterUser> registerUserList = new ArrayList<>();
        RegisterUser registerUser = null;
        List<UserInfomationPO> infoList = null;
        List<RegisterUserPO> userList = null;
        ResponseUser responseUser = null;
        if (requestUser.getRegisterUser().getUserId() == null || requestUser.getRegisterUser().getUserId().equalsIgnoreCase("")) {
            logger.error("ID不能为空！####");
            responseUser = ResponseUser.newBuilder()
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)
                    .setResult(ConstType.INPUT_EXCEPTION)
                    .build();
            return responseUser;
        }

        if (requestUser.getArgs().equals(ConstType.SEARCH_USER)) {

            userList = usercontroller.searchUser(requestUser.getRegisterUser().getUserId());
            infoList = infoController.getUserInfo(Integer.parseInt(requestUser.getRegisterUser().getUserId()));

            if (userList == null) {
                logger.info("未查询到此 id 用户信息 :" + requestUser.getRegisterUser().getUserId());
                responseUser = ResponseUser.newBuilder()
                        .setUserType(IMSContacts.UserType.REGISTERED_USER)
                        .setRet(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)
                        .setResult(ConstType.QUERY_USERINFO_FAILURE)
                        .build();
                return responseUser;
            }

            if (userList.size() > 0 && infoList.size() > 0) {
                if (userList.get(0).getUserId() == infoList.get(0).getUserId()) {
                    registerUser = RegisterUser.newBuilder()
                            .setUserId(String.valueOf(userList.get(0).getUserId()))
                            .setUserAccount(String.valueOf(userList.get(0).getUserAcount()))
                            .setPhone(userList.get(0).getPhone())
                            .setPassword(userList.get(0).getPassword())
                            .setUserInfomation(UserInfomation.newBuilder()
                                    .setUserId(String.valueOf(infoList.get(0).getUserId()))
                                    .setNickname(infoList.get(0).getNickname())
                                    .setAvatar(infoList.get(0).getAvatar())
                                    .setOnlineStatus(infoList.get(0).getOnlineStatus())
                                    .setExitClean(infoList.get(0).getExitClean())
                                    .setTimerClean(infoList.get(0).getTimerClean()).build()).build();
                }
                registerUserList.add(registerUser);

            }
        }

        if (registerUserList == null || registerUserList.size() <= 0) {
            responseUser = ResponseUser.newBuilder()
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)
                    .setResult(ConstType.QUERY_USERINFO_FAILURE)
                    .build();
        } else {
            responseUser = ResponseUser.newBuilder()
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS)
                    .setResult(ConstType.QUERY_USERINFO_SUCCESS)
                    .addAllRegisterUser(registerUserList).build();
        }


        return responseUser;
    }

    //登錄
    public ResponseUser loginRegistUser(RequestUser requestUser) {

        RegisterUser registerUser = requestUser.getRegisterUser();
        StorageRegisterUserController controller = new StorageRegisterUserController();
        int num = controller.loginRegist(registerUser);
        ResponseUser responseUser = null;

        if (num > 0) {
            responseUser = ResponseUser.newBuilder().addRegisterUser(RegisterUser.newBuilder()
                    .setUserId(registerUser.getUserId()))
                    .setResult(ConstType.REGIST_LOGIN_SUCCESS)
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS)
                    .build();
        } else {
            responseUser = ResponseUser.newBuilder().addRegisterUser(RegisterUser.newBuilder()
                    .setUserId(registerUser.getUserId()))
                    .setResult(ConstType.REGIST_LOGIN_FAILURE)
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)
                    .build();
            return responseUser;

        }
        return responseUser;

    }

    //更改個人設置
    public ResponseUser updateUserInfomation(RequestUser request) {
        ResponseUser responseUser = null;
        if (request.getRegisterUser().getUserId() == null || request.getRegisterUser().getUserId().equalsIgnoreCase("")) {
            logger.error("id不能为空！" + request.toString());
            responseUser = ResponseUser.newBuilder()
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)
                    .setResult(ConstType.INPUT_EXCEPTION)
                    .build();
            return responseUser;
        }

        //个人的手机、密码设置
        if (request.getArgs().equalsIgnoreCase(ConstType.USER_SET)) {
            StorageRegisterUserController controller = new StorageRegisterUserController();
            int up = controller.updateUser(request.getRegisterUser());
            if (up > 0) {
                responseUser = ResponseUser.newBuilder()
                        .setResult(ConstType.PERSON_SETTING_SUCCESS)
                        .setUserType(IMSContacts.UserType.REGISTERED_USER)
                        .setRet(String.valueOf(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS))
                        .build();

            } else {
                responseUser = ResponseUser.newBuilder()
                        .setResult(ConstType.PERSON_SETTING_FAILURE)
                        .setUserType(IMSContacts.UserType.REGISTERED_USER)
                        .setRet(String.valueOf(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE))
                        .build();
            }
            return responseUser;
        }

        //设置个人的头像、昵称、退出清理、在线状态、清理周期。
        UserInfomation userInfomationinfo = request.getRegisterUser().getUserInfomation();
        StorageRegistInfoController controller = new StorageRegistInfoController();
        int num = controller.updateUserInfo(userInfomationinfo);
        if (num > 0) {

            responseUser = ResponseUser.newBuilder()
                    .setResult(ConstType.PERSON_SETTING_SUCCESS)
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .setRet(String.valueOf(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS))
                    .build();

        } else {
            responseUser = ResponseUser.newBuilder()
                    .setResult(ConstType.PERSON_SETTING_FAILURE)
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .setRet(String.valueOf(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE))
                    .build();
        }
        return responseUser;
    }

    //退出
    public ResponseUser logoutRegistUser(RequestUser request) {
        UserInfomation userInfomationinfo = request.getRegisterUser().getUserInfomation();
        StorageRegistInfoController controller = new StorageRegistInfoController();
        int num = controller.updateUserInfo(userInfomationinfo);
        ResponseUser responseUser = null;
        if (num > 0) {
            responseUser = ResponseUser.newBuilder()
                    .setResult(ConstType.REGIST_LOGOUT_SUCCESS)
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS)
                    .build();

        } else {
            responseUser = ResponseUser.newBuilder()
                    .setResult(ConstType.REGIST_LOGOUT_FAILURE)
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)
                    .build();

        }
        return responseUser;
    }


    public CheckForUpdatesProtocol checkAPPVersion(CheckForUpdatesProtocol request) {
        RegisterUserService rservice = new RegisterUserService();
        VersionPO version = rservice.getNewVersion();
        CheckForUpdatesProtocol response = CheckForUpdatesProtocol.newBuilder()
                .setDeviceType(version.getPhoneType())
                .setVersionCode(version.getVersionCode())
                .setVersionName(version.getVersionName())
                .setIsConstraint(version.getConstraint())
                .setUpdatePath(version.getPath())
                .setUpdateDescribe(version.getDescribe())
                .build();
        return response;
    }

    //检查并更新设备信息
    public RequestUserDevice updateUserDevice(RequestUserDevice request) {
        RegisterUserService rservice = new RegisterUserService();
        UserDevice userDevice = rservice.selectUserDevice(request.getRequestDeviceUpdate(0).getUserId());
        if(request.getRequestDeviceUpdate(0).getStatusDetail().equalsIgnoreCase("select")){
            UserInfomationService infoService = new UserInfomationService();
            List<UserInfomationPO> usrInfoList = infoService.getUsrInfomation(Integer.parseInt(request.getRequestDeviceUpdate(0).getUserId()));
            String onlineStatus = usrInfoList.get(0).getOnlineStatus();
            if (userDevice != null && !onlineStatus.equalsIgnoreCase("OUT")) {
                return RequestUserDevice.newBuilder().addRequestDeviceUpdate(RequestDeviceUpdate.newBuilder()
                        .setUserId(request.getRequestDeviceUpdate(0).getUserId())
                        .setManufacturer(userDevice.getManufacturer())
                        .setPushToken(userDevice.getPush_token())
                        .setStatusDetail(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS).build()).build();
            }
            return RequestUserDevice.newBuilder().addRequestDeviceUpdate(RequestDeviceUpdate.newBuilder()
                    .setUserId(request.getRequestDeviceUpdate(0).getUserId()) .setStatusDetail(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE).build()).build();
        }
        if (userDevice == null){
           return rservice.insertUserDevice(request.getRequestDeviceUpdate(0).getUserId(),request.getRequestDeviceUpdate(0).getManufacturer(),request.getRequestDeviceUpdate(0).getPushToken());
        }
        rservice.updateUserDevice(request.getRequestDeviceUpdate(0).getUserId(),request.getRequestDeviceUpdate(0).getManufacturer(),request.getRequestDeviceUpdate(0).getPushToken());
        return RequestUserDevice.newBuilder()
                .addRequestDeviceUpdate(RequestDeviceUpdate.newBuilder()
                        .setUserId(request.getRequestDeviceUpdate(0).getUserId())
                        .setStatusDetail(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS)
                        .build()).build();

    }
}
