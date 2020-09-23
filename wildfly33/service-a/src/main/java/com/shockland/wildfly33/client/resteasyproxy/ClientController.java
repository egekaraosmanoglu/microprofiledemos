package com.shockland.wildfly33.client.resteasyproxy;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.faulttolerance.Fallback;

@Path("/clientRestEasy")
@ApplicationScoped
public class ClientController {

    @Inject
    private Service service;

    @GET
    @Path("/test/{parameter}")
    @Fallback(fallbackMethod = "fallbackClientMethod")
    public String onClientSide(@PathParam("parameter") String parameter) {
        return "resteasy " + service.doSomething(parameter);
    }
    
    
    private String fallbackClientMethod()
    {
    	return "fallbackRestEasy";
    }
}
