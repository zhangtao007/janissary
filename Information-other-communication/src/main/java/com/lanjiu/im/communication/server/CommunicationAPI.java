package com.lanjiu.im.communication.server;

import com.lanjiu.im.communication.server.service.*;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelHandlerContext;

public class CommunicationAPI {

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectGuestUserFriendAPI(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        FriendListProtocolService friendListProtocolService = new FriendListProtocolService();
        return friendListProtocolService.selectGuestUserFriendServiceAPI(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectRegisteredUserFriendAPI(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        FriendListProtocolService friendListProtocolService = new FriendListProtocolService();
        return friendListProtocolService.selectRegisteredUserFriendServiceAPI(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage insertGuestUserFriendAPI(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        FriendInsertService friendInsertService = new FriendInsertService();
        return null;
//        return friendInsertService.insertGuestUserFriendServiceAPI(ctx, unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage insertRegisteredUserFriendAPI(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        FriendInsertService friendInsertService = new FriendInsertService();
        return friendInsertService.insertRegisteredUserFriendServiceAPI(unifiedEntranceMessage, head);
    }

    public void deleteGuestUserFriendAPI(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        FriendDeleteService friendDeleteService = new FriendDeleteService();
        friendDeleteService.deleteGuestUserFriendServiceAPI(ctx, unifiedEntranceMessage, head);
    }

    public void deleteRegisteredUserFriendAPI(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        FriendDeleteService friendDeleteService = new FriendDeleteService();
        friendDeleteService.deleteRegisteredUserFriendServiceAPI(ctx, unifiedEntranceMessage, head);
    }

    public void selectGuestGroupAPI(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        GroupListProtocolService groupListProtocolService = new GroupListProtocolService();
        groupListProtocolService.selectGuestGroupAPIService(ctx, unifiedEntranceMessage, head);
    }

    public void selectRegisteredGroupAPI(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        GroupListProtocolService groupListProtocolService = new GroupListProtocolService();
        groupListProtocolService.selectRegisteredGroupAPIService(ctx, unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectTouristsGroupList(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        GroupSelectByGuestUserService groupSelectByGuestUserService = new GroupSelectByGuestUserService();
        return groupSelectByGuestUserService.selectByGuestGroup(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectRegisteredGroupList(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        GroupSelectByRegisteredUserService groupSelectByRegisteredUserService = new GroupSelectByRegisteredUserService();
        return groupSelectByRegisteredUserService.selectByRegisteredGroup(unifiedEntranceMessage, head);
    }

    public void createGuestGroup(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, ChannelHandlerContext ctx){
        GuestGroupCreateService guestGroupCreateService = new GuestGroupCreateService();
        guestGroupCreateService.createGuestGroupAPIService(unifiedEntranceMessage, ctx);
    }

    public void createRegisteredGroup(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, ChannelHandlerContext ctx){
        RegisteredGroupCreateService registeredGroupCreateService = new RegisteredGroupCreateService();
        registeredGroupCreateService.createRegisteredGroupAPIService(unifiedEntranceMessage, ctx);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectGuestGroupInformation(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        GuestGroupInfoService guestGroupInfoService = new GuestGroupInfoService();
        return guestGroupInfoService.selectGuestGroupInformation(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectRegisteredGroupInformation(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        RegisteredGroupInfoService registeredGroupInfoService = new RegisteredGroupInfoService();
        return registeredGroupInfoService.selectRegisteredGroupInformation(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage addTouristsGroupMemberInviteAgree(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        TouristsGroupMemberInviteAgreeService touristsGroupMemberInviteAgreeService = new TouristsGroupMemberInviteAgreeService();
        return touristsGroupMemberInviteAgreeService.addTouristsGroupMemberInviteAgree(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage addRegisteredGroupMemberInviteAgree(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        RegisteredGroupMemberInviteAgreeService registeredGroupMemberInviteAgreeService = new RegisteredGroupMemberInviteAgreeService();
        return registeredGroupMemberInviteAgreeService.addRegisteredGroupMemberInviteAgree(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage addTouristsGroupMemberApplyAgree(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        TouristsGroupMemberApplyAgreeService touristsGroupMemberApplyAgreeService = new TouristsGroupMemberApplyAgreeService();
        return touristsGroupMemberApplyAgreeService.addTouristsGroupMemberApplyAgree(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage addRegisteredGroupMemberApplyAgree(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        RegisteredGroupMemberApplyAgreeService registeredGroupMemberApplyAgreeService = new RegisteredGroupMemberApplyAgreeService();
        return registeredGroupMemberApplyAgreeService.addRegisteredGroupMemberApplyAgree(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage deleteTouristsGroupMember(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        DeleteTouristsGroupMemberService deleteTouristsGroupMemberService = new DeleteTouristsGroupMemberService();
        return deleteTouristsGroupMemberService.deleteTouristsGroupMember(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage deleteRegisteredGroupMember(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        DeleteRegisteredGroupMemberService deleteRegisteredGroupMemberService = new DeleteRegisteredGroupMemberService();
        return deleteRegisteredGroupMemberService.deleteRegisteredGroupMember(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage updateTouristsGroupAnnouncement(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        UpdateTouristsGroupAnnouncementService updateTouristsGroupAnnouncementService = new UpdateTouristsGroupAnnouncementService();
        return updateTouristsGroupAnnouncementService.updateTouristsGroupAnnouncement(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage updateRegisteredGroupAnnouncement(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        UpdateRegisteredGroupAnnouncementService updateRegisteredGroupAnnouncementService = new UpdateRegisteredGroupAnnouncementService();
        return updateRegisteredGroupAnnouncementService.updateRegisteredGroupAnnouncement(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectTouristsGroupAnnouncement(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        SelectTouristsGroupAnnouncementService selectTouristsGroupAnnouncementService = new SelectTouristsGroupAnnouncementService();
        return selectTouristsGroupAnnouncementService.selectTouristsGroupAnnouncement(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectRegisteredGroupAnnouncement(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        SelectRegisteredGroupAnnouncementService selectRegisteredGroupAnnouncementService = new SelectRegisteredGroupAnnouncementService();
        return selectRegisteredGroupAnnouncementService.selectRegisteredGroupAnnouncement(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage updateTouristsFriend(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        UpdateTouristsFriendService updateTouristsFriendService = new UpdateTouristsFriendService();
        return updateTouristsFriendService.updateTouristsFriend(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage updateRegisteredFriend(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        UpdateRegisteredFriendService updateRegisteredFriendService = new UpdateRegisteredFriendService();
        return updateRegisteredFriendService.updateRegisteredFriend(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage updateGuestGroup(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        GuestGroupUpdateService updateService = new GuestGroupUpdateService();
        return updateService.updateGuestGroup(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage updateRegisteredGroup(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        RegisteredGroupUpdateService updateService = new RegisteredGroupUpdateService();
        return updateService.updateRegisteredGroup(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage updateGuestGroupMemberRemark(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        TouristsGroupMemberUpdateRemarkService touristsGroupMemberUpdateRemarkService = new TouristsGroupMemberUpdateRemarkService();
        return touristsGroupMemberUpdateRemarkService.updateGuestGroupMemberRemark(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage updateRegisteredGroupMemberRemark(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, ChannelHandlerContext ctx){
        RegisteredGroupMemberUpdateRemarkService registeredGroupMemberUpdateRemarkService = new RegisteredGroupMemberUpdateRemarkService();
        return registeredGroupMemberUpdateRemarkService.updateRegisteredGroupMemberRemark(unifiedEntranceMessage, ctx);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectTouristsFriendInformation(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        SelectTouristsFriendInformationService selectTouristsFriendInformationService = new SelectTouristsFriendInformationService();
        return selectTouristsFriendInformationService.selectTouristsFriendInformation(unifiedEntranceMessage, head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectRegisteredFriendInformation(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        SelectRegisteredFriendInformationService selectRegisteredFriendInformationService = new SelectRegisteredFriendInformationService();
        return selectRegisteredFriendInformationService.selectRegisteredFriendInformation(unifiedEntranceMessage, head);
    }

    public void touristExitService(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, ChannelHandlerContext ctx){
        TouristInfoService tounistInfoService = new TouristInfoService();
        tounistInfoService.touristExitServcie(unifiedEntranceMessage,ctx);
    }

    public void inviteUserJoinGroup(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, ChannelHandlerContext ctx){
        RegisteredGroupUpdateService registeredGroupUpdateService = new RegisteredGroupUpdateService();
        registeredGroupUpdateService.inviteUserJoinGroup(unifiedEntranceMessage,ctx);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectGroupMembersInfoList(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage){
        return new GroupListProtocolService().selectGroupMembersInfoList(unifiedEntranceMessage);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage searchAllGroupByUserId(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, ChannelHandlerContext ctx){
        GroupListProtocolService groupListProtocolService = new GroupListProtocolService();
        return groupListProtocolService.searchAllGroupByUserId(unifiedEntranceMessage,ctx);
    }

    public void groupOwnerDeleteMember(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, ChannelHandlerContext ctx){
        GroupListProtocolService groupListProtocolService = new GroupListProtocolService();
        groupListProtocolService.GroupOwnerDeleteMember(unifiedEntranceMessage,ctx);
    }

    public void groupMemberExitGroup(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, ChannelHandlerContext ctx){
        GroupListProtocolService groupListProtocolService = new GroupListProtocolService();
        groupListProtocolService.GroupMemberExitGroup(unifiedEntranceMessage,ctx);
    }
}
