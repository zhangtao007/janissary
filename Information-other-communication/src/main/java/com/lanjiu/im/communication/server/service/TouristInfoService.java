package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.grpc.AllGroupsMemberResponse;
import com.lanjiu.im.grpc.RpcGuestUserFriend;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.im.grpc.client.util.ConstantsSelectKind;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelHandlerContext;

public class TouristInfoService {

    //游客退出登录服务--删除所有游客信息和好友以及所有所在群
    public void touristExitServcie(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, ChannelHandlerContext ctx){
        StorageAPI storageAPI = new StorageAPI();
        BusinessProtocolEntities.TouristsUser touristsUser = unifiedEntranceMessage.getFriendListProtocol().getTouristsUser();
        int userId = Integer.parseInt(touristsUser.getTemporaryId());
        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
                .setRequestKind(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_FRIEND_USER_ID)
                .setGuestUserFriend(RpcGuestUserFriend.newBuilder().setGuestUserId(userId).build())
                .build();
        AllGroupsMemberResponse allGroupsMemberResponse = storageAPI.touristExitServcie(transmissionRequest);
    }
}
