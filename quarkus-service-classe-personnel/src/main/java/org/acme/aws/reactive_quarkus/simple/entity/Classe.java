package org.acme.aws.reactive_quarkus.simple.entity;


import java.text.Format;
import java.util.Set;

import org.acme.aws.reactive_quarkus.simple.enums.FormationType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nomClasse;
    public String department;
    public String description;

    @Column( unique=true )
    public String codeClasse;

    @Enumerated(EnumType.STRING)
    private FormationType formationType;

    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<AssignmentTeachersInClassroom> assignmentTeachersClassrooms = new java.util.HashSet<>();


    public String getCodeClasse() {
        return codeClasse;
    }

    public void setCodeClasse(String codeClasse) {
        this.codeClasse = codeClasse;
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

