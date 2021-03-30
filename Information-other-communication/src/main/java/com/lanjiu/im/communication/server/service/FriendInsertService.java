package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.im.grpc.client.util.ConstantsDefault;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FriendInsertService {

    private final Logger logger = Logger.getLogger(FriendInsertService.class);

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage insertRegisteredUserFriendServiceAPI(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        StorageAPI storageAPI = new StorageAPI();
        String userType = unifiedEntranceMessage.getFriendAddProtocol().getUserType();
        BusinessProtocolEntities.RegisteredUser registeredUser = unifiedEntranceMessage.getFriendAddProtocol().getRegisteredUser();
        List<BusinessProtocolEntities.RegisteredFriend> registeredFriendList = unifiedEntranceMessage.getFriendAddProtocol().getRegisteredFriendList();
        int userId = Integer.parseInt(registeredUser.getUserId());
        logger.info("注册用户添加好友的用户ID："+userId);
        TransmissionRequest transmissionRequest ;
        String unit = ConstantsDefault.TIME_UNIT_SECOND;
        List<RpcRegisteredUserFriend> listRegistered;
        List<RpcRegisteredUserFriend> listRegisteredAdded = new ArrayList<>();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response ;
        FriendUtils friendUtils = new FriendUtils();
        for (BusinessProtocolEntities.RegisteredFriend registeredFriend : registeredFriendList) {
            if (IMSContacts.TimeUnit.SECOND == registeredFriend.getSettings().getSnapchatTimeUnit()) {
                unit = ConstantsDefault.TIME_UNIT_SECOND;
            } else if (IMSContacts.TimeUnit.MINUTE == registeredFriend.getSettings().getSnapchatTimeUnit()) {
                unit = ConstantsDefault.TIME_UNIT_MINUTE;
            } else if (IMSContacts.TimeUnit.HOUR == registeredFriend.getSettings().getSnapchatTimeUnit()) {
                unit = ConstantsDefault.TIME_UNIT_HOUR;
            }
            if (IMSContacts.UserType.REGISTERED_USER.equals(registeredFriend.getUserType())) {
                //以好友发起人的角色来加记录
                transmissionRequest = TransmissionRequest.newBuilder()
                        .setRegisteredUserFriend(RpcRegisteredUserFriend.newBuilder()
                        .setRegisteredUserId(Integer.parseInt(registeredFriend.getFriendUserId()))
                        .setFriendUserId(userId)
                        .setFriendNickName(registeredUser.getNickname())
                        .setFriendComment(registeredFriend.getFriendAlias())
                        .setBurnAfterReadingTimeLength(registeredFriend.getSettings().getSnapchatTimeLength())
                        .setBurnAfterReadingTimeUnit(unit)
                        .setBurnAfterReadingSetting(ConstantsDefault.BURN_AFTER_READING_SETTING_ON)
                        .setOfflineMessageSetting(ConstantsDefault.OFFLINE_MESSAGE_SETTING_ON)
                        .build()).build();
                logger.info("注册用户添加好友的被添加用户ID"+registeredFriend.getFriendUserId());
                RegisteredUserFriendResponse registeredUserFriendResponse = storageAPI.insertRegisteredUserFriendAPI(transmissionRequest);
                if("repeated".equals(registeredUserFriendResponse.getStatusDetail())){
                    return this.exceptionHandle(unifiedEntranceMessage);
                }
                listRegistered = registeredUserFriendResponse.getResponseDataList();
                //添加当前同意人的一条好友记录
                if (IMSContacts.UserType.REGISTERED_USER.equals(userType)) {
                    transmissionRequest = TransmissionRequest.newBuilder()
                            .setRegisteredUserFriend(RpcRegisteredUserFriend.newBuilder()
                            .setRegisteredUserId(userId)
                            .setFriendUserId(Integer.parseInt(registeredFriend.getFriendUserId()))
                            .setFriendNickName(registeredFriend.getFriendNickname())
                            .setFriendComment(registeredFriend.getFriendAlias())
                            .setBurnAfterReadingTimeLength(registeredFriend.getSettings().getSnapchatTimeLength())
                            .setBurnAfterReadingTimeUnit(unit)
                            .setBurnAfterReadingSetting(ConstantsDefault.BURN_AFTER_READING_SETTING_ON)
                            .setOfflineMessageSetting(ConstantsDefault.OFFLINE_MESSAGE_SETTING_ON)
                            .build()).build();
                    registeredUserFriendResponse = storageAPI.insertRegisteredUserFriendAPI(transmissionRequest);
                    if("repeated".equals(registeredUserFriendResponse.getStatusDetail())){
                        logger.info("注册用户添加好友重复"+registeredUserFriendResponse.getStatusDetail());
                        return this.exceptionHandle(unifiedEntranceMessage);
                    }
                    listRegisteredAdded = registeredUserFriendResponse.getResponseDataList();
                }
                response = friendUtils.responseToClientRegisteredUserFriend(unifiedEntranceMessage, head, listRegisteredAdded, listRegistered);
                return response;
            }
        }
        return null;
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage exceptionHandle(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage){
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        BusinessProtocolMessages.FriendAddProtocol friendAddProtocol = BusinessProtocolMessages.FriendAddProtocol.newBuilder()
                .setUserType(unifiedEntranceMessage.getFriendAddProtocol().getUserType())
                .setTouristsUser(unifiedEntranceMessage.getFriendAddProtocol().getTouristsUser())
                .setRegisteredUser(unifiedEntranceMessage.getFriendAddProtocol().getRegisteredUser())
                .setStatusDetail("好友添加重复")
                .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                .newBuilder()
                .setFriendAddProtocol(friendAddProtocol)
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(IMSContacts.MsgType.FRIEND_APPLY_AGREE_REGISTERED)
                        .setStatusReport("EXCEPTION")
                        .setToId(head.getToId())
                        .setFromId(head.getFromId())
                        .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setMsgContentType(head.getMsgContentType())
                        .build()).build();
        return jcrc32.packageCheckSum(message);
    }
}
