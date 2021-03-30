package com.lanjiu.im.grpc.client;

import com.lanjiu.im.storage.util.ConfigFileOperation;
import com.lanjiu.pro.file.FileTransmissionServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TransferCommunicationClient {

    private static final Logger logger = Logger.getLogger(TransferCommunicationClient.class.getName());

    private static ManagedChannel managedChannel = null;

    private static FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub blockingStub = null;

    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public TransferCommunicationClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct client for accessing HelloWorld server using the existing channel. */
    TransferCommunicationClient(ManagedChannel channel) {
        this.managedChannel = channel;
        blockingStub = FileTransmissionServiceGrpc.newBlockingStub(channel);
    }
    public static void shutdown() throws InterruptedException {
        managedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void shutdownNow() throws InterruptedException {
        managedChannel.shutdownNow();
    }

    public static FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub linkTransferCommunication()
    {
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        Properties properties = configFileOperation.getTransferCommunicationConfig();
        String address = properties.getProperty("server_address");
        int port = Integer.valueOf(properties.getProperty("server_port"));
        TransferCommunicationClient client = new TransferCommunicationClient(address, port);
        return client.blockingStub;
    }
}
