package org.acme.aws.reactive_quarkus.simple;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

//    @ConfigProperty(name = "greeting.message", defaultValue="Hello from default")
//     String message;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "message";
    }
    
}
