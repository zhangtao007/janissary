package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.GuestGroupGuestUserMemberRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuestGroupGuestUserMemberRelationMapper {
    public List<GuestGroupGuestUserMemberRelation> selectAllGuestGroupGuestUserMemberRelation() throws Exception;

    public List<GuestGroupGuestUserMemberRelation> selectAllGuestGroupGuestUserMemberRelationByGroupIdAndMemberId(
            @Param("guestGroupId") int guestGroupId, @Param("guestUserMemberId") int guestUserMemberId) throws Exception;

    public List<GuestGroupGuestUserMemberRelation> selectGuestGroupGuestUserMemberRelationByGuestGroupId(@Param("guestGroupId") int guestGroupId) throws Exception;

    public List<GuestGroupGuestUserMemberRelation> selectGuestGroupGuestUserMemberRelationByGuestUserMemberId(@Param("guestUserMemberId") int guestUserMemberId) throws Exception;

    public int insertGuestGroupGuestUserMemberRelation(@Param("guestGroupId") int guestGroupId,
                                                       @Param("guestUserMemberId") int guestUserMemberId) throws Exception;

    public int deleteGuestGroupGuestUserMemberRelation(@Param("guestGroupId") int guestGroupId, @Param("guestUserMemberId") int guestUserMemberId) throws Exception;

    int deleteGuestGroupUserMemberRelationByGuestUserMemberId(@Param("guestUserMemberId") int guestUserMemberId)throws Exception;
}
