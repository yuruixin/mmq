// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: consistency.proto

package org.monkey.mmq.core.entity;

public interface InternalMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:InternalMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string address = 1;</code>
   */
  java.lang.String getAddress();
  /**
   * <code>string address = 1;</code>
   */
  com.google.protobuf.ByteString
      getAddressBytes();

  /**
   * <code>string processId = 2;</code>
   */
  java.lang.String getProcessId();
  /**
   * <code>string processId = 2;</code>
   */
  com.google.protobuf.ByteString
      getProcessIdBytes();

  /**
   * <code>string topic = 3;</code>
   */
  java.lang.String getTopic();
  /**
   * <code>string topic = 3;</code>
   */
  com.google.protobuf.ByteString
      getTopicBytes();

  /**
   * <code>int32 mqttQoS = 4;</code>
   */
  int getMqttQoS();

  /**
   * <code>bytes messageBytes = 5;</code>
   */
  com.google.protobuf.ByteString getMessageBytes();

  /**
   * <code>bool retain = 6;</code>
   */
  boolean getRetain();

  /**
   * <code>bool dup = 7;</code>
   */
  boolean getDup();
}