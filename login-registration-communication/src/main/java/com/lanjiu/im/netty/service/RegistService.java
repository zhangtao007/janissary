package com.lanjiu.im.netty.service;


import com.aliyuncs.utils.StringUtils;
import com.lanjiu.im.loginClient.GuestUserAPI;
import com.lanjiu.im.loginClient.RegistUserAPI;
import com.lanjiu.im.netty.clean.QuartzManager;
import com.lanjiu.im.netty.common.AliyunSmsUtils;
import com.lanjiu.im.netty.grpc_pool.filePool.GrpcClient;
import com.lanjiu.im.netty.grpc_pool.gmsgPool.GmsgClient;
import com.lanjiu.im.netty.grpc_pool.msgPool.MsgClient;
import com.lanjiu.im.util.*;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import com.lanjiu.pro.login.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RegistService {

    private static final Logger logger = LoggerFactory.getLogger(RegistService.class);

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage userRegist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {

            //装载grpc的proto协议请求信息
        BusinessProtocolEntities.RegisteredUser registeredUser = unifiedEntranceMessage.getRegisteredUserProtocol().getRegisteredUser();
        RequestUser requestUser = RequestUser.newBuilder()
                .setUserType(ConstType.REGISTERUSER)
                .setRegisterUser(RegisterUser.newBuilder()
                        .setPhone(registeredUser.getPhone())
                        .setPassword(registeredUser.getSecret())
                .setUserInfomation(UserInfomation.newBuilder()
                        .setNickname(registeredUser.getNickname()).build())
                .build()).build();
        JCRC32 jcrc32 = new JCRC32();
        //验证码校验
        if( CommonUtil.get(registeredUser.getPhone())== null || !CommonUtil.get(registeredUser.getPhone()).equals(registeredUser.getCaptcha()) ){
            logger.error("缓存验证码："+CommonUtil.get(registeredUser.getPhone())+", 输入验证码："+registeredUser.getCaptcha());
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                    .newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setRegisteredUserProtocol(BusinessProtocolMessages.RegisteredUserProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .setNickname(registeredUser.getNickname())
                                    .setPhone(registeredUser.getPhone())
                                    .build())
                            .setStatusDetail(ConstType.VCODE_ERROR)
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(head.getMsgType())
                            .setStatusReport(ConstType.FAILURE)
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setMsgContentType(head.getMsgContentType())
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .build())
                    .build();

            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return  checkUnifiedEntranceMessage;
        }


        RegistUserAPI registUserAPI = new RegistUserAPI();
        ResponseUser responseUser = null;
        try {
            responseUser = registUserAPI.storageRegisterUser(requestUser);
        } catch (Exception e) {
            logger.error("login_storage,用户注册异常");
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                    .newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setRegisteredUserProtocol(BusinessProtocolMessages.RegisteredUserProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .setNickname(registeredUser.getNickname())
                                    .setPhone(registeredUser.getPhone())
                                    .build())
                            .setStatusDetail(ConstType.REGIST_FAILURE)
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(head.getMsgType())
                            .setStatusReport(ConstType.FAILURE)
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setMsgContentType(head.getMsgContentType())
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .build())
                    .build();

            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return  checkUnifiedEntranceMessage;
        }

        if(responseUser.getRet().equalsIgnoreCase(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)){
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                    .newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setRegisteredUserProtocol(BusinessProtocolMessages.RegisteredUserProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .setNickname(registeredUser.getNickname())
                                    .setPhone(registeredUser.getPhone())
                                    .build())
                            .setStatusDetail(responseUser.getResult())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(head.getMsgType())
                            .setStatusReport(ConstType.FAILURE)
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setMsgContentType(head.getMsgContentType())
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .build())
                    .build();

            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return  checkUnifiedEntranceMessage;
        }

        String userId = responseUser.getRegisterUserList().get(0).getUserId();
        String cron = "0 0 3 * * ?"; //默认每天的3点执行清理
        QuartzManager.addJob(userId,userId,cron,userId);


        //返回响应IMserver

        BusinessProtocolEntities.RegisteredUser registeredUserRes = BusinessProtocolEntities.RegisteredUser.newBuilder()
                .setUserId(responseUser.getRegisterUserList().get(0).getUserId())
                .setNickname(registeredUser.getNickname())
                .setPhone(registeredUser.getPhone())
                .build();
        BusinessProtocolMessages.RegisteredUserProtocol registeredUserProtocol = BusinessProtocolMessages.RegisteredUserProtocol.newBuilder()
                .setRegisteredUser(registeredUserRes)
                .setStatusDetail(responseUser.getResult())
                .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                .newBuilder()
                .setDataType(unifiedEntranceMessage.getDataType())
                .setRegisteredUserProtocol(registeredUserProtocol)
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(head.getMsgType())
                        .setStatusReport(responseUser.getRet())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setMsgContentType(head.getMsgContentType())
                        .setFromId(head.getFromId())
                        .setToId(head.getToId())
                        .build())
                .build();

        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return  checkUnifiedEntranceMessage;


    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage loginRegistered(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolEntities.RegisteredUser registeredUser = unifiedEntranceMessage.getLoginProtocol().getRegisteredUser();
        String secret = registeredUser.getSecret();
        String userId = registeredUser.getUserId();
        String regs ="^\\d{8}\\b$";
        JCRC32 jcrc32 = new JCRC32();

        if(!userId.matches(regs)){
            logger.error("id格式检验失败,id:"+userId);
            BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setLoginProtocol(BusinessProtocolMessages.LoginProtocol.newBuilder()
                            .setStatusDetail(ConstType.USER_ID_ERROR).build())
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)
                            .build()).build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return checkUnifiedEntranceMessage;
        }
        RequestUser requestUser = RequestUser.newBuilder()
                .setArgs(ConstType.SEARCH_USER)
                .setUserType(IMSContacts.UserType.REGISTERED_USER)
                .setRegisterUser(RegisterUser.newBuilder()
                .setUserId(registeredUser.getUserId())
                .setPassword(registeredUser.getSecret())
                        .setUserInfomation(UserInfomation.newBuilder()
                                .setUserId(registeredUser.getUserId()).build())
                .build()).build();

        BusinessProtocolMessages.LoginProtocol loginProtocol = null;
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage =null;
        RegistUserAPI registUserAPI = new RegistUserAPI();
        ResponseUser singleLogin = null;
        try {
            singleLogin = registUserAPI.selectUserInfomation(requestUser);
        } catch (Exception e) {
            logger.error("login_server,userId:{},登录异常",userId);
            BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setLoginProtocol(BusinessProtocolMessages.LoginProtocol.newBuilder()
                            .setStatusDetail(ConstType.USER_ID_ERROR).build())
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)
                            .build()).build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkMessage = jcrc32.packageCheckSum(message);
            return checkMessage;
        }
        if(singleLogin.getRet().equalsIgnoreCase(ConstType.FAILURE)){
            logger.error("login执行数据库查询返回失败,id:"+userId);
            BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setLoginProtocol(BusinessProtocolMessages.LoginProtocol.newBuilder()
                            .setStatusDetail(ConstType.USER_ID_ERROR).build())
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)
                            .build()).build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkMessage = jcrc32.packageCheckSum(message);
            return checkMessage;
        }
        String password = singleLogin.getRegisterUser(0).getPassword();
        String status = singleLogin.getRegisterUserList().get(0).getUserInfomation().getOnlineStatus();
        if(secret ==null || !secret.equals(password)){
            loginProtocol  = BusinessProtocolMessages.LoginProtocol.newBuilder()
                    .setStatusDetail(ConstType.PASSWORD_ERROR)
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                            .setUserId(registeredUser.getUserId())
                            .build()).build();

            BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setLoginProtocol(loginProtocol)
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setTimestamp(head.getTimestamp())
                            .build())
                    .build();

            checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return checkUnifiedEntranceMessage;
        }

        loginProtocol  = BusinessProtocolMessages.LoginProtocol.newBuilder()
                .setStatusDetail(ConstType.REGIST_LOGIN_SUCCESS)
                .setUserType(IMSContacts.UserType.REGISTERED_USER)
                .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                        .setUserId(registeredUser.getUserId())
                        .setNickname(singleLogin.getRegisterUserList().get(0).getUserInfomation().getNickname())
                        .setPhone(singleLogin.getRegisterUserList().get(0).getPhone())
                        .setAvatar(singleLogin.getRegisterUserList().get(0).getUserInfomation().getAvatar())
                        .build()).build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setLoginProtocol(loginProtocol)
                .setDataType(unifiedEntranceMessage.getDataType())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(head.getMsgType())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .setFromId(head.getFromId())
                        .setToId(head.getToId())
                        .setTimestamp(head.getTimestamp())
                        .build())
                .build();

         checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return checkUnifiedEntranceMessage;
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage logoutRegist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolEntities.RegisteredUser registeredUser = unifiedEntranceMessage.getLogoutProtocol().getRegisteredUser();
        String userId = registeredUser.getUserId();
        RequestUser requestUser = RequestUser.newBuilder().setUserType(ConstType.REGISTERUSER)
                .setArgs(ConstType.SEARCH_USER)
                .setRegisterUser(RegisterUser.newBuilder()
                .setUserId(registeredUser.getUserId())
                .setUserInfomation(UserInfomation.newBuilder()
                        .setUserId(registeredUser.getUserId())
                        .setOnlineStatus(ConstType.OUT).build())
                .setPassword(registeredUser.getSecret()).build()).build();

        JCRC32 jcrc32 = new JCRC32();
        RegistUserAPI registUserAPI = new RegistUserAPI();
        ResponseUser responseUser=null;
        try {
            responseUser = registUserAPI.logoutRegistUser(requestUser);
        } catch (Exception e) {
            logger.error("login_server,userId:{},退出异常1",userId);
            BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setLogoutProtocol( BusinessProtocolMessages.LogoutProtocol.newBuilder()
                            .setUserType(IMSContacts.UserType.REGISTERED_USER)
                            .setStatusDetail(ConstType.REGIST_LOGOUT_FAILURE)
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .setUserId(registeredUser.getUserId())
                            ).build())
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(head.getMsgType())
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)
                            .build()).build();

            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return checkUnifiedEntranceMessage;
        }

        //todo 拆分退出清理和文件服务
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {

                    //判断是否设置退出清理
               ResponseUser cresponse = null;
               try {
                   cresponse = registUserAPI.selectUserInfomation(requestUser);
               } catch (Exception e) {
                   logger.error("login_server,userId:{},退出清理时查询用户设置异常1,e:{}",userId,e);
                   return;
               }
               String exitClean = cresponse.getRegisterUser(0).getUserInfomation().getExitClean();
               if(exitClean.equalsIgnoreCase(ConstType.ON)){
                   String userId = registeredUser.getUserId();
                   logger.info("执行*退出*清理的用户："+userId);
//                   FriendMessageUtil.cleanFriendMessage(registeredUser.getUserId());
//                   GroupMessageUtil.cleanGroupMessage(registeredUser.getUserId());
//                   FileStorageUtil.cleanFile(registeredUser.getUserId());
                   GrpcClient.call("cleanfilesBytime",userId);
                   MsgClient.call("cleanMsg",userId);
                   GmsgClient.call("cleanGmsg",userId);
               }


            }
        });


        BusinessProtocolMessages.LogoutProtocol logoutProtocol = BusinessProtocolMessages.LogoutProtocol.newBuilder()
                .setUserType(IMSContacts.UserType.REGISTERED_USER)
                .setStatusDetail(responseUser.getResult())
                .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                        .setUserId(registeredUser.getUserId())
                ).build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setLogoutProtocol(logoutProtocol)
                .setDataType(unifiedEntranceMessage.getDataType())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(head.getMsgType())
                        .setFromId(head.getFromId())
                        .setToId(head.getToId())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setStatusReport(responseUser.getRet())
                        .build()).build();

        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return checkUnifiedEntranceMessage;

    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage registPersonSetting(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolEntities.RegisteredUser registeredUser = unifiedEntranceMessage.getPersonalSettingsProtocol().getRegisteredUser();
        BusinessProtocolMessages.PersonalSettingsProtocol personalSettingsProtocol = unifiedEntranceMessage.getPersonalSettingsProtocol();
        boolean exitClean = personalSettingsProtocol.getSettings().getExitClean();
        RequestUser requestUser = null;
        String temp ="";
        String userId = registeredUser.getUserId();

        //查询个人信息
        if (head.getMsgType().equals(IMSContacts.MsgType.USER_INFOMATION)){
           return getUserInformation(unifiedEntranceMessage);
        }
        //设置退出清理
        if(head.getMsgType().equals(IMSContacts.MsgType.PERSONAL_EXIT_CLEAN_REGISTERED)){
            if(exitClean){
                temp = ConstType.ON;
            }else{
                temp = ConstType.OFF;
            }
            requestUser = RequestUser.newBuilder().setUserType(ConstType.REGISTERUSER)
                    .setRegisterUser(RegisterUser.newBuilder()
                    .setUserId(registeredUser.getUserId())
                    .setUserInfomation(UserInfomation.newBuilder()
                            .setUserId(registeredUser.getUserId())
                            .setExitClean(temp)
                            .build()).build()).build();
        }

        if(head.getMsgType().equals(IMSContacts.MsgType.PERSONAL_TIMER_CLEAN_REGISTERED)){
            requestUser = RequestUser.newBuilder().setUserType(ConstType.REGISTERUSER)
                    .setRegisterUser(RegisterUser.newBuilder()
                    .setUserId(registeredUser.getUserId())
                    .setUserInfomation(UserInfomation.newBuilder()
                            .setUserId(registeredUser.getUserId())
                            .setTimerClean(personalSettingsProtocol.getSettings().getTimerClean())
                            .build()).build()).build();

            // 修改定期清理周期
            int timeClean = personalSettingsProtocol.getSettings().getTimerClean();
            String cron ="0 0 5 L * ?";
            if(timeClean == 1){
                cron ="0 0 3 * * ?";  //默认每天的3点执行清理
            }else if(timeClean == 2){
//                cron = "0 0 4 1/7 * ?";  //每隔7天的4点执行清理
                cron = "0 0 4 ? * L";    //每周六的4点清理一次
            }else if(timeClean == 3){
//                cron ="0 */3 * * * ?";
                cron = "0 0 5 L * ?";  //每月最后一天5点执行清理
            }
//            QuartzManager.modifyJobExpression(userId,cron);
            QuartzManager.removeJob(userId,userId);
            QuartzManager.addJob(userId,userId,cron,userId);

        }


        RegistUserAPI registUserAPI = new RegistUserAPI();
        JCRC32 jcrc32 = new JCRC32();
        ResponseUser responseUser = null;
        try {
            responseUser = registUserAPI.updateUserInfomation(requestUser);
        } catch (Exception e) {
            logger.error("用户  userId:{},个人设置异常",userId);
            BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setPersonalSettingsProtocol( BusinessProtocolMessages.PersonalSettingsProtocol.newBuilder()
                            .setUserType(IMSContacts.UserType.REGISTERED_USER)
                            .setStatusDetail(ConstType.PERSON_SETTING_FAILURE)
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .setUserId(registeredUser.getUserId()))
                            .build())
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_EXCEPTION)
                            .build()).build();

            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return checkUnifiedEntranceMessage;
        }

        BusinessProtocolMessages.PersonalSettingsProtocol personalSetting = BusinessProtocolMessages.PersonalSettingsProtocol.newBuilder()
                .setUserType(IMSContacts.UserType.REGISTERED_USER)
                .setStatusDetail(responseUser.getRet())
                .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                        .setUserId(registeredUser.getUserId()))
                .build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setPersonalSettingsProtocol(personalSetting)
                .setDataType(unifiedEntranceMessage.getDataType())
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

    private BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage getUserInformation(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage) {
        BusinessProtocolMessageStandard.Head head =unifiedEntranceMessage.getHead();
        BusinessProtocolEntities.RegisteredUser registeredUser = unifiedEntranceMessage.getPersonalSettingsProtocol().getRegisteredUser();
        String userId = registeredUser.getUserId();
        RequestUser requestUser  = RequestUser.newBuilder().setArgs(ConstType.SEARCH_USER)
                .setRegisterUser(RegisterUser.newBuilder().setUserId(userId).setUserInfomation(UserInfomation.newBuilder().setUserId(userId).build())
                        .build())
                .build();
        RegistUserAPI registUserAPI = new RegistUserAPI();
        JCRC32 jcrc32 = new JCRC32();
        ResponseUser responseUser =null;
        try {
             responseUser = registUserAPI.selectUserInfomation(requestUser);
        } catch (Exception e) {
            BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setPersonalSettingsProtocol( BusinessProtocolMessages.PersonalSettingsProtocol.newBuilder()
                            .setUserType(IMSContacts.UserType.REGISTERED_USER)
                            .setStatusDetail(ConstType.PERSON_SETTING_FAILURE)
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .setUserId(registeredUser.getUserId()))
                            .build())
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_EXCEPTION)
                            .build()).build();

            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return checkUnifiedEntranceMessage;
        }
        if(responseUser.getRet().equals(ResponseStatus.STATUS_REPORT_FAILURE)){
            logger.error("login_storage 查询个人信息接口异常"+requestUser.toString());
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)
                            .build()).build());
            return checkUnifiedEntranceMessage;
        }
        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setPersonalSettingsProtocol( BusinessProtocolMessages.PersonalSettingsProtocol.newBuilder()
                        .setUserType(IMSContacts.UserType.REGISTERED_USER)
                        .setStatusDetail(ConstType.PERSON_SETTING_SUCCESS)
                        .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                .setUserId(registeredUser.getUserId())
                                 .setPhone(responseUser.getRegisterUser(0).getPhone())
                                  .setSecret(responseUser.getRegisterUser(0).getPassword())
                                 .setNickname(responseUser.getRegisterUser(0).getUserInfomation().getNickname())
                                 .setAvatar(responseUser.getRegisterUser(0).getUserInfomation().getAvatar()))
                        .setSettings(BusinessProtocolEntities.Settings.newBuilder()
                                .setExitClean(responseUser.getRegisterUser(0).getUserInfomation().getExitClean().equalsIgnoreCase(ConstType.OFF) ? false : true)
                                .setTimerClean(responseUser.getRegisterUser(0).getUserInfomation().getTimerClean())
                                .build())
                        .build())
                .setDataType(unifiedEntranceMessage.getDataType())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setFromId(head.getFromId())
                        .setToId(head.getToId())
                        .setMsgType(head.getMsgType())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .build()).build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return checkUnifiedEntranceMessage;
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage registPersonInfo(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolEntities.RegisteredUser registeredUser = unifiedEntranceMessage.getPersonalInfoProtocol().getRegisteredUser();
        BusinessProtocolEntities.RegisteredUser newRegistUser = unifiedEntranceMessage.getPersonalInfoProtocol().getSettingsRegisteredUser();
        RegistUserAPI registUserAPI = new RegistUserAPI();
        JCRC32 jcrc32 = new JCRC32();
        ResponseUser responseUser = null;
        String userId = newRegistUser.getUserId();


        //一、修改密码
       if(head.getMsgType().equalsIgnoreCase(IMSContacts.MsgType.RESET_SECRET)){

           RequestUser request = RequestUser.newBuilder()
                   .setArgs(ConstType.USER_SET)
                   .setUserType(ConstType.REGISTERUSER)
                   .setRegisterUser(RegisterUser.newBuilder()
                           .setUserId(newRegistUser.getUserId())
                           .setPassword(newRegistUser.getSecret())
                           .build()).build();

           try {
               responseUser = registUserAPI.updateUserInfomation(request);
           } catch (Exception e) {
              logger.error("userId:{},个人信息更新(修改密码)异常",userId);
              logger.error("info:"+e.getMessage());
               BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                       .setPersonalInfoProtocol( BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                               .setUserType(IMSContacts.UserType.REGISTERED_USER)
                               .setStatusDetail(ConstType.EXCEPTION)
                               .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                       .setUserId(registeredUser.getUserId())
                               ).build())
                       .setDataType(unifiedEntranceMessage.getDataType())
                       .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                               .setFromId(head.getFromId())
                               .setToId(head.getToId())
                               .setMsgType(head.getMsgType())
                               .setToken(head.getToken())
                               .setUniqueIdentify(head.getUniqueIdentify())
                               .setStatusReport(ResponseStatus.STATUS_REPORT_EXCEPTION)
                               .build()).build();

               BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
               return checkUnifiedEntranceMessage;
           }


           BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                   .setPersonalInfoProtocol(BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                           .setUserType(IMSContacts.UserType.REGISTERED_USER)
                           .setStatusDetail(responseUser.getResult())
                           .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                   .setUserId(registeredUser.getUserId())
                           ).build())
                   .setDataType(unifiedEntranceMessage.getDataType())
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

       //二、忘记密码
       if(head.getMsgType().equalsIgnoreCase(IMSContacts.MsgType.RESET_SECRET_VERIFY)){
           String phone = newRegistUser.getPhone();
//           String password = newRegistUser.getSecret();
           String vCode = newRegistUser.getCaptcha();
           String regs ="^\\d{8}\\b$";
           String number = (String) CommonUtil.get(phone);
           if(number==null || !userId.matches(regs) || !number.equals(vCode)){
               BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                       .setPersonalInfoProtocol(  BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                               .setUserType(IMSContacts.UserType.REGISTERED_USER)
                               .setStatusDetail(ConstType.VCODE_ID_ERROR)
                               .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                       .setUserId(newRegistUser.getUserId())
                               ).build())
                       .setDataType(unifiedEntranceMessage.getDataType())
                       .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                               .setFromId(head.getFromId())
                               .setToId(head.getToId())
                               .setMsgType(head.getMsgType())
                               .setToken(head.getToken())
                               .setUniqueIdentify(head.getUniqueIdentify())
                               .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)
                               .build()).build();

               BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
               return checkUnifiedEntranceMessage;
           }

           RequestUser request = RequestUser.newBuilder()
                   .setArgs(ConstType.SEARCH_USER)
                   .setUserType(ConstType.REGISTERUSER)
                   .setRegisterUser(RegisterUser.newBuilder()
                           .setUserId(newRegistUser.getUserId())
                           .build()).build();

           try {
               responseUser = registUserAPI.selectUserInfomation(request);
           } catch (Exception e) {
               logger.error("用户  userId:{},个人信息更新(忘记密码)异常",userId);
               BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                       .setPersonalInfoProtocol(BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                               .setUserType(IMSContacts.UserType.REGISTERED_USER)
                               .setStatusDetail(ConstType.NET_BUSINISS)
                               .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                       .setUserId(newRegistUser.getUserId())
                               ).build())
                       .setDataType(unifiedEntranceMessage.getDataType())
                       .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                               .setFromId(head.getFromId())
                               .setToId(head.getToId())
                               .setMsgType(head.getMsgType())
                               .setToken(head.getToken())
                               .setUniqueIdentify(head.getUniqueIdentify())
                               .setStatusReport(ResponseStatus.STATUS_REPORT_EXCEPTION)
                               .build()).build();

               BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
               return checkUnifiedEntranceMessage;
           }

           if (responseUser.getRet().equalsIgnoreCase(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)){
               BusinessProtocolMessageStandard .UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                       .setPersonalInfoProtocol(BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                               .setUserType(IMSContacts.UserType.REGISTERED_USER)
                               .setStatusDetail(ConstType.USER_ID_ERROR)
                               .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                       .setUserId(newRegistUser.getUserId())
                               ).build())
                       .setDataType(unifiedEntranceMessage.getDataType())
                       .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                               .setFromId(head.getFromId())
                               .setToId(head.getToId())
                               .setMsgType(head.getMsgType())
                               .setToken(head.getToken())
                               .setUniqueIdentify(head.getUniqueIdentify())
                               .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)
                               .build()).build();

               BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
               return checkUnifiedEntranceMessage;
           }


           if((responseUser.getRegisterUser(0).getPhone().equals(phone)) && (number.equals(vCode))){
                //手机和验证码都正确
               BusinessProtocolMessageStandard .UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                       .setPersonalInfoProtocol(BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                               .setUserType(IMSContacts.UserType.REGISTERED_USER)
                               .setStatusDetail(ConstType.PHONE_VCODE_OK)
                               .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                       .setUserId(newRegistUser.getUserId())
                               ).build())
                       .setDataType(unifiedEntranceMessage.getDataType())
                       .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                               .setFromId(head.getFromId())
                               .setToId(head.getToId())
                               .setMsgType(head.getMsgType())
                               .setToken(head.getToken())
                               .setUniqueIdentify(head.getUniqueIdentify())
                               .setStatusReport(responseUser.getRet())
                               .build()).build();
                CommonUtil.remove(phone);
               BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
               return checkUnifiedEntranceMessage;
           }else{
               //手机或验证码错误
               BusinessProtocolMessageStandard .UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                       .setPersonalInfoProtocol(BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                               .setUserType(IMSContacts.UserType.REGISTERED_USER)
                               .setStatusDetail(ConstType.VCODE_ID_ERROR)
                               .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                       .setUserId(newRegistUser.getUserId())
                               ).build())
                       .setDataType(unifiedEntranceMessage.getDataType())
                       .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                               .setFromId(head.getFromId())
                               .setToId(head.getToId())
                               .setMsgType(head.getMsgType())
                               .setToken(head.getToken())
                               .setUniqueIdentify(head.getUniqueIdentify())
                               .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)
                               .build()).build();

               BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
               return checkUnifiedEntranceMessage;
           }

       }
       //三、修改头像/昵称
        RequestUser requestUser = RequestUser.newBuilder()
                .setUserType(ConstType.REGISTERUSER)
                .setArgs(ConstType.SEARCH_USER)
                .setRegisterUser(RegisterUser.newBuilder()
                .setUserId(registeredUser.getUserId())
                        .setPhone(newRegistUser.getPhone())
                .setUserInfomation(UserInfomation.newBuilder()
                        .setUserId(registeredUser.getUserId())
                        .setAvatar(newRegistUser.getAvatar())
                        .setNickname(newRegistUser.getNickname())
                        .build()).build()).build();

        try {
            responseUser = registUserAPI.updateUserInfomation(requestUser);
        } catch (Exception e) {
            logger.error("userId:{},个人信息(头像/昵称)更新异常",userId);
            logger.error("info:"+e.getMessage());
            BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setPersonalInfoProtocol( BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                            .setUserType(IMSContacts.UserType.REGISTERED_USER)
                            .setStatusDetail(ConstType.EXCEPTION)
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .setUserId(registeredUser.getUserId())
                            ).build())
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_EXCEPTION)
                            .build()).build();

            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return checkUnifiedEntranceMessage;
        }


        BusinessProtocolMessages.PersonalInfoProtocol personalInfo = BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                .setUserType(IMSContacts.UserType.REGISTERED_USER)
                .setStatusDetail(responseUser.getResult())
                .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                        .setUserId(registeredUser.getUserId())
                ).build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setPersonalInfoProtocol(personalInfo)
                .setDataType(unifiedEntranceMessage.getDataType())
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

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage findUserRegist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        String userID =  unifiedEntranceMessage.getFindUserProtocol().getSearch().getKeyword();
        RegistUserAPI registUserAPI = new RegistUserAPI();
        GuestUserAPI guestUserAPI  = new GuestUserAPI();
        List<BusinessProtocolEntities.RegisteredUser> resUserList = new ArrayList<>();
        List<BusinessProtocolEntities.TouristsUser>  guesUserList = new ArrayList<>();
        BusinessProtocolMessages.FindUserProtocol findUserProtocol = null;
        RequestUser requestUser = null;
        ResponseUser responseRegistUser =null;
        ResponseUser responseGuestUser =null;
        String regs ="^\\d{8}\\b$";
        JCRC32 jcrc32 = new JCRC32();

        if(!userID.matches(regs)){
            BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setFindUserProtocol( BusinessProtocolMessages.FindUserProtocol.newBuilder()
                            .setUserType(IMSContacts.UserType.REGISTERED_USER)
                            .setStatusDetail(ResponseStatus.INPUT_ERROR_FIND_USER)
                            .build())
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)
                            .build()).build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return checkUnifiedEntranceMessage;
        }
//        if(Integer.parseInt(userID)<70000000){
            requestUser = RequestUser.newBuilder().setArgs(ConstType.SEARCH_USER).setUserType(IMSContacts.UserType.REGISTERED_USER).setRegisterUser(RegisterUser.newBuilder()
                    .setUserId(userID).build())
                    .build();
            try {
                responseRegistUser =registUserAPI.selectUserInfomation(requestUser);
            } catch (Exception e) {
                logger.error("搜索用户 userID:{},时查询异常",userID);
                logger.error("info:"+e.getMessage());
                BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                        .setFindUserProtocol(BusinessProtocolMessages.FindUserProtocol.newBuilder()
                                .setUserType(IMSContacts.UserType.REGISTERED_USER)
                                .setStatusDetail(ConstType.EXCEPTION)
                                .addAllRegisteredFind(resUserList)
                                .addAllTouristsFind(guesUserList).build())
                        .setDataType(unifiedEntranceMessage.getDataType())
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                .setMsgType(head.getMsgType())
                                .setToken(head.getToken())
                                .setFromId(head.getFromId())
                                .setToId(head.getToId())
                                .setUniqueIdentify(head.getUniqueIdentify())
                                .setStatusReport(ResponseStatus.STATUS_REPORT_EXCEPTION)
                                .build()).build();
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
                return checkUnifiedEntranceMessage;
            }
            if(responseRegistUser.getRet().equals(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS)){
                List<RegisterUser> registerUserList = responseRegistUser.getRegisterUserList();
                if(registerUserList.size()>0) {
                    for (RegisterUser user : registerUserList) {
                        BusinessProtocolEntities.RegisteredUser resUser = BusinessProtocolEntities.RegisteredUser.newBuilder()
                                .setUserId(user.getUserId())
                                .setNickname(user.getUserInfomation().getNickname())
                                .setAvatar(user.getUserInfomation().getAvatar()).build();
                        resUserList.add(resUser);
                    }
                }

                findUserProtocol = BusinessProtocolMessages.FindUserProtocol.newBuilder()
                        .setUserType(IMSContacts.UserType.REGISTERED_USER)
                        .setStatusDetail(ConstType.QUERY_USERINFO_SUCCESS)
                        .addAllRegisteredFind(resUserList)
                        .addAllTouristsFind(guesUserList)
                        .build();

            } else if((responseRegistUser.getRet().equals(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE))){

                findUserProtocol = BusinessProtocolMessages.FindUserProtocol.newBuilder()
                        .setUserType(IMSContacts.UserType.REGISTERED_USER)
                        .setStatusDetail(ConstType.QUERY_USERINFO_FAILURE)
                        .build();
            }

//        }else{
//            requestUser = RequestUser.newBuilder().setArgs(ConstType.SEARCH_USER).setUserType(IMSContacts.UserType.TOURISTS_USER).setGuestUser(GuestUser.newBuilder()
//                    .setUserId(userID).build())
//                    .build();
//            responseGuestUser =guestUserAPI.selectGuestUserInfo(requestUser);
//            if(responseGuestUser.getRet().equals(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS)){
//                List<GuestUser> guestUserList = responseGuestUser.getGuestUserList();
//                if(guestUserList.size()>0){
//                    for(GuestUser user : guestUserList){
//                        BusinessProtocolEntities.TouristsUser guestUser = BusinessProtocolEntities.TouristsUser.newBuilder()
//                                .setTemporaryId(user.getUserId())
//                                .setNickname(user.getUserInfomation().getNickname())
//                                .setAvatar(user.getUserInfomation().getAvatar()).build();
//                        guesUserList.add(guestUser);
//                    }
//                }
//            }
//        }


        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setFindUserProtocol(findUserProtocol)
                .setDataType(unifiedEntranceMessage.getDataType())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(head.getMsgType())
                        .setToken(head.getToken())
                        .setFromId(head.getFromId())
                        .setToId(head.getToId())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .build()).build();

        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return checkUnifiedEntranceMessage;


    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage changeStatusRegist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        String userId = head.getFromId();
        boolean onlineStatus = unifiedEntranceMessage.getPersonalSettingsProtocol().getSettings().getOnlineStatus();
        JCRC32 jcrc32 = new JCRC32();
        String status = "";
        if (onlineStatus){
            status = ConstType.ON;
        }else {
            status = ConstType.OFF;
        }
        RequestUser requestUser = RequestUser.newBuilder().setArgs(ConstType.SEARCH_USER).setUserType(IMSContacts.UserType.REGISTERED_USER)
                .setRegisterUser(RegisterUser.newBuilder()
                        .setUserId(userId)
                        .setUserInfomation(UserInfomation.newBuilder()
                                .setUserId(userId)
                                .setOnlineStatus(status).build()).build())
                .build();

        RegistUserAPI registUserAPI = new RegistUserAPI();
        ResponseUser response = null;
        try {
            response = registUserAPI.selectUserInfomation(requestUser);
        } catch (Exception e) {
            logger.error("用户 userId:{},IM更改状态时查询异常",userId);
            BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setPersonalSettingsProtocol(BusinessProtocolMessages.PersonalSettingsProtocol.newBuilder()
                            .setUserType(IMSContacts.UserType.REGISTERED_USER)
                            .setStatusDetail(ConstType.EXCEPTION)
                            .build())
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_EXCEPTION)
                            .build()).build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return checkUnifiedEntranceMessage;
        }
        if( response.getRet().equalsIgnoreCase(ConstType.FAILURE) || response.getRegisterUserList().size()<=0 ){
            BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_EXCEPTION)
                            .build()).build();

            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return checkUnifiedEntranceMessage;
        }
        if(!onlineStatus && response.getRegisterUser(0).getUserInfomation().getOnlineStatus().equalsIgnoreCase(ConstType.OUT)){
            BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setPersonalSettingsProtocol(BusinessProtocolMessages.PersonalSettingsProtocol.newBuilder()
                            .setUserType(IMSContacts.UserType.REGISTERED_USER)
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .setUserId(userId))
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_EXCEPTION)
                            .build()).build();

            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return checkUnifiedEntranceMessage;
        }
        ResponseUser responseUser = null;
        try {
            responseUser = registUserAPI.updateUserInfomation(requestUser);
        } catch (Exception e) {
            logger.error("用户 userId:{},更改状态时更新异常,",userId);
            logger.error("statck:",e.fillInStackTrace());
            BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setPersonalSettingsProtocol(BusinessProtocolMessages.PersonalSettingsProtocol.newBuilder()
                            .setUserType(IMSContacts.UserType.REGISTERED_USER)
                            .setStatusDetail(ConstType.EXCEPTION)
                            .build())
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_EXCEPTION)
                            .build()).build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return checkUnifiedEntranceMessage;
        }

        BusinessProtocolMessages.PersonalSettingsProtocol personalSetting = BusinessProtocolMessages.PersonalSettingsProtocol.newBuilder()
                .setUserType(IMSContacts.UserType.REGISTERED_USER)
                .setStatusDetail(responseUser.getResult())
                .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                        .setUserId(userId))
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

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage setPhone(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolEntities.RegisteredUser registeredUser = unifiedEntranceMessage.getPersonalInfoProtocol().getRegisteredUser();
        BusinessProtocolEntities.RegisteredUser newRegistUser = unifiedEntranceMessage.getPersonalInfoProtocol().getSettingsRegisteredUser();
        RegistUserAPI registUserAPI = new RegistUserAPI();
        String userId = registeredUser.getUserId();
        JCRC32 jcrc32 = new JCRC32();
        ResponseUser responseUser = null;

        //设置手机
        if(head.getMsgType().equalsIgnoreCase(IMSContacts.MsgType.SETUP_PHONE)){
            //判断验证码
            String vCode = (String) CommonUtil.get(newRegistUser.getPhone());
            if(vCode == null || !vCode.equalsIgnoreCase(newRegistUser.getCaptcha())){
                BusinessProtocolMessages.PersonalInfoProtocol personalInfo = BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                        .setUserType(IMSContacts.UserType.REGISTERED_USER)
                        .setStatusDetail(ConstType.VCODE_ERROR)
                        .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                .setUserId(registeredUser.getUserId())
                        ).build();
                BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                        .setPersonalInfoProtocol(personalInfo)
                        .setDataType(unifiedEntranceMessage.getDataType())
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                .setFromId(head.getFromId())
                                .setToId(head.getToId())
                                .setMsgType(head.getMsgType())
                                .setToken(head.getToken())
                                .setUniqueIdentify(head.getUniqueIdentify())
                                .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)
                                .build()).build();

                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
                return checkUnifiedEntranceMessage;
            }

            if(vCode.equalsIgnoreCase(newRegistUser.getCaptcha())){
                CommonUtil.remove(newRegistUser.getPhone());
                RequestUser request = RequestUser.newBuilder()
                        .setArgs(ConstType.USER_SET)
                        .setUserType(ConstType.REGISTERUSER)
                        .setRegisterUser(RegisterUser.newBuilder()
                                .setUserId(newRegistUser.getUserId())
                                .setPhone(newRegistUser.getPhone())
                                .build()).build();
                try {
                    responseUser = registUserAPI.updateUserInfomation(request);
                } catch (Exception e) {
                    logger.error("用户 userId:{},设置手机号时更新异常",userId);
                    BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                            .setPersonalInfoProtocol(BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                                    .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                            .setUserId(userId).build())
                                    .setStatusDetail(ConstType.EXCEPTION)
                                    .build())
                            .setDataType(unifiedEntranceMessage.getDataType())
                            .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                    .setMsgType(head.getMsgType())
                                    .setToken(head.getToken())
                                    .setFromId(head.getFromId())
                                    .setToId(head.getToId())
                                    .setUniqueIdentify(head.getUniqueIdentify())
                                    .setStatusReport(ResponseStatus.STATUS_REPORT_EXCEPTION)
                                    .build()).build();
                    BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
                    return checkUnifiedEntranceMessage;
                }

                BusinessProtocolMessages.PersonalInfoProtocol personalInfo = BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                        .setUserType(IMSContacts.UserType.REGISTERED_USER)
                        .setStatusDetail(responseUser.getResult())
                        .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                .setUserId(registeredUser.getUserId())
                                .setPhone(newRegistUser.getPhone())
                        ).build();

                BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                        .setPersonalInfoProtocol(personalInfo)
                        .setDataType(unifiedEntranceMessage.getDataType())
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

        }else if(head.getMsgType().equalsIgnoreCase(IMSContacts.MsgType.SETUP_PHONE_EDIT)){
            //判断验证码
            String new_vCode = (String) CommonUtil.get(newRegistUser.getPhone());
            String old_vCode = (String) CommonUtil.get(registeredUser.getPhone());
            if(new_vCode==null || old_vCode==null){
                BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                        .setPersonalInfoProtocol(BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                                .setUserType(IMSContacts.UserType.REGISTERED_USER)
                                .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                        .setUserId(userId).build())
                                .setStatusDetail(ConstType.EXCEPTION)
                                .build())
                        .setDataType(unifiedEntranceMessage.getDataType())
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                .setMsgType(head.getMsgType())
                                .setToken(head.getToken())
                                .setFromId(head.getFromId())
                                .setToId(head.getToId())
                                .setUniqueIdentify(head.getUniqueIdentify())
                                .setStatusReport(ResponseStatus.STATUS_REPORT_EXCEPTION)
                                .build()).build();
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
                return checkUnifiedEntranceMessage;
            }
            if(old_vCode.equals(registeredUser.getCaptcha()) &&  new_vCode.equals(newRegistUser.getCaptcha())){
                RequestUser request = RequestUser.newBuilder()
                        .setArgs(ConstType.USER_SET)
                        .setUserType(ConstType.REGISTERUSER)
                        .setRegisterUser(RegisterUser.newBuilder()
                                .setUserId(newRegistUser.getUserId())
                                .setPhone(newRegistUser.getPhone())
                                .build()).build();
                try {
                    responseUser = registUserAPI.updateUserInfomation(request);
                } catch (Exception e) {
                    logger.error("用户 userId:{},变更手机号时更新异常",userId);
                    BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                            .setPersonalInfoProtocol(BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                                    .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                            .setUserId(userId).build())
                                    .setStatusDetail(ConstType.EXCEPTION)
                                    .build())
                            .setDataType(unifiedEntranceMessage.getDataType())
                            .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                    .setMsgType(head.getMsgType())
                                    .setToken(head.getToken())
                                    .setFromId(head.getFromId())
                                    .setToId(head.getToId())
                                    .setUniqueIdentify(head.getUniqueIdentify())
                                    .setStatusReport(ResponseStatus.STATUS_REPORT_EXCEPTION)
                                    .build()).build();
                    BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
                    return checkUnifiedEntranceMessage;
                }

                BusinessProtocolMessages.PersonalInfoProtocol personalInfo = BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                        .setUserType(IMSContacts.UserType.REGISTERED_USER)
                        .setStatusDetail(responseUser.getResult())
                        .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                .setUserId(registeredUser.getUserId())
                                .setPhone(newRegistUser.getPhone())
                        ).build();

                BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                        .setPersonalInfoProtocol(personalInfo)
                        .setDataType(unifiedEntranceMessage.getDataType())
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                .setFromId(head.getFromId())
                                .setToId(head.getToId())
                                .setMsgType(head.getMsgType())
                                .setToken(head.getToken())
                                .setUniqueIdentify(head.getUniqueIdentify())
                                .setStatusReport(responseUser.getRet())
                                .build()).build();
                CommonUtil.remove(newRegistUser.getPhone());
                CommonUtil.remove(registeredUser.getPhone());
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
                return checkUnifiedEntranceMessage;
            }else{
                BusinessProtocolMessages.PersonalInfoProtocol personalInfo = BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                        .setUserType(IMSContacts.UserType.REGISTERED_USER)
                        .setStatusDetail(ConstType.PERSON_SETTING_FAILURE)
                        .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                .setUserId(registeredUser.getUserId())
                        ).build();
                BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                        .setPersonalInfoProtocol(personalInfo)
                        .setDataType(unifiedEntranceMessage.getDataType())
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                .setFromId(head.getFromId())
                                .setToId(head.getToId())
                                .setMsgType(head.getMsgType())
                                .setToken(head.getToken())
                                .setUniqueIdentify(head.getUniqueIdentify())
                                .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)
                                .build()).build();

                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
                return checkUnifiedEntranceMessage;
            }

        }
       return null;
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage verificationCode(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {

        String phone = unifiedEntranceMessage.getPersonalInfoProtocol().getSettingsRegisteredUser().getPhone();
        JCRC32 jcrc32 = new JCRC32();
        if(!AliyunSmsUtils.isMobile(phone)){
            BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setPersonalInfoProtocol(BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                            .setUserType(IMSContacts.UserType.REGISTERED_USER)
                            .setStatusDetail(ConstType.PHONE_ERROR)
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .setPhone(phone).build())
                    )
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)
                            .build()).build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return checkUnifiedEntranceMessage;
        }

        String vcode = AliyunSmsUtils.getVCode();
        CommonUtil.put(phone,vcode);

        try {
            boolean responseState = AliyunSmsUtils.sendSms(phone, vcode);
            if(responseState){

                BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                        .setPersonalInfoProtocol(BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                                .setUserType(IMSContacts.UserType.REGISTERED_USER)
                                .setStatusDetail(ConstType.PERSON_SETTING_SUCCESS)
                                .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                        .setPhone(phone).build()))
                        .setDataType(unifiedEntranceMessage.getDataType())
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                .setFromId(head.getFromId())
                                .setToId(head.getToId())
                                .setMsgType(head.getMsgType())
                                .setToken(head.getToken())
                                .setUniqueIdentify(head.getUniqueIdentify())
                                .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                                .build()).build();
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
                return checkUnifiedEntranceMessage;
            }
        } catch (Exception e) {
            logger.error("短信发送错误");
        }
        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setPersonalInfoProtocol(BusinessProtocolMessages.PersonalInfoProtocol.newBuilder()
                        .setUserType(IMSContacts.UserType.REGISTERED_USER)
                        .setStatusDetail(ConstType.PHONE_ERROR)
                        .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                .setPhone(phone).build()))
                .setDataType(unifiedEntranceMessage.getDataType())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setFromId(head.getFromId())
                        .setToId(head.getToId())
                        .setMsgType(head.getMsgType())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)
                        .build()).build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return checkUnifiedEntranceMessage;
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkVersion(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolMessages.CheckForUpdatesProtocol localVersion = unifiedEntranceMessage.getCheckForUpdatesProtocol();
        RegistUserAPI registUserAPI = new RegistUserAPI();
        JCRC32 jcrc32 = new JCRC32();
        CheckForUpdatesProtocol request = CheckForUpdatesProtocol.newBuilder()
                .setDeviceType(localVersion.getDeviceType())
                .setVersionCode(localVersion.getVersionCode())
                .build();
        CheckForUpdatesProtocol newVersion = null;
        try {
            newVersion = registUserAPI.checkAPPVersion(request);
        } catch (Exception e) {
           logger.error("版本检查异常");
            BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_EXCEPTION)
                            .build()).build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage check =jcrc32.packageCheckSum(message);
            return check;
        }

        BusinessProtocolMessages.CheckForUpdatesProtocol checkForUpdatesProtocol = BusinessProtocolMessages.CheckForUpdatesProtocol.newBuilder()
                .setDeviceType(newVersion.getDeviceType())
                .setVersionCode(newVersion.getVersionCode())
                .setVersionName(newVersion.getVersionName())
                .setIsConstraint(newVersion.getIsConstraint())
                .setUpdatePath(newVersion.getUpdatePath())
                .setUpdateDescribe(newVersion.getUpdateDescribe())
                .build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setCheckForUpdatesProtocol(checkForUpdatesProtocol)
                .setDataType(unifiedEntranceMessage.getDataType())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setFromId(head.getFromId())
                        .setToId(head.getToId())
                        .setMsgType(head.getMsgType())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .build()).build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage check =jcrc32.packageCheckSum(message);
        return check;
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage updateUserDevice(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolMessages.BindingPushServicesProtocol bindingPushServicesProtocol = unifiedEntranceMessage.getBindingPushServicesProtocol();
        String userId = bindingPushServicesProtocol.getUserId();
        String pushToken = bindingPushServicesProtocol.getPushToken();
        String manufacturer = bindingPushServicesProtocol.getManufacturer();
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(pushToken) || StringUtils.isEmpty(manufacturer)){
            logger.error("用户："+head.getFromId()+"  更新用户设备传入参数为空，pushToken:"+pushToken+",manufacturer"+manufacturer+",userId:"+userId);
            BusinessProtocolMessageStandard.UnifiedEntranceMessage uem = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setBindingPushServicesProtocol(BusinessProtocolMessages.BindingPushServicesProtocol.newBuilder().
                            setUserId(userId)
                            .setPushToken(pushToken)
                            .setManufacturer(manufacturer)
                            .setStatusDetail("传入参数为空")).build();
            return responseIllegalParam(unifiedEntranceMessage,head,uem,ResponseStatus.STATUS_REPORT_FAILURE);
        }
        RegistUserAPI registUserAPI = new RegistUserAPI();
        RequestUserDevice respose = registUserAPI.updateUserDevice(RequestUserDevice.newBuilder()
                .addRequestDeviceUpdate(RequestDeviceUpdate.newBuilder()
                        .setUserId(userId).setPushToken(pushToken).setManufacturer(manufacturer)
                        .build()).build());
        BusinessProtocolMessageStandard.UnifiedEntranceMessage uem = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setDataType(unifiedEntranceMessage.getDataType())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setFromId(head.getFromId())
                        .setToId(head.getToId())
                        .setMsgType(head.getMsgType())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .build())
                .setBindingPushServicesProtocol(BusinessProtocolMessages.BindingPushServicesProtocol.newBuilder().
                        setUserId(userId)
                        .setPushToken(pushToken)
                        .setManufacturer(manufacturer)
                        .setStatusDetail(respose.getRequestDeviceUpdate(0).getStatusDetail())).build();
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(uem);
        return checkUnifiedEntranceMessage;
    }


    public   BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage responseIllegalParam(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head,BusinessProtocolMessageStandard.UnifiedEntranceMessage uem,String statusReport){
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage  message = uem.toBuilder()
                .setDataType(unifiedEntranceMessage.getDataType())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setFromId(head.getFromId())
                        .setToId(head.getToId())
                        .setMsgType(head.getMsgType())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setStatusReport(statusReport)
                        .build()).build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return checkUnifiedEntranceMessage;
    }
}
