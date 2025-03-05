package org.acme.mongodb.panache.dto;

import org.acme.mongodb.panache.enumeration.TypeNote;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class NoteInput {
    
public String id; // used by MongoDB for the _id field
    
    public String matriculeStudent;

    public String typeNote;

    public Long idMatiere;

    public Long schoolYearCode;

}
