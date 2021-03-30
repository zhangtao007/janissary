package com.lanjiu.im.grpc.client.service;

import com.lanjiu.im.grpc.*;

public class StorageAPI {

    /**
     * 创建游客群接口
     */
    public GuestGroupResponse insertGuestGroupAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.insertGuestGroupService(request);
    }

    /**
     * 创建注册群接口
     */
    public RegisteredGroupResponse insertRegisteredGroupAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.insertRegisteredGroupService(request);
    }

    /**
     * 创建游客群成员接口
     */
    public GuestGroupMemberResponse insertGuestGroupMemberAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.insertGuestGroupMemberService(request);
    }

    /**
     * 创建注册群成员接口
     */
    public RegisteredGroupMemberResponse insertRegisteredGroupMemberAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.insertRegisteredGroupMemberService(request);
    }

    /**
     * 创建注册好友接口
     */
    public RegisteredUserFriendResponse insertRegisteredUserFriendAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.insertRegisteredUserFriendService(request);
    }

    /**
     * 查询某注册用户的群列表接口----》一个注册绑定多个注册群成员----->一个注册群成员绑定一个群(可能是注册群也可能是游客群)
     * 1.某个注册用户关联的注册群成员列表和群列表（包含注册群和游客群）(GROUP_SELECT_TYPE_BY_GUEST_USER_ID)
     */
    public RegisteredGroupResponse selectRegisteredGroupAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.selectRegisteredGroupService(request);
    }

    /**
     * 查询某游客用户的群列表接口----》一个游客绑定多个游客群成员----->一个游客群成员绑定一个群(可能是注册群也可能是游客群)
     * 1.某个游客用户关联的游客群成员列表和群列表（包含注册群和游客群）(GROUP_SELECT_TYPE_BY_GUEST_USER_ID)
     */
    public GuestGroupResponse selectGuestGroupAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.selectGuestGroupService(request);
    }

    /**
     * 查询某游客好友列表接口
     */
    public GuestUserFriendResponse selectGuestUserFriendAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.selectGuestUserFriendService(request);
    }

    /**
     * 查询某注册好友列表接口
     */
    public RegisteredUserFriendResponse selectRegisteredUserFriendAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.selectRegisteredUserFriendService(request);
    }

    /**
     * 查询群公告信息
     */
    public GroupAnnouncementsResponse selectGroupAnnouncementsAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.selectGroupAnnouncementsService(request);
    }

    /**
     * 更新群备注信息
     */
    public GroupRemarkResponse updateGroupRemarkAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.updateGroupRemarkService(request);
    }

    /**
     * 更新群公共信息
     */
    public GroupAnnouncementsResponse updateGroupAnnouncementsAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.updateGroupAnnouncementsService(request);
    }

    /**
     * 更新游客好友信息
     */
    public GuestUserFriendResponse updateGuestUserFriendAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.updateGuestUserFriendService(request);
    }

    /**
     * 更新注册好友信息
     */
    public RegisteredUserFriendResponse updateRegisteredUserFriendAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.updateRegisteredUserFriendService(request);
    }

    /**
     * 更新游客群信息
     */
    public GuestGroupResponse updateGuestGroupAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.updateGuestGroupService(request);
    }

    /**
     * 更新注册群信息
     */
    public RegisteredGroupResponse updateRegisteredGroupAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.updateRegisteredGroupService(request);
    }

    /**
     * 更新注册群成员信息
     */
    public RegisteredGroupMemberResponse updateRegisteredGroupMemberAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.updateRegisteredGroupMemberService(request);
    }

    /**
     * 删除游客好友信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    public GuestUserFriendResponse deleteGuestUserFriendAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.deleteGuestUserFriendService(request);
    }

    /**
     * 删除注册好友信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    public RegisteredUserFriendResponse deleteRegisteredUserFriendAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.deleteRegisteredUserFriendService(request);
    }

    /**
     * 删除游客群成员信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    public GuestGroupMemberResponse deleteGuestGroupMemberAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.deleteGuestGroupMemberService(request);
    }

    /**
     * 删除注册群成员信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    public RegisteredGroupMemberResponse deleteRegisteredGroupMemberAPI(TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.deleteRegisteredGroupMemberService(request);
    }

    /**
     *  邀请用户加入群服务--邀请注册和游客都可以
     */
    public AllGroupsMemberResponse inviteUsersJoinGroup(TransmissionRequest request){
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.insertInviteUsersJoinGroupService(request);
    }

    /**
     *  获取所有群成员列表信息
     */
    public AllGroupsMemberResponse selectGroupMembersInfoList(SelectGroupMemberRequest request){
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.selectGroupMembersInfoList(request);
    }

    /**
     *  获取所有群成员列表信息
     */
    public AllGroupsMemberResponse queryGroupMembersInfoList(SelectGroupMemberRequest request){
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.queryGroupMembersInfoList(request);
    }

    public AllGroupsMemberResponse touristExitServcie(TransmissionRequest request){
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.touristExitServcie(request);
    }

    public AllGroupsMemberResponse searchAllGroupByUserId(TransmissionRequest request){
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.searchAllGroupByUserId(request);
    }

    public AllGroupsMemberResponse groupOwnerDeleteMember(TransmissionRequest request){
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.GroupOwnerDeleteMember(request);
    }

    public AllGroupsMemberResponse groupMemberExitGroup(TransmissionRequest request){
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.groupMemberExitGroup(request);
    }

    public RegisteredGroupMemberResponse updateRegisteredGroupMemberRemark(TransmissionRequest request){
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.updateRegisteredGroupMemberRemark(request);
    }

    public GroupMemberNicknameResponse selectGroupMemberNickname(TransmissionRequest request) {
        return new LinkTransferCommunication().selectGroupMemberNickname(request);
    }

    public AllGroupsMemberResponse insertGroupPhotoUrl(TransmissionRequest request){
        return new LinkTransferCommunication().insertGroupPhotoUrl(request);
    }

}
