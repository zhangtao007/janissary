package com.lanjiu.im.grpc.server.create;


import com.lanjiu.im.storage.pojo.*;
import com.lanjiu.im.storage.service.AudioAndVideoService;
import com.lanjiu.im.storage.service.MsgFriendOffService;
import com.lanjiu.im.storage.service.MsgFriendOnService;
import com.lanjiu.im.storage.utils.ConstType;
import com.lanjiu.im.storage.utils.ConstantKind;
import com.lanjiu.pro.friend_msg.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class StorageFriendMessageAPI {
    private  static Logger logger = LoggerFactory.getLogger(StorageFriendMessageAPI.class);

    public ResponseFriendMessage storageFriendMessageOff(RequestFriendMessage request) {
        MsgFriendOffService service = new MsgFriendOffService();
        String args = request.getRet();
        int num = 0;
        //判断消息类型
        if(args.equals(ConstantKind.MESSAGE_FRIEND_OFF)){
            List<FriendMessage> friendMessageList =request.getFriendMessageList();

            for(FriendMessage friendMessage : friendMessageList){
                MsgFriendOffPO msgFriendOffPO = new MsgFriendOffPO();
                msgFriendOffPO.setMsgId(request.getFriendMessage(0).getMsgId());
                msgFriendOffPO.setMsgType(friendMessage.getMsgType());
                msgFriendOffPO.setFromId(friendMessage.getFromId());
                msgFriendOffPO.setToId(friendMessage.getToId());
                msgFriendOffPO.setContent(friendMessage.getContent());
                msgFriendOffPO.setEntityUrl(friendMessage.getEntityUrl());
                msgFriendOffPO.setMessageOfflineStatus(friendMessage.getMessageOfflineStatus());
                msgFriendOffPO.setBurnAfterReadingStatus(friendMessage.getBurnAfterReadingStatus());
                msgFriendOffPO.setBurnAfterReadingLength(friendMessage.getBurnAfterReadingLength());
                msgFriendOffPO.setCreateTime(Long.parseLong(friendMessage.getCreateTime()));
                msgFriendOffPO.setFromNickname(friendMessage.getFromNickname());
                msgFriendOffPO.setFromAvatar(friendMessage.getFromAvatar());
                msgFriendOffPO.setVideoTime(friendMessage.getVideoTime());
                num = service.storageMsgFriendOff(msgFriendOffPO);

            }
        }else if(args.equals(ConstantKind.MESSAGE_FRIEND_DEL)){
            List<NotifyDelMsg> notifyDelMsgsList = request.getNotifyDelMsgList();
            //对于删除指令，先判断离线消息中是否该消息尚未发出，若是则删除响应离线消息；若否则存储删除指令；

            for (NotifyDelMsg msg: notifyDelMsgsList ) {
                int count=0;
                 count = service.deleteMsgFriendOff(msg.getMsgId());
                 num=count;
                if(count >0) {
                    break;
                }
                //存入删除指令
                DelFriendOffMsg delOffMsg = new DelFriendOffMsg();
                delOffMsg.setDelFromId(msg.getDelfromId());
                delOffMsg.setDelToId(msg.getDeltoId());
                delOffMsg.setFromId(msg.getFromId());
                delOffMsg.setTimer(Long.parseLong(msg.getTimestap()));
                delOffMsg.setMsgId(msg.getMsgId());
                delOffMsg.setMsgType(Integer.parseInt(msg.getArgs()));

                 num = service.insertDelFriendMsgOff(delOffMsg);


            }
        }else if(args.equals(ConstantKind.TIME_CLEAR_ARG)){
            List<NotifyDelMsg> ndmList = request.getNotifyDelMsgList();
            int fromId = ndmList.get(0).getDelfromId();
            int toId = ndmList.get(0).getDeltoId();
            int msgType = Integer.parseInt(ndmList.get(0).getArgs());
            String msguid = ndmList.get(0).getMsgId();
            long timer = Long.parseLong( ndmList.get(0).getTimestap());
            TimeClearMsgPO tcm = new TimeClearMsgPO();
            tcm.setClsFromId(fromId);
            tcm.setClsToId(toId);
            tcm.setMsgUid(msguid);
            tcm.setNewtime(timer);
            tcm.setMsgType(msgType);
            TimeClearMsgPO tpo = service.getOneTimeClearLastMsg(fromId, toId);
            if(tpo ==null){
                num =service.insertTimeClearMsg(tcm);
            }else{
                num =service.updateTimeClearMsg(tcm);
            }
        }

        service.commit();
        service.close();
        if(num>0 ){
            ResponseFriendMessage response = ResponseFriendMessage.newBuilder()
                    .setRet(ConstType.SUCCESS)
                    .build();
            return  response;
        }else{
            ResponseFriendMessage response = ResponseFriendMessage.newBuilder()
                    .setRet(ConstType.FAILURE)
                    .build();
            return  response;

        }
    }

    public AudioAndVideoCallResponse audioAndVideoCallMessage(AudioAndVideoCallRequest request) {
        //音视频消息保存
        AudioAndVideoCallMessage avcmessage = request.getAudioAndVideoCallMessage();
        AudioAndVideoService  service = new AudioAndVideoService();
        AudioAndVideoPO  po = new AudioAndVideoPO();
        po.setServer(avcmessage.getServer());
        po.setRoomId(avcmessage.getRoomId());
        po.setRoomPwd(avcmessage.getRoomPwd());
        po.setFromUserId(avcmessage.getFromUserId());
        po.setUserName(avcmessage.getFromUserName());
        po.setUserAvatar(avcmessage.getUserAvatar());
        po.setOnlyAudio(avcmessage.getOnlyAudio());
        po.setToUser(avcmessage.getToUser());
        po.setType(avcmessage.getType());
        po.setTime(Long.parseLong(avcmessage.getStatusDetail()));
        int res = service.storageVideoMessage(po);
        service.commit();
        service.close();
        if (res>0){
            AudioAndVideoCallResponse response = AudioAndVideoCallResponse.newBuilder()
                        .setResult(ConstType.SUCCESS)
                        .build();
                return  response;
        }
        return null;
    }




}
