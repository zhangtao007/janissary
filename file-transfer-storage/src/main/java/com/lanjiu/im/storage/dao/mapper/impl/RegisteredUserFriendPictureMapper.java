package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.RegisteredUserFriendPicture;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface RegisteredUserFriendPictureMapper {
    List<RegisteredUserFriendPicture> selectAllRegisteredUserFriendPicture() throws Exception;
    List<RegisteredUserFriendPicture> selectRegisteredUserFriendPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
    List<RegisteredUserFriendPicture> selectRegisteredUserFriendPictureByFriendId(@Param("registeredUserId") String registeredUserId, @Param("friendId") String friendId) throws Exception;
    int insertRegisteredUserFriendPicture(@Param("downloadUrl") String downloadUrl, @Param("registeredUserId") int registeredUserId, @Param("creationTime") Date creationTime, @Param("friendId") int friendId) throws Exception;
    int deleteRegisteredUserFriendPicture(@Param("downloadUrl") String downloadUrl) throws Exception;

    List<RegisteredUserFriendPicture> selectRegisteredUserFriendPictureOnlyByFriendId( @Param("friendId")Integer friendId);

    List<RegisteredUserFriendPicture> selectRegisteredUserFriendPictureByUserId(@Param("registeredUserId")Integer registeredUserId);

    void cleanFriendPictureVideo(@Param("userId") int userId);

    List<RegisteredUserFriendPicture> selectPicByDay(@Param("sqlDate") Date sqlDate);

    void deletePicByDay(@Param("sqlDate")Date sqlDate);
}
