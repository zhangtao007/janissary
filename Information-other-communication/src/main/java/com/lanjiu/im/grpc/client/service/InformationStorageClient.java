package com.lanjiu.im.grpc.client.service;

import com.lanjiu.im.grpc.InformationStorageServiceGrpc;
import com.lanjiu.im.grpc.client.util.ConfigFileOperation;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class InformationStorageClient {

    private static final Logger logger = Logger.getLogger(InformationStorageClient.class.getName());

    private static ManagedChannel managedChannel = null;

    private static InformationStorageServiceGrpc.InformationStorageServiceBlockingStub blockingStub = null;

    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public InformationStorageClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct client for accessing HelloWorld server using the existing channel. */
    InformationStorageClient(ManagedChannel channel) {
        this.managedChannel = channel;
        blockingStub = InformationStorageServiceGrpc.newBlockingStub(channel);
    }
    public static void shutdown() throws InterruptedException {
        managedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void shutdownNow() throws InterruptedException {
        managedChannel.shutdownNow();
    }

    public static InformationStorageServiceGrpc.InformationStorageServiceBlockingStub linkTransferCommunication(InformationStorageServiceGrpc.InformationStorageServiceBlockingStub blockingStub)
    {
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        Properties properties = configFileOperation.getInformationStorageConfig();
        String address = properties.getProperty("server_address");
        int port = Integer.valueOf(properties.getProperty("server_port"));
        InformationStorageClient client = new InformationStorageClient(address, port);
        blockingStub = client.blockingStub;
        return blockingStub;
    }
}
