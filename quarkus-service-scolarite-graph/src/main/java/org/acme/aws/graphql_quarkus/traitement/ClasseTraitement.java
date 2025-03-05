package org.acme.aws.graphql_quarkus.traitement;

import java.util.List;

import org.acme.aws.graphql_quarkus.body_request_and_body_response.CreateClase;
import org.acme.aws.graphql_quarkus.entity.Classe;
import org.acme.aws.graphql_quarkus.enumeration.ParcoursType;
import org.acme.aws.graphql_quarkus.repository.ClasseRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import un.my.ext.runtime.dto.bodyrequest.AuthenticationStaff;

@ApplicationScoped
public class ClasseTraitement {

  @Inject
  private ClasseRepository classeRepository;

  public Classe createClasse( CreateClase createClase){
        
        Classe classe = new Classe();
        classe.setNomClasse(createClase.nomClasse);
        classe.setCodeClasse(createClase.codeClasse);
        classe.setFiliere(createClase.filiere);
        classe.setDepartment(createClase.department);
        classe.setParcoursType(ParcoursType.fromString(createClase.parcoursType));

      /*   classe.setNomClasse(createClase.nomClasse);
        classe.setNiveau(createClase.niveau);
        classe.setSerie(createClase.serie);
        classe.setSpecialite(createClase.specialite);
        classe.setEffectif(createClase.effectif);
        classe.setMontantScolarite(createClase.montantScolarite);
        classe.setMontantInscription(createClase.montantInscription);
        classe.setMontantMensuel(createClase.montantMensuel);
        classe.setMontantTrimestriel(createClase.montantTrimestriel);
        classe.setMontantAnnuel(createClase.montantAnnuel);
        classe.setMontantExamen(createClase.montantExamen);
        classe.setMontantUniforme(createClase.montantUniforme);
        classe.setMontantTransport(createClase.montantTransport);
        classe.setMontantRestauration(createClase.montantRestauration);
        classe.setMontantInternat(createClase.montantInternat);
        classe.setMontantDivers(createClase.montantDivers);
        classe.setMontantFourniture(createClase.montantFourniture);
        classe.setMontantSoutienScolaire(createClase.montantSoutienScolaire);
        classe.setMontantCantine(createClase.montantCantine);
        classe.setMontantGarderie(createClase.montantGarderie);
        classe.setMontantEtudeDirige(createClase.montantEtudeDirige);    */

        AuthenticationStaff authenticationStaff = new AuthenticationStaff();
        classeRepository.persist(classe);
        return classe;
        
    }

    public void updateClasse(){
        
    }

    public void deleteClasse(){
        
    }

    public void getClasse(){
        
    }

    public List<Classe> getAllClasse(){
            return classeRepository.listAll();
        
    }

}
