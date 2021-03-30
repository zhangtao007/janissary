package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.GuestUserInfoPO;
import com.lanjiu.im.storage.pojo.UserInfomationPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuestInfomationMapper {
    int insertUserInfomation(GuestUserInfoPO  userInfomationPO );
    int deleteUserInfomation(@Param("userId") int userId);
    int updateUserInfomation(GuestUserInfoPO  userInfomationPO);
    List<GuestUserInfoPO>  selectUserInfomation( @Param("userId")int userId);
    List<GuestUserInfoPO > selectAllUserInfomation();

    int removeOverGuestInfo(List<Integer> list);
}
