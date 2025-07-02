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

    @Path("/add")
    @POST
    public Personnel addClass(Personnel personnel) {
        // Here you would typically add the class to a database or perform some action
        return personnel;
    }

    @Path("/classe/{classroomId}")
    @POST
    public Long removeClass(Long classroomId) {
    
        // Here you would typically remove the class from a database or perform some action
        return classroomId;
    }

    

}