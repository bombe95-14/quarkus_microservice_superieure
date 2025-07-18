package authentication.service.controller;


import authentication.service.dto.request.CreateStudentRequest;
import authentication.service.service.UserService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @POST
    @Path("create")
    public Object createStudent( CreateStudentRequest createPersonnelRequestDto ){
        return userService.createStudent( createPersonnelRequestDto );
    }

}
