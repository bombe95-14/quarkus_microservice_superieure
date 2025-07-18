package org.acme.aws.graphql_quarkus.body_request_and_body_response;

import java.util.Date;

public class InscriptionInput {

    private Long idEleve;
    private Date dateInscription;
    private String codeClasse;
    
    private String schoolYearCode;

    public Date getDateInscription() {
        return dateInscription;
    }
    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Long getIdEleve() {
        return idEleve;
    }
    public void setIdEleve(Long idEleve) {
        this.idEleve = idEleve;
    }
    public String getCodeClasse() {
        return codeClasse;
    }
    public void setCodeClasse(String codeClasse) {
        this.codeClasse = codeClasse;
    }
    public String getSchoolYearCode() {
        return schoolYearCode;
    }
    public void setSchoolYearCode(String schoolYearCode) {
        this.schoolYearCode = schoolYearCode;
    }

    
    

}
