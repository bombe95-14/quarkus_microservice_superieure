package org.acme.aws.graphql_quarkus.traitement;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

import org.acme.aws.graphql_quarkus.body_request_and_body_response.InscriptionInput;
import org.acme.aws.graphql_quarkus.entity.Classe;
import org.acme.aws.graphql_quarkus.entity.Eleve;
import org.acme.aws.graphql_quarkus.entity.Inscription;
import org.acme.aws.graphql_quarkus.entity.SchoolYear;
import org.acme.aws.graphql_quarkus.repository.ClasseRepository;
import org.acme.aws.graphql_quarkus.repository.EleveRepository;
import org.acme.aws.graphql_quarkus.repository.InscriptionRepository;
import org.acme.aws.graphql_quarkus.repository.SchoolYearRepository;

@ApplicationScoped
public class InscriptionTraitement {

    @Inject
    private InscriptionRepository inscriptionRepository;

    @Inject
    private EleveRepository eleveRepository;

    @Inject
    private ClasseRepository classeRepository;

    @Inject
    private SchoolYearRepository schoolYearRepository;

    public List<Inscription> getRegistrationList() {
        return inscriptionRepository.listAll();
    }

    public Inscription createRegistrationStudent(InscriptionInput inscriptionInput) {
       
        Inscription inscription = new Inscription();    
        Optional<Eleve> eleveOptional = eleveRepository.findByIdOptional(inscriptionInput.getIdEleve());
        if (eleveOptional.isEmpty()) {
            throw new RuntimeException("Eleve non trouvé");
        }
        
        Optional<Classe> classeOptional = classeRepository.findByIdOptional(inscriptionInput.getIdClasse());
        if (classeOptional.isEmpty()) {
            throw new RuntimeException("Classe non trouvée");
        }

        Optional<SchoolYear> schoolYearOptional = schoolYearRepository.findByIdOptional(inscriptionInput.getIdSchoolYear());
        if (schoolYearOptional.isEmpty()) {
            throw new RuntimeException("SchoolYear non trouvé");
        }

        inscription.eleve = eleveOptional.get();
        inscription.classe = classeOptional.get();
        inscription.schoolYear = schoolYearOptional.get();
        inscription.dateInscription = inscriptionInput.getDateInscription();
        // inscription.dateInscription = inscriptionInput.dateInscription;
        // inscription.montantInscription = inscriptionInput.montantInscription;
        // inscription.montantScolarite = inscriptionInput.montantScolarite;
        // inscription.montantTransport = inscriptionInput.montantTransport;
        // inscription.montantRestauration = inscriptionInput.montantRestauration;
        // inscription.montantInternat = inscriptionInput.montantInternat;
        // inscription.montantDivers = inscriptionInput.montantDivers;
        // inscription.montantFourniture = inscriptionInput.montantFourniture;
        // inscription.montantSoutienScolaire = inscriptionInput.montantSoutienScolaire
        // inscription.montantCantine = inscriptionInput.montantCantine;
        // inscription.montantGarderie = inscriptionInput.montantGarderie;
        // inscription.montantEtudeDirige = inscriptionInput.montantEtudeDirige;   

        inscriptionRepository.persist(inscription);
        return inscription;
    }

}
