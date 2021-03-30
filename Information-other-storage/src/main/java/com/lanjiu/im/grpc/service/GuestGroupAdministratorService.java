package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.GuestGroupAdministratorMapper;
import com.lanjiu.im.grpc.pojo.GuestGroupAdministrator;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GuestGroupAdministratorService {

    public List<GuestGroupAdministrator> selectAllRecords(SqlSession session, GuestGroupAdministratorMapper mapperb) {
        List<GuestGroupAdministrator> bList = null;
        try {
            bList = mapperb.selectAllGuestGroupAdministrator();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public int insertRecord(SqlSession session, GuestGroupAdministratorMapper mapperb, GuestGroupAdministrator guestGroupAdministrator){
        int result = 0;
        try {
            result = mapperb.insertGuestGroupAdministrator(guestGroupAdministrator.getAdministratorId(), guestGroupAdministrator.getAdministratorType(), guestGroupAdministrator.getAdministratorName());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int updateRecord(SqlSession session, GuestGroupAdministratorMapper mapperb, GuestGroupAdministrator guestGroupAdministrator){
        int result = 0;
        try {
            result = mapperb.updateGuestGroupAdministrator(guestGroupAdministrator.getAdministratorId(), guestGroupAdministrator.getAdministratorType(), guestGroupAdministrator.getAdministratorName());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public int deleteRecordByGroupAdministratorId(SqlSession session, GuestGroupAdministratorMapper mapperb, GuestGroupAdministrator guestGroupAdministrator){
        int result = 0;
        try {
            result = mapperb.deleteGuestGroupAdministrator(guestGroupAdministrator.getAdministratorId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }
}
