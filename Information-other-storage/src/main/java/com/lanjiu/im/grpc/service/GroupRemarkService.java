package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.GroupRemarkMapper;
import com.lanjiu.im.grpc.pojo.GroupRemark;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GroupRemarkService {

    public List<GroupRemark> selectAllRecords(SqlSession session, GroupRemarkMapper mapperb) {
        List<GroupRemark> bList = null;
        try {
            bList = mapperb.selectAllGroupRemark();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupRemark> selectGroupRemarkWithGroupWithGroupMember(SqlSession session, GroupRemarkMapper mapperb, GroupRemark groupRemark) {
        List<GroupRemark> bList = null;
        try {
            bList = mapperb.selectGroupRemarkWithGroupWithGroupMember(groupRemark.getGroupId(),
                    groupRemark.getGroupMemberId(),
                    groupRemark.getGroupMemberIdRemarked()
                    );
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public int insertRecord(SqlSession session, GroupRemarkMapper mapperb, GroupRemark groupRemark){
        int result = 0;
        try {
            result = mapperb.insertGroupRemark(groupRemark.getGroupId(), groupRemark.getGroupMemberId(), groupRemark.getGroupMemberIdRemarked(), groupRemark.getRemark());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int updateRecord(SqlSession session, GroupRemarkMapper mapperb, GroupRemark groupRemark){
        int result = 0;
        try {
            result = mapperb.updateGroupRemark(groupRemark.getGroupId(), groupRemark.getGroupMemberId(), groupRemark.getGroupMemberIdRemarked(), groupRemark.getRemark());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteGroupRemarkByGroupId(SqlSession session, GroupRemarkMapper mapperb, GroupRemark groupRemark){
        int result = 0;
        try {
            result = mapperb.deleteGroupRemarkByGroupId(groupRemark.getGroupId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteGroupRemarkByMemberRemarkedId(SqlSession session, GroupRemarkMapper mapperb, GroupRemark groupRemark){
        int result = 0;
        try {
            result = mapperb.deleteGroupRemarkByMemberRemarkedId(groupRemark.getGroupMemberIdRemarked());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteGroupRemarkByMemberId(SqlSession session, GroupRemarkMapper mapperb, GroupRemark groupRemark){
        int result = 0;
        try {
            result = mapperb.deleteGroupRemarkByMemberId(groupRemark.getGroupMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteGroupRemarkByGroupIdAndMemberId(SqlSession session, GroupRemarkMapper mapperb, GroupRemark groupRemark){
        int result = 0;
        try {
            result = mapperb.deleteGroupRemarkByGroupIdAndMemberId(groupRemark.getGroupId() ,groupRemark.getGroupMemberId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }
}
