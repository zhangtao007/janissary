package com.lanjiu.im.fileStorage.fileClient;

import com.lanjiu.im.util.PropertyConf;
import com.lanjiu.pro.fileStorage.FileStorageServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TransferStorageClient {

    private static final Logger logger = Logger.getLogger(TransferStorageClient.class.getName());

    private static ManagedChannel managedChannel = null;

    private static FileStorageServiceGrpc.FileStorageServiceBlockingStub blockingStub = null;

    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public TransferStorageClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct client for accessing HelloWorld server using the existing channel. */
    TransferStorageClient(ManagedChannel channel) {
        this.managedChannel = channel;
        blockingStub = FileStorageServiceGrpc.newBlockingStub(channel);
    }

    public static void shutdown() throws InterruptedException {
        System.out.println("shutdown-file-Channel_Id:"+TransferStorageClient.managedChannel.toString());
        managedChannel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
    }

    public static void shutdownNow() throws InterruptedException {
        managedChannel.shutdownNow();
    }

    public static FileStorageServiceGrpc.FileStorageServiceBlockingStub linkTransferCommunication(FileStorageServiceGrpc.FileStorageServiceBlockingStub blockingStub)
    {
        PropertyConf propertyConf = new PropertyConf("/transfer_storage.properties");
        String address = propertyConf.getValue("server_address");
        int port = Integer.valueOf(propertyConf.getValue("server_port"));
        TransferStorageClient client = new TransferStorageClient(address, port);
        blockingStub = client.blockingStub;
        System.out.println("file-Channel_Id:"+TransferStorageClient.managedChannel.toString());
        return blockingStub;
    }
}
