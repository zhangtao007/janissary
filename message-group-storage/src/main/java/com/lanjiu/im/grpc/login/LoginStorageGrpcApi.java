package com.lanjiu.im.grpc.login;


import com.lanjiu.pro.login.RegisterStorageProto;
import com.lanjiu.pro.login.RegisterStorageServiceGrpc;

import java.util.logging.Logger;

public class LoginStorageGrpcApi {

    private static final Logger log = Logger.getLogger(LoginStorageGrpcApi.class.getName());

    private static RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub getInstance(){
        return RegisterLoginClient.linkTransferCommunication();
    }

    public RegisterStorageProto.ResponseUser selectUserInformation(RegisterStorageProto.RequestUser request) {
        RegisterStorageProto.ResponseUser responseUser = getInstance().selectUserInfomation(request);
        try {
            RegisterLoginClient.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return responseUser;
    }

    public RegisterStorageProto.ResponseUser selectGuestUserInfo(RegisterStorageProto.RequestUser request) {
        RegisterStorageProto.ResponseUser responseUser = getInstance().selectGuestUserInfo(request);
        try {
            RegisterLoginClient.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return responseUser;
    }

}
