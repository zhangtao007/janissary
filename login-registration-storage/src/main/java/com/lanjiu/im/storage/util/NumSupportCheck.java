package com.lanjiu.im.storage.util;

import com.lanjiu.im.regist.utils.ConstType;
import com.lanjiu.im.storage.pojo.AutoRecordNumPO;
import com.lanjiu.im.storage.pojo.NumAutoRegistPO;
import com.lanjiu.im.storage.service.RegistAutoNumService;

import java.util.List;
import java.util.logging.Logger;

public class NumSupportCheck {

    private  static  final Logger logger = Logger.getLogger(NumSupportCheck.class.getName());
    public RegistAutoNumService autoService = new RegistAutoNumService();


    public void autoSupportNumber(int minNum,int everyNum) {

        //1.定时判断未使用靓号表[2开头号码]中数据量，是否小于200条
        //2.若小于200条，从记录表获取记录的数据位
        //3.根据数据位到总表批量捞取1000条数据
        //4.将数据插入到未使用表，
        //5.将记录表的数据位更新。


        try {
            int min = autoService.getUnusedAutoNum();
            if (min < minNum) {
                AutoRecordNumPO record = autoService.getRecordNum(ConstType.AUTO_REGIST);
                NumAutoRegistPO numAutoRegistPO = new NumAutoRegistPO();
                numAutoRegistPO.setTenMillion(record.getTenMillion());
                numAutoRegistPO.setOneMillion(record.getOneMillion());
                numAutoRegistPO.setOneHundredThousand(record.getOneHundredThousand());
                numAutoRegistPO.setTenThousand(record.getTenThousand());
                numAutoRegistPO.setOneThousand(record.getOneThousand());
                List<NumAutoRegistPO> list = autoService.getAutoNumByThousand(numAutoRegistPO);
                int j = autoService.insertUsedAutoNum(list);
                int initialNumber = record.getTenMillion() * ConstType.BEAUTIFUL_NUMBER_TEN_MILLION + record.getOneMillion() * ConstType.BEAUTIFUL_NUMBER_ONE_MILLION
                        + record.getOneHundredThousand() * ConstType.BEAUTIFUL_NUMBER_ONE_HUNDRED_THOUSAND + record.getTenThousand() * ConstType.BEAUTIFUL_NUMBER_TEN_THOUSAND
                        + record.getOneThousand() * ConstType.BEAUTIFUL_NUMBER_ONE_THOUSAND;

                NumAutoRegistPO  numAuto = checkNumRecord(initialNumber);

                updateRecord(numAuto);

            }


            autoService.commit();
            autoService.close();
        } catch (Exception e) {
            logger.info("error number supplement :号码自动补充发生错误");
            autoService.rollback();
            autoService.close();
        }
    }

    private void updateRecord(NumAutoRegistPO numAuto) {

        AutoRecordNumPO autoRecordNumPO = new AutoRecordNumPO();
        autoRecordNumPO.setRecordType(ConstType.AUTO_REGIST);
        autoRecordNumPO.setTenMillion(numAuto.getTenMillion());
        autoRecordNumPO.setOneMillion(numAuto.getOneMillion());
        autoRecordNumPO.setOneHundredThousand(numAuto.getOneHundredThousand());
        autoRecordNumPO.setTenThousand(numAuto.getTenThousand());
        autoRecordNumPO.setOneThousand(numAuto.getOneThousand());
        autoService.insertNewRecord(autoRecordNumPO);


    }

    public NumAutoRegistPO checkNumRecord(int initialNumber) {

        int nsize = 0;
        int nTime = 0;
        int number = 0;

        NumAutoRegistPO numAutoRegistPO = new NumAutoRegistPO();
        while(nsize <= 0) {
            number = initialNumber + (nTime + 1) * ConstType.BEAUTIFUL_NUMBER_ONCE_GET * ConstType.BEAUTIFUL_NUMBER_ONE_THOUSAND;
            String nConfig = String.valueOf(number);
            int tenMillion = Integer.parseInt(nConfig.substring(0, 1));
            int oneMillion = Integer.parseInt(nConfig.substring(1, 2));
            int oneHundredThousand = Integer.parseInt(nConfig.substring(2, 3));
            int tenThousand = Integer.parseInt(nConfig.substring(3, 4));
            int oneThousand = Integer.parseInt(nConfig.substring(4, 5));
            numAutoRegistPO.setTenMillion(tenMillion);
            numAutoRegistPO.setOneMillion(oneMillion);
            numAutoRegistPO.setOneHundredThousand(oneHundredThousand);
            numAutoRegistPO.setTenThousand(tenThousand);
            numAutoRegistPO.setOneThousand(oneThousand);
//            autoRecordNumPO.setTenMillion(tenMillion);
//            autoRecordNumPO.setOneMillion(oneMillion);
//            autoRecordNumPO.setOneHundredThousand(oneHundredThousand);
//            autoRecordNumPO.setTenThousand(tenThousand);
//            autoRecordNumPO.setOneThousand(oneThousand);
            List<NumAutoRegistPO> list =autoService.getAutoNumByThousand(numAutoRegistPO);
            if(null != list){
                nsize = list.size();
                if(nsize == 0){
                    nTime++;
                }
            }else {
                nsize = 1;
                logger.info("数据库状态不正常，数据查询失败，请确认.");
            }

        }
        return numAutoRegistPO;
    }



}

