package com.lanjiu.im.grpc.server.controller.update;

import com.lanjiu.im.grpc.RegisteredUserFriendResponse;
import com.lanjiu.im.grpc.RpcRegisteredUserFriend;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.pojo.RegisteredUserFriend;
import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class UpdateRegisteredUserFriendEntityAPI {

    private static final Logger logger = Logger.getLogger(UpdateRegisteredUserFriendEntityAPI.class.getName());

    public RegisteredUserFriendResponse updateRegisteredUserFriend(TransmissionRequest request){
        RpcRegisteredUserFriend rpcRegisteredUserFriend = request.getRegisteredUserFriend();
        UpdateRegisteredUserFriendServiceAPI userFriendService = new UpdateRegisteredUserFriendServiceAPI();
        RegisteredUserFriend registeredUserFriend = null;
        if(request.getRequestKind().equalsIgnoreCase(ConstantsContent.FRIEND_ALIAS)){
            registeredUserFriend = userFriendService.updateRegisteredUserFriend(rpcRegisteredUserFriend,ConstantsContent.FRIEND_ALIAS);
            if(null == registeredUserFriend){
                return null;
            }
            RegisteredUserFriendResponse registeredUserFriendResponse = RegisteredUserFriendResponse.newBuilder()
                    .addResponseData(RpcRegisteredUserFriend.newBuilder()
                            .setRegisteredUserId(registeredUserFriend.getRegisteredUserId())
                            .setFriendUserId(registeredUserFriend.getFriendUserId())
                            .setFriendComment(registeredUserFriend.getFriendComment())
                            .setModificationTime(registeredUserFriend.getModificationTime().getTime())
                            .build()).setStatusDetail(ConstantsContent.RESPONSE_SUCCESS).build();
            return registeredUserFriendResponse;
        }else if(request.getRequestKind().equalsIgnoreCase(ConstantsContent.FRIEND_OFFLINE_SET)){
            registeredUserFriend = userFriendService.updateRegisteredUserFriend(rpcRegisteredUserFriend,ConstantsContent.FRIEND_OFFLINE_SET);
            if(null == registeredUserFriend){
            return null;
            }
            RegisteredUserFriendResponse registeredUserFriendResponse = RegisteredUserFriendResponse.newBuilder()
                    .addResponseData(RpcRegisteredUserFriend.newBuilder()
                            .setRegisteredUserId(registeredUserFriend.getRegisteredUserId())
                            .setFriendUserId(registeredUserFriend.getFriendUserId())
                            .setModificationTime(registeredUserFriend.getModificationTime().getTime())
                            .setOfflineMessageSetting(registeredUserFriend.getOfflineMessageSetting())
                            .build()).setStatusDetail(ConstantsContent.RESPONSE_SUCCESS).build();
            return registeredUserFriendResponse;
        }


//        RegisteredUserFriend registeredUserFriend = userFriendService.updateRegisteredUserFriend(rpcRegisteredUserFriend);
//        if(null == registeredUserFriend){
//            return null;
//        }
//        RegisteredUserFriendResponse registeredUserFriendResponse = RegisteredUserFriendResponse.newBuilder()
//                .addResponseData(RpcRegisteredUserFriend.newBuilder()
//                        .setRegisteredUserId(registeredUserFriend.getRegisteredUserId())
//                        .setFriendUserId(registeredUserFriend.getFriendUserId())
//                        .setFriendComment(registeredUserFriend.getFriendComment())
//                        .setCreationTime(registeredUserFriend.getCreationTime().getTime())
//                        .setModificationTime(registeredUserFriend.getModificationTime().getTime())
//                        .setOfflineMessageSetting(registeredUserFriend.getOfflineMessageSetting())
//                        .setBurnAfterReadingSetting(registeredUserFriend.getBurnAfterReadingSetting())
//                        .setBurnAfterReadingTimeUnit(registeredUserFriend.getBurnAfterReadingTimeUnit())
//                        .setBurnAfterReadingTimeLength(registeredUserFriend.getBurnAfterReadingTimeLength().floatValue())
//                        .setFriendNickName(registeredUserFriend.getFriendNickName())
//                        .build()).setStatusDetail(ConstantsContent.RESPONSE_SUCCESS).build();
//        return registeredUserFriendResponse;
        return null;
    }
}
