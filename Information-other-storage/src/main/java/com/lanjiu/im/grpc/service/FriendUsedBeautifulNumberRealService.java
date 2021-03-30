package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.FriendUsedBeautifulNumberRealMapper;
import com.lanjiu.im.grpc.pojo.FriendUsedBeautifulNumberReal;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FriendUsedBeautifulNumberRealService {

    public int insertRecord(SqlSession session, FriendUsedBeautifulNumberRealMapper mapperb, FriendUsedBeautifulNumberReal friendUsedBeautifulNumberReal){
        int result = 0;
        try {
            result = mapperb.insertFriendUsedBeautifulNumberReal(friendUsedBeautifulNumberReal.getTenMillion(), friendUsedBeautifulNumberReal.getOneMillion(),
                    friendUsedBeautifulNumberReal.getOneHundredThousand(), friendUsedBeautifulNumberReal.getTenThousand(), friendUsedBeautifulNumberReal.getOneThousand(), friendUsedBeautifulNumberReal.getOneHundred(),
                    friendUsedBeautifulNumberReal.getTen(), friendUsedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, FriendUsedBeautifulNumberRealMapper mapperb, FriendUsedBeautifulNumberReal friendUsedBeautifulNumberReal){
        int result = 0;
        try {
            result = mapperb.deleteFriendUsedBeautifulNumberReal(friendUsedBeautifulNumberReal.getTenMillion(), friendUsedBeautifulNumberReal.getOneMillion(),
                    friendUsedBeautifulNumberReal.getOneHundredThousand(), friendUsedBeautifulNumberReal.getTenThousand(), friendUsedBeautifulNumberReal.getOneThousand(), friendUsedBeautifulNumberReal.getOneHundred(),
                    friendUsedBeautifulNumberReal.getTen(), friendUsedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<FriendUsedBeautifulNumberReal> selectRecord(SqlSession session, FriendUsedBeautifulNumberRealMapper mapperb, FriendUsedBeautifulNumberReal friendUsedBeautifulNumberReal) {
        List<FriendUsedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectFriendUsedBeautifulNumberReal(friendUsedBeautifulNumberReal.getTenMillion(), friendUsedBeautifulNumberReal.getOneMillion(),
                    friendUsedBeautifulNumberReal.getOneHundredThousand(), friendUsedBeautifulNumberReal.getTenThousand(), friendUsedBeautifulNumberReal.getOneThousand(), friendUsedBeautifulNumberReal.getOneHundred(),
                    friendUsedBeautifulNumberReal.getTen(), friendUsedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<FriendUsedBeautifulNumberReal> selectRecordByThousand(SqlSession session, FriendUsedBeautifulNumberRealMapper mapperb, FriendUsedBeautifulNumberReal friendUsedBeautifulNumberReal) {
        List<FriendUsedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectFriendUsedBeautifulNumberRealByThousand(friendUsedBeautifulNumberReal.getTenMillion(), friendUsedBeautifulNumberReal.getOneMillion(),
                    friendUsedBeautifulNumberReal.getOneHundredThousand(), friendUsedBeautifulNumberReal.getTenThousand(), friendUsedBeautifulNumberReal.getOneThousand());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<FriendUsedBeautifulNumberReal> selectAllRecords(SqlSession session, FriendUsedBeautifulNumberRealMapper mapperb) {
        List<FriendUsedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectAllFriendUsedBeautifulNumberReal();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

}
