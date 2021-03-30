// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: information_other_communication_grpc.proto

package com.lanjiu.im.communication.grpc;

public interface GroupOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.im.communication.grpc.Group)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 群ID
   * </pre>
   *
   * <code>string group_id = 1;</code>
   * @return The groupId.
   */
  java.lang.String getGroupId();
  /**
   * <pre>
   * 群ID
   * </pre>
   *
   * <code>string group_id = 1;</code>
   * @return The bytes for groupId.
   */
  com.google.protobuf.ByteString
      getGroupIdBytes();

  /**
   * <pre>
   *群昵称
   * </pre>
   *
   * <code>string group_nickname = 2;</code>
   * @return The groupNickname.
   */
  java.lang.String getGroupNickname();
  /**
   * <pre>
   *群昵称
   * </pre>
   *
   * <code>string group_nickname = 2;</code>
   * @return The bytes for groupNickname.
   */
  com.google.protobuf.ByteString
      getGroupNicknameBytes();

  /**
   * <pre>
   *群类型(游客用户群，注册用户群，混合群)
   * </pre>
   *
   * <code>string group_type = 3;</code>
   * @return The groupType.
   */
  java.lang.String getGroupType();
  /**
   * <pre>
   *群类型(游客用户群，注册用户群，混合群)
   * </pre>
   *
   * <code>string group_type = 3;</code>
   * @return The bytes for groupType.
   */
  com.google.protobuf.ByteString
      getGroupTypeBytes();

  /**
   * <pre>
   * 群人数
   * </pre>
   *
   * <code>int32 group_quantity = 4;</code>
   * @return The groupQuantity.
   */
  int getGroupQuantity();
}
