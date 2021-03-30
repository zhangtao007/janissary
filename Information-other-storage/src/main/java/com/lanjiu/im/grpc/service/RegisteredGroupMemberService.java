package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.RegisteredGroupMemberMapper;
import com.lanjiu.im.grpc.pojo.RegisteredGroupMember;
import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class RegisteredGroupMemberService {

    public int insertRecord(SqlSession session, RegisteredGroupMemberMapper mapperb, RegisteredGroupMember registeredGroupMember){
        int result = 0;
        try {
            result = mapperb.insertRegisteredGroupMember(registeredGroupMember.getGroupMemberId(), registeredGroupMember.getRegisteredUserId(),null,
                    registeredGroupMember.getGroupRemarks(), registeredGroupMember.getGroupOwner(),
                    registeredGroupMember.getBurnAfterReadingSettings(), registeredGroupMember.getBurnAfterReadingTimeUnit(),
                    registeredGroupMember.getBurnAfterReadingTimeLength(), registeredGroupMember.getGroupEntryTime(), registeredGroupMember.getOfflineMessageSetting());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int updateRecord(SqlSession session, RegisteredGroupMemberMapper mapperb, RegisteredGroupMember registeredGroupMember){
        int result = 0;
        try {
//            result = mapperb.updateRegisteredGroupMember(registeredGroupMember.getGroupMemberId(), registeredGroupMember.getRegisteredUserId(),
//                    registeredGroupMember.getGroupRemarks(), registeredGroupMember.getGroupOwner(),
//                    registeredGroupMember.getBurnAfterReadingSettings(), registeredGroupMember.getBurnAfterReadingTimeUnit(),
//                    registeredGroupMember.getBurnAfterReadingTimeLength(), registeredGroupMember.getGroupEntryTime(), registeredGroupMember.getOfflineMessageSetting());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecordByGroupMemberId(SqlSession session, RegisteredGroupMemberMapper mapperb, RegisteredGroupMember registeredGroupMember){
        int result = 0;
        try {
            result = mapperb.deleteRegisteredGroupMemberByGroupMemberId(registeredGroupMember.getGroupMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecordByRegisteredUserId(SqlSession session, RegisteredGroupMemberMapper mapperb, RegisteredGroupMember registeredGroupMember){
        int result = 0;
        try {
            result = mapperb.deleteRegisteredGroupMemberByRegisteredUserId(registeredGroupMember.getRegisteredUserId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<RegisteredGroupMember> selectRegisteredGroupMember(SqlSession session, RegisteredGroupMemberMapper mapperb, RegisteredGroupMember registeredGroupMember) {
        List<RegisteredGroupMember> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupMember(registeredGroupMember.getGroupMemberId(), registeredGroupMember.getRegisteredUserId(),
                    registeredGroupMember.getGroupRemarks(), registeredGroupMember.getGroupOwner(),
                    registeredGroupMember.getBurnAfterReadingSettings(), registeredGroupMember.getBurnAfterReadingTimeUnit(),
                    registeredGroupMember.getBurnAfterReadingTimeLength(), registeredGroupMember.getGroupEntryTime(), registeredGroupMember.getOfflineMessageSetting());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupMember> selectRegisteredGroupMemberByGroupMemberId(SqlSession session, RegisteredGroupMemberMapper mapperb, RegisteredGroupMember registeredGroupMember) {
        List<RegisteredGroupMember> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupMemberByGroupMemberId(registeredGroupMember.getGroupMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupMember> selectRegisteredGroupMemberByGroupMemberIdLike(SqlSession session, RegisteredGroupMemberMapper mapperb, RegisteredGroupMember registeredGroupMember) {
        List<RegisteredGroupMember> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupMemberByGroupMemberIdLike(registeredGroupMember.getGroupMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupMember> selectRegisteredGroupMemberByRegisteredUserId(SqlSession session, RegisteredGroupMemberMapper mapperb, RegisteredGroupMember registeredGroupMember) {
        List<RegisteredGroupMember> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupMemberByRegisteredUserId(registeredGroupMember.getRegisteredUserId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupMember> selectRegisteredGroupMemberByGroupMemberIdAndRegisteredUserId(SqlSession session, RegisteredGroupMemberMapper mapperb, RegisteredGroupMember registeredGroupMember) {
        List<RegisteredGroupMember> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupMemberByGroupMemberIdAndRegisteredUserId(registeredGroupMember.getGroupMemberId(), registeredGroupMember.getRegisteredUserId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupMember> selectRegisteredGroupMemberByOfflineMessageSetting(SqlSession session, RegisteredGroupMemberMapper mapperb, RegisteredGroupMember registeredGroupMember) {
        List<RegisteredGroupMember> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupMemberByOfflineMessageSetting(registeredGroupMember.getOfflineMessageSetting());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupMember> selectRegisteredGroupMemberByBurnAfterReadingSetting(SqlSession session, RegisteredGroupMemberMapper mapperb, RegisteredGroupMember registeredGroupMember) {
        List<RegisteredGroupMember> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupMemberByBurnAfterReadingSetting(registeredGroupMember.getBurnAfterReadingSettings());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupMember> selectAllRecords(SqlSession session, RegisteredGroupMemberMapper mapperb) {
        List<RegisteredGroupMember> bList = null;
        try {
            bList = mapperb.selectAllRegisteredGroupMember();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
