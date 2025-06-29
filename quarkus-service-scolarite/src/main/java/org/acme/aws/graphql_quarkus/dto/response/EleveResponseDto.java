package org.acme.aws.graphql_quarkus.dto.response;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.acme.aws.graphql_quarkus.entity.Eleve;
import org.acme.aws.graphql_quarkus.enumeration.StatusEleve;


public class EleveResponseDto {
    
    public Long id;
    public String nom;
    public String matricule;

    public String numeroCni;

    public String dateDelivrance;
    public String prenom;
    public String birthday;
    public String sexe;
    public String lieuNaissance;
    public String password;


    
   // public String statusEleve;

    public EleveResponseDto(){
    }

    public EleveResponseDto(Long id, String nom, String matricule, String numeroCni, String dateDelivrance, String prenom, String birthday, String sexe, String lieuNaissance, String password, StatusEleve statusEleve) {
        this.id = id;
        this.nom = nom;
        this.matricule = matricule;
        this.numeroCni = numeroCni;
        this.dateDelivrance = dateDelivrance;
        this.prenom = prenom;
        this.birthday = birthday;
        this.sexe = sexe;
        this.lieuNaissance = lieuNaissance;
        this.password = password;
      //  this.statusEleve = statusEleve;
    }

    public EleveResponseDto( Eleve eleve ){
            id= eleve.id;
            nom= eleve.nom;
            matricule= eleve.matricule;
            numeroCni= eleve.numeroCni;
            dateDelivrance= simpleDateFormat.format(eleve.dateDelivrance==null ? new Date() : eleve.dateDelivrance);
            prenom= eleve.prenom;
            birthday= simpleDateFormat.format(eleve.birthday   ==null ? new Date() : eleve.birthday);
            sexe= eleve.sexe ==null ? "" : eleve.toString()  ;
            this.lieuNaissance= eleve.LieuNaissance;
            password= eleve.password;
           // statusEleve= eleve.statusEleve.toString();
            
    }

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh::mm::ss");

}
