package org.acme.aws.graphql_quarkus.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import org.acme.aws.graphql_quarkus.entity.Eleve;





@ApplicationScoped
public class EleveRepository implements PanacheRepository<Eleve> {
    
    public Eleve findByName(String name){
        return find("name", name).firstResult();
    }
 
    public List<Eleve> findByMatricule(String matricule){
        return list("matricule", matricule);
    }
 
//     public void deleteStefs(){
//         delete("name", "Stef");
//    }
//  List<Person> livingPersons = personRepository.list("status", Status.Alive);
//  personRepository.update("name = 'Mortal' where status = ?1", Status.Alive);


}
