package org.acme.aws.graphql_quarkus.body_request_and_body_response;

import java.util.Date;

public class InscriptionInput {

    private Long idEleve;
    private Date dateInscription;
    private Long idClasse;
    public Long getIdClasse() {
        return idClasse;
    }
    public void setIdClasse(Long idClasse) {
        this.idClasse = idClasse;
    }
    private Long idSchoolYear;

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


    public Long getIdSchoolYear() {
        return idSchoolYear;
    }
    public void setIdSchoolYear(Long idSchoolYear) {
        this.idSchoolYear = idSchoolYear;
    }

}
