package authentication.service;

import java.util.List;

import authentication.service.dto.request.CreateStudentRequest;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.Response;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.keycloak.representations.idm.UserRepresentation;


@Path("/roles")
public class RolesResource {
    
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

        @GET
        @Path("/roles")
        public List<RoleRepresentation> getRoles() {
//            () -> keycloak.realm("null").users()
            keycloak.realm("null").
            return keycloak.realm("springbootkeycloak").roles().list();
        }

        @POST
        public void  createStudent(CreateStudentRequest createPersonnelRequestDto){

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
            }

        }

    private UsersResource getUsersResource() {


            return keycloak.realm( "springbootkeycloak" ).users();
               }



}
