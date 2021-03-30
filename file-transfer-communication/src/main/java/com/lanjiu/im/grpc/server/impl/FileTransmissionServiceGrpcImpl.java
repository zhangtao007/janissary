package com.lanjiu.im.grpc.server.impl;

import com.lanjiu.im.grpc.server.FileServiceOperation;
import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.FileJCRC32;
import com.lanjiu.im.grpc.util.FilePackageCheckSumResult;
import com.lanjiu.im.grpc.util.FileProperties;
import com.lanjiu.pro.file.*;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FileTransmissionServiceGrpcImpl extends FileTransmissionServiceGrpc.FileTransmissionServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(FileTransmissionServiceGrpcImpl.class);

    public   static Map<String,FileProperties> filePropertyMap = new ConcurrentHashMap<>();
    //参数非流式传输的接口-------------------------------------------------------------------------------------
    //好友上传
    @Override
    public void originalFriendsTransmissionUpload(FriendsTransmissionRequest request, StreamObserver<FriendsTransmissionResponse> responseObserver) {
        //数据包完整性校验
        FileJCRC32 jcrc32 = new FileJCRC32();
        FilePackageCheckSumResult checkSumResult = jcrc32.checkSumValidateFriendsRequest(request);
        if (checkSumResult.b_result){
            OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission = request.getFriendsPictureVideoMessage();
//            Friends Avatar = Friends.newBuilder().setFriendsId("000").build();
            Friends friends = request.getFriendsPictureVideoMessage().getFriends();
            FileContent fileContent = request.getFriendsPictureVideoMessage().getFileContent();

            FileServiceOperation fileServiceOperation = new FileServiceOperation();
            try {
                //保存文件并且responseObserver返回信息到申请端
                fileServiceOperation.transmissionFileContentReception(originalPictureVideoFriendsTransmission, friends, fileContent, responseObserver);
            } catch (IOException e) {
                logger.error(request.toString());
                logger.error("文件上传错误，e");
            }

        }else {
            //responseObserver返回信息到申请端
            logger.info("好友上传数据包完整性校验失败，fromId:"+request.getFriendsPictureVideoMessage().getHead().getFromId());
            responseObserver.onNext(checkSumResult.getMsgFriendsResponse());
        }
        //标识方法调用已完成
        responseObserver.onCompleted();
    }

    //群成员上传
    @Override
    public void originalGroupTransmissionUpload(GroupTransmissionRequest request,StreamObserver<GroupTransmissionResponse> responseObserver) {
        //数据包完整性校验
        FileProperties fileProperties = new FileProperties();
        FileJCRC32 jcrc32 = new FileJCRC32();
        FilePackageCheckSumResult checkSumResult = jcrc32.checkSumValidateGroupRequest(request);
        if (checkSumResult.b_result){
            GroupMember groupMember = request.getGroupPictureVideoMessage().getGroupMember();
            Group group = request.getGroupPictureVideoMessage().getGroup();
            OriginalPictureVideoGroupTransmission originalPictureVideoGroupTransmission = request.getGroupPictureVideoMessage();
            FileContent fileContent = request.getGroupPictureVideoMessage().getFileContent();
            FileServiceOperation fileServiceOperation = new FileServiceOperation();
            try {
                //保存文件并且responseObserver返回信息到申请端
                fileServiceOperation.transmissionFileContentGroupReception(originalPictureVideoGroupTransmission, group, groupMember, fileContent, responseObserver);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            //responseObserver返回信息到申请端
            logger.info("群成员上传数据包完整性校验失败，fromId:"+request.getGroupPictureVideoMessage().getHead().getFromId());
            responseObserver.onNext(checkSumResult.getMsgGroupResponse());
        }
        //标识方法调用已完成
        responseObserver.onCompleted();
    }

    //好友下载
    @Override
    public void originalFriendsTransmissionDownload(FriendsTransmissionRequest request, StreamObserver<FriendsTransmissionResponse> responseObserver) {
        //数据包完整性校验
        FileJCRC32 jcrc32 = new FileJCRC32();
        long start = System.currentTimeMillis();
        FilePackageCheckSumResult checkSumResult = jcrc32.checkSumValidateFriendsRequest(request);
        long  end  = System.currentTimeMillis();
//        logger.error("download checkSumValidate 耗时 :"+((end-start)/1000));

        if (checkSumResult.b_result){
            OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission = request.getFriendsPictureVideoMessage();
            FileServiceOperation fileServiceOperation = new FileServiceOperation();
            try {
                //保存文件并且responseObserver返回信息到申请端
                fileServiceOperation.transmissionFileContentSend(originalPictureVideoFriendsTransmission, responseObserver);
            } catch (IOException e) {
                logger.info("下载文件不存在$W$ ,url:"+originalPictureVideoFriendsTransmission.getFileContent().getBigFileHead().getServerUrl());
                FriendsTransmissionResponse response = null;
                response = jcrc32.packageCheckSumResponse(
                        OriginalPictureVideoFriendsTransmission.newBuilder()
                                .setHead(Head.newBuilder()
                                        .setToken(ConstantsContent.CRC_FAILURE)
                                        .setStatusReport("文件地址错误").build())
                                .setFileContent(originalPictureVideoFriendsTransmission.getFileContent().toBuilder().setPackageKind(ConstantsContent.FILE_NON_EXISTENT)
                                        )
                                .setFriends(originalPictureVideoFriendsTransmission.getFriends())
                                .build());

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }

        }else {
            //responseObserver返回信息到申请端
            logger.info("数据包完整性校验失败,fromId:"+request.getFriendsPictureVideoMessage().getHead().getFromId());
            responseObserver.onNext(checkSumResult.getMsgFriendsResponse());
            responseObserver.onCompleted();
        }
    }

    //群成员下载
    @Override
    public void originalGroupTransmissionDownload(GroupTransmissionRequest request, StreamObserver<GroupTransmissionResponse> responseObserver) {
        //数据包完整性校验
        FileJCRC32 jcrc32 = new FileJCRC32();
        FilePackageCheckSumResult checkSumResult = jcrc32.checkSumValidateGroupRequest(request);
        if (checkSumResult.b_result){
            OriginalPictureVideoGroupTransmission originalPictureVideoGroupTransmission = request.getGroupPictureVideoMessage();
            FileServiceOperation fileServiceOperation = new FileServiceOperation();
            try {
                //保存文件并且responseObserver返回信息到申请端
                fileServiceOperation.transmissionFileContentGroupSend(originalPictureVideoGroupTransmission, responseObserver);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            //responseObserver返回信息到申请端
            logger.info("群成员下载数据包完整性校验失败,fromId:"+request.getGroupPictureVideoMessage().getHead().getFromId());
            responseObserver.onNext(checkSumResult.getMsgGroupResponse());
        }
    }

    //文件存储服务器定时删除任务-----群定时
    @Override
    public void groupTransmissionFileDeleteForStorageServer(GroupTransmissionRequest request, StreamObserver<GroupTransmissionResponse> responseObserver){
        //数据包完整性校验
        logger.info("存储服务器定时删除文件接口");
        OriginalPictureVideoGroupTransmission originalPictureVideoGroupTransmission = request.getGroupPictureVideoMessage();
        FileServiceOperation fileServiceOperation = new FileServiceOperation();
        //保存文件并且responseObserver返回信息到申请端
        fileServiceOperation.groupTransmissionFileDelete(originalPictureVideoGroupTransmission, responseObserver);
        responseObserver.onCompleted();
    }

    //文件存储服务器删除文件交互服务器上的文件信息-----好友
    @Override
    public void friendsTransmissionFileDeleteForStorageServer(FriendsTransmissionRequest request, StreamObserver<FriendsTransmissionResponse> responseObserver) {
        //数据包完整性校验
        logger.info("存储服务器删除文件接口");
        OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission= request.getFriendsPictureVideoMessage();
        FileServiceOperation fileServiceOperation = new FileServiceOperation();
        //标识方法调用已完成
        fileServiceOperation.friendsTransmissionFileDelete(originalPictureVideoFriendsTransmission, responseObserver);
        responseObserver.onCompleted();
    }


}
