package com.lanjiu.im.netty.server.common;

import com.lanjiu.im.netty.service.RegistFriendService;
import com.lanjiu.im.netty.service.TouristFriendService;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelHandlerContext;

public class MessageFriendCommon {
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage friendApplyRegist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistFriendService registFriendService = new RegistFriendService();
        return  registFriendService.friendApplyRegist(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage friendApplyTourist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        TouristFriendService touristFriendService = new TouristFriendService();
        return touristFriendService.friendApplyTourist(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage agreeFriendApplyRegist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistFriendService registFriendService = new RegistFriendService();
        return  registFriendService.agreeFriendApplyRegist(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage refuseFriendApplyRegist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistFriendService registFriendService = new RegistFriendService();
        return  registFriendService.refuseFriendApplyRegist(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage agreeFriendApplyTourist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        TouristFriendService touristFriendService = new TouristFriendService();
        return touristFriendService.agreeFriendApplyTourist(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage refuseFriendApplyTourist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        TouristFriendService touristFriendService = new TouristFriendService();
        return touristFriendService.refuseFriendApplyTourist(unifiedEntranceMessage,head);
    }


    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage friendChatRegist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistFriendService registFriendService = new RegistFriendService();
        return  registFriendService.friendChatRegist(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage friendChatTourist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        TouristFriendService touristFriendService = new TouristFriendService();
        return touristFriendService.friendChatTourist(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage delFriendOffMessageRegist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistFriendService registFriendService = new RegistFriendService();
        return  registFriendService.delFriendOffMessageRegist(unifiedEntranceMessage,head);

    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage delFriendOffMessageTourist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        TouristFriendService touristFriendService = new TouristFriendService();
        return touristFriendService.delFriendOffMessageTourist(unifiedEntranceMessage,head);
    }


    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage getRegistFriendOffMessage(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistFriendService registFriendService = new RegistFriendService();
        return registFriendService.getRegistFriendOffMessage(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage getGuestFriendOffMessage(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        TouristFriendService touristFriendService = new TouristFriendService();
        return touristFriendService.getGuestFriendOffMessage(unifiedEntranceMessage,head);
    }


    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage friendDeleteRegist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistFriendService registFriendService = new RegistFriendService();
        return registFriendService.friendDeleteRegist(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage friendDeleteTourist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        TouristFriendService touristFriendService = new TouristFriendService();
        return touristFriendService.friendDeleteTourist(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage removeMsgFromIM(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistFriendService registFriendService = new RegistFriendService();
        return registFriendService.removeMsgFromIM(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage timeClearOnline(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistFriendService registFriendService = new RegistFriendService();
        return registFriendService.timeClearOnline(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage Online(ChannelHandlerContext ctx,BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistFriendService registFriendService = new RegistFriendService();
        return registFriendService.Online(ctx,unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage audioAndVideoCallStorage(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistFriendService registFriendService = new RegistFriendService();
        return registFriendService.audioAndVideoCallStorage(unifiedEntranceMessage,head);
    }

    public void pushAudioAndVideoCallMessage(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistFriendService registFriendService = new RegistFriendService();
        registFriendService.pushAudioAndVideoCallMessage(ctx,unifiedEntranceMessage,head);
        return;
    }

    public void removeAVCMessage(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage,BusinessProtocolMessageStandard.Head head) {
        RegistFriendService registFriendService = new RegistFriendService();
         registFriendService.removeAVCMessage(unifiedEntranceMessage,head);
        return;
    }
}
