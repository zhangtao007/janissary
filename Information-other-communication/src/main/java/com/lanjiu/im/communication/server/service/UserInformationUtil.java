package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.server.ResponseUtil;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.login.client.registLoginAPI.GuestUserAPI;
import com.lanjiu.im.login.client.registLoginAPI.RegistUserAPI;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.login.*;
import org.apache.log4j.Logger;

import java.util.List;

public class UserInformationUtil {

    private final Logger logger = Logger.getLogger(UserInformationUtil.class);

    public UserInfomation guestUserInformation(int guestUserId, BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage){
        GuestUserAPI guestUserAPI = new GuestUserAPI();
        RequestUser request ;
        ResponseUser responseUser ;
        UserInfomation userInfomation = null;
        List<GuestUser> guestUserList ;
        ResponseUtil responseUtil = new ResponseUtil();

        request = RequestUser.newBuilder().setGuestUser(GuestUser.newBuilder()
                .setUserId(String.valueOf(guestUserId))
                .build())
                .build();
        responseUser = guestUserAPI.selectGuestUserInfo(request);
        guestUserList = responseUser.getGuestUserList();
        //commonUtils.isHave(list)
        CommonUtils<GuestUser> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(guestUserList)){
            userInfomation = guestUserList.get(0).getUserInfomation();
        }
        else{
            responseUtil.requestWithResponseFail(unifiedEntranceMessage);
            logger.info(ResponseStatus.RESPONSE_USER_INFORMATION_SELECT_FAILURE);
        }
        return userInfomation;
    }

    public UserInfomation registeredUserInformation(int registeredUserId, BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage){
        RegistUserAPI registeredUserAPI = new RegistUserAPI();
        RequestUser request ;
        ResponseUser responseUser ;
        UserInfomation userInfomation = null;
        List<RegisterUser> registerUserList ;
        ResponseUtil responseUtil = new ResponseUtil();

        request = RequestUser.newBuilder().setRegisterUser(RegisterUser.newBuilder()
                .setUserId(String.valueOf(registeredUserId))
                .build())
                .build();
        responseUser = registeredUserAPI.selectUserInfomation(request);
        registerUserList = responseUser.getRegisterUserList();
        //commonUtils.isHave(list)
        CommonUtils<RegisterUser> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(registerUserList)){
            userInfomation = registerUserList.get(0).getUserInfomation();
        }
        else{
            responseUtil.requestWithResponseFail(unifiedEntranceMessage);
            logger.info(ResponseStatus.RESPONSE_USER_INFORMATION_SELECT_FAILURE);
        }
        return userInfomation;
    }
}
