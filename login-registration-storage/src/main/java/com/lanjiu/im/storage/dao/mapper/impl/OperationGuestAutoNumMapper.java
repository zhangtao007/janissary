package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.NumAutoGuestPO;

import java.util.List;

public interface OperationGuestAutoNumMapper {

    List<NumAutoGuestPO> getUnusedGuestAutoNum();

    int insertUsedGuestAutoNum(NumAutoGuestPO numberPO);

    int deleteUsedGuestAutoNumber(NumAutoGuestPO numberPO);

    int insertUnUsedGuestNum(NumAutoGuestPO po);

    int deleteUnUsedGGuestAutoNum(NumAutoGuestPO numberPO);
}
