package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.server.ResponseUtil;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.im.grpc.client.util.ConstantsDefault;
import com.lanjiu.im.grpc.client.util.ConstantsSelectKind;
import com.lanjiu.im.login.client.registLoginAPI.RegistUserAPI;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import com.lanjiu.pro.login.RegisterUser;
import com.lanjiu.pro.login.RequestUser;
import com.lanjiu.pro.login.ResponseUser;
import com.lanjiu.pro.login.UserInfomation;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GroupSelectByRegisteredUserService {

    private final Logger logger = Logger.getLogger(GroupSelectByRegisteredUserService.class);

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectByRegisteredGroup(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        StorageAPI storageAPI = new StorageAPI();
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolEntities.RegisteredUser registeredUser = unifiedEntranceMessage.getGroupListProtocol().getRegisteredUser();
        int userId = Integer.parseInt(registeredUser.getUserId());
        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
                .setRequestKind(ConstantsSelectKind.GROUP_SELECT_TYPE_BY_REGISTERED_USER_ID)
                .setRegisteredGroup(RpcRegisteredGroup.newBuilder().setRegisteredUserId(userId).build())
                .build();
        RegisteredGroupResponse registeredGroupResponse = storageAPI.selectRegisteredGroupAPI(transmissionRequest);
        List<RpcGuestGroup> rpcGuestGroupList = registeredGroupResponse.getResponseGuestGroupList();
        List<RpcRegisteredGroup> rpcRegisteredGroupList = registeredGroupResponse.getResponseRegisteredGroupList();

        List<BusinessProtocolEntities.TouristsGroup> touristsGroupList = guestGroupList(rpcGuestGroupList);
        List<BusinessProtocolEntities.RegisteredGroup> registeredGroupList = registeredGroupList(rpcRegisteredGroupList);

        BusinessProtocolMessages.GroupListProtocol groupListProtocol = BusinessProtocolMessages.GroupListProtocol.newBuilder()
                .addAllRegisteredGroup(registeredGroupList)
                .addAllTouristsGroup(touristsGroupList)
                .setUserType(unifiedEntranceMessage.getFindGroupProtocol().getUserType())
                .setTouristsUser(unifiedEntranceMessage.getFindGroupProtocol().getTouristsUser())
                .setRegisteredUser(unifiedEntranceMessage.getFindGroupProtocol().getRegisteredUser())
                .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                .newBuilder().setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupListProtocol)
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


    public List<RpcGuestGroup> getGuestGroup(int groupId){
        StorageAPI storageAPI = new StorageAPI();
        TransmissionRequest transmissionRequest ;
        List<RpcGuestGroup> list ;
        transmissionRequest = TransmissionRequest.newBuilder()
                .setRequestKind(ConstantsSelectKind.GROUP_SELECT_TYPE_BY_GUEST_GROUP_ID)
                .setGuestGroup(RpcGuestGroup.newBuilder().setGroupId(groupId).build())
                .build();
        GuestGroupResponse guestGroupResponse = storageAPI.selectGuestGroupAPI(transmissionRequest);
        list = guestGroupResponse.getResponseGuestGroupList();
        return list;
    }

    public List<RpcRegisteredGroup> getRegisteredGroup(int groupId){
        StorageAPI storageAPI = new StorageAPI();
        TransmissionRequest transmissionRequest ;
        List<RpcRegisteredGroup> list ;
        transmissionRequest = TransmissionRequest.newBuilder()
                .setRequestKind(ConstantsSelectKind.GROUP_SELECT_TYPE_BY_REGISTERED_GROUP_ID)
                .setRegisteredGroup(RpcRegisteredGroup.newBuilder().setGroupId(groupId).build())
                .build();
        RegisteredGroupResponse guestGroupResponse = storageAPI.selectRegisteredGroupAPI(transmissionRequest);
        list = guestGroupResponse.getResponseRegisteredGroupList();
        return list;
    }

    public List<BusinessProtocolEntities.RegisteredGroupMember> registeredGroupMemberList(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, List<RpcRegisteredGroupMember> list){
        BusinessProtocolEntities.RegisteredGroupMember touristsGroupMember ;
        List<BusinessProtocolEntities.RegisteredGroupMember> touristsGroupMemberList = new ArrayList<>();
        List<RpcGuestGroup> rpcGuestGroupListTemp ;
        RpcGuestGroup rpcGuestGroup ;

        List<RpcRegisteredGroup> rpcRegisteredGroupListTemp ;
        RpcRegisteredGroup rpcRegisteredGroup ;

        RegistUserAPI registUserAPI = new RegistUserAPI();
        RequestUser request ;
        ResponseUser responseUser ;
        UserInfomation userInfomation ;
        List<RegisterUser> registerUserList ;
        ResponseUtil responseUtil = new ResponseUtil();

        GroupUtils groupUtils = new GroupUtils();
        BusinessProtocolEntities.GroupAnnouncements groupAnnouncements ;
        BusinessProtocolEntities.RegisteredGroup touristsGroup ;
        int isOwner = 0;
        for (RpcRegisteredGroupMember rpcRegisteredGroupMember : list){
            if(ConstantsDefault.GROUP_MEMBER_MASTER_NO.equals(rpcRegisteredGroupMember.getGroupOwner())){
                isOwner = 0;
            }else if(ConstantsDefault.GROUP_MEMBER_MASTER_YES.equals(rpcRegisteredGroupMember.getGroupOwner())){
                isOwner = 1;
            }

            request = RequestUser.newBuilder().setRegisterUser(RegisterUser.newBuilder()
                    .setUserId(String.valueOf(rpcRegisteredGroupMember.getRegisteredUserId()))
                    .build())
                    .build();
            responseUser = registUserAPI.selectUserInfomation(request);
            registerUserList = responseUser.getRegisterUserList();
            //commonUtils.isHave(list)
            CommonUtils<RegisterUser> commonUtils = new CommonUtils<>();
            if(commonUtils.isHave(registerUserList)){
                userInfomation = registerUserList.get(0).getUserInfomation();
            }
            else{
                responseUtil.requestWithResponseFail(unifiedEntranceMessage);
                logger.info(ResponseStatus.RESPONSE_USER_INFORMATION_SELECT_FAILURE);
                break;
            }

            rpcGuestGroupListTemp = getGuestGroup(rpcRegisteredGroupMember.getGroupId());
            //commonUtils.isHave(list)
            CommonUtils<RpcGuestGroup> commonUtils2 = new CommonUtils<>();
            if(commonUtils2.isHave(rpcGuestGroupListTemp)){
                rpcGuestGroup = rpcGuestGroupListTemp.get(0);
                groupAnnouncements = groupUtils.getGroupAnnouncement(rpcGuestGroup.getGroupId());
                touristsGroup = BusinessProtocolEntities.RegisteredGroup
                        .newBuilder()
                        .setGroupId(String.valueOf(rpcGuestGroup.getGroupId()))
                        .setGroupName(rpcGuestGroup.getGroupName())
                        .setGroupType(IMSContacts.UserType.TOURISTS_USER)
                        .setMemberCount(rpcGuestGroup.getAmount())
                        .setGroupAnnouncements(groupAnnouncements)
                        .build();

                touristsGroupMember = BusinessProtocolEntities.RegisteredGroupMember
                        .newBuilder()
                        .setGroup(touristsGroup)
                        .setGroupMemberId(String.valueOf(rpcRegisteredGroupMember.getGroupMemberId()))
                        .setGroupMemberAlias(rpcRegisteredGroupMember.getGroupRemarks())
                        .setGroupMemberType(isOwner)
                        .setUserType(IMSContacts.UserType.TOURISTS_USER)
                        .setGroupMemberAvatar(userInfomation.getAvatar())
                        .setGroupMemberNick(userInfomation.getNickname())
                        .build();
                touristsGroupMemberList.add(touristsGroupMember);
            }
            rpcRegisteredGroupListTemp = getRegisteredGroup(rpcRegisteredGroupMember.getGroupId());
            //commonUtils.isHave(list)
            CommonUtils<RpcRegisteredGroup> commonUtils3 = new CommonUtils<>();
            if(commonUtils3.isHave(rpcRegisteredGroupListTemp)){
                rpcRegisteredGroup = rpcRegisteredGroupListTemp.get(0);
                groupAnnouncements = groupUtils.getGroupAnnouncement(rpcRegisteredGroup.getGroupId());
                touristsGroup = BusinessProtocolEntities.RegisteredGroup
                        .newBuilder()
                        .setGroupId(String.valueOf(rpcRegisteredGroup.getGroupId()))
                        .setGroupName(rpcRegisteredGroup.getGroupName())
                        .setGroupType(IMSContacts.UserType.REGISTERED_USER)
                        .setMemberCount(rpcRegisteredGroup.getAmount())
                        .setGroupAnnouncements(groupAnnouncements)
                        .build();

                touristsGroupMember = BusinessProtocolEntities.RegisteredGroupMember
                        .newBuilder()
                        .setGroup(touristsGroup)
                        .setGroupMemberId(String.valueOf(rpcRegisteredGroupMember.getGroupMemberId()))
                        .setGroupMemberAlias(rpcRegisteredGroupMember.getGroupRemarks())
                        .setGroupMemberType(isOwner)
                        .setUserType(IMSContacts.UserType.TOURISTS_USER)
                        .setGroupMemberAvatar(userInfomation.getAvatar())
                        .setGroupMemberNick(userInfomation.getNickname())
                        .build();
                touristsGroupMemberList.add(touristsGroupMember);
            }

        }
        return touristsGroupMemberList;
    }

    //格式转换
    public List<BusinessProtocolEntities.TouristsGroup> guestGroupList(List<RpcGuestGroup> list){
        BusinessProtocolEntities.TouristsGroup touristsGroup ;
        List<BusinessProtocolEntities.TouristsGroup> touristsGroupList = new ArrayList<>();
        BusinessProtocolEntities.GroupAnnouncements groupAnnouncements ;
        GroupUtils groupUtils = new GroupUtils();
        for (RpcGuestGroup rpcGuestGroup : list){
            groupAnnouncements = groupUtils.getGroupAnnouncement(rpcGuestGroup.getGroupId());
            touristsGroup = BusinessProtocolEntities.TouristsGroup
                    .newBuilder()
                    .setGroupId(String.valueOf(rpcGuestGroup.getGroupId()))
                    .setMemberCount(rpcGuestGroup.getAmount())
                    .setGroupType(IMSContacts.UserType.TOURISTS_USER)
                    .setGroupName(rpcGuestGroup.getGroupName())
                    .setGroupAnnouncements(BusinessProtocolEntities.GroupAnnouncements
                            .newBuilder()
                            .setAnnouncementId(groupAnnouncements.getAnnouncementId())
                            .setAnnouncementContent(groupAnnouncements.getAnnouncementContent())
                            .setAnnouncementTitle(groupAnnouncements.getAnnouncementTitle())
                            .build())
                    .build();
            touristsGroupList.add(touristsGroup);
        }
        return touristsGroupList;
    }

    //格式转换
    public List<BusinessProtocolEntities.RegisteredGroup> registeredGroupList(List<RpcRegisteredGroup> list){
        BusinessProtocolEntities.RegisteredGroup registeredGroup ;
        List<BusinessProtocolEntities.RegisteredGroup> registeredGroupList = new ArrayList<>();
        BusinessProtocolEntities.GroupAnnouncements groupAnnouncements ;
        GroupUtils groupUtils = new GroupUtils();
        for (RpcRegisteredGroup rpcRegisteredGroup : list){
            groupAnnouncements = groupUtils.getGroupAnnouncement(rpcRegisteredGroup.getGroupId());
            registeredGroup = BusinessProtocolEntities.RegisteredGroup
                    .newBuilder()
                    .setGroupId(String.valueOf(rpcRegisteredGroup.getGroupId()))
                    .setMemberCount(rpcRegisteredGroup.getAmount())
                    .setGroupType(IMSContacts.UserType.REGISTERED_USER)
                    .setGroupName(rpcRegisteredGroup.getGroupName())
                    .setGroupAnnouncements(BusinessProtocolEntities.GroupAnnouncements
                            .newBuilder()
                            .setAnnouncementId(groupAnnouncements.getAnnouncementId())
                            .setAnnouncementContent(groupAnnouncements.getAnnouncementContent())
                            .setAnnouncementTitle(groupAnnouncements.getAnnouncementTitle())
                            .build())
                    .build();
            registeredGroupList.add(registeredGroup);
        }
        return registeredGroupList;
    }

}
