// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: information_other_storage_grpc.proto

package com.lanjiu.im.grpc;

public interface GuestUserFriendResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.im.grpc.GuestUserFriendResponse)
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
   * <code>repeated .com.lanjiu.im.grpc.RpcGuestUserFriend response_data = 2;</code>
   */
  java.util.List<com.lanjiu.im.grpc.RpcGuestUserFriend> 
      getResponseDataList();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGuestUserFriend response_data = 2;</code>
   */
  com.lanjiu.im.grpc.RpcGuestUserFriend getResponseData(int index);
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGuestUserFriend response_data = 2;</code>
   */
  int getResponseDataCount();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGuestUserFriend response_data = 2;</code>
   */
  java.util.List<? extends com.lanjiu.im.grpc.RpcGuestUserFriendOrBuilder> 
      getResponseDataOrBuilderList();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGuestUserFriend response_data = 2;</code>
   */
  com.lanjiu.im.grpc.RpcGuestUserFriendOrBuilder getResponseDataOrBuilder(
      int index);
}
