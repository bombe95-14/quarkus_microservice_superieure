package org.acme.aws.reactive_quarkus.simple.entity;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Personnel extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    public UUID id;
    
    public String nom;
    public String prenom;
    
    @Column(name = "email", unique = true)
    public String email;
    
    @Column(name = "telephone", unique = true)
    public String telephone;
    
    @Column(name = "numero_cni", unique = true)
    public String numeroCni;
    
    @Column(name = "matricule", unique = true)
    public String matricule;

    public String adresse;
    public Date dateNaissance;
    public String dateEmbauche;

    // Constructors, getters, and setters can be added as needed

}
