package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.RegisteredUserFriendVideoMapper;
import com.lanjiu.im.storage.pojo.RegisteredUserFriendVideo;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class RegisteredUserFriendVideoService {

    private static final Logger logger = LoggerFactory.getLogger(RegisteredUserFriendVideoService.class);

    public int insertRecord(SqlSession session, RegisteredUserFriendVideoMapper mapperb, RegisteredUserFriendVideo registeredUserFriendVideo){
        int result = 0;
        try {
            result = mapperb.insertRegisteredUserFriendVideo(registeredUserFriendVideo.getDownloadUrl(),
                    registeredUserFriendVideo.getRegisteredUserId(),
                    registeredUserFriendVideo.getCreationTime(), registeredUserFriendVideo.getFriendId());
            session.commit();
        } catch (Exception e) {
            logger.error("插入数据库操作错误:",e);
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, RegisteredUserFriendVideoMapper mapperb, RegisteredUserFriendVideo registeredUserFriendVideo){
        int result = 0;
        try {
            result = mapperb.deleteRegisteredUserFriendVideo(registeredUserFriendVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            logger.error("删除数据库操作错误:",e);
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<RegisteredUserFriendVideo> selectRecord(SqlSession session, RegisteredUserFriendVideoMapper mapperb, RegisteredUserFriendVideo registeredUserFriendVideo) {
        List<RegisteredUserFriendVideo> bList = null;
        try {
            bList = mapperb.selectRegisteredUserFriendVideo(registeredUserFriendVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            logger.error("selectRecord():",e);
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredUserFriendVideo> selectRecordByFriendId(SqlSession session, RegisteredUserFriendVideoMapper mapperb, RegisteredUserFriendVideo registeredUserFriendVideo) {
        List<RegisteredUserFriendVideo> bList = null;
        try {
            bList = mapperb.selectRegisteredUserFriendVideoByFriendId(String.valueOf(registeredUserFriendVideo.getRegisteredUserId()), String.valueOf(registeredUserFriendVideo.getFriendId()));
            session.commit();
        } catch (Exception e) {
            logger.error("selectRecordByFriendId():",e);
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredUserFriendVideo> selectAllRecords(SqlSession session, RegisteredUserFriendVideoMapper mapperb) {
        List<RegisteredUserFriendVideo> bList = null;
        try {
            bList = mapperb.selectAllRegisteredUserFriendVideo();
            session.commit();
        } catch (Exception e) {
            logger.error("selectAllRecords():",e);
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredUserFriendVideo> selectRecordOnlyByFriendId(SqlSession session, RegisteredUserFriendVideoMapper mapperb, RegisteredUserFriendVideo registeredUserFriendVideo) {
        List<RegisteredUserFriendVideo> bList = null;
        try {
            bList = mapperb.selectRegisteredUserFriendVideoOnlyByFriendId(registeredUserFriendVideo.getFriendId());
            session.commit();
        } catch (Exception e) {
            logger.error("查询数据库记录异常:",e);
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredUserFriendVideo> selectRecordByRegistUserId(SqlSession session, RegisteredUserFriendVideoMapper mapperb, RegisteredUserFriendVideo registeredUserFriendVideo) {
        List<RegisteredUserFriendVideo> bList = null;
        try {
            bList = mapperb.selectRegisteredUserFriendVideoByUserId(registeredUserFriendVideo.getRegisteredUserId());
            session.commit();
        } catch (Exception e) {
            logger.error("根据用户id查询数据库操作异常：",e);
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredUserFriendVideo> selectVidRecordByDay(SqlSession session, RegisteredUserFriendVideoMapper mapperrv, Date day) {
        List<RegisteredUserFriendVideo> vidList  = new ArrayList<>();
        java.sql.Date sqlDate=new java.sql.Date(day.getTime());
        try {
            vidList = mapperrv.selectVidByDay(sqlDate);
            session.commit();
        } catch (Exception e) {
            logger.error("selectVidRecordByDay",e);
        }
        return vidList;
    }

    public void deleteVidRecordByDay(SqlSession session, RegisteredUserFriendVideoMapper mapperrv, Date day) {
        java.sql.Date sqlDate=new java.sql.Date(day.getTime());
        try {
            mapperrv.deleteVidByDay(sqlDate);
            session.commit();
        } catch (Exception e) {
            logger.error("deleteVidRecordByDay",e);
        }
    }
}
