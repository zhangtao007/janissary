// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: information_other_communication_grpc.proto

package com.lanjiu.im.communication.grpc;

public interface FriendsTransmissionRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.im.communication.grpc.FriendsTransmissionRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.lanjiu.im.communication.grpc.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
   * @return Whether the friendsPictureVideoMessage field is set.
   */
  boolean hasFriendsPictureVideoMessage();
  /**
   * <code>.com.lanjiu.im.communication.grpc.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
   * @return The friendsPictureVideoMessage.
   */
  com.lanjiu.im.communication.grpc.OriginalPictureVideoFriendsTransmission getFriendsPictureVideoMessage();
  /**
   * <code>.com.lanjiu.im.communication.grpc.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
   */
  com.lanjiu.im.communication.grpc.OriginalPictureVideoFriendsTransmissionOrBuilder getFriendsPictureVideoMessageOrBuilder();

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
