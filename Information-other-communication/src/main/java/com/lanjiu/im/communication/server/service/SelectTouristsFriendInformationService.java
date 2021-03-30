package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.grpc.GuestUserFriendResponse;
import com.lanjiu.im.grpc.RpcGuestUserFriend;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.im.grpc.client.util.ConstantsDefault;
import com.lanjiu.im.grpc.client.util.ConstantsSelectKind;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class SelectTouristsFriendInformationService {

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectTouristsFriendInformation(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        StorageAPI storageAPI = new StorageAPI();
        JCRC32 jcrc32 = new JCRC32();
        FriendUtils friendUtils = new FriendUtils();
        //装载grpc协议请求信息
        TransmissionRequest transmissionRequest ;
        List<RpcGuestUserFriend> list ;
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response = null;
        BusinessProtocolEntities.TouristsUser touristsUser = unifiedEntranceMessage.getFriendSettingsProtocol().getTouristsUser();
        BusinessProtocolEntities.TouristsFriend touristsFriend = unifiedEntranceMessage.getFriendSettingsProtocol().getTouristsFriend();
        String offlineMessage = ConstantsDefault.OFFLINE_MESSAGE_SETTING_OFF;
        String snapchatStatus = ConstantsDefault.BURN_AFTER_READING_SETTING_OFF;
        String timeUnit = ConstantsDefault.TIME_UNIT_SECOND;
        if(IMSContacts.UserType.TOURISTS_USER.equals(touristsFriend.getUserType())){
            if(touristsFriend.getSettings().getOfflineMessage()){
                offlineMessage = ConstantsDefault.OFFLINE_MESSAGE_SETTING_ON;
            }
            if (touristsFriend.getSettings().getSnapchatStatus()){
                snapchatStatus = ConstantsDefault.BURN_AFTER_READING_SETTING_ON;
            }
            if (IMSContacts.TimeUnit.SECOND == touristsFriend.getSettings().getSnapchatTimeUnit()){
                timeUnit = ConstantsDefault.TIME_UNIT_SECOND;
            }else if (IMSContacts.TimeUnit.MINUTE == touristsFriend.getSettings().getSnapchatTimeUnit()){
                timeUnit = ConstantsDefault.TIME_UNIT_MINUTE;
            }else if (IMSContacts.TimeUnit.HOUR == touristsFriend.getSettings().getSnapchatTimeUnit()){
                timeUnit = ConstantsDefault.TIME_UNIT_HOUR;
            }
            transmissionRequest = TransmissionRequest.newBuilder()
                    .setRequestKind(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_GUEST_FRIEND_ID)
                    .setGuestUserFriend(RpcGuestUserFriend.newBuilder()
                            .setGuestUserId(Integer.parseInt(touristsUser.getTemporaryId()))
                            .setFriendId(Integer.parseInt(touristsFriend.getFriendId()))
                            .setFriendUserId(Integer.parseInt(touristsFriend.getFriendUserId()))
                            .setFriendComment(touristsFriend.getFriendAlias())
                            .setOfflineMessageSetting(offlineMessage)
                            .setBurnAfterReadingSetting(snapchatStatus)
                            .setBurnAfterReadingTimeUnit(timeUnit)
                            .setBurnAfterReadingTimeLength(touristsFriend.getSettings().getSnapchatTimeLength())
                            .setFriendNickName(touristsFriend.getFriendNickname())
                            .build())
                    .build();
            GuestUserFriendResponse guestUserFriendResponse = storageAPI.selectGuestUserFriendAPI(transmissionRequest);
            list = guestUserFriendResponse.getResponseDataList();
            List<BusinessProtocolEntities.TouristsFriend> touristsFriendByFriendUserIdList = friendUtils.guestUserFriendList(unifiedEntranceMessage, list);

            //commonUtils.isHave(list)
            CommonUtils<BusinessProtocolEntities.TouristsFriend> commonUtils = new CommonUtils<>();
            if(commonUtils.isHave(touristsFriendByFriendUserIdList)){
                touristsFriend = touristsFriendByFriendUserIdList.get(0);
            }
            BusinessProtocolMessages.FriendSettingsProtocol friendSettingsProtocol = BusinessProtocolMessages.FriendSettingsProtocol.newBuilder()
                    .setTouristsFriend(touristsFriend)
                    .setUserType(unifiedEntranceMessage.getFriendSettingsProtocol().getUserType())
                    .setTouristsUser(unifiedEntranceMessage.getFriendSettingsProtocol().getTouristsUser())
                    .setRegisteredUser(unifiedEntranceMessage.getFriendSettingsProtocol().getRegisteredUser())
                    .setRegisteredFriend(unifiedEntranceMessage.getFriendSettingsProtocol().getRegisteredFriend())
                    .setOperation(unifiedEntranceMessage.getFriendSettingsProtocol().getOperation())
                    .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                    .build();
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                    .newBuilder()
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
                    )
                    .build();
            response = jcrc32.packageCheckSum(message);
        }
        return response;
    }
}
