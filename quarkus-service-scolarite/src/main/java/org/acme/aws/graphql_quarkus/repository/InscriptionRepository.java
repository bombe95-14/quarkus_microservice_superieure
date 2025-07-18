package org.acme.aws.graphql_quarkus.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.aws.graphql_quarkus.entity.Eleve;
import org.acme.aws.graphql_quarkus.entity.Inscription;





@ApplicationScoped
public class InscriptionRepository implements PanacheRepository<Inscription>  {
    
public List<Inscription> findByEleve(Eleve eleve){
       return list("eleve", eleve);
}

//     find("nom = ?1 and prenom = ?2 and LieuNaissance = ?3 and birthday=?4 ", nom, prenom, lieuNaissance, birthday).stream().toList();

public List<Inscription> findByEleveAndSchoolYear(Eleve eleve, String schoolYearCode){
        
       return list("eleve = ?1 and schoolYearCode = ?2", eleve, schoolYearCode);
}


public List<Inscription> findByClassRoomAndSchoolYear( String codeClasse, String schoolYearCode ){

    return find( "schoolYearCode=?1 and codeClasse=?2", schoolYearCode, codeClasse ).list();

} 


//public List<Inscription> findByEleveAndSchoolYear(Eleve eleve, SchoolYear schoolYear){
  //  return list("eleve = :eleve and schoolYear = :schoolYear", Parameters.with("eleve", eleve).and("schoolYear", schoolYear).map());
//}

}
