package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.GuestGroupRegisteredMemberRegisteredUserPicture;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface GuestGroupRegisteredMemberRegisteredUserPictureMapper {
    public List<GuestGroupRegisteredMemberRegisteredUserPicture> selectAllGuestGroupRegisteredMemberRegisteredUserPicture() throws Exception;
    public List<GuestGroupRegisteredMemberRegisteredUserPicture> selectGuestGroupRegisteredMemberRegisteredUserPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
    public int insertGuestGroupRegisteredMemberRegisteredUserPicture(@Param("downloadUrl") String downloadUrl, @Param("guestGroupId") int guestGroupId, @Param("registeredMemberId") int registeredMemberId,
                       @Param("registeredUserId") int registeredUserId, @Param("creationTime") Date creationTime) throws Exception;
    public int deleteGuestGroupRegisteredMemberRegisteredUserPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
}
