package com.lanjiu.pro.groupStorage;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: message_group_storage_grpc.proto")
public final class MessageGroupStorageServiceGrpc {

  private MessageGroupStorageServiceGrpc() {}

  public static final String SERVICE_NAME = "com.lanjiu.pro.groupStorage.MessageGroupStorageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest,
      com.lanjiu.pro.groupStorage.ResponseResult> getSaveGroupMassageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveGroupMassage",
      requestType = com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest.class,
      responseType = com.lanjiu.pro.groupStorage.ResponseResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest,
      com.lanjiu.pro.groupStorage.ResponseResult> getSaveGroupMassageMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest, com.lanjiu.pro.groupStorage.ResponseResult> getSaveGroupMassageMethod;
    if ((getSaveGroupMassageMethod = MessageGroupStorageServiceGrpc.getSaveGroupMassageMethod) == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        if ((getSaveGroupMassageMethod = MessageGroupStorageServiceGrpc.getSaveGroupMassageMethod) == null) {
          MessageGroupStorageServiceGrpc.getSaveGroupMassageMethod = getSaveGroupMassageMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest, com.lanjiu.pro.groupStorage.ResponseResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "saveGroupMassage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.ResponseResult.getDefaultInstance()))
              .setSchemaDescriptor(new MessageGroupStorageServiceMethodDescriptorSupplier("saveGroupMassage"))
              .build();
        }
      }
    }
    return getSaveGroupMassageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest,
      com.lanjiu.pro.groupStorage.ResponseResult> getSaveGroupMembersOffLineMsgMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveGroupMembersOffLineMsg",
      requestType = com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest.class,
      responseType = com.lanjiu.pro.groupStorage.ResponseResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest,
      com.lanjiu.pro.groupStorage.ResponseResult> getSaveGroupMembersOffLineMsgMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest, com.lanjiu.pro.groupStorage.ResponseResult> getSaveGroupMembersOffLineMsgMethod;
    if ((getSaveGroupMembersOffLineMsgMethod = MessageGroupStorageServiceGrpc.getSaveGroupMembersOffLineMsgMethod) == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        if ((getSaveGroupMembersOffLineMsgMethod = MessageGroupStorageServiceGrpc.getSaveGroupMembersOffLineMsgMethod) == null) {
          MessageGroupStorageServiceGrpc.getSaveGroupMembersOffLineMsgMethod = getSaveGroupMembersOffLineMsgMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest, com.lanjiu.pro.groupStorage.ResponseResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "saveGroupMembersOffLineMsg"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.ResponseResult.getDefaultInstance()))
              .setSchemaDescriptor(new MessageGroupStorageServiceMethodDescriptorSupplier("saveGroupMembersOffLineMsg"))
              .build();
        }
      }
    }
    return getSaveGroupMembersOffLineMsgMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest,
      com.lanjiu.pro.groupStorage.ResponseResult> getDeleteGroupMembersOffLineMsgMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGroupMembersOffLineMsg",
      requestType = com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest.class,
      responseType = com.lanjiu.pro.groupStorage.ResponseResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest,
      com.lanjiu.pro.groupStorage.ResponseResult> getDeleteGroupMembersOffLineMsgMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest, com.lanjiu.pro.groupStorage.ResponseResult> getDeleteGroupMembersOffLineMsgMethod;
    if ((getDeleteGroupMembersOffLineMsgMethod = MessageGroupStorageServiceGrpc.getDeleteGroupMembersOffLineMsgMethod) == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        if ((getDeleteGroupMembersOffLineMsgMethod = MessageGroupStorageServiceGrpc.getDeleteGroupMembersOffLineMsgMethod) == null) {
          MessageGroupStorageServiceGrpc.getDeleteGroupMembersOffLineMsgMethod = getDeleteGroupMembersOffLineMsgMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest, com.lanjiu.pro.groupStorage.ResponseResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGroupMembersOffLineMsg"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.ResponseResult.getDefaultInstance()))
              .setSchemaDescriptor(new MessageGroupStorageServiceMethodDescriptorSupplier("deleteGroupMembersOffLineMsg"))
              .build();
        }
      }
    }
    return getDeleteGroupMembersOffLineMsgMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest,
      com.lanjiu.pro.groupStorage.ResponseCount> getSelectOffLineGroupMsgCountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectOffLineGroupMsgCount",
      requestType = com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest.class,
      responseType = com.lanjiu.pro.groupStorage.ResponseCount.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest,
      com.lanjiu.pro.groupStorage.ResponseCount> getSelectOffLineGroupMsgCountMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest, com.lanjiu.pro.groupStorage.ResponseCount> getSelectOffLineGroupMsgCountMethod;
    if ((getSelectOffLineGroupMsgCountMethod = MessageGroupStorageServiceGrpc.getSelectOffLineGroupMsgCountMethod) == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        if ((getSelectOffLineGroupMsgCountMethod = MessageGroupStorageServiceGrpc.getSelectOffLineGroupMsgCountMethod) == null) {
          MessageGroupStorageServiceGrpc.getSelectOffLineGroupMsgCountMethod = getSelectOffLineGroupMsgCountMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest, com.lanjiu.pro.groupStorage.ResponseCount>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectOffLineGroupMsgCount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.ResponseCount.getDefaultInstance()))
              .setSchemaDescriptor(new MessageGroupStorageServiceMethodDescriptorSupplier("selectOffLineGroupMsgCount"))
              .build();
        }
      }
    }
    return getSelectOffLineGroupMsgCountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest,
      com.lanjiu.pro.groupStorage.ResponseResult> getDeleteSendOffLineMsgMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteSendOffLineMsg",
      requestType = com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest.class,
      responseType = com.lanjiu.pro.groupStorage.ResponseResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest,
      com.lanjiu.pro.groupStorage.ResponseResult> getDeleteSendOffLineMsgMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest, com.lanjiu.pro.groupStorage.ResponseResult> getDeleteSendOffLineMsgMethod;
    if ((getDeleteSendOffLineMsgMethod = MessageGroupStorageServiceGrpc.getDeleteSendOffLineMsgMethod) == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        if ((getDeleteSendOffLineMsgMethod = MessageGroupStorageServiceGrpc.getDeleteSendOffLineMsgMethod) == null) {
          MessageGroupStorageServiceGrpc.getDeleteSendOffLineMsgMethod = getDeleteSendOffLineMsgMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest, com.lanjiu.pro.groupStorage.ResponseResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteSendOffLineMsg"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.ResponseResult.getDefaultInstance()))
              .setSchemaDescriptor(new MessageGroupStorageServiceMethodDescriptorSupplier("deleteSendOffLineMsg"))
              .build();
        }
      }
    }
    return getDeleteSendOffLineMsgMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest,
      com.lanjiu.pro.groupStorage.ResponseResult> getSelectOffLineGroupMsgMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectOffLineGroupMsg",
      requestType = com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest.class,
      responseType = com.lanjiu.pro.groupStorage.ResponseResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest,
      com.lanjiu.pro.groupStorage.ResponseResult> getSelectOffLineGroupMsgMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest, com.lanjiu.pro.groupStorage.ResponseResult> getSelectOffLineGroupMsgMethod;
    if ((getSelectOffLineGroupMsgMethod = MessageGroupStorageServiceGrpc.getSelectOffLineGroupMsgMethod) == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        if ((getSelectOffLineGroupMsgMethod = MessageGroupStorageServiceGrpc.getSelectOffLineGroupMsgMethod) == null) {
          MessageGroupStorageServiceGrpc.getSelectOffLineGroupMsgMethod = getSelectOffLineGroupMsgMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest, com.lanjiu.pro.groupStorage.ResponseResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectOffLineGroupMsg"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.ResponseResult.getDefaultInstance()))
              .setSchemaDescriptor(new MessageGroupStorageServiceMethodDescriptorSupplier("selectOffLineGroupMsg"))
              .build();
        }
      }
    }
    return getSelectOffLineGroupMsgMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest,
      com.lanjiu.pro.groupStorage.ResponseResult> getDeleteGroupMsgMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGroupMsg",
      requestType = com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest.class,
      responseType = com.lanjiu.pro.groupStorage.ResponseResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest,
      com.lanjiu.pro.groupStorage.ResponseResult> getDeleteGroupMsgMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest, com.lanjiu.pro.groupStorage.ResponseResult> getDeleteGroupMsgMethod;
    if ((getDeleteGroupMsgMethod = MessageGroupStorageServiceGrpc.getDeleteGroupMsgMethod) == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        if ((getDeleteGroupMsgMethod = MessageGroupStorageServiceGrpc.getDeleteGroupMsgMethod) == null) {
          MessageGroupStorageServiceGrpc.getDeleteGroupMsgMethod = getDeleteGroupMsgMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest, com.lanjiu.pro.groupStorage.ResponseResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGroupMsg"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.ResponseResult.getDefaultInstance()))
              .setSchemaDescriptor(new MessageGroupStorageServiceMethodDescriptorSupplier("deleteGroupMsg"))
              .build();
        }
      }
    }
    return getDeleteGroupMsgMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest,
      com.lanjiu.pro.groupStorage.ResponseResult> getGroupOwnerExitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "groupOwnerExit",
      requestType = com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest.class,
      responseType = com.lanjiu.pro.groupStorage.ResponseResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest,
      com.lanjiu.pro.groupStorage.ResponseResult> getGroupOwnerExitMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest, com.lanjiu.pro.groupStorage.ResponseResult> getGroupOwnerExitMethod;
    if ((getGroupOwnerExitMethod = MessageGroupStorageServiceGrpc.getGroupOwnerExitMethod) == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        if ((getGroupOwnerExitMethod = MessageGroupStorageServiceGrpc.getGroupOwnerExitMethod) == null) {
          MessageGroupStorageServiceGrpc.getGroupOwnerExitMethod = getGroupOwnerExitMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest, com.lanjiu.pro.groupStorage.ResponseResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "groupOwnerExit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.ResponseResult.getDefaultInstance()))
              .setSchemaDescriptor(new MessageGroupStorageServiceMethodDescriptorSupplier("groupOwnerExit"))
              .build();
        }
      }
    }
    return getGroupOwnerExitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.GroupAudioVideoCallRequest,
      com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse> getGroupAudioAndVideoCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "groupAudioAndVideoCall",
      requestType = com.lanjiu.pro.groupStorage.GroupAudioVideoCallRequest.class,
      responseType = com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.GroupAudioVideoCallRequest,
      com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse> getGroupAudioAndVideoCallMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.groupStorage.GroupAudioVideoCallRequest, com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse> getGroupAudioAndVideoCallMethod;
    if ((getGroupAudioAndVideoCallMethod = MessageGroupStorageServiceGrpc.getGroupAudioAndVideoCallMethod) == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        if ((getGroupAudioAndVideoCallMethod = MessageGroupStorageServiceGrpc.getGroupAudioAndVideoCallMethod) == null) {
          MessageGroupStorageServiceGrpc.getGroupAudioAndVideoCallMethod = getGroupAudioAndVideoCallMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.groupStorage.GroupAudioVideoCallRequest, com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "groupAudioAndVideoCall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.GroupAudioVideoCallRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageGroupStorageServiceMethodDescriptorSupplier("groupAudioAndVideoCall"))
              .build();
        }
      }
    }
    return getGroupAudioAndVideoCallMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessageGroupStorageServiceStub newStub(io.grpc.Channel channel) {
    return new MessageGroupStorageServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessageGroupStorageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MessageGroupStorageServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessageGroupStorageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MessageGroupStorageServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class MessageGroupStorageServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void saveGroupMassage(com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveGroupMassageMethod(), responseObserver);
    }

    /**
     */
    public void saveGroupMembersOffLineMsg(com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveGroupMembersOffLineMsgMethod(), responseObserver);
    }

    /**
     */
    public void deleteGroupMembersOffLineMsg(com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGroupMembersOffLineMsgMethod(), responseObserver);
    }

    /**
     */
    public void selectOffLineGroupMsgCount(com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseCount> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectOffLineGroupMsgCountMethod(), responseObserver);
    }

    /**
     */
    public void deleteSendOffLineMsg(com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteSendOffLineMsgMethod(), responseObserver);
    }

    /**
     */
    public void selectOffLineGroupMsg(com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectOffLineGroupMsgMethod(), responseObserver);
    }

    /**
     */
    public void deleteGroupMsg(com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGroupMsgMethod(), responseObserver);
    }

    /**
     */
    public void groupOwnerExit(com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult> responseObserver) {
      asyncUnimplementedUnaryCall(getGroupOwnerExitMethod(), responseObserver);
    }

    /**
     */
    public void groupAudioAndVideoCall(com.lanjiu.pro.groupStorage.GroupAudioVideoCallRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGroupAudioAndVideoCallMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSaveGroupMassageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest,
                com.lanjiu.pro.groupStorage.ResponseResult>(
                  this, METHODID_SAVE_GROUP_MASSAGE)))
          .addMethod(
            getSaveGroupMembersOffLineMsgMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest,
                com.lanjiu.pro.groupStorage.ResponseResult>(
                  this, METHODID_SAVE_GROUP_MEMBERS_OFF_LINE_MSG)))
          .addMethod(
            getDeleteGroupMembersOffLineMsgMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest,
                com.lanjiu.pro.groupStorage.ResponseResult>(
                  this, METHODID_DELETE_GROUP_MEMBERS_OFF_LINE_MSG)))
          .addMethod(
            getSelectOffLineGroupMsgCountMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest,
                com.lanjiu.pro.groupStorage.ResponseCount>(
                  this, METHODID_SELECT_OFF_LINE_GROUP_MSG_COUNT)))
          .addMethod(
            getDeleteSendOffLineMsgMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest,
                com.lanjiu.pro.groupStorage.ResponseResult>(
                  this, METHODID_DELETE_SEND_OFF_LINE_MSG)))
          .addMethod(
            getSelectOffLineGroupMsgMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest,
                com.lanjiu.pro.groupStorage.ResponseResult>(
                  this, METHODID_SELECT_OFF_LINE_GROUP_MSG)))
          .addMethod(
            getDeleteGroupMsgMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest,
                com.lanjiu.pro.groupStorage.ResponseResult>(
                  this, METHODID_DELETE_GROUP_MSG)))
          .addMethod(
            getGroupOwnerExitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest,
                com.lanjiu.pro.groupStorage.ResponseResult>(
                  this, METHODID_GROUP_OWNER_EXIT)))
          .addMethod(
            getGroupAudioAndVideoCallMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.groupStorage.GroupAudioVideoCallRequest,
                com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse>(
                  this, METHODID_GROUP_AUDIO_AND_VIDEO_CALL)))
          .build();
    }
  }

  /**
   */
  public static final class MessageGroupStorageServiceStub extends io.grpc.stub.AbstractStub<MessageGroupStorageServiceStub> {
    private MessageGroupStorageServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessageGroupStorageServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageGroupStorageServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageGroupStorageServiceStub(channel, callOptions);
    }

    /**
     */
    public void saveGroupMassage(com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveGroupMassageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void saveGroupMembersOffLineMsg(com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveGroupMembersOffLineMsgMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGroupMembersOffLineMsg(com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGroupMembersOffLineMsgMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectOffLineGroupMsgCount(com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseCount> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectOffLineGroupMsgCountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteSendOffLineMsg(com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteSendOffLineMsgMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectOffLineGroupMsg(com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectOffLineGroupMsgMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGroupMsg(com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGroupMsgMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void groupOwnerExit(com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGroupOwnerExitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void groupAudioAndVideoCall(com.lanjiu.pro.groupStorage.GroupAudioVideoCallRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGroupAudioAndVideoCallMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MessageGroupStorageServiceBlockingStub extends io.grpc.stub.AbstractStub<MessageGroupStorageServiceBlockingStub> {
    private MessageGroupStorageServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessageGroupStorageServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageGroupStorageServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageGroupStorageServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.lanjiu.pro.groupStorage.ResponseResult saveGroupMassage(com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest request) {
      return blockingUnaryCall(
          getChannel(), getSaveGroupMassageMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.groupStorage.ResponseResult saveGroupMembersOffLineMsg(com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest request) {
      return blockingUnaryCall(
          getChannel(), getSaveGroupMembersOffLineMsgMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.groupStorage.ResponseResult deleteGroupMembersOffLineMsg(com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGroupMembersOffLineMsgMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.groupStorage.ResponseCount selectOffLineGroupMsgCount(com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectOffLineGroupMsgCountMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.groupStorage.ResponseResult deleteSendOffLineMsg(com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteSendOffLineMsgMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.groupStorage.ResponseResult selectOffLineGroupMsg(com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectOffLineGroupMsgMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.groupStorage.ResponseResult deleteGroupMsg(com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGroupMsgMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.groupStorage.ResponseResult groupOwnerExit(com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest request) {
      return blockingUnaryCall(
          getChannel(), getGroupOwnerExitMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse groupAudioAndVideoCall(com.lanjiu.pro.groupStorage.GroupAudioVideoCallRequest request) {
      return blockingUnaryCall(
          getChannel(), getGroupAudioAndVideoCallMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MessageGroupStorageServiceFutureStub extends io.grpc.stub.AbstractStub<MessageGroupStorageServiceFutureStub> {
    private MessageGroupStorageServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessageGroupStorageServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageGroupStorageServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageGroupStorageServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.groupStorage.ResponseResult> saveGroupMassage(
        com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveGroupMassageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.groupStorage.ResponseResult> saveGroupMembersOffLineMsg(
        com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveGroupMembersOffLineMsgMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.groupStorage.ResponseResult> deleteGroupMembersOffLineMsg(
        com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGroupMembersOffLineMsgMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.groupStorage.ResponseCount> selectOffLineGroupMsgCount(
        com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectOffLineGroupMsgCountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.groupStorage.ResponseResult> deleteSendOffLineMsg(
        com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteSendOffLineMsgMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.groupStorage.ResponseResult> selectOffLineGroupMsg(
        com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectOffLineGroupMsgMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.groupStorage.ResponseResult> deleteGroupMsg(
        com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGroupMsgMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.groupStorage.ResponseResult> groupOwnerExit(
        com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGroupOwnerExitMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse> groupAudioAndVideoCall(
        com.lanjiu.pro.groupStorage.GroupAudioVideoCallRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGroupAudioAndVideoCallMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAVE_GROUP_MASSAGE = 0;
  private static final int METHODID_SAVE_GROUP_MEMBERS_OFF_LINE_MSG = 1;
  private static final int METHODID_DELETE_GROUP_MEMBERS_OFF_LINE_MSG = 2;
  private static final int METHODID_SELECT_OFF_LINE_GROUP_MSG_COUNT = 3;
  private static final int METHODID_DELETE_SEND_OFF_LINE_MSG = 4;
  private static final int METHODID_SELECT_OFF_LINE_GROUP_MSG = 5;
  private static final int METHODID_DELETE_GROUP_MSG = 6;
  private static final int METHODID_GROUP_OWNER_EXIT = 7;
  private static final int METHODID_GROUP_AUDIO_AND_VIDEO_CALL = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessageGroupStorageServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MessageGroupStorageServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAVE_GROUP_MASSAGE:
          serviceImpl.saveGroupMassage((com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult>) responseObserver);
          break;
        case METHODID_SAVE_GROUP_MEMBERS_OFF_LINE_MSG:
          serviceImpl.saveGroupMembersOffLineMsg((com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult>) responseObserver);
          break;
        case METHODID_DELETE_GROUP_MEMBERS_OFF_LINE_MSG:
          serviceImpl.deleteGroupMembersOffLineMsg((com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult>) responseObserver);
          break;
        case METHODID_SELECT_OFF_LINE_GROUP_MSG_COUNT:
          serviceImpl.selectOffLineGroupMsgCount((com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseCount>) responseObserver);
          break;
        case METHODID_DELETE_SEND_OFF_LINE_MSG:
          serviceImpl.deleteSendOffLineMsg((com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult>) responseObserver);
          break;
        case METHODID_SELECT_OFF_LINE_GROUP_MSG:
          serviceImpl.selectOffLineGroupMsg((com.lanjiu.pro.groupStorage.SelectOffLineGroupMsgRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult>) responseObserver);
          break;
        case METHODID_DELETE_GROUP_MSG:
          serviceImpl.deleteGroupMsg((com.lanjiu.pro.groupStorage.GroupMsgOffLineRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult>) responseObserver);
          break;
        case METHODID_GROUP_OWNER_EXIT:
          serviceImpl.groupOwnerExit((com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult>) responseObserver);
          break;
        case METHODID_GROUP_AUDIO_AND_VIDEO_CALL:
          serviceImpl.groupAudioAndVideoCall((com.lanjiu.pro.groupStorage.GroupAudioVideoCallRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MessageGroupStorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessageGroupStorageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.lanjiu.pro.groupStorage.MessageGroupStorageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MessageGroupStorageService");
    }
  }

  private static final class MessageGroupStorageServiceFileDescriptorSupplier
      extends MessageGroupStorageServiceBaseDescriptorSupplier {
    MessageGroupStorageServiceFileDescriptorSupplier() {}
  }

  private static final class MessageGroupStorageServiceMethodDescriptorSupplier
      extends MessageGroupStorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MessageGroupStorageServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessageGroupStorageServiceFileDescriptorSupplier())
              .addMethod(getSaveGroupMassageMethod())
              .addMethod(getSaveGroupMembersOffLineMsgMethod())
              .addMethod(getDeleteGroupMembersOffLineMsgMethod())
              .addMethod(getSelectOffLineGroupMsgCountMethod())
              .addMethod(getDeleteSendOffLineMsgMethod())
              .addMethod(getSelectOffLineGroupMsgMethod())
              .addMethod(getDeleteGroupMsgMethod())
              .addMethod(getGroupOwnerExitMethod())
              .addMethod(getGroupAudioAndVideoCallMethod())
              .build();
        }
      }
    }
    return result;
  }
}
