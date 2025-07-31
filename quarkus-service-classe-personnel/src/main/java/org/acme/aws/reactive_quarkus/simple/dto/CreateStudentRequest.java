package org.acme.aws.reactive_quarkus.simple.dto;

public record CreateStudentRequest(
     String username,
        String password,
        String email,
        String firstName,
        String lastName,
        String roleName
) {
    // This record can be used to define the structure of the request body for creating a student.
    // You can add fields as needed, for example:
    // private String name;
    // private String email;
    // private int age;

    // Add getters if necessary, or use Lombok annotations to generate them automatically.
}
