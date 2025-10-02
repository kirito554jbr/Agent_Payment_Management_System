package Service;

import Model.Agent;
import Repository.AgentRepository;
import Repository.Interface.IAgentRepositoryInterface;
import Service.Interfaces.IAuthService;

public class AuthService implements IAuthService {
    private IAgentRepositoryInterface agentRepository;

    public AuthService(AgentRepository agentRepository){
        this.agentRepository = agentRepository;
    }

    @Override
    public Agent logIn(String email, String password){
        Agent agent = this.agentRepository.findByEmail(email);

        if(agent == null){
            System.out.println("Email not found");
            return null;
        }


        if(!agent.getMotDePasse().equals(password)){
            System.out.println("Password is false");
            return null;
        }

        return agent;
    }
}
