package Repository.Interface;

import Model.Agent;

public interface IAgentRepositoryInterface {

    String create(Agent agent);
    String delete(String nom);
    void update(Agent agent, Agent updatedAgent);
    void findById();
    void findAll();
    Agent findByName(String nom);
}
