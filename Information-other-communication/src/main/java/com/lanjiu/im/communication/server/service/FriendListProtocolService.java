package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.im.grpc.client.util.ConstantsSelectKind;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import org.apache.log4j.Logger;

import java.util.List;

public class FriendListProtocolService {

    private final Logger logger = Logger.getLogger(FriendListProtocolService.class);

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectGuestUserFriendServiceAPI(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        //还需以被添加人的角色检索记录
        StorageAPI storageAPI = new StorageAPI();
        BusinessProtocolEntities.TouristsUser touristsUser = unifiedEntranceMessage.getFriendListProtocol().getTouristsUser();
        int userId = Integer.parseInt(touristsUser.getTemporaryId());
        //装载grpc协议请求信息
        FriendUtils friendUtils = new FriendUtils();
        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
                .setRequestKind(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_FRIEND_USER_ID)
                .setRegisteredUserFriend(RpcRegisteredUserFriend.newBuilder().setFriendUserId(userId).build())
                .build();
        RegisteredUserFriendResponse registeredUserFriendResponse = storageAPI.selectRegisteredUserFriendAPI(transmissionRequest);
        //装载通信协议响应信息
        List<RpcRegisteredUserFriend> listRegistered = registeredUserFriendResponse.getResponseDataList();
        List<BusinessProtocolEntities.RegisteredFriend> registeredFriendByFriendUserIdList = friendUtils.registeredUserFriendList(listRegistered);
        return friendUtils.responseFriendList(unifiedEntranceMessage, head, registeredFriendByFriendUserIdList);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectRegisteredUserFriendServiceAPI(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        StorageAPI storageAPI = new StorageAPI();
        BusinessProtocolEntities.RegisteredUser registeredUser = unifiedEntranceMessage.getFriendListProtocol().getRegisteredUser();
        int userId = Integer.parseInt(registeredUser.getUserId());
        FriendUtils friendUtils = new FriendUtils();
        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
                .setRequestKind(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_FRIEND_USER_ID)
                .setRegisteredUserFriend(RpcRegisteredUserFriend.newBuilder().setRegisteredUserId(userId).build())
                .build();
        RegisteredUserFriendResponse registeredUserFriendResponse = storageAPI.selectRegisteredUserFriendAPI(transmissionRequest);
        List<RpcRegisteredUserFriend> listRegister = registeredUserFriendResponse.getResponseDataList();
        List<BusinessProtocolEntities.RegisteredFriend> registeredFriendList = friendUtils.registeredUserFriendList(listRegister);
        logger.info("获取注册好友列表用户ID："+userId+"---好友列表人数："+registeredFriendList.size());

//        transmissionRequest = TransmissionRequest.newBuilder()
//                .setRequestKind(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_FRIEND_USER_ID)
//                .setGuestUserFriend(RpcGuestUserFriend.newBuilder().setFriendUserId(userId).build())
//                .build();
//        GuestUserFriendResponse guestUserFriendResponse = storageAPI.selectGuestUserFriendAPI(transmissionRequest);
//        List<RpcGuestUserFriend> listGuest = guestUserFriendResponse.getResponseDataList();
//        List<BusinessProtocolEntities.TouristsFriend> touristsFriendByFriendUserIdList = friendUtils.guestUserFriendList(unifiedEntranceMessage, listGuest);
        return friendUtils.responseFriendList(unifiedEntranceMessage, head, registeredFriendList);
    }
}
