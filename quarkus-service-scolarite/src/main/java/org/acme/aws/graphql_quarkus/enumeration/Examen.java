
package org.acme.aws.graphql_quarkus.enumeration;


public enum Examen {
    PROBATOIRE("Probatoire"),
    CAP("Certificat d'Aptitude Professionnelle"),
    BEPC("Brevet d'Études Premier Cycle "),
    BAC("Baccalauréat"),
    LICENCE("Licence"),
    MASTER("Master"),
    DOCTORAT("Doctorat");

    private final String label;

    Examen(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}