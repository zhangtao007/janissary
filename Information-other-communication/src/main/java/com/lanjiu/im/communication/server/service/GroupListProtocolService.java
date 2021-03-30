package com.lanjiu.im.communication.server.service;

import com.google.gson.Gson;
import com.lanjiu.im.communication.server.ResponseUtil;
import com.lanjiu.im.communication.util.ConstantsContent;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.file.fileTransferAPI.FileStorageAPI;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.im.grpc.client.util.ConstantsSelectKind;
import com.lanjiu.im.login.client.registLoginAPI.RegistUserAPI;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import com.lanjiu.pro.fileStorage.GroupAvatarRequest;
import com.lanjiu.pro.fileStorage.GroupAvatarResponse;
import com.lanjiu.pro.login.*;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;

public class GroupListProtocolService {

    private final Logger logger = Logger.getLogger(GroupListProtocolService.class);

    private static final Pattern pattern = Pattern.compile("[0-9]*");

    public void selectGuestGroupAPIService(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        //还需以被添加人的角色检索记录
        StorageAPI storageAPI = new StorageAPI();
        TransmissionRequest transmissionRequest;
        GroupUtils groupUtils = new GroupUtils();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response;
        //装载grpc协议请求信息
        String keyword = unifiedEntranceMessage.getFindGroupProtocol().getSearch().getKeyword();
        logger.info("查找群的群ID-----："+keyword);
        transmissionRequest = TransmissionRequest.newBuilder().setRequestKind(keyword).build();
        GuestGroupResponse guestGroupResponse = storageAPI.selectGuestGroupAPI(transmissionRequest);
        response = groupUtils.guestGroupList(unifiedEntranceMessage, guestGroupResponse, head);
        ctx.writeAndFlush(response);
    }

    public void selectRegisteredGroupAPIService(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        StorageAPI storageAPI = new StorageAPI();
        TransmissionRequest transmissionRequest;
        List<RpcRegisteredGroup> list;
        GroupUtils groupUtils = new GroupUtils();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response ;
        List<BusinessProtocolEntities.RegisteredGroup>  registeredGroupList = unifiedEntranceMessage.getFindGroupProtocol().getRegisteredGroupList();
        for(BusinessProtocolEntities.RegisteredGroup registeredGroup : registeredGroupList){

            if(IMSContacts.UserType.REGISTERED_USER.equals(registeredGroup.getGroupType())){
                transmissionRequest = TransmissionRequest.newBuilder()
                        .setRequestKind(ConstantsSelectKind.GROUP_SELECT_TYPE_BY_REGISTERED_GROUP_ID)
                        .setRegisteredGroup(RpcRegisteredGroup.newBuilder().setGroupId(Integer.parseInt(registeredGroup.getGroupId())).build())
                        .build();
                logger.info("搜索群的ID："+registeredGroup.getGroupId());
                RegisteredGroupResponse registeredGroupResponse = storageAPI.selectRegisteredGroupAPI(transmissionRequest);
                if (registeredGroupResponse.getStatusDetail().equals(ConstantsContent.RESPONSE_FAILURE)){
                    JCRC32 jcrc32 = new JCRC32();
                    BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                            .newBuilder()
                            .setFindGroupProtocol(unifiedEntranceMessage.getFindGroupProtocol())
                            .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                    .setMsgType(head.getMsgType())
                                    .setStatusReport(ResponseStatus.STATUS_REPORT_NO_EXIST)
                                    .setToId(head.getToId())
                                    .setFromId(head.getFromId())
                                    .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                                    .setToken(head.getToken())
                                    .setUniqueIdentify(head.getUniqueIdentify())
                                    .setMsgContentType(head.getMsgContentType())
                                    .build()
                            ).build();
                    response = jcrc32.packageCheckSum(message);

                }else {
                    list = registeredGroupResponse.getResponseRegisteredGroupList();
                    response = groupUtils.registeredGroupList(unifiedEntranceMessage, list, head);
                }
                ctx.writeAndFlush(response);
            }
        }
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectGroupMembersInfoList(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage){
        BusinessProtocolEntities.RegisteredGroup registeredGroup = unifiedEntranceMessage.getGroupInfoProtocol().getRegisteredGroup();
        String fromId = unifiedEntranceMessage.getHead().getFromId();
        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
                                                .setRequestKind(String.valueOf(registeredGroup.getGroupId()))
                                                .setRegisteredGroupMember(RpcRegisteredGroupMember.newBuilder().setRegisteredUserId(Integer.parseInt(fromId)).build())
                                                .build();

        StorageAPI storageAPI = new StorageAPI();
        FileStorageAPI fileStorageAPI = new FileStorageAPI();
        RegistUserAPI registUserAPI = new RegistUserAPI();
        logger.info("查询群成员列表群ID："+registeredGroup.getGroupId());
        //获取所有群成员列表
        SelectGroupMemberRequest request2 = SelectGroupMemberRequest.newBuilder().setGroupId(registeredGroup.getGroupId()).build();
        AllGroupsMemberResponse allGroupsMemberResponse = storageAPI.queryGroupMembersInfoList(request2);
//        AllGroupsMemberResponse allGroupsMemberResponse = storageAPI.inviteUsersJoinGroup(transmissionRequest);
        List<AllGroupMemberVO> responseGroupMemberVoList = allGroupsMemberResponse.getResponseGroupMemberVoList();
        logger.info("查询群成员列表返回数据："+responseGroupMemberVoList.size());
        String groupPhotoUrl = responseGroupMemberVoList.get(0).getUserPhoto();//群头像字段
        String grpcPhotoUrl ="";
        List<AllGroupMemberVO> list = new ArrayList<>();
        List<String> userIdList = new ArrayList<>();
        for (AllGroupMemberVO groupMemberVO : responseGroupMemberVoList) {
            if ("Yes".equals(groupMemberVO.getGroupOwner())){
                userIdList.add(String.valueOf(groupMemberVO.getRegisteredUserId()));
                list.add(groupMemberVO);
            }
        }
        for (AllGroupMemberVO groupMemberVO : responseGroupMemberVoList) {
            if ("No".equals(groupMemberVO.getGroupOwner())){
                userIdList.add(String.valueOf(groupMemberVO.getRegisteredUserId()));
                list.add(groupMemberVO);
            }
        }
        if("A".equals(groupPhotoUrl)){
            RequestUser request;
            ResponseUser responseUser ;
            UserInfomation userInfomation;
            List<RegisterUser> registerUserList ;
            List<String> photoList = new ArrayList<>();
            List<String> photoUserIdList = new ArrayList<>();
            for (String id : userIdList) {
                request = RequestUser.newBuilder().setArgs(IMSContacts.MsgType.SEARCH_USER).setRegisterUser(RegisterUser.newBuilder()
                        .setUserId(id).build()).build();
                responseUser = registUserAPI.selectUserInfomation(request);
                registerUserList = responseUser.getRegisterUserList();
                if (null != registerUserList && registerUserList.size() > 0) {
                    userInfomation = registerUserList.get(0).getUserInfomation();
                    if(null != userInfomation.getAvatar() && !"".equals(userInfomation.getAvatar())){
                        photoList.add(userInfomation.getAvatar());
                        photoUserIdList.add(id);
                        if(photoList.size()==9){
                            break;
                        }
                    }
                }
            }
            logger.info("群成员接口群头像成员ID集合----"+userIdList.toString());
            GroupAvatarRequest avatarRequest = GroupAvatarRequest.newBuilder()
                    .setGroupId(String.valueOf(registeredGroup.getGroupId()))
                    .setNum(String.valueOf(responseGroupMemberVoList.size()))
                    .addAllAvatarUrl(photoList).build();
            logger.info("获取群成员列表1"+registeredGroup.getGroupId()+"--"+photoList.toString()+"---"+new Date());
            GroupAvatarResponse groupAvatarResponse = fileStorageAPI.groupMergerPhoto(avatarRequest);
            grpcPhotoUrl += groupAvatarResponse.getGroupAvatar();
            logger.info("获取群成员列表2"+registeredGroup.getGroupId()+"--"+grpcPhotoUrl+"---"+new Date());
            String groupPhotoUserIdList = String.join(",",photoUserIdList);
            logger.info("保存新合成头像用户ID集合："+groupPhotoUserIdList);
            TransmissionRequest request3 = TransmissionRequest.newBuilder()
                    .setAllGroupMemberVo(AllGroupMemberVO.newBuilder()
                            .setRegisteredGroupId(Integer.parseInt(registeredGroup.getGroupId()))
                            .setAnnouncementContent(groupPhotoUserIdList)
                            .setUserPhoto(grpcPhotoUrl)
                            .build())
                    .build();
            storageAPI.insertGroupPhotoUrl(request3);
        }

        List<BusinessProtocolEntities.AllGroupMemberVO> groupMemberVOS = new ArrayList<>(responseGroupMemberVoList.size());
        for (AllGroupMemberVO memberVO : list) {
                RequestUser requestUser = RequestUser.newBuilder().setArgs(IMSContacts.MsgType.SEARCH_USER).setRegisterUser(RegisterUser.newBuilder()
                        .setUserId(String.valueOf(memberVO.getRegisteredUserId())).build()).build();
                List<RegisterUser> users = registUserAPI.selectUserInfomation(requestUser).getRegisterUserList();
                if (users == null || users.isEmpty()) {
                    continue;
                }
                UserInfomation userInfomation2 = users.get(0).getUserInfomation();
                BusinessProtocolEntities.AllGroupMemberVO allGroupMemberVO = BusinessProtocolEntities.AllGroupMemberVO.newBuilder()
                        .setGroupMemberId(memberVO.getGroupMemberId())
                        .setRegisteredGroupId(memberVO.getRegisteredGroupId())
                        .setRegisteredUserId(memberVO.getRegisteredUserId())
                        .setGroupName(memberVO.getGroupName())
                        .setAmount(memberVO.getAmount())
                        .setAnnouncementContent(memberVO.getAnnouncementContent())
                        .setGroupOwner(memberVO.getGroupOwner())
                        .setRegisterUserNickAme(userInfomation2.getNickname())
                        .setUserPhoto(userInfomation2.getAvatar())
                        .build();
                groupMemberVOS.add(allGroupMemberVO);
        }

        GroupMemberNicknameResponse nicknameResponse = storageAPI.selectGroupMemberNickname(transmissionRequest);
//        if (nicknameResponse == null){
//            return ResponseUtil.ResponseResult(unifiedEntranceMessage, groupMemberVOS,"A".equals(groupPhotoUrl)?grpcPhotoUrl:groupPhotoUrl);
//        }
        List<RpcGroupMemberNickname> responseDataList = nicknameResponse.getResponseDataList();
//        if (responseDataList == null || responseDataList.isEmpty()) {
//            return ResponseUtil.ResponseResult(unifiedEntranceMessage, groupMemberVOS,"A".equals(groupPhotoUrl)?grpcPhotoUrl:groupPhotoUrl);
//        }
        logger.info("群成员列表返回IM数据1："+groupMemberVOS.size());

        List<BusinessProtocolEntities.AllGroupMemberVO> resultVos = new ArrayList<>(responseGroupMemberVoList.size());
//        if(responseDataList.size()>0){
//            Map<Integer, String> map = responseDataList.stream().collect(Collectors.toMap(RpcGroupMemberNickname::getGroupMemberId, RpcGroupMemberNickname::getNickRemark);
//            groupMemberVOS.forEach(allGroupMemberVO -> {
//                if (map.get(allGroupMemberVO.getRegisteredUserId()) != null) {
//                    BusinessProtocolEntities.AllGroupMemberVO allGroupMemberVO1 = BusinessProtocolEntities.AllGroupMemberVO.newBuilder(allGroupMemberVO)
//                            .setGroupRemarks(map.get(allGroupMemberVO.getRegisteredUserId()))
//                            .build();
//                    resultVos.add(allGroupMemberVO1);
//                }
//            });
//        }else {
//            groupMemberVOS.forEach(allGroupMemberVO -> resultVos.add(allGroupMemberVO));
//        }
        resultVos.addAll(groupMemberVOS);
        logger.info("群成员列表返回IM数据2："+resultVos.size());
        return ResponseUtil.ResponseResult(unifiedEntranceMessage, resultVos,"A".equals(groupPhotoUrl)?grpcPhotoUrl:groupPhotoUrl);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage searchAllGroupByUserId(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, ChannelHandlerContext ctx){
        StorageAPI storageAPI = new StorageAPI();
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolEntities.RegisteredUser registeredUser = unifiedEntranceMessage.getGroupListProtocol().getRegisteredUser();
        String userId = registeredUser.getUserId();
        String currUserId = "" ;
        if(null != userId && !"".equals(userId)){
            currUserId = userId;
        }
        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder().setRequestKind(currUserId).build();
        AllGroupsMemberResponse allGroupsResponse = storageAPI.searchAllGroupByUserId(transmissionRequest);
        List<AllGroupMemberVO> responseGroupVoList = allGroupsResponse.getResponseGroupMemberVoList();
        BusinessProtocolEntities.RegisteredGroup allGroups ;
        List<BusinessProtocolEntities.RegisteredGroup> groupList = new ArrayList<>();
        RegistUserAPI registUserAPI = new RegistUserAPI();
        FileStorageAPI fileStorageAPI = new FileStorageAPI();
        RequestUser request ;
        ResponseUser responseUser ;
        UserInfomation userInfomation ;
        List<RegisterUser> registerUserList ;
        if(null != responseGroupVoList && responseGroupVoList.size()>0){
            for (AllGroupMemberVO vo : responseGroupVoList) {
//                TransmissionRequest tRequest = TransmissionRequest.newBuilder()
//                        .setRequestKind(String.valueOf(vo.getRegisteredGroupId()))
//                        .setRegisteredGroupMember(RpcRegisteredGroupMember.newBuilder().setRegisteredUserId(Integer.parseInt(currUserId)).build())
//                        .build();
//                AllGroupsMemberResponse groupsMemberResponse = storageAPI.inviteUsersJoinGroup(tRequest);

                String grpcPhotoUrl ="";
                if("A".equals(vo.getUserPhoto())){
                    //获取所有群成员列表
                    SelectGroupMemberRequest request2 = SelectGroupMemberRequest.newBuilder().setGroupId(String.valueOf(vo.getRegisteredGroupId())).build();
                    AllGroupsMemberResponse allGroupsMemberResponse2 = storageAPI.queryGroupMembersInfoList(request2);
                    List<AllGroupMemberVO> responseGroupMemberVoList = allGroupsMemberResponse2.getResponseGroupMemberVoList();

                    List<String> userIdList = new ArrayList<>();
                    for (AllGroupMemberVO groupMemberVO : responseGroupMemberVoList) {
                        if ("Yes".equals(groupMemberVO.getGroupOwner())){
                            userIdList.add(String.valueOf(groupMemberVO.getRegisteredUserId()));
                        }
                    }
                    for (AllGroupMemberVO groupMemberVO : responseGroupMemberVoList) {
                        if ("No".equals(groupMemberVO.getGroupOwner())){
                            userIdList.add(String.valueOf(groupMemberVO.getRegisteredUserId()));
                        }
                    }
                    List<String> photoList = new ArrayList<>();
                    List<String> photoUserIdList = new ArrayList<>();
                    for (String id : userIdList) {
                        request = RequestUser.newBuilder().setArgs(IMSContacts.MsgType.SEARCH_USER).setRegisterUser(RegisterUser.newBuilder()
                                .setUserId(id).build()).build();
                        responseUser = registUserAPI.selectUserInfomation(request);
                        registerUserList = responseUser.getRegisterUserList();
                        if (null != registerUserList && registerUserList.size() > 0) {
                            userInfomation = registerUserList.get(0).getUserInfomation();
                            if(null != userInfomation.getAvatar() && !"".equals(userInfomation.getAvatar())){
                                photoList.add(userInfomation.getAvatar());
                                photoUserIdList.add(id);
                                if(photoList.size()==9){
                                    break;
                                }
                            }
                        }
                    }
                    GroupAvatarRequest avatarRequest = GroupAvatarRequest.newBuilder()
                            .setGroupId(String.valueOf(vo.getRegisteredGroupId()))
                            .setNum(String.valueOf(vo.getAmount()))
                            .addAllAvatarUrl(photoList).build();
                    logger.info("获取群头像合成的群ID："+vo.getRegisteredGroupId()+"获取群头像的成员ID集合--"+"---"+new Date());
                    GroupAvatarResponse groupAvatarResponse = fileStorageAPI.groupMergerPhoto(avatarRequest);
                    grpcPhotoUrl += groupAvatarResponse.getGroupAvatar();
                    logger.info("返回获取群头像合成的群ID："+vo.getRegisteredGroupId()+"--"+groupAvatarResponse.getGroupAvatar()+"---"+new Date());
                    String groupPhotoUserIdList = String.join(",",photoUserIdList);
                    logger.info("群列表保存新合成头像用户ID集合："+groupPhotoUserIdList);
                    TransmissionRequest request3 = TransmissionRequest.newBuilder()
                            .setAllGroupMemberVo(AllGroupMemberVO.newBuilder()
                                    .setRegisteredGroupId(vo.getRegisteredGroupId())
                                    .setAnnouncementContent(groupPhotoUserIdList)
                                    .setUserPhoto(grpcPhotoUrl)
                                    .build())
                            .build();
                    storageAPI.insertGroupPhotoUrl(request3);
                }

                allGroups = BusinessProtocolEntities.RegisteredGroup.newBuilder()
                        .setGroupId(String.valueOf(vo.getRegisteredGroupId()))
                        .setGroupOwnerUserId(String.valueOf(vo.getRegisteredUserId()))
                        .setGroupName(vo.getGroupName())
                        .setMemberCount(vo.getAmount())
                        .setGroupAvatar("A".equals(vo.getUserPhoto())?grpcPhotoUrl:vo.getUserPhoto())
                        .build();
                groupList.add(allGroups);
            }
        }
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        BusinessProtocolMessages.GroupListProtocol groupListProtocol = BusinessProtocolMessages.GroupListProtocol.newBuilder()
                                            .addAllRegisteredGroup(groupList)
                                            .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                                            .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                        .newBuilder()
                        .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupListProtocol)
                        .setGroupListProtocol(groupListProtocol)
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(head.getMsgType())
                        .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .setToId(head.getToId())
                        .setFromId(head.getFromId())
                        .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setMsgContentType(head.getMsgContentType())
                        .build()).build();
        return jcrc32.packageCheckSum(message);
    }

    public static String mapToString(Map<String,String> map){
        return new Gson().toJson(map);
    }

    public void GroupOwnerDeleteMember(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, ChannelHandlerContext ctx){
        StorageAPI storageAPI = new StorageAPI();
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolEntities.RegisteredGroupMember groupMember = unifiedEntranceMessage.getGroupChatProtocol().getRegisteredGroupMember();
        BusinessProtocolEntities.RegisteredGroup registeredGroup = unifiedEntranceMessage.getGroupChatProtocol().getRegisteredGroupMember().getGroup();
        String groupMemberIds = groupMember.getGroupMemberUserId();//要删除的群成员ID集合

//        TransmissionRequest request = TransmissionRequest.newBuilder()
//                .setRequestKind(String.valueOf(registeredGroup.getGroupId()))
//                .setRegisteredGroupMember(RpcRegisteredGroupMember.newBuilder().setRegisteredUserId(Integer.parseInt(registeredGroup.getGroupId())).build())
//                .build();
//        AllGroupsMemberResponse allGroupsMemberResponse = storageAPI.inviteUsersJoinGroup(request);

        //获取所有群成员列表
        SelectGroupMemberRequest request = SelectGroupMemberRequest.newBuilder().setGroupId(registeredGroup.getGroupId()).build();
        AllGroupsMemberResponse allGroupsMemberResponse = storageAPI.queryGroupMembersInfoList(request);
        List<AllGroupMemberVO> allGroupMemberVoList = allGroupsMemberResponse.getResponseGroupMemberVoList();

        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
                                            .setRegisteredGroup(RpcRegisteredGroup.newBuilder()
                                                    .setGroupMemberId(Integer.parseInt(groupMember.getGroupMemberId()))
                                                    .setGroupId(Integer.parseInt(registeredGroup.getGroupId())).build())
                                                    .setRequestKind(groupMemberIds)
                                            .build();
        storageAPI.groupOwnerDeleteMember(transmissionRequest);
        BusinessProtocolEntities.RegisteredGroupMember registeredGroupMember;
        if(null != allGroupMemberVoList){
            BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
            for (AllGroupMemberVO memberVO : allGroupMemberVoList) {
                registeredGroupMember = BusinessProtocolEntities.RegisteredGroupMember.newBuilder()
                                .setGroupMemberUserId(groupMember.getGroupMemberUserId())
                                .setGroupMemberName(groupMember.getGroupMemberName())
                                .setGroupMemberAvatar(groupMember.getGroupMemberAvatar())
                                .setGroupMemberType(groupMember.getGroupMemberType())
                                .setGroupMemberNick(groupMember.getGroupMemberNick())
                                .setGroupMemberAlias(groupMember.getGroupMemberAlias())
                                .setUserType(groupMember.getUserType())
                                .setGroup(registeredGroup)
                                .build();
                BusinessProtocolMessages.GroupChatProtocol groupChatProtocol = BusinessProtocolMessages.GroupChatProtocol.newBuilder()
                        .setUserType(unifiedEntranceMessage.getGroupChatProtocol().getUserType())
                        .setRegisteredGroupMember(registeredGroupMember)
                        .setAt(unifiedEntranceMessage.getGroupChatProtocol().getAt())
                        .setChatMessage(unifiedEntranceMessage.getGroupChatProtocol().getChatMessage())
                        .build();
                BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                        .newBuilder()
                        .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupChatProtocol)
                        .setGroupChatProtocol(groupChatProtocol)
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                .setMsgType(head.getMsgType())
                                .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                                .setToId(String.valueOf(memberVO.getRegisteredUserId()))
                                .setFromId(head.getFromId())
                                .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                                .setToken(head.getToken())
                                .setUniqueIdentify(head.getUniqueIdentify())
                                .setMsgContentType(head.getMsgContentType())
                                .build()).build();
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(message);
                ctx.writeAndFlush(checkUnified);
            }
        }

    }

    public void GroupMemberExitGroup(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, ChannelHandlerContext ctx){
        StorageAPI storageAPI = new StorageAPI();
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolEntities.RegisteredGroupMember registeredGroupMember = unifiedEntranceMessage.getGroupChatProtocol().getRegisteredGroupMember();
        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
                                .setRegisteredGroupMember(RpcRegisteredGroupMember.newBuilder()
                                        .setGroupId(Integer.parseInt(registeredGroupMember.getGroup().getGroupId()))
//                                        .setGroupMemberId(Integer.valueOf(registeredGroupMember.getGroupMemberId()))
                                        .setRegisteredUserId(Integer.parseInt(registeredGroupMember.getGroupMemberUserId()))
                                        .build())
                                .build();
        //获取所有群成员列表
        SelectGroupMemberRequest request = SelectGroupMemberRequest.newBuilder().setGroupId(registeredGroupMember.getGroup().getGroupId()).build();
        AllGroupsMemberResponse allGroupsMemberResponse = storageAPI.queryGroupMembersInfoList(request);
//        TransmissionRequest transmissionRequest2 = TransmissionRequest.newBuilder()
//                .setRequestKind(registeredGroupMember.getGroup().getGroupId())
//                .build();
//        AllGroupsMemberResponse allGroupsMemberResponse = storageAPI.inviteUsersJoinGroup(transmissionRequest2);//获取所有群成员
        List<AllGroupMemberVO> groupMemberVoList = allGroupsMemberResponse.getResponseGroupMemberVoList();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        String groupOwnerId="";//群主ID
        for (AllGroupMemberVO allGroupMemberVO : groupMemberVoList) {
            if("Yes".equals(allGroupMemberVO.getGroupOwner())){
                groupOwnerId = String.valueOf(allGroupMemberVO.getRegisteredUserId());
            }
        }
        if(groupOwnerId.equals(registeredGroupMember.getGroupMemberUserId())){
            storageAPI.groupMemberExitGroup(transmissionRequest);
            for (AllGroupMemberVO memberVO : groupMemberVoList) {
                BusinessProtocolMessages.GroupChatProtocol groupChatProtocol = BusinessProtocolMessages.GroupChatProtocol.newBuilder()
                        .setUserType(unifiedEntranceMessage.getGroupChatProtocol().getUserType())
                        .setRegisteredGroupMember(registeredGroupMember)
                        .setAt(unifiedEntranceMessage.getGroupChatProtocol().getAt())
                        .setChatMessage(unifiedEntranceMessage.getGroupChatProtocol().getChatMessage())
                        .build();
                BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                        .newBuilder()
                        .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupChatProtocol)
                        .setGroupChatProtocol(groupChatProtocol)
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                .setMsgType(head.getMsgType())
                                .setStatusReport(ResponseStatus.GROUP_OWNER_DISSOLVE)
                                .setToId(String.valueOf(memberVO.getRegisteredUserId()))
                                .setFromId(head.getFromId())
                                .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                                .setToken(head.getToken())
                                .setUniqueIdentify(head.getUniqueIdentify())
                                .setMsgContentType(head.getMsgContentType())
                                .build()).build();
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(message);
                ctx.writeAndFlush(checkUnified);
            }
        }else{
            storageAPI.groupMemberExitGroup(transmissionRequest);
            for (AllGroupMemberVO memberVO : groupMemberVoList) {
                registeredGroupMember = BusinessProtocolEntities.RegisteredGroupMember.newBuilder()
                        .setGroupMemberId(String.valueOf(memberVO.getRegisteredUserId()))
                        .setGroupMemberUserId(registeredGroupMember.getGroupMemberUserId())
                        .setGroupMemberName(registeredGroupMember.getGroupMemberName())
                        .setGroupMemberAvatar(registeredGroupMember.getGroupMemberAvatar())
                        .setGroupMemberType(registeredGroupMember.getGroupMemberType())
                        .setGroupMemberNick(registeredGroupMember.getGroupMemberNick())
                        .setGroupMemberAlias(registeredGroupMember.getGroupMemberAlias())
                        .setGroup(registeredGroupMember.getGroup())
                        .build();
                BusinessProtocolMessages.GroupChatProtocol groupChatProtocol = BusinessProtocolMessages.GroupChatProtocol.newBuilder()
                        .setUserType(unifiedEntranceMessage.getGroupChatProtocol().getUserType())
                        .setRegisteredGroupMember(registeredGroupMember)
                        .setAt(unifiedEntranceMessage.getGroupChatProtocol().getAt())
                        .setChatMessage(unifiedEntranceMessage.getGroupChatProtocol().getChatMessage())
                        .build();
                BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                        .newBuilder()
                        .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupChatProtocol)
                        .setGroupChatProtocol(groupChatProtocol)
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                .setMsgType(head.getMsgType())
                                .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                                .setToId(String.valueOf(memberVO.getRegisteredUserId()))
                                .setFromId(head.getFromId())
                                .setTimestamp(Timestamp.valueOf(LocalDateTime.now().withNano(0)).getTime())
                                .setToken(head.getToken())
                                .setUniqueIdentify(head.getUniqueIdentify())
                                .setMsgContentType(head.getMsgContentType())
                                .build()).build();
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(message);
                ctx.writeAndFlush(checkUnified);
            }
        }

    }
}
