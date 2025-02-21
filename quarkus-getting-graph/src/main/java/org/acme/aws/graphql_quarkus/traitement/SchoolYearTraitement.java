
package org.acme.aws.graphql_quarkus.traitement;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.acme.aws.graphql_quarkus.body_request_and_body_response.CreateSchoolYear;
import org.acme.aws.graphql_quarkus.entity.SchoolYear;
import org.acme.aws.graphql_quarkus.repository.SchoolYearRepository;

@ApplicationScoped
public class SchoolYearTraitement {

    @Inject
    private SchoolYearRepository schoolYearRepository;

    public SchoolYear createSchoolYear(CreateSchoolYear createSchoolYear){

        SchoolYear schoolYear = new SchoolYear();
        schoolYear.setCodeAnneScolaire(createSchoolYear.codeAnneScolaire);
        schoolYear.setDateCreation(createSchoolYear.dateCreation);
        schoolYear.setDateCloture(createSchoolYear.dateCloture);

        schoolYearRepository.persist(schoolYear);
        return schoolYear;
    }

}