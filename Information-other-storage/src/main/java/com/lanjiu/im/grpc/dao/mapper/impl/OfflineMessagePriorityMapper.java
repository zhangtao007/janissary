package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.OfflineMessagePriority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OfflineMessagePriorityMapper {
    public List<OfflineMessagePriority> selectAllOfflineMessagePriority() throws Exception;
}
