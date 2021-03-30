package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GroupUtils {

    private final Logger logger = Logger.getLogger(GroupUtils.class);
    
    //游客群记录查询相关
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage guestGroupList(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, GuestGroupResponse guestGroupResponse, BusinessProtocolMessageStandard.Head head){
//        BusinessProtocolEntities.TouristsGroup touristsGroup ;
        BusinessProtocolEntities.RegisteredGroup registeredGroup ;
//        List<BusinessProtocolEntities.TouristsGroup> touristsGroupList = new ArrayList<>();
        List<BusinessProtocolEntities.RegisteredGroup> registeredGroupList = new ArrayList<>();
        List<RpcRegisteredGroup> responseRegisteredGroupList = guestGroupResponse.getResponseRegisteredGroupList();
//        List<RpcGuestGroup> responseGuestGroupList = guestGroupResponse.getResponseGuestGroupList();
        String photo = guestGroupResponse.getResponseGroupMemberVoList().get(0).getUserPhoto();
        logger.info("------查找群的群头像-----："+photo);
        JCRC32 jcrc32 = new JCRC32();
        if(null != responseRegisteredGroupList && responseRegisteredGroupList.size()>0){
            for (RpcRegisteredGroup registGroup : responseRegisteredGroupList) {
                registeredGroup = BusinessProtocolEntities.RegisteredGroup.newBuilder()
                        .setGroupId(String.valueOf(registGroup.getGroupId()))
                        .setGroupOwnerUserId(String.valueOf(registGroup.getRegisteredUserId()))
                        .setGroupName(registGroup.getGroupName())
                        .setMemberCount(registGroup.getAmount())
                        .setGroupAvatar(photo)
                        .build();
                registeredGroupList.add(registeredGroup);
            }
        }
//        if(null != responseGuestGroupList && responseGuestGroupList.size()>0){
//            for (RpcGuestGroup gueGroup : responseGuestGroupList) {
//                touristsGroup = BusinessProtocolEntities.TouristsGroup.newBuilder()
//                        .setGroupId(String.valueOf(gueGroup.getGroupId()))
//                        .setGroupOwnerUserId(String.valueOf(gueGroup.getGuestUserId()))
//                        .setGroupName(gueGroup.getGroupName())
//                        .setMemberCount(gueGroup.getAmount())
//                        .build();
//                touristsGroupList.add(touristsGroup);
//            }
//        }

        BusinessProtocolMessages.FindGroupProtocol findGroupProtocol = BusinessProtocolMessages.FindGroupProtocol.newBuilder()
//                .addAllTouristsGroup(touristsGroupList)
                .addAllRegisteredGroup(registeredGroupList)
                .setUserType(unifiedEntranceMessage.getFindGroupProtocol().getUserType())
                .setTouristsUser(unifiedEntranceMessage.getFindGroupProtocol().getTouristsUser())
                .setRegisteredUser(unifiedEntranceMessage.getFindGroupProtocol().getRegisteredUser())
                .setSearch(unifiedEntranceMessage.getFindGroupProtocol().getSearch())
                .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                .newBuilder().setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FindGroupProtocol)
                .setFindGroupProtocol(findGroupProtocol)
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

    //注册群记录查询相关
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage registeredGroupList(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, List<RpcRegisteredGroup> list, BusinessProtocolMessageStandard.Head head){
        BusinessProtocolEntities.RegisteredGroup registeredGroup ;
        List<BusinessProtocolEntities.RegisteredGroup> registeredGroupList = new ArrayList<>();
        BusinessProtocolEntities.GroupAnnouncements groupAnnouncements ;
        JCRC32 jcrc32 = new JCRC32();
        for (RpcRegisteredGroup rpcRegisteredGroup : list){
            logger.info("搜索注册群返回数据："+rpcRegisteredGroup.toString());
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

        BusinessProtocolMessages.FindGroupProtocol findGroupProtocol = BusinessProtocolMessages.FindGroupProtocol.newBuilder()
                .addAllRegisteredGroup(registeredGroupList)
                .setUserType(unifiedEntranceMessage.getFindGroupProtocol().getUserType())
                .setTouristsUser(unifiedEntranceMessage.getFindGroupProtocol().getTouristsUser())
                .setRegisteredUser(unifiedEntranceMessage.getFindGroupProtocol().getRegisteredUser())
                .addAllTouristsGroup(unifiedEntranceMessage.getFindGroupProtocol().getTouristsGroupList())
                .setSearch(unifiedEntranceMessage.getFindGroupProtocol().getSearch())
                .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                .newBuilder()
                .setFindGroupProtocol(findGroupProtocol)
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
                ).build();
        return jcrc32.packageCheckSum(message);
    }

    public BusinessProtocolEntities.GroupAnnouncements getGroupAnnouncement(int groupId){
        StorageAPI storageAPI = new StorageAPI();
        TransmissionRequest transmissionRequest;
        transmissionRequest = TransmissionRequest.newBuilder()
                .setGroupAnnouncements(RpcGroupAnnouncements.newBuilder()
                        .setGroupAnnouncementId(groupId)
                        .build())
                .build();
        GroupAnnouncementsResponse groupAnnouncementsResponse = storageAPI.selectGroupAnnouncementsAPI(transmissionRequest);
        List<RpcGroupAnnouncements> groupAnnouncementsList = groupAnnouncementsResponse.getResponseDataList();
        RpcGroupAnnouncements rpcGroupAnnouncements;
        BusinessProtocolEntities.GroupAnnouncements groupAnnouncements = null;
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
