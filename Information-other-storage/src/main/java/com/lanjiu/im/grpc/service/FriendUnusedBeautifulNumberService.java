package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.FriendUnusedBeautifulNumberMapper;
import com.lanjiu.im.grpc.pojo.FriendUnusedBeautifulNumber;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FriendUnusedBeautifulNumberService {

    public int insertRecord(SqlSession session, FriendUnusedBeautifulNumberMapper mapperb, FriendUnusedBeautifulNumber friendUnusedBeautifulNumber){
        int result = 0;
        try {
            result = mapperb.insertFriendUnusedBeautifulNumber(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
                    friendUnusedBeautifulNumber.getOneHundredThousand(), friendUnusedBeautifulNumber.getTenThousand(), friendUnusedBeautifulNumber.getOneThousand(), friendUnusedBeautifulNumber.getOneHundred(),
                    friendUnusedBeautifulNumber.getTen(), friendUnusedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, FriendUnusedBeautifulNumberMapper mapperb, FriendUnusedBeautifulNumber friendUnusedBeautifulNumber){
        int result = 0;
        try {
            result = mapperb.deleteFriendUnusedBeautifulNumber(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
                    friendUnusedBeautifulNumber.getOneHundredThousand(), friendUnusedBeautifulNumber.getTenThousand(), friendUnusedBeautifulNumber.getOneThousand(), friendUnusedBeautifulNumber.getOneHundred(),
                    friendUnusedBeautifulNumber.getTen(), friendUnusedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<FriendUnusedBeautifulNumber> selectRecord(SqlSession session, FriendUnusedBeautifulNumberMapper mapperb, FriendUnusedBeautifulNumber friendUnusedBeautifulNumber) {
        List<FriendUnusedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectFriendUnusedBeautifulNumber(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
                    friendUnusedBeautifulNumber.getOneHundredThousand(), friendUnusedBeautifulNumber.getTenThousand(), friendUnusedBeautifulNumber.getOneThousand(), friendUnusedBeautifulNumber.getOneHundred(),
                    friendUnusedBeautifulNumber.getTen(), friendUnusedBeautifulNumber.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<FriendUnusedBeautifulNumber> selectRecordByThousand(SqlSession session, FriendUnusedBeautifulNumberMapper mapperb, FriendUnusedBeautifulNumber friendUnusedBeautifulNumber) {
        List<FriendUnusedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectFriendUnusedBeautifulNumberByThousand(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
                    friendUnusedBeautifulNumber.getOneHundredThousand(), friendUnusedBeautifulNumber.getTenThousand(), friendUnusedBeautifulNumber.getOneThousand());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<FriendUnusedBeautifulNumber> selectAllRecords(SqlSession session, FriendUnusedBeautifulNumberMapper mapperb) {
        List<FriendUnusedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectAllFriendUnusedBeautifulNumber();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<FriendUnusedBeautifulNumber> selectOnlyFriendUnusedBeautifulNumber(SqlSession session, FriendUnusedBeautifulNumberMapper mapperb) {
        List<FriendUnusedBeautifulNumber> bList = null;
        try {
            bList = mapperb.selectOnlyFriendUnusedBeautifulNumber();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

}
