package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.MsgFriendOffMapper;
import com.lanjiu.im.storage.pojo.DelFriendOffMsg;
import com.lanjiu.im.storage.pojo.MsgFriendOffPO;
import com.lanjiu.im.storage.pojo.TimeClearMsgPO;
import com.lanjiu.im.storage.utils.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MsgFriendOffService {

    public static final Logger logger = LoggerFactory.getLogger(MsgFriendOffService.class);

    private SqlSession session;
    private MsgFriendOffMapper mapper;

    public MsgFriendOffService(){
        session = DBTools.getSession();
        mapper = session.getMapper(MsgFriendOffMapper.class);
    }

    public void close(){
        session.close();
    }
    public void commit(){session.commit();}
    public void rollback() {session.rollback();}

    public int storageMsgFriendOff(MsgFriendOffPO po){
        int i =0;
        try {
//            logger.info("size:"+po.getContent().getBytes("utf-8").length/1024 +" ,fromId:"+po.getFromId());
            i = mapper.insertMsgFriendOff(po);
        } catch (Exception e) {
            logger.info("离线好友消息存储插入错误, fromId:"+po.getFromId()+",info:"+e.getMessage());
            session.rollback();
        }
        return  i;
    }

    public int deleteMsgFriendOff(String msgId){
        int i =0;
        try {
            i = mapper.deleteMsgFriendOff(msgId);
        } catch (Exception e) {
            logger.info("离线好友消息删除错误,msgId:{}",msgId);
            session.rollback();
        }
        return  i;
    }

    public int deleteMsgFriendOffByFromId(int fromId){
        int i =0;
        try {
            i = mapper.deleteMsgFriendOffByFromId(fromId);

        } catch (Exception e) {
            logger.info("离线好友消息删除错误,fromId",fromId);
            session.rollback();
        }
        return  i;
    }

    public int deleteMsgFriendOffByToId(int toId){
        int i =0;
        try {
            i = mapper.deleteMsgFriendOffByToId(toId);
        } catch (Exception e) {
            logger.info("离线好友消息删除错误,toId:{}",toId);
            e.printStackTrace();
            session.rollback();
        }
        return  i;
    }

    public int deleteGuestOffMsgByFromidToid(int fromId,int toId){
        int i =0;
        try {
            i = mapper.deleteGuestOffMsgByFromidToid(fromId,toId);
        } catch (Exception e) {
            logger.info("游客退出时离线好友消息删除错误,fromId:{} and toId:{}",fromId,toId);
            session.rollback();
        }
        return  i;
    }

    public List<MsgFriendOffPO> selectMsgFriendOffByToId(int toId){
        List<MsgFriendOffPO> list = new ArrayList<>();
        try {
            list = mapper.selectMsgFriendOffByToId(toId);

        } catch (Exception e) {
            logger.info("查询离线的好友消息错误,toId:{}",toId);
            session.close();
            return list;
        }
        return list;
    }

    public int insertDelFriendMsgOff(DelFriendOffMsg delFriendOffMsg){
        int i=0;
        try {
            i = mapper.insertDelFriendMsgOff(delFriendOffMsg);
        } catch (Exception e) {
            logger.info("离线好友删除指令消息存储插入错误, delfromId:"+delFriendOffMsg.getDelFromId()+",info:"+e.getMessage());
        }
        return  i;

    }

    public  List<DelFriendOffMsg> getDelFriendMsgOff(int toId){
        List<DelFriendOffMsg> list = new ArrayList<>();
        try {
            list = mapper.selectDelFriendMsgOff(toId);
        } catch (Exception e) {
            logger.error("捞取删除指令类消息错误,"+e.getMessage());
            session.close();
            return list;
        }
        return  list;
    }

    public int deleteDelFriendMsgOff(int toId){
        int i=0;
        try {
            i = mapper.deleteDelFriendMsgOff(toId);
        } catch (Exception e) {
            logger.error("删除删除指令类消息错误, "+e.getMessage());
        }
        return  i;
    }

    public int deleteDelGuestOffMsgByFromidToid(int fromId,int toId){
        int i=0;
        try {
            i = mapper.deleteDelGuestOffMsgByFromidToid(fromId,toId);
        } catch (Exception e) {
            logger.error("删除删除指令类消息错误，"+e.getMessage());
        }
        return  i;
    }

    public List<TimeClearMsgPO> getTimeClearLastMsg(int toId) {
        List<TimeClearMsgPO> tcmlist =new ArrayList<>();
        try {
            tcmlist = mapper.selectTimeClearLastMsg( toId);
        } catch (Exception e) {
            logger.error("捞取定期清理类消息错误,"+e.getMessage());
            session.close();
            return tcmlist;
        }
        return  tcmlist;
    }

    public void deleteTimeClearMsg( int toId) {
        int num=0;
        try {
           num= mapper.deleteTimeClearMsg(toId);
        } catch (Exception e) {
            session.close();
            logger.error("&&&&&&&&&&&&&&&&&&&&&&&&删除定期清理类消息错误,"+e.getMessage());
        }
        logger.info("删除定期清理类消息数量：toId:{}",toId);
    }

    public int insertTimeClearMsg(TimeClearMsgPO po){
        int count=0;
        try {
            count = mapper.insertTimeClearMsg(po);
        } catch (Exception e) {
            session.close();
            logger.error("存储定期清理类消息错误,"+e.getMessage());
            e.printStackTrace();
        }
        return count;
    }

    public int updateTimeClearMsg(TimeClearMsgPO po){
        int count=0;
        try {
            count = mapper.updateTimeClearMsg(po);
        } catch (Exception e) {
            session.close();
            logger.error("更新定期清理类消息错误,"+e.getMessage());
            e.printStackTrace();
        }
        return count;
    }

    public TimeClearMsgPO getOneTimeClearLastMsg(int fromId,int toId) {
        TimeClearMsgPO tcmpo =new TimeClearMsgPO();
        try {
            tcmpo = mapper.getOneTimeClearLastMsg(fromId, toId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("捞取指定好友间定期清理类消息错误,"+e.getMessage());
        }
        return  tcmpo;
    }
}
