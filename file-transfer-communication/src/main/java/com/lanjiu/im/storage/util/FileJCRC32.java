package com.lanjiu.im.storage.util;

import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.pro.fileStorage.*;
import org.apache.log4j.Logger;

import java.util.zip.CRC32;

public class FileJCRC32 {
    private final Logger log = Logger.getLogger(FileJCRC32.class);
    /**
     * 编码
     *
     * @param data
     * @return
     */
    public static long encode(byte[] data) {
        CRC32 crc32 = new CRC32();
        crc32.update(data);
        return crc32.getValue();
    }

    //给请求数据包加校验信息
    public FriendsTransmissionRequest packageCheckSumRequest(OriginalPictureVideoFriendsTransmission msg){

        CustomGRPCEntityToString customGRPCEntityToString = new CustomGRPCEntityToString();
        String protocolHexString = customGRPCEntityToString.toStringOriginalPictureVideoFriendsTransmission(msg);
        log.info(protocolHexString);
        String checksum_Translate = String.valueOf(FileJCRC32.encode(protocolHexString.getBytes()));
        log.info(checksum_Translate);
        FriendsTransmissionRequest friendsTransmissionRequest = FriendsTransmissionRequest.newBuilder()
                .setFriendsPictureVideoMessage(msg)
                .setChecksum(checksum_Translate).build();
        return friendsTransmissionRequest;
    }

    //给响应数据包加校验信息
    public FriendsTransmissionResponse packageCheckSumResponse(OriginalPictureVideoFriendsTransmission msg){

        CustomGRPCEntityToString customGRPCEntityToString = new CustomGRPCEntityToString();
        String protocolHexString = customGRPCEntityToString.toStringOriginalPictureVideoFriendsTransmission(msg);
        log.info(protocolHexString);
        String checksum_Translate = String.valueOf(FileJCRC32.encode(protocolHexString.getBytes()));
        log.info(checksum_Translate);
        FriendsTransmissionResponse friendsTransmissionRequest = FriendsTransmissionResponse.newBuilder()
                .setFriendsPictureVideoMessage(msg)
                .setChecksum(checksum_Translate).build();
        return friendsTransmissionRequest;
    }

    //给请求数据包加校验信息
    public GroupTransmissionRequest packageCheckSumGroupRequest(OriginalPictureVideoGroupTransmission msg){

        CustomGRPCEntityToString customGRPCEntityToString = new CustomGRPCEntityToString();
        String protocolHexString = customGRPCEntityToString.toStringOriginalPictureVideoGroupTransmission(msg);
        log.info(protocolHexString);
        String checksum_Translate = String.valueOf(FileJCRC32.encode(protocolHexString.getBytes()));
        log.info(checksum_Translate);
        GroupTransmissionRequest groupTransmissionRequest = GroupTransmissionRequest.newBuilder()
                .setGroupPictureVideoMessage(msg)
                .setChecksum(checksum_Translate).build();
        return groupTransmissionRequest;
    }

    //给响应数据包加校验信息
    public GroupTransmissionResponse packageCheckSumGroupResponse(OriginalPictureVideoGroupTransmission msg){

        CustomGRPCEntityToString customGRPCEntityToString = new CustomGRPCEntityToString();
        String protocolHexString = customGRPCEntityToString.toStringOriginalPictureVideoGroupTransmission(msg);
        log.info(protocolHexString);
        String checksum_Translate = String.valueOf(FileJCRC32.encode(protocolHexString.getBytes()));
        log.info(checksum_Translate);
        GroupTransmissionResponse groupTransmissionResponse = GroupTransmissionResponse.newBuilder()
                .setGroupPictureVideoMessage(msg)
                .setChecksum(checksum_Translate).build();
        return groupTransmissionResponse;
    }


    //checksum的自定义校验函数
    public FilePackageCheckSumResult checkSumValidateGroupResponse(GroupTransmissionResponse groupTransmissionResponse)
    {
        String checksum = groupTransmissionResponse.getChecksum();
        System.out.println("checkSumValidateProtocol" + checksum);
        CustomGRPCEntityToString customGRPCEntityToString = new CustomGRPCEntityToString();
        String protocolHexString = customGRPCEntityToString.toStringOriginalPictureVideoGroupTransmission(groupTransmissionResponse.getGroupPictureVideoMessage());

        log.info("原串：" + protocolHexString);
        String checksum_Translate = String.valueOf(FileJCRC32.encode(protocolHexString.getBytes()));
        log.info("CRC32：" + checksum_Translate);

        if(checksum_Translate.equals(checksum))
        {
            FilePackageCheckSumResult checkSumResult = new FilePackageCheckSumResult(true,groupTransmissionResponse);
            return checkSumResult;
        }else {
            GroupTransmissionResponse checkUnified = GroupTransmissionResponse.newBuilder()
                    .setGroupPictureVideoMessage(OriginalPictureVideoGroupTransmission
                            .newBuilder()
                            .setHead(Head.newBuilder()
                                    .setToken(ConstantsContent.CONSTANT_TOKEN)
                                    .setStatusReport(ConstantsContent.CRC_FAILURE)
                                    .build())
                                    .build())
                    .setChecksum(checksum_Translate)
                    .build();
            FilePackageCheckSumResult checkSumResult = new FilePackageCheckSumResult(false,checkUnified);
            return checkSumResult;
        }
    }
    //checksum的自定义校验函数
    public FilePackageCheckSumResult checkSumValidateGroupRequest(GroupTransmissionRequest groupTransmissionResponse)
    {
        String checksum = groupTransmissionResponse.getChecksum();
        System.out.println("checkSumValidateProtocol" + checksum);
        CustomGRPCEntityToString customGRPCEntityToString = new CustomGRPCEntityToString();
        String protocolHexString = customGRPCEntityToString.toStringOriginalPictureVideoGroupTransmission(groupTransmissionResponse.getGroupPictureVideoMessage());

        log.info("原串：" + protocolHexString);
        String checksum_Translate = String.valueOf(FileJCRC32.encode(protocolHexString.getBytes()));
        log.info("CRC32：" + checksum_Translate);

        if(checksum_Translate.equals(checksum))
        {
            FilePackageCheckSumResult checkSumResult = new FilePackageCheckSumResult(true,groupTransmissionResponse);
            return checkSumResult;
        }else {
            GroupTransmissionRequest checkUnified = GroupTransmissionRequest.newBuilder()
                    .setGroupPictureVideoMessage(OriginalPictureVideoGroupTransmission
                            .newBuilder()
                            .setHead(Head.newBuilder()
                                    .setToken(ConstantsContent.CONSTANT_TOKEN)
                                    .setStatusReport(ConstantsContent.CRC_FAILURE)
                                    .build())
                            .build())
                    .setChecksum(checksum_Translate)
                    .build();
            FilePackageCheckSumResult checkSumResult = new FilePackageCheckSumResult(false,checkUnified);
            return checkSumResult;
        }
    }
    //checksum的自定义校验函数
    public FilePackageCheckSumResult checkSumValidateFriendsResponse(FriendsTransmissionResponse groupTransmissionResponse)
    {
        String checksum = groupTransmissionResponse.getChecksum();
        System.out.println("checkSumValidateProtocol" + checksum);
        CustomGRPCEntityToString customGRPCEntityToString = new CustomGRPCEntityToString();
        String protocolHexString = customGRPCEntityToString.toStringOriginalPictureVideoFriendsTransmission(groupTransmissionResponse.getFriendsPictureVideoMessage());

        log.info("原串：" + protocolHexString);
        String checksum_Translate = String.valueOf(FileJCRC32.encode(protocolHexString.getBytes()));
        log.info("CRC32：" + checksum_Translate);

        if(checksum_Translate.equals(checksum))
        {
            FilePackageCheckSumResult checkSumResult = new FilePackageCheckSumResult(true,groupTransmissionResponse);
            return checkSumResult;
        }else {
            FriendsTransmissionRequest checkUnified = FriendsTransmissionRequest.newBuilder()
                    .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission
                            .newBuilder()
                            .setHead(Head.newBuilder()
                                    .setToken(ConstantsContent.CONSTANT_TOKEN)
                                    .setStatusReport(ConstantsContent.CRC_FAILURE)
                                    .build())
                            .build())
                    .setChecksum(checksum_Translate)
                    .build();
            FilePackageCheckSumResult checkSumResult = new FilePackageCheckSumResult(false,checkUnified);
            return checkSumResult;
        }
    }
    //checksum的自定义校验函数
    public FilePackageCheckSumResult checkSumValidateFriendsRequest(FriendsTransmissionRequest groupTransmissionResponse)
    {
        String checksum = groupTransmissionResponse.getChecksum();
        System.out.println("checkSumValidateProtocol" + checksum);
        CustomGRPCEntityToString customGRPCEntityToString = new CustomGRPCEntityToString();
        String protocolHexString = customGRPCEntityToString.toStringOriginalPictureVideoFriendsTransmission(groupTransmissionResponse.getFriendsPictureVideoMessage());

        log.info("原串：" + protocolHexString);
        String checksum_Translate = String.valueOf(FileJCRC32.encode(protocolHexString.getBytes()));
        log.info("CRC32：" + checksum_Translate);

        if(checksum_Translate.equals(checksum))
        {
            FilePackageCheckSumResult checkSumResult = new FilePackageCheckSumResult(true,groupTransmissionResponse);
            return checkSumResult;
        }else {
            FriendsTransmissionResponse checkUnified = FriendsTransmissionResponse.newBuilder()
                    .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission
                            .newBuilder()
                            .setHead(Head.newBuilder()
                                    .setToken(ConstantsContent.CONSTANT_TOKEN)
                                    .setStatusReport(ConstantsContent.CRC_FAILURE)
                                    .build())
                            .build())
                    .setChecksum(checksum_Translate)
                    .build();
            FilePackageCheckSumResult checkSumResult = new FilePackageCheckSumResult(false,checkUnified);
            return checkSumResult;
        }
    }
}
