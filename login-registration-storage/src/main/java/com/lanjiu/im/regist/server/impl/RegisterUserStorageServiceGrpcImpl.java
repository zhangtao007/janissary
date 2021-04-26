package com.lanjiu.im.regist.server.impl;


import com.lanjiu.im.regist.server.loginRegistStorageAPI.GuestUserAPI;
import com.lanjiu.im.regist.server.loginRegistStorageAPI.RegistUserAPI;
import com.lanjiu.pro.login.*;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterUserStorageServiceGrpcImpl extends RegisterStorageServiceGrpc.RegisterStorageServiceImplBase{

    private static  final Logger logger = LoggerFactory.getLogger(RegisterUserStorageServiceGrpcImpl.class);

    //注冊用戶
    @Override
    public void storageRegisterUser(RequestUser requestUser, StreamObserver<ResponseUser> responseObserver){
        RegistUserAPI registUserAPI = new RegistUserAPI();
        ResponseUser responseUser = registUserAPI.storageRegisterUser(requestUser);
        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();

    }

    //游客登录
    @Override
    public void loginGuestUser(RequestUser requestUser, StreamObserver<ResponseUser> responseObserver){
        GuestUserAPI guestUserAPI = new GuestUserAPI();
        ResponseUser responseUser = guestUserAPI.loginGuestUser(requestUser);
        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();

    }

    //註冊用户设置信息保存
    @Override
    public void storageUserInfomation(RequestUser requestUser, StreamObserver<ResponseUser> responseObserver){
        RegistUserAPI registUserAPI = new RegistUserAPI();
        ResponseUser responseUser = registUserAPI.storageUserInfomation(requestUser);
        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();

    }

    //遊客個人信息設置
    @Override
    public void storageGuestUserInfo(RequestUser requestUser, StreamObserver<ResponseUser> responseObserver) {
        GuestUserAPI guestUserAPI = new GuestUserAPI();
        ResponseUser responseUser = guestUserAPI.storageGuestUserInfo(requestUser);
        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();
    }

    //註冊用戶個人設置信息獲取
    @Override
    public void selectUserInfomation(RequestUser requestUser,
                                     io.grpc.stub.StreamObserver<ResponseUser> responseObserver) {
        logger.info("info:"+requestUser.getRegisterUser().toString());
        RegistUserAPI registUserAPI = new RegistUserAPI();
        ResponseUser responseUser = registUserAPI.selectUserInfomation(requestUser);
        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();
    }

    //遊客個人設置信息獲取
    @Override
    public void selectGuestUserInfo(RequestUser requestUser,
                                    io.grpc.stub.StreamObserver<ResponseUser> responseObserver) {
        GuestUserAPI guestUserAPI = new GuestUserAPI();
        ResponseUser responseUser = guestUserAPI.selectGuestUserInfo(requestUser);
        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();
    }


    //用户设置信息更改
    @Override
    public void updateUserInfomation(RequestUser requestUser, StreamObserver<ResponseUser> responseObserver){
        RegistUserAPI registUserAPI = new RegistUserAPI();
        ResponseUser responseUser = registUserAPI.updateUserInfomation(requestUser);
        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();

    }

    //修改遊客個人設置信息
    @Override
    public void updateGuestUserInfo(RequestUser request,
                                    io.grpc.stub.StreamObserver<ResponseUser> responseObserver) {
        GuestUserAPI guestUserAPI = new GuestUserAPI();
        ResponseUser responseUser = guestUserAPI.updateGuestUserInfo(request);
        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();

    }

    //注冊用戶登录
    @Override
    public void loginRegistUser(RequestUser requestUser,StreamObserver<ResponseUser> responseObserver) {
        RegistUserAPI registUserAPI = new RegistUserAPI();
        ResponseUser responseUser = registUserAPI.loginRegistUser(requestUser);
        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();

    }

    //游客退出
    @Override
    public void logoutGuestUser(RequestUser requestUser,
                                io.grpc.stub.StreamObserver<ResponseUser> responseObserver) {
        GuestUserAPI guestUserAPI = new GuestUserAPI();
        ResponseUser responseUser = guestUserAPI.LogoutGuestUser(requestUser);
        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();
    }

    //注册用户退出
    @Override
    public void logoutRegistUser(RequestUser requestUser,
                                 io.grpc.stub.StreamObserver<ResponseUser> responseObserver) {
        RegistUserAPI registUserAPI = new RegistUserAPI();
        ResponseUser responseUser = registUserAPI.logoutRegistUser(requestUser);
        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();
    }


    //版本检查
    @Override
    public void checkAPPVersion(com.lanjiu.pro.login.CheckForUpdatesProtocol request,
                                io.grpc.stub.StreamObserver<com.lanjiu.pro.login.CheckForUpdatesProtocol> responseObserver) {
        RegistUserAPI registUserAPI = new RegistUserAPI();
        CheckForUpdatesProtocol checkForUpdatesProtocol = registUserAPI.checkAPPVersion(request);
        responseObserver.onNext(checkForUpdatesProtocol);
        responseObserver.onCompleted();
    }

    @Override
    public void updateUserDevice(com.lanjiu.pro.login.RequestUserDevice request,
                                 io.grpc.stub.StreamObserver<com.lanjiu.pro.login.RequestUserDevice> responseObserver) {
        RegistUserAPI registUserAPI = new RegistUserAPI();
        RequestUserDevice response = registUserAPI.updateUserDevice(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
