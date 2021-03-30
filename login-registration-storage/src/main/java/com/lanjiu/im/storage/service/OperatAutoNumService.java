package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.mapper.impl.OperationAutoNumMapper ;
import com.lanjiu.im.storage.pojo.BueautifulNumberPO;
import com.lanjiu.im.storage.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OperatAutoNumService {

    private SqlSession session;
    private OperationAutoNumMapper mapper;

    public OperatAutoNumService(){
        session = DBTools.getSession();
        mapper = session.getMapper(OperationAutoNumMapper.class);
    }

    public void close(){
        session.close();
    }
    public void commit(){session.commit();}
    public void rollback() {session.rollback();}



    //从非靓号库捞号
    public List<BueautifulNumberPO>  getOneUnusedAutoNumber(){
        List<BueautifulNumberPO> list =null;
        try {
           list = mapper.getUnusedAutoNum();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return  list;
    }

    public int insertUsedAutoNumber(BueautifulNumberPO numberPO) {
        int i = 0;
        try {
           i = mapper.insertUsedAutoNum(numberPO);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return i;
    }

    public int deleteUsedAutoNumber(BueautifulNumberPO numberPO) {
        int i = 0;
        try {
            mapper.deleteUsedAutoNumber(numberPO);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return i;
    }
}
