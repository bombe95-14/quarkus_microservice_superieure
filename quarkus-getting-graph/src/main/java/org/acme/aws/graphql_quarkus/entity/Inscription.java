package org.acme.aws.graphql_quarkus.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Inscription{  // extends PanacheEntityBase 
    
     @Id @GeneratedValue 
    private Long id;
    /* private Eleve eleve;
    private Classroom classroom;
    private SchoolYear schoolYear; */

    

}
