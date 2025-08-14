package org.acme.aws.reactive_quarkus.simple.entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class PriseService {

    // Define fields, constructors, getters, and setters as needed 
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "prise_service_uuid", updatable = false, nullable = false)
    private UUID priseServiceUuid;

    @OneToOne
    private Personnel personnel;

    @ManyToOne
    @JoinColumn(name = "school_year_id" , nullable = true )
    private SchoolYear schoolYear;

    public PriseService() {
    }

}
