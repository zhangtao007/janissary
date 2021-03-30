package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.GroupMemberUsedBeautifulNumberReal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupMemberUsedBeautifulNumberRealMapper {

    public List<GroupMemberUsedBeautifulNumberReal> selectAllGroupMemberUsedBeautifulNumberReal() throws Exception;
    public List<GroupMemberUsedBeautifulNumberReal> selectGroupMemberUsedBeautifulNumberReal(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                                   @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public List<GroupMemberUsedBeautifulNumberReal> selectGroupMemberUsedBeautifulNumberRealByThousand(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                                             @Param("oneThousand") int oneThousand) throws Exception;
    public int insertGroupMemberUsedBeautifulNumberReal(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                   @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public int deleteGroupMemberUsedBeautifulNumberReal(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                   @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
}
