package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.RegisteredGroupGuestMemberGuestUserPictureMapper;
import com.lanjiu.im.storage.pojo.RegisteredGroupGuestMemberGuestUserPicture;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RegisteredGroupGuestMemberGuestUserPictureService {

    public int insertRecord(SqlSession session, RegisteredGroupGuestMemberGuestUserPictureMapper mapperb, RegisteredGroupGuestMemberGuestUserPicture registeredGroupGuestMemberGuestUserPicture){
        int result = 0;
        try {
            result = mapperb.insertRegisteredGroupGuestMemberGuestUserPicture(registeredGroupGuestMemberGuestUserPicture.getDownloadUrl(),
                    registeredGroupGuestMemberGuestUserPicture.getRegisteredGroupId(),
                    registeredGroupGuestMemberGuestUserPicture.getGuestMemberId(),
                    registeredGroupGuestMemberGuestUserPicture.getGuestUserId(),
                    registeredGroupGuestMemberGuestUserPicture.getCreationTime());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, RegisteredGroupGuestMemberGuestUserPictureMapper mapperb, RegisteredGroupGuestMemberGuestUserPicture registeredGroupGuestMemberGuestUserPicture){
        int result = 0;
        try {
            result = mapperb.deleteRegisteredGroupGuestMemberGuestUserPicture(registeredGroupGuestMemberGuestUserPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<RegisteredGroupGuestMemberGuestUserPicture> selectRecord(SqlSession session, RegisteredGroupGuestMemberGuestUserPictureMapper mapperb, RegisteredGroupGuestMemberGuestUserPicture registeredGroupGuestMemberGuestUserPicture) {
        List<RegisteredGroupGuestMemberGuestUserPicture> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupGuestMemberGuestUserPicture(registeredGroupGuestMemberGuestUserPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupGuestMemberGuestUserPicture> selectAllRecords(SqlSession session, RegisteredGroupGuestMemberGuestUserPictureMapper mapperb) {
        List<RegisteredGroupGuestMemberGuestUserPicture> bList = null;
        try {
            bList = mapperb.selectAllRegisteredGroupGuestMemberGuestUserPicture();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
