package io.healthControl.CA.watchFit;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: healthControl.proto")
public final class HealthControlGrpc {

  private HealthControlGrpc() {}

  public static final String SERVICE_NAME = "HealthControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.healthControl.CA.watchFit.TemperatureLevelRequest,
      io.healthControl.CA.watchFit.TemperatureResponse> getTemperatureReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TemperatureReport",
      requestType = io.healthControl.CA.watchFit.TemperatureLevelRequest.class,
      responseType = io.healthControl.CA.watchFit.TemperatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<io.healthControl.CA.watchFit.TemperatureLevelRequest,
      io.healthControl.CA.watchFit.TemperatureResponse> getTemperatureReportMethod() {
    io.grpc.MethodDescriptor<io.healthControl.CA.watchFit.TemperatureLevelRequest, io.healthControl.CA.watchFit.TemperatureResponse> getTemperatureReportMethod;
    if ((getTemperatureReportMethod = HealthControlGrpc.getTemperatureReportMethod) == null) {
      synchronized (HealthControlGrpc.class) {
        if ((getTemperatureReportMethod = HealthControlGrpc.getTemperatureReportMethod) == null) {
          HealthControlGrpc.getTemperatureReportMethod = getTemperatureReportMethod = 
              io.grpc.MethodDescriptor.<io.healthControl.CA.watchFit.TemperatureLevelRequest, io.healthControl.CA.watchFit.TemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "HealthControl", "TemperatureReport"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.healthControl.CA.watchFit.TemperatureLevelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.healthControl.CA.watchFit.TemperatureResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HealthControlMethodDescriptorSupplier("TemperatureReport"))
                  .build();
          }
        }
     }
     return getTemperatureReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.healthControl.CA.watchFit.ExerciseZoneRequest,
      io.healthControl.CA.watchFit.ExerciseZoneResponse> getExerciseZoneRateLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExerciseZoneRateLevel",
      requestType = io.healthControl.CA.watchFit.ExerciseZoneRequest.class,
      responseType = io.healthControl.CA.watchFit.ExerciseZoneResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<io.healthControl.CA.watchFit.ExerciseZoneRequest,
      io.healthControl.CA.watchFit.ExerciseZoneResponse> getExerciseZoneRateLevelMethod() {
    io.grpc.MethodDescriptor<io.healthControl.CA.watchFit.ExerciseZoneRequest, io.healthControl.CA.watchFit.ExerciseZoneResponse> getExerciseZoneRateLevelMethod;
    if ((getExerciseZoneRateLevelMethod = HealthControlGrpc.getExerciseZoneRateLevelMethod) == null) {
      synchronized (HealthControlGrpc.class) {
        if ((getExerciseZoneRateLevelMethod = HealthControlGrpc.getExerciseZoneRateLevelMethod) == null) {
          HealthControlGrpc.getExerciseZoneRateLevelMethod = getExerciseZoneRateLevelMethod = 
              io.grpc.MethodDescriptor.<io.healthControl.CA.watchFit.ExerciseZoneRequest, io.healthControl.CA.watchFit.ExerciseZoneResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "HealthControl", "ExerciseZoneRateLevel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.healthControl.CA.watchFit.ExerciseZoneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.healthControl.CA.watchFit.ExerciseZoneResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HealthControlMethodDescriptorSupplier("ExerciseZoneRateLevel"))
                  .build();
          }
        }
     }
     return getExerciseZoneRateLevelMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HealthControlStub newStub(io.grpc.Channel channel) {
    return new HealthControlStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HealthControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HealthControlBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HealthControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HealthControlFutureStub(channel);
  }

  /**
   */
  public static abstract class HealthControlImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * bidirectional rpc
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.healthControl.CA.watchFit.TemperatureLevelRequest> temperatureReport(
        io.grpc.stub.StreamObserver<io.healthControl.CA.watchFit.TemperatureResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getTemperatureReportMethod(), responseObserver);
    }

    /**
     * <pre>
     * server streaming rpc
     * </pre>
     */
    public void exerciseZoneRateLevel(io.healthControl.CA.watchFit.ExerciseZoneRequest request,
        io.grpc.stub.StreamObserver<io.healthControl.CA.watchFit.ExerciseZoneResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getExerciseZoneRateLevelMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTemperatureReportMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.healthControl.CA.watchFit.TemperatureLevelRequest,
                io.healthControl.CA.watchFit.TemperatureResponse>(
                  this, METHODID_TEMPERATURE_REPORT)))
          .addMethod(
            getExerciseZoneRateLevelMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                io.healthControl.CA.watchFit.ExerciseZoneRequest,
                io.healthControl.CA.watchFit.ExerciseZoneResponse>(
                  this, METHODID_EXERCISE_ZONE_RATE_LEVEL)))
          .build();
    }
  }

  /**
   */
  public static final class HealthControlStub extends io.grpc.stub.AbstractStub<HealthControlStub> {
    private HealthControlStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthControlStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthControlStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthControlStub(channel, callOptions);
    }

    /**
     * <pre>
     * bidirectional rpc
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.healthControl.CA.watchFit.TemperatureLevelRequest> temperatureReport(
        io.grpc.stub.StreamObserver<io.healthControl.CA.watchFit.TemperatureResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getTemperatureReportMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * server streaming rpc
     * </pre>
     */
    public void exerciseZoneRateLevel(io.healthControl.CA.watchFit.ExerciseZoneRequest request,
        io.grpc.stub.StreamObserver<io.healthControl.CA.watchFit.ExerciseZoneResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getExerciseZoneRateLevelMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HealthControlBlockingStub extends io.grpc.stub.AbstractStub<HealthControlBlockingStub> {
    private HealthControlBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthControlBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthControlBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthControlBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * server streaming rpc
     * </pre>
     */
    public java.util.Iterator<io.healthControl.CA.watchFit.ExerciseZoneResponse> exerciseZoneRateLevel(
        io.healthControl.CA.watchFit.ExerciseZoneRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getExerciseZoneRateLevelMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HealthControlFutureStub extends io.grpc.stub.AbstractStub<HealthControlFutureStub> {
    private HealthControlFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthControlFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthControlFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthControlFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_EXERCISE_ZONE_RATE_LEVEL = 0;
  private static final int METHODID_TEMPERATURE_REPORT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HealthControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HealthControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXERCISE_ZONE_RATE_LEVEL:
          serviceImpl.exerciseZoneRateLevel((io.healthControl.CA.watchFit.ExerciseZoneRequest) request,
              (io.grpc.stub.StreamObserver<io.healthControl.CA.watchFit.ExerciseZoneResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TEMPERATURE_REPORT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.temperatureReport(
              (io.grpc.stub.StreamObserver<io.healthControl.CA.watchFit.TemperatureResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HealthControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HealthControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.healthControl.CA.watchFit.HealthControlgRPCProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HealthControl");
    }
  }

  private static final class HealthControlFileDescriptorSupplier
      extends HealthControlBaseDescriptorSupplier {
    HealthControlFileDescriptorSupplier() {}
  }

  private static final class HealthControlMethodDescriptorSupplier
      extends HealthControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HealthControlMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HealthControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HealthControlFileDescriptorSupplier())
              .addMethod(getTemperatureReportMethod())
              .addMethod(getExerciseZoneRateLevelMethod())
              .build();
        }
      }
    }
    return result;
  }
}
