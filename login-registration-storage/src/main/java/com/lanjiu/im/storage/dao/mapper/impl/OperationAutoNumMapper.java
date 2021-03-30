package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.BueautifulNumberPO;
import com.lanjiu.im.storage.pojo.NumAutoGuestPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperationAutoNumMapper {



    List<BueautifulNumberPO>  getUnusedAutoNum();

    int insertUsedAutoNum(BueautifulNumberPO numberPO);

    int deleteUsedAutoNumber(BueautifulNumberPO numberPO);






}
