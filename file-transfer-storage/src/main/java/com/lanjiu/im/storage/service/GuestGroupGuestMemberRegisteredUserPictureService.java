package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupGuestMemberGuestUserPictureMapper;
import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupGuestMemberRegisteredUserPictureMapper;
import com.lanjiu.im.storage.pojo.GuestGroupGuestMemberGuestUserPicture;
import com.lanjiu.im.storage.pojo.GuestGroupGuestMemberRegisteredUserPicture;
import com.lanjiu.im.storage.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GuestGroupGuestMemberRegisteredUserPictureService {

    public int insertRecord(SqlSession session, GuestGroupGuestMemberRegisteredUserPictureMapper mapperb, GuestGroupGuestMemberRegisteredUserPicture guestGroupGuestMemberRegisteredUserPicture){
        int result = 0;
        try {
            result = mapperb.insertGuestGroupGuestMemberRegisteredUserPicture(guestGroupGuestMemberRegisteredUserPicture.getDownloadUrl(),
                    guestGroupGuestMemberRegisteredUserPicture.getGuestGroupId(),
                    guestGroupGuestMemberRegisteredUserPicture.getGuestMemberId(),
                    guestGroupGuestMemberRegisteredUserPicture.getRegisteredUserId(),
                    guestGroupGuestMemberRegisteredUserPicture.getCreationTime());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GuestGroupGuestMemberRegisteredUserPictureMapper mapperb, GuestGroupGuestMemberRegisteredUserPicture guestGroupGuestMemberRegisteredUserPicture){
        int result = 0;
        try {
            result = mapperb.deleteGuestGroupGuestMemberRegisteredUserPicture(guestGroupGuestMemberRegisteredUserPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GuestGroupGuestMemberRegisteredUserPicture> selectRecord(SqlSession session, GuestGroupGuestMemberRegisteredUserPictureMapper mapperb, GuestGroupGuestMemberRegisteredUserPicture guestGroupGuestMemberRegisteredUserPicture) {
        List<GuestGroupGuestMemberRegisteredUserPicture> bList = null;
        try {
            bList = mapperb.selectGuestGroupGuestMemberRegisteredUserPicture(guestGroupGuestMemberRegisteredUserPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupGuestMemberRegisteredUserPicture> selectAllRecords(SqlSession session, GuestGroupGuestMemberRegisteredUserPictureMapper mapperb) {
        List<GuestGroupGuestMemberRegisteredUserPicture> bList = null;
        try {
            bList = mapperb.selectAllGuestGroupGuestMemberRegisteredUserPicture();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
