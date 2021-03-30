package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.RegisteredGroupGuestMemberRegisteredUserPictureMapper;
import com.lanjiu.im.storage.pojo.RegisteredGroupGuestMemberRegisteredUserPicture;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.logging.Logger;

public class RegisteredGroupGuestMemberRegisteredUserPictureService {

    private static final Logger logger = Logger.getLogger(RegisteredGroupGuestMemberRegisteredUserPictureService.class.getName());

    public int insertRecord(SqlSession session, RegisteredGroupGuestMemberRegisteredUserPictureMapper mapperb, RegisteredGroupGuestMemberRegisteredUserPicture registeredGroupGuestMemberRegisteredUserPicture){
        int result = 0;
        try {
            result = mapperb.insertRegisteredGroupGuestMemberRegisteredUserPicture(registeredGroupGuestMemberRegisteredUserPicture.getDownloadUrl(),
                    registeredGroupGuestMemberRegisteredUserPicture.getRegisteredGroupId(),
                    registeredGroupGuestMemberRegisteredUserPicture.getGuestMemberId(),
                    registeredGroupGuestMemberRegisteredUserPicture.getRegisteredUserId(),
                    registeredGroupGuestMemberRegisteredUserPicture.getCreationTime());
            session.commit();
        } catch (Exception e) {
            logger.info("群成员插入记录异常，"+e.getMessage());
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, RegisteredGroupGuestMemberRegisteredUserPictureMapper mapperb, RegisteredGroupGuestMemberRegisteredUserPicture registeredGroupGuestMemberRegisteredUserPicture){
        int result = 0;
        try {
            result = mapperb.deleteRegisteredGroupGuestMemberRegisteredUserPicture(registeredGroupGuestMemberRegisteredUserPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<RegisteredGroupGuestMemberRegisteredUserPicture> selectRecord(SqlSession session, RegisteredGroupGuestMemberRegisteredUserPictureMapper mapperb, RegisteredGroupGuestMemberRegisteredUserPicture registeredGroupGuestMemberRegisteredUserPicture) {
        List<RegisteredGroupGuestMemberRegisteredUserPicture> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupGuestMemberRegisteredUserPicture(registeredGroupGuestMemberRegisteredUserPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupGuestMemberRegisteredUserPicture> selectAllRecords(SqlSession session, RegisteredGroupGuestMemberRegisteredUserPictureMapper mapperb) {
        List<RegisteredGroupGuestMemberRegisteredUserPicture> bList = null;
        try {
            bList = mapperb.selectAllRegisteredGroupGuestMemberRegisteredUserPicture();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
