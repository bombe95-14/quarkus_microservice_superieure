package org.acme.aws.graphql_quarkus.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.acme.aws.graphql_quarkus.enumeration.Sexe;

import java.util.Date;

public class EleveDto {

    public Long id;

    public String nom;
    public String matricule;

    public String numeroCni;

    public Date dateDelivrance;
    public String prenom;
    public Date birthday;
    //private Sexe sexe;
    public String LieuNaissance;

}
