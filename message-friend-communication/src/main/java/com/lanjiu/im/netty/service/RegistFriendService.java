package com.lanjiu.im.netty.service;

import com.google.protobuf.ByteString;
import com.lanjiu.im.grpc.InformationStorageProto;
import com.lanjiu.im.grpc.InformationStorageServiceGrpc;
import com.lanjiu.im.grpc.client.file_storage.FileStorageAPI;
import com.lanjiu.im.grpc.client.infomation.StorageAPI;
import com.lanjiu.im.grpc.client.login_regist.login_storageAPI.GuestUserAPI;
import com.lanjiu.im.grpc.client.login_regist.login_storageAPI.RegistUserAPI;
import com.lanjiu.im.grpc.client.message_friend.mfAPI.OffFriendMessageAPI;

import com.lanjiu.im.grpc.utils.*;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import com.lanjiu.pro.fileStorage.*;
import com.lanjiu.pro.friend_msg.*;
import com.lanjiu.pro.login.*;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class RegistFriendService {

    private static final Logger logger = LoggerFactory.getLogger(RegistFriendService.class);

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage friendApplyRegist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolMessages.FriendChatProtocol friendChatProtocol = unifiedEntranceMessage.getFriendChatProtocol();
        String userType =friendChatProtocol.getUserType();
        String fromId = friendChatProtocol.getRegisteredUser().getUserId();
        String friendUserType = friendChatProtocol.getRegisteredFriend().getUserType();
        String toId = friendChatProtocol.getRegisteredFriend().getFriendUserId();
        String msgId = friendChatProtocol.getChatMessage().getMsgId();
        int msgType = friendChatProtocol.getChatMessage().getChatType();
        long msgTime =head.getTimestamp();
        String fromNickname = friendChatProtocol.getRegisteredUser().getNickname();
        String fromAtavar = friendChatProtocol.getRegisteredUser().getAvatar();
        String content = friendChatProtocol.getChatMessage().getText().getContent() == null ? ConstType.EMPTY :friendChatProtocol.getChatMessage().getText().getContent();

        JCRC32 jcrc32 = new JCRC32();
        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
        RequestFriendMessage requestFriendMessage = null;
        requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.MESSAGE_FRIEND_OFF)
                .addFriendMessage(FriendMessage.newBuilder()
                        .setFromId(Integer.parseInt(fromId))
                        .setToId(Integer.parseInt(toId))
                        .setContent(content)
                        .setMsgType(msgType)
                        .setMsgId(msgId)
                        .setCreateTime( String.valueOf(msgTime))
                        .setFromNickname(fromNickname)
                        .setFromAvatar(fromAtavar)
                        .build()).build();

        ResponseFriendMessage responseFriendMessage = null;
        try {
            responseFriendMessage = offFriendMessageAPI.storageFriendMessage(requestFriendMessage);
        } catch (Exception e) {
            logger.error("离线消息(好友申请)存储异常，fromId:{},and toId:{}",fromId,toId);
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setFriendChatProtocol(BusinessProtocolMessages.FriendChatProtocol.newBuilder()
                            .setUserType(userType)
                            .setStatusDetail(ConstType.EXCEPTION)
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .setUserId(fromId)
                                    .setNickname(fromNickname)
                                    .setAvatar(fromAtavar).build())
                            .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                                    .setFriendUserId(toId)
                                    .setUserType(friendUserType).build()
                            ).build())
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setMsgType(head.getMsgType())
                            .setFromId(fromId)
                            .setToId(toId)
                            .setTimestamp(msgTime)
                            .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE).build())
                    .build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return  checkUnifiedEntranceMessage;
        }

        //响应客户端
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setFriendChatProtocol(BusinessProtocolMessages.FriendChatProtocol.newBuilder()
                        .setUserType(userType)
                        .setStatusDetail(responseFriendMessage.getRet())
                        .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                .setUserId(fromId)
                                .setNickname(fromNickname)
                                .setAvatar(fromAtavar).build())
                        .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                                .setFriendUserId(toId)
                                .setUserType(friendUserType).build()
                        ).build())
                .setDataType(unifiedEntranceMessage.getDataType())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setMsgType(head.getMsgType())
                        .setFromId(fromId)
                        .setToId(toId)
                        .setTimestamp(msgTime)
                        .setStatusReport(responseFriendMessage.getRet()).build())
                .build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return  checkUnifiedEntranceMessage;

    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage agreeFriendApplyRegist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolMessages.FriendAddProtocol friendAddProtocol = unifiedEntranceMessage.getFriendAddProtocol();
        String userType =friendAddProtocol.getUserType();
        String fromId = friendAddProtocol.getRegisteredUser().getUserId();
        String fromNickname = friendAddProtocol.getRegisteredUser().getNickname();
        String fromAtavar = friendAddProtocol.getRegisteredUser().getAvatar();
        String friendUserType = friendAddProtocol.getRegisteredFriend(0).getUserType();
        String toId = friendAddProtocol.getRegisteredFriend(0).getFriendUserId();
        long msgTime =head.getTimestamp();
        int msgType = IMSContacts.MsgContentType.APPLY_AGREE_FRIEND_REGISTERED;
        RequestFriendMessage requestFriendMessage = null;

        requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.MESSAGE_FRIEND_OFF)
                .addFriendMessage(FriendMessage.newBuilder()
                        .setFromId(Integer.parseInt(fromId))
                        .setToId(Integer.parseInt(toId))
                        .setMsgId(String.valueOf(msgType))
                        .setMsgType(msgType)
                        .setContent(ConstType.EMPTY)
                        .setCreateTime(String.valueOf(msgTime))
                        .setFromNickname(fromNickname)
                        .setFromAvatar(fromAtavar)
                        .build()).build();
        JCRC32 jcrc32 = new JCRC32();
        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
        ResponseFriendMessage responseFriendMessage = null;
        try {
            responseFriendMessage = offFriendMessageAPI.storageFriendMessage(requestFriendMessage);
        } catch (Exception e) {
            logger.error("离线消息(好友同意)存储异常，fromId:{},and toId:{}",fromId,toId);
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setFriendAddProtocol(BusinessProtocolMessages.FriendAddProtocol.newBuilder()
                            .setUserType(userType)
                            .setStatusDetail(ConstType.EXCEPTION)
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .setUserId(fromId)
                                    .setNickname(fromNickname)
                                    .setAvatar(fromAtavar).build())
                            .addRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                                    .setFriendUserId(toId)
                                    .setUserType(friendUserType).build())
                            .build())
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setMsgType(head.getMsgType())
                            .setFromId(fromId)
                            .setToId(toId)
                            .setTimestamp(msgTime)
                            .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE).build())
                    .build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return  checkUnifiedEntranceMessage;
        }


        //响应客户端
        BusinessProtocolMessages.FriendAddProtocol friendAddProtocols = BusinessProtocolMessages.FriendAddProtocol.newBuilder()
                .setUserType(userType)
                .setStatusDetail(responseFriendMessage.getRet())
                .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                        .setUserId(fromId)
                        .setNickname(fromNickname)
                        .setAvatar(fromAtavar).build())
                .addRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                        .setFriendUserId(toId)
                        .setUserType(friendUserType).build())
                .build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setFriendAddProtocol(friendAddProtocols)
                .setDataType(unifiedEntranceMessage.getDataType())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setMsgType(head.getMsgType())
                        .setFromId(fromId)
                        .setToId(toId)
                        .setTimestamp(msgTime)
                        .setStatusReport(responseFriendMessage.getRet()).build())
                .build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return  checkUnifiedEntranceMessage;
        
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage refuseFriendApplyRegist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolMessages.FriendChatProtocol friendChatProtocol = unifiedEntranceMessage.getFriendChatProtocol();
        String userType =friendChatProtocol.getUserType();
        String fromId = friendChatProtocol.getRegisteredUser().getUserId();
        String fromNickname = friendChatProtocol.getRegisteredUser().getNickname();
        String fromAtavar = friendChatProtocol.getRegisteredUser().getAvatar();
        String friendUserType = friendChatProtocol.getRegisteredFriend().getUserType();
        String toId = friendChatProtocol.getRegisteredFriend().getFriendUserId();
        int msgType = friendChatProtocol.getChatMessage().getChatType();
        long msgTime =head.getTimestamp();
        String content =   friendChatProtocol.getChatMessage().getText().getContent() == null ? ConstType.EMPTY :   friendChatProtocol.getChatMessage().getText().getContent();
        RequestFriendMessage requestFriendMessage = null;

        requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.MESSAGE_FRIEND_OFF)
                .addFriendMessage(FriendMessage.newBuilder()
                        .setFromId(Integer.parseInt(fromId))
                        .setToId(Integer.parseInt(toId))
                        .setContent(content)
                        .setMsgType(msgType)
                        .setMsgId(String.valueOf(msgType))
                        .setCreateTime(String.valueOf(msgTime))
                        .setFromAvatar(fromAtavar)
                        .setFromNickname(fromNickname)
                        .build()).build();
        JCRC32 jcrc32 = new JCRC32();
        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
        ResponseFriendMessage responseFriendMessage = null;
        try {
            responseFriendMessage = offFriendMessageAPI.storageFriendMessage(requestFriendMessage);
        } catch (Exception e) {
            logger.error("离线消息(好友拒绝)存储异常，fromId:{},and toId:{}",fromId,toId);
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setFriendChatProtocol(BusinessProtocolMessages.FriendChatProtocol.newBuilder()
                            .setUserType(userType)
                            .setStatusDetail(ConstType.EXCEPTION)
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .setUserId(fromId)
                                    .setNickname(fromNickname)
                                    .setAvatar(fromAtavar)
                                    .build())
                            .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                                    .setFriendUserId(toId)
                                    .setUserType(friendUserType).build()
                            ).build())
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setMsgType(head.getMsgType())
                            .setFromId(fromId)
                            .setToId(toId)
                            .setTimestamp(msgTime)
                            .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE).build())
                    .build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return  checkUnifiedEntranceMessage;
        }

        //响应客户端
        BusinessProtocolMessages.FriendChatProtocol friendChatProtocols = BusinessProtocolMessages.FriendChatProtocol.newBuilder()
                .setUserType(userType)
                .setStatusDetail(responseFriendMessage.getRet())
                .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                        .setUserId(fromId)
                        .setNickname(fromNickname)
                        .setAvatar(fromAtavar)
                        .build())
                .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                        .setFriendUserId(toId)
                        .setUserType(friendUserType).build()
                ).build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setFriendChatProtocol(friendChatProtocols)
                .setDataType(unifiedEntranceMessage.getDataType())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setMsgType(head.getMsgType())
                        .setFromId(fromId)
                        .setToId(toId)
                        .setTimestamp(msgTime)
                        .setStatusReport(responseFriendMessage.getRet()).build())
                .build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return  checkUnifiedEntranceMessage;
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage friendChatRegist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head)  {
        BusinessProtocolMessages.FriendChatProtocol friendChatProtocol = unifiedEntranceMessage.getFriendChatProtocol();
        String userType =friendChatProtocol.getUserType();
        String fromId = friendChatProtocol.getRegisteredUser().getUserId();
        String fromNickname = friendChatProtocol.getRegisteredUser().getNickname();
        String fromAtavar = friendChatProtocol.getRegisteredUser().getAvatar();
        String friendUserType = friendChatProtocol.getRegisteredFriend().getUserType();
        String toId = friendChatProtocol.getRegisteredFriend().getFriendUserId();
        String msgId = friendChatProtocol.getChatMessage().getMsgId();
        boolean offlineMessage = friendChatProtocol.getRegisteredFriend().getSettings().getOfflineMessage();
        boolean snapchatStatus = friendChatProtocol.getRegisteredFriend().getSettings().getSnapchatStatus();
        int snapchatTimeLength = friendChatProtocol.getRegisteredFriend().getSettings().getSnapchatTimeLength();
        long msgTime = head.getTimestamp();
        int msgType = friendChatProtocol.getChatMessage().getChatType();
        String content = "";
        byte[] bytes =null;
        String url = "";
        long video_time=0;
        boolean frindOffMsgSetting=false;
        JCRC32 jcrc32 = new JCRC32();
        long start = System.currentTimeMillis();

/*
        //1.调资料服务器接口，判断好友的好友之间离线消息设置
        if(friendUserType.equals(IMSContacts.UserType.REGISTERED_USER)){

            StorageAPI storageAPI = new StorageAPI();
            InformationStorageProto.TransmissionRequest request = InformationStorageProto.TransmissionRequest.newBuilder().setRequestKind(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_FRIEND_USER_ID)
                    .setRegisteredUserFriend(InformationStorageProto.RpcRegisteredUserFriend.newBuilder()
                            .setRegisteredUserId(Integer.parseInt(toId))
                            .setFriendUserId(Integer.parseInt(fromId)).build()).build();
            InformationStorageProto.RpcRegisteredUserFriend infoServerRespponse = null;
            //grpc连接池方式一
//            InformationStorageServiceGrpc.InformationStorageServiceBlockingStub stub =null;
//            infoServerRespponse = (InformationStorageProto.RpcRegisteredUserFriend)InfoClient.call("checkFriend", toId, fromId);
            //grpc连接池方式二
//            Pool  infoPool  =Pool.getPoolInstanse();
////            infoPool.init();
////            infoPool.timer();
//            try {
//                 stub = infoPool.get();
//                infoServerRespponse = stub.queryUserFriendRelation(request);
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                if(stub != null){
//                    infoPool.release(stub);
//                    System.out.println("释放连接对象》》》》》stub:"+stub.toString());
//                }
//            }
            //普通方式调用
            try {
                infoServerRespponse = storageAPI.queryUserFriendRelation(request);
            } catch (Exception e) {
                logger.error("离线消息(聊天消息)存储时调用资料服务器接口异常，fromId:{},and toId:{}，msgType:{}",fromId,toId,msgType);
                BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                        .setDataType(unifiedEntranceMessage.getDataType())
                        .setFriendChatProtocol( BusinessProtocolMessages.FriendChatProtocol.newBuilder()
                                .setUserType(IMSContacts.UserType.REGISTERED_USER)
                                .setStatusDetail(ConstType.EXCEPTION)
                                .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder().setUserId(fromId).build())
                                .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                                        .setFriendUserId(toId)
                                        .setUserType(friendUserType).build()
                                ).build())
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                .setToken(head.getToken())
                                .setUniqueIdentify(head.getUniqueIdentify())
                                .setMsgType(head.getMsgType())
                                .setFromId(fromId)
                                .setToId(toId)
                                .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE).build())
                        .build();
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
                return  checkUnifiedEntranceMessage;
            }
            frindOffMsgSetting = infoServerRespponse.getOfflineMessageSetting().equalsIgnoreCase(ConstType.ON)  ? true : false;
        }else if(friendUserType.equals(IMSContacts.UserType.TOURISTS_USER)){

            StorageAPI storageAPI = new StorageAPI();
            InformationStorageProto.TransmissionRequest request = InformationStorageProto.TransmissionRequest.newBuilder().setRequestKind(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_FRIEND_USER_ID)
                    .setGuestUserFriend(InformationStorageProto.RpcGuestUserFriend.newBuilder()
                            .setGuestUserId(Integer.parseInt(fromId))
                            .setFriendUserId(Integer.parseInt(toId)).build()).build();
            InformationStorageProto.RpcRegisteredUserFriend infoServerRespponse = storageAPI.queryUserFriendRelation(request);
            frindOffMsgSetting = infoServerRespponse.getOfflineMessageSetting().equalsIgnoreCase(ConstType.ON)  ? true : false;

        }
        long inforTime = System.currentTimeMillis();
        //当用户不接受离线消息
      if(!frindOffMsgSetting) {

            BusinessProtocolMessages.FriendChatProtocol friendChatProtocols = BusinessProtocolMessages.FriendChatProtocol.newBuilder()
                    .setUserType(IMSContacts.UserType.REGISTERED_USER)
                    .setStatusDetail(ConstType.OFF_MSG_SETTING)
                    .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder().setUserId(fromId).build())
                    .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                            .setFriendUserId(toId)
                            .setUserType(friendUserType).build()
                    ).build();

            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setFriendChatProtocol(friendChatProtocols)
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setMsgType(head.getMsgType())
                            .setFromId(fromId)
                            .setToId(toId)
                            .setStatusReport(ResponseStatus.STATUS_REPORT_REFUSE).build())
                    .build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return  checkUnifiedEntranceMessage;
        }

*/



        if(msgType==IMSContacts.MsgContentType.TEXT){
            content = friendChatProtocol.getChatMessage().getText().getContent();
        }else if(msgType == IMSContacts.MsgContentType.PICTURE){
            url = friendChatProtocol.getChatMessage().getPicture().getUrl();
            bytes=friendChatProtocol.getChatMessage().getPicture().getThumbnail().toByteArray();
            try {
                content = new String(bytes,"ISO-8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }else if(msgType == IMSContacts.MsgContentType.VIDEO){
            url = friendChatProtocol.getChatMessage().getVideo().getUrl();
             bytes = friendChatProtocol.getChatMessage().getVideo().getThumbnail().toByteArray();
             video_time = friendChatProtocol.getChatMessage().getVideo().getPos();
            try {
                content = new String(bytes,"ISO-8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else if(msgType == IMSContacts.MsgContentType.VOICE){
            bytes = friendChatProtocol.getChatMessage().getVoice().getContent().toByteArray();
            try {
                content = new String(bytes,"ISO-8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else if(msgType ==IMSContacts.MsgContentType.FILE){
            url = friendChatProtocol.getChatMessage().getFile().getUrl();
            content = friendChatProtocol.getChatMessage().getFile().getUrl();
        }else {
            content = friendChatProtocol.getChatMessage().getText().getContent();
        }


        //todo
        RegistUserAPI userAPI = new RegistUserAPI();
        RequestUserDevice deviceResponse = userAPI.updateUserDevice(RequestUserDevice.newBuilder().addRequestDeviceUpdate(RequestDeviceUpdate.newBuilder()
                .setUserId(toId).setStatusDetail("select").build()).build());
        if (deviceResponse != null && deviceResponse.getRequestDeviceUpdate(0).getStatusDetail().equalsIgnoreCase(ResponseStatus.STATUS_REPORT_SUCCESS)){
            String pushToken = deviceResponse.getRequestDeviceUpdate(0).getPushToken();
            Map<String,String> data = new HashMap();
            data.put("fromId",fromId);
            data.put("toId",toId);
            data.put("content",content);
            data.put("pushToken",pushToken);
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setMsgType(head.getMsgType())
                            .setFromId(fromId)
                            .setToId(toId)
                            .setStatusReport("huawei-push").build())
                    .setFriendChatProtocol(BusinessProtocolMessages.FriendChatProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder().setSecret(pushToken).build())
                            .setStatusDetail(data.toString())
                            .build()).build();

            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage entranceMessage = jcrc32.packageCheckSum(message);
            return entranceMessage;
        }

        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
        RequestFriendMessage requestFriendMessage = null;
        requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.MESSAGE_FRIEND_OFF)
                .addFriendMessage(FriendMessage.newBuilder()
                        .setMsgId(msgId)
                        .setFromId(Integer.parseInt(fromId))
                        .setToId(Integer.parseInt(toId))
                        .setContent(content)
                        .setEntityUrl(url)
                        .setMsgType(msgType)
                        .setCreateTime(String.valueOf(msgTime))
                        .setFromNickname(fromNickname)
                        .setFromAvatar(fromAtavar)
                        .setMessageOfflineStatus(offlineMessage)
                        .setBurnAfterReadingStatus(snapchatStatus)
                        .setBurnAfterReadingLength(snapchatTimeLength)
                        .setVideoTime(video_time)
                        .build()).build();

        ResponseFriendMessage responseFriendMessage = null;
        try {
            responseFriendMessage = offFriendMessageAPI.storageFriendMessage(requestFriendMessage);
        } catch (Exception e) {
            logger.error("离线消息(聊天消息)存储时存储接口异常，fromId:{},and toId:{}，msgType:{}",fromId,toId,msgType);
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setFriendChatProtocol( BusinessProtocolMessages.FriendChatProtocol.newBuilder()
                            .setUserType(IMSContacts.UserType.REGISTERED_USER)
                            .setStatusDetail(ConstType.EXCEPTION)
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder().setUserId(fromId).build())
                            .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                                    .setFriendUserId(toId)
                                    .setUserType(friendUserType).build()
                            ).build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setMsgType(head.getMsgType())
                            .setFromId(fromId)
                            .setToId(toId)
                            .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE).build())
                    .build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return  checkUnifiedEntranceMessage;
        }
        long end = System.currentTimeMillis();
//        logger.info("###########################################离线消息存储接口总耗时：" +(end-start)+",    fromid:"+fromId);
//        logger.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^离线消息存储时调资料接口耗时：" +(inforTime-start)+",    fromid:"+fromId);

        //响应客户端
        BusinessProtocolMessages.FriendChatProtocol friendChatProtocols = BusinessProtocolMessages.FriendChatProtocol.newBuilder()
                .setUserType(IMSContacts.UserType.REGISTERED_USER)
                .setStatusDetail(responseFriendMessage.getRet())
                .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                        .setUserId(fromId)
                        .setNickname(fromNickname)
                        .setAvatar(fromAtavar).build())
                .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                        .setFriendUserId(toId)
                        .setUserType(friendUserType).build()
                ).build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setFriendChatProtocol(friendChatProtocols)
                .setDataType(unifiedEntranceMessage.getDataType())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setMsgType(head.getMsgType())
                        .setFromId(fromId)
                        .setToId(toId)
                        .setTimestamp(msgTime)
                        .setStatusReport(responseFriendMessage.getRet()).build())
                .build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return  checkUnifiedEntranceMessage;

    }

    //存储删除指令
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage delFriendOffMessageRegist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolMessages.DelFriendOffMessageProtocol delFriendOffMessageProtocol = unifiedEntranceMessage.getDelFriendOffMessageProtocol();
        String userType =delFriendOffMessageProtocol.getUserType();
        String delfromId = head.getFromId();
        String friendUserType = delFriendOffMessageProtocol.getRegisteredFriend().getUserType();
        String deltoId = head.getToId();
        String[] msgIdArr = delFriendOffMessageProtocol.getChatMessage().getMsgId().split(",");
        String[] msgfromIdArr = delFriendOffMessageProtocol.getMsgfromId().split(",");
        String[] msgTimeArr = delFriendOffMessageProtocol.getStatusDetail().split(",");
        String[] chatTypeArr = delFriendOffMessageProtocol.getChatMessage().getText().getLength().split(",");
        String[] urlArr = delFriendOffMessageProtocol.getChatMessage().getText().getContent().split(",");
        JCRC32 jcrc32 = new JCRC32();
        String onlineStatus = "";
        String url = "";
        String file_userType = "";
        String settingsType = "";
        NotifyDelMsg notifyDelMsg = null;
        List<NotifyDelMsg>  delMsgList = new ArrayList<>();


        if(friendUserType.equals(IMSContacts.UserType.REGISTERED_USER)){
            RegistUserAPI loginAPI = new RegistUserAPI();
            RequestUser requestUser = RequestUser.newBuilder().setArgs(ConstType.SEARCH_USER).setUserType(friendUserType).setRegisterUser(RegisterUser.newBuilder().setUserId(deltoId).build()).build();
            ResponseUser responseUser = null;
            try {
                responseUser = loginAPI.selectUserInfomation(requestUser);
            } catch (Exception e) {
                logger.error("离线消息(删除消息)存储时调用登录服务的用户查询接口异常，delfromId:{},and deltoId:{}",delfromId,deltoId);
                BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                        .setDataType(unifiedEntranceMessage.getDataType())
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                .setToken(head.getToken())
                                .setUniqueIdentify(head.getUniqueIdentify())
                                .setMsgType(head.getMsgType())
                                .setFromId(delfromId)
                                .setToId(deltoId)
                                .setTimestamp(head.getTimestamp())
                                .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE).build())
                        .build();
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
                return  checkUnifiedEntranceMessage;
            }
            if(responseUser.getRet().equalsIgnoreCase(ConstType.FAILURE)){
                BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                        .setDataType(unifiedEntranceMessage.getDataType())
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                .setToken(head.getToken())
                                .setUniqueIdentify(head.getUniqueIdentify())
                                .setMsgType(head.getMsgType())
                                .setFromId(delfromId)
                                .setToId(deltoId)
                                .setTimestamp(head.getTimestamp())
                                .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE).build())
                        .build();
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
                return  checkUnifiedEntranceMessage;
            }
            onlineStatus = responseUser.getRegisterUser(0).getUserInfomation().getOnlineStatus();

        }else if(friendUserType.equals(IMSContacts.UserType.TOURISTS_USER)){
            GuestUserAPI guestLoginAPI = new GuestUserAPI();
            RequestUser requestUser = RequestUser.newBuilder().setArgs(ConstType.SEARCH_USER).setUserType(friendUserType).setGuestUser(GuestUser.newBuilder().setUserId(deltoId).build()).build();
            ResponseUser responseUser = guestLoginAPI.selectGuestUserInfo(requestUser);
            onlineStatus = responseUser.getGuestUser(0).getUserInfomation().getOnlineStatus();

        }
        //多项消息删除操作
        for(int i=0,j=0;i<chatTypeArr.length;i++) {

            //图片类文件筛选处理
            if (!chatTypeArr[i].equals(String.valueOf(IMSContacts.MsgContentType.TEXT))) {
                url = urlArr[j];
                j++;

                //仅先执行删除文件图片等
                if (friendUserType.equalsIgnoreCase(IMSContacts.UserType.REGISTERED_USER) &&
                        ((chatTypeArr[i].equals(String.valueOf(IMSContacts.MsgContentType.PICTURE))) || (chatTypeArr[i].equals(String.valueOf(IMSContacts.MsgContentType.VIDEO))))) {
                    file_userType = ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_FRIENDS_REGISTERED_USER;
                    //调用文件服务，参数设置
                    if (chatTypeArr[i].equals(String.valueOf(IMSContacts.MsgContentType.PICTURE))) {
                        settingsType = ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE;
                    } else if (chatTypeArr[i].equals(String.valueOf(IMSContacts.MsgContentType.VIDEO))) {
                        settingsType = ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO;
                    }
                    FileStorageAPI fileStorageAPI = new FileStorageAPI();
                    FriendsTransmissionRequest friendsTransmissionRequest = FriendsTransmissionRequest.newBuilder()
                            .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
                                    .setUserType(file_userType)
                                    .setSettingsType(settingsType)
                                    .setRegisteredUser(RegisteredUser.newBuilder()
                                            .setUserId(msgfromIdArr[i]).build())
                                    .setFriends(Friends.newBuilder()
                                            .setFriendsId(msgfromIdArr[i]).build())
                                    .setFileContent(FileContent.newBuilder()
                                            .setBigFileHead(BigFileHead.newBuilder()
                                                    .setServerUrl(url).build())
                                            .build())
                                    .build())
                            .build();

                    try {
                        fileStorageAPI.deleteFileInformationWithFriend(friendsTransmissionRequest);
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error("离线消息(删除消息)调用文件存储接口异常，delfromId:{},and deltoId:{}, url:{}",delfromId,deltoId,url);
                        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                                .setDataType(unifiedEntranceMessage.getDataType())
                                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                        .setToken(head.getToken())
                                        .setUniqueIdentify(head.getUniqueIdentify())
                                        .setMsgType(head.getMsgType())
                                        .setFromId(delfromId)
                                        .setToId(deltoId)
                                        .setTimestamp(head.getTimestamp())
                                        .setStatusReport(ResponseStatus.STATUS_REPORT_EXCEPTION).build())
                                .build();
                        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
                        return  checkUnifiedEntranceMessage;
                    }

                } else if (friendUserType.equalsIgnoreCase(IMSContacts.UserType.TOURISTS_USER) &&
                        ((chatTypeArr[i].equals(String.valueOf(IMSContacts.MsgContentType.PICTURE))) || (chatTypeArr[i].equals(String.valueOf(IMSContacts.MsgContentType.VIDEO))))) {
                    file_userType = ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_FRIENDS_GUEST_USER;

                    if (chatTypeArr[i].equals(String.valueOf(IMSContacts.MsgContentType.PICTURE))) {
                        settingsType = ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE;
                    } else if (chatTypeArr[i].equals(String.valueOf(IMSContacts.MsgContentType.VIDEO))) {
                        settingsType = ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO;
                    }
                    FileStorageAPI fileStorageAPI = new FileStorageAPI();
                    FriendsTransmissionRequest friendsTransmissionRequest = FriendsTransmissionRequest.newBuilder()
                            .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
                                    .setUserType(file_userType)
                                    .setSettingsType(settingsType)
                                    .setTourists(Tourists.newBuilder()
                                            .setTemporaryId(msgfromIdArr[i]).build())
                                    .setFriends(Friends.newBuilder()
                                            .setFriendsId(msgfromIdArr[i]).build())
                                    .setFileContent(FileContent.newBuilder()
                                            .setBigFileHead(BigFileHead.newBuilder()
                                                    .setServerUrl(url).build())
                                            .build())
                                    .build())
                            .build();
                    fileStorageAPI.deleteFileInformationWithFriend(friendsTransmissionRequest);
                }
                //接收方为：离线时存储文件删除指令
                if(!onlineStatus.equalsIgnoreCase(ConstType.ON)){
                    notifyDelMsg = NotifyDelMsg.newBuilder()
                            .setArgs(chatTypeArr[i])
                            .setDelfromId(Integer.parseInt(delfromId))
                            .setDeltoId(Integer.parseInt(deltoId))
                            .setMsgId(msgIdArr[i])
                            .setFromId(Integer.parseInt(msgfromIdArr[i]))
                            .setTimestap(msgTimeArr[i])
                            .build();

                    delMsgList.add(notifyDelMsg);
                }

            }else{
                if(!onlineStatus.equalsIgnoreCase(ConstType.ON)) {
                    //非图片类直接存储删除指令；
                    notifyDelMsg = NotifyDelMsg.newBuilder()
                            .setArgs(chatTypeArr[i])
                            .setDelfromId(Integer.parseInt(delfromId))
                            .setDeltoId(Integer.parseInt(deltoId))
                            .setMsgId(msgIdArr[i])
                            .setFromId(Integer.parseInt(msgfromIdArr[i]))
                            .setTimestap(msgTimeArr[i])
                            .build();
                    delMsgList.add(notifyDelMsg);
                }
          }

        }


        //grpc调用消息存储服务
        ResponseFriendMessage responseFriendMessage =null;
        if(delMsgList.size() <=0){
            //在线时，直接响应
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setDelFriendOffMessageProtocol(BusinessProtocolMessages.DelFriendOffMessageProtocol.newBuilder()
                            .setUserType(IMSContacts.UserType.REGISTERED_USER)
                            .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .setUserId(delfromId)
                                    .setNickname(delFriendOffMessageProtocol.getRegisteredUser().getNickname())
                                    .setAvatar(delFriendOffMessageProtocol.getRegisteredUser().getAvatar()).build())
                            .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                                    .setFriendUserId(deltoId)
                                    .setUserType(friendUserType).build()
                            ).build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setMsgType(head.getMsgType())
                            .setFromId(delfromId)
                            .setToId(deltoId)
                            .setTimestamp(head.getTimestamp())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_SUCCESS).build())
                    .build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return  checkUnifiedEntranceMessage;
        }
        RequestFriendMessage requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.MESSAGE_FRIEND_DEL)
                .addAllNotifyDelMsg(delMsgList)
                .build();
        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
        try {
            responseFriendMessage = offFriendMessageAPI.storageFriendMessage(requestFriendMessage);
        } catch (Exception e) {
            logger.error("离线消息(删除消息)存储时调用存储接口异常，delfromId:{},and deltoId:{}",delfromId,deltoId);
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setMsgType(head.getMsgType())
                            .setFromId(delfromId)
                            .setToId(deltoId)
                            .setTimestamp(head.getTimestamp())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE).build())
                    .build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return  checkUnifiedEntranceMessage;
        }
        //响应客户端
        BusinessProtocolMessages.DelFriendOffMessageProtocol delFriendOffMessageProtocols = BusinessProtocolMessages.DelFriendOffMessageProtocol.newBuilder()
                .setUserType(IMSContacts.UserType.REGISTERED_USER)
                .setStatusDetail(responseFriendMessage.getRet())
                .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                        .setUserId(delfromId)
                        .setNickname(delFriendOffMessageProtocol.getRegisteredUser().getNickname())
                        .setAvatar(delFriendOffMessageProtocol.getRegisteredUser().getAvatar()).build())
                .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                        .setFriendUserId(deltoId)
                        .setUserType(friendUserType).build()
                ).build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setDelFriendOffMessageProtocol(delFriendOffMessageProtocols)
                .setDataType(unifiedEntranceMessage.getDataType())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setMsgType(head.getMsgType())
                        .setFromId(delfromId)
                        .setToId(deltoId)
                        .setTimestamp(head.getTimestamp())
                        .setStatusReport(responseFriendMessage.getRet()).build())
                .build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return  checkUnifiedEntranceMessage;

    }

    //捞取离线消息
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage getRegistFriendOffMessage(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head)  {
        BusinessProtocolMessages.OffFriendMessageListProtocol offFriendMessageListProtocol = unifiedEntranceMessage.getOffFriendMessageListProtocol();
        String userId = offFriendMessageListProtocol.getRegisteredUser().getUserId();
        String onTime = String.valueOf(unifiedEntranceMessage.getHead().getTimestamp());
        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
        RequestFriendMessage requestFriendMessage = null;
        JCRC32 jcrc32 = new JCRC32();
        requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.MESSAGE_REQUEST_SELECT_TO_ID)
                .addFriendMessage(FriendMessage.newBuilder()
                        .setToId(Integer.parseInt(userId))
                        .setCreateTime(onTime).build())
                .build();
        ResponseFriendMessage responseFriendMessage = null;
        try {
            responseFriendMessage = offFriendMessageAPI.selectFriendMessage(requestFriendMessage);
        } catch (Exception e) {
           logger.error("捞取用户离线消息异常，userId:{}",userId);
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OffFriendMessageListProtocol)
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)
                            .setToken(head.getToken())
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setMsgType(head.getMsgType())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .build())
                    .build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return checkUnifiedEntranceMessage;
        }

        //响应IMServer
        List<FriendMessage> friendMessageList = responseFriendMessage.getFriendMessageList();
        List<NotifyDelMsg>  notifyDelMsgList  = responseFriendMessage.getNotifyDelMsgList();
        List<BusinessProtocolEntities.RegistFriendOffMessage> rfomlist = new ArrayList<>();
        String content = null;
        String url = null;
        ByteString bytes1 = null;
        String fromUserType = "";
        BusinessProtocolEntities.RegistFriendOffMessage rfm = null;


        if(friendMessageList.size()>0 ) {

            for (FriendMessage fm : friendMessageList) {
                int msgType = fm.getMsgType();
//                if (fm.getFromId() < 70000000) {
                    fromUserType = "100";
//                } else {
//                    fromUserType = "101";
//                }

                if (msgType == IMSContacts.MsgContentType.TEXT) {
                    rfm = BusinessProtocolEntities.RegistFriendOffMessage.newBuilder()
                            .setMsgId(String.valueOf(fm.getMsgId()))
                            .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                                    .setUserType(fromUserType)
                                    .setFriendUserId(String.valueOf(fm.getFromId()))
                                    .setFriendNickname(fm.getFromNickname())
                                    .setFriendAvatar(fm.getFromAvatar())
                                    .setSettings(BusinessProtocolEntities.Settings.newBuilder()
                                            .setOfflineMessage(fm.getMessageOfflineStatus())
                                            .setSnapchatStatus(fm.getBurnAfterReadingStatus())
                                            .setSnapchatTimeLength(fm.getBurnAfterReadingLength()).build())
                                    .build())
                            .setChatType(msgType)
                            .setMsgTime(fm.getCreateTime())
                            .setText(BusinessProtocolEntities.Text.newBuilder().setContent(fm.getContent()).build())
                            .build();
                } else if (msgType == IMSContacts.MsgContentType.PICTURE) {

                    try {
                        bytes1 = ByteString.copyFrom(fm.getContent().getBytes("ISO-8859-1"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    rfm = BusinessProtocolEntities.RegistFriendOffMessage.newBuilder()
                            .setMsgId(String.valueOf(fm.getMsgId()))
                            .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                                    .setUserType(fromUserType)
                                    .setFriendUserId(String.valueOf(fm.getFromId()))
                                    .setFriendNickname(fm.getFromNickname())
                                    .setFriendAvatar(fm.getFromAvatar())
                                    .setSettings(BusinessProtocolEntities.Settings.newBuilder()
                                            .setOfflineMessage(fm.getMessageOfflineStatus())
                                            .setSnapchatStatus(fm.getBurnAfterReadingStatus())
                                            .setSnapchatTimeLength(fm.getBurnAfterReadingLength()).build())
                                    .build())
                            .setChatType(msgType)
                            .setMsgTime(fm.getCreateTime())
                            .setPicture(BusinessProtocolEntities.Picture.newBuilder()
                                    .setUrl(fm.getEntityUrl())
                                    .setThumbnail(bytes1).build())
                            .build();

                } else if (msgType == IMSContacts.MsgContentType.VIDEO) {
                    try {
                        bytes1 = ByteString.copyFrom(fm.getContent().getBytes("ISO-8859-1"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    rfm = BusinessProtocolEntities.RegistFriendOffMessage.newBuilder()
                            .setMsgId(String.valueOf(fm.getMsgId()))
                            .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                                    .setUserType(fromUserType)
                                    .setFriendUserId(String.valueOf(fm.getFromId()))
                                    .setFriendNickname(fm.getFromNickname())
                                    .setFriendAvatar(fm.getFromAvatar())
                                    .setSettings(BusinessProtocolEntities.Settings.newBuilder()
                                            .setOfflineMessage(fm.getMessageOfflineStatus())
                                            .setSnapchatStatus(fm.getBurnAfterReadingStatus())
                                            .setSnapchatTimeLength(fm.getBurnAfterReadingLength()).build())
                                    .build())
                            .setChatType(msgType)
                            .setMsgTime(fm.getCreateTime())
                            .setVideo(BusinessProtocolEntities.Video.newBuilder()
                                    .setUrl(fm.getEntityUrl())
                                    .setPos(fm.getVideoTime())
                                    .setThumbnail(bytes1).build())
                            .build();
                } else if (msgType == IMSContacts.MsgContentType.VOICE) {

                    try {
                        bytes1 = ByteString.copyFrom(fm.getContent().getBytes("ISO-8859-1"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    rfm = BusinessProtocolEntities.RegistFriendOffMessage.newBuilder()
                            .setMsgId(String.valueOf(fm.getMsgId()))
                            .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                                    .setUserType(fromUserType)
                                    .setFriendUserId(String.valueOf(fm.getFromId()))
                                    .setFriendNickname(fm.getFromNickname())
                                    .setFriendAvatar(fm.getFromAvatar())
                                    .setSettings(BusinessProtocolEntities.Settings.newBuilder()
                                            .setOfflineMessage(fm.getMessageOfflineStatus())
                                            .setSnapchatStatus(fm.getBurnAfterReadingStatus())
                                            .setSnapchatTimeLength(fm.getBurnAfterReadingLength()).build())
                                    .build())
                            .setChatType(msgType)
                            .setMsgTime(fm.getCreateTime())
                            .setVoice(BusinessProtocolEntities.Voice.newBuilder()
                                    .setContent(bytes1).build())
                            .build();


                } else if (msgType == IMSContacts.MsgContentType.FILE) {
                    rfm = BusinessProtocolEntities.RegistFriendOffMessage.newBuilder()
                            .setMsgId(String.valueOf(fm.getMsgId()))
                            .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                                    .setUserType(fromUserType)
                                    .setFriendUserId(String.valueOf(fm.getFromId()))
                                    .setFriendNickname(fm.getFromNickname())
                                    .setFriendAvatar(fm.getFromAvatar())
                                    .setSettings(BusinessProtocolEntities.Settings.newBuilder()
                                            .setOfflineMessage(fm.getMessageOfflineStatus())
                                            .setSnapchatStatus(fm.getBurnAfterReadingStatus())
                                            .setSnapchatTimeLength(fm.getBurnAfterReadingLength()).build())
                                    .build())
                            .setChatType(msgType)
                            .setMsgTime(fm.getCreateTime())
                            .setFile(BusinessProtocolEntities.File.newBuilder().setUrl(fm.getEntityUrl()).build())
                            .build();
                } else {
                    //好友申请、同意、决绝、删除类消息

                    rfm = BusinessProtocolEntities.RegistFriendOffMessage.newBuilder()
                            .setMsgId(String.valueOf(fm.getMsgId()))
                            .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                                    .setUserType(fromUserType)
                                    .setFriendUserId(String.valueOf(fm.getFromId()))
                                    .setFriendNickname(fm.getFromNickname())
                                    .setFriendAvatar(fm.getFromAvatar())
                                    .setSettings(BusinessProtocolEntities.Settings.newBuilder()
                                            .setOfflineMessage(fm.getMessageOfflineStatus())
                                            .setSnapchatStatus(fm.getBurnAfterReadingStatus())
                                            .setSnapchatTimeLength(fm.getBurnAfterReadingLength()).build())
                                    .build())
                            .setChatType(msgType)
                            .setText(BusinessProtocolEntities.Text.newBuilder().setContent(fm.getContent()).build())
                            .setMsgTime(fm.getCreateTime())
                            .build();
                }
                rfomlist.add(rfm);
            }
        }

        if(notifyDelMsgList.size()>0) {

            for (NotifyDelMsg nm : notifyDelMsgList) {
                if(nm.getArgs().equals(IMSContacts.MsgContentType.DEL_OFF_MESSAGE_REGISTERED)){
                     rfm = BusinessProtocolEntities.RegistFriendOffMessage.newBuilder()
                             .setMsgId(String.valueOf(nm.getMsgId()))
                             .setChatType(IMSContacts.MsgContentType.DEL_OFF_MESSAGE_REGISTERED)
                             .setMsgFromUserId(String.valueOf(nm.getFromId()))
                             .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                                     .setFriendUserId(String.valueOf(nm.getDelfromId()))
                                     .build())
                             .setMsgTime(nm.getTimestap())
                             .build();
                     rfomlist.add(rfm);
                }
            }
        }

        //大于100条离线消息时分页拉去
        System.out.println("=====msg number:"+rfomlist.size());
        if (rfomlist.size()>10){

            int pageNum = offFriendMessageListProtocol.getPage();
            int subSize=10;
            int subCount=rfomlist.size();
            int subPageTotal = (subCount / subSize)+(subCount % subSize>0 ? 1 : 0);


            int fromIndex = (pageNum-1) * subSize;
            int toIndex = (pageNum == subPageTotal) ? subCount : ((pageNum)* subSize);
             rfomlist = rfomlist.subList(fromIndex,toIndex);

             if(pageNum != subPageTotal){
                 BusinessProtocolMessages.OffFriendMessageListProtocol offMessageListProtocol= BusinessProtocolMessages.OffFriendMessageListProtocol.newBuilder()
                         .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder().setUserId(userId).build())
                         .setUserType(unifiedEntranceMessage.getDelFriendOffMessageProtocol().getUserType())
                         .addAllRegistFriendOffMessage(rfomlist)
                         .setStatusDetail(responseFriendMessage.getResult())
                         .setPage(offFriendMessageListProtocol.getPage())
                         .setRequest(true)
                         .build();

                 BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                         .setOffFriendMessageListProtocol(offMessageListProtocol)
                         .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OffFriendMessageListProtocol)
                         .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                 .setStatusReport(responseFriendMessage.getRet())
                                 .setToken(head.getToken())
                                 .setFromId(head.getFromId())
                                 .setToId(head.getToId())
                                 .setMsgType(head.getMsgType())
                                 .setUniqueIdentify(head.getUniqueIdentify())
                                 .build())
                         .build();

                 logger.info("============== fromIndex:" +fromIndex + ", toIndex:"+toIndex);
                 logger.info("==============response  page  :"+offMessageListProtocol.getPage());
                 BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
                 return checkUnifiedEntranceMessage;
             }else {
                 BusinessProtocolMessages.OffFriendMessageListProtocol offMessageListProtocol= BusinessProtocolMessages.OffFriendMessageListProtocol.newBuilder()
                         .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder().setUserId(userId).build())
                         .setUserType(unifiedEntranceMessage.getDelFriendOffMessageProtocol().getUserType())
                         .addAllRegistFriendOffMessage(rfomlist)
                         .setStatusDetail(responseFriendMessage.getResult())
                         .setPage(offFriendMessageListProtocol.getPage())
                         .setRequest(false)
                         .build();

                 BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                         .setOffFriendMessageListProtocol(offMessageListProtocol)
                         .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OffFriendMessageListProtocol)
                         .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                 .setStatusReport(responseFriendMessage.getRet())
                                 .setToken(head.getToken())
                                 .setFromId(head.getFromId())
                                 .setToId(head.getToId())
                                 .setMsgType(head.getMsgType())
                                 .setUniqueIdentify(head.getUniqueIdentify())
                                 .build())
                         .build();
                 logger.info("============== fromIndex:" +fromIndex + ", toIndex:"+toIndex);
                 logger.info("==============response  page  :"+offMessageListProtocol.getPage());
                 BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
                 return checkUnifiedEntranceMessage;

             }


        }



        BusinessProtocolMessages.OffFriendMessageListProtocol offMessageListProtocol= BusinessProtocolMessages.OffFriendMessageListProtocol.newBuilder()
                .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder().setUserId(userId).build())
                .setUserType(unifiedEntranceMessage.getDelFriendOffMessageProtocol().getUserType())
                .addAllRegistFriendOffMessage(rfomlist)
                .setStatusDetail(responseFriendMessage.getResult())
                .setPage(offFriendMessageListProtocol.getPage())
                .setRequest(false)
                .build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setOffFriendMessageListProtocol(offMessageListProtocol)
                .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OffFriendMessageListProtocol)
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setStatusReport(responseFriendMessage.getRet())
                        .setToken(head.getToken())
                        .setFromId(head.getFromId())
                        .setToId(head.getToId())
                        .setMsgType(head.getMsgType())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .build())
                .build();

        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return checkUnifiedEntranceMessage;
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage friendDeleteRegist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolMessages.FriendDeleteProtocol friendDeleteProtocol = unifiedEntranceMessage.getFriendDeleteProtocol();
        String userType =friendDeleteProtocol.getUserType();
        String fromId = friendDeleteProtocol.getRegisteredUser().getUserId();
        String friendUserType = friendDeleteProtocol.getRegisteredFriend().getUserType();
        String toId = friendDeleteProtocol.getRegisteredFriend().getFriendUserId();
        String fromNickname = friendDeleteProtocol.getRegisteredUser().getNickname();
        String fromAtavar = friendDeleteProtocol.getRegisteredUser().getAvatar();
        int msgType = IMSContacts.MsgContentType.DELETE_FRIEND_REGISTERED;
        long msgTime =head.getTimestamp();

        JCRC32 jcrc32 = new JCRC32();
        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
        RequestFriendMessage requestFriendMessage = null;
        requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.MESSAGE_FRIEND_OFF)
                .addFriendMessage(FriendMessage.newBuilder()
                        .setFromId(Integer.parseInt(fromId))
                        .setToId(Integer.parseInt(toId))
                        .setContent(ConstType.EMPTY)
                        .setMsgType(msgType)
                        .setMsgId(String.valueOf(msgType))
                        .setCreateTime( String.valueOf(msgTime))
                        .setFromAvatar(fromAtavar)
                        .setFromNickname(fromNickname)
                        .build()).build();

        ResponseFriendMessage responseFriendMessage = null;
        try {
            responseFriendMessage = offFriendMessageAPI.storageFriendMessage(requestFriendMessage);
        } catch (Exception e) {
            logger.error("离线消息存储（好友删除）异常，fromId:{} and toId:{}",fromId,toId);
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setFriendDeleteProtocol(BusinessProtocolMessages.FriendDeleteProtocol.newBuilder()
                            .setUserType(userType)
                            .setStatusDetail(ConstType.EXCEPTION)
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .setUserId(fromId)
                                    .setAvatar(fromAtavar)
                                    .setNickname(fromNickname).build())
                            .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                                    .setFriendUserId(toId)
                                    .setUserType(friendUserType).build()
                            ).build())
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setToken(head.getToken())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setMsgType(head.getMsgType())
                            .setFromId(fromId)
                            .setToId(toId)
                            .setTimestamp(msgTime)
                            .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE).build())
                    .build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return  checkUnifiedEntranceMessage;
        }

        //响应客户端

        BusinessProtocolMessages.FriendDeleteProtocol friendDeleteProtocols = BusinessProtocolMessages.FriendDeleteProtocol.newBuilder()
                .setUserType(userType)
                .setStatusDetail(responseFriendMessage.getRet())
                .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                        .setUserId(fromId)
                        .setAvatar(fromAtavar)
                        .setNickname(fromNickname).build())
                .setRegisteredFriend(BusinessProtocolEntities.RegisteredFriend.newBuilder()
                        .setFriendUserId(toId)
                        .setUserType(friendUserType).build()
                ).build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setFriendDeleteProtocol(friendDeleteProtocols)
                .setDataType(unifiedEntranceMessage.getDataType())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setToken(head.getToken())
                        .setUniqueIdentify(head.getUniqueIdentify())
                        .setMsgType(head.getMsgType())
                        .setFromId(fromId)
                        .setToId(toId)
                        .setTimestamp(msgTime)
                        .setStatusReport(responseFriendMessage.getRet()).build())
                .build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return  checkUnifiedEntranceMessage;

    }

    //IM删除离线消息
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage removeMsgFromIM(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        String msgId = head.getToken();
        RequestFriendMessage requestFriendMessage = null;
        requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.MESSAGE_REQUEST_DELETE_MSG_ID)
                .addFriendMessage(FriendMessage.newBuilder()
                        .setMsgId(msgId)
                        .build()).build();
        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
        JCRC32 jcrc32 = new JCRC32();
        ResponseFriendMessage responseFriendMessage =null;
        try {
             responseFriendMessage = offFriendMessageAPI.removeFriendMessage(requestFriendMessage);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("IM删除离线消息时，消息存储服务grpc响应异常");
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setToken(head.getToken())
                            .setMsgType(head.getMsgType())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_EXCEPTION).build())
                    .build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return  checkUnifiedEntranceMessage;

        }

        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setToken(head.getToken())
                        .setMsgType(head.getMsgType())
                        .setStatusReport(responseFriendMessage.getRet()).build())
                .build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return  checkUnifiedEntranceMessage;


    }

    //定期清理在线消息转存离线/删除
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage timeClearOnline(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        String userId = head.getFromId();
        String toId = head.getToId();
        long timestamp = head.getTimestamp();
        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
        if(head.getStatusReport().equals(ResponseStatus.STATUS_REPORT_RECEIPT)){
            //执行删除
            NotifyDelMsg no =NotifyDelMsg.newBuilder()
                    .setTimestap(String.valueOf(timestamp))
                    .setDeltoId(Integer.parseInt(toId)).build();
            RequestFriendMessage requestFriendMessage = RequestFriendMessage.newBuilder()
                    .setRet(ConstantKind.TIME_CLEAR_ARG)
                    .addNotifyDelMsg(no)
                    .build();
            offFriendMessageAPI.removeFriendMessage(requestFriendMessage);
            logger.info("userID:"+userId+" ，删除用户的定期清理转离线消息" +" ,toID:"+toId);
            return null;
        }
        //存离线库
        NotifyDelMsg notifyDelMsg = null;
        ResponseFriendMessage responseFriendMessage =null;
        List<NotifyDelMsg> list = new ArrayList<>();
        notifyDelMsg = NotifyDelMsg.newBuilder()
                .setArgs(String.valueOf(IMSContacts.MsgContentType.TIME_CLEAR_ONLINE))
                .setDelfromId(Integer.parseInt(userId))
                .setDeltoId(Integer.parseInt(toId))
                .setMsgId(head.getUniqueIdentify())
                .setFromId(Integer.parseInt(userId))
                .setTimestap(String.valueOf(timestamp))
                .build();
        list.add(notifyDelMsg);
        RequestFriendMessage requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.TIME_CLEAR_ARG)
                .addAllNotifyDelMsg(list)
                .build();
        logger.info("userID:"+userId+" ，定期清理转离线消息" +" ,toID:"+toId);

        try {
            responseFriendMessage = offFriendMessageAPI.storageFriendMessage(requestFriendMessage);
        } catch (Exception e) {
            logger.error("定期清理在线消息时存离线时调用存储接口异常，userId:{}",userId);
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(head.getMsgType())
                            .setFromId(userId)
                            .setToId(userId)
                            .setTimestamp(head.getTimestamp())
                            .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE).build())
                    .build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.newBuilder().setUnifiedEntranceMessage(message).build();
            return  checkUnifiedEntranceMessage;
        }
        if(responseFriendMessage.getRet().equals(ConstType.FAILURE)){
            logger.error("*********  定期清理之离线消息存储失败 ，fromId: "+userId+"toID:"+toId +"    **********");
            return null;
        }
        return  null;
    }

    //用户上线推送定期删除在线消息通知
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage Online(ChannelHandlerContext ctx,BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        String userID = head.getFromId();
        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
        RequestFriendMessage requestFriendMessage = null;
        requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.TIME_CLEAR_REQUEST_SELECT_TO_ID)
                .addNotifyDelMsg(NotifyDelMsg.newBuilder()
                        .setDeltoId(Integer.parseInt(userID))
                     .build())
                .build();
        ResponseFriendMessage responseFriendMessage = null;
        try {
            responseFriendMessage = offFriendMessageAPI.selectFriendMessage(requestFriendMessage);
        } catch (Exception e) {
            logger.error("捞取用户在线消息定期删除消息异常，userID:{}",userID);
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ResponseStatus.STATUS_REPORT_FAILURE)
                            .setFromId(head.getFromId())
                            .build())
                    .build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.newBuilder().setUnifiedEntranceMessage(message).build();
            ctx.writeAndFlush(checkUnifiedEntranceMessage);
            return null;
        }

        List<NotifyDelMsg> notifyDelMsgList = responseFriendMessage.getNotifyDelMsgList();
        long timer=0;
        String fromId ="";
        if(responseFriendMessage.getRet().equals(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS)){
            for (NotifyDelMsg ndm : notifyDelMsgList){
                timer= (Long.parseLong(ndm.getTimestap()));
                fromId =String.valueOf(ndm.getDelfromId());
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.newBuilder()
                        .setUnifiedEntranceMessage(BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                                .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.MessageClearProtocol)
                                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                        .setFromId(fromId)
                                        .setToId(userID)
                                        .setTimestamp(timer)
                                        .setMsgType(IMSContacts.MsgType.DEL_ON_LINE_RECEIVE)
                                        .setStatusReport(ConstType.TIME_CLEAR_NOTIFY)
                                        .setUniqueIdentify(UUID.randomUUID().toString().replaceAll("-",""))
                                        .build())
                                .build()).build();
                ctx.writeAndFlush(checkUnifiedEntranceMessage);
                logger.info("用户上线推送通知："+checkUnifiedEntranceMessage.getUnifiedEntranceMessage().getHead().toString());
                return null;
            }

        }

        return null;

    }

    //音视频离线消息
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage audioAndVideoCallStorage(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        String time = String.valueOf(head.getTimestamp()).substring(0,10);
        BusinessProtocolMessages.AudioAndVideoCallProtocol avcprotocol = unifiedEntranceMessage.getAudioAndVideoCallProtocol();
        AudioAndVideoCallRequest avcRequest=null;
        //todo 发起者关闭房间时，删除该roomId对应离线消息
        if (avcprotocol.getType().equals(ConstType.ROOM_CLOSE)){
            avcRequest = AudioAndVideoCallRequest.newBuilder().setAudioAndVideoCallMessage(AudioAndVideoCallMessage.newBuilder()
                    .setServer(avcprotocol.getServer())
                    .setRoomId(avcprotocol.getRoom().getRoomId())
                    .setRoomPwd(avcprotocol.getRoom().getRoomPwd())
                    .setOnlyAudio(avcprotocol.getRoom().getOnlyAudio())
                    .setFromUserId(avcprotocol.getFromUser().getUserId())
                    .setFromUserName(avcprotocol.getFromUser().getUserName())
                    .setUserAvatar(avcprotocol.getFromUser().getUserAvatar())
                    .setToUser(avcprotocol.getToUser().getUserId())
                    .setType(avcprotocol.getType())
                    .setStatusDetail(time).build())
                    .setArgs(ConstType.ROOM_CLOSE).build();
        }else{
             avcRequest = AudioAndVideoCallRequest.newBuilder().setAudioAndVideoCallMessage(AudioAndVideoCallMessage.newBuilder()
                    .setServer(avcprotocol.getServer())
                    .setRoomId(avcprotocol.getRoom().getRoomId())
                    .setRoomPwd(avcprotocol.getRoom().getRoomPwd())
                    .setOnlyAudio(avcprotocol.getRoom().getOnlyAudio())
                    .setFromUserId(avcprotocol.getFromUser().getUserId())
                    .setFromUserName(avcprotocol.getFromUser().getUserName())
                    .setUserAvatar(avcprotocol.getFromUser().getUserAvatar())
                    .setToUser(avcprotocol.getToUser().getUserId())
                    .setType(avcprotocol.getType())
                    .setStatusDetail(time).build())
                    .setArgs(ConstType.AVC_STORAGE).build();
        }


        AudioAndVideoCallResponse avcResponse = null;
        OffFriendMessageAPI  offFriendMessageAPI  = new OffFriendMessageAPI();
        JCRC32 jcrc32 = new JCRC32();
        try {
            avcResponse =offFriendMessageAPI.audioAndVideoCall(avcRequest);
        } catch (Exception e) {
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(unifiedEntranceMessage.getDataType())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setFromId(head.getFromId())
                            .setMsgType(head.getMsgType())
                            .setStatusReport(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE).build())
                    .build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return  checkUnifiedEntranceMessage;
        }

        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setDataType(unifiedEntranceMessage.getDataType())
                .setAudioAndVideoCallProtocol(BusinessProtocolMessages.AudioAndVideoCallProtocol.newBuilder()
                        .setStatusDetail(ConstType.AVC_STORAGE_SUCCESS).build())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setFromId(head.getFromId())
                        .setMsgType(head.getMsgType())
                        .setStatusReport(IMSContacts.ResponseCode.STATUS_REPORT_SUCCESS).build())
                .build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
        return  checkUnifiedEntranceMessage;

    }

    //推送音视频消息
    public void pushAudioAndVideoCallMessage(ChannelHandlerContext ctx,BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        String  toUserId = head.getFromId(); //推送用户id
        AudioAndVideoCallRequest avcRequest = AudioAndVideoCallRequest.newBuilder().setAudioAndVideoCallMessage(AudioAndVideoCallMessage.newBuilder()
                .setFromUserId(toUserId)
                .build())
                .setArgs(ConstType.AVC_GET).build();
        AudioAndVideoCallResponse avcResponse = null;
        OffFriendMessageAPI  offFriendMessageAPI  = new OffFriendMessageAPI();
        JCRC32 jcrc32 = new JCRC32();
        try {
            avcResponse =offFriendMessageAPI.audioAndVideoCall(avcRequest);
        } catch (Exception e) {
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.AudioAndVideoCallProtocol)
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setFromId(head.getFromId())
                            .setMsgType(head.getMsgType())
                            .setStatusReport(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE).build())
                    .build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            ctx.writeAndFlush(checkUnifiedEntranceMessage);
            return  ;
        }



        List<AudioAndVideoCallMessage> audioAndVideoCallMessageList = avcResponse.getAudioAndVideoCallMessageList();
        if (audioAndVideoCallMessageList.size()>0){
            for (AudioAndVideoCallMessage  avcmessage : audioAndVideoCallMessageList){
                BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                        .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.AudioAndVideoCallProtocol)
                        .setAudioAndVideoCallProtocol(BusinessProtocolMessages.AudioAndVideoCallProtocol.newBuilder()
                                .setStatusDetail(ConstType.AVC_STORAGE_SUCCESS)
                                .setServer(avcmessage.getServer())
                                .setRoom(BusinessProtocolEntities.Room.newBuilder()
                                        .setRoomId(avcmessage.getRoomId())
                                        .setRoomPwd(avcmessage.getRoomPwd())
                                        .setOnlyAudio(avcmessage.getOnlyAudio())
                                        .setClientRole(0).build())
                                .setFromUser(BusinessProtocolEntities.CallUser.newBuilder()
                                        .setUserId(avcmessage.getFromUserId())
                                        .setUserName(avcmessage.getFromUserName())
                                        .setUserAvatar(avcmessage.getUserAvatar()).build())
                                .setToType(0)
                                .setToUser(BusinessProtocolEntities.CallUser.newBuilder()
                                        .setUserId(toUserId).build())
                                .setType(avcmessage.getType())
                                .setStatusDetail(avcmessage.getStatusDetail())
                                .build())
                        .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                                .setFromId(avcmessage.getFromUserId())
                                .setToId(toUserId)
                                .setTimestamp(Long.parseLong(avcmessage.getStatusDetail()))
                                .setMsgType(IMSContacts.MsgType.AUDIO_AND_VIDEO_CALL)
                                .setStatusReport(ConstType.STATUS_REPORT_RECEIPT_OFFLINE)
                                .setUniqueIdentify(ConstType.AVC_PUSH)
                                .setToken(avcmessage.getRoomId())
                                .build())
                        .build();
                BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
                logger.info("用户【"+ toUserId + "】上线后推送音视频通话消息："+message.toString());
                ctx.writeAndFlush(checkUnifiedEntranceMessage);
            }
        }

        return ;


    }

    //用户收到音视频推送后执行删除
    public void removeAVCMessage(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage,BusinessProtocolMessageStandard.Head head) {
        String receiveUserId = head.getToId(); //推送后客户端将head头原样返回。
        String roomId = head.getToken();
        AudioAndVideoCallRequest avcRequest = AudioAndVideoCallRequest.newBuilder().setAudioAndVideoCallMessage(AudioAndVideoCallMessage.newBuilder()
                .setFromUserId(receiveUserId)
                .setRoomId(roomId)
                .build())
                .setArgs(ConstType.AVC_REMOVE).build();
        OffFriendMessageAPI  offFriendMessageAPI  = new OffFriendMessageAPI();

        try {
            offFriendMessageAPI.audioAndVideoCall(avcRequest);
        } catch (Exception e) {
           logger.error("清除推送成功后的音视频消息时异常",e);
        }
        return;
    }
}
