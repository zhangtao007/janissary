// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: file_transfer_storage_grpc.proto

package com.lanjiu.pro.fileStorage;

public interface GroupTransmissionRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.pro.fileStorage.GroupTransmissionRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.lanjiu.pro.fileStorage.OriginalPictureVideoGroupTransmission Group_picture_video_message = 1;</code>
   * @return Whether the groupPictureVideoMessage field is set.
   */
  boolean hasGroupPictureVideoMessage();
  /**
   * <code>.com.lanjiu.pro.fileStorage.OriginalPictureVideoGroupTransmission Group_picture_video_message = 1;</code>
   * @return The groupPictureVideoMessage.
   */
  com.lanjiu.pro.fileStorage.OriginalPictureVideoGroupTransmission getGroupPictureVideoMessage();
  /**
   * <code>.com.lanjiu.pro.fileStorage.OriginalPictureVideoGroupTransmission Group_picture_video_message = 1;</code>
   */
  com.lanjiu.pro.fileStorage.OriginalPictureVideoGroupTransmissionOrBuilder getGroupPictureVideoMessageOrBuilder();

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
