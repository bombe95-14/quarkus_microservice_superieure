package org.acme.aws.graphql_quarkus.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Date;
import org.acme.aws.graphql_quarkus.enumeration.Sexe;




@Entity
public class Eleve    { //
    
    @Id
    @GeneratedValue
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

    public Eleve(){

    }

    public void crearionStudent(){

        this.prenom = "jhkkjsdf f";
        this.sexe = Sexe.FEMININ;
        
    } 
    
}
