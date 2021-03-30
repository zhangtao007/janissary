package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.GroupMemberUsedBeautifulNumberMapper;
import com.lanjiu.im.grpc.pojo.GroupMemberUsedBeautifulNumber;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GroupMemberUsedBeautifulNumberService {

    public int insertRecord(SqlSession session, GroupMemberUsedBeautifulNumberMapper mapperb, GroupMemberUsedBeautifulNumber groupMemberUsedBeautifulNumber){
        int result = 0;
        try {
            result = mapperb.insertGroupMemberUsedBeautifulNumber(groupMemberUsedBeautifulNumber.getTenMillion(), groupMemberUsedBeautifulNumber.getOneMillion(),
                    groupMemberUsedBeautifulNumber.getOneHundredThousand(), groupMemberUsedBeautifulNumber.getTenThousand(),
                    groupMemberUsedBeautifulNumber.getOneThousand(), groupMemberUsedBeautifulNumber.getOneHundred(),
                    groupMemberUsedBeautifulNumber.getTen(), groupMemberUsedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GroupMemberUsedBeautifulNumberMapper mapperb, GroupMemberUsedBeautifulNumber groupMemberUsedBeautifulNumber){
        int result = 0;
        try {
            result = mapperb.deleteGroupMemberUsedBeautifulNumber(groupMemberUsedBeautifulNumber.getTenMillion(), groupMemberUsedBeautifulNumber.getOneMillion(),
                    groupMemberUsedBeautifulNumber.getOneHundredThousand(), groupMemberUsedBeautifulNumber.getTenThousand(),
                    groupMemberUsedBeautifulNumber.getOneThousand(), groupMemberUsedBeautifulNumber.getOneHundred(),
                    groupMemberUsedBeautifulNumber.getTen(), groupMemberUsedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GroupMemberUsedBeautifulNumber> selectRecord(SqlSession session, GroupMemberUsedBeautifulNumberMapper mapperb, GroupMemberUsedBeautifulNumber groupMemberUsedBeautifulNumber) {
        List<GroupMemberUsedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectGroupMemberUsedBeautifulNumber(groupMemberUsedBeautifulNumber.getTenMillion(), groupMemberUsedBeautifulNumber.getOneMillion(),
                    groupMemberUsedBeautifulNumber.getOneHundredThousand(), groupMemberUsedBeautifulNumber.getTenThousand(),
                    groupMemberUsedBeautifulNumber.getOneThousand(), groupMemberUsedBeautifulNumber.getOneHundred(),
                    groupMemberUsedBeautifulNumber.getTen(), groupMemberUsedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupMemberUsedBeautifulNumber> selectRecordByThousand(SqlSession session, GroupMemberUsedBeautifulNumberMapper mapperb, GroupMemberUsedBeautifulNumber groupMemberUsedBeautifulNumber) {
        List<GroupMemberUsedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectGroupMemberUsedBeautifulNumberByThousand(groupMemberUsedBeautifulNumber.getTenMillion(), groupMemberUsedBeautifulNumber.getOneMillion(),
                    groupMemberUsedBeautifulNumber.getOneHundredThousand(), groupMemberUsedBeautifulNumber.getTenThousand(), groupMemberUsedBeautifulNumber.getOneThousand());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupMemberUsedBeautifulNumber> selectAllRecords(SqlSession session, GroupMemberUsedBeautifulNumberMapper mapperb) {
        List<GroupMemberUsedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectAllGroupMemberUsedBeautifulNumber();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

}
