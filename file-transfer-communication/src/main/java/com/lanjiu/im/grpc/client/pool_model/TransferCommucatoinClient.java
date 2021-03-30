package com.lanjiu.im.grpc.client.pool_model;

import com.lanjiu.pro.file.FileTransmissionServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TransferCommucatoinClient {
    private static final Logger logger = LoggerFactory.getLogger(TransferCommucatoinClient.class);

    private static ManagedChannel managedChannel = null;

    private static FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub blockingStub = null;

    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public TransferCommucatoinClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct client for accessing HelloWorld server using the existing channel. */
    TransferCommucatoinClient(ManagedChannel channel) {
        this.managedChannel = channel;
        blockingStub = FileTransmissionServiceGrpc.newBlockingStub(channel);
    }
    public static void shutdown() throws InterruptedException {
        managedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void shutdownNow() throws InterruptedException {
        managedChannel.shutdownNow();
    }

//    private void awaitTermination() throws InterruptedException{
//        if (null != this.blockingStub){
//            this.blockingStub.awaitTermination();
//            //this.server.awaitTermination(3000,TimeUnit.MILLISECONDS);
//        }
//    }

    public static FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub linkTransferCommunication(FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub blockingStub)
    {
//        ConfigFileOperation configFileOperation = new ConfigFileOperation();
//        Properties properties = configFileOperation.getTransferStorageConfig();
        String address ="127.0.0.1";
        int port = 11320;
        TransferCommucatoinClient client = new TransferCommucatoinClient(address, port);
        blockingStub = client.blockingStub;
        return blockingStub;
    }
}
