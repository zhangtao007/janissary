// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: file_transfer_communication_grpc.proto

package com.lanjiu.pro.file;

public interface FriendsTransmissionResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.pro.file.FriendsTransmissionResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.lanjiu.pro.file.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
   * @return Whether the friendsPictureVideoMessage field is set.
   */
  boolean hasFriendsPictureVideoMessage();
  /**
   * <code>.com.lanjiu.pro.file.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
   * @return The friendsPictureVideoMessage.
   */
  com.lanjiu.pro.file.OriginalPictureVideoFriendsTransmission getFriendsPictureVideoMessage();
  /**
   * <code>.com.lanjiu.pro.file.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
   */
  com.lanjiu.pro.file.OriginalPictureVideoFriendsTransmissionOrBuilder getFriendsPictureVideoMessageOrBuilder();

  /**
   * <pre>
   *校验位
   * </pre>
   *
   * <code>string checksum = 2;</code>
   * @return The checksum.
   */
  java.lang.String getChecksum();
  /**
   * <pre>
   *校验位
   * </pre>
   *
   * <code>string checksum = 2;</code>
   * @return The bytes for checksum.
   */
  com.google.protobuf.ByteString
      getChecksumBytes();
}
