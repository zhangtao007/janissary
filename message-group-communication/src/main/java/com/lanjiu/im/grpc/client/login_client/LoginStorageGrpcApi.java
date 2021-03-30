package com.lanjiu.im.grpc.client.login_client;


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

    public com.lanjiu.pro.login.RegisterStorageProto.RequestUserDevice updateUserDevice(com.lanjiu.pro.login.RegisterStorageProto.RequestUserDevice request) {
        RegisterStorageProto.RequestUserDevice responseUser = getInstance().updateUserDevice(request);
        try {
            RegisterLoginClient.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return responseUser;
    }




}
