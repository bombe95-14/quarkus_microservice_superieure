package org.acme.aws.reactive_quarkus.simple.service;

import java.util.Set;

import org.acme.aws.reactive_quarkus.simple.entity.Classe;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

public interface ExtensionsService {

     //@GET
    Set<Classe> getById(@QueryParam(value = "id") String id);

}
