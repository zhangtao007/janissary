package com.lanjiu.im.groupMsgStorage.gmClient;

import com.lanjiu.im.util.PropertyConf;
import com.lanjiu.pro.groupStorage.MessageGroupStorageServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class GroupMessageClient {

    private static final Logger logger = LoggerFactory.getLogger(GroupMessageClient.class.getName());

    private static ManagedChannel managedChannel = null;

    private static MessageGroupStorageServiceGrpc.MessageGroupStorageServiceBlockingStub blockingStub = null;


    /** Construct client connecting to HelloWorld client at {@code host:port}. */
    public GroupMessageClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct client for accessing HelloWorld client using the existing channel. */
    GroupMessageClient(ManagedChannel channel) {
        this.managedChannel = channel;
        blockingStub = MessageGroupStorageServiceGrpc.newBlockingStub(channel);
    }


    public static  MessageGroupStorageServiceGrpc.MessageGroupStorageServiceBlockingStub transformStorageCommunition( MessageGroupStorageServiceGrpc.MessageGroupStorageServiceBlockingStub blockingStub){

        PropertyConf propertyConf = new PropertyConf("/message_group_storage.properties");
        String address = propertyConf.getValue("server_address");
        int port = Integer.valueOf(propertyConf.getValue("server_port"));
        GroupMessageClient client = new GroupMessageClient(address, port);
        blockingStub = client.blockingStub;
        return blockingStub;
    }

    public static void shutdownNow() throws InterruptedException {
        managedChannel.shutdownNow();
    }
}
