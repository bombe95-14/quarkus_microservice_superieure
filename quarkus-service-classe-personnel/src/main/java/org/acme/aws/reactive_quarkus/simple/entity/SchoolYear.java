package org.acme.aws.reactive_quarkus.simple.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class SchoolYear { // extends PanacheEntityBase
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String codeAnneScolaire;
    public String getCodeAnneScolaire() {
        return codeAnneScolaire;
    }


    public void setCodeAnneScolaire(String codeAnneScolaire) {
        this.codeAnneScolaire = codeAnneScolaire;
    }


    public Date dateCreation;
    public Date getDateCreation() {
        return dateCreation;
    }


    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }


    public Date dateCloture;


    public Date getDateCloture() {
        return dateCloture;
    }


    public void setDateCloture(Date dateCloture) {
        this.dateCloture = dateCloture;
    }


  
}

