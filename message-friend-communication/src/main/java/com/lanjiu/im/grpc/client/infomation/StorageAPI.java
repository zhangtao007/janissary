package com.lanjiu.im.grpc.client.infomation;

import com.lanjiu.im.grpc.InformationStorageProto;
import org.apache.log4j.Logger;

public class StorageAPI {

    private static final Logger logger = Logger.getLogger(StorageAPI.class.getName());



    /**
     * 查询某注册好友列表接口
     */
    public InformationStorageProto.AllGroupsMemberResponse deleteGuestRelatedAllInfo(InformationStorageProto.TransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        InformationStorageProto.AllGroupsMemberResponse registeredUserFriendResponse = linkTransferCommunication.deleteGuestRelatedAllInfo(request);
        return registeredUserFriendResponse;
    }

    public InformationStorageProto.RpcRegisteredUserFriend queryUserFriendRelation(InformationStorageProto.TransmissionRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        InformationStorageProto.RpcRegisteredUserFriend rpcRegisteredUserFriend = linkTransferCommunication.queryUserFriendRelation(request);
        return rpcRegisteredUserFriend;
    }





//    public static void main(String[] args) {
//        boolean frindOffMsgSetting;
//        StorageAPI storageAPI = new StorageAPI();
//        TransmissionRequest request = TransmissionRequest.newBuilder().setRequestKind(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_FRIEND_USER_ID)
//                .setRegisteredUserFriend(RpcRegisteredUserFriend.newBuilder()
//                        .setRegisteredUserId(10010087)
//                        .setFriendUserId(10010064).build()).build();
//        RpcRegisteredUserFriend rpcRegisteredUserFriend = storageAPI.queryUserFriendRelation(request);
//        System.out.println("");
//




//        for(RpcRegisteredUserFriend rruf : responseDataList){
//            if((rruf.getRegisteredUserId() == Integer.parseInt(10010087)) && rruf.getFriendUserId() == Integer.parseInt(toId)){
//                frindOffMsgSetting = rruf.getOfflineMessageSetting().equals("on") ? true : false;
//            }
//        }
//        for (RpcRegisteredGroupMember rpcRegisteredGroupMember : list){
//            logger.info(rpcRegisteredGroupMember.getRegisteredUserId());
//            logger.info("getGroupMemberId: " + rpcRegisteredGroupMember.getGroupMemberId());
//            logger.info("getGroupRemarks: " + rpcRegisteredGroupMember.getGroupRemarks());
//            logger.info(rpcRegisteredGroupMember.getGroupEntryTime());
//        }
    }



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
//}
