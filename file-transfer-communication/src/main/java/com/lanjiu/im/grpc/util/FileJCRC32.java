package com.lanjiu.im.grpc.util;

import com.lanjiu.im.grpc.*;
import com.lanjiu.pro.file.*;
import org.apache.log4j.Logger;

import java.nio.charset.StandardCharsets;
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
//        log.info(protocolHexString);
        String checksum_Translate = String.valueOf(FileJCRC32.encode(protocolHexString.getBytes(StandardCharsets.UTF_8)));
//        log.info(checksum_Translate);
        FriendsTransmissionRequest friendsTransmissionRequest = FriendsTransmissionRequest.newBuilder()
                .setFriendsPictureVideoMessage(msg)
                .setChecksum(checksum_Translate).build();
        return friendsTransmissionRequest;
    }

    //给响应数据包加校验信息
    public FriendsTransmissionResponse packageCheckSumResponse(OriginalPictureVideoFriendsTransmission msg){

        CustomGRPCEntityToString customGRPCEntityToString = new CustomGRPCEntityToString();
        String protocolHexString = customGRPCEntityToString.toStringOriginalPictureVideoFriendsTransmission(msg);
//        log.info(protocolHexString);
        String checksum_Translate = String.valueOf(FileJCRC32.encode(protocolHexString.getBytes(StandardCharsets.UTF_8)));
//        log.info(checksum_Translate);
        FriendsTransmissionResponse friendsTransmissionRequest = FriendsTransmissionResponse.newBuilder()
                .setFriendsPictureVideoMessage(msg)
                .setChecksum(checksum_Translate).build();
        return friendsTransmissionRequest;
    }

    //给请求数据包加校验信息
    public GroupTransmissionRequest packageCheckSumGroupRequest(OriginalPictureVideoGroupTransmission msg){

        CustomGRPCEntityToString customGRPCEntityToString = new CustomGRPCEntityToString();
        String protocolHexString = customGRPCEntityToString.toStringOriginalPictureVideoGroupTransmission(msg);
//        log.info(protocolHexString);
        String checksum_Translate = String.valueOf(FileJCRC32.encode(protocolHexString.getBytes(StandardCharsets.UTF_8)));
//        log.info(checksum_Translate);
        GroupTransmissionRequest groupTransmissionRequest = GroupTransmissionRequest.newBuilder()
                .setGroupPictureVideoMessage(msg)
                .setChecksum(checksum_Translate).build();
        return groupTransmissionRequest;
    }

    //给响应数据包加校验信息
    public GroupTransmissionResponse packageCheckSumGroupResponse(OriginalPictureVideoGroupTransmission msg){

        CustomGRPCEntityToString customGRPCEntityToString = new CustomGRPCEntityToString();
        String protocolHexString = customGRPCEntityToString.toStringOriginalPictureVideoGroupTransmission(msg);
        String checksum_Translate = String.valueOf(FileJCRC32.encode(protocolHexString.getBytes(StandardCharsets.UTF_8)));
        GroupTransmissionResponse groupTransmissionResponse = GroupTransmissionResponse.newBuilder()
                .setGroupPictureVideoMessage(msg)
                .setChecksum(checksum_Translate).build();
        return groupTransmissionResponse;
    }


    //checksum的自定义校验函数
    public FilePackageCheckSumResult checkSumValidateGroupResponse(GroupTransmissionResponse groupTransmissionResponse)
    {
        String checksum = groupTransmissionResponse.getChecksum();
        CustomGRPCEntityToString customGRPCEntityToString = new CustomGRPCEntityToString();
        String protocolHexString = customGRPCEntityToString.toStringOriginalPictureVideoGroupTransmission(groupTransmissionResponse.getGroupPictureVideoMessage());
        String checksum_Translate = String.valueOf(FileJCRC32.encode(protocolHexString.getBytes(StandardCharsets.UTF_8)));

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
        CustomGRPCEntityToString customGRPCEntityToString = new CustomGRPCEntityToString();
        String protocolHexString = customGRPCEntityToString.toStringOriginalPictureVideoGroupTransmission(groupTransmissionResponse.getGroupPictureVideoMessage());
        String checksum_Translate = String.valueOf(FileJCRC32.encode(protocolHexString.getBytes(StandardCharsets.UTF_8)));

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
                            .setGroup(groupTransmissionResponse.getGroupPictureVideoMessage().getGroup())
                            .setGroupMember(groupTransmissionResponse.getGroupPictureVideoMessage().getGroupMember())
                            .setFileContent(groupTransmissionResponse.getGroupPictureVideoMessage().getFileContent())
                            .setPicture(groupTransmissionResponse.getGroupPictureVideoMessage().getPicture())
                            .setRegisteredUser(groupTransmissionResponse.getGroupPictureVideoMessage().getRegisteredUser())
                            .setTourists(groupTransmissionResponse.getGroupPictureVideoMessage().getTourists())
                            .setVideo(groupTransmissionResponse.getGroupPictureVideoMessage().getVideo())
                            .setUserType(groupTransmissionResponse.getGroupPictureVideoMessage().getUserType())
                            .setSettingsType(groupTransmissionResponse.getGroupPictureVideoMessage().getSettingsType())
                            .setStatusDetail(ConstantsContent.CRC_FAILURE)
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
        CustomGRPCEntityToString customGRPCEntityToString = new CustomGRPCEntityToString();
        String protocolHexString = customGRPCEntityToString.toStringOriginalPictureVideoFriendsTransmission(groupTransmissionResponse.getFriendsPictureVideoMessage());
        String checksum_Translate = String.valueOf(FileJCRC32.encode(protocolHexString.getBytes(StandardCharsets.UTF_8)));
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
                            .setFriends(groupTransmissionResponse.getFriendsPictureVideoMessage().getFriends())
                            .setFileContent(groupTransmissionResponse.getFriendsPictureVideoMessage().getFileContent())
                            .setPicture(groupTransmissionResponse.getFriendsPictureVideoMessage().getPicture())
                            .setRegisteredUser(groupTransmissionResponse.getFriendsPictureVideoMessage().getRegisteredUser())
                            .setTourists(groupTransmissionResponse.getFriendsPictureVideoMessage().getTourists())
                            .setVideo(groupTransmissionResponse.getFriendsPictureVideoMessage().getVideo())
                            .setUserType(groupTransmissionResponse.getFriendsPictureVideoMessage().getUserType())
                            .setSettingsType(groupTransmissionResponse.getFriendsPictureVideoMessage().getSettingsType())
                            .setStatusDetail(ConstantsContent.CRC_FAILURE)
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
        CustomGRPCEntityToString customGRPCEntityToString = new CustomGRPCEntityToString();
        String protocolHexString = customGRPCEntityToString.toStringOriginalPictureVideoFriendsTransmission(groupTransmissionResponse.getFriendsPictureVideoMessage());

        String checksum_Translate = String.valueOf(FileJCRC32.encode(protocolHexString.getBytes(StandardCharsets.UTF_8)));

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
                            .setFriends(groupTransmissionResponse.getFriendsPictureVideoMessage().getFriends())
                            .setFileContent(groupTransmissionResponse.getFriendsPictureVideoMessage().getFileContent())
                            .setPicture(groupTransmissionResponse.getFriendsPictureVideoMessage().getPicture())
                            .setRegisteredUser(groupTransmissionResponse.getFriendsPictureVideoMessage().getRegisteredUser())
                            .setTourists(groupTransmissionResponse.getFriendsPictureVideoMessage().getTourists())
                            .setVideo(groupTransmissionResponse.getFriendsPictureVideoMessage().getVideo())
                            .setUserType(groupTransmissionResponse.getFriendsPictureVideoMessage().getUserType())
                            .setSettingsType(groupTransmissionResponse.getFriendsPictureVideoMessage().getSettingsType())
                            .setStatusDetail(ConstantsContent.CRC_FAILURE)
                            .build())
                    .setChecksum(checksum_Translate)
                    .build();
            FilePackageCheckSumResult checkSumResult = new FilePackageCheckSumResult(false,checkUnified);
            return checkSumResult;
        }
    }
}
