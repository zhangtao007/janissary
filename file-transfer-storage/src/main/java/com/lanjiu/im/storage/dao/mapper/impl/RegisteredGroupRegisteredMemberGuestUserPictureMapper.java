package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.RegisteredGroupRegisteredMemberGuestUserPicture;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface RegisteredGroupRegisteredMemberGuestUserPictureMapper {
    public List<RegisteredGroupRegisteredMemberGuestUserPicture> selectAllRegisteredGroupRegisteredMemberGuestUserPicture() throws Exception;
    public List<RegisteredGroupRegisteredMemberGuestUserPicture> selectRegisteredGroupRegisteredMemberGuestUserPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
    public int insertRegisteredGroupRegisteredMemberGuestUserPicture(@Param("downloadUrl") String downloadUrl, @Param("registeredGroupId") int registeredGroupId, @Param("registeredMemberId") int registeredMemberId,
                       @Param("guestUserId") int guestUserId, @Param("creationTime") Date creationTime) throws Exception;
    public int deleteRegisteredGroupRegisteredMemberGuestUserPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
}
