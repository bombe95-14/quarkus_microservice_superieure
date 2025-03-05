package org.acme.mongodb.panache.traitement;

import java.util.List;

import org.acme.mongodb.panache.dto.NoteInput;
import org.acme.mongodb.panache.entity.Note;
import org.acme.mongodb.panache.enumeration.TypeNote;
import org.acme.mongodb.panache.repository.NoteRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class NoteEleveTraitement {
    
    @Inject
    private NoteRepository noteRepository;

    public List<Note> getAllNotes(){
        return noteRepository.listAll();
    }

    public List<Note> getAllNotesOfStudents( String matriculeStudent ){
        return noteRepository.getAllNoteStudents( matriculeStudent );
    }

    public List<Note> getNotesByTypeAndSchoolYearAndMatiere( String typeNote, Long codeMatiere , Long codeSchoolYear ){
        return noteRepository.getNotesBySchoolYearAndTypeNote( codeSchoolYear, TypeNote.matchOneTypeNote( typeNote ), 
                codeMatiere );
    }

    public Note saveOneNote( NoteInput noteInput ){
        Note note = new Note();
        note.idMatiere = noteInput.idMatiere;
        note.matriculeStudent = noteInput.matriculeStudent;
        note.schoolYearCode = noteInput.schoolYearCode;
        note.typeNote = TypeNote.matchOneTypeNote( noteInput.typeNote );
  
        noteRepository.persist(note);
        return note;
    }

}
