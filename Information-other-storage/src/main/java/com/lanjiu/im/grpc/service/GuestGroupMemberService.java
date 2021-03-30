package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.GuestGroupMemberMapper;
import com.lanjiu.im.grpc.pojo.GuestGroupMember;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class GuestGroupMemberService {

    public int insertRecord(SqlSession session, GuestGroupMemberMapper mapperb, GuestGroupMember guestGroupMember){
        int result = 0;
        try {
            result = mapperb.insertGuestGroupMember(guestGroupMember.getGroupMemberId(), guestGroupMember.getGuestUserId(),
                    guestGroupMember.getGroupRemarks(), guestGroupMember.getGroupOwner(),
                    guestGroupMember.getBurnAfterReadingSettings(), guestGroupMember.getBurnAfterReadingTimeUnit(),
                    guestGroupMember.getBurnAfterReadingTimeLength(), guestGroupMember.getGroupEntryTime(), guestGroupMember.getOfflineMessageSetting());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int updateRecord(SqlSession session, GuestGroupMemberMapper mapperb, GuestGroupMember guestGroupMember){
        int result = 0;
        try {
            result = mapperb.updateGuestGroupMember(guestGroupMember.getGroupMemberId(), guestGroupMember.getGuestUserId(),
                    guestGroupMember.getGroupRemarks(), guestGroupMember.getGroupOwner(),
                    guestGroupMember.getBurnAfterReadingSettings(), guestGroupMember.getBurnAfterReadingTimeUnit(),
                    guestGroupMember.getBurnAfterReadingTimeLength(), guestGroupMember.getGroupEntryTime(), guestGroupMember.getOfflineMessageSetting());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecordByGroupMemberId(SqlSession session, GuestGroupMemberMapper mapperb, GuestGroupMember guestGroupMember){
        int result = 0;
        try {
            result = mapperb.deleteGuestGroupMemberByGroupMemberId(guestGroupMember.getGroupMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecordByGuestUserId(SqlSession session, GuestGroupMemberMapper mapperb, GuestGroupMember guestGroupMember){
        int result = 0;
        try {
            result = mapperb.deleteGuestGroupMemberByGuestUserId(guestGroupMember.getGuestUserId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GuestGroupMember> selectGuestGroupMember(SqlSession session, GuestGroupMemberMapper mapperb, GuestGroupMember guestGroupMember) {
        List<GuestGroupMember> bList = null;
        try {
            bList = mapperb.selectGuestGroupMember(guestGroupMember.getGroupMemberId(), guestGroupMember.getGuestUserId(),
                    guestGroupMember.getGroupRemarks(), guestGroupMember.getGroupOwner(),
                    guestGroupMember.getBurnAfterReadingSettings(), guestGroupMember.getBurnAfterReadingTimeUnit(),
                    guestGroupMember.getBurnAfterReadingTimeLength(), guestGroupMember.getGroupEntryTime(), guestGroupMember.getOfflineMessageSetting());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupMember> selectGuestGroupMemberByGroupMemberId(SqlSession session, GuestGroupMemberMapper mapperb, GuestGroupMember guestGroupMember) {
        List<GuestGroupMember> bList = null;
        try {
            bList = mapperb.selectGuestGroupMemberByGroupMemberId(guestGroupMember.getGroupMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupMember> selectGuestGroupMemberByGroupMemberIdLike(SqlSession session, GuestGroupMemberMapper mapperb, GuestGroupMember guestGroupMember) {
        List<GuestGroupMember> bList = null;
        try {
            bList = mapperb.selectGuestGroupMemberByGroupMemberIdLike(guestGroupMember.getGroupMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupMember> selectGuestGroupMemberByGuestUserId(SqlSession session, GuestGroupMemberMapper mapperb, GuestGroupMember guestGroupMember) {
        List<GuestGroupMember> bList = null;
        try {
            bList = mapperb.selectGuestGroupMemberByGuestUserId(guestGroupMember.getGuestUserId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupMember> selectGuestGroupMemberByGroupMemberIdAndGuestUserId(SqlSession session, GuestGroupMemberMapper mapperb, GuestGroupMember guestGroupMember) {
        List<GuestGroupMember> bList = null;
        try {
            bList = mapperb.selectGuestGroupMemberByGroupMemberIdAndGuestUserId(guestGroupMember.getGroupMemberId(), guestGroupMember.getGuestUserId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupMember> selectGuestGroupMemberByOfflineMessageSetting(SqlSession session, GuestGroupMemberMapper mapperb, GuestGroupMember guestGroupMember) {
        List<GuestGroupMember> bList = null;
        try {
            bList = mapperb.selectGuestGroupMemberByOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupMember> selectGuestGroupMemberByBurnAfterReadingSetting(SqlSession session, GuestGroupMemberMapper mapperb, GuestGroupMember guestGroupMember) {
        List<GuestGroupMember> bList = null;
        try {
            bList = mapperb.selectGuestGroupMemberByBurnAfterReadingSetting(guestGroupMember.getBurnAfterReadingSettings());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupMember> selectAllRecords(SqlSession session, GuestGroupMemberMapper mapperb) {
        List<GuestGroupMember> bList = null;
        try {
            bList = mapperb.selectAllGuestGroupMember();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

//    public static void main(String[] args) {
//        SqlSession session = DBTools.getSession();
//        GuestGroupMemberMapper guestUserFriendMapper = session.getMapper(GuestGroupMemberMapper.class);
//
//        GuestGroupMember guestGroupMember = new GuestGroupMember();
//
//        guestGroupMember.setGroupMemberId(11);
//
//        try {
//            List<GuestGroupMember> nlist =guestUserFriendMapper.selectGuestGroupMemberByGroupMemberIdLike(guestGroupMember.getGroupMemberId());
//            System.out.println(nlist.size());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
