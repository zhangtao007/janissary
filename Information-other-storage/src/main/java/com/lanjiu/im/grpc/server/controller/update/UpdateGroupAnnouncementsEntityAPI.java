package com.lanjiu.im.grpc.server.controller.update;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.pojo.GroupAnnouncements;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.log4j.Logger;


public class UpdateGroupAnnouncementsEntityAPI {

    private static final Logger logger = Logger.getLogger(UpdateGroupAnnouncementsEntityAPI.class.getName());

    public GroupAnnouncementsResponse updateGroupAnnouncements(TransmissionRequest request){
        RpcGroupAnnouncements rpcGroupAnnouncements = request.getGroupAnnouncements();
        UpdateGroupAnnouncementsServiceAPI guestGroupUpdateServiceAPI = new UpdateGroupAnnouncementsServiceAPI();
        GroupAnnouncements groupAnnouncements = guestGroupUpdateServiceAPI.updateGroupAnnouncements(rpcGroupAnnouncements);
        if(null == groupAnnouncements){
            return null;
        }
        GroupAnnouncementsResponse registeredUserFriendResponse = GroupAnnouncementsResponse.newBuilder()
                .addResponseData(RpcGroupAnnouncements.newBuilder()
                        .setGroupAnnouncementId(groupAnnouncements.getGroupAnnouncementId())
                        .setAnnouncementContent(groupAnnouncements.getAnnouncementContent())
                        .build())
                        .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                        .build();
        return registeredUserFriendResponse;
    }
}
