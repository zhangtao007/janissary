package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.BeautifulNumberRealMapper;
import com.lanjiu.im.grpc.pojo.BeautifulNumberReal;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BeautifulNumberRealService {

    public List<BeautifulNumberReal> selectRecord(SqlSession session, BeautifulNumberRealMapper mapperb, BeautifulNumberReal beautifulNumberReal) {
        List<BeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectBeautifulNumberReal(beautifulNumberReal.getTenMillion(), beautifulNumberReal.getOneMillion(),
                    beautifulNumberReal.getOneHundredThousand(), beautifulNumberReal.getTenThousand(), beautifulNumberReal.getOneThousand(), beautifulNumberReal.getOneHundred(),
                    beautifulNumberReal.getTen(), beautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<BeautifulNumberReal> selectRecordByThousand(SqlSession session, BeautifulNumberRealMapper mapperb, BeautifulNumberReal beautifulNumberReal) {
        List<BeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectBeautifulNumberRealByThousand(beautifulNumberReal.getTenMillion(), beautifulNumberReal.getOneMillion(),
                    beautifulNumberReal.getOneHundredThousand(), beautifulNumberReal.getTenThousand(), beautifulNumberReal.getOneThousand());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

    public List<BeautifulNumberReal> selectAllRecords(SqlSession session, BeautifulNumberRealMapper mapperb) {
        List<BeautifulNumberReal> bList = null;
        try {
            bList = mapperb.selectAllBeautifulNumberReal();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }

}
