package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.GroupUsedBeautifulNumber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupUsedBeautifulNumberMapper {
    //tenMillion,oneMillion,oneHundredThousand,tenThousand,oneThousand,oneHundred,ten,one
    public List<GroupUsedBeautifulNumber> selectAllGroupUsedBeautifulNumber() throws Exception;
    public List<GroupUsedBeautifulNumber> selectGroupUsedBeautifulNumber(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                           @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public List<GroupUsedBeautifulNumber> selectGroupUsedBeautifulNumberByThousand(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                                     @Param("oneThousand") int oneThousand) throws Exception;
    public int insertGroupUsedBeautifulNumber(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                               @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public int deleteGroupUsedBeautifulNumber(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                               @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
}
