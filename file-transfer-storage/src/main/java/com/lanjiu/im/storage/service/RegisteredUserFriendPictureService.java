package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.RegisteredUserFriendPictureMapper;
import com.lanjiu.im.storage.pojo.RegisteredUserFriendPicture;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisteredUserFriendPictureService {

    private static final Logger logger = LoggerFactory.getLogger(RegisteredUserFriendPictureService.class);

    public int insertRecord(SqlSession session, RegisteredUserFriendPictureMapper mapperb, RegisteredUserFriendPicture registeredUserFriendPicture){
        int result = 0;
        try {
            result = mapperb.insertRegisteredUserFriendPicture(registeredUserFriendPicture.getDownloadUrl(),
                    registeredUserFriendPicture.getRegisteredUserId(),
                    registeredUserFriendPicture.getCreationTime(), registeredUserFriendPicture.getFriendId());
            session.commit();
        } catch (Exception e) {
            logger.error("insertRecord()",e);
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, RegisteredUserFriendPictureMapper mapperb, RegisteredUserFriendPicture registeredUserFriendPicture){
        int result = 0;
        try {
            result = mapperb.deleteRegisteredUserFriendPicture(registeredUserFriendPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            logger.error("deleteRecord()",e);
            session.rollback();
        }
        return result;
    }

    public List<RegisteredUserFriendPicture> selectRecord(SqlSession session, RegisteredUserFriendPictureMapper mapperb, RegisteredUserFriendPicture registeredUserFriendPicture) {
        List<RegisteredUserFriendPicture> bList = null;
        try {
            bList = mapperb.selectRegisteredUserFriendPicture(registeredUserFriendPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            logger.error("selectRecord()",e);
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredUserFriendPicture> selectRecordByFriendId(SqlSession session, RegisteredUserFriendPictureMapper mapperb, RegisteredUserFriendPicture registeredUserFriendPicture) {
        List<RegisteredUserFriendPicture> bList = null;
        try {
            bList = mapperb.selectRegisteredUserFriendPictureByFriendId(String.valueOf(registeredUserFriendPicture.getRegisteredUserId()), String.valueOf(registeredUserFriendPicture.getFriendId()));
            session.commit();
        } catch (Exception e) {
            logger.error("selectRecordByFriendId()",e);
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredUserFriendPicture> selectAllRecords(SqlSession session, RegisteredUserFriendPictureMapper mapperb) {
        List<RegisteredUserFriendPicture> bList = null;
        try {
            bList = mapperb.selectAllRegisteredUserFriendPicture();
            session.commit();
        } catch (Exception e) {
            logger.error("selectAllRecords()",e);
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredUserFriendPicture> selectRecordOnlyByFriendId(SqlSession session, RegisteredUserFriendPictureMapper mapperb, RegisteredUserFriendPicture registeredUserFriendPicture) {
        List<RegisteredUserFriendPicture> bList = null;
        try {
            bList = mapperb.selectRegisteredUserFriendPictureOnlyByFriendId(registeredUserFriendPicture.getFriendId());
            session.commit();
        } catch (Exception e) {
            logger.error("selectRecordOnlyByFriendId()",e);
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredUserFriendPicture> selectRecordByUserId(SqlSession session, RegisteredUserFriendPictureMapper mapperb, RegisteredUserFriendPicture registeredUserFriendPicture) {
        List<RegisteredUserFriendPicture> bList = null;
        try {
            bList = mapperb.selectRegisteredUserFriendPictureByUserId(registeredUserFriendPicture.getRegisteredUserId());
            session.commit();
        } catch (Exception e) {
            logger.error("selectRecordByUserId()",e);
            session.rollback();
        }
        return bList;
    }

    public void cleanRegistFile(SqlSession session, RegisteredUserFriendPictureMapper mapperbrp, int userId) {
        try {
            mapperbrp.cleanFriendPictureVideo(userId);
            session.commit();
        } catch (Exception e) {
            logger.error("cleanRegistFile()",e);
            session.rollback();
        }
    }

    public List<RegisteredUserFriendPicture> selectPicRecordByDay(SqlSession session, RegisteredUserFriendPictureMapper mapperbrp, Date day) {
        List<RegisteredUserFriendPicture> vidList  = new ArrayList<>();
        java.sql.Date sqlDate=new java.sql.Date(day.getTime());
        try {
            vidList = mapperbrp.selectPicByDay(sqlDate);
            session.commit();
        } catch (Exception e) {
            logger.error("selectPicRecordByDay",e);
        }
        return vidList;
    }

    public void deletePicRecordByDay(SqlSession session, RegisteredUserFriendPictureMapper mapperbrp, Date day) {
        java.sql.Date sqlDate=new java.sql.Date(day.getTime());
        try {
            mapperbrp.deletePicByDay(sqlDate);
            session.commit();
        } catch (Exception e) {
            logger.error("deletePicRecordByDay",e);
        }
    }
}
