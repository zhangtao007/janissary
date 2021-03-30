package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.GroupMemberUnusedBeautifulNumberReal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupMemberUnusedBeautifulNumberRealMapper {

    public List<GroupMemberUnusedBeautifulNumberReal> selectOnlyGroupMemberUnusedBeautifulNumberReal() throws Exception;
    public List<GroupMemberUnusedBeautifulNumberReal> selectAllGroupMemberUnusedBeautifulNumberReal() throws Exception;
    public List<GroupMemberUnusedBeautifulNumberReal> selectGroupMemberUnusedBeautifulNumberReal(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                                       @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public List<GroupMemberUnusedBeautifulNumberReal> selectGroupMemberUnusedBeautifulNumberRealByThousand(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                                                 @Param("oneThousand") int oneThousand) throws Exception;
    public int insertGroupMemberUnusedBeautifulNumberReal(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                     @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public int deleteGroupMemberUnusedBeautifulNumberReal(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                     @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
}
