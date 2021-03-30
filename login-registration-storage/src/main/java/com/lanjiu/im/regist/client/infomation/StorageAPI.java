package com.lanjiu.im.regist.client.infomation;


import com.lanjiu.im.grpc.*;
import org.apache.log4j.Logger;

public class StorageAPI {

    private static final Logger logger = Logger.getLogger(StorageAPI.class.getName());

    /**
     * 创建群备注接口
     */
    public GroupRemarkResponse insertGroupRemarkAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GroupRemarkResponse groupRemarkResponse = linkTransferCommunication.insertGroupRemarkService(request);
        return groupRemarkResponse;
    }

    /**
     * 创建游客群接口
     */
    public GuestGroupResponse insertGuestGroupAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GuestGroupResponse guestGroupResponse = linkTransferCommunication.insertGuestGroupService(request);
        return guestGroupResponse;
    }

    /**
     * 创建注册群接口
     */
    public RegisteredGroupResponse insertRegisteredGroupAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        RegisteredGroupResponse registeredGroupResponse = linkTransferCommunication.insertRegisteredGroupService(request);
        return registeredGroupResponse;
    }

    /**
     * 创建游客群成员接口
     */
    public GuestGroupMemberResponse insertGuestGroupMemberAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GuestGroupMemberResponse guestGroupMemberResponse = linkTransferCommunication.insertGuestGroupMemberService(request);
        return guestGroupMemberResponse;
    }

    /**
     * 创建注册群成员接口
     */
    public RegisteredGroupMemberResponse insertRegisteredGroupMemberAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        RegisteredGroupMemberResponse registeredGroupMemberResponse = linkTransferCommunication.insertRegisteredGroupMemberService(request);
        return registeredGroupMemberResponse;
    }

    /**
     * 创建游客好友接口
     */
    public GuestUserFriendResponse insertGuestUserFriendAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GuestUserFriendResponse guestUserFriendResponse = linkTransferCommunication.insertGuestUserFriendService(request);
        return guestUserFriendResponse;
    }

    /**
     * 创建注册好友接口
     */
    public RegisteredUserFriendResponse insertRegisteredUserFriendAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        RegisteredUserFriendResponse registeredUserFriendResponse = linkTransferCommunication.insertRegisteredUserFriendService(request);
        return registeredUserFriendResponse;
    }

    /**
     * 查询某注册用户的群列表接口----》一个注册绑定多个注册群成员----->一个注册群成员绑定一个群(可能是注册群也可能是游客群)
     * 1.某个注册用户关联的注册群成员列表和群列表（包含注册群和游客群）(GROUP_SELECT_TYPE_BY_GUEST_USER_ID)
     */
    public RegisteredGroupResponse selectRegisteredGroupAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        RegisteredGroupResponse registeredGroupResponse = linkTransferCommunication.selectRegisteredGroupService(request);
        return registeredGroupResponse;
    }

    /**
     * 查询某游客用户的群列表接口----》一个游客绑定多个游客群成员----->一个游客群成员绑定一个群(可能是注册群也可能是游客群)
     * 1.某个游客用户关联的游客群成员列表和群列表（包含注册群和游客群）(GROUP_SELECT_TYPE_BY_GUEST_USER_ID)
     */
    public GuestGroupResponse selectGuestGroupAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GuestGroupResponse registeredGroupResponse = linkTransferCommunication.selectGuestGroupService(request);
        return registeredGroupResponse;
    }

    /**
     * 查询某游客的游客群成员列表接口----》一个游客绑定多个游客群成员
     */
    public RegisteredGroupMemberResponse selectRegisteredGroupMemberAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        RegisteredGroupMemberResponse registeredGroupMemberResponse = linkTransferCommunication.selectRegisteredGroupMemberService(request);
        return registeredGroupMemberResponse;
    }

    /**
     * 查询某游客的游客群成员列表接口----》一个游客绑定多个游客群成员
     */
    public GuestGroupMemberResponse selectGuestGroupMemberAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GuestGroupMemberResponse guestGroupMemberResponse = linkTransferCommunication.selectGuestGroupMemberService(request);
        return guestGroupMemberResponse;
    }

    /**
     * 查询某游客好友列表接口
     */
    public GuestUserFriendResponse selectGuestUserFriendAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GuestUserFriendResponse guestUserFriendResponse = linkTransferCommunication.selectGuestUserFriendService(request);
        return guestUserFriendResponse;
    }

    /**
     * 查询某注册好友列表接口
     */
    public RegisteredUserFriendResponse selectRegisteredUserFriendAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        RegisteredUserFriendResponse registeredUserFriendResponse = linkTransferCommunication.selectRegisteredUserFriendService(request);
        return registeredUserFriendResponse;
    }

    /**
     * 查询阅后即焚优先级列表
     */
    public BurnAfterReadingPriorityResponse selectBurnAfterReadingPriorityAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        BurnAfterReadingPriorityResponse burnAfterReadingPriorityResponse = linkTransferCommunication.selectBurnAfterReadingPriorityService(request);
        return burnAfterReadingPriorityResponse;
    }

    /**
     * 查询离线消息优先级列表
     */
    public OfflineMessagePriorityResponse selectOfflineMessagePriorityAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        OfflineMessagePriorityResponse offlineMessagePriorityResponse = linkTransferCommunication.selectOfflineMessagePriorityService(request);
        return offlineMessagePriorityResponse;
    }

    /**
     * 查询群公告信息
     */
    public GroupAnnouncementsResponse selectGroupAnnouncementsAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GroupAnnouncementsResponse groupAnnouncementsResponse = linkTransferCommunication.selectGroupAnnouncementsService(request);
        return groupAnnouncementsResponse;
    }

    /**
     * 查询群备注信息
     */
    public GroupRemarkResponse selectGroupRemarkAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GroupRemarkResponse groupRemarkResponse = linkTransferCommunication.selectGroupRemarkService(request);
        return groupRemarkResponse;
    }

    /**
     * 更新群备注信息
     */
    public GroupRemarkResponse updateGroupRemarkAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GroupRemarkResponse groupRemarkResponse = linkTransferCommunication.updateGroupRemarkService(request);
        return groupRemarkResponse;
    }

    /**
     * 更新群公共信息
     */
    public GroupAnnouncementsResponse updateGroupAnnouncementsAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GroupAnnouncementsResponse groupAnnouncementsResponse = linkTransferCommunication.updateGroupAnnouncementsService(request);
        return groupAnnouncementsResponse;
    }

    /**
     * 更新游客好友信息
     */
    public GuestUserFriendResponse updateGuestUserFriendAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GuestUserFriendResponse guestUserFriendResponse = linkTransferCommunication.updateGuestUserFriendService(request);
        return guestUserFriendResponse;
    }

    /**
     * 更新注册好友信息
     */
    public RegisteredUserFriendResponse updateRegisteredUserFriendAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        RegisteredUserFriendResponse registeredUserFriendResponse = linkTransferCommunication.updateRegisteredUserFriendService(request);
        return registeredUserFriendResponse;
    }

    /**
     * 更新游客群信息
     */
    public GuestGroupResponse updateGuestGroupAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GuestGroupResponse guestGroupResponse = linkTransferCommunication.updateGuestGroupService(request);
        return guestGroupResponse;
    }

    /**
     * 更新注册群信息
     */
    public RegisteredGroupResponse updateRegisteredGroupAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        RegisteredGroupResponse guestGroupResponse = linkTransferCommunication.updateRegisteredGroupService(request);
        return guestGroupResponse;
    }

    /**
     * 更新游客群成员信息
     */
    public GuestGroupMemberResponse updateGuestGroupMemberAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GuestGroupMemberResponse guestGroupMemberResponse = linkTransferCommunication.updateGuestGroupMemberService(request);
        return guestGroupMemberResponse;
    }

    /**
     * 更新注册群成员信息
     */
    public RegisteredGroupMemberResponse updateRegisteredGroupMemberAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        RegisteredGroupMemberResponse registeredGroupMemberResponse = linkTransferCommunication.updateRegisteredGroupMemberService(request);
        return registeredGroupMemberResponse;
    }

    /**
     * 删除群备注信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    public GroupRemarkResponse deleteGroupRemarkAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GroupRemarkResponse groupRemarkResponse = linkTransferCommunication.deleteGroupRemarkService(request);
        return groupRemarkResponse;
    }

    /**
     * 删除游客好友信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    public GuestUserFriendResponse deleteGuestUserFriendAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GuestUserFriendResponse guestUserFriendResponse = linkTransferCommunication.deleteGuestUserFriendService(request);
        return guestUserFriendResponse;
    }

    /**
     * 删除注册好友信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    public RegisteredUserFriendResponse deleteRegisteredUserFriendAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        RegisteredUserFriendResponse guestUserFriendResponse = linkTransferCommunication.deleteRegisteredUserFriendService(request);
        return guestUserFriendResponse;
    }

    /**
     * 删除游客群信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    public GuestGroupResponse deleteGuestGroupAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GuestGroupResponse guestUserFriendResponse = linkTransferCommunication.deleteGuestGroupService(request);
        return guestUserFriendResponse;
    }

    /**
     * 删除注册群信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    public RegisteredGroupResponse deleteRegisteredGroupAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        RegisteredGroupResponse registeredGroupResponse = linkTransferCommunication.deleteRegisteredGroupService(request);
        return registeredGroupResponse;
    }

    /**
     * 删除游客群成员信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    public GuestGroupMemberResponse deleteGuestGroupMemberAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GuestGroupMemberResponse guestGroupMemberResponse = linkTransferCommunication.deleteGuestGroupMemberService(request);
        return guestGroupMemberResponse;
    }

    /**
     * 删除注册群成员信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    public RegisteredGroupMemberResponse deleteRegisteredGroupMemberAPI(TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        RegisteredGroupMemberResponse registeredGroupMemberResponse = linkTransferCommunication.deleteRegisteredGroupMemberService(request);
        return registeredGroupMemberResponse;
    }

//    public static void main(String[] args) {
//        StorageAPI storageAPI = new StorageAPI();
//        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
//                .setRequestKind(ConstantsSelectKind.REGISTERED_GROUP_MEMBER_SELECT_TYPE_BY_REGISTERED_USER_ID)
//                .setRegisteredGroupMember(RpcRegisteredGroupMember.newBuilder().setRegisteredUserId(11).build())
//                .build();
//        RegisteredGroupMemberResponse registeredGroupMemberResponse = storageAPI.selectRegisteredGroupMember(transmissionRequest);
//        List<RpcRegisteredGroupMember> list = registeredGroupMemberResponse.getResponseDataList();
//        for (RpcRegisteredGroupMember rpcRegisteredGroupMember : list){
//            logger.info(rpcRegisteredGroupMember.getRegisteredUserId());
//            logger.info("getGroupMemberId: " + rpcRegisteredGroupMember.getGroupMemberId());
//            logger.info("getGroupRemarks: " + rpcRegisteredGroupMember.getGroupRemarks());
//            logger.info(rpcRegisteredGroupMember.getGroupEntryTime());
//        }
//    }



//    public static void main(String[] args) {
//        StorageAPI storageAPI = new StorageAPI();
//        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
//                .setRequestKind(ConstantsSelectKind.GUEST_GROUP_MEMBER_SELECT_TYPE_BY_GUEST_USER_ID)
//                .setGuestGroupMember(RpcGuestGroupMember.newBuilder().setGuestUserId(11).build())
//                .build();
//        GuestGroupMemberResponse guestGroupMemberResponse = storageAPI.selectGuestGroupMember(transmissionRequest);
//        List<RpcGuestGroupMember> list = guestGroupMemberResponse.getResponseDataList();
//        for (RpcGuestGroupMember rpcGuestGroupMember : list){
//            logger.info(rpcGuestGroupMember.getGuestUserId());
//            logger.info("getGroupMemberId: " + rpcGuestGroupMember.getGroupMemberId());
//            logger.info("getGroupRemarks: " + rpcGuestGroupMember.getGroupRemarks());
//            logger.info(rpcGuestGroupMember.getGroupEntryTime());
//        }
//    }
//    public static void main(String[] args) {
//        StorageAPI storageAPI = new StorageAPI();
//        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
//                .setRequestKind(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_REGISTERED_USER_ID)
//                .setRegisteredUserFriend(RpcRegisteredUserFriend.newBuilder().setRegisteredUserId(222222).build())
//                .build();
//        RegisteredUserFriendResponse registeredUserFriendResponse = storageAPI.selectRegisteredUserFriend(transmissionRequest);
//        List<RpcRegisteredUserFriend> list = registeredUserFriendResponse.getResponseDataList();
//        for (RpcRegisteredUserFriend rpcRegisteredUserFriend : list){
//            logger.info(rpcRegisteredUserFriend.getRegisteredUserId());
//            logger.info("getFriendId: " + rpcRegisteredUserFriend.getFriendId());
//            logger.info("getFriendUserId: " + rpcRegisteredUserFriend.getFriendUserId());
//            logger.info(rpcRegisteredUserFriend.getFriendNickName());
//        }
//    }
//    public static void main(String[] args) {
//        StorageAPI storageAPI = new StorageAPI();
//        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
//                .setBeautifulNumberCommon(RpcBeautifulNumberCommon.newBuilder()
//                        .setTenMillion(1)
//                        .setOneMillion(1)
//                        .setOneHundredThousand(1)
//                        .setTenThousand(1)
//                        .setOneThousand(1)
//                        .build())
//                .setGuestUserFriend(RpcGuestUserFriend.newBuilder().setGuestUserId(111111).setFriendUserId(33).build())
//                //.setGuestUserFriend(RpcGuestUserFriend.newBuilder().setGuestUserId(111111).build())
//                .build();
//        GuestUserFriendResponse guestUserFriendResponse = storageAPI.insertGuestUserFriend(transmissionRequest);
//        List<RpcGuestUserFriend> list = guestUserFriendResponse.getResponseDataList();
//        for (RpcGuestUserFriend rpcGuestUserFriend : list){
//            logger.info(rpcGuestUserFriend.getGuestUserId());
//            logger.info("getFriendId: " + rpcGuestUserFriend.getFriendId());
//            logger.info("getFriendUserId: " + rpcGuestUserFriend.getFriendUserId());
//            logger.info(rpcGuestUserFriend.getFriendNickName());
//        }
//    }
//        public static void main(String[] args) {
//        StorageAPI storageAPI = new StorageAPI();
//        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
//                .setBeautifulNumberCommon(RpcBeautifulNumberCommon.newBuilder()
//                        .setTenMillion(1)
//                        .setOneMillion(1)
//                        .setOneHundredThousand(1)
//                        .setTenThousand(1)
//                        .setOneThousand(1)
//                        .build())
//                .setRegisteredUserFriend(RpcRegisteredUserFriend.newBuilder().setRegisteredUserId(222222).setFriendUserId(22).build())
//                //.setGuestUserFriend(RpcGuestUserFriend.newBuilder().setGuestUserId(111111).build())
//                .build();
//        RegisteredUserFriendResponse registeredUserFriendResponse = storageAPI.insertRegisteredUserFriend(transmissionRequest);
//        List<RpcRegisteredUserFriend> list = registeredUserFriendResponse.getResponseDataList();
//        for (RpcRegisteredUserFriend rpcRegisteredUserFriend : list){
//            logger.info(rpcRegisteredUserFriend.getRegisteredUserId());
//            logger.info("getFriendId: " + rpcRegisteredUserFriend.getFriendId());
//            logger.info("getFriendUserId: " + rpcRegisteredUserFriend.getFriendUserId());
//            logger.info(rpcRegisteredUserFriend.getFriendNickName());
//        }
//    }

//    public static void main(String[] args) {
//        StorageAPI storageAPI = new StorageAPI();
//        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
//                .setRequestKind(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_GUEST_USER_ID)
//                .setGuestUserFriend(RpcGuestUserFriend.newBuilder().setGuestUserId(111111).build())
//                //.setGuestUserFriend(RpcGuestUserFriend.newBuilder().setGuestUserId(111111).build())
//                .build();
//        GuestUserFriendResponse guestUserFriendResponse = storageAPI.selectGuestUserFriend(transmissionRequest);
//        List<RpcGuestUserFriend> list = guestUserFriendResponse.getResponseDataList();
//        for (RpcGuestUserFriend rpcGuestUserFriend : list){
//            logger.info(rpcGuestUserFriend.getGuestUserId());
//            logger.info("getFriendId: " + rpcGuestUserFriend.getFriendId());
//            logger.info(rpcGuestUserFriend.getFriendNickName());
//        }
//    }

//    public static void main(String[] args) {
//        StorageAPI storageAPI = new StorageAPI();
//        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
//                .setBeautifulNumberCommon(RpcBeautifulNumberCommon.newBuilder()
//                        .setTenMillion(1)
//                        .setOneMillion(1)
//                        .setOneHundredThousand(1)
//                        .setTenThousand(1)
//                        .setOneThousand(1)
//                        .build())
//                .setRegisteredUserFriend(RpcRegisteredUserFriend.newBuilder().setRegisteredUserId(222222).build())
//                //.setGuestUserFriend(RpcGuestUserFriend.newBuilder().setGuestUserId(111111).build())
//                .build();
//        RegisteredUserFriendResponse registeredUserFriendResponse = storageAPI.insertRegisteredUserFriend(transmissionRequest);
//        List<RpcRegisteredUserFriend> list = registeredUserFriendResponse.getResponseDataList();
//        for (RpcRegisteredUserFriend rpcRegisteredUserFriend : list){
//            logger.info(rpcRegisteredUserFriend.getRegisteredUserId());
//            logger.info("getFriendId: " + rpcRegisteredUserFriend.getFriendId());
//            logger.info(rpcRegisteredUserFriend.getFriendNickName());
//        }
//    }
//    public static void main(String[] args) {
//        StorageAPI storageAPI = new StorageAPI();
//        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
//                .setBeautifulNumberCommon(RpcBeautifulNumberCommon.newBuilder()
//                        .setTenMillion(1)
//                        .setOneMillion(1)
//                        .setOneHundredThousand(1)
//                        .setTenThousand(1)
//                        .setOneThousand(1)
//                        .build())
//                .setGuestUserFriend(RpcGuestUserFriend.newBuilder().setGuestUserId(111111).build())
//                //.setGuestUserFriend(RpcGuestUserFriend.newBuilder().setGuestUserId(111111).build())
//                .build();
//        GuestUserFriendResponse guestUserFriendResponse = storageAPI.insertGuestUserFriend(transmissionRequest);
//        List<RpcGuestUserFriend> list = guestUserFriendResponse.getResponseDataList();
//        for (RpcGuestUserFriend rpcGuestUserFriend : list){
//            logger.info(rpcGuestUserFriend.getGuestUserId());
//            logger.info("getFriendId: " + rpcGuestUserFriend.getFriendId());
//            logger.info(rpcGuestUserFriend.getFriendNickName());
//        }
//    }

//    public static void main(String[] args) {
//        StorageAPI storageAPI = new StorageAPI();
//        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
//                .setBeautifulNumberCommon(RpcBeautifulNumberCommon.newBuilder()
//                        .setTenMillion(1)
//                        .setOneMillion(1)
//                        .setOneHundredThousand(1)
//                        .setTenThousand(1)
//                        .setOneThousand(1)
//                        .build())
//                .setRegisteredGroup(RpcRegisteredGroup.newBuilder().setGroupId(10010010).build())
//                //.setGuestGroup(RpcGuestGroup.newBuilder().setGroupId(70010010).build())
//                .setRegisteredGroupMember(RpcRegisteredGroupMember.newBuilder().setGroupRemarks("ok2").setRegisteredUserId(11).build())
//                .build();
//        RegisteredGroupMemberResponse registeredGroupMemberResponse = storageAPI.insertRegisteredGroupMember(transmissionRequest);
//        List<RpcRegisteredGroupMember> list = registeredGroupMemberResponse.getResponseDataList();
//        for (RpcRegisteredGroupMember rpcRegisteredGroupMember : list){
//            logger.info(rpcRegisteredGroupMember.getOfflineMessageSetting());
//            logger.info(rpcRegisteredGroupMember.getGroupEntryTime());
//            logger.info(rpcRegisteredGroupMember.getRegisteredUserId());
//            logger.info("getGroupId : " + rpcRegisteredGroupMember.getGroupMemberId());
//        }
//    }
//    public static void main(String[] args) {
//        StorageAPI storageAPI = new StorageAPI();
//        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
//                .setBeautifulNumberCommon(RpcBeautifulNumberCommon.newBuilder()
//                        .setTenMillion(1)
//                        .setOneMillion(1)
//                        .setOneHundredThousand(1)
//                        .setTenThousand(1)
//                        .setOneThousand(1)
//                        .build())
//                //.setRegisteredGroup(RpcRegisteredGroup.newBuilder().setGroupId(10010010).build())
//                .setGuestGroup(RpcGuestGroup.newBuilder().setGroupId(70010010).build())
//                .setGuestGroupMember(RpcGuestGroupMember.newBuilder().setGroupRemarks("ok").setGuestUserId(11).build())
//                .build();
//        GuestGroupMemberResponse guestGroupMemberResponse = storageAPI.insertGuestGroupMember(transmissionRequest);
//        List<RpcGuestGroupMember> list = guestGroupMemberResponse.getResponseDataList();
//        for (RpcGuestGroupMember rpcGuestGroupMember : list){
//            logger.info(rpcGuestGroupMember.getOfflineMessageSetting());
//            logger.info(rpcGuestGroupMember.getGroupEntryTime());
//            logger.info(rpcGuestGroupMember.getGuestUserId());
//            logger.info("getGroupId : " + rpcGuestGroupMember.getGroupMemberId());
//        }
//    }

//    public static void main(String[] args) {
//        StorageAPI storageAPI = new StorageAPI();
//        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
//                .setBeautifulNumberCommon(RpcBeautifulNumberCommon.newBuilder()
//                        .setTenMillion(1)
//                        .setOneMillion(1)
//                        .setOneHundredThousand(1)
//                        .setTenThousand(1)
//                        .setOneThousand(1)
//                        .build())
//                .setGuestGroup(RpcGuestGroup.newBuilder().setAmount(20).setGroupName("junjun").setGuestUserId(222))
//                .build();
//        GuestGroupResponse guestGroupResponse = storageAPI.insertGuestGroup(transmissionRequest);
//        List<RpcGuestGroup> list = guestGroupResponse.getResponseDataList();
//        for (RpcGuestGroup rpcGuestGroup : list){
//            logger.info(rpcGuestGroup.getCreationTime());
//            logger.info(rpcGuestGroup.getGroupName());
//            logger.info(rpcGuestGroup.getGroupName());
//            logger.info("getGroupId : " + rpcGuestGroup.getGroupId());
//        }
//    }
//    public static void main(String[] args) {
//        StorageAPI storageAPI = new StorageAPI();
//        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
//                .setBeautifulNumberCommon(RpcBeautifulNumberCommon.newBuilder()
//                        .setTenMillion(1)
//                        .setOneMillion(1)
//                        .setOneHundredThousand(1)
//                        .setTenThousand(1)
//                        .setOneThousand(1)
//                        .build())
//                .setRegisteredGroup(RpcRegisteredGroup.newBuilder().setAmount(20).setGroupName("junjun").setRegisteredUserId(222))
//                .build();
//        RegisteredGroupResponse guestGroupResponse = storageAPI.insertRegisteredGroup(transmissionRequest);
//        List<RpcRegisteredGroup> list = guestGroupResponse.getResponseDataList();
//        for (RpcRegisteredGroup rpcRegisteredGroup : list){
//            logger.info(rpcRegisteredGroup.getCreationTime());
//            logger.info(rpcRegisteredGroup.getGroupName());
//            logger.info(rpcRegisteredGroup.getGroupName());
//            logger.info("getGroupId : " + rpcRegisteredGroup.getGroupId());
//        }
//    }
}
