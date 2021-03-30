package com.lanjiu.im.storage.dao.mapper.impl;


import com.lanjiu.im.storage.pojo.GuestGroupRegisteredMemberGuestUserVideo;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface GuestGroupRegisteredMemberGuestUserVideoMapper {
    public List<GuestGroupRegisteredMemberGuestUserVideo> selectAllGuestGroupRegisteredMemberGuestUserVideo() throws Exception;
    public List<GuestGroupRegisteredMemberGuestUserVideo> selectGuestGroupRegisteredMemberGuestUserVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
    public int insertGuestGroupRegisteredMemberGuestUserVideo(@Param("downloadUrl") String downloadUrl, @Param("guestGroupId") int guestGroupId, @Param("registeredMemberId") int registeredMemberId,
                       @Param("guestUserId") int guestUserId, @Param("creationTime") Date creationTime) throws Exception;
    public int deleteGuestGroupRegisteredMemberGuestUserVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
}
