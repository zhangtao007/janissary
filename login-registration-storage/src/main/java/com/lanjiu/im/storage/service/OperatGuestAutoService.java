package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.OperationAutoNumMapper;
import com.lanjiu.im.storage.dao.mapper.impl.OperationGuestAutoNumMapper;
import com.lanjiu.im.storage.pojo.NumAutoGuestPO;
import com.lanjiu.im.storage.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OperatGuestAutoService {

    private SqlSession session;
    private OperationGuestAutoNumMapper mapper;

    public OperatGuestAutoService(){
        session = DBTools.getSession();
        mapper = session.getMapper(OperationGuestAutoNumMapper.class);
    }

    public void close(){
        session.close();
    }
    public void commit(){session.commit();}
    public void rollback() {session.rollback();}



    //从非靓号库捞号
    public List<NumAutoGuestPO> getOneUnusedAutoNumber(){
        List<NumAutoGuestPO> list =null;
        try {
            list = mapper.getUnusedGuestAutoNum();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return  list;
    }

    public int insertUsedAutoNumber(NumAutoGuestPO numberPO) {
        int i = 0;
        try {
            i = mapper.insertUsedGuestAutoNum(numberPO);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return i;
    }

    public int deleteUsedAutoNumber(NumAutoGuestPO numberPO) {
        int i = 0;
        try {
            i=mapper.deleteUsedGuestAutoNumber(numberPO);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return i;
    }

    public int insertUnUsedGuestAutoNum(NumAutoGuestPO po) {
        int i = 0;
        try {
            i=mapper.insertUnUsedGuestNum(po);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return i;
    }

    public int deleteUnUsedAutoNumber(NumAutoGuestPO numberPO) {
        int i = 0;
        try {
            i=mapper.deleteUnUsedGGuestAutoNum(numberPO);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return i;
    }
}
