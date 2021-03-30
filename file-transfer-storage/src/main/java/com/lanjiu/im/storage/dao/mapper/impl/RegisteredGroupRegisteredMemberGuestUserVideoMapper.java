package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.RegisteredGroupRegisteredMemberGuestUserVideo;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface RegisteredGroupRegisteredMemberGuestUserVideoMapper {
    public List<RegisteredGroupRegisteredMemberGuestUserVideo> selectAllRegisteredGroupRegisteredMemberGuestUserVideo() throws Exception;
    public List<RegisteredGroupRegisteredMemberGuestUserVideo> selectRegisteredGroupRegisteredMemberGuestUserVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
    public int insertRegisteredGroupRegisteredMemberGuestUserVideo(@Param("downloadUrl") String downloadUrl, @Param("registeredGroupId") int registeredGroupId, @Param("registeredMemberId") int registeredMemberId,
                       @Param("guestUserId") int guestUserId, @Param("creationTime") Date creationTime) throws Exception;
    public int deleteRegisteredGroupRegisteredMemberGuestUserVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
}
