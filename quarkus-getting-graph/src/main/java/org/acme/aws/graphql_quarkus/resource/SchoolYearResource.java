package org.acme.aws.graphql_quarkus.resource;


import org.acme.aws.graphql_quarkus.body_request_and_body_response.CreateSchoolYear;
import org.acme.aws.graphql_quarkus.body_request_and_body_response.EleveInput;
import org.acme.aws.graphql_quarkus.entity.Eleve;
import org.acme.aws.graphql_quarkus.entity.SchoolYear;
import org.acme.aws.graphql_quarkus.traitement.SchoolYearTraitement;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@GraphQLApi
public class SchoolYearResource {

    @Inject
    private SchoolYearTraitement schoolYearTraitement;

    @Mutation
    @Transactional
    public SchoolYear createSchoolYear( CreateSchoolYear createSchoolYear ) {
        SchoolYear schoolYearToSave =  schoolYearTraitement.createSchoolYear( createSchoolYear );
        return schoolYearToSave;
    }

}
