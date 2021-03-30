package com.lanjiu.im.friendStorage;

import com.lanjiu.im.friendStorage.fmClient.OffFriendMessageAPI;
import com.lanjiu.im.util.ConstantKind;
import com.lanjiu.im.util.IMSContacts;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.friend_msg.FriendMessage;
import com.lanjiu.pro.friend_msg.NotifyDelMsg;
import com.lanjiu.pro.friend_msg.RequestFriendMessage;
import com.lanjiu.pro.friend_msg.ResponseFriendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FriendMessageUtil {

    private  static final Logger logger = LoggerFactory.getLogger(FriendMessageUtil.class);

    public static void cleanFriendMessage(String toId){

        RequestFriendMessage requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.MESSAGE_REQUEST_DELETE_TO_ID)
                .addFriendMessage(FriendMessage.newBuilder()
                        .setToId(Integer.parseInt(toId)).build())
                .addNotifyDelMsg(NotifyDelMsg.newBuilder()
                        .setDeltoId(Integer.parseInt(toId)).build())
                .build();
        OffFriendMessageAPI offMsgAPI = new OffFriendMessageAPI();
        ResponseFriendMessage responseFriendMessage = null;
        try {
            responseFriendMessage = offMsgAPI.removeFriendMessage(requestFriendMessage);
        } catch (Exception e) {
            logger.error("用户退出时删除好友离线消息接口调用异常！！,Id:"+toId+" ,info:"+e.getMessage());
        }


        if(responseFriendMessage.getRet().equals(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)){
            logger.error("删除好友离线消息接口返回未删除成功,toId:"+toId);
        }
    }
}
