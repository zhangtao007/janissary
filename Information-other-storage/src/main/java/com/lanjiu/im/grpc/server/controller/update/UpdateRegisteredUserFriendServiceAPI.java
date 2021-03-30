package com.lanjiu.im.grpc.server.controller.update;

import com.lanjiu.im.grpc.RpcRegisteredUserFriend;
import com.lanjiu.im.grpc.dao.mapper.impl.RegisteredUserFriendMapper;
import com.lanjiu.im.grpc.pojo.RegisteredUserFriend;
import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UpdateRegisteredUserFriendServiceAPI {

    private static final Logger logger = Logger.getLogger(UpdateRegisteredUserFriendServiceAPI.class.getName());

    public RegisteredUserFriend updateRegisteredUserFriend(RpcRegisteredUserFriend rpcRegisteredUserFriend,String type){
        SqlSession session = DBTools.getSession();
        Integer registeredUserId = rpcRegisteredUserFriend.getRegisteredUserId();
        Integer friendUserId = rpcRegisteredUserFriend.getFriendUserId();
        Timestamp modificationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        RegisteredUserFriendMapper registeredUserFriendMapper = session.getMapper(RegisteredUserFriendMapper.class);

        if(type.equalsIgnoreCase(ConstantsContent.FRIEND_ALIAS)){
            String friendComment = rpcRegisteredUserFriend.getFriendComment();
            RegisteredUserFriend registeredUserFriend = new RegisteredUserFriend();
            registeredUserFriend.setRegisteredUserId(registeredUserId);
            registeredUserFriend.setFriendUserId(friendUserId);
            registeredUserFriend.setFriendComment(friendComment);
            registeredUserFriend.setModificationTime(modificationTime);
            int res=0;
            try {
                res=registeredUserFriendMapper.updateFriendAlias(registeredUserId,friendUserId,friendComment,modificationTime);
            } catch (Exception e) {
                logger.error("好友备注设置updateRegisteredUserFriend",e);
                session.rollback();
            }finally {
                session.commit();
                session.close();
            }

            return registeredUserFriend;
        }else if(type.equalsIgnoreCase(ConstantsContent.FRIEND_OFFLINE_SET)){
            String offlineMessageSetting = rpcRegisteredUserFriend.getOfflineMessageSetting();
            RegisteredUserFriend registeredUserFriend = new RegisteredUserFriend();
            registeredUserFriend.setRegisteredUserId(registeredUserId);
            registeredUserFriend.setFriendUserId(friendUserId);
            registeredUserFriend.setModificationTime(modificationTime);
            registeredUserFriend.setOfflineMessageSetting(offlineMessageSetting);
            int res=0;
            try {
                res = registeredUserFriendMapper.updateFriendOfflineSet(registeredUserId,friendUserId,modificationTime,offlineMessageSetting);
            } catch (Exception e) {
                logger.error("离线消息接收设置updateRegisteredUserFriend",e);
                session.rollback();
            }finally {
                session.commit();
                session.close();
            }

            return registeredUserFriend;
        }


//        String friendComment = rpcRegisteredUserFriend.getFriendComment();
//        Timestamp creationTime = new Timestamp(rpcRegisteredUserFriend.getCreationTime());
//        String burnAfterReadingSettings = rpcRegisteredUserFriend.getBurnAfterReadingSetting();
//        String burnAfterReadingTimeUnit = rpcRegisteredUserFriend.getBurnAfterReadingTimeUnit();
//        float length = rpcRegisteredUserFriend.getBurnAfterReadingTimeLength();
//        BigDecimal burnAfterReadingTimeLength = new BigDecimal(length);
//        String offlineMessageSetting = rpcRegisteredUserFriend.getOfflineMessageSetting();
//        String friendNickName = rpcRegisteredUserFriend.getFriendNickName();

//        RegisteredUserFriend registeredUserFriend = new RegisteredUserFriend();
//        registeredUserFriend.setRegisteredUserId(registeredUserId);
//        registeredUserFriend.setFriendUserId(friendUserId);
//        registeredUserFriend.setFriendComment(friendComment);
//        registeredUserFriend.setCreationTime(creationTime);
//        registeredUserFriend.setModificationTime(modificationTime);
//        registeredUserFriend.setOfflineMessageSetting(offlineMessageSetting);
//        registeredUserFriend.setBurnAfterReadingSetting(burnAfterReadingSettings);
//        registeredUserFriend.setBurnAfterReadingTimeUnit(burnAfterReadingTimeUnit);
//        registeredUserFriend.setBurnAfterReadingTimeLength(burnAfterReadingTimeLength);
//        registeredUserFriend.setFriendNickName(friendNickName);

//        boolean bResult = updateRegisteredUserFriendService(session, registeredUserFriend);
//        if(bResult){
//            return registeredUserFriend;
//        }else {
//            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
//        }
        return null;
    }

    public boolean updateRegisteredUserFriendService(SqlSession session, RegisteredUserFriend registeredUserFriend){
        RegisteredUserFriendMapper registeredUserFriendMapper = session.getMapper(RegisteredUserFriendMapper.class);
        int result = 0;
        try {
            RegisteredUserFriend relation = registeredUserFriendMapper.getRelationByRegisteredUserIdAndFriendUserId(registeredUserFriend.getRegisteredUserId(), registeredUserFriend.getFriendUserId());
            result = registeredUserFriendMapper.updateRegisteredUserFriendByRidAndFid(registeredUserFriend.getRegisteredUserId(),
                    registeredUserFriend.getFriendUserId(), registeredUserFriend.getFriendComment(),
                    registeredUserFriend.getModificationTime(), registeredUserFriend.getOfflineMessageSetting(),
                    registeredUserFriend.getBurnAfterReadingSetting(), registeredUserFriend.getBurnAfterReadingTimeUnit(),
                    registeredUserFriend.getBurnAfterReadingTimeLength(), relation.getFriendNickName());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        if(result > 0){
            return true;
        }else {
            return false;
        }
    }
}
