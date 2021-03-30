package com.lanjiu.im.friend.client;


import com.lanjiu.pro.friend_msg.RequestFriendMessage;
import com.lanjiu.pro.friend_msg.ResponseFriendMessage;

public class OffFriendMessageAPI {

    public ResponseFriendMessage storageFriendMessage(RequestFriendMessage request) {
        FriendMessageCommon friendMessageCommon = new FriendMessageCommon();
        ResponseFriendMessage responseFriendMessage = friendMessageCommon.storageFriendMessage(request);
        return responseFriendMessage;
    }

    public ResponseFriendMessage removeFriendMessage(RequestFriendMessage request) {
        FriendMessageCommon friendMessageCommon = new FriendMessageCommon();
        ResponseFriendMessage responseFriendMessage =friendMessageCommon.removeFriendMessage(request);
        return responseFriendMessage;
    }

    public ResponseFriendMessage selectFriendMessage(RequestFriendMessage request) {
        FriendMessageCommon friendMessageCommon = new FriendMessageCommon();
        ResponseFriendMessage responseFriendMessage =friendMessageCommon.selectFriendMessage(request);
        return responseFriendMessage;
    }

    public static void main(String[] args) {
        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
    /*  RequestFriendMessage requestFriendMessage = RequestFriendMessage.newBuilder()
                                                             .addFriendMessage(FriendMessage.newBuilder()
                                                                     .setMsgId(143)
                                                                     .setMsgType(0)
                                                                      .setFromId(369)
                                                                      .setToId(852)
                                                                      .setContent("hello ,tt")
                                                                       .setMessageOfflineStatus(true).build())
                                                             .setRet("0").build();

        ResponseFriendMessage responseFriendMessage = offFriendMessageAPI.storageFriendMessage(requestFriendMessage);
        System.out.println(responseFriendMessage.getRet());
        List<FriendMessage> list = responseFriendMessage.getFriendMessageList();
        for(FriendMessage friendMessage : list){
            System.out.println(friendMessage.getMsgId());
        }*/

       /*RequestFriendMessage requestFriendMessage = RequestFriendMessage.newBuilder()
                                                             .addFriendMessage(FriendMessage.newBuilder()
                                                                     .setMsgId(140)
                                                                     .setMsgType(0)
                                                                      .setFromId(369)
                                                                      .setToId(852)
                                                                      .setContent("你好，kk")
                                                                       .setMessageOfflineStatus(true).build())
                                                             .setRet(ConstantKind.MESSAGE_REQUEST_DELETE_MSG_ID).build();

        ResponseFriendMessage responseFriendMessage = offFriendMessageAPI.removeFriendMessage(requestFriendMessage);
        System.out.println(responseFriendMessage.getRet());
        List<FriendMessage> list = responseFriendMessage.getFriendMessageList();
        for(FriendMessage friendMessage : list){
            System.out.println(friendMessage.getMsgId());
        }*/

       /*RequestFriendMessage requestFriendMessage = RequestFriendMessage.newBuilder()
                                                             .addFriendMessage(FriendMessage.newBuilder()
                                                                     .setMsgId(143)
                                                                     .setMsgType(0)
                                                                      .setFromId(369)
                                                                      .setToId(852)
                                                                      .setContent("你好，kk")
                                                                       .setMessageOfflineStatus(true).build())
                                                             .setRet(ConstantKind.MESSAGE_REQUEST_SELECT_ALL).build();

        ResponseFriendMessage responseFriendMessage = offFriendMessageAPI.selectFriendMessage(requestFriendMessage);
        System.out.println(responseFriendMessage.getRet());
        List<FriendMessage> list = responseFriendMessage.getFriendMessageList();
        for(FriendMessage friendMessage : list){
            System.out.println(friendMessage.getMsgId());
        }*/


    }
}
