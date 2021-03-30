// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: file_transfer_communication_grpc.proto

package com.lanjiu.pro.file;

public interface RegisteredUserOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.pro.file.RegisteredUser)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 注册用户ID
   * </pre>
   *
   * <code>string user_id = 1;</code>
   * @return The userId.
   */
  java.lang.String getUserId();
  /**
   * <pre>
   * 注册用户ID
   * </pre>
   *
   * <code>string user_id = 1;</code>
   * @return The bytes for userId.
   */
  com.google.protobuf.ByteString
      getUserIdBytes();

  /**
   * <pre>
   *密码
   * </pre>
   *
   * <code>string secret = 2;</code>
   * @return The secret.
   */
  java.lang.String getSecret();
  /**
   * <pre>
   *密码
   * </pre>
   *
   * <code>string secret = 2;</code>
   * @return The bytes for secret.
   */
  com.google.protobuf.ByteString
      getSecretBytes();

  /**
   * <pre>
   * 注册用户昵称
   * </pre>
   *
   * <code>string nickname = 3;</code>
   * @return The nickname.
   */
  java.lang.String getNickname();
  /**
   * <pre>
   * 注册用户昵称
   * </pre>
   *
   * <code>string nickname = 3;</code>
   * @return The bytes for nickname.
   */
  com.google.protobuf.ByteString
      getNicknameBytes();

  /**
   * <pre>
   * 注册用户手机号码
   * </pre>
   *
   * <code>string user_phone = 4;</code>
   * @return The userPhone.
   */
  java.lang.String getUserPhone();
  /**
   * <pre>
   * 注册用户手机号码
   * </pre>
   *
   * <code>string user_phone = 4;</code>
   * @return The bytes for userPhone.
   */
  com.google.protobuf.ByteString
      getUserPhoneBytes();

  /**
   * <pre>
   *IP地址
   * </pre>
   *
   * <code>string ip_address = 5;</code>
   * @return The ipAddress.
   */
  java.lang.String getIpAddress();
  /**
   * <pre>
   *IP地址
   * </pre>
   *
   * <code>string ip_address = 5;</code>
   * @return The bytes for ipAddress.
   */
  com.google.protobuf.ByteString
      getIpAddressBytes();
}
