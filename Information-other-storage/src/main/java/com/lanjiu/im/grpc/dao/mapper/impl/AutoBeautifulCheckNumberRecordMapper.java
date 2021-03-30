package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.AutoBeautifulCheckNumberRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AutoBeautifulCheckNumberRecordMapper {
    public List<AutoBeautifulCheckNumberRecord> selectAutoBeautifulCheckNumberRecord(@Param("recordType") String recordType) throws Exception;
    public int updateAutoBeautifulCheckNumberRecord(@Param("tenMillion") int tenMillion,
                                                    @Param("oneMillion") int oneMillion,
                                                    @Param("oneHundredThousand") int oneHundredThousand,
                                                    @Param("tenThousand") int tenThousand,
                                                    @Param("oneThousand") int oneThousand,
                                                    @Param("recordType") String recordType) throws Exception;
}
