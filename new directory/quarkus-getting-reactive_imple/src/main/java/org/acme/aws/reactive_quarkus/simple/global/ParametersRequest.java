package org.acme.aws.reactive_quarkus.simple.global;

import java.io.File;

import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestCookie;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestHeader;
import org.jboss.resteasy.reactive.RestMatrix;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;

import jakarta.ws.rs.core.MediaType;

public class ParametersRequest {
    
        @RestPath
        String type;

        @RestMatrix
        String variant;

        @RestQuery
        String age;

        @RestCookie
        String level;

        @RestHeader("X-Cheese-Secret-Handshake")
        String secretHandshake;

        @RestForm
        String smell;


    @RestForm
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    File file;

}
