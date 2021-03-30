package com.lanjiu.im.storage.dao.mapper.impl;

import com.lanjiu.im.storage.pojo.GuestUserPO;
import com.lanjiu.im.storage.pojo.VersionPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuestUserMapper {
    int insertGuestUser(GuestUserPO guestUserPO);
    int deleteGuestUser(@Param("userId") int userId);
    List<GuestUserPO> selectAllGuestUser();
    List<GuestUserPO> searchGuestUser(@Param("userId") int userId);

    List<Integer> selectOverTimeUser(@Param("time") int time);
    int removeOverTimeUser(List<Integer> list);


}
