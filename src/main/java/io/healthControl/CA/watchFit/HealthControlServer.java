package io.healthControl.CA.watchFit;

import java.io.IOException;

import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.healthControl.CA.watchFit.HealthControlGrpc.HealthControlImplBase;

public class HealthControlServer extends HealthControlImplBase{

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

}
