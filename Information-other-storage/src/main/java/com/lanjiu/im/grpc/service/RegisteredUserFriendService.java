package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.RegisteredUserFriendMapper;
import com.lanjiu.im.grpc.pojo.RegisteredUserFriend;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class RegisteredUserFriendService {

    public int insertRecord(SqlSession session, RegisteredUserFriendMapper mapperb, RegisteredUserFriend registeredUserFriend){
        Timestamp creationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        Timestamp modificationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        int result = 0;
        try {
            result = mapperb.insertRegisteredUserFriend(registeredUserFriend.getRegisteredUserId(),
                    registeredUserFriend.getFriendUserId(), registeredUserFriend.getFriendComment(),
                    creationTime,modificationTime,
                    registeredUserFriend.getOfflineMessageSetting(),
                    registeredUserFriend.getBurnAfterReadingSetting(), registeredUserFriend.getBurnAfterReadingTimeUnit(),
                    registeredUserFriend.getBurnAfterReadingTimeLength(), registeredUserFriend.getFriendNickName());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int updateRecord(SqlSession session, RegisteredUserFriendMapper mapperb, RegisteredUserFriend registeredUserFriend){
        int result = 0;
        try {
            result = mapperb.updateRegisteredUserFriend(registeredUserFriend.getRegisteredUserId(),
                    registeredUserFriend.getFriendId(), registeredUserFriend.getFriendUserId(), registeredUserFriend.getFriendComment(),
                    registeredUserFriend.getModificationTime(), registeredUserFriend.getOfflineMessageSetting(),
                    registeredUserFriend.getBurnAfterReadingSetting(), registeredUserFriend.getBurnAfterReadingTimeUnit(),
                    registeredUserFriend.getBurnAfterReadingTimeLength(), registeredUserFriend.getFriendNickName());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecordByFriendId(SqlSession session, RegisteredUserFriendMapper mapperb, RegisteredUserFriend registeredUserFriend){
        int result = 0;
        try {
            result = mapperb.deleteRegisteredUserFriendByFriendId(registeredUserFriend.getFriendId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecordByRegisteredUserId(SqlSession session, RegisteredUserFriendMapper mapperb, RegisteredUserFriend registeredUserFriend){
        int result = 0;
        try {
            result = mapperb.deleteRegisteredUserFriendByRegisteredUserId(registeredUserFriend.getRegisteredUserId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<RegisteredUserFriend> selectRegisteredUserFriend(SqlSession session, RegisteredUserFriendMapper mapperb, RegisteredUserFriend registeredUserFriend) {
        List<RegisteredUserFriend> bList = null;
        try {
            bList = mapperb.selectRegisteredUserFriend(registeredUserFriend.getRegisteredUserId(),
                    registeredUserFriend.getFriendId(), registeredUserFriend.getFriendUserId(),
                    registeredUserFriend.getFriendComment(), registeredUserFriend.getCreationTime(),
                    registeredUserFriend.getModificationTime(), registeredUserFriend.getOfflineMessageSetting(),
                    registeredUserFriend.getBurnAfterReadingSetting(), registeredUserFriend.getBurnAfterReadingTimeUnit(),
                    registeredUserFriend.getBurnAfterReadingTimeLength(), registeredUserFriend.getFriendNickName());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredUserFriend> selectRegisteredUserFriendByRegisteredUserId(SqlSession session, RegisteredUserFriendMapper mapperb, RegisteredUserFriend registeredUserFriend) {
        List<RegisteredUserFriend> bList = null;
        try {
            bList = mapperb.selectRegisteredUserFriendByRegisteredUserId(registeredUserFriend.getRegisteredUserId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredUserFriend> selectRegisteredUserFriendByFriendUserId(SqlSession session, RegisteredUserFriendMapper mapperb, RegisteredUserFriend registeredUserFriend) {
        List<RegisteredUserFriend> bList = null;
        try {
            bList = mapperb.selectRegisteredUserFriendByRegisteredUserId(registeredUserFriend.getRegisteredUserId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredUserFriend> selectRegisteredUserFriendByFriendId(SqlSession session, RegisteredUserFriendMapper mapperb, RegisteredUserFriend registeredUserFriend) {
        List<RegisteredUserFriend> bList = null;
        try {
            bList = mapperb.selectRegisteredUserFriendByFriendId(registeredUserFriend.getFriendId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredUserFriend> selectRegisteredUserFriendByFriendIdLike(SqlSession session, RegisteredUserFriendMapper mapperb, RegisteredUserFriend registeredUserFriend) {
        List<RegisteredUserFriend> bList = null;
        try {
            bList = mapperb.selectRegisteredUserFriendByFriendIdLike(registeredUserFriend.getFriendId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredUserFriend> selectRegisteredUserFriendByRegisteredUserIdAndFriendId(SqlSession session, RegisteredUserFriendMapper mapperb, RegisteredUserFriend registeredUserFriend) {
        List<RegisteredUserFriend> bList = null;
        try {
            bList = mapperb.selectRegisteredUserFriendByRegisteredUserIdAndFriendId(registeredUserFriend.getRegisteredUserId(), registeredUserFriend.getFriendId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredUserFriend> selectRegisteredUserFriendByOfflineMessageSetting(SqlSession session, RegisteredUserFriendMapper mapperb, RegisteredUserFriend registeredUserFriend) {
        List<RegisteredUserFriend> bList = null;
        try {
            bList = mapperb.selectRegisteredUserFriendByOfflineMessageSetting(registeredUserFriend.getOfflineMessageSetting());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredUserFriend> selectRegisteredUserFriendByBurnAfterReadingSetting(SqlSession session, RegisteredUserFriendMapper mapperb, RegisteredUserFriend registeredUserFriend) {
        List<RegisteredUserFriend> bList = null;
        try {
            bList = mapperb.selectRegisteredUserFriendByBurnAfterReadingSetting(registeredUserFriend.getBurnAfterReadingSetting());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredUserFriend> selectAllRecords(SqlSession session, RegisteredUserFriendMapper mapperb) {
        List<RegisteredUserFriend> bList = null;
        try {
            bList = mapperb.selectAllRegisteredUserFriend();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
