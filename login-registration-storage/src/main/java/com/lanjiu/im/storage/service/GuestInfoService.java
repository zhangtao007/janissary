package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.GuestInfomationMapper;
import com.lanjiu.im.storage.pojo.GuestUserInfoPO;
import com.lanjiu.im.storage.pojo.UserInfomationPO;
import com.lanjiu.im.storage.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GuestInfoService {

    private SqlSession session;
    private GuestInfomationMapper mapper;

    public GuestInfoService(){
        session = DBTools.getSession();
        mapper = session.getMapper(GuestInfomationMapper.class);
    }

    public void close(){
        session.close();
    }

    public int insertUserInfo(GuestUserInfoPO  userInfomationPO ){

        int i = 0;
        try {
            i = mapper.insertUserInfomation(userInfomationPO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return  i;
    }

    public int deleteUserInfo(int userId){

        int i = 0;
        try {
            i = mapper.deleteUserInfomation(userId);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return i;

    }

    public int updateUserInfo(GuestUserInfoPO  userInfomationPO){
        int i=0;
        try {
            i = mapper.updateUserInfomation(userInfomationPO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return i;
    }

    public List<GuestUserInfoPO> getUsrInfomation(int userId){
        List<GuestUserInfoPO>   list = null;
        try {
            list = this.mapper.selectUserInfomation( userId);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return list;

    }

    public int removeOverGuestInfo(List<Integer> UserIds) {
        int i=0;
        try {
            i = mapper.removeOverGuestInfo(UserIds);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return i;
    }
}
