// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: file_transfer_storage_grpc.proto

package com.lanjiu.pro.fileStorage;

public interface FriendsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.pro.fileStorage.Friends)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 好友ID
   * </pre>
   *
   * <code>string friends_id = 1;</code>
   * @return The friendsId.
   */
  java.lang.String getFriendsId();
  /**
   * <pre>
   * 好友ID
   * </pre>
   *
   * <code>string friends_id = 1;</code>
   * @return The bytes for friendsId.
   */
  com.google.protobuf.ByteString
      getFriendsIdBytes();

  /**
   * <pre>
   *好友昵称
   * </pre>
   *
   * <code>string friends_nickname = 2;</code>
   * @return The friendsNickname.
   */
  java.lang.String getFriendsNickname();
  /**
   * <pre>
   *好友昵称
   * </pre>
   *
   * <code>string friends_nickname = 2;</code>
   * @return The bytes for friendsNickname.
   */
  com.google.protobuf.ByteString
      getFriendsNicknameBytes();

  /**
   * <pre>
   *好友用户类型
   * </pre>
   *
   * <code>string friends_user_type = 3;</code>
   * @return The friendsUserType.
   */
  java.lang.String getFriendsUserType();
  /**
   * <pre>
   *好友用户类型
   * </pre>
   *
   * <code>string friends_user_type = 3;</code>
   * @return The bytes for friendsUserType.
   */
  com.google.protobuf.ByteString
      getFriendsUserTypeBytes();

  /**
   * <pre>
   *好友离线消息
   * </pre>
   *
   * <code>string friends_offline_message = 4;</code>
   * @return The friendsOfflineMessage.
   */
  java.lang.String getFriendsOfflineMessage();
  /**
   * <pre>
   *好友离线消息
   * </pre>
   *
   * <code>string friends_offline_message = 4;</code>
   * @return The bytes for friendsOfflineMessage.
   */
  com.google.protobuf.ByteString
      getFriendsOfflineMessageBytes();

  /**
   * <pre>
   *好友阅后即焚
   * </pre>
   *
   * <code>string friends_burn_after_reading = 5;</code>
   * @return The friendsBurnAfterReading.
   */
  java.lang.String getFriendsBurnAfterReading();
  /**
   * <pre>
   *好友阅后即焚
   * </pre>
   *
   * <code>string friends_burn_after_reading = 5;</code>
   * @return The bytes for friendsBurnAfterReading.
   */
  com.google.protobuf.ByteString
      getFriendsBurnAfterReadingBytes();

  /**
   * <pre>
   *好友在线状态
   * </pre>
   *
   * <code>string friends_online_status = 6;</code>
   * @return The friendsOnlineStatus.
   */
  java.lang.String getFriendsOnlineStatus();
  /**
   * <pre>
   *好友在线状态
   * </pre>
   *
   * <code>string friends_online_status = 6;</code>
   * @return The bytes for friendsOnlineStatus.
   */
  com.google.protobuf.ByteString
      getFriendsOnlineStatusBytes();

  /**
   * <code>.com.lanjiu.pro.fileStorage.Tourists tourists = 7;</code>
   * @return Whether the tourists field is set.
   */
  boolean hasTourists();
  /**
   * <code>.com.lanjiu.pro.fileStorage.Tourists tourists = 7;</code>
   * @return The tourists.
   */
  com.lanjiu.pro.fileStorage.Tourists getTourists();
  /**
   * <code>.com.lanjiu.pro.fileStorage.Tourists tourists = 7;</code>
   */
  com.lanjiu.pro.fileStorage.TouristsOrBuilder getTouristsOrBuilder();

  /**
   * <code>.com.lanjiu.pro.fileStorage.RegisteredUser registered_user = 8;</code>
   * @return Whether the registeredUser field is set.
   */
  boolean hasRegisteredUser();
  /**
   * <code>.com.lanjiu.pro.fileStorage.RegisteredUser registered_user = 8;</code>
   * @return The registeredUser.
   */
  com.lanjiu.pro.fileStorage.RegisteredUser getRegisteredUser();
  /**
   * <code>.com.lanjiu.pro.fileStorage.RegisteredUser registered_user = 8;</code>
   */
  com.lanjiu.pro.fileStorage.RegisteredUserOrBuilder getRegisteredUserOrBuilder();
}
