package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.GroupRemark;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupRemarkMapper {
    public List<GroupRemark> selectAllGroupRemark() throws Exception;
    public List<GroupRemark> selectGroupRemarkWithGroupWithGroupMember(@Param("groupId") int groupId, @Param("groupMemberId") int groupMemberId, @Param("groupMemberIdRemarked") int groupMemberIdRemarked) throws Exception;
    public int insertGroupRemark(@Param("groupId") int groupId,
                                 @Param("groupMemberId") int groupMemberId,
                                 @Param("groupMemberIdRemarked") int groupMemberIdRemarked,
                                 @Param("remark") String remark) throws Exception;
    public int updateGroupRemark(@Param("groupId") int groupId,
                                 @Param("groupMemberId") int groupMemberId,
                                 @Param("groupMemberIdRemarked") int groupMemberIdRemarked,
                                 @Param("remark") String remark) throws Exception;
    public int deleteGroupRemarkByGroupId(@Param("groupId") int groupId) throws Exception;
    public int deleteGroupRemarkByMemberRemarkedId(@Param("groupMemberIdRemarked") int groupMemberIdRemarked) throws Exception;
    public int deleteGroupRemarkByMemberId(@Param("groupMemberId") int groupMemberId) throws Exception;
    public int deleteGroupRemarkByGroupIdAndMemberId(@Param("groupId") int groupId, @Param("groupMemberId") int groupMemberId) throws Exception;
}
