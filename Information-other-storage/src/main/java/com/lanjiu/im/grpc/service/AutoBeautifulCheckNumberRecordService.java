package com.lanjiu.im.grpc.service;

import com.lanjiu.im.grpc.dao.mapper.impl.AutoBeautifulCheckNumberRecordMapper;
import com.lanjiu.im.grpc.pojo.AutoBeautifulCheckNumberRecord;
import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AutoBeautifulCheckNumberRecordService {

    public int updateAutoBeautifulCheckNumberRecord(SqlSession session, AutoBeautifulCheckNumberRecordMapper mapperb, AutoBeautifulCheckNumberRecord autoBeautifulCheckNumberRecord){
        int result = 0;
        try {
            result = mapperb.updateAutoBeautifulCheckNumberRecord(autoBeautifulCheckNumberRecord.getTenMillion(), autoBeautifulCheckNumberRecord.getOneMillion(),
                    autoBeautifulCheckNumberRecord.getOneHundredThousand(), autoBeautifulCheckNumberRecord.getTenThousand(),
                    autoBeautifulCheckNumberRecord.getOneThousand(), autoBeautifulCheckNumberRecord.getRecordType());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return result;
    }

    public List<AutoBeautifulCheckNumberRecord> selectAutoBeautifulCheckNumberRecord(SqlSession session, AutoBeautifulCheckNumberRecordMapper mapperb, AutoBeautifulCheckNumberRecord autoBeautifulCheckNumberRecord) {
        List<AutoBeautifulCheckNumberRecord> bList = null;
        try {
            bList = mapperb.selectAutoBeautifulCheckNumberRecord(autoBeautifulCheckNumberRecord.getRecordType());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return bList;
    }
}
