package com.lanjiu.im.grpc.server.select;


import com.lanjiu.im.storage.pojo.*;
import com.lanjiu.im.storage.service.AudioAndVideoService;
import com.lanjiu.im.storage.service.MsgFriendOffService;
import com.lanjiu.im.storage.service.MsgFriendOnService;
import com.lanjiu.im.storage.utils.ConstType;
import com.lanjiu.im.storage.utils.ConstantKind;
import com.lanjiu.im.storage.utils.IMSContacts;
import com.lanjiu.pro.friend_msg.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SelectFriendmessageAPI {

    private  static Logger logger = LoggerFactory.getLogger(SelectFriendmessageAPI.class);

    public ResponseFriendMessage selectFriendMessageOff(RequestFriendMessage request) {
        MsgFriendOffService service = new MsgFriendOffService();
        ResponseFriendMessage responseFriendMessage = null;
        List<MsgFriendOffPO> msgFriendOffList = new ArrayList<>();
        List<DelFriendOffMsg> delList = new ArrayList<>();
        List<FriendMessage> fmList = new ArrayList<>();
        List<NotifyDelMsg>  noList = new ArrayList<>();
        FriendMessage fm = null;
        NotifyDelMsg nm = null;

        //用户上线时,同时捞取用户离线信息和删除指令信息，一并发送给用户
            try {
                 if(request.getRet().equals(ConstantKind.MESSAGE_REQUEST_SELECT_TO_ID)) {
                     int toId = request.getFriendMessage(0).getToId();
                     msgFriendOffList = service.selectMsgFriendOffByToId(toId);

                    if(msgFriendOffList !=null && msgFriendOffList.size() > 0){
                        for (MsgFriendOffPO msgFriendOffPO : msgFriendOffList) {
                            String url = msgFriendOffPO.getEntityUrl() == null ? "" : msgFriendOffPO.getEntityUrl();
                            fm = FriendMessage.newBuilder()
                                    .setMsgId(msgFriendOffPO.getMsgId())
                                    .setMsgType(msgFriendOffPO.getMsgType())
                                    .setFromId(msgFriendOffPO.getFromId())
                                    .setToId(msgFriendOffPO.getToId())
                                    .setContent(msgFriendOffPO.getContent())
                                    .setEntityUrl(url)
                                    .setMessageOfflineStatus(msgFriendOffPO.isMessageOfflineStatus())
                                    .setBurnAfterReadingStatus(msgFriendOffPO.isBurnAfterReadingStatus())
                                    .setBurnAfterReadingLength(msgFriendOffPO.getBurnAfterReadingLength())
                                    .setFromNickname(msgFriendOffPO.getFromNickname())
                                    .setFromAvatar(msgFriendOffPO.getFromAvatar())
                                    .setVideoTime(msgFriendOffPO.getVideoTime())
                                    .build();
                            fmList.add(fm);
                        }
                    }


                    //捞取删除指令
                    delList = service.getDelFriendMsgOff(toId);
                    if(delList !=null && delList.size()>0){
                        for (DelFriendOffMsg dfom : delList) {
                            if(dfom.getMsgType().equals(IMSContacts.MsgContentType.DEL_OFF_MESSAGE_REGISTERED)){
                                nm = NotifyDelMsg.newBuilder()
                                        .setDelfromId(dfom.getDelFromId())
                                        .setDeltoId(dfom.getDelToId())
                                        .setFromId(dfom.getFromId())
                                        .setMsgId(dfom.getMsgId())
                                        .setTimestap(String.valueOf(dfom.getTimer()))
                                        .setArgs(String.valueOf(dfom.getMsgType()))
                                        .build();
                                noList.add(nm);
                            }

                        }
                    }
                 }
                //捞取定期清理通知
                if(request.getRet().equals(ConstantKind.TIME_CLEAR_REQUEST_SELECT_TO_ID)){
                    return getTimeClearMessage(service,request.getNotifyDelMsg(0).getDeltoId());
                }

                service.commit();
                service.close();
            } catch (Exception e) {
                logger.error("off_message select  error!!!");
                service.rollback();
                service.close();
            }

        if(delList.size()<=0 && (msgFriendOffList.size()<=0))    {
            responseFriendMessage = ResponseFriendMessage.newBuilder()
                    .setRet(ConstType.SUCCESS)
                    .setResult(ConstType.OFF_FRIEND_MESSAGE_NULL)
                    .build();
            return  responseFriendMessage;
        }

        responseFriendMessage = ResponseFriendMessage.newBuilder()
                .setRet(ConstType.SUCCESS)
                .setResult(ConstType.OFF_FRIEND_MESSAGE_SUCCESS)
                .addAllFriendMessage(fmList)
                .addAllNotifyDelMsg(noList)
                .build();
        return  responseFriendMessage;

    }

    private ResponseFriendMessage getTimeClearMessage(MsgFriendOffService service, int toId) {
        //捞取指定用户的定期删除在线消息指令
        long start = System.currentTimeMillis();
        List<TimeClearMsgPO> tcmList = service.getTimeClearLastMsg(toId);
        long mid = System.currentTimeMillis();
        List<NotifyDelMsg>  noList = new ArrayList<>();
        NotifyDelMsg nm = null;
        ResponseFriendMessage responseFriendMessage = null;

        if (tcmList.size() <= 0){
            service.commit();
            service.close();
            responseFriendMessage = ResponseFriendMessage.newBuilder()
                    .setRet(ConstType.FAILURE)
                    .setResult(ConstType.TIME_CLEAR_MESSAGE)
                    .build();
//            logger.info("捞取定期定期清理消息查询耗时：" + (mid-start));
            return  responseFriendMessage;
        }


        for (TimeClearMsgPO po : tcmList){
            nm = NotifyDelMsg.newBuilder()
                    .setDelfromId(po.getClsFromId())
                    .setDeltoId(po.getClsToId())
                    .setFromId(po.getClsFromId())
                    .setMsgId(po.getMsgUid())
                    .setTimestap(String.valueOf(po.getNewtime()))
                    .setArgs(String.valueOf(po.getMsgType()))
                    .build();
            noList.add(nm);
        }
        service.commit();
        service.close();
        responseFriendMessage = ResponseFriendMessage.newBuilder()
                    .setRet(ConstType.SUCCESS)
                    .setResult(ConstType.TIME_CLEAR_MESSAGE)
                    .addAllNotifyDelMsg(noList)
                    .build();
        long end = System.currentTimeMillis();
//        logger.info("捞取定期定期清理消息总耗时：" + (end-start));
//        logger.info("捞取定期定期清理消息查询耗时：" + (mid-start));
        return  responseFriendMessage;


    }

    //根据userId推送音视频消息
    public AudioAndVideoCallResponse getAudioAndVideoMessage(AudioAndVideoCallRequest request) {
        String to_user = request.getAudioAndVideoCallMessage().getFromUserId();
        List<AudioAndVideoCallMessage>  messageList = new ArrayList<>();
        AudioAndVideoService service = new AudioAndVideoService();
        List<AudioAndVideoPO> avpList = service.selectAudioAndVideoMessage(to_user);
        if (avpList.size()>=0){
            for (AudioAndVideoPO po : avpList){
                AudioAndVideoCallMessage message = AudioAndVideoCallMessage.newBuilder()
                        .setServer(po.getServer())
                        .setRoomId(po.getRoomId())
                        .setRoomPwd(po.getRoomPwd())
                        .setOnlyAudio(po.getOnlyAudio())
                        .setFromUserId(po.getFromUserId())
                        .setFromUserName(po.getUserName())
                        .setUserAvatar(po.getUserAvatar())
                        .setToUser(po.getToUser())
                        .setType(po.getType())
                        .setStatusDetail(String.valueOf(po.getTime()))
                        .build();
                messageList.add(message);
            }
        }
        AudioAndVideoCallResponse  response = AudioAndVideoCallResponse.newBuilder()
                .setResult(ConstType.SUCCESS)
                .addAllAudioAndVideoCallMessage(messageList).build();
        return response;
    }
}
