package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.GroupMemberUsedBeautifulNumberRealMapper;
import com.lanjiu.im.grpc.pojo.GroupMemberUsedBeautifulNumberReal;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GroupMemberUsedBeautifulNumberRealService {

    public int insertRecord(SqlSession session, GroupMemberUsedBeautifulNumberRealMapper mapperb, GroupMemberUsedBeautifulNumberReal groupMemberUsedBeautifulNumberReal){
        int result = 0;
        try {
            result = mapperb.insertGroupMemberUsedBeautifulNumberReal(groupMemberUsedBeautifulNumberReal.getTenMillion(), groupMemberUsedBeautifulNumberReal.getOneMillion(),
                    groupMemberUsedBeautifulNumberReal.getOneHundredThousand(), groupMemberUsedBeautifulNumberReal.getTenThousand(),
                    groupMemberUsedBeautifulNumberReal.getOneThousand(), groupMemberUsedBeautifulNumberReal.getOneHundred(),
                    groupMemberUsedBeautifulNumberReal.getTen(), groupMemberUsedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GroupMemberUsedBeautifulNumberRealMapper mapperb, GroupMemberUsedBeautifulNumberReal groupMemberUsedBeautifulNumberReal){
        int result = 0;
        try {
            result = mapperb.deleteGroupMemberUsedBeautifulNumberReal(groupMemberUsedBeautifulNumberReal.getTenMillion(), groupMemberUsedBeautifulNumberReal.getOneMillion(),
                    groupMemberUsedBeautifulNumberReal.getOneHundredThousand(), groupMemberUsedBeautifulNumberReal.getTenThousand(),
                    groupMemberUsedBeautifulNumberReal.getOneThousand(), groupMemberUsedBeautifulNumberReal.getOneHundred(),
                    groupMemberUsedBeautifulNumberReal.getTen(), groupMemberUsedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GroupMemberUsedBeautifulNumberReal> selectRecord(SqlSession session, GroupMemberUsedBeautifulNumberRealMapper mapperb, GroupMemberUsedBeautifulNumberReal groupMemberUsedBeautifulNumberReal) {
        List<GroupMemberUsedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectGroupMemberUsedBeautifulNumberReal(groupMemberUsedBeautifulNumberReal.getTenMillion(), groupMemberUsedBeautifulNumberReal.getOneMillion(),
                    groupMemberUsedBeautifulNumberReal.getOneHundredThousand(), groupMemberUsedBeautifulNumberReal.getTenThousand(),
                    groupMemberUsedBeautifulNumberReal.getOneThousand(), groupMemberUsedBeautifulNumberReal.getOneHundred(),
                    groupMemberUsedBeautifulNumberReal.getTen(), groupMemberUsedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupMemberUsedBeautifulNumberReal> selectRecordByThousand(SqlSession session, GroupMemberUsedBeautifulNumberRealMapper mapperb, GroupMemberUsedBeautifulNumberReal groupMemberUsedBeautifulNumberReal) {
        List<GroupMemberUsedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectGroupMemberUsedBeautifulNumberRealByThousand(groupMemberUsedBeautifulNumberReal.getTenMillion(),
                    groupMemberUsedBeautifulNumberReal.getOneMillion(),
                    groupMemberUsedBeautifulNumberReal.getOneHundredThousand(), groupMemberUsedBeautifulNumberReal.getTenThousand(),
                    groupMemberUsedBeautifulNumberReal.getOneThousand());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupMemberUsedBeautifulNumberReal> selectAllRecords(SqlSession session, GroupMemberUsedBeautifulNumberRealMapper mapperb) {
        List<GroupMemberUsedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectAllGroupMemberUsedBeautifulNumberReal();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

}
