package com.lanjiu.im.grpc.server.controller.delete;

import com.lanjiu.im.grpc.RegisteredUserFriendResponse;
import com.lanjiu.im.grpc.RpcRegisteredUserFriend;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.pojo.RegisteredUserFriend;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.log4j.Logger;


public class DeleteRegisteredUserFriendEntityAPI {

    private static final Logger logger = Logger.getLogger(DeleteRegisteredUserFriendEntityAPI.class.getName());

    public RegisteredUserFriendResponse deleteRegisteredUserFriend(TransmissionRequest request){
        RpcRegisteredUserFriend rpcRegisteredUserFriend = request.getRegisteredUserFriend();
        DeleteRegisteredUserFriendServiceAPI registeredUserFriendServiceAPI = new DeleteRegisteredUserFriendServiceAPI();
        RegisteredUserFriend registeredUserFriend = registeredUserFriendServiceAPI.deleteRegisteredUserFriend(rpcRegisteredUserFriend);
        if(null == registeredUserFriend){
            return null;
        }
        RegisteredUserFriendResponse registeredUserFriendResponse = RegisteredUserFriendResponse.newBuilder()
                .addResponseData(RpcRegisteredUserFriend.newBuilder()
                .setRegisteredUserId(registeredUserFriend.getRegisteredUserId())
//                .setFriendId(registeredUserFriend.getFriendId())
                .setFriendUserId(registeredUserFriend.getFriendUserId())
//                .setFriendComment(registeredUserFriend.getFriendComment())
                .setCreationTime(registeredUserFriend.getCreationTime().getTime())
                .setModificationTime(registeredUserFriend.getModificationTime().getTime())
//                .setOfflineMessageSetting(registeredUserFriend.getOfflineMessageSetting())
//                .setBurnAfterReadingSetting(registeredUserFriend.getBurnAfterReadingSetting())
//                .setBurnAfterReadingTimeUnit(registeredUserFriend.getBurnAfterReadingTimeUnit())
//                .setBurnAfterReadingTimeLength(registeredUserFriend.getBurnAfterReadingTimeLength().floatValue())
//                .setFriendNickName(registeredUserFriend.getFriendNickName())
                .build())
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        return registeredUserFriendResponse;
    }
}
