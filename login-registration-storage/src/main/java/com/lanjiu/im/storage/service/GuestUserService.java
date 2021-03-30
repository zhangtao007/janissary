package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.GuestUserMapper;
import com.lanjiu.im.storage.pojo.GuestUserPO;
import com.lanjiu.im.storage.pojo.VersionPO;
import com.lanjiu.im.storage.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GuestUserService {

    private static final Logger logger = LoggerFactory.getLogger(GuestUserService.class);

    private  SqlSession session;
    private  GuestUserMapper mapper;

    public GuestUserService(){
        session = DBTools.getSession();
        mapper = session.getMapper(GuestUserMapper.class);
    }

    public void close(){
        session.close();
    }

    public int insertUser(GuestUserPO guestUserPO){

        int i = 0;
        try {
            i = mapper.insertGuestUser(guestUserPO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return i;

    }

    public int deleteUser(int userId){

        int i = 0;
        try {
            i = mapper.deleteGuestUser(userId);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return  i;

    }

    public List<GuestUserPO> getAllGuestUser() {
        List<GuestUserPO> list = null;
        try {
            list = mapper.selectAllGuestUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public List<GuestUserPO> getGuestUser(int userId) {
        List<GuestUserPO> list = null;
        try {
            list = mapper.searchGuestUser(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Integer> selectOverTimeUser(int time){
        List<Integer> list = null;
        try {
            list = mapper.selectOverTimeUser(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int removeOverGuest(List<Integer> userIds){

        int i = 0;
        try {
            i = mapper.removeOverTimeUser(userIds);
            session.commit();
        } catch (Exception e) {
           logger.error("清除过期游客账号异常");
            session.rollback();
        }
        return  i;

    }


}
