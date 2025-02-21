package org.acme.aws.graphql_quarkus.enumeration;

public enum Semestre {

    SEMESTRE1("Semestre 1"), SEMESTRE2("Semestre 2"),
     SEMESTRE3("Semestre 3"), SEMESTRE4("Semestre 4"),
      SEMESTRE5("Semestre 5"), SEMESTRE6("Semestre 6"),
       SEMESTRE7("Semestre 7"), SEMESTRE8("Semestre 8"),
        SEMESTRE9("Semestre 9"), SEMESTRE10("Semestre 10");
        
        public String semestre;
                Semestre(String libelle) {
                    this.semestre = libelle;
                }

                public String getSemestre() {
                    return semestre;
                }

                public void setSemestre(String semestre) {
                    this.semestre = semestre;
                }

                public static Semestre fromString(String text) {
                    for (Semestre b : Semestre.values()) {
                        if (b.semestre.equalsIgnoreCase(text)) {
                            return b;
                        }
                    }
                    return null;
                }

}
