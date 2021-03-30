package com.lanjiu.im.grpc.server.controller.update;

import com.lanjiu.im.grpc.*;
import org.apache.log4j.Logger;

public class UpdateEntityAPI {

    private static final Logger logger = Logger.getLogger(UpdateEntityAPI.class.getName());

    public GroupRemarkResponse updateGroupRemark(TransmissionRequest request){
        UpdateGroupRemarkEntityAPI updateGroupRemarkEntityAPI = new UpdateGroupRemarkEntityAPI();
        return updateGroupRemarkEntityAPI.updateGroupRemark(request);
    }

    public GroupAnnouncementsResponse updateGroupAnnouncements(TransmissionRequest request){
        UpdateGroupAnnouncementsEntityAPI updateGroupAnnouncementsEntityAPI = new UpdateGroupAnnouncementsEntityAPI();
        return updateGroupAnnouncementsEntityAPI.updateGroupAnnouncements(request);
    }

    public GuestUserFriendResponse updateGuestUserFriend(TransmissionRequest request){
        UpdateGuestUserFriendEntityAPI updateGuestUserFriendEntityAPI = new UpdateGuestUserFriendEntityAPI();
        return updateGuestUserFriendEntityAPI.updateGuestUserFriend(request);
    }

    public RegisteredUserFriendResponse updateRegisteredUserFriend(TransmissionRequest request){
        UpdateRegisteredUserFriendEntityAPI updateRegisteredUserFriendEntityAPI = new UpdateRegisteredUserFriendEntityAPI();
        return updateRegisteredUserFriendEntityAPI.updateRegisteredUserFriend(request);
    }

    public GuestGroupResponse updateGuestGroup(TransmissionRequest request){
        UpdateGuestGroupEntityAPI updateGuestGroupEntityAPI = new UpdateGuestGroupEntityAPI();
        return updateGuestGroupEntityAPI.updateGuestGroup(request);
    }

    public RegisteredGroupResponse updateRegisteredGroup(TransmissionRequest request){
        UpdateRegisteredGroupEntityAPI updateRegisteredGroupEntityAPI = new UpdateRegisteredGroupEntityAPI();
        return updateRegisteredGroupEntityAPI.updateRegisteredGroup(request);
    }

    public GuestGroupMemberResponse updateGuestGroupMember(TransmissionRequest request){
        UpdateGuestGroupMemberEntityAPI updateGuestGroupMemberEntityAPI = new UpdateGuestGroupMemberEntityAPI();
        return updateGuestGroupMemberEntityAPI.updateGuestGroupMember(request);
    }

    public RegisteredGroupMemberResponse updateRegisteredGroupMember(TransmissionRequest request){
        UpdateRegisteredGroupMemberEntityAPI updateRegisteredGroupMemberEntityAPI = new UpdateRegisteredGroupMemberEntityAPI();
        return updateRegisteredGroupMemberEntityAPI.updateRegisteredGroupMember(request);
    }

    public RegisteredGroupMemberResponse updateRegtGroupMemberRemark(TransmissionRequest request){
        UpdateRegisteredGroupMemberEntityAPI updateRegisteredGroupMemberEntityAPI = new UpdateRegisteredGroupMemberEntityAPI();
        return updateRegisteredGroupMemberEntityAPI.updateRegtGroupMemberRemark(request);
    }

    public AllGroupsMemberResponse updateRegisteredGroupServcie(TransmissionRequest request){
        return new UpdateRegisteredGroupMemberEntityAPI().updateRegisteredGroupServcie(request);
    }
}
