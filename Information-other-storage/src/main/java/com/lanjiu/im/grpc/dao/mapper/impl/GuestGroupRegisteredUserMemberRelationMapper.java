package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.GuestGroupRegisteredUserMemberRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuestGroupRegisteredUserMemberRelationMapper {
    public List<GuestGroupRegisteredUserMemberRelation> selectAllGuestGroupRegisteredUserMemberRelation() throws Exception;

    public List<GuestGroupRegisteredUserMemberRelation> selectAllGuestGroupRegisteredUserMemberRelationByGroupIdAndMemberId(
            @Param("guestGroupId") int guestGroupId,
            @Param("registeredUserMemberId") int registeredUserMemberId
    ) throws Exception;

    public List<GuestGroupRegisteredUserMemberRelation> selectGuestGroupRegisteredUserMemberRelationByGuestGroupId(@Param("guestGroupId") int guestGroupId) throws Exception;

    public List<GuestGroupRegisteredUserMemberRelation> selectGuestGroupRegisteredUserMemberRelationByRegisteredUserMemberId(@Param("registeredUserMemberId") int registeredUserMemberId) throws Exception;

    public int insertGuestGroupRegisteredUserMemberRelation(@Param("guestGroupId") int guestGroupId,
                                                            @Param("registeredUserMemberId") int registeredUserMemberId) throws Exception;

    public int deleteGuestGroupRegisteredUserMemberRelation(@Param("guestGroupId") int guestGroupId, @Param("registeredUserMemberId") int registeredUserMemberId) throws Exception;
}
