// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message_group_storage_grpc.proto

package com.lanjiu.pro.groupStorage;

public interface MsgGroupOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.pro.groupStorage.MsgGroup)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 msg_id = 1;</code>
   * @return The msgId.
   */
  int getMsgId();

  /**
   * <code>int32 msg_type = 2;</code>
   * @return The msgType.
   */
  int getMsgType();

  /**
   * <code>int32 from_id = 3;</code>
   * @return The fromId.
   */
  int getFromId();

  /**
   * <code>int32 to_id = 4;</code>
   * @return The toId.
   */
  int getToId();

  /**
   * <code>string content = 5;</code>
   * @return The content.
   */
  java.lang.String getContent();
  /**
   * <code>string content = 5;</code>
   * @return The bytes for content.
   */
  com.google.protobuf.ByteString
      getContentBytes();

  /**
   * <code>string entity_url = 6;</code>
   * @return The entityUrl.
   */
  java.lang.String getEntityUrl();
  /**
   * <code>string entity_url = 6;</code>
   * @return The bytes for entityUrl.
   */
  com.google.protobuf.ByteString
      getEntityUrlBytes();

  /**
   * <code>int64 create_time = 7;</code>
   * @return The createTime.
   */
  long getCreateTime();

  /**
   * <code>string message_offline_status = 8;</code>
   * @return The messageOfflineStatus.
   */
  java.lang.String getMessageOfflineStatus();
  /**
   * <code>string message_offline_status = 8;</code>
   * @return The bytes for messageOfflineStatus.
   */
  com.google.protobuf.ByteString
      getMessageOfflineStatusBytes();

  /**
   * <code>string burn_after_reading_status = 9;</code>
   * @return The burnAfterReadingStatus.
   */
  java.lang.String getBurnAfterReadingStatus();
  /**
   * <code>string burn_after_reading_status = 9;</code>
   * @return The bytes for burnAfterReadingStatus.
   */
  com.google.protobuf.ByteString
      getBurnAfterReadingStatusBytes();

  /**
   * <code>float burn_after_reading_length = 10;</code>
   * @return The burnAfterReadingLength.
   */
  float getBurnAfterReadingLength();
}
