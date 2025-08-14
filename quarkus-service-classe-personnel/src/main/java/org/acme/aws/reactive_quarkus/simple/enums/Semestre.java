package org.acme.aws.reactive_quarkus.simple.enums;

public enum Semestre {
    SEMESTRE_1("Semestre 1"),
    SEMESTRE_2("Semestre 2"),
    SEMESTRE_3("Semestre 3"),
    SEMESTRE_4("Semestre 4"),
    SEMESTRE_5("Semestre 5"),
    SEMESTRE_6("Semestre 6"),
    SEMESTRE_7("Semestre 7"),
    SEMESTRE_8("Semestre 8");
    
    private final String label;
    Semestre(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }

    public static Semestre fromLabel(String label) {
        for (Semestre semestre : Semestre.values()) {
            if (semestre.label.equalsIgnoreCase(label)) {
                return semestre;
            }
        }
        throw new IllegalArgumentException("No Semestre found for label: " + label);
    }

}

