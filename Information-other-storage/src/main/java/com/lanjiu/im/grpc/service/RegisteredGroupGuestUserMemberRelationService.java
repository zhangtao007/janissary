package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.RegisteredGroupGuestUserMemberRelationMapper;
import com.lanjiu.im.grpc.pojo.RegisteredGroupGuestUserMemberRelation;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RegisteredGroupGuestUserMemberRelationService {

    public List<RegisteredGroupGuestUserMemberRelation> selectAllRecords(SqlSession session, RegisteredGroupGuestUserMemberRelationMapper mapperb) {
        List<RegisteredGroupGuestUserMemberRelation> bList = null;
        try {
            bList = mapperb.selectAllRegisteredGroupGuestUserMemberRelation();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupGuestUserMemberRelation> selectAllRegisteredGroupGuestUserMemberRelationByGroupIdAndMemberId(SqlSession session, RegisteredGroupGuestUserMemberRelationMapper mapperb, RegisteredGroupGuestUserMemberRelation registeredGroupGuestUserMemberRelation) {
        List<RegisteredGroupGuestUserMemberRelation> bList = null;
        try {
            bList = mapperb.selectAllRegisteredGroupGuestUserMemberRelationByGroupIdAndMemberId(
                    registeredGroupGuestUserMemberRelation.getRegisteredGroupId(),
                    registeredGroupGuestUserMemberRelation.getGuestUserMemberId()
            );
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }


    public List<RegisteredGroupGuestUserMemberRelation> selectRegisteredGroupGuestUserMemberRelationByRegisteredGroupId(SqlSession session, RegisteredGroupGuestUserMemberRelationMapper mapperb, RegisteredGroupGuestUserMemberRelation registeredGroupGuestUserMemberRelation) {
        List<RegisteredGroupGuestUserMemberRelation> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupGuestUserMemberRelationByRegisteredGroupId(registeredGroupGuestUserMemberRelation.getRegisteredGroupId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupGuestUserMemberRelation> selectRegisteredGroupGuestUserMemberRelationByGuestUserMemberId(SqlSession session, RegisteredGroupGuestUserMemberRelationMapper mapperb, RegisteredGroupGuestUserMemberRelation registeredGroupGuestUserMemberRelation) {
        List<RegisteredGroupGuestUserMemberRelation> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupGuestUserMemberRelationByGuestUserMemberId(registeredGroupGuestUserMemberRelation.getGuestUserMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public int insertRecord(SqlSession session, RegisteredGroupGuestUserMemberRelationMapper mapperb, RegisteredGroupGuestUserMemberRelation registeredGroupGuestUserMemberRelation){
        int result = 0;
        try {
            result = mapperb.insertRegisteredGroupGuestUserMemberRelation(registeredGroupGuestUserMemberRelation.getRegisteredGroupId(),
                    registeredGroupGuestUserMemberRelation.getGuestUserMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRegisteredGroupGuestUserMemberRelation(SqlSession session, RegisteredGroupGuestUserMemberRelationMapper mapperb, RegisteredGroupGuestUserMemberRelation registeredGroupGuestUserMemberRelation){
        int result = 0;
        try {
            result = mapperb.deleteRegisteredGroupGuestUserMemberRelation(registeredGroupGuestUserMemberRelation.getRegisteredGroupId(),
                    registeredGroupGuestUserMemberRelation.getGuestUserMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }
}
