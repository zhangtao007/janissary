// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message_group_storage_grpc.proto

package com.lanjiu.pro.groupStorage;

public interface ResponseSelectResultOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.pro.groupStorage.ResponseSelectResult)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .com.lanjiu.pro.groupStorage.MsgGroup msg_group = 1;</code>
   */
  java.util.List<com.lanjiu.pro.groupStorage.MsgGroup> 
      getMsgGroupList();
  /**
   * <code>repeated .com.lanjiu.pro.groupStorage.MsgGroup msg_group = 1;</code>
   */
  com.lanjiu.pro.groupStorage.MsgGroup getMsgGroup(int index);
  /**
   * <code>repeated .com.lanjiu.pro.groupStorage.MsgGroup msg_group = 1;</code>
   */
  int getMsgGroupCount();
  /**
   * <code>repeated .com.lanjiu.pro.groupStorage.MsgGroup msg_group = 1;</code>
   */
  java.util.List<? extends com.lanjiu.pro.groupStorage.MsgGroupOrBuilder> 
      getMsgGroupOrBuilderList();
  /**
   * <code>repeated .com.lanjiu.pro.groupStorage.MsgGroup msg_group = 1;</code>
   */
  com.lanjiu.pro.groupStorage.MsgGroupOrBuilder getMsgGroupOrBuilder(
      int index);

  /**
   * <code>string status = 2;</code>
   * @return The status.
   */
  java.lang.String getStatus();
  /**
   * <code>string status = 2;</code>
   * @return The bytes for status.
   */
  com.google.protobuf.ByteString
      getStatusBytes();
}
