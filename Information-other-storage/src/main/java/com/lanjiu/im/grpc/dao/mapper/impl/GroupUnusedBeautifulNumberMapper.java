package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.GroupUnusedBeautifulNumber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupUnusedBeautifulNumberMapper {

    public List<GroupUnusedBeautifulNumber> selectOnlyGroupUnusedBeautifulNumber() throws Exception;
    public List<GroupUnusedBeautifulNumber> selectAllGroupUnusedBeautifulNumber() throws Exception;
    public List<GroupUnusedBeautifulNumber> selectGroupUnusedBeautifulNumber(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                               @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public List<GroupUnusedBeautifulNumber> selectGroupUnusedBeautifulNumberByThousand(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                                         @Param("oneThousand") int oneThousand) throws Exception;
    public int insertGroupUnusedBeautifulNumber(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                 @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public int deleteGroupUnusedBeautifulNumber(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                 @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
}
