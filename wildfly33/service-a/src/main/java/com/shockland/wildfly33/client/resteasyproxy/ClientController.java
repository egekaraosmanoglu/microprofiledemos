package com.shockland.wildfly33.client.resteasyproxy;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/clientRestEasy")
@ApplicationScoped
public class ClientController {

    @Inject
    private Service service;

    @GET
    @Path("/test/{parameter}")
    public String onClientSide(@PathParam("parameter") String parameter) {
        return "resteasy " + service.doSomething(parameter);
    }
}
