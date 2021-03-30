package com.lanjiu.im.storage.test;

import com.lanjiu.im.storage.pojo.RegisterUserPO;
import com.lanjiu.im.storage.pojo.UserDevice;
import com.lanjiu.im.storage.service.RegisterUserService;
import com.lanjiu.im.storage.service.UserInfomationService;
import com.lanjiu.pro.login.RequestDeviceUpdate;

import java.util.List;

public class TestGuestUserService {

    public static RegisterUserService service = new RegisterUserService();

//    public static GuestUserService guestService = new GuestUserService();

    //    public static OperatAutoNumService autoService = new OperatAutoNumService();
//
//    public static GuestAutoNumService guestAutoNumService = new GuestAutoNumService();
//
//    public static UserInfomationService infoService = new UserInfomationService();
//    public static GuestInfoService guestInfoService  = new GuestInfoService();


    public static void main(String[] args) {

//        RequestD eviceUpdate requestDeviceUpdate = service.insertUserDevice("10010198", "abcd", "huawei");
//        System.out.println(requestDeviceUpdate.getPushToken());
        UserDevice userDevice = service.selectUserDevice("10010190");
        System.out.println(userDevice.getPush_token());





//        RegisterUserPO userByPhone = service.getUserByPhone("18165216675");
//        List<RegisterUserPO> list = service.searchUser(20011716);
//        System.out.println(list);
//        System.out.println(userByPhone);
//        System.out.println(userByPhone.getPhone());



//        VersionPO newVersion = guestService.getNewVersion();
//        System.out.println(newVersion.getVersionCode());

//        int userId=10020010;
//        for (int i = 0; i <1 ; i++) {
//            int temp =userId+i;
//            RegisterUserPO registerUser =  new RegisterUserPO();
//
//            registerUser.setUserId(temp);
//            registerUser.setUserAcount(temp+"");
//            registerUser.setPassword("FVU84okkYXU=");
//            registerUser.setDate(new Date());
//            int res = service.insertUser(registerUser);
//            System.out.println(res+i);
//        }

//        String userPass = service.getUserPass("10020010");
//        System.out.println(userPass);

//        for (int i = 0; i <300 ; i++) {
//            int temp = userId+i;
//            UserInfomationPO userInfoPO  = new UserInfomationPO();
//            userInfoPO.setUserId(temp);
//            userInfoPO.setNickname(""+temp);
//            userInfoPO.setTimerClean(1);
//            userInfoPO.setOnlineStatus("OUT");
//            userInfoPO.setExitClean("OFF");
////            userInfoPO.setModificationTime(new Date());
//            int j = infoService.updateUserInfo(userInfoPO);
//            System.out.println(j+i);
//        }


//        UserInfomationPO userInfoPO  = new UserInfomationPO();
//        userInfoPO.setUserId(007);
//        userInfoPO.setNickname("凌凌漆");
//        userInfoPO.setTimerClean(0);
//        userInfoPO.setOnlineStatus("1");
//        userInfoPO.setExitClean("OFF");
//        String cron = "0 0 2 0/3 * ?";
//        userInfoPO.setModificationTime(new Date());
//        int j = infoService.insertUserInfo(userInfoPO);
////        int i = infoService.updateUserInfo(userInfoPO);
//        System.out.println(j);
//        List<UserInfomationPO> usrInfo= infoService.getUsrInfomation(7);
//        System.out.println(usrInfo.get(0).getExitClean());

//        List<RegisterUserPO> registerUserPOList = service.searchUser(10010128);
//        System.out.println(registerUserPOList.get(0).getPhone());
//        System.out.println(registerUserPOList.get(0).getDate());

//        GuestUserPO guestUserPO = new GuestUserPO();
//        guestUserPO.setUserId(1);
//        guestUserPO.setDate(new Date());
//        RegisterUserPO registerUser =  new RegisterUserPO();
//        registerUser.setUserId(0);
//        registerUser.setPassword("4123");
//        registerUser.setPhone(null);
//        int j = service.updateUser(registerUser);
//        service.close();
//        System.out.println(j);
//        GuestAutoNumService numService = new GuestAutoNumService();
//        AutoRecordNumPO po = new AutoRecordNumPO();
//        RegistAutoNumService numService = new RegistAutoNumService();
//        po.setTenMillion(1);
//        po.setOneMillion(0);
//        po.setOneHundredThousand(0);
//        po.setTenThousand(2);
//        po.setOneThousand(0);
//        po.setRecordType("AUTO_REGIST");

//        NumAutoGuestPO npo = new NumAutoGuestPO();
//        npo.setTenMillion(1);
//        npo.setOneMillion(0);
//        npo.setOneHundredThousand(0);
//        npo.setTenThousand(2);
//        npo.setOneThousand(0);
//        npo.setOneHundred(1);
//        npo.setTen(1);
//        npo.setOne(1);
//        List<NumAutoGuestPO> list = new ArrayList<>();
//        list.add(npo);
//        int i = guestAutoNumService.insertUsedAutoNum(list);
//        System.out.println(i);
//        guestAutoNumService.commit();

//        List<BueautifulNumberPO> list = service.exportNmber(0,1);
//        System.out.println(list);
//        int i = service.selectMinNumber();
//        System.out.println(i);
//        int j = service.insertBatch(list);
//        System.out.println(j);
//        List<BueautifulNumberPO> list = autoService.getOneUnusedAutoNumber();
//        System.out.println(list);
//         List<BueautifulNumberPO> list = new ArrayList<>();
//         list.add(po);
//
//        System.out.println(list.get(0).toString());
//        System.out.println(list.get(0).toString().length());

//         int i =autoService.insertUsedAutoNumber(po);
//         int j = autoService.deleteUsedAutoNumber(po);

//            String pass = service.getUserPass("6");
//        System.out.println(pass);
//        List<NumAutoGuestPO> list =new ArrayList<>();
//        list.add(po);
//       int i = numService.insertUsedAutoNum(list);
//        System.out.println(list);

//        List<NumAutoGuestPO> num = numService.getAutoNumByThousand(po);
//        System.out.println(num);
//        int auto_regist = numService.insertNewRecord(po);
//        System.out.println(auto_regist);


        //个人信息设置
//        UserInfomationPO po = new UserInfomationPO();
//        po.setUserId(6);
////        po.setAvatar("lalala");
//        po.setNickname("lalala");
//        po.setOfflineMessageSetting(true);
//        po.setOnlineStatus(false);
////        po.setBurnAfterReadingSetting(true);
//        po.setBurnAfterReadingTimeUnit(0);
//        po.setBurnAfterReadingTimeLength(30);
////        int j = infoService.updateUserInfo(po);
//        int j = infoService.updateUserInfo(po);
//        System.out.println(j);
//        List<UserInfomationPO> usrInfomation = infoService.getUsrInfomation(1);
//        System.out.println(usrInfomation.get(0));
//        int i= infoService.insertUserInfo(po);
//        System.out.println(i);

//        List<RegisterUserPO> list = service.searchUser(1001004);
//        List<RegisterUserPO> list = service.selectAllUser();

//          List<UserInfomationPO>  list = infoService.getUsrInfomation(1);
//        System.out.println(list.size());
//        List<GuestUserPO> list = guestService.getGuestUser(1);
//        System.out.println(list.size());
//        GuestUserInfoPO po = new GuestUserInfoPO();
//        po.setAvatar("lili");
//        po.setUserId(1);
//        int i = guestInfoService.updateUserInfo(po);
//        System.out.println(i);


    }

}
