package com.lanjiu.im.grpc.client.message_friend;

import com.lanjiu.im.grpc.utils.ConfigFileOperation;
import com.lanjiu.pro.friend_msg.MessageFriendServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MessageFriendStorageClient {

    private static final Logger logger = Logger.getLogger(MessageFriendStorageClient.class.getName());

    private static ManagedChannel managedChannel = null;

    private static MessageFriendServiceGrpc.MessageFriendServiceBlockingStub blockingStub = null;


    /** Construct server connecting to HelloWorld server at {@code host:port}. */
    public MessageFriendStorageClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct server for accessing HelloWorld server using the existing channel. */
    MessageFriendStorageClient(ManagedChannel channel) {
        this.managedChannel = channel;
        blockingStub = MessageFriendServiceGrpc.newBlockingStub(channel);
    }
    public static void shutdown() throws InterruptedException {
        managedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


    public static MessageFriendServiceGrpc.MessageFriendServiceBlockingStub transformStorageCommunition(MessageFriendServiceGrpc.MessageFriendServiceBlockingStub blockingStub){
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        Properties properties = configFileOperation.getMessageGroupStorageConfig();
        String address = properties.getProperty("server_address");
        int port = Integer.valueOf(properties.getProperty("server_port"));
        MessageFriendStorageClient client = new MessageFriendStorageClient(address, port);
        blockingStub = client.blockingStub;
        return blockingStub;
    }





    public static void shutdownNow() throws InterruptedException {
        managedChannel.shutdownNow();
    }

}
