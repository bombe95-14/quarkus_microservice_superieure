package org.acme.aws.graphql_quarkus.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SchoolYear { // extends PanacheEntityBase
    
     @Id @GeneratedValue
     public Long id;

    public String codeAnneScolaire;

}
