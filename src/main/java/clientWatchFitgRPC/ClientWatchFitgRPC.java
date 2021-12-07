package clientWatchFitgRPC;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.healthControl.CA.watchFit.ExerciseZoneRequest;
import io.healthControl.CA.watchFit.ExerciseZoneResponse;
import io.healthControl.CA.watchFit.HealthControlGrpc;
import io.healthControl.CA.watchFit.HealthControlGrpc.HealthControlBlockingStub;
import io.healthControl.CA.watchFit.HealthControlGrpc.HealthControlStub;
import io.healthControl.CA.watchFit.TemperatureLevelRequest;
import io.healthControl.CA.watchFit.TemperatureResponse;
import io.runningControl.CA.watchFit.BurnedCaloriesRequest;
import io.runningControl.CA.watchFit.BurnedCaloriesResponse;
import io.runningControl.CA.watchFit.RunningControlGrpc;
import io.runningControl.CA.watchFit.RunningControlGrpc.RunningControlBlockingStub;
import io.runningControl.CA.watchFit.RunningControlGrpc.RunningControlStub;
import jmDNS.ServiceDiscovery;

public class ClientWatchFitgRPC {

	private static HealthControlBlockingStub healthControlBlockingStub;
	private static HealthControlStub healthControlStub;

	private static RunningControlBlockingStub runningControlBlockingStub;
	private static RunningControlStub runningControlStub;
	
	final static JDialog dialog = new JDialog();

	public static void main(String[] args) {
			
		dialog.setAlwaysOnTop(true); 

		// JmDNS implementation - Service Discovery
		/*ServiceInfo serviceInfoHealth;
		ServiceInfo serviceInfoRunning;
		
		String serviceTypeHealth = "_https._tcp.local.";
		serviceInfoHealth = ServiceDiscovery.run(serviceTypeHealth);
		int portHealthControl = serviceInfoHealth.getPort();
		
		String serviceTypeRunning = "_http._tcp.local.";
		serviceInfoRunning = ServiceDiscovery.run(serviceTypeRunning);
		int portRunningControl = serviceInfoRunning.getPort();
*/
		// channel for the first Server
		ManagedChannel channelHealthControl = ManagedChannelBuilder.forAddress("localhost", 50051)//portHealthControl)
				.usePlaintext().build();
		healthControlBlockingStub = HealthControlGrpc.newBlockingStub(channelHealthControl);
		healthControlStub = HealthControlGrpc.newStub(channelHealthControl);

		// here channel for second Server
		ManagedChannel channelRunningControl = ManagedChannelBuilder.forAddress("localhost", 50052)//portRunningControl)
				.usePlaintext().build();
		runningControlBlockingStub = RunningControlGrpc.newBlockingStub(channelRunningControl);
		runningControlStub = RunningControlGrpc.newStub(channelRunningControl);

		
		 // server streaming 
		// exerciseZoneRateLevel();
		 
		 // bidirectional
		temperatureReport();
		
		 // unary 
		 burnedCalories();
		 

		// client streaming
		// restHeartRate();

		try {
			channelHealthControl.shutdown().awaitTermination(60, TimeUnit.SECONDS);
			channelRunningControl.shutdown().awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// server streaming - completed
	public static void exerciseZoneRateLevel() {
		int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age: "));
		int restingHeartRate = Integer.parseInt(JOptionPane.showInputDialog("Enter your resting hear rate: "));

		ExerciseZoneRequest request = ExerciseZoneRequest.newBuilder().setAge(age).setRestingHeartRate(restingHeartRate)
				.build();

		Iterator<ExerciseZoneResponse> response = healthControlBlockingStub.exerciseZoneRateLevel(request);

		ExerciseZoneResponse cardioValue = response.next();
		JOptionPane.showMessageDialog(dialog, "Your cardio level is between " + cardioValue.getCardioValue());
		ExerciseZoneResponse fatBurnValue = response.next();
		JOptionPane.showMessageDialog(dialog, "Your fat burn level is between " + fatBurnValue.getFatBurnValue());
		ExerciseZoneResponse peakValue = response.next();
		JOptionPane.showMessageDialog(dialog, "Your peak level is: " + peakValue.getPeakValue());
	}

	// bidirectional
	public static void temperatureReport() {

		StreamObserver<TemperatureResponse> responseObserver = new StreamObserver<TemperatureResponse>() {

			@Override
			public void onNext(TemperatureResponse value) {
				JOptionPane.showMessageDialog(dialog, "This is today's report on your temperature.\n Average Temp " + value.getAverageTemperature() + "\n Below Temp " + value.getBelowTemperature() + "\n Above Temp " + value.getAboveTemperature());		 
			}

			@Override
			public void onError(Throwable t) {
				System.out.println(t.getMessage());

			}

			@Override
			public void onCompleted() {
				JOptionPane.showMessageDialog(dialog, "Application has no more data to show...");
			}
		};

		StreamObserver<TemperatureLevelRequest> requestObserver = healthControlStub.temperatureReport(responseObserver);

		// application will run 15 times only
		int counter = 0;
		do {
			if (counter == 5 || counter == 10) {
				try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			double temperature = Double.parseDouble(JOptionPane.showInputDialog("Enter your temperature: "));

			requestObserver.onNext(TemperatureLevelRequest.newBuilder().setTemperature(temperature).build());

			counter++;
		} while (counter < 15);

		requestObserver.onCompleted();
	}

	// unary - completed
	public static void burnedCalories() {
		int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age: "));
		int weight = Integer.parseInt(JOptionPane.showInputDialog("Enter your weight in lbs: "));
		int height = Integer.parseInt(JOptionPane.showInputDialog("Enter your height in inches: "));
		String gender = JOptionPane.showInputDialog("Enter your gender (male or female): ");
		double duration = Double
				.parseDouble(JOptionPane.showInputDialog("Enter the duration of your activity (in hours): "));
		int activity = Integer.parseInt(JOptionPane.showInputDialog(
				"Which activity did you perform? Enter the correspondent index\n1 - Slow walk\n2 - Leisure cycle\n3 - Pilates\n4 - Heavy lifting\n5 - Jogging\n6 - Fast walk"));

		BurnedCaloriesRequest request = BurnedCaloriesRequest.newBuilder().setAge(age).setWeight(weight)
				.setHeight(height).setGender(gender).setDuration(duration).setActivity(activity).build();

		BurnedCaloriesResponse response = runningControlBlockingStub.burnedCalories(request);
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		JOptionPane.showMessageDialog(dialog,
				"Your caloric consuption is " + numberFormat.format(response.getBurnedCalories()));
	}

	// client streaming
	/*public static void restHeartRate() {
		StreamObserver<RestHeartRateResponse> responseObserver = new StreamObserver<RestHeartRateResponse>() {

			@Override
			public void onNext(RestHeartRateResponse value) {
				JOptionPane.showMessageDialog(dialog, value.getRestHeartLevelResponse());

			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCompleted() {
				JOptionPane.showMessageDialog(dialog, "Application has finished...");
			}
		};
	}*/
}