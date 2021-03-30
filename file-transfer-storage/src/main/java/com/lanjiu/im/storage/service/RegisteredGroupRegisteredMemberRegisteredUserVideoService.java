package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.RegisteredGroupRegisteredMemberRegisteredUserVideoMapper;
import com.lanjiu.im.storage.pojo.RegisteredGroupRegisteredMemberRegisteredUserVideo;
import com.lanjiu.im.storage.server.TransferStorageServer;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class RegisteredGroupRegisteredMemberRegisteredUserVideoService {

    private static final Logger logger = LoggerFactory.getLogger(RegisteredGroupRegisteredMemberRegisteredUserVideoService.class);

    public int insertRecord(SqlSession session, RegisteredGroupRegisteredMemberRegisteredUserVideoMapper mapperb, RegisteredGroupRegisteredMemberRegisteredUserVideo registeredGroupRegisteredMemberRegisteredUserVideo){
        int result = 0;
        try {
            result = mapperb.insertRegisteredGroupRegisteredMemberRegisteredUserVideo(registeredGroupRegisteredMemberRegisteredUserVideo.getDownloadUrl(),
                    registeredGroupRegisteredMemberRegisteredUserVideo.getRegisteredGroupId(),
                    registeredGroupRegisteredMemberRegisteredUserVideo.getRegisteredMemberId(),
                    registeredGroupRegisteredMemberRegisteredUserVideo.getRegisteredUserId(),
                    registeredGroupRegisteredMemberRegisteredUserVideo.getCreationTime());
            session.commit();
        } catch (Exception e) {
           logger.error("insertRecord()",e);
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, RegisteredGroupRegisteredMemberRegisteredUserVideoMapper mapperb, RegisteredGroupRegisteredMemberRegisteredUserVideo registeredGroupRegisteredMemberRegisteredUserVideo){
        int result = 0;
        try {
            result = mapperb.deleteRegisteredGroupRegisteredMemberRegisteredUserVideo(registeredGroupRegisteredMemberRegisteredUserVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            logger.error("deleteRecord()",e);
            session.rollback();
        }
        return result;
    }

    public List<RegisteredGroupRegisteredMemberRegisteredUserVideo> selectRecord(SqlSession session, RegisteredGroupRegisteredMemberRegisteredUserVideoMapper mapperb, RegisteredGroupRegisteredMemberRegisteredUserVideo registeredGroupRegisteredMemberRegisteredUserVideo) {
        List<RegisteredGroupRegisteredMemberRegisteredUserVideo> bList = new ArrayList<>();
        try {
            bList = mapperb.selectRegisteredGroupRegisteredMemberRegisteredUserVideo(registeredGroupRegisteredMemberRegisteredUserVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            logger.error("selectRecord()",e);
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupRegisteredMemberRegisteredUserVideo> selectAllRecords(SqlSession session, RegisteredGroupRegisteredMemberRegisteredUserVideoMapper mapperb) {
        List<RegisteredGroupRegisteredMemberRegisteredUserVideo> bList = new ArrayList<>();
        try {
            bList = mapperb.selectAllRegisteredGroupRegisteredMemberRegisteredUserVideo();
            session.commit();
        } catch (Exception e) {
            logger.error("selectAllRecords()",e);
            session.rollback();
        }
        return bList;
    }
}
