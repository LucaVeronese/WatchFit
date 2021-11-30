package io.runningControl.CA.watchFit;

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
    comments = "Source: runningControl.proto")
public final class RunningControlGrpc {

  private RunningControlGrpc() {}

  public static final String SERVICE_NAME = "RunningControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.runningControl.CA.watchFit.BurnedCaloriesRequest,
      io.runningControl.CA.watchFit.BurnedCaloriesResponse> getBurnedCaloriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BurnedCalories",
      requestType = io.runningControl.CA.watchFit.BurnedCaloriesRequest.class,
      responseType = io.runningControl.CA.watchFit.BurnedCaloriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.runningControl.CA.watchFit.BurnedCaloriesRequest,
      io.runningControl.CA.watchFit.BurnedCaloriesResponse> getBurnedCaloriesMethod() {
    io.grpc.MethodDescriptor<io.runningControl.CA.watchFit.BurnedCaloriesRequest, io.runningControl.CA.watchFit.BurnedCaloriesResponse> getBurnedCaloriesMethod;
    if ((getBurnedCaloriesMethod = RunningControlGrpc.getBurnedCaloriesMethod) == null) {
      synchronized (RunningControlGrpc.class) {
        if ((getBurnedCaloriesMethod = RunningControlGrpc.getBurnedCaloriesMethod) == null) {
          RunningControlGrpc.getBurnedCaloriesMethod = getBurnedCaloriesMethod = 
              io.grpc.MethodDescriptor.<io.runningControl.CA.watchFit.BurnedCaloriesRequest, io.runningControl.CA.watchFit.BurnedCaloriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RunningControl", "BurnedCalories"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.runningControl.CA.watchFit.BurnedCaloriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.runningControl.CA.watchFit.BurnedCaloriesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RunningControlMethodDescriptorSupplier("BurnedCalories"))
                  .build();
          }
        }
     }
     return getBurnedCaloriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.runningControl.CA.watchFit.RestHeartRateRequest,
      io.runningControl.CA.watchFit.RestHeartRateResponse> getRestHeartRateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestHeartRate",
      requestType = io.runningControl.CA.watchFit.RestHeartRateRequest.class,
      responseType = io.runningControl.CA.watchFit.RestHeartRateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<io.runningControl.CA.watchFit.RestHeartRateRequest,
      io.runningControl.CA.watchFit.RestHeartRateResponse> getRestHeartRateMethod() {
    io.grpc.MethodDescriptor<io.runningControl.CA.watchFit.RestHeartRateRequest, io.runningControl.CA.watchFit.RestHeartRateResponse> getRestHeartRateMethod;
    if ((getRestHeartRateMethod = RunningControlGrpc.getRestHeartRateMethod) == null) {
      synchronized (RunningControlGrpc.class) {
        if ((getRestHeartRateMethod = RunningControlGrpc.getRestHeartRateMethod) == null) {
          RunningControlGrpc.getRestHeartRateMethod = getRestHeartRateMethod = 
              io.grpc.MethodDescriptor.<io.runningControl.CA.watchFit.RestHeartRateRequest, io.runningControl.CA.watchFit.RestHeartRateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "RunningControl", "RestHeartRate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.runningControl.CA.watchFit.RestHeartRateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.runningControl.CA.watchFit.RestHeartRateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RunningControlMethodDescriptorSupplier("RestHeartRate"))
                  .build();
          }
        }
     }
     return getRestHeartRateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RunningControlStub newStub(io.grpc.Channel channel) {
    return new RunningControlStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RunningControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RunningControlBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RunningControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RunningControlFutureStub(channel);
  }

  /**
   */
  public static abstract class RunningControlImplBase implements io.grpc.BindableService {

    /**
     */
    public void burnedCalories(io.runningControl.CA.watchFit.BurnedCaloriesRequest request,
        io.grpc.stub.StreamObserver<io.runningControl.CA.watchFit.BurnedCaloriesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBurnedCaloriesMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.runningControl.CA.watchFit.RestHeartRateRequest> restHeartRate(
        io.grpc.stub.StreamObserver<io.runningControl.CA.watchFit.RestHeartRateResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getRestHeartRateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBurnedCaloriesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.runningControl.CA.watchFit.BurnedCaloriesRequest,
                io.runningControl.CA.watchFit.BurnedCaloriesResponse>(
                  this, METHODID_BURNED_CALORIES)))
          .addMethod(
            getRestHeartRateMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                io.runningControl.CA.watchFit.RestHeartRateRequest,
                io.runningControl.CA.watchFit.RestHeartRateResponse>(
                  this, METHODID_REST_HEART_RATE)))
          .build();
    }
  }

  /**
   */
  public static final class RunningControlStub extends io.grpc.stub.AbstractStub<RunningControlStub> {
    private RunningControlStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RunningControlStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RunningControlStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RunningControlStub(channel, callOptions);
    }

    /**
     */
    public void burnedCalories(io.runningControl.CA.watchFit.BurnedCaloriesRequest request,
        io.grpc.stub.StreamObserver<io.runningControl.CA.watchFit.BurnedCaloriesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBurnedCaloriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.runningControl.CA.watchFit.RestHeartRateRequest> restHeartRate(
        io.grpc.stub.StreamObserver<io.runningControl.CA.watchFit.RestHeartRateResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getRestHeartRateMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class RunningControlBlockingStub extends io.grpc.stub.AbstractStub<RunningControlBlockingStub> {
    private RunningControlBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RunningControlBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RunningControlBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RunningControlBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.runningControl.CA.watchFit.BurnedCaloriesResponse burnedCalories(io.runningControl.CA.watchFit.BurnedCaloriesRequest request) {
      return blockingUnaryCall(
          getChannel(), getBurnedCaloriesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RunningControlFutureStub extends io.grpc.stub.AbstractStub<RunningControlFutureStub> {
    private RunningControlFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RunningControlFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RunningControlFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RunningControlFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.runningControl.CA.watchFit.BurnedCaloriesResponse> burnedCalories(
        io.runningControl.CA.watchFit.BurnedCaloriesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBurnedCaloriesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BURNED_CALORIES = 0;
  private static final int METHODID_REST_HEART_RATE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RunningControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RunningControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BURNED_CALORIES:
          serviceImpl.burnedCalories((io.runningControl.CA.watchFit.BurnedCaloriesRequest) request,
              (io.grpc.stub.StreamObserver<io.runningControl.CA.watchFit.BurnedCaloriesResponse>) responseObserver);
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
        case METHODID_REST_HEART_RATE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.restHeartRate(
              (io.grpc.stub.StreamObserver<io.runningControl.CA.watchFit.RestHeartRateResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RunningControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RunningControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.runningControl.CA.watchFit.RunningControlgRPCProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RunningControl");
    }
  }

  private static final class RunningControlFileDescriptorSupplier
      extends RunningControlBaseDescriptorSupplier {
    RunningControlFileDescriptorSupplier() {}
  }

  private static final class RunningControlMethodDescriptorSupplier
      extends RunningControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RunningControlMethodDescriptorSupplier(String methodName) {
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
      synchronized (RunningControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RunningControlFileDescriptorSupplier())
              .addMethod(getBurnedCaloriesMethod())
              .addMethod(getRestHeartRateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
