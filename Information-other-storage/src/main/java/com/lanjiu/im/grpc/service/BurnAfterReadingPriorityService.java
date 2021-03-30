package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.BurnAfterReadingPriorityMapper;
import com.lanjiu.im.grpc.pojo.BurnAfterReadingPriority;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BurnAfterReadingPriorityService {

    public List<BurnAfterReadingPriority> selectAllRecords(SqlSession session, BurnAfterReadingPriorityMapper mapperb) {
        List<BurnAfterReadingPriority> bList = null;
        try {
            bList = mapperb.selectAllBurnAfterReadingPriority();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

}
