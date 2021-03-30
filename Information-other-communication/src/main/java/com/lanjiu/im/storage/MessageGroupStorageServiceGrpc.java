package com.lanjiu.im.storage;

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

  public static final String SERVICE_NAME = "com.lanjiu.im.storage.MessageGroupStorageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.storage.OnGroupMessageTransmissionRequest,
      com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> getStorageMessageGroupInformationWithGroupOnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "storageMessageGroupInformationWithGroupOn",
      requestType = com.lanjiu.im.storage.OnGroupMessageTransmissionRequest.class,
      responseType = com.lanjiu.im.storage.OnGroupMessageTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.storage.OnGroupMessageTransmissionRequest,
      com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> getStorageMessageGroupInformationWithGroupOnMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.storage.OnGroupMessageTransmissionRequest, com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> getStorageMessageGroupInformationWithGroupOnMethod;
    if ((getStorageMessageGroupInformationWithGroupOnMethod = MessageGroupStorageServiceGrpc.getStorageMessageGroupInformationWithGroupOnMethod) == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        if ((getStorageMessageGroupInformationWithGroupOnMethod = MessageGroupStorageServiceGrpc.getStorageMessageGroupInformationWithGroupOnMethod) == null) {
          MessageGroupStorageServiceGrpc.getStorageMessageGroupInformationWithGroupOnMethod = getStorageMessageGroupInformationWithGroupOnMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.storage.OnGroupMessageTransmissionRequest, com.lanjiu.im.storage.OnGroupMessageTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "storageMessageGroupInformationWithGroupOn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.storage.OnGroupMessageTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.storage.OnGroupMessageTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageGroupStorageServiceMethodDescriptorSupplier("storageMessageGroupInformationWithGroupOn"))
              .build();
        }
      }
    }
    return getStorageMessageGroupInformationWithGroupOnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.storage.OnGroupMessageTransmissionRequest,
      com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> getDeleteMessageGroupInformationWithGroupOnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteMessageGroupInformationWithGroupOn",
      requestType = com.lanjiu.im.storage.OnGroupMessageTransmissionRequest.class,
      responseType = com.lanjiu.im.storage.OnGroupMessageTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.storage.OnGroupMessageTransmissionRequest,
      com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> getDeleteMessageGroupInformationWithGroupOnMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.storage.OnGroupMessageTransmissionRequest, com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> getDeleteMessageGroupInformationWithGroupOnMethod;
    if ((getDeleteMessageGroupInformationWithGroupOnMethod = MessageGroupStorageServiceGrpc.getDeleteMessageGroupInformationWithGroupOnMethod) == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        if ((getDeleteMessageGroupInformationWithGroupOnMethod = MessageGroupStorageServiceGrpc.getDeleteMessageGroupInformationWithGroupOnMethod) == null) {
          MessageGroupStorageServiceGrpc.getDeleteMessageGroupInformationWithGroupOnMethod = getDeleteMessageGroupInformationWithGroupOnMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.storage.OnGroupMessageTransmissionRequest, com.lanjiu.im.storage.OnGroupMessageTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteMessageGroupInformationWithGroupOn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.storage.OnGroupMessageTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.storage.OnGroupMessageTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageGroupStorageServiceMethodDescriptorSupplier("deleteMessageGroupInformationWithGroupOn"))
              .build();
        }
      }
    }
    return getDeleteMessageGroupInformationWithGroupOnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.storage.OnGroupMessageTransmissionRequest,
      com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> getUpdateMessageGroupInformationWithGroupOnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateMessageGroupInformationWithGroupOn",
      requestType = com.lanjiu.im.storage.OnGroupMessageTransmissionRequest.class,
      responseType = com.lanjiu.im.storage.OnGroupMessageTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.storage.OnGroupMessageTransmissionRequest,
      com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> getUpdateMessageGroupInformationWithGroupOnMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.storage.OnGroupMessageTransmissionRequest, com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> getUpdateMessageGroupInformationWithGroupOnMethod;
    if ((getUpdateMessageGroupInformationWithGroupOnMethod = MessageGroupStorageServiceGrpc.getUpdateMessageGroupInformationWithGroupOnMethod) == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        if ((getUpdateMessageGroupInformationWithGroupOnMethod = MessageGroupStorageServiceGrpc.getUpdateMessageGroupInformationWithGroupOnMethod) == null) {
          MessageGroupStorageServiceGrpc.getUpdateMessageGroupInformationWithGroupOnMethod = getUpdateMessageGroupInformationWithGroupOnMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.storage.OnGroupMessageTransmissionRequest, com.lanjiu.im.storage.OnGroupMessageTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateMessageGroupInformationWithGroupOn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.storage.OnGroupMessageTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.storage.OnGroupMessageTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageGroupStorageServiceMethodDescriptorSupplier("updateMessageGroupInformationWithGroupOn"))
              .build();
        }
      }
    }
    return getUpdateMessageGroupInformationWithGroupOnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.storage.OnGroupMessageTransmissionRequest,
      com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> getSelectMessageGroupInformationWithGroupOnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectMessageGroupInformationWithGroupOn",
      requestType = com.lanjiu.im.storage.OnGroupMessageTransmissionRequest.class,
      responseType = com.lanjiu.im.storage.OnGroupMessageTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.storage.OnGroupMessageTransmissionRequest,
      com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> getSelectMessageGroupInformationWithGroupOnMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.storage.OnGroupMessageTransmissionRequest, com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> getSelectMessageGroupInformationWithGroupOnMethod;
    if ((getSelectMessageGroupInformationWithGroupOnMethod = MessageGroupStorageServiceGrpc.getSelectMessageGroupInformationWithGroupOnMethod) == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        if ((getSelectMessageGroupInformationWithGroupOnMethod = MessageGroupStorageServiceGrpc.getSelectMessageGroupInformationWithGroupOnMethod) == null) {
          MessageGroupStorageServiceGrpc.getSelectMessageGroupInformationWithGroupOnMethod = getSelectMessageGroupInformationWithGroupOnMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.storage.OnGroupMessageTransmissionRequest, com.lanjiu.im.storage.OnGroupMessageTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectMessageGroupInformationWithGroupOn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.storage.OnGroupMessageTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.storage.OnGroupMessageTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageGroupStorageServiceMethodDescriptorSupplier("selectMessageGroupInformationWithGroupOn"))
              .build();
        }
      }
    }
    return getSelectMessageGroupInformationWithGroupOnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.storage.OffGroupMessageTransmissionRequest,
      com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> getStorageMessageGroupInformationWithGroupOffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "storageMessageGroupInformationWithGroupOff",
      requestType = com.lanjiu.im.storage.OffGroupMessageTransmissionRequest.class,
      responseType = com.lanjiu.im.storage.OffGroupMessageTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.storage.OffGroupMessageTransmissionRequest,
      com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> getStorageMessageGroupInformationWithGroupOffMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.storage.OffGroupMessageTransmissionRequest, com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> getStorageMessageGroupInformationWithGroupOffMethod;
    if ((getStorageMessageGroupInformationWithGroupOffMethod = MessageGroupStorageServiceGrpc.getStorageMessageGroupInformationWithGroupOffMethod) == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        if ((getStorageMessageGroupInformationWithGroupOffMethod = MessageGroupStorageServiceGrpc.getStorageMessageGroupInformationWithGroupOffMethod) == null) {
          MessageGroupStorageServiceGrpc.getStorageMessageGroupInformationWithGroupOffMethod = getStorageMessageGroupInformationWithGroupOffMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.storage.OffGroupMessageTransmissionRequest, com.lanjiu.im.storage.OffGroupMessageTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "storageMessageGroupInformationWithGroupOff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.storage.OffGroupMessageTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.storage.OffGroupMessageTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageGroupStorageServiceMethodDescriptorSupplier("storageMessageGroupInformationWithGroupOff"))
              .build();
        }
      }
    }
    return getStorageMessageGroupInformationWithGroupOffMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.storage.OffGroupMessageTransmissionRequest,
      com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> getDeleteMessageGroupInformationWithGroupOffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteMessageGroupInformationWithGroupOff",
      requestType = com.lanjiu.im.storage.OffGroupMessageTransmissionRequest.class,
      responseType = com.lanjiu.im.storage.OffGroupMessageTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.storage.OffGroupMessageTransmissionRequest,
      com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> getDeleteMessageGroupInformationWithGroupOffMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.storage.OffGroupMessageTransmissionRequest, com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> getDeleteMessageGroupInformationWithGroupOffMethod;
    if ((getDeleteMessageGroupInformationWithGroupOffMethod = MessageGroupStorageServiceGrpc.getDeleteMessageGroupInformationWithGroupOffMethod) == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        if ((getDeleteMessageGroupInformationWithGroupOffMethod = MessageGroupStorageServiceGrpc.getDeleteMessageGroupInformationWithGroupOffMethod) == null) {
          MessageGroupStorageServiceGrpc.getDeleteMessageGroupInformationWithGroupOffMethod = getDeleteMessageGroupInformationWithGroupOffMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.storage.OffGroupMessageTransmissionRequest, com.lanjiu.im.storage.OffGroupMessageTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteMessageGroupInformationWithGroupOff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.storage.OffGroupMessageTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.storage.OffGroupMessageTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageGroupStorageServiceMethodDescriptorSupplier("deleteMessageGroupInformationWithGroupOff"))
              .build();
        }
      }
    }
    return getDeleteMessageGroupInformationWithGroupOffMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.storage.OffGroupMessageTransmissionRequest,
      com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> getUpdateMessageGroupInformationWithGroupOffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateMessageGroupInformationWithGroupOff",
      requestType = com.lanjiu.im.storage.OffGroupMessageTransmissionRequest.class,
      responseType = com.lanjiu.im.storage.OffGroupMessageTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.storage.OffGroupMessageTransmissionRequest,
      com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> getUpdateMessageGroupInformationWithGroupOffMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.storage.OffGroupMessageTransmissionRequest, com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> getUpdateMessageGroupInformationWithGroupOffMethod;
    if ((getUpdateMessageGroupInformationWithGroupOffMethod = MessageGroupStorageServiceGrpc.getUpdateMessageGroupInformationWithGroupOffMethod) == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        if ((getUpdateMessageGroupInformationWithGroupOffMethod = MessageGroupStorageServiceGrpc.getUpdateMessageGroupInformationWithGroupOffMethod) == null) {
          MessageGroupStorageServiceGrpc.getUpdateMessageGroupInformationWithGroupOffMethod = getUpdateMessageGroupInformationWithGroupOffMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.storage.OffGroupMessageTransmissionRequest, com.lanjiu.im.storage.OffGroupMessageTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateMessageGroupInformationWithGroupOff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.storage.OffGroupMessageTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.storage.OffGroupMessageTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageGroupStorageServiceMethodDescriptorSupplier("updateMessageGroupInformationWithGroupOff"))
              .build();
        }
      }
    }
    return getUpdateMessageGroupInformationWithGroupOffMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.storage.OffGroupMessageTransmissionRequest,
      com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> getSelectMessageGroupInformationWithGroupOffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectMessageGroupInformationWithGroupOff",
      requestType = com.lanjiu.im.storage.OffGroupMessageTransmissionRequest.class,
      responseType = com.lanjiu.im.storage.OffGroupMessageTransmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.storage.OffGroupMessageTransmissionRequest,
      com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> getSelectMessageGroupInformationWithGroupOffMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.storage.OffGroupMessageTransmissionRequest, com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> getSelectMessageGroupInformationWithGroupOffMethod;
    if ((getSelectMessageGroupInformationWithGroupOffMethod = MessageGroupStorageServiceGrpc.getSelectMessageGroupInformationWithGroupOffMethod) == null) {
      synchronized (MessageGroupStorageServiceGrpc.class) {
        if ((getSelectMessageGroupInformationWithGroupOffMethod = MessageGroupStorageServiceGrpc.getSelectMessageGroupInformationWithGroupOffMethod) == null) {
          MessageGroupStorageServiceGrpc.getSelectMessageGroupInformationWithGroupOffMethod = getSelectMessageGroupInformationWithGroupOffMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.storage.OffGroupMessageTransmissionRequest, com.lanjiu.im.storage.OffGroupMessageTransmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectMessageGroupInformationWithGroupOff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.storage.OffGroupMessageTransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.storage.OffGroupMessageTransmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageGroupStorageServiceMethodDescriptorSupplier("selectMessageGroupInformationWithGroupOff"))
              .build();
        }
      }
    }
    return getSelectMessageGroupInformationWithGroupOffMethod;
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
    public void storageMessageGroupInformationWithGroupOn(com.lanjiu.im.storage.OnGroupMessageTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStorageMessageGroupInformationWithGroupOnMethod(), responseObserver);
    }

    /**
     */
    public void deleteMessageGroupInformationWithGroupOn(com.lanjiu.im.storage.OnGroupMessageTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMessageGroupInformationWithGroupOnMethod(), responseObserver);
    }

    /**
     */
    public void updateMessageGroupInformationWithGroupOn(com.lanjiu.im.storage.OnGroupMessageTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMessageGroupInformationWithGroupOnMethod(), responseObserver);
    }

    /**
     */
    public void selectMessageGroupInformationWithGroupOn(com.lanjiu.im.storage.OnGroupMessageTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectMessageGroupInformationWithGroupOnMethod(), responseObserver);
    }

    /**
     */
    public void storageMessageGroupInformationWithGroupOff(com.lanjiu.im.storage.OffGroupMessageTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStorageMessageGroupInformationWithGroupOffMethod(), responseObserver);
    }

    /**
     */
    public void deleteMessageGroupInformationWithGroupOff(com.lanjiu.im.storage.OffGroupMessageTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMessageGroupInformationWithGroupOffMethod(), responseObserver);
    }

    /**
     */
    public void updateMessageGroupInformationWithGroupOff(com.lanjiu.im.storage.OffGroupMessageTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMessageGroupInformationWithGroupOffMethod(), responseObserver);
    }

    /**
     */
    public void selectMessageGroupInformationWithGroupOff(com.lanjiu.im.storage.OffGroupMessageTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectMessageGroupInformationWithGroupOffMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStorageMessageGroupInformationWithGroupOnMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.storage.OnGroupMessageTransmissionRequest,
                com.lanjiu.im.storage.OnGroupMessageTransmissionResponse>(
                  this, METHODID_STORAGE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_ON)))
          .addMethod(
            getDeleteMessageGroupInformationWithGroupOnMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.storage.OnGroupMessageTransmissionRequest,
                com.lanjiu.im.storage.OnGroupMessageTransmissionResponse>(
                  this, METHODID_DELETE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_ON)))
          .addMethod(
            getUpdateMessageGroupInformationWithGroupOnMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.storage.OnGroupMessageTransmissionRequest,
                com.lanjiu.im.storage.OnGroupMessageTransmissionResponse>(
                  this, METHODID_UPDATE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_ON)))
          .addMethod(
            getSelectMessageGroupInformationWithGroupOnMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.storage.OnGroupMessageTransmissionRequest,
                com.lanjiu.im.storage.OnGroupMessageTransmissionResponse>(
                  this, METHODID_SELECT_MESSAGE_GROUP_INFORMATION_WITH_GROUP_ON)))
          .addMethod(
            getStorageMessageGroupInformationWithGroupOffMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.storage.OffGroupMessageTransmissionRequest,
                com.lanjiu.im.storage.OffGroupMessageTransmissionResponse>(
                  this, METHODID_STORAGE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_OFF)))
          .addMethod(
            getDeleteMessageGroupInformationWithGroupOffMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.storage.OffGroupMessageTransmissionRequest,
                com.lanjiu.im.storage.OffGroupMessageTransmissionResponse>(
                  this, METHODID_DELETE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_OFF)))
          .addMethod(
            getUpdateMessageGroupInformationWithGroupOffMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.storage.OffGroupMessageTransmissionRequest,
                com.lanjiu.im.storage.OffGroupMessageTransmissionResponse>(
                  this, METHODID_UPDATE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_OFF)))
          .addMethod(
            getSelectMessageGroupInformationWithGroupOffMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.storage.OffGroupMessageTransmissionRequest,
                com.lanjiu.im.storage.OffGroupMessageTransmissionResponse>(
                  this, METHODID_SELECT_MESSAGE_GROUP_INFORMATION_WITH_GROUP_OFF)))
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
    public void storageMessageGroupInformationWithGroupOn(com.lanjiu.im.storage.OnGroupMessageTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStorageMessageGroupInformationWithGroupOnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteMessageGroupInformationWithGroupOn(com.lanjiu.im.storage.OnGroupMessageTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMessageGroupInformationWithGroupOnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateMessageGroupInformationWithGroupOn(com.lanjiu.im.storage.OnGroupMessageTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMessageGroupInformationWithGroupOnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectMessageGroupInformationWithGroupOn(com.lanjiu.im.storage.OnGroupMessageTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectMessageGroupInformationWithGroupOnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void storageMessageGroupInformationWithGroupOff(com.lanjiu.im.storage.OffGroupMessageTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStorageMessageGroupInformationWithGroupOffMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteMessageGroupInformationWithGroupOff(com.lanjiu.im.storage.OffGroupMessageTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMessageGroupInformationWithGroupOffMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateMessageGroupInformationWithGroupOff(com.lanjiu.im.storage.OffGroupMessageTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMessageGroupInformationWithGroupOffMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectMessageGroupInformationWithGroupOff(com.lanjiu.im.storage.OffGroupMessageTransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectMessageGroupInformationWithGroupOffMethod(), getCallOptions()), request, responseObserver);
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
    public com.lanjiu.im.storage.OnGroupMessageTransmissionResponse storageMessageGroupInformationWithGroupOn(com.lanjiu.im.storage.OnGroupMessageTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getStorageMessageGroupInformationWithGroupOnMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.storage.OnGroupMessageTransmissionResponse deleteMessageGroupInformationWithGroupOn(com.lanjiu.im.storage.OnGroupMessageTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMessageGroupInformationWithGroupOnMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.storage.OnGroupMessageTransmissionResponse updateMessageGroupInformationWithGroupOn(com.lanjiu.im.storage.OnGroupMessageTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMessageGroupInformationWithGroupOnMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.storage.OnGroupMessageTransmissionResponse selectMessageGroupInformationWithGroupOn(com.lanjiu.im.storage.OnGroupMessageTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectMessageGroupInformationWithGroupOnMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.storage.OffGroupMessageTransmissionResponse storageMessageGroupInformationWithGroupOff(com.lanjiu.im.storage.OffGroupMessageTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getStorageMessageGroupInformationWithGroupOffMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.storage.OffGroupMessageTransmissionResponse deleteMessageGroupInformationWithGroupOff(com.lanjiu.im.storage.OffGroupMessageTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMessageGroupInformationWithGroupOffMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.storage.OffGroupMessageTransmissionResponse updateMessageGroupInformationWithGroupOff(com.lanjiu.im.storage.OffGroupMessageTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMessageGroupInformationWithGroupOffMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.storage.OffGroupMessageTransmissionResponse selectMessageGroupInformationWithGroupOff(com.lanjiu.im.storage.OffGroupMessageTransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectMessageGroupInformationWithGroupOffMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> storageMessageGroupInformationWithGroupOn(
        com.lanjiu.im.storage.OnGroupMessageTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStorageMessageGroupInformationWithGroupOnMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> deleteMessageGroupInformationWithGroupOn(
        com.lanjiu.im.storage.OnGroupMessageTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMessageGroupInformationWithGroupOnMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> updateMessageGroupInformationWithGroupOn(
        com.lanjiu.im.storage.OnGroupMessageTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMessageGroupInformationWithGroupOnMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.storage.OnGroupMessageTransmissionResponse> selectMessageGroupInformationWithGroupOn(
        com.lanjiu.im.storage.OnGroupMessageTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectMessageGroupInformationWithGroupOnMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> storageMessageGroupInformationWithGroupOff(
        com.lanjiu.im.storage.OffGroupMessageTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStorageMessageGroupInformationWithGroupOffMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> deleteMessageGroupInformationWithGroupOff(
        com.lanjiu.im.storage.OffGroupMessageTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMessageGroupInformationWithGroupOffMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> updateMessageGroupInformationWithGroupOff(
        com.lanjiu.im.storage.OffGroupMessageTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMessageGroupInformationWithGroupOffMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.storage.OffGroupMessageTransmissionResponse> selectMessageGroupInformationWithGroupOff(
        com.lanjiu.im.storage.OffGroupMessageTransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectMessageGroupInformationWithGroupOffMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STORAGE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_ON = 0;
  private static final int METHODID_DELETE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_ON = 1;
  private static final int METHODID_UPDATE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_ON = 2;
  private static final int METHODID_SELECT_MESSAGE_GROUP_INFORMATION_WITH_GROUP_ON = 3;
  private static final int METHODID_STORAGE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_OFF = 4;
  private static final int METHODID_DELETE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_OFF = 5;
  private static final int METHODID_UPDATE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_OFF = 6;
  private static final int METHODID_SELECT_MESSAGE_GROUP_INFORMATION_WITH_GROUP_OFF = 7;

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
        case METHODID_STORAGE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_ON:
          serviceImpl.storageMessageGroupInformationWithGroupOn((com.lanjiu.im.storage.OnGroupMessageTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OnGroupMessageTransmissionResponse>) responseObserver);
          break;
        case METHODID_DELETE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_ON:
          serviceImpl.deleteMessageGroupInformationWithGroupOn((com.lanjiu.im.storage.OnGroupMessageTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OnGroupMessageTransmissionResponse>) responseObserver);
          break;
        case METHODID_UPDATE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_ON:
          serviceImpl.updateMessageGroupInformationWithGroupOn((com.lanjiu.im.storage.OnGroupMessageTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OnGroupMessageTransmissionResponse>) responseObserver);
          break;
        case METHODID_SELECT_MESSAGE_GROUP_INFORMATION_WITH_GROUP_ON:
          serviceImpl.selectMessageGroupInformationWithGroupOn((com.lanjiu.im.storage.OnGroupMessageTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OnGroupMessageTransmissionResponse>) responseObserver);
          break;
        case METHODID_STORAGE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_OFF:
          serviceImpl.storageMessageGroupInformationWithGroupOff((com.lanjiu.im.storage.OffGroupMessageTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OffGroupMessageTransmissionResponse>) responseObserver);
          break;
        case METHODID_DELETE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_OFF:
          serviceImpl.deleteMessageGroupInformationWithGroupOff((com.lanjiu.im.storage.OffGroupMessageTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OffGroupMessageTransmissionResponse>) responseObserver);
          break;
        case METHODID_UPDATE_MESSAGE_GROUP_INFORMATION_WITH_GROUP_OFF:
          serviceImpl.updateMessageGroupInformationWithGroupOff((com.lanjiu.im.storage.OffGroupMessageTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OffGroupMessageTransmissionResponse>) responseObserver);
          break;
        case METHODID_SELECT_MESSAGE_GROUP_INFORMATION_WITH_GROUP_OFF:
          serviceImpl.selectMessageGroupInformationWithGroupOff((com.lanjiu.im.storage.OffGroupMessageTransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.storage.OffGroupMessageTransmissionResponse>) responseObserver);
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
      return com.lanjiu.im.storage.MessageGroupStorageProto.getDescriptor();
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
              .addMethod(getStorageMessageGroupInformationWithGroupOnMethod())
              .addMethod(getDeleteMessageGroupInformationWithGroupOnMethod())
              .addMethod(getUpdateMessageGroupInformationWithGroupOnMethod())
              .addMethod(getSelectMessageGroupInformationWithGroupOnMethod())
              .addMethod(getStorageMessageGroupInformationWithGroupOffMethod())
              .addMethod(getDeleteMessageGroupInformationWithGroupOffMethod())
              .addMethod(getUpdateMessageGroupInformationWithGroupOffMethod())
              .addMethod(getSelectMessageGroupInformationWithGroupOffMethod())
              .build();
        }
      }
    }
    return result;
  }
}
