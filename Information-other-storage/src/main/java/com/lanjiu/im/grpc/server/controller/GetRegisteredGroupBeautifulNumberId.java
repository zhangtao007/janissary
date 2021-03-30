package com.lanjiu.im.grpc.server.controller;

import com.lanjiu.im.grpc.dao.mapper.impl.BeautifulNumberRealMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.GroupUnusedBeautifulNumberRealMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.GroupUsedBeautifulNumberRealMapper;
import com.lanjiu.im.grpc.pojo.BeautifulNumberReal;
import com.lanjiu.im.grpc.pojo.GroupUnusedBeautifulNumberReal;
import com.lanjiu.im.grpc.pojo.GroupUsedBeautifulNumberReal;
import com.lanjiu.im.grpc.server.entity.BeautifulNumberEntity;
import com.lanjiu.im.grpc.service.BeautifulNumberRealService;
import com.lanjiu.im.grpc.service.GroupUnusedBeautifulNumberRealService;
import com.lanjiu.im.grpc.service.GroupUsedBeautifulNumberRealService;
import com.lanjiu.im.grpc.util.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Properties;

public class GetRegisteredGroupBeautifulNumberId {

    private static final Logger logger = Logger.getLogger(GetRegisteredGroupBeautifulNumberId.class.getName());

    public BeautifulNumberEntity getConfig(){
        BeautifulNumberEntity beautifulNumberEntity = new BeautifulNumberEntity();
        ConfigFileOperationForBeautifulNumber configFileOperationForBeautifulNumber = new ConfigFileOperationForBeautifulNumber();
        Properties properties = configFileOperationForBeautifulNumber.getRegisteredGroupBeautifulNumberConfig();
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

    public GroupUsedBeautifulNumberReal judgeAndGetGroupId(SqlSession session, GroupUsedBeautifulNumberRealMapper mapperbGroupUsedBeautifulNumberMapper, BeautifulNumberEntity beautifulNumberEntity){
        GroupUsedBeautifulNumberRealService friendUnusedBeautifulNumberService = new GroupUsedBeautifulNumberRealService();
        GroupUsedBeautifulNumberReal friendUnusedBeautifulNumber = new GroupUsedBeautifulNumberReal();
        List<GroupUsedBeautifulNumberReal> friendUnusedBeautifulNumberList = null;
        int nSelectUnused = 0;
        friendUnusedBeautifulNumber.setTenMillion(beautifulNumberEntity.getTenMillion());
        friendUnusedBeautifulNumber.setOneMillion(beautifulNumberEntity.getOneMillion());
        friendUnusedBeautifulNumber.setOneHundredThousand(beautifulNumberEntity.getOneHundredThousand());
        friendUnusedBeautifulNumber.setTenThousand(beautifulNumberEntity.getTenThousand());
        friendUnusedBeautifulNumber.setOneThousand(beautifulNumberEntity.getOneThousand());
        friendUnusedBeautifulNumber.setOneHundred(beautifulNumberEntity.getOneHundred());
        friendUnusedBeautifulNumber.setTen(beautifulNumberEntity.getTen());
        friendUnusedBeautifulNumber.setOne(beautifulNumberEntity.getOne());
        friendUnusedBeautifulNumberList = friendUnusedBeautifulNumberService.selectRecord(session, mapperbGroupUsedBeautifulNumberMapper, friendUnusedBeautifulNumber);
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

    public GroupUnusedBeautifulNumberReal getRegisteredGroupId(){
        SqlSession session = DBTools.getSession();
        GroupUnusedBeautifulNumberRealMapper mapperbFriendUnusedBeautifulNumberMapper = session.getMapper(GroupUnusedBeautifulNumberRealMapper.class);
        GroupUnusedBeautifulNumberRealService friendUnusedBeautifulNumberService = new GroupUnusedBeautifulNumberRealService();
        List<GroupUnusedBeautifulNumberReal> friendUnusedBeautifulNumberList = null;
        GroupUnusedBeautifulNumberReal friendUnusedBeautifulNumber = new GroupUnusedBeautifulNumberReal();
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
                GroupUsedBeautifulNumberRealMapper mapperbFriendUsedBeautifulNumberMapper = session.getMapper(GroupUsedBeautifulNumberRealMapper.class);
                GroupUsedBeautifulNumberReal friendUsedBeautifulNumber = judgeAndGetGroupId(session, mapperbFriendUsedBeautifulNumberMapper, beautifulNumberEntity);
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
                friendUnusedBeautifulNumberList = friendUnusedBeautifulNumberService.selectOnlyGroupUnusedBeautifulNumberReal(session, mapperbFriendUnusedBeautifulNumberMapper);
                //commonUtils.isHave(list)
                CommonUtils<GroupUnusedBeautifulNumberReal> commonUtils = new CommonUtils<>();
                if (commonUtils.isHave(friendUnusedBeautifulNumberList)){
                    friendUnusedBeautifulNumber = friendUnusedBeautifulNumberList.get(0);
                }
            }
        }
        return friendUnusedBeautifulNumber;
    }

    public int getRegisteredGroupIntId(){
        GroupUnusedBeautifulNumberReal groupUnusedBeautifulNumber = getRegisteredGroupId();
        int initialNumber = groupUnusedBeautifulNumber.getTenMillion() * ConstantsContent.BEAUTIFUL_NUMBER_TEN_MILLION
                + groupUnusedBeautifulNumber.getOneMillion() * ConstantsContent.BEAUTIFUL_NUMBER_ONE_MILLION
                + groupUnusedBeautifulNumber.getOneHundredThousand() * ConstantsContent.BEAUTIFUL_NUMBER_ONE_HUNDRED_THOUSAND
                + groupUnusedBeautifulNumber.getTenThousand() * ConstantsContent.BEAUTIFUL_NUMBER_TEN_THOUSAND
                + groupUnusedBeautifulNumber.getOneThousand() * ConstantsContent.BEAUTIFUL_NUMBER_ONE_THOUSAND
                + groupUnusedBeautifulNumber.getOneHundred() * ConstantsContent.BEAUTIFUL_NUMBER_ONE_HUNDRED
                + groupUnusedBeautifulNumber.getTen() * ConstantsContent.BEAUTIFUL_NUMBER_TEN
                + groupUnusedBeautifulNumber.getOne() * ConstantsContent.BEAUTIFUL_NUMBER_ONE;
        return initialNumber;
    }
}
