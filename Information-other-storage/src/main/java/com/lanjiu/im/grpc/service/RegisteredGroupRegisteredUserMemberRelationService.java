package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.RegisteredGroupRegisteredUserMemberRelationMapper;
import com.lanjiu.im.grpc.pojo.RegisteredGroupRegisteredUserMemberRelation;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RegisteredGroupRegisteredUserMemberRelationService {

    public List<RegisteredGroupRegisteredUserMemberRelation> selectAllRecords(SqlSession session, RegisteredGroupRegisteredUserMemberRelationMapper mapperb) {
        List<RegisteredGroupRegisteredUserMemberRelation> bList = null;
        try {
            bList = mapperb.selectAllRegisteredGroupRegisteredUserMemberRelation();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupRegisteredUserMemberRelation> selectAllRegisteredGroupRegisteredUserMemberRelationByGroupIdAndMemberId(SqlSession session, RegisteredGroupRegisteredUserMemberRelationMapper mapperb, RegisteredGroupRegisteredUserMemberRelation registeredGroupRegisteredUserMemberRelation) {
        List<RegisteredGroupRegisteredUserMemberRelation> bList = null;
        try {
            bList = mapperb.selectAllRegisteredGroupRegisteredUserMemberRelationByGroupIdAndMemberId(
                    registeredGroupRegisteredUserMemberRelation.getRegisteredGroupId(),
                    registeredGroupRegisteredUserMemberRelation.getRegisteredUserMemberId()
            );
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }


    public List<RegisteredGroupRegisteredUserMemberRelation> selectRegisteredGroupRegisteredUserMemberRelationByRegisteredGroupId(SqlSession session, RegisteredGroupRegisteredUserMemberRelationMapper mapperb, RegisteredGroupRegisteredUserMemberRelation registeredGroupRegisteredUserMemberRelation) {
        List<RegisteredGroupRegisteredUserMemberRelation> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupRegisteredUserMemberRelationByRegisteredGroupId(registeredGroupRegisteredUserMemberRelation.getRegisteredGroupId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupRegisteredUserMemberRelation> selectRegisteredGroupRegisteredUserMemberRelationByRegisteredUserMemberId(SqlSession session, RegisteredGroupRegisteredUserMemberRelationMapper mapperb, RegisteredGroupRegisteredUserMemberRelation registeredGroupRegisteredUserMemberRelation) {
        List<RegisteredGroupRegisteredUserMemberRelation> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupRegisteredUserMemberRelationByRegisteredUserMemberId(registeredGroupRegisteredUserMemberRelation.getRegisteredUserMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public int insertRecord(SqlSession session, RegisteredGroupRegisteredUserMemberRelationMapper mapperb, RegisteredGroupRegisteredUserMemberRelation registeredGroupRegisteredUserMemberRelation){
        int result = 0;
        try {
            result = mapperb.insertRegisteredGroupRegisteredUserMemberRelation(registeredGroupRegisteredUserMemberRelation.getRegisteredGroupId(),
                    registeredGroupRegisteredUserMemberRelation.getRegisteredUserMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRegisteredGroupRegisteredUserMemberRelation(SqlSession session, RegisteredGroupRegisteredUserMemberRelationMapper mapperb, RegisteredGroupRegisteredUserMemberRelation registeredGroupRegisteredUserMemberRelation){
        int result = 0;
        try {
            result = mapperb.deleteRegisteredGroupRegisteredUserMemberRelation(registeredGroupRegisteredUserMemberRelation.getRegisteredGroupId(),
                    registeredGroupRegisteredUserMemberRelation.getRegisteredUserMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }
}
