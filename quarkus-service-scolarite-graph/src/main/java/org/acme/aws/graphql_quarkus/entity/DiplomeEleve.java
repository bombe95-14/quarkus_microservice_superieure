package org.acme.aws.graphql_quarkus.entity;

import org.acme.aws.graphql_quarkus.enumeration.Examen;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DiplomeEleve extends PanacheEntityBase  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String anneScolaire;
    private String etablissement;
    private Examen examen;
    private String mention;

}
