package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.GuestGroupRegisteredMemberRegisteredUserVideo;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface GuestGroupRegisteredMemberRegisteredUserVideoMapper {
    public List<GuestGroupRegisteredMemberRegisteredUserVideo> selectAllGuestGroupRegisteredMemberRegisteredUserVideo() throws Exception;
    public List<GuestGroupRegisteredMemberRegisteredUserVideo> selectGuestGroupRegisteredMemberRegisteredUserVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
    public int insertGuestGroupRegisteredMemberRegisteredUserVideo(@Param("downloadUrl") String downloadUrl, @Param("guestGroupId") int guestGroupId, @Param("registeredMemberId") int registeredMemberId,
                       @Param("registeredUserId") int registeredUserId, @Param("creationTime") Date creationTime) throws Exception;
    public int deleteGuestGroupRegisteredMemberRegisteredUserVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
}
