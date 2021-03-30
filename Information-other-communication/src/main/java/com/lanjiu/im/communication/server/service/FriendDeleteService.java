package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.im.grpc.client.util.ConstantsSelectKind;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class FriendDeleteService {

    private final Logger logger = Logger.getLogger(FriendDeleteService.class);

    public void deleteGuestUserFriendServiceAPI(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        StorageAPI storageAPI = new StorageAPI();
        JCRC32 jcrc32 = new JCRC32();
        //装载grpc协议请求信息
        TransmissionRequest transmissionRequest ;
        List<RpcGuestUserFriend> list ;
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response ;
        FriendUtils friendUtils = new FriendUtils();
        List<BusinessProtocolEntities.TouristsFriend> touristsFriendList = unifiedEntranceMessage.getFriendListProtocol().getTouristsFriendList();
        for (BusinessProtocolEntities.TouristsFriend touristsFriend : touristsFriendList){
            if(IMSContacts.UserType.TOURISTS_USER.equals(touristsFriend.getUserType())){
                transmissionRequest = TransmissionRequest.newBuilder()
                        .setRequestKind(ConstantsSelectKind.FRIEND_DELETE_TYPE_BY_FRIEND_ID)
                        .setGuestUserFriend(RpcGuestUserFriend.newBuilder().setFriendId(Integer.parseInt(touristsFriend.getFriendId())).build())
                        .build();
                GuestUserFriendResponse guestUserFriendResponse = storageAPI.deleteGuestUserFriendAPI(transmissionRequest);
                list = guestUserFriendResponse.getResponseDataList();

                List<BusinessProtocolEntities.TouristsFriend> touristsFriendByFriendUserIdList = friendUtils.guestUserFriendList(unifiedEntranceMessage, list);

                //commonUtils.isHave(list)
                CommonUtils<BusinessProtocolEntities.TouristsFriend> commonUtils = new CommonUtils<>();
                if(commonUtils.isHave(touristsFriendByFriendUserIdList)){
                    touristsFriend = touristsFriendByFriendUserIdList.get(0);
                }
                BusinessProtocolMessages.FriendDeleteProtocol friendDeleteProtocol = BusinessProtocolMessages.FriendDeleteProtocol.newBuilder()
                        .setTouristsFriend(touristsFriend)
                        .setUserType(unifiedEntranceMessage.getFriendDeleteProtocol().getUserType())
                        .setTouristsUser(unifiedEntranceMessage.getFriendDeleteProtocol().getTouristsUser())
                        .setRegisteredUser(unifiedEntranceMessage.getFriendDeleteProtocol().getRegisteredUser())
                        .setRegisteredFriend(unifiedEntranceMessage.getFriendDeleteProtocol().getRegisteredFriend())
                        .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .build();
                BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                        .newBuilder().setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendDeleteProtocol)
                        .setFriendDeleteProtocol(friendDeleteProtocol)
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
                ctx.writeAndFlush(response);
            }

        }
    }

    public void deleteRegisteredUserFriendServiceAPI(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        StorageAPI storageAPI = new StorageAPI();
        JCRC32 jcrc32 = new JCRC32();
        //装载grpc协议请求信息
        TransmissionRequest transmissionRequest;
        List<RpcRegisteredUserFriend> listRegistered ;
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response ;
        FriendUtils friendUtils = new FriendUtils();
        //获取被删除的好友实体
        BusinessProtocolEntities.RegisteredFriend registeredFriend = unifiedEntranceMessage.getFriendDeleteProtocol().getRegisteredFriend();
        //获取操作用户实体
        BusinessProtocolEntities.RegisteredUser registeredUser = unifiedEntranceMessage.getFriendDeleteProtocol().getRegisteredUser();
        if(IMSContacts.UserType.REGISTERED_USER.equals(registeredFriend.getUserType())){
            transmissionRequest = TransmissionRequest.newBuilder()
                                    .setRegisteredUserFriend(RpcRegisteredUserFriend.newBuilder()
                                    .setRegisteredUserId(Integer.parseInt(registeredUser.getUserId()))
                                    .setFriendUserId(Integer.parseInt(registeredFriend.getFriendUserId())).build()).build();
            RegisteredUserFriendResponse registeredUserFriendResponse = storageAPI.deleteRegisteredUserFriendAPI(transmissionRequest);
            listRegistered = registeredUserFriendResponse.getResponseDataList();

            List<BusinessProtocolEntities.RegisteredFriend> registeredFriendByFriendUserIdList = friendUtils.registeredUserFriendList(listRegistered);
            CommonUtils<BusinessProtocolEntities.RegisteredFriend> commonUtils = new CommonUtils<>();
            if(commonUtils.isHave(registeredFriendByFriendUserIdList)){
                registeredFriend = registeredFriendByFriendUserIdList.get(0);
            }
            BusinessProtocolMessages.FriendDeleteProtocol friendDeleteProtocol = BusinessProtocolMessages.FriendDeleteProtocol.newBuilder()
                    .setTouristsFriend(unifiedEntranceMessage.getFriendDeleteProtocol().getTouristsFriend())
                    .setUserType(unifiedEntranceMessage.getFriendDeleteProtocol().getUserType())
                    .setTouristsUser(unifiedEntranceMessage.getFriendDeleteProtocol().getTouristsUser())
                    .setRegisteredUser(unifiedEntranceMessage.getFriendDeleteProtocol().getRegisteredUser())
                    .setRegisteredFriend(registeredFriend)
                    .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                    .build();
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                    .newBuilder().setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendDeleteProtocol)
                    .setFriendDeleteProtocol(friendDeleteProtocol)
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                    .setMsgType(head.getMsgType())
                    .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                    .setFromId(head.getFromId())
                    .setToId(head.getToId())
                    .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                    .setToken(head.getToken())
                    .setUniqueIdentify(head.getUniqueIdentify())
                    .setMsgContentType(head.getMsgContentType())
                    .build()).build();
            response = jcrc32.packageCheckSum(message);
            ctx.writeAndFlush(response);
        }
    }
}
