package org.acme.aws.graphql_quarkus.traitement;

import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.core.Response;
//import un.my.ext.runtime.ExtProcessor;
//import un.my.ext.runtime.dto.bodyrequest.AuthenticationStudent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.acme.aws.graphql_quarkus.dto.request.EleveInput;
import org.acme.aws.graphql_quarkus.entity.Eleve;
import org.acme.aws.graphql_quarkus.enumeration.Sexe;
import org.acme.aws.graphql_quarkus.repository.EleveRepository;
import org.acme.aws.graphql_quarkus.repository.InscriptionRepository;


@ApplicationScoped
public class EleveTraitement {
    
@Inject
EleveRepository eleveRepository;

@Inject
InscriptionRepository inscriptionRepository;

    public long count(){
      //  extProcessors.processor();
        return eleveRepository.count();
    }

    public  List<Eleve>  getListEleve() {
        return eleveRepository.listOrdonneStudent();
    }

    public Eleve createStudent(EleveInput eleveInput){
    
        if ( Objects.isNull( eleveInput.getNom() ) || eleveInput.getNom().isEmpty()  || eleveInput.getNom().isBlank() || // Objects.isNull( eleveInput.getBirthday() ) ||
            Objects.isNull( eleveInput.getNumeroCni() ) || Objects.isNull( eleveInput.getSexe() ) || eleveInput.getNumeroCni().isBlank() || eleveInput.getNumeroCni().isEmpty() ){
                throw new BadRequestException("Champ obligatoire vide" );
        } 

        if ( eleveRepository.findByNumeroCni( eleveInput.getNumeroCni() ).isPresent() ) {
            throw new BadRequestException("Numero CNI déjà existant" );
        }

        if ( !eleveRepository.findByNomAndPrenomAndDateNaissanceAndLieuNaissance(eleveInput.getNom().trim(), eleveInput.getPrenom().trim(),
            eleveInput.getLieuNaissance(), eleveInput.getBirthday()).isEmpty() ) {
                throw new BadRequestException("Eleve déjà existant" );
        }

        Eleve eleve = new Eleve();
        eleve.nom = eleveInput.nom;
        eleve.prenom = eleveInput.prenom;
        eleve.birthday = eleveInput.birthday;
        eleve.sexe = Sexe.getSexe(eleveInput.sexe);
        eleve.numeroCni = eleveInput.numeroCni;
        eleve.dateDelivrance = eleveInput.dateDelivrance;
        eleve.LieuNaissance = eleveInput.LieuNaissance;
        eleve.password = eleveInput.password;
            

        eleveRepository.persist(eleve);
        return eleve;
    }

    public String generatedMatricule(){
        return "";
    }

    public Eleve informationsStudent( Long idEleve ){
        return new Eleve();
    }

    // public Eleve loginStudent( AuthenticationStudent authenticationStudent ){
    //     Optional<Eleve>  optionalEleve = eleveRepository.findByMatricule( authenticationStudent.getMatriculeStudent() );
    //     if ( optionalEleve.isPresent() ) {
            
    //     } else {
            
    //     }
    //     return new Eleve();
    // }
}
