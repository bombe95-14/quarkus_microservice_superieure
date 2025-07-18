package authentication.service.service;

import authentication.service.dto.request.CreateStudentRequest;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.Response;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;


@ApplicationScoped
public class UserService {


    public Response  createStudent(CreateStudentRequest createPersonnelRequestDto){

        UserRepresentation userRepresentation = new UserRepresentation();
        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();

        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
        credentialRepresentation.setValue(createPersonnelRequestDto.password());
        credentialRepresentation.setTemporary(false);
        userRepresentation.setCredentials(List.of(credentialRepresentation));

        userRepresentation.setUsername(createPersonnelRequestDto.username());
        userRepresentation.setFirstName(createPersonnelRequestDto.firstName());
        userRepresentation.setLastName(createPersonnelRequestDto.lastName());
        userRepresentation.setEmail(createPersonnelRequestDto.email());
        userRepresentation.setEmailVerified(false);
        userRepresentation.setEnabled(true);

        Response response = getUsersResource().create(userRepresentation);

        if (response.getStatus() != Response.Status.CREATED.getStatusCode()) {
            throw new RuntimeException("Failed to create user: " + response.getStatusInfo());
        } else {
            
            return response ;
        }

    }

    private UsersResource getUsersResource() {
        return keycloak.realm( "springbootkeycloak" ).users();
//        keycloak.realm("d")
    }

    public void forgotPassword(String username) {
        // TODO Auto-generated method stub
        List<UserRepresentation> userRepresentations = getUsersResource().searchByUsername(username, true);
        if ( !userRepresentations.isEmpty() ) {
            UserRepresentation user = userRepresentations.get(0);
            getUsersResource().get(user.getId()).executeActionsEmail(List.of("UPDATE_PASSWORD"));
            // Assuming you have a method to send a password reset email
            // sendPasswordResetEmail(user.getId());
            return;

        }
    }

    public UserResource getUser(String userId) {
        // TODO Auto-generated method stub
        return getUsersResource().get(userId);
    }

    public List<RoleRepresentation> getRolesUser(String userId) {
        return getUser(userId).roles().realmLevel().listAll();
        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'getRolesUser'");
    }

    public List<GroupRepresentation> getGroupsUser(String userId) {
        return getUser(userId).groups();
        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'getRolesUser'");
    }

    public void deleteUser(String userId) {
        getUsersResource().delete(userId);
        // Implementation for deleting user
    }

    Keycloak keycloak;

    @PostConstruct
    public void initKeycloak() {
        keycloak = KeycloakBuilder.builder()
                .serverUrl("http://localhost:9082")
                .realm("springbootkeycloak")
                .clientId("authentication_student")
                .grantType("CLIENT_CREDENTIALS".toLowerCase())
                .clientSecret("E03Jsr7flKzJC7VJ4ydiU4QyUJzPYGKL")
                .build();
    }

    @PreDestroy
    public void closeKeycloak() {
        keycloak.close();
    }

}
