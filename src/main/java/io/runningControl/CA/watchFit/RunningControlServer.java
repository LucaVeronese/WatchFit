package io.runningControl.CA.watchFit;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import io.runningControl.CA.watchFit.RunningControlGrpc.RunningControlImplBase;

public class RunningControlServer extends RunningControlImplBase {

	public static void main(String[] args) {
		RunningControlServer runningControlServer = new RunningControlServer();
		int port = 50052;
		
		try {
			Server server = ServerBuilder.forPort(port).addService(runningControlServer).build().start();
			System.out.println("Server running on port " + port);
			server.awaitTermination();
		} catch (IOException e) {
			System.out.println("Server 'HealthControl' is not up and running...");
		} catch (InterruptedException e) {
			System.out.println("Thread in 'RunningControl' server was interrupted...");
		}
	}

	// unary - completed
	@Override
	public void burnedCalories(BurnedCaloriesRequest request, StreamObserver<BurnedCaloriesResponse> responseObserver) {
		
		int weight = request.getWeight();
		int height = request.getHeight();
		int age = request.getAge();
		double basalMetabolicRate = 0, metabolicEquivalents = 0;
		int activities = request.getActivity();
		double burnedCalories;
		
		if (request.getGender().toUpperCase().equals("MALE"))
			basalMetabolicRate = 66 + (6.23 * weight) + (12.7 * height) - (6.8 * age);
		else if (request.getGender().toUpperCase().equals("FEMALE"))
			basalMetabolicRate = 655 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
		
		switch(activities) {
		case 1:
			metabolicEquivalents = 2.3;
			break;
		case 2:
			metabolicEquivalents = 4;
			break;
		case 3:
			metabolicEquivalents = 3.8;
			break;
		case 4:
			metabolicEquivalents = 8;
			break;
		case 5:
			metabolicEquivalents = 7;
			break;
		case 6:
			metabolicEquivalents = 3.6;
			break;
		}
		
		burnedCalories = (basalMetabolicRate * metabolicEquivalents) / 24 * request.getDuration();
		BurnedCaloriesResponse response = BurnedCaloriesResponse.newBuilder().setBurnedCalories(burnedCalories).build();
		
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
