// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: file_transfer_communication_grpc.proto

package com.lanjiu.pro.file;

public interface HeadOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.pro.file.Head)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 消息id  服务类型编码+服务编码+模块编码+功能(动作)编码
   * </pre>
   *
   * <code>string msgId = 1;</code>
   * @return The msgId.
   */
  java.lang.String getMsgId();
  /**
   * <pre>
   * 消息id  服务类型编码+服务编码+模块编码+功能(动作)编码
   * </pre>
   *
   * <code>string msgId = 1;</code>
   * @return The bytes for msgId.
   */
  com.google.protobuf.ByteString
      getMsgIdBytes();

  /**
   * <pre>
   * 消息类型   长连接，短连接
   * </pre>
   *
   * <code>int32 msgType = 2;</code>
   * @return The msgType.
   */
  int getMsgType();

  /**
   * <pre>
   * 消息内容类型
   * </pre>
   *
   * <code>int32 msgContentType = 3;</code>
   * @return The msgContentType.
   */
  int getMsgContentType();

  /**
   * <pre>
   * 消息发送者id
   * </pre>
   *
   * <code>string fromId = 4;</code>
   * @return The fromId.
   */
  java.lang.String getFromId();
  /**
   * <pre>
   * 消息发送者id
   * </pre>
   *
   * <code>string fromId = 4;</code>
   * @return The bytes for fromId.
   */
  com.google.protobuf.ByteString
      getFromIdBytes();

  /**
   * <pre>
   * 消息接收者id
   * </pre>
   *
   * <code>string toId = 5;</code>
   * @return The toId.
   */
  java.lang.String getToId();
  /**
   * <pre>
   * 消息接收者id
   * </pre>
   *
   * <code>string toId = 5;</code>
   * @return The bytes for toId.
   */
  com.google.protobuf.ByteString
      getToIdBytes();

  /**
   * <pre>
   * 消息时间戳
   * </pre>
   *
   * <code>int64 timestamp = 6;</code>
   * @return The timestamp.
   */
  long getTimestamp();

  /**
   * <pre>
   * 是否在线鉴权
   * </pre>
   *
   * <code>string token = 7;</code>
   * @return The token.
   */
  java.lang.String getToken();
  /**
   * <pre>
   * 是否在线鉴权
   * </pre>
   *
   * <code>string token = 7;</code>
   * @return The bytes for token.
   */
  com.google.protobuf.ByteString
      getTokenBytes();

  /**
   * <pre>
   * 状态报告   返回类型(成功/失败)
   * </pre>
   *
   * <code>string statusReport = 8;</code>
   * @return The statusReport.
   */
  java.lang.String getStatusReport();
  /**
   * <pre>
   * 状态报告   返回类型(成功/失败)
   * </pre>
   *
   * <code>string statusReport = 8;</code>
   * @return The bytes for statusReport.
   */
  com.google.protobuf.ByteString
      getStatusReportBytes();
}
