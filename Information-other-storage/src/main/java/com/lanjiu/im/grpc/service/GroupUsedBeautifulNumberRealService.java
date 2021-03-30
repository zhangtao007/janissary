package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.GroupUsedBeautifulNumberRealMapper;
import com.lanjiu.im.grpc.pojo.GroupUsedBeautifulNumberReal;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GroupUsedBeautifulNumberRealService {

    public int insertRecord(SqlSession session, GroupUsedBeautifulNumberRealMapper mapperb, GroupUsedBeautifulNumberReal groupUsedBeautifulNumberReal){
        int result = 0;
        try {
            result = mapperb.insertGroupUsedBeautifulNumberReal(groupUsedBeautifulNumberReal.getTenMillion(), groupUsedBeautifulNumberReal.getOneMillion(),
                    groupUsedBeautifulNumberReal.getOneHundredThousand(), groupUsedBeautifulNumberReal.getTenThousand(),
                    groupUsedBeautifulNumberReal.getOneThousand(), groupUsedBeautifulNumberReal.getOneHundred(),
                    groupUsedBeautifulNumberReal.getTen(), groupUsedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GroupUsedBeautifulNumberRealMapper mapperb, GroupUsedBeautifulNumberReal groupUsedBeautifulNumberReal){
        int result = 0;
        try {
            result = mapperb.deleteGroupUsedBeautifulNumberReal(groupUsedBeautifulNumberReal.getTenMillion(), groupUsedBeautifulNumberReal.getOneMillion(),
                    groupUsedBeautifulNumberReal.getOneHundredThousand(), groupUsedBeautifulNumberReal.getTenThousand(),
                    groupUsedBeautifulNumberReal.getOneThousand(), groupUsedBeautifulNumberReal.getOneHundred(),
                    groupUsedBeautifulNumberReal.getTen(), groupUsedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GroupUsedBeautifulNumberReal> selectRecord(SqlSession session, GroupUsedBeautifulNumberRealMapper mapperb, GroupUsedBeautifulNumberReal groupUsedBeautifulNumberReal) {
        List<GroupUsedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectGroupUsedBeautifulNumberReal(groupUsedBeautifulNumberReal.getTenMillion(), groupUsedBeautifulNumberReal.getOneMillion(),
                    groupUsedBeautifulNumberReal.getOneHundredThousand(), groupUsedBeautifulNumberReal.getTenThousand(),
                    groupUsedBeautifulNumberReal.getOneThousand(), groupUsedBeautifulNumberReal.getOneHundred(),
                    groupUsedBeautifulNumberReal.getTen(), groupUsedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupUsedBeautifulNumberReal> selectRecordByThousand(SqlSession session, GroupUsedBeautifulNumberRealMapper mapperb, GroupUsedBeautifulNumberReal groupUsedBeautifulNumberReal) {
        List<GroupUsedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectGroupUsedBeautifulNumberRealByThousand(groupUsedBeautifulNumberReal.getTenMillion(), groupUsedBeautifulNumberReal.getOneMillion(),
                    groupUsedBeautifulNumberReal.getOneHundredThousand(), groupUsedBeautifulNumberReal.getTenThousand(), groupUsedBeautifulNumberReal.getOneThousand());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupUsedBeautifulNumberReal> selectAllRecords(SqlSession session, GroupUsedBeautifulNumberRealMapper mapperb) {
        List<GroupUsedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectAllGroupUsedBeautifulNumberReal();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

}
