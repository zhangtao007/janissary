package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.RegisteredGroupAdministratorMapper;
import com.lanjiu.im.grpc.pojo.RegisteredGroupAdministrator;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RegisteredGroupAdministratorService {

    public List<RegisteredGroupAdministrator> selectAllRecords(SqlSession session, RegisteredGroupAdministratorMapper mapperb) {
        List<RegisteredGroupAdministrator> bList = null;
        try {
            bList = mapperb.selectAllRegisteredGroupAdministrator();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public int insertRecord(SqlSession session, RegisteredGroupAdministratorMapper mapperb, RegisteredGroupAdministrator registeredGroupAdministrator){
        int result = 0;
        try {
            result = mapperb.insertRegisteredGroupAdministrator(registeredGroupAdministrator.getAdministratorId(), registeredGroupAdministrator.getAdministratorType(), registeredGroupAdministrator.getAdministratorName());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int updateRecord(SqlSession session, RegisteredGroupAdministratorMapper mapperb, RegisteredGroupAdministrator registeredGroupAdministrator){
        int result = 0;
        try {
            result = mapperb.updateRegisteredGroupAdministrator(registeredGroupAdministrator.getAdministratorId(), registeredGroupAdministrator.getAdministratorType(), registeredGroupAdministrator.getAdministratorName());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecordByGroupAdministratorId(SqlSession session, RegisteredGroupAdministratorMapper mapperb, RegisteredGroupAdministrator registeredGroupAdministrator){
        int result = 0;
        try {
            result = mapperb.deleteRegisteredGroupAdministrator(registeredGroupAdministrator.getAdministratorId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }
}
