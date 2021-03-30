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
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RegisteredGroupUpdateService {

    private final Logger logger = Logger.getLogger(RegisteredGroupUpdateService.class);

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage updateRegisteredGroup(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head){
        //还需以被添加人的角色检索记录
        StorageAPI storageAPI = new StorageAPI();
        TransmissionRequest transmissionRequest ;
        List<RpcRegisteredGroup> list ;
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response ;
        //装载grpc协议请求信息
        BusinessProtocolEntities.RegisteredUser  registeredUser = unifiedEntranceMessage.getGroupSettingsProtocol().getRegisteredUser();
        BusinessProtocolEntities.RegisteredGroup  registeredGroup = unifiedEntranceMessage.getGroupSettingsProtocol().getRegisteredGroup();
        transmissionRequest = TransmissionRequest.newBuilder()
                        .setRegisteredGroup(RpcRegisteredGroup.newBuilder()
                        .setGroupId(Integer.parseInt(registeredGroup.getGroupId()))
                        .setRegisteredUserId(Integer.parseInt(registeredUser.getUserId()))
                        .setGroupName(registeredGroup.getGroupName())
                        .setAmount(registeredGroup.getMemberCount())
                        .build()).build();
        RegisteredGroupResponse registeredGroupResponse = storageAPI.updateRegisteredGroupAPI(transmissionRequest);
        if(null != registeredGroupResponse){
            list = registeredGroupResponse.getResponseRegisteredGroupList();
            response = registeredGroupUpdateResponseList(unifiedEntranceMessage, list, head);
            return response;
        }else {
            ResponseUtil responseUtil = new ResponseUtil();
            response = responseUtil.requestWithResponseFail(unifiedEntranceMessage);
        }
        return response;
    }

    //游客群记录查询相关
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage registeredGroupUpdateResponseList(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, List<RpcRegisteredGroup> list, BusinessProtocolMessageStandard.Head head){
        BusinessProtocolEntities.RegisteredGroup registeredGroup = null;
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage response ;
        List<BusinessProtocolEntities.RegisteredGroup> registeredGroupList = new ArrayList<>();
        JCRC32 jcrc32 = new JCRC32();
        for (RpcRegisteredGroup rpcRegisteredGroup : list){
            registeredGroup = BusinessProtocolEntities.RegisteredGroup
                    .newBuilder()
                    .setGroupId(String.valueOf(rpcRegisteredGroup.getGroupId()))
                    .setGroupName(rpcRegisteredGroup.getGroupName())
                    .setGroupType(IMSContacts.UserType.REGISTERED_USER)
                    .setMemberCount(rpcRegisteredGroup.getAmount())
                    .build();
            registeredGroupList.add(registeredGroup);
        }
        BusinessProtocolMessages.GroupSettingsProtocol groupSettingsProtocol = BusinessProtocolMessages.GroupSettingsProtocol.newBuilder()
                .setTouristsGroup(unifiedEntranceMessage.getGroupSettingsProtocol().getTouristsGroup())
                .setUserType(unifiedEntranceMessage.getGroupSettingsProtocol().getUserType())
                .setTouristsUser(unifiedEntranceMessage.getGroupSettingsProtocol().getTouristsUser())
                .setRegisteredUser(unifiedEntranceMessage.getGroupSettingsProtocol().getRegisteredUser())
                .setRegisteredGroup(registeredGroup)
                .setOperation(unifiedEntranceMessage.getGroupSettingsProtocol().getOperation())
                .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupSettingsProtocol)
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

    public void inviteUserJoinGroup(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, ChannelHandlerContext ctx){
        StorageAPI storageAPI = new StorageAPI();
        //获取群ID
        String groupId = unifiedEntranceMessage.getHead().getToId();
        BusinessProtocolEntities.AllGroupMemberVO allGroupMemberVo = unifiedEntranceMessage.getGroupMemberAddProtocol().getAllGroupMemberVo(0);
        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder().setAllGroupMemberVo(AllGroupMemberVO.newBuilder()
                                                .setRegisteredGroupId(Integer.parseInt(groupId))
                                                .setRegisteredUserId(Integer.parseInt(unifiedEntranceMessage.getHead().getFromId()))
                                                .setGroupRemarks(allGroupMemberVo.getGroupRemarks())
                                                .build()).build();
        AllGroupsMemberResponse allGroupsMemberResponse = storageAPI.inviteUsersJoinGroup(transmissionRequest);
        GroupCreateUtils groupCreateUtils = new GroupCreateUtils();
        groupCreateUtils.groupMemberAddHdle(unifiedEntranceMessage,allGroupsMemberResponse,ctx);
    }
}
