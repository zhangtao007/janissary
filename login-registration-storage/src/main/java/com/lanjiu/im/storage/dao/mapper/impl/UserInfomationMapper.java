package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.UserInfomationPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfomationMapper {
    int insertUserInfomation(UserInfomationPO userInfomationPO );
    int updateUserInfomation(UserInfomationPO userInfomationPO);
    List<UserInfomationPO>  selectUserInfomation( @Param("userId")int userId);
}
