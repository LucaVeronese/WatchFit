package io.runningControl.CA.watchFit;

import java.io.IOException;
import java.util.ArrayList;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import io.runningControl.CA.watchFit.RunningControlGrpc.RunningControlImplBase;
import jmDNS.ServiceRegistration;

public class RunningControlServer extends RunningControlImplBase {

	public static void main(String[] args) {
		RunningControlServer runningControlServer = new RunningControlServer();
		
		// JmDNS integration
		int port = 50052;
		String serviceName = "gRPC Server";
		String serviceType = "_http._tcp.local.";
		ServiceRegistration service = new ServiceRegistration();
		service.run(port, serviceType, serviceName);
		
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

	// client streaming
	@Override
	public StreamObserver<ExerciseTimeRequest> exerciseTime(StreamObserver<ExerciseTimeResponse> responseObserver) {
		
		return new StreamObserver<ExerciseTimeRequest>() {

			double start, end;
			
			@Override
			public void onNext(ExerciseTimeRequest value) {	
				if (value.getExerciseTimeSignal() == true)
					start = System.currentTimeMillis();
				else if (value.getExerciseTimeSignal() == false)
					end = System.currentTimeMillis();
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				ExerciseTimeResponse response = ExerciseTimeResponse.newBuilder().setExerciseTimeResponse("Congrats! You have exercised for " + (end - start)/1000 + " seconds").build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
			}
		};
	}
}
