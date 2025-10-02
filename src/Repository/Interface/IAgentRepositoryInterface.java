package Repository.Interface;

import Model.Agent;

import java.util.List;

public interface IAgentRepositoryInterface {

    boolean create(Agent agent);
    boolean delete(String nom);
    boolean update(Agent agent, Agent updatedAgent);
    List<Agent> getAll();
    Agent getById(int id);
    Agent findByName(String nom);
    Agent findByEmail(String email);
}
