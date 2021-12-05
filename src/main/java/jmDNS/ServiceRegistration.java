package jmDNS;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class ServiceRegistration {
	
	public void run (int port, String serviceType, String serviceName) {
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			String serviceDesc = "JmDNS integration with gRPC";
			ServiceInfo serviceInfo = ServiceInfo.create(serviceType, serviceName, port, serviceDesc);
			jmdns.registerService(serviceInfo);
			
			System.out.println("Registering service " + serviceType + " on port " + port);
			
			Thread.sleep(15000);
			
			System.out.println("Service registered");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
