package com.lanjiu.im.regist.server.controller;

import com.lanjiu.im.storage.pojo.BueautifulNumberPO;
import com.lanjiu.im.storage.pojo.RegisterUserPO;
import com.lanjiu.im.storage.service.OperatAutoNumService;
import com.lanjiu.im.storage.service.RegisterUserService;
import com.lanjiu.pro.login.RegisterUser;

import java.util.Date;
import java.util.List;

public class StorageRegisterUserController {

    public int storageRegistUser(RegisterUser registerUser) {
        RegisterUserService userService = new RegisterUserService();
        OperatAutoNumService numService = new OperatAutoNumService();
        RegisterUserPO user = new RegisterUserPO();
        //TODO
        //根据规则分配号段（事务）
        //1.从未使用非靓号库捞一个；
        //2.判断已使用非靓号库是否存在该号冲突,
        //3.冲突则删除未使用库该号码，并重新获取一个；
        //4.不冲突则将号码赋予用户，并插入已使用非靓号库，同时删除未使用库该号码；
        String  autoNum = null;
        try {
            List<BueautifulNumberPO> list =numService.getOneUnusedAutoNumber();
            autoNum = list.get(0).toString();
            if(list.size()>0){
                    numService.insertUsedAutoNumber(list.get(0));
                    numService.deleteUsedAutoNumber(list.get(0));
                    numService.commit();
                    numService.close();
            }
            numService.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            numService.rollback();
            numService.close();
        }

        user.setUserId(Integer.parseInt(autoNum));
        user.setPassword(registerUser.getPassword());
        user.setUserAcount(autoNum);
        user.setPhone(registerUser.getPhone());
        Date currentTime = new Date();
        user.setDate(currentTime);  //设置为服务器时间

        int i =userService.insertUser(user);
        userService.close();
        if(i>0){
            return Integer.parseInt(autoNum);
        }
        return i;
    }

    public int delete(int usrId){
        RegisterUserService userService = new RegisterUserService();
        int i = userService.deleteUser(usrId);
        userService.close();
        return  i;
    }

    public int updateUser(RegisterUser registerUser){
        RegisterUserService userService = new RegisterUserService();
        RegisterUserPO po = new RegisterUserPO();
        po.setUserId(Integer.parseInt(registerUser.getUserId()));
        po.setPhone(registerUser.getPhone());
        po.setPassword(registerUser.getPassword());
        int i = userService.updateUser(po);
        return i;
    }

    public int loginRegist(RegisterUser registerUser) {
        RegisterUserService userService = new RegisterUserService();
        String pass = registerUser.getPassword();
        String number = userService.getUserPass(registerUser.getUserId());
        userService.close();
        if(pass.equals(number)){

            return 1;
        }
        return 0;
    }

    public List<RegisterUserPO> searchUser(String userId) {
        RegisterUserService service = new RegisterUserService();
        List<RegisterUserPO> registerUserList = service.searchUser(Integer.parseInt(userId));
        service.close();
        return registerUserList;
    }

    public RegisterUserPO getUserByPhone(String phone) {
        RegisterUserService service = new RegisterUserService();
        RegisterUserPO user =service.getUserByPhone(phone);
        service.close();
        return user;
    }
}
