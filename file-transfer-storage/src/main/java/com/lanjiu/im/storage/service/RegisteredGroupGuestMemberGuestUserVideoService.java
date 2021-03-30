package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.RegisteredGroupGuestMemberGuestUserVideoMapper;
import com.lanjiu.im.storage.pojo.RegisteredGroupGuestMemberGuestUserVideo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RegisteredGroupGuestMemberGuestUserVideoService {

    public int insertRecord(SqlSession session, RegisteredGroupGuestMemberGuestUserVideoMapper mapperb, RegisteredGroupGuestMemberGuestUserVideo registeredGroupGuestMemberGuestUserVideo){
        int result = 0;
        try {
            result = mapperb.insertRegisteredGroupGuestMemberGuestUserVideo(registeredGroupGuestMemberGuestUserVideo.getDownloadUrl(),
                    registeredGroupGuestMemberGuestUserVideo.getRegisteredGroupId(),
                    registeredGroupGuestMemberGuestUserVideo.getGuestMemberId(),
                    registeredGroupGuestMemberGuestUserVideo.getGuestUserId(),
                    registeredGroupGuestMemberGuestUserVideo.getCreationTime());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, RegisteredGroupGuestMemberGuestUserVideoMapper mapperb, RegisteredGroupGuestMemberGuestUserVideo registeredGroupGuestMemberGuestUserVideo){
        int result = 0;
        try {
            result = mapperb.deleteRegisteredGroupGuestMemberGuestUserVideo(registeredGroupGuestMemberGuestUserVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<RegisteredGroupGuestMemberGuestUserVideo> selectRecord(SqlSession session, RegisteredGroupGuestMemberGuestUserVideoMapper mapperb, RegisteredGroupGuestMemberGuestUserVideo registeredGroupGuestMemberGuestUserVideo) {
        List<RegisteredGroupGuestMemberGuestUserVideo> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupGuestMemberGuestUserVideo(registeredGroupGuestMemberGuestUserVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupGuestMemberGuestUserVideo> selectAllRecords(SqlSession session, RegisteredGroupGuestMemberGuestUserVideoMapper mapperb) {
        List<RegisteredGroupGuestMemberGuestUserVideo> bList = null;
        try {
            bList = mapperb.selectAllRegisteredGroupGuestMemberGuestUserVideo();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
