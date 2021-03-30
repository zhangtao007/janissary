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
    public void deleteGroupMembersOffLineMsg(com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGroupMembersOffLineMsgMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDeleteGroupMembersOffLineMsgMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest,
                com.lanjiu.pro.groupStorage.ResponseResult>(
                  this, METHODID_DELETE_GROUP_MEMBERS_OFF_LINE_MSG)))
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
    public void deleteGroupMembersOffLineMsg(com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGroupMembersOffLineMsgMethod(), getCallOptions()), request, responseObserver);
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
    public com.lanjiu.pro.groupStorage.ResponseResult deleteGroupMembersOffLineMsg(com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGroupMembersOffLineMsgMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.groupStorage.ResponseResult> deleteGroupMembersOffLineMsg(
        com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGroupMembersOffLineMsgMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELETE_GROUP_MEMBERS_OFF_LINE_MSG = 0;

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
        case METHODID_DELETE_GROUP_MEMBERS_OFF_LINE_MSG:
          serviceImpl.deleteGroupMembersOffLineMsg((com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.groupStorage.ResponseResult>) responseObserver);
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
              .addMethod(getDeleteGroupMembersOffLineMsgMethod())
              .build();
        }
      }
    }
    return result;
  }
}
