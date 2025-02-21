package org.acme.aws.graphql_quarkus.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.aws.graphql_quarkus.entity.Eleve;
import org.acme.aws.graphql_quarkus.entity.Inscription;
import org.acme.aws.graphql_quarkus.entity.SchoolYear;





@ApplicationScoped
public class InscriptionRepository implements PanacheRepository<Inscription>  {
    
//public List<Inscription> findByEleve(Eleve eleve){
  //      return list("eleve", eleve);
//}

/* public List<Inscription> findByClassRoom( Classroom classroom ){

    return list( "classroom", classroom );

} */


//public List<Inscription> findByEleveAndSchoolYear(Eleve eleve, SchoolYear schoolYear){
  //  return list("eleve = :eleve and schoolYear = :schoolYear", Parameters.with("eleve", eleve).and("schoolYear", schoolYear).map());
//}

}
