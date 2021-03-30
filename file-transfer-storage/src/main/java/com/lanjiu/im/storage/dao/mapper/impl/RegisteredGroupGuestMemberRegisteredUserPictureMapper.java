package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.RegisteredGroupGuestMemberRegisteredUserPicture;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface RegisteredGroupGuestMemberRegisteredUserPictureMapper {
    public List<RegisteredGroupGuestMemberRegisteredUserPicture> selectAllRegisteredGroupGuestMemberRegisteredUserPicture() throws Exception;
    public List<RegisteredGroupGuestMemberRegisteredUserPicture> selectRegisteredGroupGuestMemberRegisteredUserPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
    public int insertRegisteredGroupGuestMemberRegisteredUserPicture(@Param("downloadUrl") String downloadUrl, @Param("registeredGroupId") int registeredGroupId, @Param("guestMemberId") int guestMemberId,
                       @Param("registeredUserId") int registeredUserId, @Param("creationTime") Date creationTime) throws Exception;
    public int deleteRegisteredGroupGuestMemberRegisteredUserPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
}
