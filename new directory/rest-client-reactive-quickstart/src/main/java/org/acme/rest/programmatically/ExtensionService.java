package org.acme.rest.programmatically;

import java.util.Set;

import org.acme.rest.client.Extension;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/extensions")
public interface ExtensionService {
    
 @GET
    Set<Extension> getById(@QueryParam("id") String id);

}
