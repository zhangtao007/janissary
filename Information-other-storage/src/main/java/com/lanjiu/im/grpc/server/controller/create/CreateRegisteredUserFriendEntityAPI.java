package com.lanjiu.im.grpc.server.controller.create;

import com.lanjiu.im.grpc.RegisteredUserFriendResponse;
import com.lanjiu.im.grpc.RpcRegisteredUserFriend;
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


public class CreateRegisteredUserFriendEntityAPI {

    private static final Logger logger = Logger.getLogger(CreateRegisteredUserFriendEntityAPI.class.getName());

    public RegisteredUserFriendResponse createRegisteredUserFriend(TransmissionRequest request){
        SqlSession session = DBTools.getSession();
        RpcRegisteredUserFriend rpcRegisteredUserFriend = request.getRegisteredUserFriend();
        GuestUserFriendMapper guestUserFriendMapper = session.getMapper(GuestUserFriendMapper.class);
        RegisteredUserFriendMapper registeredUserFriendMapper = session.getMapper(RegisteredUserFriendMapper.class);
        int friendUserId = rpcRegisteredUserFriend.getFriendUserId();
        int registeredUserId = rpcRegisteredUserFriend.getRegisteredUserId();
        logger.info("添加好友用户ID：" + registeredUserId + "---被添加好友用户ID：" + friendUserId);
        //判断是否已经是好友了，不能重复添加
        try {
            List<RegisteredUserFriend> registeredUserFriends = registeredUserFriendMapper.selectRegisteredUserFriendByRegisteredUserIdAndFriendUserId(registeredUserId,friendUserId);
            List<RegisteredUserFriend> registeredUserFriends2 = registeredUserFriendMapper.selectRegisteredUserFriendByRegisteredUserIdAndFriendUserId(friendUserId,registeredUserId);
            List<GuestUserFriend> guestUserFriends = guestUserFriendMapper.selectGuestUserFriendByGuestUserIdAndFriendUserId(friendUserId, registeredUserId);
            if(registeredUserFriends.size() > 0 && registeredUserFriends2.size() > 0){
                logger.info("----注册用户好友重复添加1----");
                RegisteredUserFriendResponse registeredUserFriendResponse1 = RegisteredUserFriendResponse.newBuilder().setStatusDetail("repeated").build();
                return registeredUserFriendResponse1;
            }
            if(registeredUserFriends.size() > 0 && guestUserFriends.size() > 0){
                logger.info("----注册用户好友重复添加2----");
                RegisteredUserFriendResponse registeredUserFriendResponse1 = RegisteredUserFriendResponse.newBuilder().setStatusDetail("repeated").build();
                return registeredUserFriendResponse1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        RegisteredUserFriendServiceAPI registeredUserFriendServiceAPI = new RegisteredUserFriendServiceAPI();
        RegisteredUserFriend registeredUserFriend = registeredUserFriendServiceAPI.createRegisteredUserFriend(rpcRegisteredUserFriend);
        logger.info("添加好友返回对象："+registeredUserFriend.toString());
        if(null == registeredUserFriend){
            return null;
        }
        RegisteredUserFriendResponse registeredUserFriendResponse = RegisteredUserFriendResponse.newBuilder()
                .addResponseData(RpcRegisteredUserFriend.newBuilder()
                        .setRegisteredUserId(registeredUserFriend.getRegisteredUserId())
                        .setFriendUserId(registeredUserFriend.getFriendUserId())
                        .setFriendComment(registeredUserFriend.getFriendComment())
//                        .setCreationTime(registeredUserFriend.getCreationTime().getTime())
//                        .setModificationTime(registeredUserFriend.getModificationTime().getTime())
                        .setOfflineMessageSetting(registeredUserFriend.getOfflineMessageSetting())
                        .setBurnAfterReadingSetting(registeredUserFriend.getBurnAfterReadingSetting())
                        .setBurnAfterReadingTimeUnit(registeredUserFriend.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(registeredUserFriend.getBurnAfterReadingTimeLength().floatValue())
                        .setFriendNickName(registeredUserFriend.getFriendNickName())
                        .build()).setStatusDetail(ConstantsContent.RESPONSE_SUCCESS).build();

        return registeredUserFriendResponse;
    }
}
