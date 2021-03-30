package com.lanjiu.im.grpc.server.controller.delete;

import com.lanjiu.im.grpc.*;
import org.apache.log4j.Logger;


public class DeleteEntityAPI {

    private static final Logger logger = Logger.getLogger(DeleteEntityAPI.class.getName());

    public GuestGroupResponse deleteGuestGroup(TransmissionRequest request){
        DeleteGuestGroupEntityAPI deleteGuestGroupEntityAPI = new DeleteGuestGroupEntityAPI();
        return deleteGuestGroupEntityAPI.deleteGuestGroup(request);
    }

    public RegisteredGroupResponse deleteRegisteredGroup(TransmissionRequest request){
        DeleteRegisteredGroupEntityAPI deleteRegisteredGroupEntityAPI = new DeleteRegisteredGroupEntityAPI();
        return deleteRegisteredGroupEntityAPI.deleteRegisteredGroup(request);
    }

    public GuestGroupMemberResponse deleteGuestGroupMember(TransmissionRequest request){
        DeleteGuestGroupMemberEntityAPI deleteGuestGroupMemberEntityAPI = new DeleteGuestGroupMemberEntityAPI();
        return deleteGuestGroupMemberEntityAPI.deleteGuestGroupMember(request);
    }

    public RegisteredGroupMemberResponse deleteRegisteredGroupMember(TransmissionRequest request){
        DeleteRegisteredGroupMemberEntityAPI deleteRegisteredGroupMemberEntityAPI = new DeleteRegisteredGroupMemberEntityAPI();
        return deleteRegisteredGroupMemberEntityAPI.deleteRegisteredGroupMember(request);
    }

    public GuestUserFriendResponse deleteGuestUserFriend(TransmissionRequest request){
        DeleteGuestUserFriendEntityAPI deleteGuestUserFriendEntityAPI = new DeleteGuestUserFriendEntityAPI();
        return deleteGuestUserFriendEntityAPI.deleteGuestUserFriend(request);
    }

    public RegisteredUserFriendResponse deleteRegisteredUserFriend(TransmissionRequest request){
        DeleteRegisteredUserFriendEntityAPI deleteRegisteredUserFriendEntityAPI = new DeleteRegisteredUserFriendEntityAPI();
        return deleteRegisteredUserFriendEntityAPI.deleteRegisteredUserFriend(request);
    }

    public GroupRemarkResponse deleteGroupRemark(TransmissionRequest request){
        DeleteGroupRemarkEntityAPI deleteGroupRemarkEntityAPI = new DeleteGroupRemarkEntityAPI();
        return deleteGroupRemarkEntityAPI.deleteGroupRemark(request);
    }

    public AllGroupsMemberResponse deleteGuestRelatedAllInfo(TransmissionRequest request){
        DeleteGuestUserFriendEntityAPI friendEntityAPI = new DeleteGuestUserFriendEntityAPI();
        return friendEntityAPI.deleteGuestRelatedAllInfo(request);
    }

    public AllGroupsMemberResponse deleteMembersByGroupOwner(TransmissionRequest request){
        DeleteGroupRemarkEntityAPI deleteGroupRemarkEntityAPI = new DeleteGroupRemarkEntityAPI();
        return deleteGroupRemarkEntityAPI.deleteMembersByGroupOwner(request);
    }

    public AllGroupsMemberResponse groupMemberExitGroupChat(TransmissionRequest request){
        DeleteGroupRemarkEntityAPI deleteGroupRemarkEntityAPI = new DeleteGroupRemarkEntityAPI();
        return deleteGroupRemarkEntityAPI.groupMemberExitGroupChat(request);
    }
}
