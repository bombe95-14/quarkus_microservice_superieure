package org.acme.rest.programmatically;

import java.net.URI;
import java.util.Set;

import org.acme.rest.client.Extension;
import org.acme.rest.client.ExtensionsService;

import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/extension")
public class ExtensionRessource {

    private final ExtensionsService extensionsService;

    public ExtensionRessource() {
        extensionsService = QuarkusRestClientBuilder.newBuilder()
            .baseUri(URI.create("https://stage.code.quarkus.io/api"))
            .build(ExtensionsService.class);
    }

    @GET
    @Path("/id/{id}")
    public Set<Extension> id(String id) {
        return extensionsService.getById(id);
    }
}