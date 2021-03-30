// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: information_other_storage_grpc.proto

package com.lanjiu.im.grpc;

/**
 * <pre>
 * 传输响应
 * </pre>
 *
 * Protobuf type {@code com.lanjiu.im.grpc.GroupMemberNicknameResponse}
 */
public  final class GroupMemberNicknameResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.lanjiu.im.grpc.GroupMemberNicknameResponse)
    GroupMemberNicknameResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GroupMemberNicknameResponse.newBuilder() to construct.
  private GroupMemberNicknameResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GroupMemberNicknameResponse() {
    statusDetail_ = "";
    responseData_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GroupMemberNicknameResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GroupMemberNicknameResponse(
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
            java.lang.String s = input.readStringRequireUtf8();

            statusDetail_ = s;
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              responseData_ = new java.util.ArrayList<com.lanjiu.im.grpc.RpcGroupMemberNickname>();
              mutable_bitField0_ |= 0x00000001;
            }
            responseData_.add(
                input.readMessage(com.lanjiu.im.grpc.RpcGroupMemberNickname.parser(), extensionRegistry));
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
        responseData_ = java.util.Collections.unmodifiableList(responseData_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.lanjiu.im.grpc.InformationStorageProto.internal_static_com_lanjiu_im_grpc_GroupMemberNicknameResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.lanjiu.im.grpc.InformationStorageProto.internal_static_com_lanjiu_im_grpc_GroupMemberNicknameResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.lanjiu.im.grpc.GroupMemberNicknameResponse.class, com.lanjiu.im.grpc.GroupMemberNicknameResponse.Builder.class);
  }

  public static final int STATUS_DETAIL_FIELD_NUMBER = 1;
  private volatile java.lang.Object statusDetail_;
  /**
   * <code>string status_detail = 1;</code>
   * @return The statusDetail.
   */
  public java.lang.String getStatusDetail() {
    java.lang.Object ref = statusDetail_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      statusDetail_ = s;
      return s;
    }
  }
  /**
   * <code>string status_detail = 1;</code>
   * @return The bytes for statusDetail.
   */
  public com.google.protobuf.ByteString
      getStatusDetailBytes() {
    java.lang.Object ref = statusDetail_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      statusDetail_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int RESPONSE_DATA_FIELD_NUMBER = 2;
  private java.util.List<com.lanjiu.im.grpc.RpcGroupMemberNickname> responseData_;
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
   */
  public java.util.List<com.lanjiu.im.grpc.RpcGroupMemberNickname> getResponseDataList() {
    return responseData_;
  }
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
   */
  public java.util.List<? extends com.lanjiu.im.grpc.RpcGroupMemberNicknameOrBuilder> 
      getResponseDataOrBuilderList() {
    return responseData_;
  }
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
   */
  public int getResponseDataCount() {
    return responseData_.size();
  }
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
   */
  public com.lanjiu.im.grpc.RpcGroupMemberNickname getResponseData(int index) {
    return responseData_.get(index);
  }
  /**
   * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
   */
  public com.lanjiu.im.grpc.RpcGroupMemberNicknameOrBuilder getResponseDataOrBuilder(
      int index) {
    return responseData_.get(index);
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
    if (!getStatusDetailBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, statusDetail_);
    }
    for (int i = 0; i < responseData_.size(); i++) {
      output.writeMessage(2, responseData_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getStatusDetailBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, statusDetail_);
    }
    for (int i = 0; i < responseData_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, responseData_.get(i));
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
    if (!(obj instanceof com.lanjiu.im.grpc.GroupMemberNicknameResponse)) {
      return super.equals(obj);
    }
    com.lanjiu.im.grpc.GroupMemberNicknameResponse other = (com.lanjiu.im.grpc.GroupMemberNicknameResponse) obj;

    if (!getStatusDetail()
        .equals(other.getStatusDetail())) return false;
    if (!getResponseDataList()
        .equals(other.getResponseDataList())) return false;
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
    hash = (37 * hash) + STATUS_DETAIL_FIELD_NUMBER;
    hash = (53 * hash) + getStatusDetail().hashCode();
    if (getResponseDataCount() > 0) {
      hash = (37 * hash) + RESPONSE_DATA_FIELD_NUMBER;
      hash = (53 * hash) + getResponseDataList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.lanjiu.im.grpc.GroupMemberNicknameResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.GroupMemberNicknameResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.GroupMemberNicknameResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.GroupMemberNicknameResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.GroupMemberNicknameResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.GroupMemberNicknameResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.GroupMemberNicknameResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.GroupMemberNicknameResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.GroupMemberNicknameResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.GroupMemberNicknameResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.GroupMemberNicknameResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.GroupMemberNicknameResponse parseFrom(
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
  public static Builder newBuilder(com.lanjiu.im.grpc.GroupMemberNicknameResponse prototype) {
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
   * 传输响应
   * </pre>
   *
   * Protobuf type {@code com.lanjiu.im.grpc.GroupMemberNicknameResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.lanjiu.im.grpc.GroupMemberNicknameResponse)
      com.lanjiu.im.grpc.GroupMemberNicknameResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.lanjiu.im.grpc.InformationStorageProto.internal_static_com_lanjiu_im_grpc_GroupMemberNicknameResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.lanjiu.im.grpc.InformationStorageProto.internal_static_com_lanjiu_im_grpc_GroupMemberNicknameResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.lanjiu.im.grpc.GroupMemberNicknameResponse.class, com.lanjiu.im.grpc.GroupMemberNicknameResponse.Builder.class);
    }

    // Construct using com.lanjiu.im.grpc.GroupMemberNicknameResponse.newBuilder()
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
        getResponseDataFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      statusDetail_ = "";

      if (responseDataBuilder_ == null) {
        responseData_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        responseDataBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.lanjiu.im.grpc.InformationStorageProto.internal_static_com_lanjiu_im_grpc_GroupMemberNicknameResponse_descriptor;
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.GroupMemberNicknameResponse getDefaultInstanceForType() {
      return com.lanjiu.im.grpc.GroupMemberNicknameResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.GroupMemberNicknameResponse build() {
      com.lanjiu.im.grpc.GroupMemberNicknameResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.GroupMemberNicknameResponse buildPartial() {
      com.lanjiu.im.grpc.GroupMemberNicknameResponse result = new com.lanjiu.im.grpc.GroupMemberNicknameResponse(this);
      int from_bitField0_ = bitField0_;
      result.statusDetail_ = statusDetail_;
      if (responseDataBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          responseData_ = java.util.Collections.unmodifiableList(responseData_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.responseData_ = responseData_;
      } else {
        result.responseData_ = responseDataBuilder_.build();
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
      if (other instanceof com.lanjiu.im.grpc.GroupMemberNicknameResponse) {
        return mergeFrom((com.lanjiu.im.grpc.GroupMemberNicknameResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.lanjiu.im.grpc.GroupMemberNicknameResponse other) {
      if (other == com.lanjiu.im.grpc.GroupMemberNicknameResponse.getDefaultInstance()) return this;
      if (!other.getStatusDetail().isEmpty()) {
        statusDetail_ = other.statusDetail_;
        onChanged();
      }
      if (responseDataBuilder_ == null) {
        if (!other.responseData_.isEmpty()) {
          if (responseData_.isEmpty()) {
            responseData_ = other.responseData_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureResponseDataIsMutable();
            responseData_.addAll(other.responseData_);
          }
          onChanged();
        }
      } else {
        if (!other.responseData_.isEmpty()) {
          if (responseDataBuilder_.isEmpty()) {
            responseDataBuilder_.dispose();
            responseDataBuilder_ = null;
            responseData_ = other.responseData_;
            bitField0_ = (bitField0_ & ~0x00000001);
            responseDataBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getResponseDataFieldBuilder() : null;
          } else {
            responseDataBuilder_.addAllMessages(other.responseData_);
          }
        }
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
      com.lanjiu.im.grpc.GroupMemberNicknameResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.lanjiu.im.grpc.GroupMemberNicknameResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object statusDetail_ = "";
    /**
     * <code>string status_detail = 1;</code>
     * @return The statusDetail.
     */
    public java.lang.String getStatusDetail() {
      java.lang.Object ref = statusDetail_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        statusDetail_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string status_detail = 1;</code>
     * @return The bytes for statusDetail.
     */
    public com.google.protobuf.ByteString
        getStatusDetailBytes() {
      java.lang.Object ref = statusDetail_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        statusDetail_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string status_detail = 1;</code>
     * @param value The statusDetail to set.
     * @return This builder for chaining.
     */
    public Builder setStatusDetail(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      statusDetail_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string status_detail = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearStatusDetail() {
      
      statusDetail_ = getDefaultInstance().getStatusDetail();
      onChanged();
      return this;
    }
    /**
     * <code>string status_detail = 1;</code>
     * @param value The bytes for statusDetail to set.
     * @return This builder for chaining.
     */
    public Builder setStatusDetailBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      statusDetail_ = value;
      onChanged();
      return this;
    }

    private java.util.List<com.lanjiu.im.grpc.RpcGroupMemberNickname> responseData_ =
      java.util.Collections.emptyList();
    private void ensureResponseDataIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        responseData_ = new java.util.ArrayList<com.lanjiu.im.grpc.RpcGroupMemberNickname>(responseData_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.lanjiu.im.grpc.RpcGroupMemberNickname, com.lanjiu.im.grpc.RpcGroupMemberNickname.Builder, com.lanjiu.im.grpc.RpcGroupMemberNicknameOrBuilder> responseDataBuilder_;

    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public java.util.List<com.lanjiu.im.grpc.RpcGroupMemberNickname> getResponseDataList() {
      if (responseDataBuilder_ == null) {
        return java.util.Collections.unmodifiableList(responseData_);
      } else {
        return responseDataBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public int getResponseDataCount() {
      if (responseDataBuilder_ == null) {
        return responseData_.size();
      } else {
        return responseDataBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public com.lanjiu.im.grpc.RpcGroupMemberNickname getResponseData(int index) {
      if (responseDataBuilder_ == null) {
        return responseData_.get(index);
      } else {
        return responseDataBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public Builder setResponseData(
        int index, com.lanjiu.im.grpc.RpcGroupMemberNickname value) {
      if (responseDataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureResponseDataIsMutable();
        responseData_.set(index, value);
        onChanged();
      } else {
        responseDataBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public Builder setResponseData(
        int index, com.lanjiu.im.grpc.RpcGroupMemberNickname.Builder builderForValue) {
      if (responseDataBuilder_ == null) {
        ensureResponseDataIsMutable();
        responseData_.set(index, builderForValue.build());
        onChanged();
      } else {
        responseDataBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public Builder addResponseData(com.lanjiu.im.grpc.RpcGroupMemberNickname value) {
      if (responseDataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureResponseDataIsMutable();
        responseData_.add(value);
        onChanged();
      } else {
        responseDataBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public Builder addResponseData(
        int index, com.lanjiu.im.grpc.RpcGroupMemberNickname value) {
      if (responseDataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureResponseDataIsMutable();
        responseData_.add(index, value);
        onChanged();
      } else {
        responseDataBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public Builder addResponseData(
        com.lanjiu.im.grpc.RpcGroupMemberNickname.Builder builderForValue) {
      if (responseDataBuilder_ == null) {
        ensureResponseDataIsMutable();
        responseData_.add(builderForValue.build());
        onChanged();
      } else {
        responseDataBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public Builder addResponseData(
        int index, com.lanjiu.im.grpc.RpcGroupMemberNickname.Builder builderForValue) {
      if (responseDataBuilder_ == null) {
        ensureResponseDataIsMutable();
        responseData_.add(index, builderForValue.build());
        onChanged();
      } else {
        responseDataBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public Builder addAllResponseData(
        java.lang.Iterable<? extends com.lanjiu.im.grpc.RpcGroupMemberNickname> values) {
      if (responseDataBuilder_ == null) {
        ensureResponseDataIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, responseData_);
        onChanged();
      } else {
        responseDataBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public Builder clearResponseData() {
      if (responseDataBuilder_ == null) {
        responseData_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        responseDataBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public Builder removeResponseData(int index) {
      if (responseDataBuilder_ == null) {
        ensureResponseDataIsMutable();
        responseData_.remove(index);
        onChanged();
      } else {
        responseDataBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public com.lanjiu.im.grpc.RpcGroupMemberNickname.Builder getResponseDataBuilder(
        int index) {
      return getResponseDataFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public com.lanjiu.im.grpc.RpcGroupMemberNicknameOrBuilder getResponseDataOrBuilder(
        int index) {
      if (responseDataBuilder_ == null) {
        return responseData_.get(index);  } else {
        return responseDataBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public java.util.List<? extends com.lanjiu.im.grpc.RpcGroupMemberNicknameOrBuilder> 
         getResponseDataOrBuilderList() {
      if (responseDataBuilder_ != null) {
        return responseDataBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(responseData_);
      }
    }
    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public com.lanjiu.im.grpc.RpcGroupMemberNickname.Builder addResponseDataBuilder() {
      return getResponseDataFieldBuilder().addBuilder(
          com.lanjiu.im.grpc.RpcGroupMemberNickname.getDefaultInstance());
    }
    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public com.lanjiu.im.grpc.RpcGroupMemberNickname.Builder addResponseDataBuilder(
        int index) {
      return getResponseDataFieldBuilder().addBuilder(
          index, com.lanjiu.im.grpc.RpcGroupMemberNickname.getDefaultInstance());
    }
    /**
     * <code>repeated .com.lanjiu.im.grpc.RpcGroupMemberNickname response_data = 2;</code>
     */
    public java.util.List<com.lanjiu.im.grpc.RpcGroupMemberNickname.Builder> 
         getResponseDataBuilderList() {
      return getResponseDataFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.lanjiu.im.grpc.RpcGroupMemberNickname, com.lanjiu.im.grpc.RpcGroupMemberNickname.Builder, com.lanjiu.im.grpc.RpcGroupMemberNicknameOrBuilder> 
        getResponseDataFieldBuilder() {
      if (responseDataBuilder_ == null) {
        responseDataBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.lanjiu.im.grpc.RpcGroupMemberNickname, com.lanjiu.im.grpc.RpcGroupMemberNickname.Builder, com.lanjiu.im.grpc.RpcGroupMemberNicknameOrBuilder>(
                responseData_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        responseData_ = null;
      }
      return responseDataBuilder_;
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


    // @@protoc_insertion_point(builder_scope:com.lanjiu.im.grpc.GroupMemberNicknameResponse)
  }

  // @@protoc_insertion_point(class_scope:com.lanjiu.im.grpc.GroupMemberNicknameResponse)
  private static final com.lanjiu.im.grpc.GroupMemberNicknameResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.lanjiu.im.grpc.GroupMemberNicknameResponse();
  }

  public static com.lanjiu.im.grpc.GroupMemberNicknameResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GroupMemberNicknameResponse>
      PARSER = new com.google.protobuf.AbstractParser<GroupMemberNicknameResponse>() {
    @java.lang.Override
    public GroupMemberNicknameResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GroupMemberNicknameResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GroupMemberNicknameResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GroupMemberNicknameResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.lanjiu.im.grpc.GroupMemberNicknameResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

