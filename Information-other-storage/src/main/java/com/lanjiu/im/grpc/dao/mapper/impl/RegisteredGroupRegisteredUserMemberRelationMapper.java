package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.AllGroupMemberVO;
import com.lanjiu.im.grpc.pojo.RegisteredGroupRegisteredUserMemberRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegisteredGroupRegisteredUserMemberRelationMapper {
    List<RegisteredGroupRegisteredUserMemberRelation> selectAllRegisteredGroupRegisteredUserMemberRelation() throws Exception;

    List<RegisteredGroupRegisteredUserMemberRelation> selectAllRegisteredGroupRegisteredUserMemberRelationByGroupIdAndMemberId(
            @Param("registeredGroupId") int registeredGroupId,
            @Param("registeredUserMemberId") int registeredUserMemberId
    ) throws Exception;

    List<RegisteredGroupRegisteredUserMemberRelation> selectRegisteredGroupRegisteredUserMemberRelationByRegisteredGroupId(@Param("registeredGroupId") int registeredGroupId) throws Exception;

    List<RegisteredGroupRegisteredUserMemberRelation> selectRegisteredGroupRegisteredUserMemberRelationByRegisteredUserMemberId(@Param("registeredUserMemberId") int registeredUserMemberId) throws Exception;

    int insertRegisteredGroupRegisteredUserMemberRelation(@Param("registeredGroupId") int registeredGroupId,
                                                                 @Param("registeredUserMemberId") int registeredUserMemberId) throws Exception;

    int deleteRegisteredGroupRegisteredUserMemberRelation(@Param("registeredGroupId") int registeredGroupId, @Param("registeredUserMemberId") int registeredUserMemberId) throws Exception;

    AllGroupMemberVO getGroupAndMemberRelation(@Param("registeredUserId")int registeredUserId,@Param("registeredGroupId")int registeredGroupId ) throws Exception;

    int insertGroupMemberRelationOfBatch(List<RegisteredGroupRegisteredUserMemberRelation> memRelaList);
}
