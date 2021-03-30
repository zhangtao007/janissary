package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.server.ResponseUtil;
import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

import java.util.List;

public class GuestGroupCreateService {

    private final Logger logger = Logger.getLogger(GuestGroupCreateService.class);

    public void createGuestGroupAPIService(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, ChannelHandlerContext ctx){
        String userType = unifiedEntranceMessage.getGroupCreateProtocol().getUserType();
        //还需以被添加人的角色检索记录
        StorageAPI storageAPI = new StorageAPI();
        TransmissionRequest transmissionRequest;
        GroupCreateUtils groupUtils = new GroupCreateUtils();
        //装载grpc协议请求信息
        BusinessProtocolEntities.TouristsUser  touristsUser = unifiedEntranceMessage.getGroupCreateProtocol().getTouristsUser();
        if(IMSContacts.UserType.TOURISTS_USER.equals(userType)){
            transmissionRequest = TransmissionRequest.newBuilder()
                            .setGuestGroup(RpcGuestGroup.newBuilder()
                            .setGuestUserId(Integer.parseInt(touristsUser.getTemporaryId()))
                            .setGroupName(touristsUser.getNickname())
                            .build()).build();
            GuestGroupResponse guestGroupResponse = storageAPI.insertGuestGroupAPI(transmissionRequest);
            List<AllGroupMemberVO> responseGroupMemberVoList = guestGroupResponse.getResponseGroupMemberVoList();
            groupUtils.guestGroupListhdle(unifiedEntranceMessage, responseGroupMemberVoList,ctx);
        }else {
            ResponseUtil responseUtil = new ResponseUtil();
            responseUtil.requestWithResponseFail(unifiedEntranceMessage);
        }
    }
}
