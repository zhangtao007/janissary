package com.lanjiu.im.regist.client.friend_msg;


import com.lanjiu.im.storage.util.PropertyConf;
import com.lanjiu.pro.friend_msg.MessageFriendServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MessageFriendCommunitClient {

    private static final Logger logger = Logger.getLogger(MessageFriendCommunitClient.class.getName());

    private static ManagedChannel managedChannel = null;

    private static MessageFriendServiceGrpc.MessageFriendServiceBlockingStub blockingStub = null;


    /** Construct client connecting to HelloWorld client at {@code host:port}. */
    public MessageFriendCommunitClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct client for accessing HelloWorld client using the existing channel. */
    MessageFriendCommunitClient(ManagedChannel channel) {
        this.managedChannel = channel;
        blockingStub = MessageFriendServiceGrpc.newBlockingStub(channel);
    }
    public static void shutdown() throws InterruptedException {
        managedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


    public static MessageFriendServiceGrpc.MessageFriendServiceBlockingStub transformStorageCommunition(MessageFriendServiceGrpc.MessageFriendServiceBlockingStub blockingStub){

        PropertyConf propertyConf = new PropertyConf("/message_friend_storage.properties");
        String address = propertyConf.getValue("server_address");
        int port = Integer.valueOf(propertyConf.getValue("server_port"));
        MessageFriendCommunitClient client = new MessageFriendCommunitClient(address, port);
        blockingStub = client.blockingStub;
        return blockingStub;
    }

   /* public static void main(String[] args) {
        PropertyConf propertyConf = new PropertyConf("/message_friend_storage.properties");
        String address = propertyConf.getValue("server_address");
        int port = Integer.valueOf(propertyConf.getValue("server_port"));
        MessageFriendCommunitClient client = new MessageFriendCommunitClient(address, port);
        blockingStub = client.blockingStub;
        RequestFriendMessage requestFriendMessage = RequestFriendMessage.newBuilder()
                .addFriendMessage(FriendMessage.newBuilder()
                        .setToId(132).build())
                .addNotifyDelMsg(NotifyDelMsg.newBuilder()
                        .setDeltoId(456).build())
                .build();
        ResponseFriendMessage response = null;
        response = blockingStub.removeFriendMessage(requestFriendMessage);
    }*/





    public static void shutdownNow() throws InterruptedException {
        managedChannel.shutdownNow();
    }



}
