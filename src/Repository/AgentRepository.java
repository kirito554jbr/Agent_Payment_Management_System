package Repository;

import DAO.AgentDao;
import Repository.Interface.IAgentRepositoryInterface;

public class AgentRepository implements IAgentRepositoryInterface {

    private AgentDao agentDao;

    public AgentRepository() {
        agentDao = new AgentDao();
    }

    public void create(int departemenet, int role, String nom, String prenom, String email, String password){
        this.agentDao.create(departemenet, role, nom, prenom, email, password);
    }


    public void delete(){}
    public void update(){}
    public void findById(){}
    public void findAll(){}
    public void findByName(){}

}
