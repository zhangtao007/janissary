package com.lanjiu.im.grpc.server.delete;


import com.lanjiu.im.storage.service.AudioAndVideoService;
import com.lanjiu.im.storage.service.MsgFriendOffService;
import com.lanjiu.im.storage.service.MsgFriendOnService;
import com.lanjiu.im.storage.utils.ConstType;
import com.lanjiu.im.storage.utils.ConstantKind;
import com.lanjiu.pro.friend_msg.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RemoveFriendMessageAPI {

    private  static Logger logger = LoggerFactory.getLogger(RemoveFriendMessageAPI.class);

    public ResponseFriendMessage removeFriendMessageOff(RequestFriendMessage request) {
        MsgFriendOffService service = new MsgFriendOffService();
        if(request.getRet().equals(ConstantKind.TIME_CLEAR_ARG)){
            int toId = request.getNotifyDelMsg(0).getDeltoId();
            service.deleteTimeClearMsg(toId);
            service.commit();
            service.close();
            return null;
        }

        List<FriendMessage> friendMessageList =request.getFriendMessageList();
        int num = 0 , k = 0;
        for (FriendMessage friendMessage : friendMessageList){
            try {
                if(request.getRet().equals(ConstantKind.MESSAGE_REQUEST_DELETE_MSG_ID)){
                    num =  service.deleteMsgFriendOff(friendMessage.getMsgId());
                    service.commit();
                    service.close();
                    if(num>0){
                        ResponseFriendMessage response = ResponseFriendMessage.newBuilder()
                                .setRet(ConstType.SUCCESS)
                                .build();
                        return  response;
                    }
                    ResponseFriendMessage response = ResponseFriendMessage.newBuilder()
                            .setRet(ConstType.FAILURE)
                            .build();
                    return  response;

                }else if(request.getRet().equals(ConstantKind.MESSAGE_REQUEST_DELETE_FROM_ID)){
                    num = service.deleteMsgFriendOffByFromId(friendMessage.getFromId());
                }else if(request.getRet().equals(ConstantKind.MESSAGE_REQUEST_DELETE_TO_ID)){
                    //删除toId发送的消息和待接收的消息。
                    logger.info("执行用户离线消息定期清理："+friendMessage.getToId());
                    num = service.deleteMsgFriendOffByToId(friendMessage.getToId());
//                    k = service.deleteDelFriendMsgOff(friendMessage.getToId());
                }else if(request.getRet().equals(ConstantKind.MESSAGE_REQUEST_GUEST_USER_LOGOUT)){
                    //游客退出，删除离线消息，指令
                    service.deleteGuestOffMsgByFromidToid(friendMessage.getToId(),friendMessage.getToId());
                    service.deleteDelGuestOffMsgByFromidToid(friendMessage.getToId(),friendMessage.getToId());

                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                ResponseFriendMessage response = ResponseFriendMessage.newBuilder().setRet(ConstType.FAILURE)
                        .setResult(ConstType.DELETE_FRIEND_MESSAGE_FAILURE).addAllFriendMessage(friendMessageList).build();
                return response;
            }
        }
        service.commit();
        service.close();

        ResponseFriendMessage response = ResponseFriendMessage.newBuilder()
                .setRet(ConstType.SUCCESS)
                .addAllFriendMessage(friendMessageList).build();
        return  response;



    }


    //用户收到推送消息后根据回执roomId和User删除对应消息
    public AudioAndVideoCallResponse removeAudioAndVideoMessage(AudioAndVideoCallRequest request) {
        String receiveUser = request.getAudioAndVideoCallMessage().getFromUserId();
        String roomId = request.getAudioAndVideoCallMessage().getRoomId();
        AudioAndVideoService service = new AudioAndVideoService();
        int row= service.removeAudioAndVideoMessge(receiveUser,roomId);
        service.commit();
        service.close();
        if (row>=0){
            AudioAndVideoCallResponse response = AudioAndVideoCallResponse.newBuilder()
                    .setResult(ConstType.SUCCESS)
                    .build();
            return response;
        }
        return null;
    }

    public void closeRoomByRoomId(AudioAndVideoCallRequest request) {
        String roomId = request.getAudioAndVideoCallMessage().getRoomId();
        AudioAndVideoService service = new AudioAndVideoService();
        int row = service.closeRoomByRoomId(roomId);
        logger.info("房间【"+roomId+"】关闭后清除相关离线消息数量："+row);
        service.commit();
        service.close();
    }
}
