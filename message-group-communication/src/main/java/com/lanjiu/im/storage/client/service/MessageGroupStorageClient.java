package com.lanjiu.im.storage.client.service;

import com.lanjiu.im.storage.client.util.ConfigFileOperation;
import com.lanjiu.pro.groupStorage.MessageGroupStorageServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MessageGroupStorageClient {

    private static final Logger logger = Logger.getLogger(MessageGroupStorageClient.class.getName());

    private static ManagedChannel managedChannel = null;

    private static MessageGroupStorageServiceGrpc.MessageGroupStorageServiceBlockingStub blockingStub = null;

    private MessageGroupStorageClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build());
    }

    private MessageGroupStorageClient(ManagedChannel channel) {
        managedChannel = channel;
        blockingStub = MessageGroupStorageServiceGrpc.newBlockingStub(channel);
    }
    public static void shutdown() throws InterruptedException {
        managedChannel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
    }

    public static void shutdownNow() throws InterruptedException {
        managedChannel.shutdownNow();
    }

    public static MessageGroupStorageServiceGrpc.MessageGroupStorageServiceBlockingStub linkTransferCommunication() {
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        Properties properties = configFileOperation.getMessageGroupStorageConfig();
        String address = properties.getProperty("server_address");
        int port = Integer.valueOf(properties.getProperty("server_port"));
        new MessageGroupStorageClient(address, port);
        return blockingStub;
    }
}
