// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: information_other_storage_grpc.proto

package com.lanjiu.im.grpc;

/**
 * <pre>
 * 游客用户
 * </pre>
 *
 * Protobuf type {@code com.lanjiu.im.grpc.Tourists}
 */
public  final class Tourists extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.lanjiu.im.grpc.Tourists)
    TouristsOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Tourists.newBuilder() to construct.
  private Tourists(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Tourists() {
    temporaryId_ = "";
    ipAddress_ = "";
    macAddress_ = "";
    ime_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Tourists();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Tourists(
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

            temporaryId_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            ipAddress_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            macAddress_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            ime_ = s;
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
    return com.lanjiu.im.grpc.FileStorageProto.internal_static_com_lanjiu_im_grpc_Tourists_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.lanjiu.im.grpc.FileStorageProto.internal_static_com_lanjiu_im_grpc_Tourists_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.lanjiu.im.grpc.Tourists.class, com.lanjiu.im.grpc.Tourists.Builder.class);
  }

  public static final int TEMPORARY_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object temporaryId_;
  /**
   * <pre>
   * 临时ID
   * </pre>
   *
   * <code>string temporary_id = 1;</code>
   * @return The temporaryId.
   */
  public java.lang.String getTemporaryId() {
    java.lang.Object ref = temporaryId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      temporaryId_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * 临时ID
   * </pre>
   *
   * <code>string temporary_id = 1;</code>
   * @return The bytes for temporaryId.
   */
  public com.google.protobuf.ByteString
      getTemporaryIdBytes() {
    java.lang.Object ref = temporaryId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      temporaryId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int IP_ADDRESS_FIELD_NUMBER = 2;
  private volatile java.lang.Object ipAddress_;
  /**
   * <pre>
   *IP地址
   * </pre>
   *
   * <code>string ip_address = 2;</code>
   * @return The ipAddress.
   */
  public java.lang.String getIpAddress() {
    java.lang.Object ref = ipAddress_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      ipAddress_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *IP地址
   * </pre>
   *
   * <code>string ip_address = 2;</code>
   * @return The bytes for ipAddress.
   */
  public com.google.protobuf.ByteString
      getIpAddressBytes() {
    java.lang.Object ref = ipAddress_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      ipAddress_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MAC_ADDRESS_FIELD_NUMBER = 3;
  private volatile java.lang.Object macAddress_;
  /**
   * <pre>
   *MAC地址
   * </pre>
   *
   * <code>string mac_address = 3;</code>
   * @return The macAddress.
   */
  public java.lang.String getMacAddress() {
    java.lang.Object ref = macAddress_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      macAddress_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *MAC地址
   * </pre>
   *
   * <code>string mac_address = 3;</code>
   * @return The bytes for macAddress.
   */
  public com.google.protobuf.ByteString
      getMacAddressBytes() {
    java.lang.Object ref = macAddress_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      macAddress_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int IME_FIELD_NUMBER = 4;
  private volatile java.lang.Object ime_;
  /**
   * <pre>
   * IME码
   * </pre>
   *
   * <code>string ime = 4;</code>
   * @return The ime.
   */
  public java.lang.String getIme() {
    java.lang.Object ref = ime_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      ime_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * IME码
   * </pre>
   *
   * <code>string ime = 4;</code>
   * @return The bytes for ime.
   */
  public com.google.protobuf.ByteString
      getImeBytes() {
    java.lang.Object ref = ime_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      ime_ = b;
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
    if (!getTemporaryIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, temporaryId_);
    }
    if (!getIpAddressBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, ipAddress_);
    }
    if (!getMacAddressBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, macAddress_);
    }
    if (!getImeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, ime_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getTemporaryIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, temporaryId_);
    }
    if (!getIpAddressBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, ipAddress_);
    }
    if (!getMacAddressBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, macAddress_);
    }
    if (!getImeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, ime_);
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
    if (!(obj instanceof com.lanjiu.im.grpc.Tourists)) {
      return super.equals(obj);
    }
    com.lanjiu.im.grpc.Tourists other = (com.lanjiu.im.grpc.Tourists) obj;

    if (!getTemporaryId()
        .equals(other.getTemporaryId())) return false;
    if (!getIpAddress()
        .equals(other.getIpAddress())) return false;
    if (!getMacAddress()
        .equals(other.getMacAddress())) return false;
    if (!getIme()
        .equals(other.getIme())) return false;
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
    hash = (37 * hash) + TEMPORARY_ID_FIELD_NUMBER;
    hash = (53 * hash) + getTemporaryId().hashCode();
    hash = (37 * hash) + IP_ADDRESS_FIELD_NUMBER;
    hash = (53 * hash) + getIpAddress().hashCode();
    hash = (37 * hash) + MAC_ADDRESS_FIELD_NUMBER;
    hash = (53 * hash) + getMacAddress().hashCode();
    hash = (37 * hash) + IME_FIELD_NUMBER;
    hash = (53 * hash) + getIme().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.lanjiu.im.grpc.Tourists parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.Tourists parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.Tourists parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.Tourists parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.Tourists parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.Tourists parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.Tourists parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.Tourists parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.Tourists parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.Tourists parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.Tourists parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.Tourists parseFrom(
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
  public static Builder newBuilder(com.lanjiu.im.grpc.Tourists prototype) {
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
   * 游客用户
   * </pre>
   *
   * Protobuf type {@code com.lanjiu.im.grpc.Tourists}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.lanjiu.im.grpc.Tourists)
      com.lanjiu.im.grpc.TouristsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.lanjiu.im.grpc.FileStorageProto.internal_static_com_lanjiu_im_grpc_Tourists_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.lanjiu.im.grpc.FileStorageProto.internal_static_com_lanjiu_im_grpc_Tourists_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.lanjiu.im.grpc.Tourists.class, com.lanjiu.im.grpc.Tourists.Builder.class);
    }

    // Construct using com.lanjiu.im.grpc.Tourists.newBuilder()
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
      temporaryId_ = "";

      ipAddress_ = "";

      macAddress_ = "";

      ime_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.lanjiu.im.grpc.FileStorageProto.internal_static_com_lanjiu_im_grpc_Tourists_descriptor;
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.Tourists getDefaultInstanceForType() {
      return com.lanjiu.im.grpc.Tourists.getDefaultInstance();
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.Tourists build() {
      com.lanjiu.im.grpc.Tourists result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.Tourists buildPartial() {
      com.lanjiu.im.grpc.Tourists result = new com.lanjiu.im.grpc.Tourists(this);
      result.temporaryId_ = temporaryId_;
      result.ipAddress_ = ipAddress_;
      result.macAddress_ = macAddress_;
      result.ime_ = ime_;
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
      if (other instanceof com.lanjiu.im.grpc.Tourists) {
        return mergeFrom((com.lanjiu.im.grpc.Tourists)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.lanjiu.im.grpc.Tourists other) {
      if (other == com.lanjiu.im.grpc.Tourists.getDefaultInstance()) return this;
      if (!other.getTemporaryId().isEmpty()) {
        temporaryId_ = other.temporaryId_;
        onChanged();
      }
      if (!other.getIpAddress().isEmpty()) {
        ipAddress_ = other.ipAddress_;
        onChanged();
      }
      if (!other.getMacAddress().isEmpty()) {
        macAddress_ = other.macAddress_;
        onChanged();
      }
      if (!other.getIme().isEmpty()) {
        ime_ = other.ime_;
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
      com.lanjiu.im.grpc.Tourists parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.lanjiu.im.grpc.Tourists) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object temporaryId_ = "";
    /**
     * <pre>
     * 临时ID
     * </pre>
     *
     * <code>string temporary_id = 1;</code>
     * @return The temporaryId.
     */
    public java.lang.String getTemporaryId() {
      java.lang.Object ref = temporaryId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        temporaryId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * 临时ID
     * </pre>
     *
     * <code>string temporary_id = 1;</code>
     * @return The bytes for temporaryId.
     */
    public com.google.protobuf.ByteString
        getTemporaryIdBytes() {
      java.lang.Object ref = temporaryId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        temporaryId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * 临时ID
     * </pre>
     *
     * <code>string temporary_id = 1;</code>
     * @param value The temporaryId to set.
     * @return This builder for chaining.
     */
    public Builder setTemporaryId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      temporaryId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 临时ID
     * </pre>
     *
     * <code>string temporary_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearTemporaryId() {
      
      temporaryId_ = getDefaultInstance().getTemporaryId();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 临时ID
     * </pre>
     *
     * <code>string temporary_id = 1;</code>
     * @param value The bytes for temporaryId to set.
     * @return This builder for chaining.
     */
    public Builder setTemporaryIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      temporaryId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object ipAddress_ = "";
    /**
     * <pre>
     *IP地址
     * </pre>
     *
     * <code>string ip_address = 2;</code>
     * @return The ipAddress.
     */
    public java.lang.String getIpAddress() {
      java.lang.Object ref = ipAddress_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        ipAddress_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *IP地址
     * </pre>
     *
     * <code>string ip_address = 2;</code>
     * @return The bytes for ipAddress.
     */
    public com.google.protobuf.ByteString
        getIpAddressBytes() {
      java.lang.Object ref = ipAddress_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        ipAddress_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *IP地址
     * </pre>
     *
     * <code>string ip_address = 2;</code>
     * @param value The ipAddress to set.
     * @return This builder for chaining.
     */
    public Builder setIpAddress(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      ipAddress_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *IP地址
     * </pre>
     *
     * <code>string ip_address = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearIpAddress() {
      
      ipAddress_ = getDefaultInstance().getIpAddress();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *IP地址
     * </pre>
     *
     * <code>string ip_address = 2;</code>
     * @param value The bytes for ipAddress to set.
     * @return This builder for chaining.
     */
    public Builder setIpAddressBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      ipAddress_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object macAddress_ = "";
    /**
     * <pre>
     *MAC地址
     * </pre>
     *
     * <code>string mac_address = 3;</code>
     * @return The macAddress.
     */
    public java.lang.String getMacAddress() {
      java.lang.Object ref = macAddress_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        macAddress_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *MAC地址
     * </pre>
     *
     * <code>string mac_address = 3;</code>
     * @return The bytes for macAddress.
     */
    public com.google.protobuf.ByteString
        getMacAddressBytes() {
      java.lang.Object ref = macAddress_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        macAddress_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *MAC地址
     * </pre>
     *
     * <code>string mac_address = 3;</code>
     * @param value The macAddress to set.
     * @return This builder for chaining.
     */
    public Builder setMacAddress(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      macAddress_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *MAC地址
     * </pre>
     *
     * <code>string mac_address = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearMacAddress() {
      
      macAddress_ = getDefaultInstance().getMacAddress();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *MAC地址
     * </pre>
     *
     * <code>string mac_address = 3;</code>
     * @param value The bytes for macAddress to set.
     * @return This builder for chaining.
     */
    public Builder setMacAddressBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      macAddress_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object ime_ = "";
    /**
     * <pre>
     * IME码
     * </pre>
     *
     * <code>string ime = 4;</code>
     * @return The ime.
     */
    public java.lang.String getIme() {
      java.lang.Object ref = ime_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        ime_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * IME码
     * </pre>
     *
     * <code>string ime = 4;</code>
     * @return The bytes for ime.
     */
    public com.google.protobuf.ByteString
        getImeBytes() {
      java.lang.Object ref = ime_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        ime_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * IME码
     * </pre>
     *
     * <code>string ime = 4;</code>
     * @param value The ime to set.
     * @return This builder for chaining.
     */
    public Builder setIme(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      ime_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * IME码
     * </pre>
     *
     * <code>string ime = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearIme() {
      
      ime_ = getDefaultInstance().getIme();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * IME码
     * </pre>
     *
     * <code>string ime = 4;</code>
     * @param value The bytes for ime to set.
     * @return This builder for chaining.
     */
    public Builder setImeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      ime_ = value;
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


    // @@protoc_insertion_point(builder_scope:com.lanjiu.im.grpc.Tourists)
  }

  // @@protoc_insertion_point(class_scope:com.lanjiu.im.grpc.Tourists)
  private static final com.lanjiu.im.grpc.Tourists DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.lanjiu.im.grpc.Tourists();
  }

  public static com.lanjiu.im.grpc.Tourists getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Tourists>
      PARSER = new com.google.protobuf.AbstractParser<Tourists>() {
    @java.lang.Override
    public Tourists parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Tourists(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Tourists> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Tourists> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.lanjiu.im.grpc.Tourists getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

