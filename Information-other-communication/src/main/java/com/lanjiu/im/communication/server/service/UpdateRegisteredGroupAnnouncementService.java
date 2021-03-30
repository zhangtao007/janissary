package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.grpc.GroupAnnouncementsResponse;
import com.lanjiu.im.grpc.RpcGroupAnnouncements;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class UpdateRegisteredGroupAnnouncementService {

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage updateRegisteredGroupAnnouncement(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        StorageAPI storageAPI = new StorageAPI();
        JCRC32 jcrc32 = new JCRC32();
        //装载grpc协议请求信息
        TransmissionRequest transmissionRequest ;
        List<RpcGroupAnnouncements> list ;
        BusinessProtocolEntities.RegisteredGroup registeredGroup = unifiedEntranceMessage.getGroupAnnouncementProtocol().getRegisteredGroup();
        BusinessProtocolEntities.RegisteredGroup registeredGroupUpdate = null;
        transmissionRequest = TransmissionRequest.newBuilder()
                        .setGroupAnnouncements(RpcGroupAnnouncements.newBuilder()
                        .setGroupAnnouncementId(Integer.parseInt(registeredGroup.getGroupId()))
                        .setAnnouncementContent(registeredGroup.getGroupAnnouncements().getAnnouncementContent())
                        .build()).build();
        GroupAnnouncementsResponse groupAnnouncementsResponse = storageAPI.updateGroupAnnouncementsAPI(transmissionRequest);
        list = groupAnnouncementsResponse.getResponseDataList();

        CommonUtils<RpcGroupAnnouncements> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(list)){
            RpcGroupAnnouncements rpcGroupAnnouncements= list.get(0);
            BusinessProtocolEntities.GroupAnnouncements groupAnnouncements = BusinessProtocolEntities.GroupAnnouncements.newBuilder()
                                .setAnnouncementId(String.valueOf(rpcGroupAnnouncements.getGroupAnnouncementId()))
                                .setAnnouncementContent(rpcGroupAnnouncements.getAnnouncementContent())
                                .build();
            registeredGroupUpdate = BusinessProtocolEntities.RegisteredGroup.newBuilder()
                                .setGroupAnnouncements(groupAnnouncements)
                                .setGroupId(registeredGroup.getGroupId())
                                .build();
        }

        BusinessProtocolMessages.GroupAnnouncementProtocol groupAnnouncementProtocol = BusinessProtocolMessages.GroupAnnouncementProtocol.newBuilder()
                        .setRegisteredGroup(registeredGroupUpdate)
                        .setTouristsGroup(unifiedEntranceMessage.getGroupAnnouncementProtocol().getTouristsGroup())
                        .setUserType(unifiedEntranceMessage.getGroupAnnouncementProtocol().getUserType())
                        .setTouristsUser(unifiedEntranceMessage.getGroupAnnouncementProtocol().getTouristsUser())
                        .setRegisteredUser(unifiedEntranceMessage.getGroupAnnouncementProtocol().getRegisteredUser())
                        .setOperation(unifiedEntranceMessage.getGroupAnnouncementProtocol().getOperation())
                        .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                        .newBuilder().setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupAnnouncementProtocol)
                        .setGroupAnnouncementProtocol(groupAnnouncementProtocol)
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
}
