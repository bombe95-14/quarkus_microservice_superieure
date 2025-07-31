package authentication.service.dto.request;



public record CreateStudentRequest(
        String username,
        String password,
        String email,
        String firstName,
        String lastName,
        String roleName
) {
    // This record can be used to encapsulate the data required to create a student.
    // It includes fields for username, password, email, first name, last name, and role name.

}
