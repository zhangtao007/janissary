package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupGuestMemberGuestUserPictureMapper;
import com.lanjiu.im.storage.pojo.GuestGroupGuestMemberGuestUserPicture;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GuestGroupGuestMemberGuestUserPictureService {

    public int insertRecord(SqlSession session, GuestGroupGuestMemberGuestUserPictureMapper mapperb, GuestGroupGuestMemberGuestUserPicture guestGroupGuestMemberGuestUserPicture){
        int result = 0;
        try {
            result = mapperb.insertGuestGroupGuestMemberGuestUserPicture(guestGroupGuestMemberGuestUserPicture.getDownloadUrl(),
                    guestGroupGuestMemberGuestUserPicture.getGuestGroupId(),
                    guestGroupGuestMemberGuestUserPicture.getGuestMemberId(),
                    guestGroupGuestMemberGuestUserPicture.getGuestUserId(),
                    guestGroupGuestMemberGuestUserPicture.getCreationTime());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GuestGroupGuestMemberGuestUserPictureMapper mapperb, GuestGroupGuestMemberGuestUserPicture guestGroupGuestMemberGuestUserPicture){
        int result = 0;
        try {
            result = mapperb.deleteGuestGroupGuestMemberGuestUserPicture(guestGroupGuestMemberGuestUserPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GuestGroupGuestMemberGuestUserPicture> selectRecord(SqlSession session, GuestGroupGuestMemberGuestUserPictureMapper mapperb, GuestGroupGuestMemberGuestUserPicture guestGroupGuestMemberGuestUserPicture) {
        List<GuestGroupGuestMemberGuestUserPicture> bList = null;
        try {
            bList = mapperb.selectGuestGroupGuestMemberGuestUserPicture(guestGroupGuestMemberGuestUserPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupGuestMemberGuestUserPicture> selectAllRecords(SqlSession session, GuestGroupGuestMemberGuestUserPictureMapper mapperb) {
        List<GuestGroupGuestMemberGuestUserPicture> bList = null;
        try {
            bList = mapperb.selectAllGuestGroupGuestMemberGuestUserPicture();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
