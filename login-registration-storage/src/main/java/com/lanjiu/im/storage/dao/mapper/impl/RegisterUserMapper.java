package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.RegisterUserPO;
import com.lanjiu.im.storage.pojo.UserDevice;
import com.lanjiu.im.storage.pojo.VersionPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegisterUserMapper {
     int insertRegisterUser(RegisterUserPO registerUserPO);
     int deleteRegisterUser(@Param("userId") int userId );
     int updateRegisterUser(RegisterUserPO registerUserPO);
     List<RegisterUserPO> selectAllRegisterUser();
     RegisterUserPO  selesctRegisterUser(@Param("userId") int userId );
     String selectUserPass(@Param("userId")int userId);

     List<RegisterUserPO> searchUserById(@Param("userId")int userId);

     VersionPO selectNewVersion();

     List<RegisterUserPO> getUserByPhone(@Param("phone") String phone);

    List<UserDevice> getUserDevice(@Param("userId") int userId);

     int insertUserDevice(@Param("userId") int userId ,@Param("manufacturer") String manufacturer, @Param("pushToken") String pushToken);

     int updateUserDevice(@Param("userId") int userId,  @Param("manufacturer")String manufacturer, @Param("pushToken") String pushToken);
}
