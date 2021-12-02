package io.runningControl.CA.watchFit;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
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

}
