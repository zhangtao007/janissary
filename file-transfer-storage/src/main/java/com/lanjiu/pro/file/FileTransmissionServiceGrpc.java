package com.lanjiu.pro.file;

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
    comments = "Source: file_transfer_communication_grpc.proto")
public final class FileTransmissionServiceGrpc {

  private FileTransmissionServiceGrpc() {}

  public static final String SERVICE_NAME = "com.lanjiu.pro.file.FileTransmissionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.file.FriendsTransmissionRequest,
      com.lanjiu.pro.file.FriendsTransmissionResponse> getOriginalFriendsTransmissionUploadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OriginalFriendsTransmissionUpload",
      requestType = com.lanjiu.pro.file.FriendsTransmissionRequest.class,
      responseType = com.lanjiu.pro.file.FriendsTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.file.FriendsTransmissionRequest,
      com.lanjiu.pro.file.FriendsTransmissionResponse> getOriginalFriendsTransmissionUploadMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.file.FriendsTransmissionRequest, com.lanjiu.pro.file.FriendsTransmissionResponse> getOriginalFriendsTransmissionUploadMethod;
    if ((getOriginalFriendsTransmissionUploadMethod = FileTransmissionServiceGrpc.getOriginalFriendsTransmissionUploadMethod) == null) {
      synchronized (FileTransmissionServiceGrpc.class) {
        if ((getOriginalFriendsTransmissionUploadMethod = FileTransmissionServiceGrpc.getOriginalFriendsTransmissionUploadMethod) == null) {
          FileTransmissionServiceGrpc.getOriginalFriendsTransmissionUploadMethod = getOriginalFriendsTransmissionUploadMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.file.FriendsTransmissionRequest, com.lanjiu.pro.file.FriendsTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OriginalFriendsTransmissionUpload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.file.FriendsTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.file.FriendsTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FileTransmissionServiceMethodDescriptorSupplier("OriginalFriendsTransmissionUpload"))
              .build();
        }
      }
    }
    return getOriginalFriendsTransmissionUploadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.file.FriendsTransmissionRequest,
      com.lanjiu.pro.file.FriendsTransmissionResponse> getOriginalFriendsTransmissionDownloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OriginalFriendsTransmissionDownload",
      requestType = com.lanjiu.pro.file.FriendsTransmissionRequest.class,
      responseType = com.lanjiu.pro.file.FriendsTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.file.FriendsTransmissionRequest,
      com.lanjiu.pro.file.FriendsTransmissionResponse> getOriginalFriendsTransmissionDownloadMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.file.FriendsTransmissionRequest, com.lanjiu.pro.file.FriendsTransmissionResponse> getOriginalFriendsTransmissionDownloadMethod;
    if ((getOriginalFriendsTransmissionDownloadMethod = FileTransmissionServiceGrpc.getOriginalFriendsTransmissionDownloadMethod) == null) {
      synchronized (FileTransmissionServiceGrpc.class) {
        if ((getOriginalFriendsTransmissionDownloadMethod = FileTransmissionServiceGrpc.getOriginalFriendsTransmissionDownloadMethod) == null) {
          FileTransmissionServiceGrpc.getOriginalFriendsTransmissionDownloadMethod = getOriginalFriendsTransmissionDownloadMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.file.FriendsTransmissionRequest, com.lanjiu.pro.file.FriendsTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OriginalFriendsTransmissionDownload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.file.FriendsTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.file.FriendsTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FileTransmissionServiceMethodDescriptorSupplier("OriginalFriendsTransmissionDownload"))
              .build();
        }
      }
    }
    return getOriginalFriendsTransmissionDownloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.file.GroupTransmissionRequest,
      com.lanjiu.pro.file.GroupTransmissionResponse> getOriginalGroupTransmissionUploadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OriginalGroupTransmissionUpload",
      requestType = com.lanjiu.pro.file.GroupTransmissionRequest.class,
      responseType = com.lanjiu.pro.file.GroupTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.file.GroupTransmissionRequest,
      com.lanjiu.pro.file.GroupTransmissionResponse> getOriginalGroupTransmissionUploadMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.file.GroupTransmissionRequest, com.lanjiu.pro.file.GroupTransmissionResponse> getOriginalGroupTransmissionUploadMethod;
    if ((getOriginalGroupTransmissionUploadMethod = FileTransmissionServiceGrpc.getOriginalGroupTransmissionUploadMethod) == null) {
      synchronized (FileTransmissionServiceGrpc.class) {
        if ((getOriginalGroupTransmissionUploadMethod = FileTransmissionServiceGrpc.getOriginalGroupTransmissionUploadMethod) == null) {
          FileTransmissionServiceGrpc.getOriginalGroupTransmissionUploadMethod = getOriginalGroupTransmissionUploadMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.file.GroupTransmissionRequest, com.lanjiu.pro.file.GroupTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OriginalGroupTransmissionUpload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.file.GroupTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.file.GroupTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FileTransmissionServiceMethodDescriptorSupplier("OriginalGroupTransmissionUpload"))
              .build();
        }
      }
    }
    return getOriginalGroupTransmissionUploadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.file.GroupTransmissionRequest,
      com.lanjiu.pro.file.GroupTransmissionResponse> getOriginalGroupTransmissionDownloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OriginalGroupTransmissionDownload",
      requestType = com.lanjiu.pro.file.GroupTransmissionRequest.class,
      responseType = com.lanjiu.pro.file.GroupTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.file.GroupTransmissionRequest,
      com.lanjiu.pro.file.GroupTransmissionResponse> getOriginalGroupTransmissionDownloadMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.file.GroupTransmissionRequest, com.lanjiu.pro.file.GroupTransmissionResponse> getOriginalGroupTransmissionDownloadMethod;
    if ((getOriginalGroupTransmissionDownloadMethod = FileTransmissionServiceGrpc.getOriginalGroupTransmissionDownloadMethod) == null) {
      synchronized (FileTransmissionServiceGrpc.class) {
        if ((getOriginalGroupTransmissionDownloadMethod = FileTransmissionServiceGrpc.getOriginalGroupTransmissionDownloadMethod) == null) {
          FileTransmissionServiceGrpc.getOriginalGroupTransmissionDownloadMethod = getOriginalGroupTransmissionDownloadMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.file.GroupTransmissionRequest, com.lanjiu.pro.file.GroupTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OriginalGroupTransmissionDownload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.file.GroupTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.file.GroupTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FileTransmissionServiceMethodDescriptorSupplier("OriginalGroupTransmissionDownload"))
              .build();
        }
      }
    }
    return getOriginalGroupTransmissionDownloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.file.GroupTransmissionRequest,
      com.lanjiu.pro.file.GroupTransmissionResponse> getGroupTransmissionFileDeleteForStorageServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GroupTransmissionFileDeleteForStorageServer",
      requestType = com.lanjiu.pro.file.GroupTransmissionRequest.class,
      responseType = com.lanjiu.pro.file.GroupTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.file.GroupTransmissionRequest,
      com.lanjiu.pro.file.GroupTransmissionResponse> getGroupTransmissionFileDeleteForStorageServerMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.file.GroupTransmissionRequest, com.lanjiu.pro.file.GroupTransmissionResponse> getGroupTransmissionFileDeleteForStorageServerMethod;
    if ((getGroupTransmissionFileDeleteForStorageServerMethod = FileTransmissionServiceGrpc.getGroupTransmissionFileDeleteForStorageServerMethod) == null) {
      synchronized (FileTransmissionServiceGrpc.class) {
        if ((getGroupTransmissionFileDeleteForStorageServerMethod = FileTransmissionServiceGrpc.getGroupTransmissionFileDeleteForStorageServerMethod) == null) {
          FileTransmissionServiceGrpc.getGroupTransmissionFileDeleteForStorageServerMethod = getGroupTransmissionFileDeleteForStorageServerMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.file.GroupTransmissionRequest, com.lanjiu.pro.file.GroupTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GroupTransmissionFileDeleteForStorageServer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.file.GroupTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.file.GroupTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FileTransmissionServiceMethodDescriptorSupplier("GroupTransmissionFileDeleteForStorageServer"))
              .build();
        }
      }
    }
    return getGroupTransmissionFileDeleteForStorageServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.file.FriendsTransmissionRequest,
      com.lanjiu.pro.file.FriendsTransmissionResponse> getFriendsTransmissionFileDeleteForStorageServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FriendsTransmissionFileDeleteForStorageServer",
      requestType = com.lanjiu.pro.file.FriendsTransmissionRequest.class,
      responseType = com.lanjiu.pro.file.FriendsTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.file.FriendsTransmissionRequest,
      com.lanjiu.pro.file.FriendsTransmissionResponse> getFriendsTransmissionFileDeleteForStorageServerMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.file.FriendsTransmissionRequest, com.lanjiu.pro.file.FriendsTransmissionResponse> getFriendsTransmissionFileDeleteForStorageServerMethod;
    if ((getFriendsTransmissionFileDeleteForStorageServerMethod = FileTransmissionServiceGrpc.getFriendsTransmissionFileDeleteForStorageServerMethod) == null) {
      synchronized (FileTransmissionServiceGrpc.class) {
        if ((getFriendsTransmissionFileDeleteForStorageServerMethod = FileTransmissionServiceGrpc.getFriendsTransmissionFileDeleteForStorageServerMethod) == null) {
          FileTransmissionServiceGrpc.getFriendsTransmissionFileDeleteForStorageServerMethod = getFriendsTransmissionFileDeleteForStorageServerMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.file.FriendsTransmissionRequest, com.lanjiu.pro.file.FriendsTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FriendsTransmissionFileDeleteForStorageServer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.file.FriendsTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.file.FriendsTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FileTransmissionServiceMethodDescriptorSupplier("FriendsTransmissionFileDeleteForStorageServer"))
              .build();
        }
      }
    }
    return getFriendsTransmissionFileDeleteForStorageServerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FileTransmissionServiceStub newStub(io.grpc.Channel channel) {
    return new FileTransmissionServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FileTransmissionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FileTransmissionServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FileTransmissionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FileTransmissionServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FileTransmissionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void originalFriendsTransmissionUpload(com.lanjiu.pro.file.FriendsTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.file.FriendsTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getOriginalFriendsTransmissionUploadMethod(), responseObserver);
    }

    /**
     */
    public void originalFriendsTransmissionDownload(com.lanjiu.pro.file.FriendsTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.file.FriendsTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getOriginalFriendsTransmissionDownloadMethod(), responseObserver);
    }

    /**
     */
    public void originalGroupTransmissionUpload(com.lanjiu.pro.file.GroupTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.file.GroupTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getOriginalGroupTransmissionUploadMethod(), responseObserver);
    }

    /**
     */
    public void originalGroupTransmissionDownload(com.lanjiu.pro.file.GroupTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.file.GroupTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getOriginalGroupTransmissionDownloadMethod(), responseObserver);
    }

    /**
     */
    public void groupTransmissionFileDeleteForStorageServer(com.lanjiu.pro.file.GroupTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.file.GroupTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGroupTransmissionFileDeleteForStorageServerMethod(), responseObserver);
    }

    /**
     */
    public void friendsTransmissionFileDeleteForStorageServer(com.lanjiu.pro.file.FriendsTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.file.FriendsTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFriendsTransmissionFileDeleteForStorageServerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOriginalFriendsTransmissionUploadMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.file.FriendsTransmissionRequest,
                com.lanjiu.pro.file.FriendsTransmissionResponse>(
                  this, METHODID_ORIGINAL_FRIENDS_TRANSMISSION_UPLOAD)))
          .addMethod(
            getOriginalFriendsTransmissionDownloadMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.file.FriendsTransmissionRequest,
                com.lanjiu.pro.file.FriendsTransmissionResponse>(
                  this, METHODID_ORIGINAL_FRIENDS_TRANSMISSION_DOWNLOAD)))
          .addMethod(
            getOriginalGroupTransmissionUploadMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.file.GroupTransmissionRequest,
                com.lanjiu.pro.file.GroupTransmissionResponse>(
                  this, METHODID_ORIGINAL_GROUP_TRANSMISSION_UPLOAD)))
          .addMethod(
            getOriginalGroupTransmissionDownloadMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.file.GroupTransmissionRequest,
                com.lanjiu.pro.file.GroupTransmissionResponse>(
                  this, METHODID_ORIGINAL_GROUP_TRANSMISSION_DOWNLOAD)))
          .addMethod(
            getGroupTransmissionFileDeleteForStorageServerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.file.GroupTransmissionRequest,
                com.lanjiu.pro.file.GroupTransmissionResponse>(
                  this, METHODID_GROUP_TRANSMISSION_FILE_DELETE_FOR_STORAGE_SERVER)))
          .addMethod(
            getFriendsTransmissionFileDeleteForStorageServerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.file.FriendsTransmissionRequest,
                com.lanjiu.pro.file.FriendsTransmissionResponse>(
                  this, METHODID_FRIENDS_TRANSMISSION_FILE_DELETE_FOR_STORAGE_SERVER)))
          .build();
    }
  }

  /**
   */
  public static final class FileTransmissionServiceStub extends io.grpc.stub.AbstractStub<FileTransmissionServiceStub> {
    private FileTransmissionServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileTransmissionServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileTransmissionServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileTransmissionServiceStub(channel, callOptions);
    }

    /**
     */
    public void originalFriendsTransmissionUpload(com.lanjiu.pro.file.FriendsTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.file.FriendsTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOriginalFriendsTransmissionUploadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void originalFriendsTransmissionDownload(com.lanjiu.pro.file.FriendsTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.file.FriendsTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOriginalFriendsTransmissionDownloadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void originalGroupTransmissionUpload(com.lanjiu.pro.file.GroupTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.file.GroupTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOriginalGroupTransmissionUploadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void originalGroupTransmissionDownload(com.lanjiu.pro.file.GroupTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.file.GroupTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOriginalGroupTransmissionDownloadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void groupTransmissionFileDeleteForStorageServer(com.lanjiu.pro.file.GroupTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.file.GroupTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGroupTransmissionFileDeleteForStorageServerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void friendsTransmissionFileDeleteForStorageServer(com.lanjiu.pro.file.FriendsTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.file.FriendsTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFriendsTransmissionFileDeleteForStorageServerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FileTransmissionServiceBlockingStub extends io.grpc.stub.AbstractStub<FileTransmissionServiceBlockingStub> {
    private FileTransmissionServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileTransmissionServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileTransmissionServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileTransmissionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.lanjiu.pro.file.FriendsTransmissionResponse originalFriendsTransmissionUpload(com.lanjiu.pro.file.FriendsTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getOriginalFriendsTransmissionUploadMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.file.FriendsTransmissionResponse originalFriendsTransmissionDownload(com.lanjiu.pro.file.FriendsTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getOriginalFriendsTransmissionDownloadMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.file.GroupTransmissionResponse originalGroupTransmissionUpload(com.lanjiu.pro.file.GroupTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getOriginalGroupTransmissionUploadMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.file.GroupTransmissionResponse originalGroupTransmissionDownload(com.lanjiu.pro.file.GroupTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getOriginalGroupTransmissionDownloadMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.file.GroupTransmissionResponse groupTransmissionFileDeleteForStorageServer(com.lanjiu.pro.file.GroupTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getGroupTransmissionFileDeleteForStorageServerMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.file.FriendsTransmissionResponse friendsTransmissionFileDeleteForStorageServer(com.lanjiu.pro.file.FriendsTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getFriendsTransmissionFileDeleteForStorageServerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FileTransmissionServiceFutureStub extends io.grpc.stub.AbstractStub<FileTransmissionServiceFutureStub> {
    private FileTransmissionServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileTransmissionServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileTransmissionServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileTransmissionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.file.FriendsTransmissionResponse> originalFriendsTransmissionUpload(
        com.lanjiu.pro.file.FriendsTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getOriginalFriendsTransmissionUploadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.file.FriendsTransmissionResponse> originalFriendsTransmissionDownload(
        com.lanjiu.pro.file.FriendsTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getOriginalFriendsTransmissionDownloadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.file.GroupTransmissionResponse> originalGroupTransmissionUpload(
        com.lanjiu.pro.file.GroupTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getOriginalGroupTransmissionUploadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.file.GroupTransmissionResponse> originalGroupTransmissionDownload(
        com.lanjiu.pro.file.GroupTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getOriginalGroupTransmissionDownloadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.file.GroupTransmissionResponse> groupTransmissionFileDeleteForStorageServer(
        com.lanjiu.pro.file.GroupTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGroupTransmissionFileDeleteForStorageServerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.file.FriendsTransmissionResponse> friendsTransmissionFileDeleteForStorageServer(
        com.lanjiu.pro.file.FriendsTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFriendsTransmissionFileDeleteForStorageServerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ORIGINAL_FRIENDS_TRANSMISSION_UPLOAD = 0;
  private static final int METHODID_ORIGINAL_FRIENDS_TRANSMISSION_DOWNLOAD = 1;
  private static final int METHODID_ORIGINAL_GROUP_TRANSMISSION_UPLOAD = 2;
  private static final int METHODID_ORIGINAL_GROUP_TRANSMISSION_DOWNLOAD = 3;
  private static final int METHODID_GROUP_TRANSMISSION_FILE_DELETE_FOR_STORAGE_SERVER = 4;
  private static final int METHODID_FRIENDS_TRANSMISSION_FILE_DELETE_FOR_STORAGE_SERVER = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FileTransmissionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FileTransmissionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ORIGINAL_FRIENDS_TRANSMISSION_UPLOAD:
          serviceImpl.originalFriendsTransmissionUpload((com.lanjiu.pro.file.FriendsTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.file.FriendsTransmissionResponse>) responseObserver);
          break;
        case METHODID_ORIGINAL_FRIENDS_TRANSMISSION_DOWNLOAD:
          serviceImpl.originalFriendsTransmissionDownload((com.lanjiu.pro.file.FriendsTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.file.FriendsTransmissionResponse>) responseObserver);
          break;
        case METHODID_ORIGINAL_GROUP_TRANSMISSION_UPLOAD:
          serviceImpl.originalGroupTransmissionUpload((com.lanjiu.pro.file.GroupTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.file.GroupTransmissionResponse>) responseObserver);
          break;
        case METHODID_ORIGINAL_GROUP_TRANSMISSION_DOWNLOAD:
          serviceImpl.originalGroupTransmissionDownload((com.lanjiu.pro.file.GroupTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.file.GroupTransmissionResponse>) responseObserver);
          break;
        case METHODID_GROUP_TRANSMISSION_FILE_DELETE_FOR_STORAGE_SERVER:
          serviceImpl.groupTransmissionFileDeleteForStorageServer((com.lanjiu.pro.file.GroupTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.file.GroupTransmissionResponse>) responseObserver);
          break;
        case METHODID_FRIENDS_TRANSMISSION_FILE_DELETE_FOR_STORAGE_SERVER:
          serviceImpl.friendsTransmissionFileDeleteForStorageServer((com.lanjiu.pro.file.FriendsTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.file.FriendsTransmissionResponse>) responseObserver);
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

  private static abstract class FileTransmissionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FileTransmissionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.lanjiu.pro.file.FileTransmissionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FileTransmissionService");
    }
  }

  private static final class FileTransmissionServiceFileDescriptorSupplier
      extends FileTransmissionServiceBaseDescriptorSupplier {
    FileTransmissionServiceFileDescriptorSupplier() {}
  }

  private static final class FileTransmissionServiceMethodDescriptorSupplier
      extends FileTransmissionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FileTransmissionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FileTransmissionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FileTransmissionServiceFileDescriptorSupplier())
              .addMethod(getOriginalFriendsTransmissionUploadMethod())
              .addMethod(getOriginalFriendsTransmissionDownloadMethod())
              .addMethod(getOriginalGroupTransmissionUploadMethod())
              .addMethod(getOriginalGroupTransmissionDownloadMethod())
              .addMethod(getGroupTransmissionFileDeleteForStorageServerMethod())
              .addMethod(getFriendsTransmissionFileDeleteForStorageServerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
