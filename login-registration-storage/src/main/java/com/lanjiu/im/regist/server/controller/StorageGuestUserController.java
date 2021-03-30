package com.lanjiu.im.regist.server.controller;

import com.lanjiu.im.storage.pojo.GuestUserPO;
import com.lanjiu.im.storage.pojo.NumAutoGuestPO;
import com.lanjiu.im.storage.service.GuestInfoService;
import com.lanjiu.im.storage.service.GuestUserService;
import com.lanjiu.im.storage.service.OperatGuestAutoService;
import com.lanjiu.pro.login.GuestUser;

import java.util.Date;
import java.util.List;

public class StorageGuestUserController {


    public int insertUser(GuestUser guestUser){

        OperatGuestAutoService guestService = new OperatGuestAutoService();

        GuestUserPO userPO = new GuestUserPO();
        GuestUserService service = new GuestUserService();
        //TODO
        //根据规则分配号段（事务）
        //1.从未使用非靓号库捞一个；
        //2.判断已使用非靓号库是否存在该号冲突,todo
        //3.冲突则删除未使用库该号码，并重新获取一个；todo
        //4.不冲突则将号码赋予用户，并插入已使用非靓号库，同时删除未使用库该号码；
        String  autoNum = null;
        List<NumAutoGuestPO> list = guestService.getOneUnusedAutoNumber();
        autoNum = list.get(0).toString();
        guestService.insertUsedAutoNumber(list.get(0));
        guestService.deleteUnUsedAutoNumber(list.get(0));
        guestService.commit();
        guestService.close();
        userPO.setUserId(Integer.parseInt(autoNum));
        userPO.setUserAccount(autoNum);
        userPO.setDate(new Date());
        int i = service.insertUser(userPO);
        service.close();
        if(i>0){
            return Integer.parseInt(autoNum);
        }
        return i;


    }

    //删除游客个人及设置信息，释放号码；
    public int delete(int userId){
        GuestUserService service = new GuestUserService();
        GuestInfoService infoService = new GuestInfoService();

        //回收游客id号码
        OperatGuestAutoService numberService = new OperatGuestAutoService();
        NumAutoGuestPO po = new NumAutoGuestPO();
        String nConfig = String.valueOf(userId);
        int tenMillion = Integer.parseInt(nConfig.substring(0, 1));
        int oneMillion = Integer.parseInt(nConfig.substring(1, 2));
        int oneHundredThousand = Integer.parseInt(nConfig.substring(2, 3));
        int tenThousand = Integer.parseInt(nConfig.substring(3, 4));
        int oneThousand = Integer.parseInt(nConfig.substring(4, 5));
        int oneHundred = Integer.parseInt(nConfig.substring(5, 6));
        int ten = Integer.parseInt(nConfig.substring(6, 7));
        int one = Integer.parseInt(nConfig.substring(7, 8));
        po.setTenMillion(tenMillion);
        po.setOneMillion(oneMillion);
        po.setOneHundredThousand(oneHundredThousand);
        po.setTenThousand(tenThousand);
        po.setOneHundred(oneHundred);
        po.setOneThousand(oneThousand);
        po.setTen(ten);
        po.setOne(one);

        int i=0, j=0;
        try {
            i = service.deleteUser(userId);
            j = numberService.deleteUsedAutoNumber(po);
        } catch (Exception e) {
            e.printStackTrace();
        }
        service.close();
        numberService.close();
        if(i>=1  && j>=1 ){
            return 1;
        }
        return 0;
    }

    public List<GuestUserPO> getAllGuestUsr(){
        GuestUserService service = new GuestUserService();
        List<GuestUserPO> list = null;
        list = service.getAllGuestUser();
        service.close();
        return list;
    }

    public List<GuestUserPO> searchUser(String userId) {
        GuestUserService service = new GuestUserService();
        List<GuestUserPO> list = null;
        list = service.getGuestUser(Integer.parseInt(userId));
        service.close();
        return list;
    }
}
