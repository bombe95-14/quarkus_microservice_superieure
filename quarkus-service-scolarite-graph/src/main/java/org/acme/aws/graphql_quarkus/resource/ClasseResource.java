package org.acme.aws.graphql_quarkus.resource;


import java.util.List;

import org.acme.aws.graphql_quarkus.body_request_and_body_response.CreateClase;
import org.acme.aws.graphql_quarkus.body_request_and_body_response.EleveInput;
import org.acme.aws.graphql_quarkus.entity.Classe;
import org.acme.aws.graphql_quarkus.entity.Eleve;
import org.acme.aws.graphql_quarkus.traitement.ClasseTraitement;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@GraphQLApi
public class ClasseResource {

    @Inject
    private ClasseTraitement classeTraitement;

    @Query
    public List<Classe> globalListClasse() {
        return classeTraitement.getAllClasse();
    }

    @Mutation
    @Transactional
    public Classe createClasse( CreateClase createClase ) {
        Classe eleveToSave =  classeTraitement.createClasse( createClase );
        return eleveToSave;
    }

}
