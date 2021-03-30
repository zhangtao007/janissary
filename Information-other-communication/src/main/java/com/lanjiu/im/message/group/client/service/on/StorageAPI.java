package com.lanjiu.im.message.group.client.service.on;

import com.lanjiu.im.message.group.client.service.LinkTransferCommunication;
import com.lanjiu.im.message.group.client.util.StatusConstant;
import com.lanjiu.im.storage.MsgGroup;
import com.lanjiu.im.storage.OnGroupMessageTransmissionRequest;
import com.lanjiu.im.storage.OnGroupMessageTransmissionResponse;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class StorageAPI {

    private static final Logger logger = Logger.getLogger(StorageAPI.class.getName());

    //online
    public OnGroupMessageTransmissionResponse selectMessageGroupInformationWithGroupOn(OnGroupMessageTransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        OnGroupMessageTransmissionResponse onGroupMessageTransmissionResponse = linkTransferCommunication.selectMessageGroupInformationWithGroupOn(request);
        return onGroupMessageTransmissionResponse;
    }

    //online
    public OnGroupMessageTransmissionResponse storageMessageGroupInformationWithGroupOn(OnGroupMessageTransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        OnGroupMessageTransmissionResponse onGroupMessageTransmissionResponse = linkTransferCommunication.storageMessageGroupInformationWithGroupOn(request);
        return onGroupMessageTransmissionResponse;
    }

    //online
    public OnGroupMessageTransmissionResponse deleteMessageGroupInformationWithGroupOn(OnGroupMessageTransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        OnGroupMessageTransmissionResponse onGroupMessageTransmissionResponse = linkTransferCommunication.deleteMessageGroupInformationWithGroupOn(request);
        return onGroupMessageTransmissionResponse;
    }

    //online
    public OnGroupMessageTransmissionResponse updateMessageGroupInformationWithGroupOn(OnGroupMessageTransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        OnGroupMessageTransmissionResponse onGroupMessageTransmissionResponse = linkTransferCommunication.updateMessageGroupInformationWithGroupOn(request);
        return onGroupMessageTransmissionResponse;
    }

    public static void main(String[] args) {
        StorageAPI storageAPI = new StorageAPI();
        OnGroupMessageTransmissionRequest onGroupMessageTransmissionRequest = null;
        String content = "\uD83D\uDE0F\uD83D\uDE49\uD83E\uDD84\uD83D\uDC15\uD83E\uDD6D\uD83E\uDD7A\uD83D\uDE02";
        Timestamp creationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        float length = 111;
        BigDecimal lengthBig = new BigDecimal(length);
        onGroupMessageTransmissionRequest = OnGroupMessageTransmissionRequest.newBuilder().addMsgGroup(MsgGroup.newBuilder()
                        .setMsgId(111211111)
                        .setMsgType(0)
                        .setFromId(121212)
                .setToId(212121)
                .setContent(content)
                .setEntityUrl("")
                .setCreateTime(creationTime.getTime())
                .setMessageOfflineStatus(StatusConstant.MESSAGE_OFFLINE_STATUS_OFF)
                .setBurnAfterReadingStatus(StatusConstant.BURN_AFTER_READING_STATUS_OFF)
                .setBurnAfterReadingLength(lengthBig.floatValue()).build()
        ).build();
        System.out.println("start");
        OnGroupMessageTransmissionResponse onGroupMessageTransmissionResponse = storageAPI.storageMessageGroupInformationWithGroupOn(onGroupMessageTransmissionRequest);
        List<MsgGroup> list = onGroupMessageTransmissionResponse.getMsgGroupList();
        for (MsgGroup msgGroup : list){
            logger.info(msgGroup.getContent());
            logger.info("getMsgId: " + msgGroup.getMsgId());
            logger.info("getBurnAfterReadingLength: " + msgGroup.getBurnAfterReadingLength());
            logger.info(msgGroup.getCreateTime());
        }
    }
}
