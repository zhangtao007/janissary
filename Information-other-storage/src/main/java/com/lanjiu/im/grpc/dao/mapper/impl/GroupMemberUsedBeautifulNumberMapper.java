package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.GroupMemberUsedBeautifulNumber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupMemberUsedBeautifulNumberMapper {

    public List<GroupMemberUsedBeautifulNumber> selectAllGroupMemberUsedBeautifulNumber() throws Exception;
    public List<GroupMemberUsedBeautifulNumber> selectGroupMemberUsedBeautifulNumber(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                           @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public List<GroupMemberUsedBeautifulNumber> selectGroupMemberUsedBeautifulNumberByThousand(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                                     @Param("oneThousand") int oneThousand) throws Exception;
    public int insertGroupMemberUsedBeautifulNumber(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                               @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public int deleteGroupMemberUsedBeautifulNumber(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                               @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
}
