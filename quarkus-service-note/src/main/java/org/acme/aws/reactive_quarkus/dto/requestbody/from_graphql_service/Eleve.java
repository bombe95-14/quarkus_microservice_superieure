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
    public String birthday;
    public String dateDelivrance;


    public String prenom;
    public String sexe;
    public String lieuNaissance;
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
   
       public String getBirthday() {
            return birthday;
        }
        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getDateDelivrance() {
           return dateDelivrance;
       }
       public void setDateDelivrance(String dateDelivrance) {
           this.dateDelivrance = dateDelivrance;
       } 
   
       public String getPrenom() {
           return prenom;
       }
       public void setPrenom(String prenom) {
           this.prenom = prenom;
       }
   
   
       public String getSexe() {
           return sexe;
       }
       public void setSexe(String sexe) {
           this.sexe = sexe;
       }
   
       public String getLieuNaissance() {
           return lieuNaissance;
       }
       public void setLieuNaissance(String lieuNaissance) {
           this.lieuNaissance = lieuNaissance;
       }
   
       public String getPassword() {
           return password;
       }
       public void setPassword(String password) {
           this.password = password;
       }
   

      
    
}
