package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.server.ResponseUtil;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.grpc.RegisteredUserFriendResponse;
import com.lanjiu.im.grpc.RpcRegisteredUserFriend;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.im.grpc.client.util.ConstantsSelectKind;
import com.lanjiu.im.login.client.registLoginAPI.RegistUserAPI;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import com.lanjiu.pro.login.RegisterUser;
import com.lanjiu.pro.login.RequestUser;
import com.lanjiu.pro.login.ResponseUser;
import com.lanjiu.pro.login.UserInfomation;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class SelectRegisteredFriendInformationService {

    private final Logger logger = Logger.getLogger(SelectRegisteredFriendInformationService.class);

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectRegisteredFriendInformation(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        StorageAPI storageAPI = new StorageAPI();
        JCRC32 jcrc32 = new JCRC32();
        TransmissionRequest transmissionRequest ;
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response = null;
        BusinessProtocolEntities.RegisteredUser registeredUser = unifiedEntranceMessage.getFriendInfoProtocol().getRegisteredUser();
        BusinessProtocolEntities.RegisteredFriend registeredFriend = unifiedEntranceMessage.getFriendInfoProtocol().getRegisteredFriend();

        RegistUserAPI registUserAPI = new RegistUserAPI();
        ResponseUtil responseUtil = new ResponseUtil();
        if(IMSContacts.UserType.REGISTERED_USER.equals(unifiedEntranceMessage.getFriendInfoProtocol().getUserType())){

            transmissionRequest = TransmissionRequest.newBuilder()
                    .setRequestKind(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_REGISTERED_FRIEND_ID)
                    .setRegisteredUserFriend(RpcRegisteredUserFriend.newBuilder()
                            .setRegisteredUserId(Integer.parseInt(registeredUser.getUserId()))
                            .setFriendId(Integer.parseInt(registeredFriend.getFriendId()))
                            .build())
                    .build();
            RegisteredUserFriendResponse registeredUserFriendResponse = storageAPI.selectRegisteredUserFriendAPI(transmissionRequest);
            RpcRegisteredUserFriend responseData = registeredUserFriendResponse.getResponseDataList().get(0); //todo
            RequestUser request = RequestUser.newBuilder().setArgs(IMSContacts.MsgType.SEARCH_USER).setRegisterUser(RegisterUser.newBuilder()
                                    .setUserId(registeredFriend.getFriendId()).build()).build();
            ResponseUser responseUser = registUserAPI.selectUserInfomation(request);
            List<RegisterUser> registerUserList = responseUser.getRegisterUserList();

            CommonUtils<RegisterUser> commonUtils = new CommonUtils<>();
            if(commonUtils.isHave(registerUserList)){
                UserInfomation userInfomation = registerUserList.get(0).getUserInfomation();
                BusinessProtocolEntities.RegisteredFriend registeredFriendRE = BusinessProtocolEntities.RegisteredFriend.newBuilder()
                                    .setFriendNickname(userInfomation.getNickname())
                                    .setFriendAvatar(userInfomation.getAvatar())
                                    .setFriendAlias(null!=responseData.getFriendComment()&&!"".equals(responseData.getFriendComment())
                                            ?responseData.getFriendComment():"")
                                    .setFriendUserId(String.valueOf(registeredFriend.getFriendId()))
                                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                                    .setSettings(BusinessProtocolEntities.Settings.newBuilder()
                                    .setExitClean(!"OFF".equals(userInfomation.getExitClean()))
                                    .setOfflineMessage(responseData.getOfflineMessageSetting().equals("ON"))
                                    .setSnapchatStatus(responseData.getBurnAfterReadingSetting().equals("ON"))
                                    .setSnapchatTimeLength(Float.floatToIntBits(responseData.getBurnAfterReadingTimeLength()))
                                    .setSnapchatTimeUnit(0)
                                    .setTimerClean(userInfomation.getTimerClean())
                                    .build())
                                    .setOnlineStatus(IMSContacts.OnlineStatus.ONLINE)
                                    .build();

                BusinessProtocolMessages.FriendInfoProtocol friendInfoProtocol = BusinessProtocolMessages.FriendInfoProtocol.newBuilder()
                        .setTouristsFriend(unifiedEntranceMessage.getFriendInfoProtocol().getTouristsFriend())
                        .setUserType(unifiedEntranceMessage.getFriendInfoProtocol().getUserType())
                        .setTouristsUser(unifiedEntranceMessage.getFriendInfoProtocol().getTouristsUser())
                        .setRegisteredUser(unifiedEntranceMessage.getFriendInfoProtocol().getRegisteredUser())
                        .setRegisteredFriend(registeredFriendRE)
                        .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .build();
                BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                        .newBuilder().setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendInfoProtocol)
                        .setFriendInfoProtocol(friendInfoProtocol)
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
                response = jcrc32.packageCheckSum(message);
            }else{
                responseUtil.requestWithResponseFail(unifiedEntranceMessage);
                logger.info(ResponseStatus.RESPONSE_USER_INFORMATION_SELECT_FAILURE);
            }
        }
        return response;
    }
}
