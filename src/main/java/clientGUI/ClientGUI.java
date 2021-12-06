package clientGUI;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.healthControl.CA.watchFit.ExerciseZoneRequest;
import io.healthControl.CA.watchFit.ExerciseZoneResponse;
import io.healthControl.CA.watchFit.HealthControlGrpc;
import io.healthControl.CA.watchFit.TemperatureLevelRequest;
import io.healthControl.CA.watchFit.TemperatureResponse;
import io.healthControl.CA.watchFit.HealthControlGrpc.HealthControlBlockingStub;
import io.healthControl.CA.watchFit.HealthControlGrpc.HealthControlStub;
import io.runningControl.CA.watchFit.BurnedCaloriesRequest;
import io.runningControl.CA.watchFit.BurnedCaloriesResponse;
import io.runningControl.CA.watchFit.RestHeartRateRequest;
import io.runningControl.CA.watchFit.RestHeartRateResponse;
import io.runningControl.CA.watchFit.RunningControlGrpc;
import io.runningControl.CA.watchFit.RunningControlGrpc.RunningControlBlockingStub;
import io.runningControl.CA.watchFit.RunningControlGrpc.RunningControlStub;
import jmDNS.ServiceDiscovery;


public class ClientGUI implements ActionListener{

	private static HealthControlBlockingStub healthControlBlockingStub;
	private static HealthControlStub healthControlStub;

	private static RunningControlBlockingStub runningControlBlockingStub;
	private static RunningControlStub runningControlStub;
	
	final static JDialog dialog = new JDialog();
	
	ManagedChannel channelHealthControl;
	ManagedChannel channelRunningControl;
	
	ServiceInfo serviceInfoHealth;
	ServiceInfo serviceInfoRunning;

	private JPanel getService1JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JButton button = new JButton("Invoke Service 1");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		panel.setLayout(boxlayout);

		return panel;
	}

	private JPanel getService2JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JButton button = new JButton("Invoke Service 2");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		panel.setLayout(boxlayout);

		return panel;

	}

	private JPanel getService3JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
		
		JButton button = new JButton("Invoke Service 3");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		panel.setLayout(boxlayout);

		return panel;

	}

	private JPanel getService4JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JButton button = new JButton("Invoke Service 4");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		panel.setLayout(boxlayout);

		return panel;

	}
	
	public static void main(String[] args) {

		ClientGUI gui = new ClientGUI();

		gui.build();
	}

	private void build() { 

		JFrame frame = new JFrame("Service Controller Sample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
	
		panel.add( getService1JPanel() );
		panel.add( getService2JPanel() );
		panel.add( getService3JPanel() );
		panel.add( getService4JPanel() );

		// Set size for the frame
		frame.setSize(300, 300);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		String label = button.getActionCommand();  

		// server streaming
		if (label.equals("Invoke Service 1")) {
			System.out.println("service 1 to be invoked ...");
			
			String serviceTypeHealth = "_https._tcp.local.";
			serviceInfoHealth = ServiceDiscovery.run(serviceTypeHealth);
			int portHealthControl = serviceInfoHealth.getPort();

			channelHealthControl = ManagedChannelBuilder.forAddress("localhost", portHealthControl)
					.usePlaintext().build();
			healthControlBlockingStub = HealthControlGrpc.newBlockingStub(channelHealthControl);
			healthControlStub = HealthControlGrpc.newStub(channelHealthControl);
			
			exerciseZoneRateLevel();
			
			try {
				channelHealthControl.shutdown().awaitTermination(60, TimeUnit.SECONDS);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		// bidirectional
		}else if (label.equals("Invoke Service 2")) {
			System.out.println("service 2 to be invoked ...");

			String serviceTypeHealth = "_https._tcp.local.";
			serviceInfoHealth = ServiceDiscovery.run(serviceTypeHealth);
			int portHealthControl = serviceInfoHealth.getPort();
			
			channelHealthControl = ManagedChannelBuilder.forAddress("localhost", portHealthControl)
					.usePlaintext().build();
			healthControlBlockingStub = HealthControlGrpc.newBlockingStub(channelHealthControl);
			healthControlStub = HealthControlGrpc.newStub(channelHealthControl);
			
			temperatureReport();
			
			try {
				channelHealthControl.shutdown().awaitTermination(60, TimeUnit.SECONDS);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}else if (label.equals("Invoke Service 3")) {
			System.out.println("service 3 to be invoked ...");
			
			String serviceTypeRunning = "_http._tcp.local.";
			serviceInfoRunning = ServiceDiscovery.run(serviceTypeRunning);
			int portRunningControl = serviceInfoRunning.getPort();
			
			channelRunningControl = ManagedChannelBuilder.forAddress("localhost", portRunningControl)
					.usePlaintext().build();
			runningControlBlockingStub = RunningControlGrpc.newBlockingStub(channelRunningControl);
			runningControlStub = RunningControlGrpc.newStub(channelRunningControl);
			
			burnedCalories();
			
			try {
				channelRunningControl.shutdown().awaitTermination(60, TimeUnit.SECONDS);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		
		}else if (label.equals("Invoke Service 4")) {
			System.out.println("service 4 to be invoked ...");
			
			String serviceTypeRunning = "_http._tcp.local.";
			serviceInfoRunning = ServiceDiscovery.run(serviceTypeRunning);
			int portRunningControl = serviceInfoRunning.getPort();
			
			channelRunningControl = ManagedChannelBuilder.forAddress("localhost", portRunningControl)
					.usePlaintext().build();
			runningControlBlockingStub = RunningControlGrpc.newBlockingStub(channelRunningControl);
			runningControlStub = RunningControlGrpc.newStub(channelRunningControl);
			
			restHeartRate();
			
			try {
				channelRunningControl.shutdown().awaitTermination(60, TimeUnit.SECONDS);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
	}
	
	// server streaming
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
	public static void restHeartRate() {
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

			StreamObserver<RestHeartRateRequest> requestObserver = runningControlStub.restHeartRate(responseObserver);

			double heartRate;

			for (int i = 0; i < 4; i++) {
				heartRate = Double.parseDouble(JOptionPane.showInputDialog("Enter your resting heart rate"));
				requestObserver.onNext(RestHeartRateRequest.newBuilder().setRestHeartLevel(heartRate).build());
			}

			requestObserver.onCompleted();
		}	
}
