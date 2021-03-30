package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.GroupUnusedBeautifulNumberRealMapper;
import com.lanjiu.im.grpc.pojo.GroupUnusedBeautifulNumberReal;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GroupUnusedBeautifulNumberRealService {

    public int insertRecord(SqlSession session, GroupUnusedBeautifulNumberRealMapper mapperb, GroupUnusedBeautifulNumberReal groupUnusedBeautifulNumberReal){
        int result = 0;
        try {
            result = mapperb.insertGroupUnusedBeautifulNumberReal(groupUnusedBeautifulNumberReal.getTenMillion(), groupUnusedBeautifulNumberReal.getOneMillion(),
                    groupUnusedBeautifulNumberReal.getOneHundredThousand(), groupUnusedBeautifulNumberReal.getTenThousand(),
                    groupUnusedBeautifulNumberReal.getOneThousand(), groupUnusedBeautifulNumberReal.getOneHundred(),
                    groupUnusedBeautifulNumberReal.getTen(), groupUnusedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GroupUnusedBeautifulNumberRealMapper mapperb, GroupUnusedBeautifulNumberReal groupUnusedBeautifulNumberReal){
        int result = 0;
        try {
            result = mapperb.deleteGroupUnusedBeautifulNumberReal(groupUnusedBeautifulNumberReal.getTenMillion(), groupUnusedBeautifulNumberReal.getOneMillion(),
                    groupUnusedBeautifulNumberReal.getOneHundredThousand(), groupUnusedBeautifulNumberReal.getTenThousand(),
                    groupUnusedBeautifulNumberReal.getOneThousand(), groupUnusedBeautifulNumberReal.getOneHundred(),
                    groupUnusedBeautifulNumberReal.getTen(), groupUnusedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GroupUnusedBeautifulNumberReal> selectRecord(SqlSession session, GroupUnusedBeautifulNumberRealMapper mapperb, GroupUnusedBeautifulNumberReal groupUnusedBeautifulNumberReal) {
        List<GroupUnusedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectGroupUnusedBeautifulNumberReal(groupUnusedBeautifulNumberReal.getTenMillion(), groupUnusedBeautifulNumberReal.getOneMillion(),
                    groupUnusedBeautifulNumberReal.getOneHundredThousand(), groupUnusedBeautifulNumberReal.getTenThousand(),
                    groupUnusedBeautifulNumberReal.getOneThousand(), groupUnusedBeautifulNumberReal.getOneHundred(),
                    groupUnusedBeautifulNumberReal.getTen(), groupUnusedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupUnusedBeautifulNumberReal> selectRecordByThousand(SqlSession session, GroupUnusedBeautifulNumberRealMapper mapperb, GroupUnusedBeautifulNumberReal groupUnusedBeautifulNumberReal) {
        List<GroupUnusedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectGroupUnusedBeautifulNumberRealByThousand(groupUnusedBeautifulNumberReal.getTenMillion(), groupUnusedBeautifulNumberReal.getOneMillion(),
                    groupUnusedBeautifulNumberReal.getOneHundredThousand(), groupUnusedBeautifulNumberReal.getTenThousand(), groupUnusedBeautifulNumberReal.getOneThousand());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupUnusedBeautifulNumberReal> selectAllRecords(SqlSession session, GroupUnusedBeautifulNumberRealMapper mapperb) {
        List<GroupUnusedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectAllGroupUnusedBeautifulNumberReal();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupUnusedBeautifulNumberReal> selectOnlyGroupUnusedBeautifulNumberReal(SqlSession session, GroupUnusedBeautifulNumberRealMapper mapperb) {
        List<GroupUnusedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectOnlyGroupUnusedBeautifulNumberReal();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

}
