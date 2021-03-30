// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: file_transfer_storage_grpc.proto

package com.lanjiu.pro.fileStorage;

public interface VoiceOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.pro.fileStorage.Voice)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 文本长度
   * </pre>
   *
   * <code>string all_length = 1;</code>
   * @return The allLength.
   */
  java.lang.String getAllLength();
  /**
   * <pre>
   * 文本长度
   * </pre>
   *
   * <code>string all_length = 1;</code>
   * @return The bytes for allLength.
   */
  com.google.protobuf.ByteString
      getAllLengthBytes();

  /**
   * <pre>
   * 文本内容
   * </pre>
   *
   * <code>bytes content = 2;</code>
   * @return The content.
   */
  com.google.protobuf.ByteString getContent();

  /**
   * <pre>
   *当前坐标
   * </pre>
   *
   * <code>int32 pos = 3;</code>
   * @return The pos.
   */
  int getPos();

  /**
   * <pre>
   *当前文件内容大小
   * </pre>
   *
   * <code>int32 length = 4;</code>
   * @return The length.
   */
  int getLength();

  /**
   * <pre>
   *好友结构体
   * </pre>
   *
   * <code>.com.lanjiu.pro.fileStorage.Friends friends = 5;</code>
   * @return Whether the friends field is set.
   */
  boolean hasFriends();
  /**
   * <pre>
   *好友结构体
   * </pre>
   *
   * <code>.com.lanjiu.pro.fileStorage.Friends friends = 5;</code>
   * @return The friends.
   */
  com.lanjiu.pro.fileStorage.Friends getFriends();
  /**
   * <pre>
   *好友结构体
   * </pre>
   *
   * <code>.com.lanjiu.pro.fileStorage.Friends friends = 5;</code>
   */
  com.lanjiu.pro.fileStorage.FriendsOrBuilder getFriendsOrBuilder();

  /**
   * <code>.com.lanjiu.pro.fileStorage.GroupMember groupMember = 6;</code>
   * @return Whether the groupMember field is set.
   */
  boolean hasGroupMember();
  /**
   * <code>.com.lanjiu.pro.fileStorage.GroupMember groupMember = 6;</code>
   * @return The groupMember.
   */
  com.lanjiu.pro.fileStorage.GroupMember getGroupMember();
  /**
   * <code>.com.lanjiu.pro.fileStorage.GroupMember groupMember = 6;</code>
   */
  com.lanjiu.pro.fileStorage.GroupMemberOrBuilder getGroupMemberOrBuilder();
}
