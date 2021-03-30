package com.lanjiu.im.friend.client;

import com.lanjiu.pro.friend_msg.RequestFriendMessage;
import com.lanjiu.pro.friend_msg.ResponseFriendMessage;

public class OnFriendMessageAPI {
    public ResponseFriendMessage storageFriendMessageOn(RequestFriendMessage request) {
        FriendMessageCommon friendMessageCommon = new FriendMessageCommon();
        ResponseFriendMessage responseFriendMessage = friendMessageCommon.storageFriendMessageOn(request);
        return  responseFriendMessage;

    }

    public ResponseFriendMessage removeFriendMessageOn(RequestFriendMessage request) {
        FriendMessageCommon friendMessageCommon = new FriendMessageCommon();
        ResponseFriendMessage responseFriendMessage = friendMessageCommon.removeFriendMessageOn(request);
        return  responseFriendMessage;
    }

    public ResponseFriendMessage selectFriendMessageOn(RequestFriendMessage request) {
        FriendMessageCommon friendMessageCommon = new FriendMessageCommon();
        ResponseFriendMessage responseFriendMessage = friendMessageCommon.selectFriendMessageOn(request);
        return responseFriendMessage;
    }
}
