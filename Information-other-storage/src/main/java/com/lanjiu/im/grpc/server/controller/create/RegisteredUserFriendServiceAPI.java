package com.lanjiu.im.grpc.server.controller.create;

import com.lanjiu.im.grpc.RpcRegisteredUserFriend;
import com.lanjiu.im.grpc.dao.mapper.impl.FriendUnusedBeautifulNumberRealMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.FriendUsedBeautifulNumberRealMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.RegisteredUserFriendMapper;
import com.lanjiu.im.grpc.pojo.FriendUnusedBeautifulNumberReal;
import com.lanjiu.im.grpc.pojo.RegisteredUserFriend;
import com.lanjiu.im.grpc.server.controller.GetRegisteredFriendBeautifulNumberId;
import com.lanjiu.im.grpc.util.ConstantsDefault;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class RegisteredUserFriendServiceAPI {

    private static final Logger logger = Logger.getLogger(RegisteredUserFriendServiceAPI.class.getName());

    public RegisteredUserFriend createRegisteredUserFriend(RpcRegisteredUserFriend rpcRegisteredUserFriend){
        SqlSession session = DBTools.getSession();
        Integer registeredUserId = rpcRegisteredUserFriend.getRegisteredUserId();
        if((0 == registeredUserId)){
            logger.info(ConstantsDefault.FRIEND_USER_ID_UNDEFAULT);
            return null;
        }
        Integer friendUserId = rpcRegisteredUserFriend.getFriendUserId();
        if((0 == friendUserId)){
            logger.info(ConstantsDefault.FRIEND_FRIEND_USER_ID_UNDEFAULT);
            return null;
        }
        String friendComment = rpcRegisteredUserFriend.getFriendComment();
        if(("".equals(friendComment))||(null == friendComment)){
            friendComment = ConstantsDefault.FRIEND_COMMENT_DEFAULT;
        }
        float length = rpcRegisteredUserFriend.getBurnAfterReadingTimeLength();
        BigDecimal burnAfterReadingTimeLength = new BigDecimal(length);
        String friendNickName = rpcRegisteredUserFriend.getFriendNickName();
        if(("".equals(friendNickName))||(null == friendNickName)){
            friendNickName = String.valueOf(registeredUserId);
        }
        RegisteredUserFriend registeredUserFriend = new RegisteredUserFriend();
        registeredUserFriend.setRegisteredUserId(registeredUserId);
        registeredUserFriend.setFriendUserId(friendUserId);
        registeredUserFriend.setFriendComment(friendComment);
        registeredUserFriend.setOfflineMessageSetting(ConstantsDefault.OFFLINE_MESSAGE_SETTING_ON);
        registeredUserFriend.setBurnAfterReadingSetting(ConstantsDefault.BURN_AFTER_READING_SETTING_ON);
        registeredUserFriend.setBurnAfterReadingTimeUnit(ConstantsDefault.TIME_UNIT_SECOND);
        registeredUserFriend.setBurnAfterReadingTimeLength(burnAfterReadingTimeLength);
        registeredUserFriend.setFriendNickName(friendNickName);

        boolean bResult = insertFriend(session, registeredUserFriend);
        if(bResult){
            return registeredUserFriend;
        }else {
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
        }
        return null;
    }

    public boolean insertFriend(SqlSession session, RegisteredUserFriend registeredUserFriend){
        RegisteredUserFriendMapper registeredUserFriendMapper = session.getMapper(RegisteredUserFriendMapper.class);
        Timestamp creationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        Timestamp modificationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        int result = 0;
        try {
            result = registeredUserFriendMapper.insertRegisteredUserFriend(registeredUserFriend.getRegisteredUserId(),
                    registeredUserFriend.getFriendUserId(),registeredUserFriend.getFriendComment(),
                    creationTime,modificationTime, registeredUserFriend.getOfflineMessageSetting(),
                    registeredUserFriend.getBurnAfterReadingSetting(), registeredUserFriend.getBurnAfterReadingTimeUnit(),
                    registeredUserFriend.getBurnAfterReadingTimeLength(), registeredUserFriend.getFriendNickName());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        if(result > 0){
            return true;
        }else {
            return false;
        }
    }
}
