package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.RegistAutoNumMapper;
import com.lanjiu.im.storage.pojo.AutoRecordNumPO;
import com.lanjiu.im.storage.pojo.NumAutoRegistPO;
import com.lanjiu.im.storage.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RegistAutoNumService {

    private SqlSession session;
    private RegistAutoNumMapper mapper;

    public RegistAutoNumService(){
        session = DBTools.getSession();
        mapper = session.getMapper(RegistAutoNumMapper.class);
    }

    public void close(){
        session.close();
    }
    public void commit(){session.commit();}
    public void rollback() {session.rollback();}

    public int getUnusedAutoNum(){
        int i =0;
        try {
            i = mapper.selectUnusedSumNum();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return  i;
    }

    public List<NumAutoRegistPO> getAutoNumByThousand(NumAutoRegistPO po){
        List<NumAutoRegistPO> list=null;
        try {
            list = mapper.selectBatchNumByThousand(po);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return  list;
    }

    public int insertUsedAutoNum(List<NumAutoRegistPO> list){
        int i =0;
        try {
            i = mapper.insertBatchNum(list);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return  i;

    }

    public AutoRecordNumPO getRecordNum(String redord){
        AutoRecordNumPO po = null;
        try {
             po = mapper.selectNewNum(redord);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return  po;
    }

    public int insertNewRecord(AutoRecordNumPO po){
        int i =0;
        try {
            i = mapper.insertNewNum(po);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return  i;

    }
}
