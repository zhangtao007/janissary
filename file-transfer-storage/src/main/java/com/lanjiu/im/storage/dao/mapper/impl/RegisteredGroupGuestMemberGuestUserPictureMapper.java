package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.RegisteredGroupGuestMemberGuestUserPicture;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface RegisteredGroupGuestMemberGuestUserPictureMapper {
    public List<RegisteredGroupGuestMemberGuestUserPicture> selectAllRegisteredGroupGuestMemberGuestUserPicture() throws Exception;
    public List<RegisteredGroupGuestMemberGuestUserPicture> selectRegisteredGroupGuestMemberGuestUserPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
    public int insertRegisteredGroupGuestMemberGuestUserPicture(@Param("downloadUrl") String downloadUrl, @Param("registeredGroupId") int registeredGroupId, @Param("guestMemberId") int guestMemberId,
                       @Param("guestUserId") int guestUserId, @Param("creationTime") Date creationTime) throws Exception;
    public int deleteRegisteredGroupGuestMemberGuestUserPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
}
