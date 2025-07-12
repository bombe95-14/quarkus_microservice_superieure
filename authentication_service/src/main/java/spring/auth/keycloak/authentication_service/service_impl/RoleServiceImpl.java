package spring.auth.keycloak.authentication_service.service_impl;

import java.util.Collections;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import spring.auth.keycloak.authentication_service.service.RoleService;
import spring.auth.keycloak.authentication_service.service.UserService;


@Service
public class RoleServiceImpl implements RoleService {

     @Value("${app.keycloak.realm}")
    private String realm;

    private final Keycloak keycloak;
    private final UserService userService; 

    public RoleServiceImpl(Keycloak keycloak, UserService userService) {
        this.keycloak = keycloak;
        this.userService = userService;
    }

   
    public void createRole(String roleName) {
        // Logic to create a role in Keycloak or your authentication service
    }

    // Example method to delete a role
    public void deleteRole(String roleName) {
        // Logic to delete a role in Keycloak or your authentication service
    }

    @Override
    public void assignRoleToUser(String userId, String roleName) {
        RoleRepresentation roleRepresentation = getRolesResource().get(roleName).toRepresentation();
        userService.getUser(userId).roles().realmLevel().add( Collections.singletonList(roleRepresentation) );
        // TODO Auto-generated method stub
    }

    private RolesResource getRolesResource() {
        return keycloak.realm(realm).roles();
    }


    @Override
    public void deleteRoleFromUser(String userId, String roleName) {
        RoleRepresentation roleRepresentation = getRolesResource().get(roleName).toRepresentation();
        userService.getUser(userId).roles().realmLevel().remove( Collections.singletonList(roleRepresentation) );
    }

}
