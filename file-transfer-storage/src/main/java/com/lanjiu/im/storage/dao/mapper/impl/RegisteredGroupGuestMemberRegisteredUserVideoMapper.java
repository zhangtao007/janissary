package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.RegisteredGroupGuestMemberRegisteredUserVideo;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface RegisteredGroupGuestMemberRegisteredUserVideoMapper {
    public List<RegisteredGroupGuestMemberRegisteredUserVideo> selectAllRegisteredGroupGuestMemberRegisteredUserVideo() throws Exception;
    public List<RegisteredGroupGuestMemberRegisteredUserVideo> selectRegisteredGroupGuestMemberRegisteredUserVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
    public int insertRegisteredGroupGuestMemberRegisteredUserVideo(@Param("downloadUrl") String downloadUrl, @Param("registeredGroupId") int registeredGroupId, @Param("guestMemberId") int guestMemberId,
                       @Param("registeredUserId") int registeredUserId, @Param("creationTime") Date creationTime)throws Exception;
    public int deleteRegisteredGroupGuestMemberRegisteredUserVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
}
