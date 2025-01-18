package org.acme.aws.graphql_quarkus;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.aws.graphql_quarkus.entity.Eleve;
import org.acme.aws.graphql_quarkus.traitement.EleveTraitement;
import org.eclipse.microprofile.graphql.*;

import java.util.List;


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
    @Description("Say hello")
    public String listStudent(@DefaultValue("World") String name) {
        return "Hello " + name;
    }

    @Query
    public List<Eleve> globalListStudent() {
        
        return eleveTraitement.getListEleve();
    }

    @Mutation
    @Transactional
    public Eleve createHero( Eleve eleve ) {
        Eleve eleveToSave =  eleveTraitement.createStudent( eleve );
        return eleveToSave;
    }

  /*   @Mutation
    public Eleve deleteHero(int id) {
        return null;
    } */
}