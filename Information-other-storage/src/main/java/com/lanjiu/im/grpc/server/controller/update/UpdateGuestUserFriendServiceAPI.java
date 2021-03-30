package com.lanjiu.im.grpc.server.controller.update;

import com.lanjiu.im.grpc.RpcGuestUserFriend;
import com.lanjiu.im.grpc.dao.mapper.impl.GuestUserFriendMapper;
import com.lanjiu.im.grpc.pojo.GuestUserFriend;
import com.lanjiu.im.grpc.util.ConstantsDefault;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UpdateGuestUserFriendServiceAPI {

    private static final Logger logger = Logger.getLogger(UpdateGuestUserFriendServiceAPI.class.getName());

    public GuestUserFriend updateGuestUserFriend(RpcGuestUserFriend rpcGuestUserFriend){
        SqlSession session = DBTools.getSession();
        int friendId = rpcGuestUserFriend.getFriendId();
        if((0 == friendId)){
            logger.info(ConstantsDefault.FRIEND_USER_ID_UNDEFAULT_UPDATE);
            return null;
        }
        Integer guestUserId = rpcGuestUserFriend.getGuestUserId();
        if((0 == guestUserId)){
            logger.info(ConstantsDefault.FRIEND_USER_ID_UNDEFAULT);
            return null;
        }
        Integer friendUserId = rpcGuestUserFriend.getFriendUserId();
        if((0 == friendUserId)){
            logger.info(ConstantsDefault.FRIEND_FRIEND_USER_ID_UNDEFAULT);
            return null;
        }
        String friendComment = rpcGuestUserFriend.getFriendComment();
        Timestamp creationTime = new Timestamp(rpcGuestUserFriend.getCreationTime());
        Timestamp modificationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        String burnAfterReadingSettings = rpcGuestUserFriend.getBurnAfterReadingSetting();
        if(("".equals(burnAfterReadingSettings))||(null == burnAfterReadingSettings)){
            burnAfterReadingSettings = ConstantsDefault.BURN_AFTER_READING_SETTING_OFF;
        }
        String burnAfterReadingTimeUnit = rpcGuestUserFriend.getBurnAfterReadingTimeUnit();
        if(("".equals(burnAfterReadingTimeUnit))||(null == burnAfterReadingTimeUnit)){
            burnAfterReadingTimeUnit = ConstantsDefault.TIME_UNIT_SECOND;
        }
        float length = rpcGuestUserFriend.getBurnAfterReadingTimeLength();
        BigDecimal burnAfterReadingTimeLength = new BigDecimal(length);
        String offlineMessageSetting = rpcGuestUserFriend.getOfflineMessageSetting();
        if(("".equals(offlineMessageSetting))||(null == offlineMessageSetting)){
            offlineMessageSetting = ConstantsDefault.OFFLINE_MESSAGE_SETTING_OFF;
        }
        String friendNickName = rpcGuestUserFriend.getFriendNickName();
        if(("".equals(friendNickName))||(null == friendNickName)){
            friendNickName = String.valueOf(friendId);
        }
        GuestUserFriend guestUserFriend = new GuestUserFriend();
        guestUserFriend.setGuestUserId(guestUserId);
        guestUserFriend.setFriendId(friendId);
        guestUserFriend.setFriendUserId(friendUserId);
        guestUserFriend.setFriendComment(friendComment);
        guestUserFriend.setCreationTime(creationTime);
        guestUserFriend.setModificationTime(modificationTime);
        guestUserFriend.setOfflineMessageSetting(offlineMessageSetting);
        guestUserFriend.setBurnAfterReadingSetting(burnAfterReadingSettings);
        guestUserFriend.setBurnAfterReadingTimeUnit(burnAfterReadingTimeUnit);
        guestUserFriend.setBurnAfterReadingTimeLength(burnAfterReadingTimeLength);
        guestUserFriend.setFriendNickName(friendNickName);

        boolean bResult = updateGuestUserFriendService(session, guestUserFriend);
        if(bResult){
            return guestUserFriend;
        }else {
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
        }
        return null;
    }

    public boolean updateGuestUserFriendService(SqlSession session, GuestUserFriend guestUserFriend){
        GuestUserFriendMapper guestUserFriendMapper = session.getMapper(GuestUserFriendMapper.class);
        //
        int result = 0;
        try {
            result = guestUserFriendMapper.updateGuestUserFriend(guestUserFriend.getGuestUserId(), guestUserFriend.getFriendId(),
                    guestUserFriend.getFriendUserId(),
                    guestUserFriend.getFriendComment(), guestUserFriend.getCreationTime(),
                    guestUserFriend.getModificationTime(), guestUserFriend.getOfflineMessageSetting(),
                    guestUserFriend.getBurnAfterReadingSetting(), guestUserFriend.getBurnAfterReadingTimeUnit(),
                    guestUserFriend.getBurnAfterReadingTimeLength(), guestUserFriend.getFriendNickName());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        System.out.println("result: " + result);
        if(result > 0){
            return true;
        }else {
            return false;
        }
    }
}
