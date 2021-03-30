package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.RegisteredGroupRegisteredMemberGuestUserPictureMapper;
import com.lanjiu.im.storage.pojo.RegisteredGroupRegisteredMemberGuestUserPicture;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RegisteredGroupRegisteredMemberGuestUserPictureService {

    public int insertRecord(SqlSession session, RegisteredGroupRegisteredMemberGuestUserPictureMapper mapperb, RegisteredGroupRegisteredMemberGuestUserPicture registeredGroupRegisteredMemberGuestUserPicture){
        int result = 0;
        try {
            mapperb.insertRegisteredGroupRegisteredMemberGuestUserPicture(registeredGroupRegisteredMemberGuestUserPicture.getDownloadUrl(),
                    registeredGroupRegisteredMemberGuestUserPicture.getRegisteredGroupId(),
                    registeredGroupRegisteredMemberGuestUserPicture.getRegisteredMemberId(),
                    registeredGroupRegisteredMemberGuestUserPicture.getGuestUserId(),
                    registeredGroupRegisteredMemberGuestUserPicture.getCreationTime());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, RegisteredGroupRegisteredMemberGuestUserPictureMapper mapperb, RegisteredGroupRegisteredMemberGuestUserPicture registeredGroupRegisteredMemberGuestUserPicture){
        int result = 0;
        try {
            result = mapperb.deleteRegisteredGroupRegisteredMemberGuestUserPicture(registeredGroupRegisteredMemberGuestUserPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<RegisteredGroupRegisteredMemberGuestUserPicture> selectRecord(SqlSession session, RegisteredGroupRegisteredMemberGuestUserPictureMapper mapperb, RegisteredGroupRegisteredMemberGuestUserPicture registeredGroupRegisteredMemberGuestUserPicture) {
        List<RegisteredGroupRegisteredMemberGuestUserPicture> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupRegisteredMemberGuestUserPicture(registeredGroupRegisteredMemberGuestUserPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupRegisteredMemberGuestUserPicture> selectAllRecords(SqlSession session, RegisteredGroupRegisteredMemberGuestUserPictureMapper mapperb) {
        List<RegisteredGroupRegisteredMemberGuestUserPicture> bList = null;
        try {
            bList = mapperb.selectAllRegisteredGroupRegisteredMemberGuestUserPicture();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
