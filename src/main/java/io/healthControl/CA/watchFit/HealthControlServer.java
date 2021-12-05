package io.healthControl.CA.watchFit;

import java.io.IOException;
import java.util.ArrayList;

import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import io.healthControl.CA.watchFit.HealthControlGrpc.HealthControlImplBase;
import io.runningControl.CA.watchFit.BurnedCaloriesRequest;
import jmDNS.ServiceRegistration;

public class HealthControlServer extends HealthControlImplBase {

	public static void main(String[] args) {

		HealthControlServer healthControlServer = new HealthControlServer();

		int port = 50051;
		String serviceName = "gRPC Server Health Control";
		String serviceType = "_https._tcp.local.";
		ServiceRegistration service = new ServiceRegistration();
		service.run(port, serviceType, serviceName);

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

	// server streaming - completed
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

		ExerciseZoneResponse reply2 = ExerciseZoneResponse.newBuilder()
				.setFatBurnValue(fatValueLow + " and " + fatValueHigh).build();
		responseObserver.onNext(reply2);

		double peakValueLow = ((maximumHeartRate - restingHeartRate) * 0.85) + restingHeartRate;
		double peakValueHigh = ((maximumHeartRate - restingHeartRate) * 0.95) + restingHeartRate;

		ExerciseZoneResponse reply3 = ExerciseZoneResponse.newBuilder()
				.setPeakValue(peakValueLow + " and " + peakValueHigh).build();
		responseObserver.onNext(reply3);

		responseObserver.onCompleted();
	}

	// bidirectional - GUI in Client to be fixed
	@Override
	public StreamObserver<TemperatureLevelRequest> temperatureReport(
			StreamObserver<TemperatureResponse> responseObserver) {

		return new StreamObserver<TemperatureLevelRequest>() {

			ArrayList<Double> list = new ArrayList<>();
			int belowTemp = 0, averageTemp = 0, aboveTemp = 0, counter = 0;
			
			@Override
			public void onNext(TemperatureLevelRequest value) {				
				
				list.add(value.getTemperature());

				if (list.size() % 5 == 0) {
					for (int i = counter; i < list.size(); i++) {
						if (list.get(i) >= 36.1 && list.get(i) < 37.2)
							averageTemp++;
						else if (list.get(i) < 36.1)
							belowTemp++;
						else if (list.get(i) > 37.2)
							aboveTemp++;
					}
					TemperatureResponse reply = TemperatureResponse.newBuilder().setAboveTemperature(aboveTemp)
							.setAverageTemperature(averageTemp).setBelowTemperature(belowTemp).build();
					responseObserver.onNext(reply);
					
					counter = counter + 5;
					belowTemp = averageTemp = aboveTemp = 0;
				}
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCompleted() {
				responseObserver.onCompleted();
			}
		};
	}
}
