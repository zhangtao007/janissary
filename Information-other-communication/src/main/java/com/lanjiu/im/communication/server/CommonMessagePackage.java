package com.lanjiu.im.communication.server;

import com.lanjiu.im.communication.util.IMSContacts;
import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;

public class CommonMessagePackage {

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage offLineStatusUpdateToTourists(){
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(IMSContacts.MsgType.FRIEND_ONLINE_STATUS_TOURISTS)
                        .build())
                .build();
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(unifiedEntranceMessage);
        return checkUnified;
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage offLineStatusUpdateToRegistered(){
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(IMSContacts.MsgType.FRIEND_ONLINE_STATUS_REGISTERED)
                        .build())
                .build();
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(unifiedEntranceMessage);
        return checkUnified;
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage offLineStatusUpdateToGroupMemberTourists(){
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(IMSContacts.MsgType.GROUP_MEMBER_ONLINE_STATUS_TOURISTS)
                        .build())
                .build();
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(unifiedEntranceMessage);
        return checkUnified;
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage offLineStatusUpdateToGroupMemberRegistered(){
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(IMSContacts.MsgType.GROUP_MEMBER_ONLINE_STATUS_REGISTERED)
                        .build())
                .build();
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(unifiedEntranceMessage);
        return checkUnified;
    }
}
