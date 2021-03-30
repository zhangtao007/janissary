package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupRegisteredMemberRegisteredUserPictureMapper;
import com.lanjiu.im.storage.pojo.GuestGroupRegisteredMemberRegisteredUserPicture;
import com.lanjiu.im.storage.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GuestGroupRegisteredMemberRegisteredUserPictureService {

    public int insertRecord(SqlSession session, GuestGroupRegisteredMemberRegisteredUserPictureMapper mapperb, GuestGroupRegisteredMemberRegisteredUserPicture guestGroupRegisteredMemberRegisteredUserPicture){
        int result = 0;
        try {
            result = mapperb.insertGuestGroupRegisteredMemberRegisteredUserPicture(guestGroupRegisteredMemberRegisteredUserPicture.getDownloadUrl(),
                    guestGroupRegisteredMemberRegisteredUserPicture.getGuestGroupId(),
                    guestGroupRegisteredMemberRegisteredUserPicture.getRegisteredMemberId(),
                    guestGroupRegisteredMemberRegisteredUserPicture.getRegisteredUserId(),
                    guestGroupRegisteredMemberRegisteredUserPicture.getCreationTime());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GuestGroupRegisteredMemberRegisteredUserPictureMapper mapperb, GuestGroupRegisteredMemberRegisteredUserPicture guestGroupRegisteredMemberRegisteredUserPicture){
        int result = 0;
        try {
            result = mapperb.deleteGuestGroupRegisteredMemberRegisteredUserPicture(guestGroupRegisteredMemberRegisteredUserPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GuestGroupRegisteredMemberRegisteredUserPicture> selectRecord(SqlSession session, GuestGroupRegisteredMemberRegisteredUserPictureMapper mapperb, GuestGroupRegisteredMemberRegisteredUserPicture guestGroupRegisteredMemberRegisteredUserPicture) {
        List<GuestGroupRegisteredMemberRegisteredUserPicture> bList = null;
        try {
            bList = mapperb.selectGuestGroupRegisteredMemberRegisteredUserPicture(guestGroupRegisteredMemberRegisteredUserPicture.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupRegisteredMemberRegisteredUserPicture> selectAllRecords(SqlSession session, GuestGroupRegisteredMemberRegisteredUserPictureMapper mapperb) {
        List<GuestGroupRegisteredMemberRegisteredUserPicture> bList = null;
        try {
            bList = mapperb.selectAllGuestGroupRegisteredMemberRegisteredUserPicture();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
