// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: consistency.proto

package org.monkey.mmq.core.entity;

/**
 * Protobuf type {@code InternalMessage}
 */
public  final class InternalMessage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:InternalMessage)
    InternalMessageOrBuilder {
private static final long serialVersionUID = 0L;
  // Use InternalMessage.newBuilder() to construct.
  private InternalMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private InternalMessage() {
    address_ = "";
    processId_ = "";
    topic_ = "";
    messageBytes_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new InternalMessage();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private InternalMessage(
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

            address_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            processId_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            topic_ = s;
            break;
          }
          case 32: {

            mqttQoS_ = input.readInt32();
            break;
          }
          case 42: {

            messageBytes_ = input.readBytes();
            break;
          }
          case 48: {

            retain_ = input.readBool();
            break;
          }
          case 56: {

            dup_ = input.readBool();
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
    return org.monkey.mmq.core.entity.Consistency.internal_static_InternalMessage_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.monkey.mmq.core.entity.Consistency.internal_static_InternalMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.monkey.mmq.core.entity.InternalMessage.class, org.monkey.mmq.core.entity.InternalMessage.Builder.class);
  }

  public static final int ADDRESS_FIELD_NUMBER = 1;
  private volatile java.lang.Object address_;
  /**
   * <code>string address = 1;</code>
   */
  public java.lang.String getAddress() {
    java.lang.Object ref = address_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      address_ = s;
      return s;
    }
  }
  /**
   * <code>string address = 1;</code>
   */
  public com.google.protobuf.ByteString
      getAddressBytes() {
    java.lang.Object ref = address_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      address_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PROCESSID_FIELD_NUMBER = 2;
  private volatile java.lang.Object processId_;
  /**
   * <code>string processId = 2;</code>
   */
  public java.lang.String getProcessId() {
    java.lang.Object ref = processId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      processId_ = s;
      return s;
    }
  }
  /**
   * <code>string processId = 2;</code>
   */
  public com.google.protobuf.ByteString
      getProcessIdBytes() {
    java.lang.Object ref = processId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      processId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TOPIC_FIELD_NUMBER = 3;
  private volatile java.lang.Object topic_;
  /**
   * <code>string topic = 3;</code>
   */
  public java.lang.String getTopic() {
    java.lang.Object ref = topic_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      topic_ = s;
      return s;
    }
  }
  /**
   * <code>string topic = 3;</code>
   */
  public com.google.protobuf.ByteString
      getTopicBytes() {
    java.lang.Object ref = topic_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      topic_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MQTTQOS_FIELD_NUMBER = 4;
  private int mqttQoS_;
  /**
   * <code>int32 mqttQoS = 4;</code>
   */
  public int getMqttQoS() {
    return mqttQoS_;
  }

  public static final int MESSAGEBYTES_FIELD_NUMBER = 5;
  private com.google.protobuf.ByteString messageBytes_;
  /**
   * <code>bytes messageBytes = 5;</code>
   */
  public com.google.protobuf.ByteString getMessageBytes() {
    return messageBytes_;
  }

  public static final int RETAIN_FIELD_NUMBER = 6;
  private boolean retain_;
  /**
   * <code>bool retain = 6;</code>
   */
  public boolean getRetain() {
    return retain_;
  }

  public static final int DUP_FIELD_NUMBER = 7;
  private boolean dup_;
  /**
   * <code>bool dup = 7;</code>
   */
  public boolean getDup() {
    return dup_;
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
    if (!getAddressBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, address_);
    }
    if (!getProcessIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, processId_);
    }
    if (!getTopicBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, topic_);
    }
    if (mqttQoS_ != 0) {
      output.writeInt32(4, mqttQoS_);
    }
    if (!messageBytes_.isEmpty()) {
      output.writeBytes(5, messageBytes_);
    }
    if (retain_ != false) {
      output.writeBool(6, retain_);
    }
    if (dup_ != false) {
      output.writeBool(7, dup_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getAddressBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, address_);
    }
    if (!getProcessIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, processId_);
    }
    if (!getTopicBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, topic_);
    }
    if (mqttQoS_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, mqttQoS_);
    }
    if (!messageBytes_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(5, messageBytes_);
    }
    if (retain_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(6, retain_);
    }
    if (dup_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(7, dup_);
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
    if (!(obj instanceof org.monkey.mmq.core.entity.InternalMessage)) {
      return super.equals(obj);
    }
    org.monkey.mmq.core.entity.InternalMessage other = (org.monkey.mmq.core.entity.InternalMessage) obj;

    if (!getAddress()
        .equals(other.getAddress())) return false;
    if (!getProcessId()
        .equals(other.getProcessId())) return false;
    if (!getTopic()
        .equals(other.getTopic())) return false;
    if (getMqttQoS()
        != other.getMqttQoS()) return false;
    if (!getMessageBytes()
        .equals(other.getMessageBytes())) return false;
    if (getRetain()
        != other.getRetain()) return false;
    if (getDup()
        != other.getDup()) return false;
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
    hash = (37 * hash) + ADDRESS_FIELD_NUMBER;
    hash = (53 * hash) + getAddress().hashCode();
    hash = (37 * hash) + PROCESSID_FIELD_NUMBER;
    hash = (53 * hash) + getProcessId().hashCode();
    hash = (37 * hash) + TOPIC_FIELD_NUMBER;
    hash = (53 * hash) + getTopic().hashCode();
    hash = (37 * hash) + MQTTQOS_FIELD_NUMBER;
    hash = (53 * hash) + getMqttQoS();
    hash = (37 * hash) + MESSAGEBYTES_FIELD_NUMBER;
    hash = (53 * hash) + getMessageBytes().hashCode();
    hash = (37 * hash) + RETAIN_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getRetain());
    hash = (37 * hash) + DUP_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getDup());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.monkey.mmq.core.entity.InternalMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.monkey.mmq.core.entity.InternalMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.monkey.mmq.core.entity.InternalMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.monkey.mmq.core.entity.InternalMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.monkey.mmq.core.entity.InternalMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.monkey.mmq.core.entity.InternalMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.monkey.mmq.core.entity.InternalMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.monkey.mmq.core.entity.InternalMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.monkey.mmq.core.entity.InternalMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.monkey.mmq.core.entity.InternalMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.monkey.mmq.core.entity.InternalMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.monkey.mmq.core.entity.InternalMessage parseFrom(
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
  public static Builder newBuilder(org.monkey.mmq.core.entity.InternalMessage prototype) {
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
   * Protobuf type {@code InternalMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:InternalMessage)
      org.monkey.mmq.core.entity.InternalMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.monkey.mmq.core.entity.Consistency.internal_static_InternalMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.monkey.mmq.core.entity.Consistency.internal_static_InternalMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.monkey.mmq.core.entity.InternalMessage.class, org.monkey.mmq.core.entity.InternalMessage.Builder.class);
    }

    // Construct using org.monkey.mmq.core.entity.InternalMessage.newBuilder()
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
      address_ = "";

      processId_ = "";

      topic_ = "";

      mqttQoS_ = 0;

      messageBytes_ = com.google.protobuf.ByteString.EMPTY;

      retain_ = false;

      dup_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.monkey.mmq.core.entity.Consistency.internal_static_InternalMessage_descriptor;
    }

    @java.lang.Override
    public org.monkey.mmq.core.entity.InternalMessage getDefaultInstanceForType() {
      return org.monkey.mmq.core.entity.InternalMessage.getDefaultInstance();
    }

    @java.lang.Override
    public org.monkey.mmq.core.entity.InternalMessage build() {
      org.monkey.mmq.core.entity.InternalMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.monkey.mmq.core.entity.InternalMessage buildPartial() {
      org.monkey.mmq.core.entity.InternalMessage result = new org.monkey.mmq.core.entity.InternalMessage(this);
      result.address_ = address_;
      result.processId_ = processId_;
      result.topic_ = topic_;
      result.mqttQoS_ = mqttQoS_;
      result.messageBytes_ = messageBytes_;
      result.retain_ = retain_;
      result.dup_ = dup_;
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
      if (other instanceof org.monkey.mmq.core.entity.InternalMessage) {
        return mergeFrom((org.monkey.mmq.core.entity.InternalMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.monkey.mmq.core.entity.InternalMessage other) {
      if (other == org.monkey.mmq.core.entity.InternalMessage.getDefaultInstance()) return this;
      if (!other.getAddress().isEmpty()) {
        address_ = other.address_;
        onChanged();
      }
      if (!other.getProcessId().isEmpty()) {
        processId_ = other.processId_;
        onChanged();
      }
      if (!other.getTopic().isEmpty()) {
        topic_ = other.topic_;
        onChanged();
      }
      if (other.getMqttQoS() != 0) {
        setMqttQoS(other.getMqttQoS());
      }
      if (other.getMessageBytes() != com.google.protobuf.ByteString.EMPTY) {
        setMessageBytes(other.getMessageBytes());
      }
      if (other.getRetain() != false) {
        setRetain(other.getRetain());
      }
      if (other.getDup() != false) {
        setDup(other.getDup());
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
      org.monkey.mmq.core.entity.InternalMessage parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.monkey.mmq.core.entity.InternalMessage) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object address_ = "";
    /**
     * <code>string address = 1;</code>
     */
    public java.lang.String getAddress() {
      java.lang.Object ref = address_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        address_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string address = 1;</code>
     */
    public com.google.protobuf.ByteString
        getAddressBytes() {
      java.lang.Object ref = address_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        address_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string address = 1;</code>
     */
    public Builder setAddress(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      address_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string address = 1;</code>
     */
    public Builder clearAddress() {
      
      address_ = getDefaultInstance().getAddress();
      onChanged();
      return this;
    }
    /**
     * <code>string address = 1;</code>
     */
    public Builder setAddressBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      address_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object processId_ = "";
    /**
     * <code>string processId = 2;</code>
     */
    public java.lang.String getProcessId() {
      java.lang.Object ref = processId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        processId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string processId = 2;</code>
     */
    public com.google.protobuf.ByteString
        getProcessIdBytes() {
      java.lang.Object ref = processId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        processId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string processId = 2;</code>
     */
    public Builder setProcessId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      processId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string processId = 2;</code>
     */
    public Builder clearProcessId() {
      
      processId_ = getDefaultInstance().getProcessId();
      onChanged();
      return this;
    }
    /**
     * <code>string processId = 2;</code>
     */
    public Builder setProcessIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      processId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object topic_ = "";
    /**
     * <code>string topic = 3;</code>
     */
    public java.lang.String getTopic() {
      java.lang.Object ref = topic_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        topic_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string topic = 3;</code>
     */
    public com.google.protobuf.ByteString
        getTopicBytes() {
      java.lang.Object ref = topic_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        topic_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string topic = 3;</code>
     */
    public Builder setTopic(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      topic_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string topic = 3;</code>
     */
    public Builder clearTopic() {
      
      topic_ = getDefaultInstance().getTopic();
      onChanged();
      return this;
    }
    /**
     * <code>string topic = 3;</code>
     */
    public Builder setTopicBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      topic_ = value;
      onChanged();
      return this;
    }

    private int mqttQoS_ ;
    /**
     * <code>int32 mqttQoS = 4;</code>
     */
    public int getMqttQoS() {
      return mqttQoS_;
    }
    /**
     * <code>int32 mqttQoS = 4;</code>
     */
    public Builder setMqttQoS(int value) {
      
      mqttQoS_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 mqttQoS = 4;</code>
     */
    public Builder clearMqttQoS() {
      
      mqttQoS_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString messageBytes_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes messageBytes = 5;</code>
     */
    public com.google.protobuf.ByteString getMessageBytes() {
      return messageBytes_;
    }
    /**
     * <code>bytes messageBytes = 5;</code>
     */
    public Builder setMessageBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      messageBytes_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes messageBytes = 5;</code>
     */
    public Builder clearMessageBytes() {
      
      messageBytes_ = getDefaultInstance().getMessageBytes();
      onChanged();
      return this;
    }

    private boolean retain_ ;
    /**
     * <code>bool retain = 6;</code>
     */
    public boolean getRetain() {
      return retain_;
    }
    /**
     * <code>bool retain = 6;</code>
     */
    public Builder setRetain(boolean value) {
      
      retain_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool retain = 6;</code>
     */
    public Builder clearRetain() {
      
      retain_ = false;
      onChanged();
      return this;
    }

    private boolean dup_ ;
    /**
     * <code>bool dup = 7;</code>
     */
    public boolean getDup() {
      return dup_;
    }
    /**
     * <code>bool dup = 7;</code>
     */
    public Builder setDup(boolean value) {
      
      dup_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool dup = 7;</code>
     */
    public Builder clearDup() {
      
      dup_ = false;
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


    // @@protoc_insertion_point(builder_scope:InternalMessage)
  }

  // @@protoc_insertion_point(class_scope:InternalMessage)
  private static final org.monkey.mmq.core.entity.InternalMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.monkey.mmq.core.entity.InternalMessage();
  }

  public static org.monkey.mmq.core.entity.InternalMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<InternalMessage>
      PARSER = new com.google.protobuf.AbstractParser<InternalMessage>() {
    @java.lang.Override
    public InternalMessage parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new InternalMessage(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<InternalMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<InternalMessage> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.monkey.mmq.core.entity.InternalMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
