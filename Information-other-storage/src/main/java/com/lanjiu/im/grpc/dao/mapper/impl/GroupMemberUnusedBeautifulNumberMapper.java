package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.GroupMemberUnusedBeautifulNumber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupMemberUnusedBeautifulNumberMapper {

    public List<GroupMemberUnusedBeautifulNumber> selectOnlyGroupMemberUnusedBeautifulNumber() throws Exception;
    public List<GroupMemberUnusedBeautifulNumber> selectAllGroupMemberUnusedBeautifulNumber() throws Exception;
    public List<GroupMemberUnusedBeautifulNumber> selectGroupMemberUnusedBeautifulNumber(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                               @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public List<GroupMemberUnusedBeautifulNumber> selectGroupMemberUnusedBeautifulNumberByThousand(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                                         @Param("oneThousand") int oneThousand) throws Exception;
    public int insertGroupMemberUnusedBeautifulNumber(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                 @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public int deleteGroupMemberUnusedBeautifulNumber(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                 @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
}
