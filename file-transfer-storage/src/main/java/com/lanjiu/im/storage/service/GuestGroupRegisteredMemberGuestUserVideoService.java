package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupRegisteredMemberGuestUserVideoMapper;
import com.lanjiu.im.storage.pojo.GuestGroupRegisteredMemberGuestUserVideo;
import com.lanjiu.im.storage.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GuestGroupRegisteredMemberGuestUserVideoService {

    public int insertRecord(SqlSession session, GuestGroupRegisteredMemberGuestUserVideoMapper mapperb, GuestGroupRegisteredMemberGuestUserVideo guestGroupRegisteredMemberGuestUserVideo){
        int result = 0;
        try {
            result = mapperb.insertGuestGroupRegisteredMemberGuestUserVideo(guestGroupRegisteredMemberGuestUserVideo.getDownloadUrl(),
                    guestGroupRegisteredMemberGuestUserVideo.getGuestGroupId(),
                    guestGroupRegisteredMemberGuestUserVideo.getRegisteredMemberId(),
                    guestGroupRegisteredMemberGuestUserVideo.getGuestUserId(),
                    guestGroupRegisteredMemberGuestUserVideo.getCreationTime());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GuestGroupRegisteredMemberGuestUserVideoMapper mapperb, GuestGroupRegisteredMemberGuestUserVideo guestGroupRegisteredMemberGuestUserVideo){
        int result = 0;
        try {
            result = mapperb.deleteGuestGroupRegisteredMemberGuestUserVideo(guestGroupRegisteredMemberGuestUserVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GuestGroupRegisteredMemberGuestUserVideo> selectRecord(SqlSession session, GuestGroupRegisteredMemberGuestUserVideoMapper mapperb, GuestGroupRegisteredMemberGuestUserVideo guestGroupRegisteredMemberGuestUserVideo) {
        List<GuestGroupRegisteredMemberGuestUserVideo> bList = null;
        try {
            bList = mapperb.selectGuestGroupRegisteredMemberGuestUserVideo(guestGroupRegisteredMemberGuestUserVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupRegisteredMemberGuestUserVideo> selectAllRecords(SqlSession session, GuestGroupRegisteredMemberGuestUserVideoMapper mapperb) {
        List<GuestGroupRegisteredMemberGuestUserVideo> bList = null;
        try {
            bList = mapperb.selectAllGuestGroupRegisteredMemberGuestUserVideo();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
