package Repository.Interface;

import Model.Agent;

public interface IAgentRepositoryInterface {

    String create(int departemenet, int role, String nom, String prenom, String email, String password );
    String delete(String nom);
    void update();
    void findById();
    void findAll();
    Agent findByName(String nom);
}
