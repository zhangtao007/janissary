package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.GuestGroupRegisteredUserMemberRelationMapper;
import com.lanjiu.im.grpc.pojo.GuestGroupRegisteredUserMemberRelation;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GuestGroupRegisteredUserMemberRelationService {

    public List<GuestGroupRegisteredUserMemberRelation> selectAllRecords(SqlSession session, GuestGroupRegisteredUserMemberRelationMapper mapperb) {
        List<GuestGroupRegisteredUserMemberRelation> bList = null;
        try {
            bList = mapperb.selectAllGuestGroupRegisteredUserMemberRelation();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupRegisteredUserMemberRelation> selectAllGuestGroupRegisteredUserMemberRelationByGroupIdAndMemberId(SqlSession session, GuestGroupRegisteredUserMemberRelationMapper mapperb, GuestGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation) {
        List<GuestGroupRegisteredUserMemberRelation> bList = null;
        try {
            bList = mapperb.selectAllGuestGroupRegisteredUserMemberRelationByGroupIdAndMemberId(
                    guestGroupRegisteredUserMemberRelation.getGuestGroupId(),
                    guestGroupRegisteredUserMemberRelation.getRegisteredUserMemberId()
            );
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }


    public List<GuestGroupRegisteredUserMemberRelation> selectGuestGroupRegisteredUserMemberRelationByGuestGroupId(SqlSession session, GuestGroupRegisteredUserMemberRelationMapper mapperb, GuestGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation) {
        List<GuestGroupRegisteredUserMemberRelation> bList = null;
        try {
            bList = mapperb.selectGuestGroupRegisteredUserMemberRelationByGuestGroupId(guestGroupRegisteredUserMemberRelation.getGuestGroupId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupRegisteredUserMemberRelation> selectGuestGroupRegisteredUserMemberRelationByRegisteredUserMemberId(SqlSession session, GuestGroupRegisteredUserMemberRelationMapper mapperb, GuestGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation) {
        List<GuestGroupRegisteredUserMemberRelation> bList = null;
        try {
            bList = mapperb.selectGuestGroupRegisteredUserMemberRelationByRegisteredUserMemberId(guestGroupRegisteredUserMemberRelation.getRegisteredUserMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public int insertRecord(SqlSession session, GuestGroupRegisteredUserMemberRelationMapper mapperb, GuestGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation){
        int result = 0;
        try {
            result = mapperb.insertGuestGroupRegisteredUserMemberRelation(guestGroupRegisteredUserMemberRelation.getGuestGroupId(),
                    guestGroupRegisteredUserMemberRelation.getRegisteredUserMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteGuestGroupRegisteredUserMemberRelation(SqlSession session, GuestGroupRegisteredUserMemberRelationMapper mapperb, GuestGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation){
        int result = 0;
        try {
            result = mapperb.deleteGuestGroupRegisteredUserMemberRelation(guestGroupRegisteredUserMemberRelation.getGuestGroupId(),
                    guestGroupRegisteredUserMemberRelation.getRegisteredUserMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }
}
