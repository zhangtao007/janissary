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
public final class FileStorageServiceGrpc {

  private FileStorageServiceGrpc() {}

  public static final String SERVICE_NAME = "com.lanjiu.im.grpc.FileStorageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.FriendsTransmissionRequest,
      com.lanjiu.im.grpc.FriendsTransmissionResponse> getStorageFileInformationWithFriendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "storageFileInformationWithFriend",
      requestType = com.lanjiu.im.grpc.FriendsTransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.FriendsTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.FriendsTransmissionRequest,
      com.lanjiu.im.grpc.FriendsTransmissionResponse> getStorageFileInformationWithFriendMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.FriendsTransmissionRequest, com.lanjiu.im.grpc.FriendsTransmissionResponse> getStorageFileInformationWithFriendMethod;
    if ((getStorageFileInformationWithFriendMethod = FileStorageServiceGrpc.getStorageFileInformationWithFriendMethod) == null) {
      synchronized (FileStorageServiceGrpc.class) {
        if ((getStorageFileInformationWithFriendMethod = FileStorageServiceGrpc.getStorageFileInformationWithFriendMethod) == null) {
          FileStorageServiceGrpc.getStorageFileInformationWithFriendMethod = getStorageFileInformationWithFriendMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.FriendsTransmissionRequest, com.lanjiu.im.grpc.FriendsTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "storageFileInformationWithFriend"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.FriendsTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.FriendsTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FileStorageServiceMethodDescriptorSupplier("storageFileInformationWithFriend"))
              .build();
        }
      }
    }
    return getStorageFileInformationWithFriendMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.GroupTransmissionRequest,
      com.lanjiu.im.grpc.GroupTransmissionResponse> getStorageFileInformationWithGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "storageFileInformationWithGroup",
      requestType = com.lanjiu.im.grpc.GroupTransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GroupTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.GroupTransmissionRequest,
      com.lanjiu.im.grpc.GroupTransmissionResponse> getStorageFileInformationWithGroupMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.GroupTransmissionRequest, com.lanjiu.im.grpc.GroupTransmissionResponse> getStorageFileInformationWithGroupMethod;
    if ((getStorageFileInformationWithGroupMethod = FileStorageServiceGrpc.getStorageFileInformationWithGroupMethod) == null) {
      synchronized (FileStorageServiceGrpc.class) {
        if ((getStorageFileInformationWithGroupMethod = FileStorageServiceGrpc.getStorageFileInformationWithGroupMethod) == null) {
          FileStorageServiceGrpc.getStorageFileInformationWithGroupMethod = getStorageFileInformationWithGroupMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.GroupTransmissionRequest, com.lanjiu.im.grpc.GroupTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "storageFileInformationWithGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GroupTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GroupTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FileStorageServiceMethodDescriptorSupplier("storageFileInformationWithGroup"))
              .build();
        }
      }
    }
    return getStorageFileInformationWithGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.FriendsTransmissionRequest,
      com.lanjiu.im.grpc.FriendsTransmissionResponse> getDeleteFileInformationWithFriendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteFileInformationWithFriend",
      requestType = com.lanjiu.im.grpc.FriendsTransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.FriendsTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.FriendsTransmissionRequest,
      com.lanjiu.im.grpc.FriendsTransmissionResponse> getDeleteFileInformationWithFriendMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.FriendsTransmissionRequest, com.lanjiu.im.grpc.FriendsTransmissionResponse> getDeleteFileInformationWithFriendMethod;
    if ((getDeleteFileInformationWithFriendMethod = FileStorageServiceGrpc.getDeleteFileInformationWithFriendMethod) == null) {
      synchronized (FileStorageServiceGrpc.class) {
        if ((getDeleteFileInformationWithFriendMethod = FileStorageServiceGrpc.getDeleteFileInformationWithFriendMethod) == null) {
          FileStorageServiceGrpc.getDeleteFileInformationWithFriendMethod = getDeleteFileInformationWithFriendMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.FriendsTransmissionRequest, com.lanjiu.im.grpc.FriendsTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteFileInformationWithFriend"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.FriendsTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.FriendsTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FileStorageServiceMethodDescriptorSupplier("deleteFileInformationWithFriend"))
              .build();
        }
      }
    }
    return getDeleteFileInformationWithFriendMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.FriendsTransmissionRequest,
      com.lanjiu.im.grpc.FriendsTransmissionResponse> getDeleteFileInformationWithFriendByFriendIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteFileInformationWithFriendByFriendId",
      requestType = com.lanjiu.im.grpc.FriendsTransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.FriendsTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.FriendsTransmissionRequest,
      com.lanjiu.im.grpc.FriendsTransmissionResponse> getDeleteFileInformationWithFriendByFriendIdMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.FriendsTransmissionRequest, com.lanjiu.im.grpc.FriendsTransmissionResponse> getDeleteFileInformationWithFriendByFriendIdMethod;
    if ((getDeleteFileInformationWithFriendByFriendIdMethod = FileStorageServiceGrpc.getDeleteFileInformationWithFriendByFriendIdMethod) == null) {
      synchronized (FileStorageServiceGrpc.class) {
        if ((getDeleteFileInformationWithFriendByFriendIdMethod = FileStorageServiceGrpc.getDeleteFileInformationWithFriendByFriendIdMethod) == null) {
          FileStorageServiceGrpc.getDeleteFileInformationWithFriendByFriendIdMethod = getDeleteFileInformationWithFriendByFriendIdMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.FriendsTransmissionRequest, com.lanjiu.im.grpc.FriendsTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteFileInformationWithFriendByFriendId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.FriendsTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.FriendsTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FileStorageServiceMethodDescriptorSupplier("deleteFileInformationWithFriendByFriendId"))
              .build();
        }
      }
    }
    return getDeleteFileInformationWithFriendByFriendIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.GroupTransmissionRequest,
      com.lanjiu.im.grpc.GroupTransmissionResponse> getDeleteFileInformationWithGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteFileInformationWithGroup",
      requestType = com.lanjiu.im.grpc.GroupTransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GroupTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.GroupTransmissionRequest,
      com.lanjiu.im.grpc.GroupTransmissionResponse> getDeleteFileInformationWithGroupMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.GroupTransmissionRequest, com.lanjiu.im.grpc.GroupTransmissionResponse> getDeleteFileInformationWithGroupMethod;
    if ((getDeleteFileInformationWithGroupMethod = FileStorageServiceGrpc.getDeleteFileInformationWithGroupMethod) == null) {
      synchronized (FileStorageServiceGrpc.class) {
        if ((getDeleteFileInformationWithGroupMethod = FileStorageServiceGrpc.getDeleteFileInformationWithGroupMethod) == null) {
          FileStorageServiceGrpc.getDeleteFileInformationWithGroupMethod = getDeleteFileInformationWithGroupMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.GroupTransmissionRequest, com.lanjiu.im.grpc.GroupTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteFileInformationWithGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GroupTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GroupTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FileStorageServiceMethodDescriptorSupplier("deleteFileInformationWithGroup"))
              .build();
        }
      }
    }
    return getDeleteFileInformationWithGroupMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FileStorageServiceStub newStub(io.grpc.Channel channel) {
    return new FileStorageServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FileStorageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FileStorageServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FileStorageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FileStorageServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FileStorageServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void storageFileInformationWithFriend(com.lanjiu.im.grpc.FriendsTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.FriendsTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStorageFileInformationWithFriendMethod(), responseObserver);
    }

    /**
     */
    public void storageFileInformationWithGroup(com.lanjiu.im.grpc.GroupTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStorageFileInformationWithGroupMethod(), responseObserver);
    }

    /**
     */
    public void deleteFileInformationWithFriend(com.lanjiu.im.grpc.FriendsTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.FriendsTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteFileInformationWithFriendMethod(), responseObserver);
    }

    /**
     */
    public void deleteFileInformationWithFriendByFriendId(com.lanjiu.im.grpc.FriendsTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.FriendsTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteFileInformationWithFriendByFriendIdMethod(), responseObserver);
    }

    /**
     */
    public void deleteFileInformationWithGroup(com.lanjiu.im.grpc.GroupTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteFileInformationWithGroupMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStorageFileInformationWithFriendMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.FriendsTransmissionRequest,
                com.lanjiu.im.grpc.FriendsTransmissionResponse>(
                  this, METHODID_STORAGE_FILE_INFORMATION_WITH_FRIEND)))
          .addMethod(
            getStorageFileInformationWithGroupMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.GroupTransmissionRequest,
                com.lanjiu.im.grpc.GroupTransmissionResponse>(
                  this, METHODID_STORAGE_FILE_INFORMATION_WITH_GROUP)))
          .addMethod(
            getDeleteFileInformationWithFriendMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.FriendsTransmissionRequest,
                com.lanjiu.im.grpc.FriendsTransmissionResponse>(
                  this, METHODID_DELETE_FILE_INFORMATION_WITH_FRIEND)))
          .addMethod(
            getDeleteFileInformationWithFriendByFriendIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.FriendsTransmissionRequest,
                com.lanjiu.im.grpc.FriendsTransmissionResponse>(
                  this, METHODID_DELETE_FILE_INFORMATION_WITH_FRIEND_BY_FRIEND_ID)))
          .addMethod(
            getDeleteFileInformationWithGroupMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.GroupTransmissionRequest,
                com.lanjiu.im.grpc.GroupTransmissionResponse>(
                  this, METHODID_DELETE_FILE_INFORMATION_WITH_GROUP)))
          .build();
    }
  }

  /**
   */
  public static final class FileStorageServiceStub extends io.grpc.stub.AbstractStub<FileStorageServiceStub> {
    private FileStorageServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileStorageServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileStorageServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileStorageServiceStub(channel, callOptions);
    }

    /**
     */
    public void storageFileInformationWithFriend(com.lanjiu.im.grpc.FriendsTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.FriendsTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStorageFileInformationWithFriendMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void storageFileInformationWithGroup(com.lanjiu.im.grpc.GroupTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStorageFileInformationWithGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteFileInformationWithFriend(com.lanjiu.im.grpc.FriendsTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.FriendsTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteFileInformationWithFriendMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteFileInformationWithFriendByFriendId(com.lanjiu.im.grpc.FriendsTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.FriendsTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteFileInformationWithFriendByFriendIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteFileInformationWithGroup(com.lanjiu.im.grpc.GroupTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteFileInformationWithGroupMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FileStorageServiceBlockingStub extends io.grpc.stub.AbstractStub<FileStorageServiceBlockingStub> {
    private FileStorageServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileStorageServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileStorageServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileStorageServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.lanjiu.im.grpc.FriendsTransmissionResponse storageFileInformationWithFriend(com.lanjiu.im.grpc.FriendsTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getStorageFileInformationWithFriendMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GroupTransmissionResponse storageFileInformationWithGroup(com.lanjiu.im.grpc.GroupTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getStorageFileInformationWithGroupMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.FriendsTransmissionResponse deleteFileInformationWithFriend(com.lanjiu.im.grpc.FriendsTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteFileInformationWithFriendMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.FriendsTransmissionResponse deleteFileInformationWithFriendByFriendId(com.lanjiu.im.grpc.FriendsTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteFileInformationWithFriendByFriendIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GroupTransmissionResponse deleteFileInformationWithGroup(com.lanjiu.im.grpc.GroupTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteFileInformationWithGroupMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FileStorageServiceFutureStub extends io.grpc.stub.AbstractStub<FileStorageServiceFutureStub> {
    private FileStorageServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileStorageServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileStorageServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileStorageServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.FriendsTransmissionResponse> storageFileInformationWithFriend(
        com.lanjiu.im.grpc.FriendsTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStorageFileInformationWithFriendMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GroupTransmissionResponse> storageFileInformationWithGroup(
        com.lanjiu.im.grpc.GroupTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStorageFileInformationWithGroupMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.FriendsTransmissionResponse> deleteFileInformationWithFriend(
        com.lanjiu.im.grpc.FriendsTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteFileInformationWithFriendMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.FriendsTransmissionResponse> deleteFileInformationWithFriendByFriendId(
        com.lanjiu.im.grpc.FriendsTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteFileInformationWithFriendByFriendIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GroupTransmissionResponse> deleteFileInformationWithGroup(
        com.lanjiu.im.grpc.GroupTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteFileInformationWithGroupMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STORAGE_FILE_INFORMATION_WITH_FRIEND = 0;
  private static final int METHODID_STORAGE_FILE_INFORMATION_WITH_GROUP = 1;
  private static final int METHODID_DELETE_FILE_INFORMATION_WITH_FRIEND = 2;
  private static final int METHODID_DELETE_FILE_INFORMATION_WITH_FRIEND_BY_FRIEND_ID = 3;
  private static final int METHODID_DELETE_FILE_INFORMATION_WITH_GROUP = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FileStorageServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FileStorageServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STORAGE_FILE_INFORMATION_WITH_FRIEND:
          serviceImpl.storageFileInformationWithFriend((com.lanjiu.im.grpc.FriendsTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.FriendsTransmissionResponse>) responseObserver);
          break;
        case METHODID_STORAGE_FILE_INFORMATION_WITH_GROUP:
          serviceImpl.storageFileInformationWithGroup((com.lanjiu.im.grpc.GroupTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupTransmissionResponse>) responseObserver);
          break;
        case METHODID_DELETE_FILE_INFORMATION_WITH_FRIEND:
          serviceImpl.deleteFileInformationWithFriend((com.lanjiu.im.grpc.FriendsTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.FriendsTransmissionResponse>) responseObserver);
          break;
        case METHODID_DELETE_FILE_INFORMATION_WITH_FRIEND_BY_FRIEND_ID:
          serviceImpl.deleteFileInformationWithFriendByFriendId((com.lanjiu.im.grpc.FriendsTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.FriendsTransmissionResponse>) responseObserver);
          break;
        case METHODID_DELETE_FILE_INFORMATION_WITH_GROUP:
          serviceImpl.deleteFileInformationWithGroup((com.lanjiu.im.grpc.GroupTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupTransmissionResponse>) responseObserver);
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

  private static abstract class FileStorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FileStorageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.lanjiu.im.grpc.FileStorageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FileStorageService");
    }
  }

  private static final class FileStorageServiceFileDescriptorSupplier
      extends FileStorageServiceBaseDescriptorSupplier {
    FileStorageServiceFileDescriptorSupplier() {}
  }

  private static final class FileStorageServiceMethodDescriptorSupplier
      extends FileStorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FileStorageServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FileStorageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FileStorageServiceFileDescriptorSupplier())
              .addMethod(getStorageFileInformationWithFriendMethod())
              .addMethod(getStorageFileInformationWithGroupMethod())
              .addMethod(getDeleteFileInformationWithFriendMethod())
              .addMethod(getDeleteFileInformationWithFriendByFriendIdMethod())
              .addMethod(getDeleteFileInformationWithGroupMethod())
              .build();
        }
      }
    }
    return result;
  }
}
