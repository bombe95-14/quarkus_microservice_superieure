package un.my.ext.runtime.dto.auth;

public class AuthenticationStudent {
    
    public String matriculeStudent;
   
    public String password;
 
    public String userName;
    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMatriculeStudent() {
        return matriculeStudent;
    }
    public void setMatriculeStudent(String matriculeStudent) {
        this.matriculeStudent = matriculeStudent;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
