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
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectBeautifulNumberRealMethod;
    if ((getSelectBeautifulNumberRealMethod = InformationStorageServiceGrpc.getSelectBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectBeautifulNumberRealMethod = InformationStorageServiceGrpc.getSelectBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getSelectBeautifulNumberRealMethod = getSelectBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getSelectBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectBeautifulNumberAutoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectBeautifulNumberAuto",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectBeautifulNumberAutoMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectBeautifulNumberAutoMethod;
    if ((getSelectBeautifulNumberAutoMethod = InformationStorageServiceGrpc.getSelectBeautifulNumberAutoMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectBeautifulNumberAutoMethod = InformationStorageServiceGrpc.getSelectBeautifulNumberAutoMethod) == null) {
          InformationStorageServiceGrpc.getSelectBeautifulNumberAutoMethod = getSelectBeautifulNumberAutoMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectBeautifulNumberAuto"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectBeautifulNumberAuto"))
              .build();
        }
      }
    }
    return getSelectBeautifulNumberAutoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BurnAfterReadingPriorityResponse> getSelectBurnAfterReadingPriorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectBurnAfterReadingPriority",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BurnAfterReadingPriorityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BurnAfterReadingPriorityResponse> getSelectBurnAfterReadingPriorityMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BurnAfterReadingPriorityResponse> getSelectBurnAfterReadingPriorityMethod;
    if ((getSelectBurnAfterReadingPriorityMethod = InformationStorageServiceGrpc.getSelectBurnAfterReadingPriorityMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectBurnAfterReadingPriorityMethod = InformationStorageServiceGrpc.getSelectBurnAfterReadingPriorityMethod) == null) {
          InformationStorageServiceGrpc.getSelectBurnAfterReadingPriorityMethod = getSelectBurnAfterReadingPriorityMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BurnAfterReadingPriorityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectBurnAfterReadingPriority"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BurnAfterReadingPriorityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectBurnAfterReadingPriority"))
              .build();
        }
      }
    }
    return getSelectBurnAfterReadingPriorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectFriendUnusedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectFriendUnusedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectFriendUnusedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectFriendUnusedBeautifulNumberMethod;
    if ((getSelectFriendUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getSelectFriendUnusedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectFriendUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getSelectFriendUnusedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getSelectFriendUnusedBeautifulNumberMethod = getSelectFriendUnusedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectFriendUnusedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectFriendUnusedBeautifulNumber"))
              .build();
        }
      }
    }
    return getSelectFriendUnusedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectFriendUsedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectFriendUsedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectFriendUsedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectFriendUsedBeautifulNumberMethod;
    if ((getSelectFriendUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getSelectFriendUsedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectFriendUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getSelectFriendUsedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getSelectFriendUsedBeautifulNumberMethod = getSelectFriendUsedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectFriendUsedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectFriendUsedBeautifulNumber"))
              .build();
        }
      }
    }
    return getSelectFriendUsedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GroupAnnouncementsResponse> getSelectGroupAnnouncementsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectGroupAnnouncements",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GroupAnnouncementsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GroupAnnouncementsResponse> getSelectGroupAnnouncementsMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GroupAnnouncementsResponse> getSelectGroupAnnouncementsMethod;
    if ((getSelectGroupAnnouncementsMethod = InformationStorageServiceGrpc.getSelectGroupAnnouncementsMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectGroupAnnouncementsMethod = InformationStorageServiceGrpc.getSelectGroupAnnouncementsMethod) == null) {
          InformationStorageServiceGrpc.getSelectGroupAnnouncementsMethod = getSelectGroupAnnouncementsMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GroupAnnouncementsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectGroupAnnouncements"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GroupAnnouncementsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectGroupAnnouncements"))
              .build();
        }
      }
    }
    return getSelectGroupAnnouncementsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupMemberUnusedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectGroupMemberUnusedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupMemberUnusedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupMemberUnusedBeautifulNumberMethod;
    if ((getSelectGroupMemberUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getSelectGroupMemberUnusedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectGroupMemberUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getSelectGroupMemberUnusedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getSelectGroupMemberUnusedBeautifulNumberMethod = getSelectGroupMemberUnusedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectGroupMemberUnusedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectGroupMemberUnusedBeautifulNumber"))
              .build();
        }
      }
    }
    return getSelectGroupMemberUnusedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupMemberUsedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectGroupMemberUsedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupMemberUsedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupMemberUsedBeautifulNumberMethod;
    if ((getSelectGroupMemberUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getSelectGroupMemberUsedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectGroupMemberUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getSelectGroupMemberUsedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getSelectGroupMemberUsedBeautifulNumberMethod = getSelectGroupMemberUsedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectGroupMemberUsedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectGroupMemberUsedBeautifulNumber"))
              .build();
        }
      }
    }
    return getSelectGroupMemberUsedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupUnusedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectGroupUnusedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupUnusedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupUnusedBeautifulNumberMethod;
    if ((getSelectGroupUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getSelectGroupUnusedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectGroupUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getSelectGroupUnusedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getSelectGroupUnusedBeautifulNumberMethod = getSelectGroupUnusedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectGroupUnusedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectGroupUnusedBeautifulNumber"))
              .build();
        }
      }
    }
    return getSelectGroupUnusedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupUsedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectGroupUsedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupUsedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupUsedBeautifulNumberMethod;
    if ((getSelectGroupUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getSelectGroupUsedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectGroupUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getSelectGroupUsedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getSelectGroupUsedBeautifulNumberMethod = getSelectGroupUsedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectGroupUsedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectGroupUsedBeautifulNumber"))
              .build();
        }
      }
    }
    return getSelectGroupUsedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupResponse> getSelectGuestGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectGuestGroup",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupResponse> getSelectGuestGroupMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupResponse> getSelectGuestGroupMethod;
    if ((getSelectGuestGroupMethod = InformationStorageServiceGrpc.getSelectGuestGroupMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectGuestGroupMethod = InformationStorageServiceGrpc.getSelectGuestGroupMethod) == null) {
          InformationStorageServiceGrpc.getSelectGuestGroupMethod = getSelectGuestGroupMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectGuestGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectGuestGroup"))
              .build();
        }
      }
    }
    return getSelectGuestGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupAdministratorResponse> getSelectGuestGroupAdministratorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectGuestGroupAdministrator",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupAdministratorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupAdministratorResponse> getSelectGuestGroupAdministratorMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupAdministratorResponse> getSelectGuestGroupAdministratorMethod;
    if ((getSelectGuestGroupAdministratorMethod = InformationStorageServiceGrpc.getSelectGuestGroupAdministratorMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectGuestGroupAdministratorMethod = InformationStorageServiceGrpc.getSelectGuestGroupAdministratorMethod) == null) {
          InformationStorageServiceGrpc.getSelectGuestGroupAdministratorMethod = getSelectGuestGroupAdministratorMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupAdministratorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectGuestGroupAdministrator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupAdministratorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectGuestGroupAdministrator"))
              .build();
        }
      }
    }
    return getSelectGuestGroupAdministratorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> getSelectGuestGroupGuestUserMemberRelationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectGuestGroupGuestUserMemberRelation",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> getSelectGuestGroupGuestUserMemberRelationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> getSelectGuestGroupGuestUserMemberRelationMethod;
    if ((getSelectGuestGroupGuestUserMemberRelationMethod = InformationStorageServiceGrpc.getSelectGuestGroupGuestUserMemberRelationMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectGuestGroupGuestUserMemberRelationMethod = InformationStorageServiceGrpc.getSelectGuestGroupGuestUserMemberRelationMethod) == null) {
          InformationStorageServiceGrpc.getSelectGuestGroupGuestUserMemberRelationMethod = getSelectGuestGroupGuestUserMemberRelationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectGuestGroupGuestUserMemberRelation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectGuestGroupGuestUserMemberRelation"))
              .build();
        }
      }
    }
    return getSelectGuestGroupGuestUserMemberRelationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupMemberResponse> getSelectGuestGroupMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectGuestGroupMember",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupMemberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupMemberResponse> getSelectGuestGroupMemberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupMemberResponse> getSelectGuestGroupMemberMethod;
    if ((getSelectGuestGroupMemberMethod = InformationStorageServiceGrpc.getSelectGuestGroupMemberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectGuestGroupMemberMethod = InformationStorageServiceGrpc.getSelectGuestGroupMemberMethod) == null) {
          InformationStorageServiceGrpc.getSelectGuestGroupMemberMethod = getSelectGuestGroupMemberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupMemberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectGuestGroupMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupMemberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectGuestGroupMember"))
              .build();
        }
      }
    }
    return getSelectGuestGroupMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> getSelectGuestGroupRegisteredUserMemberRelationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectGuestGroupRegisteredUserMemberRelation",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> getSelectGuestGroupRegisteredUserMemberRelationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> getSelectGuestGroupRegisteredUserMemberRelationMethod;
    if ((getSelectGuestGroupRegisteredUserMemberRelationMethod = InformationStorageServiceGrpc.getSelectGuestGroupRegisteredUserMemberRelationMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectGuestGroupRegisteredUserMemberRelationMethod = InformationStorageServiceGrpc.getSelectGuestGroupRegisteredUserMemberRelationMethod) == null) {
          InformationStorageServiceGrpc.getSelectGuestGroupRegisteredUserMemberRelationMethod = getSelectGuestGroupRegisteredUserMemberRelationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectGuestGroupRegisteredUserMemberRelation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectGuestGroupRegisteredUserMemberRelation"))
              .build();
        }
      }
    }
    return getSelectGuestGroupRegisteredUserMemberRelationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestUserFriendResponse> getSelectGuestUserFriendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectGuestUserFriend",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestUserFriendResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestUserFriendResponse> getSelectGuestUserFriendMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestUserFriendResponse> getSelectGuestUserFriendMethod;
    if ((getSelectGuestUserFriendMethod = InformationStorageServiceGrpc.getSelectGuestUserFriendMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectGuestUserFriendMethod = InformationStorageServiceGrpc.getSelectGuestUserFriendMethod) == null) {
          InformationStorageServiceGrpc.getSelectGuestUserFriendMethod = getSelectGuestUserFriendMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestUserFriendResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectGuestUserFriend"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestUserFriendResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectGuestUserFriend"))
              .build();
        }
      }
    }
    return getSelectGuestUserFriendMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.OfflineMessagePriorityResponse> getSelectOfflineMessagePriorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectOfflineMessagePriority",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.OfflineMessagePriorityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.OfflineMessagePriorityResponse> getSelectOfflineMessagePriorityMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.OfflineMessagePriorityResponse> getSelectOfflineMessagePriorityMethod;
    if ((getSelectOfflineMessagePriorityMethod = InformationStorageServiceGrpc.getSelectOfflineMessagePriorityMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectOfflineMessagePriorityMethod = InformationStorageServiceGrpc.getSelectOfflineMessagePriorityMethod) == null) {
          InformationStorageServiceGrpc.getSelectOfflineMessagePriorityMethod = getSelectOfflineMessagePriorityMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.OfflineMessagePriorityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectOfflineMessagePriority"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.OfflineMessagePriorityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectOfflineMessagePriority"))
              .build();
        }
      }
    }
    return getSelectOfflineMessagePriorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupResponse> getSelectRegisteredGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectRegisteredGroup",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupResponse> getSelectRegisteredGroupMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupResponse> getSelectRegisteredGroupMethod;
    if ((getSelectRegisteredGroupMethod = InformationStorageServiceGrpc.getSelectRegisteredGroupMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectRegisteredGroupMethod = InformationStorageServiceGrpc.getSelectRegisteredGroupMethod) == null) {
          InformationStorageServiceGrpc.getSelectRegisteredGroupMethod = getSelectRegisteredGroupMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectRegisteredGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectRegisteredGroup"))
              .build();
        }
      }
    }
    return getSelectRegisteredGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> getSelectRegisteredGroupAdministratorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectRegisteredGroupAdministrator",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> getSelectRegisteredGroupAdministratorMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> getSelectRegisteredGroupAdministratorMethod;
    if ((getSelectRegisteredGroupAdministratorMethod = InformationStorageServiceGrpc.getSelectRegisteredGroupAdministratorMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectRegisteredGroupAdministratorMethod = InformationStorageServiceGrpc.getSelectRegisteredGroupAdministratorMethod) == null) {
          InformationStorageServiceGrpc.getSelectRegisteredGroupAdministratorMethod = getSelectRegisteredGroupAdministratorMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectRegisteredGroupAdministrator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectRegisteredGroupAdministrator"))
              .build();
        }
      }
    }
    return getSelectRegisteredGroupAdministratorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> getSelectRegisteredGroupGuestUserMemberRelationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectRegisteredGroupGuestUserMemberRelation",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> getSelectRegisteredGroupGuestUserMemberRelationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> getSelectRegisteredGroupGuestUserMemberRelationMethod;
    if ((getSelectRegisteredGroupGuestUserMemberRelationMethod = InformationStorageServiceGrpc.getSelectRegisteredGroupGuestUserMemberRelationMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectRegisteredGroupGuestUserMemberRelationMethod = InformationStorageServiceGrpc.getSelectRegisteredGroupGuestUserMemberRelationMethod) == null) {
          InformationStorageServiceGrpc.getSelectRegisteredGroupGuestUserMemberRelationMethod = getSelectRegisteredGroupGuestUserMemberRelationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectRegisteredGroupGuestUserMemberRelation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectRegisteredGroupGuestUserMemberRelation"))
              .build();
        }
      }
    }
    return getSelectRegisteredGroupGuestUserMemberRelationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupMemberResponse> getSelectRegisteredGroupMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectRegisteredGroupMember",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupMemberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupMemberResponse> getSelectRegisteredGroupMemberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupMemberResponse> getSelectRegisteredGroupMemberMethod;
    if ((getSelectRegisteredGroupMemberMethod = InformationStorageServiceGrpc.getSelectRegisteredGroupMemberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectRegisteredGroupMemberMethod = InformationStorageServiceGrpc.getSelectRegisteredGroupMemberMethod) == null) {
          InformationStorageServiceGrpc.getSelectRegisteredGroupMemberMethod = getSelectRegisteredGroupMemberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupMemberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectRegisteredGroupMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupMemberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectRegisteredGroupMember"))
              .build();
        }
      }
    }
    return getSelectRegisteredGroupMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> getSelectRegisteredGroupRegisteredUserMemberRelationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectRegisteredGroupRegisteredUserMemberRelation",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> getSelectRegisteredGroupRegisteredUserMemberRelationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> getSelectRegisteredGroupRegisteredUserMemberRelationMethod;
    if ((getSelectRegisteredGroupRegisteredUserMemberRelationMethod = InformationStorageServiceGrpc.getSelectRegisteredGroupRegisteredUserMemberRelationMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectRegisteredGroupRegisteredUserMemberRelationMethod = InformationStorageServiceGrpc.getSelectRegisteredGroupRegisteredUserMemberRelationMethod) == null) {
          InformationStorageServiceGrpc.getSelectRegisteredGroupRegisteredUserMemberRelationMethod = getSelectRegisteredGroupRegisteredUserMemberRelationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectRegisteredGroupRegisteredUserMemberRelation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectRegisteredGroupRegisteredUserMemberRelation"))
              .build();
        }
      }
    }
    return getSelectRegisteredGroupRegisteredUserMemberRelationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredUserFriendResponse> getSelectRegisteredUserFriendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectRegisteredUserFriend",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredUserFriendResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredUserFriendResponse> getSelectRegisteredUserFriendMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredUserFriendResponse> getSelectRegisteredUserFriendMethod;
    if ((getSelectRegisteredUserFriendMethod = InformationStorageServiceGrpc.getSelectRegisteredUserFriendMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectRegisteredUserFriendMethod = InformationStorageServiceGrpc.getSelectRegisteredUserFriendMethod) == null) {
          InformationStorageServiceGrpc.getSelectRegisteredUserFriendMethod = getSelectRegisteredUserFriendMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredUserFriendResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectRegisteredUserFriend"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredUserFriendResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectRegisteredUserFriend"))
              .build();
        }
      }
    }
    return getSelectRegisteredUserFriendMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupUnusedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectGroupUnusedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupUnusedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupUnusedBeautifulNumberRealMethod;
    if ((getSelectGroupUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getSelectGroupUnusedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectGroupUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getSelectGroupUnusedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getSelectGroupUnusedBeautifulNumberRealMethod = getSelectGroupUnusedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectGroupUnusedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectGroupUnusedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getSelectGroupUnusedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupUsedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectGroupUsedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupUsedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupUsedBeautifulNumberRealMethod;
    if ((getSelectGroupUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getSelectGroupUsedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectGroupUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getSelectGroupUsedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getSelectGroupUsedBeautifulNumberRealMethod = getSelectGroupUsedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectGroupUsedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectGroupUsedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getSelectGroupUsedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupMemberUnusedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectGroupMemberUnusedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupMemberUnusedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupMemberUnusedBeautifulNumberRealMethod;
    if ((getSelectGroupMemberUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getSelectGroupMemberUnusedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectGroupMemberUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getSelectGroupMemberUnusedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getSelectGroupMemberUnusedBeautifulNumberRealMethod = getSelectGroupMemberUnusedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectGroupMemberUnusedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectGroupMemberUnusedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getSelectGroupMemberUnusedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupMemberUsedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectGroupMemberUsedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupMemberUsedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectGroupMemberUsedBeautifulNumberRealMethod;
    if ((getSelectGroupMemberUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getSelectGroupMemberUsedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectGroupMemberUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getSelectGroupMemberUsedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getSelectGroupMemberUsedBeautifulNumberRealMethod = getSelectGroupMemberUsedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectGroupMemberUsedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectGroupMemberUsedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getSelectGroupMemberUsedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectFriendUnusedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectFriendUnusedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectFriendUnusedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectFriendUnusedBeautifulNumberRealMethod;
    if ((getSelectFriendUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getSelectFriendUnusedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectFriendUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getSelectFriendUnusedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getSelectFriendUnusedBeautifulNumberRealMethod = getSelectFriendUnusedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectFriendUnusedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectFriendUnusedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getSelectFriendUnusedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectFriendUsedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectFriendUsedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectFriendUsedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getSelectFriendUsedBeautifulNumberRealMethod;
    if ((getSelectFriendUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getSelectFriendUsedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectFriendUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getSelectFriendUsedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getSelectFriendUsedBeautifulNumberRealMethod = getSelectFriendUsedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectFriendUsedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectFriendUsedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getSelectFriendUsedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GroupRemarkResponse> getSelectGroupRemarkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectGroupRemark",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GroupRemarkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GroupRemarkResponse> getSelectGroupRemarkMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GroupRemarkResponse> getSelectGroupRemarkMethod;
    if ((getSelectGroupRemarkMethod = InformationStorageServiceGrpc.getSelectGroupRemarkMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getSelectGroupRemarkMethod = InformationStorageServiceGrpc.getSelectGroupRemarkMethod) == null) {
          InformationStorageServiceGrpc.getSelectGroupRemarkMethod = getSelectGroupRemarkMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GroupRemarkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectGroupRemark"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GroupRemarkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("selectGroupRemark"))
              .build();
        }
      }
    }
    return getSelectGroupRemarkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertFriendUnusedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertFriendUnusedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertFriendUnusedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertFriendUnusedBeautifulNumberMethod;
    if ((getInsertFriendUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getInsertFriendUnusedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertFriendUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getInsertFriendUnusedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getInsertFriendUnusedBeautifulNumberMethod = getInsertFriendUnusedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertFriendUnusedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertFriendUnusedBeautifulNumber"))
              .build();
        }
      }
    }
    return getInsertFriendUnusedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertFriendUsedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertFriendUsedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertFriendUsedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertFriendUsedBeautifulNumberMethod;
    if ((getInsertFriendUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getInsertFriendUsedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertFriendUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getInsertFriendUsedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getInsertFriendUsedBeautifulNumberMethod = getInsertFriendUsedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertFriendUsedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertFriendUsedBeautifulNumber"))
              .build();
        }
      }
    }
    return getInsertFriendUsedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GroupAnnouncementsResponse> getInsertGroupAnnouncementsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertGroupAnnouncements",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GroupAnnouncementsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GroupAnnouncementsResponse> getInsertGroupAnnouncementsMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GroupAnnouncementsResponse> getInsertGroupAnnouncementsMethod;
    if ((getInsertGroupAnnouncementsMethod = InformationStorageServiceGrpc.getInsertGroupAnnouncementsMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertGroupAnnouncementsMethod = InformationStorageServiceGrpc.getInsertGroupAnnouncementsMethod) == null) {
          InformationStorageServiceGrpc.getInsertGroupAnnouncementsMethod = getInsertGroupAnnouncementsMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GroupAnnouncementsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertGroupAnnouncements"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GroupAnnouncementsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertGroupAnnouncements"))
              .build();
        }
      }
    }
    return getInsertGroupAnnouncementsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupMemberUnusedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertGroupMemberUnusedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupMemberUnusedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupMemberUnusedBeautifulNumberMethod;
    if ((getInsertGroupMemberUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getInsertGroupMemberUnusedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertGroupMemberUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getInsertGroupMemberUnusedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getInsertGroupMemberUnusedBeautifulNumberMethod = getInsertGroupMemberUnusedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertGroupMemberUnusedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertGroupMemberUnusedBeautifulNumber"))
              .build();
        }
      }
    }
    return getInsertGroupMemberUnusedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupMemberUsedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertGroupMemberUsedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupMemberUsedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupMemberUsedBeautifulNumberMethod;
    if ((getInsertGroupMemberUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getInsertGroupMemberUsedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertGroupMemberUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getInsertGroupMemberUsedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getInsertGroupMemberUsedBeautifulNumberMethod = getInsertGroupMemberUsedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertGroupMemberUsedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertGroupMemberUsedBeautifulNumber"))
              .build();
        }
      }
    }
    return getInsertGroupMemberUsedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupUnusedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertGroupUnusedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupUnusedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupUnusedBeautifulNumberMethod;
    if ((getInsertGroupUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getInsertGroupUnusedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertGroupUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getInsertGroupUnusedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getInsertGroupUnusedBeautifulNumberMethod = getInsertGroupUnusedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertGroupUnusedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertGroupUnusedBeautifulNumber"))
              .build();
        }
      }
    }
    return getInsertGroupUnusedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupUsedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertGroupUsedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupUsedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupUsedBeautifulNumberMethod;
    if ((getInsertGroupUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getInsertGroupUsedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertGroupUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getInsertGroupUsedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getInsertGroupUsedBeautifulNumberMethod = getInsertGroupUsedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertGroupUsedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertGroupUsedBeautifulNumber"))
              .build();
        }
      }
    }
    return getInsertGroupUsedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupResponse> getInsertGuestGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertGuestGroup",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupResponse> getInsertGuestGroupMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupResponse> getInsertGuestGroupMethod;
    if ((getInsertGuestGroupMethod = InformationStorageServiceGrpc.getInsertGuestGroupMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertGuestGroupMethod = InformationStorageServiceGrpc.getInsertGuestGroupMethod) == null) {
          InformationStorageServiceGrpc.getInsertGuestGroupMethod = getInsertGuestGroupMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertGuestGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertGuestGroup"))
              .build();
        }
      }
    }
    return getInsertGuestGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupAdministratorResponse> getInsertGuestGroupAdministratorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertGuestGroupAdministrator",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupAdministratorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupAdministratorResponse> getInsertGuestGroupAdministratorMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupAdministratorResponse> getInsertGuestGroupAdministratorMethod;
    if ((getInsertGuestGroupAdministratorMethod = InformationStorageServiceGrpc.getInsertGuestGroupAdministratorMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertGuestGroupAdministratorMethod = InformationStorageServiceGrpc.getInsertGuestGroupAdministratorMethod) == null) {
          InformationStorageServiceGrpc.getInsertGuestGroupAdministratorMethod = getInsertGuestGroupAdministratorMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupAdministratorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertGuestGroupAdministrator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupAdministratorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertGuestGroupAdministrator"))
              .build();
        }
      }
    }
    return getInsertGuestGroupAdministratorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> getInsertGuestGroupGuestUserMemberRelationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertGuestGroupGuestUserMemberRelation",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> getInsertGuestGroupGuestUserMemberRelationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> getInsertGuestGroupGuestUserMemberRelationMethod;
    if ((getInsertGuestGroupGuestUserMemberRelationMethod = InformationStorageServiceGrpc.getInsertGuestGroupGuestUserMemberRelationMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertGuestGroupGuestUserMemberRelationMethod = InformationStorageServiceGrpc.getInsertGuestGroupGuestUserMemberRelationMethod) == null) {
          InformationStorageServiceGrpc.getInsertGuestGroupGuestUserMemberRelationMethod = getInsertGuestGroupGuestUserMemberRelationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertGuestGroupGuestUserMemberRelation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertGuestGroupGuestUserMemberRelation"))
              .build();
        }
      }
    }
    return getInsertGuestGroupGuestUserMemberRelationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupMemberResponse> getInsertGuestGroupMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertGuestGroupMember",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupMemberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupMemberResponse> getInsertGuestGroupMemberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupMemberResponse> getInsertGuestGroupMemberMethod;
    if ((getInsertGuestGroupMemberMethod = InformationStorageServiceGrpc.getInsertGuestGroupMemberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertGuestGroupMemberMethod = InformationStorageServiceGrpc.getInsertGuestGroupMemberMethod) == null) {
          InformationStorageServiceGrpc.getInsertGuestGroupMemberMethod = getInsertGuestGroupMemberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupMemberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertGuestGroupMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupMemberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertGuestGroupMember"))
              .build();
        }
      }
    }
    return getInsertGuestGroupMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> getInsertGuestGroupRegisteredUserMemberRelationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertGuestGroupRegisteredUserMemberRelation",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> getInsertGuestGroupRegisteredUserMemberRelationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> getInsertGuestGroupRegisteredUserMemberRelationMethod;
    if ((getInsertGuestGroupRegisteredUserMemberRelationMethod = InformationStorageServiceGrpc.getInsertGuestGroupRegisteredUserMemberRelationMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertGuestGroupRegisteredUserMemberRelationMethod = InformationStorageServiceGrpc.getInsertGuestGroupRegisteredUserMemberRelationMethod) == null) {
          InformationStorageServiceGrpc.getInsertGuestGroupRegisteredUserMemberRelationMethod = getInsertGuestGroupRegisteredUserMemberRelationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertGuestGroupRegisteredUserMemberRelation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertGuestGroupRegisteredUserMemberRelation"))
              .build();
        }
      }
    }
    return getInsertGuestGroupRegisteredUserMemberRelationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestUserFriendResponse> getInsertGuestUserFriendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertGuestUserFriend",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestUserFriendResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestUserFriendResponse> getInsertGuestUserFriendMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestUserFriendResponse> getInsertGuestUserFriendMethod;
    if ((getInsertGuestUserFriendMethod = InformationStorageServiceGrpc.getInsertGuestUserFriendMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertGuestUserFriendMethod = InformationStorageServiceGrpc.getInsertGuestUserFriendMethod) == null) {
          InformationStorageServiceGrpc.getInsertGuestUserFriendMethod = getInsertGuestUserFriendMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestUserFriendResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertGuestUserFriend"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestUserFriendResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertGuestUserFriend"))
              .build();
        }
      }
    }
    return getInsertGuestUserFriendMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.OfflineMessagePriorityResponse> getInsertOfflineMessagePriorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertOfflineMessagePriority",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.OfflineMessagePriorityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.OfflineMessagePriorityResponse> getInsertOfflineMessagePriorityMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.OfflineMessagePriorityResponse> getInsertOfflineMessagePriorityMethod;
    if ((getInsertOfflineMessagePriorityMethod = InformationStorageServiceGrpc.getInsertOfflineMessagePriorityMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertOfflineMessagePriorityMethod = InformationStorageServiceGrpc.getInsertOfflineMessagePriorityMethod) == null) {
          InformationStorageServiceGrpc.getInsertOfflineMessagePriorityMethod = getInsertOfflineMessagePriorityMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.OfflineMessagePriorityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertOfflineMessagePriority"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.OfflineMessagePriorityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertOfflineMessagePriority"))
              .build();
        }
      }
    }
    return getInsertOfflineMessagePriorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupResponse> getInsertRegisteredGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertRegisteredGroup",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupResponse> getInsertRegisteredGroupMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupResponse> getInsertRegisteredGroupMethod;
    if ((getInsertRegisteredGroupMethod = InformationStorageServiceGrpc.getInsertRegisteredGroupMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertRegisteredGroupMethod = InformationStorageServiceGrpc.getInsertRegisteredGroupMethod) == null) {
          InformationStorageServiceGrpc.getInsertRegisteredGroupMethod = getInsertRegisteredGroupMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertRegisteredGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertRegisteredGroup"))
              .build();
        }
      }
    }
    return getInsertRegisteredGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> getInsertRegisteredGroupAdministratorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertRegisteredGroupAdministrator",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> getInsertRegisteredGroupAdministratorMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> getInsertRegisteredGroupAdministratorMethod;
    if ((getInsertRegisteredGroupAdministratorMethod = InformationStorageServiceGrpc.getInsertRegisteredGroupAdministratorMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertRegisteredGroupAdministratorMethod = InformationStorageServiceGrpc.getInsertRegisteredGroupAdministratorMethod) == null) {
          InformationStorageServiceGrpc.getInsertRegisteredGroupAdministratorMethod = getInsertRegisteredGroupAdministratorMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertRegisteredGroupAdministrator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertRegisteredGroupAdministrator"))
              .build();
        }
      }
    }
    return getInsertRegisteredGroupAdministratorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> getInsertRegisteredGroupGuestUserMemberRelationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertRegisteredGroupGuestUserMemberRelation",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> getInsertRegisteredGroupGuestUserMemberRelationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> getInsertRegisteredGroupGuestUserMemberRelationMethod;
    if ((getInsertRegisteredGroupGuestUserMemberRelationMethod = InformationStorageServiceGrpc.getInsertRegisteredGroupGuestUserMemberRelationMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertRegisteredGroupGuestUserMemberRelationMethod = InformationStorageServiceGrpc.getInsertRegisteredGroupGuestUserMemberRelationMethod) == null) {
          InformationStorageServiceGrpc.getInsertRegisteredGroupGuestUserMemberRelationMethod = getInsertRegisteredGroupGuestUserMemberRelationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertRegisteredGroupGuestUserMemberRelation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertRegisteredGroupGuestUserMemberRelation"))
              .build();
        }
      }
    }
    return getInsertRegisteredGroupGuestUserMemberRelationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupMemberResponse> getInsertRegisteredGroupMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertRegisteredGroupMember",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupMemberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupMemberResponse> getInsertRegisteredGroupMemberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupMemberResponse> getInsertRegisteredGroupMemberMethod;
    if ((getInsertRegisteredGroupMemberMethod = InformationStorageServiceGrpc.getInsertRegisteredGroupMemberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertRegisteredGroupMemberMethod = InformationStorageServiceGrpc.getInsertRegisteredGroupMemberMethod) == null) {
          InformationStorageServiceGrpc.getInsertRegisteredGroupMemberMethod = getInsertRegisteredGroupMemberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupMemberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertRegisteredGroupMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupMemberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertRegisteredGroupMember"))
              .build();
        }
      }
    }
    return getInsertRegisteredGroupMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> getInsertRegisteredGroupRegisteredUserMemberRelationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertRegisteredGroupRegisteredUserMemberRelation",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> getInsertRegisteredGroupRegisteredUserMemberRelationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> getInsertRegisteredGroupRegisteredUserMemberRelationMethod;
    if ((getInsertRegisteredGroupRegisteredUserMemberRelationMethod = InformationStorageServiceGrpc.getInsertRegisteredGroupRegisteredUserMemberRelationMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertRegisteredGroupRegisteredUserMemberRelationMethod = InformationStorageServiceGrpc.getInsertRegisteredGroupRegisteredUserMemberRelationMethod) == null) {
          InformationStorageServiceGrpc.getInsertRegisteredGroupRegisteredUserMemberRelationMethod = getInsertRegisteredGroupRegisteredUserMemberRelationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertRegisteredGroupRegisteredUserMemberRelation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertRegisteredGroupRegisteredUserMemberRelation"))
              .build();
        }
      }
    }
    return getInsertRegisteredGroupRegisteredUserMemberRelationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredUserFriendResponse> getInsertRegisteredUserFriendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertRegisteredUserFriend",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredUserFriendResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredUserFriendResponse> getInsertRegisteredUserFriendMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredUserFriendResponse> getInsertRegisteredUserFriendMethod;
    if ((getInsertRegisteredUserFriendMethod = InformationStorageServiceGrpc.getInsertRegisteredUserFriendMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertRegisteredUserFriendMethod = InformationStorageServiceGrpc.getInsertRegisteredUserFriendMethod) == null) {
          InformationStorageServiceGrpc.getInsertRegisteredUserFriendMethod = getInsertRegisteredUserFriendMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredUserFriendResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertRegisteredUserFriend"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredUserFriendResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertRegisteredUserFriend"))
              .build();
        }
      }
    }
    return getInsertRegisteredUserFriendMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupUnusedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertGroupUnusedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupUnusedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupUnusedBeautifulNumberRealMethod;
    if ((getInsertGroupUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getInsertGroupUnusedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertGroupUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getInsertGroupUnusedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getInsertGroupUnusedBeautifulNumberRealMethod = getInsertGroupUnusedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertGroupUnusedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertGroupUnusedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getInsertGroupUnusedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupUsedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertGroupUsedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupUsedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupUsedBeautifulNumberRealMethod;
    if ((getInsertGroupUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getInsertGroupUsedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertGroupUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getInsertGroupUsedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getInsertGroupUsedBeautifulNumberRealMethod = getInsertGroupUsedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertGroupUsedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertGroupUsedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getInsertGroupUsedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupMemberUnusedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertGroupMemberUnusedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupMemberUnusedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupMemberUnusedBeautifulNumberRealMethod;
    if ((getInsertGroupMemberUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getInsertGroupMemberUnusedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertGroupMemberUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getInsertGroupMemberUnusedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getInsertGroupMemberUnusedBeautifulNumberRealMethod = getInsertGroupMemberUnusedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertGroupMemberUnusedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertGroupMemberUnusedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getInsertGroupMemberUnusedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupMemberUsedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertGroupMemberUsedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupMemberUsedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertGroupMemberUsedBeautifulNumberRealMethod;
    if ((getInsertGroupMemberUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getInsertGroupMemberUsedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertGroupMemberUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getInsertGroupMemberUsedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getInsertGroupMemberUsedBeautifulNumberRealMethod = getInsertGroupMemberUsedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertGroupMemberUsedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertGroupMemberUsedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getInsertGroupMemberUsedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertFriendUnusedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertFriendUnusedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertFriendUnusedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertFriendUnusedBeautifulNumberRealMethod;
    if ((getInsertFriendUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getInsertFriendUnusedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertFriendUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getInsertFriendUnusedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getInsertFriendUnusedBeautifulNumberRealMethod = getInsertFriendUnusedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertFriendUnusedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertFriendUnusedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getInsertFriendUnusedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertFriendUsedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertFriendUsedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertFriendUsedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getInsertFriendUsedBeautifulNumberRealMethod;
    if ((getInsertFriendUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getInsertFriendUsedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertFriendUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getInsertFriendUsedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getInsertFriendUsedBeautifulNumberRealMethod = getInsertFriendUsedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertFriendUsedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertFriendUsedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getInsertFriendUsedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GroupRemarkResponse> getInsertGroupRemarkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertGroupRemark",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GroupRemarkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GroupRemarkResponse> getInsertGroupRemarkMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GroupRemarkResponse> getInsertGroupRemarkMethod;
    if ((getInsertGroupRemarkMethod = InformationStorageServiceGrpc.getInsertGroupRemarkMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getInsertGroupRemarkMethod = InformationStorageServiceGrpc.getInsertGroupRemarkMethod) == null) {
          InformationStorageServiceGrpc.getInsertGroupRemarkMethod = getInsertGroupRemarkMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GroupRemarkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "insertGroupRemark"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GroupRemarkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("insertGroupRemark"))
              .build();
        }
      }
    }
    return getInsertGroupRemarkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateFriendUnusedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateFriendUnusedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateFriendUnusedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateFriendUnusedBeautifulNumberMethod;
    if ((getUpdateFriendUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getUpdateFriendUnusedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateFriendUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getUpdateFriendUnusedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getUpdateFriendUnusedBeautifulNumberMethod = getUpdateFriendUnusedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateFriendUnusedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateFriendUnusedBeautifulNumber"))
              .build();
        }
      }
    }
    return getUpdateFriendUnusedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateFriendUsedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateFriendUsedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateFriendUsedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateFriendUsedBeautifulNumberMethod;
    if ((getUpdateFriendUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getUpdateFriendUsedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateFriendUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getUpdateFriendUsedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getUpdateFriendUsedBeautifulNumberMethod = getUpdateFriendUsedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateFriendUsedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateFriendUsedBeautifulNumber"))
              .build();
        }
      }
    }
    return getUpdateFriendUsedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GroupAnnouncementsResponse> getUpdateGroupAnnouncementsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateGroupAnnouncements",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GroupAnnouncementsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GroupAnnouncementsResponse> getUpdateGroupAnnouncementsMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GroupAnnouncementsResponse> getUpdateGroupAnnouncementsMethod;
    if ((getUpdateGroupAnnouncementsMethod = InformationStorageServiceGrpc.getUpdateGroupAnnouncementsMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateGroupAnnouncementsMethod = InformationStorageServiceGrpc.getUpdateGroupAnnouncementsMethod) == null) {
          InformationStorageServiceGrpc.getUpdateGroupAnnouncementsMethod = getUpdateGroupAnnouncementsMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GroupAnnouncementsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateGroupAnnouncements"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GroupAnnouncementsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateGroupAnnouncements"))
              .build();
        }
      }
    }
    return getUpdateGroupAnnouncementsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupMemberUnusedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateGroupMemberUnusedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupMemberUnusedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupMemberUnusedBeautifulNumberMethod;
    if ((getUpdateGroupMemberUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getUpdateGroupMemberUnusedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateGroupMemberUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getUpdateGroupMemberUnusedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getUpdateGroupMemberUnusedBeautifulNumberMethod = getUpdateGroupMemberUnusedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateGroupMemberUnusedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateGroupMemberUnusedBeautifulNumber"))
              .build();
        }
      }
    }
    return getUpdateGroupMemberUnusedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupMemberUsedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateGroupMemberUsedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupMemberUsedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupMemberUsedBeautifulNumberMethod;
    if ((getUpdateGroupMemberUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getUpdateGroupMemberUsedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateGroupMemberUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getUpdateGroupMemberUsedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getUpdateGroupMemberUsedBeautifulNumberMethod = getUpdateGroupMemberUsedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateGroupMemberUsedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateGroupMemberUsedBeautifulNumber"))
              .build();
        }
      }
    }
    return getUpdateGroupMemberUsedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupUnusedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateGroupUnusedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupUnusedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupUnusedBeautifulNumberMethod;
    if ((getUpdateGroupUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getUpdateGroupUnusedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateGroupUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getUpdateGroupUnusedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getUpdateGroupUnusedBeautifulNumberMethod = getUpdateGroupUnusedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateGroupUnusedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateGroupUnusedBeautifulNumber"))
              .build();
        }
      }
    }
    return getUpdateGroupUnusedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupUsedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateGroupUsedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupUsedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupUsedBeautifulNumberMethod;
    if ((getUpdateGroupUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getUpdateGroupUsedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateGroupUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getUpdateGroupUsedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getUpdateGroupUsedBeautifulNumberMethod = getUpdateGroupUsedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateGroupUsedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateGroupUsedBeautifulNumber"))
              .build();
        }
      }
    }
    return getUpdateGroupUsedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupResponse> getUpdateGuestGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateGuestGroup",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupResponse> getUpdateGuestGroupMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupResponse> getUpdateGuestGroupMethod;
    if ((getUpdateGuestGroupMethod = InformationStorageServiceGrpc.getUpdateGuestGroupMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateGuestGroupMethod = InformationStorageServiceGrpc.getUpdateGuestGroupMethod) == null) {
          InformationStorageServiceGrpc.getUpdateGuestGroupMethod = getUpdateGuestGroupMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateGuestGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateGuestGroup"))
              .build();
        }
      }
    }
    return getUpdateGuestGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupAdministratorResponse> getUpdateGuestGroupAdministratorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateGuestGroupAdministrator",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupAdministratorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupAdministratorResponse> getUpdateGuestGroupAdministratorMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupAdministratorResponse> getUpdateGuestGroupAdministratorMethod;
    if ((getUpdateGuestGroupAdministratorMethod = InformationStorageServiceGrpc.getUpdateGuestGroupAdministratorMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateGuestGroupAdministratorMethod = InformationStorageServiceGrpc.getUpdateGuestGroupAdministratorMethod) == null) {
          InformationStorageServiceGrpc.getUpdateGuestGroupAdministratorMethod = getUpdateGuestGroupAdministratorMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupAdministratorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateGuestGroupAdministrator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupAdministratorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateGuestGroupAdministrator"))
              .build();
        }
      }
    }
    return getUpdateGuestGroupAdministratorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> getUpdateGuestGroupGuestUserMemberRelationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateGuestGroupGuestUserMemberRelation",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> getUpdateGuestGroupGuestUserMemberRelationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> getUpdateGuestGroupGuestUserMemberRelationMethod;
    if ((getUpdateGuestGroupGuestUserMemberRelationMethod = InformationStorageServiceGrpc.getUpdateGuestGroupGuestUserMemberRelationMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateGuestGroupGuestUserMemberRelationMethod = InformationStorageServiceGrpc.getUpdateGuestGroupGuestUserMemberRelationMethod) == null) {
          InformationStorageServiceGrpc.getUpdateGuestGroupGuestUserMemberRelationMethod = getUpdateGuestGroupGuestUserMemberRelationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateGuestGroupGuestUserMemberRelation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateGuestGroupGuestUserMemberRelation"))
              .build();
        }
      }
    }
    return getUpdateGuestGroupGuestUserMemberRelationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupMemberResponse> getUpdateGuestGroupMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateGuestGroupMember",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupMemberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupMemberResponse> getUpdateGuestGroupMemberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupMemberResponse> getUpdateGuestGroupMemberMethod;
    if ((getUpdateGuestGroupMemberMethod = InformationStorageServiceGrpc.getUpdateGuestGroupMemberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateGuestGroupMemberMethod = InformationStorageServiceGrpc.getUpdateGuestGroupMemberMethod) == null) {
          InformationStorageServiceGrpc.getUpdateGuestGroupMemberMethod = getUpdateGuestGroupMemberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupMemberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateGuestGroupMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupMemberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateGuestGroupMember"))
              .build();
        }
      }
    }
    return getUpdateGuestGroupMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> getUpdateGuestGroupRegisteredUserMemberRelationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateGuestGroupRegisteredUserMemberRelation",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> getUpdateGuestGroupRegisteredUserMemberRelationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> getUpdateGuestGroupRegisteredUserMemberRelationMethod;
    if ((getUpdateGuestGroupRegisteredUserMemberRelationMethod = InformationStorageServiceGrpc.getUpdateGuestGroupRegisteredUserMemberRelationMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateGuestGroupRegisteredUserMemberRelationMethod = InformationStorageServiceGrpc.getUpdateGuestGroupRegisteredUserMemberRelationMethod) == null) {
          InformationStorageServiceGrpc.getUpdateGuestGroupRegisteredUserMemberRelationMethod = getUpdateGuestGroupRegisteredUserMemberRelationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateGuestGroupRegisteredUserMemberRelation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateGuestGroupRegisteredUserMemberRelation"))
              .build();
        }
      }
    }
    return getUpdateGuestGroupRegisteredUserMemberRelationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestUserFriendResponse> getUpdateGuestUserFriendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateGuestUserFriend",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestUserFriendResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestUserFriendResponse> getUpdateGuestUserFriendMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestUserFriendResponse> getUpdateGuestUserFriendMethod;
    if ((getUpdateGuestUserFriendMethod = InformationStorageServiceGrpc.getUpdateGuestUserFriendMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateGuestUserFriendMethod = InformationStorageServiceGrpc.getUpdateGuestUserFriendMethod) == null) {
          InformationStorageServiceGrpc.getUpdateGuestUserFriendMethod = getUpdateGuestUserFriendMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestUserFriendResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateGuestUserFriend"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestUserFriendResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateGuestUserFriend"))
              .build();
        }
      }
    }
    return getUpdateGuestUserFriendMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.OfflineMessagePriorityResponse> getUpdateOfflineMessagePriorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateOfflineMessagePriority",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.OfflineMessagePriorityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.OfflineMessagePriorityResponse> getUpdateOfflineMessagePriorityMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.OfflineMessagePriorityResponse> getUpdateOfflineMessagePriorityMethod;
    if ((getUpdateOfflineMessagePriorityMethod = InformationStorageServiceGrpc.getUpdateOfflineMessagePriorityMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateOfflineMessagePriorityMethod = InformationStorageServiceGrpc.getUpdateOfflineMessagePriorityMethod) == null) {
          InformationStorageServiceGrpc.getUpdateOfflineMessagePriorityMethod = getUpdateOfflineMessagePriorityMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.OfflineMessagePriorityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateOfflineMessagePriority"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.OfflineMessagePriorityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateOfflineMessagePriority"))
              .build();
        }
      }
    }
    return getUpdateOfflineMessagePriorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupResponse> getUpdateRegisteredGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateRegisteredGroup",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupResponse> getUpdateRegisteredGroupMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupResponse> getUpdateRegisteredGroupMethod;
    if ((getUpdateRegisteredGroupMethod = InformationStorageServiceGrpc.getUpdateRegisteredGroupMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateRegisteredGroupMethod = InformationStorageServiceGrpc.getUpdateRegisteredGroupMethod) == null) {
          InformationStorageServiceGrpc.getUpdateRegisteredGroupMethod = getUpdateRegisteredGroupMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateRegisteredGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateRegisteredGroup"))
              .build();
        }
      }
    }
    return getUpdateRegisteredGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> getUpdateRegisteredGroupAdministratorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateRegisteredGroupAdministrator",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> getUpdateRegisteredGroupAdministratorMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> getUpdateRegisteredGroupAdministratorMethod;
    if ((getUpdateRegisteredGroupAdministratorMethod = InformationStorageServiceGrpc.getUpdateRegisteredGroupAdministratorMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateRegisteredGroupAdministratorMethod = InformationStorageServiceGrpc.getUpdateRegisteredGroupAdministratorMethod) == null) {
          InformationStorageServiceGrpc.getUpdateRegisteredGroupAdministratorMethod = getUpdateRegisteredGroupAdministratorMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateRegisteredGroupAdministrator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateRegisteredGroupAdministrator"))
              .build();
        }
      }
    }
    return getUpdateRegisteredGroupAdministratorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> getUpdateRegisteredGroupGuestUserMemberRelationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateRegisteredGroupGuestUserMemberRelation",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> getUpdateRegisteredGroupGuestUserMemberRelationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> getUpdateRegisteredGroupGuestUserMemberRelationMethod;
    if ((getUpdateRegisteredGroupGuestUserMemberRelationMethod = InformationStorageServiceGrpc.getUpdateRegisteredGroupGuestUserMemberRelationMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateRegisteredGroupGuestUserMemberRelationMethod = InformationStorageServiceGrpc.getUpdateRegisteredGroupGuestUserMemberRelationMethod) == null) {
          InformationStorageServiceGrpc.getUpdateRegisteredGroupGuestUserMemberRelationMethod = getUpdateRegisteredGroupGuestUserMemberRelationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateRegisteredGroupGuestUserMemberRelation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateRegisteredGroupGuestUserMemberRelation"))
              .build();
        }
      }
    }
    return getUpdateRegisteredGroupGuestUserMemberRelationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupMemberResponse> getUpdateRegisteredGroupMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateRegisteredGroupMember",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupMemberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupMemberResponse> getUpdateRegisteredGroupMemberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupMemberResponse> getUpdateRegisteredGroupMemberMethod;
    if ((getUpdateRegisteredGroupMemberMethod = InformationStorageServiceGrpc.getUpdateRegisteredGroupMemberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateRegisteredGroupMemberMethod = InformationStorageServiceGrpc.getUpdateRegisteredGroupMemberMethod) == null) {
          InformationStorageServiceGrpc.getUpdateRegisteredGroupMemberMethod = getUpdateRegisteredGroupMemberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupMemberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateRegisteredGroupMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupMemberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateRegisteredGroupMember"))
              .build();
        }
      }
    }
    return getUpdateRegisteredGroupMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> getUpdateRegisteredGroupRegisteredUserMemberRelationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateRegisteredGroupRegisteredUserMemberRelation",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> getUpdateRegisteredGroupRegisteredUserMemberRelationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> getUpdateRegisteredGroupRegisteredUserMemberRelationMethod;
    if ((getUpdateRegisteredGroupRegisteredUserMemberRelationMethod = InformationStorageServiceGrpc.getUpdateRegisteredGroupRegisteredUserMemberRelationMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateRegisteredGroupRegisteredUserMemberRelationMethod = InformationStorageServiceGrpc.getUpdateRegisteredGroupRegisteredUserMemberRelationMethod) == null) {
          InformationStorageServiceGrpc.getUpdateRegisteredGroupRegisteredUserMemberRelationMethod = getUpdateRegisteredGroupRegisteredUserMemberRelationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateRegisteredGroupRegisteredUserMemberRelation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateRegisteredGroupRegisteredUserMemberRelation"))
              .build();
        }
      }
    }
    return getUpdateRegisteredGroupRegisteredUserMemberRelationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredUserFriendResponse> getUpdateRegisteredUserFriendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateRegisteredUserFriend",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredUserFriendResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredUserFriendResponse> getUpdateRegisteredUserFriendMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredUserFriendResponse> getUpdateRegisteredUserFriendMethod;
    if ((getUpdateRegisteredUserFriendMethod = InformationStorageServiceGrpc.getUpdateRegisteredUserFriendMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateRegisteredUserFriendMethod = InformationStorageServiceGrpc.getUpdateRegisteredUserFriendMethod) == null) {
          InformationStorageServiceGrpc.getUpdateRegisteredUserFriendMethod = getUpdateRegisteredUserFriendMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredUserFriendResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateRegisteredUserFriend"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredUserFriendResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateRegisteredUserFriend"))
              .build();
        }
      }
    }
    return getUpdateRegisteredUserFriendMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupUnusedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateGroupUnusedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupUnusedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupUnusedBeautifulNumberRealMethod;
    if ((getUpdateGroupUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getUpdateGroupUnusedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateGroupUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getUpdateGroupUnusedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getUpdateGroupUnusedBeautifulNumberRealMethod = getUpdateGroupUnusedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateGroupUnusedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateGroupUnusedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getUpdateGroupUnusedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupUsedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateGroupUsedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupUsedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupUsedBeautifulNumberRealMethod;
    if ((getUpdateGroupUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getUpdateGroupUsedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateGroupUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getUpdateGroupUsedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getUpdateGroupUsedBeautifulNumberRealMethod = getUpdateGroupUsedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateGroupUsedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateGroupUsedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getUpdateGroupUsedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupMemberUnusedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateGroupMemberUnusedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupMemberUnusedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupMemberUnusedBeautifulNumberRealMethod;
    if ((getUpdateGroupMemberUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getUpdateGroupMemberUnusedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateGroupMemberUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getUpdateGroupMemberUnusedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getUpdateGroupMemberUnusedBeautifulNumberRealMethod = getUpdateGroupMemberUnusedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateGroupMemberUnusedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateGroupMemberUnusedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getUpdateGroupMemberUnusedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupMemberUsedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateGroupMemberUsedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupMemberUsedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateGroupMemberUsedBeautifulNumberRealMethod;
    if ((getUpdateGroupMemberUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getUpdateGroupMemberUsedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateGroupMemberUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getUpdateGroupMemberUsedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getUpdateGroupMemberUsedBeautifulNumberRealMethod = getUpdateGroupMemberUsedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateGroupMemberUsedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateGroupMemberUsedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getUpdateGroupMemberUsedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateFriendUnusedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateFriendUnusedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateFriendUnusedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateFriendUnusedBeautifulNumberRealMethod;
    if ((getUpdateFriendUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getUpdateFriendUnusedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateFriendUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getUpdateFriendUnusedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getUpdateFriendUnusedBeautifulNumberRealMethod = getUpdateFriendUnusedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateFriendUnusedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateFriendUnusedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getUpdateFriendUnusedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateFriendUsedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateFriendUsedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateFriendUsedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getUpdateFriendUsedBeautifulNumberRealMethod;
    if ((getUpdateFriendUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getUpdateFriendUsedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateFriendUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getUpdateFriendUsedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getUpdateFriendUsedBeautifulNumberRealMethod = getUpdateFriendUsedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateFriendUsedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateFriendUsedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getUpdateFriendUsedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GroupRemarkResponse> getUpdateGroupRemarkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateGroupRemark",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GroupRemarkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GroupRemarkResponse> getUpdateGroupRemarkMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GroupRemarkResponse> getUpdateGroupRemarkMethod;
    if ((getUpdateGroupRemarkMethod = InformationStorageServiceGrpc.getUpdateGroupRemarkMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getUpdateGroupRemarkMethod = InformationStorageServiceGrpc.getUpdateGroupRemarkMethod) == null) {
          InformationStorageServiceGrpc.getUpdateGroupRemarkMethod = getUpdateGroupRemarkMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GroupRemarkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateGroupRemark"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GroupRemarkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("updateGroupRemark"))
              .build();
        }
      }
    }
    return getUpdateGroupRemarkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteFriendUnusedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteFriendUnusedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteFriendUnusedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteFriendUnusedBeautifulNumberMethod;
    if ((getDeleteFriendUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getDeleteFriendUnusedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteFriendUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getDeleteFriendUnusedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getDeleteFriendUnusedBeautifulNumberMethod = getDeleteFriendUnusedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteFriendUnusedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteFriendUnusedBeautifulNumber"))
              .build();
        }
      }
    }
    return getDeleteFriendUnusedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteFriendUsedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteFriendUsedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteFriendUsedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteFriendUsedBeautifulNumberMethod;
    if ((getDeleteFriendUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getDeleteFriendUsedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteFriendUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getDeleteFriendUsedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getDeleteFriendUsedBeautifulNumberMethod = getDeleteFriendUsedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteFriendUsedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteFriendUsedBeautifulNumber"))
              .build();
        }
      }
    }
    return getDeleteFriendUsedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GroupAnnouncementsResponse> getDeleteGroupAnnouncementsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGroupAnnouncements",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GroupAnnouncementsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GroupAnnouncementsResponse> getDeleteGroupAnnouncementsMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GroupAnnouncementsResponse> getDeleteGroupAnnouncementsMethod;
    if ((getDeleteGroupAnnouncementsMethod = InformationStorageServiceGrpc.getDeleteGroupAnnouncementsMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteGroupAnnouncementsMethod = InformationStorageServiceGrpc.getDeleteGroupAnnouncementsMethod) == null) {
          InformationStorageServiceGrpc.getDeleteGroupAnnouncementsMethod = getDeleteGroupAnnouncementsMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GroupAnnouncementsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGroupAnnouncements"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GroupAnnouncementsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteGroupAnnouncements"))
              .build();
        }
      }
    }
    return getDeleteGroupAnnouncementsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupMemberUnusedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGroupMemberUnusedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupMemberUnusedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupMemberUnusedBeautifulNumberMethod;
    if ((getDeleteGroupMemberUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getDeleteGroupMemberUnusedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteGroupMemberUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getDeleteGroupMemberUnusedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getDeleteGroupMemberUnusedBeautifulNumberMethod = getDeleteGroupMemberUnusedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGroupMemberUnusedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteGroupMemberUnusedBeautifulNumber"))
              .build();
        }
      }
    }
    return getDeleteGroupMemberUnusedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupMemberUsedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGroupMemberUsedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupMemberUsedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupMemberUsedBeautifulNumberMethod;
    if ((getDeleteGroupMemberUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getDeleteGroupMemberUsedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteGroupMemberUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getDeleteGroupMemberUsedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getDeleteGroupMemberUsedBeautifulNumberMethod = getDeleteGroupMemberUsedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGroupMemberUsedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteGroupMemberUsedBeautifulNumber"))
              .build();
        }
      }
    }
    return getDeleteGroupMemberUsedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupUnusedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGroupUnusedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupUnusedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupUnusedBeautifulNumberMethod;
    if ((getDeleteGroupUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getDeleteGroupUnusedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteGroupUnusedBeautifulNumberMethod = InformationStorageServiceGrpc.getDeleteGroupUnusedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getDeleteGroupUnusedBeautifulNumberMethod = getDeleteGroupUnusedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGroupUnusedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteGroupUnusedBeautifulNumber"))
              .build();
        }
      }
    }
    return getDeleteGroupUnusedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupUsedBeautifulNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGroupUsedBeautifulNumber",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupUsedBeautifulNumberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupUsedBeautifulNumberMethod;
    if ((getDeleteGroupUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getDeleteGroupUsedBeautifulNumberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteGroupUsedBeautifulNumberMethod = InformationStorageServiceGrpc.getDeleteGroupUsedBeautifulNumberMethod) == null) {
          InformationStorageServiceGrpc.getDeleteGroupUsedBeautifulNumberMethod = getDeleteGroupUsedBeautifulNumberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGroupUsedBeautifulNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteGroupUsedBeautifulNumber"))
              .build();
        }
      }
    }
    return getDeleteGroupUsedBeautifulNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupResponse> getDeleteGuestGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGuestGroup",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupResponse> getDeleteGuestGroupMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupResponse> getDeleteGuestGroupMethod;
    if ((getDeleteGuestGroupMethod = InformationStorageServiceGrpc.getDeleteGuestGroupMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteGuestGroupMethod = InformationStorageServiceGrpc.getDeleteGuestGroupMethod) == null) {
          InformationStorageServiceGrpc.getDeleteGuestGroupMethod = getDeleteGuestGroupMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGuestGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteGuestGroup"))
              .build();
        }
      }
    }
    return getDeleteGuestGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupAdministratorResponse> getDeleteGuestGroupAdministratorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGuestGroupAdministrator",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupAdministratorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupAdministratorResponse> getDeleteGuestGroupAdministratorMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupAdministratorResponse> getDeleteGuestGroupAdministratorMethod;
    if ((getDeleteGuestGroupAdministratorMethod = InformationStorageServiceGrpc.getDeleteGuestGroupAdministratorMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteGuestGroupAdministratorMethod = InformationStorageServiceGrpc.getDeleteGuestGroupAdministratorMethod) == null) {
          InformationStorageServiceGrpc.getDeleteGuestGroupAdministratorMethod = getDeleteGuestGroupAdministratorMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupAdministratorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGuestGroupAdministrator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupAdministratorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteGuestGroupAdministrator"))
              .build();
        }
      }
    }
    return getDeleteGuestGroupAdministratorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> getDeleteGuestGroupGuestUserMemberRelationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGuestGroupGuestUserMemberRelation",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> getDeleteGuestGroupGuestUserMemberRelationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> getDeleteGuestGroupGuestUserMemberRelationMethod;
    if ((getDeleteGuestGroupGuestUserMemberRelationMethod = InformationStorageServiceGrpc.getDeleteGuestGroupGuestUserMemberRelationMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteGuestGroupGuestUserMemberRelationMethod = InformationStorageServiceGrpc.getDeleteGuestGroupGuestUserMemberRelationMethod) == null) {
          InformationStorageServiceGrpc.getDeleteGuestGroupGuestUserMemberRelationMethod = getDeleteGuestGroupGuestUserMemberRelationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGuestGroupGuestUserMemberRelation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteGuestGroupGuestUserMemberRelation"))
              .build();
        }
      }
    }
    return getDeleteGuestGroupGuestUserMemberRelationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupMemberResponse> getDeleteGuestGroupMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGuestGroupMember",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupMemberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupMemberResponse> getDeleteGuestGroupMemberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupMemberResponse> getDeleteGuestGroupMemberMethod;
    if ((getDeleteGuestGroupMemberMethod = InformationStorageServiceGrpc.getDeleteGuestGroupMemberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteGuestGroupMemberMethod = InformationStorageServiceGrpc.getDeleteGuestGroupMemberMethod) == null) {
          InformationStorageServiceGrpc.getDeleteGuestGroupMemberMethod = getDeleteGuestGroupMemberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupMemberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGuestGroupMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupMemberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteGuestGroupMember"))
              .build();
        }
      }
    }
    return getDeleteGuestGroupMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> getDeleteGuestGroupRegisteredUserMemberRelationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGuestGroupRegisteredUserMemberRelation",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> getDeleteGuestGroupRegisteredUserMemberRelationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> getDeleteGuestGroupRegisteredUserMemberRelationMethod;
    if ((getDeleteGuestGroupRegisteredUserMemberRelationMethod = InformationStorageServiceGrpc.getDeleteGuestGroupRegisteredUserMemberRelationMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteGuestGroupRegisteredUserMemberRelationMethod = InformationStorageServiceGrpc.getDeleteGuestGroupRegisteredUserMemberRelationMethod) == null) {
          InformationStorageServiceGrpc.getDeleteGuestGroupRegisteredUserMemberRelationMethod = getDeleteGuestGroupRegisteredUserMemberRelationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGuestGroupRegisteredUserMemberRelation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteGuestGroupRegisteredUserMemberRelation"))
              .build();
        }
      }
    }
    return getDeleteGuestGroupRegisteredUserMemberRelationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestUserFriendResponse> getDeleteGuestUserFriendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGuestUserFriend",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GuestUserFriendResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GuestUserFriendResponse> getDeleteGuestUserFriendMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestUserFriendResponse> getDeleteGuestUserFriendMethod;
    if ((getDeleteGuestUserFriendMethod = InformationStorageServiceGrpc.getDeleteGuestUserFriendMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteGuestUserFriendMethod = InformationStorageServiceGrpc.getDeleteGuestUserFriendMethod) == null) {
          InformationStorageServiceGrpc.getDeleteGuestUserFriendMethod = getDeleteGuestUserFriendMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GuestUserFriendResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGuestUserFriend"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GuestUserFriendResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteGuestUserFriend"))
              .build();
        }
      }
    }
    return getDeleteGuestUserFriendMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.OfflineMessagePriorityResponse> getDeleteOfflineMessagePriorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteOfflineMessagePriority",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.OfflineMessagePriorityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.OfflineMessagePriorityResponse> getDeleteOfflineMessagePriorityMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.OfflineMessagePriorityResponse> getDeleteOfflineMessagePriorityMethod;
    if ((getDeleteOfflineMessagePriorityMethod = InformationStorageServiceGrpc.getDeleteOfflineMessagePriorityMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteOfflineMessagePriorityMethod = InformationStorageServiceGrpc.getDeleteOfflineMessagePriorityMethod) == null) {
          InformationStorageServiceGrpc.getDeleteOfflineMessagePriorityMethod = getDeleteOfflineMessagePriorityMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.OfflineMessagePriorityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteOfflineMessagePriority"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.OfflineMessagePriorityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteOfflineMessagePriority"))
              .build();
        }
      }
    }
    return getDeleteOfflineMessagePriorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupResponse> getDeleteRegisteredGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteRegisteredGroup",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupResponse> getDeleteRegisteredGroupMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupResponse> getDeleteRegisteredGroupMethod;
    if ((getDeleteRegisteredGroupMethod = InformationStorageServiceGrpc.getDeleteRegisteredGroupMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteRegisteredGroupMethod = InformationStorageServiceGrpc.getDeleteRegisteredGroupMethod) == null) {
          InformationStorageServiceGrpc.getDeleteRegisteredGroupMethod = getDeleteRegisteredGroupMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteRegisteredGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteRegisteredGroup"))
              .build();
        }
      }
    }
    return getDeleteRegisteredGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> getDeleteRegisteredGroupAdministratorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteRegisteredGroupAdministrator",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> getDeleteRegisteredGroupAdministratorMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> getDeleteRegisteredGroupAdministratorMethod;
    if ((getDeleteRegisteredGroupAdministratorMethod = InformationStorageServiceGrpc.getDeleteRegisteredGroupAdministratorMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteRegisteredGroupAdministratorMethod = InformationStorageServiceGrpc.getDeleteRegisteredGroupAdministratorMethod) == null) {
          InformationStorageServiceGrpc.getDeleteRegisteredGroupAdministratorMethod = getDeleteRegisteredGroupAdministratorMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteRegisteredGroupAdministrator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteRegisteredGroupAdministrator"))
              .build();
        }
      }
    }
    return getDeleteRegisteredGroupAdministratorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> getDeleteRegisteredGroupGuestUserMemberRelationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteRegisteredGroupGuestUserMemberRelation",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> getDeleteRegisteredGroupGuestUserMemberRelationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> getDeleteRegisteredGroupGuestUserMemberRelationMethod;
    if ((getDeleteRegisteredGroupGuestUserMemberRelationMethod = InformationStorageServiceGrpc.getDeleteRegisteredGroupGuestUserMemberRelationMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteRegisteredGroupGuestUserMemberRelationMethod = InformationStorageServiceGrpc.getDeleteRegisteredGroupGuestUserMemberRelationMethod) == null) {
          InformationStorageServiceGrpc.getDeleteRegisteredGroupGuestUserMemberRelationMethod = getDeleteRegisteredGroupGuestUserMemberRelationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteRegisteredGroupGuestUserMemberRelation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteRegisteredGroupGuestUserMemberRelation"))
              .build();
        }
      }
    }
    return getDeleteRegisteredGroupGuestUserMemberRelationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupMemberResponse> getDeleteRegisteredGroupMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteRegisteredGroupMember",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupMemberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupMemberResponse> getDeleteRegisteredGroupMemberMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupMemberResponse> getDeleteRegisteredGroupMemberMethod;
    if ((getDeleteRegisteredGroupMemberMethod = InformationStorageServiceGrpc.getDeleteRegisteredGroupMemberMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteRegisteredGroupMemberMethod = InformationStorageServiceGrpc.getDeleteRegisteredGroupMemberMethod) == null) {
          InformationStorageServiceGrpc.getDeleteRegisteredGroupMemberMethod = getDeleteRegisteredGroupMemberMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupMemberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteRegisteredGroupMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupMemberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteRegisteredGroupMember"))
              .build();
        }
      }
    }
    return getDeleteRegisteredGroupMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> getDeleteRegisteredGroupRegisteredUserMemberRelationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteRegisteredGroupRegisteredUserMemberRelation",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> getDeleteRegisteredGroupRegisteredUserMemberRelationMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> getDeleteRegisteredGroupRegisteredUserMemberRelationMethod;
    if ((getDeleteRegisteredGroupRegisteredUserMemberRelationMethod = InformationStorageServiceGrpc.getDeleteRegisteredGroupRegisteredUserMemberRelationMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteRegisteredGroupRegisteredUserMemberRelationMethod = InformationStorageServiceGrpc.getDeleteRegisteredGroupRegisteredUserMemberRelationMethod) == null) {
          InformationStorageServiceGrpc.getDeleteRegisteredGroupRegisteredUserMemberRelationMethod = getDeleteRegisteredGroupRegisteredUserMemberRelationMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteRegisteredGroupRegisteredUserMemberRelation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteRegisteredGroupRegisteredUserMemberRelation"))
              .build();
        }
      }
    }
    return getDeleteRegisteredGroupRegisteredUserMemberRelationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredUserFriendResponse> getDeleteRegisteredUserFriendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteRegisteredUserFriend",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.RegisteredUserFriendResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.RegisteredUserFriendResponse> getDeleteRegisteredUserFriendMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredUserFriendResponse> getDeleteRegisteredUserFriendMethod;
    if ((getDeleteRegisteredUserFriendMethod = InformationStorageServiceGrpc.getDeleteRegisteredUserFriendMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteRegisteredUserFriendMethod = InformationStorageServiceGrpc.getDeleteRegisteredUserFriendMethod) == null) {
          InformationStorageServiceGrpc.getDeleteRegisteredUserFriendMethod = getDeleteRegisteredUserFriendMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.RegisteredUserFriendResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteRegisteredUserFriend"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.RegisteredUserFriendResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteRegisteredUserFriend"))
              .build();
        }
      }
    }
    return getDeleteRegisteredUserFriendMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupUnusedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGroupUnusedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupUnusedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupUnusedBeautifulNumberRealMethod;
    if ((getDeleteGroupUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getDeleteGroupUnusedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteGroupUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getDeleteGroupUnusedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getDeleteGroupUnusedBeautifulNumberRealMethod = getDeleteGroupUnusedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGroupUnusedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteGroupUnusedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getDeleteGroupUnusedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupUsedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGroupUsedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupUsedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupUsedBeautifulNumberRealMethod;
    if ((getDeleteGroupUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getDeleteGroupUsedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteGroupUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getDeleteGroupUsedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getDeleteGroupUsedBeautifulNumberRealMethod = getDeleteGroupUsedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGroupUsedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteGroupUsedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getDeleteGroupUsedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupMemberUnusedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGroupMemberUnusedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupMemberUnusedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupMemberUnusedBeautifulNumberRealMethod;
    if ((getDeleteGroupMemberUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getDeleteGroupMemberUnusedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteGroupMemberUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getDeleteGroupMemberUnusedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getDeleteGroupMemberUnusedBeautifulNumberRealMethod = getDeleteGroupMemberUnusedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGroupMemberUnusedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteGroupMemberUnusedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getDeleteGroupMemberUnusedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupMemberUsedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGroupMemberUsedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupMemberUsedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteGroupMemberUsedBeautifulNumberRealMethod;
    if ((getDeleteGroupMemberUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getDeleteGroupMemberUsedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteGroupMemberUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getDeleteGroupMemberUsedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getDeleteGroupMemberUsedBeautifulNumberRealMethod = getDeleteGroupMemberUsedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGroupMemberUsedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteGroupMemberUsedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getDeleteGroupMemberUsedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteFriendUnusedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteFriendUnusedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteFriendUnusedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteFriendUnusedBeautifulNumberRealMethod;
    if ((getDeleteFriendUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getDeleteFriendUnusedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteFriendUnusedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getDeleteFriendUnusedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getDeleteFriendUnusedBeautifulNumberRealMethod = getDeleteFriendUnusedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteFriendUnusedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteFriendUnusedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getDeleteFriendUnusedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteFriendUsedBeautifulNumberRealMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteFriendUsedBeautifulNumberReal",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.BeautifulNumberCommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteFriendUsedBeautifulNumberRealMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse> getDeleteFriendUsedBeautifulNumberRealMethod;
    if ((getDeleteFriendUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getDeleteFriendUsedBeautifulNumberRealMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteFriendUsedBeautifulNumberRealMethod = InformationStorageServiceGrpc.getDeleteFriendUsedBeautifulNumberRealMethod) == null) {
          InformationStorageServiceGrpc.getDeleteFriendUsedBeautifulNumberRealMethod = getDeleteFriendUsedBeautifulNumberRealMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.BeautifulNumberCommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteFriendUsedBeautifulNumberReal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.BeautifulNumberCommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteFriendUsedBeautifulNumberReal"))
              .build();
        }
      }
    }
    return getDeleteFriendUsedBeautifulNumberRealMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GroupRemarkResponse> getDeleteGroupRemarkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteGroupRemark",
      requestType = com.lanjiu.im.grpc.TransmissionRequest.class,
      responseType = com.lanjiu.im.grpc.GroupRemarkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest,
      com.lanjiu.im.grpc.GroupRemarkResponse> getDeleteGroupRemarkMethod() {
    io.grpc.MethodDescriptor<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GroupRemarkResponse> getDeleteGroupRemarkMethod;
    if ((getDeleteGroupRemarkMethod = InformationStorageServiceGrpc.getDeleteGroupRemarkMethod) == null) {
      synchronized (InformationStorageServiceGrpc.class) {
        if ((getDeleteGroupRemarkMethod = InformationStorageServiceGrpc.getDeleteGroupRemarkMethod) == null) {
          InformationStorageServiceGrpc.getDeleteGroupRemarkMethod = getDeleteGroupRemarkMethod =
              io.grpc.MethodDescriptor.<com.lanjiu.im.grpc.TransmissionRequest, com.lanjiu.im.grpc.GroupRemarkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteGroupRemark"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.TransmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lanjiu.im.grpc.GroupRemarkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InformationStorageServiceMethodDescriptorSupplier("deleteGroupRemark"))
              .build();
        }
      }
    }
    return getDeleteGroupRemarkMethod;
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
    public void selectBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void selectBeautifulNumberAuto(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectBeautifulNumberAutoMethod(), responseObserver);
    }

    /**
     */
    public void selectBurnAfterReadingPriority(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BurnAfterReadingPriorityResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectBurnAfterReadingPriorityMethod(), responseObserver);
    }

    /**
     */
    public void selectFriendUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectFriendUnusedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void selectFriendUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectFriendUsedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void selectGroupAnnouncements(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupAnnouncementsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGroupAnnouncementsMethod(), responseObserver);
    }

    /**
     */
    public void selectGroupMemberUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGroupMemberUnusedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void selectGroupMemberUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGroupMemberUsedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void selectGroupUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGroupUnusedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void selectGroupUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGroupUsedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void selectGuestGroup(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGuestGroupMethod(), responseObserver);
    }

    /**
     */
    public void selectGuestGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupAdministratorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGuestGroupAdministratorMethod(), responseObserver);
    }

    /**
     */
    public void selectGuestGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGuestGroupGuestUserMemberRelationMethod(), responseObserver);
    }

    /**
     */
    public void selectGuestGroupMember(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupMemberResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGuestGroupMemberMethod(), responseObserver);
    }

    /**
     */
    public void selectGuestGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGuestGroupRegisteredUserMemberRelationMethod(), responseObserver);
    }

    /**
     */
    public void selectGuestUserFriend(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestUserFriendResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGuestUserFriendMethod(), responseObserver);
    }

    /**
     */
    public void selectOfflineMessagePriority(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.OfflineMessagePriorityResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectOfflineMessagePriorityMethod(), responseObserver);
    }

    /**
     */
    public void selectRegisteredGroup(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectRegisteredGroupMethod(), responseObserver);
    }

    /**
     */
    public void selectRegisteredGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectRegisteredGroupAdministratorMethod(), responseObserver);
    }

    /**
     */
    public void selectRegisteredGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectRegisteredGroupGuestUserMemberRelationMethod(), responseObserver);
    }

    /**
     */
    public void selectRegisteredGroupMember(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupMemberResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectRegisteredGroupMemberMethod(), responseObserver);
    }

    /**
     */
    public void selectRegisteredGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectRegisteredGroupRegisteredUserMemberRelationMethod(), responseObserver);
    }

    /**
     */
    public void selectRegisteredUserFriend(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredUserFriendResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectRegisteredUserFriendMethod(), responseObserver);
    }

    /**
     */
    public void selectGroupUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGroupUnusedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void selectGroupUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGroupUsedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void selectGroupMemberUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGroupMemberUnusedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void selectGroupMemberUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGroupMemberUsedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void selectFriendUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectFriendUnusedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void selectFriendUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectFriendUsedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void selectGroupRemark(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupRemarkResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSelectGroupRemarkMethod(), responseObserver);
    }

    /**
     */
    public void insertFriendUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertFriendUnusedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void insertFriendUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertFriendUsedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void insertGroupAnnouncements(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupAnnouncementsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertGroupAnnouncementsMethod(), responseObserver);
    }

    /**
     */
    public void insertGroupMemberUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertGroupMemberUnusedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void insertGroupMemberUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertGroupMemberUsedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void insertGroupUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertGroupUnusedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void insertGroupUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertGroupUsedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void insertGuestGroup(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertGuestGroupMethod(), responseObserver);
    }

    /**
     */
    public void insertGuestGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupAdministratorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertGuestGroupAdministratorMethod(), responseObserver);
    }

    /**
     */
    public void insertGuestGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertGuestGroupGuestUserMemberRelationMethod(), responseObserver);
    }

    /**
     */
    public void insertGuestGroupMember(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupMemberResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertGuestGroupMemberMethod(), responseObserver);
    }

    /**
     */
    public void insertGuestGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertGuestGroupRegisteredUserMemberRelationMethod(), responseObserver);
    }

    /**
     */
    public void insertGuestUserFriend(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestUserFriendResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertGuestUserFriendMethod(), responseObserver);
    }

    /**
     */
    public void insertOfflineMessagePriority(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.OfflineMessagePriorityResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertOfflineMessagePriorityMethod(), responseObserver);
    }

    /**
     */
    public void insertRegisteredGroup(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertRegisteredGroupMethod(), responseObserver);
    }

    /**
     */
    public void insertRegisteredGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertRegisteredGroupAdministratorMethod(), responseObserver);
    }

    /**
     */
    public void insertRegisteredGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertRegisteredGroupGuestUserMemberRelationMethod(), responseObserver);
    }

    /**
     */
    public void insertRegisteredGroupMember(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupMemberResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertRegisteredGroupMemberMethod(), responseObserver);
    }

    /**
     */
    public void insertRegisteredGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertRegisteredGroupRegisteredUserMemberRelationMethod(), responseObserver);
    }

    /**
     */
    public void insertRegisteredUserFriend(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredUserFriendResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertRegisteredUserFriendMethod(), responseObserver);
    }

    /**
     */
    public void insertGroupUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertGroupUnusedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void insertGroupUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertGroupUsedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void insertGroupMemberUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertGroupMemberUnusedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void insertGroupMemberUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertGroupMemberUsedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void insertFriendUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertFriendUnusedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void insertFriendUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertFriendUsedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void insertGroupRemark(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupRemarkResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertGroupRemarkMethod(), responseObserver);
    }

    /**
     */
    public void updateFriendUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateFriendUnusedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void updateFriendUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateFriendUsedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void updateGroupAnnouncements(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupAnnouncementsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGroupAnnouncementsMethod(), responseObserver);
    }

    /**
     */
    public void updateGroupMemberUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGroupMemberUnusedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void updateGroupMemberUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGroupMemberUsedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void updateGroupUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGroupUnusedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void updateGroupUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGroupUsedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void updateGuestGroup(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGuestGroupMethod(), responseObserver);
    }

    /**
     */
    public void updateGuestGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupAdministratorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGuestGroupAdministratorMethod(), responseObserver);
    }

    /**
     */
    public void updateGuestGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGuestGroupGuestUserMemberRelationMethod(), responseObserver);
    }

    /**
     */
    public void updateGuestGroupMember(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupMemberResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGuestGroupMemberMethod(), responseObserver);
    }

    /**
     */
    public void updateGuestGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGuestGroupRegisteredUserMemberRelationMethod(), responseObserver);
    }

    /**
     */
    public void updateGuestUserFriend(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestUserFriendResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGuestUserFriendMethod(), responseObserver);
    }

    /**
     */
    public void updateOfflineMessagePriority(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.OfflineMessagePriorityResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateOfflineMessagePriorityMethod(), responseObserver);
    }

    /**
     */
    public void updateRegisteredGroup(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateRegisteredGroupMethod(), responseObserver);
    }

    /**
     */
    public void updateRegisteredGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateRegisteredGroupAdministratorMethod(), responseObserver);
    }

    /**
     */
    public void updateRegisteredGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateRegisteredGroupGuestUserMemberRelationMethod(), responseObserver);
    }

    /**
     */
    public void updateRegisteredGroupMember(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupMemberResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateRegisteredGroupMemberMethod(), responseObserver);
    }

    /**
     */
    public void updateRegisteredGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateRegisteredGroupRegisteredUserMemberRelationMethod(), responseObserver);
    }

    /**
     */
    public void updateRegisteredUserFriend(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredUserFriendResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateRegisteredUserFriendMethod(), responseObserver);
    }

    /**
     */
    public void updateGroupUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGroupUnusedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void updateGroupUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGroupUsedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void updateGroupMemberUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGroupMemberUnusedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void updateGroupMemberUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGroupMemberUsedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void updateFriendUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateFriendUnusedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void updateFriendUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateFriendUsedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void updateGroupRemark(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupRemarkResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGroupRemarkMethod(), responseObserver);
    }

    /**
     */
    public void deleteFriendUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteFriendUnusedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void deleteFriendUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteFriendUsedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void deleteGroupAnnouncements(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupAnnouncementsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGroupAnnouncementsMethod(), responseObserver);
    }

    /**
     */
    public void deleteGroupMemberUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGroupMemberUnusedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void deleteGroupMemberUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGroupMemberUsedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void deleteGroupUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGroupUnusedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void deleteGroupUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGroupUsedBeautifulNumberMethod(), responseObserver);
    }

    /**
     */
    public void deleteGuestGroup(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGuestGroupMethod(), responseObserver);
    }

    /**
     */
    public void deleteGuestGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupAdministratorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGuestGroupAdministratorMethod(), responseObserver);
    }

    /**
     */
    public void deleteGuestGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGuestGroupGuestUserMemberRelationMethod(), responseObserver);
    }

    /**
     */
    public void deleteGuestGroupMember(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupMemberResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGuestGroupMemberMethod(), responseObserver);
    }

    /**
     */
    public void deleteGuestGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGuestGroupRegisteredUserMemberRelationMethod(), responseObserver);
    }

    /**
     */
    public void deleteGuestUserFriend(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestUserFriendResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGuestUserFriendMethod(), responseObserver);
    }

    /**
     */
    public void deleteOfflineMessagePriority(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.OfflineMessagePriorityResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteOfflineMessagePriorityMethod(), responseObserver);
    }

    /**
     */
    public void deleteRegisteredGroup(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteRegisteredGroupMethod(), responseObserver);
    }

    /**
     */
    public void deleteRegisteredGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteRegisteredGroupAdministratorMethod(), responseObserver);
    }

    /**
     */
    public void deleteRegisteredGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteRegisteredGroupGuestUserMemberRelationMethod(), responseObserver);
    }

    /**
     */
    public void deleteRegisteredGroupMember(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupMemberResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteRegisteredGroupMemberMethod(), responseObserver);
    }

    /**
     */
    public void deleteRegisteredGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteRegisteredGroupRegisteredUserMemberRelationMethod(), responseObserver);
    }

    /**
     */
    public void deleteRegisteredUserFriend(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredUserFriendResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteRegisteredUserFriendMethod(), responseObserver);
    }

    /**
     */
    public void deleteGroupUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGroupUnusedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void deleteGroupUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGroupUsedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void deleteGroupMemberUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGroupMemberUnusedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void deleteGroupMemberUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGroupMemberUsedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void deleteFriendUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteFriendUnusedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void deleteFriendUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteFriendUsedBeautifulNumberRealMethod(), responseObserver);
    }

    /**
     */
    public void deleteGroupRemark(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupRemarkResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGroupRemarkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSelectBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_SELECT_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getSelectBeautifulNumberAutoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_SELECT_BEAUTIFUL_NUMBER_AUTO)))
          .addMethod(
            getSelectBurnAfterReadingPriorityMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BurnAfterReadingPriorityResponse>(
                  this, METHODID_SELECT_BURN_AFTER_READING_PRIORITY)))
          .addMethod(
            getSelectFriendUnusedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_SELECT_FRIEND_UNUSED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getSelectFriendUsedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_SELECT_FRIEND_USED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getSelectGroupAnnouncementsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GroupAnnouncementsResponse>(
                  this, METHODID_SELECT_GROUP_ANNOUNCEMENTS)))
          .addMethod(
            getSelectGroupMemberUnusedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_SELECT_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getSelectGroupMemberUsedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_SELECT_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getSelectGroupUnusedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_SELECT_GROUP_UNUSED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getSelectGroupUsedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_SELECT_GROUP_USED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getSelectGuestGroupMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupResponse>(
                  this, METHODID_SELECT_GUEST_GROUP)))
          .addMethod(
            getSelectGuestGroupAdministratorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupAdministratorResponse>(
                  this, METHODID_SELECT_GUEST_GROUP_ADMINISTRATOR)))
          .addMethod(
            getSelectGuestGroupGuestUserMemberRelationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse>(
                  this, METHODID_SELECT_GUEST_GROUP_GUEST_USER_MEMBER_RELATION)))
          .addMethod(
            getSelectGuestGroupMemberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupMemberResponse>(
                  this, METHODID_SELECT_GUEST_GROUP_MEMBER)))
          .addMethod(
            getSelectGuestGroupRegisteredUserMemberRelationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse>(
                  this, METHODID_SELECT_GUEST_GROUP_REGISTERED_USER_MEMBER_RELATION)))
          .addMethod(
            getSelectGuestUserFriendMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestUserFriendResponse>(
                  this, METHODID_SELECT_GUEST_USER_FRIEND)))
          .addMethod(
            getSelectOfflineMessagePriorityMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.OfflineMessagePriorityResponse>(
                  this, METHODID_SELECT_OFFLINE_MESSAGE_PRIORITY)))
          .addMethod(
            getSelectRegisteredGroupMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupResponse>(
                  this, METHODID_SELECT_REGISTERED_GROUP)))
          .addMethod(
            getSelectRegisteredGroupAdministratorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse>(
                  this, METHODID_SELECT_REGISTERED_GROUP_ADMINISTRATOR)))
          .addMethod(
            getSelectRegisteredGroupGuestUserMemberRelationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse>(
                  this, METHODID_SELECT_REGISTERED_GROUP_GUEST_USER_MEMBER_RELATION)))
          .addMethod(
            getSelectRegisteredGroupMemberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupMemberResponse>(
                  this, METHODID_SELECT_REGISTERED_GROUP_MEMBER)))
          .addMethod(
            getSelectRegisteredGroupRegisteredUserMemberRelationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse>(
                  this, METHODID_SELECT_REGISTERED_GROUP_REGISTERED_USER_MEMBER_RELATION)))
          .addMethod(
            getSelectRegisteredUserFriendMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredUserFriendResponse>(
                  this, METHODID_SELECT_REGISTERED_USER_FRIEND)))
          .addMethod(
            getSelectGroupUnusedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_SELECT_GROUP_UNUSED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getSelectGroupUsedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_SELECT_GROUP_USED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getSelectGroupMemberUnusedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_SELECT_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getSelectGroupMemberUsedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_SELECT_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getSelectFriendUnusedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_SELECT_FRIEND_UNUSED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getSelectFriendUsedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_SELECT_FRIEND_USED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getSelectGroupRemarkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GroupRemarkResponse>(
                  this, METHODID_SELECT_GROUP_REMARK)))
          .addMethod(
            getInsertFriendUnusedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_INSERT_FRIEND_UNUSED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getInsertFriendUsedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_INSERT_FRIEND_USED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getInsertGroupAnnouncementsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GroupAnnouncementsResponse>(
                  this, METHODID_INSERT_GROUP_ANNOUNCEMENTS)))
          .addMethod(
            getInsertGroupMemberUnusedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_INSERT_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getInsertGroupMemberUsedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_INSERT_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getInsertGroupUnusedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_INSERT_GROUP_UNUSED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getInsertGroupUsedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_INSERT_GROUP_USED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getInsertGuestGroupMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupResponse>(
                  this, METHODID_INSERT_GUEST_GROUP)))
          .addMethod(
            getInsertGuestGroupAdministratorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupAdministratorResponse>(
                  this, METHODID_INSERT_GUEST_GROUP_ADMINISTRATOR)))
          .addMethod(
            getInsertGuestGroupGuestUserMemberRelationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse>(
                  this, METHODID_INSERT_GUEST_GROUP_GUEST_USER_MEMBER_RELATION)))
          .addMethod(
            getInsertGuestGroupMemberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupMemberResponse>(
                  this, METHODID_INSERT_GUEST_GROUP_MEMBER)))
          .addMethod(
            getInsertGuestGroupRegisteredUserMemberRelationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse>(
                  this, METHODID_INSERT_GUEST_GROUP_REGISTERED_USER_MEMBER_RELATION)))
          .addMethod(
            getInsertGuestUserFriendMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestUserFriendResponse>(
                  this, METHODID_INSERT_GUEST_USER_FRIEND)))
          .addMethod(
            getInsertOfflineMessagePriorityMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.OfflineMessagePriorityResponse>(
                  this, METHODID_INSERT_OFFLINE_MESSAGE_PRIORITY)))
          .addMethod(
            getInsertRegisteredGroupMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupResponse>(
                  this, METHODID_INSERT_REGISTERED_GROUP)))
          .addMethod(
            getInsertRegisteredGroupAdministratorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse>(
                  this, METHODID_INSERT_REGISTERED_GROUP_ADMINISTRATOR)))
          .addMethod(
            getInsertRegisteredGroupGuestUserMemberRelationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse>(
                  this, METHODID_INSERT_REGISTERED_GROUP_GUEST_USER_MEMBER_RELATION)))
          .addMethod(
            getInsertRegisteredGroupMemberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupMemberResponse>(
                  this, METHODID_INSERT_REGISTERED_GROUP_MEMBER)))
          .addMethod(
            getInsertRegisteredGroupRegisteredUserMemberRelationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse>(
                  this, METHODID_INSERT_REGISTERED_GROUP_REGISTERED_USER_MEMBER_RELATION)))
          .addMethod(
            getInsertRegisteredUserFriendMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredUserFriendResponse>(
                  this, METHODID_INSERT_REGISTERED_USER_FRIEND)))
          .addMethod(
            getInsertGroupUnusedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_INSERT_GROUP_UNUSED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getInsertGroupUsedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_INSERT_GROUP_USED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getInsertGroupMemberUnusedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_INSERT_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getInsertGroupMemberUsedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_INSERT_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getInsertFriendUnusedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_INSERT_FRIEND_UNUSED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getInsertFriendUsedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_INSERT_FRIEND_USED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getInsertGroupRemarkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GroupRemarkResponse>(
                  this, METHODID_INSERT_GROUP_REMARK)))
          .addMethod(
            getUpdateFriendUnusedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_UPDATE_FRIEND_UNUSED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getUpdateFriendUsedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_UPDATE_FRIEND_USED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getUpdateGroupAnnouncementsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GroupAnnouncementsResponse>(
                  this, METHODID_UPDATE_GROUP_ANNOUNCEMENTS)))
          .addMethod(
            getUpdateGroupMemberUnusedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_UPDATE_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getUpdateGroupMemberUsedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_UPDATE_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getUpdateGroupUnusedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_UPDATE_GROUP_UNUSED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getUpdateGroupUsedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_UPDATE_GROUP_USED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getUpdateGuestGroupMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupResponse>(
                  this, METHODID_UPDATE_GUEST_GROUP)))
          .addMethod(
            getUpdateGuestGroupAdministratorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupAdministratorResponse>(
                  this, METHODID_UPDATE_GUEST_GROUP_ADMINISTRATOR)))
          .addMethod(
            getUpdateGuestGroupGuestUserMemberRelationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse>(
                  this, METHODID_UPDATE_GUEST_GROUP_GUEST_USER_MEMBER_RELATION)))
          .addMethod(
            getUpdateGuestGroupMemberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupMemberResponse>(
                  this, METHODID_UPDATE_GUEST_GROUP_MEMBER)))
          .addMethod(
            getUpdateGuestGroupRegisteredUserMemberRelationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse>(
                  this, METHODID_UPDATE_GUEST_GROUP_REGISTERED_USER_MEMBER_RELATION)))
          .addMethod(
            getUpdateGuestUserFriendMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestUserFriendResponse>(
                  this, METHODID_UPDATE_GUEST_USER_FRIEND)))
          .addMethod(
            getUpdateOfflineMessagePriorityMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.OfflineMessagePriorityResponse>(
                  this, METHODID_UPDATE_OFFLINE_MESSAGE_PRIORITY)))
          .addMethod(
            getUpdateRegisteredGroupMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupResponse>(
                  this, METHODID_UPDATE_REGISTERED_GROUP)))
          .addMethod(
            getUpdateRegisteredGroupAdministratorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse>(
                  this, METHODID_UPDATE_REGISTERED_GROUP_ADMINISTRATOR)))
          .addMethod(
            getUpdateRegisteredGroupGuestUserMemberRelationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse>(
                  this, METHODID_UPDATE_REGISTERED_GROUP_GUEST_USER_MEMBER_RELATION)))
          .addMethod(
            getUpdateRegisteredGroupMemberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupMemberResponse>(
                  this, METHODID_UPDATE_REGISTERED_GROUP_MEMBER)))
          .addMethod(
            getUpdateRegisteredGroupRegisteredUserMemberRelationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse>(
                  this, METHODID_UPDATE_REGISTERED_GROUP_REGISTERED_USER_MEMBER_RELATION)))
          .addMethod(
            getUpdateRegisteredUserFriendMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredUserFriendResponse>(
                  this, METHODID_UPDATE_REGISTERED_USER_FRIEND)))
          .addMethod(
            getUpdateGroupUnusedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_UPDATE_GROUP_UNUSED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getUpdateGroupUsedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_UPDATE_GROUP_USED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getUpdateGroupMemberUnusedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_UPDATE_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getUpdateGroupMemberUsedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_UPDATE_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getUpdateFriendUnusedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_UPDATE_FRIEND_UNUSED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getUpdateFriendUsedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_UPDATE_FRIEND_USED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getUpdateGroupRemarkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GroupRemarkResponse>(
                  this, METHODID_UPDATE_GROUP_REMARK)))
          .addMethod(
            getDeleteFriendUnusedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_DELETE_FRIEND_UNUSED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getDeleteFriendUsedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_DELETE_FRIEND_USED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getDeleteGroupAnnouncementsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GroupAnnouncementsResponse>(
                  this, METHODID_DELETE_GROUP_ANNOUNCEMENTS)))
          .addMethod(
            getDeleteGroupMemberUnusedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_DELETE_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getDeleteGroupMemberUsedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_DELETE_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getDeleteGroupUnusedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_DELETE_GROUP_UNUSED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getDeleteGroupUsedBeautifulNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_DELETE_GROUP_USED_BEAUTIFUL_NUMBER)))
          .addMethod(
            getDeleteGuestGroupMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupResponse>(
                  this, METHODID_DELETE_GUEST_GROUP)))
          .addMethod(
            getDeleteGuestGroupAdministratorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupAdministratorResponse>(
                  this, METHODID_DELETE_GUEST_GROUP_ADMINISTRATOR)))
          .addMethod(
            getDeleteGuestGroupGuestUserMemberRelationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse>(
                  this, METHODID_DELETE_GUEST_GROUP_GUEST_USER_MEMBER_RELATION)))
          .addMethod(
            getDeleteGuestGroupMemberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupMemberResponse>(
                  this, METHODID_DELETE_GUEST_GROUP_MEMBER)))
          .addMethod(
            getDeleteGuestGroupRegisteredUserMemberRelationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse>(
                  this, METHODID_DELETE_GUEST_GROUP_REGISTERED_USER_MEMBER_RELATION)))
          .addMethod(
            getDeleteGuestUserFriendMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GuestUserFriendResponse>(
                  this, METHODID_DELETE_GUEST_USER_FRIEND)))
          .addMethod(
            getDeleteOfflineMessagePriorityMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.OfflineMessagePriorityResponse>(
                  this, METHODID_DELETE_OFFLINE_MESSAGE_PRIORITY)))
          .addMethod(
            getDeleteRegisteredGroupMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupResponse>(
                  this, METHODID_DELETE_REGISTERED_GROUP)))
          .addMethod(
            getDeleteRegisteredGroupAdministratorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse>(
                  this, METHODID_DELETE_REGISTERED_GROUP_ADMINISTRATOR)))
          .addMethod(
            getDeleteRegisteredGroupGuestUserMemberRelationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse>(
                  this, METHODID_DELETE_REGISTERED_GROUP_GUEST_USER_MEMBER_RELATION)))
          .addMethod(
            getDeleteRegisteredGroupMemberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupMemberResponse>(
                  this, METHODID_DELETE_REGISTERED_GROUP_MEMBER)))
          .addMethod(
            getDeleteRegisteredGroupRegisteredUserMemberRelationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse>(
                  this, METHODID_DELETE_REGISTERED_GROUP_REGISTERED_USER_MEMBER_RELATION)))
          .addMethod(
            getDeleteRegisteredUserFriendMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.RegisteredUserFriendResponse>(
                  this, METHODID_DELETE_REGISTERED_USER_FRIEND)))
          .addMethod(
            getDeleteGroupUnusedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_DELETE_GROUP_UNUSED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getDeleteGroupUsedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_DELETE_GROUP_USED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getDeleteGroupMemberUnusedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_DELETE_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getDeleteGroupMemberUsedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_DELETE_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getDeleteFriendUnusedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_DELETE_FRIEND_UNUSED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getDeleteFriendUsedBeautifulNumberRealMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.BeautifulNumberCommonResponse>(
                  this, METHODID_DELETE_FRIEND_USED_BEAUTIFUL_NUMBER_REAL)))
          .addMethod(
            getDeleteGroupRemarkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lanjiu.im.grpc.TransmissionRequest,
                com.lanjiu.im.grpc.GroupRemarkResponse>(
                  this, METHODID_DELETE_GROUP_REMARK)))
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
    public void selectBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectBeautifulNumberAuto(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectBeautifulNumberAutoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectBurnAfterReadingPriority(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BurnAfterReadingPriorityResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectBurnAfterReadingPriorityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectFriendUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectFriendUnusedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectFriendUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectFriendUsedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectGroupAnnouncements(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupAnnouncementsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGroupAnnouncementsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectGroupMemberUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGroupMemberUnusedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectGroupMemberUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGroupMemberUsedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectGroupUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGroupUnusedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectGroupUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGroupUsedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectGuestGroup(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGuestGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectGuestGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupAdministratorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGuestGroupAdministratorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectGuestGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGuestGroupGuestUserMemberRelationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectGuestGroupMember(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupMemberResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGuestGroupMemberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectGuestGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGuestGroupRegisteredUserMemberRelationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectGuestUserFriend(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestUserFriendResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGuestUserFriendMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectOfflineMessagePriority(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.OfflineMessagePriorityResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectOfflineMessagePriorityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectRegisteredGroup(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectRegisteredGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectRegisteredGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectRegisteredGroupAdministratorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectRegisteredGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectRegisteredGroupGuestUserMemberRelationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectRegisteredGroupMember(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupMemberResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectRegisteredGroupMemberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectRegisteredGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectRegisteredGroupRegisteredUserMemberRelationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectRegisteredUserFriend(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredUserFriendResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectRegisteredUserFriendMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectGroupUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGroupUnusedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectGroupUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGroupUsedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectGroupMemberUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGroupMemberUnusedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectGroupMemberUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGroupMemberUsedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectFriendUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectFriendUnusedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectFriendUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectFriendUsedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void selectGroupRemark(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupRemarkResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSelectGroupRemarkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertFriendUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertFriendUnusedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertFriendUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertFriendUsedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertGroupAnnouncements(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupAnnouncementsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertGroupAnnouncementsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertGroupMemberUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertGroupMemberUnusedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertGroupMemberUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertGroupMemberUsedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertGroupUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertGroupUnusedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertGroupUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertGroupUsedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertGuestGroup(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertGuestGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertGuestGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupAdministratorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertGuestGroupAdministratorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertGuestGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertGuestGroupGuestUserMemberRelationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertGuestGroupMember(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupMemberResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertGuestGroupMemberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertGuestGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertGuestGroupRegisteredUserMemberRelationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertGuestUserFriend(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestUserFriendResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertGuestUserFriendMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertOfflineMessagePriority(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.OfflineMessagePriorityResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertOfflineMessagePriorityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertRegisteredGroup(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertRegisteredGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertRegisteredGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertRegisteredGroupAdministratorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertRegisteredGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertRegisteredGroupGuestUserMemberRelationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertRegisteredGroupMember(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupMemberResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertRegisteredGroupMemberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertRegisteredGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertRegisteredGroupRegisteredUserMemberRelationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertRegisteredUserFriend(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredUserFriendResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertRegisteredUserFriendMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertGroupUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertGroupUnusedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertGroupUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertGroupUsedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertGroupMemberUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertGroupMemberUnusedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertGroupMemberUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertGroupMemberUsedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertFriendUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertFriendUnusedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertFriendUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertFriendUsedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertGroupRemark(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupRemarkResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertGroupRemarkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateFriendUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateFriendUnusedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateFriendUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateFriendUsedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateGroupAnnouncements(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupAnnouncementsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGroupAnnouncementsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateGroupMemberUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGroupMemberUnusedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateGroupMemberUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGroupMemberUsedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateGroupUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGroupUnusedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateGroupUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGroupUsedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateGuestGroup(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGuestGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateGuestGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupAdministratorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGuestGroupAdministratorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateGuestGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGuestGroupGuestUserMemberRelationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateGuestGroupMember(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupMemberResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGuestGroupMemberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateGuestGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGuestGroupRegisteredUserMemberRelationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateGuestUserFriend(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestUserFriendResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGuestUserFriendMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateOfflineMessagePriority(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.OfflineMessagePriorityResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateOfflineMessagePriorityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateRegisteredGroup(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateRegisteredGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateRegisteredGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateRegisteredGroupAdministratorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateRegisteredGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateRegisteredGroupGuestUserMemberRelationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateRegisteredGroupMember(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupMemberResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateRegisteredGroupMemberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateRegisteredGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateRegisteredGroupRegisteredUserMemberRelationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateRegisteredUserFriend(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredUserFriendResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateRegisteredUserFriendMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateGroupUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGroupUnusedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateGroupUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGroupUsedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateGroupMemberUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGroupMemberUnusedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateGroupMemberUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGroupMemberUsedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateFriendUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateFriendUnusedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateFriendUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateFriendUsedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateGroupRemark(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupRemarkResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGroupRemarkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteFriendUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteFriendUnusedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteFriendUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteFriendUsedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGroupAnnouncements(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupAnnouncementsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGroupAnnouncementsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGroupMemberUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGroupMemberUnusedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGroupMemberUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGroupMemberUsedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGroupUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGroupUnusedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGroupUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGroupUsedBeautifulNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGuestGroup(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGuestGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGuestGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupAdministratorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGuestGroupAdministratorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGuestGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGuestGroupGuestUserMemberRelationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGuestGroupMember(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupMemberResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGuestGroupMemberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGuestGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGuestGroupRegisteredUserMemberRelationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGuestUserFriend(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestUserFriendResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGuestUserFriendMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteOfflineMessagePriority(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.OfflineMessagePriorityResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteOfflineMessagePriorityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteRegisteredGroup(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteRegisteredGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteRegisteredGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteRegisteredGroupAdministratorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteRegisteredGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteRegisteredGroupGuestUserMemberRelationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteRegisteredGroupMember(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupMemberResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteRegisteredGroupMemberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteRegisteredGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteRegisteredGroupRegisteredUserMemberRelationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteRegisteredUserFriend(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredUserFriendResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteRegisteredUserFriendMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGroupUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGroupUnusedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGroupUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGroupUsedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGroupMemberUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGroupMemberUnusedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGroupMemberUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGroupMemberUsedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteFriendUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteFriendUnusedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteFriendUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteFriendUsedBeautifulNumberRealMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteGroupRemark(com.lanjiu.im.grpc.TransmissionRequest request,
        io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupRemarkResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGroupRemarkMethod(), getCallOptions()), request, responseObserver);
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
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse selectBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse selectBeautifulNumberAuto(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectBeautifulNumberAutoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BurnAfterReadingPriorityResponse selectBurnAfterReadingPriority(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectBurnAfterReadingPriorityMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse selectFriendUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectFriendUnusedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse selectFriendUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectFriendUsedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GroupAnnouncementsResponse selectGroupAnnouncements(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectGroupAnnouncementsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse selectGroupMemberUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectGroupMemberUnusedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse selectGroupMemberUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectGroupMemberUsedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse selectGroupUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectGroupUnusedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse selectGroupUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectGroupUsedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupResponse selectGuestGroup(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectGuestGroupMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupAdministratorResponse selectGuestGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectGuestGroupAdministratorMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse selectGuestGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectGuestGroupGuestUserMemberRelationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupMemberResponse selectGuestGroupMember(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectGuestGroupMemberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse selectGuestGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectGuestGroupRegisteredUserMemberRelationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestUserFriendResponse selectGuestUserFriend(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectGuestUserFriendMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.OfflineMessagePriorityResponse selectOfflineMessagePriority(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectOfflineMessagePriorityMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupResponse selectRegisteredGroup(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectRegisteredGroupMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse selectRegisteredGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectRegisteredGroupAdministratorMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse selectRegisteredGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectRegisteredGroupGuestUserMemberRelationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupMemberResponse selectRegisteredGroupMember(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectRegisteredGroupMemberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse selectRegisteredGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectRegisteredGroupRegisteredUserMemberRelationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredUserFriendResponse selectRegisteredUserFriend(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectRegisteredUserFriendMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse selectGroupUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectGroupUnusedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse selectGroupUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectGroupUsedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse selectGroupMemberUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectGroupMemberUnusedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse selectGroupMemberUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectGroupMemberUsedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse selectFriendUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectFriendUnusedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse selectFriendUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectFriendUsedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GroupRemarkResponse selectGroupRemark(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSelectGroupRemarkMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse insertFriendUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertFriendUnusedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse insertFriendUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertFriendUsedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GroupAnnouncementsResponse insertGroupAnnouncements(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertGroupAnnouncementsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse insertGroupMemberUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertGroupMemberUnusedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse insertGroupMemberUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertGroupMemberUsedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse insertGroupUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertGroupUnusedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse insertGroupUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertGroupUsedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupResponse insertGuestGroup(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertGuestGroupMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupAdministratorResponse insertGuestGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertGuestGroupAdministratorMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse insertGuestGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertGuestGroupGuestUserMemberRelationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupMemberResponse insertGuestGroupMember(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertGuestGroupMemberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse insertGuestGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertGuestGroupRegisteredUserMemberRelationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestUserFriendResponse insertGuestUserFriend(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertGuestUserFriendMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.OfflineMessagePriorityResponse insertOfflineMessagePriority(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertOfflineMessagePriorityMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupResponse insertRegisteredGroup(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertRegisteredGroupMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse insertRegisteredGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertRegisteredGroupAdministratorMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse insertRegisteredGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertRegisteredGroupGuestUserMemberRelationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupMemberResponse insertRegisteredGroupMember(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertRegisteredGroupMemberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse insertRegisteredGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertRegisteredGroupRegisteredUserMemberRelationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredUserFriendResponse insertRegisteredUserFriend(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertRegisteredUserFriendMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse insertGroupUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertGroupUnusedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse insertGroupUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertGroupUsedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse insertGroupMemberUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertGroupMemberUnusedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse insertGroupMemberUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertGroupMemberUsedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse insertFriendUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertFriendUnusedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse insertFriendUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertFriendUsedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GroupRemarkResponse insertGroupRemark(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertGroupRemarkMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse updateFriendUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateFriendUnusedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse updateFriendUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateFriendUsedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GroupAnnouncementsResponse updateGroupAnnouncements(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGroupAnnouncementsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse updateGroupMemberUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGroupMemberUnusedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse updateGroupMemberUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGroupMemberUsedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse updateGroupUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGroupUnusedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse updateGroupUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGroupUsedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupResponse updateGuestGroup(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGuestGroupMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupAdministratorResponse updateGuestGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGuestGroupAdministratorMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse updateGuestGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGuestGroupGuestUserMemberRelationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupMemberResponse updateGuestGroupMember(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGuestGroupMemberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse updateGuestGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGuestGroupRegisteredUserMemberRelationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestUserFriendResponse updateGuestUserFriend(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGuestUserFriendMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.OfflineMessagePriorityResponse updateOfflineMessagePriority(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateOfflineMessagePriorityMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupResponse updateRegisteredGroup(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateRegisteredGroupMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse updateRegisteredGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateRegisteredGroupAdministratorMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse updateRegisteredGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateRegisteredGroupGuestUserMemberRelationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupMemberResponse updateRegisteredGroupMember(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateRegisteredGroupMemberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse updateRegisteredGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateRegisteredGroupRegisteredUserMemberRelationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredUserFriendResponse updateRegisteredUserFriend(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateRegisteredUserFriendMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse updateGroupUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGroupUnusedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse updateGroupUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGroupUsedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse updateGroupMemberUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGroupMemberUnusedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse updateGroupMemberUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGroupMemberUsedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse updateFriendUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateFriendUnusedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse updateFriendUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateFriendUsedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GroupRemarkResponse updateGroupRemark(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGroupRemarkMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse deleteFriendUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteFriendUnusedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse deleteFriendUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteFriendUsedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GroupAnnouncementsResponse deleteGroupAnnouncements(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGroupAnnouncementsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse deleteGroupMemberUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGroupMemberUnusedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse deleteGroupMemberUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGroupMemberUsedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse deleteGroupUnusedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGroupUnusedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse deleteGroupUsedBeautifulNumber(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGroupUsedBeautifulNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupResponse deleteGuestGroup(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGuestGroupMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupAdministratorResponse deleteGuestGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGuestGroupAdministratorMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse deleteGuestGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGuestGroupGuestUserMemberRelationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupMemberResponse deleteGuestGroupMember(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGuestGroupMemberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse deleteGuestGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGuestGroupRegisteredUserMemberRelationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GuestUserFriendResponse deleteGuestUserFriend(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGuestUserFriendMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.OfflineMessagePriorityResponse deleteOfflineMessagePriority(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteOfflineMessagePriorityMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupResponse deleteRegisteredGroup(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteRegisteredGroupMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse deleteRegisteredGroupAdministrator(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteRegisteredGroupAdministratorMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse deleteRegisteredGroupGuestUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteRegisteredGroupGuestUserMemberRelationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupMemberResponse deleteRegisteredGroupMember(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteRegisteredGroupMemberMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse deleteRegisteredGroupRegisteredUserMemberRelation(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteRegisteredGroupRegisteredUserMemberRelationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.RegisteredUserFriendResponse deleteRegisteredUserFriend(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteRegisteredUserFriendMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse deleteGroupUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGroupUnusedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse deleteGroupUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGroupUsedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse deleteGroupMemberUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGroupMemberUnusedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse deleteGroupMemberUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGroupMemberUsedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse deleteFriendUnusedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteFriendUnusedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.BeautifulNumberCommonResponse deleteFriendUsedBeautifulNumberReal(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteFriendUsedBeautifulNumberRealMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.lanjiu.im.grpc.GroupRemarkResponse deleteGroupRemark(com.lanjiu.im.grpc.TransmissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGroupRemarkMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> selectBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> selectBeautifulNumberAuto(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectBeautifulNumberAutoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BurnAfterReadingPriorityResponse> selectBurnAfterReadingPriority(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectBurnAfterReadingPriorityMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> selectFriendUnusedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectFriendUnusedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> selectFriendUsedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectFriendUsedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GroupAnnouncementsResponse> selectGroupAnnouncements(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGroupAnnouncementsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> selectGroupMemberUnusedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGroupMemberUnusedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> selectGroupMemberUsedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGroupMemberUsedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> selectGroupUnusedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGroupUnusedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> selectGroupUsedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGroupUsedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupResponse> selectGuestGroup(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGuestGroupMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupAdministratorResponse> selectGuestGroupAdministrator(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGuestGroupAdministratorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> selectGuestGroupGuestUserMemberRelation(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGuestGroupGuestUserMemberRelationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupMemberResponse> selectGuestGroupMember(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGuestGroupMemberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> selectGuestGroupRegisteredUserMemberRelation(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGuestGroupRegisteredUserMemberRelationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestUserFriendResponse> selectGuestUserFriend(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGuestUserFriendMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.OfflineMessagePriorityResponse> selectOfflineMessagePriority(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectOfflineMessagePriorityMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupResponse> selectRegisteredGroup(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectRegisteredGroupMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> selectRegisteredGroupAdministrator(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectRegisteredGroupAdministratorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> selectRegisteredGroupGuestUserMemberRelation(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectRegisteredGroupGuestUserMemberRelationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupMemberResponse> selectRegisteredGroupMember(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectRegisteredGroupMemberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> selectRegisteredGroupRegisteredUserMemberRelation(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectRegisteredGroupRegisteredUserMemberRelationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredUserFriendResponse> selectRegisteredUserFriend(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectRegisteredUserFriendMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> selectGroupUnusedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGroupUnusedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> selectGroupUsedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGroupUsedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> selectGroupMemberUnusedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGroupMemberUnusedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> selectGroupMemberUsedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGroupMemberUsedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> selectFriendUnusedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectFriendUnusedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> selectFriendUsedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectFriendUsedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GroupRemarkResponse> selectGroupRemark(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSelectGroupRemarkMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> insertFriendUnusedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertFriendUnusedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> insertFriendUsedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertFriendUsedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GroupAnnouncementsResponse> insertGroupAnnouncements(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertGroupAnnouncementsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> insertGroupMemberUnusedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertGroupMemberUnusedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> insertGroupMemberUsedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertGroupMemberUsedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> insertGroupUnusedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertGroupUnusedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> insertGroupUsedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertGroupUsedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupResponse> insertGuestGroup(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertGuestGroupMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupAdministratorResponse> insertGuestGroupAdministrator(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertGuestGroupAdministratorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> insertGuestGroupGuestUserMemberRelation(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertGuestGroupGuestUserMemberRelationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupMemberResponse> insertGuestGroupMember(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertGuestGroupMemberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> insertGuestGroupRegisteredUserMemberRelation(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertGuestGroupRegisteredUserMemberRelationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestUserFriendResponse> insertGuestUserFriend(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertGuestUserFriendMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.OfflineMessagePriorityResponse> insertOfflineMessagePriority(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertOfflineMessagePriorityMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupResponse> insertRegisteredGroup(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertRegisteredGroupMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> insertRegisteredGroupAdministrator(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertRegisteredGroupAdministratorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> insertRegisteredGroupGuestUserMemberRelation(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertRegisteredGroupGuestUserMemberRelationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupMemberResponse> insertRegisteredGroupMember(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertRegisteredGroupMemberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> insertRegisteredGroupRegisteredUserMemberRelation(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertRegisteredGroupRegisteredUserMemberRelationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredUserFriendResponse> insertRegisteredUserFriend(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertRegisteredUserFriendMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> insertGroupUnusedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertGroupUnusedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> insertGroupUsedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertGroupUsedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> insertGroupMemberUnusedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertGroupMemberUnusedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> insertGroupMemberUsedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertGroupMemberUsedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> insertFriendUnusedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertFriendUnusedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> insertFriendUsedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertFriendUsedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GroupRemarkResponse> insertGroupRemark(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertGroupRemarkMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> updateFriendUnusedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateFriendUnusedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> updateFriendUsedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateFriendUsedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GroupAnnouncementsResponse> updateGroupAnnouncements(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGroupAnnouncementsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> updateGroupMemberUnusedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGroupMemberUnusedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> updateGroupMemberUsedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGroupMemberUsedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> updateGroupUnusedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGroupUnusedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> updateGroupUsedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGroupUsedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupResponse> updateGuestGroup(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGuestGroupMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupAdministratorResponse> updateGuestGroupAdministrator(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGuestGroupAdministratorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> updateGuestGroupGuestUserMemberRelation(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGuestGroupGuestUserMemberRelationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupMemberResponse> updateGuestGroupMember(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGuestGroupMemberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> updateGuestGroupRegisteredUserMemberRelation(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGuestGroupRegisteredUserMemberRelationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestUserFriendResponse> updateGuestUserFriend(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGuestUserFriendMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.OfflineMessagePriorityResponse> updateOfflineMessagePriority(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateOfflineMessagePriorityMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupResponse> updateRegisteredGroup(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateRegisteredGroupMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> updateRegisteredGroupAdministrator(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateRegisteredGroupAdministratorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> updateRegisteredGroupGuestUserMemberRelation(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateRegisteredGroupGuestUserMemberRelationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupMemberResponse> updateRegisteredGroupMember(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateRegisteredGroupMemberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> updateRegisteredGroupRegisteredUserMemberRelation(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateRegisteredGroupRegisteredUserMemberRelationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredUserFriendResponse> updateRegisteredUserFriend(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateRegisteredUserFriendMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> updateGroupUnusedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGroupUnusedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> updateGroupUsedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGroupUsedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> updateGroupMemberUnusedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGroupMemberUnusedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> updateGroupMemberUsedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGroupMemberUsedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> updateFriendUnusedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateFriendUnusedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> updateFriendUsedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateFriendUsedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GroupRemarkResponse> updateGroupRemark(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGroupRemarkMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> deleteFriendUnusedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteFriendUnusedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> deleteFriendUsedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteFriendUsedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GroupAnnouncementsResponse> deleteGroupAnnouncements(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGroupAnnouncementsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> deleteGroupMemberUnusedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGroupMemberUnusedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> deleteGroupMemberUsedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGroupMemberUsedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> deleteGroupUnusedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGroupUnusedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> deleteGroupUsedBeautifulNumber(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGroupUsedBeautifulNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupResponse> deleteGuestGroup(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGuestGroupMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupAdministratorResponse> deleteGuestGroupAdministrator(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGuestGroupAdministratorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse> deleteGuestGroupGuestUserMemberRelation(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGuestGroupGuestUserMemberRelationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupMemberResponse> deleteGuestGroupMember(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGuestGroupMemberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse> deleteGuestGroupRegisteredUserMemberRelation(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGuestGroupRegisteredUserMemberRelationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GuestUserFriendResponse> deleteGuestUserFriend(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGuestUserFriendMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.OfflineMessagePriorityResponse> deleteOfflineMessagePriority(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteOfflineMessagePriorityMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupResponse> deleteRegisteredGroup(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteRegisteredGroupMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse> deleteRegisteredGroupAdministrator(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteRegisteredGroupAdministratorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse> deleteRegisteredGroupGuestUserMemberRelation(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteRegisteredGroupGuestUserMemberRelationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupMemberResponse> deleteRegisteredGroupMember(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteRegisteredGroupMemberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse> deleteRegisteredGroupRegisteredUserMemberRelation(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteRegisteredGroupRegisteredUserMemberRelationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.RegisteredUserFriendResponse> deleteRegisteredUserFriend(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteRegisteredUserFriendMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> deleteGroupUnusedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGroupUnusedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> deleteGroupUsedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGroupUsedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> deleteGroupMemberUnusedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGroupMemberUnusedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> deleteGroupMemberUsedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGroupMemberUsedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> deleteFriendUnusedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteFriendUnusedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.BeautifulNumberCommonResponse> deleteFriendUsedBeautifulNumberReal(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteFriendUsedBeautifulNumberRealMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lanjiu.im.grpc.GroupRemarkResponse> deleteGroupRemark(
        com.lanjiu.im.grpc.TransmissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGroupRemarkMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SELECT_BEAUTIFUL_NUMBER_REAL = 0;
  private static final int METHODID_SELECT_BEAUTIFUL_NUMBER_AUTO = 1;
  private static final int METHODID_SELECT_BURN_AFTER_READING_PRIORITY = 2;
  private static final int METHODID_SELECT_FRIEND_UNUSED_BEAUTIFUL_NUMBER = 3;
  private static final int METHODID_SELECT_FRIEND_USED_BEAUTIFUL_NUMBER = 4;
  private static final int METHODID_SELECT_GROUP_ANNOUNCEMENTS = 5;
  private static final int METHODID_SELECT_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER = 6;
  private static final int METHODID_SELECT_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER = 7;
  private static final int METHODID_SELECT_GROUP_UNUSED_BEAUTIFUL_NUMBER = 8;
  private static final int METHODID_SELECT_GROUP_USED_BEAUTIFUL_NUMBER = 9;
  private static final int METHODID_SELECT_GUEST_GROUP = 10;
  private static final int METHODID_SELECT_GUEST_GROUP_ADMINISTRATOR = 11;
  private static final int METHODID_SELECT_GUEST_GROUP_GUEST_USER_MEMBER_RELATION = 12;
  private static final int METHODID_SELECT_GUEST_GROUP_MEMBER = 13;
  private static final int METHODID_SELECT_GUEST_GROUP_REGISTERED_USER_MEMBER_RELATION = 14;
  private static final int METHODID_SELECT_GUEST_USER_FRIEND = 15;
  private static final int METHODID_SELECT_OFFLINE_MESSAGE_PRIORITY = 16;
  private static final int METHODID_SELECT_REGISTERED_GROUP = 17;
  private static final int METHODID_SELECT_REGISTERED_GROUP_ADMINISTRATOR = 18;
  private static final int METHODID_SELECT_REGISTERED_GROUP_GUEST_USER_MEMBER_RELATION = 19;
  private static final int METHODID_SELECT_REGISTERED_GROUP_MEMBER = 20;
  private static final int METHODID_SELECT_REGISTERED_GROUP_REGISTERED_USER_MEMBER_RELATION = 21;
  private static final int METHODID_SELECT_REGISTERED_USER_FRIEND = 22;
  private static final int METHODID_SELECT_GROUP_UNUSED_BEAUTIFUL_NUMBER_REAL = 23;
  private static final int METHODID_SELECT_GROUP_USED_BEAUTIFUL_NUMBER_REAL = 24;
  private static final int METHODID_SELECT_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER_REAL = 25;
  private static final int METHODID_SELECT_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER_REAL = 26;
  private static final int METHODID_SELECT_FRIEND_UNUSED_BEAUTIFUL_NUMBER_REAL = 27;
  private static final int METHODID_SELECT_FRIEND_USED_BEAUTIFUL_NUMBER_REAL = 28;
  private static final int METHODID_SELECT_GROUP_REMARK = 29;
  private static final int METHODID_INSERT_FRIEND_UNUSED_BEAUTIFUL_NUMBER = 30;
  private static final int METHODID_INSERT_FRIEND_USED_BEAUTIFUL_NUMBER = 31;
  private static final int METHODID_INSERT_GROUP_ANNOUNCEMENTS = 32;
  private static final int METHODID_INSERT_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER = 33;
  private static final int METHODID_INSERT_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER = 34;
  private static final int METHODID_INSERT_GROUP_UNUSED_BEAUTIFUL_NUMBER = 35;
  private static final int METHODID_INSERT_GROUP_USED_BEAUTIFUL_NUMBER = 36;
  private static final int METHODID_INSERT_GUEST_GROUP = 37;
  private static final int METHODID_INSERT_GUEST_GROUP_ADMINISTRATOR = 38;
  private static final int METHODID_INSERT_GUEST_GROUP_GUEST_USER_MEMBER_RELATION = 39;
  private static final int METHODID_INSERT_GUEST_GROUP_MEMBER = 40;
  private static final int METHODID_INSERT_GUEST_GROUP_REGISTERED_USER_MEMBER_RELATION = 41;
  private static final int METHODID_INSERT_GUEST_USER_FRIEND = 42;
  private static final int METHODID_INSERT_OFFLINE_MESSAGE_PRIORITY = 43;
  private static final int METHODID_INSERT_REGISTERED_GROUP = 44;
  private static final int METHODID_INSERT_REGISTERED_GROUP_ADMINISTRATOR = 45;
  private static final int METHODID_INSERT_REGISTERED_GROUP_GUEST_USER_MEMBER_RELATION = 46;
  private static final int METHODID_INSERT_REGISTERED_GROUP_MEMBER = 47;
  private static final int METHODID_INSERT_REGISTERED_GROUP_REGISTERED_USER_MEMBER_RELATION = 48;
  private static final int METHODID_INSERT_REGISTERED_USER_FRIEND = 49;
  private static final int METHODID_INSERT_GROUP_UNUSED_BEAUTIFUL_NUMBER_REAL = 50;
  private static final int METHODID_INSERT_GROUP_USED_BEAUTIFUL_NUMBER_REAL = 51;
  private static final int METHODID_INSERT_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER_REAL = 52;
  private static final int METHODID_INSERT_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER_REAL = 53;
  private static final int METHODID_INSERT_FRIEND_UNUSED_BEAUTIFUL_NUMBER_REAL = 54;
  private static final int METHODID_INSERT_FRIEND_USED_BEAUTIFUL_NUMBER_REAL = 55;
  private static final int METHODID_INSERT_GROUP_REMARK = 56;
  private static final int METHODID_UPDATE_FRIEND_UNUSED_BEAUTIFUL_NUMBER = 57;
  private static final int METHODID_UPDATE_FRIEND_USED_BEAUTIFUL_NUMBER = 58;
  private static final int METHODID_UPDATE_GROUP_ANNOUNCEMENTS = 59;
  private static final int METHODID_UPDATE_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER = 60;
  private static final int METHODID_UPDATE_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER = 61;
  private static final int METHODID_UPDATE_GROUP_UNUSED_BEAUTIFUL_NUMBER = 62;
  private static final int METHODID_UPDATE_GROUP_USED_BEAUTIFUL_NUMBER = 63;
  private static final int METHODID_UPDATE_GUEST_GROUP = 64;
  private static final int METHODID_UPDATE_GUEST_GROUP_ADMINISTRATOR = 65;
  private static final int METHODID_UPDATE_GUEST_GROUP_GUEST_USER_MEMBER_RELATION = 66;
  private static final int METHODID_UPDATE_GUEST_GROUP_MEMBER = 67;
  private static final int METHODID_UPDATE_GUEST_GROUP_REGISTERED_USER_MEMBER_RELATION = 68;
  private static final int METHODID_UPDATE_GUEST_USER_FRIEND = 69;
  private static final int METHODID_UPDATE_OFFLINE_MESSAGE_PRIORITY = 70;
  private static final int METHODID_UPDATE_REGISTERED_GROUP = 71;
  private static final int METHODID_UPDATE_REGISTERED_GROUP_ADMINISTRATOR = 72;
  private static final int METHODID_UPDATE_REGISTERED_GROUP_GUEST_USER_MEMBER_RELATION = 73;
  private static final int METHODID_UPDATE_REGISTERED_GROUP_MEMBER = 74;
  private static final int METHODID_UPDATE_REGISTERED_GROUP_REGISTERED_USER_MEMBER_RELATION = 75;
  private static final int METHODID_UPDATE_REGISTERED_USER_FRIEND = 76;
  private static final int METHODID_UPDATE_GROUP_UNUSED_BEAUTIFUL_NUMBER_REAL = 77;
  private static final int METHODID_UPDATE_GROUP_USED_BEAUTIFUL_NUMBER_REAL = 78;
  private static final int METHODID_UPDATE_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER_REAL = 79;
  private static final int METHODID_UPDATE_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER_REAL = 80;
  private static final int METHODID_UPDATE_FRIEND_UNUSED_BEAUTIFUL_NUMBER_REAL = 81;
  private static final int METHODID_UPDATE_FRIEND_USED_BEAUTIFUL_NUMBER_REAL = 82;
  private static final int METHODID_UPDATE_GROUP_REMARK = 83;
  private static final int METHODID_DELETE_FRIEND_UNUSED_BEAUTIFUL_NUMBER = 84;
  private static final int METHODID_DELETE_FRIEND_USED_BEAUTIFUL_NUMBER = 85;
  private static final int METHODID_DELETE_GROUP_ANNOUNCEMENTS = 86;
  private static final int METHODID_DELETE_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER = 87;
  private static final int METHODID_DELETE_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER = 88;
  private static final int METHODID_DELETE_GROUP_UNUSED_BEAUTIFUL_NUMBER = 89;
  private static final int METHODID_DELETE_GROUP_USED_BEAUTIFUL_NUMBER = 90;
  private static final int METHODID_DELETE_GUEST_GROUP = 91;
  private static final int METHODID_DELETE_GUEST_GROUP_ADMINISTRATOR = 92;
  private static final int METHODID_DELETE_GUEST_GROUP_GUEST_USER_MEMBER_RELATION = 93;
  private static final int METHODID_DELETE_GUEST_GROUP_MEMBER = 94;
  private static final int METHODID_DELETE_GUEST_GROUP_REGISTERED_USER_MEMBER_RELATION = 95;
  private static final int METHODID_DELETE_GUEST_USER_FRIEND = 96;
  private static final int METHODID_DELETE_OFFLINE_MESSAGE_PRIORITY = 97;
  private static final int METHODID_DELETE_REGISTERED_GROUP = 98;
  private static final int METHODID_DELETE_REGISTERED_GROUP_ADMINISTRATOR = 99;
  private static final int METHODID_DELETE_REGISTERED_GROUP_GUEST_USER_MEMBER_RELATION = 100;
  private static final int METHODID_DELETE_REGISTERED_GROUP_MEMBER = 101;
  private static final int METHODID_DELETE_REGISTERED_GROUP_REGISTERED_USER_MEMBER_RELATION = 102;
  private static final int METHODID_DELETE_REGISTERED_USER_FRIEND = 103;
  private static final int METHODID_DELETE_GROUP_UNUSED_BEAUTIFUL_NUMBER_REAL = 104;
  private static final int METHODID_DELETE_GROUP_USED_BEAUTIFUL_NUMBER_REAL = 105;
  private static final int METHODID_DELETE_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER_REAL = 106;
  private static final int METHODID_DELETE_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER_REAL = 107;
  private static final int METHODID_DELETE_FRIEND_UNUSED_BEAUTIFUL_NUMBER_REAL = 108;
  private static final int METHODID_DELETE_FRIEND_USED_BEAUTIFUL_NUMBER_REAL = 109;
  private static final int METHODID_DELETE_GROUP_REMARK = 110;

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
        case METHODID_SELECT_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.selectBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_SELECT_BEAUTIFUL_NUMBER_AUTO:
          serviceImpl.selectBeautifulNumberAuto((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_SELECT_BURN_AFTER_READING_PRIORITY:
          serviceImpl.selectBurnAfterReadingPriority((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BurnAfterReadingPriorityResponse>) responseObserver);
          break;
        case METHODID_SELECT_FRIEND_UNUSED_BEAUTIFUL_NUMBER:
          serviceImpl.selectFriendUnusedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_SELECT_FRIEND_USED_BEAUTIFUL_NUMBER:
          serviceImpl.selectFriendUsedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_SELECT_GROUP_ANNOUNCEMENTS:
          serviceImpl.selectGroupAnnouncements((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupAnnouncementsResponse>) responseObserver);
          break;
        case METHODID_SELECT_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER:
          serviceImpl.selectGroupMemberUnusedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_SELECT_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER:
          serviceImpl.selectGroupMemberUsedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_SELECT_GROUP_UNUSED_BEAUTIFUL_NUMBER:
          serviceImpl.selectGroupUnusedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_SELECT_GROUP_USED_BEAUTIFUL_NUMBER:
          serviceImpl.selectGroupUsedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_SELECT_GUEST_GROUP:
          serviceImpl.selectGuestGroup((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupResponse>) responseObserver);
          break;
        case METHODID_SELECT_GUEST_GROUP_ADMINISTRATOR:
          serviceImpl.selectGuestGroupAdministrator((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupAdministratorResponse>) responseObserver);
          break;
        case METHODID_SELECT_GUEST_GROUP_GUEST_USER_MEMBER_RELATION:
          serviceImpl.selectGuestGroupGuestUserMemberRelation((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse>) responseObserver);
          break;
        case METHODID_SELECT_GUEST_GROUP_MEMBER:
          serviceImpl.selectGuestGroupMember((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupMemberResponse>) responseObserver);
          break;
        case METHODID_SELECT_GUEST_GROUP_REGISTERED_USER_MEMBER_RELATION:
          serviceImpl.selectGuestGroupRegisteredUserMemberRelation((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse>) responseObserver);
          break;
        case METHODID_SELECT_GUEST_USER_FRIEND:
          serviceImpl.selectGuestUserFriend((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestUserFriendResponse>) responseObserver);
          break;
        case METHODID_SELECT_OFFLINE_MESSAGE_PRIORITY:
          serviceImpl.selectOfflineMessagePriority((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.OfflineMessagePriorityResponse>) responseObserver);
          break;
        case METHODID_SELECT_REGISTERED_GROUP:
          serviceImpl.selectRegisteredGroup((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupResponse>) responseObserver);
          break;
        case METHODID_SELECT_REGISTERED_GROUP_ADMINISTRATOR:
          serviceImpl.selectRegisteredGroupAdministrator((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse>) responseObserver);
          break;
        case METHODID_SELECT_REGISTERED_GROUP_GUEST_USER_MEMBER_RELATION:
          serviceImpl.selectRegisteredGroupGuestUserMemberRelation((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse>) responseObserver);
          break;
        case METHODID_SELECT_REGISTERED_GROUP_MEMBER:
          serviceImpl.selectRegisteredGroupMember((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupMemberResponse>) responseObserver);
          break;
        case METHODID_SELECT_REGISTERED_GROUP_REGISTERED_USER_MEMBER_RELATION:
          serviceImpl.selectRegisteredGroupRegisteredUserMemberRelation((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse>) responseObserver);
          break;
        case METHODID_SELECT_REGISTERED_USER_FRIEND:
          serviceImpl.selectRegisteredUserFriend((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredUserFriendResponse>) responseObserver);
          break;
        case METHODID_SELECT_GROUP_UNUSED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.selectGroupUnusedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_SELECT_GROUP_USED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.selectGroupUsedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_SELECT_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.selectGroupMemberUnusedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_SELECT_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.selectGroupMemberUsedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_SELECT_FRIEND_UNUSED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.selectFriendUnusedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_SELECT_FRIEND_USED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.selectFriendUsedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_SELECT_GROUP_REMARK:
          serviceImpl.selectGroupRemark((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupRemarkResponse>) responseObserver);
          break;
        case METHODID_INSERT_FRIEND_UNUSED_BEAUTIFUL_NUMBER:
          serviceImpl.insertFriendUnusedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_INSERT_FRIEND_USED_BEAUTIFUL_NUMBER:
          serviceImpl.insertFriendUsedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_INSERT_GROUP_ANNOUNCEMENTS:
          serviceImpl.insertGroupAnnouncements((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupAnnouncementsResponse>) responseObserver);
          break;
        case METHODID_INSERT_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER:
          serviceImpl.insertGroupMemberUnusedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_INSERT_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER:
          serviceImpl.insertGroupMemberUsedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_INSERT_GROUP_UNUSED_BEAUTIFUL_NUMBER:
          serviceImpl.insertGroupUnusedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_INSERT_GROUP_USED_BEAUTIFUL_NUMBER:
          serviceImpl.insertGroupUsedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_INSERT_GUEST_GROUP:
          serviceImpl.insertGuestGroup((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupResponse>) responseObserver);
          break;
        case METHODID_INSERT_GUEST_GROUP_ADMINISTRATOR:
          serviceImpl.insertGuestGroupAdministrator((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupAdministratorResponse>) responseObserver);
          break;
        case METHODID_INSERT_GUEST_GROUP_GUEST_USER_MEMBER_RELATION:
          serviceImpl.insertGuestGroupGuestUserMemberRelation((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse>) responseObserver);
          break;
        case METHODID_INSERT_GUEST_GROUP_MEMBER:
          serviceImpl.insertGuestGroupMember((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupMemberResponse>) responseObserver);
          break;
        case METHODID_INSERT_GUEST_GROUP_REGISTERED_USER_MEMBER_RELATION:
          serviceImpl.insertGuestGroupRegisteredUserMemberRelation((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse>) responseObserver);
          break;
        case METHODID_INSERT_GUEST_USER_FRIEND:
          serviceImpl.insertGuestUserFriend((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestUserFriendResponse>) responseObserver);
          break;
        case METHODID_INSERT_OFFLINE_MESSAGE_PRIORITY:
          serviceImpl.insertOfflineMessagePriority((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.OfflineMessagePriorityResponse>) responseObserver);
          break;
        case METHODID_INSERT_REGISTERED_GROUP:
          serviceImpl.insertRegisteredGroup((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupResponse>) responseObserver);
          break;
        case METHODID_INSERT_REGISTERED_GROUP_ADMINISTRATOR:
          serviceImpl.insertRegisteredGroupAdministrator((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse>) responseObserver);
          break;
        case METHODID_INSERT_REGISTERED_GROUP_GUEST_USER_MEMBER_RELATION:
          serviceImpl.insertRegisteredGroupGuestUserMemberRelation((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse>) responseObserver);
          break;
        case METHODID_INSERT_REGISTERED_GROUP_MEMBER:
          serviceImpl.insertRegisteredGroupMember((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupMemberResponse>) responseObserver);
          break;
        case METHODID_INSERT_REGISTERED_GROUP_REGISTERED_USER_MEMBER_RELATION:
          serviceImpl.insertRegisteredGroupRegisteredUserMemberRelation((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse>) responseObserver);
          break;
        case METHODID_INSERT_REGISTERED_USER_FRIEND:
          serviceImpl.insertRegisteredUserFriend((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredUserFriendResponse>) responseObserver);
          break;
        case METHODID_INSERT_GROUP_UNUSED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.insertGroupUnusedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_INSERT_GROUP_USED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.insertGroupUsedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_INSERT_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.insertGroupMemberUnusedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_INSERT_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.insertGroupMemberUsedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_INSERT_FRIEND_UNUSED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.insertFriendUnusedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_INSERT_FRIEND_USED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.insertFriendUsedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_INSERT_GROUP_REMARK:
          serviceImpl.insertGroupRemark((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupRemarkResponse>) responseObserver);
          break;
        case METHODID_UPDATE_FRIEND_UNUSED_BEAUTIFUL_NUMBER:
          serviceImpl.updateFriendUnusedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_UPDATE_FRIEND_USED_BEAUTIFUL_NUMBER:
          serviceImpl.updateFriendUsedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GROUP_ANNOUNCEMENTS:
          serviceImpl.updateGroupAnnouncements((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupAnnouncementsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER:
          serviceImpl.updateGroupMemberUnusedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER:
          serviceImpl.updateGroupMemberUsedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GROUP_UNUSED_BEAUTIFUL_NUMBER:
          serviceImpl.updateGroupUnusedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GROUP_USED_BEAUTIFUL_NUMBER:
          serviceImpl.updateGroupUsedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GUEST_GROUP:
          serviceImpl.updateGuestGroup((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GUEST_GROUP_ADMINISTRATOR:
          serviceImpl.updateGuestGroupAdministrator((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupAdministratorResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GUEST_GROUP_GUEST_USER_MEMBER_RELATION:
          serviceImpl.updateGuestGroupGuestUserMemberRelation((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GUEST_GROUP_MEMBER:
          serviceImpl.updateGuestGroupMember((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupMemberResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GUEST_GROUP_REGISTERED_USER_MEMBER_RELATION:
          serviceImpl.updateGuestGroupRegisteredUserMemberRelation((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GUEST_USER_FRIEND:
          serviceImpl.updateGuestUserFriend((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestUserFriendResponse>) responseObserver);
          break;
        case METHODID_UPDATE_OFFLINE_MESSAGE_PRIORITY:
          serviceImpl.updateOfflineMessagePriority((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.OfflineMessagePriorityResponse>) responseObserver);
          break;
        case METHODID_UPDATE_REGISTERED_GROUP:
          serviceImpl.updateRegisteredGroup((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupResponse>) responseObserver);
          break;
        case METHODID_UPDATE_REGISTERED_GROUP_ADMINISTRATOR:
          serviceImpl.updateRegisteredGroupAdministrator((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse>) responseObserver);
          break;
        case METHODID_UPDATE_REGISTERED_GROUP_GUEST_USER_MEMBER_RELATION:
          serviceImpl.updateRegisteredGroupGuestUserMemberRelation((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse>) responseObserver);
          break;
        case METHODID_UPDATE_REGISTERED_GROUP_MEMBER:
          serviceImpl.updateRegisteredGroupMember((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupMemberResponse>) responseObserver);
          break;
        case METHODID_UPDATE_REGISTERED_GROUP_REGISTERED_USER_MEMBER_RELATION:
          serviceImpl.updateRegisteredGroupRegisteredUserMemberRelation((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse>) responseObserver);
          break;
        case METHODID_UPDATE_REGISTERED_USER_FRIEND:
          serviceImpl.updateRegisteredUserFriend((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredUserFriendResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GROUP_UNUSED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.updateGroupUnusedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GROUP_USED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.updateGroupUsedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.updateGroupMemberUnusedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.updateGroupMemberUsedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_UPDATE_FRIEND_UNUSED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.updateFriendUnusedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_UPDATE_FRIEND_USED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.updateFriendUsedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GROUP_REMARK:
          serviceImpl.updateGroupRemark((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupRemarkResponse>) responseObserver);
          break;
        case METHODID_DELETE_FRIEND_UNUSED_BEAUTIFUL_NUMBER:
          serviceImpl.deleteFriendUnusedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_DELETE_FRIEND_USED_BEAUTIFUL_NUMBER:
          serviceImpl.deleteFriendUsedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_DELETE_GROUP_ANNOUNCEMENTS:
          serviceImpl.deleteGroupAnnouncements((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupAnnouncementsResponse>) responseObserver);
          break;
        case METHODID_DELETE_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER:
          serviceImpl.deleteGroupMemberUnusedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_DELETE_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER:
          serviceImpl.deleteGroupMemberUsedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_DELETE_GROUP_UNUSED_BEAUTIFUL_NUMBER:
          serviceImpl.deleteGroupUnusedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_DELETE_GROUP_USED_BEAUTIFUL_NUMBER:
          serviceImpl.deleteGroupUsedBeautifulNumber((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_DELETE_GUEST_GROUP:
          serviceImpl.deleteGuestGroup((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupResponse>) responseObserver);
          break;
        case METHODID_DELETE_GUEST_GROUP_ADMINISTRATOR:
          serviceImpl.deleteGuestGroupAdministrator((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupAdministratorResponse>) responseObserver);
          break;
        case METHODID_DELETE_GUEST_GROUP_GUEST_USER_MEMBER_RELATION:
          serviceImpl.deleteGuestGroupGuestUserMemberRelation((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupGuestUserMemberRelationResponse>) responseObserver);
          break;
        case METHODID_DELETE_GUEST_GROUP_MEMBER:
          serviceImpl.deleteGuestGroupMember((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupMemberResponse>) responseObserver);
          break;
        case METHODID_DELETE_GUEST_GROUP_REGISTERED_USER_MEMBER_RELATION:
          serviceImpl.deleteGuestGroupRegisteredUserMemberRelation((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestGroupRegisteredUserMemberRelationResponse>) responseObserver);
          break;
        case METHODID_DELETE_GUEST_USER_FRIEND:
          serviceImpl.deleteGuestUserFriend((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GuestUserFriendResponse>) responseObserver);
          break;
        case METHODID_DELETE_OFFLINE_MESSAGE_PRIORITY:
          serviceImpl.deleteOfflineMessagePriority((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.OfflineMessagePriorityResponse>) responseObserver);
          break;
        case METHODID_DELETE_REGISTERED_GROUP:
          serviceImpl.deleteRegisteredGroup((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupResponse>) responseObserver);
          break;
        case METHODID_DELETE_REGISTERED_GROUP_ADMINISTRATOR:
          serviceImpl.deleteRegisteredGroupAdministrator((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupAdministratorResponse>) responseObserver);
          break;
        case METHODID_DELETE_REGISTERED_GROUP_GUEST_USER_MEMBER_RELATION:
          serviceImpl.deleteRegisteredGroupGuestUserMemberRelation((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupGuestUserMemberRelationResponse>) responseObserver);
          break;
        case METHODID_DELETE_REGISTERED_GROUP_MEMBER:
          serviceImpl.deleteRegisteredGroupMember((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupMemberResponse>) responseObserver);
          break;
        case METHODID_DELETE_REGISTERED_GROUP_REGISTERED_USER_MEMBER_RELATION:
          serviceImpl.deleteRegisteredGroupRegisteredUserMemberRelation((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredGroupRegisteredUserMemberRelationResponse>) responseObserver);
          break;
        case METHODID_DELETE_REGISTERED_USER_FRIEND:
          serviceImpl.deleteRegisteredUserFriend((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.RegisteredUserFriendResponse>) responseObserver);
          break;
        case METHODID_DELETE_GROUP_UNUSED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.deleteGroupUnusedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_DELETE_GROUP_USED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.deleteGroupUsedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_DELETE_GROUP_MEMBER_UNUSED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.deleteGroupMemberUnusedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_DELETE_GROUP_MEMBER_USED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.deleteGroupMemberUsedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_DELETE_FRIEND_UNUSED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.deleteFriendUnusedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_DELETE_FRIEND_USED_BEAUTIFUL_NUMBER_REAL:
          serviceImpl.deleteFriendUsedBeautifulNumberReal((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.BeautifulNumberCommonResponse>) responseObserver);
          break;
        case METHODID_DELETE_GROUP_REMARK:
          serviceImpl.deleteGroupRemark((com.lanjiu.im.grpc.TransmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.lanjiu.im.grpc.GroupRemarkResponse>) responseObserver);
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
              .addMethod(getSelectBeautifulNumberRealMethod())
              .addMethod(getSelectBeautifulNumberAutoMethod())
              .addMethod(getSelectBurnAfterReadingPriorityMethod())
              .addMethod(getSelectFriendUnusedBeautifulNumberMethod())
              .addMethod(getSelectFriendUsedBeautifulNumberMethod())
              .addMethod(getSelectGroupAnnouncementsMethod())
              .addMethod(getSelectGroupMemberUnusedBeautifulNumberMethod())
              .addMethod(getSelectGroupMemberUsedBeautifulNumberMethod())
              .addMethod(getSelectGroupUnusedBeautifulNumberMethod())
              .addMethod(getSelectGroupUsedBeautifulNumberMethod())
              .addMethod(getSelectGuestGroupMethod())
              .addMethod(getSelectGuestGroupAdministratorMethod())
              .addMethod(getSelectGuestGroupGuestUserMemberRelationMethod())
              .addMethod(getSelectGuestGroupMemberMethod())
              .addMethod(getSelectGuestGroupRegisteredUserMemberRelationMethod())
              .addMethod(getSelectGuestUserFriendMethod())
              .addMethod(getSelectOfflineMessagePriorityMethod())
              .addMethod(getSelectRegisteredGroupMethod())
              .addMethod(getSelectRegisteredGroupAdministratorMethod())
              .addMethod(getSelectRegisteredGroupGuestUserMemberRelationMethod())
              .addMethod(getSelectRegisteredGroupMemberMethod())
              .addMethod(getSelectRegisteredGroupRegisteredUserMemberRelationMethod())
              .addMethod(getSelectRegisteredUserFriendMethod())
              .addMethod(getSelectGroupUnusedBeautifulNumberRealMethod())
              .addMethod(getSelectGroupUsedBeautifulNumberRealMethod())
              .addMethod(getSelectGroupMemberUnusedBeautifulNumberRealMethod())
              .addMethod(getSelectGroupMemberUsedBeautifulNumberRealMethod())
              .addMethod(getSelectFriendUnusedBeautifulNumberRealMethod())
              .addMethod(getSelectFriendUsedBeautifulNumberRealMethod())
              .addMethod(getSelectGroupRemarkMethod())
              .addMethod(getInsertFriendUnusedBeautifulNumberMethod())
              .addMethod(getInsertFriendUsedBeautifulNumberMethod())
              .addMethod(getInsertGroupAnnouncementsMethod())
              .addMethod(getInsertGroupMemberUnusedBeautifulNumberMethod())
              .addMethod(getInsertGroupMemberUsedBeautifulNumberMethod())
              .addMethod(getInsertGroupUnusedBeautifulNumberMethod())
              .addMethod(getInsertGroupUsedBeautifulNumberMethod())
              .addMethod(getInsertGuestGroupMethod())
              .addMethod(getInsertGuestGroupAdministratorMethod())
              .addMethod(getInsertGuestGroupGuestUserMemberRelationMethod())
              .addMethod(getInsertGuestGroupMemberMethod())
              .addMethod(getInsertGuestGroupRegisteredUserMemberRelationMethod())
              .addMethod(getInsertGuestUserFriendMethod())
              .addMethod(getInsertOfflineMessagePriorityMethod())
              .addMethod(getInsertRegisteredGroupMethod())
              .addMethod(getInsertRegisteredGroupAdministratorMethod())
              .addMethod(getInsertRegisteredGroupGuestUserMemberRelationMethod())
              .addMethod(getInsertRegisteredGroupMemberMethod())
              .addMethod(getInsertRegisteredGroupRegisteredUserMemberRelationMethod())
              .addMethod(getInsertRegisteredUserFriendMethod())
              .addMethod(getInsertGroupUnusedBeautifulNumberRealMethod())
              .addMethod(getInsertGroupUsedBeautifulNumberRealMethod())
              .addMethod(getInsertGroupMemberUnusedBeautifulNumberRealMethod())
              .addMethod(getInsertGroupMemberUsedBeautifulNumberRealMethod())
              .addMethod(getInsertFriendUnusedBeautifulNumberRealMethod())
              .addMethod(getInsertFriendUsedBeautifulNumberRealMethod())
              .addMethod(getInsertGroupRemarkMethod())
              .addMethod(getUpdateFriendUnusedBeautifulNumberMethod())
              .addMethod(getUpdateFriendUsedBeautifulNumberMethod())
              .addMethod(getUpdateGroupAnnouncementsMethod())
              .addMethod(getUpdateGroupMemberUnusedBeautifulNumberMethod())
              .addMethod(getUpdateGroupMemberUsedBeautifulNumberMethod())
              .addMethod(getUpdateGroupUnusedBeautifulNumberMethod())
              .addMethod(getUpdateGroupUsedBeautifulNumberMethod())
              .addMethod(getUpdateGuestGroupMethod())
              .addMethod(getUpdateGuestGroupAdministratorMethod())
              .addMethod(getUpdateGuestGroupGuestUserMemberRelationMethod())
              .addMethod(getUpdateGuestGroupMemberMethod())
              .addMethod(getUpdateGuestGroupRegisteredUserMemberRelationMethod())
              .addMethod(getUpdateGuestUserFriendMethod())
              .addMethod(getUpdateOfflineMessagePriorityMethod())
              .addMethod(getUpdateRegisteredGroupMethod())
              .addMethod(getUpdateRegisteredGroupAdministratorMethod())
              .addMethod(getUpdateRegisteredGroupGuestUserMemberRelationMethod())
              .addMethod(getUpdateRegisteredGroupMemberMethod())
              .addMethod(getUpdateRegisteredGroupRegisteredUserMemberRelationMethod())
              .addMethod(getUpdateRegisteredUserFriendMethod())
              .addMethod(getUpdateGroupUnusedBeautifulNumberRealMethod())
              .addMethod(getUpdateGroupUsedBeautifulNumberRealMethod())
              .addMethod(getUpdateGroupMemberUnusedBeautifulNumberRealMethod())
              .addMethod(getUpdateGroupMemberUsedBeautifulNumberRealMethod())
              .addMethod(getUpdateFriendUnusedBeautifulNumberRealMethod())
              .addMethod(getUpdateFriendUsedBeautifulNumberRealMethod())
              .addMethod(getUpdateGroupRemarkMethod())
              .addMethod(getDeleteFriendUnusedBeautifulNumberMethod())
              .addMethod(getDeleteFriendUsedBeautifulNumberMethod())
              .addMethod(getDeleteGroupAnnouncementsMethod())
              .addMethod(getDeleteGroupMemberUnusedBeautifulNumberMethod())
              .addMethod(getDeleteGroupMemberUsedBeautifulNumberMethod())
              .addMethod(getDeleteGroupUnusedBeautifulNumberMethod())
              .addMethod(getDeleteGroupUsedBeautifulNumberMethod())
              .addMethod(getDeleteGuestGroupMethod())
              .addMethod(getDeleteGuestGroupAdministratorMethod())
              .addMethod(getDeleteGuestGroupGuestUserMemberRelationMethod())
              .addMethod(getDeleteGuestGroupMemberMethod())
              .addMethod(getDeleteGuestGroupRegisteredUserMemberRelationMethod())
              .addMethod(getDeleteGuestUserFriendMethod())
              .addMethod(getDeleteOfflineMessagePriorityMethod())
              .addMethod(getDeleteRegisteredGroupMethod())
              .addMethod(getDeleteRegisteredGroupAdministratorMethod())
              .addMethod(getDeleteRegisteredGroupGuestUserMemberRelationMethod())
              .addMethod(getDeleteRegisteredGroupMemberMethod())
              .addMethod(getDeleteRegisteredGroupRegisteredUserMemberRelationMethod())
              .addMethod(getDeleteRegisteredUserFriendMethod())
              .addMethod(getDeleteGroupUnusedBeautifulNumberRealMethod())
              .addMethod(getDeleteGroupUsedBeautifulNumberRealMethod())
              .addMethod(getDeleteGroupMemberUnusedBeautifulNumberRealMethod())
              .addMethod(getDeleteGroupMemberUsedBeautifulNumberRealMethod())
              .addMethod(getDeleteFriendUnusedBeautifulNumberRealMethod())
              .addMethod(getDeleteFriendUsedBeautifulNumberRealMethod())
              .addMethod(getDeleteGroupRemarkMethod())
              .build();
        }
      }
    }
    return result;
  }
}
