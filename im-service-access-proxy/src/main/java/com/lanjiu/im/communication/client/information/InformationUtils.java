package com.lanjiu.im.communication.client.information;

import com.lanjiu.im.communication.util.JCRC32;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;

public class InformationUtils {

    static BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage responseAddFriendMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        BusinessProtocolMessageStandard.Head head = unifiedEntranceMessage.getHead();
        BusinessProtocolMessages.FriendAddProtocol friendAddProtocol = unifiedEntranceMessage.getFriendAddProtocol();
        BusinessProtocolMessages.FriendAddProtocol protocol = BusinessProtocolMessages.FriendAddProtocol.newBuilder()
                .setStatusDetail(friendAddProtocol.getStatusDetail())
                .build();
        BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder(head))
                .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendAddProtocol)
                .setFriendAddProtocol(protocol)
                .build();
        return JCRC32.packageCheckSum(message);
    }

}
