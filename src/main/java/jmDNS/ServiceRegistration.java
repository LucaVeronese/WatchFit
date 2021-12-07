package jmDNS;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class ServiceRegistration {
	
	public void run (int port, String serviceType, String serviceName) {
		try {
			// instance of jmdns
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			String serviceDesc = "JmDNS integration with gRPC";
			
			// creation of serviceInfo with specified elements
			ServiceInfo serviceInfo = ServiceInfo.create(serviceType, serviceName, port, serviceDesc);
			
			// jmdns is being registered. Thread.sleep is needed as this can take some time.
			jmdns.registerService(serviceInfo);
			
			System.out.println("Registering service " + serviceType + " on port " + port);
			
			Thread.sleep(15000);
			
			System.out.println("Service registered");
		
		} catch (InterruptedException e) {
			System.out.println("Service was interrupted... error occured!");
		} catch (IOException e) {
			System.out.println("Service was not registered successfully...");
		}
	}

}
