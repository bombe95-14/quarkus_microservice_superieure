package org.acme.aws.reactive_quarkus.simple.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fonction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String nameFr;
    private String nameEn;

    public Fonction() {
    }

    public Fonction(Long id, String nameFr, String nameEn) {
        this.id = id;
        this.nameFr = nameFr;
        this.nameEn = nameEn;
    }

}
