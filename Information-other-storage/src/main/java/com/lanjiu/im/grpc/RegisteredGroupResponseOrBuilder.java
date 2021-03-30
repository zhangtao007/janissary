// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: information_other_storage_grpc.proto

package com.lanjiu.im.grpc;

public interface RegisteredGroupResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.im.grpc.RegisteredGroupResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string status_detail = 1;</code>
   * @return The statusDetail.
   */
  java.lang.String getStatusDetail();
  /**
   * <code>string status_detail = 1;</code>
   * @return The bytes for statusDetail.
   */
  com.google.protobuf.ByteString
      getStatusDetailBytes();

  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcRegisteredGroup response_registered_group = 2;</code>
   */
  java.util.List<com.lanjiu.im.grpc.RpcRegisteredGroup> 
      getResponseRegisteredGroupList();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcRegisteredGroup response_registered_group = 2;</code>
   */
  com.lanjiu.im.grpc.RpcRegisteredGroup getResponseRegisteredGroup(int index);
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcRegisteredGroup response_registered_group = 2;</code>
   */
  int getResponseRegisteredGroupCount();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcRegisteredGroup response_registered_group = 2;</code>
   */
  java.util.List<? extends com.lanjiu.im.grpc.RpcRegisteredGroupOrBuilder> 
      getResponseRegisteredGroupOrBuilderList();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcRegisteredGroup response_registered_group = 2;</code>
   */
  com.lanjiu.im.grpc.RpcRegisteredGroupOrBuilder getResponseRegisteredGroupOrBuilder(
      int index);

  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGuestGroup response_guest_group = 3;</code>
   */
  java.util.List<com.lanjiu.im.grpc.RpcGuestGroup> 
      getResponseGuestGroupList();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGuestGroup response_guest_group = 3;</code>
   */
  com.lanjiu.im.grpc.RpcGuestGroup getResponseGuestGroup(int index);
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGuestGroup response_guest_group = 3;</code>
   */
  int getResponseGuestGroupCount();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGuestGroup response_guest_group = 3;</code>
   */
  java.util.List<? extends com.lanjiu.im.grpc.RpcGuestGroupOrBuilder> 
      getResponseGuestGroupOrBuilderList();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGuestGroup response_guest_group = 3;</code>
   */
  com.lanjiu.im.grpc.RpcGuestGroupOrBuilder getResponseGuestGroupOrBuilder(
      int index);

  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcRegisteredGroupMember response_registered_group_member = 4;</code>
   */
  java.util.List<com.lanjiu.im.grpc.RpcRegisteredGroupMember> 
      getResponseRegisteredGroupMemberList();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcRegisteredGroupMember response_registered_group_member = 4;</code>
   */
  com.lanjiu.im.grpc.RpcRegisteredGroupMember getResponseRegisteredGroupMember(int index);
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcRegisteredGroupMember response_registered_group_member = 4;</code>
   */
  int getResponseRegisteredGroupMemberCount();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcRegisteredGroupMember response_registered_group_member = 4;</code>
   */
  java.util.List<? extends com.lanjiu.im.grpc.RpcRegisteredGroupMemberOrBuilder> 
      getResponseRegisteredGroupMemberOrBuilderList();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcRegisteredGroupMember response_registered_group_member = 4;</code>
   */
  com.lanjiu.im.grpc.RpcRegisteredGroupMemberOrBuilder getResponseRegisteredGroupMemberOrBuilder(
      int index);

  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGuestGroupMember response_guest_group_member = 5;</code>
   */
  java.util.List<com.lanjiu.im.grpc.RpcGuestGroupMember> 
      getResponseGuestGroupMemberList();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGuestGroupMember response_guest_group_member = 5;</code>
   */
  com.lanjiu.im.grpc.RpcGuestGroupMember getResponseGuestGroupMember(int index);
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGuestGroupMember response_guest_group_member = 5;</code>
   */
  int getResponseGuestGroupMemberCount();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGuestGroupMember response_guest_group_member = 5;</code>
   */
  java.util.List<? extends com.lanjiu.im.grpc.RpcGuestGroupMemberOrBuilder> 
      getResponseGuestGroupMemberOrBuilderList();
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGuestGroupMember response_guest_group_member = 5;</code>
   */
  com.lanjiu.im.grpc.RpcGuestGroupMemberOrBuilder getResponseGuestGroupMemberOrBuilder(
      int index);

  /**
   * <code>repeated .com.lanjiu.im.grpc.AllGroupMemberVO response_group_member_vo = 6;</code>
   */
  java.util.List<com.lanjiu.im.grpc.AllGroupMemberVO> 
      getResponseGroupMemberVoList();
  /**
   * <code>repeated .com.lanjiu.im.grpc.AllGroupMemberVO response_group_member_vo = 6;</code>
   */
  com.lanjiu.im.grpc.AllGroupMemberVO getResponseGroupMemberVo(int index);
  /**
   * <code>repeated .com.lanjiu.im.grpc.AllGroupMemberVO response_group_member_vo = 6;</code>
   */
  int getResponseGroupMemberVoCount();
  /**
   * <code>repeated .com.lanjiu.im.grpc.AllGroupMemberVO response_group_member_vo = 6;</code>
   */
  java.util.List<? extends com.lanjiu.im.grpc.AllGroupMemberVOOrBuilder> 
      getResponseGroupMemberVoOrBuilderList();
  /**
   * <code>repeated .com.lanjiu.im.grpc.AllGroupMemberVO response_group_member_vo = 6;</code>
   */
  com.lanjiu.im.grpc.AllGroupMemberVOOrBuilder getResponseGroupMemberVoOrBuilder(
      int index);
}
