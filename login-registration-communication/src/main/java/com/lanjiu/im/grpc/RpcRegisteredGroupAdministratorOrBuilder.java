// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: information_other_storage_grpc.proto

package com.lanjiu.im.grpc;

public interface RpcRegisteredGroupAdministratorOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.im.grpc.RpcRegisteredGroupAdministrator)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 administrator_id = 1;</code>
   * @return The administratorId.
   */
  int getAdministratorId();

  /**
   * <code>string administrator_type = 2;</code>
   * @return The administratorType.
   */
  java.lang.String getAdministratorType();
  /**
   * <code>string administrator_type = 2;</code>
   * @return The bytes for administratorType.
   */
  com.google.protobuf.ByteString
      getAdministratorTypeBytes();

  /**
   * <code>string administrator_name = 3;</code>
   * @return The administratorName.
   */
  java.lang.String getAdministratorName();
  /**
   * <code>string administrator_name = 3;</code>
   * @return The bytes for administratorName.
   */
  com.google.protobuf.ByteString
      getAdministratorNameBytes();
}
