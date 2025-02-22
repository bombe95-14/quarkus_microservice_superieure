package org.acme.aws.graphql_quarkus.enumeration;

public enum ParcoursType {
    
    INITIALE("Initiale"),
    PROFESSIONNEL("Professionnel");
    
    private String libelle;
        ParcoursType(String string) {
            this.libelle = string;
        }
        public String getLibelle() {
            return libelle;
        }

        public void setLibelle(String libelle) {
            this.libelle = libelle;
        }

        public static ParcoursType fromString(String text) {
            for (ParcoursType b : ParcoursType.values()) {
                if (b.libelle.equalsIgnoreCase(text)) {
                    return b;
                }
            }
            return null;
        }

}
