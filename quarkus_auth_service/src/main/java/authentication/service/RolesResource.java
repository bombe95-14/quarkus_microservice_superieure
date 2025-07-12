package authentication.service;

import java.util.List;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.RoleRepresentation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;


@Path("/roles")
public class RolesResource {
    
    Keycloak keycloak;

        @PostConstruct
        public void initKeycloak() {
            keycloak = KeycloakBuilder.builder()
                .serverUrl("http://localhost:8081")
                .realm("master")
                .clientId("admin-cli")
                .grantType("password")
                .username("admin")
                .password("admin")
                .build();
        }

        @PreDestroy
        public void closeKeycloak() {
            keycloak.close();
        }

        @GET
        @Path("/roles")
        public List<RoleRepresentation> getRoles() {
            //keycloak.realm("null").users().lo
            return keycloak.realm("quarkus").roles().list();
        }

}
