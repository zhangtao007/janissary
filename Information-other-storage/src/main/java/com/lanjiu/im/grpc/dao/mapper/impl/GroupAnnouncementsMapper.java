package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.GroupAnnouncements;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupAnnouncementsMapper {
    List<GroupAnnouncements> selectAllGroupAnnouncements() throws Exception;
    List<GroupAnnouncements> selectGroupAnnouncementsByGroupAnnouncementId(@Param("groupAnnouncementId") int groupAnnouncementId) throws Exception;
    int insertGroupAnnouncements(@Param("groupAnnouncementId") int groupAnnouncementId, @Param("announcementTitle") String announcementTitle, @Param("announcementContent") String announcementContent) throws Exception;
    int updateGroupAnnouncements(@Param("groupAnnouncementId") int groupAnnouncementId, @Param("announcementTitle") String announcementTitle, @Param("announcementContent") String announcementContent) throws Exception;
    int deleteGroupAnnouncements(@Param("groupAnnouncementId") int groupAnnouncementId) throws Exception;
}
