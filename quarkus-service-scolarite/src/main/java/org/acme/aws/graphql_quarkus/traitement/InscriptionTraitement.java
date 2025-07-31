package org.acme.aws.graphql_quarkus.traitement;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

import org.acme.aws.graphql_quarkus.body_request_and_body_response.InscriptionInput;
import org.acme.aws.graphql_quarkus.entity.Eleve;
import org.acme.aws.graphql_quarkus.entity.Inscription;
import org.acme.aws.graphql_quarkus.repository.EleveRepository;
import org.acme.aws.graphql_quarkus.repository.InscriptionRepository;

@ApplicationScoped
public class InscriptionTraitement {

    @Inject
    private InscriptionRepository inscriptionRepository;

    @Inject
    private EleveRepository eleveRepository;

    public List<Inscription> getRegistrationList() {
        return inscriptionRepository.listAll();
    }

    public Inscription createRegistrationStudent(InscriptionInput inscriptionInput) {
       
        Inscription inscription = new Inscription();    
        Optional<Eleve> eleveOptional = eleveRepository.findByIdOptional(inscriptionInput.getIdEleve());
        if (eleveOptional.isEmpty()) {
            throw new RuntimeException("Eleve non trouvé");
        }
        
        // Optional<Classe> classeOptional = classeRepository.findByIdOptional(inscriptionInput.getIdClasse());
        // if (classeOptional.isEmpty()) {
        //     throw new RuntimeException("Classe non trouvée");
        // }

        // Optional<SchoolYear> schoolYearOptional = schoolYearRepository.findByIdOptional(inscriptionInput.getIdSchoolYear());
        // if (schoolYearOptional.isEmpty()) {
        //     throw new RuntimeException("SchoolYear non trouvé");
        // }

        inscription.eleve = eleveOptional.get();
        inscription.codeClasse = inscriptionInput.getCodeClasse();
        inscription.schoolYearCode = inscriptionInput.getSchoolYearCode();
     
        //inscription.dateInscription = inscriptionInput.getDateInscription();
      

        inscriptionRepository.persist(inscription);
        return inscription;
    }

    public Eleve generateRegistrationNumberOfStudent( Long studentId ){
        return null;
    }

}
