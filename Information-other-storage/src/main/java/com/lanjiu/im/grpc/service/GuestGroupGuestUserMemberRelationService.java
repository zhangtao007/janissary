package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.GuestGroupGuestUserMemberRelationMapper;
import com.lanjiu.im.grpc.pojo.GuestGroupGuestUserMemberRelation;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GuestGroupGuestUserMemberRelationService {

    public List<GuestGroupGuestUserMemberRelation> selectAllRecords(SqlSession session, GuestGroupGuestUserMemberRelationMapper mapperb) {
        List<GuestGroupGuestUserMemberRelation> bList = null;
        try {
            bList = mapperb.selectAllGuestGroupGuestUserMemberRelation();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupGuestUserMemberRelation> selectAllGuestGroupGuestUserMemberRelationByGroupIdAndMemberId(SqlSession session, GuestGroupGuestUserMemberRelationMapper mapperb, GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation) {
        List<GuestGroupGuestUserMemberRelation> bList = null;
        try {
            bList = mapperb.selectAllGuestGroupGuestUserMemberRelationByGroupIdAndMemberId(
                    guestGroupGuestUserMemberRelation.getGuestGroupId(),
                    guestGroupGuestUserMemberRelation.getGuestUserMemberId()
            );
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }


    public List<GuestGroupGuestUserMemberRelation> selectGuestGroupGuestUserMemberRelationByGuestGroupId(SqlSession session, GuestGroupGuestUserMemberRelationMapper mapperb, GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation) {
        List<GuestGroupGuestUserMemberRelation> bList = null;
        try {
            bList = mapperb.selectGuestGroupGuestUserMemberRelationByGuestGroupId(guestGroupGuestUserMemberRelation.getGuestGroupId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupGuestUserMemberRelation> selectGuestGroupGuestUserMemberRelationByGuestUserMemberId(SqlSession session, GuestGroupGuestUserMemberRelationMapper mapperb, GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation) {
        List<GuestGroupGuestUserMemberRelation> bList = null;
        try {
            bList = mapperb.selectGuestGroupGuestUserMemberRelationByGuestUserMemberId(guestGroupGuestUserMemberRelation.getGuestUserMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public int insertRecord(SqlSession session, GuestGroupGuestUserMemberRelationMapper mapperb, GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation){
        int result = 0;
        try {
            result = mapperb.insertGuestGroupGuestUserMemberRelation(guestGroupGuestUserMemberRelation.getGuestGroupId(),
                    guestGroupGuestUserMemberRelation.getGuestUserMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteGuestGroupGuestUserMemberRelation(SqlSession session, GuestGroupGuestUserMemberRelationMapper mapperb, GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation){
        int result = 0;
        try {
            result = mapperb.deleteGuestGroupGuestUserMemberRelation(guestGroupGuestUserMemberRelation.getGuestGroupId(),
                    guestGroupGuestUserMemberRelation.getGuestUserMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }
}
