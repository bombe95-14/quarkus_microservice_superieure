package spring.auth.keycloak.authentication_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.auth.keycloak.authentication_service.service.RoleService;

@RestController
@RequestMapping
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PutMapping("/assign_role/{userId}/{roleName}")
    public ResponseEntity<?> assignRoleToUser(@PathVariable("userId") String userId, @PathVariable("roleName") String roleName) {
        // Logic to assign a role to a user using the RoleService
        roleService.assignRoleToUser(userId, roleName);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
