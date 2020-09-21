package com.shockland.wildfly33.config;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/egeconfig")
@RequestScoped
public class EgeConfigTestController {

	@Inject
	private Config config;
	
	
    @Inject
    @ConfigProperty(name = "injected.value")
    private String injectedValue;
    
    @Inject
    @ConfigProperty(name = "personname") 
    private Person person;
    
    

    @Path("/injected")
    @GET
    public String getInjectedConfigValue() {
        return "Config value as Injected by CDI " + injectedValue;
    }

    @Path("/lookup")
    @GET
    public String getLookupConfigValue() {
        Config config = ConfigProvider.getConfig();
        String value = config.getValue("value", String.class);
        return "Config value from ConfigProvider " + value;
    }
    
    @Path("/lookupConfig")
    @GET  
    public String displayProperties(){
    	   Optional<String> optionalValue = config.getOptionalValue("optional",String.class); 
    	   optionalValue.ifPresent(v -> System.out.println(v));

    	   String requiredValue = config.getValue("required",String.class);  
    	   System.out.println(requiredValue);
    	   
    	   
    	   System.out.println("person name from config: " + person.getName());
    	   return "check logs";
    	}
    
    
    
}
