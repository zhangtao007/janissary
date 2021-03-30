package com.lanjiu.im.storage.dao;

import com.lanjiu.im.storage.pojo.GroupAudioVideoCallEntity;
import com.lanjiu.im.storage.pojo.GroupMsgOffLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupMsgOffLineMapper {

    /** 插入数据 */
    void insert(GroupMsgOffLine entity);

    /** 根据主键ID获取单条数据 */
    GroupMsgOffLine selectByPrimaryKey(@Param("id") String id);

    /** 批量查询数据 */
    List<GroupMsgOffLine> selectByPrimaryKeys(@Param("ids") List<Integer> ids);

    /** 批量查询数据 */
    List<GroupMsgOffLine> selectByGroupIds(@Param("ids") List<Integer> ids);

    List<GroupMsgOffLine> selectByMsgId(@Param("msgId") String msgId);

    /** 根据主键ID全局更新 */
    int updateByPrimaryKey(GroupMsgOffLine msgGroupOff);

    void deleteByGroupIds(@Param("groupIds") List<String> groupIds);

    int deleteByFromId(@Param("fromId") String fromId);

    int deletePrimaryKeys(@Param("ids") List<Integer> ids);

    void insertBatch(@Param("list") List<GroupMsgOffLine> offLines);

    List<GroupMsgOffLine> selectByMsgIds(@Param("msgIds") List<String> msgIds);

    List<GroupMsgOffLine> selectByFromId(@Param("fromId") String fromId);

    int storageAudioVideoCallMsg(GroupAudioVideoCallEntity entity);

    List<GroupAudioVideoCallEntity> getAudioCallMsg(@Param("toUserId") String toUserId);

    void removeAudioVideoCallMsgByRoomId(@Param("groupId") String groupId);

    int updateAudioCallMsgJoin(GroupAudioVideoCallEntity entity);

    List<GroupAudioVideoCallEntity> selectMsgByRoomId(@Param("roomId") String roomId);
}
