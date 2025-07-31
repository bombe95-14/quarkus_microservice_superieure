package org.acme.mongodb.panache.ressource;

import java.util.List;

import org.acme.mongodb.panache.dto.NoteInput;
import org.acme.mongodb.panache.entity.Note;
import org.acme.mongodb.panache.repository.NoteRepository;
import org.acme.mongodb.panache.traitement.NoteEleveTraitement;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/note")
@Consumes("application/json")
@Produces("application/json")
public class NoteRessource {

    @Inject
    private NoteEleveTraitement noteEleveTraitement;
    

    @GET
    public List<Note> getAllNotes(){
        return noteEleveTraitement.getAllNotes();
    }


    @GET
    @Path("student/{matricule_eleve}")
    public List<Note> getAllNotesOfStudents( @PathParam(value = "matricule_eleve") String matricule_eleve ){
        return noteEleveTraitement.getAllNotesOfStudents( matricule_eleve );
    }

    @GET
    @Path("student/{codeSchoolYear}/{typeNote}/{codeMatiere}")
    public List<Note> getNotesByTypeAndSchoolYearAndMatiere( @PathParam(value = "typeNote") String typeNote,
            @PathParam(value = "codeMatiere") Long codeMatiere, @PathParam(value = "codeSchoolYear") Long codeSchoolYear ){
        return noteEleveTraitement.getNotesByTypeAndSchoolYearAndMatiere( typeNote, codeMatiere, codeSchoolYear );
    }

    @POST
    @Path("save/one")
    public Note saveOneNote( NoteInput noteInput ){
         return  noteEleveTraitement.saveOneNote(noteInput);
    }

    @POST
    @Path("save/morenote/frommatiere")
    public Note saveMoreNoteFromMatiere(  List<NoteInput> noteInputs ){
        return null;
    }

}
