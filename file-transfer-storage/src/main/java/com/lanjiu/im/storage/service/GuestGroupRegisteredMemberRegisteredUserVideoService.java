package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupRegisteredMemberRegisteredUserVideoMapper;
import com.lanjiu.im.storage.pojo.GuestGroupRegisteredMemberRegisteredUserVideo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GuestGroupRegisteredMemberRegisteredUserVideoService {

    public int insertRecord(SqlSession session, GuestGroupRegisteredMemberRegisteredUserVideoMapper mapperb, GuestGroupRegisteredMemberRegisteredUserVideo guestGroupRegisteredMemberRegisteredUserVideo){
        int result = 0;
        try {
            result = mapperb.insertGuestGroupRegisteredMemberRegisteredUserVideo(guestGroupRegisteredMemberRegisteredUserVideo.getDownloadUrl(),
                    guestGroupRegisteredMemberRegisteredUserVideo.getGuestGroupId(),
                    guestGroupRegisteredMemberRegisteredUserVideo.getRegisteredMemberId(),
                    guestGroupRegisteredMemberRegisteredUserVideo.getRegisteredUserId(),
                    guestGroupRegisteredMemberRegisteredUserVideo.getCreationTime());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GuestGroupRegisteredMemberRegisteredUserVideoMapper mapperb, GuestGroupRegisteredMemberRegisteredUserVideo guestGroupRegisteredMemberRegisteredUserVideo){
        int result = 0;
        try {
            result = mapperb.deleteGuestGroupRegisteredMemberRegisteredUserVideo(guestGroupRegisteredMemberRegisteredUserVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GuestGroupRegisteredMemberRegisteredUserVideo> selectRecord(SqlSession session, GuestGroupRegisteredMemberRegisteredUserVideoMapper mapperb, GuestGroupRegisteredMemberRegisteredUserVideo guestGroupRegisteredMemberRegisteredUserVideo) {
        List<GuestGroupRegisteredMemberRegisteredUserVideo> bList = null;
        try {
            bList = mapperb.selectGuestGroupRegisteredMemberRegisteredUserVideo(guestGroupRegisteredMemberRegisteredUserVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupRegisteredMemberRegisteredUserVideo> selectAllRecords(SqlSession session, GuestGroupRegisteredMemberRegisteredUserVideoMapper mapperb) {
        List<GuestGroupRegisteredMemberRegisteredUserVideo> bList = null;
        try {
            bList = mapperb.selectAllGuestGroupRegisteredMemberRegisteredUserVideo();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
