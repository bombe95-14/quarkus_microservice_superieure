package org.acme.aws.graphql_quarkus.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DiplomeEleve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

}
