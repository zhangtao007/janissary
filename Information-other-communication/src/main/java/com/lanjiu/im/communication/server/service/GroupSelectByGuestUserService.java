package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.im.grpc.client.util.ConstantsSelectKind;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GroupSelectByGuestUserService {

    private final Logger logger = Logger.getLogger(GroupSelectByGuestUserService.class);

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage selectByGuestGroup(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        StorageAPI storageAPI = new StorageAPI();
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolEntities.TouristsUser touristsUser = unifiedEntranceMessage.getGroupListProtocol().getTouristsUser();
        int userId = Integer.parseInt(touristsUser.getTemporaryId());
        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
                .setRequestKind(ConstantsSelectKind.GROUP_SELECT_TYPE_BY_GUEST_USER_ID)
                .setGuestGroup(RpcGuestGroup.newBuilder().setGuestUserId(userId).build())
                .build();
        GuestGroupResponse guestGroupResponse = storageAPI.selectGuestGroupAPI(transmissionRequest);
        List<RpcGuestGroup> rpcGuestGroupList = guestGroupResponse.getResponseGuestGroupList();
        List<RpcRegisteredGroup> rpcRegisteredGroupList = guestGroupResponse.getResponseRegisteredGroupList();
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
                .newBuilder()
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
                        .build()
                )
                .build();
        return jcrc32.packageCheckSum(message);
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
