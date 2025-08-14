package org.acme.aws.reactive_quarkus.simple.enums;

public enum FormationType {
    INITIALE("Initiale"),
//    CONTINUE,
    PROFESSIONNELLE("Professionnelle");

    private final String label;

    FormationType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }

    public static FormationType fromLabel(String label) {
        for (FormationType type : FormationType.values()) {
            if (type.label.equalsIgnoreCase(label)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No FormationType found for label: " + label);
    }

}
