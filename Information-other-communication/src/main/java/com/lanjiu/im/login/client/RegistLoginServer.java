package com.lanjiu.im.login.client;

import com.lanjiu.im.login.client.util.ConfigFileOperation;
import com.lanjiu.pro.login.RegisterStorageServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class RegistLoginServer {

    private static final Logger logger = Logger.getLogger(RegistLoginServer.class.getName());

    private static ManagedChannel managedChannel = null;

    private static RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub blockingStub = null;


    /** Construct server connecting to HelloWorld server at {@code host:port}. */
    public RegistLoginServer(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct server for accessing HelloWorld server using the existing channel. */
    RegistLoginServer(ManagedChannel channel) {
        this.managedChannel = channel;
        blockingStub = RegisterStorageServiceGrpc.newBlockingStub(channel);
    }
    public static void shutdown() throws InterruptedException {
        managedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


    public static RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub transformStorageCommunition(RegisterStorageServiceGrpc.RegisterStorageServiceBlockingStub blockingStub){
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        Properties properties = configFileOperation.getMessageRegisteredLoginConfig();
        String address = properties.getProperty("server_address");
        int port = Integer.valueOf(properties.getProperty("server_port"));
        RegistLoginServer client = new RegistLoginServer(address, port);
        blockingStub = client.blockingStub;
        return blockingStub;
    }

    public static void shutdownNow() throws InterruptedException {
        managedChannel.shutdownNow();
    }
}
