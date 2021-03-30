package com.lanjiu.im.grpc.server.controller.create;

import com.lanjiu.im.grpc.*;
import org.apache.log4j.Logger;


public class CreateEntityAPI {

    private static final Logger logger = Logger.getLogger(CreateEntityAPI.class.getName());

    public GuestGroupResponse createGuestGroup(TransmissionRequest request){
        CreateGuestGroupEntityAPI createGuestGroupEntityAPI = new CreateGuestGroupEntityAPI();
        return createGuestGroupEntityAPI.createGuestGroup(request);
    }

    public RegisteredGroupResponse createRegisteredGroup(TransmissionRequest request) throws Exception {
        CreateRegisteredGroupEntityAPI createRegisteredGroupEntityAPI = new CreateRegisteredGroupEntityAPI();
        return createRegisteredGroupEntityAPI.createRegisteredGroup(request);
    }

    public GuestGroupMemberResponse createGuestGroupMember(TransmissionRequest request){
        CreateGuestGroupMemberEntityAPI createGuestGroupMemberEntityAPI = new CreateGuestGroupMemberEntityAPI();
        return createGuestGroupMemberEntityAPI.createGuestGroupMember(request);
    }

    public RegisteredGroupMemberResponse createRegisteredGroupMember(TransmissionRequest request){
        CreateRegisteredGroupMemberEntityAPI createRegisteredGroupMemberEntityAPI = new CreateRegisteredGroupMemberEntityAPI();
        return createRegisteredGroupMemberEntityAPI.createRegisteredGroupMember(request);
    }

    public GuestUserFriendResponse createGuestUserFriend(TransmissionRequest request){
        CreateGuestUserFriendEntityAPI createGuestUserFriendEntityAPI = new CreateGuestUserFriendEntityAPI();
        return createGuestUserFriendEntityAPI.createGuestUserFriend(request);
    }

    public RegisteredUserFriendResponse createRegisteredUserFriend(TransmissionRequest request){
        CreateRegisteredUserFriendEntityAPI createRegisteredUserFriendEntityAPI = new CreateRegisteredUserFriendEntityAPI();
        return createRegisteredUserFriendEntityAPI.createRegisteredUserFriend(request);
    }

    public GroupRemarkResponse createGroupRemark(TransmissionRequest request){
        CreateGroupRemarkEntityAPI createGroupRemarkEntityAPI = new CreateGroupRemarkEntityAPI();
        return createGroupRemarkEntityAPI.createGroupRemark(request);
    }
}
