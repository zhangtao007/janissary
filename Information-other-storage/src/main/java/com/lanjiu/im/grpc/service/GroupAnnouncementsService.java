package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.GroupAnnouncementsMapper;
import com.lanjiu.im.grpc.pojo.GroupAnnouncements;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GroupAnnouncementsService {

    public List<GroupAnnouncements> selectAllRecords(SqlSession session, GroupAnnouncementsMapper mapperb) {
        List<GroupAnnouncements> bList = null;
        try {
            bList = mapperb.selectAllGroupAnnouncements();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<GroupAnnouncements> selectGroupAnnouncementsByGroupAnnouncementId(SqlSession session, GroupAnnouncementsMapper mapperb, GroupAnnouncements groupAnnouncements) {
        List<GroupAnnouncements> bList = null;
        try {
            bList = mapperb.selectGroupAnnouncementsByGroupAnnouncementId(groupAnnouncements.getGroupAnnouncementId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public int insertRecord(SqlSession session, GroupAnnouncementsMapper mapperb, GroupAnnouncements groupAnnouncements){
        int result = 0;
        try {
            result = mapperb.insertGroupAnnouncements(groupAnnouncements.getGroupAnnouncementId(), groupAnnouncements.getAnnouncementTitle(), groupAnnouncements.getAnnouncementContent());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int updateRecord(SqlSession session, GroupAnnouncementsMapper mapperb, GroupAnnouncements groupAnnouncements){
        int result = 0;
        try {
            result = mapperb.updateGroupAnnouncements(groupAnnouncements.getGroupAnnouncementId(), groupAnnouncements.getAnnouncementTitle(), groupAnnouncements.getAnnouncementContent());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecordByAnnouncementId(SqlSession session, GroupAnnouncementsMapper mapperb, GroupAnnouncements groupAnnouncements){
        int result = 0;
        try {
            result = mapperb.deleteGroupAnnouncements(groupAnnouncements.getGroupAnnouncementId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }
}
