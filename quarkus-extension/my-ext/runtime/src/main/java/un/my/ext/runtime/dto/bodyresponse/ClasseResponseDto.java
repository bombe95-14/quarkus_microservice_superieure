package un.my.ext.runtime.dto.bodyresponse;

public class ClasseResponseDto {
    
    public String codeClasse;
   
        
    public Long id;
    public String classRoom;
    public String codeNiveau;
    public String parcoursType;
    public String codeFiliere;// code department
    public String codeNiveauScolaire;
  
    public String codeClasse() {
        return codeClasse;
    }
    public void codeClasse(String codeClasse) {
        this.codeClasse = codeClasse;
    }
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
}
