package com.lanjiu.im.grpc.login;

import com.lanjiu.pro.login.RegisterStorageServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class RegisterLoginClient {

    private static final Logger log = Logger.getLogger(RegisterLoginClient.class.getName());

    private static ManagedChannel managedChannel = null;

    private static RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub serviceBlockingStub = null;

    private RegisterLoginClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
    }

    private RegisterLoginClient(ManagedChannel channel) {
        managedChannel = channel;
        serviceBlockingStub = RegisterStorageServiceGrpc.newBlockingStub(channel);
    }

    public static RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub linkTransferCommunication(){
        PropertyConf propertyConf = new PropertyConf("/login_regist_storage.properties");
        String address = propertyConf.getValue("server_address");
        int port = Integer.valueOf(propertyConf.getValue("server_port"));
        new RegisterLoginClient(address, port);
        return serviceBlockingStub;
    }

    public static void shutdownNow(){
        managedChannel.shutdownNow();
    }

    public static void shutdown() throws InterruptedException {
        managedChannel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
    }
}
