package org.acme.mongodb.panache.repository;

import java.util.List;

import org.acme.mongodb.panache.entity.Note;
import org.acme.mongodb.panache.enumeration.TypeNote;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NoteRepository implements PanacheMongoRepository<Note> {
    
    public List<Note> getAllNoteStudents(String matricule){
       return find("matricule_eleve", matricule).list() ;
   }

   public List<Note> getNotesBySchoolYearAndTypeNote( Long codeSchoolYear, TypeNote typeNote, Long codeMatiere ){
    
    return find("{'categorie_note': :categorie_note, 'code_anne_scolaire': :code_anne_scolaire}",
         Parameters.with("categorie_note", typeNote).and("code_anne_scolaire", codeSchoolYear)).list();
         
   }

   
}
