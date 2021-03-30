package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.GroupUsedBeautifulNumberMapper;
import com.lanjiu.im.grpc.pojo.GroupUsedBeautifulNumber;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GroupUsedBeautifulNumberService {

    public int insertRecord(SqlSession session, GroupUsedBeautifulNumberMapper mapperb, GroupUsedBeautifulNumber groupUsedBeautifulNumber){
        int result = 0;
        try {
            result = mapperb.insertGroupUsedBeautifulNumber(groupUsedBeautifulNumber.getTenMillion(), groupUsedBeautifulNumber.getOneMillion(),
                    groupUsedBeautifulNumber.getOneHundredThousand(), groupUsedBeautifulNumber.getTenThousand(),
                    groupUsedBeautifulNumber.getOneThousand(), groupUsedBeautifulNumber.getOneHundred(),
                    groupUsedBeautifulNumber.getTen(), groupUsedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GroupUsedBeautifulNumberMapper mapperb, GroupUsedBeautifulNumber groupUsedBeautifulNumber){
        int result = 0;
        try {
            result = mapperb.deleteGroupUsedBeautifulNumber(groupUsedBeautifulNumber.getTenMillion(), groupUsedBeautifulNumber.getOneMillion(),
                    groupUsedBeautifulNumber.getOneHundredThousand(), groupUsedBeautifulNumber.getTenThousand(),
                    groupUsedBeautifulNumber.getOneThousand(), groupUsedBeautifulNumber.getOneHundred(),
                    groupUsedBeautifulNumber.getTen(), groupUsedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GroupUsedBeautifulNumber> selectRecord(SqlSession session, GroupUsedBeautifulNumberMapper mapperb, GroupUsedBeautifulNumber groupUsedBeautifulNumber) {
        List<GroupUsedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectGroupUsedBeautifulNumber(groupUsedBeautifulNumber.getTenMillion(), groupUsedBeautifulNumber.getOneMillion(),
                    groupUsedBeautifulNumber.getOneHundredThousand(), groupUsedBeautifulNumber.getTenThousand(),
                    groupUsedBeautifulNumber.getOneThousand(), groupUsedBeautifulNumber.getOneHundred(),
                    groupUsedBeautifulNumber.getTen(), groupUsedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupUsedBeautifulNumber> selectRecordByThousand(SqlSession session, GroupUsedBeautifulNumberMapper mapperb, GroupUsedBeautifulNumber groupUsedBeautifulNumber) {
        List<GroupUsedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectGroupUsedBeautifulNumberByThousand(groupUsedBeautifulNumber.getTenMillion(), groupUsedBeautifulNumber.getOneMillion(),
                    groupUsedBeautifulNumber.getOneHundredThousand(), groupUsedBeautifulNumber.getTenThousand(), groupUsedBeautifulNumber.getOneThousand());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupUsedBeautifulNumber> selectAllRecords(SqlSession session, GroupUsedBeautifulNumberMapper mapperb) {
        List<GroupUsedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectAllGroupUsedBeautifulNumber();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
