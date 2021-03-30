package com.lanjiu.im.regist.server.controller;


import com.lanjiu.im.grpc.GuestUserFriendResponse;
import com.lanjiu.im.grpc.RpcGuestUserFriend;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.regist.client.friend_msg.OffFriendMessageAPI;
import com.lanjiu.im.regist.client.infomation.StorageAPI;
import com.lanjiu.im.regist.utils.ConstantKind;
import com.lanjiu.im.regist.utils.ConstantsSelectKind;
import com.lanjiu.im.storage.service.GuestUserService;
import com.lanjiu.pro.friend_msg.FriendMessage;
import com.lanjiu.pro.friend_msg.NotifyDelMsg;
import com.lanjiu.pro.friend_msg.RequestFriendMessage;
import com.lanjiu.pro.friend_msg.ResponseFriendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CkeckOTGuestUser {

    private static final Logger logger = LoggerFactory.getLogger(CkeckOTGuestUser.class);

    public static void ckeckOverTimeGuest(int time){
            //1.获取注册时间距离当前系统时间超过指定时间的游客用户id,
           //2. 调用登录服务api接口删除超时游客的个人信息及设置信息
           //3. 调用资料服务api接口删除超时游客的好友关系，群关系，
           //4. 调用好友消息服务api接口删除超时游客的已发出和未接收的离线好友消息；
           //5. 调用群消息服务api接口删除超时游客的已发出和未接收群消息；
           //6. 调用文件服务api接口删除超时游客的已发出和未接收的文件信息。

        GuestUserService guestUserService = new GuestUserService();
        List<Integer> overUserId = guestUserService.selectOverTimeUser(time);
        guestUserService.removeOverGuest(overUserId);

        grpcFriendMsgStorage(overUserId);
        grpcInfomationStorage(overUserId);
        //  删除群资料和文件 +++》取消游客功能2020.1.3


    }

    //调用好友消息服务清除离线消息
    private static void grpcFriendMsgStorage(List<Integer> overUserId) {
        OffFriendMessageAPI offmsg = new OffFriendMessageAPI();
        List<FriendMessage> fmlist = new ArrayList<>();
        List<NotifyDelMsg>  ndlist = new ArrayList<>();
        for (Integer id : overUserId){
            FriendMessage friendMessage = FriendMessage.newBuilder()
                    .setFromId(id)
                    .setToId(id)
                    .build();
            NotifyDelMsg notifyDelMsg = NotifyDelMsg.newBuilder()
                    .setDelfromId(id)
                    .setDeltoId(id)
                    .build();
            fmlist.add(friendMessage);
            ndlist.add(notifyDelMsg);
        }
        RequestFriendMessage requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.MESSAGE_REQUEST_GUEST_USER_LOGOUT)
                .addAllFriendMessage(fmlist)
                .addAllNotifyDelMsg(ndlist)
                .build();

        ResponseFriendMessage responseFriendMessage = offmsg.removeFriendMessage(requestFriendMessage);
    }

    //调用资料服务清除
    private static void grpcInfomationStorage(List<Integer> overUserId) {
        StorageAPI storageAPI =  new StorageAPI();
        for(Integer id : overUserId){

            TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
                    .setRequestKind(ConstantsSelectKind.FRIEND_DELETE_TYPE_BY_GUEST_USER_ID)
                    .setGuestUserFriend(RpcGuestUserFriend.newBuilder()
                            .setGuestUserId(id).build())
                    .build();
            GuestUserFriendResponse guestUserFriendResponse =  storageAPI.deleteGuestUserFriendAPI(transmissionRequest);
            String statusDetail = guestUserFriendResponse.getStatusDetail();
//            System.out.println(statusDetail);
        }

    }




    public static void main(String[] args) {
//        GuestUserService guestUserService = new GuestUserService();
//        List<Integer> allUserId = guestUserService.selectOverTimeUser(2);
//        System.out.println(allUserId.size());
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(70011001);
//        int i = guestUserService.removeOverGuest(list);
//        System.out.println(i);

//        List<Integer> list = new ArrayList<>();
//        list.add(10010065);

//        CkeckOTGuestUser.grpcInfomationStorage(list);
    }
}
