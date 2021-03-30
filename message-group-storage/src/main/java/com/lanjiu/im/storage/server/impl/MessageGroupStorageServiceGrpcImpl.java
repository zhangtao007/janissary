package com.lanjiu.im.storage.server.impl;

import com.lanjiu.im.storage.service.api.MessageGroupServiceApi;
import com.lanjiu.im.storage.util.CommKeys;
import com.lanjiu.pro.groupStorage.*;
import io.grpc.stub.StreamObserver;
import org.apache.log4j.Logger;


public class MessageGroupStorageServiceGrpcImpl extends MessageGroupStorageServiceGrpc.MessageGroupStorageServiceImplBase {

    private static final Logger log = Logger.getLogger(MessageGroupStorageServiceGrpcImpl.class.getName());

    private MessageGroupServiceApi serviceApi = new MessageGroupServiceApi();

    @Override
    public void saveGroupMassage(GroupMsgOffLineRequest request, StreamObserver<ResponseResult> responseObserver) {
        log.info("存储离线主体消息数据入参：" + request);
        ResponseResult responseResult = serviceApi.saveGroupMassage(request);
        responseObserver.onNext(responseResult);
        responseObserver.onCompleted();
    }

    @Override
    public void saveGroupMembersOffLineMsg(GroupMsgOffLineRequest request, StreamObserver<ResponseResult> responseObserver) {
        ResponseResult responseResult = serviceApi.saveGroupMembersOffLineMsg(request);
        responseObserver.onNext(responseResult);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteGroupMembersOffLineMsg(DeleteGroupMembersMsgRequest request, StreamObserver<ResponseResult> response) {
        ResponseResult responseResult = serviceApi.deleteGroupMembersOffLineMsg(request);
        response.onNext(responseResult);
        response.onCompleted();
    }

    @Override
    public void deleteSendOffLineMsg(DeleteGroupMembersMsgRequest request, StreamObserver<ResponseResult> response) {
        log.info("删除离线消息入参：" + request);
        ResponseResult responseResult = serviceApi.deleteSendOffLineMsg(request);
        response.onNext(responseResult);
        response.onCompleted();
    }

    @Override
    public void deleteGroupMsg(GroupMsgOffLineRequest request, StreamObserver<ResponseResult> response) {
        ResponseResult responseResult = serviceApi.deleteGroupMsg(request);
        response.onNext(responseResult);
        response.onCompleted();
    }

    @Override
    public void selectOffLineGroupMsg(SelectOffLineGroupMsgRequest request, StreamObserver<ResponseResult> response) {
        ResponseResult responseResult = serviceApi.selectOffLineGroupMsg(request);
        response.onNext(responseResult);
        response.onCompleted();
    }

    @Override
    public void selectOffLineGroupMsgCount(SelectOffLineGroupMsgRequest request, StreamObserver<ResponseCount> response) {
        ResponseCount responseCount = serviceApi.selectOffLineGroupMsgCount(request);
        response.onNext(responseCount);
        response.onCompleted();
    }

    @Override
    public void groupOwnerExit(DeleteGroupMembersMsgRequest request, StreamObserver<ResponseResult> response) {
        ResponseResult responseResult = serviceApi.groupOwnerExit(request);
        response.onNext(responseResult);
        response.onCompleted();

    }

    @Override
    public void groupAudioAndVideoCall(com.lanjiu.pro.groupStorage.GroupAudioVideoCallRequest request,
                                       io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse> responseObserver) {
        log.info("音视频通话消息主体数据入参：" + request);
        if(request.getArgs().equals(CommKeys.AVC_SAVE)){
            GroupAudioVideoCallResponse responseResult = serviceApi.saveGroupAudioVideoCallMassage(request);
            responseObserver.onNext(responseResult);
            responseObserver.onCompleted();
            return;
        }

        if (request.getArgs().equals(CommKeys.AVC_SAVE_TO_OFF_USER)){
            GroupAudioVideoCallResponse responseResult = serviceApi.saveCallMsgToOffUser(request);
            responseObserver.onNext(responseResult);
            responseObserver.onCompleted();
            return;
        }
        if (request.getArgs().equals(CommKeys.AVC_PUSH)){
            GroupAudioVideoCallResponse responseResult = serviceApi.pushCallMsgToOffUser(request);
            responseObserver.onNext(responseResult);
            responseObserver.onCompleted();
            return;
        }
        if (request.getArgs().equals(CommKeys.AVC_DEL)){
            GroupAudioVideoCallResponse responseResult = serviceApi.deleteCallMsgToOffUser(request);
            responseObserver.onNext(responseResult);
            responseObserver.onCompleted();
            return;
        }

        if (request.getArgs().equals(CommKeys.ROOM_CLOSED)){
           serviceApi.closeRoomByGroupId(request);
            responseObserver.onCompleted();
            return;
        }

    }
}
