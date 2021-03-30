// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: file_transfer_storage_grpc.proto

package com.lanjiu.pro.fileStorage;

/**
 * <pre>
 * 好友上传响应
 * </pre>
 *
 * Protobuf type {@code com.lanjiu.pro.fileStorage.FriendsTransmissionResponse}
 */
public  final class FriendsTransmissionResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.lanjiu.pro.fileStorage.FriendsTransmissionResponse)
    FriendsTransmissionResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FriendsTransmissionResponse.newBuilder() to construct.
  private FriendsTransmissionResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FriendsTransmissionResponse() {
    checksum_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FriendsTransmissionResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FriendsTransmissionResponse(
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
            com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission.Builder subBuilder = null;
            if (friendsPictureVideoMessage_ != null) {
              subBuilder = friendsPictureVideoMessage_.toBuilder();
            }
            friendsPictureVideoMessage_ = input.readMessage(com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(friendsPictureVideoMessage_);
              friendsPictureVideoMessage_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            checksum_ = s;
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
    return com.lanjiu.pro.fileStorage.FileStorageProto.internal_static_com_lanjiu_pro_fileStorage_FriendsTransmissionResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.lanjiu.pro.fileStorage.FileStorageProto.internal_static_com_lanjiu_pro_fileStorage_FriendsTransmissionResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.lanjiu.pro.fileStorage.FriendsTransmissionResponse.class, com.lanjiu.pro.fileStorage.FriendsTransmissionResponse.Builder.class);
  }

  public static final int FRIENDS_PICTURE_VIDEO_MESSAGE_FIELD_NUMBER = 1;
  private com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission friendsPictureVideoMessage_;
  /**
   * <code>.com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
   * @return Whether the friendsPictureVideoMessage field is set.
   */
  public boolean hasFriendsPictureVideoMessage() {
    return friendsPictureVideoMessage_ != null;
  }
  /**
   * <code>.com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
   * @return The friendsPictureVideoMessage.
   */
  public com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission getFriendsPictureVideoMessage() {
    return friendsPictureVideoMessage_ == null ? com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission.getDefaultInstance() : friendsPictureVideoMessage_;
  }
  /**
   * <code>.com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
   */
  public com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmissionOrBuilder getFriendsPictureVideoMessageOrBuilder() {
    return getFriendsPictureVideoMessage();
  }

  public static final int CHECKSUM_FIELD_NUMBER = 2;
  private volatile java.lang.Object checksum_;
  /**
   * <pre>
   *校验位
   * </pre>
   *
   * <code>string checksum = 2;</code>
   * @return The checksum.
   */
  public java.lang.String getChecksum() {
    java.lang.Object ref = checksum_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      checksum_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *校验位
   * </pre>
   *
   * <code>string checksum = 2;</code>
   * @return The bytes for checksum.
   */
  public com.google.protobuf.ByteString
      getChecksumBytes() {
    java.lang.Object ref = checksum_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      checksum_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (friendsPictureVideoMessage_ != null) {
      output.writeMessage(1, getFriendsPictureVideoMessage());
    }
    if (!getChecksumBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, checksum_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (friendsPictureVideoMessage_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getFriendsPictureVideoMessage());
    }
    if (!getChecksumBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, checksum_);
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
    if (!(obj instanceof com.lanjiu.pro.fileStorage.FriendsTransmissionResponse)) {
      return super.equals(obj);
    }
    com.lanjiu.pro.fileStorage.FriendsTransmissionResponse other = (com.lanjiu.pro.fileStorage.FriendsTransmissionResponse) obj;

    if (hasFriendsPictureVideoMessage() != other.hasFriendsPictureVideoMessage()) return false;
    if (hasFriendsPictureVideoMessage()) {
      if (!getFriendsPictureVideoMessage()
          .equals(other.getFriendsPictureVideoMessage())) return false;
    }
    if (!getChecksum()
        .equals(other.getChecksum())) return false;
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
    if (hasFriendsPictureVideoMessage()) {
      hash = (37 * hash) + FRIENDS_PICTURE_VIDEO_MESSAGE_FIELD_NUMBER;
      hash = (53 * hash) + getFriendsPictureVideoMessage().hashCode();
    }
    hash = (37 * hash) + CHECKSUM_FIELD_NUMBER;
    hash = (53 * hash) + getChecksum().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.lanjiu.pro.fileStorage.FriendsTransmissionResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.pro.fileStorage.FriendsTransmissionResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.pro.fileStorage.FriendsTransmissionResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.pro.fileStorage.FriendsTransmissionResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.pro.fileStorage.FriendsTransmissionResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.pro.fileStorage.FriendsTransmissionResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.pro.fileStorage.FriendsTransmissionResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.pro.fileStorage.FriendsTransmissionResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.pro.fileStorage.FriendsTransmissionResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.lanjiu.pro.fileStorage.FriendsTransmissionResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.pro.fileStorage.FriendsTransmissionResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.pro.fileStorage.FriendsTransmissionResponse parseFrom(
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
  public static Builder newBuilder(com.lanjiu.pro.fileStorage.FriendsTransmissionResponse prototype) {
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
   * 好友上传响应
   * </pre>
   *
   * Protobuf type {@code com.lanjiu.pro.fileStorage.FriendsTransmissionResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.lanjiu.pro.fileStorage.FriendsTransmissionResponse)
      com.lanjiu.pro.fileStorage.FriendsTransmissionResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.lanjiu.pro.fileStorage.FileStorageProto.internal_static_com_lanjiu_pro_fileStorage_FriendsTransmissionResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.lanjiu.pro.fileStorage.FileStorageProto.internal_static_com_lanjiu_pro_fileStorage_FriendsTransmissionResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.lanjiu.pro.fileStorage.FriendsTransmissionResponse.class, com.lanjiu.pro.fileStorage.FriendsTransmissionResponse.Builder.class);
    }

    // Construct using com.lanjiu.pro.fileStorage.FriendsTransmissionResponse.newBuilder()
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
      if (friendsPictureVideoMessageBuilder_ == null) {
        friendsPictureVideoMessage_ = null;
      } else {
        friendsPictureVideoMessage_ = null;
        friendsPictureVideoMessageBuilder_ = null;
      }
      checksum_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.lanjiu.pro.fileStorage.FileStorageProto.internal_static_com_lanjiu_pro_fileStorage_FriendsTransmissionResponse_descriptor;
    }

    @java.lang.Override
    public com.lanjiu.pro.fileStorage.FriendsTransmissionResponse getDefaultInstanceForType() {
      return com.lanjiu.pro.fileStorage.FriendsTransmissionResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.lanjiu.pro.fileStorage.FriendsTransmissionResponse build() {
      com.lanjiu.pro.fileStorage.FriendsTransmissionResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.lanjiu.pro.fileStorage.FriendsTransmissionResponse buildPartial() {
      com.lanjiu.pro.fileStorage.FriendsTransmissionResponse result = new com.lanjiu.pro.fileStorage.FriendsTransmissionResponse(this);
      if (friendsPictureVideoMessageBuilder_ == null) {
        result.friendsPictureVideoMessage_ = friendsPictureVideoMessage_;
      } else {
        result.friendsPictureVideoMessage_ = friendsPictureVideoMessageBuilder_.build();
      }
      result.checksum_ = checksum_;
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
      if (other instanceof com.lanjiu.pro.fileStorage.FriendsTransmissionResponse) {
        return mergeFrom((com.lanjiu.pro.fileStorage.FriendsTransmissionResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.lanjiu.pro.fileStorage.FriendsTransmissionResponse other) {
      if (other == com.lanjiu.pro.fileStorage.FriendsTransmissionResponse.getDefaultInstance()) return this;
      if (other.hasFriendsPictureVideoMessage()) {
        mergeFriendsPictureVideoMessage(other.getFriendsPictureVideoMessage());
      }
      if (!other.getChecksum().isEmpty()) {
        checksum_ = other.checksum_;
        onChanged();
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
      com.lanjiu.pro.fileStorage.FriendsTransmissionResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.lanjiu.pro.fileStorage.FriendsTransmissionResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission friendsPictureVideoMessage_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission, com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission.Builder, com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmissionOrBuilder> friendsPictureVideoMessageBuilder_;
    /**
     * <code>.com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
     * @return Whether the friendsPictureVideoMessage field is set.
     */
    public boolean hasFriendsPictureVideoMessage() {
      return friendsPictureVideoMessageBuilder_ != null || friendsPictureVideoMessage_ != null;
    }
    /**
     * <code>.com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
     * @return The friendsPictureVideoMessage.
     */
    public com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission getFriendsPictureVideoMessage() {
      if (friendsPictureVideoMessageBuilder_ == null) {
        return friendsPictureVideoMessage_ == null ? com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission.getDefaultInstance() : friendsPictureVideoMessage_;
      } else {
        return friendsPictureVideoMessageBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
     */
    public Builder setFriendsPictureVideoMessage(com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission value) {
      if (friendsPictureVideoMessageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        friendsPictureVideoMessage_ = value;
        onChanged();
      } else {
        friendsPictureVideoMessageBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
     */
    public Builder setFriendsPictureVideoMessage(
        com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission.Builder builderForValue) {
      if (friendsPictureVideoMessageBuilder_ == null) {
        friendsPictureVideoMessage_ = builderForValue.build();
        onChanged();
      } else {
        friendsPictureVideoMessageBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
     */
    public Builder mergeFriendsPictureVideoMessage(com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission value) {
      if (friendsPictureVideoMessageBuilder_ == null) {
        if (friendsPictureVideoMessage_ != null) {
          friendsPictureVideoMessage_ =
            com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission.newBuilder(friendsPictureVideoMessage_).mergeFrom(value).buildPartial();
        } else {
          friendsPictureVideoMessage_ = value;
        }
        onChanged();
      } else {
        friendsPictureVideoMessageBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
     */
    public Builder clearFriendsPictureVideoMessage() {
      if (friendsPictureVideoMessageBuilder_ == null) {
        friendsPictureVideoMessage_ = null;
        onChanged();
      } else {
        friendsPictureVideoMessage_ = null;
        friendsPictureVideoMessageBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
     */
    public com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission.Builder getFriendsPictureVideoMessageBuilder() {
      
      onChanged();
      return getFriendsPictureVideoMessageFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
     */
    public com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmissionOrBuilder getFriendsPictureVideoMessageOrBuilder() {
      if (friendsPictureVideoMessageBuilder_ != null) {
        return friendsPictureVideoMessageBuilder_.getMessageOrBuilder();
      } else {
        return friendsPictureVideoMessage_ == null ?
            com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission.getDefaultInstance() : friendsPictureVideoMessage_;
      }
    }
    /**
     * <code>.com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission friends_picture_video_message = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission, com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission.Builder, com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmissionOrBuilder> 
        getFriendsPictureVideoMessageFieldBuilder() {
      if (friendsPictureVideoMessageBuilder_ == null) {
        friendsPictureVideoMessageBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission, com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmission.Builder, com.lanjiu.pro.fileStorage.OriginalPictureVideoFriendsTransmissionOrBuilder>(
                getFriendsPictureVideoMessage(),
                getParentForChildren(),
                isClean());
        friendsPictureVideoMessage_ = null;
      }
      return friendsPictureVideoMessageBuilder_;
    }

    private java.lang.Object checksum_ = "";
    /**
     * <pre>
     *校验位
     * </pre>
     *
     * <code>string checksum = 2;</code>
     * @return The checksum.
     */
    public java.lang.String getChecksum() {
      java.lang.Object ref = checksum_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        checksum_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *校验位
     * </pre>
     *
     * <code>string checksum = 2;</code>
     * @return The bytes for checksum.
     */
    public com.google.protobuf.ByteString
        getChecksumBytes() {
      java.lang.Object ref = checksum_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        checksum_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *校验位
     * </pre>
     *
     * <code>string checksum = 2;</code>
     * @param value The checksum to set.
     * @return This builder for chaining.
     */
    public Builder setChecksum(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      checksum_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *校验位
     * </pre>
     *
     * <code>string checksum = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearChecksum() {
      
      checksum_ = getDefaultInstance().getChecksum();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *校验位
     * </pre>
     *
     * <code>string checksum = 2;</code>
     * @param value The bytes for checksum to set.
     * @return This builder for chaining.
     */
    public Builder setChecksumBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      checksum_ = value;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:com.lanjiu.pro.fileStorage.FriendsTransmissionResponse)
  }

  // @@protoc_insertion_point(class_scope:com.lanjiu.pro.fileStorage.FriendsTransmissionResponse)
  private static final com.lanjiu.pro.fileStorage.FriendsTransmissionResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.lanjiu.pro.fileStorage.FriendsTransmissionResponse();
  }

  public static com.lanjiu.pro.fileStorage.FriendsTransmissionResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FriendsTransmissionResponse>
      PARSER = new com.google.protobuf.AbstractParser<FriendsTransmissionResponse>() {
    @java.lang.Override
    public FriendsTransmissionResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FriendsTransmissionResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FriendsTransmissionResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FriendsTransmissionResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.lanjiu.pro.fileStorage.FriendsTransmissionResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

