package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.RegisteredGroupGuestMemberGuestUserFile;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface RegisteredGroupGuestMemberGuestUserFileMapper {
    public List<RegisteredGroupGuestMemberGuestUserFile> selectAllRegisteredGroupGuestMemberGuestUserFile() throws Exception;
    public List<RegisteredGroupGuestMemberGuestUserFile> selectRegisteredGroupGuestMemberGuestUserFile(@Param("downloadUrl") String downloadUrl) throws Exception;
    public int insertRegisteredGroupGuestMemberGuestUserFile(@Param("downloadUrl") String downloadUrl, @Param("registeredGroupId") int registeredGroupId, @Param("guestMemberId") int guestMemberId,
                       @Param("guestUserId") int guestUserId, @Param("creationTime") Date creationTime) throws Exception;
    public int deleteRegisteredGroupGuestMemberGuestUserFile(@Param("downloadUrl") String downloadUrl) throws Exception;
}
