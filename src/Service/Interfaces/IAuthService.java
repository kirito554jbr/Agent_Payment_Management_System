package Service.Interfaces;

import Model.Agent;

public interface IAuthService {
    Agent logIn(String email, String password);
}
