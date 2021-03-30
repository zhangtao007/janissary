package com.lanjiu.im.friend.client;

import com.lanjiu.pro.friend_msg.MessageFriendServiceGrpc;
import com.lanjiu.pro.friend_msg.RequestFriendMessage;
import com.lanjiu.pro.friend_msg.ResponseFriendMessage;

public class FriendMessageCommon {

    public static MessageFriendServiceGrpc.MessageFriendServiceBlockingStub blockingStub = null;
    public static  MessageFriendServiceGrpc.MessageFriendServiceBlockingStub FriendMessageCommon(){
        MessageFriendServiceGrpc.MessageFriendServiceBlockingStub stub = MessageFriendCommunitServer.transformStorageCommunition(blockingStub);
        return stub;
    }



    public ResponseFriendMessage storageFriendMessage(RequestFriendMessage requestFriendMessage) {
        blockingStub =FriendMessageCommon();
        ResponseFriendMessage response = null;
        response = blockingStub.storageFriendMessage(requestFriendMessage);
        try {
            MessageFriendCommunitServer.shutdownNow();
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
            MessageFriendCommunitServer.shutdownNow();
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
            MessageFriendCommunitServer.shutdownNow();
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
            MessageFriendCommunitServer.shutdownNow();
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
            MessageFriendCommunitServer.shutdownNow();
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
            MessageFriendCommunitServer.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }
}
