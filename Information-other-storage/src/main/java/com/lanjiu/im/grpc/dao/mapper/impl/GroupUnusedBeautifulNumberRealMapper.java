package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.GroupUnusedBeautifulNumberReal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupUnusedBeautifulNumberRealMapper {

    List<GroupUnusedBeautifulNumberReal> selectOnlyGroupUnusedBeautifulNumberReal() throws Exception;

    List<GroupUnusedBeautifulNumberReal> selectAllGroupUnusedBeautifulNumberReal() throws Exception;

    List<GroupUnusedBeautifulNumberReal> selectGroupUnusedBeautifulNumberReal(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                                       @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;

    List<GroupUnusedBeautifulNumberReal> selectGroupUnusedBeautifulNumberRealByThousand(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                                                 @Param("oneThousand") int oneThousand) throws Exception;

    int insertGroupUnusedBeautifulNumberReal(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                     @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;

    int deleteGroupUnusedBeautifulNumberReal(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                     @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;


}
