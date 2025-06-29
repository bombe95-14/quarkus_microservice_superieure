package un.my.ext.runtime.dto.scolarite.bodyrequest;

import java.util.Date;

public class EleveInput {
    
    public Long id;
    public String nom;
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String matricule;
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String numeroCni;

    public String getNumeroCni() {
        return numeroCni;
    }
    public void setNumeroCni(String numeroCni) {
        this.numeroCni = numeroCni;
    }

    public Date dateDelivrance;
    public Date getDateDelivrance() {
        return dateDelivrance;
    }
    public void setDateDelivrance(Date dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }

    public String prenom;
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date birthday;
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String sexe;
    public String getSexe() {
        return sexe;
    }
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String LieuNaissance;
    public String getLieuNaissance() {
        return LieuNaissance;
    }
    public void setLieuNaissance(String lieuNaissance) {
        LieuNaissance = lieuNaissance;
    }

    public String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}
