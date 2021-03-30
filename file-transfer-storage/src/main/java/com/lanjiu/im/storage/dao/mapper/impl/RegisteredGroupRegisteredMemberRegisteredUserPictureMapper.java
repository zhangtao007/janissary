package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.RegisteredGroupRegisteredMemberRegisteredUserPicture;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface RegisteredGroupRegisteredMemberRegisteredUserPictureMapper {
    public List<RegisteredGroupRegisteredMemberRegisteredUserPicture> selectAllRegisteredGroupRegisteredMemberRegisteredUserPicture() throws Exception;
    public List<RegisteredGroupRegisteredMemberRegisteredUserPicture> selectRegisteredGroupRegisteredMemberRegisteredUserPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
    public int insertRegisteredGroupRegisteredMemberRegisteredUserPicture(@Param("downloadUrl") String downloadUrl, @Param("registeredGroupId") int registeredGroupId, @Param("registeredMemberId") int registeredMemberId,
                       @Param("registeredUserId") int registeredUserId, @Param("creationTime") Date creationTime) throws Exception;
    public int deleteRegisteredGroupRegisteredMemberRegisteredUserPicture(@Param("downloadUrl") String downloadUrl) throws Exception;
}
