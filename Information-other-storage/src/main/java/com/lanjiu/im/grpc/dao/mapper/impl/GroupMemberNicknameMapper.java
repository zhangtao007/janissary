package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.GroupMemberNickname;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupMemberNicknameMapper {

    /** 插入数据 */
    int insert(GroupMemberNickname entity);

    /** 根据主键ID全局更新 */
    int updateByPrimaryKey(GroupMemberNickname entity);

    /** 根据主键ID获取单条数据 */
    GroupMemberNickname selectByPrimaryKey(@Param("id") String id);

    /** 根据用户ID获取单条数据 */
    GroupMemberNickname selectByUserId(@Param("userId") String userId);

    /** 批量查询数据 */
    List<GroupMemberNickname> selectByGroupId(@Param("groupId") Integer groupId);

    List<GroupMemberNickname> selectMemberNickname(@Param("groupId") Integer groupId, @Param("userId")Integer userId);

    GroupMemberNickname selectGroupMemberNickname(@Param("groupId")Integer groupId, @Param("userId")Integer userId, @Param("muserId")Integer muserId);

    void deleteByGroupId(@Param("groupId") Integer groupId);

    void deleteMemberNickname(@Param("groupId")Integer groupId, @Param("userId")Integer userId);
}
