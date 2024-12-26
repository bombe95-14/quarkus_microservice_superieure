package org.acme.aws.graphql_quarkus.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;
import org.acme.aws.graphql_quarkus.entity.Eleve;
import org.acme.aws.graphql_quarkus.entity.Inscription;




public class InscriptionRepository implements PanacheRepository<Inscription>  {
    
  public List<Inscription> findByEleve(Eleve eleve){
        return list("eleve", eleve);
    }

}
