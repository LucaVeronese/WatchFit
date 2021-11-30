package clientWatchFitgRPC;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.healthControl.CA.watchFit.ExerciseZoneRequest;
import io.healthControl.CA.watchFit.ExerciseZoneResponse;
import io.healthControl.CA.watchFit.HealthControlGrpc;
import io.healthControl.CA.watchFit.HealthControlGrpc.HealthControlBlockingStub;
import io.healthControl.CA.watchFit.HealthControlGrpc.HealthControlStub;

public class ClientWatchFitgRPC {

	private static HealthControlBlockingStub healthControlBlockingStub;
	private static HealthControlStub healthControlStub;

	public static void main(String[] args) {

		// channel for the first Server
		ManagedChannel channelHealthControl = ManagedChannelBuilder.forAddress("localhost", 50051).build();

		// here channel for second Server

		healthControlBlockingStub = HealthControlGrpc.newBlockingStub(channelHealthControl);
		healthControlStub = HealthControlGrpc.newStub(channelHealthControl);

		int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age: "));
		int restingHeartRate = Integer.parseInt(JOptionPane.showInputDialog("Enter your resting hear rate: "));

		// bidirectional rpc
		// TemperatureReport();

		// server streaming
		exerciseZoneRateLevel(age, restingHeartRate);

		try {
			channelHealthControl.shutdown().awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void exerciseZoneRateLevel(int age, int restingHeartRate) {
		ExerciseZoneRequest request = ExerciseZoneRequest.newBuilder().setAge(age).setRestingHeartRate(restingHeartRate)
				.build();

		Iterator<ExerciseZoneResponse> response = healthControlBlockingStub.exerciseZoneRateLevel(request);
		
		ExerciseZoneResponse cardioValue = response.next();
		JOptionPane.showMessageDialog(null, "Your cardio level is: " + cardioValue.getCardioValue());
		ExerciseZoneResponse fatBurnValue = response.next();
		JOptionPane.showMessageDialog(null, "Your fat burn level is: " + fatBurnValue.getCardioValue());
		ExerciseZoneResponse peakValue = response.next();
		JOptionPane.showMessageDialog(null, "Your peak level is: " + peakValue.getCardioValue());
	}

}
