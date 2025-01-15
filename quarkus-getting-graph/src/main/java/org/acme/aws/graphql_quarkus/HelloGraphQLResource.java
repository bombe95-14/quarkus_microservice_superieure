package org.acme.aws.graphql_quarkus;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.aws.graphql_quarkus.entity.Eleve;
import org.acme.aws.graphql_quarkus.traitement.EleveTraitement;
import org.eclipse.microprofile.graphql.*;


@GraphQLApi
public class HelloGraphQLResource {

    @Inject
    EleveTraitement eleveTraitement;

    @Query
    @Description("Say hello")
    public String sayHello(@DefaultValue("World") String name) {
        return "Hello " + name;
    }

    @Query
    public long globalListStudent() {
        
        return eleveTraitement.count();
    }

    @Mutation
    @Transactional
    public Eleve createHero( @Source Eleve eleve ) {
        Eleve eleveToSave =  eleveTraitement.createStudent( eleve );
        return eleveToSave;
    }

  /*   @Mutation
    public Eleve deleteHero(int id) {
        return null;
    } */
}