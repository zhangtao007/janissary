package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.FriendUnusedBeautifulNumberReal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FriendUnusedBeautifulNumberRealMapper {

    public List<FriendUnusedBeautifulNumberReal> selectOnlyFriendUnusedBeautifulNumberReal() throws Exception;
    public List<FriendUnusedBeautifulNumberReal> selectAllFriendUnusedBeautifulNumberReal() throws Exception;
    public List<FriendUnusedBeautifulNumberReal> selectFriendUnusedBeautifulNumberReal(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                               @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public List<FriendUnusedBeautifulNumberReal> selectFriendUnusedBeautifulNumberRealByThousand(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                         @Param("oneThousand") int oneThousand) throws Exception;
    public int insertFriendUnusedBeautifulNumberReal(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                     @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public int deleteFriendUnusedBeautifulNumberReal(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                     @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
}
