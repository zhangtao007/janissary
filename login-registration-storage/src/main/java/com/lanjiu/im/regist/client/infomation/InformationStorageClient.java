package com.lanjiu.im.regist.client.infomation;

import com.lanjiu.im.grpc.InformationStorageServiceGrpc;
import com.lanjiu.im.storage.util.PropertyConf;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class InformationStorageClient {

    private static final Logger logger = Logger.getLogger(InformationStorageClient.class.getName());

    private static ManagedChannel managedChannel = null;

    private static InformationStorageServiceGrpc.InformationStorageServiceBlockingStub blockingStub = null;

    /** Construct client connecting to HelloWorld client at {@code host:port}. */
    public InformationStorageClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct client for accessing HelloWorld client using the existing channel. */
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
        PropertyConf propertyConf = new PropertyConf("/information_storage.properties");
        String address = propertyConf.getValue("server_address");
        int port = Integer.valueOf(propertyConf.getValue("server_port"));
        InformationStorageClient client = new InformationStorageClient(address, port);
        blockingStub = client.blockingStub;
        return blockingStub;
    }
}
