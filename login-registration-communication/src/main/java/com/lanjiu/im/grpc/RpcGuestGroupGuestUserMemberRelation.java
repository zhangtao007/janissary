// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: information_other_storage_grpc.proto

package com.lanjiu.im.grpc;

/**
 * Protobuf type {@code com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation}
 */
public  final class RpcGuestGroupGuestUserMemberRelation extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation)
    RpcGuestGroupGuestUserMemberRelationOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RpcGuestGroupGuestUserMemberRelation.newBuilder() to construct.
  private RpcGuestGroupGuestUserMemberRelation(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RpcGuestGroupGuestUserMemberRelation() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RpcGuestGroupGuestUserMemberRelation();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RpcGuestGroupGuestUserMemberRelation(
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

            guestGroupId_ = input.readInt32();
            break;
          }
          case 16: {

            guestUserMemberId_ = input.readInt32();
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
    return com.lanjiu.im.grpc.InformationStorageProto.internal_static_com_lanjiu_im_grpc_RpcGuestGroupGuestUserMemberRelation_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.lanjiu.im.grpc.InformationStorageProto.internal_static_com_lanjiu_im_grpc_RpcGuestGroupGuestUserMemberRelation_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation.class, com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation.Builder.class);
  }

  public static final int GUEST_GROUP_ID_FIELD_NUMBER = 1;
  private int guestGroupId_;
  /**
   * <code>int32 guest_group_id = 1;</code>
   * @return The guestGroupId.
   */
  public int getGuestGroupId() {
    return guestGroupId_;
  }

  public static final int GUEST_USER_MEMBER_ID_FIELD_NUMBER = 2;
  private int guestUserMemberId_;
  /**
   * <code>int32 guest_user_member_id = 2;</code>
   * @return The guestUserMemberId.
   */
  public int getGuestUserMemberId() {
    return guestUserMemberId_;
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
    if (guestGroupId_ != 0) {
      output.writeInt32(1, guestGroupId_);
    }
    if (guestUserMemberId_ != 0) {
      output.writeInt32(2, guestUserMemberId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (guestGroupId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, guestGroupId_);
    }
    if (guestUserMemberId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, guestUserMemberId_);
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
    if (!(obj instanceof com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation)) {
      return super.equals(obj);
    }
    com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation other = (com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation) obj;

    if (getGuestGroupId()
        != other.getGuestGroupId()) return false;
    if (getGuestUserMemberId()
        != other.getGuestUserMemberId()) return false;
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
    hash = (37 * hash) + GUEST_GROUP_ID_FIELD_NUMBER;
    hash = (53 * hash) + getGuestGroupId();
    hash = (37 * hash) + GUEST_USER_MEMBER_ID_FIELD_NUMBER;
    hash = (53 * hash) + getGuestUserMemberId();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation parseFrom(
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
  public static Builder newBuilder(com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation prototype) {
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
   * Protobuf type {@code com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation)
      com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelationOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.lanjiu.im.grpc.InformationStorageProto.internal_static_com_lanjiu_im_grpc_RpcGuestGroupGuestUserMemberRelation_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.lanjiu.im.grpc.InformationStorageProto.internal_static_com_lanjiu_im_grpc_RpcGuestGroupGuestUserMemberRelation_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation.class, com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation.Builder.class);
    }

    // Construct using com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation.newBuilder()
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
      guestGroupId_ = 0;

      guestUserMemberId_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.lanjiu.im.grpc.InformationStorageProto.internal_static_com_lanjiu_im_grpc_RpcGuestGroupGuestUserMemberRelation_descriptor;
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation getDefaultInstanceForType() {
      return com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation.getDefaultInstance();
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation build() {
      com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation buildPartial() {
      com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation result = new com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation(this);
      result.guestGroupId_ = guestGroupId_;
      result.guestUserMemberId_ = guestUserMemberId_;
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
      if (other instanceof com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation) {
        return mergeFrom((com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation other) {
      if (other == com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation.getDefaultInstance()) return this;
      if (other.getGuestGroupId() != 0) {
        setGuestGroupId(other.getGuestGroupId());
      }
      if (other.getGuestUserMemberId() != 0) {
        setGuestUserMemberId(other.getGuestUserMemberId());
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
      com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int guestGroupId_ ;
    /**
     * <code>int32 guest_group_id = 1;</code>
     * @return The guestGroupId.
     */
    public int getGuestGroupId() {
      return guestGroupId_;
    }
    /**
     * <code>int32 guest_group_id = 1;</code>
     * @param value The guestGroupId to set.
     * @return This builder for chaining.
     */
    public Builder setGuestGroupId(int value) {
      
      guestGroupId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 guest_group_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearGuestGroupId() {
      
      guestGroupId_ = 0;
      onChanged();
      return this;
    }

    private int guestUserMemberId_ ;
    /**
     * <code>int32 guest_user_member_id = 2;</code>
     * @return The guestUserMemberId.
     */
    public int getGuestUserMemberId() {
      return guestUserMemberId_;
    }
    /**
     * <code>int32 guest_user_member_id = 2;</code>
     * @param value The guestUserMemberId to set.
     * @return This builder for chaining.
     */
    public Builder setGuestUserMemberId(int value) {
      
      guestUserMemberId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 guest_user_member_id = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearGuestUserMemberId() {
      
      guestUserMemberId_ = 0;
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


    // @@protoc_insertion_point(builder_scope:com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation)
  }

  // @@protoc_insertion_point(class_scope:com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation)
  private static final com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation();
  }

  public static com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RpcGuestGroupGuestUserMemberRelation>
      PARSER = new com.google.protobuf.AbstractParser<RpcGuestGroupGuestUserMemberRelation>() {
    @java.lang.Override
    public RpcGuestGroupGuestUserMemberRelation parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RpcGuestGroupGuestUserMemberRelation(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RpcGuestGroupGuestUserMemberRelation> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RpcGuestGroupGuestUserMemberRelation> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.lanjiu.im.grpc.RpcGuestGroupGuestUserMemberRelation getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

