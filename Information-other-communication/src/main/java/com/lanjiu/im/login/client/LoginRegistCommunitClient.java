package com.lanjiu.im.login.client;

import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.login.RegisterStorageServiceGrpc;
import com.lanjiu.pro.login.RequestUser;
import com.lanjiu.pro.login.ResponseUser;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;






public class LoginRegistCommunitClient {

    private static final Logger logger = Logger.getLogger(LoginRegistCommunitClient.class.getName());

    private static ManagedChannel managedChannel = null;

    private static RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub blockingStub = null;


    /** Construct server connecting to HelloWorld server at {@code host:port}. */
    public LoginRegistCommunitClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct server for accessing HelloWorld server using the existing channel. */
    LoginRegistCommunitClient(ManagedChannel channel) {
        this.managedChannel = channel;
        blockingStub = RegisterStorageServiceGrpc.newBlockingStub(channel);
    }
    public static void shutdown() throws InterruptedException {
        managedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
//    public static void main(String[] args) throws InterruptedException {
//        registRegisterUser();
//    }


    //用户注册
    public ResponseUser registRegisterUser(BusinessProtocolEntities.RegisteredUser builder) {
        RegisterCommon  registerCommon = new RegisterCommon();
        return registerCommon.createRegistUser(blockingStub,builder);
    }

    //注册用户登录
    public ResponseUser loginRegisterUser(BusinessProtocolEntities.RegisteredUser builder) {
        RegisterCommon  registerCommon = new RegisterCommon();
        //调用资料和其他服务器，修改用户状态
        //TODO
        return registerCommon.loginRegist(blockingStub,builder);

    }

    //游客登录
    public ResponseUser loginGuestUser(BusinessProtocolEntities.TouristsUser tourists) {
        RegisterCommon  registerCommon = new RegisterCommon();
        //调用资料和其他服务器，修改用户状态
        //TODO
        ResponseUser responseUser = registerCommon.loginGuest(blockingStub,tourists);
        return  responseUser;
    }

    //注册用户退出
    public void logoutRegistUser(RequestUser request, StreamObserver<ResponseUser> responseObserver) {
        //修改用户状态，主动调用资料和其他服务器修改用户状态
        //TODO

    }


    //游客退出
    public void logoutGuestUser(RequestUser request, StreamObserver<ResponseUser> responseObserver) {
        //删除游客信息，调用资料和其他服务器
        //TODO
    }


    //获取注册用户个人相关资料信息
    public ResponseUser selectUserInfomation(BusinessProtocolEntities.RegisteredUser request){
        RegisterCommon  registerCommon = new RegisterCommon();
        return registerCommon.selectUserInfo(blockingStub,request);

    }


    //获取游客相关个人资料信息
    public ResponseUser selectGuestUserInfo(BusinessProtocolEntities.TouristsUser request){
        RegisterCommon  registerCommon = new RegisterCommon();
        return registerCommon.selectGuestUserInfo(blockingStub,request);
    }






    public static void shutdownNow() throws InterruptedException {
        managedChannel.shutdownNow();
    }



}
