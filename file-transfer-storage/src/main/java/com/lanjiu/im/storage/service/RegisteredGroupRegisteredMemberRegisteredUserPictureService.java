package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.RegisteredGroupRegisteredMemberRegisteredUserPictureMapper;
import com.lanjiu.im.storage.pojo.RegisteredGroupRegisteredMemberRegisteredUserPicture;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RegisteredGroupRegisteredMemberRegisteredUserPictureService {

    private static final Logger logger = LoggerFactory.getLogger(RegisteredGroupRegisteredMemberRegisteredUserPictureService.class);

    public int insertRecord(SqlSession session, RegisteredGroupRegisteredMemberRegisteredUserPictureMapper mapperb, RegisteredGroupRegisteredMemberRegisteredUserPicture registeredGroupRegisteredMemberRegisteredUserPicture){
        int result = 0;
        try {
            result= mapperb.insertRegisteredGroupRegisteredMemberRegisteredUserPicture(registeredGroupRegisteredMemberRegisteredUserPicture.getDownloadUrl(),
                    registeredGroupRegisteredMemberRegisteredUserPicture.getRegisteredGroupId(),
                    registeredGroupRegisteredMemberRegisteredUserPicture.getRegisteredMemberId(),
                    registeredGroupRegisteredMemberRegisteredUserPicture.getRegisteredUserId(),
                    registeredGroupRegisteredMemberRegisteredUserPicture.getCreationTime());
            session.commit();
        } catch (Exception e) {
            logger.error("insertRecord()",e);
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, RegisteredGroupRegisteredMemberRegisteredUserPictureMapper mapperb, RegisteredGroupRegisteredMemberRegisteredUserPicture registeredGroupRegisteredMemberRegisteredUserPicture){
        int result = 0;
        try {
            result= mapperb.deleteRegisteredGroupRegisteredMemberRegisteredUserPicture(registeredGroupRegisteredMemberRegisteredUserPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            logger.error("deleteRecord()",e);
            session.rollback();
        }
        return result;
    }

    public List<RegisteredGroupRegisteredMemberRegisteredUserPicture> selectRecord(SqlSession session, RegisteredGroupRegisteredMemberRegisteredUserPictureMapper mapperb, RegisteredGroupRegisteredMemberRegisteredUserPicture registeredGroupRegisteredMemberRegisteredUserPicture) {
        List<RegisteredGroupRegisteredMemberRegisteredUserPicture> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupRegisteredMemberRegisteredUserPicture(registeredGroupRegisteredMemberRegisteredUserPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            logger.error("selectRecord()",e);
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupRegisteredMemberRegisteredUserPicture> selectAllRecords(SqlSession session, RegisteredGroupRegisteredMemberRegisteredUserPictureMapper mapperb) {
        List<RegisteredGroupRegisteredMemberRegisteredUserPicture> bList = null;
        try {
            bList = mapperb.selectAllRegisteredGroupRegisteredMemberRegisteredUserPicture();
            session.commit();
        } catch (Exception e) {
            logger.error("selectAllRecords()",e);
            session.rollback();
        }
        return bList;
    }
}
