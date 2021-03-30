package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.GuestGroupMapper;
import com.lanjiu.im.grpc.pojo.GuestGroup;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class GuestGroupService {

    public int insertRecord(SqlSession session, GuestGroupMapper mapperb, GuestGroup guestGroup){
        int result = 0;
        try {
            result = mapperb.insertGuestGroup(guestGroup.getGuestUserId(), guestGroup.getGroupId(),
                    guestGroup.getGroupName(), guestGroup.getGroupAnnouncementId(),
                    guestGroup.getCreationTime(), guestGroup.getModificationTime(),
                    guestGroup.getAmount());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int updateRecord(SqlSession session, GuestGroupMapper mapperb, GuestGroup guestGroup){
        int result = 0;
        try {
            result = mapperb.updateGuestGroup(guestGroup.getGuestUserId(), guestGroup.getGroupId(),
                    guestGroup.getGroupName(), guestGroup.getGroupAnnouncementId(),
                    guestGroup.getCreationTime(), guestGroup.getModificationTime(),
                    guestGroup.getAmount());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecordByGroupId(SqlSession session, GuestGroupMapper mapperb, GuestGroup guestGroup){
        int result = 0;
        try {
            result = mapperb.deleteGuestGroupByGroupId(guestGroup.getGroupId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecordByGuestUserId(SqlSession session, GuestGroupMapper mapperb, GuestGroup guestGroup){
        int result = 0;
        try {
            result = mapperb.deleteGuestGroupByGuestUserId(guestGroup.getGuestUserId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GuestGroup> selectGuestGroup(SqlSession session, GuestGroupMapper mapperb, GuestGroup guestGroup) {
        List<GuestGroup> bList = null;
        try {
            bList = mapperb.selectGuestGroup(guestGroup.getGuestUserId(), guestGroup.getGroupId(),
                    guestGroup.getGroupName(), guestGroup.getGroupAnnouncementId(),
                    guestGroup.getCreationTime(), guestGroup.getModificationTime(),
                    guestGroup.getAmount());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroup> selectGuestGroupByGuestUserId(SqlSession session, GuestGroupMapper mapperb, GuestGroup guestGroup) {
        List<GuestGroup> bList = null;
        try {
            bList = mapperb.selectGuestGroupByGuestUserId(guestGroup.getGuestUserId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroup> selectGuestGroupByGroupId(SqlSession session, GuestGroupMapper mapperb, GuestGroup guestGroup) {
        List<GuestGroup> bList = null;
        try {
            bList = mapperb.selectGuestGroupByGroupId(guestGroup.getGroupId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroup> selectGuestGroupByGroupIdLike(SqlSession session, GuestGroupMapper mapperb, GuestGroup guestGroup) {
        List<GuestGroup> bList = null;
        try {
            bList = mapperb.selectGuestGroupByGroupIdLike(guestGroup.getGroupId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroup> selectGuestGroupByGuestUserIdAndGroupId(SqlSession session, GuestGroupMapper mapperb, GuestGroup guestGroup) {
        List<GuestGroup> bList = null;
        try {
            bList = mapperb.selectGuestGroupByGuestUserIdAndGroupId(guestGroup.getGuestUserId(), guestGroup.getGroupId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroup> selectAllRecords(SqlSession session, GuestGroupMapper mapperb) {
        List<GuestGroup> bList = null;
        try {
            bList = mapperb.selectAllGuestGroup();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
