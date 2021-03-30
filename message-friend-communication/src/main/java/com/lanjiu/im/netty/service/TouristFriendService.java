package com.lanjiu.im.netty.service;

import com.google.protobuf.ByteString;
import com.lanjiu.im.grpc.InformationStorageProto;
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
import com.lanjiu.pro.friend_msg.FriendMessage;
import com.lanjiu.pro.friend_msg.NotifyDelMsg;
import com.lanjiu.pro.friend_msg.RequestFriendMessage;
import com.lanjiu.pro.friend_msg.ResponseFriendMessage;
import com.lanjiu.pro.login.GuestUser;
import com.lanjiu.pro.login.RegisterUser;
import com.lanjiu.pro.login.RequestUser;
import com.lanjiu.pro.login.ResponseUser;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class TouristFriendService {
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage friendApplyTourist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head)  {
        BusinessProtocolMessages.FriendChatProtocol friendChatProtocol = unifiedEntranceMessage.getFriendChatProtocol();
        String userType =friendChatProtocol.getUserType();
        String fromId = friendChatProtocol.getTouristsUser().getTemporaryId();
        String fromNickname = friendChatProtocol.getTouristsUser().getNickname();
        String fromAvatar = friendChatProtocol.getTouristsUser().getAvatar();
        String friendUserType = friendChatProtocol.getTouristsFriend().getUserType();
        String toId = friendChatProtocol.getTouristsFriend().getFriendUserId();
        int msgType = friendChatProtocol.getChatMessage().getChatType();
        long msgTime =head.getTimestamp();
        String content = friendChatProtocol.getChatMessage().getText().getContent() == null ? ConstType.EMPTY : friendChatProtocol.getChatMessage().getText().getContent();


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
                        .setFromNickname(fromNickname)
                        .setFromAvatar(fromAvatar)
                        .build()).build();

        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
        ResponseFriendMessage responseFriendMessage = offFriendMessageAPI.storageFriendMessage(requestFriendMessage);

        //响应客户端
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessages.FriendChatProtocol friendChatProtocols = BusinessProtocolMessages.FriendChatProtocol.newBuilder()
                .setUserType(userType)
                .setStatusDetail(responseFriendMessage.getRet())
                .setTouristsUser(BusinessProtocolEntities.TouristsUser.newBuilder()
                        .setTemporaryId(fromId)
                        .setNickname(fromNickname)
                        .setAvatar(fromAvatar)
                        .build())
                .setTouristsFriend(BusinessProtocolEntities.TouristsFriend.newBuilder().setFriendId(toId)
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

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage agreeFriendApplyTourist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolMessages.FriendAddProtocol friendAddProtocol = unifiedEntranceMessage.getFriendAddProtocol();
        String userType =friendAddProtocol.getUserType();
        String fromId = friendAddProtocol.getTouristsUser().getTemporaryId();
        String fromNickname = friendAddProtocol.getTouristsUser().getNickname();
        String fromAvatar = friendAddProtocol.getTouristsUser().getAvatar();
        String friendUserType = friendAddProtocol.getTouristsFriend(0).getUserType();
        String toId = friendAddProtocol.getTouristsFriend(0).getFriendUserId();
        int msgType = IMSContacts.MsgContentType.APPLY_AGREE_FRIEND_TOURISTS;
        long msgTime =head.getTimestamp();

        RequestFriendMessage requestFriendMessage = null;
        requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.MESSAGE_FRIEND_OFF)
                .addFriendMessage(FriendMessage.newBuilder()
                        .setFromId(Integer.parseInt(fromId))
                        .setToId(Integer.parseInt(toId))
                        .setContent(ConstType.EMPTY)
                        .setMsgType(msgType)
                        .setCreateTime(String.valueOf(msgTime))
                        .setFromNickname(fromNickname)
                        .setFromAvatar(fromAvatar)
                        .build()).build();

        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
        ResponseFriendMessage responseFriendMessage = offFriendMessageAPI.storageFriendMessage(requestFriendMessage);

        //响应客户端
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessages.FriendChatProtocol friendChatProtocols = BusinessProtocolMessages.FriendChatProtocol.newBuilder()
                .setUserType(userType)
                .setStatusDetail(responseFriendMessage.getRet())
                .setTouristsUser(BusinessProtocolEntities.TouristsUser.newBuilder()
                        .setTemporaryId(fromId)
                        .setNickname(fromNickname)
                        .setAvatar(fromAvatar).build())
                .setTouristsFriend(BusinessProtocolEntities.TouristsFriend.newBuilder().setFriendId(toId)
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

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage refuseFriendApplyTourist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolMessages.FriendChatProtocol friendChatProtocol = unifiedEntranceMessage.getFriendChatProtocol();
        String userType =friendChatProtocol.getUserType();
        String fromId = friendChatProtocol.getTouristsUser().getTemporaryId();
        String fromNickname = friendChatProtocol.getTouristsUser().getNickname();
        String fromAvatar = friendChatProtocol.getTouristsUser().getAvatar();
        String friendUserType = friendChatProtocol.getTouristsFriend().getUserType();
        String toId = friendChatProtocol.getRegisteredFriend().getFriendUserId();
        int msgType = friendChatProtocol.getChatMessage().getChatType();
        long msgTime =head.getTimestamp();
        RequestFriendMessage requestFriendMessage = null;
        String content =friendChatProtocol.getChatMessage().getText().getContent() == null ? ConstType.EMPTY : friendChatProtocol.getChatMessage().getText().getContent();


        requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.MESSAGE_FRIEND_OFF)
                .addFriendMessage(FriendMessage.newBuilder()
                        .setFromId(Integer.parseInt(fromId))
                        .setToId(Integer.parseInt(toId))
                        .setContent(content)
                        .setMsgType(msgType)
                        .setMsgId(String.valueOf(msgType))
                        .setCreateTime(String.valueOf(msgTime))
                        .setFromNickname(fromNickname)
                        .setFromAvatar(fromAvatar)
                        .build()).build();

        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
        ResponseFriendMessage responseFriendMessage = offFriendMessageAPI.storageFriendMessage(requestFriendMessage);

        //响应客户端
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessages.FriendChatProtocol friendChatProtocols = BusinessProtocolMessages.FriendChatProtocol.newBuilder()
                .setUserType(userType)
                .setStatusDetail(responseFriendMessage.getRet())
                .setTouristsUser(BusinessProtocolEntities.TouristsUser.newBuilder()
                        .setTemporaryId(fromId)
                        .setNickname(fromNickname)
                        .setAvatar(fromAvatar)
                        .build())
                .setTouristsFriend(BusinessProtocolEntities.TouristsFriend.newBuilder()
                        .setFriendId(toId)
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

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage friendChatTourist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolMessages.FriendChatProtocol friendChatProtocol = unifiedEntranceMessage.getFriendChatProtocol();
        String userType =friendChatProtocol.getUserType();
        String fromId = friendChatProtocol.getTouristsUser().getTemporaryId();
        String fromNickname = friendChatProtocol.getTouristsUser().getNickname();
        String fromAvatar = friendChatProtocol.getTouristsUser().getAvatar();
        String friendUserType = friendChatProtocol.getTouristsFriend().getUserType();
        String toId = friendChatProtocol.getTouristsFriend().getFriendUserId();
        String msgId = friendChatProtocol.getChatMessage().getMsgId();
        boolean offlineMessage = friendChatProtocol.getTouristsFriend().getSettings().getOfflineMessage();
        boolean snapchatStatus = friendChatProtocol.getTouristsFriend().getSettings().getSnapchatStatus();
        int snapchatTimeLength = friendChatProtocol.getTouristsFriend().getSettings().getSnapchatTimeLength();
        int msgType = friendChatProtocol.getChatMessage().getChatType();
        long msgTime =head.getTimestamp();
        String content ="";
        String url ="";

        //1.调资料服务器接口，判断好友的好友之间离线消息设置

        //3.若都设置不接受离线消息，不用存储；若有设置接收，则入库；
        if(friendUserType.equals(IMSContacts.UserType.REGISTERED_USER)){
            StorageAPI storageAPI = new StorageAPI();
            InformationStorageProto.TransmissionRequest request = InformationStorageProto.TransmissionRequest.newBuilder().setRequestKind(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_FRIEND_USER_ID)
                    .setGuestUserFriend(InformationStorageProto.RpcGuestUserFriend.newBuilder()
                            .setGuestUserId(Integer.parseInt(fromId))
                            .setFriendUserId(Integer.parseInt(toId)).build())
                   .build();
//            GuestUserFriendResponse guestUserFriendResponse = storageAPI.selectGuestUserFriendAPI(request);
        }else if(friendUserType.equals(IMSContacts.UserType.TOURISTS_USER)){

        }

       if(msgType==IMSContacts.MsgContentType.TEXT){
            content = friendChatProtocol.getChatMessage().getText().getContent();
        }else if(msgType == IMSContacts.MsgContentType.PICTURE){
            url = friendChatProtocol.getChatMessage().getPicture().getUrl();
            byte[] bytes=friendChatProtocol.getChatMessage().getPicture().getThumbnail().toByteArray();
           try {
               content = new String(bytes,"ISO-8859-1");
           } catch (UnsupportedEncodingException e) {
               e.printStackTrace();
           }
       }else if(msgType == IMSContacts.MsgContentType.VIDEO){
            url = friendChatProtocol.getChatMessage().getVideo().getUrl();
           byte[] bytes=friendChatProtocol.getChatMessage().getVideo().getThumbnail().toByteArray();
           try {
               content = new String(bytes,"ISO-8859-1");
           } catch (UnsupportedEncodingException e) {
               e.printStackTrace();
           }
        }else if(msgType == IMSContacts.MsgContentType.VOICE){
           byte[] bytes=friendChatProtocol.getChatMessage().getVoice().getContent().toByteArray();
           try {
               content = new String(bytes,"ISO-8859-1");
           } catch (UnsupportedEncodingException e) {
               e.printStackTrace();
           }
        }else if(msgType ==IMSContacts.MsgContentType.FILE){
            url = friendChatProtocol.getChatMessage().getFile().getUrl();
            content = friendChatProtocol.getChatMessage().getFile().getUrl();
        }

        RequestFriendMessage requestFriendMessage = null;
        requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.MESSAGE_FRIEND_OFF)
                .addFriendMessage(FriendMessage.newBuilder()
                        .setFromId(Integer.parseInt(fromId))
                        .setToId(Integer.parseInt(toId))
                        .setContent(content)
                        .setEntityUrl(url)
                        .setMsgType(msgType)
                        .setMsgId(msgId)
                        .setCreateTime(String.valueOf(msgTime))
                        .setFromNickname(fromNickname)
                        .setFromAvatar(fromAvatar)
                        .setMessageOfflineStatus(offlineMessage)
                        .setMessageOfflineStatus(snapchatStatus)
                        .setBurnAfterReadingLength(snapchatTimeLength)
                        .build()).build();

        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
        ResponseFriendMessage responseFriendMessage = offFriendMessageAPI.storageFriendMessage(requestFriendMessage);

        //响应客户端
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessages.FriendChatProtocol friendChatProtocols = BusinessProtocolMessages.FriendChatProtocol.newBuilder()
                .setUserType(userType)
                .setStatusDetail(responseFriendMessage.getRet())
                .setTouristsUser(BusinessProtocolEntities.TouristsUser.newBuilder()
                        .setTemporaryId(fromId)
                        .setNickname(fromNickname)
                        .setAvatar(fromAvatar).build())
                .setTouristsFriend(BusinessProtocolEntities.TouristsFriend.newBuilder().setFriendId(toId)
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

    //捞取离线消息
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage getGuestFriendOffMessage(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolMessages.OffFriendMessageListProtocol offFriendMessageListProtocol = unifiedEntranceMessage.getOffFriendMessageListProtocol();
        String userId = offFriendMessageListProtocol.getTouristsUser().getTemporaryId();
        String onTime = String.valueOf(unifiedEntranceMessage.getHead().getTimestamp());
        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
        RequestFriendMessage requestFriendMessage = null;

        requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.MESSAGE_REQUEST_SELECT_TO_ID)
                .addFriendMessage(FriendMessage.newBuilder()
                        .setToId(Integer.parseInt(userId))
                        .setCreateTime(onTime).build())
                .build();
        ResponseFriendMessage responseFriendMessage = offFriendMessageAPI.selectFriendMessage(requestFriendMessage);

        //响应IMServer
        List<FriendMessage> friendMessageList = responseFriendMessage.getFriendMessageList();
        List<NotifyDelMsg>  notifyDelMsgList  = responseFriendMessage.getNotifyDelMsgList();
        List<BusinessProtocolEntities.TouristFriendOffMessage> tfomlist = new ArrayList<>();
        String content = null;
        String url = null;
        ByteString bytes1 = null;
        String fromUserType="";
        BusinessProtocolEntities.TouristFriendOffMessage tfm = null;
        for (FriendMessage fm : friendMessageList){

            int msgType = fm.getMsgType();
            if(fm.getFromId() < 70000000){
                fromUserType ="100";
            } else {
                fromUserType ="101";
            }
            if(msgType==IMSContacts.MsgContentType.TEXT){
                tfm = BusinessProtocolEntities.TouristFriendOffMessage.newBuilder()
                        .setMsgId(String.valueOf(fm.getMsgId()))
                        .setTouristsFriend(BusinessProtocolEntities.TouristsFriend.newBuilder()
                                .setUserType(fromUserType)
                                .setFriendUserId(String.valueOf(fm.getFromId()))
                                .setFriendNickname(fm.getFromNickname())
                                .setFriendAvatar(fm.getFromAvatar())
                                .build())
                        .setChatType(msgType)
                        .setMsgTime(fm.getCreateTime())
                        .setText(BusinessProtocolEntities.Text.newBuilder().setContent(fm.getContent()).build())
                        .build();
            }else if(msgType == IMSContacts.MsgContentType.PICTURE){
                try {
                     bytes1 = ByteString.copyFrom(fm.getContent().getBytes("ISO-8859-1"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                tfm = BusinessProtocolEntities.TouristFriendOffMessage.newBuilder()
                        .setMsgId(String.valueOf(fm.getMsgId()))
                        .setTouristsFriend(BusinessProtocolEntities.TouristsFriend.newBuilder()
                                .setUserType(fromUserType)
                                .setFriendUserId(String.valueOf(fm.getFromId()))
                                .setFriendNickname(fm.getFromNickname())
                                .setFriendAvatar(fm.getFromAvatar())
                                .build())
                        .setChatType(msgType)
                        .setMsgTime(fm.getCreateTime())
                        .setPicture(BusinessProtocolEntities.Picture.newBuilder().setUrl(fm.getEntityUrl()).build())
                        .build();
            }else if(msgType == IMSContacts.MsgContentType.VIDEO){
                try {
                    bytes1 = ByteString.copyFrom(fm.getContent().getBytes("ISO-8859-1"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                tfm = BusinessProtocolEntities.TouristFriendOffMessage.newBuilder()
                        .setMsgId(String.valueOf(fm.getMsgId()))
                        .setTouristsFriend(BusinessProtocolEntities.TouristsFriend.newBuilder()
                                .setUserType(fromUserType)
                                .setFriendUserId(String.valueOf(fm.getFromId()))
                                .setFriendNickname(fm.getFromNickname())
                                .setFriendAvatar(fm.getFromAvatar())
                                .build())
                        .setChatType(msgType)
                        .setMsgTime(fm.getCreateTime())
                        .setVideo(BusinessProtocolEntities.Video.newBuilder().setUrl(fm.getEntityUrl()).build())
                        .build();
            }else if(msgType == IMSContacts.MsgContentType.VOICE){
                try {
                    bytes1 = ByteString.copyFrom(fm.getContent().getBytes("ISO-8859-1"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                tfm = BusinessProtocolEntities.TouristFriendOffMessage.newBuilder()
                        .setMsgId(String.valueOf(fm.getMsgId()))
                        .setTouristsFriend(BusinessProtocolEntities.TouristsFriend.newBuilder()
                                .setUserType(fromUserType)
                                .setFriendUserId(String.valueOf(fm.getFromId()))
                                .setFriendNickname(fm.getFromNickname())
                                .setFriendAvatar(fm.getFromAvatar())
                                .build())
                        .setChatType(msgType)
                        .setMsgTime(fm.getCreateTime())
                        .setVoice(BusinessProtocolEntities.Voice.newBuilder().setContent(fm.getContentBytes()).build())
                        .build();
            }else if(msgType ==IMSContacts.MsgContentType.FILE){
                tfm = BusinessProtocolEntities.TouristFriendOffMessage.newBuilder()
                        .setMsgId(String.valueOf(fm.getMsgId()))
                        .setTouristsFriend(BusinessProtocolEntities.TouristsFriend.newBuilder()
                                .setUserType(fromUserType)
                                .setFriendUserId(String.valueOf(fm.getFromId()))
                                .setFriendNickname(fm.getFromNickname())
                                .setFriendAvatar(fm.getFromAvatar())
                                .build())
                        .setChatType(msgType)
                        .setMsgTime(fm.getCreateTime())
                        .setFile(BusinessProtocolEntities.File.newBuilder().setUrl(fm.getEntityUrl()).build())
                        .build();
            }else {
                //好友申请、同意、拒绝、删除类消息
                tfm = BusinessProtocolEntities.TouristFriendOffMessage.newBuilder()
                        .setMsgId(String.valueOf(fm.getMsgId()))
                        .setTouristsFriend(BusinessProtocolEntities.TouristsFriend.newBuilder()
                                .setUserType(fromUserType)
                                .setFriendUserId(String.valueOf(fm.getFromId()))
                                .setFriendNickname(fm.getFromNickname())
                                .setFriendAvatar(fm.getFromAvatar())
                                .build())
                        .setChatType(msgType)
                        .setText(BusinessProtocolEntities.Text.newBuilder().setContent(fm.getContent()).build())
                        .setMsgTime(fm.getCreateTime())
                        .build();
            }
            tfomlist.add(tfm);
        }

        for (NotifyDelMsg nm: notifyDelMsgList){
            tfm = BusinessProtocolEntities.TouristFriendOffMessage.newBuilder()
                    .setMsgId(String.valueOf(nm.getMsgId()))
                    .setChatType(IMSContacts.MsgContentType.DEL_OFF_MESSAGE_REGISTERED)
                    .setMsgFromUserId(String.valueOf(nm.getFromId()))
                    .setTouristsFriend(BusinessProtocolEntities.TouristsFriend.newBuilder()
                            .setFriendUserId(String.valueOf(nm.getDelfromId()))
                            .build())
                    .setMsgTime(nm.getTimestap())
                    .build();
            tfomlist.add(tfm);
        }

        BusinessProtocolMessages.OffFriendMessageListProtocol offMessageListProtocol= BusinessProtocolMessages.OffFriendMessageListProtocol.newBuilder()
                .setTouristsUser(BusinessProtocolEntities.TouristsUser.newBuilder().setTemporaryId(userId).build())
                .setUserType(unifiedEntranceMessage.getDelFriendOffMessageProtocol().getUserType())
                .addAllTouristFriendOffMessage(tfomlist)
                .setStatusDetail(responseFriendMessage.getResult())
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
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);

        return checkUnifiedEntranceMessage;
    }

    //存储游客删除指令
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage delFriendOffMessageTourist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolMessages.DelFriendOffMessageProtocol delFriendOffMessageProtocol = unifiedEntranceMessage.getDelFriendOffMessageProtocol();
        String userType =delFriendOffMessageProtocol.getUserType();
        String delfromId = delFriendOffMessageProtocol.getTouristsUser().getTemporaryId();
        String friendUserType = delFriendOffMessageProtocol.getTouristsFriend().getUserType();
        String deltoId = delFriendOffMessageProtocol.getTouristsFriend().getFriendUserId();
        String[] msgIdArr = delFriendOffMessageProtocol.getChatMessage().getMsgId().split(",");
        String[] msgfromIdArr = delFriendOffMessageProtocol.getMsgfromId().split(",");
        String[] msgTimeArr = delFriendOffMessageProtocol.getStatusDetail().split(",");
        String[] chatTypeArr = delFriendOffMessageProtocol.getChatMessage().getText().getLength().split(",");
        String[] urlArr =delFriendOffMessageProtocol.getChatMessage().getText().getLength().split(",");
        JCRC32 jcrc32 = new JCRC32();
        boolean onlineStatus = false;
        String url = null;
        String file_userType = "";
        String settingsType = "";
        NotifyDelMsg notifyDelMsg = null;
        List<NotifyDelMsg>  delMsgList = new ArrayList<>();


        if(friendUserType.equals(IMSContacts.UserType.REGISTERED_USER)){
            RegistUserAPI loginAPI = new RegistUserAPI();
            RequestUser requestUser = RequestUser.newBuilder().setArgs(ConstType.SEARCH_USER).setUserType(friendUserType).setRegisterUser(RegisterUser.newBuilder().setUserId(deltoId).build()).build();
            ResponseUser responseUser = loginAPI.selectUserInfomation(requestUser);
//            onlineStatus = responseUser.getRegisterUser(0).getUserInfomation().getOnlineStatus();


        }else if(friendUserType.equals(IMSContacts.UserType.TOURISTS_USER)){
            GuestUserAPI guestLoginAPI = new GuestUserAPI();
            RequestUser requestUser = RequestUser.newBuilder().setArgs(ConstType.SEARCH_USER).setUserType(friendUserType).setGuestUser(GuestUser.newBuilder().setUserId(deltoId).build()).build();
            ResponseUser responseUser = guestLoginAPI.selectGuestUserInfo(requestUser);
//            onlineStatus = responseUser.getGuestUser(0).getUserInfomation().getOnlineStatus();

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
                    fileStorageAPI.deleteFileInformationWithFriend(friendsTransmissionRequest);

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
                if(!onlineStatus){
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
                if(!onlineStatus) {
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
                            .setUserType(IMSContacts.UserType.TOURISTS_USER)
                            .setStatusDetail(ResponseStatus.STATUS_REPORT_SUCCESS)
                            .setTouristsUser(BusinessProtocolEntities.TouristsUser.newBuilder()
                                    .setTemporaryId(delfromId)
                                    .setNickname(delFriendOffMessageProtocol.getTouristsUser().getNickname())
                                    .setAvatar(delFriendOffMessageProtocol.getTouristsUser().getAvatar()).build())
                            .setTouristsFriend(BusinessProtocolEntities.TouristsFriend.newBuilder()
                                    .setFriendUserId(deltoId)
                                    .setUserType(friendUserType).build())
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
                            .setStatusReport(responseFriendMessage.getRet()).build())
                    .build();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(message);
            return  checkUnifiedEntranceMessage;
        }


        RequestFriendMessage requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.MESSAGE_FRIEND_DEL)
                .addAllNotifyDelMsg(delMsgList)
                .build();
        OffFriendMessageAPI offFriendMessageAPI = new OffFriendMessageAPI();
        responseFriendMessage = offFriendMessageAPI.storageFriendMessage(requestFriendMessage);

        //响应客户端
        BusinessProtocolMessages.FriendChatProtocol friendChatProtocols = BusinessProtocolMessages.FriendChatProtocol.newBuilder()
                .setUserType(IMSContacts.UserType.TOURISTS_USER)
                .setStatusDetail(responseFriendMessage.getRet())
                .setTouristsUser(BusinessProtocolEntities.TouristsUser.newBuilder()
                        .setTemporaryId(delfromId)
                        .setNickname(delFriendOffMessageProtocol.getTouristsUser().getNickname())
                        .setAvatar(delFriendOffMessageProtocol.getTouristsUser().getAvatar()).build())
                .setTouristsFriend(BusinessProtocolEntities.TouristsFriend.newBuilder()
                        .setFriendUserId(deltoId)
                        .setUserType(friendUserType).build())
                .build();

        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setFriendChatProtocol(friendChatProtocols)
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

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage friendDeleteTourist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        BusinessProtocolMessages.FriendDeleteProtocol friendDeleteProtocol = unifiedEntranceMessage.getFriendDeleteProtocol();
        String userType =friendDeleteProtocol.getUserType();
        String fromId = friendDeleteProtocol.getTouristsUser().getTemporaryId();
        String friendUserType = friendDeleteProtocol.getTouristsFriend().getUserType();
        String toId = friendDeleteProtocol.getTouristsFriend().getFriendUserId();
        String fromNickname = friendDeleteProtocol.getTouristsUser().getNickname();
        String fromAtavar = friendDeleteProtocol.getTouristsUser().getAvatar();
        int msgType = IMSContacts.MsgContentType.DELETE_FRIEND_REGISTERED;
        long msgTime =head.getTimestamp();

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

        ResponseFriendMessage responseFriendMessage = offFriendMessageAPI.storageFriendMessage(requestFriendMessage);

        //响应客户端
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessages.FriendDeleteProtocol friendDeleteProtocols = BusinessProtocolMessages.FriendDeleteProtocol.newBuilder()
                .setUserType(userType)
                .setStatusDetail(responseFriendMessage.getRet())
                .setTouristsUser(BusinessProtocolEntities.TouristsUser.newBuilder()
                        .setTemporaryId(fromId)
                        .setNickname(fromNickname)
                        .setAvatar(fromAtavar)
                        .build())
                .setTouristsFriend(BusinessProtocolEntities.TouristsFriend.newBuilder()
                        .setFriendUserId(toId)
                        .setUserType(friendUserType)
                        .build())
                .build();

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
}
