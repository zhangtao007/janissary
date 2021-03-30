package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.RegisteredGroup;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface RegisteredGroupMapper {
    List<RegisteredGroup> selectAllRegisteredGroup() throws Exception;
    List<RegisteredGroup> selectRegisteredGroup(@Param("registeredUserId") int registeredUserId,
                                             @Param("groupId") int groupId,
                                             @Param("groupName") String groupName,
                                             @Param("groupAnnouncementId") int groupAnnouncementId,
                                             @Param("creationTime") Timestamp creationTime,
                                             @Param("modificationTime") Timestamp modificationTime,
                                             @Param("amount") int amount) throws Exception;

    List<RegisteredGroup> selectRegisteredGroupByRegisteredUserId(@Param("registeredUserId") int registeredUserId) throws Exception;
    List<RegisteredGroup> selectRegisteredGroupByGroupId(@Param("groupId") int groupId) throws Exception;
    List<RegisteredGroup> selectRegisteredGroupByGroupIdLike(@Param("groupId") int groupId) throws Exception;
    List<RegisteredGroup> selectRegisteredGroupByRegisteredUserIdAndGroupId(@Param("registeredUserId") int registeredUserId, @Param("groupId") int groupId) throws Exception;

    int insertRegisteredGroup(@Param("registeredUserId") int registeredUserId,
                              @Param("groupId") int groupId,
                              @Param("groupName") String groupName,
                              @Param("groupAnnouncementId") int groupAnnouncementId,
                              @Param("creationTime") Timestamp creationTime,
                              @Param("modificationTime") Timestamp modificationTime,
                              @Param("amount") int amount,
                              @Param("groupPhotoUrl") String groupPhotoUrl,
                              @Param("groupPhotoUserIdList") String groupPhotoUserIdList) throws Exception;

    int updateRegisteredGroup(@Param("groupId") int groupId,@Param("registeredUserId") int registeredUserId, @Param("groupName") String groupName,
                              @Param("groupAnnouncementId") int groupAnnouncementId, @Param("creationTime") Timestamp creationTime, @Param("modificationTime") Timestamp modificationTime,
                              @Param("amount") int amount,@Param("groupPhotoUrl") String groupPhotoUrl,@Param("groupPhotoUserIdList") String groupPhotoUserIdList) throws Exception;
    int deleteRegisteredGroupByGroupId(@Param("groupId") int groupId) throws Exception;
    int deleteRegisteredGroupByRegisteredUserId(@Param("registeredUserId") int registeredUserId) throws Exception;

    RegisteredGroup getRegisteredGroupByGroupId(@Param("groupId") int groupId) throws Exception;

    List<RegisteredGroup> queryRegGroupByGroupIds(List<String> list) throws Exception;
}
