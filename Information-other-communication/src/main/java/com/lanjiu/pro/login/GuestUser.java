// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: login_regist_storage.proto

package com.lanjiu.pro.login;

/**
 * Protobuf type {@code com.lanjiu.pro.login.GuestUser}
 */
public  final class GuestUser extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.lanjiu.pro.login.GuestUser)
    GuestUserOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GuestUser.newBuilder() to construct.
  private GuestUser(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GuestUser() {
    userId_ = "";
    userAcount_ = "";
    password_ = "";
    createTime_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GuestUser();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GuestUser(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            userId_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            userAcount_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            password_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            createTime_ = s;
            break;
          }
          case 42: {
            com.lanjiu.pro.login.UserInfomation.Builder subBuilder = null;
            if (userInfomation_ != null) {
              subBuilder = userInfomation_.toBuilder();
            }
            userInfomation_ = input.readMessage(com.lanjiu.pro.login.UserInfomation.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(userInfomation_);
              userInfomation_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.lanjiu.pro.login.RegisterStorageProto.internal_static_com_lanjiu_pro_login_GuestUser_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.lanjiu.pro.login.RegisterStorageProto.internal_static_com_lanjiu_pro_login_GuestUser_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.lanjiu.pro.login.GuestUser.class, com.lanjiu.pro.login.GuestUser.Builder.class);
  }

  public static final int USER_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object userId_;
  /**
   * <code>string user_id = 1;</code>
   * @return The userId.
   */
  public java.lang.String getUserId() {
    java.lang.Object ref = userId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      userId_ = s;
      return s;
    }
  }
  /**
   * <code>string user_id = 1;</code>
   * @return The bytes for userId.
   */
  public com.google.protobuf.ByteString
      getUserIdBytes() {
    java.lang.Object ref = userId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      userId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int USER_ACOUNT_FIELD_NUMBER = 2;
  private volatile java.lang.Object userAcount_;
  /**
   * <pre>
   *游客无账号为空
   * </pre>
   *
   * <code>string user_acount = 2;</code>
   * @return The userAcount.
   */
  public java.lang.String getUserAcount() {
    java.lang.Object ref = userAcount_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      userAcount_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *游客无账号为空
   * </pre>
   *
   * <code>string user_acount = 2;</code>
   * @return The bytes for userAcount.
   */
  public com.google.protobuf.ByteString
      getUserAcountBytes() {
    java.lang.Object ref = userAcount_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      userAcount_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PASSWORD_FIELD_NUMBER = 3;
  private volatile java.lang.Object password_;
  /**
   * <pre>
   *游客无密码
   * </pre>
   *
   * <code>string password = 3;</code>
   * @return The password.
   */
  public java.lang.String getPassword() {
    java.lang.Object ref = password_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      password_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *游客无密码
   * </pre>
   *
   * <code>string password = 3;</code>
   * @return The bytes for password.
   */
  public com.google.protobuf.ByteString
      getPasswordBytes() {
    java.lang.Object ref = password_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      password_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CREATE_TIME_FIELD_NUMBER = 4;
  private volatile java.lang.Object createTime_;
  /**
   * <code>string create_time = 4;</code>
   * @return The createTime.
   */
  public java.lang.String getCreateTime() {
    java.lang.Object ref = createTime_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      createTime_ = s;
      return s;
    }
  }
  /**
   * <code>string create_time = 4;</code>
   * @return The bytes for createTime.
   */
  public com.google.protobuf.ByteString
      getCreateTimeBytes() {
    java.lang.Object ref = createTime_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      createTime_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int USERINFOMATION_FIELD_NUMBER = 5;
  private com.lanjiu.pro.login.UserInfomation userInfomation_;
  /**
   * <code>.com.lanjiu.pro.login.UserInfomation userInfomation = 5;</code>
   * @return Whether the userInfomation field is set.
   */
  public boolean hasUserInfomation() {
    return userInfomation_ != null;
  }
  /**
   * <code>.com.lanjiu.pro.login.UserInfomation userInfomation = 5;</code>
   * @return The userInfomation.
   */
  public com.lanjiu.pro.login.UserInfomation getUserInfomation() {
    return userInfomation_ == null ? com.lanjiu.pro.login.UserInfomation.getDefaultInstance() : userInfomation_;
  }
  /**
   * <code>.com.lanjiu.pro.login.UserInfomation userInfomation = 5;</code>
   */
  public com.lanjiu.pro.login.UserInfomationOrBuilder getUserInfomationOrBuilder() {
    return getUserInfomation();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getUserIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, userId_);
    }
    if (!getUserAcountBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, userAcount_);
    }
    if (!getPasswordBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, password_);
    }
    if (!getCreateTimeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, createTime_);
    }
    if (userInfomation_ != null) {
      output.writeMessage(5, getUserInfomation());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getUserIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, userId_);
    }
    if (!getUserAcountBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, userAcount_);
    }
    if (!getPasswordBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, password_);
    }
    if (!getCreateTimeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, createTime_);
    }
    if (userInfomation_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, getUserInfomation());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.lanjiu.pro.login.GuestUser)) {
      return super.equals(obj);
    }
    com.lanjiu.pro.login.GuestUser other = (com.lanjiu.pro.login.GuestUser) obj;

    if (!getUserId()
        .equals(other.getUserId())) return false;
    if (!getUserAcount()
        .equals(other.getUserAcount())) return false;
    if (!getPassword()
        .equals(other.getPassword())) return false;
    if (!getCreateTime()
        .equals(other.getCreateTime())) return false;
    if (hasUserInfomation() != other.hasUserInfomation()) return false;
    if (hasUserInfomation()) {
      if (!getUserInfomation()
          .equals(other.getUserInfomation())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + USER_ID_FIELD_NUMBER;
    hash = (53 * hash) + getUserId().hashCode();
    hash = (37 * hash) + USER_ACOUNT_FIELD_NUMBER;
    hash = (53 * hash) + getUserAcount().hashCode();
    hash = (37 * hash) + PASSWORD_FIELD_NUMBER;
    hash = (53 * hash) + getPassword().hashCode();
    hash = (37 * hash) + CREATE_TIME_FIELD_NUMBER;
    hash = (53 * hash) + getCreateTime().hashCode();
    if (hasUserInfomation()) {
      hash = (37 * hash) + USERINFOMATION_FIELD_NUMBER;
      hash = (53 * hash) + getUserInfomation().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.lanjiu.pro.login.GuestUser parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.pro.login.GuestUser parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.pro.login.GuestUser parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.pro.login.GuestUser parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.pro.login.GuestUser parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.pro.login.GuestUser parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.pro.login.GuestUser parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.pro.login.GuestUser parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.pro.login.GuestUser parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.lanjiu.pro.login.GuestUser parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.pro.login.GuestUser parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.pro.login.GuestUser parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.lanjiu.pro.login.GuestUser prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.lanjiu.pro.login.GuestUser}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.lanjiu.pro.login.GuestUser)
      com.lanjiu.pro.login.GuestUserOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.lanjiu.pro.login.RegisterStorageProto.internal_static_com_lanjiu_pro_login_GuestUser_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.lanjiu.pro.login.RegisterStorageProto.internal_static_com_lanjiu_pro_login_GuestUser_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.lanjiu.pro.login.GuestUser.class, com.lanjiu.pro.login.GuestUser.Builder.class);
    }

    // Construct using com.lanjiu.pro.login.GuestUser.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      userId_ = "";

      userAcount_ = "";

      password_ = "";

      createTime_ = "";

      if (userInfomationBuilder_ == null) {
        userInfomation_ = null;
      } else {
        userInfomation_ = null;
        userInfomationBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.lanjiu.pro.login.RegisterStorageProto.internal_static_com_lanjiu_pro_login_GuestUser_descriptor;
    }

    @java.lang.Override
    public com.lanjiu.pro.login.GuestUser getDefaultInstanceForType() {
      return com.lanjiu.pro.login.GuestUser.getDefaultInstance();
    }

    @java.lang.Override
    public com.lanjiu.pro.login.GuestUser build() {
      com.lanjiu.pro.login.GuestUser result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.lanjiu.pro.login.GuestUser buildPartial() {
      com.lanjiu.pro.login.GuestUser result = new com.lanjiu.pro.login.GuestUser(this);
      result.userId_ = userId_;
      result.userAcount_ = userAcount_;
      result.password_ = password_;
      result.createTime_ = createTime_;
      if (userInfomationBuilder_ == null) {
        result.userInfomation_ = userInfomation_;
      } else {
        result.userInfomation_ = userInfomationBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.lanjiu.pro.login.GuestUser) {
        return mergeFrom((com.lanjiu.pro.login.GuestUser)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.lanjiu.pro.login.GuestUser other) {
      if (other == com.lanjiu.pro.login.GuestUser.getDefaultInstance()) return this;
      if (!other.getUserId().isEmpty()) {
        userId_ = other.userId_;
        onChanged();
      }
      if (!other.getUserAcount().isEmpty()) {
        userAcount_ = other.userAcount_;
        onChanged();
      }
      if (!other.getPassword().isEmpty()) {
        password_ = other.password_;
        onChanged();
      }
      if (!other.getCreateTime().isEmpty()) {
        createTime_ = other.createTime_;
        onChanged();
      }
      if (other.hasUserInfomation()) {
        mergeUserInfomation(other.getUserInfomation());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.lanjiu.pro.login.GuestUser parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.lanjiu.pro.login.GuestUser) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object userId_ = "";
    /**
     * <code>string user_id = 1;</code>
     * @return The userId.
     */
    public java.lang.String getUserId() {
      java.lang.Object ref = userId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        userId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string user_id = 1;</code>
     * @return The bytes for userId.
     */
    public com.google.protobuf.ByteString
        getUserIdBytes() {
      java.lang.Object ref = userId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        userId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string user_id = 1;</code>
     * @param value The userId to set.
     * @return This builder for chaining.
     */
    public Builder setUserId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      userId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string user_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearUserId() {
      
      userId_ = getDefaultInstance().getUserId();
      onChanged();
      return this;
    }
    /**
     * <code>string user_id = 1;</code>
     * @param value The bytes for userId to set.
     * @return This builder for chaining.
     */
    public Builder setUserIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      userId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object userAcount_ = "";
    /**
     * <pre>
     *游客无账号为空
     * </pre>
     *
     * <code>string user_acount = 2;</code>
     * @return The userAcount.
     */
    public java.lang.String getUserAcount() {
      java.lang.Object ref = userAcount_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        userAcount_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *游客无账号为空
     * </pre>
     *
     * <code>string user_acount = 2;</code>
     * @return The bytes for userAcount.
     */
    public com.google.protobuf.ByteString
        getUserAcountBytes() {
      java.lang.Object ref = userAcount_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        userAcount_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *游客无账号为空
     * </pre>
     *
     * <code>string user_acount = 2;</code>
     * @param value The userAcount to set.
     * @return This builder for chaining.
     */
    public Builder setUserAcount(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      userAcount_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *游客无账号为空
     * </pre>
     *
     * <code>string user_acount = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearUserAcount() {
      
      userAcount_ = getDefaultInstance().getUserAcount();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *游客无账号为空
     * </pre>
     *
     * <code>string user_acount = 2;</code>
     * @param value The bytes for userAcount to set.
     * @return This builder for chaining.
     */
    public Builder setUserAcountBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      userAcount_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object password_ = "";
    /**
     * <pre>
     *游客无密码
     * </pre>
     *
     * <code>string password = 3;</code>
     * @return The password.
     */
    public java.lang.String getPassword() {
      java.lang.Object ref = password_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        password_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *游客无密码
     * </pre>
     *
     * <code>string password = 3;</code>
     * @return The bytes for password.
     */
    public com.google.protobuf.ByteString
        getPasswordBytes() {
      java.lang.Object ref = password_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        password_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *游客无密码
     * </pre>
     *
     * <code>string password = 3;</code>
     * @param value The password to set.
     * @return This builder for chaining.
     */
    public Builder setPassword(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      password_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *游客无密码
     * </pre>
     *
     * <code>string password = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearPassword() {
      
      password_ = getDefaultInstance().getPassword();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *游客无密码
     * </pre>
     *
     * <code>string password = 3;</code>
     * @param value The bytes for password to set.
     * @return This builder for chaining.
     */
    public Builder setPasswordBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      password_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object createTime_ = "";
    /**
     * <code>string create_time = 4;</code>
     * @return The createTime.
     */
    public java.lang.String getCreateTime() {
      java.lang.Object ref = createTime_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        createTime_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string create_time = 4;</code>
     * @return The bytes for createTime.
     */
    public com.google.protobuf.ByteString
        getCreateTimeBytes() {
      java.lang.Object ref = createTime_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        createTime_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string create_time = 4;</code>
     * @param value The createTime to set.
     * @return This builder for chaining.
     */
    public Builder setCreateTime(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      createTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string create_time = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearCreateTime() {
      
      createTime_ = getDefaultInstance().getCreateTime();
      onChanged();
      return this;
    }
    /**
     * <code>string create_time = 4;</code>
     * @param value The bytes for createTime to set.
     * @return This builder for chaining.
     */
    public Builder setCreateTimeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      createTime_ = value;
      onChanged();
      return this;
    }

    private com.lanjiu.pro.login.UserInfomation userInfomation_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.lanjiu.pro.login.UserInfomation, com.lanjiu.pro.login.UserInfomation.Builder, com.lanjiu.pro.login.UserInfomationOrBuilder> userInfomationBuilder_;
    /**
     * <code>.com.lanjiu.pro.login.UserInfomation userInfomation = 5;</code>
     * @return Whether the userInfomation field is set.
     */
    public boolean hasUserInfomation() {
      return userInfomationBuilder_ != null || userInfomation_ != null;
    }
    /**
     * <code>.com.lanjiu.pro.login.UserInfomation userInfomation = 5;</code>
     * @return The userInfomation.
     */
    public com.lanjiu.pro.login.UserInfomation getUserInfomation() {
      if (userInfomationBuilder_ == null) {
        return userInfomation_ == null ? com.lanjiu.pro.login.UserInfomation.getDefaultInstance() : userInfomation_;
      } else {
        return userInfomationBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.lanjiu.pro.login.UserInfomation userInfomation = 5;</code>
     */
    public Builder setUserInfomation(com.lanjiu.pro.login.UserInfomation value) {
      if (userInfomationBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        userInfomation_ = value;
        onChanged();
      } else {
        userInfomationBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.lanjiu.pro.login.UserInfomation userInfomation = 5;</code>
     */
    public Builder setUserInfomation(
        com.lanjiu.pro.login.UserInfomation.Builder builderForValue) {
      if (userInfomationBuilder_ == null) {
        userInfomation_ = builderForValue.build();
        onChanged();
      } else {
        userInfomationBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.lanjiu.pro.login.UserInfomation userInfomation = 5;</code>
     */
    public Builder mergeUserInfomation(com.lanjiu.pro.login.UserInfomation value) {
      if (userInfomationBuilder_ == null) {
        if (userInfomation_ != null) {
          userInfomation_ =
            com.lanjiu.pro.login.UserInfomation.newBuilder(userInfomation_).mergeFrom(value).buildPartial();
        } else {
          userInfomation_ = value;
        }
        onChanged();
      } else {
        userInfomationBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.lanjiu.pro.login.UserInfomation userInfomation = 5;</code>
     */
    public Builder clearUserInfomation() {
      if (userInfomationBuilder_ == null) {
        userInfomation_ = null;
        onChanged();
      } else {
        userInfomation_ = null;
        userInfomationBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.lanjiu.pro.login.UserInfomation userInfomation = 5;</code>
     */
    public com.lanjiu.pro.login.UserInfomation.Builder getUserInfomationBuilder() {
      
      onChanged();
      return getUserInfomationFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.lanjiu.pro.login.UserInfomation userInfomation = 5;</code>
     */
    public com.lanjiu.pro.login.UserInfomationOrBuilder getUserInfomationOrBuilder() {
      if (userInfomationBuilder_ != null) {
        return userInfomationBuilder_.getMessageOrBuilder();
      } else {
        return userInfomation_ == null ?
            com.lanjiu.pro.login.UserInfomation.getDefaultInstance() : userInfomation_;
      }
    }
    /**
     * <code>.com.lanjiu.pro.login.UserInfomation userInfomation = 5;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.lanjiu.pro.login.UserInfomation, com.lanjiu.pro.login.UserInfomation.Builder, com.lanjiu.pro.login.UserInfomationOrBuilder> 
        getUserInfomationFieldBuilder() {
      if (userInfomationBuilder_ == null) {
        userInfomationBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.lanjiu.pro.login.UserInfomation, com.lanjiu.pro.login.UserInfomation.Builder, com.lanjiu.pro.login.UserInfomationOrBuilder>(
                getUserInfomation(),
                getParentForChildren(),
                isClean());
        userInfomation_ = null;
      }
      return userInfomationBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.lanjiu.pro.login.GuestUser)
  }

  // @@protoc_insertion_point(class_scope:com.lanjiu.pro.login.GuestUser)
  private static final com.lanjiu.pro.login.GuestUser DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.lanjiu.pro.login.GuestUser();
  }

  public static com.lanjiu.pro.login.GuestUser getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GuestUser>
      PARSER = new com.google.protobuf.AbstractParser<GuestUser>() {
    @java.lang.Override
    public GuestUser parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GuestUser(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GuestUser> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GuestUser> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.lanjiu.pro.login.GuestUser getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

