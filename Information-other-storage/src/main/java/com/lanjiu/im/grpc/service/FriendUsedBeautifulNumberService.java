package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.FriendUsedBeautifulNumberMapper;
import com.lanjiu.im.grpc.pojo.FriendUsedBeautifulNumber;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FriendUsedBeautifulNumberService {

    public int insertRecord(SqlSession session, FriendUsedBeautifulNumberMapper mapperb, FriendUsedBeautifulNumber friendUsedBeautifulNumber){
        int result = 0;
        try {
            result = mapperb.insertFriendUsedBeautifulNumber(friendUsedBeautifulNumber.getTenMillion(), friendUsedBeautifulNumber.getOneMillion(),
                    friendUsedBeautifulNumber.getOneHundredThousand(), friendUsedBeautifulNumber.getTenThousand(), friendUsedBeautifulNumber.getOneThousand(), friendUsedBeautifulNumber.getOneHundred(),
                    friendUsedBeautifulNumber.getTen(), friendUsedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, FriendUsedBeautifulNumberMapper mapperb, FriendUsedBeautifulNumber friendUsedBeautifulNumber){
        int result = 0;
        try {
            result = mapperb.deleteFriendUsedBeautifulNumber(friendUsedBeautifulNumber.getTenMillion(), friendUsedBeautifulNumber.getOneMillion(),
                    friendUsedBeautifulNumber.getOneHundredThousand(), friendUsedBeautifulNumber.getTenThousand(), friendUsedBeautifulNumber.getOneThousand(), friendUsedBeautifulNumber.getOneHundred(),
                    friendUsedBeautifulNumber.getTen(), friendUsedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<FriendUsedBeautifulNumber> selectRecord(SqlSession session, FriendUsedBeautifulNumberMapper mapperb, FriendUsedBeautifulNumber friendUsedBeautifulNumber) {
        List<FriendUsedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectFriendUsedBeautifulNumber(friendUsedBeautifulNumber.getTenMillion(), friendUsedBeautifulNumber.getOneMillion(),
                    friendUsedBeautifulNumber.getOneHundredThousand(), friendUsedBeautifulNumber.getTenThousand(), friendUsedBeautifulNumber.getOneThousand(), friendUsedBeautifulNumber.getOneHundred(),
                    friendUsedBeautifulNumber.getTen(), friendUsedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<FriendUsedBeautifulNumber> selectRecordByThousand(SqlSession session, FriendUsedBeautifulNumberMapper mapperb, FriendUsedBeautifulNumber friendUsedBeautifulNumber) {
        List<FriendUsedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectFriendUsedBeautifulNumberByThousand(friendUsedBeautifulNumber.getTenMillion(), friendUsedBeautifulNumber.getOneMillion(),
                    friendUsedBeautifulNumber.getOneHundredThousand(), friendUsedBeautifulNumber.getTenThousand(), friendUsedBeautifulNumber.getOneThousand());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<FriendUsedBeautifulNumber> selectAllRecords(SqlSession session, FriendUsedBeautifulNumberMapper mapperb) {
        List<FriendUsedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectAllFriendUsedBeautifulNumber();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

}
