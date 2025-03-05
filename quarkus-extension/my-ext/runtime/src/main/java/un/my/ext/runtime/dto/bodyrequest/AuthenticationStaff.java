package un.my.ext.runtime.dto.bodyrequest;

public class AuthenticationStaff {
    
    private String matricule;
 
    private String code;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
}
