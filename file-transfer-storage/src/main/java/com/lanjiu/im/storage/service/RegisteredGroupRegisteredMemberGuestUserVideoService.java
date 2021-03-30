package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.RegisteredGroupRegisteredMemberGuestUserVideoMapper;
import com.lanjiu.im.storage.pojo.RegisteredGroupRegisteredMemberGuestUserVideo;
import com.lanjiu.im.storage.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RegisteredGroupRegisteredMemberGuestUserVideoService {

    public int insertRecord(SqlSession session, RegisteredGroupRegisteredMemberGuestUserVideoMapper mapperb, RegisteredGroupRegisteredMemberGuestUserVideo registeredGroupRegisteredMemberGuestUserVideo){
        int result = 0;
        try {
            result = mapperb.insertRegisteredGroupRegisteredMemberGuestUserVideo(registeredGroupRegisteredMemberGuestUserVideo.getDownloadUrl(),
                    registeredGroupRegisteredMemberGuestUserVideo.getRegisteredGroupId(),
                    registeredGroupRegisteredMemberGuestUserVideo.getRegisteredMemberId(),
                    registeredGroupRegisteredMemberGuestUserVideo.getGuestUserId(),
                    registeredGroupRegisteredMemberGuestUserVideo.getCreationTime());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, RegisteredGroupRegisteredMemberGuestUserVideoMapper mapperb, RegisteredGroupRegisteredMemberGuestUserVideo registeredGroupRegisteredMemberGuestUserVideo){
        int result = 0;
        try {
            result = mapperb.deleteRegisteredGroupRegisteredMemberGuestUserVideo(registeredGroupRegisteredMemberGuestUserVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<RegisteredGroupRegisteredMemberGuestUserVideo> selectRecord(SqlSession session, RegisteredGroupRegisteredMemberGuestUserVideoMapper mapperb, RegisteredGroupRegisteredMemberGuestUserVideo registeredGroupRegisteredMemberGuestUserVideo) {
        List<RegisteredGroupRegisteredMemberGuestUserVideo> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupRegisteredMemberGuestUserVideo(registeredGroupRegisteredMemberGuestUserVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupRegisteredMemberGuestUserVideo> selectAllRecords(SqlSession session, RegisteredGroupRegisteredMemberGuestUserVideoMapper mapperb) {
        List<RegisteredGroupRegisteredMemberGuestUserVideo> bList = null;
        try {
            bList = mapperb.selectAllRegisteredGroupRegisteredMemberGuestUserVideo();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
