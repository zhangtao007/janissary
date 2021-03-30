package com.lanjiu.im.grpc.server.controller.update;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.pojo.GuestUserFriend;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.log4j.Logger;


public class UpdateGuestUserFriendEntityAPI {

    private static final Logger logger = Logger.getLogger(UpdateGuestUserFriendEntityAPI.class.getName());

    public GuestUserFriendResponse updateGuestUserFriend(TransmissionRequest request){
        RpcGuestUserFriend rpcGuestUserFriend = request.getGuestUserFriend();
        UpdateGuestUserFriendServiceAPI guestGroupUpdateServiceAPI = new UpdateGuestUserFriendServiceAPI();
        GuestUserFriend guestUserFriend = guestGroupUpdateServiceAPI.updateGuestUserFriend(rpcGuestUserFriend);
        if(null == guestUserFriend){
            return null;
        }
        GuestUserFriendResponse registeredUserFriendResponse = GuestUserFriendResponse.newBuilder()
                .addResponseData(RpcGuestUserFriend.newBuilder()
                        .setGuestUserId(guestUserFriend.getGuestUserId())
                        .setFriendId(guestUserFriend.getFriendId())
                        .setFriendUserId(guestUserFriend.getFriendUserId())
                        .setFriendComment(guestUserFriend.getFriendComment())
                        .setCreationTime(guestUserFriend.getCreationTime().getTime())
                        .setModificationTime(guestUserFriend.getModificationTime().getTime())
                        .setOfflineMessageSetting(guestUserFriend.getOfflineMessageSetting())
                        .setBurnAfterReadingSetting(guestUserFriend.getBurnAfterReadingSetting())
                        .setBurnAfterReadingTimeUnit(guestUserFriend.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(guestUserFriend.getBurnAfterReadingTimeLength().floatValue())
                        .setFriendNickName(guestUserFriend.getFriendNickName())
                        .build())
                        .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        return registeredUserFriendResponse;
    }
}
