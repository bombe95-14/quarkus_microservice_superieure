package org.acme.aws.graphql_quarkus.traitement;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import org.acme.aws.graphql_quarkus.entity.Eleve;
import org.acme.aws.graphql_quarkus.repository.EleveRepository;




@ApplicationScoped
public class EleveTraitement {
    
@Inject
EleveRepository eleveRepository;

public long count(){
    
    return eleveRepository.count();
}

public List<Eleve> crearionStudent(){

    Eleve eleve = new Eleve();
        eleve.crearionStudent();
        return List.of( eleve );
        //        this.sexe = Sexe.FEMININ;
        
} 

public Eleve createStudent( Eleve eleve ){

    System.out.println(  "csss nsjg sdsds sdsd  \n " +  eleve.toString() );
    eleveRepository.persist(eleve);
    return eleve;
}

}
