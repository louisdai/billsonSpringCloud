// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PhoneNumberBuf.proto.txt

public final class PhoneNumberBuf {
  private PhoneNumberBuf() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PhoneNumberOrBuilder extends
      // @@protoc_insertion_point(interface_extends:PhoneNumber)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string number = 1;</code>
     */
    java.lang.String getNumber();
    /**
     * <code>string number = 1;</code>
     */
    com.google.protobuf.ByteString
        getNumberBytes();

    /**
     * <code>.PhoneNumber.PhoneType type = 2;</code>
     */
    int getTypeValue();
    /**
     * <code>.PhoneNumber.PhoneType type = 2;</code>
     */
    PhoneNumberBuf.PhoneNumber.PhoneType getType();
  }
  /**
   * Protobuf type {@code PhoneNumber}
   */
  public  static final class PhoneNumber extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:PhoneNumber)
      PhoneNumberOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use PhoneNumber.newBuilder() to construct.
    private PhoneNumber(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private PhoneNumber() {
      number_ = "";
      type_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private PhoneNumber(
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

              number_ = s;
              break;
            }
            case 16: {
              int rawValue = input.readEnum();

              type_ = rawValue;
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
      return PhoneNumberBuf.internal_static_PhoneNumber_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return PhoneNumberBuf.internal_static_PhoneNumber_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              PhoneNumberBuf.PhoneNumber.class, PhoneNumberBuf.PhoneNumber.Builder.class);
    }

    /**
     * <pre>
     * ö��ʾ��
     * </pre>
     *
     * Protobuf enum {@code PhoneNumber.PhoneType}
     */
    public enum PhoneType
        implements com.google.protobuf.ProtocolMessageEnum {
      /**
       * <code>MOBILE = 0;</code>
       */
      MOBILE(0),
      /**
       * <code>TELEPHONE = 1;</code>
       */
      TELEPHONE(1),
      UNRECOGNIZED(-1),
      ;

      /**
       * <code>MOBILE = 0;</code>
       */
      public static final int MOBILE_VALUE = 0;
      /**
       * <code>TELEPHONE = 1;</code>
       */
      public static final int TELEPHONE_VALUE = 1;


      public final int getNumber() {
        if (this == UNRECOGNIZED) {
          throw new java.lang.IllegalArgumentException(
              "Can't get the number of an unknown enum value.");
        }
        return value;
      }

      /**
       * @deprecated Use {@link #forNumber(int)} instead.
       */
      @java.lang.Deprecated
      public static PhoneType valueOf(int value) {
        return forNumber(value);
      }

      public static PhoneType forNumber(int value) {
        switch (value) {
          case 0: return MOBILE;
          case 1: return TELEPHONE;
          default: return null;
        }
      }

      public static com.google.protobuf.Internal.EnumLiteMap<PhoneType>
          internalGetValueMap() {
        return internalValueMap;
      }
      private static final com.google.protobuf.Internal.EnumLiteMap<
          PhoneType> internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<PhoneType>() {
              public PhoneType findValueByNumber(int number) {
                return PhoneType.forNumber(number);
              }
            };

      public final com.google.protobuf.Descriptors.EnumValueDescriptor
          getValueDescriptor() {
        return getDescriptor().getValues().get(ordinal());
      }
      public final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }
      public static final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptor() {
        return PhoneNumberBuf.PhoneNumber.getDescriptor().getEnumTypes().get(0);
      }

      private static final PhoneType[] VALUES = values();

      public static PhoneType valueOf(
          com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
        if (desc.getType() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "EnumValueDescriptor is not for this type.");
        }
        if (desc.getIndex() == -1) {
          return UNRECOGNIZED;
        }
        return VALUES[desc.getIndex()];
      }

      private final int value;

      private PhoneType(int value) {
        this.value = value;
      }

      // @@protoc_insertion_point(enum_scope:PhoneNumber.PhoneType)
    }

    public static final int NUMBER_FIELD_NUMBER = 1;
    private volatile java.lang.Object number_;
    /**
     * <code>string number = 1;</code>
     */
    public java.lang.String getNumber() {
      java.lang.Object ref = number_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        number_ = s;
        return s;
      }
    }
    /**
     * <code>string number = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNumberBytes() {
      java.lang.Object ref = number_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        number_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TYPE_FIELD_NUMBER = 2;
    private int type_;
    /**
     * <code>.PhoneNumber.PhoneType type = 2;</code>
     */
    public int getTypeValue() {
      return type_;
    }
    /**
     * <code>.PhoneNumber.PhoneType type = 2;</code>
     */
    public PhoneNumberBuf.PhoneNumber.PhoneType getType() {
      @SuppressWarnings("deprecation")
      PhoneNumberBuf.PhoneNumber.PhoneType result = PhoneNumberBuf.PhoneNumber.PhoneType.valueOf(type_);
      return result == null ? PhoneNumberBuf.PhoneNumber.PhoneType.UNRECOGNIZED : result;
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
      if (!getNumberBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, number_);
      }
      if (type_ != PhoneNumberBuf.PhoneNumber.PhoneType.MOBILE.getNumber()) {
        output.writeEnum(2, type_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getNumberBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, number_);
      }
      if (type_ != PhoneNumberBuf.PhoneNumber.PhoneType.MOBILE.getNumber()) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(2, type_);
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
      if (!(obj instanceof PhoneNumberBuf.PhoneNumber)) {
        return super.equals(obj);
      }
      PhoneNumberBuf.PhoneNumber other = (PhoneNumberBuf.PhoneNumber) obj;

      boolean result = true;
      result = result && getNumber()
          .equals(other.getNumber());
      result = result && type_ == other.type_;
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
      hash = (37 * hash) + NUMBER_FIELD_NUMBER;
      hash = (53 * hash) + getNumber().hashCode();
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + type_;
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static PhoneNumberBuf.PhoneNumber parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PhoneNumberBuf.PhoneNumber parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PhoneNumberBuf.PhoneNumber parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PhoneNumberBuf.PhoneNumber parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PhoneNumberBuf.PhoneNumber parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PhoneNumberBuf.PhoneNumber parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PhoneNumberBuf.PhoneNumber parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static PhoneNumberBuf.PhoneNumber parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static PhoneNumberBuf.PhoneNumber parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static PhoneNumberBuf.PhoneNumber parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static PhoneNumberBuf.PhoneNumber parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static PhoneNumberBuf.PhoneNumber parseFrom(
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
    public static Builder newBuilder(PhoneNumberBuf.PhoneNumber prototype) {
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
     * Protobuf type {@code PhoneNumber}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:PhoneNumber)
        PhoneNumberBuf.PhoneNumberOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return PhoneNumberBuf.internal_static_PhoneNumber_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return PhoneNumberBuf.internal_static_PhoneNumber_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                PhoneNumberBuf.PhoneNumber.class, PhoneNumberBuf.PhoneNumber.Builder.class);
      }

      // Construct using PhoneNumberBuf.PhoneNumber.newBuilder()
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
        number_ = "";

        type_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return PhoneNumberBuf.internal_static_PhoneNumber_descriptor;
      }

      @java.lang.Override
      public PhoneNumberBuf.PhoneNumber getDefaultInstanceForType() {
        return PhoneNumberBuf.PhoneNumber.getDefaultInstance();
      }

      @java.lang.Override
      public PhoneNumberBuf.PhoneNumber build() {
        PhoneNumberBuf.PhoneNumber result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public PhoneNumberBuf.PhoneNumber buildPartial() {
        PhoneNumberBuf.PhoneNumber result = new PhoneNumberBuf.PhoneNumber(this);
        result.number_ = number_;
        result.type_ = type_;
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
        if (other instanceof PhoneNumberBuf.PhoneNumber) {
          return mergeFrom((PhoneNumberBuf.PhoneNumber)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(PhoneNumberBuf.PhoneNumber other) {
        if (other == PhoneNumberBuf.PhoneNumber.getDefaultInstance()) return this;
        if (!other.getNumber().isEmpty()) {
          number_ = other.number_;
          onChanged();
        }
        if (other.type_ != 0) {
          setTypeValue(other.getTypeValue());
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
        PhoneNumberBuf.PhoneNumber parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (PhoneNumberBuf.PhoneNumber) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object number_ = "";
      /**
       * <code>string number = 1;</code>
       */
      public java.lang.String getNumber() {
        java.lang.Object ref = number_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          number_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string number = 1;</code>
       */
      public com.google.protobuf.ByteString
          getNumberBytes() {
        java.lang.Object ref = number_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          number_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string number = 1;</code>
       */
      public Builder setNumber(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        number_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string number = 1;</code>
       */
      public Builder clearNumber() {
        
        number_ = getDefaultInstance().getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>string number = 1;</code>
       */
      public Builder setNumberBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        number_ = value;
        onChanged();
        return this;
      }

      private int type_ = 0;
      /**
       * <code>.PhoneNumber.PhoneType type = 2;</code>
       */
      public int getTypeValue() {
        return type_;
      }
      /**
       * <code>.PhoneNumber.PhoneType type = 2;</code>
       */
      public Builder setTypeValue(int value) {
        type_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>.PhoneNumber.PhoneType type = 2;</code>
       */
      public PhoneNumberBuf.PhoneNumber.PhoneType getType() {
        @SuppressWarnings("deprecation")
        PhoneNumberBuf.PhoneNumber.PhoneType result = PhoneNumberBuf.PhoneNumber.PhoneType.valueOf(type_);
        return result == null ? PhoneNumberBuf.PhoneNumber.PhoneType.UNRECOGNIZED : result;
      }
      /**
       * <code>.PhoneNumber.PhoneType type = 2;</code>
       */
      public Builder setType(PhoneNumberBuf.PhoneNumber.PhoneType value) {
        if (value == null) {
          throw new NullPointerException();
        }
        
        type_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>.PhoneNumber.PhoneType type = 2;</code>
       */
      public Builder clearType() {
        
        type_ = 0;
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


      // @@protoc_insertion_point(builder_scope:PhoneNumber)
    }

    // @@protoc_insertion_point(class_scope:PhoneNumber)
    private static final PhoneNumberBuf.PhoneNumber DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new PhoneNumberBuf.PhoneNumber();
    }

    public static PhoneNumberBuf.PhoneNumber getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PhoneNumber>
        PARSER = new com.google.protobuf.AbstractParser<PhoneNumber>() {
      @java.lang.Override
      public PhoneNumber parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new PhoneNumber(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<PhoneNumber> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PhoneNumber> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public PhoneNumberBuf.PhoneNumber getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PhoneNumber_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PhoneNumber_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\030PhoneNumberBuf.proto.txt\"k\n\013PhoneNumbe" +
      "r\022\016\n\006number\030\001 \001(\t\022$\n\004type\030\002 \001(\0162\026.PhoneN" +
      "umber.PhoneType\"&\n\tPhoneType\022\n\n\006MOBILE\020\000" +
      "\022\r\n\tTELEPHONE\020\001B\022\n\000B\016PhoneNumberBufb\006pro" +
      "to3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_PhoneNumber_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_PhoneNumber_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PhoneNumber_descriptor,
        new java.lang.String[] { "Number", "Type", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
