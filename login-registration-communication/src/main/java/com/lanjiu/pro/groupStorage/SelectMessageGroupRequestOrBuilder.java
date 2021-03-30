// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message_group_storage_grpc.proto

package com.lanjiu.pro.groupStorage;

public interface SelectMessageGroupRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.pro.groupStorage.SelectMessageGroupRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated string group_id = 1;</code>
   * @return A list containing the groupId.
   */
  java.util.List<java.lang.String>
      getGroupIdList();
  /**
   * <code>repeated string group_id = 1;</code>
   * @return The count of groupId.
   */
  int getGroupIdCount();
  /**
   * <code>repeated string group_id = 1;</code>
   * @param index The index of the element to return.
   * @return The groupId at the given index.
   */
  java.lang.String getGroupId(int index);
  /**
   * <code>repeated string group_id = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the groupId at the given index.
   */
  com.google.protobuf.ByteString
      getGroupIdBytes(int index);

  /**
   * <code>string from_id = 2;</code>
   * @return The fromId.
   */
  java.lang.String getFromId();
  /**
   * <code>string from_id = 2;</code>
   * @return The bytes for fromId.
   */
  com.google.protobuf.ByteString
      getFromIdBytes();
}
