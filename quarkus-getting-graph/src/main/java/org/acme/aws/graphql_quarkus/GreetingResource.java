package org.acme.aws.graphql_quarkus;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import org.acme.aws.graphql_quarkus.entity.Eleve;



@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

     @POST
    @Transactional
    public Response create(Eleve eleve) {
        eleve.persist();
        return Response.created(URI.create("/persons/" + eleve.id )).build();
    }
}
  