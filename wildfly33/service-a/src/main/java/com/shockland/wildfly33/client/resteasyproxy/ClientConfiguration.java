package com.shockland.wildfly33.client.resteasyproxy;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class ClientConfiguration {
	
	@Inject
	@ConfigProperty(name = "servicebHost")
    private String 	servicebHost;
	
	@Inject
	@ConfigProperty(name = "servicebPort")
    private String 	servicebPort;

	
	@Produces
	public Service service() {
		
		System.out.println("ClientConfiguration Service " + System.currentTimeMillis());
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://" + servicebHost + ":" + servicebPort + "/data/client/service" );
		ResteasyWebTarget rtarget = (ResteasyWebTarget) target;
		Service service = rtarget.proxy(Service.class);
		return service;
	}
	
}
