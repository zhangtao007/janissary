package com.lanjiu.im.fileStorage;

import com.lanjiu.im.fileStorage.fileClient.FileStorageAPI;
import com.lanjiu.im.util.ConstantsContent;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import com.lanjiu.pro.fileStorage.FriendsTransmissionRequest;
import com.lanjiu.pro.fileStorage.Head;
import com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission;
import com.lanjiu.pro.fileStorage.Tourists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileStorageUtil {

    private  static final Logger logger = LoggerFactory.getLogger(FileStorageUtil.class);

    //游客退出时grpc调文件存储和交互服务器
    public static void cleanFile(String fromId) {

        FriendsTransmissionRequest request = FriendsTransmissionRequest.newBuilder()
                .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
                        .setHead(Head.newBuilder()
                                .setFromId(fromId).build())
                     .build())
               .build();
        FileStorageAPI fileStorageAPI = new FileStorageAPI();
        try {
            fileStorageAPI.cleanFileWithUserId(request);
        } catch (Exception e) {
            logger.error("用户退出时调用文件服务删除文件接口异常！fromId:"+fromId+", info:");
            e.printStackTrace();
        }

    }

//    public static void main(String[] args) {
//        BusinessProtocolMessageStandard.Head head = BusinessProtocolMessageStandard.Head.newBuilder()
//                .setFromId("")
//                .setToId("1").build();
//        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage =BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                .setLogoutProtocol(BusinessProtocolMessages.LogoutProtocol.newBuilder()
//                        .setTouristsUser(BusinessProtocolEntities.TouristsUser.newBuilder()
//                                .setTemporaryId("").build()).build()).build();
//        FileStorageUtil.cleanFile(unifiedEntranceMessage,head);
//    }

}
