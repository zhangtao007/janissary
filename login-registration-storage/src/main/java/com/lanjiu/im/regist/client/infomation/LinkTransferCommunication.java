package com.lanjiu.im.regist.client.infomation;

import com.lanjiu.im.grpc.*;

public class LinkTransferCommunication {

    private static InformationStorageServiceGrpc.InformationStorageServiceBlockingStub blockingStub = null;

    public static InformationStorageServiceGrpc.InformationStorageServiceBlockingStub linkTransferCommunication(){
        InformationStorageServiceGrpc.InformationStorageServiceBlockingStub stub = InformationStorageClient.linkTransferCommunication(blockingStub);
        return stub;
    }

    public GroupRemarkResponse insertGroupRemarkService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();

        GroupRemarkResponse response = null;
        response = blockingStub.insertGroupRemark(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GuestGroupResponse insertGuestGroupService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GuestGroupResponse response = null;
        response = blockingStub.insertGuestGroup(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public RegisteredGroupResponse insertRegisteredGroupService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        RegisteredGroupResponse response = null;
        response = blockingStub.insertRegisteredGroup(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GuestGroupMemberResponse insertGuestGroupMemberService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GuestGroupMemberResponse response = null;
        response = blockingStub.insertGuestGroupMember(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public RegisteredGroupMemberResponse insertRegisteredGroupMemberService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        RegisteredGroupMemberResponse response = null;
        response = blockingStub.insertRegisteredGroupMember(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GuestUserFriendResponse insertGuestUserFriendService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GuestUserFriendResponse response = null;
        response = blockingStub.insertGuestUserFriend(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public RegisteredUserFriendResponse insertRegisteredUserFriendService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        RegisteredUserFriendResponse response = null;
        response = blockingStub.insertRegisteredUserFriend(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GuestUserFriendResponse selectGuestUserFriendService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GuestUserFriendResponse response = null;
        response = blockingStub.selectGuestUserFriend(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public RegisteredUserFriendResponse selectRegisteredUserFriendService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        RegisteredUserFriendResponse response = null;
        response = blockingStub.selectRegisteredUserFriend(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GuestGroupMemberResponse selectGuestGroupMemberService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GuestGroupMemberResponse response = null;
        response = blockingStub.selectGuestGroupMember(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public RegisteredGroupResponse selectRegisteredGroupService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        RegisteredGroupResponse response = null;
        response = blockingStub.selectRegisteredGroup(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GuestGroupResponse selectGuestGroupService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GuestGroupResponse response = null;
        response = blockingStub.selectGuestGroup(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public RegisteredGroupMemberResponse selectRegisteredGroupMemberService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        RegisteredGroupMemberResponse response = null;
        response = blockingStub.selectRegisteredGroupMember(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public BurnAfterReadingPriorityResponse selectBurnAfterReadingPriorityService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        BurnAfterReadingPriorityResponse response = null;
        response = blockingStub.selectBurnAfterReadingPriority(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public OfflineMessagePriorityResponse selectOfflineMessagePriorityService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        OfflineMessagePriorityResponse response = null;
        response = blockingStub.selectOfflineMessagePriority(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GroupAnnouncementsResponse selectGroupAnnouncementsService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GroupAnnouncementsResponse response = null;
        response = blockingStub.selectGroupAnnouncements(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GroupRemarkResponse selectGroupRemarkService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GroupRemarkResponse response = null;
        response = blockingStub.selectGroupRemark(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GroupRemarkResponse updateGroupRemarkService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GroupRemarkResponse response = null;
        response = blockingStub.updateGroupRemark(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GroupAnnouncementsResponse updateGroupAnnouncementsService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GroupAnnouncementsResponse response = null;
        response = blockingStub.updateGroupAnnouncements(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GuestUserFriendResponse updateGuestUserFriendService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GuestUserFriendResponse response = null;
        response = blockingStub.updateGuestUserFriend(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public RegisteredUserFriendResponse updateRegisteredUserFriendService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        RegisteredUserFriendResponse response = null;
        response = blockingStub.updateRegisteredUserFriend(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GuestGroupResponse updateGuestGroupService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GuestGroupResponse response = null;
        response = blockingStub.updateGuestGroup(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public RegisteredGroupResponse updateRegisteredGroupService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        RegisteredGroupResponse response = null;
        response = blockingStub.updateRegisteredGroup(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GuestGroupMemberResponse updateGuestGroupMemberService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GuestGroupMemberResponse response = null;
        response = blockingStub.updateGuestGroupMember(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public RegisteredGroupMemberResponse updateRegisteredGroupMemberService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        RegisteredGroupMemberResponse response = null;
        response = blockingStub.updateRegisteredGroupMember(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GroupRemarkResponse deleteGroupRemarkService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GroupRemarkResponse response = null;
        response = blockingStub.deleteGroupRemark(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GuestUserFriendResponse deleteGuestUserFriendService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GuestUserFriendResponse response = null;
        response = blockingStub.deleteGuestUserFriend(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public RegisteredUserFriendResponse deleteRegisteredUserFriendService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        RegisteredUserFriendResponse response = null;
        response = blockingStub.deleteRegisteredUserFriend(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GuestGroupResponse deleteGuestGroupService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GuestGroupResponse response = null;
        response = blockingStub.deleteGuestGroup(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public RegisteredGroupResponse deleteRegisteredGroupService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        RegisteredGroupResponse response = null;
        response = blockingStub.deleteRegisteredGroup(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GuestGroupMemberResponse deleteGuestGroupMemberService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        GuestGroupMemberResponse response = null;
        response = blockingStub.deleteGuestGroupMember(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public RegisteredGroupMemberResponse deleteRegisteredGroupMemberService(TransmissionRequest request){
        blockingStub = linkTransferCommunication();
        RegisteredGroupMemberResponse response = null;
        response = blockingStub.deleteRegisteredGroupMember(request);
        try {
            InformationStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }
}
