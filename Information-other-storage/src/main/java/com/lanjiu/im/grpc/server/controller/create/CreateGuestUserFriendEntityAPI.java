package com.lanjiu.im.grpc.server.controller.create;

import com.lanjiu.im.grpc.GuestUserFriendResponse;
import com.lanjiu.im.grpc.RpcGuestUserFriend;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.dao.mapper.impl.GuestUserFriendMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.RegisteredUserFriendMapper;
import com.lanjiu.im.grpc.pojo.GuestUserFriend;
import com.lanjiu.im.grpc.pojo.RegisteredUserFriend;
import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;


public class CreateGuestUserFriendEntityAPI {

    private static final Logger logger = Logger.getLogger(CreateGuestUserFriendEntityAPI.class.getName());

    public GuestUserFriendResponse createGuestUserFriend(TransmissionRequest request){
        SqlSession session = DBTools.getSession();
        RpcGuestUserFriend rpcGuestUserFriend = request.getGuestUserFriend();
        GuestUserFriendMapper guestUserFriendMapper = session.getMapper(GuestUserFriendMapper.class);
        RegisteredUserFriendMapper registeredUserFriendMapper = session.getMapper(RegisteredUserFriendMapper.class);
        int friendUserId = rpcGuestUserFriend.getFriendUserId();
        int guestUserId = rpcGuestUserFriend.getGuestUserId();
        //判断是否已经是好友了，不能重复添加
        try {
            List<GuestUserFriend> guestUserFriends1 = guestUserFriendMapper.selectGuestUserFriendByGuestUserIdAndFriendUserId(friendUserId, guestUserId);
            List<GuestUserFriend> guestUserFriends2 = guestUserFriendMapper.selectGuestUserFriendByGuestUserIdAndFriendUserId(guestUserId,friendUserId);
            List<RegisteredUserFriend> registeredUserFriends = registeredUserFriendMapper.selectRegisteredUserFriendByRegisteredUserIdAndFriendUserId(friendUserId, guestUserId);
            if(guestUserFriends1.size() > 0 && guestUserFriends2.size() > 0){
                logger.info("----游客好友重复添加3----");
                GuestUserFriendResponse guestUserFriendResponse1 = GuestUserFriendResponse.newBuilder().setStatusDetail("repeated").build();
                return guestUserFriendResponse1;
            }
            if(guestUserFriends2.size() > 0 && registeredUserFriends.size() > 0){
                logger.info("----游客好友重复添加4----");
                GuestUserFriendResponse guestUserFriendResponse1 = GuestUserFriendResponse.newBuilder().setStatusDetail("repeated").build();
                return guestUserFriendResponse1;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        GuestUserFriendServiceAPI guestUserFriendService = new GuestUserFriendServiceAPI();

        GuestUserFriend guestUserFriend = guestUserFriendService.createGuestUserFriend(rpcGuestUserFriend);
        if(null == guestUserFriend){
            return null;
        }
        GuestUserFriendResponse guestUserFriendResponse = GuestUserFriendResponse.newBuilder()
                .addResponseData(RpcGuestUserFriend.newBuilder()
                        .setGuestUserId(guestUserFriend.getGuestUserId())
                        .setFriendUserId(guestUserFriend.getFriendUserId())
                        .setFriendComment(guestUserFriend.getFriendComment())
//                        .setCreationTime(guestUserFriend.getCreationTime().getTime())
//                        .setModificationTime(guestUserFriend.getModificationTime().getTime())
                        .setOfflineMessageSetting(guestUserFriend.getOfflineMessageSetting())
                        .setBurnAfterReadingSetting(guestUserFriend.getBurnAfterReadingSetting())
                        .setBurnAfterReadingTimeUnit(guestUserFriend.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(guestUserFriend.getBurnAfterReadingTimeLength().floatValue())
                        .setFriendNickName(guestUserFriend.getFriendNickName())
                        .build())
                        .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS).build();

        return guestUserFriendResponse;
    }
}
