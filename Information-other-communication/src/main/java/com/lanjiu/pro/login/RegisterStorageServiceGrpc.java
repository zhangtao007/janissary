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
  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getStorageRegisterUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StorageRegisterUser",
      requestType = com.lanjiu.pro.login.RequestUser.class,
      responseType = com.lanjiu.pro.login.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getStorageRegisterUserMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser> getStorageRegisterUserMethod;
    if ((getStorageRegisterUserMethod = RegisterStorageServiceGrpc.getStorageRegisterUserMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getStorageRegisterUserMethod = RegisterStorageServiceGrpc.getStorageRegisterUserMethod) == null) {
          RegisterStorageServiceGrpc.getStorageRegisterUserMethod = getStorageRegisterUserMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StorageRegisterUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("StorageRegisterUser"))
              .build();
        }
      }
    }
    return getStorageRegisterUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getStorageGuestUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StorageGuestUser",
      requestType = com.lanjiu.pro.login.RequestUser.class,
      responseType = com.lanjiu.pro.login.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getStorageGuestUserMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser> getStorageGuestUserMethod;
    if ((getStorageGuestUserMethod = RegisterStorageServiceGrpc.getStorageGuestUserMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getStorageGuestUserMethod = RegisterStorageServiceGrpc.getStorageGuestUserMethod) == null) {
          RegisterStorageServiceGrpc.getStorageGuestUserMethod = getStorageGuestUserMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StorageGuestUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("StorageGuestUser"))
              .build();
        }
      }
    }
    return getStorageGuestUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getStorageUserInfomationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "storageUserInfomation",
      requestType = com.lanjiu.pro.login.RequestUser.class,
      responseType = com.lanjiu.pro.login.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getStorageUserInfomationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser> getStorageUserInfomationMethod;
    if ((getStorageUserInfomationMethod = RegisterStorageServiceGrpc.getStorageUserInfomationMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getStorageUserInfomationMethod = RegisterStorageServiceGrpc.getStorageUserInfomationMethod) == null) {
          RegisterStorageServiceGrpc.getStorageUserInfomationMethod = getStorageUserInfomationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "storageUserInfomation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("storageUserInfomation"))
              .build();
        }
      }
    }
    return getStorageUserInfomationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getStorageGuestUserInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "storageGuestUserInfo",
      requestType = com.lanjiu.pro.login.RequestUser.class,
      responseType = com.lanjiu.pro.login.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getStorageGuestUserInfoMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser> getStorageGuestUserInfoMethod;
    if ((getStorageGuestUserInfoMethod = RegisterStorageServiceGrpc.getStorageGuestUserInfoMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getStorageGuestUserInfoMethod = RegisterStorageServiceGrpc.getStorageGuestUserInfoMethod) == null) {
          RegisterStorageServiceGrpc.getStorageGuestUserInfoMethod = getStorageGuestUserInfoMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "storageGuestUserInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("storageGuestUserInfo"))
              .build();
        }
      }
    }
    return getStorageGuestUserInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getSelectUserInfomationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SelectUserInfomation",
      requestType = com.lanjiu.pro.login.RequestUser.class,
      responseType = com.lanjiu.pro.login.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getSelectUserInfomationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser> getSelectUserInfomationMethod;
    if ((getSelectUserInfomationMethod = RegisterStorageServiceGrpc.getSelectUserInfomationMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getSelectUserInfomationMethod = RegisterStorageServiceGrpc.getSelectUserInfomationMethod) == null) {
          RegisterStorageServiceGrpc.getSelectUserInfomationMethod = getSelectUserInfomationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SelectUserInfomation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("SelectUserInfomation"))
              .build();
        }
      }
    }
    return getSelectUserInfomationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getSelectGuestUserInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SelectGuestUserInfo",
      requestType = com.lanjiu.pro.login.RequestUser.class,
      responseType = com.lanjiu.pro.login.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getSelectGuestUserInfoMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser> getSelectGuestUserInfoMethod;
    if ((getSelectGuestUserInfoMethod = RegisterStorageServiceGrpc.getSelectGuestUserInfoMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getSelectGuestUserInfoMethod = RegisterStorageServiceGrpc.getSelectGuestUserInfoMethod) == null) {
          RegisterStorageServiceGrpc.getSelectGuestUserInfoMethod = getSelectGuestUserInfoMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SelectGuestUserInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("SelectGuestUserInfo"))
              .build();
        }
      }
    }
    return getSelectGuestUserInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getLoginRegistUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LoginRegistUser",
      requestType = com.lanjiu.pro.login.RequestUser.class,
      responseType = com.lanjiu.pro.login.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getLoginRegistUserMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser> getLoginRegistUserMethod;
    if ((getLoginRegistUserMethod = RegisterStorageServiceGrpc.getLoginRegistUserMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getLoginRegistUserMethod = RegisterStorageServiceGrpc.getLoginRegistUserMethod) == null) {
          RegisterStorageServiceGrpc.getLoginRegistUserMethod = getLoginRegistUserMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LoginRegistUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("LoginRegistUser"))
              .build();
        }
      }
    }
    return getLoginRegistUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getLoginGuestUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LoginGuestUser",
      requestType = com.lanjiu.pro.login.RequestUser.class,
      responseType = com.lanjiu.pro.login.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getLoginGuestUserMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser> getLoginGuestUserMethod;
    if ((getLoginGuestUserMethod = RegisterStorageServiceGrpc.getLoginGuestUserMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getLoginGuestUserMethod = RegisterStorageServiceGrpc.getLoginGuestUserMethod) == null) {
          RegisterStorageServiceGrpc.getLoginGuestUserMethod = getLoginGuestUserMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LoginGuestUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("LoginGuestUser"))
              .build();
        }
      }
    }
    return getLoginGuestUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getLogoutRegistUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LogoutRegistUser",
      requestType = com.lanjiu.pro.login.RequestUser.class,
      responseType = com.lanjiu.pro.login.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getLogoutRegistUserMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser> getLogoutRegistUserMethod;
    if ((getLogoutRegistUserMethod = RegisterStorageServiceGrpc.getLogoutRegistUserMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getLogoutRegistUserMethod = RegisterStorageServiceGrpc.getLogoutRegistUserMethod) == null) {
          RegisterStorageServiceGrpc.getLogoutRegistUserMethod = getLogoutRegistUserMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LogoutRegistUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("LogoutRegistUser"))
              .build();
        }
      }
    }
    return getLogoutRegistUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getLogoutGuestUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LogoutGuestUser",
      requestType = com.lanjiu.pro.login.RequestUser.class,
      responseType = com.lanjiu.pro.login.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getLogoutGuestUserMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser> getLogoutGuestUserMethod;
    if ((getLogoutGuestUserMethod = RegisterStorageServiceGrpc.getLogoutGuestUserMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getLogoutGuestUserMethod = RegisterStorageServiceGrpc.getLogoutGuestUserMethod) == null) {
          RegisterStorageServiceGrpc.getLogoutGuestUserMethod = getLogoutGuestUserMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LogoutGuestUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("LogoutGuestUser"))
              .build();
        }
      }
    }
    return getLogoutGuestUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getDeleteRegisterUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRegisterUser",
      requestType = com.lanjiu.pro.login.RequestUser.class,
      responseType = com.lanjiu.pro.login.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getDeleteRegisterUserMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser> getDeleteRegisterUserMethod;
    if ((getDeleteRegisterUserMethod = RegisterStorageServiceGrpc.getDeleteRegisterUserMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getDeleteRegisterUserMethod = RegisterStorageServiceGrpc.getDeleteRegisterUserMethod) == null) {
          RegisterStorageServiceGrpc.getDeleteRegisterUserMethod = getDeleteRegisterUserMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRegisterUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("DeleteRegisterUser"))
              .build();
        }
      }
    }
    return getDeleteRegisterUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getDeleteGuestUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGuestUser",
      requestType = com.lanjiu.pro.login.RequestUser.class,
      responseType = com.lanjiu.pro.login.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getDeleteGuestUserMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser> getDeleteGuestUserMethod;
    if ((getDeleteGuestUserMethod = RegisterStorageServiceGrpc.getDeleteGuestUserMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getDeleteGuestUserMethod = RegisterStorageServiceGrpc.getDeleteGuestUserMethod) == null) {
          RegisterStorageServiceGrpc.getDeleteGuestUserMethod = getDeleteGuestUserMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteGuestUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("DeleteGuestUser"))
              .build();
        }
      }
    }
    return getDeleteGuestUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getUpdateUserInfomationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUserInfomation",
      requestType = com.lanjiu.pro.login.RequestUser.class,
      responseType = com.lanjiu.pro.login.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getUpdateUserInfomationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser> getUpdateUserInfomationMethod;
    if ((getUpdateUserInfomationMethod = RegisterStorageServiceGrpc.getUpdateUserInfomationMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getUpdateUserInfomationMethod = RegisterStorageServiceGrpc.getUpdateUserInfomationMethod) == null) {
          RegisterStorageServiceGrpc.getUpdateUserInfomationMethod = getUpdateUserInfomationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUserInfomation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("UpdateUserInfomation"))
              .build();
        }
      }
    }
    return getUpdateUserInfomationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getUpdateGuestUserInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGuestUserInfo",
      requestType = com.lanjiu.pro.login.RequestUser.class,
      responseType = com.lanjiu.pro.login.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getUpdateGuestUserInfoMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser> getUpdateGuestUserInfoMethod;
    if ((getUpdateGuestUserInfoMethod = RegisterStorageServiceGrpc.getUpdateGuestUserInfoMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getUpdateGuestUserInfoMethod = RegisterStorageServiceGrpc.getUpdateGuestUserInfoMethod) == null) {
          RegisterStorageServiceGrpc.getUpdateGuestUserInfoMethod = getUpdateGuestUserInfoMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateGuestUserInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("UpdateGuestUserInfo"))
              .build();
        }
      }
    }
    return getUpdateGuestUserInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getSeekPasswordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SeekPassword",
      requestType = com.lanjiu.pro.login.RequestUser.class,
      responseType = com.lanjiu.pro.login.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getSeekPasswordMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser> getSeekPasswordMethod;
    if ((getSeekPasswordMethod = RegisterStorageServiceGrpc.getSeekPasswordMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getSeekPasswordMethod = RegisterStorageServiceGrpc.getSeekPasswordMethod) == null) {
          RegisterStorageServiceGrpc.getSeekPasswordMethod = getSeekPasswordMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SeekPassword"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("SeekPassword"))
              .build();
        }
      }
    }
    return getSeekPasswordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getVerificationCodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerificationCode",
      requestType = com.lanjiu.pro.login.RequestUser.class,
      responseType = com.lanjiu.pro.login.ResponseUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser,
      com.lanjiu.pro.login.ResponseUser> getVerificationCodeMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser> getVerificationCodeMethod;
    if ((getVerificationCodeMethod = RegisterStorageServiceGrpc.getVerificationCodeMethod) == null) {
      synchronized (RegisterStorageServiceGrpc.class) {
        if ((getVerificationCodeMethod = RegisterStorageServiceGrpc.getVerificationCodeMethod) == null) {
          RegisterStorageServiceGrpc.getVerificationCodeMethod = getVerificationCodeMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.pro.login.RequestUser, com.lanjiu.pro.login.ResponseUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VerificationCode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.RequestUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.pro.login.ResponseUser.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterStorageServiceMethodDescriptorSupplier("VerificationCode"))
              .build();
        }
      }
    }
    return getVerificationCodeMethod;
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
     *保存注册用户
     * </pre>
     */
    public void storageRegisterUser(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getStorageRegisterUserMethod(), responseObserver);
    }

    /**
     * <pre>
     *保存游客
     * </pre>
     */
    public void storageGuestUser(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getStorageGuestUserMethod(), responseObserver);
    }

    /**
     * <pre>
     *保存注册个人设置
     * </pre>
     */
    public void storageUserInfomation(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getStorageUserInfomationMethod(), responseObserver);
    }

    /**
     * <pre>
     *保存游客个人设置
     * </pre>
     */
    public void storageGuestUserInfo(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getStorageGuestUserInfoMethod(), responseObserver);
    }

    /**
     * <pre>
     *獲取註冊用戶個人設置信息及基本信息
     * </pre>
     */
    public void selectUserInfomation(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectUserInfomationMethod(), responseObserver);
    }

    /**
     * <pre>
     *獲取遊客用戶個人設置信息及基本信息
     * </pre>
     */
    public void selectGuestUserInfo(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGuestUserInfoMethod(), responseObserver);
    }

    /**
     * <pre>
     *注册用户登录
     * </pre>
     */
    public void loginRegistUser(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginRegistUserMethod(), responseObserver);
    }

    /**
     * <pre>
     *游客登录
     * </pre>
     */
    public void loginGuestUser(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginGuestUserMethod(), responseObserver);
    }

    /**
     */
    public void logoutRegistUser(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutRegistUserMethod(), responseObserver);
    }

    /**
     */
    public void logoutGuestUser(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutGuestUserMethod(), responseObserver);
    }

    /**
     */
    public void deleteRegisterUser(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteRegisterUserMethod(), responseObserver);
    }

    /**
     */
    public void deleteGuestUser(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGuestUserMethod(), responseObserver);
    }

    /**
     */
    public void updateUserInfomation(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateUserInfomationMethod(), responseObserver);
    }

    /**
     */
    public void updateGuestUserInfo(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGuestUserInfoMethod(), responseObserver);
    }

    /**
     */
    public void seekPassword(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getSeekPasswordMethod(), responseObserver);
    }

    /**
     */
    public void verificationCode(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnimplementedUnaryCall(getVerificationCodeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStorageRegisterUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RequestUser,
                com.lanjiu.pro.login.ResponseUser>(
                  this, METHODID_STORAGE_REGISTER_USER)))
          .addMethod(
            getStorageGuestUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RequestUser,
                com.lanjiu.pro.login.ResponseUser>(
                  this, METHODID_STORAGE_GUEST_USER)))
          .addMethod(
            getStorageUserInfomationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RequestUser,
                com.lanjiu.pro.login.ResponseUser>(
                  this, METHODID_STORAGE_USER_INFOMATION)))
          .addMethod(
            getStorageGuestUserInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RequestUser,
                com.lanjiu.pro.login.ResponseUser>(
                  this, METHODID_STORAGE_GUEST_USER_INFO)))
          .addMethod(
            getSelectUserInfomationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RequestUser,
                com.lanjiu.pro.login.ResponseUser>(
                  this, METHODID_SELECT_USER_INFOMATION)))
          .addMethod(
            getSelectGuestUserInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RequestUser,
                com.lanjiu.pro.login.ResponseUser>(
                  this, METHODID_SELECT_GUEST_USER_INFO)))
          .addMethod(
            getLoginRegistUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RequestUser,
                com.lanjiu.pro.login.ResponseUser>(
                  this, METHODID_LOGIN_REGIST_USER)))
          .addMethod(
            getLoginGuestUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RequestUser,
                com.lanjiu.pro.login.ResponseUser>(
                  this, METHODID_LOGIN_GUEST_USER)))
          .addMethod(
            getLogoutRegistUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RequestUser,
                com.lanjiu.pro.login.ResponseUser>(
                  this, METHODID_LOGOUT_REGIST_USER)))
          .addMethod(
            getLogoutGuestUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RequestUser,
                com.lanjiu.pro.login.ResponseUser>(
                  this, METHODID_LOGOUT_GUEST_USER)))
          .addMethod(
            getDeleteRegisterUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RequestUser,
                com.lanjiu.pro.login.ResponseUser>(
                  this, METHODID_DELETE_REGISTER_USER)))
          .addMethod(
            getDeleteGuestUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RequestUser,
                com.lanjiu.pro.login.ResponseUser>(
                  this, METHODID_DELETE_GUEST_USER)))
          .addMethod(
            getUpdateUserInfomationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RequestUser,
                com.lanjiu.pro.login.ResponseUser>(
                  this, METHODID_UPDATE_USER_INFOMATION)))
          .addMethod(
            getUpdateGuestUserInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RequestUser,
                com.lanjiu.pro.login.ResponseUser>(
                  this, METHODID_UPDATE_GUEST_USER_INFO)))
          .addMethod(
            getSeekPasswordMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RequestUser,
                com.lanjiu.pro.login.ResponseUser>(
                  this, METHODID_SEEK_PASSWORD)))
          .addMethod(
            getVerificationCodeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.pro.login.RequestUser,
                com.lanjiu.pro.login.ResponseUser>(
                  this, METHODID_VERIFICATION_CODE)))
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
     *保存注册用户
     * </pre>
     */
    public void storageRegisterUser(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStorageRegisterUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *保存游客
     * </pre>
     */
    public void storageGuestUser(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStorageGuestUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *保存注册个人设置
     * </pre>
     */
    public void storageUserInfomation(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStorageUserInfomationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *保存游客个人设置
     * </pre>
     */
    public void storageGuestUserInfo(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStorageGuestUserInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *獲取註冊用戶個人設置信息及基本信息
     * </pre>
     */
    public void selectUserInfomation(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectUserInfomationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *獲取遊客用戶個人設置信息及基本信息
     * </pre>
     */
    public void selectGuestUserInfo(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGuestUserInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *注册用户登录
     * </pre>
     */
    public void loginRegistUser(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginRegistUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *游客登录
     * </pre>
     */
    public void loginGuestUser(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginGuestUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logoutRegistUser(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutRegistUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logoutGuestUser(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutGuestUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteRegisterUser(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteRegisterUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGuestUser(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGuestUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUserInfomation(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateUserInfomationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateGuestUserInfo(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGuestUserInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void seekPassword(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSeekPasswordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void verificationCode(com.lanjiu.pro.login.RequestUser request,
        io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getVerificationCodeMethod(), getCallOptions()), request, responseObserver);
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
     *保存注册用户
     * </pre>
     */
    public com.lanjiu.pro.login.ResponseUser storageRegisterUser(com.lanjiu.pro.login.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getStorageRegisterUserMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *保存游客
     * </pre>
     */
    public com.lanjiu.pro.login.ResponseUser storageGuestUser(com.lanjiu.pro.login.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getStorageGuestUserMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *保存注册个人设置
     * </pre>
     */
    public com.lanjiu.pro.login.ResponseUser storageUserInfomation(com.lanjiu.pro.login.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getStorageUserInfomationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *保存游客个人设置
     * </pre>
     */
    public com.lanjiu.pro.login.ResponseUser storageGuestUserInfo(com.lanjiu.pro.login.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getStorageGuestUserInfoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *獲取註冊用戶個人設置信息及基本信息
     * </pre>
     */
    public com.lanjiu.pro.login.ResponseUser selectUserInfomation(com.lanjiu.pro.login.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getSelectUserInfomationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *獲取遊客用戶個人設置信息及基本信息
     * </pre>
     */
    public com.lanjiu.pro.login.ResponseUser selectGuestUserInfo(com.lanjiu.pro.login.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getSelectGuestUserInfoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *注册用户登录
     * </pre>
     */
    public com.lanjiu.pro.login.ResponseUser loginRegistUser(com.lanjiu.pro.login.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getLoginRegistUserMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *游客登录
     * </pre>
     */
    public com.lanjiu.pro.login.ResponseUser loginGuestUser(com.lanjiu.pro.login.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getLoginGuestUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.login.ResponseUser logoutRegistUser(com.lanjiu.pro.login.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getLogoutRegistUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.login.ResponseUser logoutGuestUser(com.lanjiu.pro.login.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getLogoutGuestUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.login.ResponseUser deleteRegisterUser(com.lanjiu.pro.login.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getDeleteRegisterUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.login.ResponseUser deleteGuestUser(com.lanjiu.pro.login.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGuestUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.login.ResponseUser updateUserInfomation(com.lanjiu.pro.login.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getUpdateUserInfomationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.login.ResponseUser updateGuestUserInfo(com.lanjiu.pro.login.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGuestUserInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.login.ResponseUser seekPassword(com.lanjiu.pro.login.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getSeekPasswordMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.pro.login.ResponseUser verificationCode(com.lanjiu.pro.login.RequestUser request) {
      return blockingUnaryCall(
          getChannel(), getVerificationCodeMethod(), getCallOptions(), request);
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
     *保存注册用户
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.ResponseUser> storageRegisterUser(
        com.lanjiu.pro.login.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getStorageRegisterUserMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *保存游客
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.ResponseUser> storageGuestUser(
        com.lanjiu.pro.login.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getStorageGuestUserMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *保存注册个人设置
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.ResponseUser> storageUserInfomation(
        com.lanjiu.pro.login.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getStorageUserInfomationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *保存游客个人设置
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.ResponseUser> storageGuestUserInfo(
        com.lanjiu.pro.login.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getStorageGuestUserInfoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *獲取註冊用戶個人設置信息及基本信息
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.ResponseUser> selectUserInfomation(
        com.lanjiu.pro.login.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectUserInfomationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *獲取遊客用戶個人設置信息及基本信息
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.ResponseUser> selectGuestUserInfo(
        com.lanjiu.pro.login.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGuestUserInfoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *注册用户登录
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.ResponseUser> loginRegistUser(
        com.lanjiu.pro.login.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginRegistUserMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *游客登录
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.ResponseUser> loginGuestUser(
        com.lanjiu.pro.login.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginGuestUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.ResponseUser> logoutRegistUser(
        com.lanjiu.pro.login.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutRegistUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.ResponseUser> logoutGuestUser(
        com.lanjiu.pro.login.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutGuestUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.ResponseUser> deleteRegisterUser(
        com.lanjiu.pro.login.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteRegisterUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.ResponseUser> deleteGuestUser(
        com.lanjiu.pro.login.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGuestUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.ResponseUser> updateUserInfomation(
        com.lanjiu.pro.login.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateUserInfomationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.ResponseUser> updateGuestUserInfo(
        com.lanjiu.pro.login.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGuestUserInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.ResponseUser> seekPassword(
        com.lanjiu.pro.login.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getSeekPasswordMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.pro.login.ResponseUser> verificationCode(
        com.lanjiu.pro.login.RequestUser request) {
      return futureUnaryCall(
          getChannel().newCall(getVerificationCodeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STORAGE_REGISTER_USER = 0;
  private static final int METHODID_STORAGE_GUEST_USER = 1;
  private static final int METHODID_STORAGE_USER_INFOMATION = 2;
  private static final int METHODID_STORAGE_GUEST_USER_INFO = 3;
  private static final int METHODID_SELECT_USER_INFOMATION = 4;
  private static final int METHODID_SELECT_GUEST_USER_INFO = 5;
  private static final int METHODID_LOGIN_REGIST_USER = 6;
  private static final int METHODID_LOGIN_GUEST_USER = 7;
  private static final int METHODID_LOGOUT_REGIST_USER = 8;
  private static final int METHODID_LOGOUT_GUEST_USER = 9;
  private static final int METHODID_DELETE_REGISTER_USER = 10;
  private static final int METHODID_DELETE_GUEST_USER = 11;
  private static final int METHODID_UPDATE_USER_INFOMATION = 12;
  private static final int METHODID_UPDATE_GUEST_USER_INFO = 13;
  private static final int METHODID_SEEK_PASSWORD = 14;
  private static final int METHODID_VERIFICATION_CODE = 15;

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
        case METHODID_STORAGE_REGISTER_USER:
          serviceImpl.storageRegisterUser((com.lanjiu.pro.login.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser>) responseObserver);
          break;
        case METHODID_STORAGE_GUEST_USER:
          serviceImpl.storageGuestUser((com.lanjiu.pro.login.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser>) responseObserver);
          break;
        case METHODID_STORAGE_USER_INFOMATION:
          serviceImpl.storageUserInfomation((com.lanjiu.pro.login.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser>) responseObserver);
          break;
        case METHODID_STORAGE_GUEST_USER_INFO:
          serviceImpl.storageGuestUserInfo((com.lanjiu.pro.login.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser>) responseObserver);
          break;
        case METHODID_SELECT_USER_INFOMATION:
          serviceImpl.selectUserInfomation((com.lanjiu.pro.login.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser>) responseObserver);
          break;
        case METHODID_SELECT_GUEST_USER_INFO:
          serviceImpl.selectGuestUserInfo((com.lanjiu.pro.login.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser>) responseObserver);
          break;
        case METHODID_LOGIN_REGIST_USER:
          serviceImpl.loginRegistUser((com.lanjiu.pro.login.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser>) responseObserver);
          break;
        case METHODID_LOGIN_GUEST_USER:
          serviceImpl.loginGuestUser((com.lanjiu.pro.login.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser>) responseObserver);
          break;
        case METHODID_LOGOUT_REGIST_USER:
          serviceImpl.logoutRegistUser((com.lanjiu.pro.login.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser>) responseObserver);
          break;
        case METHODID_LOGOUT_GUEST_USER:
          serviceImpl.logoutGuestUser((com.lanjiu.pro.login.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser>) responseObserver);
          break;
        case METHODID_DELETE_REGISTER_USER:
          serviceImpl.deleteRegisterUser((com.lanjiu.pro.login.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser>) responseObserver);
          break;
        case METHODID_DELETE_GUEST_USER:
          serviceImpl.deleteGuestUser((com.lanjiu.pro.login.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser>) responseObserver);
          break;
        case METHODID_UPDATE_USER_INFOMATION:
          serviceImpl.updateUserInfomation((com.lanjiu.pro.login.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser>) responseObserver);
          break;
        case METHODID_UPDATE_GUEST_USER_INFO:
          serviceImpl.updateGuestUserInfo((com.lanjiu.pro.login.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser>) responseObserver);
          break;
        case METHODID_SEEK_PASSWORD:
          serviceImpl.seekPassword((com.lanjiu.pro.login.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser>) responseObserver);
          break;
        case METHODID_VERIFICATION_CODE:
          serviceImpl.verificationCode((com.lanjiu.pro.login.RequestUser) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.pro.login.ResponseUser>) responseObserver);
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
              .addMethod(getStorageRegisterUserMethod())
              .addMethod(getStorageGuestUserMethod())
              .addMethod(getStorageUserInfomationMethod())
              .addMethod(getStorageGuestUserInfoMethod())
              .addMethod(getSelectUserInfomationMethod())
              .addMethod(getSelectGuestUserInfoMethod())
              .addMethod(getLoginRegistUserMethod())
              .addMethod(getLoginGuestUserMethod())
              .addMethod(getLogoutRegistUserMethod())
              .addMethod(getLogoutGuestUserMethod())
              .addMethod(getDeleteRegisterUserMethod())
              .addMethod(getDeleteGuestUserMethod())
              .addMethod(getUpdateUserInfomationMethod())
              .addMethod(getUpdateGuestUserInfoMethod())
              .addMethod(getSeekPasswordMethod())
              .addMethod(getVerificationCodeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
