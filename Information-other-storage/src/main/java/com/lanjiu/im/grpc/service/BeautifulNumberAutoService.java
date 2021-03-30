package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.BeautifulNumberAutoMapper;
import com.lanjiu.im.grpc.pojo.BeautifulNumberAuto;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BeautifulNumberAutoService {

    public List<BeautifulNumberAuto> selectRecord(SqlSession session, BeautifulNumberAutoMapper mapperb, BeautifulNumberAuto beautifulNumberAuto) {
        List<BeautifulNumberAuto> bList = null;
        try {
            bList = mapperb.selectBeautifulNumberAuto(beautifulNumberAuto.getTenMillion(), beautifulNumberAuto.getOneMillion(),
                    beautifulNumberAuto.getOneHundredThousand(), beautifulNumberAuto.getTenThousand(), beautifulNumberAuto.getOneThousand(), beautifulNumberAuto.getOneHundred(),
                    beautifulNumberAuto.getTen(), beautifulNumberAuto.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<BeautifulNumberAuto> selectRecordByThousand(SqlSession session, BeautifulNumberAutoMapper mapperb, BeautifulNumberAuto beautifulNumberAuto) {
        List<BeautifulNumberAuto> bList = null;
        try {
            bList = mapperb.selectBeautifulNumberAutoByThousand(beautifulNumberAuto.getTenMillion(), beautifulNumberAuto.getOneMillion(),
                    beautifulNumberAuto.getOneHundredThousand(), beautifulNumberAuto.getTenThousand(), beautifulNumberAuto.getOneThousand());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<BeautifulNumberAuto> selectAllRecords(SqlSession session, BeautifulNumberAutoMapper mapperb) {
        List<BeautifulNumberAuto> bList = null;
        try {
            bList = mapperb.selectAllBeautifulNumberAuto();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
