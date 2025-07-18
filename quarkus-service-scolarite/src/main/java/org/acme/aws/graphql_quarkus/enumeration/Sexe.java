package org.acme.aws.graphql_quarkus.enumeration;

import java.util.Objects;

public enum Sexe {
    MASCULIN("Masculin"),
    FEMININ("Féminin");
    
    private String libelle;
        Sexe(String libelle) {
            this.libelle = libelle;
            //TODO Auto-generated constructor stub
        }

        public String getLibelle() {
            return libelle;
        }

        public void setLibelle(String libelle) {
            this.libelle = libelle;
        }

        public static Sexe getSexe(String sexe) {
            if ( Objects.nonNull(sexe) && !sexe.isEmpty() && !sexe.isBlank() ) {
                if(sexe.equalsIgnoreCase("Masculin")) {
                    return Sexe.MASCULIN;
                } else {
                    return Sexe.FEMININ;
                }
                
            } else {
                return null;
            }
         
        }
}
