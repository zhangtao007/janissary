package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.GroupMemberUnusedBeautifulNumberMapper;
import com.lanjiu.im.grpc.pojo.GroupMemberUnusedBeautifulNumber;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GroupMemberUnusedBeautifulNumberService {

    public int insertRecord(SqlSession session, GroupMemberUnusedBeautifulNumberMapper mapperb, GroupMemberUnusedBeautifulNumber groupMemberUnusedBeautifulNumber){
        int result = 0;
        try {
            result = mapperb.insertGroupMemberUnusedBeautifulNumber(groupMemberUnusedBeautifulNumber.getTenMillion(), groupMemberUnusedBeautifulNumber.getOneMillion(),
                    groupMemberUnusedBeautifulNumber.getOneHundredThousand(), groupMemberUnusedBeautifulNumber.getTenThousand(),
                    groupMemberUnusedBeautifulNumber.getOneThousand(), groupMemberUnusedBeautifulNumber.getOneHundred(),
                    groupMemberUnusedBeautifulNumber.getTen(), groupMemberUnusedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GroupMemberUnusedBeautifulNumberMapper mapperb, GroupMemberUnusedBeautifulNumber groupMemberUnusedBeautifulNumber){
        int result = 0;
        try {
            result = mapperb.deleteGroupMemberUnusedBeautifulNumber(groupMemberUnusedBeautifulNumber.getTenMillion(), groupMemberUnusedBeautifulNumber.getOneMillion(),
                    groupMemberUnusedBeautifulNumber.getOneHundredThousand(), groupMemberUnusedBeautifulNumber.getTenThousand(),
                    groupMemberUnusedBeautifulNumber.getOneThousand(), groupMemberUnusedBeautifulNumber.getOneHundred(),
                    groupMemberUnusedBeautifulNumber.getTen(), groupMemberUnusedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GroupMemberUnusedBeautifulNumber> selectRecord(SqlSession session, GroupMemberUnusedBeautifulNumberMapper mapperb, GroupMemberUnusedBeautifulNumber groupMemberUnusedBeautifulNumber) {
        List<GroupMemberUnusedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectGroupMemberUnusedBeautifulNumber(groupMemberUnusedBeautifulNumber.getTenMillion(), groupMemberUnusedBeautifulNumber.getOneMillion(),
                    groupMemberUnusedBeautifulNumber.getOneHundredThousand(), groupMemberUnusedBeautifulNumber.getTenThousand(),
                    groupMemberUnusedBeautifulNumber.getOneThousand(), groupMemberUnusedBeautifulNumber.getOneHundred(),
                    groupMemberUnusedBeautifulNumber.getTen(), groupMemberUnusedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupMemberUnusedBeautifulNumber> selectRecordByThousand(SqlSession session, GroupMemberUnusedBeautifulNumberMapper mapperb, GroupMemberUnusedBeautifulNumber groupMemberUnusedBeautifulNumber) {
        List<GroupMemberUnusedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectGroupMemberUnusedBeautifulNumberByThousand(groupMemberUnusedBeautifulNumber.getTenMillion(), groupMemberUnusedBeautifulNumber.getOneMillion(),
                    groupMemberUnusedBeautifulNumber.getOneHundredThousand(), groupMemberUnusedBeautifulNumber.getTenThousand(), groupMemberUnusedBeautifulNumber.getOneThousand());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupMemberUnusedBeautifulNumber> selectAllRecords(SqlSession session, GroupMemberUnusedBeautifulNumberMapper mapperb) {
        List<GroupMemberUnusedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectAllGroupMemberUnusedBeautifulNumber();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupMemberUnusedBeautifulNumber> selectOnlyGroupMemberUnusedBeautifulNumber(SqlSession session, GroupMemberUnusedBeautifulNumberMapper mapperb) {
        List<GroupMemberUnusedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectOnlyGroupMemberUnusedBeautifulNumber();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

}
