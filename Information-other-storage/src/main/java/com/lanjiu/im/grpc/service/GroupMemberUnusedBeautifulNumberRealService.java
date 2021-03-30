package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.GroupMemberUnusedBeautifulNumberRealMapper;
import com.lanjiu.im.grpc.pojo.GroupMemberUnusedBeautifulNumberReal;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GroupMemberUnusedBeautifulNumberRealService {

    public int insertRecord(SqlSession session, GroupMemberUnusedBeautifulNumberRealMapper mapperb, GroupMemberUnusedBeautifulNumberReal groupMemberUnusedBeautifulNumberReal){
        int result = 0;
        try {
            result = mapperb.insertGroupMemberUnusedBeautifulNumberReal(groupMemberUnusedBeautifulNumberReal.getTenMillion(), groupMemberUnusedBeautifulNumberReal.getOneMillion(),
                    groupMemberUnusedBeautifulNumberReal.getOneHundredThousand(), groupMemberUnusedBeautifulNumberReal.getTenThousand(), groupMemberUnusedBeautifulNumberReal.getOneThousand(), groupMemberUnusedBeautifulNumberReal.getOneHundred(),
                    groupMemberUnusedBeautifulNumberReal.getTen(), groupMemberUnusedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GroupMemberUnusedBeautifulNumberRealMapper mapperb, GroupMemberUnusedBeautifulNumberReal groupMemberUnusedBeautifulNumberReal){
        int result = 0;
        try {
            result = mapperb.deleteGroupMemberUnusedBeautifulNumberReal(groupMemberUnusedBeautifulNumberReal.getTenMillion(), groupMemberUnusedBeautifulNumberReal.getOneMillion(),
                    groupMemberUnusedBeautifulNumberReal.getOneHundredThousand(), groupMemberUnusedBeautifulNumberReal.getTenThousand(), groupMemberUnusedBeautifulNumberReal.getOneThousand(), groupMemberUnusedBeautifulNumberReal.getOneHundred(),
                    groupMemberUnusedBeautifulNumberReal.getTen(), groupMemberUnusedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GroupMemberUnusedBeautifulNumberReal> selectRecord(SqlSession session, GroupMemberUnusedBeautifulNumberRealMapper mapperb, GroupMemberUnusedBeautifulNumberReal groupMemberUnusedBeautifulNumberReal) {
        List<GroupMemberUnusedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectGroupMemberUnusedBeautifulNumberReal(groupMemberUnusedBeautifulNumberReal.getTenMillion(), groupMemberUnusedBeautifulNumberReal.getOneMillion(),
                    groupMemberUnusedBeautifulNumberReal.getOneHundredThousand(), groupMemberUnusedBeautifulNumberReal.getTenThousand(),
                    groupMemberUnusedBeautifulNumberReal.getOneThousand(), groupMemberUnusedBeautifulNumberReal.getOneHundred(),
                    groupMemberUnusedBeautifulNumberReal.getTen(), groupMemberUnusedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupMemberUnusedBeautifulNumberReal> selectRecordByThousand(SqlSession session, GroupMemberUnusedBeautifulNumberRealMapper mapperb, GroupMemberUnusedBeautifulNumberReal groupMemberUnusedBeautifulNumberReal) {
        List<GroupMemberUnusedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectGroupMemberUnusedBeautifulNumberRealByThousand(groupMemberUnusedBeautifulNumberReal.getTenMillion(), groupMemberUnusedBeautifulNumberReal.getOneMillion(),
                    groupMemberUnusedBeautifulNumberReal.getOneHundredThousand(), groupMemberUnusedBeautifulNumberReal.getTenThousand(), groupMemberUnusedBeautifulNumberReal.getOneThousand());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupMemberUnusedBeautifulNumberReal> selectAllRecords(SqlSession session, GroupMemberUnusedBeautifulNumberRealMapper mapperb) {
        List<GroupMemberUnusedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectAllGroupMemberUnusedBeautifulNumberReal();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupMemberUnusedBeautifulNumberReal> selectOnlyGroupMemberUnusedBeautifulNumberReal(SqlSession session, GroupMemberUnusedBeautifulNumberRealMapper mapperb) {
        List<GroupMemberUnusedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectOnlyGroupMemberUnusedBeautifulNumberReal();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
