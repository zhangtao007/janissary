package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.login.client.registLoginAPI.RegistUserAPI;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import com.lanjiu.pro.login.*;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RegisteredGroupCreateUtils {

    private final Logger logger = Logger.getLogger(RegisteredGroupCreateUtils.class);

    public void registeredGroupListhdle(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, List<AllGroupMemberVO> allGroupMemberVOS, ChannelHandlerContext ctx){
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        RequestUser request;
        ResponseUser responseUser;
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessages.GroupCreateProtocol groupCreateProtocol;

        RegistUserAPI registUserAPI = new RegistUserAPI();
        List<RegisterUser> registerUserListInfo;
        List<BusinessProtocolEntities.RegisteredUser> registerUserList = new ArrayList<>();

        for (AllGroupMemberVO groupMemberVO : allGroupMemberVOS) {
            //查询注册用户个人资料
//            request = RequestUser.newBuilder().setArgs(IMSContacts.MsgType.SEARCH_USER).setRegisterUser(RegisterUser.newBuilder()
//                    .setUserId(String.valueOf(groupMemberVO.getRegisteredUserId())).build()).build();
//            responseUser = registUserAPI.selectUserInfomation(request);
//            registerUserListInfo = responseUser.getRegisterUserList();
//            if (null != registerUserListInfo && registerUserListInfo.size()>0) {
//            }
            BusinessProtocolEntities.RegisteredUser registeredUser = BusinessProtocolEntities.RegisteredUser.newBuilder()
                    .setUserId(String.valueOf(groupMemberVO.getRegisteredUserId()))
                    .build();
            registerUserList.add(registeredUser);
        }
        BusinessProtocolEntities.RegisteredGroup registeredGroup = BusinessProtocolEntities.RegisteredGroup.newBuilder()
                        .setGroupId(String.valueOf(allGroupMemberVOS.get(0).getRegisteredGroupId()))
                        .setGroupName(allGroupMemberVOS.get(0).getGroupName())
                        .setGroupAvatar(allGroupMemberVOS.get(0).getAnnouncementTitle())
                        .setMemberCount(allGroupMemberVOS.get(0).getAmount())
                        .build();
        if(registerUserList.size()>0){
            for (BusinessProtocolEntities.RegisteredUser registeredUser : registerUserList) {
                groupCreateProtocol = BusinessProtocolMessages.GroupCreateProtocol.newBuilder()
                        .setRegisteredGroup(registeredGroup)
                        .setUserType(unifiedEntranceMessage.getGroupCreateProtocol().getUserType())
                        .setTouristsUser(unifiedEntranceMessage.getGroupCreateProtocol().getTouristsUser())
                        .setRegisteredUser(registeredUser)
//                            .addAllAllGroupMemberVo(allGroupMemberVOList)
                        .addAllTouristsGroupMember(unifiedEntranceMessage.getGroupCreateProtocol().getTouristsGroupMemberList())
                        .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .build();
                BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                        .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupCreateProtocol)
                        .setGroupCreateProtocol(groupCreateProtocol)
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(head.getMsgType())
                        .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .setToId(registeredUser.getUserId())
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
