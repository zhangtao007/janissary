package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.AutoRecordNumPO;
import com.lanjiu.im.storage.pojo.NumAutoRegistPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegistAutoNumMapper {

    int selectUnusedSumNum();

    List<NumAutoRegistPO> selectBatchNumByThousand(NumAutoRegistPO po);


    int insertBatchNum(List<NumAutoRegistPO> list);

    //获取记录附表当前数据位
    AutoRecordNumPO  selectNewNum(@Param("autoRegist")String autoRegist);

    //更新记录附表数据位
    int insertNewNum(AutoRecordNumPO po);
}
