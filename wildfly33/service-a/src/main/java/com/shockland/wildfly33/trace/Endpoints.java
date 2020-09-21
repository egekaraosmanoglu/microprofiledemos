package com.shockland.wildfly33.trace;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.opentracing.Traced;

@Path("/trace")
//JAxRS endpoints are always traced. Adding the annotation for clarity doesn't hurt, but not strictly needed 
//@Traced
public class Endpoints {

    @Inject
    private TracedHelloService helloService;

    @GET
    @Path("/json")
    @Produces({"application/json"})
    public String getHelloWorldJSON(@DefaultValue("World") @QueryParam("name") String name) {
        return "{\"result\":\"" + helloService.createHelloMessage(name) + "\"}";
    }

    @GET
    @Path("/xml")
    @Produces({"application/xml"})
    public String getHelloWorldXML(@DefaultValue("World") @QueryParam("name") String name) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><xml><result>" + helloService.createHelloMessage(name) + "</result></xml>";
    }

}