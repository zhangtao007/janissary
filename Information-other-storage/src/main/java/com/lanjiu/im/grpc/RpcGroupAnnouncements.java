// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: information_other_storage_grpc.proto

package com.lanjiu.im.grpc;

/**
 * Protobuf type {@code com.lanjiu.im.grpc.RpcGroupAnnouncements}
 */
public  final class RpcGroupAnnouncements extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.lanjiu.im.grpc.RpcGroupAnnouncements)
    RpcGroupAnnouncementsOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RpcGroupAnnouncements.newBuilder() to construct.
  private RpcGroupAnnouncements(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RpcGroupAnnouncements() {
    announcementTitle_ = "";
    announcementContent_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RpcGroupAnnouncements();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RpcGroupAnnouncements(
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

            groupAnnouncementId_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            announcementTitle_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            announcementContent_ = s;
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
    return com.lanjiu.im.grpc.InformationStorageProto.internal_static_com_lanjiu_im_grpc_RpcGroupAnnouncements_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.lanjiu.im.grpc.InformationStorageProto.internal_static_com_lanjiu_im_grpc_RpcGroupAnnouncements_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.lanjiu.im.grpc.RpcGroupAnnouncements.class, com.lanjiu.im.grpc.RpcGroupAnnouncements.Builder.class);
  }

  public static final int GROUP_ANNOUNCEMENT_ID_FIELD_NUMBER = 1;
  private int groupAnnouncementId_;
  /**
   * <code>int32 group_announcement_id = 1;</code>
   * @return The groupAnnouncementId.
   */
  public int getGroupAnnouncementId() {
    return groupAnnouncementId_;
  }

  public static final int ANNOUNCEMENT_TITLE_FIELD_NUMBER = 2;
  private volatile java.lang.Object announcementTitle_;
  /**
   * <code>string announcement_title = 2;</code>
   * @return The announcementTitle.
   */
  public java.lang.String getAnnouncementTitle() {
    java.lang.Object ref = announcementTitle_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      announcementTitle_ = s;
      return s;
    }
  }
  /**
   * <code>string announcement_title = 2;</code>
   * @return The bytes for announcementTitle.
   */
  public com.google.protobuf.ByteString
      getAnnouncementTitleBytes() {
    java.lang.Object ref = announcementTitle_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      announcementTitle_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ANNOUNCEMENT_CONTENT_FIELD_NUMBER = 3;
  private volatile java.lang.Object announcementContent_;
  /**
   * <code>string announcement_content = 3;</code>
   * @return The announcementContent.
   */
  public java.lang.String getAnnouncementContent() {
    java.lang.Object ref = announcementContent_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      announcementContent_ = s;
      return s;
    }
  }
  /**
   * <code>string announcement_content = 3;</code>
   * @return The bytes for announcementContent.
   */
  public com.google.protobuf.ByteString
      getAnnouncementContentBytes() {
    java.lang.Object ref = announcementContent_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      announcementContent_ = b;
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
    if (groupAnnouncementId_ != 0) {
      output.writeInt32(1, groupAnnouncementId_);
    }
    if (!getAnnouncementTitleBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, announcementTitle_);
    }
    if (!getAnnouncementContentBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, announcementContent_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (groupAnnouncementId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, groupAnnouncementId_);
    }
    if (!getAnnouncementTitleBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, announcementTitle_);
    }
    if (!getAnnouncementContentBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, announcementContent_);
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
    if (!(obj instanceof com.lanjiu.im.grpc.RpcGroupAnnouncements)) {
      return super.equals(obj);
    }
    com.lanjiu.im.grpc.RpcGroupAnnouncements other = (com.lanjiu.im.grpc.RpcGroupAnnouncements) obj;

    if (getGroupAnnouncementId()
        != other.getGroupAnnouncementId()) return false;
    if (!getAnnouncementTitle()
        .equals(other.getAnnouncementTitle())) return false;
    if (!getAnnouncementContent()
        .equals(other.getAnnouncementContent())) return false;
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
    hash = (37 * hash) + GROUP_ANNOUNCEMENT_ID_FIELD_NUMBER;
    hash = (53 * hash) + getGroupAnnouncementId();
    hash = (37 * hash) + ANNOUNCEMENT_TITLE_FIELD_NUMBER;
    hash = (53 * hash) + getAnnouncementTitle().hashCode();
    hash = (37 * hash) + ANNOUNCEMENT_CONTENT_FIELD_NUMBER;
    hash = (53 * hash) + getAnnouncementContent().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.lanjiu.im.grpc.RpcGroupAnnouncements parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.RpcGroupAnnouncements parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.RpcGroupAnnouncements parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.RpcGroupAnnouncements parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.RpcGroupAnnouncements parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.RpcGroupAnnouncements parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.RpcGroupAnnouncements parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.RpcGroupAnnouncements parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.RpcGroupAnnouncements parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.RpcGroupAnnouncements parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.RpcGroupAnnouncements parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.RpcGroupAnnouncements parseFrom(
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
  public static Builder newBuilder(com.lanjiu.im.grpc.RpcGroupAnnouncements prototype) {
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
   * Protobuf type {@code com.lanjiu.im.grpc.RpcGroupAnnouncements}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.lanjiu.im.grpc.RpcGroupAnnouncements)
      com.lanjiu.im.grpc.RpcGroupAnnouncementsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.lanjiu.im.grpc.InformationStorageProto.internal_static_com_lanjiu_im_grpc_RpcGroupAnnouncements_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.lanjiu.im.grpc.InformationStorageProto.internal_static_com_lanjiu_im_grpc_RpcGroupAnnouncements_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.lanjiu.im.grpc.RpcGroupAnnouncements.class, com.lanjiu.im.grpc.RpcGroupAnnouncements.Builder.class);
    }

    // Construct using com.lanjiu.im.grpc.RpcGroupAnnouncements.newBuilder()
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
      groupAnnouncementId_ = 0;

      announcementTitle_ = "";

      announcementContent_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.lanjiu.im.grpc.InformationStorageProto.internal_static_com_lanjiu_im_grpc_RpcGroupAnnouncements_descriptor;
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.RpcGroupAnnouncements getDefaultInstanceForType() {
      return com.lanjiu.im.grpc.RpcGroupAnnouncements.getDefaultInstance();
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.RpcGroupAnnouncements build() {
      com.lanjiu.im.grpc.RpcGroupAnnouncements result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.RpcGroupAnnouncements buildPartial() {
      com.lanjiu.im.grpc.RpcGroupAnnouncements result = new com.lanjiu.im.grpc.RpcGroupAnnouncements(this);
      result.groupAnnouncementId_ = groupAnnouncementId_;
      result.announcementTitle_ = announcementTitle_;
      result.announcementContent_ = announcementContent_;
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
      if (other instanceof com.lanjiu.im.grpc.RpcGroupAnnouncements) {
        return mergeFrom((com.lanjiu.im.grpc.RpcGroupAnnouncements)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.lanjiu.im.grpc.RpcGroupAnnouncements other) {
      if (other == com.lanjiu.im.grpc.RpcGroupAnnouncements.getDefaultInstance()) return this;
      if (other.getGroupAnnouncementId() != 0) {
        setGroupAnnouncementId(other.getGroupAnnouncementId());
      }
      if (!other.getAnnouncementTitle().isEmpty()) {
        announcementTitle_ = other.announcementTitle_;
        onChanged();
      }
      if (!other.getAnnouncementContent().isEmpty()) {
        announcementContent_ = other.announcementContent_;
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
      com.lanjiu.im.grpc.RpcGroupAnnouncements parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.lanjiu.im.grpc.RpcGroupAnnouncements) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int groupAnnouncementId_ ;
    /**
     * <code>int32 group_announcement_id = 1;</code>
     * @return The groupAnnouncementId.
     */
    public int getGroupAnnouncementId() {
      return groupAnnouncementId_;
    }
    /**
     * <code>int32 group_announcement_id = 1;</code>
     * @param value The groupAnnouncementId to set.
     * @return This builder for chaining.
     */
    public Builder setGroupAnnouncementId(int value) {
      
      groupAnnouncementId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 group_announcement_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearGroupAnnouncementId() {
      
      groupAnnouncementId_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object announcementTitle_ = "";
    /**
     * <code>string announcement_title = 2;</code>
     * @return The announcementTitle.
     */
    public java.lang.String getAnnouncementTitle() {
      java.lang.Object ref = announcementTitle_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        announcementTitle_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string announcement_title = 2;</code>
     * @return The bytes for announcementTitle.
     */
    public com.google.protobuf.ByteString
        getAnnouncementTitleBytes() {
      java.lang.Object ref = announcementTitle_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        announcementTitle_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string announcement_title = 2;</code>
     * @param value The announcementTitle to set.
     * @return This builder for chaining.
     */
    public Builder setAnnouncementTitle(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      announcementTitle_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string announcement_title = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAnnouncementTitle() {
      
      announcementTitle_ = getDefaultInstance().getAnnouncementTitle();
      onChanged();
      return this;
    }
    /**
     * <code>string announcement_title = 2;</code>
     * @param value The bytes for announcementTitle to set.
     * @return This builder for chaining.
     */
    public Builder setAnnouncementTitleBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      announcementTitle_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object announcementContent_ = "";
    /**
     * <code>string announcement_content = 3;</code>
     * @return The announcementContent.
     */
    public java.lang.String getAnnouncementContent() {
      java.lang.Object ref = announcementContent_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        announcementContent_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string announcement_content = 3;</code>
     * @return The bytes for announcementContent.
     */
    public com.google.protobuf.ByteString
        getAnnouncementContentBytes() {
      java.lang.Object ref = announcementContent_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        announcementContent_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string announcement_content = 3;</code>
     * @param value The announcementContent to set.
     * @return This builder for chaining.
     */
    public Builder setAnnouncementContent(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      announcementContent_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string announcement_content = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearAnnouncementContent() {
      
      announcementContent_ = getDefaultInstance().getAnnouncementContent();
      onChanged();
      return this;
    }
    /**
     * <code>string announcement_content = 3;</code>
     * @param value The bytes for announcementContent to set.
     * @return This builder for chaining.
     */
    public Builder setAnnouncementContentBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      announcementContent_ = value;
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


    // @@protoc_insertion_point(builder_scope:com.lanjiu.im.grpc.RpcGroupAnnouncements)
  }

  // @@protoc_insertion_point(class_scope:com.lanjiu.im.grpc.RpcGroupAnnouncements)
  private static final com.lanjiu.im.grpc.RpcGroupAnnouncements DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.lanjiu.im.grpc.RpcGroupAnnouncements();
  }

  public static com.lanjiu.im.grpc.RpcGroupAnnouncements getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RpcGroupAnnouncements>
      PARSER = new com.google.protobuf.AbstractParser<RpcGroupAnnouncements>() {
    @java.lang.Override
    public RpcGroupAnnouncements parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RpcGroupAnnouncements(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RpcGroupAnnouncements> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RpcGroupAnnouncements> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.lanjiu.im.grpc.RpcGroupAnnouncements getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

