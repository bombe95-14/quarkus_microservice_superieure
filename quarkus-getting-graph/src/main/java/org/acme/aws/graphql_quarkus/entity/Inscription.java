package org.acme.aws.graphql_quarkus.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;

@Entity
public class Inscription extends PanacheEntityBase {
    
    private Eleve eleve;
    private Classroom classroom;
    private SchoolYear schoolYear;

    

}
