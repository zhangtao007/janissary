package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.GuestUserFriendVideo;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface GuestUserFriendVideoMapper {
    public List<GuestUserFriendVideo> selectAllGuestUserFriendVideo() throws Exception;
    public List<GuestUserFriendVideo> selectGuestUserFriendVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
    public List<GuestUserFriendVideo> selectGuestUserFriendVideoByFriendId(@Param("guestUserId") String guestUserId, @Param("friendId") String friendId) throws Exception;
    public int insertGuestUserFriendVideo(@Param("downloadUrl") String downloadUrl, @Param("guestUserId") int guestUserId, @Param("creationTime") Date creationTime, @Param("friendId") int friendId) throws Exception;
    public int deleteGuestUserFriendVideo(@Param("downloadUrl") String downloadUrl) throws Exception;

    List<GuestUserFriendVideo> selectGuestUserFriendVideoByUserId(@Param("guestUserId") Integer guestUserId);

    List<GuestUserFriendVideo> selectGuestUserFriendVideooOnlyByFriendId(@Param("friendId")Integer friendId);
}
