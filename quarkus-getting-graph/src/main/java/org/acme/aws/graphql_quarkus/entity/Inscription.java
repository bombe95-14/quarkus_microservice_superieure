package org.acme.aws.graphql_quarkus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.acme.aws.graphql_quarkus.enumeration.Semestre;

@Entity
public class Inscription{  // extends PanacheEntityBase 
    
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     public Long id;

    @ManyToOne(targetEntity = Eleve.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "eleve_id")
    @JsonIgnore
    public Eleve eleve;

    @ManyToOne(targetEntity = SchoolYear.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "schoolYear_id")
    @JsonIgnore
    public SchoolYear schoolYear;

    public Semestre semestre;




    //private C classroom;

    public Inscription() {}
    public Inscription(Long id, Eleve eleve) {
        this.id = id;
        this.eleve = eleve;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }
}
