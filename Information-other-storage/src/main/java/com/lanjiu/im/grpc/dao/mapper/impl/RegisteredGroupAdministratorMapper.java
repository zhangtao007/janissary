package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.RegisteredGroupAdministrator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegisteredGroupAdministratorMapper {
    public List<RegisteredGroupAdministrator> selectAllRegisteredGroupAdministrator() throws Exception;
    public int insertRegisteredGroupAdministrator(@Param("administratorId") int administratorId, @Param("administratorType") String administratorType, @Param("administratorName") String administratorName) throws Exception;
    public int updateRegisteredGroupAdministrator(@Param("administratorId") int administratorId, @Param("administratorType") String administratorType, @Param("administratorName") String administratorName) throws Exception;
    public int deleteRegisteredGroupAdministrator(@Param("administratorId") int administratorId) throws Exception;
}
