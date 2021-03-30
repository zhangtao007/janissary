package com.lanjiu.im.storage.dao;

import com.lanjiu.im.storage.pojo.MsgFriendOnPO;

import java.util.List;

public interface MsgFriendOnMapper {
    int insertMsgFriendOn(MsgFriendOnPO po);
    int deleteMsgFriendOn(String  msgId);
    int deleteMsgFriendOnByFromId(int fromId);
    int deleteMsgFriendOnByToId(int toId);
    List<MsgFriendOnPO> selectMsgFriendOnByMsgId(String msgId);
    List<MsgFriendOnPO> selectMsgFriendOnByFromId(int fromId);
    List<MsgFriendOnPO> selectMsgFriendOnByToId(int toId);
    List<MsgFriendOnPO> selectAllMsgFriendOn();

}
