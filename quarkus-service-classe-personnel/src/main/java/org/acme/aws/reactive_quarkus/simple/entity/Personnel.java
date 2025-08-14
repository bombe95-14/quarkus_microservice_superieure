package org.acme.aws.reactive_quarkus.simple.entity;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Personnel extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "personnel_uuid", updatable = false, nullable = false)
    private UUID personnelUuid;
    
    private String nom;
    private String prenom;
    
    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "telephone", unique = true)
    private String telephone;
    
    @Column(name = "numero_cni", unique = true)
    private String numeroCni;
    
    @Column(name = "matricule", unique = true)
    private String matricule;

    private String adresse;
    private Date dateNaissance;
    private String dateEmbauche;
    private String schoolYearCode;

    @OneToMany(mappedBy = "personnel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Fonction> fonctions = new java.util.HashSet<>();

    public Personnel() {   } 
    // Constructors, getters, and setters can be added as needed

    public UUID getPersonnelUuid() {
        return personnelUuid;
    }

    public void setPersonnelUuid(UUID personnelUuid) {
        this.personnelUuid = personnelUuid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getSchoolYearCode() {
        return schoolYearCode;
    }

    public void setSchoolYearCode(String schoolYearCode) {
        this.schoolYearCode = schoolYearCode;
    }

    public Set<Fonction> getFonctions() {
        return fonctions;
    }

    public void setFonctions(Set<Fonction> fonctions) {
        this.fonctions = fonctions;
    }

    
}
