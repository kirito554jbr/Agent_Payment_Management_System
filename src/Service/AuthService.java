package Service;

import Model.Agent;
import Repository.AgentRepository;
import Repository.Interface.IAgentRepositoryInterface;

public class AuthService {
    private IAgentRepositoryInterface agent;

    public AuthService(){
        this.agent = new AgentRepository();
    }

    public boolean logIn(String email, String password){
        Agent agent = this.agent.findByEmail(email);

        if(agent == null){
            System.out.println("Email not found");
            return false;
        }


        if(!agent.getMotDePasse().equals(password)){
            System.out.println("Password is false");
            return false;
        }

        return true;
    }
}
