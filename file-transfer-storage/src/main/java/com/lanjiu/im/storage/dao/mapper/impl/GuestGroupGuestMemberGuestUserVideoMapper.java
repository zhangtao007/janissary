package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.GuestGroupGuestMemberGuestUserVideo;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface GuestGroupGuestMemberGuestUserVideoMapper {
    public List<GuestGroupGuestMemberGuestUserVideo> selectAllGuestGroupGuestMemberGuestUserVideo() throws Exception;
    public List<GuestGroupGuestMemberGuestUserVideo> selectGuestGroupGuestMemberGuestUserVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
    public int insertGuestGroupGuestMemberGuestUserVideo(@Param("downloadUrl") String downloadUrl, @Param("guestGroupId") int guestGroupId, @Param("guestMemberId") int guestMemberId,
                       @Param("guestUserId") int guestUserId, @Param("creationTime") Date creationTime) throws Exception;
    public int deleteGuestGroupGuestMemberGuestUserVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
}
