package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.GuestUserFriendMapper;
import com.lanjiu.im.grpc.pojo.GuestUserFriend;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GuestUserFriendService {

    public int insertRecord(SqlSession session, GuestUserFriendMapper mapperb, GuestUserFriend guestUserFriend){
        int result = 0;
        try {
            result = mapperb.insertGuestUserFriend(guestUserFriend.getGuestUserId(), guestUserFriend.getFriendUserId(),
                    guestUserFriend.getFriendComment(), guestUserFriend.getCreationTime(),
                    guestUserFriend.getModificationTime(), guestUserFriend.getOfflineMessageSetting(),
                    guestUserFriend.getBurnAfterReadingSetting(), guestUserFriend.getBurnAfterReadingTimeUnit(),
                    guestUserFriend.getBurnAfterReadingTimeLength(), guestUserFriend.getFriendNickName());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int updateRecord(SqlSession session, GuestUserFriendMapper mapperb, GuestUserFriend guestUserFriend){
        int result = 0;
        try {
            result = mapperb.updateGuestUserFriend(guestUserFriend.getGuestUserId(),
                    guestUserFriend.getFriendId(), guestUserFriend.getFriendUserId(),
                    guestUserFriend.getFriendComment(), guestUserFriend.getCreationTime(),
                    guestUserFriend.getModificationTime(), guestUserFriend.getOfflineMessageSetting(),
                    guestUserFriend.getBurnAfterReadingSetting(), guestUserFriend.getBurnAfterReadingTimeUnit(),
                    guestUserFriend.getBurnAfterReadingTimeLength(), guestUserFriend.getFriendNickName());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecordByFriendId(SqlSession session, GuestUserFriendMapper mapperb, GuestUserFriend guestUserFriend){
        int result = 0;
        try {
            result = mapperb.deleteGuestUserFriendByFriendId(guestUserFriend.getFriendId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecordByGuestUserId(SqlSession session, GuestUserFriendMapper mapperb, GuestUserFriend guestUserFriend){
        int result = 0;
        try {
            result = mapperb.deleteGuestUserFriendByGuestUserId(guestUserFriend.getGuestUserId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GuestUserFriend> selectGuestUserFriend(SqlSession session, GuestUserFriendMapper mapperb, GuestUserFriend guestUserFriend) {
        List<GuestUserFriend> bList = null;
        try {
            bList = mapperb.selectGuestUserFriend(guestUserFriend.getGuestUserId(),
                    guestUserFriend.getFriendId(), guestUserFriend.getFriendUserId(),
                    guestUserFriend.getFriendComment(), guestUserFriend.getCreationTime(),
                    guestUserFriend.getModificationTime(), guestUserFriend.getOfflineMessageSetting(),
                    guestUserFriend.getBurnAfterReadingSetting(), guestUserFriend.getBurnAfterReadingTimeUnit(),
                    guestUserFriend.getBurnAfterReadingTimeLength(), guestUserFriend.getFriendNickName());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestUserFriend> selectGuestUserFriendByGuestUserId(SqlSession session, GuestUserFriendMapper mapperb, GuestUserFriend guestUserFriend) {
        List<GuestUserFriend> bList = null;
        try {
            bList = mapperb.selectGuestUserFriendByGuestUserId(guestUserFriend.getGuestUserId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestUserFriend> selectGuestUserFriendByFriendUserId(SqlSession session, GuestUserFriendMapper mapperb, GuestUserFriend guestUserFriend) {
        List<GuestUserFriend> bList = null;
        try {
            bList = mapperb.selectGuestUserFriendByGuestUserId(guestUserFriend.getFriendUserId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestUserFriend> selectGuestUserFriendByFriendId(SqlSession session, GuestUserFriendMapper mapperb, GuestUserFriend guestUserFriend) {
        List<GuestUserFriend> bList = null;
        try {
            bList = mapperb.selectGuestUserFriendByFriendId(guestUserFriend.getFriendId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestUserFriend> selectGuestUserFriendByFriendIdLike(SqlSession session, GuestUserFriendMapper mapperb, GuestUserFriend guestUserFriend) {
        List<GuestUserFriend> bList = null;
        try {
            bList = mapperb.selectGuestUserFriendByFriendIdLike(guestUserFriend.getFriendId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestUserFriend> selectGuestUserFriendByGuestUserIdAndFriendId(SqlSession session, GuestUserFriendMapper mapperb, GuestUserFriend guestUserFriend) {
        List<GuestUserFriend> bList = null;
        try {
            bList = mapperb.selectGuestUserFriendByGuestUserIdAndFriendId(guestUserFriend.getGuestUserId(), guestUserFriend.getFriendId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestUserFriend> selectGuestUserFriendByOfflineMessageSetting(SqlSession session, GuestUserFriendMapper mapperb, GuestUserFriend guestUserFriend) {
        List<GuestUserFriend> bList = null;
        try {
            bList = mapperb.selectGuestUserFriendByOfflineMessageSetting(guestUserFriend.getOfflineMessageSetting());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestUserFriend> selectGuestUserFriendByBurnAfterReadingSetting(SqlSession session, GuestUserFriendMapper mapperb, GuestUserFriend guestUserFriend) {
        List<GuestUserFriend> bList = null;
        try {
            bList = mapperb.selectGuestUserFriendByBurnAfterReadingSetting(guestUserFriend.getBurnAfterReadingSetting());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestUserFriend> selectAllRecords(SqlSession session, GuestUserFriendMapper mapperb) {
        List<GuestUserFriend> bList = null;
        try {
            bList = mapperb.selectAllGuestUserFriend();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
