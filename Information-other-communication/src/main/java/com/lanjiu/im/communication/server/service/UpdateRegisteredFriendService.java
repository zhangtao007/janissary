package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.util.ConstantsContent;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.im.grpc.client.util.ConstantsDefault;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class UpdateRegisteredFriendService {

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage updateRegisteredFriend(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        StorageAPI storageAPI = new StorageAPI();
        JCRC32 jcrc32 = new JCRC32();
        FriendUtils friendUtils = new FriendUtils();
        //装载grpc协议请求信息
        TransmissionRequest transmissionRequest ;
        List<RpcRegisteredUserFriend> list ;
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response = null;
        BusinessProtocolEntities.RegisteredUser registeredUser = unifiedEntranceMessage.getFriendSettingsProtocol().getRegisteredUser();
        BusinessProtocolEntities.RegisteredFriend registeredFriend = unifiedEntranceMessage.getFriendSettingsProtocol().getRegisteredFriend();
        String msgType = unifiedEntranceMessage.getHead().getMsgType();


        if(IMSContacts.UserType.REGISTERED_USER.equals(registeredFriend.getUserType())){
            //修改好友备注
            if (IMSContacts.MsgType.FRIEND_ALIAS_REGISTERED.equals(msgType)){
                transmissionRequest = TransmissionRequest.newBuilder()
                        .setRequestKind(ConstantsContent.FRIEND_ALIAS)
                        .setRegisteredUserFriend(RpcRegisteredUserFriend.newBuilder()
                                .setRegisteredUserId(Integer.parseInt(registeredUser.getUserId()))
                                .setFriendUserId(Integer.parseInt(registeredFriend.getFriendUserId()))
                                .setFriendComment(registeredFriend.getFriendAlias())
                                .build()).build();
                RegisteredUserFriendResponse registeredUserFriendResponse = storageAPI.updateRegisteredUserFriendAPI(transmissionRequest);
                list = registeredUserFriendResponse.getResponseDataList();
                List<BusinessProtocolEntities.RegisteredFriend> registeredFriendByFriendUserIdList = friendUtils.registeredUserFriendList(list);

                CommonUtils<BusinessProtocolEntities.RegisteredFriend> commonUtils = new CommonUtils<>();
                if(commonUtils.isHave(registeredFriendByFriendUserIdList)){
                    registeredFriend = registeredFriendByFriendUserIdList.get(0);
                }
                BusinessProtocolMessages.FriendSettingsProtocol friendSettingsProtocol = BusinessProtocolMessages.FriendSettingsProtocol.newBuilder()
                        .setTouristsFriend(unifiedEntranceMessage.getFriendSettingsProtocol().getTouristsFriend())
                        .setUserType(unifiedEntranceMessage.getFriendSettingsProtocol().getUserType())
                        .setTouristsUser(unifiedEntranceMessage.getFriendSettingsProtocol().getTouristsUser())
                        .setRegisteredUser(unifiedEntranceMessage.getFriendSettingsProtocol().getRegisteredUser())
                        .setRegisteredFriend(registeredFriend)
                        .setOperation(unifiedEntranceMessage.getFriendSettingsProtocol().getOperation())
                        .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .build();
                BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                        .newBuilder()
                        .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendSettingsProtocol)
                        .setFriendSettingsProtocol(friendSettingsProtocol)
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                .setMsgType(head.getMsgType())
                                .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                                .setToId(head.getToId())
                                .setFromId(head.getFromId())
                                .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                                .setToken(head.getToken())
                                .setUniqueIdentify(head.getUniqueIdentify())
                                .setMsgContentType(head.getMsgContentType())
                                .build()
                        ).build();
                response = jcrc32.packageCheckSum(message);
            }else if (IMSContacts.MsgType.FRIEND_OFFLINE_MSG_REGISTERED.equals(msgType)){
                //修改是否接受好友离线消息
//                Boolean offlineMessage = unifiedEntranceMessage.getFriendSettingsProtocol().getRegisteredFriend().getSettings().getOfflineMessage();
//                String offlineSet = offlineMessage == false ? "OFF" : "ON";
                String offlineSet = "ON" ;   //屏蔽离线消息开关
                    transmissionRequest = TransmissionRequest.newBuilder()
                            .setRequestKind(ConstantsContent.FRIEND_OFFLINE_SET)
                            .setRegisteredUserFriend(RpcRegisteredUserFriend.newBuilder()
                                    .setRegisteredUserId(Integer.parseInt(registeredUser.getUserId()))
                                    .setFriendUserId(Integer.parseInt(registeredFriend.getFriendUserId()))
                                    .setOfflineMessageSetting(offlineSet)
                                    .build()).build();
                    RegisteredUserFriendResponse registeredUserFriendResponse = storageAPI.updateRegisteredUserFriendAPI(transmissionRequest);
                    list = registeredUserFriendResponse.getResponseDataList();
                    List<BusinessProtocolEntities.RegisteredFriend> registeredFriendByFriendUserIdList = friendUtils.registeredUserFriendList(list);

                    CommonUtils<BusinessProtocolEntities.RegisteredFriend> commonUtils = new CommonUtils<>();
                    if(commonUtils.isHave(registeredFriendByFriendUserIdList)){
                        registeredFriend = registeredFriendByFriendUserIdList.get(0);
                    }
                    BusinessProtocolMessages.FriendSettingsProtocol friendSettingsProtocol = BusinessProtocolMessages.FriendSettingsProtocol.newBuilder()
                            .setTouristsFriend(unifiedEntranceMessage.getFriendSettingsProtocol().getTouristsFriend())
                            .setUserType(unifiedEntranceMessage.getFriendSettingsProtocol().getUserType())
                            .setTouristsUser(unifiedEntranceMessage.getFriendSettingsProtocol().getTouristsUser())
                            .setRegisteredUser(unifiedEntranceMessage.getFriendSettingsProtocol().getRegisteredUser())
                            .setRegisteredFriend(registeredFriend)
                            .setOperation(unifiedEntranceMessage.getFriendSettingsProtocol().getOperation())
                            .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                            .build();
                    BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                            .newBuilder()
                            .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendSettingsProtocol)
                            .setFriendSettingsProtocol(friendSettingsProtocol)
                            .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                    .setMsgType(head.getMsgType())
                                    .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                                    .setToId(head.getToId())
                                    .setFromId(head.getFromId())
                                    .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                                    .setToken(head.getToken())
                                    .setUniqueIdentify(head.getUniqueIdentify())
                                    .setMsgContentType(head.getMsgContentType())
                                    .build()
                            ).build();
                    response = jcrc32.packageCheckSum(message);

            }



//            if(registeredFriend.getSettings().getOfflineMessage()){
//                offlineMessage = ConstantsDefault.OFFLINE_MESSAGE_SETTING_ON;
//            }
//            if (registeredFriend.getSettings().getSnapchatStatus()){
//                snapchatStatus = ConstantsDefault.BURN_AFTER_READING_SETTING_ON;
//            }
//            if (IMSContacts.TimeUnit.SECOND == registeredFriend.getSettings().getSnapchatTimeUnit()){
//                timeUnit = ConstantsDefault.TIME_UNIT_SECOND;
//            }else if (IMSContacts.TimeUnit.MINUTE == registeredFriend.getSettings().getSnapchatTimeUnit()){
//                timeUnit = ConstantsDefault.TIME_UNIT_MINUTE;
//            }else if (IMSContacts.TimeUnit.HOUR == registeredFriend.getSettings().getSnapchatTimeUnit()){
//                timeUnit = ConstantsDefault.TIME_UNIT_HOUR;
//            }
//            transmissionRequest = TransmissionRequest.newBuilder()
//                    .setRegisteredUserFriend(RpcRegisteredUserFriend.newBuilder()
//                    .setRegisteredUserId(Integer.parseInt(registeredUser.getUserId()))
//                    .setFriendUserId(Integer.parseInt(registeredFriend.getFriendUserId()))
//                    .setFriendComment(registeredFriend.getFriendAlias())
//                    .setOfflineMessageSetting(offlineMessage)
//                    .setBurnAfterReadingSetting(snapchatStatus)
//                    .setBurnAfterReadingTimeUnit(timeUnit)
//                    .setBurnAfterReadingTimeLength(registeredFriend.getSettings().getSnapchatTimeLength())
//                    .setFriendNickName(registeredFriend.getFriendNickname())
//                    .build()).build();
//            RegisteredUserFriendResponse registeredUserFriendResponse = storageAPI.updateRegisteredUserFriendAPI(transmissionRequest);
//            list = registeredUserFriendResponse.getResponseDataList();
//            List<BusinessProtocolEntities.RegisteredFriend> registeredFriendByFriendUserIdList = friendUtils.registeredUserFriendList(list);
//
//            CommonUtils<BusinessProtocolEntities.RegisteredFriend> commonUtils = new CommonUtils<>();
//            if(commonUtils.isHave(registeredFriendByFriendUserIdList)){
//                registeredFriend = registeredFriendByFriendUserIdList.get(0);
//            }
//            BusinessProtocolMessages.FriendSettingsProtocol friendSettingsProtocol = BusinessProtocolMessages.FriendSettingsProtocol.newBuilder()
//                    .setTouristsFriend(unifiedEntranceMessage.getFriendSettingsProtocol().getTouristsFriend())
//                    .setUserType(unifiedEntranceMessage.getFriendSettingsProtocol().getUserType())
//                    .setTouristsUser(unifiedEntranceMessage.getFriendSettingsProtocol().getTouristsUser())
//                    .setRegisteredUser(unifiedEntranceMessage.getFriendSettingsProtocol().getRegisteredUser())
//                    .setRegisteredFriend(registeredFriend)
//                    .setOperation(unifiedEntranceMessage.getFriendSettingsProtocol().getOperation())
//                    .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
//                    .build();
//            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
//                    .newBuilder()
//                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendSettingsProtocol)
//                    .setFriendSettingsProtocol(friendSettingsProtocol)
//                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
//                    .setMsgType(head.getMsgType())
//                    .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
//                    .setToId(head.getToId())
//                    .setFromId(head.getFromId())
//                    .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
//                    .setToken(head.getToken())
//                    .setUniqueIdentify(head.getUniqueIdentify())
//                    .setMsgContentType(head.getMsgContentType())
//                    .build()
//                    ).build();
//            response = jcrc32.packageCheckSum(message);


        }
        return response;
    }
}
