package com.lanjiu.im.message.group.client.service.off;

import com.lanjiu.im.message.group.client.service.LinkTransferCommunication;
import com.lanjiu.im.storage.OffGroupMessageTransmissionRequest;
import com.lanjiu.im.storage.OffGroupMessageTransmissionResponse;
import org.apache.log4j.Logger;

public class MessageStorageAPI {

    private static final Logger logger = Logger.getLogger(MessageStorageAPI.class.getName());

    //offline
    public OffGroupMessageTransmissionResponse selectMessageGroupInformationWithGroupOff(OffGroupMessageTransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        OffGroupMessageTransmissionResponse offGroupMessageTransmissionResponse = linkTransferCommunication.selectMessageGroupInformationWithGroupOff(request);
        return offGroupMessageTransmissionResponse;
    }

    //offline
    public OffGroupMessageTransmissionResponse storageMessageGroupInformationWithGroupOff(OffGroupMessageTransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        OffGroupMessageTransmissionResponse offGroupMessageTransmissionResponse = linkTransferCommunication.storageMessageGroupInformationWithGroupOff(request);
        return offGroupMessageTransmissionResponse;
    }

    //offline
    public OffGroupMessageTransmissionResponse deleteMessageGroupInformationWithGroupOff(OffGroupMessageTransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        OffGroupMessageTransmissionResponse offGroupMessageTransmissionResponse = linkTransferCommunication.deleteMessageGroupInformationWithGroupOff(request);
        return offGroupMessageTransmissionResponse;
    }

    //offline
    public OffGroupMessageTransmissionResponse updateMessageGroupInformationWithGroupOff(OffGroupMessageTransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        OffGroupMessageTransmissionResponse offGroupMessageTransmissionResponse = linkTransferCommunication.updateMessageGroupInformationWithGroupOff(request);
        return offGroupMessageTransmissionResponse;
    }

//    public static void main(String[] args) {
//        StorageAPI storageAPI = new StorageAPI();
//        OffGroupMessageTransmissionRequest offGroupMessageTransmissionRequest = null;
//        String content = "\uD83D\uDE0F\uD83D\uDE49\uD83E\uDD84\uD83D\uDC15\uD83E\uDD6D\uD83E\uDD7A\uD83D\uDE02";
//        Timestamp creationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
//        float length = 111;
//        BigDecimal lengthBig = new BigDecimal(length);
//        offGroupMessageTransmissionRequest = OffGroupMessageTransmissionRequest.newBuilder().addMsgGroup(MsgGroup.newBuilder()
//                        .setMsgId(11111111)
//                        .setMsgType(0)
//                        .setFromId(121212)
//                .setToId(212121)
//                .setContent(content)
//                .setEntityUrl("")
//                .setCreateTime(creationTime.getTime())
//                .setMessageOfflineStatus(StatusConstant.MESSAGE_OFFLINE_STATUS_OFF)
//                .setBurnAfterReadingStatus(StatusConstant.BURN_AFTER_READING_STATUS_OFF)
//                .setBurnAfterReadingLength(lengthBig.floatValue()).build()
//        ).setKind(ConstantKind.MESSAGE_REQUEST_DELETE_FROM_ID).build();
//        System.out.println("start");
//        //OffGroupMessageTransmissionResponse onGroupMessageTransmissionResponse = storageAPI.storageMessageGroupInformationWithGroupOff(offGroupMessageTransmissionRequest);
//        OffGroupMessageTransmissionResponse onGroupMessageTransmissionResponse = storageAPI.deleteMessageGroupInformationWithGroupOff(offGroupMessageTransmissionRequest);
//        List<MsgGroup> list = onGroupMessageTransmissionResponse.getMsgGroupList();
//        for (MsgGroup msgGroup : list){
//            logger.info(msgGroup.getContent());
//            logger.info("getMsgId: " + msgGroup.getMsgId());
//            logger.info("getBurnAfterReadingLength: " + msgGroup.getBurnAfterReadingLength());
//            logger.info(msgGroup.getCreateTime());
//        }
//    }
}
