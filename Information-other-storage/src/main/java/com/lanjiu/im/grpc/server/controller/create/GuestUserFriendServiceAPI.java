package com.lanjiu.im.grpc.server.controller.create;

import com.lanjiu.im.grpc.RpcGuestUserFriend;
import com.lanjiu.im.grpc.dao.mapper.impl.*;
import com.lanjiu.im.grpc.pojo.*;
import com.lanjiu.im.grpc.server.controller.GetGuestFriendBeautifulNumberId;
import com.lanjiu.im.grpc.util.ConstantsDefault;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.math.BigDecimal;

public class GuestUserFriendServiceAPI {

    private static final Logger logger = Logger.getLogger(GuestUserFriendServiceAPI.class.getName());

    public GuestUserFriend createGuestUserFriend(RpcGuestUserFriend rpcGuestUserFriend){
        SqlSession session = DBTools.getSession();
        GetGuestFriendBeautifulNumberId getGuestUserFriendBeautifulNumberId = new GetGuestFriendBeautifulNumberId();
        FriendUnusedBeautifulNumber friendUnusedBeautifulNumber = getGuestUserFriendBeautifulNumberId.getGuestFriendId();
//        int friendId = getGuestUserFriendBeautifulNumberId.getGuestFriendIntId();
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
        if(("".equals(friendComment))||(null == friendComment)){
            friendComment = ConstantsDefault.FRIEND_COMMENT_DEFAULT;
        }
//        Timestamp creationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
//        Timestamp modificationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
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
//        if(("".equals(friendNickName))||(null == friendNickName)){
//            friendNickName = String.valueOf(friendId);
//        }
        GuestUserFriend guestUserFriend = new GuestUserFriend();
        guestUserFriend.setGuestUserId(guestUserId);
//        guestUserFriend.setFriendId(friendId);
        guestUserFriend.setFriendUserId(friendUserId);
        guestUserFriend.setFriendComment(friendComment);
        guestUserFriend.setOfflineMessageSetting(offlineMessageSetting);
        guestUserFriend.setBurnAfterReadingSetting(burnAfterReadingSettings);
        guestUserFriend.setBurnAfterReadingTimeUnit(burnAfterReadingTimeUnit);
        guestUserFriend.setBurnAfterReadingTimeLength(burnAfterReadingTimeLength);
        guestUserFriend.setFriendNickName(friendNickName);

        boolean bResult = insertFriend(session, friendUnusedBeautifulNumber, guestUserFriend);
        if(bResult){
            return guestUserFriend;
        }else {
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
        }
        return null;
    }

    public boolean insertFriend(SqlSession session, FriendUnusedBeautifulNumber friendUnusedBeautifulNumber, GuestUserFriend guestUserFriend){
        FriendUsedBeautifulNumberMapper groupUsedBeautifulNumberMapper = session.getMapper(FriendUsedBeautifulNumberMapper.class);
        FriendUnusedBeautifulNumberMapper mapperbFriendUnusedBeautifulNumberMapper = session.getMapper(FriendUnusedBeautifulNumberMapper.class);
        GuestUserFriendMapper guestUserFriendMapper = session.getMapper(GuestUserFriendMapper.class);
        int result = 0;
        try {
            result = groupUsedBeautifulNumberMapper.insertFriendUsedBeautifulNumber(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
                    friendUnusedBeautifulNumber.getOneHundredThousand(), friendUnusedBeautifulNumber.getTenThousand(),
                    friendUnusedBeautifulNumber.getOneThousand(), friendUnusedBeautifulNumber.getOneHundred(),
                    friendUnusedBeautifulNumber.getTen(), friendUnusedBeautifulNumber.getOne());
            result = mapperbFriendUnusedBeautifulNumberMapper.deleteFriendUnusedBeautifulNumber(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
                    friendUnusedBeautifulNumber.getOneHundredThousand(), friendUnusedBeautifulNumber.getTenThousand(),
                    friendUnusedBeautifulNumber.getOneThousand(), friendUnusedBeautifulNumber.getOneHundred(),
                    friendUnusedBeautifulNumber.getTen(), friendUnusedBeautifulNumber.getOne());
            result = guestUserFriendMapper.insertGuestUserFriend(guestUserFriend.getGuestUserId(),
                    guestUserFriend.getFriendUserId(), guestUserFriend.getFriendComment(), guestUserFriend.getCreationTime(),
                    guestUserFriend.getModificationTime(), guestUserFriend.getOfflineMessageSetting(),
                    guestUserFriend.getBurnAfterReadingSetting(), guestUserFriend.getBurnAfterReadingTimeUnit(),
                    guestUserFriend.getBurnAfterReadingTimeLength(), guestUserFriend.getFriendNickName());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        System.out.println(result);
        if(result > 0){
            return true;
        }else {
            return false;
        }
    }
}
