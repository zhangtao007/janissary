package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.RegisteredGroupGuestMemberRegisteredUserVideoMapper;
import com.lanjiu.im.storage.pojo.RegisteredGroupGuestMemberRegisteredUserVideo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RegisteredGroupGuestMemberRegisteredUserVideoService {

    public int insertRecord(SqlSession session, RegisteredGroupGuestMemberRegisteredUserVideoMapper mapperb, RegisteredGroupGuestMemberRegisteredUserVideo registeredGroupGuestMemberRegisteredUserVideo){
        int result = 0;
        try {
            result = mapperb.insertRegisteredGroupGuestMemberRegisteredUserVideo(registeredGroupGuestMemberRegisteredUserVideo.getDownloadUrl(),
                    registeredGroupGuestMemberRegisteredUserVideo.getRegisteredGroupId(),
                    registeredGroupGuestMemberRegisteredUserVideo.getGuestMemberId(),
                    registeredGroupGuestMemberRegisteredUserVideo.getRegisteredUserId(),
                    registeredGroupGuestMemberRegisteredUserVideo.getCreationTime());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, RegisteredGroupGuestMemberRegisteredUserVideoMapper mapperb, RegisteredGroupGuestMemberRegisteredUserVideo registeredGroupGuestMemberRegisteredUserVideo){
        int result = 0;
        try {
            result = mapperb.deleteRegisteredGroupGuestMemberRegisteredUserVideo(registeredGroupGuestMemberRegisteredUserVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<RegisteredGroupGuestMemberRegisteredUserVideo> selectRecord(SqlSession session, RegisteredGroupGuestMemberRegisteredUserVideoMapper mapperb, RegisteredGroupGuestMemberRegisteredUserVideo registeredGroupGuestMemberRegisteredUserVideo) {
        List<RegisteredGroupGuestMemberRegisteredUserVideo> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupGuestMemberRegisteredUserVideo(registeredGroupGuestMemberRegisteredUserVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroupGuestMemberRegisteredUserVideo> selectAllRecords(SqlSession session, RegisteredGroupGuestMemberRegisteredUserVideoMapper mapperb) {
        List<RegisteredGroupGuestMemberRegisteredUserVideo> bList = null;
        try {
            bList = mapperb.selectAllRegisteredGroupGuestMemberRegisteredUserVideo();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
