// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: information_other_storage_grpc.proto

package com.lanjiu.im.grpc;

/**
 * <pre>
 * 图片
 * </pre>
 *
 * Protobuf type {@code com.lanjiu.im.grpc.Picture}
 */
public  final class Picture extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.lanjiu.im.grpc.Picture)
    PictureOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Picture.newBuilder() to construct.
  private Picture(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Picture() {
    url_ = "";
    originPicture_ = com.google.protobuf.ByteString.EMPTY;
    thumbnail_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Picture();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Picture(
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

            url_ = s;
            break;
          }
          case 18: {

            originPicture_ = input.readBytes();
            break;
          }
          case 26: {

            thumbnail_ = input.readBytes();
            break;
          }
          case 32: {

            pos_ = input.readInt32();
            break;
          }
          case 40: {

            length_ = input.readInt32();
            break;
          }
          case 50: {
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
          case 58: {
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
    return com.lanjiu.im.grpc.FileStorageProto.internal_static_com_lanjiu_im_grpc_Picture_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.lanjiu.im.grpc.FileStorageProto.internal_static_com_lanjiu_im_grpc_Picture_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.lanjiu.im.grpc.Picture.class, com.lanjiu.im.grpc.Picture.Builder.class);
  }

  public static final int URL_FIELD_NUMBER = 1;
  private volatile java.lang.Object url_;
  /**
   * <pre>
   * 原图下载URL
   * </pre>
   *
   * <code>string url = 1;</code>
   * @return The url.
   */
  public java.lang.String getUrl() {
    java.lang.Object ref = url_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      url_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * 原图下载URL
   * </pre>
   *
   * <code>string url = 1;</code>
   * @return The bytes for url.
   */
  public com.google.protobuf.ByteString
      getUrlBytes() {
    java.lang.Object ref = url_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      url_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ORIGIN_PICTURE_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString originPicture_;
  /**
   * <pre>
   * 原始图
   * </pre>
   *
   * <code>bytes origin_picture = 2;</code>
   * @return The originPicture.
   */
  public com.google.protobuf.ByteString getOriginPicture() {
    return originPicture_;
  }

  public static final int THUMBNAIL_FIELD_NUMBER = 3;
  private com.google.protobuf.ByteString thumbnail_;
  /**
   * <pre>
   *缩略图
   * </pre>
   *
   * <code>bytes thumbnail = 3;</code>
   * @return The thumbnail.
   */
  public com.google.protobuf.ByteString getThumbnail() {
    return thumbnail_;
  }

  public static final int POS_FIELD_NUMBER = 4;
  private int pos_;
  /**
   * <pre>
   *当前坐标
   * </pre>
   *
   * <code>int32 pos = 4;</code>
   * @return The pos.
   */
  public int getPos() {
    return pos_;
  }

  public static final int LENGTH_FIELD_NUMBER = 5;
  private int length_;
  /**
   * <pre>
   *当前文件内容大小
   * </pre>
   *
   * <code>int32 length = 5;</code>
   * @return The length.
   */
  public int getLength() {
    return length_;
  }

  public static final int FRIENDS_FIELD_NUMBER = 6;
  private com.lanjiu.im.grpc.Friends friends_;
  /**
   * <pre>
   *好友结构体
   * </pre>
   *
   * <code>.com.lanjiu.im.grpc.Friends friends = 6;</code>
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
   * <code>.com.lanjiu.im.grpc.Friends friends = 6;</code>
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
   * <code>.com.lanjiu.im.grpc.Friends friends = 6;</code>
   */
  public com.lanjiu.im.grpc.FriendsOrBuilder getFriendsOrBuilder() {
    return getFriends();
  }

  public static final int GROUPMEMBER_FIELD_NUMBER = 7;
  private com.lanjiu.im.grpc.GroupMember groupMember_;
  /**
   * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 7;</code>
   * @return Whether the groupMember field is set.
   */
  public boolean hasGroupMember() {
    return groupMember_ != null;
  }
  /**
   * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 7;</code>
   * @return The groupMember.
   */
  public com.lanjiu.im.grpc.GroupMember getGroupMember() {
    return groupMember_ == null ? com.lanjiu.im.grpc.GroupMember.getDefaultInstance() : groupMember_;
  }
  /**
   * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 7;</code>
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
    if (!getUrlBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, url_);
    }
    if (!originPicture_.isEmpty()) {
      output.writeBytes(2, originPicture_);
    }
    if (!thumbnail_.isEmpty()) {
      output.writeBytes(3, thumbnail_);
    }
    if (pos_ != 0) {
      output.writeInt32(4, pos_);
    }
    if (length_ != 0) {
      output.writeInt32(5, length_);
    }
    if (friends_ != null) {
      output.writeMessage(6, getFriends());
    }
    if (groupMember_ != null) {
      output.writeMessage(7, getGroupMember());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getUrlBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, url_);
    }
    if (!originPicture_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, originPicture_);
    }
    if (!thumbnail_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(3, thumbnail_);
    }
    if (pos_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, pos_);
    }
    if (length_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, length_);
    }
    if (friends_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(6, getFriends());
    }
    if (groupMember_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(7, getGroupMember());
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
    if (!(obj instanceof com.lanjiu.im.grpc.Picture)) {
      return super.equals(obj);
    }
    com.lanjiu.im.grpc.Picture other = (com.lanjiu.im.grpc.Picture) obj;

    if (!getUrl()
        .equals(other.getUrl())) return false;
    if (!getOriginPicture()
        .equals(other.getOriginPicture())) return false;
    if (!getThumbnail()
        .equals(other.getThumbnail())) return false;
    if (getPos()
        != other.getPos()) return false;
    if (getLength()
        != other.getLength()) return false;
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
    hash = (37 * hash) + URL_FIELD_NUMBER;
    hash = (53 * hash) + getUrl().hashCode();
    hash = (37 * hash) + ORIGIN_PICTURE_FIELD_NUMBER;
    hash = (53 * hash) + getOriginPicture().hashCode();
    hash = (37 * hash) + THUMBNAIL_FIELD_NUMBER;
    hash = (53 * hash) + getThumbnail().hashCode();
    hash = (37 * hash) + POS_FIELD_NUMBER;
    hash = (53 * hash) + getPos();
    hash = (37 * hash) + LENGTH_FIELD_NUMBER;
    hash = (53 * hash) + getLength();
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

  public static com.lanjiu.im.grpc.Picture parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.Picture parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.Picture parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.Picture parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.Picture parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.lanjiu.im.grpc.Picture parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.Picture parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.Picture parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.Picture parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.Picture parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.lanjiu.im.grpc.Picture parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.lanjiu.im.grpc.Picture parseFrom(
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
  public static Builder newBuilder(com.lanjiu.im.grpc.Picture prototype) {
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
   * 图片
   * </pre>
   *
   * Protobuf type {@code com.lanjiu.im.grpc.Picture}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.lanjiu.im.grpc.Picture)
      com.lanjiu.im.grpc.PictureOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.lanjiu.im.grpc.FileStorageProto.internal_static_com_lanjiu_im_grpc_Picture_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.lanjiu.im.grpc.FileStorageProto.internal_static_com_lanjiu_im_grpc_Picture_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.lanjiu.im.grpc.Picture.class, com.lanjiu.im.grpc.Picture.Builder.class);
    }

    // Construct using com.lanjiu.im.grpc.Picture.newBuilder()
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
      url_ = "";

      originPicture_ = com.google.protobuf.ByteString.EMPTY;

      thumbnail_ = com.google.protobuf.ByteString.EMPTY;

      pos_ = 0;

      length_ = 0;

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
      return com.lanjiu.im.grpc.FileStorageProto.internal_static_com_lanjiu_im_grpc_Picture_descriptor;
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.Picture getDefaultInstanceForType() {
      return com.lanjiu.im.grpc.Picture.getDefaultInstance();
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.Picture build() {
      com.lanjiu.im.grpc.Picture result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.lanjiu.im.grpc.Picture buildPartial() {
      com.lanjiu.im.grpc.Picture result = new com.lanjiu.im.grpc.Picture(this);
      result.url_ = url_;
      result.originPicture_ = originPicture_;
      result.thumbnail_ = thumbnail_;
      result.pos_ = pos_;
      result.length_ = length_;
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
      if (other instanceof com.lanjiu.im.grpc.Picture) {
        return mergeFrom((com.lanjiu.im.grpc.Picture)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.lanjiu.im.grpc.Picture other) {
      if (other == com.lanjiu.im.grpc.Picture.getDefaultInstance()) return this;
      if (!other.getUrl().isEmpty()) {
        url_ = other.url_;
        onChanged();
      }
      if (other.getOriginPicture() != com.google.protobuf.ByteString.EMPTY) {
        setOriginPicture(other.getOriginPicture());
      }
      if (other.getThumbnail() != com.google.protobuf.ByteString.EMPTY) {
        setThumbnail(other.getThumbnail());
      }
      if (other.getPos() != 0) {
        setPos(other.getPos());
      }
      if (other.getLength() != 0) {
        setLength(other.getLength());
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
      com.lanjiu.im.grpc.Picture parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.lanjiu.im.grpc.Picture) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object url_ = "";
    /**
     * <pre>
     * 原图下载URL
     * </pre>
     *
     * <code>string url = 1;</code>
     * @return The url.
     */
    public java.lang.String getUrl() {
      java.lang.Object ref = url_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        url_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * 原图下载URL
     * </pre>
     *
     * <code>string url = 1;</code>
     * @return The bytes for url.
     */
    public com.google.protobuf.ByteString
        getUrlBytes() {
      java.lang.Object ref = url_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        url_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * 原图下载URL
     * </pre>
     *
     * <code>string url = 1;</code>
     * @param value The url to set.
     * @return This builder for chaining.
     */
    public Builder setUrl(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      url_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 原图下载URL
     * </pre>
     *
     * <code>string url = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearUrl() {
      
      url_ = getDefaultInstance().getUrl();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 原图下载URL
     * </pre>
     *
     * <code>string url = 1;</code>
     * @param value The bytes for url to set.
     * @return This builder for chaining.
     */
    public Builder setUrlBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      url_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString originPicture_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <pre>
     * 原始图
     * </pre>
     *
     * <code>bytes origin_picture = 2;</code>
     * @return The originPicture.
     */
    public com.google.protobuf.ByteString getOriginPicture() {
      return originPicture_;
    }
    /**
     * <pre>
     * 原始图
     * </pre>
     *
     * <code>bytes origin_picture = 2;</code>
     * @param value The originPicture to set.
     * @return This builder for chaining.
     */
    public Builder setOriginPicture(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      originPicture_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 原始图
     * </pre>
     *
     * <code>bytes origin_picture = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearOriginPicture() {
      
      originPicture_ = getDefaultInstance().getOriginPicture();
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString thumbnail_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <pre>
     *缩略图
     * </pre>
     *
     * <code>bytes thumbnail = 3;</code>
     * @return The thumbnail.
     */
    public com.google.protobuf.ByteString getThumbnail() {
      return thumbnail_;
    }
    /**
     * <pre>
     *缩略图
     * </pre>
     *
     * <code>bytes thumbnail = 3;</code>
     * @param value The thumbnail to set.
     * @return This builder for chaining.
     */
    public Builder setThumbnail(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      thumbnail_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *缩略图
     * </pre>
     *
     * <code>bytes thumbnail = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearThumbnail() {
      
      thumbnail_ = getDefaultInstance().getThumbnail();
      onChanged();
      return this;
    }

    private int pos_ ;
    /**
     * <pre>
     *当前坐标
     * </pre>
     *
     * <code>int32 pos = 4;</code>
     * @return The pos.
     */
    public int getPos() {
      return pos_;
    }
    /**
     * <pre>
     *当前坐标
     * </pre>
     *
     * <code>int32 pos = 4;</code>
     * @param value The pos to set.
     * @return This builder for chaining.
     */
    public Builder setPos(int value) {
      
      pos_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *当前坐标
     * </pre>
     *
     * <code>int32 pos = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearPos() {
      
      pos_ = 0;
      onChanged();
      return this;
    }

    private int length_ ;
    /**
     * <pre>
     *当前文件内容大小
     * </pre>
     *
     * <code>int32 length = 5;</code>
     * @return The length.
     */
    public int getLength() {
      return length_;
    }
    /**
     * <pre>
     *当前文件内容大小
     * </pre>
     *
     * <code>int32 length = 5;</code>
     * @param value The length to set.
     * @return This builder for chaining.
     */
    public Builder setLength(int value) {
      
      length_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *当前文件内容大小
     * </pre>
     *
     * <code>int32 length = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearLength() {
      
      length_ = 0;
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
     * <code>.com.lanjiu.im.grpc.Friends friends = 6;</code>
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
     * <code>.com.lanjiu.im.grpc.Friends friends = 6;</code>
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
     * <code>.com.lanjiu.im.grpc.Friends friends = 6;</code>
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
     * <code>.com.lanjiu.im.grpc.Friends friends = 6;</code>
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
     * <code>.com.lanjiu.im.grpc.Friends friends = 6;</code>
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
     * <code>.com.lanjiu.im.grpc.Friends friends = 6;</code>
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
     * <code>.com.lanjiu.im.grpc.Friends friends = 6;</code>
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
     * <code>.com.lanjiu.im.grpc.Friends friends = 6;</code>
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
     * <code>.com.lanjiu.im.grpc.Friends friends = 6;</code>
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
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 7;</code>
     * @return Whether the groupMember field is set.
     */
    public boolean hasGroupMember() {
      return groupMemberBuilder_ != null || groupMember_ != null;
    }
    /**
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 7;</code>
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
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 7;</code>
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
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 7;</code>
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
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 7;</code>
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
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 7;</code>
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
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 7;</code>
     */
    public com.lanjiu.im.grpc.GroupMember.Builder getGroupMemberBuilder() {
      
      onChanged();
      return getGroupMemberFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 7;</code>
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
     * <code>.com.lanjiu.im.grpc.GroupMember groupMember = 7;</code>
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


    // @@protoc_insertion_point(builder_scope:com.lanjiu.im.grpc.Picture)
  }

  // @@protoc_insertion_point(class_scope:com.lanjiu.im.grpc.Picture)
  private static final com.lanjiu.im.grpc.Picture DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.lanjiu.im.grpc.Picture();
  }

  public static com.lanjiu.im.grpc.Picture getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Picture>
      PARSER = new com.google.protobuf.AbstractParser<Picture>() {
    @java.lang.Override
    public Picture parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Picture(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Picture> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Picture> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.lanjiu.im.grpc.Picture getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

