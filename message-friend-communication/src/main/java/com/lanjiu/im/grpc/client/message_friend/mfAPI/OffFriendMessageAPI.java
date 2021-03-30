package com.lanjiu.im.grpc.client.message_friend.mfAPI;

import com.lanjiu.im.grpc.client.message_friend.FriendMessageCommon;
import com.lanjiu.im.grpc.utils.ConstantKind;
import com.lanjiu.im.grpc.utils.ResponseStatus;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.friend_msg.*;

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

    public AudioAndVideoCallResponse audioAndVideoCall(AudioAndVideoCallRequest request) {
        FriendMessageCommon friendMessageCommon = new FriendMessageCommon();
        AudioAndVideoCallResponse responseFriendMessage =friendMessageCommon.audioAndVideoCall(request);
        return responseFriendMessage;
    }


    public static void main(String[] args) {
        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
        int userID = 99999999;
        RequestFriendMessage requestFriendMessage = null;
        requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.TIME_CLEAR_REQUEST_SELECT_TO_ID)
                .addNotifyDelMsg(NotifyDelMsg.newBuilder()
                        .setDeltoId(userID)
                        .build())
                .build();

        for (int i = 0; i <10000 ; i++) {
            long start = System.currentTimeMillis();
            ResponseFriendMessage responseFriendMessage = null;
            try {
                responseFriendMessage = offFriendMessageAPI.selectFriendMessage(requestFriendMessage);
            } catch (Exception e) {
                System.out.println("异常");
                BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)
                                .setFromId("99999999")
                                .build())
                        .build();
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.newBuilder().setUnifiedEntranceMessage(message).build();

            }
            long end = System.currentTimeMillis();
            System.out.println(i+" , 响应结果：" +(end-start));
            System.out.println(responseFriendMessage.toString());


        }








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
