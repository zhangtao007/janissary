package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.RegisteredUserFriendVideo;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface RegisteredUserFriendVideoMapper {
    public List<RegisteredUserFriendVideo> selectAllRegisteredUserFriendVideo() throws Exception;
    public List<RegisteredUserFriendVideo> selectRegisteredUserFriendVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
    public List<RegisteredUserFriendVideo> selectRegisteredUserFriendVideoByFriendId(@Param("registeredUserId") String registeredUserId, @Param("friendId") String friendId) throws Exception;
    public int insertRegisteredUserFriendVideo(@Param("downloadUrl") String downloadUrl, @Param("registeredUserId") int registeredUserId, @Param("creationTime") Date creationTime, @Param("friendId") int friendId) throws Exception;
    public int deleteRegisteredUserFriendVideo(@Param("downloadUrl") String downloadUrl) throws Exception;

    List<RegisteredUserFriendVideo> selectRegisteredUserFriendVideoOnlyByFriendId( @Param("friendId") Integer friendId);

    List<RegisteredUserFriendVideo> selectRegisteredUserFriendVideoByUserId(@Param("registeredUserId")Integer registeredUserId);

    List<RegisteredUserFriendVideo> selectVidByDay(@Param("day") Date day);

    void deleteVidByDay(@Param("sqlDate")Date sqlDate);
}
