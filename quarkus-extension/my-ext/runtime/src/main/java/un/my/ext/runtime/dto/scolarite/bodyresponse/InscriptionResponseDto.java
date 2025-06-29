package un.my.ext.runtime.dto.scolarite.bodyresponse;

public class InscriptionResponseDto {
    
    public Long id;
    public String classRoom;
    public String codeAnneAcademique;
    public String codeClasse;
    public String matriculeEleve;
    public String codeNiveau;
    public String parcoursType;
    public String dateInscription;
    public String codeFiliere;// code department
    public String codeNiveauScolaire;

    public Long id() {
        return id;
    }
    public void id(Long id) {
        this.id = id;
    }
    public String classRoom() {
        return classRoom;
    }
    public void classRoom(String classRoom) {
        this.classRoom = classRoom;
    }
    public String codeAnneAcademique() {
        return codeAnneAcademique;
    }
    public void codeAnneAcademique(String codeAnneAcademique) {
        this.codeAnneAcademique = codeAnneAcademique;
    }
    public String codeClasse() {
        return codeClasse;
    }
    public void codeClasse(String codeClasse) {
        this.codeClasse = codeClasse;
    }
    public String matriculeEleve() {
        return matriculeEleve;
    }
    public void matriculeEleve(String matriculeEleve) {
        this.matriculeEleve = matriculeEleve;
    }
    public String codeNiveau() {
        return codeNiveau;
    }
    public void codeNiveau(String codeNiveau) {
        this.codeNiveau = codeNiveau;
    }
    public String parcoursType() {
        return parcoursType;
    }
    public void parcoursType(String parcoursType) {
        this.parcoursType = parcoursType;
    }
    public String dateInscription() {
        return dateInscription;
    }
    public void dateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }
    public String codeFiliere() {
        return codeFiliere;
    }
    public void codeFiliere(String codeFiliere) {
        this.codeFiliere = codeFiliere;
    }
    public String codeNiveauScolaire() {
        return codeNiveauScolaire;
    }   

}
