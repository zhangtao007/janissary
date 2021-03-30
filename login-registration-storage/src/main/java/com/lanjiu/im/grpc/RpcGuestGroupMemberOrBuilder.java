// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: information_other_storage_grpc.proto

package com.lanjiu.im.grpc;

public interface RpcGuestGroupMemberOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.im.grpc.RpcGuestGroupMember)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 group_member_id = 1;</code>
   * @return The groupMemberId.
   */
  int getGroupMemberId();

  /**
   * <code>int32 guest_user_id = 2;</code>
   * @return The guestUserId.
   */
  int getGuestUserId();

  /**
   * <code>string group_remarks = 3;</code>
   * @return The groupRemarks.
   */
  java.lang.String getGroupRemarks();
  /**
   * <code>string group_remarks = 3;</code>
   * @return The bytes for groupRemarks.
   */
  com.google.protobuf.ByteString
      getGroupRemarksBytes();

  /**
   * <code>string group_owner = 4;</code>
   * @return The groupOwner.
   */
  java.lang.String getGroupOwner();
  /**
   * <code>string group_owner = 4;</code>
   * @return The bytes for groupOwner.
   */
  com.google.protobuf.ByteString
      getGroupOwnerBytes();

  /**
   * <code>string burn_after_reading_settings = 5;</code>
   * @return The burnAfterReadingSettings.
   */
  java.lang.String getBurnAfterReadingSettings();
  /**
   * <code>string burn_after_reading_settings = 5;</code>
   * @return The bytes for burnAfterReadingSettings.
   */
  com.google.protobuf.ByteString
      getBurnAfterReadingSettingsBytes();

  /**
   * <code>string burn_after_reading_time_unit = 6;</code>
   * @return The burnAfterReadingTimeUnit.
   */
  java.lang.String getBurnAfterReadingTimeUnit();
  /**
   * <code>string burn_after_reading_time_unit = 6;</code>
   * @return The bytes for burnAfterReadingTimeUnit.
   */
  com.google.protobuf.ByteString
      getBurnAfterReadingTimeUnitBytes();

  /**
   * <code>float burn_after_reading_time_length = 7;</code>
   * @return The burnAfterReadingTimeLength.
   */
  float getBurnAfterReadingTimeLength();

  /**
   * <code>int64 group_entry_time = 8;</code>
   * @return The groupEntryTime.
   */
  long getGroupEntryTime();

  /**
   * <code>string offline_message_setting = 9;</code>
   * @return The offlineMessageSetting.
   */
  java.lang.String getOfflineMessageSetting();
  /**
   * <code>string offline_message_setting = 9;</code>
   * @return The bytes for offlineMessageSetting.
   */
  com.google.protobuf.ByteString
      getOfflineMessageSettingBytes();
}
