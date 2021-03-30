package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.RegisteredGroupMapper;
import com.lanjiu.im.grpc.pojo.RegisteredGroup;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RegisteredGroupService {

    public int insertRecord(SqlSession session, RegisteredGroupMapper mapperb, RegisteredGroup registeredGroup){
        int result = 0;
        try {
            result = mapperb.insertRegisteredGroup(registeredGroup.getRegisteredUserId(), registeredGroup.getGroupId(),
                    registeredGroup.getGroupName(), registeredGroup.getGroupAnnouncementId(),
                    registeredGroup.getCreationTime(), registeredGroup.getModificationTime(),
                    registeredGroup.getAmount(),registeredGroup.getGroupPhotoUrl(),registeredGroup.getGroupPhotoUserIdList());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<RegisteredGroup> selectRegisteredGroup(SqlSession session, RegisteredGroupMapper mapperb, RegisteredGroup registeredGroup) {
        List<RegisteredGroup> bList = null;
        try {
            bList = mapperb.selectRegisteredGroup(registeredGroup.getRegisteredUserId(), registeredGroup.getGroupId(),
                    registeredGroup.getGroupName(), registeredGroup.getGroupAnnouncementId(),
                    registeredGroup.getCreationTime(), registeredGroup.getModificationTime(),
                    registeredGroup.getAmount());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroup> selectRegisteredGroupByGroupId(SqlSession session, RegisteredGroupMapper mapperb, RegisteredGroup registeredGroup) {
        List<RegisteredGroup> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupByGroupId(registeredGroup.getGroupId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroup> selectRegisteredGroupByGroupIdLike(SqlSession session, RegisteredGroupMapper mapperb, RegisteredGroup registeredGroup) {
        List<RegisteredGroup> bList = null;
        try {
            bList = mapperb.selectRegisteredGroupByGroupIdLike(registeredGroup.getGroupId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<RegisteredGroup> selectAllRecords(SqlSession session, RegisteredGroupMapper mapperb) {
        List<RegisteredGroup> bList = null;
        try {
            bList = mapperb.selectAllRegisteredGroup();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
