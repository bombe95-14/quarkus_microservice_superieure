package authentication.service.controller;


import authentication.service.dto.request.AuthenticationRequestDto;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/authenticate")
public class AuthenticationController {

    @POST
    public void authenticate(AuthenticationRequestDto authenticationRequestDto){

    }

}
