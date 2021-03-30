package com.lanjiu.im.login.client;

import com.lanjiu.im.login.client.util.CommonUtil;
import com.lanjiu.im.login.client.util.ConstType;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.login.*;

import java.util.logging.Logger;

public class RegisterCommon {

    private static  final Logger logger = Logger.getLogger(RegisterCommon.class.getName());


    public ResponseUser createRegistUser(RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub blockingStub, BusinessProtocolEntities.RegisteredUser builder) {
        logger.info("start  createRegistUser");
        RequestUser request = null;
        String password = CommonUtil.password(builder.getSecret());
        String phone = builder.getPhone();

        request = RequestUser.newBuilder().setUserType(ConstType.REGISTERUSER)
                .setRegisterUser(RegisterUser.newBuilder().setPassword(password).setPhone(phone)).build();

        return  blockingStub.storageRegisterUser(request);


    }


    public ResponseUser loginRegist(RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub blockingStub, BusinessProtocolEntities.RegisteredUser builder) {
        logger.info("registUser  login");
        String userId = builder.getUserId();
        String password = CommonUtil.password(builder.getSecret());
        RequestUser request = null;
        request = RequestUser.newBuilder().setUserType(ConstType.REGISTERUSER)
                .setRegisterUser(RegisterUser.newBuilder().setUserId(userId).setUserAccount(userId).setPassword(password)).build();


        ResponseUser responseUser = blockingStub.loginRegistUser(request);
        return responseUser;
    }

    public ResponseUser loginGuest(RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub blockingStub, BusinessProtocolEntities.TouristsUser tourists) {
        RequestUser request = null;
        request = RequestUser.newBuilder().setUserType(ConstType.GUESTUSER).build();
        return blockingStub.loginGuestUser(request);
    }

    //获取个人信息
    public ResponseUser selectUserInfo(RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub blockingStub, BusinessProtocolEntities.RegisteredUser registUser) {
        RequestUser requestUser = null;
        //注意此处上层交互协议中实体RegisteredUser，转换成内部RegisterUser.
        requestUser = RequestUser.newBuilder().setUserType(ConstType.REGISTERUSER)
                .setRegisterUser(RegisterUser.newBuilder().setUserId(registUser.getUserId())).build();



        return blockingStub.selectUserInfomation(requestUser);
    }

    //获取游客个人信息
    public ResponseUser selectGuestUserInfo(RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub blockingStub, BusinessProtocolEntities.TouristsUser tourists) {
        RequestUser requestUser = null;
        //注意此处上层交互协议中实体RegisteredUser，转换成内部RegisterUser.
        requestUser = RequestUser.newBuilder().setUserType(ConstType.REGISTERUSER)
                .setGuestUser(GuestUser.newBuilder().setUserId(tourists.getTemporaryId())).build();



        return blockingStub.selectUserInfomation(requestUser);
    }
}
