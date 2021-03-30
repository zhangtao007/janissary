package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.GuestUserFriendPictureMapper;
import com.lanjiu.im.storage.pojo.GuestUserFriendPicture;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GuestUserFriendPictureService {

    public int insertRecord(SqlSession session, GuestUserFriendPictureMapper mapperb, GuestUserFriendPicture guestUserFriendPicture){
        int result = 0;
        try {
            result = mapperb.insertGuestUserFriendPicture(guestUserFriendPicture.getDownloadUrl(), guestUserFriendPicture.getGuestUserId(), guestUserFriendPicture.getCreationTime(), guestUserFriendPicture.getFriendId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GuestUserFriendPictureMapper mapperb, GuestUserFriendPicture guestUserFriendPicture){
        int result = 0;
        try {
            result = mapperb.deleteGuestUserFriendPicture(guestUserFriendPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GuestUserFriendPicture> selectRecord(SqlSession session, GuestUserFriendPictureMapper mapperb, GuestUserFriendPicture guestUserFriendPicture) {
        List<GuestUserFriendPicture> bList = null;
        try {
            bList = mapperb.selectGuestUserFriendPicture(guestUserFriendPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestUserFriendPicture> selectRecordByFriendId(SqlSession session, GuestUserFriendPictureMapper mapperb, GuestUserFriendPicture guestUserFriendPicture) {
        List<GuestUserFriendPicture> bList = null;
        try {
            bList = mapperb.selectGuestUserFriendPictureByFriendId(String.valueOf(guestUserFriendPicture.getGuestUserId()), String.valueOf(guestUserFriendPicture.getFriendId()));
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestUserFriendPicture> selectAllRecords(SqlSession session, GuestUserFriendPictureMapper mapperb) {
        List<GuestUserFriendPicture> bList = null;
        try {
            bList = mapperb.selectAllGuestUserFriendPicture();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    /**
     * 清理游客文件记录
     */
    public void cleanGuestFile(SqlSession session, GuestUserFriendPictureMapper mapperb, Integer userId){

        try {
            mapperb.cleanFriendPictureVideo(userId);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }


    public List<GuestUserFriendPicture> selectRecordByUserId(SqlSession session, GuestUserFriendPictureMapper mapperb, GuestUserFriendPicture guestUserFriendPicture) {
        List<GuestUserFriendPicture> bList = null;
        try {
            bList = mapperb.selectGuestUserFriendPictureByUserId(guestUserFriendPicture.getGuestUserId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestUserFriendPicture> selectRecordOnlyByFriendId(SqlSession session, GuestUserFriendPictureMapper mapperb, GuestUserFriendPicture guestUserFriendPicture) {
        List<GuestUserFriendPicture> bList = null;
        try {
            bList = mapperb.selectGuestUserFriendPictureOnlyByFriendId(guestUserFriendPicture.getFriendId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
