package org.acme.aws.graphql_quarkus.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.aws.graphql_quarkus.entity.Eleve;
import org.acme.aws.graphql_quarkus.entity.SchoolYear;

@ApplicationScoped
public class SchoolYearRepository implements PanacheRepository<SchoolYear> {
    
}
