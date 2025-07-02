package org.acme.aws.reactive_quarkus.simple.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Fonction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String nameFr;
    private String nameEn;

    //@ManyToOne
    @ManyToOne(targetEntity = Personnel.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "personnel_uuid")
    @JsonIgnore
    public Personnel personnel;

    public Fonction() {
    }

    public Fonction(Long id, String nameFr, String nameEn) {
        this.id = id;
        this.nameFr = nameFr;
        this.nameEn = nameEn;
    }

}
