package com.lanjiu.im.grpc.client.login_regist;

import com.lanjiu.im.grpc.utils.PropertyConf;
import com.lanjiu.pro.login.RegisterStorageServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class LoginRegistStorageClient {

    private static final Logger logger = Logger.getLogger(LoginRegistStorageClient.class.getName());

    private static ManagedChannel managedChannel = null;

    private static RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub blockingStub = null;


    /** Construct server connecting to HelloWorld server at {@code host:port}. */
    public LoginRegistStorageClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct server for accessing HelloWorld server using the existing channel. */
    LoginRegistStorageClient(ManagedChannel channel) {
        this.managedChannel = channel;
        blockingStub = RegisterStorageServiceGrpc.newBlockingStub(channel);
    }
    public static void shutdown() throws InterruptedException {
        managedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


    public static RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub transformStorageCommunition(RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub blockingStub){
        PropertyConf propertyConf = new PropertyConf("/login_regist_storage.properties");
        String address = propertyConf.getValue("server_address");
        int port = Integer.valueOf(propertyConf.getValue("server_port"));
        LoginRegistStorageClient client = new LoginRegistStorageClient(address, port);
        blockingStub = client.blockingStub;
        return blockingStub;
    }

    public static void shutdownNow() throws InterruptedException {
        managedChannel.shutdownNow();
    }

}
