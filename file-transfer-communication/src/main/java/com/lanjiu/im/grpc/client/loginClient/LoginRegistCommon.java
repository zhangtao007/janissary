package com.lanjiu.im.grpc.client.loginClient;


import com.lanjiu.pro.login.RegisterStorageServiceGrpc;
import com.lanjiu.pro.login.RequestUser;
import com.lanjiu.pro.login.ResponseUser;

public class LoginRegistCommon {

    public static RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub blockingStub = null;
    public static  RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub LoginRegistCommon(){
        RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub stub = RegistLoginClient.transformStorageCommunition(blockingStub);
        return stub;
    }


    public ResponseUser storageRegisterUser(RequestUser request) {
        blockingStub =LoginRegistCommon();
        ResponseUser response = null;
        response = blockingStub.storageRegisterUser(request);
        try {
            RegistLoginClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser storageUserInfomation(RequestUser request) {
        blockingStub =LoginRegistCommon();
        ResponseUser response = null;
        response = blockingStub.storageUserInfomation(request);
        try {
            RegistLoginClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser storageGuestUserInfo(RequestUser request) {
        blockingStub =LoginRegistCommon();
        ResponseUser response = null;
        response = blockingStub.storageGuestUserInfo(request);
        try {
            RegistLoginClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser loginRegistUser(RequestUser request) {
        blockingStub =LoginRegistCommon();
        ResponseUser response = null;
        response = blockingStub.loginRegistUser(request);
        try {
            RegistLoginClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser loginGuestUser(RequestUser request) {
        blockingStub =LoginRegistCommon();
        ResponseUser response = null;
        response = blockingStub.loginGuestUser(request);
        try {
            RegistLoginClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser logoutRegistUser(RequestUser request) {
        blockingStub =LoginRegistCommon();
        ResponseUser response = null;
        response = blockingStub.logoutRegistUser(request);
        try {
            RegistLoginClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser logoutGuestUser(RequestUser request) {
        blockingStub =LoginRegistCommon();
        ResponseUser response = null;
        response = blockingStub.logoutGuestUser(request);
        try {
            RegistLoginClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser selectUserInfomation(RequestUser request) {
        blockingStub =LoginRegistCommon();
        ResponseUser response = null;
        response = blockingStub.selectUserInfomation(request);
        try {
            RegistLoginClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser selectGuestUserInfo(RequestUser request) {
        blockingStub =LoginRegistCommon();
        ResponseUser response = null;
        response = blockingStub.selectGuestUserInfo(request);
        try {

            RegistLoginClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser updateUserInfomation(RequestUser request) {
        blockingStub =LoginRegistCommon();
        ResponseUser response = null;
        response = blockingStub.updateUserInfomation(request);
        try {

            RegistLoginClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser updateGuestUserInfo(RequestUser request) {
        blockingStub =LoginRegistCommon();
        ResponseUser response = null;
        response = blockingStub.updateGuestUserInfo(request);
        try {

            RegistLoginClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }




}
