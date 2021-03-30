package com.lanjiu.pro.friend_msg;

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
    comments = "Source: im_friend_message.proto")
public final class MessageFriendServiceGrpc {

  private MessageFriendServiceGrpc() {}

  public static final String SERVICE_NAME = "com.lanjiu.pro.friend_msg.MessageFriendService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage,
      com.lanjiu.pro.friend_msg.ResponseFriendMessage> getStorageFriendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "storageFriendMessage",
      requestType = com.lanjiu.pro.friend_msg.RequestFriendMessage.class,
      responseType = com.lanjiu.pro.friend_msg.ResponseFriendMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage,
      com.lanjiu.pro.friend_msg.ResponseFriendMessage> getStorageFriendMessageMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage, com.lanjiu.pro.friend_msg.ResponseFriendMessage> getStorageFriendMessageMethod;
    if ((getStorageFriendMessageMethod = MessageFriendServiceGrpc.getStorageFriendMessageMethod) == null) {
      synchronized (MessageFriendServiceGrpc.class) {
        if ((getStorageFriendMessageMethod = MessageFriendServiceGrpc.getStorageFriendMessageMethod) == null) {
          MessageFriendServiceGrpc.getStorageFriendMessageMethod = getStorageFriendMessageMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.friend_msg.RequestFriendMessage, com.lanjiu.pro.friend_msg.ResponseFriendMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "storageFriendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.friend_msg.RequestFriendMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.friend_msg.ResponseFriendMessage.getDefaultInstance()))
              .setSchemaDescriptor(new MessageFriendServiceMethodDescriptorSupplier("storageFriendMessage"))
              .build();
        }
      }
    }
    return getStorageFriendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage,
      com.lanjiu.pro.friend_msg.ResponseFriendMessage> getRemoveFriendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "removeFriendMessage",
      requestType = com.lanjiu.pro.friend_msg.RequestFriendMessage.class,
      responseType = com.lanjiu.pro.friend_msg.ResponseFriendMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage,
      com.lanjiu.pro.friend_msg.ResponseFriendMessage> getRemoveFriendMessageMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage, com.lanjiu.pro.friend_msg.ResponseFriendMessage> getRemoveFriendMessageMethod;
    if ((getRemoveFriendMessageMethod = MessageFriendServiceGrpc.getRemoveFriendMessageMethod) == null) {
      synchronized (MessageFriendServiceGrpc.class) {
        if ((getRemoveFriendMessageMethod = MessageFriendServiceGrpc.getRemoveFriendMessageMethod) == null) {
          MessageFriendServiceGrpc.getRemoveFriendMessageMethod = getRemoveFriendMessageMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.friend_msg.RequestFriendMessage, com.lanjiu.pro.friend_msg.ResponseFriendMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "removeFriendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.friend_msg.RequestFriendMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.friend_msg.ResponseFriendMessage.getDefaultInstance()))
              .setSchemaDescriptor(new MessageFriendServiceMethodDescriptorSupplier("removeFriendMessage"))
              .build();
        }
      }
    }
    return getRemoveFriendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage,
      com.lanjiu.pro.friend_msg.ResponseFriendMessage> getSelectFriendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectFriendMessage",
      requestType = com.lanjiu.pro.friend_msg.RequestFriendMessage.class,
      responseType = com.lanjiu.pro.friend_msg.ResponseFriendMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage,
      com.lanjiu.pro.friend_msg.ResponseFriendMessage> getSelectFriendMessageMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage, com.lanjiu.pro.friend_msg.ResponseFriendMessage> getSelectFriendMessageMethod;
    if ((getSelectFriendMessageMethod = MessageFriendServiceGrpc.getSelectFriendMessageMethod) == null) {
      synchronized (MessageFriendServiceGrpc.class) {
        if ((getSelectFriendMessageMethod = MessageFriendServiceGrpc.getSelectFriendMessageMethod) == null) {
          MessageFriendServiceGrpc.getSelectFriendMessageMethod = getSelectFriendMessageMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.friend_msg.RequestFriendMessage, com.lanjiu.pro.friend_msg.ResponseFriendMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectFriendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.friend_msg.RequestFriendMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.friend_msg.ResponseFriendMessage.getDefaultInstance()))
              .setSchemaDescriptor(new MessageFriendServiceMethodDescriptorSupplier("selectFriendMessage"))
              .build();
        }
      }
    }
    return getSelectFriendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage,
      com.lanjiu.pro.friend_msg.ResponseFriendMessage> getStorageFriendMessageOnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "storageFriendMessageOn",
      requestType = com.lanjiu.pro.friend_msg.RequestFriendMessage.class,
      responseType = com.lanjiu.pro.friend_msg.ResponseFriendMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage,
      com.lanjiu.pro.friend_msg.ResponseFriendMessage> getStorageFriendMessageOnMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage, com.lanjiu.pro.friend_msg.ResponseFriendMessage> getStorageFriendMessageOnMethod;
    if ((getStorageFriendMessageOnMethod = MessageFriendServiceGrpc.getStorageFriendMessageOnMethod) == null) {
      synchronized (MessageFriendServiceGrpc.class) {
        if ((getStorageFriendMessageOnMethod = MessageFriendServiceGrpc.getStorageFriendMessageOnMethod) == null) {
          MessageFriendServiceGrpc.getStorageFriendMessageOnMethod = getStorageFriendMessageOnMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.friend_msg.RequestFriendMessage, com.lanjiu.pro.friend_msg.ResponseFriendMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "storageFriendMessageOn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.friend_msg.RequestFriendMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.friend_msg.ResponseFriendMessage.getDefaultInstance()))
              .setSchemaDescriptor(new MessageFriendServiceMethodDescriptorSupplier("storageFriendMessageOn"))
              .build();
        }
      }
    }
    return getStorageFriendMessageOnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage,
      com.lanjiu.pro.friend_msg.ResponseFriendMessage> getRemoveFriendMessageOnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "removeFriendMessageOn",
      requestType = com.lanjiu.pro.friend_msg.RequestFriendMessage.class,
      responseType = com.lanjiu.pro.friend_msg.ResponseFriendMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage,
      com.lanjiu.pro.friend_msg.ResponseFriendMessage> getRemoveFriendMessageOnMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage, com.lanjiu.pro.friend_msg.ResponseFriendMessage> getRemoveFriendMessageOnMethod;
    if ((getRemoveFriendMessageOnMethod = MessageFriendServiceGrpc.getRemoveFriendMessageOnMethod) == null) {
      synchronized (MessageFriendServiceGrpc.class) {
        if ((getRemoveFriendMessageOnMethod = MessageFriendServiceGrpc.getRemoveFriendMessageOnMethod) == null) {
          MessageFriendServiceGrpc.getRemoveFriendMessageOnMethod = getRemoveFriendMessageOnMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.friend_msg.RequestFriendMessage, com.lanjiu.pro.friend_msg.ResponseFriendMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "removeFriendMessageOn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.friend_msg.RequestFriendMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.friend_msg.ResponseFriendMessage.getDefaultInstance()))
              .setSchemaDescriptor(new MessageFriendServiceMethodDescriptorSupplier("removeFriendMessageOn"))
              .build();
        }
      }
    }
    return getRemoveFriendMessageOnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage,
      com.lanjiu.pro.friend_msg.ResponseFriendMessage> getSelectFriendMessageOnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectFriendMessageOn",
      requestType = com.lanjiu.pro.friend_msg.RequestFriendMessage.class,
      responseType = com.lanjiu.pro.friend_msg.ResponseFriendMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage,
      com.lanjiu.pro.friend_msg.ResponseFriendMessage> getSelectFriendMessageOnMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.RequestFriendMessage, com.lanjiu.pro.friend_msg.ResponseFriendMessage> getSelectFriendMessageOnMethod;
    if ((getSelectFriendMessageOnMethod = MessageFriendServiceGrpc.getSelectFriendMessageOnMethod) == null) {
      synchronized (MessageFriendServiceGrpc.class) {
        if ((getSelectFriendMessageOnMethod = MessageFriendServiceGrpc.getSelectFriendMessageOnMethod) == null) {
          MessageFriendServiceGrpc.getSelectFriendMessageOnMethod = getSelectFriendMessageOnMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.friend_msg.RequestFriendMessage, com.lanjiu.pro.friend_msg.ResponseFriendMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectFriendMessageOn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.friend_msg.RequestFriendMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.friend_msg.ResponseFriendMessage.getDefaultInstance()))
              .setSchemaDescriptor(new MessageFriendServiceMethodDescriptorSupplier("selectFriendMessageOn"))
              .build();
        }
      }
    }
    return getSelectFriendMessageOnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest,
      com.lanjiu.pro.friend_msg.AudioAndVideoCallResponse> getAudioAndVideoCallMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "audioAndVideoCallMessage",
      requestType = com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest.class,
      responseType = com.lanjiu.pro.friend_msg.AudioAndVideoCallResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest,
      com.lanjiu.pro.friend_msg.AudioAndVideoCallResponse> getAudioAndVideoCallMessageMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest, com.lanjiu.pro.friend_msg.AudioAndVideoCallResponse> getAudioAndVideoCallMessageMethod;
    if ((getAudioAndVideoCallMessageMethod = MessageFriendServiceGrpc.getAudioAndVideoCallMessageMethod) == null) {
      synchronized (MessageFriendServiceGrpc.class) {
        if ((getAudioAndVideoCallMessageMethod = MessageFriendServiceGrpc.getAudioAndVideoCallMessageMethod) == null) {
          MessageFriendServiceGrpc.getAudioAndVideoCallMessageMethod = getAudioAndVideoCallMessageMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest, com.lanjiu.pro.friend_msg.AudioAndVideoCallResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "audioAndVideoCallMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.friend_msg.AudioAndVideoCallResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageFriendServiceMethodDescriptorSupplier("audioAndVideoCallMessage"))
              .build();
        }
      }
    }
    return getAudioAndVideoCallMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessageFriendServiceStub newStub(io.grpc.Channel channel) {
    return new MessageFriendServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessageFriendServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MessageFriendServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessageFriendServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MessageFriendServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class MessageFriendServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void storageFriendMessage(com.lanjiu.pro.friend_msg.RequestFriendMessage request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getStorageFriendMessageMethod(), responseObserver);
    }

    /**
     */
    public void removeFriendMessage(com.lanjiu.pro.friend_msg.RequestFriendMessage request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveFriendMessageMethod(), responseObserver);
    }

    /**
     */
    public void selectFriendMessage(com.lanjiu.pro.friend_msg.RequestFriendMessage request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectFriendMessageMethod(), responseObserver);
    }

    /**
     */
    public void storageFriendMessageOn(com.lanjiu.pro.friend_msg.RequestFriendMessage request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getStorageFriendMessageOnMethod(), responseObserver);
    }

    /**
     */
    public void removeFriendMessageOn(com.lanjiu.pro.friend_msg.RequestFriendMessage request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveFriendMessageOnMethod(), responseObserver);
    }

    /**
     */
    public void selectFriendMessageOn(com.lanjiu.pro.friend_msg.RequestFriendMessage request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectFriendMessageOnMethod(), responseObserver);
    }

    /**
     */
    public void audioAndVideoCallMessage(com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.AudioAndVideoCallResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAudioAndVideoCallMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStorageFriendMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.friend_msg.RequestFriendMessage,
                com.lanjiu.pro.friend_msg.ResponseFriendMessage>(
                  this, METHODID_STORAGE_FRIEND_MESSAGE)))
          .addMethod(
            getRemoveFriendMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.friend_msg.RequestFriendMessage,
                com.lanjiu.pro.friend_msg.ResponseFriendMessage>(
                  this, METHODID_REMOVE_FRIEND_MESSAGE)))
          .addMethod(
            getSelectFriendMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.friend_msg.RequestFriendMessage,
                com.lanjiu.pro.friend_msg.ResponseFriendMessage>(
                  this, METHODID_SELECT_FRIEND_MESSAGE)))
          .addMethod(
            getStorageFriendMessageOnMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.friend_msg.RequestFriendMessage,
                com.lanjiu.pro.friend_msg.ResponseFriendMessage>(
                  this, METHODID_STORAGE_FRIEND_MESSAGE_ON)))
          .addMethod(
            getRemoveFriendMessageOnMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.friend_msg.RequestFriendMessage,
                com.lanjiu.pro.friend_msg.ResponseFriendMessage>(
                  this, METHODID_REMOVE_FRIEND_MESSAGE_ON)))
          .addMethod(
            getSelectFriendMessageOnMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.friend_msg.RequestFriendMessage,
                com.lanjiu.pro.friend_msg.ResponseFriendMessage>(
                  this, METHODID_SELECT_FRIEND_MESSAGE_ON)))
          .addMethod(
            getAudioAndVideoCallMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest,
                com.lanjiu.pro.friend_msg.AudioAndVideoCallResponse>(
                  this, METHODID_AUDIO_AND_VIDEO_CALL_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class MessageFriendServiceStub extends io.grpc.stub.AbstractStub<MessageFriendServiceStub> {
    private MessageFriendServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessageFriendServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageFriendServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageFriendServiceStub(channel, callOptions);
    }

    /**
     */
    public void storageFriendMessage(com.lanjiu.pro.friend_msg.RequestFriendMessage request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStorageFriendMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeFriendMessage(com.lanjiu.pro.friend_msg.RequestFriendMessage request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveFriendMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectFriendMessage(com.lanjiu.pro.friend_msg.RequestFriendMessage request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectFriendMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void storageFriendMessageOn(com.lanjiu.pro.friend_msg.RequestFriendMessage request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStorageFriendMessageOnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeFriendMessageOn(com.lanjiu.pro.friend_msg.RequestFriendMessage request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveFriendMessageOnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectFriendMessageOn(com.lanjiu.pro.friend_msg.RequestFriendMessage request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectFriendMessageOnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void audioAndVideoCallMessage(com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.AudioAndVideoCallResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAudioAndVideoCallMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MessageFriendServiceBlockingStub extends io.grpc.stub.AbstractStub<MessageFriendServiceBlockingStub> {
    private MessageFriendServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessageFriendServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageFriendServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageFriendServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.lanjiu.pro.friend_msg.ResponseFriendMessage storageFriendMessage(com.lanjiu.pro.friend_msg.RequestFriendMessage request) {
      return blockingUnaryCall(
          getChannel(), getStorageFriendMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.friend_msg.ResponseFriendMessage removeFriendMessage(com.lanjiu.pro.friend_msg.RequestFriendMessage request) {
      return blockingUnaryCall(
          getChannel(), getRemoveFriendMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.friend_msg.ResponseFriendMessage selectFriendMessage(com.lanjiu.pro.friend_msg.RequestFriendMessage request) {
      return blockingUnaryCall(
          getChannel(), getSelectFriendMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.friend_msg.ResponseFriendMessage storageFriendMessageOn(com.lanjiu.pro.friend_msg.RequestFriendMessage request) {
      return blockingUnaryCall(
          getChannel(), getStorageFriendMessageOnMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.friend_msg.ResponseFriendMessage removeFriendMessageOn(com.lanjiu.pro.friend_msg.RequestFriendMessage request) {
      return blockingUnaryCall(
          getChannel(), getRemoveFriendMessageOnMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.friend_msg.ResponseFriendMessage selectFriendMessageOn(com.lanjiu.pro.friend_msg.RequestFriendMessage request) {
      return blockingUnaryCall(
          getChannel(), getSelectFriendMessageOnMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.friend_msg.AudioAndVideoCallResponse audioAndVideoCallMessage(com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest request) {
      return blockingUnaryCall(
          getChannel(), getAudioAndVideoCallMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MessageFriendServiceFutureStub extends io.grpc.stub.AbstractStub<MessageFriendServiceFutureStub> {
    private MessageFriendServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessageFriendServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageFriendServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageFriendServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.friend_msg.ResponseFriendMessage> storageFriendMessage(
        com.lanjiu.pro.friend_msg.RequestFriendMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getStorageFriendMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.friend_msg.ResponseFriendMessage> removeFriendMessage(
        com.lanjiu.pro.friend_msg.RequestFriendMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveFriendMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.friend_msg.ResponseFriendMessage> selectFriendMessage(
        com.lanjiu.pro.friend_msg.RequestFriendMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectFriendMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.friend_msg.ResponseFriendMessage> storageFriendMessageOn(
        com.lanjiu.pro.friend_msg.RequestFriendMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getStorageFriendMessageOnMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.friend_msg.ResponseFriendMessage> removeFriendMessageOn(
        com.lanjiu.pro.friend_msg.RequestFriendMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveFriendMessageOnMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.friend_msg.ResponseFriendMessage> selectFriendMessageOn(
        com.lanjiu.pro.friend_msg.RequestFriendMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectFriendMessageOnMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.friend_msg.AudioAndVideoCallResponse> audioAndVideoCallMessage(
        com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAudioAndVideoCallMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STORAGE_FRIEND_MESSAGE = 0;
  private static final int METHODID_REMOVE_FRIEND_MESSAGE = 1;
  private static final int METHODID_SELECT_FRIEND_MESSAGE = 2;
  private static final int METHODID_STORAGE_FRIEND_MESSAGE_ON = 3;
  private static final int METHODID_REMOVE_FRIEND_MESSAGE_ON = 4;
  private static final int METHODID_SELECT_FRIEND_MESSAGE_ON = 5;
  private static final int METHODID_AUDIO_AND_VIDEO_CALL_MESSAGE = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessageFriendServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MessageFriendServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STORAGE_FRIEND_MESSAGE:
          serviceImpl.storageFriendMessage((com.lanjiu.pro.friend_msg.RequestFriendMessage) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage>) responseObserver);
          break;
        case METHODID_REMOVE_FRIEND_MESSAGE:
          serviceImpl.removeFriendMessage((com.lanjiu.pro.friend_msg.RequestFriendMessage) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage>) responseObserver);
          break;
        case METHODID_SELECT_FRIEND_MESSAGE:
          serviceImpl.selectFriendMessage((com.lanjiu.pro.friend_msg.RequestFriendMessage) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage>) responseObserver);
          break;
        case METHODID_STORAGE_FRIEND_MESSAGE_ON:
          serviceImpl.storageFriendMessageOn((com.lanjiu.pro.friend_msg.RequestFriendMessage) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage>) responseObserver);
          break;
        case METHODID_REMOVE_FRIEND_MESSAGE_ON:
          serviceImpl.removeFriendMessageOn((com.lanjiu.pro.friend_msg.RequestFriendMessage) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage>) responseObserver);
          break;
        case METHODID_SELECT_FRIEND_MESSAGE_ON:
          serviceImpl.selectFriendMessageOn((com.lanjiu.pro.friend_msg.RequestFriendMessage) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.ResponseFriendMessage>) responseObserver);
          break;
        case METHODID_AUDIO_AND_VIDEO_CALL_MESSAGE:
          serviceImpl.audioAndVideoCallMessage((com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.friend_msg.AudioAndVideoCallResponse>) responseObserver);
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

  private static abstract class MessageFriendServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessageFriendServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.lanjiu.pro.friend_msg.MessageFriendStorageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MessageFriendService");
    }
  }

  private static final class MessageFriendServiceFileDescriptorSupplier
      extends MessageFriendServiceBaseDescriptorSupplier {
    MessageFriendServiceFileDescriptorSupplier() {}
  }

  private static final class MessageFriendServiceMethodDescriptorSupplier
      extends MessageFriendServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MessageFriendServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MessageFriendServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessageFriendServiceFileDescriptorSupplier())
              .addMethod(getStorageFriendMessageMethod())
              .addMethod(getRemoveFriendMessageMethod())
              .addMethod(getSelectFriendMessageMethod())
              .addMethod(getStorageFriendMessageOnMethod())
              .addMethod(getRemoveFriendMessageOnMethod())
              .addMethod(getSelectFriendMessageOnMethod())
              .addMethod(getAudioAndVideoCallMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
