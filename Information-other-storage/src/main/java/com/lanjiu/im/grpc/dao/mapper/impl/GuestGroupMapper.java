package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.GuestGroup;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface GuestGroupMapper {
    public List<GuestGroup> selectAllGuestGroup() throws Exception;
    public List<GuestGroup> selectGuestGroup(@Param("guestUserId") int guestUserId,
                                                       @Param("groupId") int groupId,
                                                       @Param("groupName") String groupName,
                                                       @Param("groupAnnouncementId") int groupAnnouncementId,
                                                       @Param("creationTime") Timestamp creationTime,
                                                       @Param("modificationTime") Timestamp modificationTime,
                                                       @Param("amount") int amount) throws Exception;

    public List<GuestGroup> selectGuestGroupByGuestUserId(@Param("guestUserId") int guestUserId) throws Exception;
    public List<GuestGroup> selectGuestGroupByGroupId(@Param("groupId") int groupId) throws Exception;
    public List<GuestGroup> selectGuestGroupByGroupIdLike(@Param("groupId") int groupId) throws Exception;
    public List<GuestGroup> selectGuestGroupByGuestUserIdAndGroupId(@Param("guestUserId") int guestUserId, @Param("groupId") int groupId) throws Exception;

    public int insertGuestGroup(@Param("guestUserId") int guestUserId,
                                @Param("groupId") int groupId,
                                @Param("groupName") String groupName,
                                @Param("groupAnnouncementId") int groupAnnouncementId,
                                @Param("creationTime") Timestamp creationTime,
                                @Param("modificationTime") Timestamp modificationTime,
                                @Param("amount") int amount) throws Exception;

    public int updateGuestGroup(@Param("guestUserId") int guestUserId,
                                @Param("groupId") int groupId,
                                @Param("groupName") String groupName,
                                @Param("groupAnnouncementId") int groupAnnouncementId,
                                @Param("creationTime") Timestamp creationTime,
                                @Param("modificationTime") Timestamp modificationTime,
                                @Param("amount") int amount) throws Exception;
    public int deleteGuestGroupByGroupId(@Param("groupId") int groupId) throws Exception;
    public int deleteGuestGroupByGuestUserId(@Param("guestUserId") int guestUserId) throws Exception;

    GuestGroup getGuestGroupByGroupId(@Param("groupId") int groupId) throws Exception;

}
