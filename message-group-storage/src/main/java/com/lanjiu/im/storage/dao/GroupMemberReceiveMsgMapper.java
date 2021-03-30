package com.lanjiu.im.storage.dao;

import com.lanjiu.im.storage.pojo.GroupAudioVideoCallIndex;
import com.lanjiu.im.storage.pojo.GroupMemberReceiveMsg;
import com.lanjiu.im.storage.pojo.entity.GroupMemberReceiveMsgOffLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupMemberReceiveMsgMapper {

    /** 插入数据 */
    void insert(GroupMemberReceiveMsg entity);

    /** 物理删除数据 */
    int deleteByPrimaryKey(@Param("id") Integer id);

    /** 删除数据 */
    int deleteByToId(@Param("toId") String toId);

    /** 根据主键ID全局更新 */
    int updateByPrimaryKey(GroupMemberReceiveMsg record);

    /** 根据主键ID获取单条数据 */
    GroupMemberReceiveMsg selectByPrimaryKey(Integer id);

    /** 查询数据列表 */
    List<GroupMemberReceiveMsg> selectByToId(@Param("toId") String toId);

    /** 查询数据列表 */
    List<GroupMemberReceiveMsgOffLine> selectPageData(@Param("toId") String toId, @Param("start") int start, @Param("length") int length);

    int selectCountByToId(@Param("toId") String toId);

    List<GroupMemberReceiveMsg> selectByGroupIds(@Param("groupIds") List<String> groupIds);

    void insertBatch(@Param("list") List<GroupMemberReceiveMsg> receiveMsgs);

    void deleteByGroupIds(@Param("groupIds") List<String> groupIds);

    int deleteByOffLineMsgIds(@Param("msgIds") List<Integer> msgIds);

    List<Integer> selectByOffLineIds(@Param("list") List<Integer> collect);

    List<GroupMemberReceiveMsgOffLine> selectRelationData(@Param("toId") String userId);

    List<Integer> selectGroupLineMsgByToId(@Param("groupId") String groupId, @Param("toId") String userId);

    void deleteGroupLineMsgByToId(@Param("groupId") String groupId, @Param("toId") String toId);

    int insertAudioVideoCallIndex(GroupAudioVideoCallIndex index);

    int selectAudioCallCount(@Param("toUserId") String toUserId);

    int deleteAudioVideoCallOfUserIndex(@Param("delUser") String delUser, @Param("msgId") int msgId);

    void removeAudioVideoCallIndexByRoomId(@Param("groupId") String groupId);
}
