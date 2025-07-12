package spring.auth.keycloak.authentication_service.service;

public interface RoleService {

    void assignRoleToUser(String username, String roleName);
    void deleteRoleFromUser(String username, String roleName);

}
