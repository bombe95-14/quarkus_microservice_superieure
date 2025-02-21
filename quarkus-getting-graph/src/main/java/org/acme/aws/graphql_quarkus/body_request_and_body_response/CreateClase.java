package org.acme.aws.graphql_quarkus.body_request_and_body_response;

import org.acme.aws.graphql_quarkus.enumeration.ParcoursType;

public class CreateClase {
    
    public Long id;
    public String department;
    public String nomClasse;
    public String filiere;
    public String codeClasse;
    public String parcoursType;


    public String getCodeClasse() {
        return codeClasse;
    }
    public void setCodeClasse(String codeClasse) {
        this.codeClasse = codeClasse;
    }
    
    public String getParcoursType() {
        return parcoursType;
    }
    public void setParcoursType(String parcoursType) {
        this.parcoursType = parcoursType;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNomClasse() {
        return nomClasse;
    }
    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }
    
    public String getFiliere() {
        return filiere;
    }
    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

}
