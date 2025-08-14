package org.acme.aws.reactive_quarkus.simple.entity;

import java.util.Set;
import java.util.UUID;

import org.acme.aws.reactive_quarkus.simple.enums.Semestre;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Course {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "course_uuid", updatable = false, nullable = false)
    private UUID courseUuid;

    @Column(name = "course_code", unique = true)
    private String courseCode;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id" , nullable = true )
    private Classe classe;

   
}
