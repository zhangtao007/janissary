package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.im.grpc.client.util.ConstantsDefault;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.login.UserInfomation;

import java.util.ArrayList;
import java.util.List;

public class GroupInformUtils {

    public List<BusinessProtocolEntities.TouristsGroup> turnRpcGuestGroupToTouristsGroup(List<RpcGuestGroup> list){
        BusinessProtocolEntities.TouristsGroup touristsGroup ;
        List<BusinessProtocolEntities.TouristsGroup> touristsGroupList = new ArrayList<>();
        BusinessProtocolEntities.GroupAnnouncements groupAnnouncements ;
        for (RpcGuestGroup rpcGuestGroup : list){
            groupAnnouncements = getGroupAnnouncement(rpcGuestGroup.getGroupId());
            touristsGroup = BusinessProtocolEntities.TouristsGroup
                    .newBuilder()
                    .setGroupId(String.valueOf(rpcGuestGroup.getGroupId()))
                    .setGroupName(rpcGuestGroup.getGroupName())
                    .setGroupType(IMSContacts.UserType.TOURISTS_USER)
                    .setMemberCount(rpcGuestGroup.getAmount())
                    .setGroupAnnouncements(groupAnnouncements)
                    .build();
            touristsGroupList.add(touristsGroup);
        }
        return touristsGroupList;
    }

    public List<BusinessProtocolEntities.RegisteredGroup> turnRpcRegisteredGroupToRegisteredGroup(List<RpcRegisteredGroup> rpcRegisteredGroupList){
        BusinessProtocolEntities.RegisteredGroup registeredGroup ;
        List<BusinessProtocolEntities.RegisteredGroup> registeredGroupList = new ArrayList<>();
        BusinessProtocolEntities.GroupAnnouncements groupAnnouncements ;
        for (RpcRegisteredGroup rpcRegisteredGroup : rpcRegisteredGroupList){
            groupAnnouncements = getGroupAnnouncement(rpcRegisteredGroup.getGroupId());
            registeredGroup = BusinessProtocolEntities.RegisteredGroup
                    .newBuilder()
                    .setGroupName(rpcRegisteredGroup.getGroupName())
                    .setGroupType(IMSContacts.UserType.REGISTERED_USER)
                    .setGroupId(String.valueOf(rpcRegisteredGroup.getGroupId()))
                    .setMemberCount(rpcRegisteredGroup.getAmount())
                    .setGroupAnnouncements(groupAnnouncements)
                    .build();
            registeredGroupList.add(registeredGroup);
        }
        return registeredGroupList;
    }

    public List<BusinessProtocolEntities.TouristsGroupMember> turnRpcGuestGroupMemberToTouristsGroupMember(List<RpcGuestGroupMember> rpcGuestGroupMemberList, BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage){
        List<BusinessProtocolEntities.TouristsGroupMember> touristsGroupMemberList = new ArrayList<>();
        UserInformationUtil userInformationUtil = new UserInformationUtil();
        UserInfomation userInfomation ;
        int userId ;
        int isOwner = 0;
        for (RpcGuestGroupMember rpcGuestGroupMember : rpcGuestGroupMemberList){
            if(ConstantsDefault.GROUP_MEMBER_MASTER_NO.equals(rpcGuestGroupMember.getGroupOwner())){
                isOwner = 0;
            }else if(ConstantsDefault.GROUP_MEMBER_MASTER_YES.equals(rpcGuestGroupMember.getGroupOwner())){
                isOwner = 1;
            }
            userId = Integer.parseInt(rpcGuestGroupMember.getGroupRemarks());
            userInfomation = userInformationUtil.guestUserInformation(userId , unifiedEntranceMessage);
            BusinessProtocolEntities.TouristsGroupMember touristsGroupMember = BusinessProtocolEntities.TouristsGroupMember.newBuilder()
                    .setGroupMemberAlias(rpcGuestGroupMember.getGroupRemarks())
                    .setGroupMemberAvatar(userInfomation.getAvatar())
                    .setGroupMemberNick(userInfomation.getNickname())
                    .setGroupMemberType(isOwner)
                    .setGroupMemberUserId(String.valueOf(rpcGuestGroupMember.getGuestUserId()))
                    .setGroupMemberId(String.valueOf(rpcGuestGroupMember.getGroupMemberId()))
                    .setUserType(IMSContacts.UserType.TOURISTS_USER)
                    .build();
            touristsGroupMemberList.add(touristsGroupMember);
        }
        return touristsGroupMemberList;
    }

    public List<BusinessProtocolEntities.RegisteredGroupMember> turnRpcRegisteredGroupMemberToRegisteredGroupMember(List<RpcRegisteredGroupMember> rpcRegisteredGroupMemberList, BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage){
        List<BusinessProtocolEntities.RegisteredGroupMember> registeredGroupMemberList = new ArrayList<>();
        UserInformationUtil userInformationUtil = new UserInformationUtil();
        UserInfomation userInfomation ;
        int userId ;
        int isOwner = 0;
        for (RpcRegisteredGroupMember rpcRegisteredGroupMember : rpcRegisteredGroupMemberList){
            if(ConstantsDefault.GROUP_MEMBER_MASTER_NO.equals(rpcRegisteredGroupMember.getGroupOwner())){
                isOwner = 0;
            }else if(ConstantsDefault.GROUP_MEMBER_MASTER_YES.equals(rpcRegisteredGroupMember.getGroupOwner())){
                isOwner = 1;
            }
            userId = rpcRegisteredGroupMember.getRegisteredUserId();
            userInfomation = userInformationUtil.registeredUserInformation(userId , unifiedEntranceMessage);
            BusinessProtocolEntities.RegisteredGroupMember registeredGroupMember = BusinessProtocolEntities.RegisteredGroupMember.newBuilder()
                    .setGroupMemberAlias(rpcRegisteredGroupMember.getGroupRemarks())
                    .setGroupMemberAvatar(userInfomation.getAvatar())
                    .setGroupMemberNick(userInfomation.getNickname())
                    .setGroupMemberType(isOwner)
                    .setGroupMemberUserId(String.valueOf(rpcRegisteredGroupMember.getRegisteredUserId()))
                    .setGroupMemberId(String.valueOf(rpcRegisteredGroupMember.getGroupMemberId()))
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .build();
            registeredGroupMemberList.add(registeredGroupMember);
        }
        return registeredGroupMemberList;
    }

    public BusinessProtocolEntities.GroupAnnouncements getGroupAnnouncement(int groupId){
        StorageAPI storageAPI = new StorageAPI();
        TransmissionRequest transmissionRequest ;
        transmissionRequest = TransmissionRequest.newBuilder()
                .setGroupAnnouncements(RpcGroupAnnouncements.newBuilder()
                        .setGroupAnnouncementId(groupId)
                        .build())
                .build();
        GroupAnnouncementsResponse groupAnnouncementsResponse = storageAPI.selectGroupAnnouncementsAPI(transmissionRequest);
        List<RpcGroupAnnouncements> groupAnnouncementsList = groupAnnouncementsResponse.getResponseDataList();
        RpcGroupAnnouncements rpcGroupAnnouncements ;
        BusinessProtocolEntities.GroupAnnouncements groupAnnouncements = null;
        //commonUtils.isHave(list)
        CommonUtils<RpcGroupAnnouncements> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(groupAnnouncementsList)){
            rpcGroupAnnouncements = groupAnnouncementsList.get(0);
            groupAnnouncements = BusinessProtocolEntities.GroupAnnouncements.newBuilder()
                    .setAnnouncementId(String.valueOf(rpcGroupAnnouncements.getGroupAnnouncementId()))
                    .setAnnouncementContent(rpcGroupAnnouncements.getAnnouncementContent())
                    .setAnnouncementTitle(rpcGroupAnnouncements.getAnnouncementTitle())
                    .build();
        }
        return groupAnnouncements;
    }
}
