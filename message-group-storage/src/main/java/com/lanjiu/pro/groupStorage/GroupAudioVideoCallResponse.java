// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message_group_storage_grpc.proto

package com.lanjiu.pro.groupStorage;

/**
 * Protobuf type {@code com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse}
 */
public  final class GroupAudioVideoCallResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse)
    GroupAudioVideoCallResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GroupAudioVideoCallResponse.newBuilder() to construct.
  private GroupAudioVideoCallResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GroupAudioVideoCallResponse() {
    groupAudioVideoMessage_ = java.util.Collections.emptyList();
    result_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GroupAudioVideoCallResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GroupAudioVideoCallResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              groupAudioVideoMessage_ = new java.util.ArrayList<com.lanjiu.pro.groupStorage.GroupAudioVideoMessage>();
              mutable_bitField0_ |= 0x00000001;
            }
            groupAudioVideoMessage_.add(
                input.readMessage(com.lanjiu.pro.groupStorage.GroupAudioVideoMessage.parser(), extensionRegistry));
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            result_ = s;
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        groupAudioVideoMessage_ = java.util.Collections.unmodifiableList(groupAudioVideoMessage_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.lanjiu.pro.groupStorage.MessageGroupStorageProto.internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoCallResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.lanjiu.pro.groupStorage.MessageGroupStorageProto.internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoCallResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse.class, com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse.Builder.class);
  }

  public static final int GROUPAUDIOVIDEOMESSAGE_FIELD_NUMBER = 1;
  private java.util.List<com.lanjiu.pro.groupStorage.GroupAudioVideoMessage> groupAudioVideoMessage_;
  /**
   * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
   */
  public java.util.List<com.lanjiu.pro.groupStorage.GroupAudioVideoMessage> getGroupAudioVideoMessageList() {
    return groupAudioVideoMessage_;
  }
  /**
   * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
   */
  public java.util.List<? extends com.lanjiu.pro.groupStorage.GroupAudioVideoMessageOrBuilder> 
      getGroupAudioVideoMessageOrBuilderList() {
    return groupAudioVideoMessage_;
  }
  /**
   * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
   */
  public int getGroupAudioVideoMessageCount() {
    return groupAudioVideoMessage_.size();
  }
  /**
   * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
   */
  public com.lanjiu.pro.groupStorage.GroupAudioVideoMessage getGroupAudioVideoMessage(int index) {
    return groupAudioVideoMessage_.get(index);
  }
  /**
   * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
   */
  public com.lanjiu.pro.groupStorage.GroupAudioVideoMessageOrBuilder getGroupAudioVideoMessageOrBuilder(
      int index) {
    return groupAudioVideoMessage_.get(index);
  }

  public static final int RESULT_FIELD_NUMBER = 2;
  private volatile java.lang.Object result_;
  /**
   * <code>string result = 2;</code>
   * @return The result.
   */
  public java.lang.String getResult() {
    java.lang.Object ref = result_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      result_ = s;
      return s;
    }
  }
  /**
   * <code>string result = 2;</code>
   * @return The bytes for result.
   */
  public com.google.protobuf.ByteString
      getResultBytes() {
    java.lang.Object ref = result_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      result_ = b;
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
    for (int i = 0; i < groupAudioVideoMessage_.size(); i++) {
      output.writeMessage(1, groupAudioVideoMessage_.get(i));
    }
    if (!getResultBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, result_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < groupAudioVideoMessage_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, groupAudioVideoMessage_.get(i));
    }
    if (!getResultBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, result_);
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
    if (!(obj instanceof com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse)) {
      return super.equals(obj);
    }
    com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse other = (com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse) obj;

    if (!getGroupAudioVideoMessageList()
        .equals(other.getGroupAudioVideoMessageList())) return false;
    if (!getResult()
        .equals(other.getResult())) return false;
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
    if (getGroupAudioVideoMessageCount() > 0) {
      hash = (37 * hash) + GROUPAUDIOVIDEOMESSAGE_FIELD_NUMBER;
      hash = (53 * hash) + getGroupAudioVideoMessageList().hashCode();
    }
    hash = (37 * hash) + RESULT_FIELD_NUMBER;
    hash = (53 * hash) + getResult().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse parseFrom(
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
  public static Builder newBuilder(com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse prototype) {
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
   * Protobuf type {@code com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse)
      com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.lanjiu.pro.groupStorage.MessageGroupStorageProto.internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoCallResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.lanjiu.pro.groupStorage.MessageGroupStorageProto.internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoCallResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse.class, com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse.Builder.class);
    }

    // Construct using com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse.newBuilder()
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
        getGroupAudioVideoMessageFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (groupAudioVideoMessageBuilder_ == null) {
        groupAudioVideoMessage_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        groupAudioVideoMessageBuilder_.clear();
      }
      result_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.lanjiu.pro.groupStorage.MessageGroupStorageProto.internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoCallResponse_descriptor;
    }

    @java.lang.Override
    public com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse getDefaultInstanceForType() {
      return com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse build() {
      com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse buildPartial() {
      com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse result = new com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse(this);
      int from_bitField0_ = bitField0_;
      if (groupAudioVideoMessageBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          groupAudioVideoMessage_ = java.util.Collections.unmodifiableList(groupAudioVideoMessage_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.groupAudioVideoMessage_ = groupAudioVideoMessage_;
      } else {
        result.groupAudioVideoMessage_ = groupAudioVideoMessageBuilder_.build();
      }
      result.result_ = result_;
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
      if (other instanceof com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse) {
        return mergeFrom((com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse other) {
      if (other == com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse.getDefaultInstance()) return this;
      if (groupAudioVideoMessageBuilder_ == null) {
        if (!other.groupAudioVideoMessage_.isEmpty()) {
          if (groupAudioVideoMessage_.isEmpty()) {
            groupAudioVideoMessage_ = other.groupAudioVideoMessage_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureGroupAudioVideoMessageIsMutable();
            groupAudioVideoMessage_.addAll(other.groupAudioVideoMessage_);
          }
          onChanged();
        }
      } else {
        if (!other.groupAudioVideoMessage_.isEmpty()) {
          if (groupAudioVideoMessageBuilder_.isEmpty()) {
            groupAudioVideoMessageBuilder_.dispose();
            groupAudioVideoMessageBuilder_ = null;
            groupAudioVideoMessage_ = other.groupAudioVideoMessage_;
            bitField0_ = (bitField0_ & ~0x00000001);
            groupAudioVideoMessageBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getGroupAudioVideoMessageFieldBuilder() : null;
          } else {
            groupAudioVideoMessageBuilder_.addAllMessages(other.groupAudioVideoMessage_);
          }
        }
      }
      if (!other.getResult().isEmpty()) {
        result_ = other.result_;
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
      com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.lanjiu.pro.groupStorage.GroupAudioVideoMessage> groupAudioVideoMessage_ =
      java.util.Collections.emptyList();
    private void ensureGroupAudioVideoMessageIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        groupAudioVideoMessage_ = new java.util.ArrayList<com.lanjiu.pro.groupStorage.GroupAudioVideoMessage>(groupAudioVideoMessage_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.lanjiu.pro.groupStorage.GroupAudioVideoMessage, com.lanjiu.pro.groupStorage.GroupAudioVideoMessage.Builder, com.lanjiu.pro.groupStorage.GroupAudioVideoMessageOrBuilder> groupAudioVideoMessageBuilder_;

    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public java.util.List<com.lanjiu.pro.groupStorage.GroupAudioVideoMessage> getGroupAudioVideoMessageList() {
      if (groupAudioVideoMessageBuilder_ == null) {
        return java.util.Collections.unmodifiableList(groupAudioVideoMessage_);
      } else {
        return groupAudioVideoMessageBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public int getGroupAudioVideoMessageCount() {
      if (groupAudioVideoMessageBuilder_ == null) {
        return groupAudioVideoMessage_.size();
      } else {
        return groupAudioVideoMessageBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public com.lanjiu.pro.groupStorage.GroupAudioVideoMessage getGroupAudioVideoMessage(int index) {
      if (groupAudioVideoMessageBuilder_ == null) {
        return groupAudioVideoMessage_.get(index);
      } else {
        return groupAudioVideoMessageBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public Builder setGroupAudioVideoMessage(
        int index, com.lanjiu.pro.groupStorage.GroupAudioVideoMessage value) {
      if (groupAudioVideoMessageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGroupAudioVideoMessageIsMutable();
        groupAudioVideoMessage_.set(index, value);
        onChanged();
      } else {
        groupAudioVideoMessageBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public Builder setGroupAudioVideoMessage(
        int index, com.lanjiu.pro.groupStorage.GroupAudioVideoMessage.Builder builderForValue) {
      if (groupAudioVideoMessageBuilder_ == null) {
        ensureGroupAudioVideoMessageIsMutable();
        groupAudioVideoMessage_.set(index, builderForValue.build());
        onChanged();
      } else {
        groupAudioVideoMessageBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public Builder addGroupAudioVideoMessage(com.lanjiu.pro.groupStorage.GroupAudioVideoMessage value) {
      if (groupAudioVideoMessageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGroupAudioVideoMessageIsMutable();
        groupAudioVideoMessage_.add(value);
        onChanged();
      } else {
        groupAudioVideoMessageBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public Builder addGroupAudioVideoMessage(
        int index, com.lanjiu.pro.groupStorage.GroupAudioVideoMessage value) {
      if (groupAudioVideoMessageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGroupAudioVideoMessageIsMutable();
        groupAudioVideoMessage_.add(index, value);
        onChanged();
      } else {
        groupAudioVideoMessageBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public Builder addGroupAudioVideoMessage(
        com.lanjiu.pro.groupStorage.GroupAudioVideoMessage.Builder builderForValue) {
      if (groupAudioVideoMessageBuilder_ == null) {
        ensureGroupAudioVideoMessageIsMutable();
        groupAudioVideoMessage_.add(builderForValue.build());
        onChanged();
      } else {
        groupAudioVideoMessageBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public Builder addGroupAudioVideoMessage(
        int index, com.lanjiu.pro.groupStorage.GroupAudioVideoMessage.Builder builderForValue) {
      if (groupAudioVideoMessageBuilder_ == null) {
        ensureGroupAudioVideoMessageIsMutable();
        groupAudioVideoMessage_.add(index, builderForValue.build());
        onChanged();
      } else {
        groupAudioVideoMessageBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public Builder addAllGroupAudioVideoMessage(
        java.lang.Iterable<? extends com.lanjiu.pro.groupStorage.GroupAudioVideoMessage> values) {
      if (groupAudioVideoMessageBuilder_ == null) {
        ensureGroupAudioVideoMessageIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, groupAudioVideoMessage_);
        onChanged();
      } else {
        groupAudioVideoMessageBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public Builder clearGroupAudioVideoMessage() {
      if (groupAudioVideoMessageBuilder_ == null) {
        groupAudioVideoMessage_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        groupAudioVideoMessageBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public Builder removeGroupAudioVideoMessage(int index) {
      if (groupAudioVideoMessageBuilder_ == null) {
        ensureGroupAudioVideoMessageIsMutable();
        groupAudioVideoMessage_.remove(index);
        onChanged();
      } else {
        groupAudioVideoMessageBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public com.lanjiu.pro.groupStorage.GroupAudioVideoMessage.Builder getGroupAudioVideoMessageBuilder(
        int index) {
      return getGroupAudioVideoMessageFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public com.lanjiu.pro.groupStorage.GroupAudioVideoMessageOrBuilder getGroupAudioVideoMessageOrBuilder(
        int index) {
      if (groupAudioVideoMessageBuilder_ == null) {
        return groupAudioVideoMessage_.get(index);  } else {
        return groupAudioVideoMessageBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public java.util.List<? extends com.lanjiu.pro.groupStorage.GroupAudioVideoMessageOrBuilder> 
         getGroupAudioVideoMessageOrBuilderList() {
      if (groupAudioVideoMessageBuilder_ != null) {
        return groupAudioVideoMessageBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(groupAudioVideoMessage_);
      }
    }
    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public com.lanjiu.pro.groupStorage.GroupAudioVideoMessage.Builder addGroupAudioVideoMessageBuilder() {
      return getGroupAudioVideoMessageFieldBuilder().addBuilder(
          com.lanjiu.pro.groupStorage.GroupAudioVideoMessage.getDefaultInstance());
    }
    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public com.lanjiu.pro.groupStorage.GroupAudioVideoMessage.Builder addGroupAudioVideoMessageBuilder(
        int index) {
      return getGroupAudioVideoMessageFieldBuilder().addBuilder(
          index, com.lanjiu.pro.groupStorage.GroupAudioVideoMessage.getDefaultInstance());
    }
    /**
     * <code>repeated .com.lanjiu.pro.groupStorage.GroupAudioVideoMessage groupAudioVideoMessage = 1;</code>
     */
    public java.util.List<com.lanjiu.pro.groupStorage.GroupAudioVideoMessage.Builder> 
         getGroupAudioVideoMessageBuilderList() {
      return getGroupAudioVideoMessageFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.lanjiu.pro.groupStorage.GroupAudioVideoMessage, com.lanjiu.pro.groupStorage.GroupAudioVideoMessage.Builder, com.lanjiu.pro.groupStorage.GroupAudioVideoMessageOrBuilder> 
        getGroupAudioVideoMessageFieldBuilder() {
      if (groupAudioVideoMessageBuilder_ == null) {
        groupAudioVideoMessageBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.lanjiu.pro.groupStorage.GroupAudioVideoMessage, com.lanjiu.pro.groupStorage.GroupAudioVideoMessage.Builder, com.lanjiu.pro.groupStorage.GroupAudioVideoMessageOrBuilder>(
                groupAudioVideoMessage_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        groupAudioVideoMessage_ = null;
      }
      return groupAudioVideoMessageBuilder_;
    }

    private java.lang.Object result_ = "";
    /**
     * <code>string result = 2;</code>
     * @return The result.
     */
    public java.lang.String getResult() {
      java.lang.Object ref = result_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        result_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string result = 2;</code>
     * @return The bytes for result.
     */
    public com.google.protobuf.ByteString
        getResultBytes() {
      java.lang.Object ref = result_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        result_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string result = 2;</code>
     * @param value The result to set.
     * @return This builder for chaining.
     */
    public Builder setResult(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      result_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string result = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearResult() {
      
      result_ = getDefaultInstance().getResult();
      onChanged();
      return this;
    }
    /**
     * <code>string result = 2;</code>
     * @param value The bytes for result to set.
     * @return This builder for chaining.
     */
    public Builder setResultBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      result_ = value;
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


    // @@protoc_insertion_point(builder_scope:com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse)
  }

  // @@protoc_insertion_point(class_scope:com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse)
  private static final com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse();
  }

  public static com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GroupAudioVideoCallResponse>
      PARSER = new com.google.protobuf.AbstractParser<GroupAudioVideoCallResponse>() {
    @java.lang.Override
    public GroupAudioVideoCallResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GroupAudioVideoCallResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GroupAudioVideoCallResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GroupAudioVideoCallResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.lanjiu.pro.groupStorage.GroupAudioVideoCallResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

