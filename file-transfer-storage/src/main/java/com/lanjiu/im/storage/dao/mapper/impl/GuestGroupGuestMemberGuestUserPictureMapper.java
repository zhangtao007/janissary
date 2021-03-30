package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.GuestGroupGuestMemberGuestUserPicture;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface GuestGroupGuestMemberGuestUserPictureMapper {
    public List<GuestGroupGuestMemberGuestUserPicture> selectAllGuestGroupGuestMemberGuestUserPicture() throws Exception;
    public List<GuestGroupGuestMemberGuestUserPicture> selectGuestGroupGuestMemberGuestUserPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
    public int insertGuestGroupGuestMemberGuestUserPicture(@Param("downloadUrl") String downloadUrl, @Param("guestGroupId") int guestGroupId, @Param("guestMemberId") int guestMemberId,
                       @Param("guestUserId") int guestUserId, @Param("creationTime") Date creationTime) throws Exception;
    public int deleteGuestGroupGuestMemberGuestUserPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
}
