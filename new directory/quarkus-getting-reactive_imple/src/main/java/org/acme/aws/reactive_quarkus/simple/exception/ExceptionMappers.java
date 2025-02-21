package org.acme.aws.reactive_quarkus.simple.exception;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import jakarta.ws.rs.core.Response;

public class ExceptionMappers {
    
 @ServerExceptionMapper
    public RestResponse<String> mapException(Exception x) {
        return RestResponse.status(Response.Status.NOT_FOUND, "Unknown cheese: " + x.getMessage());
    }
    
}
