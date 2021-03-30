// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: im_friend_message.proto

package com.lanjiu.pro.friend_msg;

/**
 * Protobuf type {@code com.lanjiu.pro.friend_msg.NotifyDelMsg}
 */
public  final class NotifyDelMsg extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.lanjiu.pro.friend_msg.NotifyDelMsg)
    NotifyDelMsgOrBuilder {
private static final long serialVersionUID = 0L;
  // Use NotifyDelMsg.newBuilder() to construct.
  private NotifyDelMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NotifyDelMsg() {
    msgId_ = "";
    timestap_ = "";
    args_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new NotifyDelMsg();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private NotifyDelMsg(
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
          case 8: {

            delfromId_ = input.readInt32();
            break;
          }
          case 16: {

            deltoId_ = input.readInt32();
            break;
          }
          case 24: {

            fromId_ = input.readInt32();
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            msgId_ = s;
            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            timestap_ = s;
            break;
          }
          case 50: {
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
    return com.lanjiu.pro.friend_msg.MessageFriendStorageProto.internal_static_com_lanjiu_pro_friend_msg_NotifyDelMsg_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.lanjiu.pro.friend_msg.MessageFriendStorageProto.internal_static_com_lanjiu_pro_friend_msg_NotifyDelMsg_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.lanjiu.pro.friend_msg.NotifyDelMsg.class, com.lanjiu.pro.friend_msg.NotifyDelMsg.Builder.class);
  }

  public static final int DELFROMID_FIELD_NUMBER = 1;
  private int delfromId_;
  /**
   * <code>int32 delfromId = 1;</code>
   * @return The delfromId.
   */
  public int getDelfromId() {
    return delfromId_;
  }

  public static final int DELTOID_FIELD_NUMBER = 2;
  private int deltoId_;
  /**
   * <code>int32 deltoId = 2;</code>
   * @return The deltoId.
   */
  public int getDeltoId() {
    return deltoId_;
  }

  public static final int FROMID_FIELD_NUMBER = 3;
  private int fromId_;
  /**
   * <code>int32 fromId = 3;</code>
   * @return The fromId.
   */
  public int getFromId() {
    return fromId_;
  }

  public static final int MSGID_FIELD_NUMBER = 4;
  private volatile java.lang.Object msgId_;
  /**
   * <code>string msgId = 4;</code>
   * @return The msgId.
   */
  public java.lang.String getMsgId() {
    java.lang.Object ref = msgId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      msgId_ = s;
      return s;
    }
  }
  /**
   * <code>string msgId = 4;</code>
   * @return The bytes for msgId.
   */
  public com.google.protobuf.ByteString
      getMsgIdBytes() {
    java.lang.Object ref = msgId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      msgId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TIMESTAP_FIELD_NUMBER = 5;
  private volatile java.lang.Object timestap_;
  /**
   * <code>string timestap = 5;</code>
   * @return The timestap.
   */
  public java.lang.String getTimestap() {
    java.lang.Object ref = timestap_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      timestap_ = s;
      return s;
    }
  }
  /**
   * <code>string timestap = 5;</code>
   * @return The bytes for timestap.
   */
  public com.google.protobuf.ByteString
      getTimestapBytes() {
    java.lang.Object ref = timestap_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      timestap_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ARGS_FIELD_NUMBER = 6;
  private volatile java.lang.Object args_;
  /**
   * <code>string args = 6;</code>
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
   * <code>string args = 6;</code>
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
    if (delfromId_ != 0) {
      output.writeInt32(1, delfromId_);
    }
    if (deltoId_ != 0) {
      output.writeInt32(2, deltoId_);
    }
    if (fromId_ != 0) {
      output.writeInt32(3, fromId_);
    }
    if (!getMsgIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, msgId_);
    }
    if (!getTimestapBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, timestap_);
    }
    if (!getArgsBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, args_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (delfromId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, delfromId_);
    }
    if (deltoId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, deltoId_);
    }
    if (fromId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, fromId_);
    }
    if (!getMsgIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, msgId_);
    }
    if (!getTimestapBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, timestap_);
    }
    if (!getArgsBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, args_);
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
    if (!(obj instanceof com.lanjiu.pro.friend_msg.NotifyDelMsg)) {
      return super.equals(obj);
    }
    com.lanjiu.pro.friend_msg.NotifyDelMsg other = (com.lanjiu.pro.friend_msg.NotifyDelMsg) obj;

    if (getDelfromId()
        != other.getDelfromId()) return false;
    if (getDeltoId()
        != other.getDeltoId()) return false;
    if (getFromId()
        != other.getFromId()) return false;
    if (!getMsgId()
        .equals(other.getMsgId())) return false;
    if (!getTimestap()
        .equals(other.getTimestap())) return false;
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
    hash = (37 * hash) + DELFROMID_FIELD_NUMBER;
    hash = (53 * hash) + getDelfromId();
    hash = (37 * hash) + DELTOID_FIELD_NUMBER;
    hash = (53 * hash) + getDeltoId();
    hash = (37 * hash) + FROMID_FIELD_NUMBER;
    hash = (53 * hash) + getFromId();
    hash = (37 * hash) + MSGID_FIELD_NUMBER;
    hash = (53 * hash) + getMsgId().hashCode();
    hash = (37 * hash) + TIMESTAP_FIELD_NUMBER;
    hash = (53 * hash) + getTimestap().hashCode();
    hash = (37 * hash) + ARGS_FIELD_NUMBER;
    hash = (53 * hash) + getArgs().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.lanjiu.pro.friend_msg.NotifyDelMsg parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.pro.friend_msg.NotifyDelMsg parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.pro.friend_msg.NotifyDelMsg parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.pro.friend_msg.NotifyDelMsg parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.pro.friend_msg.NotifyDelMsg parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.pro.friend_msg.NotifyDelMsg parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.pro.friend_msg.NotifyDelMsg parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.pro.friend_msg.NotifyDelMsg parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.pro.friend_msg.NotifyDelMsg parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.lanjiu.pro.friend_msg.NotifyDelMsg parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.pro.friend_msg.NotifyDelMsg parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.pro.friend_msg.NotifyDelMsg parseFrom(
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
  public static Builder newBuilder(com.lanjiu.pro.friend_msg.NotifyDelMsg prototype) {
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
   * Protobuf type {@code com.lanjiu.pro.friend_msg.NotifyDelMsg}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.lanjiu.pro.friend_msg.NotifyDelMsg)
      com.lanjiu.pro.friend_msg.NotifyDelMsgOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.lanjiu.pro.friend_msg.MessageFriendStorageProto.internal_static_com_lanjiu_pro_friend_msg_NotifyDelMsg_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.lanjiu.pro.friend_msg.MessageFriendStorageProto.internal_static_com_lanjiu_pro_friend_msg_NotifyDelMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.lanjiu.pro.friend_msg.NotifyDelMsg.class, com.lanjiu.pro.friend_msg.NotifyDelMsg.Builder.class);
    }

    // Construct using com.lanjiu.pro.friend_msg.NotifyDelMsg.newBuilder()
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
      delfromId_ = 0;

      deltoId_ = 0;

      fromId_ = 0;

      msgId_ = "";

      timestap_ = "";

      args_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.lanjiu.pro.friend_msg.MessageFriendStorageProto.internal_static_com_lanjiu_pro_friend_msg_NotifyDelMsg_descriptor;
    }

    @java.lang.Override
    public com.lanjiu.pro.friend_msg.NotifyDelMsg getDefaultInstanceForType() {
      return com.lanjiu.pro.friend_msg.NotifyDelMsg.getDefaultInstance();
    }

    @java.lang.Override
    public com.lanjiu.pro.friend_msg.NotifyDelMsg build() {
      com.lanjiu.pro.friend_msg.NotifyDelMsg result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.lanjiu.pro.friend_msg.NotifyDelMsg buildPartial() {
      com.lanjiu.pro.friend_msg.NotifyDelMsg result = new com.lanjiu.pro.friend_msg.NotifyDelMsg(this);
      result.delfromId_ = delfromId_;
      result.deltoId_ = deltoId_;
      result.fromId_ = fromId_;
      result.msgId_ = msgId_;
      result.timestap_ = timestap_;
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
      if (other instanceof com.lanjiu.pro.friend_msg.NotifyDelMsg) {
        return mergeFrom((com.lanjiu.pro.friend_msg.NotifyDelMsg)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.lanjiu.pro.friend_msg.NotifyDelMsg other) {
      if (other == com.lanjiu.pro.friend_msg.NotifyDelMsg.getDefaultInstance()) return this;
      if (other.getDelfromId() != 0) {
        setDelfromId(other.getDelfromId());
      }
      if (other.getDeltoId() != 0) {
        setDeltoId(other.getDeltoId());
      }
      if (other.getFromId() != 0) {
        setFromId(other.getFromId());
      }
      if (!other.getMsgId().isEmpty()) {
        msgId_ = other.msgId_;
        onChanged();
      }
      if (!other.getTimestap().isEmpty()) {
        timestap_ = other.timestap_;
        onChanged();
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
      com.lanjiu.pro.friend_msg.NotifyDelMsg parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.lanjiu.pro.friend_msg.NotifyDelMsg) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int delfromId_ ;
    /**
     * <code>int32 delfromId = 1;</code>
     * @return The delfromId.
     */
    public int getDelfromId() {
      return delfromId_;
    }
    /**
     * <code>int32 delfromId = 1;</code>
     * @param value The delfromId to set.
     * @return This builder for chaining.
     */
    public Builder setDelfromId(int value) {
      
      delfromId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 delfromId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearDelfromId() {
      
      delfromId_ = 0;
      onChanged();
      return this;
    }

    private int deltoId_ ;
    /**
     * <code>int32 deltoId = 2;</code>
     * @return The deltoId.
     */
    public int getDeltoId() {
      return deltoId_;
    }
    /**
     * <code>int32 deltoId = 2;</code>
     * @param value The deltoId to set.
     * @return This builder for chaining.
     */
    public Builder setDeltoId(int value) {
      
      deltoId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 deltoId = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearDeltoId() {
      
      deltoId_ = 0;
      onChanged();
      return this;
    }

    private int fromId_ ;
    /**
     * <code>int32 fromId = 3;</code>
     * @return The fromId.
     */
    public int getFromId() {
      return fromId_;
    }
    /**
     * <code>int32 fromId = 3;</code>
     * @param value The fromId to set.
     * @return This builder for chaining.
     */
    public Builder setFromId(int value) {
      
      fromId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 fromId = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearFromId() {
      
      fromId_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object msgId_ = "";
    /**
     * <code>string msgId = 4;</code>
     * @return The msgId.
     */
    public java.lang.String getMsgId() {
      java.lang.Object ref = msgId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        msgId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string msgId = 4;</code>
     * @return The bytes for msgId.
     */
    public com.google.protobuf.ByteString
        getMsgIdBytes() {
      java.lang.Object ref = msgId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        msgId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string msgId = 4;</code>
     * @param value The msgId to set.
     * @return This builder for chaining.
     */
    public Builder setMsgId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      msgId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string msgId = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearMsgId() {
      
      msgId_ = getDefaultInstance().getMsgId();
      onChanged();
      return this;
    }
    /**
     * <code>string msgId = 4;</code>
     * @param value The bytes for msgId to set.
     * @return This builder for chaining.
     */
    public Builder setMsgIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      msgId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object timestap_ = "";
    /**
     * <code>string timestap = 5;</code>
     * @return The timestap.
     */
    public java.lang.String getTimestap() {
      java.lang.Object ref = timestap_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        timestap_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string timestap = 5;</code>
     * @return The bytes for timestap.
     */
    public com.google.protobuf.ByteString
        getTimestapBytes() {
      java.lang.Object ref = timestap_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        timestap_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string timestap = 5;</code>
     * @param value The timestap to set.
     * @return This builder for chaining.
     */
    public Builder setTimestap(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      timestap_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string timestap = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearTimestap() {
      
      timestap_ = getDefaultInstance().getTimestap();
      onChanged();
      return this;
    }
    /**
     * <code>string timestap = 5;</code>
     * @param value The bytes for timestap to set.
     * @return This builder for chaining.
     */
    public Builder setTimestapBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      timestap_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object args_ = "";
    /**
     * <code>string args = 6;</code>
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
     * <code>string args = 6;</code>
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
     * <code>string args = 6;</code>
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
     * <code>string args = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearArgs() {
      
      args_ = getDefaultInstance().getArgs();
      onChanged();
      return this;
    }
    /**
     * <code>string args = 6;</code>
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


    // @@protoc_insertion_point(builder_scope:com.lanjiu.pro.friend_msg.NotifyDelMsg)
  }

  // @@protoc_insertion_point(class_scope:com.lanjiu.pro.friend_msg.NotifyDelMsg)
  private static final com.lanjiu.pro.friend_msg.NotifyDelMsg DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.lanjiu.pro.friend_msg.NotifyDelMsg();
  }

  public static com.lanjiu.pro.friend_msg.NotifyDelMsg getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NotifyDelMsg>
      PARSER = new com.google.protobuf.AbstractParser<NotifyDelMsg>() {
    @java.lang.Override
    public NotifyDelMsg parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new NotifyDelMsg(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NotifyDelMsg> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<NotifyDelMsg> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.lanjiu.pro.friend_msg.NotifyDelMsg getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

