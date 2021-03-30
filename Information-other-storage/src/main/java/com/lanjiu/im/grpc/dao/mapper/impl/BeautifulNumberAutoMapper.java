package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.BeautifulNumberAuto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BeautifulNumberAutoMapper {
    //tenMillion,oneMillion,oneHundredThousand,tenThousand,oneThousand,oneHundred,ten,one
    public List<BeautifulNumberAuto> selectAllBeautifulNumberAuto() throws Exception;
    public List<BeautifulNumberAuto> selectBeautifulNumberAuto(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                               @Param("oneThousand") int oneThousand, @Param("oneHundred") int oneHundred, @Param("ten") int ten, @Param("one") int one) throws Exception;
    public List<BeautifulNumberAuto> selectBeautifulNumberAutoByThousand(@Param("tenMillion") int tenMillion, @Param("oneMillion") int oneMillion, @Param("oneHundredThousand") int oneHundredThousand, @Param("tenThousand") int tenThousand,
                                                                         @Param("oneThousand") int oneThousand) throws Exception;
//    public int insertBeautifulNumberAuto(@Param("downloadUrl") String downloadUrl, @Param("guestGroupId") int guestGroupId, @Param("guestMemberId") int guestMemberId,
//                                                           @Param("guestUserId") int guestUserId, @Param("creationTime") Date creationTime) throws Exception;
//    public int deleteBeautifulNumberAuto(@Param("downloadUrl") String downloadUrl) throws Exception;
}
