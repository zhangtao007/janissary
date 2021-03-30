package com.lanjiu.im.grpc.server.controller.update;

import com.lanjiu.im.grpc.RpcRegisteredGroup;
import com.lanjiu.im.grpc.dao.mapper.impl.*;
import com.lanjiu.im.grpc.pojo.*;
import com.lanjiu.im.grpc.util.ConstantsDefault;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UpdateRegisteredGroupServiceAPI {

    private static final Logger logger = Logger.getLogger(UpdateRegisteredGroupServiceAPI.class.getName());

    public RegisteredGroup updateRegisteredGroup(RpcRegisteredGroup rpcRegisteredGroup){
        SqlSession session = DBTools.getSession();
        RegisteredGroupMapper registeredGroupMapper = session.getMapper(RegisteredGroupMapper.class);
        int groupId = rpcRegisteredGroup.getGroupId();
        int registeredUserId = rpcRegisteredGroup.getRegisteredUserId();
        logger.info("修改群名称服务群ID："+groupId + "---修改人：" + registeredUserId);
        if((0 == groupId)){
            logger.info(ConstantsDefault.GROUP_ID_UNDEFAULT_UPDATE);
            return null;
        }
        if((0 == registeredUserId)){
            logger.info(ConstantsDefault.GROUP_MEMBER_USER_ID_UNDEFAULT);
            return null;
        }
        String groupName = rpcRegisteredGroup.getGroupName();
        Timestamp modificationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        RegisteredGroup registeredGroup = new RegisteredGroup();
        try {
            RegisteredGroup group = registeredGroupMapper.getRegisteredGroupByGroupId(groupId);
            registeredGroupMapper.updateRegisteredGroup(groupId,group.getRegisteredUserId(),groupName,groupId,group.getCreationTime(),modificationTime,
                    group.getAmount(),group.getGroupPhotoUrl(),group.getGroupPhotoUserIdList());
            registeredGroup.setGroupId(groupId);
            registeredGroup.setGroupAnnouncementId(groupId);
            registeredGroup.setRegisteredUserId(registeredUserId);
            registeredGroup.setAmount(group.getAmount());
            registeredGroup.setCreationTime(group.getCreationTime());
            registeredGroup.setModificationTime(modificationTime);
            registeredGroup.setGroupName(groupName);
            session.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return registeredGroup;
    }
}
