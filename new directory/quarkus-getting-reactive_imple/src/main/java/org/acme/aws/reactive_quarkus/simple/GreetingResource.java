package org.acme.aws.reactive_quarkus.simple;

import org.acme.aws.reactive_quarkus.simple.global.ParametersRequest;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

        @POST
    public String allParams(@BeanParam ParametersRequest parameters) { 
        return " "; 
    }
}
