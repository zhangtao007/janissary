package com.lanjiu.im.grpc.server.controller.update;

import com.lanjiu.im.grpc.RpcGroupAnnouncements;
import com.lanjiu.im.grpc.dao.mapper.impl.GroupAnnouncementsMapper;
import com.lanjiu.im.grpc.pojo.GroupAnnouncements;
import com.lanjiu.im.grpc.util.ConstantsDefault;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class UpdateGroupAnnouncementsServiceAPI {

    private static final Logger logger = Logger.getLogger(UpdateGroupAnnouncementsServiceAPI.class.getName());

    public GroupAnnouncements updateGroupAnnouncements(RpcGroupAnnouncements rpcGroupAnnouncements){
        SqlSession session = DBTools.getSession();
        GroupAnnouncementsMapper guestUserFriendMapper = session.getMapper(GroupAnnouncementsMapper.class);
        Integer groupAnnouncementId = rpcGroupAnnouncements.getGroupAnnouncementId();
        if((0 == groupAnnouncementId)){
            logger.info(ConstantsDefault.GROUP_ANNOUNCEMENTS_ID_UNDEFAULT);
            return null;
        }
        String announcementContent = rpcGroupAnnouncements.getAnnouncementContent();
        GroupAnnouncements groupAnnouncements = new GroupAnnouncements();
        groupAnnouncements.setGroupAnnouncementId(groupAnnouncementId);
        groupAnnouncements.setAnnouncementContent(announcementContent);
        try {
            guestUserFriendMapper.updateGroupAnnouncements(groupAnnouncements.getGroupAnnouncementId(),
                    ConstantsDefault.GROUP_ANNOUNCEMENTS_TITLE, groupAnnouncements.getAnnouncementContent());
            session.commit();
            return groupAnnouncements;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return null;
    }
}
