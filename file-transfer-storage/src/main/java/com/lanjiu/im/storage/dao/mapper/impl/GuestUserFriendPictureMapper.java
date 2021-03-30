package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.GuestUserFriendPicture;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface GuestUserFriendPictureMapper {
    List<GuestUserFriendPicture> selectAllGuestUserFriendPicture() throws Exception;
    List<GuestUserFriendPicture> selectGuestUserFriendPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
    List<GuestUserFriendPicture> selectGuestUserFriendPictureByFriendId(@Param("guestUserId") String guestUserId, @Param("friendId") String friendId) throws Exception;
    int insertGuestUserFriendPicture(@Param("downloadUrl") String downloadUrl, @Param("guestUserId") int guestUserId, @Param("creationTime") Date creationTime, @Param("friendId") int friendId)throws Exception;
    int deleteGuestUserFriendPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
    void cleanFriendPictureVideo(@Param("userId")int userId);
    List<GuestUserFriendPicture> selectGuestUserFriendPictureByUserId( @Param("guestUserId") int guestUserId);

    List<GuestUserFriendPicture> selectGuestUserFriendPictureOnlyByFriendId( @Param("friendId")Integer friendId);
}
