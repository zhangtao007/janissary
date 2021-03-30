// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: im_friend_message.proto

package com.lanjiu.pro.friend_msg;

/**
 * Protobuf type {@code com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest}
 */
public  final class AudioAndVideoCallRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest)
    AudioAndVideoCallRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AudioAndVideoCallRequest.newBuilder() to construct.
  private AudioAndVideoCallRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AudioAndVideoCallRequest() {
    args_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AudioAndVideoCallRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AudioAndVideoCallRequest(
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
            com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage.Builder subBuilder = null;
            if (audioAndVideoCallMessage_ != null) {
              subBuilder = audioAndVideoCallMessage_.toBuilder();
            }
            audioAndVideoCallMessage_ = input.readMessage(com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(audioAndVideoCallMessage_);
              audioAndVideoCallMessage_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            args_ = s;
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
    return com.lanjiu.pro.friend_msg.MessageFriendStorageProto.internal_static_com_lanjiu_pro_friend_msg_AudioAndVideoCallRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.lanjiu.pro.friend_msg.MessageFriendStorageProto.internal_static_com_lanjiu_pro_friend_msg_AudioAndVideoCallRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest.class, com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest.Builder.class);
  }

  public static final int AUDIOANDVIDEOCALLMESSAGE_FIELD_NUMBER = 1;
  private com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage audioAndVideoCallMessage_;
  /**
   * <code>.com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage audioAndVideoCallMessage = 1;</code>
   * @return Whether the audioAndVideoCallMessage field is set.
   */
  public boolean hasAudioAndVideoCallMessage() {
    return audioAndVideoCallMessage_ != null;
  }
  /**
   * <code>.com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage audioAndVideoCallMessage = 1;</code>
   * @return The audioAndVideoCallMessage.
   */
  public com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage getAudioAndVideoCallMessage() {
    return audioAndVideoCallMessage_ == null ? com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage.getDefaultInstance() : audioAndVideoCallMessage_;
  }
  /**
   * <code>.com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage audioAndVideoCallMessage = 1;</code>
   */
  public com.lanjiu.pro.friend_msg.AudioAndVideoCallMessageOrBuilder getAudioAndVideoCallMessageOrBuilder() {
    return getAudioAndVideoCallMessage();
  }

  public static final int ARGS_FIELD_NUMBER = 2;
  private volatile java.lang.Object args_;
  /**
   * <code>string args = 2;</code>
   * @return The args.
   */
  public java.lang.String getArgs() {
    java.lang.Object ref = args_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      args_ = s;
      return s;
    }
  }
  /**
   * <code>string args = 2;</code>
   * @return The bytes for args.
   */
  public com.google.protobuf.ByteString
      getArgsBytes() {
    java.lang.Object ref = args_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      args_ = b;
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
    if (audioAndVideoCallMessage_ != null) {
      output.writeMessage(1, getAudioAndVideoCallMessage());
    }
    if (!getArgsBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, args_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (audioAndVideoCallMessage_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getAudioAndVideoCallMessage());
    }
    if (!getArgsBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, args_);
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
    if (!(obj instanceof com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest)) {
      return super.equals(obj);
    }
    com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest other = (com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest) obj;

    if (hasAudioAndVideoCallMessage() != other.hasAudioAndVideoCallMessage()) return false;
    if (hasAudioAndVideoCallMessage()) {
      if (!getAudioAndVideoCallMessage()
          .equals(other.getAudioAndVideoCallMessage())) return false;
    }
    if (!getArgs()
        .equals(other.getArgs())) return false;
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
    if (hasAudioAndVideoCallMessage()) {
      hash = (37 * hash) + AUDIOANDVIDEOCALLMESSAGE_FIELD_NUMBER;
      hash = (53 * hash) + getAudioAndVideoCallMessage().hashCode();
    }
    hash = (37 * hash) + ARGS_FIELD_NUMBER;
    hash = (53 * hash) + getArgs().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest parseFrom(
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
  public static Builder newBuilder(com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest prototype) {
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
   * Protobuf type {@code com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest)
      com.lanjiu.pro.friend_msg.AudioAndVideoCallRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.lanjiu.pro.friend_msg.MessageFriendStorageProto.internal_static_com_lanjiu_pro_friend_msg_AudioAndVideoCallRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.lanjiu.pro.friend_msg.MessageFriendStorageProto.internal_static_com_lanjiu_pro_friend_msg_AudioAndVideoCallRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest.class, com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest.Builder.class);
    }

    // Construct using com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest.newBuilder()
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
      if (audioAndVideoCallMessageBuilder_ == null) {
        audioAndVideoCallMessage_ = null;
      } else {
        audioAndVideoCallMessage_ = null;
        audioAndVideoCallMessageBuilder_ = null;
      }
      args_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.lanjiu.pro.friend_msg.MessageFriendStorageProto.internal_static_com_lanjiu_pro_friend_msg_AudioAndVideoCallRequest_descriptor;
    }

    @java.lang.Override
    public com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest getDefaultInstanceForType() {
      return com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest build() {
      com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest buildPartial() {
      com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest result = new com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest(this);
      if (audioAndVideoCallMessageBuilder_ == null) {
        result.audioAndVideoCallMessage_ = audioAndVideoCallMessage_;
      } else {
        result.audioAndVideoCallMessage_ = audioAndVideoCallMessageBuilder_.build();
      }
      result.args_ = args_;
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
      if (other instanceof com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest) {
        return mergeFrom((com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest other) {
      if (other == com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest.getDefaultInstance()) return this;
      if (other.hasAudioAndVideoCallMessage()) {
        mergeAudioAndVideoCallMessage(other.getAudioAndVideoCallMessage());
      }
      if (!other.getArgs().isEmpty()) {
        args_ = other.args_;
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
      com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage audioAndVideoCallMessage_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage, com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage.Builder, com.lanjiu.pro.friend_msg.AudioAndVideoCallMessageOrBuilder> audioAndVideoCallMessageBuilder_;
    /**
     * <code>.com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage audioAndVideoCallMessage = 1;</code>
     * @return Whether the audioAndVideoCallMessage field is set.
     */
    public boolean hasAudioAndVideoCallMessage() {
      return audioAndVideoCallMessageBuilder_ != null || audioAndVideoCallMessage_ != null;
    }
    /**
     * <code>.com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage audioAndVideoCallMessage = 1;</code>
     * @return The audioAndVideoCallMessage.
     */
    public com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage getAudioAndVideoCallMessage() {
      if (audioAndVideoCallMessageBuilder_ == null) {
        return audioAndVideoCallMessage_ == null ? com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage.getDefaultInstance() : audioAndVideoCallMessage_;
      } else {
        return audioAndVideoCallMessageBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage audioAndVideoCallMessage = 1;</code>
     */
    public Builder setAudioAndVideoCallMessage(com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage value) {
      if (audioAndVideoCallMessageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        audioAndVideoCallMessage_ = value;
        onChanged();
      } else {
        audioAndVideoCallMessageBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage audioAndVideoCallMessage = 1;</code>
     */
    public Builder setAudioAndVideoCallMessage(
        com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage.Builder builderForValue) {
      if (audioAndVideoCallMessageBuilder_ == null) {
        audioAndVideoCallMessage_ = builderForValue.build();
        onChanged();
      } else {
        audioAndVideoCallMessageBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage audioAndVideoCallMessage = 1;</code>
     */
    public Builder mergeAudioAndVideoCallMessage(com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage value) {
      if (audioAndVideoCallMessageBuilder_ == null) {
        if (audioAndVideoCallMessage_ != null) {
          audioAndVideoCallMessage_ =
            com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage.newBuilder(audioAndVideoCallMessage_).mergeFrom(value).buildPartial();
        } else {
          audioAndVideoCallMessage_ = value;
        }
        onChanged();
      } else {
        audioAndVideoCallMessageBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage audioAndVideoCallMessage = 1;</code>
     */
    public Builder clearAudioAndVideoCallMessage() {
      if (audioAndVideoCallMessageBuilder_ == null) {
        audioAndVideoCallMessage_ = null;
        onChanged();
      } else {
        audioAndVideoCallMessage_ = null;
        audioAndVideoCallMessageBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage audioAndVideoCallMessage = 1;</code>
     */
    public com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage.Builder getAudioAndVideoCallMessageBuilder() {
      
      onChanged();
      return getAudioAndVideoCallMessageFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage audioAndVideoCallMessage = 1;</code>
     */
    public com.lanjiu.pro.friend_msg.AudioAndVideoCallMessageOrBuilder getAudioAndVideoCallMessageOrBuilder() {
      if (audioAndVideoCallMessageBuilder_ != null) {
        return audioAndVideoCallMessageBuilder_.getMessageOrBuilder();
      } else {
        return audioAndVideoCallMessage_ == null ?
            com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage.getDefaultInstance() : audioAndVideoCallMessage_;
      }
    }
    /**
     * <code>.com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage audioAndVideoCallMessage = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage, com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage.Builder, com.lanjiu.pro.friend_msg.AudioAndVideoCallMessageOrBuilder> 
        getAudioAndVideoCallMessageFieldBuilder() {
      if (audioAndVideoCallMessageBuilder_ == null) {
        audioAndVideoCallMessageBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage, com.lanjiu.pro.friend_msg.AudioAndVideoCallMessage.Builder, com.lanjiu.pro.friend_msg.AudioAndVideoCallMessageOrBuilder>(
                getAudioAndVideoCallMessage(),
                getParentForChildren(),
                isClean());
        audioAndVideoCallMessage_ = null;
      }
      return audioAndVideoCallMessageBuilder_;
    }

    private java.lang.Object args_ = "";
    /**
     * <code>string args = 2;</code>
     * @return The args.
     */
    public java.lang.String getArgs() {
      java.lang.Object ref = args_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        args_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string args = 2;</code>
     * @return The bytes for args.
     */
    public com.google.protobuf.ByteString
        getArgsBytes() {
      java.lang.Object ref = args_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        args_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string args = 2;</code>
     * @param value The args to set.
     * @return This builder for chaining.
     */
    public Builder setArgs(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      args_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string args = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearArgs() {
      
      args_ = getDefaultInstance().getArgs();
      onChanged();
      return this;
    }
    /**
     * <code>string args = 2;</code>
     * @param value The bytes for args to set.
     * @return This builder for chaining.
     */
    public Builder setArgsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      args_ = value;
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


    // @@protoc_insertion_point(builder_scope:com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest)
  }

  // @@protoc_insertion_point(class_scope:com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest)
  private static final com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest();
  }

  public static com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AudioAndVideoCallRequest>
      PARSER = new com.google.protobuf.AbstractParser<AudioAndVideoCallRequest>() {
    @java.lang.Override
    public AudioAndVideoCallRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AudioAndVideoCallRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AudioAndVideoCallRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AudioAndVideoCallRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.lanjiu.pro.friend_msg.AudioAndVideoCallRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

