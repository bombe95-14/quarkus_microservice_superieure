package spring.auth.keycloak.authentication_service.service;

import spring.auth.keycloak.authentication_service.dto.request.CreatePersonnelRequestDto;
import spring.auth.keycloak.authentication_service.dto.request.CreateStudentRequestDto;

public interface UserService {
    void createStaff( CreatePersonnelRequestDto createPersonnelRequestDto);
    void createStudent(  CreateStudentRequestDto createStudentRequestDto);
    void deleteUser(String username);
    void updateUser(String username, String newEmail);
    String getUser(String username);
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
}
