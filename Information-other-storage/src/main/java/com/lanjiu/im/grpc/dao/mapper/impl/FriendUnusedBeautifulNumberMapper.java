package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.FriendUnusedBeautifulNumber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FriendUnusedBeautifulNumberMapper {

    public List<FriendUnusedBeautifulNumber> selectOnlyFriendUnusedBeautifulNumber() throws Exception;
    public List<FriendUnusedBeautifulNumber> selectAllFriendUnusedBeautifulNumber() throws Exception;
    public List<FriendUnusedBeautifulNumber> selectFriendUnusedBeautifulNumber(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                                       @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public List<FriendUnusedBeautifulNumber> selectFriendUnusedBeautifulNumberByThousand(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                                                 @Param("oneThousand") int oneThousand) throws Exception;
    public int insertFriendUnusedBeautifulNumber(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                     @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public int deleteFriendUnusedBeautifulNumber(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                     @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
}
