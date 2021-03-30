package com.lanjiu.im.grpc.server.controller.query;

import com.lanjiu.im.grpc.RpcRegisteredUserFriend;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.dao.mapper.impl.RegisteredUserFriendMapper;
import com.lanjiu.im.grpc.pojo.RegisteredUserFriend;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

public class QueryRegisteredFriendInfoService {

    private static final Logger logger = Logger.getLogger(QueryRegisteredFriendInfoService.class.getName());

    public RpcRegisteredUserFriend queryFriendRelation(TransmissionRequest request){
        RpcRegisteredUserFriend userFriend = request.getRegisteredUserFriend();
        SqlSession session = DBTools.getSession();

        int registeredUserId = userFriend.getRegisteredUserId();
        int friendUserId = userFriend.getFriendUserId();
        logger.info("查询好友关系的用户ID："+registeredUserId+"---好友ID:"+friendUserId);
        RegisteredUserFriendMapper mapper = session.getMapper(RegisteredUserFriendMapper.class);
        try {
            List<RegisteredUserFriend> userFriends = mapper.selectRegisteredUserFriendByRegisteredUserIdAndFriendUserId(registeredUserId, friendUserId);
            if(null!= userFriends && userFriends.size()>0){
                RpcRegisteredUserFriend friend = RpcRegisteredUserFriend.newBuilder()
                        .setFriendId(userFriends.get(0).getFriendId())
                        .setRegisteredUserId(userFriends.get(0).getRegisteredUserId())
                        .setFriendUserId(userFriends.get(0).getFriendUserId())
                        .setOfflineMessageSetting(userFriends.get(0).getOfflineMessageSetting())
                        .setBurnAfterReadingSetting(userFriends.get(0).getBurnAfterReadingSetting())
                        .setBurnAfterReadingTimeUnit(userFriends.get(0).getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(userFriends.get(0).getBurnAfterReadingTimeLength().floatValue())
                        .build();
                session.commit();
                session.close();
                return friend;
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }
        return null;
    }

}
