// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: runningControl.proto

package io.runningControl.CA.watchFit;

/**
 * <pre>
 * from client to server
 * </pre>
 *
 * Protobuf type {@code ExerciseTimeRequest}
 */
public  final class ExerciseTimeRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ExerciseTimeRequest)
    ExerciseTimeRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ExerciseTimeRequest.newBuilder() to construct.
  private ExerciseTimeRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ExerciseTimeRequest() {
    exerciseTimeSignal_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ExerciseTimeRequest(
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
          case 8: {

            exerciseTimeSignal_ = input.readBool();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
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
    return io.runningControl.CA.watchFit.RunningControlgRPCProto.internal_static_ExerciseTimeRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.runningControl.CA.watchFit.RunningControlgRPCProto.internal_static_ExerciseTimeRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.runningControl.CA.watchFit.ExerciseTimeRequest.class, io.runningControl.CA.watchFit.ExerciseTimeRequest.Builder.class);
  }

  public static final int EXERCISETIMESIGNAL_FIELD_NUMBER = 1;
  private boolean exerciseTimeSignal_;
  /**
   * <code>bool exerciseTimeSignal = 1;</code>
   */
  public boolean getExerciseTimeSignal() {
    return exerciseTimeSignal_;
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
    if (exerciseTimeSignal_ != false) {
      output.writeBool(1, exerciseTimeSignal_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (exerciseTimeSignal_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, exerciseTimeSignal_);
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
    if (!(obj instanceof io.runningControl.CA.watchFit.ExerciseTimeRequest)) {
      return super.equals(obj);
    }
    io.runningControl.CA.watchFit.ExerciseTimeRequest other = (io.runningControl.CA.watchFit.ExerciseTimeRequest) obj;

    boolean result = true;
    result = result && (getExerciseTimeSignal()
        == other.getExerciseTimeSignal());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + EXERCISETIMESIGNAL_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getExerciseTimeSignal());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.runningControl.CA.watchFit.ExerciseTimeRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.runningControl.CA.watchFit.ExerciseTimeRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.runningControl.CA.watchFit.ExerciseTimeRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.runningControl.CA.watchFit.ExerciseTimeRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.runningControl.CA.watchFit.ExerciseTimeRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.runningControl.CA.watchFit.ExerciseTimeRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.runningControl.CA.watchFit.ExerciseTimeRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.runningControl.CA.watchFit.ExerciseTimeRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.runningControl.CA.watchFit.ExerciseTimeRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.runningControl.CA.watchFit.ExerciseTimeRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.runningControl.CA.watchFit.ExerciseTimeRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.runningControl.CA.watchFit.ExerciseTimeRequest parseFrom(
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
  public static Builder newBuilder(io.runningControl.CA.watchFit.ExerciseTimeRequest prototype) {
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
   * from client to server
   * </pre>
   *
   * Protobuf type {@code ExerciseTimeRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ExerciseTimeRequest)
      io.runningControl.CA.watchFit.ExerciseTimeRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.runningControl.CA.watchFit.RunningControlgRPCProto.internal_static_ExerciseTimeRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.runningControl.CA.watchFit.RunningControlgRPCProto.internal_static_ExerciseTimeRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.runningControl.CA.watchFit.ExerciseTimeRequest.class, io.runningControl.CA.watchFit.ExerciseTimeRequest.Builder.class);
    }

    // Construct using io.runningControl.CA.watchFit.ExerciseTimeRequest.newBuilder()
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
      exerciseTimeSignal_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.runningControl.CA.watchFit.RunningControlgRPCProto.internal_static_ExerciseTimeRequest_descriptor;
    }

    @java.lang.Override
    public io.runningControl.CA.watchFit.ExerciseTimeRequest getDefaultInstanceForType() {
      return io.runningControl.CA.watchFit.ExerciseTimeRequest.getDefaultInstance();
    }

    @java.lang.Override
    public io.runningControl.CA.watchFit.ExerciseTimeRequest build() {
      io.runningControl.CA.watchFit.ExerciseTimeRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.runningControl.CA.watchFit.ExerciseTimeRequest buildPartial() {
      io.runningControl.CA.watchFit.ExerciseTimeRequest result = new io.runningControl.CA.watchFit.ExerciseTimeRequest(this);
      result.exerciseTimeSignal_ = exerciseTimeSignal_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.runningControl.CA.watchFit.ExerciseTimeRequest) {
        return mergeFrom((io.runningControl.CA.watchFit.ExerciseTimeRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.runningControl.CA.watchFit.ExerciseTimeRequest other) {
      if (other == io.runningControl.CA.watchFit.ExerciseTimeRequest.getDefaultInstance()) return this;
      if (other.getExerciseTimeSignal() != false) {
        setExerciseTimeSignal(other.getExerciseTimeSignal());
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
      io.runningControl.CA.watchFit.ExerciseTimeRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.runningControl.CA.watchFit.ExerciseTimeRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private boolean exerciseTimeSignal_ ;
    /**
     * <code>bool exerciseTimeSignal = 1;</code>
     */
    public boolean getExerciseTimeSignal() {
      return exerciseTimeSignal_;
    }
    /**
     * <code>bool exerciseTimeSignal = 1;</code>
     */
    public Builder setExerciseTimeSignal(boolean value) {
      
      exerciseTimeSignal_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool exerciseTimeSignal = 1;</code>
     */
    public Builder clearExerciseTimeSignal() {
      
      exerciseTimeSignal_ = false;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ExerciseTimeRequest)
  }

  // @@protoc_insertion_point(class_scope:ExerciseTimeRequest)
  private static final io.runningControl.CA.watchFit.ExerciseTimeRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.runningControl.CA.watchFit.ExerciseTimeRequest();
  }

  public static io.runningControl.CA.watchFit.ExerciseTimeRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ExerciseTimeRequest>
      PARSER = new com.google.protobuf.AbstractParser<ExerciseTimeRequest>() {
    @java.lang.Override
    public ExerciseTimeRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ExerciseTimeRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ExerciseTimeRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ExerciseTimeRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.runningControl.CA.watchFit.ExerciseTimeRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

