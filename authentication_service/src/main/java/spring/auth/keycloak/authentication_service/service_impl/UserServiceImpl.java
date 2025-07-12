package spring.auth.keycloak.authentication_service.service_impl;

import java.util.List;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.ws.rs.core.Response;
import spring.auth.keycloak.authentication_service.dto.request.CreatePersonnelRequestDto;
import spring.auth.keycloak.authentication_service.dto.request.CreateStudentRequestDto;
import spring.auth.keycloak.authentication_service.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Value("${app.keycloak.realm}")
    private String realm;

    private final Keycloak keycloak;

    public UserServiceImpl(Keycloak keycloak) {
        this.keycloak = keycloak;
    }

    @Override
    public void createStaff(CreatePersonnelRequestDto createPersonnelRequestDto) {

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
        // Here you would typically use the Keycloak client to create the user in Keycloak
        // keycloak.realm(realm).users().create(userRepresentation);
        // Note: Ensure to handle exceptions and check for existing users before creating
        
        // Implementation for creating staff
    }

    private UsersResource getUsersResource() {
        return keycloak.realm( realm ).users();
    }

    @Override
    public void createStudent(CreateStudentRequestDto createStudentRequestDto) {
        // Implementation for creating student
    }

    @Override
    public void deleteUser(String userId) {
        getUsersResource().delete(userId);
        // Implementation for deleting user
    }

    @Override
    public void updateUser(String username, String newEmail) {
        // Implementation for updating user email
    }

    @Override
    public boolean userExists(String username) {
        // Implementation to check if user exists
        return false;
    }

    @Override
    public void changeUserPassword(String username, String newPassword) {
        // Implementation for changing user password
    }

    @Override
    public String getUserEmail(String username) {
        // Implementation for getting user email
        return null;
    }

    @Override
    public void setUserEmail(String username, String email) {
        // Implementation for setting user email
    }

    @Override
    public void assignRoleToUser(String username, String roleName) {
        // Implementation for assigning role to user
    }

    @Override
    public void removeRoleFromUser(String username, String roleName) {
        // Implementation for removing role from user
    }

    @Override
    public String getUserRole(String username) {
        // Implementation for getting user role
        return null;
    }

    @Override
    public void enableUser(String username) {
        // Implementation for enabling user account
    }

    @Override
    public void disableUser(String username) {
        // Implementation for disabling user account
    }

    @Override
    public void resetUserPassword(String username, String newPassword) {
        // Implementation for resetting user password
    }

    @Override
    public void updateUserDetails(String username, String newEmail, String newPassword) {
        // Implementation for updating user details
    }

    @Override
    public void logoutUser(String username) {
        // Implementation for logging out user
    }

    @Override
    public void refreshUserToken(String username) {
        // Implementation for refreshing user token
    }

    @Override
    public void clearUserSessions(String username) {
    }

    @Override
    public void validateUserCredentials(String username, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateUserCredentials'");
    }

    @Override
    public void sendVerificationEmail(String userId) {
        getUsersResource().get(userId).sendVerifyEmail();
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendVerificationEmail'");
    }

    @Override
    public void sendPasswordResetEmail(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendPasswordResetEmail'");
    }

    @Override
    public void setUserAttributes(String username, String attributes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setUserAttributes'");
    }

    @Override
    public String getUserAttributes(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserAttributes'");
    }

    @Override
    public void linkUserToExternalIdentity(String username, String externalId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'linkUserToExternalIdentity'");
    }

    @Override
    public void unlinkUserFromExternalIdentity(String username, String externalId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unlinkUserFromExternalIdentity'");
    }

    @Override
    public void forgotPassword(String username) {
        // TODO Auto-generated method stub
        List<UserRepresentation> userRepresentations = getUsersResource().searchByUsername(username, true);
        if ( !userRepresentations.isEmpty() ) {
            UserRepresentation user = userRepresentations.get(0);
            getUsersResource().get(user.getId()).executeActionsEmail(List.of("UPDATE_PASSWORD"));
            // Assuming you have a method to send a password reset email
            // sendPasswordResetEmail(user.getId());
            return;
            
        }
    }

    @Override
    public UserResource getUser(String userId) {
        // TODO Auto-generated method stub
        return getUsersResource().get(userId);
    }

    @Override
    public List<RoleRepresentation> getRolesUser(String userId) {
        return getUser(userId).roles().realmLevel().listAll();
        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'getRolesUser'");
    }

    public List<GroupRepresentation> getGroupsUser(String userId) {
        return getUser(userId).groups();
        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'getRolesUser'");
    }

  
}
