package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.GroupUnusedBeautifulNumberMapper;
import com.lanjiu.im.grpc.pojo.GroupUnusedBeautifulNumber;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GroupUnusedBeautifulNumberService {

    public int insertRecord(SqlSession session, GroupUnusedBeautifulNumberMapper mapperb, GroupUnusedBeautifulNumber groupUnusedBeautifulNumber){
        int result = 0;
        try {
            result = mapperb.insertGroupUnusedBeautifulNumber(groupUnusedBeautifulNumber.getTenMillion(), groupUnusedBeautifulNumber.getOneMillion(),
                    groupUnusedBeautifulNumber.getOneHundredThousand(), groupUnusedBeautifulNumber.getTenThousand(),
                    groupUnusedBeautifulNumber.getOneThousand(), groupUnusedBeautifulNumber.getOneHundred(),
                    groupUnusedBeautifulNumber.getTen(), groupUnusedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GroupUnusedBeautifulNumberMapper mapperb, GroupUnusedBeautifulNumber groupUnusedBeautifulNumber){
        int result = 0;
        try {
            result = mapperb.deleteGroupUnusedBeautifulNumber(groupUnusedBeautifulNumber.getTenMillion(), groupUnusedBeautifulNumber.getOneMillion(),
                    groupUnusedBeautifulNumber.getOneHundredThousand(), groupUnusedBeautifulNumber.getTenThousand(),
                    groupUnusedBeautifulNumber.getOneThousand(), groupUnusedBeautifulNumber.getOneHundred(),
                    groupUnusedBeautifulNumber.getTen(), groupUnusedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GroupUnusedBeautifulNumber> selectRecord(SqlSession session, GroupUnusedBeautifulNumberMapper mapperb, GroupUnusedBeautifulNumber groupUnusedBeautifulNumber) {
        List<GroupUnusedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectGroupUnusedBeautifulNumber(groupUnusedBeautifulNumber.getTenMillion(), groupUnusedBeautifulNumber.getOneMillion(),
                    groupUnusedBeautifulNumber.getOneHundredThousand(), groupUnusedBeautifulNumber.getTenThousand(),
                    groupUnusedBeautifulNumber.getOneThousand(), groupUnusedBeautifulNumber.getOneHundred(),
                    groupUnusedBeautifulNumber.getTen(), groupUnusedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupUnusedBeautifulNumber> selectRecordByThousand(SqlSession session, GroupUnusedBeautifulNumberMapper mapperb, GroupUnusedBeautifulNumber groupUnusedBeautifulNumber) {
        List<GroupUnusedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectGroupUnusedBeautifulNumberByThousand(groupUnusedBeautifulNumber.getTenMillion(), groupUnusedBeautifulNumber.getOneMillion(),
                    groupUnusedBeautifulNumber.getOneHundredThousand(), groupUnusedBeautifulNumber.getTenThousand(), groupUnusedBeautifulNumber.getOneThousand());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupUnusedBeautifulNumber> selectAllRecords(SqlSession session, GroupUnusedBeautifulNumberMapper mapperb) {
        List<GroupUnusedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectAllGroupUnusedBeautifulNumber();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupUnusedBeautifulNumber> selectOnlyGroupUnusedBeautifulNumber(SqlSession session, GroupUnusedBeautifulNumberMapper mapperb) {
        List<GroupUnusedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectOnlyGroupUnusedBeautifulNumber();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

}
