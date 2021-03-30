package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.OfflineMessagePriorityMapper;
import com.lanjiu.im.grpc.pojo.OfflineMessagePriority;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OfflineMessagePriorityService {

    public List<OfflineMessagePriority> selectAllRecords(SqlSession session, OfflineMessagePriorityMapper mapperb) {
        List<OfflineMessagePriority> bList = null;
        try {
            bList = mapperb.selectAllOfflineMessagePriority();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
