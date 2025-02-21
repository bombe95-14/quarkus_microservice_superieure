package org.acme.aws.reactive_quarkus.simple.global;

import java.net.URI;
import java.util.Optional;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerRequestFilter;
import org.jboss.resteasy.reactive.server.ServerResponseFilter;

import jakarta.ws.rs.HttpMethod;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.core.Response;

public class Filters {
    
  @ServerRequestFilter(preMatching = true)
    public void preMatchingFilter(ContainerRequestContext requestContext) {
        // make sure we don't lose cheese lovers
        if("yes".equals(requestContext.getHeaderString("Cheese"))) {
            requestContext.setRequestUri(URI.create("/cheese"));
        }
    }

    @ServerRequestFilter
    public Optional<RestResponse<Void>> getFilter(ContainerRequestContext ctx) {
        // only allow GET methods for now
        if(ctx.getMethod().equals(HttpMethod.GET)) {
            return Optional.of(RestResponse.status(Response.Status.METHOD_NOT_ALLOWED));
        }
        return Optional.empty();
    }

        @ServerResponseFilter
    public void getFilter(ContainerResponseContext responseContext) {
        Object entity = responseContext.getEntity();
        if(entity instanceof String) {
            // make it shout
            responseContext.setEntity(((String)entity).toUpperCase());
        }
    }

}
