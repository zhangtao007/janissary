package com.lanjiu.im.grpc.server.controller;

import com.lanjiu.im.grpc.dao.mapper.impl.*;
import com.lanjiu.im.grpc.pojo.*;
import com.lanjiu.im.grpc.server.entity.BeautifulNumberEntity;
import com.lanjiu.im.grpc.service.BeautifulNumberRealService;
import com.lanjiu.im.grpc.service.GroupMemberUnusedBeautifulNumberRealService;
import com.lanjiu.im.grpc.service.GroupMemberUsedBeautifulNumberRealService;
import com.lanjiu.im.grpc.util.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Properties;
import java.util.Random;

public class GetRegisteredGroupMemberBeautifulNumberId {

    private static final Logger logger = Logger.getLogger(GetRegisteredGroupMemberBeautifulNumberId.class.getName());

    public BeautifulNumberEntity getConfig(){
        BeautifulNumberEntity beautifulNumberEntity = new BeautifulNumberEntity();
        ConfigFileOperationForBeautifulNumber configFileOperationForBeautifulNumber = new ConfigFileOperationForBeautifulNumber();
        Properties properties = configFileOperationForBeautifulNumber.getRegisteredGroupMemberBeautifulNumberConfig();
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

    public GroupMemberUsedBeautifulNumberReal judgeAndGetGroupMemberId(SqlSession session, GroupMemberUsedBeautifulNumberRealMapper mapperbGroupMemberUsedBeautifulNumberMapper, BeautifulNumberEntity beautifulNumberEntity){
        GroupMemberUsedBeautifulNumberRealService friendUnusedBeautifulNumberService = new GroupMemberUsedBeautifulNumberRealService();
        GroupMemberUsedBeautifulNumberReal friendUnusedBeautifulNumber = new GroupMemberUsedBeautifulNumberReal();
        List<GroupMemberUsedBeautifulNumberReal> friendUnusedBeautifulNumberList = null;
        int nSelectUnused = 0;
        friendUnusedBeautifulNumber.setTenMillion(beautifulNumberEntity.getTenMillion());
        friendUnusedBeautifulNumber.setOneMillion(beautifulNumberEntity.getOneMillion());
        friendUnusedBeautifulNumber.setOneHundredThousand(beautifulNumberEntity.getOneHundredThousand());
        friendUnusedBeautifulNumber.setTenThousand(beautifulNumberEntity.getTenThousand());
        friendUnusedBeautifulNumber.setOneThousand(beautifulNumberEntity.getOneThousand());
        friendUnusedBeautifulNumber.setOneHundred(beautifulNumberEntity.getOneHundred());
        friendUnusedBeautifulNumber.setTen(beautifulNumberEntity.getTen());
        friendUnusedBeautifulNumber.setOne(beautifulNumberEntity.getOne());
        friendUnusedBeautifulNumberList = friendUnusedBeautifulNumberService.selectRecord(session, mapperbGroupMemberUsedBeautifulNumberMapper, friendUnusedBeautifulNumber);
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

    public GroupMemberUnusedBeautifulNumberReal getRegisteredGroupMemberId(){
        SqlSession session = DBTools.getSession();
        GroupMemberUnusedBeautifulNumberRealMapper mapperbFriendUnusedBeautifulNumberMapper = session.getMapper(GroupMemberUnusedBeautifulNumberRealMapper.class);
        GroupMemberUnusedBeautifulNumberRealService friendUnusedBeautifulNumberService = new GroupMemberUnusedBeautifulNumberRealService();
        List<GroupMemberUnusedBeautifulNumberReal> friendUnusedBeautifulNumberList = null;
        GroupMemberUnusedBeautifulNumberReal friendUnusedBeautifulNumber = new GroupMemberUnusedBeautifulNumberReal();
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
                GroupMemberUsedBeautifulNumberRealMapper mapperbFriendUsedBeautifulNumberMapper = session.getMapper(GroupMemberUsedBeautifulNumberRealMapper.class);
                GroupMemberUsedBeautifulNumberReal friendUsedBeautifulNumber = judgeAndGetGroupMemberId(session, mapperbFriendUsedBeautifulNumberMapper, beautifulNumberEntity);
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
                friendUnusedBeautifulNumberList = friendUnusedBeautifulNumberService.selectOnlyGroupMemberUnusedBeautifulNumberReal(session, mapperbFriendUnusedBeautifulNumberMapper);
                //commonUtils.isHave(list)
                CommonUtils<GroupMemberUnusedBeautifulNumberReal> commonUtils = new CommonUtils<>();
                if (commonUtils.isHave(friendUnusedBeautifulNumberList)){
                    friendUnusedBeautifulNumber = friendUnusedBeautifulNumberList.get(0);
                }else{
                    logger.error("群成员id号码自动派发错误，");
                }
            }
        }
        return friendUnusedBeautifulNumber;
    }

    public int getRegisteredGroupMemberIntId(){
        GroupMemberUnusedBeautifulNumberReal groupMemberUnusedBeautifulNumber = getRegisteredGroupMemberId();
        int initialNumber = groupMemberUnusedBeautifulNumber.getTenMillion() * ConstantsContent.BEAUTIFUL_NUMBER_TEN_MILLION
                + groupMemberUnusedBeautifulNumber.getOneMillion() * ConstantsContent.BEAUTIFUL_NUMBER_ONE_MILLION
                + groupMemberUnusedBeautifulNumber.getOneHundredThousand() * ConstantsContent.BEAUTIFUL_NUMBER_ONE_HUNDRED_THOUSAND
                + groupMemberUnusedBeautifulNumber.getTenThousand() * ConstantsContent.BEAUTIFUL_NUMBER_TEN_THOUSAND
                + groupMemberUnusedBeautifulNumber.getOneThousand() * ConstantsContent.BEAUTIFUL_NUMBER_ONE_THOUSAND
                + groupMemberUnusedBeautifulNumber.getOneHundred() * ConstantsContent.BEAUTIFUL_NUMBER_ONE_HUNDRED
                + groupMemberUnusedBeautifulNumber.getTen() * ConstantsContent.BEAUTIFUL_NUMBER_TEN
                + groupMemberUnusedBeautifulNumber.getOne() * ConstantsContent.BEAUTIFUL_NUMBER_ONE;
        return initialNumber;
    }

    //生成注册群成员ID
    public Integer getRegisterGroupMemberId() throws Exception {
        SqlSession sqlSession = DBTools.getSession();
        RegisteredGroupMemberMapper registeredGroupMemberMapper = sqlSession.getMapper(RegisteredGroupMemberMapper.class);
        int randomId = (int)((Math.random()*9+1)*100000);
        while (true){
            RegisteredGroupMember registeredGroupMember = registeredGroupMemberMapper.getRegisteredByGroupMemberId(randomId);
            if(null != registeredGroupMember ){
                randomId = (int)((Math.random()*9+1)*100000);
            }else {
                break;
            }
        }
        return randomId;
    }

    //生成游客群成员ID
    public Integer getGuestGroupMemberId() throws Exception {
        SqlSession sqlSession = DBTools.getSession();
        GuestGroupMemberMapper guestGroupMemberMapper = sqlSession.getMapper(GuestGroupMemberMapper.class);
        int randomId = (int)((Math.random()*9+1)*100000);
        while (true){
            GuestGroupMember guestByGroupMemberId = guestGroupMemberMapper.getGuestByGroupMemberId(randomId);
            if(null != guestByGroupMemberId ){
                randomId = (int)((Math.random()*9+1)*100000);
            }else {
                break;
            }
        }
        return randomId;
    }
}
