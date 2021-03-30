package com.lanjiu.pro.login;

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
    comments = "Source: login_regist_storage.proto")
public final class RegisterStorageServiceGrpc {

  private RegisterStorageServiceGrpc() {}

  public static final String SERVICE_NAME = "com.lanjiu.pro.login.RegisterStorageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RegisterStorageProto.RequestUser,
      com.lanjiu.pro.login.RegisterStorageProto.ResponseUser> getSelectUserInfomationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SelectUserInfomation",
      requestType = com.lanjiu.pro.login.RegisterStorageProto.RequestUser.class,
      responseType = com.lanjiu.pro.login.RegisterStorageProto.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RegisterStorageProto.RequestUser,
      com.lanjiu.pro.login.RegisterStorageProto.ResponseUser> getSelectUserInfomationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RegisterStorageProto.RequestUser, com.lanjiu.pro.login.RegisterStorageProto.ResponseUser> getSelectUserInfomationMethod;
    if ((getSelectUserInfomationMethod = RegisterStorageServiceGrpc.getSelectUserInfomationMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getSelectUserInfomationMethod = RegisterStorageServiceGrpc.getSelectUserInfomationMethod) == null) {
          RegisterStorageServiceGrpc.getSelectUserInfomationMethod = getSelectUserInfomationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RegisterStorageProto.RequestUser, com.lanjiu.pro.login.RegisterStorageProto.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SelectUserInfomation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RegisterStorageProto.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RegisterStorageProto.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("SelectUserInfomation"))
              .build();
        }
      }
    }
    return getSelectUserInfomationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RegisterStorageProto.RequestUser,
      com.lanjiu.pro.login.RegisterStorageProto.ResponseUser> getSelectGuestUserInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SelectGuestUserInfo",
      requestType = com.lanjiu.pro.login.RegisterStorageProto.RequestUser.class,
      responseType = com.lanjiu.pro.login.RegisterStorageProto.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RegisterStorageProto.RequestUser,
      com.lanjiu.pro.login.RegisterStorageProto.ResponseUser> getSelectGuestUserInfoMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RegisterStorageProto.RequestUser, com.lanjiu.pro.login.RegisterStorageProto.ResponseUser> getSelectGuestUserInfoMethod;
    if ((getSelectGuestUserInfoMethod = RegisterStorageServiceGrpc.getSelectGuestUserInfoMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getSelectGuestUserInfoMethod = RegisterStorageServiceGrpc.getSelectGuestUserInfoMethod) == null) {
          RegisterStorageServiceGrpc.getSelectGuestUserInfoMethod = getSelectGuestUserInfoMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RegisterStorageProto.RequestUser, com.lanjiu.pro.login.RegisterStorageProto.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SelectGuestUserInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RegisterStorageProto.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RegisterStorageProto.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("SelectGuestUserInfo"))
              .build();
        }
      }
    }
    return getSelectGuestUserInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegisterStorageServiceStub newStub(io.grpc.Channel channel) {
    return new RegisterStorageServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegisterStorageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RegisterStorageServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegisterStorageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RegisterStorageServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class RegisterStorageServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *獲取註冊用戶個人設置信息及基本信息
     * </pre>
     */
    public void selectUserInfomation(com.lanjiu.pro.login.RegisterStorageProto.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.RegisterStorageProto.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectUserInfomationMethod(), responseObserver);
    }

    /**
     * <pre>
     *獲取遊客用戶個人設置信息及基本信息
     * </pre>
     */
    public void selectGuestUserInfo(com.lanjiu.pro.login.RegisterStorageProto.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.RegisterStorageProto.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGuestUserInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSelectUserInfomationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RegisterStorageProto.RequestUser,
                com.lanjiu.pro.login.RegisterStorageProto.ResponseUser>(
                  this, METHODID_SELECT_USER_INFOMATION)))
          .addMethod(
            getSelectGuestUserInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RegisterStorageProto.RequestUser,
                com.lanjiu.pro.login.RegisterStorageProto.ResponseUser>(
                  this, METHODID_SELECT_GUEST_USER_INFO)))
          .build();
    }
  }

  /**
   */
  public static final class RegisterStorageServiceStub extends io.grpc.stub.AbstractStub<RegisterStorageServiceStub> {
    private RegisterStorageServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegisterStorageServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterStorageServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegisterStorageServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *獲取註冊用戶個人設置信息及基本信息
     * </pre>
     */
    public void selectUserInfomation(com.lanjiu.pro.login.RegisterStorageProto.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.RegisterStorageProto.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectUserInfomationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *獲取遊客用戶個人設置信息及基本信息
     * </pre>
     */
    public void selectGuestUserInfo(com.lanjiu.pro.login.RegisterStorageProto.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.RegisterStorageProto.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGuestUserInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RegisterStorageServiceBlockingStub extends io.grpc.stub.AbstractStub<RegisterStorageServiceBlockingStub> {
    private RegisterStorageServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegisterStorageServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterStorageServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegisterStorageServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *獲取註冊用戶個人設置信息及基本信息
     * </pre>
     */
    public com.lanjiu.pro.login.RegisterStorageProto.ResponseUser selectUserInfomation(com.lanjiu.pro.login.RegisterStorageProto.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getSelectUserInfomationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *獲取遊客用戶個人設置信息及基本信息
     * </pre>
     */
    public com.lanjiu.pro.login.RegisterStorageProto.ResponseUser selectGuestUserInfo(com.lanjiu.pro.login.RegisterStorageProto.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getSelectGuestUserInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RegisterStorageServiceFutureStub extends io.grpc.stub.AbstractStub<RegisterStorageServiceFutureStub> {
    private RegisterStorageServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegisterStorageServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterStorageServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegisterStorageServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *獲取註冊用戶個人設置信息及基本信息
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.RegisterStorageProto.ResponseUser> selectUserInfomation(
        com.lanjiu.pro.login.RegisterStorageProto.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectUserInfomationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *獲取遊客用戶個人設置信息及基本信息
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.RegisterStorageProto.ResponseUser> selectGuestUserInfo(
        com.lanjiu.pro.login.RegisterStorageProto.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGuestUserInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SELECT_USER_INFOMATION = 0;
  private static final int METHODID_SELECT_GUEST_USER_INFO = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RegisterStorageServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegisterStorageServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SELECT_USER_INFOMATION:
          serviceImpl.selectUserInfomation((com.lanjiu.pro.login.RegisterStorageProto.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.RegisterStorageProto.ResponseUser>) responseObserver);
          break;
        case METHODID_SELECT_GUEST_USER_INFO:
          serviceImpl.selectGuestUserInfo((com.lanjiu.pro.login.RegisterStorageProto.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.RegisterStorageProto.ResponseUser>) responseObserver);
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

  private static abstract class RegisterStorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegisterStorageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.lanjiu.pro.login.RegisterStorageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RegisterStorageService");
    }
  }

  private static final class RegisterStorageServiceFileDescriptorSupplier
      extends RegisterStorageServiceBaseDescriptorSupplier {
    RegisterStorageServiceFileDescriptorSupplier() {}
  }

  private static final class RegisterStorageServiceMethodDescriptorSupplier
      extends RegisterStorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RegisterStorageServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RegisterStorageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegisterStorageServiceFileDescriptorSupplier())
              .addMethod(getSelectUserInfomationMethod())
              .addMethod(getSelectGuestUserInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
