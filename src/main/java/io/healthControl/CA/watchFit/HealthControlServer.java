package io.healthControl.CA.watchFit;

import java.io.IOException;

import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import io.healthControl.CA.watchFit.HealthControlGrpc.HealthControlImplBase;

public class HealthControlServer extends HealthControlImplBase {

	public static void main(String[] args) {

		HealthControlServer healthControlServer = new HealthControlServer();

		int port = 50051;

		try {
			Server server = ServerBuilder.forPort(port).addService(healthControlServer).build().start();
			System.out.println("Server running on port " + port);
			server.awaitTermination();
		} catch (IOException e) {
			System.out.println("Server 'HealthControl' is not up and running...");
		} catch (InterruptedException e) {
			System.out.println("Thread in 'HealthControl' server was interrupted...");
		}
	}

	@Override
	public void exerciseZoneRateLevel(ExerciseZoneRequest request,
			StreamObserver<ExerciseZoneResponse> responseObserver) {

		int age = request.getAge();
		int restingHeartRate = request.getRestingHeartRate();
		int maximumHeartRate = 220 - age;

		double cardioValueLow = ((maximumHeartRate - restingHeartRate) * 0.5) + restingHeartRate;
		double cardioValueHigh = ((maximumHeartRate - restingHeartRate) * 0.75) + restingHeartRate;
		
		ExerciseZoneResponse reply = ExerciseZoneResponse.newBuilder()
				.setCardioValue(cardioValueLow + " and " + cardioValueHigh).build();
		responseObserver.onNext(reply);
		
		double fatValueLow = ((maximumHeartRate - restingHeartRate) * 0.75) + restingHeartRate;
		double fatValueHigh = ((maximumHeartRate - restingHeartRate) * 0.85) + restingHeartRate;
		
		ExerciseZoneResponse reply2 = ExerciseZoneResponse.newBuilder().setFatBurnValue(fatValueLow + " and " + fatValueHigh).build();
		responseObserver.onNext(reply2);
		
		double peakValueLow = ((maximumHeartRate - restingHeartRate) * 0.85) + restingHeartRate;
		double peakValueHigh = ((maximumHeartRate - restingHeartRate) * 0.95) + restingHeartRate;
		
		ExerciseZoneResponse reply3 = ExerciseZoneResponse.newBuilder().setPeakValue(peakValueLow + " and " + peakValueHigh).build();
		responseObserver.onNext(reply3);
		
		responseObserver.onCompleted();
	}

}
