package com.lanjiu.im.storage.dao.mapper.impl;


import com.lanjiu.im.storage.pojo.GuestGroupRegisteredMemberGuestUserPicture;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface GuestGroupRegisteredMemberGuestUserPictureMapper {
    public List<GuestGroupRegisteredMemberGuestUserPicture> selectAllGuestGroupRegisteredMemberGuestUserPicture() throws Exception;
    public List<GuestGroupRegisteredMemberGuestUserPicture> selectGuestGroupRegisteredMemberGuestUserPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
    public int insertGuestGroupRegisteredMemberGuestUserPicture(@Param("downloadUrl") String downloadUrl, @Param("guestGroupId") int guestGroupId, @Param("registeredMemberId") int registeredMemberId,
                       @Param("guestUserId") int guestUserId, @Param("creationTime") Date creationTime) throws Exception;
    public int deleteGuestGroupRegisteredMemberGuestUserPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
}
