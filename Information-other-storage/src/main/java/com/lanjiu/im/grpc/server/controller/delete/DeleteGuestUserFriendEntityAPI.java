package com.lanjiu.im.grpc.server.controller.delete;

import com.lanjiu.im.grpc.AllGroupsMemberResponse;
import com.lanjiu.im.grpc.GuestUserFriendResponse;
import com.lanjiu.im.grpc.RpcGuestUserFriend;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.pojo.GuestUserFriend;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.log4j.Logger;


public class DeleteGuestUserFriendEntityAPI {

    private static final Logger logger = Logger.getLogger(DeleteGuestUserFriendEntityAPI.class.getName());

    public GuestUserFriendResponse deleteGuestUserFriend(TransmissionRequest request){
        RpcGuestUserFriend rpcGuestUserFriend = request.getGuestUserFriend();
        String kind = request.getRequestKind();
        DeleteGuestUserFriendServiceAPI guestUserFriendService = new DeleteGuestUserFriendServiceAPI();
        GuestUserFriend guestUserFriend = guestUserFriendService.deleteGuestUserFriend(rpcGuestUserFriend, kind);
        if(null == guestUserFriend){
            return null;
        }
        GuestUserFriendResponse guestUserFriendResponse = GuestUserFriendResponse.newBuilder()
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
        return guestUserFriendResponse;
    }

    public AllGroupsMemberResponse deleteGuestRelatedAllInfo(TransmissionRequest request){
        DeleteGuestUserFriendServiceAPI friendServiceAPI = new DeleteGuestUserFriendServiceAPI();
        friendServiceAPI.deleteGuestRelatedAllInfo(request);
        AllGroupsMemberResponse allGroupsMemberResponse = AllGroupsMemberResponse.newBuilder()
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        return allGroupsMemberResponse;
    }
}
