package jmDNS;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

public class ServiceDiscovery {
	
	private static ServiceInfo serviceInfo;

	private static class SimpleListener implements ServiceListener {
		
		private int port;
		private String host;
		private ServiceInfo serviceInfo;
		
		@Override
		public void serviceAdded(ServiceEvent event) {
			System.out.println("Service added " + event.getInfo());
			
		}

		@Override
		public void serviceRemoved(ServiceEvent event) {
			System.out.println("Service removed " + event.getInfo());
			
		}

		@Override
		public void serviceResolved(ServiceEvent event) {
			System.out.println("Service resolved " + event.getInfo());
			
			ServiceInfo serviceInfo = event.getInfo();
			this.setServiceInfo(serviceInfo);
			this.setPort(serviceInfo.getPort());
		}
		
		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}

		public ServiceInfo getServiceInfo() {
			return serviceInfo;
		}

		public void setServiceInfo(ServiceInfo serviceInfo) {
			this.serviceInfo = serviceInfo;
		}
	}
	
	public static ServiceInfo run(String serviceType) {
		int port;
		
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			SimpleListener listener = new SimpleListener();
			
			// discover the service based on the service type passed on method
			jmdns.addServiceListener(serviceType, listener);
			
			Thread.sleep(10000);
			
			// retrieve serviceInfo that will be returned
			serviceInfo = listener.getServiceInfo();
			
			// port is the info we need to run our client
			port = listener.getPort();
			
			System.out.println("port from JmDNS is " + port);
			jmdns.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return serviceInfo;
	}
}
