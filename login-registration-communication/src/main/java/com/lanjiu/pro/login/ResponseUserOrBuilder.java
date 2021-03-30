// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: login_regist_storage.proto

package com.lanjiu.pro.login;

public interface ResponseUserOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.lanjiu.pro.login.ResponseUser)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *返回成功或失败
   * </pre>
   *
   * <code>string ret = 1;</code>
   * @return The ret.
   */
  java.lang.String getRet();
  /**
   * <pre>
   *返回成功或失败
   * </pre>
   *
   * <code>string ret = 1;</code>
   * @return The bytes for ret.
   */
  com.google.protobuf.ByteString
      getRetBytes();

  /**
   * <pre>
   *返回信息
   * </pre>
   *
   * <code>string result = 2;</code>
   * @return The result.
   */
  java.lang.String getResult();
  /**
   * <pre>
   *返回信息
   * </pre>
   *
   * <code>string result = 2;</code>
   * @return The bytes for result.
   */
  com.google.protobuf.ByteString
      getResultBytes();

  /**
   * <code>repeated .com.lanjiu.pro.login.RegisterUser registerUser = 3;</code>
   */
  java.util.List<com.lanjiu.pro.login.RegisterUser> 
      getRegisterUserList();
  /**
   * <code>repeated .com.lanjiu.pro.login.RegisterUser registerUser = 3;</code>
   */
  com.lanjiu.pro.login.RegisterUser getRegisterUser(int index);
  /**
   * <code>repeated .com.lanjiu.pro.login.RegisterUser registerUser = 3;</code>
   */
  int getRegisterUserCount();
  /**
   * <code>repeated .com.lanjiu.pro.login.RegisterUser registerUser = 3;</code>
   */
  java.util.List<? extends com.lanjiu.pro.login.RegisterUserOrBuilder> 
      getRegisterUserOrBuilderList();
  /**
   * <code>repeated .com.lanjiu.pro.login.RegisterUser registerUser = 3;</code>
   */
  com.lanjiu.pro.login.RegisterUserOrBuilder getRegisterUserOrBuilder(
      int index);

  /**
   * <code>repeated .com.lanjiu.pro.login.GuestUser guestUser = 4;</code>
   */
  java.util.List<com.lanjiu.pro.login.GuestUser> 
      getGuestUserList();
  /**
   * <code>repeated .com.lanjiu.pro.login.GuestUser guestUser = 4;</code>
   */
  com.lanjiu.pro.login.GuestUser getGuestUser(int index);
  /**
   * <code>repeated .com.lanjiu.pro.login.GuestUser guestUser = 4;</code>
   */
  int getGuestUserCount();
  /**
   * <code>repeated .com.lanjiu.pro.login.GuestUser guestUser = 4;</code>
   */
  java.util.List<? extends com.lanjiu.pro.login.GuestUserOrBuilder> 
      getGuestUserOrBuilderList();
  /**
   * <code>repeated .com.lanjiu.pro.login.GuestUser guestUser = 4;</code>
   */
  com.lanjiu.pro.login.GuestUserOrBuilder getGuestUserOrBuilder(
      int index);

  /**
   * <code>string userType = 5;</code>
   * @return The userType.
   */
  java.lang.String getUserType();
  /**
   * <code>string userType = 5;</code>
   * @return The bytes for userType.
   */
  com.google.protobuf.ByteString
      getUserTypeBytes();
}
