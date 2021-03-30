package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.im.communication.util.ResponseStatus;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.login.client.registLoginAPI.GuestUserAPI;
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

public class GroupCreateUtils {

    private final Logger logger = Logger.getLogger(GroupCreateUtils.class);

    public void guestGroupListhdle(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, List<AllGroupMemberVO> allGroupMemberVOS,
                         ChannelHandlerContext ctx){
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        RequestUser request;
        ResponseUser responseUser;
        JCRC32 jcrc32 = new JCRC32();
        List<BusinessProtocolEntities.AllGroupMemberVO> allGroupMemberVOList = new ArrayList<>();//游客实体集合
        BusinessProtocolMessages.GroupCreateProtocol groupCreateProtocol ;

        RegistUserAPI registUserAPI = new RegistUserAPI();
        GuestUserAPI guestUserAPI = new GuestUserAPI();
        List<RegisterUser> registerUserListInfo;
        List<GuestUser> guestUserListInfo;
        List<BusinessProtocolEntities.RegisteredUser> registerUserList = new ArrayList<>();
        List<BusinessProtocolEntities.TouristsUser> guestUserList = new ArrayList<>();
        for (AllGroupMemberVO groupMemberVO : allGroupMemberVOS) {
            //查询注册用户个人资料
            request = RequestUser.newBuilder().setArgs(IMSContacts.MsgType.SEARCH_USER).setRegisterUser(RegisterUser.newBuilder()
                    .setUserId(String.valueOf(groupMemberVO.getGuestUserId())).build()).build();
            responseUser = registUserAPI.selectUserInfomation(request);
            registerUserListInfo = responseUser.getRegisterUserList();
            if (null != registerUserListInfo && registerUserListInfo.size()>0) {
                BusinessProtocolEntities.AllGroupMemberVO registeredGroupMember = BusinessProtocolEntities.AllGroupMemberVO.newBuilder()
                        .setGroupMemberId(groupMemberVO.getGroupMemberId())
                        .setGuestGroupId(groupMemberVO.getGuestGroupId())
                        .setGuestUserId(groupMemberVO.getGuestUserId())
                        .setGroupOwner(groupMemberVO.getGroupOwner())
                        .setGroupName(groupMemberVO.getGroupName())
                        .setAmount(groupMemberVO.getAmount())
                        .setAnnouncementContent(groupMemberVO.getAnnouncementContent())
                        .setRegisterUserNickAme(registerUserListInfo.get(0).getUserInfomation().getNickname())
                        .setUserPhoto(registerUserListInfo.get(0).getUserInfomation().getAvatar())
                        .build();
                allGroupMemberVOList.add(registeredGroupMember);
                BusinessProtocolEntities.RegisteredUser registeredUser = BusinessProtocolEntities.RegisteredUser.newBuilder()
                        .setUserId(String.valueOf(groupMemberVO.getGuestUserId()))
                        .build();
                registerUserList.add(registeredUser);
            }
            //查询游客用户个人资料
            request = RequestUser.newBuilder().setArgs(IMSContacts.MsgType.SEARCH_USER).setGuestUser(GuestUser.newBuilder()
                    .setUserId(String.valueOf(groupMemberVO.getGuestUserId())).build()).build();
            responseUser = guestUserAPI.selectGuestUserInfo(request);
            guestUserListInfo = responseUser.getGuestUserList();
            if(null != guestUserListInfo && guestUserListInfo.size()>0){
                BusinessProtocolEntities.AllGroupMemberVO touristsGroupMember = BusinessProtocolEntities.AllGroupMemberVO.newBuilder()
                        .setGroupMemberId(groupMemberVO.getGroupMemberId())
                        .setGuestGroupId(groupMemberVO.getGuestGroupId())
                        .setGuestUserId(groupMemberVO.getGuestUserId())
                        .setGroupOwner(groupMemberVO.getGroupOwner())
                        .setGroupName(groupMemberVO.getGroupName())
                        .setAmount(groupMemberVO.getAmount())
                        .setAnnouncementContent(groupMemberVO.getAnnouncementContent())
                        .setRegisterUserNickAme(guestUserListInfo.get(0).getUserInfomation().getNickname())
                        .setUserPhoto(guestUserListInfo.get(0).getUserInfomation().getAvatar())
                        .build();
                allGroupMemberVOList.add(touristsGroupMember);
                BusinessProtocolEntities.TouristsUser touristsUser = BusinessProtocolEntities.TouristsUser.newBuilder()
                        .setTemporaryId(String.valueOf(groupMemberVO.getGuestUserId()))
                        .build();
                guestUserList.add(touristsUser);
            }
        }
        BusinessProtocolEntities.TouristsGroup touristsGroup = BusinessProtocolEntities.TouristsGroup.newBuilder()
                .setGroupId(String.valueOf(allGroupMemberVOS.get(0).getGuestGroupId()))
                .setGroupName(allGroupMemberVOS.get(0).getGroupName())
                .build();
        if(registerUserList.size()>0){
            for (BusinessProtocolEntities.RegisteredUser registeredUser : registerUserList) {
                groupCreateProtocol = BusinessProtocolMessages.GroupCreateProtocol.newBuilder()
                        .setTouristsGroup(touristsGroup)
                        .setTouristsUser(unifiedEntranceMessage.getGroupCreateProtocol().getTouristsUser())
                        .setRegisteredUser(registeredUser)
//                        .addAllAllGroupMemberVo(allGroupMemberVOList)
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
        if(guestUserList.size()>0){
            for (BusinessProtocolEntities.TouristsUser touristsUser : guestUserList) {
                groupCreateProtocol = BusinessProtocolMessages.GroupCreateProtocol.newBuilder()
                        .setTouristsGroup(touristsGroup)
                        .setTouristsUser(touristsUser)
//                        .addAllAllGroupMemberVo(allGroupMemberVOList)
                        .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .build();
                BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                        .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupCreateProtocol)
                        .setGroupCreateProtocol(groupCreateProtocol)
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(head.getMsgType())
                        .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .setToId(touristsUser.getTemporaryId())
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

    public void groupMemberAddHdle(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage,AllGroupsMemberResponse allGroupsMemberResponse,ChannelHandlerContext ctx){
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        JCRC32 jcrc32 = new JCRC32();
        List<AllGroupMemberVO> responseGroupMemberVoList = allGroupsMemberResponse.getResponseGroupMemberVoList();
        AllGroupMemberVO responseGroupMemberVo = allGroupsMemberResponse.getResponseGroupMemberVo(0);
        BusinessProtocolMessages.GroupMemberAddProtocol groupMemberAddProtocol;
        //注册群
        if( 0 != responseGroupMemberVo.getRegisteredGroupId()){
            for (AllGroupMemberVO allRegGroupMemberVO : responseGroupMemberVoList) {
                BusinessProtocolEntities.AllGroupMemberVO registeredGroupMember = BusinessProtocolEntities.AllGroupMemberVO.newBuilder()
                        .setGroupMemberId(allRegGroupMemberVO.getGroupMemberId())
                        .setRegisteredUserId(allRegGroupMemberVO.getRegisteredUserId())
                        .setRegisteredGroupId(allRegGroupMemberVO.getRegisteredGroupId())
                        .build();
//                allGroupMemberVOList.add(registeredGroupMember);
                groupMemberAddProtocol = BusinessProtocolMessages.GroupMemberAddProtocol.newBuilder()
                        .setUserType(unifiedEntranceMessage.getGroupMemberAddProtocol().getUserType())
                        .addAllGroupMemberVo(registeredGroupMember)
//                        .addAllAllGroupMemberVo(allGroupMemberVOList)
                        .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .build();
                BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                        .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupMemberAddProtocol)
                        .setGroupMemberAddProtocol(groupMemberAddProtocol)
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(head.getMsgType())
                        .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS)
                        .setToId(String.valueOf(allRegGroupMemberVO.getRegisteredUserId()))
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
