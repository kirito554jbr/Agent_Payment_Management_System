package Controller;

import Model.Agent;
import Service.AuthService;
import Service.Interfaces.IAuthService;

public class AuthController {

    private IAuthService authService;

    public AuthController(AuthService authService) {this.authService = authService;}

    public Agent LogIn(String email, String password){
       return this.authService.logIn(email,password);
    }
}
