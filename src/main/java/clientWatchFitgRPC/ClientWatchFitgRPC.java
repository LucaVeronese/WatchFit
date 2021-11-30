package clientWatchFitgRPC;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
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

	}

}
