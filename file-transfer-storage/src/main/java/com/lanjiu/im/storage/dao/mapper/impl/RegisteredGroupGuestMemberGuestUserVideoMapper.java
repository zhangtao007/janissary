package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.RegisteredGroupGuestMemberGuestUserVideo;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface RegisteredGroupGuestMemberGuestUserVideoMapper {
    public List<RegisteredGroupGuestMemberGuestUserVideo> selectAllRegisteredGroupGuestMemberGuestUserVideo() throws Exception;
    public List<RegisteredGroupGuestMemberGuestUserVideo> selectRegisteredGroupGuestMemberGuestUserVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
    public int insertRegisteredGroupGuestMemberGuestUserVideo(@Param("downloadUrl") String downloadUrl, @Param("registeredGroupId") int registeredGroupId, @Param("guestMemberId") int guestMemberId,
                       @Param("guestUserId") int guestUserId, @Param("creationTime") Date creationTime) throws Exception;
    public int deleteRegisteredGroupGuestMemberGuestUserVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
}
