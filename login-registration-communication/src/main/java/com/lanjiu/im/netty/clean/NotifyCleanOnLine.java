package com.lanjiu.im.netty.clean;

import com.lanjiu.im.infomatiom.InfomationUtil;
import com.lanjiu.im.util.ConstType;
import com.lanjiu.im.util.IMSContacts;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.Channel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class NotifyCleanOnLine {

    public static void notifyAllRelete(Channel ch, String toId, long currentTimeMillis) {

        Set<String>  releteUserSet = new HashSet<>();
        //查询所有好友
        Set<String> friendMembers = InfomationUtil.getFriendMembers(toId);
        //查询所有参与的群相关成员
        Set<String> userJoinGroupMember = InfomationUtil.getUserJoinGroupMember(toId);
        releteUserSet.addAll(friendMembers);
        releteUserSet.addAll(userJoinGroupMember);
        if(releteUserSet.contains(toId)){
            releteUserSet.remove(toId);
        }
        //通知所有相干成员
        for (String userId : releteUserSet){
            BusinessProtocolMessageStandard.UnifiedEntranceMessage message = BusinessProtocolMessageStandard.UnifiedEntranceMessage
                .newBuilder()
                .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.MessageClearProtocol)
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgType(IMSContacts.MsgType.DEL_ON_LINE_RECEIVE)
                        .setStatusReport(ConstType.PERSONAL_SETTING_TIMER_CLEAN)
                        .setUniqueIdentify(UUID.randomUUID().toString().replaceAll("-",""))
                        .setTimestamp(currentTimeMillis)
                        .setFromId(toId)
                        .setToId(userId)
                        .build())
                .build();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkMessage = BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage.newBuilder().setUnifiedEntranceMessage(message).build();
        ch.writeAndFlush(checkMessage);
        }

    }


    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());

    }
}
