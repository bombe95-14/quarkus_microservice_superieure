package spring.auth.keycloak.authentication_service.service;

import java.util.List;

import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.RoleRepresentation;

import spring.auth.keycloak.authentication_service.dto.request.CreatePersonnelRequestDto;
import spring.auth.keycloak.authentication_service.dto.request.CreateStudentRequestDto;

public interface UserService {
    void createStaff( CreatePersonnelRequestDto createPersonnelRequestDto);
    void createStudent(  CreateStudentRequestDto createStudentRequestDto);
    void deleteUser(String username);
    void updateUser(String username, String newEmail);
    boolean userExists(String username);
    void changeUserPassword(String username, String newPassword);
    String getUserEmail(String username);
    void setUserEmail(String username, String email);
    void assignRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    String getUserRole(String username);
    void enableUser(String username);
    void disableUser(String username);
    void resetUserPassword(String username, String newPassword);
    void updateUserDetails(String username, String newEmail, String newPassword);
    void logoutUser(String username);
    void refreshUserToken(String username);
    void clearUserSessions(String username);
    void validateUserCredentials(String username, String password);
    void sendVerificationEmail(String username);
    void sendPasswordResetEmail(String username);
    void setUserAttributes(String username, String attributes);
    String getUserAttributes(String username);
    void linkUserToExternalIdentity(String username, String externalId);
    void unlinkUserFromExternalIdentity(String username, String externalId);
    void forgotPassword(String username);
    UserResource getUser(String userId);
    List<RoleRepresentation> getRolesUser(String userId);
}
