package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.UserInfomationMapper;
import com.lanjiu.im.storage.pojo.UserInfomationPO;
import com.lanjiu.im.storage.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserInfomationService {

    private static final Logger logger = LoggerFactory.getLogger(RegisterUserService.class);

    private  SqlSession session;
    private  UserInfomationMapper mapper;

    public UserInfomationService(){
        session = DBTools.getSession();
        mapper = session.getMapper(UserInfomationMapper.class);
    }

    public void close(){
        session.close();
    }

    public int insertUserInfo(UserInfomationPO userInfomationPO ){

        int i = 0;
        try {
            i = mapper.insertUserInfomation(userInfomationPO);
            session.commit();
        } catch (Exception e) {
            String userId = String.valueOf(userInfomationPO.getUserId());
            logger.error("插入用户信息错误，>> userId:{} ",userId);
            logger.error("info:"+e.getMessage());
            session.rollback();
        }
        return  i;
    }


    public int updateUserInfo(UserInfomationPO userInfomationPO){
        int i=0;
        try {
            i = mapper.updateUserInfomation(userInfomationPO);
            session.commit();
        } catch (Exception e) {
            String userId = String.valueOf(userInfomationPO.getUserId());
            logger.error("更新用户设置信息错误，userId：{}",userId);
           logger.error("info:"+e.getMessage());
            session.rollback();
        }
        return i;
    }
    
    public List<UserInfomationPO> getUsrInfomation( int userId){
        List<UserInfomationPO> list = null;
        try {
            list = this.mapper.selectUserInfomation( userId);
            session.commit();
        } catch (Exception e) {
            logger.error("selectUserInfo ,userId:{}  Error!" , userId);
            logger.error("info:",e);
            session.rollback();
        }
        return list;

    }

}
