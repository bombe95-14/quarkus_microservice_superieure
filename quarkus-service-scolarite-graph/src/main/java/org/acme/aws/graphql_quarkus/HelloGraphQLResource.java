package org.acme.aws.graphql_quarkus;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.aws.graphql_quarkus.entity.Eleve;
import org.acme.aws.graphql_quarkus.traitement.EleveTraitement;
import org.eclipse.microprofile.graphql.*;

import java.util.List;


@GraphQLApi
public class HelloGraphQLResource {

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

  /*   @Mutation
    public Eleve deleteHero(int id) {
        return null;
    } */
}