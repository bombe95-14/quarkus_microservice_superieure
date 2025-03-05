package un.my.ext.runtime.dto.bodyresponse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;




public class EleveResponseDto {
    
    public Long id;
    public String nom;
    public String matricule;

    public String numeroCni;

    public String dateDelivrance;
    public String prenom;
    public String birthday;
    public String sexe;
    public String lieuNaissance;
    public String password;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh::mm::ss");

    public List<InscriptionResponseDto> inscriptions;
   // public String statusEleve;

    public EleveResponseDto(){
    }

}
