package com.lanjiu.im.grpc.server.controller.update;

import com.lanjiu.im.grpc.RpcGuestGroup;
import com.lanjiu.im.grpc.dao.mapper.impl.GuestGroupMapper;
import com.lanjiu.im.grpc.pojo.GuestGroup;
import com.lanjiu.im.grpc.util.ConstantsDefault;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class UpdateGuestGroupServiceAPI {

    private static final Logger logger = Logger.getLogger(UpdateGuestGroupServiceAPI.class.getName());

    public GuestGroup updateGuestGroup(RpcGuestGroup rpcGuestGroup){
        SqlSession session = DBTools.getSession();
        int groupId = rpcGuestGroup.getGroupId();
        if((0 == groupId)){
            logger.info(ConstantsDefault.GROUP_ID_UNDEFAULT_UPDATE);
            return null;
        }
        Integer guestUserId = rpcGuestGroup.getGuestUserId();
        if((0 == guestUserId)){
            logger.info(ConstantsDefault.GROUP_MEMBER_USER_ID_UNDEFAULT);
            return null;
        }
        String groupName = rpcGuestGroup.getGroupName();
        Timestamp modificationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));

        GuestGroup guestGroup = new GuestGroup();
        guestGroup.setGroupId(groupId);
        guestGroup.setGroupAnnouncementId(groupId);
        guestGroup.setGuestUserId(guestUserId);
        guestGroup.setModificationTime(modificationTime);
        guestGroup.setGroupName(groupName);

        GuestGroupMapper guestGroupMapper = session.getMapper(GuestGroupMapper.class);
        try {
            List<GuestGroup> guestGroups = guestGroupMapper.selectGuestGroupByGroupId(groupId);
            if(null != guestGroups && guestGroups.size()>0){
                guestGroupMapper.updateGuestGroup(guestGroup.getGuestUserId(), guestGroup.getGroupId(),
                        guestGroup.getGroupName(), groupId,
                        guestGroups.get(0).getCreationTime(), guestGroup.getModificationTime(),
                        guestGroups.get(0).getAmount());
                session.commit();
                return guestGroup;
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return null;
    }

}
