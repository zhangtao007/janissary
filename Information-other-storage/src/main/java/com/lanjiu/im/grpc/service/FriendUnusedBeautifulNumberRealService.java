package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.FriendUnusedBeautifulNumberRealMapper;
import com.lanjiu.im.grpc.pojo.FriendUnusedBeautifulNumberReal;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/*
 * 注册好友未使用号码服务
 * */
public class FriendUnusedBeautifulNumberRealService {

    public int insertRecord(SqlSession session, FriendUnusedBeautifulNumberRealMapper mapperb, FriendUnusedBeautifulNumberReal friendUnusedBeautifulNumberReal){
        int result = 0;
        try {
            result = mapperb.insertFriendUnusedBeautifulNumberReal(friendUnusedBeautifulNumberReal.getTenMillion(), friendUnusedBeautifulNumberReal.getOneMillion(),
                    friendUnusedBeautifulNumberReal.getOneHundredThousand(), friendUnusedBeautifulNumberReal.getTenThousand(), friendUnusedBeautifulNumberReal.getOneThousand(), friendUnusedBeautifulNumberReal.getOneHundred(),
                    friendUnusedBeautifulNumberReal.getTen(), friendUnusedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, FriendUnusedBeautifulNumberRealMapper mapperb, FriendUnusedBeautifulNumberReal friendUnusedBeautifulNumberReal){
        int result = 0;
        try {
            result = mapperb.deleteFriendUnusedBeautifulNumberReal(friendUnusedBeautifulNumberReal.getTenMillion(), friendUnusedBeautifulNumberReal.getOneMillion(),
                    friendUnusedBeautifulNumberReal.getOneHundredThousand(), friendUnusedBeautifulNumberReal.getTenThousand(), friendUnusedBeautifulNumberReal.getOneThousand(), friendUnusedBeautifulNumberReal.getOneHundred(),
                    friendUnusedBeautifulNumberReal.getTen(), friendUnusedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<FriendUnusedBeautifulNumberReal> selectRecord(SqlSession session, FriendUnusedBeautifulNumberRealMapper mapperb, FriendUnusedBeautifulNumberReal friendUnusedBeautifulNumberReal) {
        List<FriendUnusedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectFriendUnusedBeautifulNumberReal(friendUnusedBeautifulNumberReal.getTenMillion(), friendUnusedBeautifulNumberReal.getOneMillion(),
                    friendUnusedBeautifulNumberReal.getOneHundredThousand(), friendUnusedBeautifulNumberReal.getTenThousand(), friendUnusedBeautifulNumberReal.getOneThousand(), friendUnusedBeautifulNumberReal.getOneHundred(),
                    friendUnusedBeautifulNumberReal.getTen(), friendUnusedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<FriendUnusedBeautifulNumberReal> selectRecordByThousand(SqlSession session, FriendUnusedBeautifulNumberRealMapper mapperb, FriendUnusedBeautifulNumberReal friendUnusedBeautifulNumberReal) {
        List<FriendUnusedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectFriendUnusedBeautifulNumberRealByThousand(friendUnusedBeautifulNumberReal.getTenMillion(), friendUnusedBeautifulNumberReal.getOneMillion(),
                    friendUnusedBeautifulNumberReal.getOneHundredThousand(), friendUnusedBeautifulNumberReal.getTenThousand(), friendUnusedBeautifulNumberReal.getOneThousand());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<FriendUnusedBeautifulNumberReal> selectAllRecords(SqlSession session, FriendUnusedBeautifulNumberRealMapper mapperb) {
        List<FriendUnusedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectAllFriendUnusedBeautifulNumberReal();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<FriendUnusedBeautifulNumberReal> selectOnlyFriendUnusedBeautifulNumberReal(SqlSession session, FriendUnusedBeautifulNumberRealMapper mapperb) {
        List<FriendUnusedBeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectOnlyFriendUnusedBeautifulNumberReal();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

}
