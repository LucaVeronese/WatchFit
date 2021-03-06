// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: runningControl.proto

package io.runningControl.CA.watchFit;

/**
 * <pre>
 * from client to server
 * </pre>
 *
 * Protobuf type {@code BurnedCaloriesRequest}
 */
public  final class BurnedCaloriesRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:BurnedCaloriesRequest)
    BurnedCaloriesRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BurnedCaloriesRequest.newBuilder() to construct.
  private BurnedCaloriesRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BurnedCaloriesRequest() {
    age_ = 0;
    weight_ = 0;
    height_ = 0;
    gender_ = "";
    duration_ = 0D;
    activity_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BurnedCaloriesRequest(
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

            age_ = input.readInt32();
            break;
          }
          case 16: {

            weight_ = input.readInt32();
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            gender_ = s;
            break;
          }
          case 32: {

            height_ = input.readInt32();
            break;
          }
          case 41: {

            duration_ = input.readDouble();
            break;
          }
          case 48: {

            activity_ = input.readInt32();
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
    return io.runningControl.CA.watchFit.RunningControlgRPCProto.internal_static_BurnedCaloriesRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.runningControl.CA.watchFit.RunningControlgRPCProto.internal_static_BurnedCaloriesRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.runningControl.CA.watchFit.BurnedCaloriesRequest.class, io.runningControl.CA.watchFit.BurnedCaloriesRequest.Builder.class);
  }

  public static final int AGE_FIELD_NUMBER = 1;
  private int age_;
  /**
   * <code>int32 age = 1;</code>
   */
  public int getAge() {
    return age_;
  }

  public static final int WEIGHT_FIELD_NUMBER = 2;
  private int weight_;
  /**
   * <code>int32 weight = 2;</code>
   */
  public int getWeight() {
    return weight_;
  }

  public static final int HEIGHT_FIELD_NUMBER = 4;
  private int height_;
  /**
   * <code>int32 height = 4;</code>
   */
  public int getHeight() {
    return height_;
  }

  public static final int GENDER_FIELD_NUMBER = 3;
  private volatile java.lang.Object gender_;
  /**
   * <code>string gender = 3;</code>
   */
  public java.lang.String getGender() {
    java.lang.Object ref = gender_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      gender_ = s;
      return s;
    }
  }
  /**
   * <code>string gender = 3;</code>
   */
  public com.google.protobuf.ByteString
      getGenderBytes() {
    java.lang.Object ref = gender_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      gender_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DURATION_FIELD_NUMBER = 5;
  private double duration_;
  /**
   * <code>double duration = 5;</code>
   */
  public double getDuration() {
    return duration_;
  }

  public static final int ACTIVITY_FIELD_NUMBER = 6;
  private int activity_;
  /**
   * <code>int32 activity = 6;</code>
   */
  public int getActivity() {
    return activity_;
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
    if (age_ != 0) {
      output.writeInt32(1, age_);
    }
    if (weight_ != 0) {
      output.writeInt32(2, weight_);
    }
    if (!getGenderBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, gender_);
    }
    if (height_ != 0) {
      output.writeInt32(4, height_);
    }
    if (duration_ != 0D) {
      output.writeDouble(5, duration_);
    }
    if (activity_ != 0) {
      output.writeInt32(6, activity_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (age_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, age_);
    }
    if (weight_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, weight_);
    }
    if (!getGenderBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, gender_);
    }
    if (height_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, height_);
    }
    if (duration_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(5, duration_);
    }
    if (activity_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(6, activity_);
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
    if (!(obj instanceof io.runningControl.CA.watchFit.BurnedCaloriesRequest)) {
      return super.equals(obj);
    }
    io.runningControl.CA.watchFit.BurnedCaloriesRequest other = (io.runningControl.CA.watchFit.BurnedCaloriesRequest) obj;

    boolean result = true;
    result = result && (getAge()
        == other.getAge());
    result = result && (getWeight()
        == other.getWeight());
    result = result && (getHeight()
        == other.getHeight());
    result = result && getGender()
        .equals(other.getGender());
    result = result && (
        java.lang.Double.doubleToLongBits(getDuration())
        == java.lang.Double.doubleToLongBits(
            other.getDuration()));
    result = result && (getActivity()
        == other.getActivity());
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
    hash = (37 * hash) + AGE_FIELD_NUMBER;
    hash = (53 * hash) + getAge();
    hash = (37 * hash) + WEIGHT_FIELD_NUMBER;
    hash = (53 * hash) + getWeight();
    hash = (37 * hash) + HEIGHT_FIELD_NUMBER;
    hash = (53 * hash) + getHeight();
    hash = (37 * hash) + GENDER_FIELD_NUMBER;
    hash = (53 * hash) + getGender().hashCode();
    hash = (37 * hash) + DURATION_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getDuration()));
    hash = (37 * hash) + ACTIVITY_FIELD_NUMBER;
    hash = (53 * hash) + getActivity();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.runningControl.CA.watchFit.BurnedCaloriesRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.runningControl.CA.watchFit.BurnedCaloriesRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.runningControl.CA.watchFit.BurnedCaloriesRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.runningControl.CA.watchFit.BurnedCaloriesRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.runningControl.CA.watchFit.BurnedCaloriesRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.runningControl.CA.watchFit.BurnedCaloriesRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.runningControl.CA.watchFit.BurnedCaloriesRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.runningControl.CA.watchFit.BurnedCaloriesRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.runningControl.CA.watchFit.BurnedCaloriesRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.runningControl.CA.watchFit.BurnedCaloriesRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.runningControl.CA.watchFit.BurnedCaloriesRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.runningControl.CA.watchFit.BurnedCaloriesRequest parseFrom(
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
  public static Builder newBuilder(io.runningControl.CA.watchFit.BurnedCaloriesRequest prototype) {
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
   * Protobuf type {@code BurnedCaloriesRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:BurnedCaloriesRequest)
      io.runningControl.CA.watchFit.BurnedCaloriesRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.runningControl.CA.watchFit.RunningControlgRPCProto.internal_static_BurnedCaloriesRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.runningControl.CA.watchFit.RunningControlgRPCProto.internal_static_BurnedCaloriesRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.runningControl.CA.watchFit.BurnedCaloriesRequest.class, io.runningControl.CA.watchFit.BurnedCaloriesRequest.Builder.class);
    }

    // Construct using io.runningControl.CA.watchFit.BurnedCaloriesRequest.newBuilder()
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
      age_ = 0;

      weight_ = 0;

      height_ = 0;

      gender_ = "";

      duration_ = 0D;

      activity_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.runningControl.CA.watchFit.RunningControlgRPCProto.internal_static_BurnedCaloriesRequest_descriptor;
    }

    @java.lang.Override
    public io.runningControl.CA.watchFit.BurnedCaloriesRequest getDefaultInstanceForType() {
      return io.runningControl.CA.watchFit.BurnedCaloriesRequest.getDefaultInstance();
    }

    @java.lang.Override
    public io.runningControl.CA.watchFit.BurnedCaloriesRequest build() {
      io.runningControl.CA.watchFit.BurnedCaloriesRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.runningControl.CA.watchFit.BurnedCaloriesRequest buildPartial() {
      io.runningControl.CA.watchFit.BurnedCaloriesRequest result = new io.runningControl.CA.watchFit.BurnedCaloriesRequest(this);
      result.age_ = age_;
      result.weight_ = weight_;
      result.height_ = height_;
      result.gender_ = gender_;
      result.duration_ = duration_;
      result.activity_ = activity_;
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
      if (other instanceof io.runningControl.CA.watchFit.BurnedCaloriesRequest) {
        return mergeFrom((io.runningControl.CA.watchFit.BurnedCaloriesRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.runningControl.CA.watchFit.BurnedCaloriesRequest other) {
      if (other == io.runningControl.CA.watchFit.BurnedCaloriesRequest.getDefaultInstance()) return this;
      if (other.getAge() != 0) {
        setAge(other.getAge());
      }
      if (other.getWeight() != 0) {
        setWeight(other.getWeight());
      }
      if (other.getHeight() != 0) {
        setHeight(other.getHeight());
      }
      if (!other.getGender().isEmpty()) {
        gender_ = other.gender_;
        onChanged();
      }
      if (other.getDuration() != 0D) {
        setDuration(other.getDuration());
      }
      if (other.getActivity() != 0) {
        setActivity(other.getActivity());
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
      io.runningControl.CA.watchFit.BurnedCaloriesRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.runningControl.CA.watchFit.BurnedCaloriesRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int age_ ;
    /**
     * <code>int32 age = 1;</code>
     */
    public int getAge() {
      return age_;
    }
    /**
     * <code>int32 age = 1;</code>
     */
    public Builder setAge(int value) {
      
      age_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 age = 1;</code>
     */
    public Builder clearAge() {
      
      age_ = 0;
      onChanged();
      return this;
    }

    private int weight_ ;
    /**
     * <code>int32 weight = 2;</code>
     */
    public int getWeight() {
      return weight_;
    }
    /**
     * <code>int32 weight = 2;</code>
     */
    public Builder setWeight(int value) {
      
      weight_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 weight = 2;</code>
     */
    public Builder clearWeight() {
      
      weight_ = 0;
      onChanged();
      return this;
    }

    private int height_ ;
    /**
     * <code>int32 height = 4;</code>
     */
    public int getHeight() {
      return height_;
    }
    /**
     * <code>int32 height = 4;</code>
     */
    public Builder setHeight(int value) {
      
      height_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 height = 4;</code>
     */
    public Builder clearHeight() {
      
      height_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object gender_ = "";
    /**
     * <code>string gender = 3;</code>
     */
    public java.lang.String getGender() {
      java.lang.Object ref = gender_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        gender_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string gender = 3;</code>
     */
    public com.google.protobuf.ByteString
        getGenderBytes() {
      java.lang.Object ref = gender_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        gender_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string gender = 3;</code>
     */
    public Builder setGender(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      gender_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string gender = 3;</code>
     */
    public Builder clearGender() {
      
      gender_ = getDefaultInstance().getGender();
      onChanged();
      return this;
    }
    /**
     * <code>string gender = 3;</code>
     */
    public Builder setGenderBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      gender_ = value;
      onChanged();
      return this;
    }

    private double duration_ ;
    /**
     * <code>double duration = 5;</code>
     */
    public double getDuration() {
      return duration_;
    }
    /**
     * <code>double duration = 5;</code>
     */
    public Builder setDuration(double value) {
      
      duration_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double duration = 5;</code>
     */
    public Builder clearDuration() {
      
      duration_ = 0D;
      onChanged();
      return this;
    }

    private int activity_ ;
    /**
     * <code>int32 activity = 6;</code>
     */
    public int getActivity() {
      return activity_;
    }
    /**
     * <code>int32 activity = 6;</code>
     */
    public Builder setActivity(int value) {
      
      activity_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 activity = 6;</code>
     */
    public Builder clearActivity() {
      
      activity_ = 0;
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


    // @@protoc_insertion_point(builder_scope:BurnedCaloriesRequest)
  }

  // @@protoc_insertion_point(class_scope:BurnedCaloriesRequest)
  private static final io.runningControl.CA.watchFit.BurnedCaloriesRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.runningControl.CA.watchFit.BurnedCaloriesRequest();
  }

  public static io.runningControl.CA.watchFit.BurnedCaloriesRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BurnedCaloriesRequest>
      PARSER = new com.google.protobuf.AbstractParser<BurnedCaloriesRequest>() {
    @java.lang.Override
    public BurnedCaloriesRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BurnedCaloriesRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BurnedCaloriesRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BurnedCaloriesRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.runningControl.CA.watchFit.BurnedCaloriesRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

