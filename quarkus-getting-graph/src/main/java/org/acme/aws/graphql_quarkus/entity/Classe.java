package org.acme.aws.graphql_quarkus.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.acme.aws.graphql_quarkus.enumeration.ParcoursType;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nomClasse;
    public String department;
    public String filiere;
    public String codeClasse;
    public ParcoursType parcoursType;

    

    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    public Set<Inscription> inscriptions = new HashSet<>();

    public ParcoursType getParcoursType() {
        return parcoursType;
    }

    public void setParcoursType(ParcoursType parcoursType) {
        this.parcoursType = parcoursType;
    }


    public String getCodeClasse() {
        return codeClasse;
    }

    public void setCodeClasse(String codeClasse) {
        this.codeClasse = codeClasse;
    }


    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
