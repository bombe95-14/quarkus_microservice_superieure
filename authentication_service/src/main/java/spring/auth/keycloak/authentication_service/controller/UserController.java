package spring.auth.keycloak.authentication_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.auth.keycloak.authentication_service.dto.request.CreateStudentRequestDto;
import spring.auth.keycloak.authentication_service.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody CreateStudentRequestDto createStudentRequestDto) {
        // Logic to create a user using the UserService
        userService.createStudent(createStudentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/send_verification_email/{userId}")
    public ResponseEntity<?>  getUserById( @PathVariable("userId") String userId) {
        userService.sendVerificationEmail(userId);
                return ResponseEntity.status(HttpStatus.OK).build();

        // Logic to get a user by ID using the UserService
        // UserResponseDto userResponse = userService.getUserById(id);
    }
    
    @PutMapping("/forgot_password/{username}")
    public ResponseEntity<?> updateUser(@PathVariable("username") String username ){
        // Logic to update a user using the UserService
        // userService.updateUser(userId, updateUserRequestDto);
        userService.forgotPassword(username);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    // @PostMapping("/create")
    // public ResponseEntity<?> createUser(@RequestBody CreateUserRequestDto request) {
    //     // Logic to create a user
    // }
    
    // @GetMapping("/{id}")
    // public ResponseEntity<UserResponseDto> getUserById(@PathVariable String id) {
    //     // Logic to get a user by ID
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UpdateUserRequestDto request) {
    //     // Logic to update a user
    // }

}
