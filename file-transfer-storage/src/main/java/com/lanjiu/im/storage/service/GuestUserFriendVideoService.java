package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.GuestUserFriendVideoMapper;
import com.lanjiu.im.storage.pojo.GuestUserFriendVideo;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class GuestUserFriendVideoService {

    public int insertRecord(SqlSession session, GuestUserFriendVideoMapper mapperb, GuestUserFriendVideo guestUserFriendVideo){
        int result = 0;
        try {
            result = mapperb.insertGuestUserFriendVideo(guestUserFriendVideo.getDownloadUrl(), guestUserFriendVideo.getGuestUserId(), guestUserFriendVideo.getCreationTime(), guestUserFriendVideo.getFriendId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GuestUserFriendVideoMapper mapperb, GuestUserFriendVideo guestUserFriendVideo){
        int result = 0;
        try {
            result = mapperb.deleteGuestUserFriendVideo(guestUserFriendVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GuestUserFriendVideo> selectRecord(SqlSession session, GuestUserFriendVideoMapper mapperb, GuestUserFriendVideo guestUserFriendVideo) {
        List<GuestUserFriendVideo> bList = null;
        try {
            bList = mapperb.selectGuestUserFriendVideo(guestUserFriendVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestUserFriendVideo> selectRecordByFriendId(SqlSession session, GuestUserFriendVideoMapper mapperb, GuestUserFriendVideo guestUserFriendVideo) {
        List<GuestUserFriendVideo> bList = null;
        try {
            bList = mapperb.selectGuestUserFriendVideoByFriendId(String.valueOf(guestUserFriendVideo.getGuestUserId()), String.valueOf(guestUserFriendVideo.getFriendId()));
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestUserFriendVideo> selectAllRecords(SqlSession session, GuestUserFriendVideoMapper mapperb) {
        List<GuestUserFriendVideo> bList = null;
        try {
            bList = mapperb.selectAllGuestUserFriendVideo();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestUserFriendVideo> selectRecordByUserId(SqlSession session, GuestUserFriendVideoMapper mapperb, GuestUserFriendVideo guestUserFriendVideo) {
        List<GuestUserFriendVideo> bList = null;
        try {
            bList = mapperb.selectGuestUserFriendVideoByUserId(guestUserFriendVideo.getGuestUserId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestUserFriendVideo> selectRecordOnlyByFriendId(SqlSession session, GuestUserFriendVideoMapper mapperb, GuestUserFriendVideo guestUserFriendVideo) {
        List<GuestUserFriendVideo> bList = null;
        try {
            bList = mapperb.selectGuestUserFriendVideooOnlyByFriendId(guestUserFriendVideo.getFriendId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
