// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: im_friend_message.proto

package com.lanjiu.im.regist;

/**
 * Protobuf type {@code com.lanjiu.im.regist.FriendMessage}
 */
public  final class FriendMessage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.lanjiu.im.regist.FriendMessage)
    FriendMessageOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FriendMessage.newBuilder() to construct.
  private FriendMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FriendMessage() {
    content_ = "";
    entityUrl_ = "";
    createTime_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FriendMessage();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FriendMessage(
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

            msgId_ = input.readInt32();
            break;
          }
          case 16: {

            msgType_ = input.readInt32();
            break;
          }
          case 24: {

            fromId_ = input.readInt32();
            break;
          }
          case 32: {

            toId_ = input.readInt32();
            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            content_ = s;
            break;
          }
          case 50: {
            java.lang.String s = input.readStringRequireUtf8();

            entityUrl_ = s;
            break;
          }
          case 58: {
            java.lang.String s = input.readStringRequireUtf8();

            createTime_ = s;
            break;
          }
          case 64: {

            messageOfflineStatus_ = input.readBool();
            break;
          }
          case 72: {

            burnAfterReadingStatus_ = input.readBool();
            break;
          }
          case 80: {

            burnAfterReadingLength_ = input.readInt32();
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
    return com.lanjiu.im.regist.MessageFriendStorageProto.internal_static_com_lanjiu_im_regist_FriendMessage_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.lanjiu.im.regist.MessageFriendStorageProto.internal_static_com_lanjiu_im_regist_FriendMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.lanjiu.im.regist.FriendMessage.class, com.lanjiu.im.regist.FriendMessage.Builder.class);
  }

  public static final int MSG_ID_FIELD_NUMBER = 1;
  private int msgId_;
  /**
   * <code>int32 msg_id = 1;</code>
   * @return The msgId.
   */
  public int getMsgId() {
    return msgId_;
  }

  public static final int MSG_TYPE_FIELD_NUMBER = 2;
  private int msgType_;
  /**
   * <code>int32 msg_type = 2;</code>
   * @return The msgType.
   */
  public int getMsgType() {
    return msgType_;
  }

  public static final int FROM_ID_FIELD_NUMBER = 3;
  private int fromId_;
  /**
   * <code>int32 from_id = 3;</code>
   * @return The fromId.
   */
  public int getFromId() {
    return fromId_;
  }

  public static final int TO_ID_FIELD_NUMBER = 4;
  private int toId_;
  /**
   * <code>int32 to_id = 4;</code>
   * @return The toId.
   */
  public int getToId() {
    return toId_;
  }

  public static final int CONTENT_FIELD_NUMBER = 5;
  private volatile java.lang.Object content_;
  /**
   * <code>string content = 5;</code>
   * @return The content.
   */
  public java.lang.String getContent() {
    java.lang.Object ref = content_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      content_ = s;
      return s;
    }
  }
  /**
   * <code>string content = 5;</code>
   * @return The bytes for content.
   */
  public com.google.protobuf.ByteString
      getContentBytes() {
    java.lang.Object ref = content_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      content_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ENTITY_URL_FIELD_NUMBER = 6;
  private volatile java.lang.Object entityUrl_;
  /**
   * <code>string entity_url = 6;</code>
   * @return The entityUrl.
   */
  public java.lang.String getEntityUrl() {
    java.lang.Object ref = entityUrl_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      entityUrl_ = s;
      return s;
    }
  }
  /**
   * <code>string entity_url = 6;</code>
   * @return The bytes for entityUrl.
   */
  public com.google.protobuf.ByteString
      getEntityUrlBytes() {
    java.lang.Object ref = entityUrl_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      entityUrl_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CREATE_TIME_FIELD_NUMBER = 7;
  private volatile java.lang.Object createTime_;
  /**
   * <code>string create_time = 7;</code>
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
   * <code>string create_time = 7;</code>
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

  public static final int MESSAGE_OFFLINE_STATUS_FIELD_NUMBER = 8;
  private boolean messageOfflineStatus_;
  /**
   * <code>bool message_offline_status = 8;</code>
   * @return The messageOfflineStatus.
   */
  public boolean getMessageOfflineStatus() {
    return messageOfflineStatus_;
  }

  public static final int BURN_AFTER_READING_STATUS_FIELD_NUMBER = 9;
  private boolean burnAfterReadingStatus_;
  /**
   * <code>bool burn_after_reading_status = 9;</code>
   * @return The burnAfterReadingStatus.
   */
  public boolean getBurnAfterReadingStatus() {
    return burnAfterReadingStatus_;
  }

  public static final int BURN_AFTER_READING_LENGTH_FIELD_NUMBER = 10;
  private int burnAfterReadingLength_;
  /**
   * <code>int32 burn_after_reading_length = 10;</code>
   * @return The burnAfterReadingLength.
   */
  public int getBurnAfterReadingLength() {
    return burnAfterReadingLength_;
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
    if (msgId_ != 0) {
      output.writeInt32(1, msgId_);
    }
    if (msgType_ != 0) {
      output.writeInt32(2, msgType_);
    }
    if (fromId_ != 0) {
      output.writeInt32(3, fromId_);
    }
    if (toId_ != 0) {
      output.writeInt32(4, toId_);
    }
    if (!getContentBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, content_);
    }
    if (!getEntityUrlBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, entityUrl_);
    }
    if (!getCreateTimeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 7, createTime_);
    }
    if (messageOfflineStatus_ != false) {
      output.writeBool(8, messageOfflineStatus_);
    }
    if (burnAfterReadingStatus_ != false) {
      output.writeBool(9, burnAfterReadingStatus_);
    }
    if (burnAfterReadingLength_ != 0) {
      output.writeInt32(10, burnAfterReadingLength_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (msgId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, msgId_);
    }
    if (msgType_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, msgType_);
    }
    if (fromId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, fromId_);
    }
    if (toId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, toId_);
    }
    if (!getContentBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, content_);
    }
    if (!getEntityUrlBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, entityUrl_);
    }
    if (!getCreateTimeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, createTime_);
    }
    if (messageOfflineStatus_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(8, messageOfflineStatus_);
    }
    if (burnAfterReadingStatus_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(9, burnAfterReadingStatus_);
    }
    if (burnAfterReadingLength_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(10, burnAfterReadingLength_);
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
    if (!(obj instanceof com.lanjiu.im.regist.FriendMessage)) {
      return super.equals(obj);
    }
    com.lanjiu.im.regist.FriendMessage other = (com.lanjiu.im.regist.FriendMessage) obj;

    if (getMsgId()
        != other.getMsgId()) return false;
    if (getMsgType()
        != other.getMsgType()) return false;
    if (getFromId()
        != other.getFromId()) return false;
    if (getToId()
        != other.getToId()) return false;
    if (!getContent()
        .equals(other.getContent())) return false;
    if (!getEntityUrl()
        .equals(other.getEntityUrl())) return false;
    if (!getCreateTime()
        .equals(other.getCreateTime())) return false;
    if (getMessageOfflineStatus()
        != other.getMessageOfflineStatus()) return false;
    if (getBurnAfterReadingStatus()
        != other.getBurnAfterReadingStatus()) return false;
    if (getBurnAfterReadingLength()
        != other.getBurnAfterReadingLength()) return false;
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
    hash = (37 * hash) + MSG_ID_FIELD_NUMBER;
    hash = (53 * hash) + getMsgId();
    hash = (37 * hash) + MSG_TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getMsgType();
    hash = (37 * hash) + FROM_ID_FIELD_NUMBER;
    hash = (53 * hash) + getFromId();
    hash = (37 * hash) + TO_ID_FIELD_NUMBER;
    hash = (53 * hash) + getToId();
    hash = (37 * hash) + CONTENT_FIELD_NUMBER;
    hash = (53 * hash) + getContent().hashCode();
    hash = (37 * hash) + ENTITY_URL_FIELD_NUMBER;
    hash = (53 * hash) + getEntityUrl().hashCode();
    hash = (37 * hash) + CREATE_TIME_FIELD_NUMBER;
    hash = (53 * hash) + getCreateTime().hashCode();
    hash = (37 * hash) + MESSAGE_OFFLINE_STATUS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getMessageOfflineStatus());
    hash = (37 * hash) + BURN_AFTER_READING_STATUS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getBurnAfterReadingStatus());
    hash = (37 * hash) + BURN_AFTER_READING_LENGTH_FIELD_NUMBER;
    hash = (53 * hash) + getBurnAfterReadingLength();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.lanjiu.im.regist.FriendMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.regist.FriendMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.regist.FriendMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.regist.FriendMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.regist.FriendMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.regist.FriendMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.regist.FriendMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.regist.FriendMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.im.regist.FriendMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.regist.FriendMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.im.regist.FriendMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.regist.FriendMessage parseFrom(
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
  public static Builder newBuilder(com.lanjiu.im.regist.FriendMessage prototype) {
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
   * Protobuf type {@code com.lanjiu.im.regist.FriendMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.lanjiu.im.regist.FriendMessage)
      com.lanjiu.im.regist.FriendMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.lanjiu.im.regist.MessageFriendStorageProto.internal_static_com_lanjiu_im_regist_FriendMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.lanjiu.im.regist.MessageFriendStorageProto.internal_static_com_lanjiu_im_regist_FriendMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.lanjiu.im.regist.FriendMessage.class, com.lanjiu.im.regist.FriendMessage.Builder.class);
    }

    // Construct using com.lanjiu.im.regist.FriendMessage.newBuilder()
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
      msgId_ = 0;

      msgType_ = 0;

      fromId_ = 0;

      toId_ = 0;

      content_ = "";

      entityUrl_ = "";

      createTime_ = "";

      messageOfflineStatus_ = false;

      burnAfterReadingStatus_ = false;

      burnAfterReadingLength_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.lanjiu.im.regist.MessageFriendStorageProto.internal_static_com_lanjiu_im_regist_FriendMessage_descriptor;
    }

    @java.lang.Override
    public com.lanjiu.im.regist.FriendMessage getDefaultInstanceForType() {
      return com.lanjiu.im.regist.FriendMessage.getDefaultInstance();
    }

    @java.lang.Override
    public com.lanjiu.im.regist.FriendMessage build() {
      com.lanjiu.im.regist.FriendMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.lanjiu.im.regist.FriendMessage buildPartial() {
      com.lanjiu.im.regist.FriendMessage result = new com.lanjiu.im.regist.FriendMessage(this);
      result.msgId_ = msgId_;
      result.msgType_ = msgType_;
      result.fromId_ = fromId_;
      result.toId_ = toId_;
      result.content_ = content_;
      result.entityUrl_ = entityUrl_;
      result.createTime_ = createTime_;
      result.messageOfflineStatus_ = messageOfflineStatus_;
      result.burnAfterReadingStatus_ = burnAfterReadingStatus_;
      result.burnAfterReadingLength_ = burnAfterReadingLength_;
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
      if (other instanceof com.lanjiu.im.regist.FriendMessage) {
        return mergeFrom((com.lanjiu.im.regist.FriendMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.lanjiu.im.regist.FriendMessage other) {
      if (other == com.lanjiu.im.regist.FriendMessage.getDefaultInstance()) return this;
      if (other.getMsgId() != 0) {
        setMsgId(other.getMsgId());
      }
      if (other.getMsgType() != 0) {
        setMsgType(other.getMsgType());
      }
      if (other.getFromId() != 0) {
        setFromId(other.getFromId());
      }
      if (other.getToId() != 0) {
        setToId(other.getToId());
      }
      if (!other.getContent().isEmpty()) {
        content_ = other.content_;
        onChanged();
      }
      if (!other.getEntityUrl().isEmpty()) {
        entityUrl_ = other.entityUrl_;
        onChanged();
      }
      if (!other.getCreateTime().isEmpty()) {
        createTime_ = other.createTime_;
        onChanged();
      }
      if (other.getMessageOfflineStatus() != false) {
        setMessageOfflineStatus(other.getMessageOfflineStatus());
      }
      if (other.getBurnAfterReadingStatus() != false) {
        setBurnAfterReadingStatus(other.getBurnAfterReadingStatus());
      }
      if (other.getBurnAfterReadingLength() != 0) {
        setBurnAfterReadingLength(other.getBurnAfterReadingLength());
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
      com.lanjiu.im.regist.FriendMessage parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.lanjiu.im.regist.FriendMessage) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int msgId_ ;
    /**
     * <code>int32 msg_id = 1;</code>
     * @return The msgId.
     */
    public int getMsgId() {
      return msgId_;
    }
    /**
     * <code>int32 msg_id = 1;</code>
     * @param value The msgId to set.
     * @return This builder for chaining.
     */
    public Builder setMsgId(int value) {
      
      msgId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 msg_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearMsgId() {
      
      msgId_ = 0;
      onChanged();
      return this;
    }

    private int msgType_ ;
    /**
     * <code>int32 msg_type = 2;</code>
     * @return The msgType.
     */
    public int getMsgType() {
      return msgType_;
    }
    /**
     * <code>int32 msg_type = 2;</code>
     * @param value The msgType to set.
     * @return This builder for chaining.
     */
    public Builder setMsgType(int value) {
      
      msgType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 msg_type = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMsgType() {
      
      msgType_ = 0;
      onChanged();
      return this;
    }

    private int fromId_ ;
    /**
     * <code>int32 from_id = 3;</code>
     * @return The fromId.
     */
    public int getFromId() {
      return fromId_;
    }
    /**
     * <code>int32 from_id = 3;</code>
     * @param value The fromId to set.
     * @return This builder for chaining.
     */
    public Builder setFromId(int value) {
      
      fromId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 from_id = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearFromId() {
      
      fromId_ = 0;
      onChanged();
      return this;
    }

    private int toId_ ;
    /**
     * <code>int32 to_id = 4;</code>
     * @return The toId.
     */
    public int getToId() {
      return toId_;
    }
    /**
     * <code>int32 to_id = 4;</code>
     * @param value The toId to set.
     * @return This builder for chaining.
     */
    public Builder setToId(int value) {
      
      toId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 to_id = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearToId() {
      
      toId_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object content_ = "";
    /**
     * <code>string content = 5;</code>
     * @return The content.
     */
    public java.lang.String getContent() {
      java.lang.Object ref = content_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        content_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string content = 5;</code>
     * @return The bytes for content.
     */
    public com.google.protobuf.ByteString
        getContentBytes() {
      java.lang.Object ref = content_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        content_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string content = 5;</code>
     * @param value The content to set.
     * @return This builder for chaining.
     */
    public Builder setContent(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      content_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string content = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearContent() {
      
      content_ = getDefaultInstance().getContent();
      onChanged();
      return this;
    }
    /**
     * <code>string content = 5;</code>
     * @param value The bytes for content to set.
     * @return This builder for chaining.
     */
    public Builder setContentBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      content_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object entityUrl_ = "";
    /**
     * <code>string entity_url = 6;</code>
     * @return The entityUrl.
     */
    public java.lang.String getEntityUrl() {
      java.lang.Object ref = entityUrl_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        entityUrl_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string entity_url = 6;</code>
     * @return The bytes for entityUrl.
     */
    public com.google.protobuf.ByteString
        getEntityUrlBytes() {
      java.lang.Object ref = entityUrl_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        entityUrl_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string entity_url = 6;</code>
     * @param value The entityUrl to set.
     * @return This builder for chaining.
     */
    public Builder setEntityUrl(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      entityUrl_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string entity_url = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearEntityUrl() {
      
      entityUrl_ = getDefaultInstance().getEntityUrl();
      onChanged();
      return this;
    }
    /**
     * <code>string entity_url = 6;</code>
     * @param value The bytes for entityUrl to set.
     * @return This builder for chaining.
     */
    public Builder setEntityUrlBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      entityUrl_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object createTime_ = "";
    /**
     * <code>string create_time = 7;</code>
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
     * <code>string create_time = 7;</code>
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
     * <code>string create_time = 7;</code>
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
     * <code>string create_time = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearCreateTime() {
      
      createTime_ = getDefaultInstance().getCreateTime();
      onChanged();
      return this;
    }
    /**
     * <code>string create_time = 7;</code>
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

    private boolean messageOfflineStatus_ ;
    /**
     * <code>bool message_offline_status = 8;</code>
     * @return The messageOfflineStatus.
     */
    public boolean getMessageOfflineStatus() {
      return messageOfflineStatus_;
    }
    /**
     * <code>bool message_offline_status = 8;</code>
     * @param value The messageOfflineStatus to set.
     * @return This builder for chaining.
     */
    public Builder setMessageOfflineStatus(boolean value) {
      
      messageOfflineStatus_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool message_offline_status = 8;</code>
     * @return This builder for chaining.
     */
    public Builder clearMessageOfflineStatus() {
      
      messageOfflineStatus_ = false;
      onChanged();
      return this;
    }

    private boolean burnAfterReadingStatus_ ;
    /**
     * <code>bool burn_after_reading_status = 9;</code>
     * @return The burnAfterReadingStatus.
     */
    public boolean getBurnAfterReadingStatus() {
      return burnAfterReadingStatus_;
    }
    /**
     * <code>bool burn_after_reading_status = 9;</code>
     * @param value The burnAfterReadingStatus to set.
     * @return This builder for chaining.
     */
    public Builder setBurnAfterReadingStatus(boolean value) {
      
      burnAfterReadingStatus_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool burn_after_reading_status = 9;</code>
     * @return This builder for chaining.
     */
    public Builder clearBurnAfterReadingStatus() {
      
      burnAfterReadingStatus_ = false;
      onChanged();
      return this;
    }

    private int burnAfterReadingLength_ ;
    /**
     * <code>int32 burn_after_reading_length = 10;</code>
     * @return The burnAfterReadingLength.
     */
    public int getBurnAfterReadingLength() {
      return burnAfterReadingLength_;
    }
    /**
     * <code>int32 burn_after_reading_length = 10;</code>
     * @param value The burnAfterReadingLength to set.
     * @return This builder for chaining.
     */
    public Builder setBurnAfterReadingLength(int value) {
      
      burnAfterReadingLength_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 burn_after_reading_length = 10;</code>
     * @return This builder for chaining.
     */
    public Builder clearBurnAfterReadingLength() {
      
      burnAfterReadingLength_ = 0;
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


    // @@protoc_insertion_point(builder_scope:com.lanjiu.im.regist.FriendMessage)
  }

  // @@protoc_insertion_point(class_scope:com.lanjiu.im.regist.FriendMessage)
  private static final com.lanjiu.im.regist.FriendMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.lanjiu.im.regist.FriendMessage();
  }

  public static com.lanjiu.im.regist.FriendMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FriendMessage>
      PARSER = new com.google.protobuf.AbstractParser<FriendMessage>() {
    @java.lang.Override
    public FriendMessage parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FriendMessage(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FriendMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FriendMessage> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.lanjiu.im.regist.FriendMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

