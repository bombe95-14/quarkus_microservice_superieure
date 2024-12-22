package org.acme.aws.graphql_quarkus.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Date;
import org.acme.aws.graphql_quarkus.enumeration.Sexe;



@Entity
public class Eleve extends PanacheEntityBase {
    
    @Id @GeneratedValue 
    private Long id;
    
    private String nom;
    private String matricule;
    private String prenom;
    private Date birthday;
    private Sexe sexe;
    private String LieuNaissance;

}
