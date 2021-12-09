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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
import io.runningControl.CA.watchFit.ExerciseTimeRequest;
import io.runningControl.CA.watchFit.ExerciseTimeResponse;
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
		
		dialog.setAlwaysOnTop(true); 

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
			
			// JmDNS integration - discovering the port specifying service type
			String serviceTypeHealth = "_https._tcp.local.";
			serviceInfoHealth = ServiceDiscovery.run(serviceTypeHealth);
			int portHealthControl = serviceInfoHealth.getPort(); // retrieving port

			// building channel using the retrieved port
			channelHealthControl = ManagedChannelBuilder.forAddress("localhost", portHealthControl)
					.usePlaintext().build();
			healthControlBlockingStub = HealthControlGrpc.newBlockingStub(channelHealthControl); //creating the stub
			
			exerciseZoneRateLevel();
			
			try {
				channelHealthControl.shutdown().awaitTermination(60, TimeUnit.SECONDS);
			} catch (InterruptedException e1) {
				System.out.println("Service 1 was interrupted... error occured!");
			}

		// bidirectional
		}else if (label.equals("Invoke Service 2")) {
			System.out.println("service 2 to be invoked ...");

			String serviceTypeHealth = "_https._tcp.local.";
			serviceInfoHealth = ServiceDiscovery.run(serviceTypeHealth);
			int portHealthControl = serviceInfoHealth.getPort();
			
			channelHealthControl = ManagedChannelBuilder.forAddress("localhost", portHealthControl)
					.usePlaintext().build();
			healthControlStub = HealthControlGrpc.newStub(channelHealthControl);
			
			temperatureReport();
			
			try {
				channelHealthControl.shutdown().awaitTermination(60, TimeUnit.SECONDS);
			} catch (InterruptedException e2) {
				System.out.println("Service 2 was interrupted... error occured!");
			}
			
		// unary
		}else if (label.equals("Invoke Service 3")) {
			System.out.println("service 3 to be invoked ...");
			
			String serviceTypeRunning = "_http._tcp.local.";
			serviceInfoRunning = ServiceDiscovery.run(serviceTypeRunning);
			int portRunningControl = serviceInfoRunning.getPort();
			
			channelRunningControl = ManagedChannelBuilder.forAddress("localhost", portRunningControl)
					.usePlaintext().build();
			runningControlBlockingStub = RunningControlGrpc.newBlockingStub(channelRunningControl);
			
			burnedCalories();
			
			try {
				channelRunningControl.shutdown().awaitTermination(60, TimeUnit.SECONDS);
			} catch (InterruptedException e3) {
				System.out.println("Service 3 was interrupted... error occured!");
			}

		// client streaming
		}else if (label.equals("Invoke Service 4")) {
			System.out.println("service 4 to be invoked ...");
			
			String serviceTypeRunning = "_http._tcp.local.";
			serviceInfoRunning = ServiceDiscovery.run(serviceTypeRunning);
			int portRunningControl = serviceInfoRunning.getPort();
			
			channelRunningControl = ManagedChannelBuilder.forAddress("localhost", portRunningControl)
					.usePlaintext().build();
			runningControlStub = RunningControlGrpc.newStub(channelRunningControl);
			
			exerciseTime();
			
			try {
				channelRunningControl.shutdown().awaitTermination(60, TimeUnit.SECONDS);
			} catch (InterruptedException e4) {
				System.out.println("Service 4 was interrupted... error occured!");
			}
		
		}
	}
	
	// server streaming
	public static void exerciseZoneRateLevel() {
		int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age: "));
		int restingHeartRate = Integer.parseInt(JOptionPane.showInputDialog("Enter your resting hear rate: "));

		// request is sent as a unique message containing two information
		ExerciseZoneRequest request = ExerciseZoneRequest.newBuilder().setAge(age).setRestingHeartRate(restingHeartRate)
				.build();

		// response is collected as an Iterator
		Iterator<ExerciseZoneResponse> response = healthControlBlockingStub.exerciseZoneRateLevel(request);

		// reading content using .next() method
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
					//JOptionPane.showMessageDialog(null, "This is today's report on your temperature.\n Average Temp " + value.getAverageTemperature() + "\n Below Temp " + value.getBelowTemperature() + "\n Above Temp " + value.getAboveTemperature());
					
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "This is today's report on your temperature.\n Average Temp " + value.getAverageTemperature() + "\n Below Temp " + value.getBelowTemperature() + "\n Above Temp " + value.getAboveTemperature());
				}

				@Override
				public void onError(Throwable t) {
					System.out.println(t.getMessage());

				}

				@Override
				public void onCompleted() {
					JOptionPane.showMessageDialog(null, "Application has no more data to show...");
				}
			};

			StreamObserver<TemperatureLevelRequest> requestObserver = healthControlStub.temperatureReport(responseObserver);

			// application will run 15 times
			int counter = 0;
			double temperature;
			do {
				// we wait to allow the user to read the report
				//if (counter == 5 || counter == 10) {
				/*try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
				//}
				temperature = Double.parseDouble(JOptionPane.showInputDialog("Body temperature: "));

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

			// single message sent
			BurnedCaloriesRequest request = BurnedCaloriesRequest.newBuilder().setAge(age).setWeight(weight)
					.setHeight(height).setGender(gender).setDuration(duration).setActivity(activity).build();

			// single response obtained
			BurnedCaloriesResponse response = runningControlBlockingStub.burnedCalories(request);
			
			// formatting
			DecimalFormat numberFormat = new DecimalFormat("#.00");
			JOptionPane.showMessageDialog(dialog,
					"Your caloric consuption is " + numberFormat.format(response.getBurnedCalories()));
		}

	// client streaming
	public static void exerciseTime() {
		StreamObserver<ExerciseTimeResponse> responseObserver = new StreamObserver<ExerciseTimeResponse>() {

			@Override
			public void onNext(ExerciseTimeResponse value) {
				JOptionPane.showMessageDialog(dialog, value.getExerciseTimeResponse());
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
			}
		};
		
		StreamObserver<ExerciseTimeRequest> requestObserver = runningControlStub.exerciseTime(responseObserver);
		
		String answer = JOptionPane.showInputDialog("Please type 'Start' when you want to begin your workout!");
		if (answer.toUpperCase().equals("START")) {
			
			String exerciseIsOver;
			requestObserver.onNext(ExerciseTimeRequest.newBuilder().setExerciseTimeSignal(true).build());
			
			do {
				exerciseIsOver = JOptionPane.showInputDialog("Type 'Over' when you are done");
				if (exerciseIsOver.toUpperCase().equals("OVER"))
				{
					requestObserver.onNext(ExerciseTimeRequest.newBuilder().setExerciseTimeSignal(false).build());
					requestObserver.onCompleted();
				}
				else
					JOptionPane.showMessageDialog(dialog, "Wrong input...");
			} while (!exerciseIsOver.toUpperCase().equals("OVER"));
		}
		else
			JOptionPane.showMessageDialog(dialog, "Invalid entry");
	}
}
