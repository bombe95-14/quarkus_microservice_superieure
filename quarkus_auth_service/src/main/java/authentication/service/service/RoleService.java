package authentication.service.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.representations.idm.RoleRepresentation;

import java.util.Collections;

public class RoleService {

    private String realm;

    private final UserService userService;

    Keycloak keycloak;

    public RoleService(UserService userService) {
        this.userService = userService;
    }

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

    public void assignRoleToUser(String userId, String roleName) {
        RoleRepresentation roleRepresentation = getRolesResource().get(roleName).toRepresentation();
        userService.getUser(userId).roles().realmLevel().add( Collections.singletonList(roleRepresentation) );
        // TODO Auto-generated method stub
    }

    private RolesResource getRolesResource() {
        return keycloak.realm(realm).roles();
    }


    public void deleteRoleFromUser(String userId, String roleName) {
        RoleRepresentation roleRepresentation = getRolesResource().get(roleName).toRepresentation();
        userService.getUser(userId).roles().realmLevel().remove( Collections.singletonList(roleRepresentation) );
    }



}
