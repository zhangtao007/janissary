// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: information_other_storage_grpc.proto

package com.lanjiu.im.grpc;

public interface BurnAfterReadingPriorityResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.im.grpc.BurnAfterReadingPriorityResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string status_detail = 1;</code>
   * @return The statusDetail.
   */
  java.lang.String getStatusDetail();
  /**
   * <code>string status_detail = 1;</code>
   * @return The bytes for statusDetail.
   */
  com.google.protobuf.ByteString
      getStatusDetailBytes();

  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcBurnAfterReadingPriority response_data = 2;</code>
   */
  java.util.List<com.lanjiu.im.grpc.RpcBurnAfterReadingPriority> 
      getResponseDataList();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcBurnAfterReadingPriority response_data = 2;</code>
   */
  com.lanjiu.im.grpc.RpcBurnAfterReadingPriority getResponseData(int index);
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcBurnAfterReadingPriority response_data = 2;</code>
   */
  int getResponseDataCount();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcBurnAfterReadingPriority response_data = 2;</code>
   */
  java.util.List<? extends com.lanjiu.im.grpc.RpcBurnAfterReadingPriorityOrBuilder> 
      getResponseDataOrBuilderList();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcBurnAfterReadingPriority response_data = 2;</code>
   */
  com.lanjiu.im.grpc.RpcBurnAfterReadingPriorityOrBuilder getResponseDataOrBuilder(
      int index);
}
