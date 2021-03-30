package com.lanjiu.im.netty.service;

import com.lanjiu.im.fileStorage.FileStorageUtil;
import com.lanjiu.im.friendStorage.FriendMessageUtil;
import com.lanjiu.im.friendStorage.fmClient.OffFriendMessageAPI;
import com.lanjiu.im.groupMsgStorage.GroupMessageUtil;
import com.lanjiu.im.loginClient.GuestUserAPI;
import com.lanjiu.im.loginClient.RegistUserAPI;
import com.lanjiu.im.infomatiom.InfomationUtil;
import com.lanjiu.im.util.*;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import com.lanjiu.pro.friend_msg.FriendMessage;
import com.lanjiu.pro.friend_msg.NotifyDelMsg;
import com.lanjiu.pro.friend_msg.RequestFriendMessage;
import com.lanjiu.pro.friend_msg.ResponseFriendMessage;
import com.lanjiu.pro.login.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TouristService {

    private  static final Logger logger = LoggerFactory.getLogger(TouristService.class);

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage loginTourist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        //装载grpc的proto协议
        BusinessProtocolEntities.TouristsUser touristsUser = unifiedEntranceMessage.getLoginProtocol().getTouristsUser();
        RequestUser requestUser = RequestUser.newBuilder().setUserType(ConstType.GUESTUSER)
                .setGuestUser(GuestUser.newBuilder().setPassword(head.getToken()).build())
                .build();

        GuestUserAPI guestUserAPI = new GuestUserAPI();
        ResponseUser responseUser = guestUserAPI.loginGuestUser(requestUser);


        //响应imServer
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessages.LoginProtocol loginProtocol = BusinessProtocolMessages.LoginProtocol.newBuilder()
                .setUserType(IMSContacts.UserType.TOURISTS_USER)
                .setStatusDetail(responseUser.getResult())
                .setTouristsUser(BusinessProtocolEntities.TouristsUser.newBuilder()
                        .setTemporaryId(responseUser.getGuestUserList().get(0).getUserId())
                        .setNickname(responseUser.getGuestUser(0).getUserInfomation().getNickname())
                        .build())
                .build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setDataType(unifiedEntranceMessage.getDataType())
                .setLoginProtocol(loginProtocol)
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(head.getMsgType())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setStatusReport(responseUser.getRet())
                        .setFromId(head.getFromId())
                        .setToId(head.getToId())
                        .setTimestamp(head.getTimestamp())
                        .build())
                .build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return checkUnifiedEntranceMessage;
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage guestPersonSetting(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolEntities.TouristsUser touristsUser = unifiedEntranceMessage.getPersonalSettingsProtocol().getTouristsUser();
        BusinessProtocolMessages.PersonalSettingsProtocol personalSettingsProtocol = unifiedEntranceMessage.getPersonalSettingsProtocol();
        boolean exitClean = personalSettingsProtocol.getSettings().getExitClean();
        GuestUserAPI guestUserAPI = new GuestUserAPI();
        JCRC32 jcrc32 = new JCRC32();
        RequestUser requestUser =null;
        String temp = "";


        if(head.getMsgType().equals(IMSContacts.MsgType.PERSONAL_EXIT_CLEAN_TOURISTS)){
            if(exitClean){
                temp = ConstType.ON;
            }else{
                temp = ConstType.OFF;
            }
            requestUser = RequestUser.newBuilder().setUserType(ConstType.GUESTUSER)
                    .setGuestUser(GuestUser.newBuilder()
                            .setUserId(touristsUser.getTemporaryId())
                            .setUserInfomation(UserInfomation.newBuilder()
                                    .setUserId(touristsUser.getTemporaryId())
                                    .setExitClean(temp)
                                    .setTimerClean(personalSettingsProtocol.getSettings().getTimerClean())
                                    .build())
                            .build())
                    .build();

        }



        ResponseUser  responseUser = guestUserAPI.updateGuestUserInfo(requestUser);

        //响应imServer
        BusinessProtocolMessages.PersonalSettingsProtocol personalSetting = BusinessProtocolMessages.PersonalSettingsProtocol.newBuilder()
                .setUserType(IMSContacts.UserType.TOURISTS_USER)
                .setStatusDetail(responseUser.getRet())
                .setTouristsUser(BusinessProtocolEntities.TouristsUser.newBuilder()
                        .setTemporaryId(responseUser.getGuestUserList().get(0).getUserId()).build())
               .build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setPersonalSettingsProtocol(personalSetting)
                .setDataType(unifiedEntranceMessage.getDataType())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(head.getMsgType())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setStatusReport(responseUser.getRet())
                        .build()).build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return checkUnifiedEntranceMessage;
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage guestPersonInfo(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolEntities.TouristsUser touristsUser = unifiedEntranceMessage.getPersonalInfoProtocol().getTouristsUser();
        BusinessProtocolEntities.TouristsUser newTouristUser = unifiedEntranceMessage.getPersonalInfoProtocol().getSettingsTouristsUser();
        RequestUser requestUser = RequestUser.newBuilder().setArgs(ConstType.SEARCH_USER).setUserType(ConstType.GUESTUSER)
                .setGuestUser(GuestUser.newBuilder()
                        .setUserId(touristsUser.getTemporaryId())
                        .setUserInfomation(UserInfomation.newBuilder()
                                .setUserId(touristsUser.getTemporaryId())
                                .setAvatar(newTouristUser.getAvatar())
                                .setNickname(newTouristUser.getNickname())
                                .build())
                        .build())
                .build();
        GuestUserAPI guestUserAPI = new GuestUserAPI();
        ResponseUser  responseUser = guestUserAPI.updateGuestUserInfo(requestUser);


        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessages.LoginProtocol loginProtocol = BusinessProtocolMessages.LoginProtocol.newBuilder()
                .setUserType(IMSContacts.UserType.TOURISTS_USER)
                .setStatusDetail(responseUser.getResult())
                .setTouristsUser(BusinessProtocolEntities.TouristsUser.newBuilder()
                        .setTemporaryId(touristsUser.getTemporaryId())
                        .build()).build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setDataType(unifiedEntranceMessage.getDataType())
                .setLoginProtocol(loginProtocol)
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setFromId(head.getFromId())
                        .setToId(head.getToId())
                        .setMsgType(head.getMsgType())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setStatusReport(responseUser.getRet())
                        .build())
                .build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return checkUnifiedEntranceMessage;
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage logoutTourists(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        //装载grpc的proto协议
        BusinessProtocolEntities.TouristsUser touristsUser = unifiedEntranceMessage.getLogoutProtocol().getTouristsUser();
        RequestUser requestUser = RequestUser.newBuilder().setUserType(ConstType.GUESTUSER)
                .setGuestUser(GuestUser.newBuilder()
                        .setUserId(touristsUser.getTemporaryId())
                .setPassword(head.getToken())
                        .setUserInfomation(UserInfomation.newBuilder()
                                .setUserId(touristsUser.getTemporaryId())
                                .setOnlineStatus(ConstType.OFF).build())
                        .build())
                .build();

        //删除游客个人信息
        GuestUserAPI guestUserAPI = new GuestUserAPI();
        ResponseUser responseUser = null;
        responseUser = guestUserAPI.logoutGuestUser(requestUser);
        JCRC32 jcrc32 = new JCRC32();

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    //清理游客所有信息资料(根据toId)
                    FriendMessageUtil.cleanFriendMessage(touristsUser.getTemporaryId());
                    GroupMessageUtil.cleanGroupMessage(touristsUser.getTemporaryId());
                    FileStorageUtil.cleanFile(touristsUser.getTemporaryId());
                    InfomationUtil.logoutTourist(touristsUser.getTemporaryId());
                } catch (Exception e) {
                    logger.error("异步处理注册用户退出清理错误~");
                }
            }
        });


        BusinessProtocolMessages.LogoutProtocol logoutProtocol = BusinessProtocolMessages.LogoutProtocol.newBuilder()
                .setUserType(IMSContacts.UserType.TOURISTS_USER)
                .setStatusDetail(ConstType.REGIST_LOGOUT_SUCCESS)
                .setTouristsUser(BusinessProtocolEntities.TouristsUser.newBuilder()
                        .setTemporaryId(touristsUser.getTemporaryId())
                        .build()).build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setLogoutProtocol(logoutProtocol)
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setStatusReport(responseUser.getRet())
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .build())
                    .build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return checkUnifiedEntranceMessage;

    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage findUserGuest(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        String userId = unifiedEntranceMessage.getFindUserProtocol().getSearch().getKeyword();
        RequestUser requestGuestUser = RequestUser.newBuilder().setArgs(ConstType.SEARCH_USER).setUserType(IMSContacts.UserType.TOURISTS_USER).setGuestUser(GuestUser.newBuilder()
                .setUserId(userId)
                .build()).build();

        RequestUser requestRegistUser = RequestUser.newBuilder().setArgs(ConstType.SEARCH_USER).setUserType(IMSContacts.UserType.REGISTERED_USER)
                .setRegisterUser(RegisterUser.newBuilder().setUserId(userId).build()).build();

        RegistUserAPI registUserAPI = new RegistUserAPI();
        GuestUserAPI guestUserAPI  = new GuestUserAPI();
        ResponseUser responseGuestUser  = guestUserAPI.selectGuestUserInfo(requestGuestUser);
        ResponseUser responseRegistUser = registUserAPI.selectUserInfomation(requestRegistUser);


        List<BusinessProtocolEntities.RegisteredUser> resUserList = new ArrayList<>();
        List<BusinessProtocolEntities.TouristsUser>  guesUserList = new ArrayList<>();

        BusinessProtocolMessages.FindUserProtocol findUserProtocol = null;
        if(responseGuestUser.getRet().equals(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)
            && responseRegistUser.getRet().equals(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)){
            findUserProtocol = BusinessProtocolMessages.FindUserProtocol.newBuilder()
                    .setUserType(IMSContacts.UserType.TOURISTS_USER)
                    .setStatusDetail(ResponseStatus.STATUS_REPORT_FAILURE)
                    .build();
        }

        if(responseGuestUser.getRet().equals(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS)){
            List<GuestUser> guestUserList = responseGuestUser.getGuestUserList();
            if(guestUserList.size()>0){
                for(GuestUser user : guestUserList){
                    BusinessProtocolEntities.TouristsUser guestUser = BusinessProtocolEntities.TouristsUser.newBuilder()
                            .setTemporaryId(user.getUserId())
                            .setNickname(user.getUserInfomation().getNickname())
                            .setAvatar(user.getUserInfomation().getAvatar()).build();
                    guesUserList.add(guestUser);
                }
            }
        }else if(responseRegistUser.getRet().equals(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS)){
            List<RegisterUser> registerUserList = responseRegistUser.getRegisterUserList();
            if(registerUserList.size()>0) {
                for (RegisterUser user : registerUserList) {
                    BusinessProtocolEntities.RegisteredUser tourUser = BusinessProtocolEntities.RegisteredUser.newBuilder()
                            .setUserId(user.getUserId())
                            .setNickname(user.getUserInfomation().getNickname())
                            .setAvatar(user.getUserInfomation().getAvatar()).build();
                    resUserList.add(tourUser);
                }

            }
        }


        JCRC32 jcrc32 = new JCRC32();
        findUserProtocol = BusinessProtocolMessages.FindUserProtocol.newBuilder()
                .setUserType(IMSContacts.UserType.TOURISTS_USER)
                .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                .addAllRegisteredFind(resUserList)
                .addAllTouristsFind(guesUserList).build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setFindUserProtocol(findUserProtocol)
                .setDataType(unifiedEntranceMessage.getDataType())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(head.getMsgType())
                        .setFromId(head.getFromId())
                        .setToId(head.getToId())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .build()).build();

        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return checkUnifiedEntranceMessage;

    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage changeStatusGuest(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        String userId = head.getFromId();
        boolean onlineStatus = unifiedEntranceMessage.getPersonalSettingsProtocol().getSettings().getOnlineStatus();
        System.out.println(userId+"  状态更新为: "+ onlineStatus);
        String temp ="";
        if (onlineStatus){
            temp = ConstType.ON;
        }else {
            temp =ConstType.OFF;
        }
        RequestUser requestUser = RequestUser.newBuilder().setUserType(IMSContacts.UserType.TOURISTS_USER)
                .setGuestUser(GuestUser.newBuilder()
                        .setUserId(userId)
                        .setUserInfomation(UserInfomation.newBuilder()
                                .setUserId(userId)
                                .setOnlineStatus(temp).build()).build())
                .build();

        GuestUserAPI guestUserAPI = new GuestUserAPI();
        ResponseUser responseUser = guestUserAPI.updateGuestUserInfo(requestUser);


        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessages.PersonalSettingsProtocol personalSetting = BusinessProtocolMessages.PersonalSettingsProtocol.newBuilder()
                .setUserType(IMSContacts.UserType.TOURISTS_USER)
                .setStatusDetail(responseUser.getResult())
                .setTouristsUser(BusinessProtocolEntities.TouristsUser.newBuilder()
                        .setTemporaryId(userId).build())
                .build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setDataType(unifiedEntranceMessage.getDataType())
                .setPersonalSettingsProtocol(personalSetting)
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setFromId(head.getFromId())
                        .setToId(head.getToId())
                        .setMsgType(head.getMsgType())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setStatusReport(responseUser.getRet())
                        .build()).build();

        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return checkUnifiedEntranceMessage;


    }



}
