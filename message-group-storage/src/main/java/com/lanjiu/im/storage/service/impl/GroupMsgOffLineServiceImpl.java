package com.lanjiu.im.storage.service.impl;

import com.google.protobuf.ProtocolStringList;
import com.lanjiu.im.storage.dao.GroupMsgOffLineMapper;
import com.lanjiu.im.storage.pojo.GroupMsgOffLine;
import com.lanjiu.im.storage.service.GroupMsgOffLineService;
import com.lanjiu.im.storage.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class GroupMsgOffLineServiceImpl implements GroupMsgOffLineService {

    private static final Logger logger = Logger.getLogger(GroupMsgOffLineServiceImpl.class.getName());

    private GroupMsgOffLineMapper msgGroupOffMapper;

    public GroupMsgOffLineServiceImpl() {
        SqlSession session = DBTools.getSession();
        this.msgGroupOffMapper = session.getMapper(GroupMsgOffLineMapper.class);
    }

    @Override
    public void insert(GroupMsgOffLine entity) {
        SqlSession session = DBTools.getSession();
        try {
            msgGroupOffMapper.insert(entity);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public GroupMsgOffLine selectByPrimaryKey(String msgId) {
        return msgGroupOffMapper.selectByPrimaryKey(msgId);
    }

    @Override
    public void deleteByGroupIds(ProtocolStringList groupIdList) {

    }
}
