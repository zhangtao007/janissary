package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.RegisteredGroupRegisteredMemberRegisteredUserVideo;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface RegisteredGroupRegisteredMemberRegisteredUserVideoMapper {
    public List<RegisteredGroupRegisteredMemberRegisteredUserVideo> selectAllRegisteredGroupRegisteredMemberRegisteredUserVideo() throws Exception;
    public List<RegisteredGroupRegisteredMemberRegisteredUserVideo> selectRegisteredGroupRegisteredMemberRegisteredUserVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
    public int insertRegisteredGroupRegisteredMemberRegisteredUserVideo(@Param("downloadUrl") String downloadUrl, @Param("registeredGroupId") int registeredGroupId, @Param("registeredMemberId") int registeredMemberId,
                       @Param("registeredUserId") int registeredUserId, @Param("creationTime") Date creationTime) throws Exception;
    public int deleteRegisteredGroupRegisteredMemberRegisteredUserVideo(@Param("downloadUrl") String downloadUrl) throws Exception;
}
