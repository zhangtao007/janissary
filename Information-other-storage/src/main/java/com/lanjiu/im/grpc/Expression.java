// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: information_other_storage_grpc.proto

package com.lanjiu.im.grpc;

/**
 * <pre>
 * 表情
 * </pre>
 *
 * Protobuf type {@code com.lanjiu.im.grpc.Expression}
 */
public  final class Expression extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.lanjiu.im.grpc.Expression)
    ExpressionOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Expression.newBuilder() to construct.
  private Expression(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Expression() {
    expressionId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Expression();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Expression(
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

            expressionId_ = s;
            break;
          }
          case 18: {
            com.lanjiu.im.grpc.Friends.Builder subBuilder = null;
            if (friends_ != null) {
              subBuilder = friends_.toBuilder();
            }
            friends_ = input.readMessage(com.lanjiu.im.grpc.Friends.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(friends_);
              friends_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            com.lanjiu.im.grpc.GroupMember.Builder subBuilder = null;
            if (groupMember_ != null) {
              subBuilder = groupMember_.toBuilder();
            }
            groupMember_ = input.readMessage(com.lanjiu.im.grpc.GroupMember.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(groupMember_);
              groupMember_ = subBuilder.buildPartial();
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
    return com.lanjiu.im.grpc.FileStorageProto.internal_static_com_lanjiu_im_grpc_Expression_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.lanjiu.im.grpc.FileStorageProto.internal_static_com_lanjiu_im_grpc_Expression_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.lanjiu.im.grpc.Expression.class, com.lanjiu.im.grpc.Expression.Builder.class);
  }

  public static final int EXPRESSION_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object expressionId_;
  /**
   * <pre>
   * 文件大小
   * </pre>
   *
   * <code>string expression_id = 1;</code>
   * @return The expressionId.
   */
  public java.lang.String getExpressionId() {
    java.lang.Object ref = expressionId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      expressionId_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * 文件大小
   * </pre>
   *
   * <code>string expression_id = 1;</code>
   * @return The bytes for expressionId.
   */
  public com.google.protobuf.ByteString
      getExpressionIdBytes() {
    java.lang.Object ref = expressionId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      expressionId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int FRIENDS_FIELD_NUMBER = 2;
  private com.lanjiu.im.grpc.Friends friends_;
  /**
   * <pre>
   *好友结构体
   * </pre>
   *
   * <code>.com.lanjiu.im.grpc.Friends friends = 2;</code>
   * @return Whether the friends field is set.
   */
  public boolean hasFriends() {
    return friends_ != null;
  }
  /**
   * <pre>
   *好友结构体
   * </pre>
   *
   * <code>.com.lanjiu.im.grpc.Friends friends = 2;</code>
   * @return The friends.
   */
  public com.lanjiu.im.grpc.Friends getFriends() {
    return friends_ == null ? com.lanjiu.im.grpc.Friends.getDefaultInstance() : friends_;
  }
  /**
   * <pre>
   *好友结构体
   * </pre>
   *
   * <code>.com.lanjiu.im.grpc.Friends friends = 2;</code>
   */
  public com.lanjiu.im.grpc.FriendsOrBuilder getFriendsOrBuilder() {
    return getFriends();
  }

  public static final int GROUPMEMBER_FIELD_NUMBER = 3;
  private com.lanjiu.im.grpc.GroupMember groupMember_;
  /**
   * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 3;</code>
   * @return Whether the groupMember field is set.
   */
  public boolean hasGroupMember() {
    return groupMember_ != null;
  }
  /**
   * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 3;</code>
   * @return The groupMember.
   */
  public com.lanjiu.im.grpc.GroupMember getGroupMember() {
    return groupMember_ == null ? com.lanjiu.im.grpc.GroupMember.getDefaultInstance() : groupMember_;
  }
  /**
   * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 3;</code>
   */
  public com.lanjiu.im.grpc.GroupMemberOrBuilder getGroupMemberOrBuilder() {
    return getGroupMember();
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
    if (!getExpressionIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, expressionId_);
    }
    if (friends_ != null) {
      output.writeMessage(2, getFriends());
    }
    if (groupMember_ != null) {
      output.writeMessage(3, getGroupMember());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getExpressionIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, expressionId_);
    }
    if (friends_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getFriends());
    }
    if (groupMember_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getGroupMember());
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
    if (!(obj instanceof com.lanjiu.im.grpc.Expression)) {
      return super.equals(obj);
    }
    com.lanjiu.im.grpc.Expression other = (com.lanjiu.im.grpc.Expression) obj;

    if (!getExpressionId()
        .equals(other.getExpressionId())) return false;
    if (hasFriends() != other.hasFriends()) return false;
    if (hasFriends()) {
      if (!getFriends()
          .equals(other.getFriends())) return false;
    }
    if (hasGroupMember() != other.hasGroupMember()) return false;
    if (hasGroupMember()) {
      if (!getGroupMember()
          .equals(other.getGroupMember())) return false;
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
    hash = (37 * hash) + EXPRESSION_ID_FIELD_NUMBER;
    hash = (53 * hash) + getExpressionId().hashCode();
    if (hasFriends()) {
      hash = (37 * hash) + FRIENDS_FIELD_NUMBER;
      hash = (53 * hash) + getFriends().hashCode();
    }
    if (hasGroupMember()) {
      hash = (37 * hash) + GROUPMEMBER_FIELD_NUMBER;
      hash = (53 * hash) + getGroupMember().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.lanjiu.im.grpc.Expression parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.Expression parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.Expression parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.Expression parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.Expression parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.Expression parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.Expression parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.Expression parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.Expression parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.Expression parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.Expression parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.Expression parseFrom(
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
  public static Builder newBuilder(com.lanjiu.im.grpc.Expression prototype) {
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
   * <pre>
   * 表情
   * </pre>
   *
   * Protobuf type {@code com.lanjiu.im.grpc.Expression}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.lanjiu.im.grpc.Expression)
      com.lanjiu.im.grpc.ExpressionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.lanjiu.im.grpc.FileStorageProto.internal_static_com_lanjiu_im_grpc_Expression_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.lanjiu.im.grpc.FileStorageProto.internal_static_com_lanjiu_im_grpc_Expression_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.lanjiu.im.grpc.Expression.class, com.lanjiu.im.grpc.Expression.Builder.class);
    }

    // Construct using com.lanjiu.im.grpc.Expression.newBuilder()
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
      expressionId_ = "";

      if (friendsBuilder_ == null) {
        friends_ = null;
      } else {
        friends_ = null;
        friendsBuilder_ = null;
      }
      if (groupMemberBuilder_ == null) {
        groupMember_ = null;
      } else {
        groupMember_ = null;
        groupMemberBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.lanjiu.im.grpc.FileStorageProto.internal_static_com_lanjiu_im_grpc_Expression_descriptor;
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.Expression getDefaultInstanceForType() {
      return com.lanjiu.im.grpc.Expression.getDefaultInstance();
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.Expression build() {
      com.lanjiu.im.grpc.Expression result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.Expression buildPartial() {
      com.lanjiu.im.grpc.Expression result = new com.lanjiu.im.grpc.Expression(this);
      result.expressionId_ = expressionId_;
      if (friendsBuilder_ == null) {
        result.friends_ = friends_;
      } else {
        result.friends_ = friendsBuilder_.build();
      }
      if (groupMemberBuilder_ == null) {
        result.groupMember_ = groupMember_;
      } else {
        result.groupMember_ = groupMemberBuilder_.build();
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
      if (other instanceof com.lanjiu.im.grpc.Expression) {
        return mergeFrom((com.lanjiu.im.grpc.Expression)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.lanjiu.im.grpc.Expression other) {
      if (other == com.lanjiu.im.grpc.Expression.getDefaultInstance()) return this;
      if (!other.getExpressionId().isEmpty()) {
        expressionId_ = other.expressionId_;
        onChanged();
      }
      if (other.hasFriends()) {
        mergeFriends(other.getFriends());
      }
      if (other.hasGroupMember()) {
        mergeGroupMember(other.getGroupMember());
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
      com.lanjiu.im.grpc.Expression parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.lanjiu.im.grpc.Expression) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object expressionId_ = "";
    /**
     * <pre>
     * 文件大小
     * </pre>
     *
     * <code>string expression_id = 1;</code>
     * @return The expressionId.
     */
    public java.lang.String getExpressionId() {
      java.lang.Object ref = expressionId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        expressionId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * 文件大小
     * </pre>
     *
     * <code>string expression_id = 1;</code>
     * @return The bytes for expressionId.
     */
    public com.google.protobuf.ByteString
        getExpressionIdBytes() {
      java.lang.Object ref = expressionId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        expressionId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * 文件大小
     * </pre>
     *
     * <code>string expression_id = 1;</code>
     * @param value The expressionId to set.
     * @return This builder for chaining.
     */
    public Builder setExpressionId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      expressionId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 文件大小
     * </pre>
     *
     * <code>string expression_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearExpressionId() {
      
      expressionId_ = getDefaultInstance().getExpressionId();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 文件大小
     * </pre>
     *
     * <code>string expression_id = 1;</code>
     * @param value The bytes for expressionId to set.
     * @return This builder for chaining.
     */
    public Builder setExpressionIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      expressionId_ = value;
      onChanged();
      return this;
    }

    private com.lanjiu.im.grpc.Friends friends_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.lanjiu.im.grpc.Friends, com.lanjiu.im.grpc.Friends.Builder, com.lanjiu.im.grpc.FriendsOrBuilder> friendsBuilder_;
    /**
     * <pre>
     *好友结构体
     * </pre>
     *
     * <code>.com.lanjiu.im.grpc.Friends friends = 2;</code>
     * @return Whether the friends field is set.
     */
    public boolean hasFriends() {
      return friendsBuilder_ != null || friends_ != null;
    }
    /**
     * <pre>
     *好友结构体
     * </pre>
     *
     * <code>.com.lanjiu.im.grpc.Friends friends = 2;</code>
     * @return The friends.
     */
    public com.lanjiu.im.grpc.Friends getFriends() {
      if (friendsBuilder_ == null) {
        return friends_ == null ? com.lanjiu.im.grpc.Friends.getDefaultInstance() : friends_;
      } else {
        return friendsBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     *好友结构体
     * </pre>
     *
     * <code>.com.lanjiu.im.grpc.Friends friends = 2;</code>
     */
    public Builder setFriends(com.lanjiu.im.grpc.Friends value) {
      if (friendsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        friends_ = value;
        onChanged();
      } else {
        friendsBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     *好友结构体
     * </pre>
     *
     * <code>.com.lanjiu.im.grpc.Friends friends = 2;</code>
     */
    public Builder setFriends(
        com.lanjiu.im.grpc.Friends.Builder builderForValue) {
      if (friendsBuilder_ == null) {
        friends_ = builderForValue.build();
        onChanged();
      } else {
        friendsBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     *好友结构体
     * </pre>
     *
     * <code>.com.lanjiu.im.grpc.Friends friends = 2;</code>
     */
    public Builder mergeFriends(com.lanjiu.im.grpc.Friends value) {
      if (friendsBuilder_ == null) {
        if (friends_ != null) {
          friends_ =
            com.lanjiu.im.grpc.Friends.newBuilder(friends_).mergeFrom(value).buildPartial();
        } else {
          friends_ = value;
        }
        onChanged();
      } else {
        friendsBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     *好友结构体
     * </pre>
     *
     * <code>.com.lanjiu.im.grpc.Friends friends = 2;</code>
     */
    public Builder clearFriends() {
      if (friendsBuilder_ == null) {
        friends_ = null;
        onChanged();
      } else {
        friends_ = null;
        friendsBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     *好友结构体
     * </pre>
     *
     * <code>.com.lanjiu.im.grpc.Friends friends = 2;</code>
     */
    public com.lanjiu.im.grpc.Friends.Builder getFriendsBuilder() {
      
      onChanged();
      return getFriendsFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     *好友结构体
     * </pre>
     *
     * <code>.com.lanjiu.im.grpc.Friends friends = 2;</code>
     */
    public com.lanjiu.im.grpc.FriendsOrBuilder getFriendsOrBuilder() {
      if (friendsBuilder_ != null) {
        return friendsBuilder_.getMessageOrBuilder();
      } else {
        return friends_ == null ?
            com.lanjiu.im.grpc.Friends.getDefaultInstance() : friends_;
      }
    }
    /**
     * <pre>
     *好友结构体
     * </pre>
     *
     * <code>.com.lanjiu.im.grpc.Friends friends = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.lanjiu.im.grpc.Friends, com.lanjiu.im.grpc.Friends.Builder, com.lanjiu.im.grpc.FriendsOrBuilder> 
        getFriendsFieldBuilder() {
      if (friendsBuilder_ == null) {
        friendsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.lanjiu.im.grpc.Friends, com.lanjiu.im.grpc.Friends.Builder, com.lanjiu.im.grpc.FriendsOrBuilder>(
                getFriends(),
                getParentForChildren(),
                isClean());
        friends_ = null;
      }
      return friendsBuilder_;
    }

    private com.lanjiu.im.grpc.GroupMember groupMember_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.lanjiu.im.grpc.GroupMember, com.lanjiu.im.grpc.GroupMember.Builder, com.lanjiu.im.grpc.GroupMemberOrBuilder> groupMemberBuilder_;
    /**
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 3;</code>
     * @return Whether the groupMember field is set.
     */
    public boolean hasGroupMember() {
      return groupMemberBuilder_ != null || groupMember_ != null;
    }
    /**
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 3;</code>
     * @return The groupMember.
     */
    public com.lanjiu.im.grpc.GroupMember getGroupMember() {
      if (groupMemberBuilder_ == null) {
        return groupMember_ == null ? com.lanjiu.im.grpc.GroupMember.getDefaultInstance() : groupMember_;
      } else {
        return groupMemberBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 3;</code>
     */
    public Builder setGroupMember(com.lanjiu.im.grpc.GroupMember value) {
      if (groupMemberBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        groupMember_ = value;
        onChanged();
      } else {
        groupMemberBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 3;</code>
     */
    public Builder setGroupMember(
        com.lanjiu.im.grpc.GroupMember.Builder builderForValue) {
      if (groupMemberBuilder_ == null) {
        groupMember_ = builderForValue.build();
        onChanged();
      } else {
        groupMemberBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 3;</code>
     */
    public Builder mergeGroupMember(com.lanjiu.im.grpc.GroupMember value) {
      if (groupMemberBuilder_ == null) {
        if (groupMember_ != null) {
          groupMember_ =
            com.lanjiu.im.grpc.GroupMember.newBuilder(groupMember_).mergeFrom(value).buildPartial();
        } else {
          groupMember_ = value;
        }
        onChanged();
      } else {
        groupMemberBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 3;</code>
     */
    public Builder clearGroupMember() {
      if (groupMemberBuilder_ == null) {
        groupMember_ = null;
        onChanged();
      } else {
        groupMember_ = null;
        groupMemberBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 3;</code>
     */
    public com.lanjiu.im.grpc.GroupMember.Builder getGroupMemberBuilder() {
      
      onChanged();
      return getGroupMemberFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 3;</code>
     */
    public com.lanjiu.im.grpc.GroupMemberOrBuilder getGroupMemberOrBuilder() {
      if (groupMemberBuilder_ != null) {
        return groupMemberBuilder_.getMessageOrBuilder();
      } else {
        return groupMember_ == null ?
            com.lanjiu.im.grpc.GroupMember.getDefaultInstance() : groupMember_;
      }
    }
    /**
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.lanjiu.im.grpc.GroupMember, com.lanjiu.im.grpc.GroupMember.Builder, com.lanjiu.im.grpc.GroupMemberOrBuilder> 
        getGroupMemberFieldBuilder() {
      if (groupMemberBuilder_ == null) {
        groupMemberBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.lanjiu.im.grpc.GroupMember, com.lanjiu.im.grpc.GroupMember.Builder, com.lanjiu.im.grpc.GroupMemberOrBuilder>(
                getGroupMember(),
                getParentForChildren(),
                isClean());
        groupMember_ = null;
      }
      return groupMemberBuilder_;
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


    // @@protoc_insertion_point(builder_scope:com.lanjiu.im.grpc.Expression)
  }

  // @@protoc_insertion_point(class_scope:com.lanjiu.im.grpc.Expression)
  private static final com.lanjiu.im.grpc.Expression DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.lanjiu.im.grpc.Expression();
  }

  public static com.lanjiu.im.grpc.Expression getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Expression>
      PARSER = new com.google.protobuf.AbstractParser<Expression>() {
    @java.lang.Override
    public Expression parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Expression(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Expression> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Expression> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.lanjiu.im.grpc.Expression getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

