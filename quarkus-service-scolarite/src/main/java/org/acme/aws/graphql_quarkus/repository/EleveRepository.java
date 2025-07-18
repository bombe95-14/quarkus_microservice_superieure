package org.acme.aws.graphql_quarkus.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import org.acme.aws.graphql_quarkus.entity.Eleve;





@ApplicationScoped
@NamedQueries(value = {@NamedQuery(name = "EleveRepository.count",
        query = "SELECT count() FROM Eleve e where e.matricule like '?1%'  ")
}
)
public class EleveRepository implements PanacheRepository<Eleve> {
    
    public Eleve findByName(String name){
        return find("nom", name).firstResult();
    }

    public List<Eleve> findByNomAndPrenomAndDateNaissanceAndLieuNaissance(String nom, String prenom, String lieuNaissance, Date birthday){
        return find("nom = ?1 and prenom = ?2 and LieuNaissance = ?3 and birthday=?4 ", nom, prenom, lieuNaissance, birthday).stream().toList();
    }


    public Optional<Eleve> findByMatricule(String matricule){
        return list("matricule", matricule).stream().findFirst();
    }

    public Optional<Eleve> findByNumeroCni(String cniNumber){
        return list("numerocni", cniNumber).stream().findFirst();
    }

    public List<Eleve> listOrdonneStudent(){

        return list("order by nom, prenom");
        
    }

    public Optional<Eleve> findByEleveId( Long idEleve ){
        return findByIdOptional( idEleve );
    }

    public long countStudentValidateCurrentSchoolYear(String chaine) {
        return count("#EleveRepository.count", chaine);
    }
 
//     public void deleteStefs(){
//         delete("name", "Stef");
//    }


//Stream<Person> persons = personRepository.streamAll();
// List<Person> persons = Person.list(Sort.by("name").and("birth"));

//  List<Person> livingPersons = personRepository.list("status", Status.Alive);
//  personRepository.update("name = 'Mortal' where status = ?1", Status.Alive);


}
