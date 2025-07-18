package org.acme.aws.graphql_quarkus.resource;


import java.util.List;

import org.acme.aws.graphql_quarkus.body_request_and_body_response.InscriptionInput;
import org.acme.aws.graphql_quarkus.entity.Inscription;
import org.acme.aws.graphql_quarkus.traitement.InscriptionTraitement;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@GraphQLApi
public class InscriptionResource {

    @Inject
    private InscriptionTraitement inscriptionTraitement;

      @Query
    public List<Inscription> globalListRegistration() {
        return inscriptionTraitement.getRegistrationList();
    }

    @Mutation
    @Transactional
    public Inscription createRegistrationStudent( InscriptionInput inscriptionInput ) {
        Inscription inscriptionToSave =  inscriptionTraitement.createRegistrationStudent( inscriptionInput );
        return inscriptionToSave;
    }

     @Mutation
    @Transactional
    public Inscription generateRegistrationNumberOfStudent( InscriptionInput inscriptionInput ) {
        Inscription inscriptionToSave =  inscriptionTraitement.createRegistrationStudent( inscriptionInput );
        return inscriptionToSave;
    }

}
