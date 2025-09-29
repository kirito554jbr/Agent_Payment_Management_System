package Repository.Interface;

import Model.Agent;

public interface IAgentRepositoryInterface {

    boolean create(Agent agent);
    boolean delete(String nom);
    boolean update(Agent agent, Agent updatedAgent);
//    void findById();
    Agent findByName(String nom);
    Agent findByEmail(String email);
}
