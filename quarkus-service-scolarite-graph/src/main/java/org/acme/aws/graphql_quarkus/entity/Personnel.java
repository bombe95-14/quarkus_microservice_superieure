package org.acme.aws.graphql_quarkus.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Date;
import org.acme.aws.graphql_quarkus.enumeration.Sexe;




@Entity
public class Personnel extends PanacheEntityBase {
    
 @Id @GeneratedValue
 public Long id;

   public String nom;
   public String prenom;

    @Column( unique = true )
    public String matricule;

    @Column( unique = true )
    public String numeroCni;

   public Date dateDelivrance;

   public Date birthday;
   public Sexe sexe;
   public String LieuNaissance;


}
