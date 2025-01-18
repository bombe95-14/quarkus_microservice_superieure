package org.acme.aws.graphql_quarkus.traitement;

import io.smallrye.mutiny.Multi;
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

public  List<Eleve>  getListEleve() {
    return eleveRepository.findAll().list();
}

public Eleve createStudent(Eleve eleve){
  eleveRepository.persist(eleve);
    return eleve;
}
}
