package org.acme.mongodb.panache.entity;

import org.acme.mongodb.panache.enumeration.TypeNote;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.common.MongoEntity;


@MongoEntity
public class Note {

    public ObjectId id; // used by MongoDB for the _id field
    
    @BsonProperty("matricule_eleve")
    public String matriculeStudent;

    @BsonProperty("categorie_note")
    public TypeNote typeNote;

    public Long idMatiere;

    @BsonProperty("code_anne_scolaire")
    public Long schoolYearCode;

}
