package com.lanjiu.im.storage.dao.mapper.impl;


import com.lanjiu.im.storage.pojo.GuestGroupGuestMemberRegisteredUserPicture;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface GuestGroupGuestMemberRegisteredUserPictureMapper {
    public List<GuestGroupGuestMemberRegisteredUserPicture> selectAllGuestGroupGuestMemberRegisteredUserPicture() throws Exception;
    public List<GuestGroupGuestMemberRegisteredUserPicture> selectGuestGroupGuestMemberRegisteredUserPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
    public int insertGuestGroupGuestMemberRegisteredUserPicture(@Param("downloadUrl") String downloadUrl, @Param("guestGroupId") int guestGroupId, @Param("guestMemberId") int guestMemberId,
                       @Param("registeredUserId") int registeredUserId, @Param("creationTime") Date creationTime) throws Exception;
    public int deleteGuestGroupGuestMemberRegisteredUserPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
}
