package com.lanjiu.im.storage.dao.mapper.impl;


import com.lanjiu.im.storage.pojo.GuestGroupGuestMemberRegisteredUserVideo;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface GuestGroupGuestMemberRegisteredUserVideoMapper {
    public List<GuestGroupGuestMemberRegisteredUserVideo> selectAllGuestGroupGuestMemberRegisteredUserVideo() throws Exception;
    public List<GuestGroupGuestMemberRegisteredUserVideo> selectGuestGroupGuestMemberRegisteredUserVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
    public int insertGuestGroupGuestMemberRegisteredUserVideo(@Param("downloadUrl") String downloadUrl, @Param("guestGroupId") int guestGroupId, @Param("guestMemberId") int guestMemberId,
                       @Param("registeredUserId") int registeredUserId, @Param("creationTime") Date creationTime);
    public int deleteGuestGroupGuestMemberRegisteredUserVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
}
