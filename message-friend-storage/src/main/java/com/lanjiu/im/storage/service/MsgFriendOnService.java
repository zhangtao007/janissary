package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.MsgFriendOnMapper;
import com.lanjiu.im.storage.pojo.MsgFriendOnPO;
import com.lanjiu.im.storage.utils.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.logging.Logger;

public class MsgFriendOnService {

    public static final Logger logger = Logger.getLogger(MsgFriendOffService.class.getName());

    private SqlSession session;
    private MsgFriendOnMapper mapper;

    public MsgFriendOnService(){
        session = DBTools.getSession();
        mapper = session.getMapper(MsgFriendOnMapper.class);
    }

    public void close(){
        session.close();
    }
    public void commit(){session.commit();}
    public void rollback() {session.rollback();}

    public int storageMsgFriendOn(MsgFriendOnPO po){
        int i =0;
        try {
            i = mapper.insertMsgFriendOn(po);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.info("离线好友消息存储错误");
            session.rollback();
        }
        return  i;
    }

    public int deleteMsgFriendOn(String msgId){
        int i =0;
        try {
            i = mapper.deleteMsgFriendOn(msgId);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.info("离线好友消息删除错误");
            session.rollback();
        }
        return  i;
    }

    public int deleteMsgFriendOnByFromId(int fromId){
        int i =0;
        try {
            i = mapper.deleteMsgFriendOnByFromId(fromId);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.info("离线好友消息删除错误");
            session.rollback();
        }
        return  i;
    }

    public int deleteMsgFriendOnByToId(int toId){
        int i =0;
        try {
            i = mapper.deleteMsgFriendOnByToId(toId);
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.info("离线好友消息删除错误");
            session.rollback();
        }
        return  i;
    }

    public List<MsgFriendOnPO> selectAllMsgFriendOn(){
        List<MsgFriendOnPO> list = null;
        try {
             list = mapper.selectAllMsgFriendOn();
            session.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<MsgFriendOnPO> selectMsgFriendOnByMsgId(String id){
        List<MsgFriendOnPO> list = null;
        try {
            list = mapper.selectMsgFriendOnByMsgId(id);
            session.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<MsgFriendOnPO> selectMsgFriendOnByFromId(int fromId){
        List<MsgFriendOnPO> list = null;
        try {
            list = mapper.selectMsgFriendOnByFromId(fromId);
            session.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<MsgFriendOnPO> selectMsgFriendOnByToId(int toId){
        List<MsgFriendOnPO> list = null;
        try {
            list = mapper.selectMsgFriendOnByToId(toId);
            session.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
