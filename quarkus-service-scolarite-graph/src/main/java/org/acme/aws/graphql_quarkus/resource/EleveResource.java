package org.acme.aws.graphql_quarkus.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.aws.graphql_quarkus.body_request_and_body_response.EleveInput;
import org.acme.aws.graphql_quarkus.dto.response_request.EleveResponseDto;
import org.acme.aws.graphql_quarkus.entity.Eleve;
import org.acme.aws.graphql_quarkus.traitement.EleveTraitement;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class EleveResource {

    @Inject
    EleveTraitement eleveTraitement;

    @Query
    public List<EleveResponseDto> globalListStudent() {
        return eleveTraitement.getListEleve().stream().map( eleve -> new EleveResponseDto( eleve ) ).toList();
    }

    @Query
    public EleveResponseDto informationsStudent( Long idEleve ) {
        return new EleveResponseDto( eleveTraitement.informationsStudent(idEleve) );
    }

    @Mutation
    @Transactional
    public EleveResponseDto createStudent( EleveInput eleveInput ) {
        Eleve eleveToSave =  eleveTraitement.createStudent( eleveInput );

        return new EleveResponseDto( eleveToSave );
    }

}
