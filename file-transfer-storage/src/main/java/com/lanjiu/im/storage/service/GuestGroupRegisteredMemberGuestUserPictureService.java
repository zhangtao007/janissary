package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupGuestMemberRegisteredUserVideoMapper;
import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupRegisteredMemberGuestUserPictureMapper;
import com.lanjiu.im.storage.pojo.GuestGroupGuestMemberRegisteredUserVideo;
import com.lanjiu.im.storage.pojo.GuestGroupRegisteredMemberGuestUserPicture;
import com.lanjiu.im.storage.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GuestGroupRegisteredMemberGuestUserPictureService {

    public int insertRecord(SqlSession session, GuestGroupRegisteredMemberGuestUserPictureMapper mapperb, GuestGroupRegisteredMemberGuestUserPicture guestGroupRegisteredMemberGuestUserPicture){
        int result = 0;
        try {
            result = mapperb.insertGuestGroupRegisteredMemberGuestUserPicture(guestGroupRegisteredMemberGuestUserPicture.getDownloadUrl(),
                    guestGroupRegisteredMemberGuestUserPicture.getGuestGroupId(),
                    guestGroupRegisteredMemberGuestUserPicture.getRegisteredMemberId(),
                    guestGroupRegisteredMemberGuestUserPicture.getGuestUserId(),
                    guestGroupRegisteredMemberGuestUserPicture.getCreationTime());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GuestGroupRegisteredMemberGuestUserPictureMapper mapperb, GuestGroupRegisteredMemberGuestUserPicture guestGroupRegisteredMemberGuestUserPicture){
        int result = 0;
        try {
            result = mapperb.deleteGuestGroupRegisteredMemberGuestUserPicture(guestGroupRegisteredMemberGuestUserPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GuestGroupRegisteredMemberGuestUserPicture> selectRecord(SqlSession session, GuestGroupRegisteredMemberGuestUserPictureMapper mapperb, GuestGroupRegisteredMemberGuestUserPicture guestGroupRegisteredMemberGuestUserPicture) {
        List<GuestGroupRegisteredMemberGuestUserPicture> bList = null;
        try {
            bList = mapperb.selectGuestGroupRegisteredMemberGuestUserPicture(guestGroupRegisteredMemberGuestUserPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupRegisteredMemberGuestUserPicture> selectAllRecords(SqlSession session, GuestGroupRegisteredMemberGuestUserPictureMapper mapperb) {
        List<GuestGroupRegisteredMemberGuestUserPicture> bList = null;
        try {
            bList = mapperb.selectAllGuestGroupRegisteredMemberGuestUserPicture();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
