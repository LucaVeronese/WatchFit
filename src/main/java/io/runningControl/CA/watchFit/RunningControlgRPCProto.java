// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: runningControl.proto

package io.runningControl.CA.watchFit;

public final class RunningControlgRPCProto {
  private RunningControlgRPCProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_BurnedCaloriesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_BurnedCaloriesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_BurnedCaloriesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_BurnedCaloriesResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ExerciseTimeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ExerciseTimeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ExerciseTimeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ExerciseTimeResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024runningControl.proto\"x\n\025BurnedCalories" +
      "Request\022\013\n\003age\030\001 \001(\005\022\016\n\006weight\030\002 \001(\005\022\016\n\006" +
      "height\030\004 \001(\005\022\016\n\006gender\030\003 \001(\t\022\020\n\010duration" +
      "\030\005 \001(\001\022\020\n\010activity\030\006 \001(\005\"0\n\026BurnedCalori" +
      "esResponse\022\026\n\016burnedCalories\030\001 \001(\001\"1\n\023Ex" +
      "erciseTimeRequest\022\032\n\022exerciseTimeSignal\030" +
      "\001 \001(\010\"4\n\024ExerciseTimeResponse\022\034\n\024exercis" +
      "eTimeResponse\030\001 \001(\t2\226\001\n\016RunningControl\022C" +
      "\n\016BurnedCalories\022\026.BurnedCaloriesRequest" +
      "\032\027.BurnedCaloriesResponse\"\000\022?\n\014ExerciseT" +
      "ime\022\024.ExerciseTimeRequest\032\025.ExerciseTime" +
      "Response\"\000(\001B:\n\035io.runningControl.CA.wat" +
      "chFitB\027RunningControlgRPCProtoP\001b\006proto3"
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
    internal_static_BurnedCaloriesRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_BurnedCaloriesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_BurnedCaloriesRequest_descriptor,
        new java.lang.String[] { "Age", "Weight", "Height", "Gender", "Duration", "Activity", });
    internal_static_BurnedCaloriesResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_BurnedCaloriesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_BurnedCaloriesResponse_descriptor,
        new java.lang.String[] { "BurnedCalories", });
    internal_static_ExerciseTimeRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ExerciseTimeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ExerciseTimeRequest_descriptor,
        new java.lang.String[] { "ExerciseTimeSignal", });
    internal_static_ExerciseTimeResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ExerciseTimeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ExerciseTimeResponse_descriptor,
        new java.lang.String[] { "ExerciseTimeResponse", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
