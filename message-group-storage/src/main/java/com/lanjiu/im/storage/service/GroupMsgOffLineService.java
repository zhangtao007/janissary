package com.lanjiu.im.storage.service;

import com.google.protobuf.ProtocolStringList;
import com.lanjiu.im.storage.pojo.GroupMsgOffLine;

public interface GroupMsgOffLineService {

    /** 插入数据 */
    void insert(GroupMsgOffLine entity);

    /** 根据主键ID获取单条数据 */
    GroupMsgOffLine selectByPrimaryKey(String msgId);

    void deleteByGroupIds(ProtocolStringList groupIdList);
}
