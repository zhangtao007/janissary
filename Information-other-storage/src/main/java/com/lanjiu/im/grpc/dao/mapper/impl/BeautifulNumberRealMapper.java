package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.BeautifulNumberReal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BeautifulNumberRealMapper {
    //tenMillion,oneMillion,oneHundredThousand,tenThousand,oneThousand,oneHundred,ten,one
    public List<BeautifulNumberReal> selectAllBeautifulNumberReal() throws Exception;
    public List<BeautifulNumberReal> selectBeautifulNumberReal(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                               @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public List<BeautifulNumberReal> selectBeautifulNumberRealByThousand(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                               @Param("oneThousand") int oneThousand) throws Exception;
//    public int insertBeautifulNumberReal(@Param("downloadUrl") String downloadUrl, @Param("guestGroupId") int guestGroupId, @Param("guestMemberId") int guestMemberId,
//                                                           @Param("guestUserId") int guestUserId, @Param("creationTime") Date creationTime) throws Exception;
//    public int deleteBeautifulNumberReal(@Param("downloadUrl") String downloadUrl) throws Exception;
}
