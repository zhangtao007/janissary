package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupGuestMemberRegisteredUserVideoMapper;
import com.lanjiu.im.storage.pojo.GuestGroupGuestMemberRegisteredUserVideo;
import com.lanjiu.im.storage.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GuestGroupGuestMemberRegisteredUserVideoService {

    public int insertRecord(SqlSession session, GuestGroupGuestMemberRegisteredUserVideoMapper mapperb, GuestGroupGuestMemberRegisteredUserVideo guestGroupGuestMemberRegisteredUserVideo){
        int result = 0;
        try {
            result = mapperb.insertGuestGroupGuestMemberRegisteredUserVideo(guestGroupGuestMemberRegisteredUserVideo.getDownloadUrl(),
                    guestGroupGuestMemberRegisteredUserVideo.getGuestGroupId(),
                    guestGroupGuestMemberRegisteredUserVideo.getGuestMemberId(),
                    guestGroupGuestMemberRegisteredUserVideo.getRegisteredUserId(),
                    guestGroupGuestMemberRegisteredUserVideo.getCreationTime());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GuestGroupGuestMemberRegisteredUserVideoMapper mapperb, GuestGroupGuestMemberRegisteredUserVideo guestGroupGuestMemberRegisteredUserVideo){
        int result = 0;
        try {
            result = mapperb.deleteGuestGroupGuestMemberRegisteredUserVideo(guestGroupGuestMemberRegisteredUserVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GuestGroupGuestMemberRegisteredUserVideo> selectRecord(SqlSession session, GuestGroupGuestMemberRegisteredUserVideoMapper mapperb, GuestGroupGuestMemberRegisteredUserVideo guestGroupGuestMemberRegisteredUserVideo) {
        List<GuestGroupGuestMemberRegisteredUserVideo> bList = null;
        try {
            bList = mapperb.selectGuestGroupGuestMemberRegisteredUserVideo(guestGroupGuestMemberRegisteredUserVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupGuestMemberRegisteredUserVideo> selectAllRecords(SqlSession session, GuestGroupGuestMemberRegisteredUserVideoMapper mapperb) {
        List<GuestGroupGuestMemberRegisteredUserVideo> bList = null;
        try {
            bList = mapperb.selectAllGuestGroupGuestMemberRegisteredUserVideo();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
