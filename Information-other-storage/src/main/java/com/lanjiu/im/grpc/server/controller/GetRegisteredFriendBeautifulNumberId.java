package com.lanjiu.im.grpc.server.controller;

import com.lanjiu.im.grpc.dao.mapper.impl.BeautifulNumberRealMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.FriendUnusedBeautifulNumberRealMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.FriendUsedBeautifulNumberRealMapper;
import com.lanjiu.im.grpc.pojo.BeautifulNumberReal;
import com.lanjiu.im.grpc.pojo.FriendUnusedBeautifulNumberReal;
import com.lanjiu.im.grpc.pojo.FriendUsedBeautifulNumberReal;
import com.lanjiu.im.grpc.server.entity.BeautifulNumberEntity;
import com.lanjiu.im.grpc.service.BeautifulNumberRealService;
import com.lanjiu.im.grpc.service.FriendUnusedBeautifulNumberRealService;
import com.lanjiu.im.grpc.service.FriendUsedBeautifulNumberRealService;
import com.lanjiu.im.grpc.util.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Properties;

public class GetRegisteredFriendBeautifulNumberId {

    private static final Logger logger = Logger.getLogger(GetRegisteredFriendBeautifulNumberId.class.getName());

    public BeautifulNumberEntity getConfig(){
        BeautifulNumberEntity beautifulNumberEntity = new BeautifulNumberEntity();
        ConfigFileOperationForBeautifulNumber configFileOperationForBeautifulNumber = new ConfigFileOperationForBeautifulNumber();
        Properties properties = configFileOperationForBeautifulNumber.getRegisteredFriendBeautifulNumberConfig();
        String tenMillionJudge = properties.getProperty("ten_million");
        String oneMillionJudge = properties.getProperty("one_million");
        String oneHundredThousandJudge = properties.getProperty("one_hundred_thousand");
        String tenThousandJudge = properties.getProperty("ten_thousand");
        String oneThousandJudge = properties.getProperty("one_thousand");
        String oneHundredJudge = properties.getProperty("one_hundred");
        String tenJudge = properties.getProperty("ten");
        String oneJudge = properties.getProperty("one");
        if(((!"".equals(tenMillionJudge))&&(tenMillionJudge != null))
                &&((!"".equals(oneMillionJudge))&&(oneMillionJudge != null))
                &&((!"".equals(oneHundredThousandJudge))&&(oneHundredThousandJudge != null))
                &&((!"".equals(tenThousandJudge))&&(tenThousandJudge != null))
                &&((!"".equals(oneThousandJudge))&&(oneThousandJudge != null))
                &&((!"".equals(oneHundredJudge))&&(oneHundredJudge != null))
                &&((!"".equals(tenJudge))&&(tenJudge != null))
                &&((!"".equals(oneJudge))&&(oneJudge != null))
                ){
            int tenMillion = Integer.valueOf(properties.getProperty("ten_million"));
            int oneMillion = Integer.valueOf(properties.getProperty("one_million"));
            int oneHundredThousand = Integer.valueOf(properties.getProperty("one_hundred_thousand"));
            int tenThousand = Integer.valueOf(properties.getProperty("ten_thousand"));
            int oneThousand = Integer.valueOf(properties.getProperty("one_thousand"));
            int oneHundred= Integer.valueOf(properties.getProperty("one_hundred"));
            int ten = Integer.valueOf(properties.getProperty("ten"));
            int one = Integer.valueOf(properties.getProperty("one"));
            String start = properties.getProperty("start");
            beautifulNumberEntity.setTenMillion(tenMillion);
            beautifulNumberEntity.setOneMillion(oneMillion);
            beautifulNumberEntity.setOneHundredThousand(oneHundredThousand);
            beautifulNumberEntity.setTenThousand(tenThousand);
            beautifulNumberEntity.setOneThousand(oneThousand);
            beautifulNumberEntity.setOneHundred(oneHundred);
            beautifulNumberEntity.setTen(ten);
            beautifulNumberEntity.setOne(one);
            beautifulNumberEntity.setStart(start);
            //合法性判断
            BeautifulNumberReal beautifulNumberReal = new BeautifulNumberReal();
            beautifulNumberReal.setTenMillion(tenMillion);
            beautifulNumberReal.setOneMillion(oneMillion);
            beautifulNumberReal.setOneHundredThousand(oneHundredThousand);
            beautifulNumberReal.setTenThousand(tenThousand);
            beautifulNumberReal.setOneThousand(oneThousand);
            beautifulNumberReal.setOneHundred(oneHundred);
            beautifulNumberReal.setTen(ten);
            beautifulNumberReal.setOne(one);
            SqlSession session = DBTools.getSession();
            BeautifulNumberRealMapper mapperb = session.getMapper(BeautifulNumberRealMapper.class);
            BeautifulNumberRealService beautifulNumberRealService = new BeautifulNumberRealService();
            List<BeautifulNumberReal> list = beautifulNumberRealService.selectRecord(session, mapperb, beautifulNumberReal);
            if(list != null){
                if(list.size() >=1){
                    return beautifulNumberEntity;
                }
            }
            return null;
        }
        return null;
    }

    public FriendUsedBeautifulNumberReal judgeAndGetFriendId(SqlSession session, FriendUsedBeautifulNumberRealMapper mapperbFriendUsedBeautifulNumberMapper, BeautifulNumberEntity beautifulNumberEntity){
        FriendUsedBeautifulNumberRealService friendUnusedBeautifulNumberService = new FriendUsedBeautifulNumberRealService();
        FriendUsedBeautifulNumberReal friendUnusedBeautifulNumber = new FriendUsedBeautifulNumberReal();
        List<FriendUsedBeautifulNumberReal> friendUnusedBeautifulNumberList = null;
        int nSelectUnused = 0;
        friendUnusedBeautifulNumber.setTenMillion(beautifulNumberEntity.getTenMillion());
        friendUnusedBeautifulNumber.setOneMillion(beautifulNumberEntity.getOneMillion());
        friendUnusedBeautifulNumber.setOneHundredThousand(beautifulNumberEntity.getOneHundredThousand());
        friendUnusedBeautifulNumber.setTenThousand(beautifulNumberEntity.getTenThousand());
        friendUnusedBeautifulNumber.setOneThousand(beautifulNumberEntity.getOneThousand());
        friendUnusedBeautifulNumber.setOneHundred(beautifulNumberEntity.getOneHundred());
        friendUnusedBeautifulNumber.setTen(beautifulNumberEntity.getTen());
        friendUnusedBeautifulNumber.setOne(beautifulNumberEntity.getOne());
        friendUnusedBeautifulNumberList = friendUnusedBeautifulNumberService.selectRecord(session, mapperbFriendUsedBeautifulNumberMapper, friendUnusedBeautifulNumber);
        if(friendUnusedBeautifulNumberList != null) {
            nSelectUnused = friendUnusedBeautifulNumberList.size();
            if (nSelectUnused == 0) {
                return friendUnusedBeautifulNumber;
            }else {
                logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_REAL_FAIL);
                return null;
            }
        }else {
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
            return null;
        }
    }

    public FriendUnusedBeautifulNumberReal getRegisteredFriendId(){
        SqlSession session = DBTools.getSession();
        FriendUnusedBeautifulNumberRealMapper mapperbFriendUnusedBeautifulNumberMapper = session.getMapper(FriendUnusedBeautifulNumberRealMapper.class);
        FriendUnusedBeautifulNumberRealService friendUnusedBeautifulNumberService = new FriendUnusedBeautifulNumberRealService();
        List<FriendUnusedBeautifulNumberReal> friendUnusedBeautifulNumberList = null;
        FriendUnusedBeautifulNumberReal friendUnusedBeautifulNumber = new FriendUnusedBeautifulNumberReal();
        //判断靓号设置是否启动
        BeautifulNumberEntity beautifulNumberEntity = getConfig();
        if(null == beautifulNumberEntity){
            //靓号配置文件不合法
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_REAL_ILLEGAL);
            return null;
        }
        else{
            String start = beautifulNumberEntity.getStart();
            if(ConstantsContent.BEAUTIFUL_NUMBER_SET_COMMON_START.equals(start)){
                //手动派发靓号
                FriendUsedBeautifulNumberRealMapper mapperbFriendUsedBeautifulNumberMapper = session.getMapper(FriendUsedBeautifulNumberRealMapper.class);
                FriendUsedBeautifulNumberReal friendUsedBeautifulNumber = judgeAndGetFriendId(session, mapperbFriendUsedBeautifulNumberMapper, beautifulNumberEntity);
                if(null != friendUsedBeautifulNumber){
                    logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_REAL_SUCCESS);
                    friendUnusedBeautifulNumber.setTenMillion(friendUsedBeautifulNumber.getTenMillion());
                    friendUnusedBeautifulNumber.setOneMillion(friendUsedBeautifulNumber.getOneMillion());
                    friendUnusedBeautifulNumber.setOneHundredThousand(friendUsedBeautifulNumber.getOneHundredThousand());
                    friendUnusedBeautifulNumber.setTenThousand(friendUsedBeautifulNumber.getTenThousand());
                    friendUnusedBeautifulNumber.setOneThousand(friendUsedBeautifulNumber.getOneThousand());
                    friendUnusedBeautifulNumber.setOneHundred(friendUsedBeautifulNumber.getOneHundred());
                    friendUnusedBeautifulNumber.setTen(friendUsedBeautifulNumber.getTen());
                    friendUnusedBeautifulNumber.setOne(friendUsedBeautifulNumber.getOne());
                    return friendUnusedBeautifulNumber;
                }
            }else {
                //自动派发号码
                friendUnusedBeautifulNumberList = friendUnusedBeautifulNumberService.selectOnlyFriendUnusedBeautifulNumberReal(session, mapperbFriendUnusedBeautifulNumberMapper);
                //commonUtils.isHave(list)
                CommonUtils<FriendUnusedBeautifulNumberReal> commonUtils = new CommonUtils<>();
                if (commonUtils.isHave(friendUnusedBeautifulNumberList)){
                    friendUnusedBeautifulNumber = friendUnusedBeautifulNumberList.get(0);
                }
            }
        }
        return friendUnusedBeautifulNumber;
    }

    public int getRegisteredFriendIntId(){
        FriendUnusedBeautifulNumberReal friendUnusedBeautifulNumber = getRegisteredFriendId();
        int initialNumber = friendUnusedBeautifulNumber.getTenMillion() * ConstantsContent.BEAUTIFUL_NUMBER_TEN_MILLION
                + friendUnusedBeautifulNumber.getOneMillion() * ConstantsContent.BEAUTIFUL_NUMBER_ONE_MILLION
                + friendUnusedBeautifulNumber.getOneHundredThousand() * ConstantsContent.BEAUTIFUL_NUMBER_ONE_HUNDRED_THOUSAND
                + friendUnusedBeautifulNumber.getTenThousand() * ConstantsContent.BEAUTIFUL_NUMBER_TEN_THOUSAND
                + friendUnusedBeautifulNumber.getOneThousand() * ConstantsContent.BEAUTIFUL_NUMBER_ONE_THOUSAND
                + friendUnusedBeautifulNumber.getOneHundred() * ConstantsContent.BEAUTIFUL_NUMBER_ONE_HUNDRED
                + friendUnusedBeautifulNumber.getTen() * ConstantsContent.BEAUTIFUL_NUMBER_TEN
                + friendUnusedBeautifulNumber.getOne() * ConstantsContent.BEAUTIFUL_NUMBER_ONE;
        return initialNumber;
    }
}
