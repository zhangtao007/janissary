package com.lanjiu.im.storage.service;

import com.lanjiu.im.regist.utils.IMSContacts;
import com.lanjiu.im.storage.dao.mapper.impl.RegisterUserMapper;
import com.lanjiu.im.storage.pojo.RegisterUserPO;
import com.lanjiu.im.storage.pojo.UserDevice;
import com.lanjiu.im.storage.pojo.VersionPO;
import com.lanjiu.im.storage.util.DBTools;
import com.lanjiu.pro.login.RequestDeviceUpdate;
import com.lanjiu.pro.login.RequestUserDevice;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class RegisterUserService {

    private static final Logger logger = LoggerFactory.getLogger(RegisterUserService.class);

    private  SqlSession session;
    private  RegisterUserMapper mapper;

    public RegisterUserService(){
        session = DBTools.getSession();
        mapper = session.getMapper(RegisterUserMapper.class);
    }

    public void close(){
        session.close();
    }

    public int insertUser(RegisterUserPO registerUserPO){

        int i = 0;
        try {
            i = mapper.insertRegisterUser(registerUserPO);
            session.commit();
        } catch (Exception e) {
            String userId = String.valueOf(registerUserPO.getUserId());
            logger.error("插入用户错误，>> userId:{} ",userId);
            logger.error("info:"+e.getMessage());
            session.rollback();
        }
        return i;
    }

    public int deleteUser(int userId){

        int i =0;
        try {
            i = mapper.deleteRegisterUser(userId);
            session.commit();
        } catch (Exception e) {
            logger.error("deleteUser Error,userId:{}",userId);
            logger.error("info:"+e.getMessage());
            session.rollback();
        }
        return i;

    }

    public int updateUser(RegisterUserPO registerUserPO){

        int i=0;
        try {
            i = mapper.updateRegisterUser(registerUserPO);
            session.commit();
        } catch (Exception e) {
            String userId = String.valueOf(registerUserPO.getUserId());
            logger.error("updateUser Error,userId:{}",userId);
            logger.error("info:"+e.getMessage());
            session.rollback();
        }
        return i;
    }

    public List<RegisterUserPO> selectAllUser(){

        List<RegisterUserPO> list = null;
        try {
            list = mapper.selectAllRegisterUser();
            session.commit();
        } catch (Exception e) {
            logger.info("selectAllUser Error");
        }
        return list;
    }

    public RegisterUserPO selectUser(int userId){

        RegisterUserPO registerUserPO = null;
        try {
            registerUserPO = mapper.selesctRegisterUser(userId);
            session.commit();
        } catch (Exception e) {
            logger.error("selectUser Error,>> userId:{}",userId);
            logger.error("info:"+e.getMessage());
        }
        return registerUserPO;
    }

    public String getUserPass(String userId) {
        String pass = null;
        try {
             pass =mapper.selectUserPass(Integer.parseInt(userId));
            session.commit();
        } catch (Exception e) {
            logger.error("getUserPass Error，》》 userId:{}",userId);
            logger.error("info:"+e.getMessage());
        }
        return  pass;
    }


    public List<RegisterUserPO> searchUser(int userId) {
        List<RegisterUserPO> list = null;
        try {
            list = mapper.searchUserById(userId);
            session.commit();
        } catch (Exception e) {
            logger.error("searchUser Error,>> userId:{}",userId);
            logger.error("info:"+e.getMessage());
        }
        return list;
    }

    public VersionPO getNewVersion(){
        VersionPO versionPO = null;
        try {
            versionPO = mapper.selectNewVersion();
            session.commit();
        } catch (Exception e) {
            logger.error("获取app新版本异常");
            logger.error("info:"+e.getMessage());
        }
        return  versionPO;
    }

    public RegisterUserPO getUserByPhone(String phone) {
        List<RegisterUserPO> list = null;
        try {
            list = mapper.getUserByPhone(phone);
            session.commit();
        } catch (Exception e) {
            logger.error("getUserByPhone Error,>> phone:{}",phone);
            logger.error("info:"+e.getMessage());
        }
        return list.get(0);
    }

    public UserDevice selectUserDevice(String userId) {
        List<UserDevice> list = null;
        try {
            list = mapper.getUserDevice(Integer.parseInt(userId));
            session.commit();
        } catch (Exception e) {
            logger.error("getUserDevice Error,>> userId:{}",userId);
            logger.error("info:"+e.getMessage());
        }
        if (list != null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    public RequestUserDevice insertUserDevice(String userId, String pushToken, String manufacturer) {
        try {
            mapper.insertUserDevice(Integer.parseInt(userId),manufacturer,pushToken);
            session.commit();
            session.close();
        } catch (NumberFormatException e) {
            logger.error("insertUserDevice :"+e.getMessage()+",userId:"+userId+",manufacturer："+manufacturer);
        } finally {
            session.close();
        }
        return RequestUserDevice.newBuilder().addRequestDeviceUpdate(RequestDeviceUpdate.newBuilder()
                .setStatusDetail(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS)
                .setUserId(userId).setPushToken(pushToken).setManufacturer(manufacturer).build()).build();
    }

    public int updateUserDevice(String userId, String pushToken, String manufacturer) {
        int n=0;
        try {
            n = mapper.updateUserDevice(Integer.parseInt(userId),manufacturer,pushToken);
            session.commit();
            session.close();
        } catch (NumberFormatException e) {
            logger.error("updateUserDevice :"+e.getMessage()+",userId:"+userId+",manufacturer："+manufacturer);
        } finally {
            session.close();
        }
        return n;
    }
}
