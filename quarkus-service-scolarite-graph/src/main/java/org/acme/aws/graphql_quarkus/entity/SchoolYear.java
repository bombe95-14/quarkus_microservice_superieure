package org.acme.aws.graphql_quarkus.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SchoolYear { // extends PanacheEntityBase
    
     @Id @GeneratedValue
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


    @OneToMany(mappedBy = "schoolYear", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    public Set<Inscription> inscriptions = new HashSet<>();

}
