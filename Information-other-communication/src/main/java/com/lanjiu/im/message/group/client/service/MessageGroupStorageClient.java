package com.lanjiu.im.message.group.client.service;

import com.lanjiu.im.message.group.client.util.ConfigFileOperation;
import com.lanjiu.im.storage.MessageGroupStorageServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MessageGroupStorageClient {

    private static final Logger logger = Logger.getLogger(MessageGroupStorageClient.class.getName());

    private static ManagedChannel managedChannel = null;

    private static MessageGroupStorageServiceGrpc.MessageGroupStorageServiceBlockingStub blockingStub = null;

    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public MessageGroupStorageClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct client for accessing HelloWorld server using the existing channel. */
    MessageGroupStorageClient(ManagedChannel channel) {
        this.managedChannel = channel;
        blockingStub = MessageGroupStorageServiceGrpc.newBlockingStub(channel);
    }
    public static void shutdown() throws InterruptedException {
        managedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void shutdownNow() throws InterruptedException {
        managedChannel.shutdownNow();
    }

    public static MessageGroupStorageServiceGrpc.MessageGroupStorageServiceBlockingStub linkTransferCommunication(MessageGroupStorageServiceGrpc.MessageGroupStorageServiceBlockingStub blockingStub)
    {
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        Properties properties = configFileOperation.getMessageGroupStorageConfig();
        String address = properties.getProperty("server_address");
        int port = Integer.valueOf(properties.getProperty("server_port"));
        MessageGroupStorageClient client = new MessageGroupStorageClient(address, port);
        blockingStub = client.blockingStub;
        return blockingStub;
    }
}
