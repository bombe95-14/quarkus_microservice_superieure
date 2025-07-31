package spring.auth.keycloak.authentication_service.service;

public interface GroupService {

       void assignGroupToUser(String userId, String groupId);
    void deleteGroupFromUser(String userId, String groupId);

}
