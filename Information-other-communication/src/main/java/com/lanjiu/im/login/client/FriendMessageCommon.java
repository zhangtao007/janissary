package com.lanjiu.im.login.client;

import com.lanjiu.pro.login.RegisterStorageServiceGrpc;
import com.lanjiu.pro.login.RequestUser;
import com.lanjiu.pro.login.ResponseUser;

public class FriendMessageCommon {

    public static RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub blockingStub = null;
    public static  RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub FriendMessageCommon(){
        RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub stub = RegistLoginServer.transformStorageCommunition(blockingStub);
        return stub;
    }


    public ResponseUser storageRegisterUser(RequestUser request) {
        blockingStub =FriendMessageCommon();
        ResponseUser response = null;
        response = blockingStub.storageRegisterUser(request);
        try {
            RegistLoginServer.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser storageUserInfomation(RequestUser request) {
        blockingStub =FriendMessageCommon();
        ResponseUser response = null;
        response = blockingStub.storageUserInfomation(request);
        try {
            RegistLoginServer.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser storageGuestUserInfo(RequestUser request) {
        blockingStub =FriendMessageCommon();
        ResponseUser response = null;
        response = blockingStub.storageGuestUserInfo(request);
        try {
            RegistLoginServer.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser loginRegistUser(RequestUser request) {
        blockingStub =FriendMessageCommon();
        ResponseUser response = null;
        response = blockingStub.loginRegistUser(request);
        try {
            RegistLoginServer.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser loginGuestUser(RequestUser request) {
        blockingStub =FriendMessageCommon();
        ResponseUser response = null;
        response = blockingStub.loginGuestUser(request);
        try {
            RegistLoginServer.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser logoutRegistUser(RequestUser request) {
        blockingStub =FriendMessageCommon();
        ResponseUser response = null;
        response = blockingStub.logoutRegistUser(request);
        try {
            RegistLoginServer.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser logoutGuestUser(RequestUser request) {
        blockingStub =FriendMessageCommon();
        ResponseUser response = null;
        response = blockingStub.logoutGuestUser(request);
        try {
            RegistLoginServer.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser selectUserInfomation(RequestUser request) {
        blockingStub =FriendMessageCommon();
        ResponseUser response = null;
        response = blockingStub.selectUserInfomation(request);
        try {
            RegistLoginServer.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseUser selectGuestUserInfo(RequestUser request) {
        blockingStub =FriendMessageCommon();
        ResponseUser response = null;
        response = blockingStub.selectGuestUserInfo(request);
        try {
            RegistLoginServer.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

//    public com.lanjiu.im.storage.ResponseUser selectRegisterUser(com.lanjiu.im.storage.RequestUser request) {
//
//    }

//    public com.lanjiu.im.storage.ResponseUser selectGuestUser(com.lanjiu.im.storage.RequestUser request) {
//
//    }



}
