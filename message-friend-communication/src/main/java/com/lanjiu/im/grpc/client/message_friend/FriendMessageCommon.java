package com.lanjiu.im.grpc.client.message_friend;


import com.lanjiu.pro.friend_msg.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FriendMessageCommon {

    private static final Logger logger = LoggerFactory.getLogger(FriendMessageCommon.class);
    public static MessageFriendServiceGrpc.MessageFriendServiceBlockingStub blockingStub = null;
    public static  MessageFriendServiceGrpc.MessageFriendServiceBlockingStub FriendMessageCommon(){
        MessageFriendServiceGrpc.MessageFriendServiceBlockingStub stub = MessageFriendStorageClient.transformStorageCommunition(blockingStub);
        return stub;
    }



    public ResponseFriendMessage storageFriendMessage(RequestFriendMessage requestFriendMessage) {
        blockingStub =FriendMessageCommon();
        ResponseFriendMessage response = null;
        response = blockingStub.storageFriendMessage(requestFriendMessage);
        try {
            MessageFriendStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;

    }

    public ResponseFriendMessage removeFriendMessage(RequestFriendMessage requestFriendMessage) {
        blockingStub =FriendMessageCommon();
        ResponseFriendMessage response = null;
        response = blockingStub.removeFriendMessage(requestFriendMessage);
        try {
            MessageFriendStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseFriendMessage selectFriendMessage(RequestFriendMessage request) {
        blockingStub =FriendMessageCommon();
        ResponseFriendMessage response = null;
        response = blockingStub.selectFriendMessage(request);
        try {
            MessageFriendStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

    public ResponseFriendMessage storageFriendMessageOn(RequestFriendMessage request) {
        blockingStub =FriendMessageCommon();
        ResponseFriendMessage response = null;
        response = blockingStub.storageFriendMessageOn(request);
        try {
            MessageFriendStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public ResponseFriendMessage removeFriendMessageOn(RequestFriendMessage request) {
        blockingStub =FriendMessageCommon();
        ResponseFriendMessage response = null;
        response = blockingStub.removeFriendMessageOn(request);
        try {
            MessageFriendStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public ResponseFriendMessage selectFriendMessageOn(RequestFriendMessage request) {
        blockingStub =FriendMessageCommon();
        ResponseFriendMessage response = null;
        response = blockingStub.selectFriendMessageOn(request);
        try {
            MessageFriendStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public AudioAndVideoCallResponse audioAndVideoCall(AudioAndVideoCallRequest request) {
        blockingStub =FriendMessageCommon();
        AudioAndVideoCallResponse response = null;
        response = blockingStub.audioAndVideoCallMessage(request);
        try {
            MessageFriendStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }


}
