package spring.auth.keycloak.authentication_service.dto.request;

public record CreatePersonnelRequestDto( 
    String username,
    String password,
    String email,
    String firstName,
    String lastName,
    String roleName
 ) {

}
