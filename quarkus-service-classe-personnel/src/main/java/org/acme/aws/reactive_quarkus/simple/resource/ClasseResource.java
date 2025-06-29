package org.acme.aws.reactive_quarkus.simple.resource;

import org.acme.aws.reactive_quarkus.simple.entity.Personnel;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/classe")
public class ClasseResource {

    @Path("/list")
    @GET
    public String listClasses() {
        return "List of classes";
    }

    

}