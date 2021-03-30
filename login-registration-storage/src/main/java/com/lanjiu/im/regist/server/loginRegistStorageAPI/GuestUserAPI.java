package com.lanjiu.im.regist.server.loginRegistStorageAPI;

import com.lanjiu.im.regist.server.controller.StorageGuestInfoController;
import com.lanjiu.im.regist.server.controller.StorageGuestUserController;
import com.lanjiu.im.regist.utils.ConstType;
import com.lanjiu.im.regist.utils.IMSContacts;
import com.lanjiu.im.storage.pojo.GuestUserInfoPO;
import com.lanjiu.im.storage.pojo.GuestUserPO;
import com.lanjiu.pro.login.GuestUser;
import com.lanjiu.pro.login.RequestUser;
import com.lanjiu.pro.login.ResponseUser;
import com.lanjiu.pro.login.UserInfomation;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GuestUserAPI {
    private static Logger logger = Logger.getLogger(GuestUserAPI.class.getName());

    //游客登录
    public ResponseUser loginGuestUser(RequestUser requestUser) {

            GuestUser guestUser = requestUser.getGuestUser();
            StorageGuestUserController controller = new StorageGuestUserController();
            StorageGuestInfoController infoController = new StorageGuestInfoController();
            int num = 0;
            try {
                num = controller.insertUser(guestUser);
            } catch (Exception e) {
                logger.info("error guest login");
            }

            if(num>0){
                UserInfomation info = UserInfomation.newBuilder().setUserId(String.valueOf(num)).setNickname("游客id"+String.valueOf(num)).build();
                infoController.insertUserInfo(info);
                ResponseUser responseUser  = ResponseUser.newBuilder()
                        .addGuestUser(GuestUser.newBuilder()
                                .setUserId(String.valueOf(num))
                                .setUserInfomation(UserInfomation.newBuilder()
                                        .setUserId(String.valueOf(num))
                                        .setNickname("游客id"+String.valueOf(num))
                                        .build())
                                .build())
                        .setUserType(IMSContacts.UserType.TOURISTS_USER)
                        .setRet(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS)
                        .setResult(ConstType.GUEST_LOGIN_SUCCESS)
                        .build();
               return responseUser;
            }else{
                ResponseUser responseUser  = ResponseUser.newBuilder()
                        .setRet(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)
                        .setResult(ConstType.GUEST_LOGIN_FAILURE)
                        .setUserType(IMSContacts.UserType.TOURISTS_USER)
                        .build();
                return responseUser;
            }


    }

    //遊客個人設置信息保存
    public ResponseUser storageGuestUserInfo(RequestUser requestUser) {
        UserInfomation userInfomationinfo = requestUser.getGuestUser().getUserInfomation();
        StorageGuestInfoController controller = new StorageGuestInfoController();
        int num = 0;
        try {
            num = controller.insertUserInfo(userInfomationinfo);
        } catch (Exception e) {
            logger.info("storage guestInfo error");
        }
        if(num>0){
            ResponseUser responseUser = ResponseUser.newBuilder()
                    .setResult(ConstType.PERSON_SETTING_SUCCESS)
                    .setUserType(IMSContacts.UserType.TOURISTS_USER)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS)
                    .addGuestUser(GuestUser.newBuilder()
                            .setUserId(userInfomationinfo.getUserId())
                            .setUserInfomation(UserInfomation.newBuilder()
                                    .setUserId(userInfomationinfo.getUserId()).build()).build())

                    .build();
            return responseUser;
        }else{
            ResponseUser responseUser = ResponseUser.newBuilder()
                    .setResult(ConstType.PERSON_SETTING_FAILURE)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)
                    .setUserType(IMSContacts.UserType.TOURISTS_USER)
                    .addGuestUser(GuestUser.newBuilder()
                            .setUserId(userInfomationinfo.getUserId())
                            .setUserInfomation(UserInfomation.newBuilder()
                                    .setUserId(userInfomationinfo.getUserId()).build()).build())
                    .build();
            return responseUser;

        }
    }

   //获取游客個人設置信息
    public ResponseUser selectGuestUserInfo(RequestUser requestUser) {
        StorageGuestUserController usercontroller = new StorageGuestUserController();
        StorageGuestInfoController infoController = new StorageGuestInfoController();
        List<GuestUser> guestUserList = new ArrayList<>();
        GuestUser guestUser = null;
        List<GuestUserInfoPO> infoList = null;
        List<GuestUserPO> userList = null;
        ResponseUser responseUser = null;

        if(requestUser.getGuestUser().getUserId() == null || requestUser.getGuestUser().getUserId().equalsIgnoreCase("")){
            responseUser = ResponseUser.newBuilder()
                    .setUserType(IMSContacts.UserType.TOURISTS_USER)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)
                    .setResult(ConstType.INPUT_EXCEPTION)
                    .build();
            return responseUser;
        }


        if(requestUser.getArgs().equals(ConstType.SEARCH_USER)){
            userList = usercontroller.searchUser(requestUser.getGuestUser().getUserId());
            infoList = infoController.getUserInfo(Integer.parseInt(requestUser.getGuestUser().getUserId()));
            if(userList != null && infoList != null){
                for (int i=0;i<userList.size();i++){
                    if(userList.get(i).getUserId() == infoList.get(i).getUserId()){
                        guestUser = GuestUser.newBuilder()
                                .setUserId(String.valueOf(userList.get(i).getUserId()))
                                .setUserInfomation(UserInfomation.newBuilder()
                                        .setUserId(String.valueOf(infoList.get(i).getUserId()))
                                        .setNickname(infoList.get(i).getNickname())
                                        .setAvatar(infoList.get(i).getAvatar())
//                                        .setOnlineStatus(infoList.get(i).isOnlineStatus())
//                                        .setExitClean(infoList.get(i).isExitClean())
                                        .setTimerClean(infoList.get(i).getTimerClean()).build()).build();
                    }
                    guestUserList.add(guestUser);
                }
            }
        }

        if(guestUserList == null || guestUserList.size() <= 0){
            responseUser = ResponseUser.newBuilder()
                    .setUserType(IMSContacts.UserType.TOURISTS_USER)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)
                    .setResult(ConstType.QUERY_USERINFO_FAILURE)
                    .build();
        }else{
            responseUser = ResponseUser.newBuilder()
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS)
                    .setUserType(IMSContacts.UserType.TOURISTS_USER)
                    .setResult(ConstType.QUERY_USERINFO_SUCCESS)
                    .addAllGuestUser(guestUserList).build();
        }


        return responseUser;
    }

    //更改個人設置
    public ResponseUser updateGuestUserInfo(RequestUser request) {
        UserInfomation userInfomationinfo = request.getGuestUser().getUserInfomation();
        ResponseUser responseUser = null;

        if(request.getGuestUser().getUserId() == null || request.getGuestUser().getUserId().equalsIgnoreCase("")){
            responseUser = ResponseUser.newBuilder()
                    .setUserType(IMSContacts.UserType.TOURISTS_USER)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)
                    .setResult(ConstType.INPUT_EXCEPTION)
                    .build();
            return responseUser;
        }

        StorageGuestInfoController controller = new StorageGuestInfoController();
        int num = controller.updateUserInfo(userInfomationinfo);
        if(num>0){
             responseUser = ResponseUser.newBuilder()
                     .setUserType(IMSContacts.UserType.TOURISTS_USER)
                    .setResult(ConstType.PERSON_SETTING_SUCCESS)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS)
                    .build();
            return responseUser;
        }else{
           responseUser = ResponseUser.newBuilder()
                   .setUserType(IMSContacts.UserType.TOURISTS_USER)
                    .setResult(ConstType.PERSON_SETTING_FAILURE)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)
                    .build();
            return responseUser;

        }
    }

    //游客退出（删除个人及设置信息，回收号码）
    public ResponseUser LogoutGuestUser (RequestUser requestUser){
        GuestUser guestUser = requestUser.getGuestUser();
        StorageGuestUserController controller = new StorageGuestUserController();
        int num = 0;
        ResponseUser responseUser = null;
        try {
            num = controller.delete(Integer.parseInt(guestUser.getUserId()));
        } catch (Exception e) {
            logger.info("error guest login");
        }

        if(num>0){
             responseUser  = ResponseUser.newBuilder()
                    .addGuestUser(GuestUser.newBuilder()
                            .setUserId(requestUser.getGuestUser().getUserId())
                            .build())
                    .setUserType(IMSContacts.UserType.TOURISTS_USER)
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS)
                     .setResult(ConstType.GUEST_LOGOUT_SUCCESS)
                    .build();
            return responseUser;
        }else{
             responseUser  = ResponseUser.newBuilder()
                     .addGuestUser(GuestUser.newBuilder()
                             .setUserId(requestUser.getGuestUser().getUserId())
                             .build())
                    .setRet(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)
                     .setResult(ConstType.GUEST_LOGOUT_FAILURE)
                    .setUserType(IMSContacts.UserType.TOURISTS_USER)
                    .build();
            return responseUser;
        }
    }
}
