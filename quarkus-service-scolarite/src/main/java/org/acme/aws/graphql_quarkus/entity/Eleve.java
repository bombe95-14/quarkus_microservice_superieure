package org.acme.aws.graphql_quarkus.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.acme.aws.graphql_quarkus.enumeration.Sexe;
import org.acme.aws.graphql_quarkus.enumeration.StatusEleve;


@Entity
public class Eleve  { //
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nom;
    @Column( unique = true )
    public String matricule;

    @Column( unique = true )
    public String numeroCni;

    public Date dateDelivrance;
    public String prenom;
    public Date birthday;
    public Sexe sexe;
    public String LieuNaissance;
    public String password;
    public StatusEleve statusEleve;

    @OneToMany(mappedBy = "eleve", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Inscription> inscriptions = new HashSet<>();

    @OneToMany(mappedBy = "eleve", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<DiplomeEleve> diplomeEleves = new HashSet<>();

    public Eleve(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumeroCni() {
        return numeroCni;
    }

    public void setNumeroCni(String numeroCni) {
        this.numeroCni = numeroCni;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Date getDateDelivrance() {
        return dateDelivrance;
    }

    public void setDateDelivrance(Date dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getLieuNaissance() {
        return LieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        LieuNaissance = lieuNaissance;
    }

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    
}
