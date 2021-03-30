package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.GuestGroupGuestMemberGuestUserFile;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface GuestGroupGuestMemberGuestUserFileMapper {
    public List<GuestGroupGuestMemberGuestUserFile> selectAllGuestGroupGuestMemberGuestUserFile();
    public List<GuestGroupGuestMemberGuestUserFile> selectGuestGroupGuestMemberGuestUserFile(@Param("downloadUrl") String downloadUrl);
    public int insertGuestGroupGuestMemberGuestUserFile(@Param("downloadUrl") String downloadUrl, @Param("guestGroupId") int guestGroupId, @Param("guestMemberId") int guestMemberId,
                       @Param("guestUserId") int guestUserId, @Param("creationTime") Date creationTime);
    public int deleteGuestGroupGuestMemberGuestUserFile(@Param("downloadUrl") String downloadUrl);
}
