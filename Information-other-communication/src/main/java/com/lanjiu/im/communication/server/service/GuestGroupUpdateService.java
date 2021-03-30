package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.server.ResponseUtil;
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

public class GuestGroupUpdateService {

    private final Logger logger = Logger.getLogger(GuestGroupUpdateService.class);

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage updateGuestGroup(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        //还需以被添加人的角色检索记录
        StorageAPI storageAPI = new StorageAPI();
        TransmissionRequest transmissionRequest ;
        List<RpcGuestGroup> list ;
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response ;
        //装载grpc协议请求信息
        BusinessProtocolEntities.TouristsUser touristsUser = unifiedEntranceMessage.getGroupSettingsProtocol().getTouristsUser();
        BusinessProtocolEntities.TouristsGroup touristsGroup = unifiedEntranceMessage.getGroupSettingsProtocol().getTouristsGroup();
            transmissionRequest = TransmissionRequest.newBuilder()
                            .setGuestGroup(RpcGuestGroup.newBuilder()
                            .setGroupId(Integer.parseInt(touristsGroup.getGroupId()))
                            .setGuestUserId(Integer.parseInt(touristsUser.getTemporaryId()))
                            .setGroupName(touristsGroup.getGroupName())
                            .build()).build();
            GuestGroupResponse guestGroupResponse = storageAPI.updateGuestGroupAPI(transmissionRequest);
            if(null != guestGroupResponse){
                list = guestGroupResponse.getResponseGuestGroupList();
                response = guestGroupUpdateResponseList(unifiedEntranceMessage, list, head);
                return response;
            } else {
                ResponseUtil responseUtil = new ResponseUtil();
                response = responseUtil.requestWithResponseFail(unifiedEntranceMessage);
            }
        return response;
    }

    //游客群记录查询相关
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage guestGroupUpdateResponseList(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, List<RpcGuestGroup> list, BusinessProtocolMessageStandard.Head head){
        BusinessProtocolEntities.TouristsGroup touristsGroup = null;
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response ;
        List<BusinessProtocolEntities.TouristsGroup> touristsGroupList = new ArrayList<>();
        JCRC32 jcrc32 = new JCRC32();
        for (RpcGuestGroup rpcGuestGroup : list){
            touristsGroup = BusinessProtocolEntities.TouristsGroup
                            .newBuilder()
                            .setGroupId(String.valueOf(rpcGuestGroup.getGroupId()))
                            .setGroupName(rpcGuestGroup.getGroupName())
                            .setGroupType(IMSContacts.UserType.TOURISTS_USER)
                            .build();
            touristsGroupList.add(touristsGroup);
        }
        BusinessProtocolMessages.GroupSettingsProtocol groupSettingsProtocol = BusinessProtocolMessages.GroupSettingsProtocol.newBuilder()
                .setTouristsGroup(touristsGroup)
                .setUserType(unifiedEntranceMessage.getGroupSettingsProtocol().getUserType())
                .setTouristsUser(unifiedEntranceMessage.getGroupSettingsProtocol().getTouristsUser())
                .setRegisteredUser(unifiedEntranceMessage.getGroupSettingsProtocol().getRegisteredUser())
                .setRegisteredGroup(unifiedEntranceMessage.getGroupSettingsProtocol().getRegisteredGroup())
                .setOperation(unifiedEntranceMessage.getGroupSettingsProtocol().getOperation())
                .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                        .newBuilder().setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupSettingsProtocol)
                        .setGroupSettingsProtocol(groupSettingsProtocol)
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
        response = jcrc32.packageCheckSum(message);
        return response;
    }

}
