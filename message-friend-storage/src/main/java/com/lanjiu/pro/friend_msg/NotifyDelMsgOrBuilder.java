// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: im_friend_message.proto

package com.lanjiu.pro.friend_msg;

public interface NotifyDelMsgOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.pro.friend_msg.NotifyDelMsg)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 delfromId = 1;</code>
   * @return The delfromId.
   */
  int getDelfromId();

  /**
   * <code>int32 deltoId = 2;</code>
   * @return The deltoId.
   */
  int getDeltoId();

  /**
   * <code>int32 fromId = 3;</code>
   * @return The fromId.
   */
  int getFromId();

  /**
   * <code>string msgId = 4;</code>
   * @return The msgId.
   */
  java.lang.String getMsgId();
  /**
   * <code>string msgId = 4;</code>
   * @return The bytes for msgId.
   */
  com.google.protobuf.ByteString
      getMsgIdBytes();

  /**
   * <code>string timestap = 5;</code>
   * @return The timestap.
   */
  java.lang.String getTimestap();
  /**
   * <code>string timestap = 5;</code>
   * @return The bytes for timestap.
   */
  com.google.protobuf.ByteString
      getTimestapBytes();

  /**
   * <code>string args = 6;</code>
   * @return The args.
   */
  java.lang.String getArgs();
  /**
   * <code>string args = 6;</code>
   * @return The bytes for args.
   */
  com.google.protobuf.ByteString
      getArgsBytes();
}
