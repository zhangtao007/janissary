package com.lanjiu.im.storage.service;


import com.lanjiu.im.storage.dao.mapper.impl.OperateNumberMapper;
import com.lanjiu.im.storage.pojo.BueautifulNumberPO;
import com.lanjiu.im.storage.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OperateNumberService {

    private SqlSession session;
    private OperateNumberMapper mapper;

    public OperateNumberService(){
        session = DBTools.getSession();
        mapper = session.getMapper(OperateNumberMapper.class);
    }

    public void close(){
        session.close();
    }
    public void commit(){session.commit();}
    public void rollback() {session.rollback();}

    public int selectMinNumber(){
        int i =0;
        try {
            i = mapper.selectMinNum();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return  i;
    }

    public List<BueautifulNumberPO> exportNmber(int offset,int num){
        List<BueautifulNumberPO> list = null;
        try {
            list = mapper.exportBatchNum(offset,num);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        return list;
    }

    public int insertBatch(List<BueautifulNumberPO> list){
        int i = 0;
        try {
            i = mapper.insertBatchNum(list);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return  i;
    }

    public int deleteBatch(int n){
        int i = 0;
        try {
            i = mapper.deleteBatchNum(n);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return  i;
    }

}
