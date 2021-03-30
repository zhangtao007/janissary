package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.GuestGroupAdministrator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuestGroupAdministratorMapper {
    public List<GuestGroupAdministrator> selectAllGuestGroupAdministrator() throws Exception;
    public int insertGuestGroupAdministrator(@Param("administratorId") int administratorId, @Param("administratorType") String administratorType, @Param("administratorName") String administratorName) throws Exception;
    public int updateGuestGroupAdministrator(@Param("administratorId") int administratorId, @Param("administratorType") String administratorType, @Param("administratorName") String administratorName) throws Exception;
    public int deleteGuestGroupAdministrator(@Param("administratorId") int administratorId) throws Exception;
}
