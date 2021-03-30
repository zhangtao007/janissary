package com.lanjiu.im.storage.dao;

import com.lanjiu.im.storage.pojo.DelFriendOffMsg;
import com.lanjiu.im.storage.pojo.MsgFriendOffPO;
import com.lanjiu.im.storage.pojo.TimeClearMsgPO;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface MsgFriendOffMapper {


    //存储好友离线消息
    int insertMsgFriendOff(MsgFriendOffPO po);
    //删除好友离线消息
    int deleteMsgFriendOffByFromId(@Param("fromId") int fromId);
    //游客退出时删除好友离线消息
    int deleteGuestOffMsgByFromidToid(@Param("fromId") int fromId,@Param("toId") int toId);


    int deleteMsgFriendOff(String  msgId);
    int deleteMsgFriendOffByToId(@Param("toId")int toId);
    List<MsgFriendOffPO> selectMsgFriendOffByToId(@Param("toId") int toId);



    //存储删除指定离线消息指令
    int insertDelFriendMsgOff(DelFriendOffMsg delFriendOffMsg);
    //获取删除指定离线消息指令
    List<DelFriendOffMsg> selectDelFriendMsgOff(@Param("deltoId")int deltoId);
    //删除相关删除指令
    int deleteDelFriendMsgOff(@Param("toId")int toId);
    //游客退出时删除好友离线指令
    int deleteDelGuestOffMsgByFromidToid(@Param("delFromId") int delFromId,@Param("deltoId")int deltoId);



    List<TimeClearMsgPO> selectTimeClearLastMsg(@Param("clsToId")int clsToId);

    int deleteTimeClearMsg(@Param("clsToId")int clsToId);

    int insertTimeClearMsg(TimeClearMsgPO po);

    int updateTimeClearMsg(TimeClearMsgPO po);

    TimeClearMsgPO getOneTimeClearLastMsg(@Param("fromId") int fromId, @Param("toId") int toId);
}
