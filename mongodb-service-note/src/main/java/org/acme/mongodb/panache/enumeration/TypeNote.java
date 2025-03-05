package org.acme.mongodb.panache.enumeration;

public enum TypeNote {
    
    CC("CC"),
    EXAM("EXAMEN"),
    TPE("TPE"),
    RATTRAPAGE("RATTRAPAGE");

    private String libelle;
   
    TypeNote( String libelle ){
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public static TypeNote matchOneTypeNote( String libelle ){

        for (TypeNote typeNote : TypeNote.values()) {
            if ( typeNote.getLibelle().equals( libelle ) ) {
                return typeNote;
            }
        }

        return null;

    }

}
