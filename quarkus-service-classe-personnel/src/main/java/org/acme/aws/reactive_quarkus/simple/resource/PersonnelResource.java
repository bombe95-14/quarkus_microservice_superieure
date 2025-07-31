package org.acme.aws.reactive_quarkus.simple.resource;

import java.util.List;

import org.acme.aws.reactive_quarkus.simple.dto.CreateStudentRequest;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/personnel")
public class PersonnelResource {


     @POST
     @Path("/create")
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

     @GET
    @Path("/roles")
    public List<RoleRepresentation> getRoles() {
        return keycloak.realm("manage_university").roles().list();
    }

    private UsersResource getUsersResource() {
        return keycloak.realm( "manage_university" ).users();
//        keycloak.realm("d")
    }

    public void forgotPassword(String username) {
    }

    public UserResource getUser(String userId) {
        // TODO Auto-generated method stub
        return getUsersResource().get(userId);
    }

    // public List<RoleRepresentation> getRolesUser(String userId) {
    // }

    // public List<GroupRepresentation> getGroupsUser(String userId) {
    // }

    public void deleteUser(String userId) {
        getUsersResource().delete(userId);
        // Implementation for deleting user
    }

     Keycloak keycloak;

     @PostConstruct
     public void initKeycloak() {

             keycloak = KeycloakBuilder.builder()
                .serverUrl("http://localhost:32768")
                .realm("manage_university")
                .clientId("taff-service")
                .grantType("client_credentials")
                .clientSecret("2jMHTl5iSTVFEtpUhHLTfgGHYDKAHQbD")
           //     .username("admin")
             //   .password("admin")
                .build();

     }

     @PreDestroy
     public void closeKeycloak() {
         keycloak.close();
     }

}
