package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.BueautifulNumberPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperateNumberMapper {

    //判断未使用表中数据量
    int selectMinNum();

    //从总表中导出批量N条数据
    List<BueautifulNumberPO> exportBatchNum(@Param("offset") int offset, @Param("num") int num);

    //将重新获取的数据导入未使用表中
    int insertBatchNum( List<BueautifulNumberPO> list);

    //删除总表中已使用的数据
    int deleteBatchNum(@Param("n") int n);

}
