package com.lanjiu.im.grpc;

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
    comments = "Source: information_other_storage_grpc.proto")
public final class InformationStorageServiceGrpc {

  private InformationStorageServiceGrpc() {}

  public static final String SERVICE_NAME = "com.lanjiu.im.grpc.InformationStorageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest,
      com.lanjiu.im.grpc.InformationStorageProto.AllGroupsMemberResponse> getDeleteGuestRelatedAllInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGuestRelatedAllInfo",
      requestType = com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.InformationStorageProto.AllGroupsMemberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest,
      com.lanjiu.im.grpc.InformationStorageProto.AllGroupsMemberResponse> getDeleteGuestRelatedAllInfoMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest, com.lanjiu.im.grpc.InformationStorageProto.AllGroupsMemberResponse> getDeleteGuestRelatedAllInfoMethod;
    if ((getDeleteGuestRelatedAllInfoMethod = InformationStorageServiceGrpc.getDeleteGuestRelatedAllInfoMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteGuestRelatedAllInfoMethod = InformationStorageServiceGrpc.getDeleteGuestRelatedAllInfoMethod) == null) {
          InformationStorageServiceGrpc.getDeleteGuestRelatedAllInfoMethod = getDeleteGuestRelatedAllInfoMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest, com.lanjiu.im.grpc.InformationStorageProto.AllGroupsMemberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGuestRelatedAllInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.InformationStorageProto.AllGroupsMemberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteGuestRelatedAllInfo"))
              .build();
        }
      }
    }
    return getDeleteGuestRelatedAllInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest,
      com.lanjiu.im.grpc.InformationStorageProto.RpcRegisteredUserFriend> getQueryUserFriendRelationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "queryUserFriendRelation",
      requestType = com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.InformationStorageProto.RpcRegisteredUserFriend.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest,
      com.lanjiu.im.grpc.InformationStorageProto.RpcRegisteredUserFriend> getQueryUserFriendRelationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest, com.lanjiu.im.grpc.InformationStorageProto.RpcRegisteredUserFriend> getQueryUserFriendRelationMethod;
    if ((getQueryUserFriendRelationMethod = InformationStorageServiceGrpc.getQueryUserFriendRelationMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getQueryUserFriendRelationMethod = InformationStorageServiceGrpc.getQueryUserFriendRelationMethod) == null) {
          InformationStorageServiceGrpc.getQueryUserFriendRelationMethod = getQueryUserFriendRelationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest, com.lanjiu.im.grpc.InformationStorageProto.RpcRegisteredUserFriend>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "queryUserFriendRelation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.InformationStorageProto.RpcRegisteredUserFriend.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("queryUserFriendRelation"))
              .build();
        }
      }
    }
    return getQueryUserFriendRelationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InformationStorageServiceStub newStub(io.grpc.Channel channel) {
    return new InformationStorageServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InformationStorageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new InformationStorageServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InformationStorageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new InformationStorageServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class InformationStorageServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void deleteGuestRelatedAllInfo(com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.InformationStorageProto.AllGroupsMemberResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGuestRelatedAllInfoMethod(), responseObserver);
    }

    /**
     */
    public void queryUserFriendRelation(com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.InformationStorageProto.RpcRegisteredUserFriend> responseObserver) {
      asyncUnimplementedUnaryCall(getQueryUserFriendRelationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDeleteGuestRelatedAllInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest,
                com.lanjiu.im.grpc.InformationStorageProto.AllGroupsMemberResponse>(
                  this, METHODID_DELETE_GUEST_RELATED_ALL_INFO)))
          .addMethod(
            getQueryUserFriendRelationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest,
                com.lanjiu.im.grpc.InformationStorageProto.RpcRegisteredUserFriend>(
                  this, METHODID_QUERY_USER_FRIEND_RELATION)))
          .build();
    }
  }

  /**
   */
  public static final class InformationStorageServiceStub extends io.grpc.stub.AbstractStub<InformationStorageServiceStub> {
    private InformationStorageServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InformationStorageServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InformationStorageServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InformationStorageServiceStub(channel, callOptions);
    }

    /**
     */
    public void deleteGuestRelatedAllInfo(com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.InformationStorageProto.AllGroupsMemberResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGuestRelatedAllInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void queryUserFriendRelation(com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.InformationStorageProto.RpcRegisteredUserFriend> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getQueryUserFriendRelationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class InformationStorageServiceBlockingStub extends io.grpc.stub.AbstractStub<InformationStorageServiceBlockingStub> {
    private InformationStorageServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InformationStorageServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InformationStorageServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InformationStorageServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.lanjiu.im.grpc.InformationStorageProto.AllGroupsMemberResponse deleteGuestRelatedAllInfo(com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGuestRelatedAllInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.InformationStorageProto.RpcRegisteredUserFriend queryUserFriendRelation(com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getQueryUserFriendRelationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class InformationStorageServiceFutureStub extends io.grpc.stub.AbstractStub<InformationStorageServiceFutureStub> {
    private InformationStorageServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InformationStorageServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InformationStorageServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InformationStorageServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.InformationStorageProto.AllGroupsMemberResponse> deleteGuestRelatedAllInfo(
        com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGuestRelatedAllInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.InformationStorageProto.RpcRegisteredUserFriend> queryUserFriendRelation(
        com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getQueryUserFriendRelationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELETE_GUEST_RELATED_ALL_INFO = 0;
  private static final int METHODID_QUERY_USER_FRIEND_RELATION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final InformationStorageServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(InformationStorageServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DELETE_GUEST_RELATED_ALL_INFO:
          serviceImpl.deleteGuestRelatedAllInfo((com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.InformationStorageProto.AllGroupsMemberResponse>) responseObserver);
          break;
        case METHODID_QUERY_USER_FRIEND_RELATION:
          serviceImpl.queryUserFriendRelation((com.lanjiu.im.grpc.InformationStorageProto.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.InformationStorageProto.RpcRegisteredUserFriend>) responseObserver);
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

  private static abstract class InformationStorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InformationStorageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.lanjiu.im.grpc.InformationStorageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InformationStorageService");
    }
  }

  private static final class InformationStorageServiceFileDescriptorSupplier
      extends InformationStorageServiceBaseDescriptorSupplier {
    InformationStorageServiceFileDescriptorSupplier() {}
  }

  private static final class InformationStorageServiceMethodDescriptorSupplier
      extends InformationStorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    InformationStorageServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (InformationStorageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InformationStorageServiceFileDescriptorSupplier())
              .addMethod(getDeleteGuestRelatedAllInfoMethod())
              .addMethod(getQueryUserFriendRelationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
