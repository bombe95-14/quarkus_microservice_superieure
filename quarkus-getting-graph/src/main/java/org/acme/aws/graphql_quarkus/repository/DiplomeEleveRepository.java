package org.acme.aws.graphql_quarkus.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.aws.graphql_quarkus.entity.DiplomeEleve;
import org.acme.aws.graphql_quarkus.entity.Eleve;

@ApplicationScoped
public class DiplomeEleveRepository implements PanacheRepository<DiplomeEleve>  {
}
