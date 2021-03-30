package com.lanjiu.im.grpc.server.impl;

import com.lanjiu.im.grpc.server.create.StorageFriendMessageAPI;
import com.lanjiu.im.grpc.server.delete.RemoveFriendMessageAPI;
import com.lanjiu.im.grpc.server.select.SelectFriendmessageAPI;
import com.lanjiu.im.storage.utils.ConstType;
import com.lanjiu.pro.friend_msg.AudioAndVideoCallResponse;
import com.lanjiu.pro.friend_msg.MessageFriendServiceGrpc;
import com.lanjiu.pro.friend_msg.RequestFriendMessage;
import com.lanjiu.pro.friend_msg.ResponseFriendMessage;

public class MessageFriendServiceGrpcImpl extends MessageFriendServiceGrpc.MessageFriendServiceImplBase{


    @Override
    public void storageFriendMessage(RequestFriendMessage request,
                                     io.grpc.stub.StreamObserver<ResponseFriendMessage> responseObserver) {

        StorageFriendMessageAPI msgFriendStorageAPI = new StorageFriendMessageAPI();
        ResponseFriendMessage responseFriendMessage = msgFriendStorageAPI.storageFriendMessageOff(request);
        responseObserver.onNext(responseFriendMessage);
        responseObserver.onCompleted();


    }

    @Override
    public void removeFriendMessage(RequestFriendMessage request,
                                    io.grpc.stub.StreamObserver<ResponseFriendMessage> responseObserver) {

        RemoveFriendMessageAPI msgFriendStorageAPI = new RemoveFriendMessageAPI();
        ResponseFriendMessage responseFriendMessage = msgFriendStorageAPI.removeFriendMessageOff(request);
        responseObserver.onNext(responseFriendMessage);
        responseObserver.onCompleted();

    }

    @Override
    public void selectFriendMessage(RequestFriendMessage request,
                                    io.grpc.stub.StreamObserver<ResponseFriendMessage> responseObserver) {
        SelectFriendmessageAPI msgFriendStorageAPI = new SelectFriendmessageAPI();
        ResponseFriendMessage responseFriendMessage = msgFriendStorageAPI.selectFriendMessageOff(request);
        responseObserver.onNext(responseFriendMessage);
        responseObserver.onCompleted();
    }




    @Override
    public void audioAndVideoCallMessage(com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest request,
                                         io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.AudioAndVideoCallResponse> responseObserver) {
        AudioAndVideoCallResponse audioAndVideoCallResponse=null;
        if(request.getArgs().equals(ConstType.AVC_STORAGE)){
            StorageFriendMessageAPI msgFriendStorageAPI = new StorageFriendMessageAPI();
            audioAndVideoCallResponse = msgFriendStorageAPI.audioAndVideoCallMessage(request);
            responseObserver.onNext(audioAndVideoCallResponse);
            responseObserver.onCompleted();
            return;
        }
        if (request.getArgs().equals(ConstType.AVC_GET)){
            SelectFriendmessageAPI  selectFriendmessageAPI = new SelectFriendmessageAPI();
            audioAndVideoCallResponse = selectFriendmessageAPI.getAudioAndVideoMessage(request);
            responseObserver.onNext(audioAndVideoCallResponse);
            responseObserver.onCompleted();
            return;
         }
         if (request.getArgs().equals(ConstType.AVC_REMOVE)){
             RemoveFriendMessageAPI removeFriendMessageAPI = new  RemoveFriendMessageAPI();
             audioAndVideoCallResponse = removeFriendMessageAPI.removeAudioAndVideoMessage(request);
             responseObserver.onNext(audioAndVideoCallResponse);
             responseObserver.onCompleted();
             return;
         }

        if (request.getArgs().equals(ConstType.ROOM_CLOSE)){
            RemoveFriendMessageAPI removeFriendMessageAPI = new  RemoveFriendMessageAPI();
            removeFriendMessageAPI.closeRoomByRoomId(request);
            responseObserver.onCompleted();
            return;
        }



    }






}
