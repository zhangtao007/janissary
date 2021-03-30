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
  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupResponse> getQueryGroupInfoByListIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "queryGroupInfoByListId",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupResponse> getQueryGroupInfoByListIdMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupResponse> getQueryGroupInfoByListIdMethod;
    if ((getQueryGroupInfoByListIdMethod = InformationStorageServiceGrpc.getQueryGroupInfoByListIdMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getQueryGroupInfoByListIdMethod = InformationStorageServiceGrpc.getQueryGroupInfoByListIdMethod) == null) {
          InformationStorageServiceGrpc.getQueryGroupInfoByListIdMethod = getQueryGroupInfoByListIdMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "queryGroupInfoByListId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("queryGroupInfoByListId"))
              .build();
        }
      }
    }
    return getQueryGroupInfoByListIdMethod;
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
    public void queryGroupInfoByListId(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getQueryGroupInfoByListIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getQueryGroupInfoByListIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupResponse>(
                  this, METHODID_QUERY_GROUP_INFO_BY_LIST_ID)))
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
    public void queryGroupInfoByListId(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getQueryGroupInfoByListIdMethod(), getCallOptions()), request, responseObserver);
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
    public com.lanjiu.im.grpc.RegisteredGroupResponse queryGroupInfoByListId(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getQueryGroupInfoByListIdMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupResponse> queryGroupInfoByListId(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getQueryGroupInfoByListIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_QUERY_GROUP_INFO_BY_LIST_ID = 0;

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
        case METHODID_QUERY_GROUP_INFO_BY_LIST_ID:
          serviceImpl.queryGroupInfoByListId((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupResponse>) responseObserver);
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
              .addMethod(getQueryGroupInfoByListIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
