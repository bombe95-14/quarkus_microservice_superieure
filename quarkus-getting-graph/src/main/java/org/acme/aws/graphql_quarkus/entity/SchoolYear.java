package org.acme.aws.graphql_quarkus.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class SchoolYear { // extends PanacheEntityBase
    
     @Id @GeneratedValue
     public Long id;

    public String codeAnneScolaire;

    @OneToMany(mappedBy = "schoolYear", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Inscription> inscriptions = new HashSet<>();

}
