package org.acme.aws.reactive_quarkus.dto.requestbody.from_graphql_service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Eleve {
        
    public Long id;
       public String nom;
       public String matricule;
       public String numeroCni;
       public Date dateDelivrance;
       public String prenom;
       public Date birthday;
       public String sexe;
       public String LieuNaissance;
       public String password;

     //  public Set<Inscription> inscriptions = new HashSet<>();

       public String getNom() {
           return nom;
       }
       public void setNom(String nom) {
           this.nom = nom;
       }
       
       public String getMatricule() {
           return matricule;
       }
       public void setMatricule(String matricule) {
           this.matricule = matricule;
       }
   
   
       public String getNumeroCni() {
           return numeroCni;
       }
       public void setNumeroCni(String numeroCni) {
           this.numeroCni = numeroCni;
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
   
       public String getSexe() {
           return sexe;
       }
       public void setSexe(String sexe) {
           this.sexe = sexe;
       }
   
       public String getLieuNaissance() {
           return LieuNaissance;
       }
       public void setLieuNaissance(String lieuNaissance) {
           LieuNaissance = lieuNaissance;
       }
   
       public String getPassword() {
           return password;
       }
       public void setPassword(String password) {
           this.password = password;
       }
   

}
