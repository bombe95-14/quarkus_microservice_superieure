package org.acme.aws.graphql_quarkus.traitement;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import org.acme.aws.graphql_quarkus.repository.EleveRepository;


public class EleveTraitement {
    
@Inject
EleveRepository eleveRepository;

@GET
public long count(){
    
    return eleveRepository.count();
}

}
