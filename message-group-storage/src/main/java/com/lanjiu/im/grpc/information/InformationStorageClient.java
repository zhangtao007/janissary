package com.lanjiu.im.grpc.information;

import com.lanjiu.im.grpc.InformationStorageServiceGrpc;
import com.lanjiu.im.grpc.login.PropertyConf;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class InformationStorageClient {

    private static final Logger log = Logger.getLogger(InformationStorageClient.class.getName());

    private static ManagedChannel managedChannel = null;

    private static InformationStorageServiceGrpc.InformationStorageServiceBlockingStub serviceBlockingStub = null;

    private InformationStorageClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
    }

    private InformationStorageClient(ManagedChannel channel) {
        managedChannel = channel;
        serviceBlockingStub = InformationStorageServiceGrpc.newBlockingStub(channel);
    }

    public static InformationStorageServiceGrpc.InformationStorageServiceBlockingStub linkTransferCommunication(){
        PropertyConf propertyConf = new PropertyConf("/information_storage.properties");
        String address = propertyConf.getValue("server_address");
        int port = Integer.valueOf(propertyConf.getValue("server_port"));
        new InformationStorageClient(address, port);
        return serviceBlockingStub;
    }

    public static void shutdownNow(){
        managedChannel.shutdownNow();
    }

    public static void shutdown() throws InterruptedException {
        managedChannel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
    }
}
