// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: file_transfer_communication_grpc.proto

package com.lanjiu.pro.file;

public interface OriginalPictureVideoGroupTransmissionOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.pro.file.OriginalPictureVideoGroupTransmission)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *原始视频图片传输归属类型
   * </pre>
   *
   * <code>string user_type = 1;</code>
   * @return The userType.
   */
  java.lang.String getUserType();
  /**
   * <pre>
   *原始视频图片传输归属类型
   * </pre>
   *
   * <code>string user_type = 1;</code>
   * @return The bytes for userType.
   */
  com.google.protobuf.ByteString
      getUserTypeBytes();

  /**
   * <pre>
   *交互数据类型(图片/视频)Picture/视频
   * </pre>
   *
   * <code>string settings_type = 2;</code>
   * @return The settingsType.
   */
  java.lang.String getSettingsType();
  /**
   * <pre>
   *交互数据类型(图片/视频)Picture/视频
   * </pre>
   *
   * <code>string settings_type = 2;</code>
   * @return The bytes for settingsType.
   */
  com.google.protobuf.ByteString
      getSettingsTypeBytes();

  /**
   * <code>.com.lanjiu.pro.file.Picture picture = 3;</code>
   * @return Whether the picture field is set.
   */
  boolean hasPicture();
  /**
   * <code>.com.lanjiu.pro.file.Picture picture = 3;</code>
   * @return The picture.
   */
  com.lanjiu.pro.file.Picture getPicture();
  /**
   * <code>.com.lanjiu.pro.file.Picture picture = 3;</code>
   */
  com.lanjiu.pro.file.PictureOrBuilder getPictureOrBuilder();

  /**
   * <code>.com.lanjiu.pro.file.Video video = 4;</code>
   * @return Whether the video field is set.
   */
  boolean hasVideo();
  /**
   * <code>.com.lanjiu.pro.file.Video video = 4;</code>
   * @return The video.
   */
  com.lanjiu.pro.file.Video getVideo();
  /**
   * <code>.com.lanjiu.pro.file.Video video = 4;</code>
   */
  com.lanjiu.pro.file.VideoOrBuilder getVideoOrBuilder();

  /**
   * <code>.com.lanjiu.pro.file.FileContent file_content = 5;</code>
   * @return Whether the fileContent field is set.
   */
  boolean hasFileContent();
  /**
   * <code>.com.lanjiu.pro.file.FileContent file_content = 5;</code>
   * @return The fileContent.
   */
  com.lanjiu.pro.file.FileContent getFileContent();
  /**
   * <code>.com.lanjiu.pro.file.FileContent file_content = 5;</code>
   */
  com.lanjiu.pro.file.FileContentOrBuilder getFileContentOrBuilder();

  /**
   * <pre>
   *兼容群成员类型成员
   * </pre>
   *
   * <code>.com.lanjiu.pro.file.GroupMember GroupMember = 6;</code>
   * @return Whether the groupMember field is set.
   */
  boolean hasGroupMember();
  /**
   * <pre>
   *兼容群成员类型成员
   * </pre>
   *
   * <code>.com.lanjiu.pro.file.GroupMember GroupMember = 6;</code>
   * @return The groupMember.
   */
  com.lanjiu.pro.file.GroupMember getGroupMember();
  /**
   * <pre>
   *兼容群成员类型成员
   * </pre>
   *
   * <code>.com.lanjiu.pro.file.GroupMember GroupMember = 6;</code>
   */
  com.lanjiu.pro.file.GroupMemberOrBuilder getGroupMemberOrBuilder();

  /**
   * <pre>
   *兼容群类型成员
   * </pre>
   *
   * <code>.com.lanjiu.pro.file.Group group = 7;</code>
   * @return Whether the group field is set.
   */
  boolean hasGroup();
  /**
   * <pre>
   *兼容群类型成员
   * </pre>
   *
   * <code>.com.lanjiu.pro.file.Group group = 7;</code>
   * @return The group.
   */
  com.lanjiu.pro.file.Group getGroup();
  /**
   * <pre>
   *兼容群类型成员
   * </pre>
   *
   * <code>.com.lanjiu.pro.file.Group group = 7;</code>
   */
  com.lanjiu.pro.file.GroupOrBuilder getGroupOrBuilder();

  /**
   * <pre>
   *游客结构体(ID、昵称、头像)
   * </pre>
   *
   * <code>.com.lanjiu.pro.file.Tourists tourists = 8;</code>
   * @return Whether the tourists field is set.
   */
  boolean hasTourists();
  /**
   * <pre>
   *游客结构体(ID、昵称、头像)
   * </pre>
   *
   * <code>.com.lanjiu.pro.file.Tourists tourists = 8;</code>
   * @return The tourists.
   */
  com.lanjiu.pro.file.Tourists getTourists();
  /**
   * <pre>
   *游客结构体(ID、昵称、头像)
   * </pre>
   *
   * <code>.com.lanjiu.pro.file.Tourists tourists = 8;</code>
   */
  com.lanjiu.pro.file.TouristsOrBuilder getTouristsOrBuilder();

  /**
   * <pre>
   *注册用户结构体
   * </pre>
   *
   * <code>.com.lanjiu.pro.file.RegisteredUser registered_user = 9;</code>
   * @return Whether the registeredUser field is set.
   */
  boolean hasRegisteredUser();
  /**
   * <pre>
   *注册用户结构体
   * </pre>
   *
   * <code>.com.lanjiu.pro.file.RegisteredUser registered_user = 9;</code>
   * @return The registeredUser.
   */
  com.lanjiu.pro.file.RegisteredUser getRegisteredUser();
  /**
   * <pre>
   *注册用户结构体
   * </pre>
   *
   * <code>.com.lanjiu.pro.file.RegisteredUser registered_user = 9;</code>
   */
  com.lanjiu.pro.file.RegisteredUserOrBuilder getRegisteredUserOrBuilder();

  /**
   * <pre>
   *返回类型(成功/失败)详情
   * </pre>
   *
   * <code>string status_detail = 10;</code>
   * @return The statusDetail.
   */
  java.lang.String getStatusDetail();
  /**
   * <pre>
   *返回类型(成功/失败)详情
   * </pre>
   *
   * <code>string status_detail = 10;</code>
   * @return The bytes for statusDetail.
   */
  com.google.protobuf.ByteString
      getStatusDetailBytes();

  /**
   * <code>.com.lanjiu.pro.file.Head head = 11;</code>
   * @return Whether the head field is set.
   */
  boolean hasHead();
  /**
   * <code>.com.lanjiu.pro.file.Head head = 11;</code>
   * @return The head.
   */
  com.lanjiu.pro.file.Head getHead();
  /**
   * <code>.com.lanjiu.pro.file.Head head = 11;</code>
   */
  com.lanjiu.pro.file.HeadOrBuilder getHeadOrBuilder();
}
