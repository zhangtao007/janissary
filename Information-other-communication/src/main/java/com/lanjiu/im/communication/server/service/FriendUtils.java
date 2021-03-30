package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.server.ResponseUtil;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.grpc.RpcGuestUserFriend;
import com.lanjiu.im.grpc.RpcRegisteredUserFriend;
import com.lanjiu.im.grpc.client.util.ConstantsDefault;
import com.lanjiu.im.login.client.registLoginAPI.GuestUserAPI;
import com.lanjiu.im.login.client.registLoginAPI.RegistUserAPI;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import com.lanjiu.pro.login.*;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FriendUtils {

    private final Logger logger = Logger.getLogger(FriendUtils.class);

    //好友记录插入相关
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage responseToClientRegisteredUserFriend(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head,
                                  List<RpcRegisteredUserFriend> listRegister,List<RpcRegisteredUserFriend> listRegister2){
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolEntities.RegisteredUser registeredUser = unifiedEntranceMessage.getFriendAddProtocol().getRegisteredUser();//添加人
        BusinessProtocolEntities.RegisteredFriend friend = unifiedEntranceMessage.getFriendAddProtocol().getRegisteredFriend(0);//好友
        BusinessProtocolEntities.RegisteredFriend registeredFriend ;
        boolean offlineMessage = false;
        boolean snapchatStatus = false;
        int unit = 0;

        RegistUserAPI registUserAPI = new RegistUserAPI();
        RequestUser request ;
        ResponseUser responseUser ;
        UserInfomation userInfomation ;
        List<RegisterUser> registerUserList ;
        ResponseUtil responseUtil = new ResponseUtil();

        //注册好友列表
        List<BusinessProtocolEntities.RegisteredFriend> registeredFriendList = new ArrayList<>();
        if(null != listRegister && listRegister.size()>0){
            for (RpcRegisteredUserFriend rpcRegisteredUserFriend : listRegister){
                if(ConstantsDefault.OFFLINE_MESSAGE_SETTING_ON.equals(rpcRegisteredUserFriend.getOfflineMessageSetting())){
                    offlineMessage = true;
                }
                if (ConstantsDefault.BURN_AFTER_READING_SETTING_ON.equals(rpcRegisteredUserFriend.getBurnAfterReadingSetting())){
                    snapchatStatus = true;
                }
                if (ConstantsDefault.TIME_UNIT_SECOND.equals(rpcRegisteredUserFriend.getBurnAfterReadingTimeUnit())){
                    unit = IMSContacts.TimeUnit.SECOND;
                }else if (ConstantsDefault.TIME_UNIT_MINUTE.equals(rpcRegisteredUserFriend.getBurnAfterReadingTimeUnit())){
                    unit = IMSContacts.TimeUnit.MINUTE;
                }else if (ConstantsDefault.TIME_UNIT_HOUR.equals(rpcRegisteredUserFriend.getBurnAfterReadingTimeUnit())){
                    unit = IMSContacts.TimeUnit.HOUR;
                }

                request = RequestUser.newBuilder().setArgs(IMSContacts.MsgType.SEARCH_USER).setRegisterUser(RegisterUser.newBuilder()
                        .setUserId(String.valueOf(rpcRegisteredUserFriend.getRegisteredUserId()))
                        .build()).build();
                responseUser = registUserAPI.selectUserInfomation(request);
                registerUserList = responseUser.getRegisterUserList();

                CommonUtils<RegisterUser> commonUtils = new CommonUtils<>();
                if(commonUtils.isHave(registerUserList)){
                    userInfomation = registerUserList.get(0).getUserInfomation();
                }else{
                    responseUtil.requestWithResponseFail(unifiedEntranceMessage);
                    logger.info(ResponseStatus.RESPONSE_USER_INFORMATION_SELECT_FAILURE);
                    break;
                }

                registeredFriend = BusinessProtocolEntities.RegisteredFriend
                        .newBuilder()
                        .setFriendAlias(rpcRegisteredUserFriend.getFriendComment())
                        .setFriendAvatar(friend.getFriendAvatar())
                        .setFriendNickname(rpcRegisteredUserFriend.getFriendNickName())
                        .setFriendUserId(String.valueOf(friend.getFriendUserId()))
                        .setUserType(IMSContacts.UserType.REGISTERED_USER)
                        .setSettings(BusinessProtocolEntities.Settings.newBuilder()
                        .setExitClean(!"OFF".equals(userInfomation.getExitClean()))
                        .setOfflineMessage(offlineMessage)
                        .setSnapchatStatus(snapchatStatus)
                        .setSnapchatTimeLength(Float.floatToIntBits(rpcRegisteredUserFriend.getBurnAfterReadingTimeLength()))
                        .setSnapchatTimeUnit(unit)
                        .setTimerClean(userInfomation.getTimerClean())
                        .build()).setOnlineStatus(IMSContacts.OnlineStatus.ONLINE).build();
                registeredFriendList.add(registeredFriend);
            }
        }

        if(null != listRegister2 && listRegister2.size()>0){
            for (RpcRegisteredUserFriend rpcRegisteredUserFriend : listRegister2){
                if(ConstantsDefault.OFFLINE_MESSAGE_SETTING_ON.equals(rpcRegisteredUserFriend.getOfflineMessageSetting())){
                    offlineMessage = true;
                }
                if (ConstantsDefault.BURN_AFTER_READING_SETTING_ON.equals(rpcRegisteredUserFriend.getBurnAfterReadingSetting())){
                    snapchatStatus = true;
                }
                if (ConstantsDefault.TIME_UNIT_SECOND.equals(rpcRegisteredUserFriend.getBurnAfterReadingTimeUnit())){
                    unit = IMSContacts.TimeUnit.SECOND;
                }else if (ConstantsDefault.TIME_UNIT_MINUTE.equals(rpcRegisteredUserFriend.getBurnAfterReadingTimeUnit())){
                    unit = IMSContacts.TimeUnit.MINUTE;
                }else if (ConstantsDefault.TIME_UNIT_HOUR.equals(rpcRegisteredUserFriend.getBurnAfterReadingTimeUnit())){
                    unit = IMSContacts.TimeUnit.HOUR;
                }

                request = RequestUser.newBuilder().setArgs(IMSContacts.MsgType.SEARCH_USER).setRegisterUser(RegisterUser.newBuilder()
                        .setUserId(String.valueOf(rpcRegisteredUserFriend.getFriendUserId()))
                        .build()).build();
                responseUser = registUserAPI.selectUserInfomation(request);
                registerUserList = responseUser.getRegisterUserList();

                CommonUtils<RegisterUser> commonUtils = new CommonUtils<>();
                if(commonUtils.isHave(registerUserList)){
                    userInfomation = registerUserList.get(0).getUserInfomation();
                }else{
                    responseUtil.requestWithResponseFail(unifiedEntranceMessage);
                    logger.info(ResponseStatus.RESPONSE_USER_INFORMATION_SELECT_FAILURE);
                    break;
                }
                registeredFriend = BusinessProtocolEntities.RegisteredFriend
                        .newBuilder()
                        .setFriendAlias(rpcRegisteredUserFriend.getFriendComment())
                        .setFriendAvatar(registeredUser.getAvatar())
                        .setFriendNickname(rpcRegisteredUserFriend.getFriendNickName())
                        .setFriendUserId(String.valueOf(rpcRegisteredUserFriend.getFriendUserId()))
                        .setUserType(IMSContacts.UserType.REGISTERED_USER)
                        .setSettings(BusinessProtocolEntities.Settings.newBuilder()
                        .setExitClean(!"OFF".equals(userInfomation.getExitClean()))
                        .setOfflineMessage(offlineMessage)
                        .setSnapchatStatus(snapchatStatus)
                        .setSnapchatTimeLength(Float.floatToIntBits(rpcRegisteredUserFriend.getBurnAfterReadingTimeLength()))
                        .setSnapchatTimeUnit(unit)
                        .setTimerClean(userInfomation.getTimerClean())
                        .build())
                        .setOnlineStatus(IMSContacts.OnlineStatus.ONLINE)
                        .build();
                registeredFriendList.add(registeredFriend);
            }
        }

        BusinessProtocolMessages.FriendAddProtocol friendAddProtocol = BusinessProtocolMessages.FriendAddProtocol.newBuilder()
                .addAllRegisteredFriend(registeredFriendList)
                .setUserType(unifiedEntranceMessage.getFriendAddProtocol().getUserType())
                .setRegisteredUser(unifiedEntranceMessage.getFriendAddProtocol().getRegisteredUser())
                .setTouristsUser(unifiedEntranceMessage.getFriendAddProtocol().getTouristsUser())
//                .addAllTouristsFriend(touristsFriendList)
                .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                .newBuilder().setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendAddProtocol)
                .setFriendAddProtocol(friendAddProtocol)
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                .setMsgType(head.getMsgType())
                .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                .setToId(head.getToId())
                .setFromId(head.getFromId())
                .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                .setToken(head.getToken())
                .setUniqueIdentify(head.getUniqueIdentify())
                .setMsgContentType(head.getMsgContentType())
                .build()).build();
        return jcrc32.packageCheckSum(message);
    }


    public List<BusinessProtocolEntities.TouristsFriend> guestUserFriendList(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, List<RpcGuestUserFriend> list){
        BusinessProtocolEntities.TouristsFriend touristsFriend ;
        boolean offlineMessage = false;
        boolean snapchatStatus = false;
        int unit = 0;

        GuestUserAPI guestUserAPI = new GuestUserAPI();
        RequestUser request ;
        ResponseUser responseUser ;
        UserInfomation userInfomation ;
        List<GuestUser> guestUserList ;
        ResponseUtil responseUtil = new ResponseUtil();

        List<BusinessProtocolEntities.TouristsFriend> touristsFriendList = new ArrayList<>();
        for (RpcGuestUserFriend rpcGuestUserFriend : list){
            if(ConstantsDefault.OFFLINE_MESSAGE_SETTING_ON.equals(rpcGuestUserFriend.getOfflineMessageSetting())){
                offlineMessage = true;
            }
            if (ConstantsDefault.BURN_AFTER_READING_SETTING_ON.equals(rpcGuestUserFriend.getBurnAfterReadingSetting())){
                snapchatStatus = true;
            }
            if (ConstantsDefault.TIME_UNIT_SECOND.equals(rpcGuestUserFriend.getBurnAfterReadingTimeUnit())){
                unit = IMSContacts.TimeUnit.SECOND;
            }else if (ConstantsDefault.TIME_UNIT_MINUTE.equals(rpcGuestUserFriend.getBurnAfterReadingTimeUnit())){
                unit = IMSContacts.TimeUnit.MINUTE;
            }else if (ConstantsDefault.TIME_UNIT_HOUR.equals(rpcGuestUserFriend.getBurnAfterReadingTimeUnit())){
                unit = IMSContacts.TimeUnit.HOUR;
            }

            request = RequestUser.newBuilder().setArgs(IMSContacts.MsgType.SEARCH_USER).setGuestUser(GuestUser.newBuilder()
                    .setUserId(String.valueOf(rpcGuestUserFriend.getFriendUserId()))
                    .build()).build();
            responseUser = guestUserAPI.selectGuestUserInfo(request);
            guestUserList = responseUser.getGuestUserList();
            CommonUtils<GuestUser> commonUtils = new CommonUtils<>();
            if(commonUtils.isHave(guestUserList)){
                userInfomation = guestUserList.get(0).getUserInfomation();
            } else{
                responseUtil.requestWithResponseFail(unifiedEntranceMessage);
                logger.info(ResponseStatus.RESPONSE_USER_INFORMATION_SELECT_FAILURE);
                break;
            }

            touristsFriend = BusinessProtocolEntities.TouristsFriend
                    .newBuilder()
                    .setFriendAlias(rpcGuestUserFriend.getFriendComment())
                    .setFriendAvatar(userInfomation.getAvatar())
                    .setFriendNickname(rpcGuestUserFriend.getFriendNickName())
                    .setFriendUserId(String.valueOf(rpcGuestUserFriend.getFriendUserId()))
                    .setUserType(IMSContacts.UserType.TOURISTS_USER)
                    .setSettings(BusinessProtocolEntities.Settings.newBuilder()
                    .setExitClean(!"OFF".equals(userInfomation.getExitClean()))
                    .setOfflineMessage(offlineMessage)
                    .setSnapchatStatus(snapchatStatus)
                    .setSnapchatTimeLength(Float.floatToIntBits(rpcGuestUserFriend.getBurnAfterReadingTimeLength()))
                    .setSnapchatTimeUnit(unit)
                    .setTimerClean(userInfomation.getTimerClean())
                    .build())
                    .setOnlineStatus(IMSContacts.OnlineStatus.ONLINE)
                    .build();
            touristsFriendList.add(touristsFriend);
        }
        return touristsFriendList;
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage responseFriendList(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head,
              List<BusinessProtocolEntities.RegisteredFriend> registeredFriendList){
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessages.FriendListProtocol friendListProtocol = BusinessProtocolMessages.FriendListProtocol.newBuilder()
//                .addAllTouristsFriend(touristsFriendList)
                .setUserType(unifiedEntranceMessage.getFriendListProtocol().getUserType())
                .setTouristsUser(unifiedEntranceMessage.getFriendListProtocol().getTouristsUser())
                .setRegisteredUser(unifiedEntranceMessage.getFriendListProtocol().getRegisteredUser())
                .addAllRegisteredFriend(registeredFriendList)
                .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                .newBuilder()
                .setFriendListProtocol(friendListProtocol)
                .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendListProtocol)
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                .setMsgType(head.getMsgType())
                .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                .setToId(head.getToId())
                .setFromId(head.getFromId())
                .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                .setToken(head.getToken())
                .setUniqueIdentify(head.getUniqueIdentify())
                .setMsgContentType(head.getMsgContentType())
                .build()).build();
        return jcrc32.packageCheckSum(message);
    }

    //获取注册好友列表 --- 好友记录查询相关
    public List<BusinessProtocolEntities.RegisteredFriend> registeredUserFriendList(List<RpcRegisteredUserFriend> listRegister){
        BusinessProtocolEntities.RegisteredFriend registeredFriend ;
        int unit = 0;
        RegistUserAPI registUserAPI = new RegistUserAPI();
        RequestUser request ;
        ResponseUser responseUser ;
        UserInfomation userInfomation ;
        List<RegisterUser> registerUserList ;

        List<BusinessProtocolEntities.RegisteredFriend> registeredFriendList = new ArrayList<>();
        for (RpcRegisteredUserFriend rpcRegisteredUserFriend : listRegister){
            if (ConstantsDefault.TIME_UNIT_SECOND.equals(rpcRegisteredUserFriend.getBurnAfterReadingTimeUnit())){
                unit = IMSContacts.TimeUnit.SECOND;
            }else if (ConstantsDefault.TIME_UNIT_MINUTE.equals(rpcRegisteredUserFriend.getBurnAfterReadingTimeUnit())){
                unit = IMSContacts.TimeUnit.MINUTE;
            }else if (ConstantsDefault.TIME_UNIT_HOUR.equals(rpcRegisteredUserFriend.getBurnAfterReadingTimeUnit())){
                unit = IMSContacts.TimeUnit.HOUR;
            }
            //查询注册用戶个人资料
            request = RequestUser.newBuilder().setArgs(IMSContacts.MsgType.SEARCH_USER).setRegisterUser(RegisterUser.newBuilder()
                    .setUserId(String.valueOf(rpcRegisteredUserFriend.getFriendUserId())).build()).build();
            responseUser = registUserAPI.selectUserInfomation(request);
            registerUserList = responseUser.getRegisterUserList();
            if(null != registerUserList && registerUserList.size() > 0){
                userInfomation = registerUserList.get(0).getUserInfomation();
                registeredFriend = BusinessProtocolEntities.RegisteredFriend
                        .newBuilder()
                        .setFriendAlias(rpcRegisteredUserFriend.getFriendComment())
                        .setFriendAvatar(userInfomation.getAvatar())
                        .setFriendNickname(null!=rpcRegisteredUserFriend.getFriendComment()&&!"".equals(rpcRegisteredUserFriend.getFriendComment())
                                ?rpcRegisteredUserFriend.getFriendComment():userInfomation.getNickname())
                        .setFriendUserId(String.valueOf(rpcRegisteredUserFriend.getFriendUserId()))
                        .setUserType(IMSContacts.UserType.REGISTERED_USER)
                        .setSettings(BusinessProtocolEntities.Settings.newBuilder()
                        .setExitClean(!"OFF".equals(userInfomation.getExitClean()))
                        .setOfflineMessage(rpcRegisteredUserFriend.getOfflineMessageSetting().equals("ON"))
                        .setSnapchatStatus(rpcRegisteredUserFriend.getBurnAfterReadingSetting().equals("ON"))
                        .setSnapchatTimeLength(Float.floatToIntBits(rpcRegisteredUserFriend.getBurnAfterReadingTimeLength()))
                        .setSnapchatTimeUnit(unit)
                        .setTimerClean(userInfomation.getTimerClean())
                        .build())
                        .setOnlineStatus(IMSContacts.OnlineStatus.ONLINE)
                        .build();
                registeredFriendList.add(registeredFriend);
            }
        }
        return registeredFriendList;
    }
}
