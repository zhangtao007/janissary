// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message_group_storage_grpc.proto

package com.lanjiu.im.storage;

public interface OffGroupMessageTransmissionRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.im.storage.OffGroupMessageTransmissionRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .com.lanjiu.im.storage.RpcMsgGroupOff msg_group = 1;</code>
   */
  java.util.List<com.lanjiu.im.storage.RpcMsgGroupOff> 
      getMsgGroupList();
  /**
   * <code>repeated .com.lanjiu.im.storage.RpcMsgGroupOff msg_group = 1;</code>
   */
  com.lanjiu.im.storage.RpcMsgGroupOff getMsgGroup(int index);
  /**
   * <code>repeated .com.lanjiu.im.storage.RpcMsgGroupOff msg_group = 1;</code>
   */
  int getMsgGroupCount();
  /**
   * <code>repeated .com.lanjiu.im.storage.RpcMsgGroupOff msg_group = 1;</code>
   */
  java.util.List<? extends com.lanjiu.im.storage.RpcMsgGroupOffOrBuilder> 
      getMsgGroupOrBuilderList();
  /**
   * <code>repeated .com.lanjiu.im.storage.RpcMsgGroupOff msg_group = 1;</code>
   */
  com.lanjiu.im.storage.RpcMsgGroupOffOrBuilder getMsgGroupOrBuilder(
      int index);

  /**
   * <code>string kind = 2;</code>
   * @return The kind.
   */
  java.lang.String getKind();
  /**
   * <code>string kind = 2;</code>
   * @return The bytes for kind.
   */
  com.google.protobuf.ByteString
      getKindBytes();
}
