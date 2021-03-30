package com.lanjiu.im.grpc.server.controller;

import com.lanjiu.im.grpc.dao.mapper.impl.AutoBeautifulCheckNumberRecordMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.BeautifulNumberAutoMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.GroupMemberUnusedBeautifulNumberMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.GroupMemberUsedBeautifulNumberMapper;
import com.lanjiu.im.grpc.pojo.AutoBeautifulCheckNumberRecord;
import com.lanjiu.im.grpc.pojo.BeautifulNumberAuto;
import com.lanjiu.im.grpc.pojo.GroupMemberUnusedBeautifulNumber;
import com.lanjiu.im.grpc.pojo.GroupMemberUsedBeautifulNumber;
import com.lanjiu.im.grpc.server.entity.BeautiFulNumberConfigEntity;
import com.lanjiu.im.grpc.service.AutoBeautifulCheckNumberRecordService;
import com.lanjiu.im.grpc.service.BeautifulNumberAutoService;
import com.lanjiu.im.grpc.service.GroupMemberUnusedBeautifulNumberService;
import com.lanjiu.im.grpc.service.GroupMemberUsedBeautifulNumberService;
import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import org.apache.log4j.Logger;

/*
 *处理游客群成员自动派发表的自动补充问题.
 * */
public class AutoAddNumberToGuestGroupMemberUnused {


    private static final Logger logger = Logger.getLogger(AutoAddNumberToGuestGroupMemberUnused.class.getName());

    public BeautiFulNumberConfigEntity turnBeautifulNumberAutoAddOnce(BeautifulNumberAuto rpcBeautifulNumberCommon, SqlSession session, BeautifulNumberAutoMapper mapperbBeautifulNumberAuto){
        int number = 0;
        int nsize = 0;
        int nTime = 0;
        BeautifulNumberAuto beautifulNumberAuto = new BeautifulNumberAuto();
        BeautifulNumberAutoService beautifulNumberAutoService = new BeautifulNumberAutoService();
        BeautiFulNumberConfigEntity beautiFulNumberConfigEntity = new BeautiFulNumberConfigEntity();
        int initialNumber = rpcBeautifulNumberCommon.getTenMillion() * ConstantsContent.BEAUTIFUL_NUMBER_TEN_MILLION
                + rpcBeautifulNumberCommon.getOneMillion() * ConstantsContent.BEAUTIFUL_NUMBER_ONE_MILLION
                + rpcBeautifulNumberCommon.getOneHundredThousand() * ConstantsContent.BEAUTIFUL_NUMBER_ONE_HUNDRED_THOUSAND
                + rpcBeautifulNumberCommon.getTenThousand() * ConstantsContent.BEAUTIFUL_NUMBER_TEN_THOUSAND
                + rpcBeautifulNumberCommon.getOneThousand() * ConstantsContent.BEAUTIFUL_NUMBER_ONE_THOUSAND;
        while(nsize <= 0){
            number = initialNumber + (nTime+1) * ConstantsContent.BEAUTIFUL_NUMBER_ONCE_GET * ConstantsContent.BEAUTIFUL_NUMBER_ONE_THOUSAND;
            String nConfig = String.valueOf(number);
            //判断新的数据是否有效
            String tenMillion = nConfig.substring(0, 1);
            beautiFulNumberConfigEntity.setTenMillion(tenMillion);
            beautifulNumberAuto.setTenMillion(Integer.valueOf(tenMillion));
            String oneMillion = nConfig.substring(1, 2);
            beautiFulNumberConfigEntity.setOneMillion(oneMillion);
            beautifulNumberAuto.setOneMillion(Integer.valueOf(oneMillion));
            String oneHundredThousand = nConfig.substring(2, 3);
            beautiFulNumberConfigEntity.setOneHundredThousand(oneHundredThousand);
            beautifulNumberAuto.setOneHundredThousand(Integer.valueOf(oneHundredThousand));
            String tenThousand = nConfig.substring(3, 4);
            beautiFulNumberConfigEntity.setTenThousand(tenThousand);
            beautifulNumberAuto.setTenThousand(Integer.valueOf(tenThousand));
            String oneThousand = nConfig.substring(4, 5);
            beautiFulNumberConfigEntity.setOneThousand(oneThousand);
            beautifulNumberAuto.setOneThousand(Integer.valueOf(oneThousand));
            List<BeautifulNumberAuto> list = beautifulNumberAutoService.selectRecordByThousand(session, mapperbBeautifulNumberAuto, beautifulNumberAuto);
            if(null != list){
                nsize = list.size();
                if(nsize == 0){
                    nTime++;
                }
            }else {
                nsize = 1;
                logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
            }
            System.out.println("nsize" + nsize);
        }
        return beautiFulNumberConfigEntity;
    }

    //只有自动派发的需要自动补充，靓号不需要.
    public int turnBeautifulNumberAutoUpdateToDatabase(BeautiFulNumberConfigEntity beautiFulNumberConfigEntity, String type, SqlSession session, AutoBeautifulCheckNumberRecordMapper autoBeautifulCheckNumberRecordMapper, AutoBeautifulCheckNumberRecordService autoBeautifulCheckNumberRecordService){
        AutoBeautifulCheckNumberRecord autoBeautifulCheckNumberRecord = new AutoBeautifulCheckNumberRecord();
        autoBeautifulCheckNumberRecord.setRecordType(type);
        autoBeautifulCheckNumberRecord.setTenMillion(Integer.valueOf(beautiFulNumberConfigEntity.getTenMillion()));
        autoBeautifulCheckNumberRecord.setOneMillion(Integer.valueOf(beautiFulNumberConfigEntity.getOneMillion()));
        autoBeautifulCheckNumberRecord.setOneHundredThousand(Integer.valueOf(beautiFulNumberConfigEntity.getOneHundredThousand()));
        autoBeautifulCheckNumberRecord.setTenThousand(Integer.valueOf(beautiFulNumberConfigEntity.getTenThousand()));
        autoBeautifulCheckNumberRecord.setOneThousand(Integer.valueOf(beautiFulNumberConfigEntity.getOneThousand()));
        int nResult = autoBeautifulCheckNumberRecordService.updateAutoBeautifulCheckNumberRecord(session, autoBeautifulCheckNumberRecordMapper, autoBeautifulCheckNumberRecord);
        return nResult;
    }

    //游客群成员非靓号未使用表自动派发
    public void autoAddNumberToGuestGroupMemberUnusedTable(){
        String typeDef = ConstantsContent.BEAUTIFUL_NUMBER_TYPE_GUEST_GROUP_MEMBER;
        SqlSession session = DBTools.getSession();
        GroupMemberUnusedBeautifulNumberMapper mapperb = session.getMapper(GroupMemberUnusedBeautifulNumberMapper.class);
        //判断游客好友的未使用表中记录数是否小于最低限
        GroupMemberUnusedBeautifulNumberService groupMemberUnusedBeautifulNumberService = new GroupMemberUnusedBeautifulNumberService();
        List<GroupMemberUnusedBeautifulNumber> listGroupMemberUnusedBeautifulNumber = groupMemberUnusedBeautifulNumberService.selectAllRecords(session, mapperb);
        int nLimit = 0;
        if(null != listGroupMemberUnusedBeautifulNumber){
            nLimit = listGroupMemberUnusedBeautifulNumber.size();
        }
        if (nLimit > ConstantsContent.BEAUTIFUL_NUMBER_MIN_LIMIT){
            //未少于最小量，不用从总表取记录
            return;
        }
        //获取当前配置文件中的配置
        BeautifulNumberAuto beautifulNumberAuto = new BeautifulNumberAuto();
        AutoBeautifulCheckNumberRecordMapper autoBeautifulCheckNumberRecordMapper = session.getMapper(AutoBeautifulCheckNumberRecordMapper.class);
        AutoBeautifulCheckNumberRecordService autoBeautifulCheckNumberRecordService = new AutoBeautifulCheckNumberRecordService();
        AutoBeautifulCheckNumberRecord autoBeautifulCheckNumberRecord = new AutoBeautifulCheckNumberRecord();
        autoBeautifulCheckNumberRecord.setRecordType(typeDef);
        List<AutoBeautifulCheckNumberRecord> listCheckNumberRecord = autoBeautifulCheckNumberRecordService.selectAutoBeautifulCheckNumberRecord(session, autoBeautifulCheckNumberRecordMapper, autoBeautifulCheckNumberRecord);
        for (AutoBeautifulCheckNumberRecord checkNumberRecord : listCheckNumberRecord){
            beautifulNumberAuto.setTenMillion(checkNumberRecord.getTenMillion());
            beautifulNumberAuto.setOneMillion(checkNumberRecord.getOneMillion());
            beautifulNumberAuto.setOneHundredThousand(checkNumberRecord.getOneHundredThousand());
            beautifulNumberAuto.setTenThousand(checkNumberRecord.getTenThousand());
            beautifulNumberAuto.setOneThousand(checkNumberRecord.getOneThousand());
        }

        //从自动派发总表中查取千条数据
        BeautifulNumberAutoService beautifulNumberAutoService = new BeautifulNumberAutoService();
        BeautifulNumberAutoMapper mapperbBeautifulNumberAuto = session.getMapper(BeautifulNumberAutoMapper.class);
        List<BeautifulNumberAuto> list = beautifulNumberAutoService.selectRecordByThousand(session, mapperbBeautifulNumberAuto, beautifulNumberAuto);

        //将总表中取出数据保存到游客好友的未使用自动派发表中
        GroupMemberUsedBeautifulNumberMapper mapperbGroupMemberUsedBeautifulNumberMapper = session.getMapper(GroupMemberUsedBeautifulNumberMapper.class);
        GroupMemberUsedBeautifulNumberService groupMemberUsedBeautifulNumberService = new GroupMemberUsedBeautifulNumberService();
        GroupMemberUnusedBeautifulNumber groupMemberUnusedBeautifulNumber = new GroupMemberUnusedBeautifulNumber();
        List<GroupMemberUnusedBeautifulNumber> groupMemberUnusedBeautifulNumberList = null;
        GroupMemberUsedBeautifulNumber groupMemberUsedBeautifulNumber = new GroupMemberUsedBeautifulNumber();
        List<GroupMemberUsedBeautifulNumber> groupMemberUsedBeautifulNumberList = null;
        int nSelectUsed = 0;
        int nSelectUnused = 0;
        for (BeautifulNumberAuto iterator : list){
            groupMemberUnusedBeautifulNumber.setTenMillion(iterator.getTenMillion());
            groupMemberUnusedBeautifulNumber.setOneMillion(iterator.getOneMillion());
            groupMemberUnusedBeautifulNumber.setOneHundredThousand(iterator.getOneHundredThousand());
            groupMemberUnusedBeautifulNumber.setTenThousand(iterator.getTenThousand());
            groupMemberUnusedBeautifulNumber.setOneThousand(iterator.getOneThousand());
            groupMemberUnusedBeautifulNumber.setOneHundred(iterator.getOneHundred());
            groupMemberUnusedBeautifulNumber.setTen(iterator.getTen());
            groupMemberUnusedBeautifulNumber.setOne(iterator.getOne());
            groupMemberUnusedBeautifulNumberList = groupMemberUnusedBeautifulNumberService.selectRecord(session, mapperb, groupMemberUnusedBeautifulNumber);
            if(groupMemberUnusedBeautifulNumberList != null){
                nSelectUnused = groupMemberUnusedBeautifulNumberList.size();
                if(nSelectUnused == 0){
                    groupMemberUsedBeautifulNumber.setTenMillion(iterator.getTenMillion());
                    groupMemberUsedBeautifulNumber.setOneMillion(iterator.getOneMillion());
                    groupMemberUsedBeautifulNumber.setOneHundredThousand(iterator.getOneHundredThousand());
                    groupMemberUsedBeautifulNumber.setTenThousand(iterator.getTenThousand());
                    groupMemberUsedBeautifulNumber.setOneThousand(iterator.getOneThousand());
                    groupMemberUsedBeautifulNumber.setOneHundred(iterator.getOneHundred());
                    groupMemberUsedBeautifulNumber.setTen(iterator.getTen());
                    groupMemberUsedBeautifulNumber.setOne(iterator.getOne());
                    groupMemberUsedBeautifulNumberList = groupMemberUsedBeautifulNumberService.selectRecord(session, mapperbGroupMemberUsedBeautifulNumberMapper, groupMemberUsedBeautifulNumber);
                    if (groupMemberUsedBeautifulNumberList != null){
                        nSelectUsed = groupMemberUsedBeautifulNumberList.size();
                        if(nSelectUsed == 0){
                            groupMemberUnusedBeautifulNumberService.insertRecord(session, mapperb, groupMemberUnusedBeautifulNumber);
                        }
                    }
                }
            }
        }
        //将更新后的配置保存到库中
        BeautiFulNumberConfigEntity beautiFulNumberConfigEntity = turnBeautifulNumberAutoAddOnce(beautifulNumberAuto, session, mapperbBeautifulNumberAuto);
        turnBeautifulNumberAutoUpdateToDatabase(beautiFulNumberConfigEntity, typeDef, session, autoBeautifulCheckNumberRecordMapper, autoBeautifulCheckNumberRecordService);
    }
}
