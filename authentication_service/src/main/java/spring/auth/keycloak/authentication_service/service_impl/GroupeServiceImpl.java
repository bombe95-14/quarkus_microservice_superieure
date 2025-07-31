package spring.auth.keycloak.authentication_service.service_impl;

import org.keycloak.admin.client.Keycloak;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import spring.auth.keycloak.authentication_service.service.GroupService;
import spring.auth.keycloak.authentication_service.service.UserService;


@Service
public class GroupeServiceImpl implements GroupService {

    @Value("${app.keycloak.realm}")
    private String realm;

    private final Keycloak keycloak;
    private final UserService userService; 

    public GroupeServiceImpl(Keycloak keycloak, UserService userService) {
        this.keycloak = keycloak;
        this.userService = userService;
    }

    @Override
    public void assignGroupToUser(String userId, String groupId) {
        userService.getUser(userId).joinGroup(groupId);
        // Implementation for assigning a role to a user

    }

    @Override
    public void deleteGroupFromUser(String userId, String groupId) {
        userService.getUser(userId).leaveGroup(groupId);
        // TODO Auto-generated method stub
    }


}
