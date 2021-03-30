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

public class RegisteredGroupCreateService {

    private final Logger logger = Logger.getLogger(RegisteredGroupCreateService.class);

    public void createRegisteredGroupAPIService(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, ChannelHandlerContext ctx){
        String userType = unifiedEntranceMessage.getGroupCreateProtocol().getUserType();
        StorageAPI storageAPI = new StorageAPI();
        TransmissionRequest transmissionRequest;
        RegisteredGroupCreateUtils groupUtils = new RegisteredGroupCreateUtils();
        BusinessProtocolEntities.RegisteredUser  registeredUser = unifiedEntranceMessage.getGroupCreateProtocol().getRegisteredUser();
        logger.info("创建注册群用户ID：" + registeredUser.getUserId()+"---群成员ID集合："+registeredUser.getAvatar());
        if(IMSContacts.UserType.REGISTERED_USER.equals(userType)){
            transmissionRequest = TransmissionRequest.newBuilder()
                                .setRegisteredGroup(RpcRegisteredGroup.newBuilder()
                                .setRegisteredUserId(Integer.parseInt(registeredUser.getUserId()))
                                .setGroupName(registeredUser.getNickname())
                                .build()).setRequestKind(registeredUser.getAvatar()).build();
            RegisteredGroupResponse registeredGroupResponse = storageAPI.insertRegisteredGroupAPI(transmissionRequest);
            List<AllGroupMemberVO> responseGroupMemberVoList = registeredGroupResponse.getResponseGroupMemberVoList();
            groupUtils.registeredGroupListhdle(unifiedEntranceMessage, responseGroupMemberVoList,ctx);
        }else {
            ResponseUtil responseUtil = new ResponseUtil();
            responseUtil.requestWithResponseFail(unifiedEntranceMessage);
        }
    }
}
