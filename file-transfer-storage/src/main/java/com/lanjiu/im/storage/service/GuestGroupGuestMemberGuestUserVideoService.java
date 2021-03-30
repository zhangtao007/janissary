package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupGuestMemberGuestUserVideoMapper;
import com.lanjiu.im.storage.pojo.GuestGroupGuestMemberGuestUserVideo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.logging.Logger;

public class GuestGroupGuestMemberGuestUserVideoService {

    private static final Logger logger = Logger.getLogger(GuestGroupGuestMemberGuestUserVideoService.class.getName());

    public int insertRecord(SqlSession session, GuestGroupGuestMemberGuestUserVideoMapper mapperb, GuestGroupGuestMemberGuestUserVideo guestGroupGuestMemberGuestUserVideo){
        int result = 0;
        try {
            result = mapperb.insertGuestGroupGuestMemberGuestUserVideo(guestGroupGuestMemberGuestUserVideo.getDownloadUrl(),
                    guestGroupGuestMemberGuestUserVideo.getGuestGroupId(),
                    guestGroupGuestMemberGuestUserVideo.getGuestMemberId(),
                    guestGroupGuestMemberGuestUserVideo.getGuestUserId(),
                    guestGroupGuestMemberGuestUserVideo.getCreationTime());
            session.commit();
        } catch (Exception e) {
            logger.info("群成员上传文件记录到数据库错误："+e.getMessage());
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecord(SqlSession session, GuestGroupGuestMemberGuestUserVideoMapper mapperb, GuestGroupGuestMemberGuestUserVideo guestGroupGuestMemberGuestUserVideo){
        int result = 0;
        try {
            result = mapperb.deleteGuestGroupGuestMemberGuestUserVideo(guestGroupGuestMemberGuestUserVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            logger.info("删除群中文件记录数据库delete异常"+e.getMessage());
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<GuestGroupGuestMemberGuestUserVideo> selectRecord(SqlSession session, GuestGroupGuestMemberGuestUserVideoMapper mapperb, GuestGroupGuestMemberGuestUserVideo guestGroupGuestMemberGuestUserVideo) {
        List<GuestGroupGuestMemberGuestUserVideo> bList = null;
        try {
            bList = mapperb.selectGuestGroupGuestMemberGuestUserVideo(guestGroupGuestMemberGuestUserVideo.getDownloadUrl());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GuestGroupGuestMemberGuestUserVideo> selectAllRecords(SqlSession session, GuestGroupGuestMemberGuestUserVideoMapper mapperb) {
        List<GuestGroupGuestMemberGuestUserVideo> bList = null;
        try {
            bList = mapperb.selectAllGuestGroupGuestMemberGuestUserVideo();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
