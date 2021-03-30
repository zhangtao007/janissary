package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.RegisteredGroupGuestUserMemberRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegisteredGroupGuestUserMemberRelationMapper {
    public List<RegisteredGroupGuestUserMemberRelation> selectAllRegisteredGroupGuestUserMemberRelation() throws Exception;
    public List<RegisteredGroupGuestUserMemberRelation> selectAllRegisteredGroupGuestUserMemberRelationByGroupIdAndMemberId(
            @Param("registeredGroupId") int registeredGroupId,
            @Param("guestUserMemberId") int guestUserMemberId
    ) throws Exception;
    public List<RegisteredGroupGuestUserMemberRelation> selectRegisteredGroupGuestUserMemberRelationByRegisteredGroupId(@Param("registeredGroupId") int registeredGroupId) throws Exception;
    public List<RegisteredGroupGuestUserMemberRelation> selectRegisteredGroupGuestUserMemberRelationByGuestUserMemberId(@Param("guestUserMemberId") int guestUserMemberId) throws Exception;
    public int insertRegisteredGroupGuestUserMemberRelation(@Param("registeredGroupId") int registeredGroupId,
                                                                 @Param("guestUserMemberId") int guestUserMemberId) throws Exception;
    public int deleteRegisteredGroupGuestUserMemberRelation(@Param("registeredGroupId") int registeredGroupId, @Param("guestUserMemberId") int guestUserMemberId) throws Exception;
}
